package com.evanko.likewise.utils.registry;

import com.evanko.likewise.common.blocks.types.HookahEmptyTypes;
import com.evanko.likewise.init.LikewiseBlocks;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemColored;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber
public class BlockRegister {
    public static void registerBlock() {
        setRegister(LikewiseBlocks.BLOCKS);
        setRegisterSubBlocks();
    }

    public static void setRegister(Block[] block) {
        for (int i = 0; i < block.length; i++) {
            ForgeRegistries.BLOCKS.register(block[i]);
            ForgeRegistries.ITEMS.register(new ItemBlock(block[i]).setRegistryName(block[i].getRegistryName()));
        }
    }

    public static void setRegisterSubBlocks() {
        ForgeRegistries.BLOCKS.register(LikewiseBlocks.HOOKAH_EMPTY);
        ForgeRegistries.ITEMS.register(new ItemColored(LikewiseBlocks.HOOKAH_EMPTY, true).setRegistryName(LikewiseBlocks.HOOKAH_EMPTY.getRegistryName()));
    }

    @SideOnly(Side.CLIENT)
    public static void renderBlock() {
        setRender(LikewiseBlocks.BLOCKS);
        setRenderSubBlocs();
    }

    @SideOnly(Side.CLIENT)
    public static void setRender(Block[] block) {
        for (int i = 0; i < block.length; i++) {
            Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block[i]), 0, new ModelResourceLocation(block[i].getRegistryName(), "inventory"));
        }
    }

    @SideOnly(Side.CLIENT)
    public static void setRenderSubBlocs() {
        Item hookah = Item.getItemFromBlock(LikewiseBlocks.HOOKAH_EMPTY);
        for (HookahEmptyTypes color : HookahEmptyTypes.values()) {
            ModelResourceLocation location = new ModelResourceLocation(LikewiseBlocks.HOOKAH_EMPTY.getRegistryName(), "color=" + color.getName().toLowerCase());
            Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(hookah, color.ordinal(), location);
        }
    }
}