package top.evanechecssss.weedding.common.tiles;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.items.ItemStackHandler;
import top.evanechecssss.weedding.client.gui.base.IHasContainer;

public class BatteryBlockTE extends TileEntity implements IHasContainer {
    private final int size = 3;
    public ItemStackHandler inventory = new ItemStackHandler(size);

    public BatteryBlockTE() {

    }


    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
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
        return size;
    }

    @Override
    public int getInventoryMaxIndex() {
        return size - 1;
    }
}
