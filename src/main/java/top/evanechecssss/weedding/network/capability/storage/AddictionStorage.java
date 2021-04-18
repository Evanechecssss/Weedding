package top.evanechecssss.weedding.network.capability.storage;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import org.jetbrains.annotations.Nullable;
import top.evanechecssss.weedding.network.capability.interfaces.IAddiction;

public class AddictionStorage implements Capability.IStorage<IAddiction> {
    @Nullable
    @Override
    public NBTBase writeNBT(Capability<IAddiction> capability, IAddiction instance, EnumFacing side) {
        return new NBTTagFloat(instance.getAddiction());
    }

    @Override
    public void readNBT(Capability<IAddiction> capability, IAddiction instance, EnumFacing side, NBTBase nbt) {
        instance.set(((NBTPrimitive) nbt).getFloat());
    }


}
