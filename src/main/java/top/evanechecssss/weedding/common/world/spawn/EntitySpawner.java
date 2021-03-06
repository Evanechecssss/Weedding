package top.evanechecssss.weedding.common.world.spawn;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import top.evanechecssss.weedding.common.entities.EntityDafuk;

public class EntitySpawner {
    public static void spawnEntities() {
        spawnEntity();
    }

    private static void spawnEntity() {
        spawnDafuk();
    }

    private static void spawnDafuk() {
        for (Biome biome : Biome.REGISTRY) {
            if (biome.getTempCategory() == Biome.TempCategory.MEDIUM) {
                EntityRegistry.addSpawn(EntityDafuk.class, 1, 1, 5, EnumCreatureType.AMBIENT, biome);
            }
        }
    }
}
