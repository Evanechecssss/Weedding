package com.evanko.likewise.base.items.tools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;

public class ItemPickaxeBase extends ItemPickaxe {
    protected ItemPickaxeBase(String name,ToolMaterial material) {
        super(material);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
    }
    protected ItemPickaxeBase(String name,ToolMaterial material, int maxStackSize, int level, int damage, CreativeTabs tab) {
        super(material);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setMaxStackSize(maxStackSize);
        this.setHarvestLevel("pickaxe",level);
        this.setMaxDamage(damage);
        this.setCreativeTab(tab);
    }
}
