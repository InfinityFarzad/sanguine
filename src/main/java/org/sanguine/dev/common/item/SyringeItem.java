package org.sanguine.dev.common.item;

import com.mojang.serialization.Codec;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class SyringeItem extends Item {
    public SyringeItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        return super.use(level, player, hand);
    }

    public void onEntityKilled(ItemStack stack, Player player, LivingEntity victim) {

    }


    public enum SyringeBloodType implements StringRepresentable {
        POTION("potion"),
        PURE_BLOOD("pure_blood"),
        VAMPIRE_BLOOD("vampire_blood"),
        UNDEAD("undead"),
        HUMAN("human"),
        EMPTY("empty")
        ;
        public static final Codec<SyringeBloodType> CODEC = StringRepresentable.fromEnum(SyringeBloodType::values);
        private final String id;

        SyringeBloodType(String id) {
            this.id = id;
        }

        @Override
        public String getSerializedName() {
            return id;
        }
    }
}
