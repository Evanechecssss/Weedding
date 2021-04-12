package top.evanechecssss.weedding.utils.registry;

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
import top.evanechecssss.weedding.common.blocks.types.HookahEmptyTypes;
import top.evanechecssss.weedding.init.WeeddingBlocks;

@Mod.EventBusSubscriber
public class BlockRegister {
    public static void registerBlock() {
        setRegister(WeeddingBlocks.BLOCKS);
        setRegisterSubBlocks();
    }

    public static void setRegister(Block[] block) {
        for (int i = 0; i < block.length; i++) {
            ForgeRegistries.BLOCKS.register(block[i]);
            ForgeRegistries.ITEMS.register(new ItemBlock(block[i]).setRegistryName(block[i].getRegistryName()));
        }
    }

    public static void setRegisterSubBlocks() {
        ForgeRegistries.BLOCKS.register(WeeddingBlocks.HOOKAH_EMPTY);
        ForgeRegistries.ITEMS.register(new ItemColored(WeeddingBlocks.HOOKAH_EMPTY, true).setRegistryName(WeeddingBlocks.HOOKAH_EMPTY.getRegistryName()));
    }

    @SideOnly(Side.CLIENT)
    public static void renderBlock() {
        setRender(WeeddingBlocks.BLOCKS);
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
        Item hookah = Item.getItemFromBlock(WeeddingBlocks.HOOKAH_EMPTY);
        for (HookahEmptyTypes color : HookahEmptyTypes.values()) {
            ModelResourceLocation location = new ModelResourceLocation(WeeddingBlocks.HOOKAH_EMPTY.getRegistryName(), "color=" + color.getName().toLowerCase());
            Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(hookah, color.ordinal(), location);
        }
    }
}