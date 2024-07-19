package tfar.valorantradiants;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.registries.RegisterEvent;
import org.apache.commons.lang3.tuple.Pair;
import tfar.valorantradiants.client.ModClient;
import tfar.valorantradiants.client.ModClientForge;
import tfar.valorantradiants.datagen.ModDatagen;
import tfar.valorantradiants.network.PacketHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

@Mod(ValorantRadiants.MOD_ID)
public class ValorantRadiantsForge {

    public static Map<Registry<?>, List<Pair<ResourceLocation, Supplier<?>>>> registerLater = new HashMap<>();

    public ValorantRadiantsForge() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        // This method is invoked by the Forge mod loader when it is ready
        // to load your mod. You can access Forge and Common code in this
        // project.
        bus.addListener(this::register);
        bus.addListener(this::setup);
        bus.addListener(ModDatagen::gather);
        if (FMLEnvironment.dist.isClient()) {
            ModClientForge.init(bus);
        }
        // Use Forge to bootstrap the Common mod.
        ValorantRadiants.init();
    }

    private void register(RegisterEvent e) {
        for (Map.Entry<Registry<?>,List<Pair<ResourceLocation, Supplier<?>>>> entry : registerLater.entrySet()) {
            Registry<?> registry = entry.getKey();
            List<Pair<ResourceLocation, Supplier<?>>> toRegister = entry.getValue();
            for (Pair<ResourceLocation,Supplier<?>> pair : toRegister) {
                e.register((ResourceKey<? extends Registry<Object>>)registry.key(),pair.getLeft(),(Supplier<Object>)pair.getValue());
            }
        }
    }

    private void setup(FMLCommonSetupEvent event) {
        registerLater.clear();
        PacketHandler.registerPackets();
    }

}