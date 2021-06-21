package top.evanechecssss.weedding.common.entities.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class WarlockModel extends ModelBase {
    private final ModelRenderer head;
    private final ModelRenderer eys2;
    private final ModelRenderer cube_r1;
    private final ModelRenderer cube_r2;
    private final ModelRenderer eys1;
    private final ModelRenderer cube_r3;
    private final ModelRenderer cube_r4;
    private final ModelRenderer eys;
    private final ModelRenderer cube_r5;
    private final ModelRenderer cube_r6;
    private final ModelRenderer tongue;
    private final ModelRenderer tongue1;
    private final ModelRenderer cube_r7;
    private final ModelRenderer cube_r8;
    private final ModelRenderer cube_r9;
    private final ModelRenderer cube_r10;
    private final ModelRenderer tongue2;
    private final ModelRenderer cube_r11;
    private final ModelRenderer cube_r12;
    private final ModelRenderer cube_r13;
    private final ModelRenderer cube_r14;
    private final ModelRenderer main;
    private final ModelRenderer cube_r15;
    private final ModelRenderer cube_r16;
    private final ModelRenderer bone;
    private final ModelRenderer teeth7;
    private final ModelRenderer teeth6;
    private final ModelRenderer teeth5;
    private final ModelRenderer teeth2;
    private final ModelRenderer teeth4;
    private final ModelRenderer teeth;
    private final ModelRenderer alex;
    private final ModelRenderer LeftLeg_r1;
    private final ModelRenderer RightLeg_r1;
    private final ModelRenderer LeftArm_r1;
    private final ModelRenderer RightArm_r1;
    private final ModelRenderer magik;
    private final ModelRenderer Head_r1;
    private final ModelRenderer Head_r2;
    private final ModelRenderer Head_r3;
    private final ModelRenderer Head_r4;
    private final ModelRenderer Head_r5;
    private final ModelRenderer Head_r6;
    private final ModelRenderer Head_r7;
    private final ModelRenderer Head_r8;
    private final ModelRenderer Head_r9;
    private final ModelRenderer Head_r10;
    private final ModelRenderer Head_r11;
    private final ModelRenderer Head_r12;
    private final ModelRenderer Head_r13;
    private final ModelRenderer Head_r14;
    private final ModelRenderer Head_r15;
    private final ModelRenderer Head_r16;
    private final ModelRenderer Head_r17;
    private final ModelRenderer Head_r18;
    private final ModelRenderer Head_r19;
    private final ModelRenderer Head_r20;
    private final ModelRenderer bb_main;

    public WarlockModel() {
        textureWidth = 256;
        textureHeight = 256;

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 24.0F, 0.0F);


        eys2 = new ModelRenderer(this);
        eys2.setRotationPoint(11.0F, -56.8894F, -22.1654F);
        head.addChild(eys2);
        setRotationAngle(eys2, 0.0F, 0.48F, 0.0F);


        cube_r1 = new ModelRenderer(this);
        cube_r1.setRotationPoint(-0.176F, 0.0F, -0.7348F);
        eys2.addChild(cube_r1);
        setRotationAngle(cube_r1, -0.1745F, 0.0F, 0.0F);
        cube_r1.cubeList.add(new ModelBox(cube_r1, 72, 53, -8.0F, -40.25F, 3.0F, 16, 16, 23, 0.0F, false));

        cube_r2 = new ModelRenderer(this);
        cube_r2.setRotationPoint(-16.176F, 0.2036F, -0.7238F);
        eys2.addChild(cube_r2);
        setRotationAngle(cube_r2, -0.5672F, 0.0F, 0.0F);
        cube_r2.cubeList.add(new ModelBox(cube_r2, 67, 93, 8.0F, -54.5F, -12.75F, 16, 16, 23, 0.0F, false));

        eys1 = new ModelRenderer(this);
        eys1.setRotationPoint(-8.0F, -56.8894F, -22.1654F);
        head.addChild(eys1);
        setRotationAngle(eys1, 0.0F, -0.48F, 0.0F);


        cube_r3 = new ModelRenderer(this);
        cube_r3.setRotationPoint(0.0F, 0.0F, 0.0F);
        eys1.addChild(cube_r3);
        setRotationAngle(cube_r3, -0.1745F, 0.0F, 0.0F);
        cube_r3.cubeList.add(new ModelBox(cube_r3, 123, 110, -8.0F, -40.25F, 3.0F, 16, 16, 23, 0.0F, false));

        cube_r4 = new ModelRenderer(this);
        cube_r4.setRotationPoint(-16.0F, 0.2036F, 0.011F);
        eys1.addChild(cube_r4);
        setRotationAngle(cube_r4, -0.5672F, 0.0F, 0.0F);
        cube_r4.cubeList.add(new ModelBox(cube_r4, 128, 70, 8.0F, -54.5F, -12.75F, 16, 16, 23, 0.0F, false));

        eys = new ModelRenderer(this);
        eys.setRotationPoint(0.0F, -56.8894F, -20.1654F);
        head.addChild(eys);


        cube_r5 = new ModelRenderer(this);
        cube_r5.setRotationPoint(-16.0F, 0.2036F, 0.011F);
        eys.addChild(cube_r5);
        setRotationAngle(cube_r5, -0.5672F, 0.0F, 0.0F);
        cube_r5.cubeList.add(new ModelBox(cube_r5, 0, 130, 8.0F, -54.5F, -12.75F, 16, 16, 23, 0.0F, false));

        cube_r6 = new ModelRenderer(this);
        cube_r6.setRotationPoint(0.0F, 0.0F, 0.0F);
        eys.addChild(cube_r6);
        setRotationAngle(cube_r6, -0.1745F, 0.0F, 0.0F);
        cube_r6.cubeList.add(new ModelBox(cube_r6, 140, 0, -8.0F, -40.25F, 3.0F, 16, 16, 23, 0.0F, false));

        tongue = new ModelRenderer(this);
        tongue.setRotationPoint(0.0F, -16.0F, 0.0F);
        head.addChild(tongue);


        tongue1 = new ModelRenderer(this);
        tongue1.setRotationPoint(0.0F, 2.8882F, -7.8516F);
        tongue.addChild(tongue1);
        setRotationAngle(tongue1, 0.6109F, 0.0F, 0.0F);


        cube_r7 = new ModelRenderer(this);
        cube_r7.setRotationPoint(0.0F, -0.0132F, -0.166F);
        tongue1.addChild(cube_r7);
        setRotationAngle(cube_r7, 0.3054F, 0.0F, 0.0F);
        cube_r7.cubeList.add(new ModelBox(cube_r7, 0, 62, -1.0F, -52.2077F, 21.5026F, 3, 1, 4, 0.0F, false));

        cube_r8 = new ModelRenderer(this);
        cube_r8.setRotationPoint(0.0F, 1.9085F, -7.2314F);
        tongue1.addChild(cube_r8);
        setRotationAngle(cube_r8, 0.3927F, 0.0F, 0.0F);
        cube_r8.cubeList.add(new ModelBox(cube_r8, 0, 62, -1.0F, -49.2066F, 29.2339F, 3, 1, 4, 0.0F, false));

        cube_r9 = new ModelRenderer(this);
        cube_r9.setRotationPoint(0.0F, 1.9188F, -7.1034F);
        tongue1.addChild(cube_r9);
        setRotationAngle(cube_r9, 0.5236F, 0.0F, 0.0F);
        cube_r9.cubeList.add(new ModelBox(cube_r9, 0, 62, -1.0F, -45.0428F, 31.3009F, 3, 1, 4, 0.0F, false));

        cube_r10 = new ModelRenderer(this);
        cube_r10.setRotationPoint(0.0F, -0.0516F, -0.2096F);
        tongue1.addChild(cube_r10);
        setRotationAngle(cube_r10, 0.1309F, 0.0F, 0.0F);
        cube_r10.cubeList.add(new ModelBox(cube_r10, 0, 62, -1.0F, -55.7993F, 16.0875F, 3, 1, 4, 0.0F, false));

        tongue2 = new ModelRenderer(this);
        tongue2.setRotationPoint(0.0F, -0.3618F, 7.1484F);
        tongue.addChild(tongue2);
        tongue2.cubeList.add(new ModelBox(tongue2, 0, 62, -1.0F, -56.6382F, -23.1484F, 3, 1, 4, 0.0F, false));

        cube_r11 = new ModelRenderer(this);
        cube_r11.setRotationPoint(0.0F, -56.0F, -20.0F);
        tongue2.addChild(cube_r11);
        setRotationAngle(cube_r11, 0.3054F, 0.0F, 0.0F);
        cube_r11.cubeList.add(new ModelBox(cube_r11, 0, 62, -1.0F, -2.25F, -10.75F, 3, 1, 4, 0.0F, false));

        cube_r12 = new ModelRenderer(this);
        cube_r12.setRotationPoint(0.0F, -54.0783F, -27.0654F);
        tongue2.addChild(cube_r12);
        setRotationAngle(cube_r12, 0.3927F, 0.0F, 0.0F);
        cube_r12.cubeList.add(new ModelBox(cube_r12, 0, 62, -1.0F, -2.25F, -7.25F, 3, 1, 4, 0.0F, false));

        cube_r13 = new ModelRenderer(this);
        cube_r13.setRotationPoint(0.0F, -56.0383F, -20.0435F);
        tongue2.addChild(cube_r13);
        setRotationAngle(cube_r13, 0.1309F, 0.0F, 0.0F);
        cube_r13.cubeList.add(new ModelBox(cube_r13, 0, 62, -1.0F, -1.0F, -7.0F, 3, 1, 4, 0.0F, false));

        cube_r14 = new ModelRenderer(this);
        cube_r14.setRotationPoint(0.0F, -54.068F, -26.9374F);
        tongue2.addChild(cube_r14);
        setRotationAngle(cube_r14, 0.5236F, 0.0F, 0.0F);
        cube_r14.cubeList.add(new ModelBox(cube_r14, 0, 62, -1.0F, -3.25F, -11.0F, 3, 1, 4, 0.0F, false));

        main = new ModelRenderer(this);
        main.setRotationPoint(0.0F, -56.0F, -20.0F);
        head.addChild(main);
        main.cubeList.add(new ModelBox(main, 0, 0, -15.0F, -24.25F, 7.0F, 30, 28, 16, 0.0F, false));
        main.cubeList.add(new ModelBox(main, 0, 45, -11.0F, -33.0058F, -15.2548F, 22, 5, 25, 0.0F, false));
        main.cubeList.add(new ModelBox(main, 0, 76, -8.0F, 3.75F, 9.5F, 17, 37, 16, 0.0F, false));

        cube_r15 = new ModelRenderer(this);
        cube_r15.setRotationPoint(0.0F, 0.0685F, -0.0531F);
        main.addChild(cube_r15);
        setRotationAngle(cube_r15, -0.2182F, 0.0F, 0.0F);
        cube_r15.cubeList.add(new ModelBox(cube_r15, 70, 20, -11.0F, -29.0F, -22.0F, 22, 5, 25, 0.0F, false));

        cube_r16 = new ModelRenderer(this);
        cube_r16.setRotationPoint(0.0F, 0.0685F, -0.0531F);
        main.addChild(cube_r16);
        setRotationAngle(cube_r16, 0.2182F, 0.0F, 0.0F);
        cube_r16.cubeList.add(new ModelBox(cube_r16, 143, 40, -8.0F, -9.0F, -11.0F, 16, 5, 22, 0.0F, false));

        bone = new ModelRenderer(this);
        bone.setRotationPoint(0.0F, 0.0F, 0.0F);
        head.addChild(bone);


        teeth7 = new ModelRenderer(this);
        teeth7.setRotationPoint(0.0F, -84.0F, -40.25F);
        bone.addChild(teeth7);
        setRotationAngle(teeth7, -0.3927F, 0.0F, 0.0F);
        teeth7.cubeList.add(new ModelBox(teeth7, 77, 0, 6.0F, -2.0F, 4.0F, 1, 5, 1, 0.0F, false));
        teeth7.cubeList.add(new ModelBox(teeth7, 77, 0, 6.0F, -2.0F, 6.0F, 1, 5, 1, 0.0F, false));
        teeth7.cubeList.add(new ModelBox(teeth7, 77, 0, 6.0F, -3.0F, 8.0F, 1, 5, 1, 0.0F, false));
        teeth7.cubeList.add(new ModelBox(teeth7, 77, 0, 6.0F, -3.0F, 10.0F, 1, 5, 1, 0.0F, false));
        teeth7.cubeList.add(new ModelBox(teeth7, 77, 0, 6.0F, -4.0F, 12.0F, 1, 5, 1, 0.0F, false));
        teeth7.cubeList.add(new ModelBox(teeth7, 77, 0, 6.0F, -4.0F, 14.0F, 1, 5, 1, 0.0F, false));
        teeth7.cubeList.add(new ModelBox(teeth7, 77, 0, 6.0F, -5.25F, 22.0F, 1, 5, 1, 0.0F, false));
        teeth7.cubeList.add(new ModelBox(teeth7, 77, 0, 6.0F, -5.0F, 16.0F, 1, 5, 1, 0.0F, false));
        teeth7.cubeList.add(new ModelBox(teeth7, 77, 0, 6.0F, -6.25F, 24.0F, 1, 5, 1, 0.0F, false));
        teeth7.cubeList.add(new ModelBox(teeth7, 77, 0, 6.0F, -5.0F, 18.0F, 1, 5, 1, 0.0F, false));
        teeth7.cubeList.add(new ModelBox(teeth7, 77, 0, 6.0F, -6.25F, 26.0F, 1, 5, 1, 0.0F, false));
        teeth7.cubeList.add(new ModelBox(teeth7, 77, 0, 6.0F, -6.0F, 20.0F, 1, 5, 1, 0.0F, false));

        teeth6 = new ModelRenderer(this);
        teeth6.setRotationPoint(3.0F, -84.0F, -40.25F);
        bone.addChild(teeth6);
        setRotationAngle(teeth6, -0.3927F, 0.0F, 0.0F);
        teeth6.cubeList.add(new ModelBox(teeth6, 77, 0, 6.0F, -2.0F, 4.0F, 1, 5, 1, 0.0F, false));
        teeth6.cubeList.add(new ModelBox(teeth6, 77, 0, 6.0F, -2.0F, 6.0F, 1, 5, 1, 0.0F, false));
        teeth6.cubeList.add(new ModelBox(teeth6, 77, 0, 6.0F, -3.0F, 8.0F, 1, 5, 1, 0.0F, false));
        teeth6.cubeList.add(new ModelBox(teeth6, 77, 0, 6.0F, -3.0F, 10.0F, 1, 5, 1, 0.0F, false));
        teeth6.cubeList.add(new ModelBox(teeth6, 77, 0, 6.0F, -4.0F, 12.0F, 1, 5, 1, 0.0F, false));
        teeth6.cubeList.add(new ModelBox(teeth6, 77, 0, 6.0F, -4.0F, 14.0F, 1, 5, 1, 0.0F, false));
        teeth6.cubeList.add(new ModelBox(teeth6, 77, 0, 6.0F, -5.25F, 22.0F, 1, 5, 1, 0.0F, false));
        teeth6.cubeList.add(new ModelBox(teeth6, 77, 0, 6.0F, -5.0F, 16.0F, 1, 5, 1, 0.0F, false));
        teeth6.cubeList.add(new ModelBox(teeth6, 77, 0, 6.0F, -6.25F, 24.0F, 1, 5, 1, 0.0F, false));
        teeth6.cubeList.add(new ModelBox(teeth6, 77, 0, 6.0F, -5.0F, 18.0F, 1, 5, 1, 0.0F, false));
        teeth6.cubeList.add(new ModelBox(teeth6, 77, 0, 6.0F, -6.25F, 26.0F, 1, 5, 1, 0.0F, false));
        teeth6.cubeList.add(new ModelBox(teeth6, 77, 0, 6.0F, -6.0F, 20.0F, 1, 5, 1, 0.0F, false));

        teeth5 = new ModelRenderer(this);
        teeth5.setRotationPoint(-13.0F, -84.0F, -40.25F);
        bone.addChild(teeth5);
        setRotationAngle(teeth5, -0.3927F, 0.0F, 0.0F);
        teeth5.cubeList.add(new ModelBox(teeth5, 77, 0, 6.0F, -2.0F, 4.0F, 1, 5, 1, 0.0F, false));
        teeth5.cubeList.add(new ModelBox(teeth5, 77, 0, 6.0F, -2.0F, 6.0F, 1, 5, 1, 0.0F, false));
        teeth5.cubeList.add(new ModelBox(teeth5, 77, 0, 6.0F, -3.0F, 8.0F, 1, 5, 1, 0.0F, false));
        teeth5.cubeList.add(new ModelBox(teeth5, 77, 0, 6.0F, -3.0F, 10.0F, 1, 5, 1, 0.0F, false));
        teeth5.cubeList.add(new ModelBox(teeth5, 77, 0, 6.0F, -4.0F, 12.0F, 1, 5, 1, 0.0F, false));
        teeth5.cubeList.add(new ModelBox(teeth5, 77, 0, 6.0F, -4.0F, 14.0F, 1, 5, 1, 0.0F, false));
        teeth5.cubeList.add(new ModelBox(teeth5, 77, 0, 6.0F, -5.25F, 22.0F, 1, 5, 1, 0.0F, false));
        teeth5.cubeList.add(new ModelBox(teeth5, 77, 0, 6.0F, -5.0F, 16.0F, 1, 5, 1, 0.0F, false));
        teeth5.cubeList.add(new ModelBox(teeth5, 77, 0, 6.0F, -6.25F, 24.0F, 1, 5, 1, 0.0F, false));
        teeth5.cubeList.add(new ModelBox(teeth5, 77, 0, 6.0F, -5.0F, 18.0F, 1, 5, 1, 0.0F, false));
        teeth5.cubeList.add(new ModelBox(teeth5, 77, 0, 6.0F, -6.25F, 26.0F, 1, 5, 1, 0.0F, false));
        teeth5.cubeList.add(new ModelBox(teeth5, 77, 0, 6.0F, -6.0F, 20.0F, 1, 5, 1, 0.0F, false));

        teeth2 = new ModelRenderer(this);
        teeth2.setRotationPoint(1.0F, -72.0F, -24.0F);
        bone.addChild(teeth2);
        teeth2.cubeList.add(new ModelBox(teeth2, 77, 0, -8.0F, 2.0F, 6.0F, 1, 5, 1, 0.0F, false));
        teeth2.cubeList.add(new ModelBox(teeth2, 77, 0, -8.0F, 1.0F, 8.0F, 1, 5, 1, 0.0F, false));
        teeth2.cubeList.add(new ModelBox(teeth2, 77, 0, -8.0F, 2.0F, 4.0F, 1, 5, 1, 0.0F, false));
        teeth2.cubeList.add(new ModelBox(teeth2, 77, 0, -8.0F, 3.0F, 2.0F, 1, 5, 1, 0.0F, false));
        teeth2.cubeList.add(new ModelBox(teeth2, 77, 0, -8.0F, 3.0F, 0.0F, 1, 5, 1, 0.0F, false));
        teeth2.cubeList.add(new ModelBox(teeth2, 77, 0, -8.0F, 4.0F, -2.0F, 1, 5, 1, 0.0F, false));
        teeth2.cubeList.add(new ModelBox(teeth2, 77, 0, -8.0F, 4.0F, -4.0F, 1, 5, 1, 0.0F, false));
        teeth2.cubeList.add(new ModelBox(teeth2, 77, 0, -8.0F, 5.0F, -6.0F, 1, 5, 1, 0.0F, false));
        teeth2.cubeList.add(new ModelBox(teeth2, 77, 0, -8.0F, 5.0F, -8.0F, 1, 5, 1, 0.0F, false));

        teeth4 = new ModelRenderer(this);
        teeth4.setRotationPoint(-16.0F, -84.0F, -40.25F);
        bone.addChild(teeth4);
        setRotationAngle(teeth4, -0.3927F, 0.0F, 0.0F);
        teeth4.cubeList.add(new ModelBox(teeth4, 77, 0, 6.0F, -2.0F, 4.0F, 1, 5, 1, 0.0F, false));
        teeth4.cubeList.add(new ModelBox(teeth4, 77, 0, 6.0F, -2.0F, 6.0F, 1, 5, 1, 0.0F, false));
        teeth4.cubeList.add(new ModelBox(teeth4, 77, 0, 6.0F, -3.0F, 8.0F, 1, 5, 1, 0.0F, false));
        teeth4.cubeList.add(new ModelBox(teeth4, 77, 0, 6.0F, -3.0F, 10.0F, 1, 5, 1, 0.0F, false));
        teeth4.cubeList.add(new ModelBox(teeth4, 77, 0, 6.0F, -4.0F, 12.0F, 1, 5, 1, 0.0F, false));
        teeth4.cubeList.add(new ModelBox(teeth4, 77, 0, 6.0F, -4.0F, 14.0F, 1, 5, 1, 0.0F, false));
        teeth4.cubeList.add(new ModelBox(teeth4, 77, 0, 6.0F, -5.25F, 22.0F, 1, 5, 1, 0.0F, false));
        teeth4.cubeList.add(new ModelBox(teeth4, 77, 0, 6.0F, -5.0F, 16.0F, 1, 5, 1, 0.0F, false));
        teeth4.cubeList.add(new ModelBox(teeth4, 77, 0, 6.0F, -6.25F, 24.0F, 1, 5, 1, 0.0F, false));
        teeth4.cubeList.add(new ModelBox(teeth4, 77, 0, 6.0F, -5.0F, 18.0F, 1, 5, 1, 0.0F, false));
        teeth4.cubeList.add(new ModelBox(teeth4, 77, 0, 6.0F, -6.25F, 26.0F, 1, 5, 1, 0.0F, false));
        teeth4.cubeList.add(new ModelBox(teeth4, 77, 0, 6.0F, -6.0F, 20.0F, 1, 5, 1, 0.0F, false));

        teeth = new ModelRenderer(this);
        teeth.setRotationPoint(0.0F, 0.0F, 0.0F);
        bone.addChild(teeth);
        teeth.cubeList.add(new ModelBox(teeth, 77, 0, 6.0F, -70.0F, -18.0F, 1, 5, 1, 0.0F, false));
        teeth.cubeList.add(new ModelBox(teeth, 77, 0, 6.0F, -71.0F, -16.0F, 1, 5, 1, 0.0F, false));
        teeth.cubeList.add(new ModelBox(teeth, 77, 0, 6.0F, -70.0F, -20.0F, 1, 5, 1, 0.0F, false));
        teeth.cubeList.add(new ModelBox(teeth, 77, 0, 6.0F, -69.0F, -22.0F, 1, 5, 1, 0.0F, false));
        teeth.cubeList.add(new ModelBox(teeth, 77, 0, 6.0F, -69.0F, -24.0F, 1, 5, 1, 0.0F, false));
        teeth.cubeList.add(new ModelBox(teeth, 77, 0, 6.0F, -68.0F, -26.0F, 1, 5, 1, 0.0F, false));
        teeth.cubeList.add(new ModelBox(teeth, 77, 0, 6.0F, -68.0F, -28.0F, 1, 5, 1, 0.0F, false));
        teeth.cubeList.add(new ModelBox(teeth, 77, 0, 6.0F, -67.0F, -30.0F, 1, 5, 1, 0.0F, false));
        teeth.cubeList.add(new ModelBox(teeth, 77, 0, 6.0F, -67.0F, -32.0F, 1, 5, 1, 0.0F, false));

        alex = new ModelRenderer(this);
        alex.setRotationPoint(0.0F, 18.0F, -7.0F);
        alex.cubeList.add(new ModelBox(alex, 81, 153, -4.0F, -32.0F, -14.0F, 8, 8, 8, 0.0F, false));
        alex.cubeList.add(new ModelBox(alex, 0, 45, -4.0F, -24.0F, -12.0F, 8, 12, 4, 0.0F, false));

        LeftLeg_r1 = new ModelRenderer(this);
        LeftLeg_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
        alex.addChild(LeftLeg_r1);
        setRotationAngle(LeftLeg_r1, 0.0F, 0.0F, -0.3054F);
        LeftLeg_r1.cubeList.add(new ModelBox(LeftLeg_r1, 70, 51, 3.9F, -12.0F, -12.0F, 4, 12, 4, 0.0F, false));

        RightLeg_r1 = new ModelRenderer(this);
        RightLeg_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
        alex.addChild(RightLeg_r1);
        setRotationAngle(RightLeg_r1, 0.0F, 0.0F, 0.3054F);
        RightLeg_r1.cubeList.add(new ModelBox(RightLeg_r1, 67, 93, -7.9F, -12.0F, -12.0F, 4, 12, 4, 0.0F, false));

        LeftArm_r1 = new ModelRenderer(this);
        LeftArm_r1.setRotationPoint(-0.0094F, -0.0628F, 0.0F);
        alex.addChild(LeftArm_r1);
        setRotationAngle(LeftArm_r1, 0.0F, 0.0F, -0.4363F);
        LeftArm_r1.cubeList.add(new ModelBox(LeftArm_r1, 128, 51, 13.75F, -20.0F, -12.0F, 3, 12, 4, 0.0F, false));

        RightArm_r1 = new ModelRenderer(this);
        RightArm_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
        alex.addChild(RightArm_r1);
        setRotationAngle(RightArm_r1, 0.0F, 0.0F, 0.4363F);
        RightArm_r1.cubeList.add(new ModelBox(RightArm_r1, 0, 130, -16.75F, -20.0F, -12.0F, 3, 12, 4, 0.0F, false));

        magik = new ModelRenderer(this);
        magik.setRotationPoint(0.0F, 18.0F, -7.0F);


        Head_r1 = new ModelRenderer(this);
        Head_r1.setRotationPoint(0.0F, -34.0F, 5.0F);
        magik.addChild(Head_r1);
        setRotationAngle(Head_r1, -1.3299F, -0.2208F, -0.1397F);
        Head_r1.cubeList.add(new ModelBox(Head_r1, 196, 0, 13.0F, -7.0F, -8.0F, 8, 8, 8, 0.0F, false));

        Head_r2 = new ModelRenderer(this);
        Head_r2.setRotationPoint(0.0F, -12.0F, 0.0F);
        magik.addChild(Head_r2);
        setRotationAngle(Head_r2, -2.0034F, -0.2594F, 0.0264F);
        Head_r2.cubeList.add(new ModelBox(Head_r2, 196, 0, 13.0F, -7.0F, -8.0F, 8, 8, 8, 0.0F, false));

        Head_r3 = new ModelRenderer(this);
        Head_r3.setRotationPoint(0.0F, -22.0F, 5.0F);
        magik.addChild(Head_r3);
        setRotationAngle(Head_r3, 1.7995F, 1.0125F, 1.0569F);
        Head_r3.cubeList.add(new ModelBox(Head_r3, 196, 0, 13.0F, 6.0F, 12.0F, 8, 8, 8, 0.0F, false));

        Head_r4 = new ModelRenderer(this);
        Head_r4.setRotationPoint(0.0F, 0.0F, 0.0F);
        magik.addChild(Head_r4);
        setRotationAngle(Head_r4, 0.1309F, 1.2654F, -0.5236F);
        Head_r4.cubeList.add(new ModelBox(Head_r4, 196, 0, 13.0F, 6.0F, 12.0F, 8, 8, 8, 0.0F, false));

        Head_r5 = new ModelRenderer(this);
        Head_r5.setRotationPoint(0.0F, -34.0F, 5.0F);
        magik.addChild(Head_r5);
        setRotationAngle(Head_r5, -1.512F, -0.2393F, 0.0835F);
        Head_r5.cubeList.add(new ModelBox(Head_r5, 196, 0, 8.0F, 26.0F, 12.0F, 8, 8, 8, 0.0F, false));

        Head_r6 = new ModelRenderer(this);
        Head_r6.setRotationPoint(0.0F, -12.0F, 0.0F);
        magik.addChild(Head_r6);
        setRotationAngle(Head_r6, -2.1713F, -0.1391F, 0.2122F);
        Head_r6.cubeList.add(new ModelBox(Head_r6, 196, 0, 25.0F, 18.0F, -25.0F, 8, 8, 8, 0.0F, false));

        Head_r7 = new ModelRenderer(this);
        Head_r7.setRotationPoint(0.0F, -22.0F, 5.0F);
        magik.addChild(Head_r7);
        setRotationAngle(Head_r7, 1.3235F, 0.9959F, 0.6495F);
        Head_r7.cubeList.add(new ModelBox(Head_r7, 196, 0, -6.0F, 6.0F, 12.0F, 8, 8, 8, 0.0F, false));

        Head_r8 = new ModelRenderer(this);
        Head_r8.setRotationPoint(0.0F, 0.0F, 0.0F);
        magik.addChild(Head_r8);
        setRotationAngle(Head_r8, 0.0F, 1.0472F, -0.5236F);
        Head_r8.cubeList.add(new ModelBox(Head_r8, 196, 0, -6.0F, 6.0F, 12.0F, 8, 8, 8, 0.0F, false));

        Head_r9 = new ModelRenderer(this);
        Head_r9.setRotationPoint(0.0F, -34.0F, 5.0F);
        magik.addChild(Head_r9);
        setRotationAngle(Head_r9, -1.657F, -0.126F, -0.1886F);
        Head_r9.cubeList.add(new ModelBox(Head_r9, 196, 0, -24.0F, 6.0F, -4.0F, 8, 8, 8, 0.0F, false));

        Head_r10 = new ModelRenderer(this);
        Head_r10.setRotationPoint(0.0F, -12.0F, 0.0F);
        magik.addChild(Head_r10);
        setRotationAngle(Head_r10, -2.3156F, -0.2146F, -0.0728F);
        Head_r10.cubeList.add(new ModelBox(Head_r10, 196, 0, -24.0F, 6.0F, -4.0F, 8, 8, 8, 0.0F, false));

        Head_r11 = new ModelRenderer(this);
        Head_r11.setRotationPoint(0.0F, -22.0F, 5.0F);
        magik.addChild(Head_r11);
        setRotationAngle(Head_r11, 1.5312F, 0.9168F, 1.1385F);
        Head_r11.cubeList.add(new ModelBox(Head_r11, 196, 0, -24.0F, 6.0F, -4.0F, 8, 8, 8, 0.0F, false));

        Head_r12 = new ModelRenderer(this);
        Head_r12.setRotationPoint(0.0F, 0.0F, 0.0F);
        magik.addChild(Head_r12);
        setRotationAngle(Head_r12, 0.1309F, 1.309F, -0.1745F);
        Head_r12.cubeList.add(new ModelBox(Head_r12, 196, 0, -24.0F, 6.0F, -4.0F, 8, 8, 8, 0.0F, false));

        Head_r13 = new ModelRenderer(this);
        Head_r13.setRotationPoint(0.0F, -34.0F, 5.0F);
        magik.addChild(Head_r13);
        setRotationAngle(Head_r13, -1.2391F, -0.2457F, 0.3982F);
        Head_r13.cubeList.add(new ModelBox(Head_r13, 196, 0, -24.0F, 6.0F, 27.0F, 8, 8, 8, 0.0F, false));

        Head_r14 = new ModelRenderer(this);
        Head_r14.setRotationPoint(0.0F, -12.0F, 0.0F);
        magik.addChild(Head_r14);
        setRotationAngle(Head_r14, -1.8352F, 0.036F, 0.4631F);
        Head_r14.cubeList.add(new ModelBox(Head_r14, 196, 0, -24.0F, 6.0F, 27.0F, 8, 8, 8, 0.0F, false));

        Head_r15 = new ModelRenderer(this);
        Head_r15.setRotationPoint(0.0F, -22.0F, 5.0F);
        magik.addChild(Head_r15);
        setRotationAngle(Head_r15, 1.2962F, 0.8639F, 0.184F);
        Head_r15.cubeList.add(new ModelBox(Head_r15, 196, 0, -24.0F, 6.0F, 27.0F, 8, 8, 8, 0.0F, false));

        Head_r16 = new ModelRenderer(this);
        Head_r16.setRotationPoint(0.0F, 0.0F, 0.0F);
        magik.addChild(Head_r16);
        setRotationAngle(Head_r16, 0.3491F, 0.7418F, -0.5236F);
        Head_r16.cubeList.add(new ModelBox(Head_r16, 196, 0, -24.0F, 6.0F, 27.0F, 8, 8, 8, 0.0F, false));

        Head_r17 = new ModelRenderer(this);
        Head_r17.setRotationPoint(0.0F, -34.0F, 5.0F);
        magik.addChild(Head_r17);
        setRotationAngle(Head_r17, -1.4681F, -0.2447F, 0.4432F);
        Head_r17.cubeList.add(new ModelBox(Head_r17, 196, 0, -24.0F, -17.0F, -3.0F, 8, 8, 8, 0.0F, false));
        Head_r17.cubeList.add(new ModelBox(Head_r17, 196, 0, -1.0F, -17.0F, -31.0F, 8, 8, 8, 0.0F, false));
        Head_r17.cubeList.add(new ModelBox(Head_r17, 196, 0, 6.0F, 24.0F, -14.0F, 8, 8, 8, 0.0F, false));

        Head_r18 = new ModelRenderer(this);
        Head_r18.setRotationPoint(0.0F, -12.0F, 0.0F);
        magik.addChild(Head_r18);
        setRotationAngle(Head_r18, -2.0517F, 0.0611F, 0.4989F);
        Head_r18.cubeList.add(new ModelBox(Head_r18, 196, 0, -24.0F, -17.0F, -3.0F, 8, 8, 8, 0.0F, false));
        Head_r18.cubeList.add(new ModelBox(Head_r18, 196, 0, -1.0F, -17.0F, -31.0F, 8, 8, 8, 0.0F, false));
        Head_r18.cubeList.add(new ModelBox(Head_r18, 196, 0, -4.0F, 24.0F, 12.0F, 8, 8, 8, 0.0F, false));

        Head_r19 = new ModelRenderer(this);
        Head_r19.setRotationPoint(0.0F, -22.0F, 5.0F);
        magik.addChild(Head_r19);
        setRotationAngle(Head_r19, 1.0382F, 0.8377F, 0.131F);
        Head_r19.cubeList.add(new ModelBox(Head_r19, 196, 0, -24.0F, -17.0F, -3.0F, 8, 8, 8, 0.0F, false));
        Head_r19.cubeList.add(new ModelBox(Head_r19, 196, 0, -1.0F, -17.0F, -31.0F, 8, 8, 8, 0.0F, false));
        Head_r19.cubeList.add(new ModelBox(Head_r19, 196, 0, -4.0F, 5.0F, -14.0F, 8, 8, 8, 0.0F, false));

        Head_r20 = new ModelRenderer(this);
        Head_r20.setRotationPoint(0.0F, 0.0F, 0.0F);
        magik.addChild(Head_r20);
        setRotationAngle(Head_r20, 0.1309F, 0.6981F, -0.5236F);
        Head_r20.cubeList.add(new ModelBox(Head_r20, 196, 0, -24.0F, -17.0F, -3.0F, 8, 8, 8, 0.0F, false));
        Head_r20.cubeList.add(new ModelBox(Head_r20, 196, 0, -1.0F, -17.0F, -31.0F, 8, 8, 8, 0.0F, false));
        Head_r20.cubeList.add(new ModelBox(Head_r20, 196, 0, -4.0F, 5.0F, -14.0F, 8, 8, 8, 0.0F, false));

        bb_main = new ModelRenderer(this);
        bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
        bb_main.cubeList.add(new ModelBox(bb_main, 77, 0, -5.0F, -39.55F, -22.0F, 10, 2, 10, 0.0F, false));
        bb_main.cubeList.add(new ModelBox(bb_main, 138, 158, -3.25F, -43.0F, -20.0F, 7, 4, 7, 0.0F, false));
        bb_main.cubeList.add(new ModelBox(bb_main, 11, 0, 0.25F, -47.5F, -16.0F, 1, 2, 1, 0.25F, false));
        bb_main.cubeList.add(new ModelBox(bb_main, 51, 76, -1.5F, -46.0F, -18.0F, 4, 4, 4, 0.0F, false));
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        head.render(f5);
        magik.render(f5);
        bb_main.render(f5);
        alex.render(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
    }

}