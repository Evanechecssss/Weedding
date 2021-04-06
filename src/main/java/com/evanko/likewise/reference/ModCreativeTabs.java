package com.evanko.likewise.reference;

import com.evanko.likewise.init.LikewiseItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class ModCreativeTabs{
    public static final CreativeTabs LIKEWISE = new CreativeTabs("likewise") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(LikewiseItems.NGM);
        }
        @Override
        public boolean hasSearchBar() {
            return true;
        }
    }.setBackgroundImageName("likewise.png").setNoTitle();
    public static final CreativeTabs HELPER = new CreativeTabs("helper") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(Blocks.VINE);
        }
        @Override
        public boolean hasSearchBar() {
            return false;
        }
    }.setBackgroundImageName("helper.png").setNoScrollbar();
}
