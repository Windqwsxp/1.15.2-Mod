package com.windqwsxp.expandedmod.init;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeDictionary.Type;

public class BiomeInit {
	
	public static Biome drylands;
	
	public static void registerBiomes() {
		registerBiome(drylands, Type.DEAD, Type.DRY);
	}
	
	public static void registerBiome(Biome biome, Type... type) {
		BiomeDictionary.addTypes(biome, type);
		BiomeManager.addSpawnBiome(biome);
	}
	
} 