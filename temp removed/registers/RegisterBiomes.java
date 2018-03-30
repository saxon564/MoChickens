package com.saxon564.mochickens.registers;

import com.saxon564.mochickens.MoChickens;
import com.saxon564.mochickens.configs.biomes.ChickenForestConfig;
import com.saxon564.mochickens.configs.biomes.ChickenPlainsConfig;
import com.saxon564.mochickens.world.dimensions.chicken.biomes.BiomeGenChickenForest;
import com.saxon564.mochickens.world.dimensions.chicken.biomes.BiomeGenChickenPlains;

import net.minecraft.world.biome.Biome.BiomeProperties;
import net.minecraftforge.common.BiomeManager;

public class RegisterBiomes {

	public static void biomeRegisters() {
		
		MoChickens.chicken_forest = new BiomeGenChickenForest(new BiomeProperties("chicken forest"));
		MoChickens.chicken_plains = new BiomeGenChickenPlains(new BiomeProperties("chicken plains"));
		
		/*     (class, can villages spawn in it [true/false])     */
		RegisterHelper.registerBiome(MoChickens.chicken_forest, false);
		RegisterHelper.registerBiome(MoChickens.chicken_plains, true);
	}

}
