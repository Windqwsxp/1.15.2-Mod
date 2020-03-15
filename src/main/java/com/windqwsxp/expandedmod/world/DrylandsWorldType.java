package com.windqwsxp.expandedmod.world;

import com.windqwsxp.expandedmod.init.BiomeInit;

import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.provider.SingleBiomeProvider;
import net.minecraft.world.biome.provider.SingleBiomeProviderSettings;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.OverworldChunkGenerator;
import net.minecraft.world.gen.OverworldGenSettings;


public class DrylandsWorldType extends WorldType {

	public DrylandsWorldType() {
		super("drylandswtype");
	}
	
	@Override
	public ChunkGenerator<?> createChunkGenerator(World world) {
		
		OverworldGenSettings genSettings = new OverworldGenSettings();
		SingleBiomeProviderSettings singleSettings = new SingleBiomeProviderSettings(world.getWorldInfo());
		singleSettings.setBiome(BiomeInit.drylands);
		return new OverworldChunkGenerator(world, new SingleBiomeProvider(singleSettings), genSettings);
		
	}

}