package io.github.debuggyteam.wonders.world.biomes;

import io.github.debuggyteam.wonders.world.gen.feature.WondersPlacedFeatures;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;

public class WarmWondersBiomeCreator {

	public static Biome createBambooForest() {
		GenerationSettings.Builder builder = new GenerationSettings.Builder()
				//.feature(GenerationStep.Feature.LOCAL_MODIFICATIONS, WondersPlacedFeatures.COPPER_IRON_BOULDER)
				.feature(GenerationStep.Feature.VEGETAL_DECORATION, WondersPlacedFeatures.LOTS_OF_BAMBOO);
		SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();
		DefaultBiomeFeatures.addJungleMobs(spawnBuilder);
		DefaultBiomeFeatures.addMossyRocks(builder);
		DefaultBiomeFeatures.addDefaultOres(builder);
		DefaultBiomeFeatures.addAmethystGeodes(builder);
		DefaultBiomeFeatures.addUndergroundVariety(builder);
		return (new Biome.Builder()
				.precipitation(Biome.Precipitation.RAIN)
				.temperature(0.5f)
				.temperatureModifier(Biome.TemperatureModifier.NONE)
				.downfall(0.7f)
				.effects(
						(new BiomeEffects.Builder())
								.skyColor(0x79A6FF)
								.fogColor(0x79A6FF)
								.grassColor(0x79C05A)
								.grassColorModifier(BiomeEffects.GrassColorModifier.NONE)
								.foliageColor(0x59AE30)
								.waterColor(0x3F76E4)
								.waterFogColor(0x1E97F2)
								.build())
				.generationSettings(builder.build())
				.spawnSettings(spawnBuilder.build())
				.build()
		);
	}
}
