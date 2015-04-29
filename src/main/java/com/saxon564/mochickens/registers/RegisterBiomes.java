package com.saxon564.mochickens.registers;

import com.saxon564.mochickens.MoChickens;
import com.saxon564.mochickens.configs.biomes.ChickenForestConfig;
import com.saxon564.mochickens.configs.biomes.ChickenPlainsConfig;
import com.saxon564.mochickens.world.dimensions.chicken.biomes.BiomeGenChickenForest;
import com.saxon564.mochickens.world.dimensions.chicken.biomes.BiomeGenChickenPlains;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenMesa;
import net.minecraftforge.common.BiomeManager;

public class RegisterBiomes {

	public static void biomeRegisters() {
		
		MoChickens.biomeChickenForest = new BiomeGenChickenForest(ChickenForestConfig.id);
		MoChickens.biomeChickenPlains = new BiomeGenChickenPlains(ChickenPlainsConfig.id);
		
		/*     (class, can villages spawn in it [true/false])     */
		RegisterHelper.registerBiome(MoChickens.biomeChickenForest, false);
		RegisterHelper.registerBiome(MoChickens.biomeChickenPlains, true);
	}

}
