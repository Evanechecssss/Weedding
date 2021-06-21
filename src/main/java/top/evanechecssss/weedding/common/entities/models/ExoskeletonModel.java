package top.evanechecssss.weedding.common.entities.models;// Made with Blockbench 3.8.4
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports


import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;

public class ExoskeletonModel extends ModelBiped {
    private final ModelRenderer Head;
    private final ModelRenderer Body;
    private final ModelRenderer RightArm;
    private final ModelRenderer LeftArm;
    private final ModelRenderer RightLeg;
    private final ModelRenderer LeftLeg;
    private final ModelRenderer wing;
    private final ModelRenderer bone;
    private final ModelRenderer bone3;
    private final ModelRenderer cube_r1;
    private final ModelRenderer bone4;
    private final ModelRenderer cube_r2;
    private final ModelRenderer cube_r3;
    private final ModelRenderer cube_r4;
    private final ModelRenderer cube_r5;
    private final ModelRenderer cube_r6;
    private final ModelRenderer wing2;
    private final ModelRenderer bone2;
    private final ModelRenderer bone5;
    private final ModelRenderer cube_r7;
    private final ModelRenderer bone6;
    private final ModelRenderer cube_r8;
    private final ModelRenderer cube_r9;
    private final ModelRenderer cube_r10;
    private final ModelRenderer cube_r11;
    private final ModelRenderer cube_r12;

