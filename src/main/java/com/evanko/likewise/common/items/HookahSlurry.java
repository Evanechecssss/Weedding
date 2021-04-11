package com.evanko.likewise.common.items;

import com.evanko.likewise.utils.base.items.ItemBase;
import net.minecraft.creativetab.CreativeTabs;

import java.util.List;

public abstract class HookahSlurry extends ItemBase {
    public HookahSlurry(String name) {
        super(name);
    }

    public HookahSlurry(String name, int damage, int stackSize, CreativeTabs tab) {
        super(name, damage, stackSize, tab);
    }

    public HookahSlurry(String name, int damage, int stackSize, CreativeTabs tab, String toolClass, int toolLevel, List<String> stringList) {
        super(name, damage, stackSize, tab, toolClass, toolLevel, stringList);
    }

}
