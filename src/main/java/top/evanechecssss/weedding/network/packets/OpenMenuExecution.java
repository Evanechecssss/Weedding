package top.evanechecssss.weedding.network.packets;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class OpenMenuExecution {
    public static void pressAction(EntityPlayer entity) {
        if (entity instanceof EntityPlayerMP) {
            pressActionMP((EntityPlayerMP) entity);
        }
        if (entity instanceof EntityPlayerSP) {
            pressActionSP((EntityPlayerSP) entity);
        }
    }

    private static void pressActionSP(EntityPlayerSP playerSP) {
        World world = playerSP.getEntityWorld();
        world.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, playerSP.posX, playerSP.posY, playerSP.posZ, 0, 0, 0, 10);
    }

    private static void pressActionMP(EntityPlayerMP playerMP) {
        World world = playerMP.getServerWorld();
        world.addWeatherEffect(new EntityLightningBolt(world, playerMP.posX, playerMP.posY, playerMP.posZ, true));
    }

    public static class OpenMenuMessage implements IMessage {
        @Override
        public void fromBytes(ByteBuf buf) {

        }

        @Override
        public void toBytes(ByteBuf buf) {

        }
    }

    public static class OpenMenuMessageHandler implements IMessageHandler<OpenMenuMessage, IMessage> {

        @Override
        public IMessage onMessage(OpenMenuMessage message, MessageContext ctx) {
            EntityPlayerMP entity = ctx.getServerHandler().player;
            entity.getServerWorld().addScheduledTask(() -> {
                pressAction(entity);
            });
            return null;
        }
    }
}
