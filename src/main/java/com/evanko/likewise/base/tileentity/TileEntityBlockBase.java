package com.evanko.likewise.base.tileentity;

import com.evanko.likewise.base.blocks.BlockBase;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

import javax.annotation.Nullable;

public abstract class TileEntityBlockBase<T extends TileEntity> extends BlockBase{
    public TileEntityBlockBase(String name, Material material) {
        super(name, material);
        GameRegistry.registerTileEntity(this.getTileEntityClass(), this.getRegistryName().toString());
    }
    public TileEntityBlockBase(String name, Material material, float hardness, float resistance, String toolClass, int toolLevel) {
        super(name, material, hardness, resistance, toolClass, toolLevel);
        GameRegistry.registerTileEntity(this.getTileEntityClass(), this.getRegistryName().toString());
    }
    public TileEntityBlockBase(String name, Material material, float hardness, float resistance, String toolClass, int toolLevel, CreativeTabs tab, SoundType type) {
        super(name, material, hardness, resistance, toolClass, toolLevel, tab, type);
        GameRegistry.registerTileEntity(this.getTileEntityClass(), this.getRegistryName().toString());
    }
    public TileEntityBlockBase(String name, Material material, float hardness, float resistance, String toolClass, int toolLevel, CreativeTabs tab, SoundType type, float lightLevel, int lightOpacity) {
        super(name, material, hardness, resistance, toolClass, toolLevel, tab, type, lightLevel, lightOpacity);
        GameRegistry.registerTileEntity(this.getTileEntityClass(), this.getRegistryName().toString());
    }

    public abstract Class<T> getTileEntityClass();

    public T getTileEntity(IBlockAccess world, BlockPos position) {
        return (T) world.getTileEntity(position);
    }

    @Override
    public boolean hasTileEntity(IBlockState blockState) {
        return true;
    }

    @Nullable
    @Override
    public abstract T createTileEntity(World world, IBlockState blockState);
}
