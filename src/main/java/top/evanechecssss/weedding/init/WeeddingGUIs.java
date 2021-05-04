package top.evanechecssss.weedding.init;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import org.jetbrains.annotations.Nullable;
import top.evanechecssss.weedding.common.tileEntitys.HookahEmptyTE;
import top.evanechecssss.weedding.utils.base.gui.ContainerBase;
import top.evanechecssss.weedding.utils.base.gui.ContainerGUIBase;
import top.evanechecssss.weedding.utils.reference.WeeddingInfo;

public class WeeddingGUIs {
    public static final int HOOKAH_GUI = 0;

    public static class GUIHandler implements IGuiHandler {

        @Nullable
        @Override
        public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
            switch (ID) {
                case WeeddingGUIs.HOOKAH_GUI:
                    return HookahGUISet(player, world, x, y, z);
            }
            return null;
        }

        @Nullable
        @Override
        public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
            switch (ID) {
                case WeeddingGUIs.HOOKAH_GUI:
                    return HookahContainerSet(player, world, x, y, z);
            }
            return null;
        }

        private ContainerBase HookahGUISet(EntityPlayer player, World world, int x, int y, int z) {
            HookahEmptyTE tileEntity = (HookahEmptyTE) world.getTileEntity(new BlockPos(x, y, z));
            ContainerBase<HookahEmptyTE> containerBase = new ContainerBase<>(player.inventory, tileEntity, true, true);
            containerBase.addPlayerInventoryBar(player.inventory);
            return containerBase;
        }

        private ContainerGUIBase HookahContainerSet(EntityPlayer player, World world, int x, int y, int z) {
            ResourceLocation location = new ResourceLocation(WeeddingInfo.MODID, "textures/gui/hookah.png");
            HookahEmptyTE tileEntity = (HookahEmptyTE) world.getTileEntity(new BlockPos(x, y, z));
            ContainerBase container = HookahGUISet(player, world, x, y, z);
            return new ContainerGUIBase<>(tileEntity, container, location, 173, 185, true, true);
        }
    }
}
