package com.evanko.likewise.init;

import com.evanko.likewise.base.blocks.FaceBlockRotationBase;
import com.evanko.likewise.base.crop.CropBase;
import com.evanko.likewise.blocks.*;
import com.evanko.likewise.reference.ModCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class LikewiseBlocks {
    public static Block REDINJECTOR = new FaceBlockRotationBase("redinjector",Material.ROCK);
    public static Block LOVEBLOCK = new LoveBlock("loveblock",Material.ROCK);
    public static Block BOILER = new BoilerBlock("boiler",Material.ROCK,ModCreativeTabs.LIKEWISE,SoundType.METAL);
    public static Block INFO = new InfoBlock("info",Material.IRON);
    public static Block BOX = new Box("box",Material.CAKE);
    public static Block HEMP = new HempBlock("hemp",ModCreativeTabs.HELPER);
    public static final Block[] BLOCKS = new Block[]{
            REDINJECTOR,LOVEBLOCK,BOILER,INFO,BOX,HEMP
    };
}
