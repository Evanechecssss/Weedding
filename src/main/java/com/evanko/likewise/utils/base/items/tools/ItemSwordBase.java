package com.evanko.likewise.utils.base.items.tools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;

public class ItemSwordBase extends ItemSword {
    public ItemSwordBase(String name,ToolMaterial material) {
        super(material);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
    }
    public ItemSwordBase(String name,ToolMaterial material, int maxStackSize, int level, int damage, CreativeTabs tab) {
        super(material);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setMaxStackSize(maxStackSize);
        this.setHarvestLevel("sword",level);
        this.setMaxDamage(damage);
        this.setCreativeTab(tab);
    }
}
