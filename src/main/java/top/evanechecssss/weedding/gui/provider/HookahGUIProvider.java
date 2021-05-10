package top.evanechecssss.weedding.gui.provider;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import top.evanechecssss.weedding.tiles.HookahEmptyTE;
import top.evanechecssss.weedding.utils.gui.ContainerBase;
import top.evanechecssss.weedding.utils.gui.ContainerGUIBase;
import top.evanechecssss.weedding.utils.reference.WeeddingInfo;

public class HookahGUIProvider {
    public static ContainerBase HookahGUISet(EntityPlayer player, World world, int x, int y, int z) {
        HookahEmptyTE tileEntity = (HookahEmptyTE) world.getTileEntity(new BlockPos(x, y, z));
        ContainerBase<HookahEmptyTE> containerBase = new ContainerBase<>(player.inventory, tileEntity, true, true);
        containerBase.addPlayerInventoryBar(player.inventory);

        return containerBase;
    }
    public static ContainerGUIBase HookahContainerSet(EntityPlayer player, World world, int x, int y, int z) {
        ResourceLocation location = new ResourceLocation(WeeddingInfo.MODID, "textures/gui/hookah.png");
        HookahEmptyTE tileEntity = (HookahEmptyTE) world.getTileEntity(new BlockPos(x, y, z));
        ContainerBase container = HookahGUISet(player, world, x, y, z);
        return new ContainerGUIBase(tileEntity, container, location, 173, 185, true, true);
    }
}