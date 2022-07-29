package io.github.debuggyteam.wonders.world.gen.feature;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class OreBoulder<O> extends Feature<OreBoulderConfig> {
    public OreBoulder(Codec<OreBoulderConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean place(FeatureContext<OreBoulderConfig> context) {
        BlockPos position = context.getOrigin();
		RandomGenerator random = context.getRandom();
		OreBoulderConfig config = context.getConfig();

        StructureWorldAccess worldGenWorldAccess = context.getWorld();

		int eastRadius = config.eastRadius().get(random);
		int westRadius = config.westRadius().get(random);
		int northRadius = config.northRadius().get(random);
		int southRadius = config.southRadius().get(random);
		int topRadius = config.topRadius().get(random);
		int bottomRadius = config.bottomRadius().get(random);
		int blocksSubmerged = config.blocksSubmerged().get(random);
		//since we're generating a bunch of mini features, we return the boolean AND of all of their results.
		var val =
			generateEighth(eastRadius, northRadius, topRadius, blocksSubmerged, true, true, true, position, context) &&
			generateEighth(eastRadius, northRadius, bottomRadius, blocksSubmerged, true, true, false, position, context) &&
			generateEighth(eastRadius, southRadius, topRadius, -blocksSubmerged, true, false, true, position, context) &&
			generateEighth(eastRadius, southRadius, bottomRadius, -blocksSubmerged, true, false, false, position, context) &&
			generateEighth(westRadius, northRadius, topRadius, blocksSubmerged, false, true, true, position, context) &&
			generateEighth(westRadius, northRadius, bottomRadius, blocksSubmerged, false, true, false, position, context) &&
			generateEighth(westRadius, southRadius, topRadius, -blocksSubmerged, false, false, true, position, context) &&
			generateEighth(westRadius, southRadius, bottomRadius, -blocksSubmerged, false, false, false, position, context);

		worldGenWorldAccess.setBlockState(context.getOrigin(), Blocks.BLUE_CONCRETE.getDefaultState(), 3);
		return val;
    }

	//generate the approriate section of the boulder
	protected boolean generateEighth(int xRadius, int zRadius, int yRadius, int blocksSubmerged, boolean east, boolean north, boolean up, BlockPos origin, FeatureContext<OreBoulderConfig> context) {
		for(int y = blocksSubmerged; y < yRadius; y++) { // by adding the amount of blocks submerged, the y has less "time".
			for(int x = 0; x < xRadius; x++) {
				for(int z = 0; z < zRadius; z++) {
					if(fallsInEllipsoid(x, y, z, xRadius, yRadius, zRadius)) {
						StructureWorldAccess worldAccess = context.getWorld();
						RandomGenerator random = context.getRandom();
						BlockPos currentPos = origin.add(
								east ? x : -x,
								up ? y : -y,
								north ? z : -z);
						OreBoulderConfig config = context.getConfig();
						BlockState boulderBlock = config.boulderBlock().getBlockState(random, currentPos);
						BlockState oreBlock = config.oreBlock().getBlockState(random, currentPos);
						worldAccess.setBlockState(currentPos, random.nextFloat() < config.oreChance().get(random) ? oreBlock : boulderBlock, 3); //4 is what block piles usew, so let's go with that.
					}
				}
			}

		}
		return true;
	}

	protected boolean fallsInEllipsoid(int x, int y, int z, int a, int b, int c) {
		return ((MathHelper.square(x) / MathHelper.square(a)) +
				(MathHelper.square(y) / MathHelper.square(b)) +
				(MathHelper.square(z) / MathHelper.square(c))) <= 1;
	}

}
