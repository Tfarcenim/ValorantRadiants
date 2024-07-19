package tfar.valorantradiants.network;

import net.minecraft.resources.ResourceLocation;
import tfar.valorantradiants.ValorantRadiants;
import tfar.valorantradiants.platform.Services;

import java.util.Locale;

public class PacketHandler {

    public static void registerPackets() {
        Services.PLATFORM.registerServerPacket(C2SKeybindPacket.class,C2SKeybindPacket::new);

    }

    public static ResourceLocation packet(Class<?> clazz) {
        return ValorantRadiants.id(clazz.getName().toLowerCase(Locale.ROOT));
    }

}
