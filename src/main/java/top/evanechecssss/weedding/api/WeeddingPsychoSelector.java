package top.evanechecssss.weedding.api;

import com.google.common.base.Predicate;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.common.IEntitySelectorFactory;
import org.jetbrains.annotations.NotNull;
import top.evanechecssss.weedding.entities.EntityDafuk;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WeeddingPsychoSelector implements IEntitySelectorFactory {
    public static final String ARGUMENT_WEEDDING_PSYCHO = "o";

    @NotNull
    @Override
    public List<Predicate<Entity>> createPredicates(Map<String, String> arguments, String mainSelector, ICommandSender sender, Vec3d position) {
        List<Predicate<Entity>> list = new ArrayList<Predicate<Entity>>();
        list.add((e) -> e instanceof EntityDafuk);
        return list;
    }
}
