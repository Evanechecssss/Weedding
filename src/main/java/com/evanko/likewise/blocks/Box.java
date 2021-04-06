package com.evanko.likewise.blocks;

import com.evanko.likewise.base.blocks.HorizontalBlockBase;
import com.evanko.likewise.base.tileentity.TileEntityBlockBase;
import com.evanko.likewise.reference.ModInfo;
import com.evanko.likewise.tileentity.Box_TE;
import com.evanko.likewise.tileentity.InfoBlockTE;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.jetbrains.annotations.Nullable;

public class Box extends HorizontalBlockBase {
    public Box(String name, Material material, CreativeTabs tabs, SoundType soundType, int hardness, int resistance, int lightOpacity, int lightLevel, String toolClass, int toolLevel) {
        super(name, material, tabs, soundType, hardness, resistance, lightOpacity, lightLevel, toolClass, toolLevel);
    }

    public Box(String name, Material material, CreativeTabs tabs, SoundType soundType, int hardness, int resistance, String toolClass, int toolLevel) {
        super(name, material, tabs, soundType, hardness, resistance, toolClass, toolLevel);
    }

    public Box(String name, Material material, int hardness, int resistance, String toolClass, int toolLevel) {
        super(name, material, hardness, resistance, toolClass, toolLevel);
    }

    public Box(String name, Material material) {
        super(name, material);
        GameRegistry.registerTileEntity(this.getTileEntityClass(), this.getRegistryName().toString());
    }

    public Box(String name) {
        super(name);
    }

    public Box(String name, Material material, CreativeTabs tabs, SoundType soundType) {
        super(name, material, tabs, soundType);
    }

    public Class<Box_TE> getTileEntityClass() {
        return Box_TE.class;
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        Box_TE tile = (Box_TE) world.getTileEntity(pos);
        if (!world.isRemote) {
            ItemStack item = playerIn.getHeldItem(EnumHand.MAIN_HAND);
            if (item.getItem() == Items.COOKIE) {
                tile.addCracker(item);
                return true;
            }
            if (item.getItem() == Items.AIR) {
                tile.removeCracker();
                return true;
            }

        }else {
            playerIn.sendMessage(new TextComponentString("cookie - " + tile.getCrackerCount()));
        }
        return true;

    }

    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }

    @Override
    public boolean hasTileEntity(IBlockState blockState) {
        return true;
    }

    @Nullable
    @Override
    public Box_TE createTileEntity(World world, IBlockState blockState) {
        return new Box_TE();
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }
}
