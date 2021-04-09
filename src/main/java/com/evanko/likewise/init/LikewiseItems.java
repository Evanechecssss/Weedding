package com.evanko.likewise.init;

import com.evanko.likewise.api.Materials;
import com.evanko.likewise.common.items.HempCalik;
import com.evanko.likewise.common.items.HempSeed;
import com.evanko.likewise.utils.base.items.ItemBase;
import com.evanko.likewise.utils.base.items.ItemFoodBase;
import com.evanko.likewise.utils.base.items.tools.ItemAxeBase;
import com.evanko.likewise.utils.reference.ModCreativeTabs;
import net.minecraft.item.Item;

public class LikewiseItems {
    public static final Item NGM = new ItemBase("ngm", 1, 1, ModCreativeTabs.LIKEWISE);
    public static final Item HEMP_SEED = new HempSeed("hemp_seed", 0, 64, ModCreativeTabs.LIKEWISE);
    public static final Item HEMP_FOOD = new ItemFoodBase("hemp_food", 2, 1, true, true, 0, 64, ModCreativeTabs.LIKEWISE);
    public static final Item HEMP_CALIK = new HempCalik("hemp_calik", 1, 1, ModCreativeTabs.LIKEWISE);
    public static final Item HEMP_AXE = new ItemAxeBase("hemp_axe", Materials.ToolMaterials.ZINC_METAL, 10, 10, 1, 5, ModCreativeTabs.LIKEWISE);
    public static final Item[] ITEMS = new Item[]{
            NGM, HEMP_SEED, HEMP_FOOD, HEMP_CALIK, HEMP_AXE
    };
}
