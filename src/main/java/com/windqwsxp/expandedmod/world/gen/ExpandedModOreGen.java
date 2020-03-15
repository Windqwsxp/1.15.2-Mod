package com.windqwsxp.expandedmod.world.gen;

import com.windqwsxp.expandedmod.init.BlockInit;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;
// if (biome == Biomes.PLAINS) {
//} else {
//biome = Biomes.ICE_SPIKES; 
//{

public class ExpandedModOreGen {
	public static void generateOre() {
		for (Biome biome : ForgeRegistries.BIOMES) {

			// Rarity (20 is not rare at all, less rare than coal), Blocks off the bottom of the world, Blocks off the top
			// of the world, Maximum height
			ConfiguredPlacement<CountRangeConfig> customConfig = Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 5, 8, 50));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,BlockInit.copperore.get().getDefaultState(), 8)).withPlacement(customConfig));
			ConfiguredPlacement<CountRangeConfig> customConfig1 = Placement.COUNT_RANGE.configure(new CountRangeConfig(4, 3, 8, 20));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,BlockInit.titaniumore.get().getDefaultState(), 9)).withPlacement(customConfig1));
			ConfiguredPlacement<CountRangeConfig> customConfig2 = Placement.COUNT_RANGE.configure(new CountRangeConfig(12, 3, 9, 30));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,BlockInit.limestone.get().getDefaultState(), 11)).withPlacement(customConfig2));
			ConfiguredPlacement<CountRangeConfig> customConfig3 = Placement.COUNT_RANGE.configure(new CountRangeConfig(4, 3, 4, 30));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,BlockInit.mud.get().getDefaultState(), 6)).withPlacement(customConfig3));
			ConfiguredPlacement<CountRangeConfig> customConfig4 = Placement.COUNT_RANGE.configure(new CountRangeConfig(4, 3, 4, 30));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,BlockInit.tinore.get().getDefaultState(), 6)).withPlacement(customConfig4));
			ConfiguredPlacement<CountRangeConfig> customConfig5 = Placement.COUNT_RANGE.configure(new CountRangeConfig(4, 3, 4, 30));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,BlockInit.nickelore.get().getDefaultState(), 6)).withPlacement(customConfig5));
		}

	}
}


