package io.github.debuggyteam.wonders.util;

import io.github.debuggyteam.wonders.Wonders;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.registry.Registry;

public class WondersRegistry {
	public static Item registerItem(String itemPath) {
		return Registry.register(Registry.ITEM, Wonders.ID(itemPath), new Item(new Item.Settings().group(ItemGroup.MISC)));
	}

	public static Block registerBlock(String itemPath, Block block){
		return Registry.register(Registry.BLOCK, Wonders.ID(itemPath), block);
	}

	public static Item registerBlockItem(String itemPath, Block block) {
		return Registry.register(Registry.ITEM, Wonders.ID(itemPath), new BlockItem(block, new Item.Settings().group(ItemGroup.MISC)));
	}
}
