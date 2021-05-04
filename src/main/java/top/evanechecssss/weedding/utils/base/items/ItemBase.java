package top.evanechecssss.weedding.utils.base.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.List;

public class ItemBase extends Item {
    public ItemBase(String name) {
        this.setRegistryName(name);
        this.setUnlocalizedName("weedding." + name);
        this.maxStackSize = 100;
    }
    public ItemBase(String name, int damage, int stackSize, CreativeTabs tab) {
        this.setRegistryName(name);
        this.setUnlocalizedName("weedding." + name);
        this.setMaxDamage(damage);
        this.setMaxStackSize(stackSize);
        this.setCreativeTab(tab);
        this.maxStackSize = 100;
    }
    public ItemBase(String name, int damage, int stackSize, CreativeTabs tab, String toolClass, int toolLevel, List<String> stringList) {
        this.setRegistryName(name);
        this.setUnlocalizedName("weedding." + name);
        this.setMaxDamage(damage);
        this.setMaxStackSize(stackSize);
        this.setCreativeTab(tab);
        this.setHarvestLevel(toolClass,toolLevel);
        this.addInformation(new ItemStack(this), null, stringList, () -> false);
        this.maxStackSize = 100;
    }
}
