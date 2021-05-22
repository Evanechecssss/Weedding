package top.evanechecssss.weedding.common.blocks.types;

import net.minecraft.util.IStringSerializable;

public enum GramophoneTypes implements IStringSerializable {
    IRON("iron"), GOLDEN("gold");
    public final String name;

    GramophoneTypes(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

}
