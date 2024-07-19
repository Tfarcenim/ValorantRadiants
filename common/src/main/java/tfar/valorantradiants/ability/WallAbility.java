package tfar.valorantradiants.ability;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import tfar.valorantradiants.init.ModItems;

public class WallAbility extends Ability {

    public WallAbility() {
        super("wall");
    }

    @Override
    public void equip(Player player) {
        if (player.getMainHandItem().isEmpty()) {
            player.setItemInHand(InteractionHand.MAIN_HAND, ModItems.FLAME_WALL.getDefaultInstance());
        }
    }
}
