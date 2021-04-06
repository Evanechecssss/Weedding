package com.evanko.likewise.blocks;

import com.evanko.likewise.base.blocks.BlockBase;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class LoveBlock extends BlockBase {
    public LoveBlock(String name, Material material) {
        super(name, material);
    }
    public LoveBlock(String name, Material material, float hardness, float resistance, String toolClass, int toolLevel) {
        super(name, material, hardness, resistance, toolClass, toolLevel);
    }
    public LoveBlock(String name, Material material, float hardness, float resistance, String toolClass, int toolLevel, CreativeTabs tab, SoundType type) {
        super(name, material, hardness, resistance, toolClass, toolLevel, tab, type);
    }
    public LoveBlock(String name, Material material, float hardness, float resistance, String toolClass, int toolLevel, CreativeTabs tab, SoundType type, float lightLevel, int lightOpacity) {
        super(name, material, hardness, resistance, toolClass, toolLevel, tab, type, lightLevel, lightOpacity);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if(playerIn.getHeldItem(hand).getItem()== Items.FIRE_CHARGE){
        worldIn.setBlockToAir(pos);
            if (!worldIn.isRemote)
            {
                EntityTNTPrimed entitytntprimed = new EntityTNTPrimed(worldIn, (double)((float)pos.getX() + 0.5F), (double)pos.getY(), (double)((float)pos.getZ() + 0.5F), null);
                worldIn.spawnEntity(entitytntprimed);
            }
        }
        return false;
    }
    public void onBlockDestroyedByExplosion(World worldIn, BlockPos pos, Explosion explosionIn) {
        if (!worldIn.isRemote)
        {
            EntityTNTPrimed entitytntprimed = new EntityTNTPrimed(worldIn, (double)((float)pos.getX() + 0.5F), (double)pos.getY(), (double)((float)pos.getZ() + 0.5F), null);
            worldIn.spawnEntity(entitytntprimed);
        }
    }
}
