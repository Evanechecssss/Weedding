package top.evanechecssss.weedding.common.tileEntitys;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.items.ItemStackHandler;

public class ChestOfLiquidsTE extends TileEntity {
    public ItemStackHandler inventory = new ItemStackHandler(19);

    public ChestOfLiquidsTE() {
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

}
