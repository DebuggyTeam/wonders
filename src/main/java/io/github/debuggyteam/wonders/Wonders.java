package io.github.debuggyteam.wonders;

import io.github.debuggyteam.wonders.block.WondersBlocks;
import io.github.debuggyteam.wonders.item.WondersItems;
import io.github.debuggyteam.wonders.util.WondersUtils;
import io.github.debuggyteam.wonders.world.biomes.SurfaceRulesStuff;
import io.github.debuggyteam.wonders.world.biomes.WondersBiomes;
import io.github.debuggyteam.wonders.world.gen.feature.custom.CustomBoulder;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Holder;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
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

	/*
	private static final Feature<CustomBoulder.BoulderConfig> BOULDER = new CustomBoulder(CustomBoulder.BoulderConfig.CODEC);
	public static final ConfiguredFeature<?, ?> ROCK = BOULDER.configure(new CustomBoulder.BoulderConfig(ConstantIntProvider.create(15),
					new SimpleBlockStateProvider(Blocks.STONE.getDefaultState())))
			.decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.OCEAN_FLOOR_WG)))
			.spreadHorizontally()
			.applyChance(5);
	 */


	@Override
	public void onInitialize(ModContainer mod) {

		//Registry.register(Registry.FEATURE, new Identifier("wonders", "rock"), ROCK);
		WondersItems.init();
		WondersBlocks.init();
		WondersBiomes.registerWondersBiomes();

		SurfaceRulesStuff.init();
		WondersUtils.registerUtils();

		LOGGER.info("Everything loaded from: {}!", mod.metadata().name());
	}
}
