package top.evanechecssss.weedding.tiles;

import io.netty.buffer.ByteBuf;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

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
        new GramophoneMessage(record);
    }

    public static class GramophoneMessage implements IMessage {

        private ItemStack toSend;

        public GramophoneMessage() {
        }

        public GramophoneMessage(ItemStack toSend) {
            this.toSend = toSend;
        }

        @Override
        public void fromBytes(ByteBuf buf) {
            toSend = ByteBufUtils.readItemStack(buf);
        }

        @Override
        public void toBytes(ByteBuf buf) {
            ByteBufUtils.writeItemStack(buf, toSend);
        }
    }

    public static class GramophoneMessageHandler implements IMessageHandler<GramophoneMessage, IMessage> {
        @Override
        public IMessage onMessage(GramophoneMessage message, MessageContext ctx) {

            return null;
        }
    }
}
