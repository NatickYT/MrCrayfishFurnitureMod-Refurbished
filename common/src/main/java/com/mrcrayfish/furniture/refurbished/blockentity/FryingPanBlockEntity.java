package com.mrcrayfish.furniture.refurbished.blockentity;

import com.mrcrayfish.furniture.refurbished.core.ModBlockEntities;
import com.mrcrayfish.furniture.refurbished.core.ModRecipeTypes;
import com.mrcrayfish.furniture.refurbished.network.Network;
import com.mrcrayfish.furniture.refurbished.network.message.MessageFlipAnimation;
import com.mrcrayfish.furniture.refurbished.util.BlockEntityHelper;
import com.mrcrayfish.furniture.refurbished.util.Utils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerChunkCache;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HoneyBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.joml.Vector3f;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Author: MrCrayfish
 */
public class FryingPanBlockEntity extends BasicLootBlockEntity implements ICookingBlock
{
    public static final Vector3f OIL_COLOUR = Vec3.fromRGB24(0xE1A803).toVector3f();

    protected final RecipeManager.CachedCheck<Container, ? extends AbstractCookingRecipe> recipeCache;
    protected boolean needsFlipping;
    protected boolean flipped;
    protected int rotation;
    protected boolean sync;

    // Client only
    private FlipAnimation animation;

    public FryingPanBlockEntity(BlockPos pos, BlockState state)
    {
        this(ModBlockEntities.FRYING_PAN.get(), pos, state, ModRecipeTypes.FRYING_PAN_COOKING.get());
    }

