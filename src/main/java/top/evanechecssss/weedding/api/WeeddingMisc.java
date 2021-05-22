package top.evanechecssss.weedding.api;


import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.common.util.EnumHelper;
import top.evanechecssss.weedding.utils.reference.WeeddingInfo;

public class WeeddingMisc {
    public static class ToolMaterials {
        public static final Item.ToolMaterial ZINC_METAL = EnumHelper.addToolMaterial("zinc_metal ", 5, 250, 15F, 12.3F, 20).setRepairItem(new ItemStack(Blocks.IRON_BLOCK));
    }

    public static class ArmorMaterials {
        public static final ItemArmor.ArmorMaterial HEMP = EnumHelper.addArmorMaterial("hemp", "weedding:hemp", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.BLOCK_GRASS_BREAK, 0.0F);
        public static final ItemArmor.ArmorMaterial HOOKAH_SUITS = EnumHelper.addArmorMaterial("hookah_suit", "weedding:hookah_suit", 20, new int[]{1, 3, 5, 1}, 5, SoundEvents.BLOCK_NOTE_HAT, 0.1F);
        public static final ItemArmor.ArmorMaterial HOOKAH_SUIT_DISTRICT = EnumHelper.addArmorMaterial("hookah_suit_district", "weedding:hookah_suit_district", 20, new int[]{2, 4, 6, 2}, 5, SoundEvents.BLOCK_NOTE_HAT, 0.5F);
    }

    public static class Rarity {
        public static final EnumRarity FORBIDDEN = EnumHelper.addRarity("forbidden", TextFormatting.GRAY, "Forbidden");
        public static final EnumRarity DISK = EnumHelper.addRarity("disk", TextFormatting.LIGHT_PURPLE, "Disk");
        public static final EnumRarity TOXIC = EnumHelper.addRarity("toxic", TextFormatting.DARK_GREEN, "Toxic");
    }

    public static class LootTable {
        public static final ResourceLocation DAFUK_LOOT = LootTableList.register(new ResourceLocation(WeeddingInfo.MODID, "dafuk"));
    }
}
