package top.evanechecssss.weedding.network.capability.main;

import top.evanechecssss.weedding.network.capability.interfaces.IAddiction;

public class Addiction implements IAddiction {
    private float addiction = 0F;

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
