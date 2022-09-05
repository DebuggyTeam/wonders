package io.github.debuggyteam.wonders.world.gen.feature;

import io.github.debuggyteam.wonders.Wonders;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Holder;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.floatprovider.FloatProvider;
import net.minecraft.util.math.floatprovider.UniformFloatProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;

public class WondersConfiguredFeatures {
	private static final ConfiguredFeature<OreBoulderConfig, ?> _COPPER_IRON_BOULDER = new ConfiguredFeature<>(WondersFeatures.ORE_BOULDER,
			new OreBoulderConfig(UniformIntProvider.create(1, 3), UniformIntProvider.create(1, 3), UniformIntProvider.create(1, 3), UniformIntProvider.create(1, 3), UniformIntProvider.create(2, 3), UniformIntProvider.create(2, 3), UniformIntProvider.create(1, 3), SimpleBlockStateProvider.of(Blocks.MOSSY_COBBLESTONE.getDefaultState()), new WeightedBlockStateProvider(DataPool.<BlockState>builder().add(Blocks.COPPER_ORE.getDefaultState(), 1).add(Blocks.IRON_ORE.getDefaultState(), 2).build()), UniformFloatProvider.create(0.04F, 0.041F)));
	/** Stone Boulder w/ 2.5% chance / block of having Iron Ore, and 1.5% chance of having Copper Ore. */
	public static final Holder<ConfiguredFeature<?, ?>> COPPER_IRON_BOULDER;

	static {
		WondersFeatures.init();
		COPPER_IRON_BOULDER = register(_COPPER_IRON_BOULDER, "copper_iron_boulder");
	}
	public static void init() {

	}

	private static Holder<ConfiguredFeature<?, ?>> register(ConfiguredFeature<?, ?> feature, String name) {
		return BuiltinRegistries.register(BuiltinRegistries.CONFIGURED_FEATURE, Wonders.ID(name), feature);
	}
}
