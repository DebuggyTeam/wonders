package io.github.debuggyteam.wonders.util;

import io.github.debuggyteam.wonders.Wonders;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.registry.Registry;

public class WondersRegistry {
	public static Item registerItem(String itemName) {
		return Registry.register(Registry.ITEM, Wonders.ID(itemName), new Item(new Item.Settings().group(Wonders.itemGroup)));
	}

	public static Block registerBlock(String blockName, Block block){
		return Registry.register(Registry.BLOCK, Wonders.ID(blockName), block);
	}

	public static Item registerBlockItem(String itemName, Block block) {
		return Registry.register(Registry.ITEM, Wonders.ID(itemName), new BlockItem(block, new Item.Settings().group(Wonders.itemGroup)));
	}
}
