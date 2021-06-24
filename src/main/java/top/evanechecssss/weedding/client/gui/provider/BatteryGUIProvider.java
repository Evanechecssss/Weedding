package top.evanechecssss.weedding.client.gui.provider;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import top.evanechecssss.weedding.client.gui.base.ContainerBase;
import top.evanechecssss.weedding.client.gui.base.ContainerGUIBase;
import top.evanechecssss.weedding.common.tiles.BatteryBlockTE;
import top.evanechecssss.weedding.init.WeeddingInfo;


public class BatteryGUIProvider {

    public static ContainerBase BatteryContainerSet(EntityPlayer player, World world, int x, int y, int z) {
        BatteryBlockTE tileEntity = (BatteryBlockTE) world.getTileEntity(new BlockPos(x, y, z));
        ContainerBase<BatteryBlockTE> containerBase = new ContainerBase<>(player.inventory, tileEntity, true, true);
        containerBase.addPlayerInventory(player.inventory, 8, 84, 58, true);
        containerBase.addContainerSlot(1, 56, 17);
        containerBase.addContainerSlot(0, 56, 53);
        containerBase.addContainerSlot(2, 112, 31);
        return containerBase;
    }

    public static ContainerGUIBase BatteryGUISet(EntityPlayer player, World world, int x, int y, int z) {
        ResourceLocation location = new ResourceLocation(WeeddingInfo.MODID, "textures/gui/furnace.png");
        BatteryBlockTE tileEntity = (BatteryBlockTE) world.getTileEntity(new BlockPos(x, y, z));
        ContainerBase container = BatteryContainerSet(player, world, x, y, z);
        ContainerGUIBase base = new ContainerGUIBase(tileEntity, container, location, 176, 166, true, true);
        int[] list = new int[3];
        list[0] = 36;
        list[1] = 37;
        list[2] = 38;
        base.changeSlotSize(27, list);
        return base;
    }
}
