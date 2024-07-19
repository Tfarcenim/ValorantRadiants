package tfar.valorantradiants;

import net.minecraftforge.fml.common.Mod;

@Mod(ValorantRadiants.MOD_ID)
public class ValorantRadiantsForge {
    
    public ValorantRadiantsForge() {
    
        // This method is invoked by the Forge mod loader when it is ready
        // to load your mod. You can access Forge and Common code in this
        // project.
    
        // Use Forge to bootstrap the Common mod.
        ValorantRadiants.LOG.info("Hello Forge world!");
        ValorantRadiants.init();
        
    }
}