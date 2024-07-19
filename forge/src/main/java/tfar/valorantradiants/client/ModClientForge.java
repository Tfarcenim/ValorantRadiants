package tfar.valorantradiants.client;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.IEventBus;

public class ModClientForge {

    public static void init(IEventBus bus) {
        MinecraftForge.EVENT_BUS.addListener(ModClientForge::tick);
    }

    static void tick(TickEvent.ClientTickEvent event) {
        ModClient.clientTick();
    }

}
