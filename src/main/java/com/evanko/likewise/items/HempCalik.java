package com.evanko.likewise.items;

import com.evanko.likewise.api.Materials;
import com.evanko.likewise.base.items.ItemBase;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;

import java.util.List;

public class HempCalik extends ItemBase {

    public HempCalik(String name) {
        super(name);
    }

    public HempCalik(String name, int damage, int stackSize, CreativeTabs tab) {
        super(name, damage, stackSize, tab);
    }

    public HempCalik(String name, int damage, int stackSize, CreativeTabs tab, String toolClass, int toolLevel, List<String> stringList) {
        super(name, damage, stackSize, tab, toolClass, toolLevel, stringList);
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return Materials.Rarity.FORBIDDEN;
    }
}
