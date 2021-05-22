package top.evanechecssss.weedding.utils.reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import top.evanechecssss.weedding.init.WeeddingBlocks;

public class WeeddingCreativeTabs {
    public static final CreativeTabs WEEDDING_CT = new CreativeTabs("weedding") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(WeeddingBlocks.HEMP);
        }

        @Override
        public boolean hasSearchBar() {
            return true;
        }
    }.setBackgroundImageName("weedding.png").setNoTitle();
}
