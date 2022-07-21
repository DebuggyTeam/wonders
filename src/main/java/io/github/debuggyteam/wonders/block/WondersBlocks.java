package io.github.debuggyteam.wonders.block;

import io.github.debuggyteam.wonders.util.WondersRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;

public class WondersBlocks {
	public static final Block TEST_BLOCK = WondersRegistry.registerBlock("test_block", createBlock(Material.WOOD, 2.0f));

	private static Block createBlock(Material material, Float strength){
		return new Block(QuiltBlockSettings.of(material).strength(strength));
	}

	public static void init(){

	}
}
