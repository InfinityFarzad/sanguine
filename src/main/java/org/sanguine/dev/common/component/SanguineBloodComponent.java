package org.sanguine.dev.common.component;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import org.sanguine.dev.common.item.SyringeItem;

public record SanguineBloodComponent(SyringeItem.SyringeBloodType bloodType) {
    public static SanguineBloodComponent EMPTY = new SanguineBloodComponent(SyringeItem.SyringeBloodType.EMPTY);
    public static final Codec<SanguineBloodComponent> CODEC = RecordCodecBuilder.create(builder -> {
        return builder.group(
               SyringeItem.SyringeBloodType.CODEC.fieldOf("type").forGetter(SanguineBloodComponent::bloodType)
        ).apply(builder, SanguineBloodComponent::new);
    });

}
