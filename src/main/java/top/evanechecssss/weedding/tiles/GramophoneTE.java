package top.evanechecssss.weedding.tiles;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

import javax.annotation.Nullable;

public class GramophoneTE extends TileEntity {
    private ItemStack record = ItemStack.EMPTY;

    public GramophoneTE() {

    }

    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);

        if (compound.hasKey("RecordItem")) {
            this.setRecord(new ItemStack(compound.getCompoundTag("RecordItem")));
        }
    }

    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        if (!this.record.isEmpty()) {
            compound.setTag("RecordItem", this.record.serializeNBT());
        }
        return super.writeToNBT(compound);
    }

    public ItemStack getRecord() {
        return record;
    }

    public void setRecord(ItemStack recordStack) {
        this.record = recordStack;
        this.markDirty();
    }

    @Override
    @Nullable
    public SPacketUpdateTileEntity getUpdatePacket() {

        return new SPacketUpdateTileEntity(this.pos, 3, this.getUpdateTag());
    }

    @Override
    public NBTTagCompound getUpdateTag() {

        return this.writeToNBT(new NBTTagCompound());
    }

    @Override
    public void onDataPacket(NetworkManager networkManager, SPacketUpdateTileEntity packet) {

        super.onDataPacket(networkManager, packet);

        this.handleUpdateTag(packet.getNbtCompound());
    }

}
