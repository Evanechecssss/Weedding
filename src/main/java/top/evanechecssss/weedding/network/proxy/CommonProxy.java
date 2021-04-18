package top.evanechecssss.weedding.network.proxy;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import top.evanechecssss.weedding.Weedding;
import top.evanechecssss.weedding.network.capability.handler.AddictionController;
import top.evanechecssss.weedding.network.capability.handler.AddictionHandler;
import top.evanechecssss.weedding.network.capability.interfaces.IAddiction;
import top.evanechecssss.weedding.network.capability.main.Addiction;
import top.evanechecssss.weedding.network.capability.storage.AddictionStorage;
import top.evanechecssss.weedding.network.handlers.GUIHandler;
import top.evanechecssss.weedding.network.packets.AddictionMessage;
import top.evanechecssss.weedding.network.packets.WeeddingPacketHandler;
import top.evanechecssss.weedding.utils.registry.BlockRegister;
import top.evanechecssss.weedding.world.gen.WeeddingWorldGen;

@Mod.EventBusSubscriber
public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
        BlockRegister.registerBlock();
        GameRegistry.registerWorldGenerator(new WeeddingWorldGen(), 3);
        CapabilityManager.INSTANCE.register(IAddiction.class, new AddictionStorage(), Addiction.class);
        WeeddingPacketHandler.INSTANCE.registerMessage(AddictionMessage.AddictionMessageHandler.class, AddictionMessage.class, 0, Side.CLIENT);
    }
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new AddictionHandler());
        MinecraftForge.EVENT_BUS.register(new AddictionController());
        NetworkRegistry.INSTANCE.registerGuiHandler(Weedding.instance, new GUIHandler());

    }
    public void postInit(FMLPostInitializationEvent event){
    }
}
