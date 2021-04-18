package top.evanechecssss.weedding.network.capability.main;

import net.minecraft.entity.player.EntityPlayer;
import top.evanechecssss.weedding.network.capability.interfaces.IAddiction;
import top.evanechecssss.weedding.network.capability.provider.AddictionProvider;

public class Addiction implements IAddiction {
    private float addiction = 0F;

    public static IAddiction get(EntityPlayer player) {
        return player.getCapability(AddictionProvider.ADDICTION_CAPABILITY, null);
    }

    @Override
    public void consume(float points) {
        if (this.addiction > 0) this.addiction -= points;

    }

    @Override
    public void fill(float points) {
        this.addiction += points;
    }

    @Override
    public void set(float points) {
        this.addiction = points;
    }

    @Override
    public float getAddiction() {
        return this.addiction;
    }
}
