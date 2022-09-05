package io.github.debuggyteam.wonders.world.biomes;

import net.minecraft.block.Blocks;
import net.minecraft.world.gen.noise.NoiseParametersKeys;
import net.minecraft.world.gen.surfacebuilder.SurfaceRules;
import org.jetbrains.annotations.NotNull;
import org.quiltmc.qsl.worldgen.surface_rule.api.SurfaceRuleContext;
import org.quiltmc.qsl.worldgen.surface_rule.api.SurfaceRuleEvents;

public class SurfaceRulesStuff implements SurfaceRuleEvents.OverworldModifierCallback {
    @Override
    public void modifyOverworldRules(SurfaceRuleContext.@NotNull Overworld context) {
        SurfaceRules.MaterialCondition stoneSurface = SurfaceRules.noiseThreshold(NoiseParametersKeys.SURFACE, 0.5, 1.0);
        SurfaceRules.MaterialRule STONE_SURFACE = SurfaceRules.block(Blocks.GLOWSTONE.getDefaultState());

        context.materialRules().add(0,
                SurfaceRules.condition(
                        //SurfaceRules.abovePreliminarySurface()
                        SurfaceRules.ON_FLOOR,
                        SurfaceRules.condition(
                            SurfaceRules.biome(WondersBiomes.DEADLANDS),
                            SurfaceRules.sequence(
                                    SurfaceRules.condition(stoneSurface, STONE_SURFACE)
                            )
                        )
                )
        );
    }

    public static void init(){}
}
