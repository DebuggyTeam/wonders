package io.github.debuggyteam.wonders.world.gen.feature;

import io.github.debuggyteam.wonders.Wonders;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;

/*
Made by Joost
 */
public class WondersFeatures {
	public static Feature<OreBoulderConfig> ORE_BOULDER = new OreBoulder<>(OreBoulderConfig.CODEC);

	public static void init() {
		register(ORE_BOULDER, "ore_boulder");
	}
	private static <FC extends FeatureConfig> void register(Feature<FC> feature, String name) {
		Registry.register(Registry.FEATURE, Wonders.ID(name), feature);
	}
}
