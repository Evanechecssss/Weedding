package top.evanechecssss.weedding.init;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.input.Keyboard;
import org.omg.CORBA.PUBLIC_MEMBER;

public class WeeddingKeybinds {
    private static final String CATEGORY1 = "WEEDDING";
    private static final String CATEGORY2 = "EXOSKELETON";
    public static final KeyBinding OPEN_MENU = new KeyBinding("weedding.key.open_menu", Keyboard.KEY_I, CATEGORY1);
    public static final KeyBinding SHOW_KEYS = new KeyBinding("weedding.key.show_keys",Keyboard.KEY_LSHIFT,CATEGORY2);
    public static final KeyBinding NAV = new KeyBinding("weedding.key.nav",Keyboard.KEY_Z,CATEGORY2);
    public static final KeyBinding NAV_EFFECT = new KeyBinding("weedding.key.nav_effect",Keyboard.KEY_1,CATEGORY2);
    public static final KeyBinding NAV_FLY = new KeyBinding("weedding.key.nav_fly",Keyboard.KEY_2,CATEGORY2);

    public static class KeybindsRegister {
        public static void register() {
            setRegister(OPEN_MENU);
            setRegister(SHOW_KEYS);
            setRegister(NAV);
            setRegister(NAV_EFFECT);
            setRegister(NAV_FLY);
        }

        private static void setRegister(KeyBinding binding) {
            ClientRegistry.registerKeyBinding(binding);
        }
    }
}
