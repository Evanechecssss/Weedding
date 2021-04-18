package top.evanechecssss.weedding.network.capability.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import top.evanechecssss.weedding.network.capability.interfaces.IAddiction;
import top.evanechecssss.weedding.network.capability.provider.AddictionProvider;

public class AddictionController {

    @SubscribeEvent
    public void onDeath(LivingDeathEvent e) {
        if (e.getEntity() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) e.getEntity();
            IAddiction addiction = player.getCapability(AddictionProvider.ADDICTION_CAPABILITY, null);
            player.sendMessage(new TextComponentString("Вы накопили зависимости:" + addiction.getAddiction()));
            player.sendStatusMessage(new TextComponentString("На свете нет прекрасней красоты, чем абсстененция морфинного генеза"), true);
        }
    }
}
