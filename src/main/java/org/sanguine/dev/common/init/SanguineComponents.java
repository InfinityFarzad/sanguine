package org.sanguine.dev.common.init;

import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import org.sanguine.dev.common.component.SanguineBloodComponent;

import java.util.function.UnaryOperator;

public interface SanguineComponents {
    DataComponentType<SanguineBloodComponent> BLOOD_TYPE = register("syringe_blood_type",builder -> builder.persistent(SanguineBloodComponent.CODEC));

    private static <T> DataComponentType<T> register(final String id, final UnaryOperator<DataComponentType.Builder<T>> builder) {
        return Registry.register(BuiltInRegistries.DATA_COMPONENT_TYPE, id, builder.apply(DataComponentType.builder()).build());
    }

    static void init() {}
}
