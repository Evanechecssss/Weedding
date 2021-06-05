package top.evanechecssss.weedding.init;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import top.evanechecssss.weedding.api.WeeddingMisc;
import top.evanechecssss.weedding.common.armor.ExoskeletonArmor;
import top.evanechecssss.weedding.common.items.CustomBook;
import top.evanechecssss.weedding.common.items.CustomBook2;
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
    public static final Item DAFUK_ICON = new ItemBase("dafuk_icon");
    public static final Item NGM = new ItemBase("ngm", 1, 1, WeeddingCreativeTabs.WEEDDING_CT);
    public static final Item HEMP_SEED = new HempSeed("hemp_seed", 0, 64, WeeddingCreativeTabs.WEEDDING_CT);
    public static final Item HEMP_FOOD = new ItemFoodBase("hemp_food", 2, 1, true, true, 0, 64, WeeddingCreativeTabs.WEEDDING_CT);
    public static final Item HEMP_CALIK = new HempCalik("hemp_calik", 1, 1, WeeddingCreativeTabs.WEEDDING_CT);
    public static final Item HEMP_AXE = new ItemAxeBase("hemp_axe", WeeddingMisc.ToolMaterials.ZINC_METAL, 10, 10, 1, 5, WeeddingCreativeTabs.WEEDDING_CT);
    public static final Item WEEDDING_BOOK = new CustomBook("weedding_book", 1, 1, WeeddingCreativeTabs.WEEDDING_CT, "text", new ResourceLocation(WeeddingInfo.MODID, "textures/gui/book.png"), true, 0, 1);
    public static final Item WEEDDING_BOOK2 = new CustomBook2("weedding_book2", 2, 1, WeeddingCreativeTabs.WEEDDING_CT, "text2", new ResourceLocation(WeeddingInfo.MODID, "textures/gui/book2.png"), false, 5, 0x8E0900);
    public static final Item HS_LEGGS = new HookahSuit("hs_leggs", WeeddingMisc.ArmorMaterials.HOOKAH_SUITS, 2, EntityEquipmentSlot.LEGS);
    public static final Item HS_CHESTPLATE = new HookahSuit("hs_chestplate", WeeddingMisc.ArmorMaterials.HOOKAH_SUITS, 1, EntityEquipmentSlot.CHEST);
    public static final Item HS_HEAD = new HookahSuit("hs_head", WeeddingMisc.ArmorMaterials.HOOKAH_SUITS, 1, EntityEquipmentSlot.HEAD);
    public static final Item HSD_LEGGS = new HookahSuit("hsd_leggs", WeeddingMisc.ArmorMaterials.HOOKAH_SUIT_DISTRICT, 2, EntityEquipmentSlot.LEGS);
    public static final Item HSD_CHESTPLATE = new HookahSuit("hsd_chestplate", WeeddingMisc.ArmorMaterials.HOOKAH_SUIT_DISTRICT, 1, EntityEquipmentSlot.CHEST);
    public static final Item HSD_HEAD = new HookahSuit("hsd_head", WeeddingMisc.ArmorMaterials.HOOKAH_SUIT_DISTRICT, 1, EntityEquipmentSlot.HEAD);
    public static final Item HSD_BOOTS = new HookahSuit("hsd_boots", WeeddingMisc.ArmorMaterials.HOOKAH_SUIT_DISTRICT, 1, EntityEquipmentSlot.FEET);
    public static final Item HEMP_LEGGS = new HookahSuit("hemp_leggs", WeeddingMisc.ArmorMaterials.HEMP, 2, EntityEquipmentSlot.LEGS);
    public static final Item HEMP_CHESTPLATE = new HookahSuit("hemp_chestplate", WeeddingMisc.ArmorMaterials.HEMP, 1, EntityEquipmentSlot.CHEST);
    public static final Item HEMP_HEAD = new HookahSuit("hemp_head", WeeddingMisc.ArmorMaterials.HEMP, 1, EntityEquipmentSlot.HEAD);
    public static final Item HEMP_BOOTS = new HookahSuit("hemp_boots", WeeddingMisc.ArmorMaterials.HEMP, 1, EntityEquipmentSlot.FEET);
    public static final Item EXOSKELETON_LEGGS = new ExoskeletonArmor("leggs", WeeddingMisc.ArmorMaterials.EXOSKELETON, 2, EntityEquipmentSlot.LEGS);
    public static final Item EXOSKELETON_CHESTPLATE = new ExoskeletonArmor("chestplate", WeeddingMisc.ArmorMaterials.EXOSKELETON, 1, EntityEquipmentSlot.CHEST);
    public static final Item EXOSKELETON_HEAD = new ExoskeletonArmor("head", WeeddingMisc.ArmorMaterials.EXOSKELETON, 1, EntityEquipmentSlot.HEAD);
    public static final Item RECORD1 = new ItemRecordBase("smooth_bong", WeeddingSounds.SMOOTH_BONG).addInfo("Michael Jackson", "Smooth Criminal");
    public static final Item RECORD2 = new ItemRecordBase("bong_on_table", WeeddingSounds.BONG_ON_TABLE).addInfo("Grigory Leps", "A glass of vodka on the table");
    public static final Item RECORD3 = new ItemRecordBase("good_puff", WeeddingSounds.GOOD_PUFF).addInfo("Beasts", "Districts-quarters");
    public static final Item RECORD4 = new ItemRecordBase("hookah_girl", WeeddingSounds.HOOKAH_GIRL).addInfo("B2", "Silver");
    public static final Item RECORD5 = new ItemRecordBase("horse", WeeddingSounds.HORSE).addInfo("Entin Y. & Krylatov E.", "Beautiful far away");
    public static final Item RECORD6 = new ItemRecordBase("horse_rhapsody", WeeddingSounds.HORSE_RHAPSODY).addInfo("Queen ", "Bohemian Rhapsody");
    public static final Item RECORD7 = new ItemRecordBase("horse_squad", WeeddingSounds.HORSE_SQUAD).addInfo("Alexey Shelygin ", "Brigade");
    public static final Item RECORD8 = new ItemRecordBase("if_u_have_a_hemp", WeeddingSounds.IF_U_HAVE_A_HEMP).addInfo("Viktor Tsoi", "Pack of Cigarettes ");
    public static final Item RECORD9 = new ItemRecordBase("my_hookah", WeeddingSounds.MY_HOOKAH).addInfo("B2", "My rock and roll ");
    public static final Item RECORD10 = new ItemRecordBase("hookah_d", WeeddingSounds.HOOKAH_D).addInfo("Gas sector", "30 years");
    public static final Item RECORD11 = new ItemRecordBase("kirkus_killer", WeeddingSounds.KIRKUS_KILLER).addInfo("Talking heads", "Psycho killer");

    public static final Item[] ITEMS = new Item[]{
            NGM, HEMP_SEED, HEMP_FOOD, HEMP_CALIK, HEMP_AXE, HS_LEGGS,
            HS_CHESTPLATE, HS_HEAD, HEMP_LEGGS, HEMP_CHESTPLATE, HEMP_BOOTS,
            HEMP_HEAD, HSD_HEAD, HSD_LEGGS, HSD_CHESTPLATE, HSD_BOOTS, WEEDDING_BOOK, RECORD1, RECORD2,
            RECORD3, RECORD4, RECORD5, RECORD6, RECORD7, RECORD8, RECORD9, RECORD10, RECORD11, DAFUK_ICON, WEEDDING_BOOK2, EXOSKELETON_HEAD, EXOSKELETON_LEGGS, EXOSKELETON_CHESTPLATE
    };
}
