package io.github.debuggyteam.wonders;

import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.DensityConstants;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import org.quiltmc.qsl.resource.loader.api.ResourceLoader;

import static io.github.debuggyteam.wonders.Wonders.ID;

public class WondersBiomes {
    private static final RegistryKey<Biome> BAMBOO_FOREST = RegistryKey.of(Registry.BIOME_KEY, ID("bamboo_forest"));

    public static void registerWondersBiomes() {
        Registry.register(BuiltinRegistries.BIOME, BAMBOO_FOREST.getValue(), createBambooForest());
    }

    private static Biome createBambooForest() {
        GenerationSettings.Builder builder = new GenerationSettings.Builder()
                .feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.BAMBOO);
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();
        DefaultBiomeFeatures.addJungleMobs(spawnBuilder);
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

    public static void init(){}
}
