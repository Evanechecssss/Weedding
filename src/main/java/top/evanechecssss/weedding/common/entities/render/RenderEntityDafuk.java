package top.evanechecssss.weedding.common.entities.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import top.evanechecssss.weedding.common.entities.EntityDafuk;

@SideOnly(Side.CLIENT)
public class RenderEntityDafuk extends RenderLiving<EntityDafuk> {

    public ResourceLocation resourceLocation;

    public RenderEntityDafuk(RenderManager manager, ModelBase model, float shadow, ResourceLocation resourceLocation) {
        super(manager, model, shadow);
        this.resourceLocation = resourceLocation;
    }

    @Override
    public boolean shouldRender(EntityDafuk livingEntity, ICamera camera, double camX, double camY, double camZ) {
        return true;
    }

    @Override
    protected void preRenderCallback(EntityDafuk entitylivingbaseIn, float partialTickTime) {
        super.preRenderCallback(entitylivingbaseIn, partialTickTime);
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
