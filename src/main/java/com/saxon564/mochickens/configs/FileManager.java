package com.saxon564.mochickens.configs;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeCache;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.saxon564.mochickens.MoChickens;
import com.saxon564.mochickens.configs.biomes.ChickenForestConfig;
import com.saxon564.mochickens.configs.biomes.ChickenPlainsConfig;
import com.saxon564.mochickens.configs.chickens.BeefyChickenConfig;
import com.saxon564.mochickens.configs.chickens.BlazingChickenConfig;
import com.saxon564.mochickens.configs.chickens.ClayChickenConfig;
import com.saxon564.mochickens.configs.chickens.CoalChickenConfig;
import com.saxon564.mochickens.configs.chickens.CookieChickenConfig;
import com.saxon564.mochickens.configs.chickens.CreeperChickenConfig;
import com.saxon564.mochickens.configs.chickens.DiamondChickenConfig;
import com.saxon564.mochickens.configs.chickens.EmeraldChickenConfig;
import com.saxon564.mochickens.configs.chickens.EnchantedChickenConfig;
import com.saxon564.mochickens.configs.chickens.EnderChickenConfig;
import com.saxon564.mochickens.configs.chickens.GiantChickenConfig;
import com.saxon564.mochickens.configs.chickens.GlowingChickenConfig;
import com.saxon564.mochickens.configs.chickens.GoldChickenConfig;
import com.saxon564.mochickens.configs.chickens.IronChickenConfig;
import com.saxon564.mochickens.configs.chickens.LapisChickenConfig;
import com.saxon564.mochickens.configs.chickens.NuuwChickenConfig;
import com.saxon564.mochickens.configs.chickens.QuartzChickenConfig;
import com.saxon564.mochickens.configs.chickens.RainbowChickenConfig;
import com.saxon564.mochickens.configs.chickens.RedstoneChickenConfig;
import com.saxon564.mochickens.configs.chickens.SkeletonChickenConfig;
import com.saxon564.mochickens.configs.chickens.SnowChickenConfig;

public class FileManager {

	public static int biomeListLength;
	public static int[] defaultBlacklist = {8, 9};
	public static int[] defaultNetherBlacklist;
	public static int[] defaultEndBlacklist;
	public static int[] allowedNether = {8};
	public static int[] allowedEnd = {9};
	
	public static void PreInit(FMLPreInitializationEvent event) {
		DimensionConfigs.setId(event);
		ChickenPlainsConfig.setId(event);
		ChickenForestConfig.setId(event);
		CoalChickenConfig.setId(event);
		IronChickenConfig.setId(event);
		GoldChickenConfig.setId(event);
		LapisChickenConfig.setId(event);
		RedstoneChickenConfig.setId(event);
		DiamondChickenConfig.setId(event);
		EmeraldChickenConfig.setId(event);
		GiantChickenConfig.setId(event);
		QuartzChickenConfig.setId(event);
		CookieChickenConfig.setId(event);
		SnowChickenConfig.setId(event);
		ClayChickenConfig.setId(event);
		RainbowChickenConfig.setId(event);
		SkeletonChickenConfig.setId(event);
		EnderChickenConfig.setId(event);
		CreeperChickenConfig.setId(event);
		BeefyChickenConfig.setId(event);
		GlowingChickenConfig.setId(event);
		BlazingChickenConfig.setId(event);
		EnchantedChickenConfig.setId(event);
		NuuwChickenConfig.setId(event);
		
	}

	public static void PostInit(FMLPostInitializationEvent event) {
		
		biomeListLength = generateList() -1;
		
		defaultNetherBlacklist = new int[biomeListLength];
		defaultEndBlacklist = new int[biomeListLength];

		// Blacklists
		defaultNetherBlacklist = generateBlackLists(allowedNether, "nether");
		defaultEndBlacklist = generateBlackLists(allowedEnd, "end");

		// Create Configs
		GeneralConfig.setConfigs(event);
		CoalChickenConfig.setConfigs(event);
		IronChickenConfig.setConfigs(event);
		GoldChickenConfig.setConfigs(event);
		RedstoneChickenConfig.setConfigs(event);
		LapisChickenConfig.setConfigs(event);
		DiamondChickenConfig.setConfigs(event);
		EmeraldChickenConfig.setConfigs(event);
		QuartzChickenConfig.setConfigs(event);
		GiantChickenConfig.setConfigs(event);
		CookieChickenConfig.setConfigs(event);
		SnowChickenConfig.setConfigs(event);
		ClayChickenConfig.setConfigs(event);
		RainbowChickenConfig.setConfigs(event);
		SkeletonChickenConfig.setConfigs(event);
		EnderChickenConfig.setConfigs(event);
		CreeperChickenConfig.setConfigs(event);
		BeefyChickenConfig.setConfigs(event);
		GlowingChickenConfig.setConfigs(event);
		BlazingChickenConfig.setConfigs(event);
		EnchantedChickenConfig.setConfigs(event);
		NuuwChickenConfig.setConfigs(event);
	}

	public static int[] generateBlackLists(int[] allowed, String type) {
		int[] ret = new int[biomeListLength];
		int loop = 0;
		for (int i = 0; i < Biome.REGISTRY.hashCode(); i++) {
			Biome biome = Biome.getBiome(i);
			if ((biome != null) && (!biome.getBiomeName().toLowerCase().equalsIgnoreCase("chicken forest")) && (!biome.getBiomeName().toLowerCase().equalsIgnoreCase("chicken plains")))
				if (biome.getBiomeName() == null) {
					System.out.println("[Mo' Chickens] Biome (id " + i + ") has null name, could not build spawn information.");
				} else {
					String name = biome.getBiomeName().toLowerCase();
					for (int k = 0; k < allowed.length; k++) {
						if (allowed[k] != i) {
							//System.out.println("BiomeGenBase Length    " + BiomeGenBase.getBiomeGenArray().length);
							ret[loop] = i;
							loop++;
						}
					}
				}
		}
		return ret;
	}
	
	public static int generateList() {
		int loop = 0;
		for (int i = 0; i < Biome.REGISTRY.hashCode(); i++) {
			Biome biome = Biome.getBiome(i);
			if ((biome != null) && (!biome.getBiomeName().toLowerCase().equalsIgnoreCase("chicken forest")) && (!biome.getBiomeName().toLowerCase().equalsIgnoreCase("chicken plains")))
				if (biome.getBiomeName() == null) {
					System.out.println("[Mo' Chickens] Biome (id " + i + ") has null name, could not build spawn information.");
				} else {
					String name = biome.getBiomeName().toLowerCase();
							loop++;
				}
		}
		return loop;
	}

}
