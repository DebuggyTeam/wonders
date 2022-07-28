package io.github.debuggyteam.wonders.item;

import io.github.debuggyteam.wonders.Wonders;
import io.github.debuggyteam.wonders.block.WondersBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;


public class WondersItems {
	// registering items
	public static Item TEST = new Item(new Item.Settings().group(Wonders.GROUP));

	public static void init(){
		//dynamically register a new block item for every block.
		WondersBlocks.BLOCKS.forEach((String name, Block block) -> register(new BlockItem(block, new Item.Settings().group(Wonders.GROUP)), name));

		//regular Items
		register(TEST, "test_item");
	}

	private static <T extends Item> void register(T item, String name) {
		Registry.register(Registry.ITEM, Wonders.ID(name), item);
	}
}
