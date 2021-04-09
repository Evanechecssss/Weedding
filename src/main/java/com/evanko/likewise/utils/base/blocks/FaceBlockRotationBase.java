package com.evanko.likewise.utils.base.blocks;

import com.evanko.likewise.utils.reference.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FaceBlockRotationBase extends Block {
    public static final PropertyDirection FACING = BlockDirectional.FACING;
    public FaceBlockRotationBase(String name, Material material, CreativeTabs tabs, SoundType soundType, int hardness, int resistance, int lightOpacity, int lightLevel, String toolClass, int toolLevel) {
        super(material);
        this.setCreativeTab(tabs);
        this.setRegistryName(name);
        this.setUnlocalizedName(ModInfo.MODID + "." + name);
        this.setSoundType(soundType);
        this.setHardness(hardness);
        this.setResistance(resistance);
        this.setLightOpacity(lightOpacity);
        this.setLightLevel(lightLevel);
        this.setHarvestLevel(toolClass,toolLevel);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    }
    public FaceBlockRotationBase(String name, Material material, CreativeTabs tabs, SoundType soundType,int hardness,int resistance,String toolClass,int toolLevel) {
        super(material);
        this.setCreativeTab(tabs);
        this.setRegistryName(name);
        this.setUnlocalizedName(ModInfo.MODID + "." + name);
        this.setSoundType(soundType);
        this.setHardness(hardness);
        this.setResistance(resistance);
        this.setHarvestLevel(toolClass,toolLevel);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    }
    public FaceBlockRotationBase(String name, Material material,int hardness,int resistance,String toolClass,int toolLevel) {
        super(material);
        this.setRegistryName(name);
        this.setUnlocalizedName(ModInfo.MODID + "." + name);
        this.setHardness(hardness);
        this.setResistance(resistance);
        this.setHarvestLevel(toolClass,toolLevel);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    }
    public FaceBlockRotationBase(String name, Material material) {
        super(material);
        this.setRegistryName(name);
        this.setUnlocalizedName(ModInfo.MODID + "." + name);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    }
    public FaceBlockRotationBase(String name) {
        super(Material.ROCK);
        this.setRegistryName(name);
        this.setUnlocalizedName(ModInfo.MODID + "." + name);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    }

    @Override
    protected net.minecraft.block.state.BlockStateContainer createBlockState() {
        return new net.minecraft.block.state.BlockStateContainer(this, FACING);
    }

    @Override
    public IBlockState withRotation(IBlockState state, Rotation rot) {
        return state.withProperty(FACING, rot.rotate(state.getValue(FACING)));
    }

    @Override
    public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
        return state.withRotation(mirrorIn.toRotation(state.getValue(FACING)));
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(FACING, EnumFacing.getFront(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return (state.getValue(FACING)).getIndex();
    }

    @Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        return this.getDefaultState().withProperty(FACING, EnumFacing.getDirectionFromEntityLiving(pos, placer));
    }
}
