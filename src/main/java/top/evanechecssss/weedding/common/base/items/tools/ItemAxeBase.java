package top.evanechecssss.weedding.common.base.items.tools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;
import top.evanechecssss.weedding.init.WeeddingInfo;

public class ItemAxeBase extends ItemAxe {
    public ItemAxeBase(String name,ToolMaterial material, float damage, float speed) {
        super(material, damage, speed);
        this.setRegistryName(name);
        this.setUnlocalizedName(WeeddingInfo.MODID + "." + name);
    }
    public ItemAxeBase(String name, ToolMaterial material, float damage, float speed, int maxStackSize, int level, CreativeTabs tab) {
        super(material, damage, speed);
        this.setRegistryName(name);
        this.setUnlocalizedName(WeeddingInfo.MODID + "." + name);
        this.setMaxStackSize(maxStackSize);
        this.setHarvestLevel("axe",level);
        this.setCreativeTab(tab);
    }
}
