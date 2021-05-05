package top.evanechecssss.weedding.init;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import org.jetbrains.annotations.Nullable;
import top.evanechecssss.weedding.gui.provider.HookahGUIProvider;

public class WeeddingGUIs {
    public static final int HOOKAH_GUI = 0;
    public static class GUIHandler implements IGuiHandler {
        @Nullable
        @Override
        public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
            switch (ID) {
                case WeeddingGUIs.HOOKAH_GUI:
                    return HookahGUIProvider.HookahGUISet(player, world, x, y, z);
            }
            return null;
        }

        @Nullable
        @Override
        public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
            switch (ID) {
                case WeeddingGUIs.HOOKAH_GUI:
                    return HookahGUIProvider.HookahContainerSet(player, world, x, y, z);
            }
            return null;
        }


    }

}
