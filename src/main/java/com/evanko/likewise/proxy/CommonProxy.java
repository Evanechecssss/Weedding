package com.evanko.likewise.proxy;

import com.evanko.likewise.gen.LikewiseWorldGen;
import com.evanko.likewise.init.LikewiseBlocks;
import com.evanko.likewise.items.meta.HoakahEmptyItem;
import com.evanko.likewise.registry.BlockRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod.EventBusSubscriber
public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {
        BlockRegister.registerBlock();
        GameRegistry.registerWorldGenerator(new LikewiseWorldGen(), 3);
        ForgeRegistries.BLOCKS.register(LikewiseBlocks.HOOKAH_EMPTY);
        ForgeRegistries.ITEMS.register(new HoakahEmptyItem(LikewiseBlocks.HOOKAH_EMPTY, true).setRegistryName(LikewiseBlocks.HOOKAH_EMPTY.getRegistryName()));
    }
    public void init(FMLInitializationEvent event){
    }
    public void postInit(FMLPostInitializationEvent event){
    }
}
