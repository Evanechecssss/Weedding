package top.evanechecssss.weedding.world.spawn;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import top.evanechecssss.weedding.entities.EntityDafuk;

public class WeeddingEntitySpawner {
    public static void spawnEntities() {
        spawnEntity();
    }

    private static void spawnEntity() {
        spawnDafuk();
    }

    private static void spawnDafuk() {
        EntityRegistry.addSpawn(EntityDafuk.class, 5, 1, 10, EnumCreatureType.MONSTER, Biomes.FOREST);
    }
}
