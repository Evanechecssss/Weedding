package top.evanechecssss.weedding.utils.base.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;
import top.evanechecssss.weedding.utils.reference.WeeddingInfo;

public class ItemFoodBase extends ItemFood {
    public ItemFoodBase(String name, int amount, float saturation, boolean isWolfFood) {
        super(amount, saturation, isWolfFood);
        this.setRegistryName(name);
        this.setUnlocalizedName(WeeddingInfo.MODID + "." + name);
    }
    public ItemFoodBase(String name, int amount, float saturation, boolean isWolfFood, int damage, int stackSize, CreativeTabs tab) {
        super(amount, saturation, isWolfFood);
        this.setRegistryName(name);
        this.setUnlocalizedName(WeeddingInfo.MODID + "." + name);
        this.setMaxDamage(damage);
        this.setMaxStackSize(stackSize);
        this.setCreativeTab(tab);
    }
    public ItemFoodBase(String name, int amount, float saturation, boolean isWolfFood, boolean alwaysEdible, int damage, int stackSize, CreativeTabs tab) {
        super(amount, saturation, isWolfFood);
        this.setRegistryName(name);
        this.setUnlocalizedName(WeeddingInfo.MODID + "." + name);
        this.setMaxDamage(damage);
        this.setMaxStackSize(stackSize);
        this.setCreativeTab(tab);
        if (alwaysEdible){
            this.setAlwaysEdible();
        }
    }
}
