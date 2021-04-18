package top.evanechecssss.weedding.network.capability.provider;


import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import top.evanechecssss.weedding.network.capability.interfaces.IAddiction;

public class AddictionProvider implements ICapabilitySerializable<NBTBase> {
    @CapabilityInject(IAddiction.class)
    public static final Capability<IAddiction> ADDICTION_CAPABILITY = null;
    private final IAddiction instance = ADDICTION_CAPABILITY.getDefaultInstance();

    @Override
    public boolean hasCapability(@NotNull Capability<?> capability, @Nullable EnumFacing facing) {
        return capability == ADDICTION_CAPABILITY;
    }

    @Nullable
    @Override
    public <T> T getCapability(@NotNull Capability<T> capability, @Nullable EnumFacing facing) {
        return capability == ADDICTION_CAPABILITY ? ADDICTION_CAPABILITY.cast(this.instance) : null;
    }

    @Override
    public NBTBase serializeNBT() {
        return ADDICTION_CAPABILITY.getStorage().writeNBT(ADDICTION_CAPABILITY, this.instance, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        ADDICTION_CAPABILITY.getStorage().readNBT(ADDICTION_CAPABILITY, this.instance, null, nbt);
    }
}
