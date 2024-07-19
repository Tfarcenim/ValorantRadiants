package tfar.valorantradiants;

import net.minecraft.world.entity.player.Player;
import tfar.valorantradiants.ability.Radiant;

public interface PlayerDuck {

    Radiant getRadiant();
    void setRadiant(Radiant radiant);

    static PlayerDuck of(Player player) {
        return (PlayerDuck) player;
    }
}
