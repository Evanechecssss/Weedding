package top.evanechecssss.weedding.network.proxy;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import top.evanechecssss.weedding.Weedding;
import top.evanechecssss.weedding.api.WeeddingPsychoSelector;
import top.evanechecssss.weedding.init.WeeddingEntity;
import top.evanechecssss.weedding.init.WeeddingGUIs;
import top.evanechecssss.weedding.init.WeeddingSounds;
import top.evanechecssss.weedding.utils.registry.BlockRegister;
import top.evanechecssss.weedding.world.gen.WeeddingWorldGen;
import top.evanechecssss.weedding.world.spawn.EntitySpawner;

@Mod.EventBusSubscriber
public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
        BlockRegister.registerBlock();
        GameRegistry.registerWorldGenerator(new WeeddingWorldGen(), 3);
        WeeddingEntity.EntityRenderRegister.RegisterEntityRender();
        WeeddingEntity.RegisterEntities();
        EntitySpawner.spawnEntities();
        GameRegistry.registerEntitySelector(new WeeddingPsychoSelector(), WeeddingPsychoSelector.ARGUMENT_WEEDDING_PSYCHO);
        MinecraftForge.EVENT_BUS.register(new WeeddingSounds.SoundRegistry());
    }
    public void init(FMLInitializationEvent event) {
        NetworkRegistry.INSTANCE.registerGuiHandler(Weedding.instance, new WeeddingGUIs.GUIHandler());
    }
    public void postInit(FMLPostInitializationEvent event){
    }
}
