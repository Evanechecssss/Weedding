package top.evanechecssss.weedding.init;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.input.Keyboard;

public class WeeddingKeybinds {
    private static final String CATEGORY = "WEEDDING";
    public static final KeyBinding OPEN_MENU = new KeyBinding("weedding.key.open_menu", Keyboard.KEY_I, CATEGORY);

    public static class KeybindsRegister {

        public static void register() {
            setRegister(OPEN_MENU);
        }

        private static void setRegister(KeyBinding binding) {
            ClientRegistry.registerKeyBinding(binding);
        }
    }
}
