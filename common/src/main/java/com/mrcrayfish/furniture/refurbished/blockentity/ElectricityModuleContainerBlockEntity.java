package com.mrcrayfish.furniture.refurbished.blockentity;

import com.mrcrayfish.furniture.refurbished.Config;
import com.mrcrayfish.furniture.refurbished.electricity.Connection;
import com.mrcrayfish.furniture.refurbished.electricity.IModuleNode;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

import javax.annotation.Nullable;
import java.util.HashSet;
import java.util.Set;

/**
 * Author: MrCrayfish
 */
public abstract class ElectricityModuleContainerBlockEntity extends RandomizableContainerBlockEntity implements IModuleNode
{
    protected final Set<Connection> connections = new HashSet<>();
    protected boolean receivingPower;

    public ElectricityModuleContainerBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state)
    {
        super(type, pos, state);
    }

    @Override
    public Level getNodeLevel()
    {
        return this.level;
    }

    @Override
    public BlockPos getNodePosition()
    {
        return this.worldPosition;
    }

    @Override
    public BlockEntity getNodeOwner()
    {
        return this;
    }

    @Override
    public Set<Connection> getNodeConnections()
    {
        return this.connections;
    }

    @Override
    public void setNodeReceivingPower(boolean power)
    {
        this.receivingPower = power;
    }

    @Override
    public boolean isNodeReceivingPower()
    {
        return this.receivingPower;
    }

    @Override
    public void load(CompoundTag tag)
    {
        super.load(tag);
        this.readNodeNbt(tag);
    }

    @Override
    protected void saveAdditional(CompoundTag tag)
    {
        super.saveAdditional(tag);
        this.writeNodeNbt(tag);
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

    // @Override From IForgeBlockEntity
    @SuppressWarnings("unused")
    public AABB getRenderBoundingBox()
    {
        return new AABB(this.worldPosition).inflate(Config.CLIENT.electricityViewDistance.get());
    }

    @Override
    public int hashCode()
    {
        return this.worldPosition.hashCode();
    }

    public static void serverTick(Level level, BlockPos pos, BlockState state, ElectricityModuleContainerBlockEntity module)
    {
        module.updateNodePoweredState();
        module.setNodeReceivingPower(false);
    }

    @Override
    public void saveToItem(ItemStack $$0)
    {
        super.saveToItem($$0);
    }
}
