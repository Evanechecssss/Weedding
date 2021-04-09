package com.evanko.likewise.utils.base.items.tools;

import com.evanko.likewise.utils.reference.ModInfo;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;

public class ItemAxeBase extends ItemAxe {
    public ItemAxeBase(String name,ToolMaterial material, float damage, float speed) {
        super(material, damage, speed);
        this.setRegistryName(name);
        this.setUnlocalizedName(ModInfo.MODID + "." + name);
    }
    public ItemAxeBase(String name, ToolMaterial material, float damage, float speed, int maxStackSize, int level, CreativeTabs tab) {
        super(material, damage, speed);
        this.setRegistryName(name);
        this.setUnlocalizedName(ModInfo.MODID + "." + name);
        this.setMaxStackSize(maxStackSize);
        this.setHarvestLevel("axe",level);
        this.setCreativeTab(tab);
    }
}
