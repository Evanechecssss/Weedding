package top.evanechecssss.weedding.init;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class WeeddingSounds {
    public static final SoundEvent SMOOTH_BONG = SoundRegistry.register("smooth_bong", new ResourceLocation(WeeddingInfo.MODID, "smooth_bong"));
    public static final SoundEvent BONG_ON_TABLE = SoundRegistry.register("bong_on_table", new ResourceLocation(WeeddingInfo.MODID, "bong_on_table"));
    public static final SoundEvent GOOD_PUFF = SoundRegistry.register("good_puff", new ResourceLocation(WeeddingInfo.MODID, "good_puff"));
    public static final SoundEvent HOOKAH_D = SoundRegistry.register("hookah", new ResourceLocation(WeeddingInfo.MODID, "hookah"));
    public static final SoundEvent HOOKAH_GIRL = SoundRegistry.register("hookah_girl", new ResourceLocation(WeeddingInfo.MODID, "hookah_girl"));
    public static final SoundEvent HORSE = SoundRegistry.register("horse", new ResourceLocation(WeeddingInfo.MODID, "horse"));
    public static final SoundEvent HORSE_RHAPSODY = SoundRegistry.register("horse_rhapsody", new ResourceLocation(WeeddingInfo.MODID, "horse_rhapsody"));
    public static final SoundEvent HORSE_SQUAD = SoundRegistry.register("horse_squad", new ResourceLocation(WeeddingInfo.MODID, "horse_squad"));
    public static final SoundEvent IF_U_HAVE_A_HEMP = SoundRegistry.register("if_u_have_a_hemp", new ResourceLocation(WeeddingInfo.MODID, "if_u_have_a_hemp"));
    public static final SoundEvent MY_HOOKAH = SoundRegistry.register("my_hookah", new ResourceLocation(WeeddingInfo.MODID, "my_hookah"));
    public static final SoundEvent KIRKUS_KILLER = SoundRegistry.register("kirkus_killer", new ResourceLocation(WeeddingInfo.MODID, "kirkus_killer"));

    public static final SoundEvent[] WEEDDING_SOUNDS = new SoundEvent[]{
            SMOOTH_BONG, BONG_ON_TABLE, GOOD_PUFF, HOOKAH_GIRL, HORSE, HOOKAH_D, HORSE_RHAPSODY, HORSE_SQUAD, MY_HOOKAH, IF_U_HAVE_A_HEMP, KIRKUS_KILLER
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
