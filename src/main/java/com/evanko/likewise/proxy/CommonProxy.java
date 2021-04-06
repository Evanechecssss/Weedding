package com.evanko.likewise.proxy;

import com.evanko.likewise.gen.LikewiseWorldGen;
import com.evanko.likewise.registry.BlockRegister;
import com.evanko.likewise.tileentity.Box_TE;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod.EventBusSubscriber
public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event){
        BlockRegister.registerBlock();
        GameRegistry.registerWorldGenerator(new LikewiseWorldGen(), 3);
    }
    public void init(FMLInitializationEvent event){
    }
    public void postInit(FMLPostInitializationEvent event){
    }
}
