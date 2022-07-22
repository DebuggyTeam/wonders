package io.github.debuggyteam.wonders;

import io.github.debuggyteam.wonders.block.WondersBlocks;
import io.github.debuggyteam.wonders.item.WondersItems;
import net.minecraft.util.Identifier;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Wonders implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod name as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("Wonders");

	private static final String MOD_ID = "wonders";
	public static Identifier ID(String name) {
		return new Identifier(MOD_ID, name);
	}

	@Override
	public void onInitialize(ModContainer mod) {

		WondersItems.init();
		WondersBlocks.init();

		LOGGER.info("Everything loaded from: {}!", mod.metadata().name());
	}
}
