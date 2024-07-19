package tfar.valorantradiants.network;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import tfar.elixirsmps2.PlayerDuck;
import tfar.elixirsmps2.elixir.Elixir;

public class C2SKeybindPacket implements C2SModPacket{

    String ability;

    public C2SKeybindPacket(String ability) {
        this.ability = ability;
    }

    public C2SKeybindPacket(FriendlyByteBuf buf) {
        ability = buf.readUtf();
    }

    @Override
    public void handleServer(ServerPlayer player) {

    }

    @Override
    public void write(FriendlyByteBuf to) {
        to.writeUtf(ability);
    }
}
