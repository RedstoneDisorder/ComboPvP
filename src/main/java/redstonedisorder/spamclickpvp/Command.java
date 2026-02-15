package redstonedisorder.spamclickpvp;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.server.command.CommandManager;
import net.minecraft.text.Text;

public class Command implements ModInitializer {
    public static int cooldown = 0;

    @Override
    public void onInitialize() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> dispatcher.register(CommandManager.literal("comboPvP").then(CommandManager.argument("cooldownTicks", IntegerArgumentType.integer(0)).executes(commandContext -> {
            cooldown = IntegerArgumentType.getInteger(commandContext, "cooldownTicks");
            commandContext.getSource().sendMessage(Text.literal("Cooldown is now " + cooldown + "ticks"));
            return 0;
        }))));
    }
}
