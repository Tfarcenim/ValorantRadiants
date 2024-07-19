package tfar.valorantradiants.ability;

import net.minecraft.world.entity.player.Player;

public abstract class Ability {

    private final String name;

    public Ability(String name) {

        this.name = name;
    }

    public String name() {
        return name;
    }

    public abstract void equip(Player player);

}
