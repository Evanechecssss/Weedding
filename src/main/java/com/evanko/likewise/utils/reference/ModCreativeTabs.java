package com.evanko.likewise.utils.reference;

import com.evanko.likewise.init.LikewiseBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class ModCreativeTabs{
    public static final CreativeTabs LIKEWISE = new CreativeTabs("likewise") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(LikewiseBlocks.HEMP);
        }

        @Override
        public boolean hasSearchBar() {
            return true;
        }
    }.setBackgroundImageName("likewise.png").setNoScrollbar();
}
