package top.evanechecssss.weedding.init;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import top.evanechecssss.weedding.common.blocks.*;
import top.evanechecssss.weedding.utils.reference.WeeddingCreativeTabs;

public class WeeddingBlocks {
    public static Block BOILER = new BoilerBlock("boiler", Material.ROCK, WeeddingCreativeTabs.weedding, SoundType.METAL);
    public static Block BOX = new Box("box", Material.CAKE, 20, 30, "pickaxe", 10, WeeddingCreativeTabs.weedding, SoundType.GLASS, 0, 0);
    public static Block HEMP = new HempBlock("hemp", WeeddingCreativeTabs.weedding);
    public static Block CHEST_OF_LIQUIDS = new ChestOfLiquids("chest_of_liquids", Material.IRON, 15, 50, "axe", 1);
    public static final Block[] BLOCKS = new Block[]{
            BOILER, BOX, HEMP, CHEST_OF_LIQUIDS
    };
    public static Block HOOKAH_EMPTY = new HookahEmpty("empty_hookah", Material.ROCK, 10, 10, "pickaxe", 1, WeeddingCreativeTabs.weedding, SoundType.METAL, 0, 0);
}
