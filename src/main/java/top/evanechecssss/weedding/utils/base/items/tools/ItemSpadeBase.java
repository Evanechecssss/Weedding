package top.evanechecssss.weedding.utils.base.items.tools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSpade;

public class ItemSpadeBase extends ItemSpade {
    public ItemSpadeBase(String name,ToolMaterial material) {
        super(material);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
    }
    public ItemSpadeBase(String name,ToolMaterial material, int maxStackSize, int level, int damage, CreativeTabs tab) {
        super(material);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setMaxStackSize(maxStackSize);
        this.setHarvestLevel("spade",level);
        this.setMaxDamage(damage);
        this.setCreativeTab(tab);
    }
}
