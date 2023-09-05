package io.github.debuggyteam.wonders.world.biomes;

import io.github.debuggyteam.wonders.world.gen.feature.WondersVegetationPlacedFeatures;
import io.github.debuggyteam.wonders.world.gen.feature.custom.CustomBoulder;
import net.minecraft.block.GrassBlock;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.GeneratorOptions;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.VegetationConfiguredFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import org.quiltmc.qsl.worldgen.biome.api.BiomeModifications;

import static io.github.debuggyteam.wonders.Wonders.ID;

public class WondersBiomes {
    public static final RegistryKey<Biome> BAMBOO_FOREST = RegistryKey.of(Registry.BIOME_KEY, ID("bamboo_forest"));
    public static final RegistryKey<Biome> DEADLANDS = RegistryKey.of(Registry.BIOME_KEY, ID("deadlands"));
    public static final RegistryKey<Biome> INFERNAL = RegistryKey.of(Registry.BIOME_KEY, ID("infernal"));

    public static void registerWondersBiomes() {
        Registry.register(BuiltinRegistries.BIOME, BAMBOO_FOREST.getValue(), createBambooForest());
        Registry.register(BuiltinRegistries.BIOME, DEADLANDS.getValue(), createDeadlands());
        Registry.register(BuiltinRegistries.BIOME, INFERNAL.getValue(), createInfernal());
    }

    private static Biome createBambooForest() {
        GenerationSettings.Builder builder = new GenerationSettings.Builder()
                //.feature(GenerationStep.Feature.RAW_GENERATION, WondersVegetationPlacedFeatures.)
                .feature(GenerationStep.Feature.VEGETAL_DECORATION, WondersVegetationPlacedFeatures.LOTS_OF_BAMBOO);
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();
        DefaultBiomeFeatures.addJungleMobs(spawnBuilder);
        //DefaultBiomeFeatures.addMossyRocks(builder);
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

    private static Biome createDeadlands() { // hello
        GenerationSettings.Builder builder = new GenerationSettings.Builder();
                //.feature(GenerationStep.Feature.VEGETAL_DECORATION, WondersVegetationPlacedFeatures.LOTS_OF_BAMBOO);
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();
        DefaultBiomeFeatures.addJungleMobs(spawnBuilder);
        //DefaultBiomeFeatures.addMossyRocks(builder);
        DefaultBiomeFeatures.addDefaultOres(builder);
        DefaultBiomeFeatures.addAmethystGeodes(builder);
        return (new Biome.Builder()
                .precipitation(Biome.Precipitation.RAIN)
                .temperature(0.5f)
                .temperatureModifier(Biome.TemperatureModifier.NONE)
                .downfall(0.7f)
                .effects(
                        (new BiomeEffects.Builder())
                                .skyColor(0x839db5)
                                .fogColor(0xe8eae9)
                                .grassColor(0x918E85)
                                .grassColorModifier(BiomeEffects.GrassColorModifier.NONE)
                                .foliageColor(0x918E85)
                                .waterColor(0x3E4826)
                                .waterFogColor(0x2B321B)
                                .build())
                .generationSettings(builder.build())
                .spawnSettings(spawnBuilder.build())
                .build()
        );
    }

    private static Biome createInfernal() { // hello
        GenerationSettings.Builder builder = new GenerationSettings.Builder()
                .feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.BROWN_MUSHROOOM_NETHER)
                .feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.RED_MUSHROOM_NETHER)
                .feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.RED_MUSHROOM_OLD_GROWTH)
                .feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.BROWN_MUSHROOM_OLD_GROWTH);
        //.feature(GenerationStep.Feature.VEGETAL_DECORATION, WondersVegetationPlacedFeatures.LOTS_OF_BAMBOO);
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();
        //DefaultBiomeFeatures.addMossyRocks(builder);
        DefaultBiomeFeatures.addDefaultOres(builder);
        DefaultBiomeFeatures.addAmethystGeodes(builder);
        return (new Biome.Builder()
                .precipitation(Biome.Precipitation.NONE)
                .temperature(1.5f)
                .temperatureModifier(Biome.TemperatureModifier.NONE)
                .downfall(0.3f)
                .effects(
                        (new BiomeEffects.Builder())
                                .skyColor(0x9f291f)
                                .fogColor(0x5f1d1c)
                                .grassColor(0x78463a)
                                .grassColorModifier(BiomeEffects.GrassColorModifier.NONE)
                                .foliageColor(0xaf9586)
                                .waterColor(0x692c20)
                                .waterFogColor(0x261718)
                                .build())
                .generationSettings(builder.build())
                .spawnSettings(spawnBuilder.build())
                .build()
        );
    }

    public static void init(){}
}
