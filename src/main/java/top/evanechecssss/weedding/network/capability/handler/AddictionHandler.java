package top.evanechecssss.weedding.network.capability.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import top.evanechecssss.weedding.network.capability.provider.AddictionProvider;
import top.evanechecssss.weedding.utils.reference.WeeddingInfo;

public class AddictionHandler {
    public static final ResourceLocation Addiction_CAP = new ResourceLocation(WeeddingInfo.MODID, "addiction");

    @SubscribeEvent
    public void attachCapability(AttachCapabilitiesEvent event) {
        if (!(event.getObject() instanceof EntityPlayer)) return;

        event.addCapability(Addiction_CAP, new AddictionProvider());
    }
}
