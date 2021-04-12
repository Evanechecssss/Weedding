package top.evanechecssss.weedding.common.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import top.evanechecssss.weedding.api.Materials;

import java.util.List;

public class HempCalik extends HookahSlurry {

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
