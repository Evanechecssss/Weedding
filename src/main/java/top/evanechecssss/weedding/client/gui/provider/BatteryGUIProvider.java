package top.evanechecssss.weedding.client.gui.provider;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import top.evanechecssss.weedding.client.gui.base.ContainerBase;
import top.evanechecssss.weedding.client.gui.base.ContainerGUIBase;
import top.evanechecssss.weedding.common.blocks.BatteryBlock;
import top.evanechecssss.weedding.init.WeeddingInfo;

public class BatteryGUIProvider {

    public static ContainerBase BatteryContainerSet(EntityPlayer player, World world, int x, int y, int z) {
        BatteryBlock.BatteryBlockTE tileEntity = (BatteryBlock.BatteryBlockTE) world.getTileEntity(new BlockPos(x, y, z));
        ContainerBase<BatteryBlock.BatteryBlockTE> containerBase = new ContainerBase<>(player.inventory, tileEntity, true, true);
        containerBase.addPlayerInventory(player.inventory);
        containerBase.addContainerSlot(0,55,16);
        containerBase.addContainerSlot(1,55,52);
        containerBase.addContainerSlot(2,155,34);
        return containerBase;
    }

    public static ContainerGUIBase BatteryGUISet(EntityPlayer player, World world, int x, int y, int z) {
        ResourceLocation location = new ResourceLocation(WeeddingInfo.MODID, "textures/gui/furnace.png");
        BatteryBlock.BatteryBlockTE tileEntity = (BatteryBlock.BatteryBlockTE) world.getTileEntity(new BlockPos(x, y, z));
        ContainerBase container = BatteryContainerSet(player, world, x, y, z);
        return new ContainerGUIBase(tileEntity, container, location, 173, 185, true, true);
    }
}
