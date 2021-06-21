package top.evanechecssss.weedding.common.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IShearable;
import org.jetbrains.annotations.NotNull;
import top.evanechecssss.weedding.init.WeeddingBlocks;
import top.evanechecssss.weedding.init.WeeddingItems;
import top.evanechecssss.weedding.common.base.blocks.crop.CropBase;

import java.util.Random;


public class HempBlock extends CropBase implements IShearable {
    public HempBlock(String name) {
        super(name);
    }
    public HempBlock(String name, CreativeTabs tab) {
        super(name, tab);
    }
    public HempBlock(String name, CreativeTabs tab, SoundType type) {
        super(name, tab, type);
    }
    public HempBlock(String name, CreativeTabs tab, SoundType type, float resistance) {
        super(name, tab, type, resistance);
    }
    @Override
    public boolean canPlaceBlockAt(World world, BlockPos pos) {
        return world.getBlockState(pos).getBlock().isReplaceable(world, pos) && world.getBlockState(pos.down()).getBlock() == Blocks.GRASS;
    }
    @Override
    protected Item getSeed() {
        return WeeddingItems.HEMP_SEED;
    }

    @Override
    protected Item getCrop() {
        return WeeddingItems.HEMP_FOOD;
    }

    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
        return true;
    }

    @Override
    public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face) {
        return 1;
    }

    @Override
    public int getFireSpreadSpeed(IBlockAccess world, BlockPos pos, EnumFacing face) {
        return 1;
    }

    @Override
    public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
        return EnumPlantType.Plains;
    }

    @Override
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
        drops.add(new ItemStack(WeeddingItems.HEMP_SEED, (int) (Math.random() * 4), 0));
        drops.add(new ItemStack(WeeddingItems.HEMP_FOOD, 1, 0));
    }

    @Override
    public boolean isReplaceable(IBlockAccess worldIn, BlockPos pos) {
        return true;
    }

    @Override
    public int quantityDroppedWithBonus(int fortune, Random random) {
        return 1 + random.nextInt(fortune * 10 + 1);
    }


    @Override
    public EnumOffsetType getOffsetType() {
        return EnumOffsetType.XYZ;
    }


    @Override
    public boolean isShearable(@NotNull ItemStack item, IBlockAccess world, BlockPos pos) {
        return true;
    }


    @Override
    public NonNullList onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
        return NonNullList.withSize(1, new ItemStack(WeeddingBlocks.HEMP));
    }

}
