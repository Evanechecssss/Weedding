package top.evanechecssss.weedding.client.gui.provider;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import top.evanechecssss.weedding.client.gui.base.ContainerBase;
import top.evanechecssss.weedding.client.gui.base.ContainerGUIBase;
import top.evanechecssss.weedding.common.tiles.HookahEmptyTE;
import top.evanechecssss.weedding.init.WeeddingInfo;

public class HookahGUIProvider {
    public static ContainerBase HookahContainerSet(EntityPlayer player, World world, int x, int y, int z) {
        HookahEmptyTE tileEntity = (HookahEmptyTE) world.getTileEntity(new BlockPos(x, y, z));
        ContainerBase<HookahEmptyTE> containerBase = new ContainerBase<>(player.inventory, tileEntity, true, true);
        containerBase.addPlayerInventory(player.inventory);
        containerBase.addContainerSlot(1, 25, 23);
        return containerBase;
    }

    public static ContainerGUIBase HookahGUISet(EntityPlayer player, World world, int x, int y, int z) {
        ResourceLocation location = new ResourceLocation(WeeddingInfo.MODID, "textures/gui/hookah.png");
        HookahEmptyTE tileEntity = (HookahEmptyTE) world.getTileEntity(new BlockPos(x, y, z));
        ContainerBase container = HookahContainerSet(player, world, x, y, z);
        return new ContainerGUIBase(tileEntity, container, location, 173, 185, true, true);
    }
}