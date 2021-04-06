package com.evanko.likewise.base.items.tools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemHoe;

public class ItemHoeBase extends ItemHoe {
    public ItemHoeBase(String name,ToolMaterial material) {
        super(material);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
    }
    public ItemHoeBase(String name, ToolMaterial material, int maxStackSize, int level, int damage,CreativeTabs tab) {
        super(material);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setMaxStackSize(maxStackSize);
        this.setHarvestLevel("hoe",level);
        this.setMaxDamage(damage);
        this.setCreativeTab(tab);
    }
}
