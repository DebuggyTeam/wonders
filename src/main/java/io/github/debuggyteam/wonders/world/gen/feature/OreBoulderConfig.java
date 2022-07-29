package io.github.debuggyteam.wonders.world.gen.feature;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.math.floatprovider.FloatProvider;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

/**
 * A (usually) assymetrical boulder config
 * @param eastRadius - {@code IntProvider} for one side along the x-axis
 * @param westRadius - {@code IntProvider} for the other side along x
 * @param northRadius - {@code IntProvider} for one side along the z-axis
 * @param southRadius - {@code IntProvider} for the other side along z
 * @param topRadius - {@code IntProvider} for one side along the y-axis
 * @param bottomRadius - {@code IntProvider} for the other side along y
 * @param blocksSubmerged - {@code IntProvider} the amount of blocks that the boulder should be submerged into the ground.
 * @param boulderBlock - {@code BlockStateProvider} the block to use for boulder.
 * @param oreBlock - {@code  BlockStateProvider} the block to use for ores.
 * @param oreChance - {@code FloatProvider} for the chance of ores replacing the base boulder block. Should always be 1 or less.
 * @see IntProvider
 * @see BlockStateProvider
 * @see FloatProvider
 */
public record OreBoulderConfig(IntProvider eastRadius,
							   IntProvider westRadius,
							   IntProvider northRadius,
							   IntProvider southRadius,
							   IntProvider topRadius,
							   IntProvider bottomRadius,
							   IntProvider blocksSubmerged,
							   BlockStateProvider boulderBlock,
							   BlockStateProvider oreBlock,
							   FloatProvider oreChance) implements FeatureConfig {
	public static final Codec<OreBoulderConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(
			IntProvider.POSITIVE_CODEC.fieldOf("east_radius").forGetter(OreBoulderConfig::eastRadius),
			IntProvider.POSITIVE_CODEC.fieldOf("west_radius").forGetter(OreBoulderConfig::westRadius),
			IntProvider.POSITIVE_CODEC.fieldOf("north_radius").forGetter(OreBoulderConfig::northRadius),
			IntProvider.POSITIVE_CODEC.fieldOf("south_radius").forGetter(OreBoulderConfig::southRadius),
			IntProvider.POSITIVE_CODEC.fieldOf("top_radius").forGetter(OreBoulderConfig::topRadius),
			IntProvider.POSITIVE_CODEC.fieldOf("bottom_radius").forGetter(OreBoulderConfig::bottomRadius),
			IntProvider.POSITIVE_CODEC.fieldOf("blocksSubmerged").orElse(ConstantIntProvider.ZERO).forGetter(OreBoulderConfig::blocksSubmerged),
			BlockStateProvider.TYPE_CODEC.fieldOf("boulder_block").forGetter(OreBoulderConfig::boulderBlock),
			BlockStateProvider.TYPE_CODEC.fieldOf("ore_block").forGetter(OreBoulderConfig::oreBlock),
			FloatProvider.VALUE_CODEC.fieldOf("ore_chance").forGetter(OreBoulderConfig::oreChance)
	).apply(instance, instance.stable(OreBoulderConfig::new)));
}
