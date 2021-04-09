package com.evanko.likewise.common.blocks.help;

import net.minecraft.potion.PotionEffect;

public interface IHookah {
    PotionEffect[] EFFECTS = {};

    default PotionEffect[] getPotionEffects() {
        return EFFECTS;
    }

    default boolean isHookah() {
        return true;
    }

    boolean isEmpty();

    int getLevel();

    String getTypeHookah();
}