    public FryingPanBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state, RecipeType<? extends AbstractCookingRecipe> recipeType)
    {
        super(type, pos, state, 1);
        this.recipeCache = RecipeManager.createCheck(recipeType);
    }

    public boolean isFlippingNeeded()
    {
        return this.needsFlipping;
    }

    public boolean isFlipped()
    {
        return this.flipped;
    }

    public int getRotation()
    {
        return this.rotation;
    }

    @Override
    protected Component getDefaultName()
    {
        return Utils.translation("container", "frying_pan");
    }

    @Override
    public boolean isMatchingContainerMenu(AbstractContainerMenu menu)
    {
        return false;
    }

    @Override
    protected AbstractContainerMenu createMenu(int windowId, Inventory playerInventory)
    {
        return null;
    }

    public static void serverTick(Level level, BlockPos pos, BlockState state, FryingPanBlockEntity fryingPan)
    {
        if(fryingPan.sync)
        {
            BlockEntityHelper.sendCustomUpdate(fryingPan, fryingPan.getUpdateTag());
            fryingPan.sync = false;
        }
    }

    public static void clientTick(Level level, BlockPos pos, BlockState state, FryingPanBlockEntity fryingPan)
    {
        fryingPan.spawnParticles(level, pos);
        fryingPan.getAnimation().tick();
    }

    /**
     * Spawns sizzling particles when the item in the pan is cooking
     *
     * @param level the level the spawn the particles
     * @param pos the block position of the frying pan
     */
    private void spawnParticles(Level level, BlockPos pos)
    {
        if(this.isCooking() && !this.getAnimation().isPlaying())
        {
            double posX = pos.getX() + 0.35 + 0.3 * level.random.nextDouble();
            double posY = pos.getY() + 0.15;
            double posZ = pos.getZ() + 0.35 + 0.3 * level.random.nextDouble();
            level.addParticle(new DustParticleOptions(OIL_COLOUR, 0.25F), posX, posY, posZ, 0, -0.05, 0);
        }
    }

    @Override
    public BlockEntity getBlockEntity()
    {
        return this;
    }

    @Override
    public boolean canCook()
    {
        ItemStack stack = this.getItem(0);
        if(!stack.isEmpty() && !this.needsFlipping)
        {
            Optional<? extends AbstractCookingRecipe> optional = this.getRecipe(this.recipeCache, stack);
            return optional.isPresent();
        }
        return false;
    }

    @Override
    public int getTimeToCook()
    {
        ItemStack stack = this.getItem(0);
        if(!stack.isEmpty())
        {
            Optional<? extends AbstractCookingRecipe> optional = this.getRecipe(this.recipeCache, stack);
            if(optional.isPresent())
            {
                return optional.get().getCookingTime() / 2; // Half the time since it's flipped
            }
        }
        return 0;
    }

    @Override
    public void onCompleteCooking()
    {
        if(!this.flipped)
        {
            this.needsFlipping = true;
            this.sync();
            return;
        }

        ItemStack stack = this.getItem(0);
        if(!stack.isEmpty())
        {
            Item remainingItem = stack.getItem().getCraftingRemainingItem();
            Optional<? extends AbstractCookingRecipe> optional = this.getRecipe(this.recipeCache, stack);
            ItemStack result = optional.map(recipe -> recipe.getResultItem(this.level.registryAccess())).orElse(ItemStack.EMPTY);
            stack.shrink(1);
            if(!result.isEmpty())
            {
                ItemStack copy = result.copy();
                this.setItem(0, copy);
                if(remainingItem != null)
                {
                    BlockPos pos = this.worldPosition;
                    this.level.addFreshEntity(new ItemEntity(this.level, pos.getX() + 0.5, pos.getY() + 0.1, pos.getZ() + 0.5, new ItemStack(remainingItem)));
                }
            }
        }
    }

    /**
     * A utility to get a recipe for the given cache and ItemStack.
     *
     * @param cache the cache to check
     * @param stack the itemstack of the recipe
     * @return An optional recipe
     */
    private Optional<? extends AbstractCookingRecipe> getRecipe(RecipeManager.CachedCheck<Container, ? extends AbstractCookingRecipe> cache, ItemStack stack)
    {
        return cache.getRecipeFor(new SimpleContainer(stack), Objects.requireNonNull(this.level));
    }

    /**
     * Flips the item
     */
    public void flipItem()
    {
        if(this.needsFlipping && !this.flipped)
        {
            this.flipped = true;
            this.needsFlipping = false;
            this.sendFlipAnimationToPlayers();
            this.sync();
            return;
        }
        if(!this.getItem(0).isEmpty())
        {
            this.removeContents();
        }
    }

    /**
     * Places an ItemStack into the frying pan. The rotation of the item when rendering is
     * determined by the rotation param. This should be the 2d value of a Direction.
     *
     * @param stack    the item to place
     * @param rotation the rotation of the item
     * @return True if the item was placed into the frying pan
     */
    public boolean placeContents(ItemStack stack, int rotation)
    {
        if(!stack.isEmpty() && this.getItem(0).isEmpty())
        {
            ItemStack copy = stack.copy();
            copy.setCount(1);
            this.setItem(0, copy);
            this.rotation = rotation;
            this.flipped = false;
            this.needsFlipping = false;
            this.sync();
            return true;
        }
        this.removeContents();
        return false;
    }

    /**
     * Removes the contents from the frying pan and spawns it as an entity in level
     */
    public void removeContents()
    {
        if(!this.getItem(0).isEmpty())
        {
            ItemStack stack = this.getItem(0);
            BlockPos pos = this.worldPosition;
            ItemEntity entity = new ItemEntity(this.level, pos.getX() + 0.5, pos.getY() + 0.1, pos.getZ() + 0.5, stack.copy());
            this.setItem(0, ItemStack.EMPTY);
            this.level.addFreshEntity(entity);
            this.sync();
        }
    }

    /**
     * Plays the flipping animation for the item at the given index. This method will do
     * nothing if called on the logical server side.
     *
     * @param index the index of the item
     */
    public void playFlipAnimation(int index)
    {
        if(Objects.requireNonNull(this.level).isClientSide() && index == 0)
        {
            this.getAnimation().play();
        }
    }

    /**
     * Sends a packet to clients tracking the position of this frying pan to perform a flipping
     * animation for the item currently placed in the frying pan.
     */
    private void sendFlipAnimationToPlayers()
    {
        Level level = Objects.requireNonNull(this.level);
        if(level.getChunkSource() instanceof ServerChunkCache cache)
        {
            BlockPos pos = this.getBlockPos();
            List<ServerPlayer> players = cache.chunkMap.getPlayers(new ChunkPos(pos), false);
            players.forEach(player -> Network.getPlay().sendToPlayer(() -> player, new MessageFlipAnimation(pos, 0)));
        }
    }

    /**
     * Client only method. Gets the animation handler used for updating the flipping animation
     *
     * @return An animation handler for the flipping motion
     */
    public FlipAnimation getAnimation()
    {
        if(this.animation == null)
        {
            this.animation = new FlipAnimation();
        }
        return this.animation;
    }

    @Override
    public void setChanged()
    {
        super.setChanged();
        this.sync();
    }

    /**
     * Marks the frying pan as needing to sync data to tracking clients
     */
    protected void sync()
    {
        this.sync = true;
    }

    @Nullable
    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket()
    {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag()
    {
        return this.saveWithoutMetadata();
    }

    @Override
    public void load(CompoundTag tag)
    {
        super.load(tag);
        if(tag.contains("NeedsFlipping", Tag.TAG_BYTE))
        {
            this.needsFlipping = tag.getBoolean("NeedsFlipping");
        }
        if(tag.contains("Flipped", Tag.TAG_BYTE))
        {
            this.flipped = tag.getBoolean("Flipped");
        }
        if(tag.contains("Rotation", Tag.TAG_INT))
        {
            this.rotation = tag.getInt("Rotation");
        }
    }

    @Override
    protected void saveAdditional(CompoundTag tag)
    {
        super.saveAdditional(tag);
        tag.putBoolean("NeedsFlipping", this.needsFlipping);
        tag.putBoolean("Flipped", this.flipped);
        tag.putInt("Rotation", this.rotation);
    }
}