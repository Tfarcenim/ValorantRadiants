package tfar.valorantradiants.client;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import org.lwjgl.glfw.GLFW;

import java.util.ArrayList;
import java.util.List;

public class ModKeybinds {

    public static List<ModKeybinding> keyMappingList = new ArrayList<>();
    public static final ModKeybinding WALL = register(GLFW.GLFW_KEY_KP_0,"Wall", () -> sendKey(0));
    public static final ModKeybinding BLIND = register(GLFW.GLFW_KEY_KP_1,"Blind", () -> sendKey(1));
    public static final ModKeybinding MOLLY = register(GLFW.GLFW_KEY_KP_2,"Molly", () -> sendKey(2));
    public static final ModKeybinding RUN_IT_BACK = register(GLFW.GLFW_KEY_KP_3,"Run It Back", () -> sendKey(3));


    private static void sendKey(String s) {
    }

    public static class ModKeybinding extends KeyMapping {

        public final Runnable onPress;

        public ModKeybinding(String $$0, int $$1, String $$2, Runnable onPress) {
            this($$0, InputConstants.Type.KEYSYM, $$1, $$2,onPress);
        }

        public ModKeybinding(String $$0, InputConstants.Type $$1, int $$2, String $$3, Runnable onPress) {
            super($$0, $$1, $$2, $$3);
            this.onPress = onPress;
        }
    }

    static ModKeybinding register(int keyCode,String name,Runnable onPress) {
        ModKeybinding keyMapping = new ModKeybinding(name, keyCode, "Elixir Abilities",onPress);
        keyMappingList.add(keyMapping);
        return keyMapping;
    }

}
