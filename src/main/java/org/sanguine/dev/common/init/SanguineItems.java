package org.sanguine.dev.common.init;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import org.sanguine.dev.common.Sanguine;
import org.sanguine.dev.common.item.SyringeItem;

import java.util.function.Function;

public interface SanguineItems {

    /* items */

    Item SYRINGE = register("syringe", SyringeItem::new);


    /* - registry and helper methods - */

    static Item register(String name, Function<Item.Properties, Item> itemFactory) {
        return register(name,itemFactory,new Item.Properties());
    }

    static Item register(String name, Function<Item.Properties, Item> itemFactory, Item.Properties settings) {
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Sanguine.id(name));
        Item item = itemFactory.apply(settings.setId(itemKey));

        Registry.register(BuiltInRegistries.ITEM, itemKey, item);
        return item;
    }


    static void init() {}

}
