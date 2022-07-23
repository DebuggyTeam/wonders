package io.github.debuggyteam.wonders.item;

import io.github.debuggyteam.wonders.block.WondersBlocks;
import io.github.debuggyteam.wonders.util.WondersRegistry;
import net.minecraft.item.Item;


public class WondersItems {
	// registering items
	public static Item TEST = WondersRegistry.registerItem("test");

	// registering block items
	public static Item TEST_BLOCK = WondersRegistry.registerBlockItem("test_block", WondersBlocks.TEST_BLOCK);
	public static Item PALM_LOG = WondersRegistry.registerBlockItem("palm_log", WondersBlocks.PALM_LOG);
	public static Item PALM_WOOD = WondersRegistry.registerBlockItem("palm_wood", WondersBlocks.PALM_WOOD);
	public static Item STRIPPED_PALM_LOG = WondersRegistry.registerBlockItem("stripped_palm_log", WondersBlocks.STRIPPED_PALM_LOG);
	public static Item STRIPPED_PALM_WOOD = WondersRegistry.registerBlockItem("stripped_palm_wood", WondersBlocks.STRIPPED_PALM_WOOD);

	public static void init(){
	}
}
