package top.evanechecssss.weedding.common.tileEntitys;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.items.ItemStackHandler;

public class HookahEmptyTE extends TileEntity {
    public ItemStackHandler inventory = new ItemStackHandler(3);
    private int liquidVolume = 0;
    private int liquidId = 0;

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

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        if (compound.hasKey("inventory")) inventory.deserializeNBT((NBTTagCompound) compound.getTag("inventory"));
        if (compound.hasKey("liquidVolume")) liquidVolume = compound.getInteger("liquidVolume");
        if (compound.hasKey("liquidId")) liquidId = compound.getInteger("liquidId");
    }

    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        NBTTagCompound nbt = new NBTTagCompound();
        this.writeToNBT(nbt);
        int metadata = getBlockMetadata();
        return new SPacketUpdateTileEntity(this.pos, metadata, nbt);
    }

    @Override
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
        this.readFromNBT(pkt.getNbtCompound());
    }

    @Override
    public NBTTagCompound getUpdateTag() {
        NBTTagCompound nbt = new NBTTagCompound();
        this.writeToNBT(nbt);
        return nbt;
    }

    @Override
    public void handleUpdateTag(NBTTagCompound tag) {
        this.readFromNBT(tag);
    }

    @Override
    public NBTTagCompound getTileData() {
        NBTTagCompound nbt = new NBTTagCompound();
        this.writeToNBT(nbt);
        return nbt;
    }
}
