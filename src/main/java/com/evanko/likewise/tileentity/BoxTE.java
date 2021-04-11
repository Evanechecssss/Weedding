package com.evanko.likewise.tileentity;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class BoxTE extends TileEntity {
    private int crackerCount = 0;

    public BoxTE() {

    }

    public boolean addCracker(ItemStack itemStack) {

        if (crackerCount < 8) {
            crackerCount++;
            int count = itemStack.getCount();
            if (count > 0) {
                count--;
            }
            itemStack.setCount(count);
            markDirty();
            return true;
        }
        markDirty();
        return false;
    }

    public int getCrackerCount() {
        return this.crackerCount;
    }

    public void removeCracker() {
        if (crackerCount > 0) {
            crackerCount--;
            world.spawnEntity(new EntityItem(world, pos.getX(), pos.up().getY(), pos.getZ(), new ItemStack(Items.COOKIE)));
        }
        markDirty();
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setInteger("crackerCount", crackerCount);
        return compound;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        this.crackerCount = compound.getInteger("crackerCount");
    }

}
