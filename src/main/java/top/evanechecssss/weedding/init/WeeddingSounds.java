package top.evanechecssss.weedding.init;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import top.evanechecssss.weedding.utils.reference.WeeddingInfo;

public class WeeddingSounds {
    public static final SoundEvent SMOOTH_BONG = SoundRegistry.register("smooth_bong", new ResourceLocation(WeeddingInfo.MODID, "music/smooth_bong"));
    public static final SoundEvent[] WEEDDING_SOUNDS = new SoundEvent[]{
            SMOOTH_BONG
    };

    public static class SoundRegistry {
        private static SoundEvent register(String name, ResourceLocation location) {
            return new SoundEvent(location).setRegistryName(name);
        }

        @SubscribeEvent
        public void register(RegistryEvent.Register<SoundEvent> e) {
            for (SoundEvent soundEvent : WEEDDING_SOUNDS) {
                ForgeRegistries.SOUND_EVENTS.register(soundEvent);
            }
        }
    }
}
