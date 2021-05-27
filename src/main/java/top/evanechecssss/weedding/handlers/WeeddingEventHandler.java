package top.evanechecssss.weedding.handlers;

import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.AdvancementEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Random;

public class WeeddingEventHandler {

    @SubscribeEvent
    public void advancementCompleted(AdvancementEvent event) {
        if (event.getAdvancement().getId().equals(new ResourceLocation("weedding:hookah/dafuk_loader"))) {
            AdvancementExecution.dafukLoaderExecute(event);
        }
    }

    private static class AdvancementExecution {
        private static void dafukLoaderExecute(AdvancementEvent event) {
            EntityPlayer player = event.getEntityPlayer();
            World world = player.getEntityWorld();
            Random random = new Random();
            player.sendMessage(new TextComponentTranslation("weedding.chat.message.dafuk.variant" + (int) Math.round(Math.random() * 3 + 1), player.getName()));
            for (int i = 0; i < 10; i++) {
                EntityLightningBolt lightningBolt = new EntityLightningBolt(world, player.posX + random.nextInt(2), player.posY, player.posZ + random.nextInt(2), false);
                world.spawnEntity(lightningBolt);
            }
        }
    }
}
