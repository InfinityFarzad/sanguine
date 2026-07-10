package org.sanguine.dev.common.init;

import net.fabricmc.fabric.api.entity.event.v1.ServerEntityCombatEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLevelEvents;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.sanguine.dev.common.item.SyringeItem;

public class SanguineEvents {

    public static void initClientEvents() {

    }

    public static void initCommonEvents() {
        ServerEntityCombatEvents.AFTER_KILLED_OTHER_ENTITY.register(((level, entity, killedEntity, damageSource) -> {
            if (entity instanceof Player player) {
                ItemStack stack = damageSource.getWeaponItem();
                if (damageSource.getWeaponItem().getItem() instanceof SyringeItem syringeItem) {
                    syringeItem.onEntityKilled(stack,player,killedEntity);
                }
            }
        }));
    }

}
