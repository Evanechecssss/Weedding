package com.evanko.likewise.registry;

import com.evanko.likewise.init.LikewiseBlocks;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber
public class BlockRegister {
    public static void registerBlock() {
        setRegister(LikewiseBlocks.BLOCKS);
    }

    public static void setRegister(Block[] block) {
        for (int i = 0; i < block.length; i++) {
            ForgeRegistries.BLOCKS.register(block[i]);
            ForgeRegistries.ITEMS.register(new ItemBlock(block[i]).setRegistryName(block[i].getRegistryName()));
        }
    }

    @SideOnly(Side.CLIENT)
    public static void renderBlock() {
        setRender(LikewiseBlocks.BLOCKS);
    }

    @SideOnly(Side.CLIENT)
    public static void setRender(Block[] block) {
        for (int i = 0; i < block.length; i++) {
            Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block[i]), 0, new ModelResourceLocation(block[i].getRegistryName(), "inventory"));
        }
    }
}
