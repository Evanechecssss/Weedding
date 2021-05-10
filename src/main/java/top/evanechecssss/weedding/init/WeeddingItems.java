package top.evanechecssss.weedding.init;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import top.evanechecssss.weedding.api.Materials;
import top.evanechecssss.weedding.common.items.CustomBook;
import top.evanechecssss.weedding.common.items.HempCalik;
import top.evanechecssss.weedding.common.items.HempSeed;
import top.evanechecssss.weedding.common.items.armor.HookahSuit;
import top.evanechecssss.weedding.utils.base.items.ItemBase;
import top.evanechecssss.weedding.utils.base.items.ItemFoodBase;
import top.evanechecssss.weedding.utils.base.items.ItemRecordBase;
import top.evanechecssss.weedding.utils.base.items.tools.ItemAxeBase;
import top.evanechecssss.weedding.utils.reference.WeeddingCreativeTabs;
import top.evanechecssss.weedding.utils.reference.WeeddingInfo;

public class WeeddingItems {
    public static final Item NGM = new ItemBase("ngm", 1, 1, WeeddingCreativeTabs.weedding);
    public static final Item HEMP_SEED = new HempSeed("hemp_seed", 0, 64, WeeddingCreativeTabs.weedding);
    public static final Item HEMP_FOOD = new ItemFoodBase("hemp_food", 2, 1, true, true, 0, 64, WeeddingCreativeTabs.weedding);
    public static final Item HEMP_CALIK = new HempCalik("hemp_calik", 1, 1, WeeddingCreativeTabs.weedding);
    public static final Item HEMP_AXE = new ItemAxeBase("hemp_axe", Materials.ToolMaterials.ZINC_METAL, 10, 10, 1, 5, WeeddingCreativeTabs.weedding);
    public static final Item WEEDDING_BOOK = new CustomBook("weedding_book", 1, 1, WeeddingCreativeTabs.weedding, "text", new ResourceLocation(WeeddingInfo.MODID, "textures/gui/book.png"), true, 0, 1);
    public static final Item HS_LEGGS = new HookahSuit("hs_leggs", Materials.ArmorMaterials.HOOKAH_SUITS, 2, EntityEquipmentSlot.LEGS);
    public static final Item HS_CHESTPLATE = new HookahSuit("hs_chestplate", Materials.ArmorMaterials.HOOKAH_SUITS, 1, EntityEquipmentSlot.CHEST);
    public static final Item HS_HEAD = new HookahSuit("hs_head", Materials.ArmorMaterials.HOOKAH_SUITS, 1, EntityEquipmentSlot.HEAD);
    public static final Item HSD_LEGGS = new HookahSuit("hsd_leggs", Materials.ArmorMaterials.HOOKAH_SUIT_DISTRICT, 2, EntityEquipmentSlot.LEGS);
    public static final Item HSD_CHESTPLATE = new HookahSuit("hsd_chestplate", Materials.ArmorMaterials.HOOKAH_SUIT_DISTRICT, 1, EntityEquipmentSlot.CHEST);
    public static final Item HSD_HEAD = new HookahSuit("hsd_head", Materials.ArmorMaterials.HOOKAH_SUIT_DISTRICT, 1, EntityEquipmentSlot.HEAD);
    public static final Item HSD_BOOTS = new HookahSuit("hsd_boots", Materials.ArmorMaterials.HOOKAH_SUIT_DISTRICT, 1, EntityEquipmentSlot.FEET);
    public static final Item HEMP_LEGGS = new HookahSuit("hemp_leggs", Materials.ArmorMaterials.HEMP, 2, EntityEquipmentSlot.LEGS);
    public static final Item HEMP_CHESTPLATE = new HookahSuit("hemp_chestplate", Materials.ArmorMaterials.HEMP, 1, EntityEquipmentSlot.CHEST);
    public static final Item HEMP_HEAD = new HookahSuit("hemp_head", Materials.ArmorMaterials.HEMP, 1, EntityEquipmentSlot.HEAD);
    public static final Item HEMP_BOOTS = new HookahSuit("hemp_boots", Materials.ArmorMaterials.HEMP, 1, EntityEquipmentSlot.FEET);
    public static final Item RECORD1 = new ItemRecordBase("smooth_bong", WeeddingSounds.SMOOTH_BONG);
    public static final Item[] ITEMS = new Item[]{
            NGM, HEMP_SEED, HEMP_FOOD, HEMP_CALIK, HEMP_AXE, HS_LEGGS, HS_CHESTPLATE, HS_HEAD, HEMP_LEGGS, HEMP_CHESTPLATE, HEMP_BOOTS, HEMP_HEAD, HSD_HEAD, HSD_LEGGS, HSD_CHESTPLATE, HSD_BOOTS, WEEDDING_BOOK, RECORD1
    };
}
