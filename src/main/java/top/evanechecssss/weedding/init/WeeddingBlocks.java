package top.evanechecssss.weedding.init;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import top.evanechecssss.weedding.common.blocks.*;
import top.evanechecssss.weedding.utils.reference.WeeddingCreativeTabs;

public class WeeddingBlocks {
    public static Block BOILER = new BoilerBlock("boiler", Material.ROCK, WeeddingCreativeTabs.WEEDDING_CT, SoundType.METAL);
    public static Block BOX = new Box("box", Material.CAKE, 20, 30, "pickaxe", 10, WeeddingCreativeTabs.WEEDDING_CT, SoundType.GLASS, 0, 0);
    public static Block HEMP = new HempBlock("hemp", WeeddingCreativeTabs.WEEDDING_CT);
    public static Block GRAMOPHONE_IRON = new GramophoneIron("gramophone_iron", Material.IRON, 20, 20, "pickaxe", 2, WeeddingCreativeTabs.WEEDDING_CT, SoundType.METAL, 0, 0);
    public static final Block[] BLOCKS = new Block[]{
            BOILER, BOX, HEMP, GRAMOPHONE_IRON
    };
    public static Block HOOKAH_EMPTY = new HookahEmpty("empty_hookah", Material.ROCK, 10, 10, "pickaxe", 1, WeeddingCreativeTabs.WEEDDING_CT, SoundType.METAL, 0, 0);


}
