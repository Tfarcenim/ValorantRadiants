package tfar.valorantradiants.mixin;

import tfar.valorantradiants.ValorantRadiants;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MixinMinecraft {
    
    @Inject(at = @At("TAIL"), method = "<init>")
    private void init(CallbackInfo info) {
        
        ValorantRadiants.LOG.info("This line is printed by an example mod common mixin!");
        ValorantRadiants.LOG.info("MC Version: {}", Minecraft.getInstance().getVersionType());
    }
}