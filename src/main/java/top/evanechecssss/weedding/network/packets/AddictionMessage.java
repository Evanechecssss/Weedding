package top.evanechecssss.weedding.network.packets;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import top.evanechecssss.weedding.network.capability.provider.AddictionProvider;

public class AddictionMessage implements IMessage {

    private float addiction;

    public AddictionMessage() {
    }

    public AddictionMessage(float addiction) {
        this.addiction = addiction;
    }

    public float AddictionGet() {
        return addiction;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        buf.writeFloat(addiction);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        addiction = buf.readFloat();
    }

    public static class AddictionMassageHandler implements IMessageHandler<AddictionMessage, IMessage> {

        @Override
        public IMessage onMessage(AddictionMessage message, MessageContext ctx) {
            EntityPlayerMP serverPlayer = ctx.getServerHandler().player;
            float addiction = message.addiction;
            serverPlayer.getServerWorld().addScheduledTask(() -> {
                serverPlayer.getCapability(AddictionProvider.ADDICTION_CAPABILITY, null).set(addiction);
            });
            WeeddingPacketHandler.INSTANCE.sendTo(new AddictionMessage(), serverPlayer);
            return null;
        }
    }
}
