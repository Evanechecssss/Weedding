package com.evanko.likewise.utils.base.items;

import com.evanko.likewise.utils.reference.ModInfo;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

public class ItemFoodBase extends ItemFood {
    public ItemFoodBase(String name, int amount, float saturation, boolean isWolfFood) {
        super(amount, saturation, isWolfFood);
        this.setRegistryName(name);
        this.setUnlocalizedName(ModInfo.MODID + "." + name);
    }
    public ItemFoodBase(String name, int amount, float saturation, boolean isWolfFood, int damage, int stackSize, CreativeTabs tab) {
        super(amount, saturation, isWolfFood);
        this.setRegistryName(name);
        this.setUnlocalizedName(ModInfo.MODID + "." + name);
        this.setMaxDamage(damage);
        this.setMaxStackSize(stackSize);
        this.setCreativeTab(tab);
    }
    public ItemFoodBase(String name, int amount, float saturation, boolean isWolfFood, boolean alwaysEdible, int damage, int stackSize, CreativeTabs tab) {
        super(amount, saturation, isWolfFood);
        this.setRegistryName(name);
        this.setUnlocalizedName(ModInfo.MODID + "." + name);
        this.setMaxDamage(damage);
        this.setMaxStackSize(stackSize);
        this.setCreativeTab(tab);
        if (alwaysEdible){
            this.setAlwaysEdible();
        }
    }
}
