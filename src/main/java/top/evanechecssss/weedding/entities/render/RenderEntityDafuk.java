package top.evanechecssss.weedding.entities.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import top.evanechecssss.weedding.entities.EntityDafuk;

public class RenderEntityDafuk extends RenderLiving<EntityDafuk> {

    public ResourceLocation resourceLocation;

    public RenderEntityDafuk(RenderManager manager, ModelBase model, float shadow, ResourceLocation resourceLocation) {
        super(manager, model, shadow);
        this.resourceLocation = resourceLocation;
    }


    @Override
    protected ResourceLocation getEntityTexture(EntityDafuk entity) {
        return resourceLocation;
    }

    @Override
    protected void applyRotations(EntityDafuk entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }

}
