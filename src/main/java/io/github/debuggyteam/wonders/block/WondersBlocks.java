package io.github.debuggyteam.wonders.block;

import io.github.debuggyteam.wonders.Wonders;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.registry.Registry;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;

import java.util.HashMap;
import java.util.Map;

public class WondersBlocks {
	/**
	 * Used to hold Blocks (type {@code Block}) and their names (type {@code String})
	 * </br></br>
	 * Used by both {@code WondersBlocks} and {@code WondersItems} to allow for automatic creation of block items per-block.
	 * @see io.github.debuggyteam.wonders.item.WondersItems#init
	 */
	public static final Map<String, Block> BLOCKS = new HashMap<>();
	/*
	Made by Joost
	 */
	public static final Block TEST_BLOCK = blockWithSettingsOf(Material.WOOD, 2.0f);

	// Palm wood and crew
	public static final Block PALM_LOG = new PillarBlock(QuiltBlockSettings.copy(Blocks.OAK_LOG).sounds(BlockSoundGroup.WOOD).strength(2.0f));
	public static final Block PALM_WOOD = new PillarBlock(QuiltBlockSettings.copy(Blocks.OAK_WOOD).sounds(BlockSoundGroup.WOOD).strength(2.0f));
	public static final Block STRIPPED_PALM_LOG = new PillarBlock(QuiltBlockSettings.copy(Blocks.STRIPPED_OAK_LOG).sounds(BlockSoundGroup.WOOD).strength(2.0f));
	public static final Block STRIPPED_PALM_WOOD = new PillarBlock(QuiltBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD).sounds(BlockSoundGroup.WOOD).strength(2.0f));
	public static final Block PALM_PLANKS = new Block(QuiltBlockSettings.copy(Blocks.OAK_PLANKS).sounds(BlockSoundGroup.WOOD).strength(2.0f));
	public static final StairsBlock PALM_STAIRS = new StairsBlock(Blocks.OAK_PLANKS.getDefaultState(), QuiltBlockSettings.copy(Blocks.OAK_STAIRS).sounds(BlockSoundGroup.WOOD).strength(2.0f));
	//TODO: add a Palm Fence Gate
	public static final FenceBlock PALM_FENCE = new FenceBlock(QuiltBlockSettings.copy(Blocks.OAK_FENCE).sounds(BlockSoundGroup.WOOD).strength(2.0f));
	public static final SlabBlock PALM_SLAB = new SlabBlock(QuiltBlockSettings.copy(Blocks.OAK_SLAB).sounds(BlockSoundGroup.WOOD).strength(2.0f));
	public static final TrapdoorBlock PALM_TRAPDOOR = new TrapdoorBlock(QuiltBlockSettings.copy(Blocks.OAK_TRAPDOOR).sounds(BlockSoundGroup.WOOD).strength(2.0f));

	static {
		BLOCKS.put("test_block", TEST_BLOCK);
		BLOCKS.put("palm_log", PALM_LOG);
		BLOCKS.put("palm_wood", PALM_WOOD);
		BLOCKS.put("stripped_palm_log", STRIPPED_PALM_LOG);
		BLOCKS.put("stripped_palm_wood", STRIPPED_PALM_WOOD);
		BLOCKS.put("palm_planks", PALM_PLANKS);
		BLOCKS.put("palm_stairs", PALM_STAIRS);
		BLOCKS.put("palm_fence", PALM_FENCE);
		BLOCKS.put("palm_slab", PALM_SLAB);
		BLOCKS.put("palm_trapdoor", PALM_TRAPDOOR);
	}
	//TODO: palm sign?
	//public static final SignBlock PALM_SIGN = WondersRegistry.registerBlock("palm_sign", new SignBlock(
	//		Blocks.OAK_PLANKS.getDefaultState(), QuiltBlockSettings.copy(Blocks.OAK_SIGN).sounds(BlockSoundGroup.WOOD).strength(2.0f)
	//));

	/**
	 * To be used for creating a block with just the settings of a {@code Material}
	 * @param material - the material to use for the block
	 * @param strength - float value of strength
	 * @see QuiltBlockSettings#of
	 * @see Material
	 */
	private static Block blockWithSettingsOf(Material material, Float strength){
		return new Block(QuiltBlockSettings.of(material).strength(strength));
	}

	public static void init(){
		//simple, innit?
		BLOCKS.forEach((String name, Block block) -> Registry.register(Registry.BLOCK, Wonders.ID(name), block));

		//TODO this has got to go soon. Use Tags and REAs.
		registerStrippableBlocks();
		registerFlammables();
		registerFuels();
	}

	private static void registerStrippableBlocks(){
		StrippableBlockRegistry.register(PALM_LOG, STRIPPED_PALM_LOG);
		StrippableBlockRegistry.register(PALM_WOOD, STRIPPED_PALM_WOOD);
	}

	private static void registerFuels() {
		FuelRegistry registry = FuelRegistry.INSTANCE;

		registry.add(PALM_LOG, 300);
		registry.add(PALM_WOOD, 300);
		registry.add(STRIPPED_PALM_LOG, 300);
		registry.add(STRIPPED_PALM_WOOD, 300);
	}

	private static void registerFlammables() {
		FlammableBlockRegistry flammableBocks = FlammableBlockRegistry.getDefaultInstance();

		flammableBocks.add(PALM_LOG, 5, 5);
		flammableBocks.add(PALM_WOOD, 5, 5);
		flammableBocks.add(STRIPPED_PALM_LOG, 5, 5);
		flammableBocks.add(STRIPPED_PALM_WOOD, 5, 5);
	}
}
