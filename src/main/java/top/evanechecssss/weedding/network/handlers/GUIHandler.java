package top.evanechecssss.weedding.network.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import org.jetbrains.annotations.Nullable;
import top.evanechecssss.weedding.client.gui.GUIChestOfLiquids;
import top.evanechecssss.weedding.common.containers.ContainerChestOfLiquids;
import top.evanechecssss.weedding.common.tileEntitys.ChestOfLiquidsTE;
import top.evanechecssss.weedding.utils.reference.WeeddingGUIs;

public class GUIHandler implements IGuiHandler {
    @Nullable
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == WeeddingGUIs.CHEST_OF_LIQUIDS) {
            return new ContainerChestOfLiquids(player.inventory, (ChestOfLiquidsTE) world.getTileEntity(new BlockPos(x, y, z)));
        }
        return null;
    }

    @Nullable
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == WeeddingGUIs.CHEST_OF_LIQUIDS) {
            return new GUIChestOfLiquids(new ContainerChestOfLiquids(player.inventory, (ChestOfLiquidsTE) world.getTileEntity(new BlockPos(x, y, z))), (ChestOfLiquidsTE) world.getTileEntity(new BlockPos(x, y, z)), player);
        }
        return null;
    }
}
