package top.evanechecssss.weedding.common.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import top.evanechecssss.weedding.api.WeeddingMisc;

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
    public boolean hasCustomEntity(ItemStack stack) {
        return true;
    }

    @Nullable
    @Override
    public Entity createEntity(World world, Entity location, ItemStack itemstack) {
        return super.createEntity(world, location, itemstack);
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return WeeddingMisc.Rarity.FORBIDDEN;
    }
}
