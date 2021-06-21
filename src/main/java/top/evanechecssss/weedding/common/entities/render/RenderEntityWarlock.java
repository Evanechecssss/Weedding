package top.evanechecssss.weedding.common.entities.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import top.evanechecssss.weedding.common.entities.EntityWarlock;

@SideOnly(Side.CLIENT)
public class RenderEntityWarlock extends RenderLiving<EntityWarlock> {

    public ResourceLocation resourceLocation;

    public RenderEntityWarlock(RenderManager manager, ModelBase model, float shadow, ResourceLocation resourceLocation) {
        super(manager, model, shadow);
        this.resourceLocation = resourceLocation;
    }

    @Override
    public boolean shouldRender(EntityWarlock livingEntity, ICamera camera, double camX, double camY, double camZ) {
        return true;
    }


    @Override
    protected ResourceLocation getEntityTexture(EntityWarlock entity) {
        return resourceLocation;
    }

    @Override
    protected void applyRotations(EntityWarlock entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }


}
