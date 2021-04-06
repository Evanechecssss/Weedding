package com.evanko.likewise.blocks;

import com.evanko.likewise.base.tileentity.TileEntityBlockBase;
import com.evanko.likewise.tileentity.InfoBlockTE;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class InfoBlock extends TileEntityBlockBase<InfoBlockTE> {
    public InfoBlock(String name, Material material) {
        super(name, material);
    }
    public InfoBlock(String name, Material material, float hardness, float resistance, String toolClass, int toolLevel) {
        super(name, material, hardness, resistance, toolClass, toolLevel);
    }
    public InfoBlock(String name, Material material, float hardness, float resistance, String toolClass, int toolLevel, CreativeTabs tab, SoundType type) {
        super(name, material, hardness, resistance, toolClass, toolLevel, tab, type);
    }
    public InfoBlock(String name, Material material, float hardness, float resistance, String toolClass, int toolLevel, CreativeTabs tab, SoundType type, float lightLevel, int lightOpacity) {
        super(name, material, hardness, resistance, toolClass, toolLevel, tab, type, lightLevel, lightOpacity);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        InfoBlockTE tile = this.getTileEntity(world,pos);
        if(!world.isRemote){
            if(player.getUniqueID().equals(tile.getUUID())){
                tile.setEXP(player.experienceLevel);
                tile.setHealth(player.getHealth());
                tile.setFoodLevel(player.getFoodStats().getFoodLevel());
            }
        }else{
            if (player.getUniqueID().equals(tile.getUUID())){
                player.sendMessage(new TextComponentString("Ваша статистика \n Здоровье: " + tile.getHealth()+"\n Еда: " +tile.getFoodLevel() + "\n Уровень:" + tile.getExp()));
            }else {
                player.sendMessage(new TextComponentString("Cтатистика игрока " +tile.getPlayerName()+ " : \n Здоровье: " + tile.getHealth()+"\n Еда: " +tile.getFoodLevel() + "\n Уровень:" + tile.getExp()));
            }
        }
        return true;
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        if(!world.isRemote){
            if(placer instanceof EntityPlayer){
            this.getTileEntity(world,pos).setPlayerName(placer.getName());
            this.getTileEntity(world,pos).setUUID(placer.getUniqueID().toString());
            }
        }
    }

    @Override
    public Class<InfoBlockTE> getTileEntityClass() {
        return InfoBlockTE.class;
    }
    @Override
    public boolean hasTileEntity(IBlockState blockState) {
        return true;
    }
    @Nullable
    @Override
    public InfoBlockTE createTileEntity(World world, IBlockState blockState) {
        return new InfoBlockTE();
    }
}
