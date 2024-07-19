package tfar.valorantradiants.mixin;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import tfar.valorantradiants.PlayerDuck;
import tfar.valorantradiants.ability.Radiant;
import tfar.valorantradiants.ability.Radiants;

@Mixin(Player.class)
public class PlayerMixin implements PlayerDuck {

    @Unique Radiant radiant;

    @Override
    public Radiant getRadiant() {
        return radiant;
    }

    @Override
    public void setRadiant(Radiant radiant) {
        this.radiant = radiant;
    }

    @Inject(method = "addAdditionalSaveData",at = @At("RETURN"))
    private void addAdd(CompoundTag tag, CallbackInfo ci) {
        if (radiant != null) {
            tag.putString("radiant",radiant.name());
        }
    }

    @Inject(method = "readAdditionalSaveData",at = @At("RETURN"))
    private void readAdd(CompoundTag tag, CallbackInfo ci) {
        if (tag.contains("radiant")) {
            radiant = Radiants.getRadiant(tag.getString("radiant"));
        }
    }


}
