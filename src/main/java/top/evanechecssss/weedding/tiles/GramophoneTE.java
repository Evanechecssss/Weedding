package top.evanechecssss.weedding.tiles;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import org.jetbrains.annotations.Nullable;

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
        markDirty();

    }

    @Override
    public NBTTagCompound getUpdateTag() {
        return writeToNBT(new NBTTagCompound());
    }

    @Nullable
    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        return new SPacketUpdateTileEntity(pos, 3, this.getUpdateTag());
    }

    @Override
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
        super.onDataPacket(net, pkt);
        this.handleUpdateTag(pkt.getNbtCompound());
    }
}
