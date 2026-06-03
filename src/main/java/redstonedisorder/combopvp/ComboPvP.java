package redstonedisorder.combopvp;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.permissions.Permissions;

public class ComboPvP implements ModInitializer {
	public static int cooldown = 0;

	@Override
	public void onInitialize() {
		CommandRegistrationCallback.EVENT.register((dispatcher, ignoredContext, ignoredEnvironment) -> dispatcher.register(Commands.literal("comboPvP").then(Commands.argument("cooldownTicks", IntegerArgumentType.integer(0)).requires(source -> source.permissions().hasPermission(Permissions.COMMANDS_MODERATOR)).executes(commandContext -> {
            cooldown = IntegerArgumentType.getInteger(commandContext, "cooldownTicks");
            commandContext.getSource().sendSuccess(() -> Component.literal("Cooldown is now " + cooldown + " ticks"), false);
			return 0;
		}))));
	}
}