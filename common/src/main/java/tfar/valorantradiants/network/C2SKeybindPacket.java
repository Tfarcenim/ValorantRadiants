package tfar.valorantradiants.network;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import tfar.valorantradiants.PlayerDuck;
import tfar.valorantradiants.ability.Abilities;
import tfar.valorantradiants.ability.Ability;
import tfar.valorantradiants.ability.Radiant;

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
        PlayerDuck playerDuck = PlayerDuck.of(player);
        Radiant radiant = playerDuck.getRadiant();
        if (radiant != null) {
            Ability ability = Abilities.getAbility(this.ability);
            if (radiant.usable().contains(ability)) {
                ability.equip(player);
            }
        }
    }

    @Override
    public void write(FriendlyByteBuf to) {
        to.writeUtf(ability);
    }
}
