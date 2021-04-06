package com.evanko.likewise.init;

import com.evanko.likewise.base.items.ItemBase;
import com.evanko.likewise.base.items.ItemFoodBase;
import com.evanko.likewise.base.items.crop.SeedBase;
import com.evanko.likewise.items.HempCalik;
import com.evanko.likewise.items.HempSeed;
import com.evanko.likewise.reference.ModCreativeTabs;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class LikewiseItems {
    public static final Item KEY = new ItemBase("key");
    public static final Item NGM = new ItemBase("ngm",1,1, ModCreativeTabs.LIKEWISE);
    public static final Item HEMP_SEED = new HempSeed("hemp_seed",0,64,CreativeTabs.MISC);
    public static final Item HEMP_FOOD = new ItemFoodBase("hemp_food",2,1,true,true,0,64, CreativeTabs.FOOD);
    public static final Item HEMP_CALIK = new HempCalik("hemp_calik",1,1,CreativeTabs.TOOLS);

    public static final Item[] ITEMS = new Item[]{
            KEY,NGM,HEMP_SEED,HEMP_FOOD,HEMP_CALIK
    };
}
