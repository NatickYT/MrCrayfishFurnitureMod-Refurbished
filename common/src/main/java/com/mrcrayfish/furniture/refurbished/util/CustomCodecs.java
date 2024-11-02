package com.mrcrayfish.furniture.refurbished.util;

import com.mojang.authlib.GameProfile;
import net.minecraft.core.UUIDUtil;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.Utf8String;
import net.minecraft.network.codec.StreamCodec;

import java.util.UUID;

/**
 * Author: MrCrayfish
 */
public class CustomCodecs
{
    public static final StreamCodec<FriendlyByteBuf, GameProfile> GAME_PROFILE_NO_PROPERTIES = StreamCodec.of((buf, profile) -> {
        UUIDUtil.STREAM_CODEC.encode(buf, profile.getId());
        Utf8String.write(buf, profile.getName(), 16);
    }, buf -> {
        UUID id = UUIDUtil.STREAM_CODEC.decode(buf);
        String name = Utf8String.read(buf, 16);
        return new GameProfile(id, name);
    });
}
