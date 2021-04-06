package com.evanko.likewise.proxy;

import com.evanko.likewise.registry.BlockRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy{
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
    }
    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
        BlockRegister.renderBlock();
    }
    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
    }
}
