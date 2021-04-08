package com.evanko.likewise.api;


import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.util.EnumHelper;

public class Materials {
    public static class ToolMaterials {
        public static final Item.ToolMaterial ZINC_METAL = EnumHelper.addToolMaterial("zinc_metal ", 5, 250, 15F, 12.3F, 20).setRepairItem(new ItemStack(Blocks.IRON_BLOCK));
    }

    public static class ArmorMaterials {
        public static final ItemArmor.ArmorMaterial HEMP = EnumHelper.addArmorMaterial("hemp", "likewise:hemp", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.BLOCK_GRASS_BREAK, 0.0F);

    }

    public static class Rarity {
        public static final EnumRarity FORBIDDEN = EnumHelper.addRarity("forbidden", TextFormatting.GRAY, "Forbidden");
        public static final EnumRarity TOXIC = EnumHelper.addRarity("toxic", TextFormatting.DARK_GREEN, "Toxic");
    }
}
