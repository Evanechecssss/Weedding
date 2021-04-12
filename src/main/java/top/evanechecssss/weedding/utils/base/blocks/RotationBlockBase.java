package top.evanechecssss.weedding.utils.base.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import top.evanechecssss.weedding.utils.reference.WeeddingInfo;

public class RotationBlockBase extends Block {
    public static final PropertyDirection FACING = BlockDirectional.FACING;
    public RotationBlockBase(String name, Material material, CreativeTabs tabs, SoundType soundType, int hardness, int resistance, int lightOpacity, int lightLevel, String toolClass, int toolLevel) {
        super(material);
        this.setCreativeTab(tabs);
        this.setRegistryName(name);
        this.setUnlocalizedName(WeeddingInfo.MODID + "." + name);
        this.setSoundType(soundType);
        this.setHardness(hardness);
        this.setResistance(resistance);
        this.setLightOpacity(lightOpacity);
        this.setLightLevel(lightLevel);
        this.setHarvestLevel(toolClass,toolLevel);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    }
    public RotationBlockBase(String name, Material material, CreativeTabs tabs, SoundType soundType,int hardness,int resistance,String toolClass,int toolLevel) {
        super(material);
        this.setCreativeTab(tabs);
        this.setRegistryName(name);
        this.setUnlocalizedName(WeeddingInfo.MODID + "." + name);
        this.setSoundType(soundType);
        this.setHardness(hardness);
        this.setResistance(resistance);
        this.setHarvestLevel(toolClass,toolLevel);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    }
    public RotationBlockBase(String name, Material material,int hardness,int resistance,String toolClass,int toolLevel) {
        super(material);
        this.setRegistryName(name);
        this.setUnlocalizedName(WeeddingInfo.MODID + "." + name);
        this.setHardness(hardness);
        this.setResistance(resistance);
        this.setHarvestLevel(toolClass,toolLevel);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    }
    public RotationBlockBase(String name, Material material) {
        super(material);
        this.setRegistryName(name);
        this.setUnlocalizedName(WeeddingInfo.MODID + "." + name);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    }
    public RotationBlockBase(String name) {
        super(Material.ROCK);
        this.setRegistryName(name);
        this.setUnlocalizedName(WeeddingInfo.MODID + "." + name);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    }

    public RotationBlockBase(String name, Material material, CreativeTabs tabs, SoundType soundType) {
        super(material);
        this.setCreativeTab(tabs);
        this.setRegistryName(name);
        this.setUnlocalizedName(WeeddingInfo.MODID + "." + name);
        this.setSoundType(soundType);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(FACING).getIndex();
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this,FACING);
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        world.setBlockState(pos,state.withProperty(FACING,EnumFacing.getDirectionFromEntityLiving(pos,placer)));
    }

    @Override
    public IBlockState withRotation(IBlockState state, Rotation rot) {
        return state.withProperty(FACING,EnumFacing.UP);
    }
}
