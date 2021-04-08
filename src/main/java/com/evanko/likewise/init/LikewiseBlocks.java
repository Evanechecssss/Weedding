package com.evanko.likewise.init;

import com.evanko.likewise.blocks.BoilerBlock;
import com.evanko.likewise.blocks.Box;
import com.evanko.likewise.blocks.HempBlock;
import com.evanko.likewise.blocks.HookahEmpty;
import com.evanko.likewise.reference.ModCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class LikewiseBlocks {
    public static Block BOILER = new BoilerBlock("boiler",Material.ROCK,ModCreativeTabs.LIKEWISE,SoundType.METAL);
    public static Block BOX = new Box("box", Material.CAKE);
    public static Block HEMP = new HempBlock("hemp", ModCreativeTabs.LIKEWISE);
    public static final Block[] BLOCKS = new Block[]{
            BOILER, BOX, HEMP
    };
    public static Block HOOKAH_EMPTY = new HookahEmpty("empty_hookah", Material.ROCK, 10, 10, "pickaxe", 1, ModCreativeTabs.LIKEWISE, SoundType.METAL, 0, 0);
}
