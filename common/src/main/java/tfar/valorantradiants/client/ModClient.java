package tfar.valorantradiants.client;

public class ModClient {

    public static void clientTick() {
        for (ModKeybinds.ModKeybinding keyMapping : ModKeybinds.keyMappingList) {
            while (keyMapping.consumeClick()) {
                keyMapping.onPress.run();
            }
        }
    }
}
