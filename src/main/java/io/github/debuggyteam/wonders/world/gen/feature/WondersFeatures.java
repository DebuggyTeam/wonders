package io.github.debuggyteam.wonders.world.gen.feature;

import net.minecraft.util.Holder;
import net.minecraft.world.gen.decorator.BiomePlacementModifier;
import net.minecraft.world.gen.decorator.InSquarePlacementModifier;
import net.minecraft.world.gen.decorator.NoiseBasedCountPlacementModifier;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.VegetationConfiguredFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.minecraft.world.gen.feature.util.PlacedFeatureUtil;

/*
Made by Joost
 */
public class WondersFeatures {
    public static final Holder<PlacedFeature> LOTS_OF_BAMBOO;

    static {
        LOTS_OF_BAMBOO = PlacedFeatureUtil.register(
                "lots_of_bamboo",
                VegetationConfiguredFeatures.BAMBOO_SOME_PODZOL,
                NoiseBasedCountPlacementModifier.create(115, 75.5, 0.73),
                InSquarePlacementModifier.getInstance(),
                PlacedFeatureUtil.WORLD_SURFACE_WG_HEIGHTMAP,
                BiomePlacementModifier.getInstance());
    }
}
