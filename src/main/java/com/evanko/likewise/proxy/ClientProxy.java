package com.evanko.likewise.proxy;

import com.evanko.likewise.blocks.HookahEmptyTypes;
import com.evanko.likewise.init.LikewiseBlocks;
import com.evanko.likewise.registry.BlockRegister;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
        BlockRegister.renderBlock();
        Item green = Item.getItemFromBlock(LikewiseBlocks.HOOKAH_EMPTY);
        for (HookahEmptyTypes color : HookahEmptyTypes.values()) {
            ModelResourceLocation location = new ModelResourceLocation(LikewiseBlocks.HOOKAH_EMPTY.getRegistryName(), "color=" + color.name);
            Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(green, color.ordinal(), location);
        }
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
    }
}
