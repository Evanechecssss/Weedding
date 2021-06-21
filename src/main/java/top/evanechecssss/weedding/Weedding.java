package top.evanechecssss.weedding;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import top.evanechecssss.weedding.init.WeeddingInfo;
import org.apache.logging.log4j.Logger;
import top.evanechecssss.weedding.network.proxy.CommonProxy;

@Mod(modid = WeeddingInfo.MODID, name = WeeddingInfo.NAME, version = WeeddingInfo.VERSION, acceptedMinecraftVersions = "[1.12]", updateJSON = "https://github.com/Evanechecssss/weeddingMod/blob/main/production/weeddingMod.main/mcmod.info")
public class Weedding {
    @SidedProxy(clientSide = "top.evanechecssss.weedding.network.proxy.ClientProxy", serverSide = "top.evanechecssss.weedding.network.proxy.CommonProxy")
    public static CommonProxy proxy;
    public static Logger logger;
    @Mod.Instance(WeeddingInfo.MODID)
    public static Weedding instance;
    public static final SimpleNetworkWrapper NETWORK = NetworkRegistry.INSTANCE.newSimpleChannel("weedding");
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);
        logger.info("!Mod preInitialization :" + WeeddingInfo.NAME);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
        logger.info("!Mod initialization :" + WeeddingInfo.NAME);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
        logger.info("!Mod postInitialization :" + WeeddingInfo.NAME);
    }
}
