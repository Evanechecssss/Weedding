package top.evanechecssss.weedding.tiles;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class GramophoneTE extends TileEntity {
    private ItemStack record = ItemStack.EMPTY;

    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);

        if (compound.hasKey("RecordItem")) {
            this.setRecord(new ItemStack(compound.getCompoundTag("RecordItem")));
        }
    }

    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);

        if (!this.getRecord().isEmpty()) {
            compound.setTag("RecordItem", this.getRecord().writeToNBT(new NBTTagCompound()));
        }

        return compound;
    }

    public ItemStack getRecord() {
        return record;
    }

    public void setRecord(ItemStack recordStack) {
        this.record = recordStack;
        this.markDirty();
    }

}
