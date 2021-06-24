package top.evanechecssss.weedding.handlers;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.AdvancementEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import top.evanechecssss.weedding.Weedding;
import top.evanechecssss.weedding.init.WeeddingKeybinds;
import top.evanechecssss.weedding.network.packets.OpenMenuExecution;

public class WeeddingEventHandler {
    private boolean f = false;


    @SubscribeEvent
    public void advancementCompleted(AdvancementEvent event) {
        if (event.getAdvancement().getId().equals(new ResourceLocation("weedding:hookah/dafuk_loader"))) {
            AdvancementExecution.dafukLoaderExecute(event);
        }
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public void keyInput(InputEvent.KeyInputEvent event) {
        if (WeeddingKeybinds.OPEN_MENU.isPressed()) {
            Weedding.NETWORK.sendToServer(new OpenMenuExecution.OpenMenuMessage());
            KeyInputExecution.openMenuKeyBind(Minecraft.getMinecraft().player);
        }
    }

    private static class AdvancementExecution {
        private static void dafukLoaderExecute(AdvancementEvent event) {
            EntityPlayer player = event.getEntityPlayer();
            World world = player.getEntityWorld();
            player.sendMessage(new TextComponentTranslation("weedding.chat.message.dafuk.variant" + (int) Math.round(Math.random() * 3 + 1), player.getName()));
            for (int i = 0; i < 20; i++) {
                EntityLightningBolt lightningBolt = new EntityLightningBolt(world, player.posX + (int) Math.round(Math.random() * 8 - 4), player.posY, player.posZ + (int) Math.round(Math.random() * 8 - 4), false);
                EntityLightningBolt lightningBoltFake = new EntityLightningBolt(world, player.posX + (int) Math.round(Math.random() * 8 - 4), player.posY, player.posZ + (int) Math.round(Math.random() * 8 - 4), true);
                world.addWeatherEffect(lightningBolt);
                world.addWeatherEffect(lightningBoltFake);
            }
        }
    }

    private static class KeyInputExecution {

        private static void openMenuKeyBind(EntityPlayer entityPlayer) {
            OpenMenuExecution.pressAction(entityPlayer);
        }
    }

}
