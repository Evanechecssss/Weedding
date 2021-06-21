package top.evanechecssss.weedding.common.tiles;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.items.ItemStackHandler;
import top.evanechecssss.weedding.client.gui.base.IHasContainer;

public class HookahEmptyTE extends TileEntity implements IHasContainer {
    private final int size = 6;
    private int liquidVolume = 0;
    private int liquidId = 0;
    public ItemStackHandler inventory = new ItemStackHandler(size);


    public HookahEmptyTE() {

    }

    public int getLiquidVolume() {
        return this.liquidVolume;
    }

    public void setLiquidVolume(int liquidVolume) {
        this.liquidVolume = liquidVolume;
    }

    public int getLiquidId() {
        return this.liquidId;
    }

    public void setLiquidId(int liquidId) {
        this.liquidId = liquidId;
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound = super.writeToNBT(compound);
        compound.setTag("inventory", inventory.serializeNBT());
        compound.setInteger("liquidVolume", liquidVolume);
        compound.setInteger("liquidId", liquidId);
        return compound;
    }

    public void blockBreaking() {
        for (int i = 0; i < getInventoryMaxIndex(); ++i)
            world.spawnEntity(new EntityItem(world, pos.getX(), pos.up().getY(), pos.getZ(), inventory.getStackInSlot(i)));
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        if (compound.hasKey("inventory")) inventory.deserializeNBT((NBTTagCompound) compound.getTag("inventory"));
        if (compound.hasKey("liquidVolume")) liquidVolume = compound.getInteger("liquidVolume");
        if (compound.hasKey("liquidId")) liquidId = compound.getInteger("liquidId");
    }

    @Override
    public ItemStackHandler getInventory() {
        return inventory;
    }

    @Override
    public int getInventorySize() {
        return size;
    }

    @Override
    public int getInventoryMaxIndex() {
        return size - 1;
    }
}
