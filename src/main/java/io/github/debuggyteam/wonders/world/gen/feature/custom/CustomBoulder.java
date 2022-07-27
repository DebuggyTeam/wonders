package io.github.debuggyteam.wonders.world.gen.feature.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.decorator.PlacementModifierType;
import net.minecraft.world.gen.decorator.RarityFilterPlacementModifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

public class CustomBoulder extends Feature<CustomBoulder.BoulderConfig> {
    public record BoulderConfig(IntProvider baseSize, IntProvider sizeVariation, BlockStateProvider exteriorBlock, BlockStateProvider interiorBlock) implements FeatureConfig {
        public static final Codec<BoulderConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(
                IntProvider.VALUE_CODEC.fieldOf("base_size").forGetter(BoulderConfig::baseSize),
                IntProvider.VALUE_CODEC.fieldOf("size_variation").forGetter(BoulderConfig::sizeVariation)
        ).apply(instance, instance.stable(BoulderConfig::new)));
    }

    public CustomBoulder(Codec<BoulderConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean place(FeatureContext<BoulderConfig> context) {
        /*
        create a boulder that has a varying shape, optionally; have the boulder contain ores
        iron: 2.5% chance, copper: 1.5% chance
         */

        BlockPos position = context.getOrigin();
        StructureWorldAccess worldGenWorldAccess = context.getWorld();
        RandomGenerator random = context.getRandom();

        BoulderConfig singleStateFeatureConfig;
        for(singleStateFeatureConfig = context.getConfig(); position.getY() > worldGenWorldAccess.getBottomY() + 3; position = position.down()) {
            if (!worldGenWorldAccess.isAir(position.down())) {
                BlockState blockState = worldGenWorldAccess.getBlockState(position.down());
                if (isSoil(blockState) || isStone(blockState)) {
                    break;
                }
            }
        }

        if (position.getY() <= worldGenWorldAccess.getBottomY() + 5) {
            return false;
        } else {
            for(int i = 0; i < 5; i++) {
                int j = random.nextInt(3);
                int k = random.nextInt(5);
                int l = random.nextInt(4);

                float rockShape = (float)(j + k + l) * 0.4f + 0.5f;

                for (BlockPos position2 : BlockPos.iterate(position.add(-j, -k, -l), position.add(j, k, l))) {
                    if (position2.getSquaredDistance(position) <= (double)(rockShape * rockShape)) {
                        worldGenWorldAccess.setBlockState(position2, singleStateFeatureConfig.state, 4);
                    }
                }

                position = position.add(-1 + random.nextInt(3), -random.nextInt(5), -1 + random.nextInt(4));
            }
        }

        return true;
    }
}
