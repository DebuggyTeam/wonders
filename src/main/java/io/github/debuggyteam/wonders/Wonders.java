package io.github.debuggyteam.wonders;

import io.github.debuggyteam.wonders.block.WondersBlocks;
import io.github.debuggyteam.wonders.item.WondersItems;
import io.github.debuggyteam.wonders.util.WondersUtils;
import io.github.debuggyteam.wonders.world.biomes.WondersBiomes;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Holder;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.PlacedFeature;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.quiltmc.qsl.item.group.api.QuiltItemGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Wonders implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod name as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("Wonders");

	/*
	Made by Joost
	 */
	private static final String MOD_ID = "wonders";
	public static Identifier ID(String name) {
		return new Identifier(MOD_ID, name);
	}

	public static final ItemGroup itemGroup = QuiltItemGroup.builder(ID("itemgroup")).icon(() -> new ItemStack(WondersItems.TEST)).build();


	@Override
	public void onInitialize(ModContainer mod) {

		WondersItems.init();
		WondersBlocks.init();
		WondersBiomes.registerWondersBiomes();

		WondersUtils.registerUtils();

		LOGGER.info("Everything loaded from: {}!", mod.metadata().name());
	}
}
