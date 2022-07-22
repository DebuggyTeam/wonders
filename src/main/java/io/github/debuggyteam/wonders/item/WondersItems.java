package io.github.debuggyteam.wonders.item;

import io.github.debuggyteam.wonders.block.WondersBlocks;
import io.github.debuggyteam.wonders.util.WondersRegistry;
import net.minecraft.item.Item;


public class WondersItems {
	// registering items
	public static Item TEST = WondersRegistry.registerItem("test");
	public static Item ANOTHER_TEST = WondersRegistry.registerItem("another_test");

	// registering block items
	public static Item TEST_BLOCK = WondersRegistry.registerBlockItem("test_block", WondersBlocks.TEST_BLOCK);

	public static void init(){
	}
}
