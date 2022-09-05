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
        context.materialRules().add(0,
                SurfaceRules.condition(
                        SurfaceRules.abovePreliminarySurface(),
                        SurfaceRules.condition(
                            SurfaceRules.biome(WondersBiomes.DEADLANDS),
                                SurfaceRules.block(Blocks.STONE.getDefaultState())
                        )
                )
        );
    }

    public static void init(){}
}
