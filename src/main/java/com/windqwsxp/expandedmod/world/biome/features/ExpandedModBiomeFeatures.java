package com.windqwsxp.expandedmod.world.biome.features;

import com.google.common.collect.ImmutableSet;
import com.windqwsxp.expandedmod.init.BlockInit;
import com.windqwsxp.expandedmod.objects.blocks.BluebushBlock;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;

public class ExpandedModBiomeFeatures {
	private static final BlockState GRASS_BLOCK = Blocks.GRASS_BLOCK.getDefaultState();
	private static final BlockState SWEET_BERRY_BUSH = BlockInit.bluebush.get().getDefaultState().with(BluebushBlock.AGE, Integer.valueOf(3));
	   
	public static final BlockClusterFeatureConfig SWEET_BERRY_BUSH_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(SWEET_BERRY_BUSH), new SimpleBlockPlacer())).tries(64).func_227316_a_(ImmutableSet.of(GRASS_BLOCK.getBlock())).func_227317_b_().build();
	
	public static void addSparseBerryBushes(Biome biomeIn) {
	      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(SWEET_BERRY_BUSH_CONFIG).withPlacement(Placement.CHANCE_HEIGHTMAP_DOUBLE.configure(new ChanceConfig(12))));
	   }

	   public static void addBerryBushes(Biome biomeIn) {
	      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(SWEET_BERRY_BUSH_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
	   }
	 
}