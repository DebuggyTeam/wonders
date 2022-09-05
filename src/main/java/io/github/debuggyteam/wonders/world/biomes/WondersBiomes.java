package io.github.debuggyteam.wonders.world.biomes;

import io.github.debuggyteam.wonders.Wonders;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;

public class WondersBiomes {
    public static final Biome BAMBOO_FOREST = WarmWondersBiomeCreator.createBambooForest();

    public static void init() {
        register(BAMBOO_FOREST, "bamboo_forest");
    }

	private static void register(Biome biome, String name) {
		Registry.register(BuiltinRegistries.BIOME, Wonders.ID(name), biome);
	}
}
