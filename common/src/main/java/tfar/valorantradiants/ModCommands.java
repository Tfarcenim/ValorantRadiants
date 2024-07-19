package tfar.valorantradiants;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.tree.LiteralCommandNode;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;

import java.util.function.Predicate;

public class ModCommands {

    public static final String VR_GET = makeKey("get");

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        LiteralCommandNode<CommandSourceStack> node = dispatcher.register(
                Commands.literal(ValorantRadiants.MOD_ID)
                        .then(Commands.literal("get")
                                .requires(checkPermissions(VR_GET, 2))
                                .executes(ModCommands::getRadiant)
                        )
        );
        dispatcher.register(Commands.literal("vr").redirect(node));
    }


    public static int getRadiant(CommandContext<CommandSourceStack> ctx) {
        return 1;
    }

    public static String makeKey(String s) {
        return ValorantRadiants.MOD_ID + "." + s;
    }

    public static Predicate<CommandSourceStack> checkPermissions(String node, int defaultValue) {
        return commandSourceStack -> commandSourceStack.hasPermission(defaultValue);//Services.PLATFORM.checkBasicPermission(commandSourceStack, node, defaultValue);
    }


}
