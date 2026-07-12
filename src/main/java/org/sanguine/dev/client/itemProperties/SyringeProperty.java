package org.sanguine.dev.client.itemProperties;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.properties.select.SelectItemModelProperty;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.jspecify.annotations.Nullable;
import org.sanguine.dev.common.component.SanguineBloodComponent;
import org.sanguine.dev.common.init.SanguineComponents;
import org.sanguine.dev.common.item.SyringeItem;

public class SyringeProperty implements SelectItemModelProperty<SyringeItem.SyringeBloodType> {

    public static final Codec<SyringeItem.SyringeBloodType> VALUE_CODEC = SyringeItem.SyringeBloodType.CODEC;
    public static final Type<SyringeProperty, SyringeItem.SyringeBloodType> TYPE = Type.create(MapCodec.unit(new SyringeProperty()), VALUE_CODEC);
    public static MapCodec<SyringeProperty> CODEC = MapCodec.unit(SyringeProperty::new);


    @Override
    public SyringeItem.SyringeBloodType get(ItemStack stack, @Nullable ClientLevel world, @Nullable LivingEntity user, int seed, ItemDisplayContext displayContext) {
        return getActualValueLmao(stack);
    }

    private SyringeItem.SyringeBloodType getActualValueLmao(ItemStack stack) {
        SyringeItem.SyringeBloodType abilityType = stack.getOrDefault(SanguineComponents.BLOOD_TYPE, SanguineBloodComponent.EMPTY).bloodType();
        return abilityType;
    }

    @Override
    public Codec<SyringeItem.SyringeBloodType> valueCodec() {
        return VALUE_CODEC;
    }

    @Override
    public Type<? extends SelectItemModelProperty<SyringeItem.SyringeBloodType>, SyringeItem.SyringeBloodType> type() {
        return TYPE;
    }
}
