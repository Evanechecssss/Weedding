package top.evanechecssss.weedding.network.proxy;

import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import top.evanechecssss.weedding.common.blocks.GramophoneIron;
import top.evanechecssss.weedding.init.WeeddingEntity;
import top.evanechecssss.weedding.init.WeeddingKeybinds;
import top.evanechecssss.weedding.handlers.registry.BlockRegister;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        WeeddingKeybinds.KeybindsRegister.register();
        super.preInit(event);
        WeeddingEntity.EntityRenderRegister.RegisterEntityRender();
    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
        BlockRegister.renderBlock();
        ClientRegistry.bindTileEntitySpecialRenderer(GramophoneIron.GramophoneTE.class, new GramophoneIron.GramophoneTERender());
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
    }
}