    public ExoskeletonModel(int type) {
        textureWidth = 128;
        textureHeight = 128;

       Head = new ModelRenderer(this);
       Head.cubeList.add(new ModelBox(Head, 32, 32, -4.0F, -8.0F, -4.0F, 8, 8, 8, 0.5F, false));
       Head.cubeList.add(new ModelBox(Head, 64, 30, -4.0F, -8.0F, -4.0F, 8, 8, 8, 1F, false));

        Body = new ModelRenderer(this);
        Body.setRotationPoint(0.0F, 0.0F, 0.0F);
        Body.cubeList.add(new ModelBox(Body, 48, 48, -4.0F, 0.0F, -2.0F, 8, 12, 4, 0.25F, false));
        Body.cubeList.add(new ModelBox(Body, 48, 64, -4.0F, 0.0F, -2.0F, 8, 12, 4, 0.5F, false));

        RightArm = new ModelRenderer(this);
        RightArm.cubeList.add(new ModelBox(RightArm, 72, 48, -3.0F, -2.0F, -2.0F, 4, 12, 4, 0.25F, false));
        RightArm.cubeList.add(new ModelBox(RightArm, 72, 64, -3.0F, -2.0F, -2.0F, 4, 12, 4, 0.5F, false));

        LeftArm = new ModelRenderer(this);
        LeftArm.cubeList.add(new ModelBox(LeftArm, 64, 80, -1.0F, -2.0F, -2.0F, 4, 12, 4, 0.25F, false));
        LeftArm.cubeList.add(new ModelBox(LeftArm, 80, 80, -1.0F, -2.0F, -2.0F, 4, 12, 4, 0.5F, false));

        RightLeg = new ModelRenderer(this);
        RightLeg.cubeList.add(new ModelBox(RightLeg, 32, 48, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.25F, false));
        RightLeg.cubeList.add(new ModelBox(RightLeg, 32, 64, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.5F, false));

        LeftLeg = new ModelRenderer(this);
        LeftLeg.cubeList.add(new ModelBox(LeftLeg, 48, 80, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.25F, false));
        LeftLeg.cubeList.add(new ModelBox(LeftLeg, 32, 80, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.5F, false));

        wing = new ModelRenderer(this);
        wing.setRotationPoint(0.0F, 26.0F, 0.0F);


        bone = new ModelRenderer(this);
        bone.setRotationPoint(0.0F, 0.0F, 0.0F);
        wing.addChild(bone);
        setRotationAngle(bone, 0.0F, 0.0F, 0.0873F);
        bone.cubeList.add(new ModelBox(bone, 24, 0, -14.0F, -24.0F, 2.0F, 10, 8, 1, 0.0F, false));

        bone3 = new ModelRenderer(this);
        bone3.setRotationPoint(0.0F, 0.0F, 0.0F);
        wing.addChild(bone3);
        setRotationAngle(bone3, 0.0F, 0.0F, 0.3927F);
        bone3.cubeList.add(new ModelBox(bone3, 24, 0, -26.0F, -20.0F, 2.0F, 10, 8, 1, 0.0F, false));

        cube_r1 = new ModelRenderer(this);
        cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
        bone3.addChild(cube_r1);
        setRotationAngle(cube_r1, 0.0F, 0.0F, 0.2618F);
        cube_r1.cubeList.add(new ModelBox(cube_r1, 24, 0, -35.0F, -15.0F, 2.0F, 10, 8, 1, 0.0F, false));

        bone4 = new ModelRenderer(this);
        bone4.setRotationPoint(4.0F, 0.0F, 0.5F);
        wing.addChild(bone4);
        setRotationAngle(bone4, 0.0F, 0.0F, 0.1309F);
        bone4.cubeList.add(new ModelBox(bone4, 24, 0, -26.0F, -20.0F, 2.0F, 10, 8, 1, 0.0F, false));
        bone4.cubeList.add(new ModelBox(bone4, 24, 0, -26.25F, -17.25F, 2.5F, 10, 6, 1, 0.0F, false));

        cube_r2 = new ModelRenderer(this);
        cube_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
        bone4.addChild(cube_r2);
        setRotationAngle(cube_r2, 0.0F, 0.0F, 0.829F);
        cube_r2.cubeList.add(new ModelBox(cube_r2, 24, 0, -45.0F, -1.0F, 2.0F, 10, 8, 1, 0.0F, false));

        cube_r3 = new ModelRenderer(this);
        cube_r3.setRotationPoint(-0.25F, 2.75F, 0.5F);
        bone4.addChild(cube_r3);
        setRotationAngle(cube_r3, 0.0F, 0.0F, 0.3927F);
        cube_r3.cubeList.add(new ModelBox(cube_r3, 24, 0, -39.0F, -14.0F, 2.0F, 10, 6, 1, 0.0F, false));

        cube_r4 = new ModelRenderer(this);
        cube_r4.setRotationPoint(0.0F, 0.0F, 0.0F);
        bone4.addChild(cube_r4);
        setRotationAngle(cube_r4, 0.0F, 0.0F, 0.3927F);
        cube_r4.cubeList.add(new ModelBox(cube_r4, 24, 0, -39.0F, -14.0F, 2.0F, 10, 8, 1, 0.0F, false));

        cube_r5 = new ModelRenderer(this);
        cube_r5.setRotationPoint(-0.25F, 2.75F, 0.5F);
        bone4.addChild(cube_r5);
        setRotationAngle(cube_r5, 0.0F, 0.0F, 0.2618F);
        cube_r5.cubeList.add(new ModelBox(cube_r5, 24, 0, -35.0F, -15.0F, 2.0F, 10, 6, 1, 0.0F, false));

        cube_r6 = new ModelRenderer(this);
        cube_r6.setRotationPoint(0.0F, 0.0F, 0.0F);
        bone4.addChild(cube_r6);
        setRotationAngle(cube_r6, 0.0F, 0.0F, 0.2618F);
        cube_r6.cubeList.add(new ModelBox(cube_r6, 24, 0, -35.0F, -15.0F, 2.0F, 10, 8, 1, 0.0F, false));

        wing2 = new ModelRenderer(this);
        wing2.setRotationPoint(0.0F, 24.0F, 0.0F);


        bone2 = new ModelRenderer(this);
        bone2.setRotationPoint(0.0F, 2.0F, 0.0F);
        wing2.addChild(bone2);
        setRotationAngle(bone2, 0.0F, 0.0F, -0.0873F);
        bone2.cubeList.add(new ModelBox(bone2, 46, 0, 4.0F, -24.0F, 2.0F, 10, 8, 1, 0.0F, true));

        bone5 = new ModelRenderer(this);
        bone5.setRotationPoint(0.0F, 2.0F, 0.0F);
        wing2.addChild(bone5);
        setRotationAngle(bone5, 0.0F, 0.0F, -0.3927F);
        bone5.cubeList.add(new ModelBox(bone5, 46, 0, 16.0F, -20.0F, 2.0F, 10, 8, 1, 0.0F, true));

        cube_r7 = new ModelRenderer(this);
        cube_r7.setRotationPoint(0.0F, 0.0F, 0.0F);
        bone5.addChild(cube_r7);
        setRotationAngle(cube_r7, 0.0F, 0.0F, -0.2618F);
        cube_r7.cubeList.add(new ModelBox(cube_r7, 46, 0, 25.0F, -15.0F, 2.0F, 10, 8, 1, 0.0F, true));

        bone6 = new ModelRenderer(this);
        bone6.setRotationPoint(-4.0F, 2.0F, 0.5F);
        wing2.addChild(bone6);
        setRotationAngle(bone6, 0.0F, 0.0F, -0.1309F);
        bone6.cubeList.add(new ModelBox(bone6, 46, 0, 16.0F, -20.0F, 2.0F, 10, 8, 1, 0.0F, true));
        bone6.cubeList.add(new ModelBox(bone6, 46, 0, 16.25F, -17.25F, 2.5F, 10, 6, 1, 0.0F, true));

        cube_r8 = new ModelRenderer(this);
        cube_r8.setRotationPoint(0.0F, 0.0F, 0.0F);
        bone6.addChild(cube_r8);
        setRotationAngle(cube_r8, 0.0F, 0.0F, -0.829F);
        cube_r8.cubeList.add(new ModelBox(cube_r8, 46, 0, 35.0F, -1.0F, 2.0F, 10, 8, 1, 0.0F, true));

        cube_r9 = new ModelRenderer(this);
        cube_r9.setRotationPoint(0.25F, 2.75F, 0.5F);
        bone6.addChild(cube_r9);
        setRotationAngle(cube_r9, 0.0F, 0.0F, -0.3927F);
        cube_r9.cubeList.add(new ModelBox(cube_r9, 46, 0, 29.0F, -14.0F, 2.0F, 10, 6, 1, 0.0F, true));

        cube_r10 = new ModelRenderer(this);
        cube_r10.setRotationPoint(0.0F, 0.0F, 0.0F);
        bone6.addChild(cube_r10);
        setRotationAngle(cube_r10, 0.0F, 0.0F, -0.3927F);
        cube_r10.cubeList.add(new ModelBox(cube_r10, 46, 0, 29.0F, -14.0F, 2.0F, 10, 8, 1, 0.0F, true));

        cube_r11 = new ModelRenderer(this);
        cube_r11.setRotationPoint(0.25F, 2.75F, 0.5F);
        bone6.addChild(cube_r11);
        setRotationAngle(cube_r11, 0.0F, 0.0F, -0.2618F);
        cube_r11.cubeList.add(new ModelBox(cube_r11, 46, 0, 25.0F, -15.0F, 2.0F, 10, 6, 1, 0.0F, true));

        cube_r12 = new ModelRenderer(this);
        cube_r12.setRotationPoint(0.0F, 0.0F, 0.0F);
        bone6.addChild(cube_r12);
        setRotationAngle(cube_r12, 0.0F, 0.0F, -0.2618F);
        cube_r12.cubeList.add(new ModelBox(cube_r12, 46, 0, 25.0F, -15.0F, 2.0F, 10, 8, 1, 0.0F, true));

        this.bipedHead.cubeList.clear();
        this.bipedHeadwear.cubeList.clear();
        this.bipedBody.cubeList.clear();
        this.bipedLeftArm.cubeList.clear();
        this.bipedRightArm.cubeList.clear();
        this.bipedLeftLeg.cubeList.clear();
        this.bipedRightLeg.cubeList.clear();

        switch (type) {
            case 0:
                this.bipedHead.addChild(Head);

                break;
            case 1:
                this.bipedBody.addChild(Body);
                this.bipedBody.addChild(wing);
                this.bipedBody.addChild(wing2);
                this.bipedLeftArm.addChild(LeftArm);
                this.bipedRightArm.addChild(RightArm);
                break;
            case 2:
                this.bipedRightLeg.addChild(RightLeg);
                this.bipedLeftLeg.addChild(LeftLeg);
                break;
        }

    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240, 240);
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }


    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}