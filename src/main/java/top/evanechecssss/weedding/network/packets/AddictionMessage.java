package top.evanechecssss.weedding.network.packets;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import top.evanechecssss.weedding.network.capability.main.Addiction;

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
        addiction = buf.readFloat();

    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeFloat(addiction);
    }

    public static class AddictionMessageHandler implements IMessageHandler<AddictionMessage, IMessage> {

        @Override
        public IMessage onMessage(AddictionMessage message, MessageContext ctx) {
            if (ctx.side.isClient()) {
                this.handleAddiction(message, ctx);
            }

            return null;
        }

        @SideOnly(Side.CLIENT)
        private void handleAddiction(AddictionMessage message, MessageContext ctx) {
            EntityPlayerSP player = Minecraft.getMinecraft().player;

            Minecraft.getMinecraft().addScheduledTask(() -> {
                Addiction.get(player).set(message.addiction);
            });
        }
    }
}
