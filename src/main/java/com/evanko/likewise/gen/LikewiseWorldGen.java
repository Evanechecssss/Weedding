package com.evanko.likewise.gen;

import com.evanko.likewise.init.LikewiseBlocks;
import com.google.common.base.Predicate;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockStateMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class LikewiseWorldGen implements IWorldGenerator {
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        if (world.provider.getDimension()==0){
            OverWorldGen(random,chunkX,chunkZ,world,chunkGenerator,chunkProvider);
        }
    }
    private void OverWorldGen(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider){
        HempBlockGen(LikewiseBlocks.HEMP.getDefaultState(),50,50,10,240,BlockStateMatcher.forBlock(Blocks.TALLGRASS),world,random,chunkX,chunkZ);
    }
    public void HempBlockGen(IBlockState blockToGen, int blockAmount, int chances, int minHeight, int maxHeight, Predicate<IBlockState> blockToReplace, World world, Random rand, int chunk_X, int chunk_Z)
    {
        if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight) return;
        WorldGenMinable generator = new WorldGenMinable(blockToGen, blockAmount, blockToReplace);
        int heightDelta = maxHeight - minHeight +1;
        for (int i = 0; i < chances; i++){
            int x = chunk_X * 16 + rand.nextInt(16);
            int y = minHeight + rand.nextInt(heightDelta);
            int z = chunk_Z * 16 + rand.nextInt(16);
            generator.generate(world, rand, new BlockPos(x, y, z));
        }
    }
}
