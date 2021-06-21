package top.evanechecssss.weedding.handlers.registry;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemColored;
import net.minecraft.util.IStringSerializable;
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
        setRegisterSubBlocks(WeeddingBlocks.HOOKAH_EMPTY);
    }

    public static void setRegister(Block[] block) {
        for (Block value : block) {
            ForgeRegistries.BLOCKS.register(value);
            ForgeRegistries.ITEMS.register(new ItemBlock(value).setRegistryName(value.getRegistryName()));
        }
    }

    public static void setRegisterSubBlocks(Block block) {
        ForgeRegistries.BLOCKS.register(block);
        ForgeRegistries.ITEMS.register(new ItemColored(block, true).setRegistryName(block.getRegistryName()));
    }

    @SideOnly(Side.CLIENT)
    public static void renderBlock() {
        setRender(WeeddingBlocks.BLOCKS);
        setRenderSubBlocs(HookahEmptyTypes.values(), WeeddingBlocks.HOOKAH_EMPTY);
    }

    @SideOnly(Side.CLIENT)
    public static void setRender(Block[] block) {
        for (Block value : block) {
            Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(value), 0, new ModelResourceLocation(value.getRegistryName(), "inventory"));
        }
    }

    @SideOnly(Side.CLIENT)
    public static void setRenderSubBlocs(Enum<? extends IStringSerializable>[] _val, Block block) {
        Item item = Item.getItemFromBlock(block);
        for (Enum<? extends IStringSerializable> type : _val) {
            ModelResourceLocation location = new ModelResourceLocation(block.getRegistryName(), "color=" + ((IStringSerializable) type).getName());
            Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, type.ordinal(), location);
        }
    }
}