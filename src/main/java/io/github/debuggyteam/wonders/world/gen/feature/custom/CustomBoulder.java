package io.github.debuggyteam.wonders.world.gen.feature.custom;

import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class CustomBoulder extends Feature<DefaultFeatureConfig> {
    public CustomBoulder(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean place(FeatureContext<DefaultFeatureConfig> context) {
        /*
        create a boulder that has a varying shape, optionally; have the boulder contain ores
        iron: 2.5% chance, copper: 1.5% chance
         */

        BlockPos position = context.getOrigin();
        StructureWorldAccess structureWorldAccess = context.getWorld();
        RandomGenerator random = context.getRandom();

        if (position.getY() <= structureWorldAccess.getBottomY() + 5) {
            return false;
        } else {
            /*
            for(int i = 0; i < 5; i++) {

            }
             */
        }

        return true;
    }
}
