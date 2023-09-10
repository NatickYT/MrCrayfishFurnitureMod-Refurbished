package com.mrcrayfish.furniture.refurbished.client.audio;

import com.mrcrayfish.furniture.refurbished.blockentity.ElectricityGeneratorBlockEntity;
import com.mrcrayfish.furniture.refurbished.core.ModSounds;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;

import java.lang.ref.WeakReference;

/**
 * Author: MrCrayfish
 */
public class ElectricityGeneratorSound extends AbstractTickableSoundInstance
{
    public static final double MAX_DISTANCE = Mth.square(5);

    private final WeakReference<ElectricityGeneratorBlockEntity> generatorRef;

    public ElectricityGeneratorSound(BlockPos pos, ElectricityGeneratorBlockEntity generator)
    {
        super(ModSounds.BLOCK_ELECTRICITY_GENERATOR_ENGINE.get(), SoundSource.BLOCKS, SoundInstance.createUnseededRandom());
        this.generatorRef = new WeakReference<>(generator);
        this.volume = 0F;
        this.looping = true;
        this.delay = 0;
        this.x = pos.getX() + 0.5;
        this.y = pos.getY() + 0.5;
        this.z = pos.getZ() + 0.5;
    }

    @Override
    public boolean canStartSilent()
    {
        return true;
    }

    @Override
    public void tick()
    {
        ElectricityGeneratorBlockEntity generator = this.generatorRef.get();
        if(generator == null || !generator.isPowered() || generator.isRemoved())
        {
            this.stop();
            return;
        }

        Minecraft mc = Minecraft.getInstance();
        if(mc.player != null)
        {
            double distanceSquared = mc.player.getEyePosition().distanceToSqr(this.x, this.y, this.z);
            if(distanceSquared > MAX_DISTANCE)
            {
                this.stop();
                return;
            }
            this.volume = 1.0F - (float) Mth.clamp(distanceSquared / MAX_DISTANCE, 0.0, 1.0);
        }
        else
        {
            this.stop();
        }
    }
}
