package com.evanko.likewise.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

import javax.annotation.Nullable;
import java.util.UUID;

public class InfoBlockTE extends TileEntity {
    private String playerName,uuid = "d";
    private float health = 5.5F;
    private int foodLevel,exp =210;
    public void setPlayerName(String playerName){
        this.playerName = playerName;
        this.markDirty();
    }
    public void setUUID(String uuid){
        this.uuid = uuid;
        this.markDirty();
    }
    public UUID getUUID(){
       return UUID.fromString(uuid);
    }

    public float getHealth() {
        return this.health;
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public int getExp() {
        return this.exp;
    }

    public int getFoodLevel() {
        return this.foodLevel;
    }

    public void setHealth(float health){
        this.health = health;
        this.markDirty();
    }
    public void setFoodLevel(int foodLevel){
        this.foodLevel = foodLevel;
        this.markDirty();
    }
    public void setEXP(int exp){
        this.exp = exp;
        this.markDirty();
    }
    @Override
    public void readFromNBT(NBTTagCompound compound) {
        this.playerName=compound.getString("playerName");
        this.uuid=compound.getString("playerUUID");
        this.health=compound.getInteger("playerHealth");
        this.foodLevel=compound.getInteger("playerFoodLevel");
        this.exp=compound.getInteger("playerEXP");
        super.readFromNBT(compound);
    }
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound.setString("playerName",this.playerName);
        compound.setString("playerUUID",this.uuid);
        compound.setFloat("playerHealth",this.health);
        compound.setInteger("playerFoodLevel",this.foodLevel);
        compound.setInteger("playerEXP",this.exp);
        return super.writeToNBT(compound);
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
