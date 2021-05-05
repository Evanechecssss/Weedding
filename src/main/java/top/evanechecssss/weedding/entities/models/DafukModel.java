package top.evanechecssss.weedding.entities.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import top.evanechecssss.weedding.entities.EntityDafuk;

public class DafukModel extends ModelBase {
    private final ModelRenderer body;
    private final ModelRenderer head;
    private final ModelRenderer leg0;
    private final ModelRenderer leg1;
    private final ModelRenderer leg2;
    private final ModelRenderer leg3;
    private final ModelRenderer bone;
    private final ModelRenderer cube_r1;
    private final ModelRenderer cube_r2;
    private final ModelRenderer bone2;
    private final ModelRenderer body2_r1;

    public DafukModel() {
        textureWidth = 128;
        textureHeight = 128;

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 5.0F, 2.0F);
        setRotationAngle(body, 1.5708F, 0.0F, 0.0F);
        body.cubeList.add(new ModelBox(body, 0, 32, -4.0F, -10.0F, -7.0F, 8, 16, 6, 1.75F, false));

        leg0 = new ModelRenderer(this);
        leg0.setRotationPoint(-3.0F, 12.0F, 7.0F);
        leg0.cubeList.add(new ModelBox(leg0, 46, 62, -2.0F, 0.0F, -3.0F, 4, 12, 4, 0.0F, false));
        leg0.cubeList.add(new ModelBox(leg0, 0, 70, -2.0F, 0.0F, -3.0F, 4, 6, 4, 0.5F, false));
        leg1 = new ModelRenderer(this);
        leg1.setRotationPoint(3.0F, 12.0F, 7.0F);
        leg1.cubeList.add(new ModelBox(leg1, 59, 29, -2.0F, 0.0F, -3.0F, 4, 12, 4, 0.0F, false));
        leg1.cubeList.add(new ModelBox(leg1, 66, 0, -2.0F, 0.0F, -3.0F, 4, 6, 4, 0.5F, false));
        leg2 = new ModelRenderer(this);
        leg2.setRotationPoint(-3.0F, 12.0F, -5.0F);
        leg2.cubeList.add(new ModelBox(leg2, 59, 12, -2.0F, 0.0F, -4.0F, 4, 12, 4, 0.0F, false));
        leg2.cubeList.add(new ModelBox(leg2, 63, 62, -2.0F, 0.0F, -4.0F, 4, 6, 4, 0.5F, false));
        leg3 = new ModelRenderer(this);
        leg3.setRotationPoint(3.0F, 12.0F, -5.0F);
        leg3.cubeList.add(new ModelBox(leg3, 29, 55, -2.0F, 0.0F, -4.0F, 4, 12, 4, 0.0F, false));
        leg3.cubeList.add(new ModelBox(leg3, 49, 0, -2.0F, 0.0F, -4.0F, 4, 6, 4, 0.5F, false));
        bone = new ModelRenderer(this);
        bone.setRotationPoint(0.0F, 24.0F, 0.0F);
        bone.cubeList.add(new ModelBox(bone, 0, 0, 4.0F, -20.25F, -7.0F, 17, 1, 14, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 0, 16, -21.0F, -20.25F, -7.0F, 17, 1, 14, 0.0F, false));
        cube_r1 = new ModelRenderer(this);
        cube_r1.setRotationPoint(-0.163F, -0.1212F, 0.0F);
        bone.addChild(cube_r1);
        setRotationAngle(cube_r1, 0.0F, 0.0F, 0.1309F);
        cube_r1.cubeList.add(new ModelBox(cube_r1, 0, 80, 1.5F, -20.5F, -7.0F, 17, 1, 14, 0.0F, false));
        cube_r2 = new ModelRenderer(this);
        cube_r2.setRotationPoint(0.6587F, -0.1864F, 0.0F);
        bone.addChild(cube_r2);
        setRotationAngle(cube_r2, 0.0F, 0.0F, -0.1309F);
        cube_r2.cubeList.add(new ModelBox(cube_r2, 0, 95, -19.0F, -20.5F, -7.0F, 17, 1, 14, 0.0F, false));
        bone2 = new ModelRenderer(this);
        bone2.setRotationPoint(0.0F, -6.0F, 23.0F);
        setRotationAngle(bone2, 1.5272F, 0.0F, 0.0F);
        body2_r1 = new ModelRenderer(this);
        body2_r1.setRotationPoint(0.0F, -35.0F, -4.0F);
        bone2.addChild(body2_r1);
        setRotationAngle(body2_r1, 0.0873F, 0.0F, 0.0F);
        body2_r1.cubeList.add(new ModelBox(cube_r2, 93, 29, -3.0F, -9.0F, -3.25F, 5, 12, 4, 1.75F, false));
        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 6.0F, -8.0F);
        head.cubeList.add(new ModelBox(head, 0, 55, -3.0F, -4.0F, -15.0F, 6, 6, 8, 0.0F, false));
        head.cubeList.add(new ModelBox(head, 50, 47, -3.0F, -4.0F, -8.0F, 6, 6, 8, 0.6F, false));
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        EntityDafuk dafuk = (EntityDafuk) entity;
        if (dafuk.isChild()) {
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0F, 12.0F * f5, 0);
            GlStateManager.scale(0.5F, 0.5F, 0.5F);
            body.render(f5);
            head.render(f5);
            leg0.render(f5);
            leg1.render(f5);
            leg2.render(f5);
            leg3.render(f5);
            bone.render(f5);
            if (dafuk.isChest()) {
                bone2.render(f5);
            }
            GlStateManager.popMatrix();
        } else {
            body.render(f5);
            head.render(f5);
            leg0.render(f5);
            leg1.render(f5);
            leg2.render(f5);
            leg3.render(f5);
            bone.render(f5);
            if (dafuk.isChest()) {
                bone2.render(f5);
            }
        }

    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.head.rotateAngleX = headPitch * 0.017453292F;
        this.head.rotateAngleY = netHeadYaw * 0.017453292F;
        this.body.rotateAngleX = ((float) Math.PI / 2F);
        this.leg0.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
        this.leg2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
        this.leg3.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}