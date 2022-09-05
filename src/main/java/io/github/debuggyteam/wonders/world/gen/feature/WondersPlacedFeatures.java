package io.github.debuggyteam.wonders.world.gen.feature;

import io.github.debuggyteam.wonders.Wonders;
import net.minecraft.util.Holder;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.world.gen.decorator.BiomePlacementModifier;
import net.minecraft.world.gen.decorator.InSquarePlacementModifier;
import net.minecraft.world.gen.decorator.NoiseBasedCountPlacementModifier;
import net.minecraft.world.gen.decorator.RarityFilterPlacementModifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacementModifier;
import net.minecraft.world.gen.feature.VegetationConfiguredFeatures;
import net.minecraft.world.gen.feature.util.PlacedFeatureUtil;

import java.util.List;

public class WondersPlacedFeatures {
	private static final PlacedFeature _LOTS_OF_BAMBOO = placedFeature(VegetationConfiguredFeatures.BAMBOO_SOME_PODZOL,NoiseBasedCountPlacementModifier.create(115, 75.5, 0.73), InSquarePlacementModifier.getInstance(), PlacedFeatureUtil.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.getInstance());
	public static final Holder<PlacedFeature> LOTS_OF_BAMBOO;
	private static final PlacedFeature _COPPER_IRON_BOULDER = placedFeature(WondersConfiguredFeatures.COPPER_IRON_BOULDER, RarityFilterPlacementModifier.create(10), InSquarePlacementModifier.getInstance(), PlacedFeatureUtil.WORLD_SURFACE_WG_HEIGHTMAP);
	/** @see io.github.debuggyteam.wonders.world.gen.feature.WondersConfiguredFeatures#COPPER_IRON_BOULDER */
	public static final Holder<PlacedFeature> COPPER_IRON_BOULDER;

	static {
		WondersConfiguredFeatures.init();
		LOTS_OF_BAMBOO = register(_LOTS_OF_BAMBOO, "lots_of_bamboo");
		COPPER_IRON_BOULDER = register(_COPPER_IRON_BOULDER, "copper_iron_boulder");
	}

	private static PlacedFeature placedFeature(Holder<? extends ConfiguredFeature<?, ?>> configuredFeature, PlacementModifier... modifiers) {
		return new PlacedFeature(Holder.upcast(configuredFeature), List.of(modifiers));
	}

	private static Holder<PlacedFeature> register(PlacedFeature feature, String name) {
		return BuiltinRegistries.register(BuiltinRegistries.PLACED_FEATURE, Wonders.ID(name), feature);
	}
}
