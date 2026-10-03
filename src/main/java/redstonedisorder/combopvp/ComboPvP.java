package redstonedisorder.combopvp;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ComboPvP implements ModInitializer {
	public static final String MOD_ID = "combo-pvp";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static int cooldown = 0;

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
			dispatcher.register(Commands.literal("combopvp").then(Commands.argument("cooldown", IntegerArgumentType.integer(0))).requires(source -> source.hasPermission(2)).executes(context -> {
				cooldown = IntegerArgumentType.getInteger(context, "cooldown");
				context.getSource().sendSuccess(() -> Component.literal("Cooldown is now " + cooldown + " ticks"), false);
				return Command.SINGLE_SUCCESS;
			}));
		});

		LOGGER.info("ComboPvP loaded!");
	}
}
