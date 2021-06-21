package top.evanechecssss.weedding.common.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.Nullable;
import top.evanechecssss.weedding.Weedding;
import top.evanechecssss.weedding.client.gui.base.IHasContainer;
import top.evanechecssss.weedding.common.base.blocks.HorizontalBlockBase;
import top.evanechecssss.weedding.init.WeeddingCreativeTabs;
import top.evanechecssss.weedding.init.WeeddingGUIs;

public class BatteryBlock extends HorizontalBlockBase {

    public BatteryBlock(String name) {
        super(name, Material.IRON, 5, 5, "pickaxe", 2, WeeddingCreativeTabs.WEEDDING_CT, SoundType.STONE, 0, 0);
        GameRegistry.registerTileEntity(BatteryBlockTE.class, getRegistryName().toString());
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (facing.equals(EnumFacing.UP)){
            if (world.isRemote){
            player.openGui(Weedding.instance, WeeddingGUIs.BATTERY_GUI, world, pos.getX(), pos.getY(), pos.getZ());
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean hasTileEntity() {
        return true;
    }

    @Nullable
    @Override
    public BatteryBlockTE createTileEntity(World world, IBlockState state) {
        return new BatteryBlockTE();
    }

    public BatteryBlockTE getTileEntity(World world, BlockPos pos) {
        return (BatteryBlockTE) world.getTileEntity(pos);
    }

    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
        destroyBlock(worldIn, pos);
    }

    @Override
    public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
        destroyBlock(worldIn, pos);
    }

    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
        destroyBlock(worldIn, pos);
    }

    private void destroyBlock(World world, BlockPos pos) {
        if (!world.isRemote){
        ItemStackHandler itemStackHandler = getTileEntity(world,pos).getInventory();
        for (int i = 0; i<getTileEntity(world,pos).getInventorySize(); i++){
          ItemStack itemStack =  itemStackHandler.getStackInSlot(i);
          world.spawnEntity(new EntityItem(world,pos.getX(),pos.up().getY(),pos.getZ(),itemStack));
        }
        }
    }

    public static class BatteryBlockTE extends TileEntity implements ITickable, IHasContainer {

        public ItemStackHandler inventory = new ItemStackHandler(2);
        public BatteryBlockTE() {

        }

        @Override
        public void update() {

        }

        @Override
        public void readFromNBT(NBTTagCompound compound) {
            if (compound.hasKey("inventory")) inventory.deserializeNBT((NBTTagCompound) compound.getTag("inventory"));
        }

        @Override
        public NBTTagCompound writeToNBT(NBTTagCompound compound) {
            compound = super.writeToNBT(compound);
            compound.setTag("inventory", inventory.serializeNBT());
            return compound;
        }

        @Override
        public ItemStackHandler getInventory() {
            return inventory;
        }

        @Override
        public int getInventorySize() {
            return 2;
        }

        @Override
        public int getInventoryMaxIndex() {
            return 1;
        }
    }
}
