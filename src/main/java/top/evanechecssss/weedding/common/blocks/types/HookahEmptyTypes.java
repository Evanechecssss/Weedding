package top.evanechecssss.weedding.common.blocks.types;

import net.minecraft.util.IStringSerializable;

public enum HookahEmptyTypes implements IStringSerializable {
    BLACK("black"),
    BLUE("blue"),
    BROWN("brown"),
    CYAN("cyan"),
    GRAY("gray"),
    GREEN("green"),
    LIGHTBLUE("lightblue"),
    LIME("lime"),
    MAGENTA("magenta"),
    ORANGE("orange"),
    PINK("pink"),
    PURPLE("purple"),
    RED("red"),
    SILVER("silver"),
    WHITE("white"),
    YELLOW("yellow");
    public final String name;

    HookahEmptyTypes(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

}
