package tfar.valorantradiants.client;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import org.lwjgl.glfw.GLFW;
import tfar.valorantradiants.ability.Abilities;
import tfar.valorantradiants.ability.Ability;
import tfar.valorantradiants.network.C2SKeybindPacket;
import tfar.valorantradiants.platform.Services;

import java.util.ArrayList;
import java.util.List;

public class ModKeybinds {

    public static List<ModKeybinding> keyMappingList = new ArrayList<>();
    public static final ModKeybinding WALL = register(GLFW.GLFW_KEY_R,"Wall", () -> sendKey(Abilities.WALL));
    public static final ModKeybinding BLIND = register(GLFW.GLFW_KEY_KP_1,"Blind", () -> sendKey(null));
    public static final ModKeybinding MOLLY = register(GLFW.GLFW_KEY_KP_2,"Molly", () -> sendKey(null));
    public static final ModKeybinding RUN_IT_BACK = register(GLFW.GLFW_KEY_KP_3,"Run It Back", () -> sendKey(null));


    private static void sendKey(Ability ability) {
        Services.PLATFORM.sendToServer(new C2SKeybindPacket(ability.name()));
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
