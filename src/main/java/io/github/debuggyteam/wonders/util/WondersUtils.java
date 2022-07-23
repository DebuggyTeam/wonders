package io.github.debuggyteam.wonders.util;

import io.github.debuggyteam.wonders.block.WondersBlocks;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;

public class WondersUtils {

	public static void registerUtils() {
		registerFuels();
		registerStrippableBlocks();
		registerFlammables();
	}

	private static void registerFuels() {
		FuelRegistry registry = FuelRegistry.INSTANCE;

		registry.add(WondersBlocks.PALM_LOG, 300);
		registry.add(WondersBlocks.PALM_WOOD, 300);
		registry.add(WondersBlocks.STRIPPED_PALM_LOG, 300);
		registry.add(WondersBlocks.STRIPPED_PALM_WOOD, 300);
	}

	private static void registerStrippableBlocks(){
		StrippableBlockRegistry.register(WondersBlocks.PALM_LOG, WondersBlocks.STRIPPED_PALM_LOG);
		StrippableBlockRegistry.register(WondersBlocks.PALM_WOOD, WondersBlocks.STRIPPED_PALM_WOOD);
	}

	private static void registerFlammables() {
		FlammableBlockRegistry flammableBocks = FlammableBlockRegistry.getDefaultInstance();

		flammableBocks.add(WondersBlocks.PALM_LOG, 5, 5);
		flammableBocks.add(WondersBlocks.PALM_WOOD, 5, 5);
		flammableBocks.add(WondersBlocks.STRIPPED_PALM_LOG, 5, 5);
		flammableBocks.add(WondersBlocks.STRIPPED_PALM_WOOD, 5, 5);
	}
}
