package top.evanechecssss.weedding.init;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import top.evanechecssss.weedding.Weedding;
import top.evanechecssss.weedding.entity.EntityDafuk;
import top.evanechecssss.weedding.entity.models.DafukModel;
import top.evanechecssss.weedding.utils.reference.WeeddingInfo;
import top.evanechecssss.weedding.utils.registry.RenderEntityBase;

public class WeeddingEntity {
    public static void RegisterEntities() {
        registerEntity("dafuk", EntityDafuk.class, "dafuk", EntityList.DAFUK, 20, 0xA8A8A8, 0xFFCD9B);
    }

    private static void registerEntity(String name, Class<? extends Entity> entity, String entityName, int id, int trackingRange, int eggColor1, int eggColor2) {
        EntityRegistry.registerModEntity(new ResourceLocation(WeeddingInfo.MODID, name), entity, entityName, id, Weedding.instance, trackingRange, 1, true, eggColor1, eggColor2);
    }

    public static class EntityList {
        public static final int DAFUK = 0;

    }

    public static class EntityRegister {
        public static void RegisterEntityRender() {
            RegisterDafukRender();
        }

        private static void RegisterDafukRender() {
            RenderingRegistry.registerEntityRenderingHandler(EntityDafuk.class, renderManager -> new RenderEntityBase(renderManager, new DafukModel(), 0.5f, new ResourceLocation(WeeddingInfo.MODID, "textures/entity/dafuk.png")));
        }
    }
}
