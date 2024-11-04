package com.mrcrayfish.furniture.refurbished.inventory;

import com.mrcrayfish.framework.api.FrameworkAPI;
import com.mrcrayfish.framework.api.menu.IMenuData;
import com.mrcrayfish.furniture.refurbished.blockentity.PostBoxBlockEntity;
import com.mrcrayfish.furniture.refurbished.client.ClientMailbox;
import com.mrcrayfish.furniture.refurbished.core.ModMenuTypes;
import com.mrcrayfish.furniture.refurbished.inventory.slot.PostBoxSlot;
import com.mrcrayfish.furniture.refurbished.mail.DeliveryService;
import com.mrcrayfish.furniture.refurbished.mail.IMailbox;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Author: MrCrayfish
 */
public class PostBoxMenu extends SimpleContainerMenu
{
    protected final List<IMailbox> mailboxes = new ArrayList<>();

    public PostBoxMenu(int windowId, Inventory playerInventory, CustomData data)
    {
        this(windowId, playerInventory, new SimpleContainer(PostBoxBlockEntity.CONTAINER_SIZE));
        this.mailboxes.addAll(data.mailboxes());
    }

    public PostBoxMenu(int windowId, Inventory playerInventory, Container container)
    {
        super(ModMenuTypes.POST_BOX.get(), windowId, container);
        checkContainerSize(container, 6);
        container.startOpen(playerInventory.player);
        for(int j = 0; j < 3; j++)
        {
            for(int i = 0; i < 2; i++)
            {
                this.addSlot(new PostBoxSlot(container, j * 2 + i, 235 + i * 18, 14 + j * 18));
            }
        }
        this.addPlayerInventorySlots(114, 90, playerInventory);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int slotIndex)
    {
        ItemStack stack = ItemStack.EMPTY;
        Slot slot = this.slots.get(slotIndex);
        if(slot.hasItem())
        {
            ItemStack slotStack = slot.getItem();
            stack = slotStack.copy();
            if(slotIndex < this.container.getContainerSize())
            {
                if(!this.moveItemStackTo(slotStack, this.container.getContainerSize(), this.slots.size(), true))
                {
                    return ItemStack.EMPTY;
                }
            }
            else if(!DeliveryService.isBannedItem(slotStack))
            {
                if(!this.moveItemStackTo(slotStack, 0, this.container.getContainerSize(), false))
                {
                    return ItemStack.EMPTY;
                }
            }
            else if(slotIndex < this.slots.size() - 9)
            {
                if(!this.moveItemStackTo(slotStack, this.slots.size() - 9, this.slots.size(), true))
                {
                    return ItemStack.EMPTY;
                }
            }
            else if(!this.moveItemStackTo(slotStack, this.container.getContainerSize(), this.slots.size() - 9, false))
            {
                return ItemStack.EMPTY;
            }
            if(slotStack.isEmpty())
            {
                slot.setByPlayer(ItemStack.EMPTY);
            }
            else
            {
                slot.setChanged();
            }
        }
        return stack;
    }

    public List<IMailbox> getMailboxes()
    {
        return Collections.unmodifiableList(this.mailboxes);
    }

    public record CustomData(Collection<IMailbox> mailboxes) implements IMenuData<PostBoxMenu.CustomData>
    {
        public static final StreamCodec<RegistryFriendlyByteBuf, CustomData> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.collection(ArrayList::new, ClientMailbox.STREAM_CODEC),
            CustomData::mailboxes,
            CustomData::new
        );

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, CustomData> codec()
        {
            return STREAM_CODEC;
        }
    }
}
