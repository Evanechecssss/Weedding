package com.evanko.likewise.base.items.crop;

import net.minecraft.block.Block;
import net.minecraft.item.ItemSeeds;

public class SeedBase extends ItemSeeds {
    public SeedBase(String name,Block crops, Block soil) {
        super(crops, soil);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);

    }
}
