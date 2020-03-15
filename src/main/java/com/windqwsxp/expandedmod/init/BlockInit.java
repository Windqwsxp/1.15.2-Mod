package com.windqwsxp.expandedmod.init;

import com.windqwsxp.expandedmod.ExpandedMod;
import com.windqwsxp.expandedmod.objects.blocks.BlockMetalFoundry;
import com.windqwsxp.expandedmod.objects.blocks.BlockMud;
import com.windqwsxp.expandedmod.objects.blocks.BlockOil;
import com.windqwsxp.expandedmod.objects.blocks.BluebushBlock;
import com.windqwsxp.expandedmod.objects.blocks.CornCrop;
import com.windqwsxp.expandedmod.objects.blocks.EPBlockLamp;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {

	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, ExpandedMod.MOD_ID);
	
	public static final RegistryObject<Block> tinore = BLOCKS.register("tinore", () -> new Block(Block.Properties.create(Material.IRON)));
	public static final RegistryObject<Block> titaniumore = BLOCKS.register("titaniumore", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 2.5f).harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));
	public static final RegistryObject<Block> nickelore = BLOCKS.register("nickelore", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.4f, 2.0f).harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));
	public static final RegistryObject<Block> copperore = BLOCKS.register("copperore", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.4f, 2.0f).harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));
	public static final RegistryObject<Block> limestone = BLOCKS.register("limestone", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0f, 1.5f).harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));
	public static final RegistryObject<Block> drygrassblock = BLOCKS.register("drygrassblock", () -> new Block(Block.Properties.create(Material.EARTH).hardnessAndResistance(0.7f).harvestTool(ToolType.SHOVEL).sound(SoundType.PLANT)));
	public static final RegistryObject<Block> bluebush = BLOCKS.register("bluebush", () -> new BluebushBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0f).doesNotBlockMovement().tickRandomly().sound(SoundType.PLANT)));
	public static final RegistryObject<Block> corncrop = BLOCKS.register("corncrop", () -> new CornCrop(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0f).doesNotBlockMovement().tickRandomly().sound(SoundType.PLANT)));
	public static final RegistryObject<Block> eplamp = BLOCKS.register("eplamp", () -> new EPBlockLamp(Block.Properties.create(Material.GLASS).hardnessAndResistance(0.8f, 0.4f).lightValue(EPBlockLamp.lightV).sound(SoundType.GLASS)));
	public static final RegistryObject<Block> metalfoundry = BLOCKS.register("metalfoundry", () -> new BlockMetalFoundry(Block.Properties.create(Material.ANVIL).hardnessAndResistance(2.4f, 3f).lightValue(5).sound(SoundType.ANVIL)));
	public static final RegistryObject<Block> mud = BLOCKS.register("mud", () -> new BlockMud());
	public static final RegistryObject<Block> oil = BLOCKS.register("oil", () -> new BlockOil());
		
	
			
}
