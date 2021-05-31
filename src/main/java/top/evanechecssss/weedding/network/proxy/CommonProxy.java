package top.evanechecssss.weedding.network.proxy;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import top.evanechecssss.weedding.Weedding;
import top.evanechecssss.weedding.common.blocks.GramophoneIron;
import top.evanechecssss.weedding.handlers.WeeddingEventHandler;
import top.evanechecssss.weedding.init.WeeddingEntity;
import top.evanechecssss.weedding.init.WeeddingGUIs;
import top.evanechecssss.weedding.init.WeeddingSounds;
import top.evanechecssss.weedding.network.packets.OpenMenuExecution;
import top.evanechecssss.weedding.utils.registry.BlockRegister;
import top.evanechecssss.weedding.world.gen.WeeddingWorldGen;
import top.evanechecssss.weedding.world.spawn.EntitySpawner;


@Mod.EventBusSubscriber
public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new WeeddingEventHandler());
        BlockRegister.registerBlock();
        GameRegistry.registerWorldGenerator(new WeeddingWorldGen(), 3);
        WeeddingEntity.RegisterEntities();
        EntitySpawner.spawnEntities();
        MinecraftForge.EVENT_BUS.register(new WeeddingSounds.SoundRegistry());
        Weedding.NETWORK.registerMessage(OpenMenuExecution.OpenMenuMessageHandler.class, OpenMenuExecution.OpenMenuMessage.class, 0, Side.SERVER);
        Weedding.NETWORK.registerMessage(GramophoneIron.GramophoneMessageHandler.class, GramophoneIron.GramophoneMessage.class, 1, Side.CLIENT);
    }
    public void init(FMLInitializationEvent event) {
        NetworkRegistry.INSTANCE.registerGuiHandler(Weedding.instance, new WeeddingGUIs.GUIHandler());
    }
    public void postInit(FMLPostInitializationEvent event){
    }
}
