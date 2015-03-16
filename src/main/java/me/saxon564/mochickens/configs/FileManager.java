package me.saxon564.mochickens.configs;

import java.io.File;

import me.saxon564.mochickens.MoChickens;
import me.saxon564.mochickens.configs.chickens.*;
import me.saxon564.mochickens.configs.txts.ItemFile;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;

public class FileManager {

	public static int biomeListLength;
	public static int[] defaultBlacklist = {8, 9};
	public static int[] defaultNetherBlacklist;
	public static int[] defaultEndBlacklist;
	public static int[] allowedNether = {8};
	public static int[] allowedEnd = {9};
	
	public static void PreInit(FMLPreInitializationEvent event) {
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

		// dimension IDs
		// MoChickens.chickenDimensionId = config.get("Dimension IDs",
		// "Chicken Dimension", 20).getInt(20);

		// biome IDs
		// MoChickens.biomeChickenForestId = config.get("Biome IDs",
		// "Chicken Forest Biome", 50).getInt(50);
	}

	public static int[] generateBlackLists(int[] allowed, String type) {
		int[] ret = new int[biomeListLength];
		int loop = 0;
		for (int i = 0; i < BiomeGenBase.getBiomeGenArray().length; i++) {
			BiomeGenBase biome = BiomeGenBase.getBiome(i);
			if ((biome != null) && (!biome.biomeName.toLowerCase().equalsIgnoreCase("chicken forest")) && (!biome.biomeName.toLowerCase().equalsIgnoreCase("chicken plains")))
				if (biome.biomeName == null) {
					System.out.println("[Mo' Chickens] Biome (id " + i + ") has null name, could not build spawn information.");
				} else {
					String name = biome.biomeName.toLowerCase();
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
		for (int i = 0; i < BiomeGenBase.getBiomeGenArray().length; i++) {
			BiomeGenBase biome = BiomeGenBase.getBiome(i);
			if ((biome != null) && (!biome.biomeName.toLowerCase().equalsIgnoreCase("chicken forest")) && (!biome.biomeName.toLowerCase().equalsIgnoreCase("chicken plains")))
				if (biome.biomeName == null) {
					System.out.println("[Mo' Chickens] Biome (id " + i + ") has null name, could not build spawn information.");
				} else {
					String name = biome.biomeName.toLowerCase();
							loop++;
				}
		}
		return loop;
	}

}
