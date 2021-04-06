package com.evanko.likewise.items;

import com.evanko.likewise.base.items.ItemBase;
import com.evanko.likewise.base.items.ItemFoodBase;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

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
}
