package com.saxon564.mochickens.configs;

import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeCache;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.saxon564.mochickens.MoChickens;

public class FileManager {

	public static int biomeListLength;
	public static String[] defaultBlacklist = {"minecraft:hell", "minecraft:sky"};
	public static String[] defaultNetherWhitelist = {"minecraft:hell"};
	public static String[] defaultEndBlacklist = {"minecraft:hell"};
	public static String[] allowedNether = {"minecraft:hell"};
	public static String[] allowedEnd = {"minecraft:sky"};

	public static Configuration beefyConfig;
	public static Configuration blazingConfig;
	public static Configuration clayConfig;
	public static Configuration coalConfig;
	public static Configuration cookieConfig;
	public static Configuration creeperConfig;
	public static Configuration diamondConfig;
	public static Configuration emeraldConfig;
	public static Configuration enchantedConfig;
	public static Configuration enderConfig;
	public static Configuration giantConfig;
	public static Configuration glowingConfig;
	public static Configuration goldConfig;
	public static Configuration ironConfig;
	public static Configuration lapisConfig;
	public static Configuration nuuwConfig;
	public static Configuration quartzConfig;
	public static Configuration rainbowConfig;
	public static Configuration redstoneConfig;
	public static Configuration skeletonConfig;
	public static Configuration snowConfig;
	
	public static void PreInit(FMLPreInitializationEvent event) {
		//DimensionConfigs.setId(event);
		//ChickenPlainsConfig.setId(event);
		//ChickenForestConfig.setId(event);
		beefyConfig = ChickenConfigGenerator.setId(event, "BeefyChicken.cfg", 516);
		blazingConfig = ChickenConfigGenerator.setId(event, "BlazingChicken.cfg", 518);
		clayConfig = ChickenConfigGenerator.setId(event, "ClayChicken.cfg", 511);
		coalConfig = ChickenConfigGenerator.setId(event, "CoalChicken.cfg", 500);
		cookieConfig = ChickenConfigGenerator.setId(event, "CookieChicken.cfg", 509);
		creeperConfig = ChickenConfigGenerator.setId(event, "CreeperChicken.cfg", 515);
		diamondConfig = ChickenConfigGenerator.setId(event, "DiamondChicken.cfg", 505);
		emeraldConfig = ChickenConfigGenerator.setId(event, "EmeraldChicken.cfg", 506);
		enchantedConfig = ChickenConfigGenerator.setId(event, "EnchantedChicken.cfg", 519);
		enderConfig = ChickenConfigGenerator.setId(event, "EnderChicken.cfg", 514);
		giantConfig = ChickenConfigGenerator.setId(event, "GiantChicken.cfg", 507);
		glowingConfig = ChickenConfigGenerator.setId(event, "GlowingChicken.cfg", 517);
		goldConfig = ChickenConfigGenerator.setId(event, "GoldChicken.cfg", 502);
		ironConfig = ChickenConfigGenerator.setId(event, "IronChicken.cfg", 501);
		lapisConfig = ChickenConfigGenerator.setId(event, "LapisChicken.cfg", 503);
		nuuwConfig = ChickenConfigGenerator.setId(event, "NuuwChicken.cfg", 520);
		quartzConfig = ChickenConfigGenerator.setId(event, "QuartzChicken.cfg", 508);
		rainbowConfig = ChickenConfigGenerator.setId(event, "RainbowChicken.cfg", 512);
		redstoneConfig = ChickenConfigGenerator.setId(event, "RedstoneChicken.cfg", 504);
		skeletonConfig = ChickenConfigGenerator.setId(event, "SkeletonChicken.cfg", 513);
		snowConfig = ChickenConfigGenerator.setId(event, "SnowChicken.cfg", 510);
		/*CoalChickenConfig.setId(event);
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
		NuuwChickenConfig.setId(event);*/
		
	}

	public static void PostInit(FMLPostInitializationEvent event) {
		
		biomeListLength = generateList();

		// Create Configs
		GeneralConfig.setConfigs(event);
		/*ChickenConfigGenerator.setConfigs(FMLPostInitializationEvent event, Configuration configIn, 
			<----- Spawning ----->
			boolean canSpawn, int probability, int minGroup, int maxGroup, int minLight, int maxLight, 
			double minTempIn, double maxTempIn, String blacklistWhitelist, String[] biomeListIn, 
			<----- Entity Data ----->
			double healthIn, double speedIn, double hitX, double hitZ, boolean despawnUntamed, 
			boolean despawnTamed, boolean hostile, boolean babies, boolean teleport, boolean emitLight, 
			int light, boolean immuneFire, boolean fireInLight, boolean waterHurt, double waterDamaged, 
			boolean emitParticles, String particle, int particleOccurance, 
			<----- Taming ----->
			String itemTame, int chance, boolean useDataTame, int dataTame, 
			<----- Tempting ----->
			String itemTempt, boolean useDataTempt, int dataTempt, int delay, 
			<----- Breeding ----->
			String itemBreed, boolean useDataBreed, int dataBreed, 
			<----- Laying ----->
			String itemLay, boolean useDataLay, boolean randomData, int minData, int maxData, int dataLay,
			int amount, int minLayTime, int varLayTime, String sound, 
			<----- Attack Data ----->
			double damage, boolean createFire, int fireLength, double speedAttack, int[] effects, 
			int[] effectDurationsIn, int[] effectAmplifiersIn, double attackRange, int fuse, 
			boolean exploding, int explodingRadius, boolean shootArrows, int arrowSpeed, 
			<----- Exploding Chicken Syndrome ----->
			boolean explodingSyndrome, boolean eCSNotifyInfectedOwner, boolean eCSWhenTamed, 
			boolean eCSWhenWild, boolean eCSClearWhenTamed, int eCSChance, int eCSBabyChance, 
			int eCSFalseFuse, int eCSExplode, 
			<----- Mad Chicken Disease ----->
			boolean madChicken, boolean mCDNotifyInfectedOwner, boolean mCDWhenTamed, boolean mCDWhenWild, 
			boolean mCDClearWhenTamed, int mCDChance, int mCDBabyChance)*/
		ChickenConfigGenerator.setConfigs(event, beefyConfig, 
				//<----- Spawning ----->
				true, 8, 2, 4, 7, 12, 0.1D, 100.0D, "Blacklist", defaultBlacklist, 
				//<----- Entity Data ----->
				10.0D, 0.25D, 0.3D, 0.7D, true, false, true, true, false, false, 0, false, false, false, 
				0.0D, false, "none", 0, 
				//<----- Taming ----->
				"minecraft:beef", 3, false, 0, 
				//<----- Tempting ----->
				"minecraft:cooked_beef", false, 0, 100, 
				//<----- Breeding ----->
				"minecraft:cooked_beef", false, 0, 
				//<----- Laying ----->
				"minecraft:cooked_beef", false, false, 0, 0, 0, 1, 6000, 2500, "entity.chicken.egg", 
				//<----- Attack Data ----->
				5.0D, false, 0, 0.25D, new String[] {"minecraft:slowness"}, new int[] {200}, new int[] {3}, 16.0D, 0, false, 0, false, 0, 
				//<----- Exploding Chicken Syndrome ----->
				false, false, false, false, false, 0, 0, 0, 0, 
				//<----- Mad Chicken Disease ----->
				true, false, true, true, false, 50000, 37500);
		ChickenConfigGenerator.setConfigs(event, blazingConfig, 
				//<----- Spawning ----->
				true, 3, 1, 2, 0, 12, 0.1D, 100.0D, "Whitelist", defaultNetherWhitelist, 
				//<----- Entity Data ----->
				15.0D, 0.25D, 0.3D, 0.7D, true, false, true, true, false, true, 5, true, false, true, 
				2.0D, true, "largesmoke", 2, 
				//<----- Taming ----->
				"minecraft:blaze_rod", 3, false, 0, 
				//<----- Tempting ----->
				"minecraft:blaze_rod", false, 0, 100, 
				//<----- Breeding ----->
				"minecraft:blaze_rod", false, 0, 
				//<----- Laying ----->
				"minecraft:blaze_powder", false, false, 0, 0, 0, 1, 6000, 300, "entity.chicken.egg", 
				//<----- Attack Data ----->
				5.0D, true, 7, 0.25D, new String[] {"minecraft:slowness"}, new int[] {200}, new int[] {3}, 16.0D, 0, false, 0, false, 0, 
				//<----- Exploding Chicken Syndrome ----->
				false, false, false, false, false, 0, 0, 0, 0, 
				//<----- Mad Chicken Disease ----->
				true, false, true, true, false, 50000, 37500);
		ChickenConfigGenerator.setConfigs(event, clayConfig, 
				//<----- Spawning ----->
				true, 6, 1, 2, 7, 12, 0.1D, 100.0D, "Blacklist", defaultBlacklist, 
				//<----- Entity Data ----->
				6.0D, 0.25D, 0.3D, 0.7D, true, false, true, true, false, false, 0, false, false, false, 
				0.0D, false, "none", 0, 
				//<----- Taming ----->
				"minecraft:clay_ball", 3, false, 0, 
				//<----- Tempting ----->
				"minecraft:clay", false, 0, 100, 
				//<----- Breeding ----->
				"minecraft:clay_ball", false, 0, 
				//<----- Laying ----->
				"minecraft:clay_ball", false, false, 0, 0, 0, 1, 6000, 2000, "entity.chicken.egg", 
				//<----- Attack Data ----->
				2.0D, false, 0, 0.25D, new String[] {"minecraft:slowness", "minecraft:blindness", "minecraft:mining_fatigue"}, 
				new int[] {200, 200, 200}, new int[] {2, 3, 3}, 16.0D, 0, false, 0, false, 0, 
				//<----- Exploding Chicken Syndrome ----->
				false, false, false, false, false, 0, 0, 0, 0, 
				//<----- Mad Chicken Disease ----->
				true, false, true, true, false, 50000, 37500);
		ChickenConfigGenerator.setConfigs(event, coalConfig, 
				//<----- Spawning ----->
				true, 10, 1, 5, 7, 12, 0.1D, 100.0D, "Blacklist", defaultBlacklist, 
				//<----- Entity Data ----->
				4.0D, 0.25D, 0.3D, 0.7D, true, false, true, true, false, false, 0, false, false, false, 
				0.0D, false, "none", 0, 
				//<----- Taming ----->
				"minecraft:coal", 3, false, 0, 
				//<----- Tempting ----->
				"minecraft:coal_block", false, 0, 100, 
				//<----- Breeding ----->
				"minecraft:coal", false, 0, 
				//<----- Laying ----->
				"minecraft:coal", false, false, 0, 0, 0, 1, 6000, 2000, "entity.chicken.egg", 
				//<----- Attack Data ----->
				2.0D, false, 0, 0.25D, new String[] {"minecraft:slowness"}, new int[] {200}, new int[] {3}, 16.0D, 0, false, 0, false, 0, 
				//<----- Exploding Chicken Syndrome ----->
				false, false, false, false, false, 0, 0, 0, 0, 
				//<----- Mad Chicken Disease ----->
				true, false, true, true, false, 50000, 37500);
		ChickenConfigGenerator.setConfigs(event, cookieConfig, 
				//<----- Spawning ----->
				true, 8, 2, 4, 7, 12, 0.1D, 100.0D, "Blacklist", defaultBlacklist, 
				//<----- Entity Data ----->
				10.0D, 0.25D, 0.3D, 0.7D, true, false, true, true, false, false, 0, false, false, false, 
				0.0D, false, "none", 0, 
				//<----- Taming ----->
				"minecraft:cookie", 3, false, 0, 
				//<----- Tempting ----->
				"minecraft:dye", true, 3, 100, 
				//<----- Breeding ----->
				"minecraft:cookie", false, 0, 
				//<----- Laying ----->
				"minecraft:cookie", false, false, 0, 0, 0, 1, 6000, 2500, "entity.chicken.egg", 
				//<----- Attack Data ----->
				3.0D, false, 0, 0.25D, new String[] {"minecraft:speed", "minecraft:nausea"}, new int[] {200, 200}, new int[] {3, 3}, 
				16.0D, 0, false, 0, false, 0, 
				//<----- Exploding Chicken Syndrome ----->
				false, false, false, false, false, 0, 0, 0, 0, 
				//<----- Mad Chicken Disease ----->
				true, false, true, true, false, 50000, 37500);
		ChickenConfigGenerator.setConfigs(event, creeperConfig, 
				//<----- Spawning ----->
				true, 7, 1, 3, 0, 7, 0.1D, 100.0D, "Blacklist", defaultBlacklist, 
				//<----- Entity Data ----->
				16.0D, 0.25D, 0.3D, 0.7D, true, false, true, true, false, false, 0, false, false, false, 
				0.0D, false, "none", 0, 
				//<----- Taming ----->
				"minecraft:gunpowder", 3, false, 0, 
				//<----- Tempting ----->
				"minecraft:tnt", false, 0, 100, 
				//<----- Breeding ----->
				"minecraft:gunpowder", false, 0, 
				//<----- Laying ----->
				"minecraft:gunpowder", false, false, 0, 0, 0, 1, 6000, 200, "entity.chicken.egg", 
				//<----- Attack Data ----->
				0.0D, false, 0, 0.25D, new String[] {"minecraft:nausea", "minecraft:blindness"}, new int[] {300, 300}, new int[] {5, 1}, 
				16.0D, 0, false, 3, false, 0, 
				//<----- Exploding Chicken Syndrome ----->
				true, false, true, true, false, 100000, 75000, 1000, 100000, 
				//<----- Mad Chicken Disease ----->
				false, false, false, false, false, 0, 0);
		ChickenConfigGenerator.setConfigs(event, diamondConfig, 
				//<----- Spawning ----->
				true, 5, 1, 2, 7, 12, 0.1D, 100.0D, "Blacklist", defaultBlacklist, 
				//<----- Entity Data ----->
				20.0D, 0.25D, 0.3D, 0.7D, true, false, true, true, false, false, 0, false, false, false, 
				0.0D, false, "none", 0, 
				//<----- Taming ----->
				"minecraft:diamond", 3, false, 0, 
				//<----- Tempting ----->
				"minecraft:diamond_block", false, 0, 100, 
				//<----- Breeding ----->
				"minecraft:diamond", false, 0, 
				//<----- Laying ----->
				"minecraft:diamond", false, false, 0, 0, 0, 1, 6000, 2500, "mochickens:layDiamond", 
				//<----- Attack Data ----->
				5.0D, false, 0, 0.25D, new String[] {"minecraft:blindeness", "minecraft:slowness"}, new int[] {200, 200}, new int[] {1, 3}, 
				16.0D, 0, false, 0, false, 0, 
				//<----- Exploding Chicken Syndrome ----->
				false, false, false, false, false, 0, 0, 0, 0, 
				//<----- Mad Chicken Disease ----->
				true, false, true, true, false, 50000, 37500);
		ChickenConfigGenerator.setConfigs(event, emeraldConfig, 
				//<----- Spawning ----->
				true, 5, 1, 2, 7, 12, 0.1D, 100.0D, "Blacklist", defaultBlacklist, 
				//<----- Entity Data ----->
				16.0D, 0.25D, 0.3D, 0.7D, true, false, true, true, false, false, 0, false, false, false, 
				0.0D, false, "none", 0, 
				//<----- Taming ----->
				"minecraft:emerald", 3, false, 0, 
				//<----- Tempting ----->
				"minecraft:emerald_block", false, 0, 100, 
				//<----- Breeding ----->
				"minecraft:emerald", false, 0, 
				//<----- Laying ----->
				"minecraft:emerald", false, false, 0, 0, 0, 1, 6000, 6000, "entity.chicken.egg", 
				//<----- Attack Data ----->
				5.0D, false, 0, 0.25D, new String[] {"minecraft:nausea"}, new int[] {200}, new int[] {2}, 
				16.0D, 0, false, 0, false, 0, 
				//<----- Exploding Chicken Syndrome ----->
				false, false, false, false, false, 0, 0, 0, 0, 
				//<----- Mad Chicken Disease ----->
				true, false, true, true, false, 50000, 37500);
		ChickenConfigGenerator.setConfigs(event, enchantedConfig, 
				//<----- Spawning ----->
				true, 8, 2, 4, 7, 12, 0.1D, 100.0D, "Blacklist", defaultBlacklist, 
				//<----- Entity Data ----->
				4.0D, 0.25D, 0.3D, 0.7D, true, false, true, true, false, true, 4, false, false, false, 
				0.0D, true, "enchantmenttable", 5, 
				//<----- Taming ----->
				"minecraft:enchanted_book", 3, false, 0, 
				//<----- Tempting ----->
				"minecraft:enchanting_table", false, 0, 100, 
				//<----- Breeding ----->
				"minecraft:experience_bottle", false, 0, 
				//<----- Laying ----->
				"minecraft:experience_bottle", false, false, 0, 0, 0, 1, 6000, 6000, "entity.chicken.egg", 
				//<----- Attack Data ----->
				5.0D, false, 0, 0.25D, new String[] {"minecraft:nausea"}, new int[] {200}, new int[] {3}, 
				16.0D, 0, false, 0, false, 0, 
				//<----- Exploding Chicken Syndrome ----->
				false, false, false, false, false, 0, 0, 0, 0, 
				//<----- Mad Chicken Disease ----->
				true, false, true, true, false, 50000, 37500);
		ChickenConfigGenerator.setConfigs(event, enderConfig, 
				//<----- Spawning ----->
				true, 3, 21, 4, 7, 12, 0.1D, 100.0D, "Blacklist", defaultEndBlacklist, 
				//<----- Entity Data ----->
				20.0D, 0.25D, 0.3D, 0.7D, true, false, true, true, true, false, 0, false, false, true, 
				1.0D, true, "portal", 2, 
				//<----- Taming ----->
				"minecraft:ender_pearl", 3, false, 0, 
				//<----- Tempting ----->
				"minecraft:ender_eye", false, 0, 100, 
				//<----- Breeding ----->
				"minecraft:ender_pearl", false, 0, 
				//<----- Laying ----->
				"minecraft:ender_pearl", false, false, 0, 0, 0, 1, 6000, 6000, "entity.chicken.egg", 
				//<----- Attack Data ----->
				6.0D, false, 0, 1.2599999809265137D, new String[] {"minecraft:weakness", "minecraft:blindness"}, new int[] {200, 200}, 
				new int[] {3, 5}, 16.0D, 0, false, 0, false, 0, 
				//<----- Exploding Chicken Syndrome ----->
				false, false, false, false, false, 0, 0, 0, 0, 
				//<----- Mad Chicken Disease ----->
				true, false, true, true, false, 50000, 37500);
		ChickenConfigGenerator.setConfigs(event, giantConfig, 
				//<----- Spawning ----->
				true, 4, 1, 2, 7, 12, 0.1D, 100.0D, "Blacklist", defaultBlacklist, 
				//<----- Entity Data ----->
				16.0D, 0.25D, 1.25D, 2.5D, true, false, true, true, false, false, 0, false, false, false, 
				0.0D, false, "none", 0, 
				//<----- Taming ----->
				"mochickens:taming_disc", 3, false, 0, 
				//<----- Tempting ----->
				"mochickens:taming_disc", false, 0, 100, 
				//<----- Breeding ----->
				"mochickens:taming_disc", false, 0, 
				//<----- Laying ----->
				"mochickens:random_egg", false, false, 0, 0, 0, 1, 6000, 5000, "entity.chicken.egg", 
				//<----- Attack Data ----->
				7.0D, false, 0, 0.25D, new String[] {"minecraft:slowness", "minecraft:poison", "minecraft:blindness"}, 
				new int[] {200, 200, 200}, new int[] {2, 1, 1}, 16.0D, 0, false, 0, false, 0, 
				//<----- Exploding Chicken Syndrome ----->
				false, false, false, false, false, 0, 0, 0, 0, 
				//<----- Mad Chicken Disease ----->
				true, false, true, true, false, 50000, 37500);
		ChickenConfigGenerator.setConfigs(event, glowingConfig, 
				//<----- Spawning ----->
				true, 8, 2, 4, 0, 12, 0.1D, 100.0D, "Whitelist", defaultNetherWhitelist, 
				//<----- Entity Data ----->
				6.0D, 0.25D, 0.3D, 0.7D, true, false, true, true, false, true, 12, false, false, false, 
				0.0D, false, "none", 0, 
				//<----- Taming ----->
				"mochickens:glowstone_dust", 3, false, 0, 
				//<----- Tempting ----->
				"mochickens:glowstone", false, 0, 100, 
				//<----- Breeding ----->
				"mochickens:glowstone_dust", false, 0, 
				//<----- Laying ----->
				"mochickens:glowstone_dust", false, false, 0, 0, 0, 1, 6000, 3000, "entity.chicken.egg", 
				//<----- Attack Data ----->
				3.0D, false, 0, 0.25D, new String[] {"minecraft:night_vision", "minecraft:jump_boost", "minecraft:speed"}, 
				new int[] {500, 400, 500}, new int[] {2, 5, 3}, 16.0D, 0, false, 0, false, 0, 
				//<----- Exploding Chicken Syndrome ----->
				false, false, false, false, false, 0, 0, 0, 0, 
				//<----- Mad Chicken Disease ----->
				true, false, true, true, false, 50000, 37500);
		ChickenConfigGenerator.setConfigs(event, goldConfig, 
				//<----- Spawning ----->
				true, 7, 1, 2, 7, 12, 0.1D, 100.0D, "Blacklist", defaultBlacklist, 
				//<----- Entity Data ----->
				8.0D, 0.25D, 0.3D, 0.7D, true, false, true, true, false, false, 0, false, false, false, 
				0.0D, false, "none", 0, 
				//<----- Taming ----->
				"mochickens:gold_ingot", 3, false, 0, 
				//<----- Tempting ----->
				"mochickens:gold_block", false, 0, 100, 
				//<----- Breeding ----->
				"mochickens:gold_ingot", false, 0, 
				//<----- Laying ----->
				"mochickens:gold_ingot", false, false, 0, 0, 0, 1, 6000, 5000, "entity.chicken.egg", 
				//<----- Attack Data ----->
				3.0D, false, 0, 0.25D, new String[] {"minecraft:blindness"}, 
				new int[] {200}, new int[] {1}, 16.0D, 0, false, 0, false, 0, 
				//<----- Exploding Chicken Syndrome ----->
				false, false, false, false, false, 0, 0, 0, 0, 
				//<----- Mad Chicken Disease ----->
				true, false, true, true, false, 50000, 37500);
		ChickenConfigGenerator.setConfigs(event, ironConfig, 
				//<----- Spawning ----->
				true, 9, 1, 3, 7, 12, 0.1D, 100.0D, "Blacklist", defaultBlacklist, 
				//<----- Entity Data ----->
				6.0D, 0.25D, 0.3D, 0.7D, true, false, true, true, false, false, 0, false, false, false, 
				0.0D, false, "none", 0, 
				//<----- Taming ----->
				"mochickens:iron_ingot", 3, false, 0, 
				//<----- Tempting ----->
				"mochickens:iron_block", false, 0, 100, 
				//<----- Breeding ----->
				"mochickens:iron_ingot", false, 0, 
				//<----- Laying ----->
				"mochickens:iron_ingot", false, false, 0, 0, 0, 1, 6000, 3000, "entity.chicken.egg", 
				//<----- Attack Data ----->
				2.0D, false, 0, 0.25D, new String[] {"minecraft:poison"}, 
				new int[] {200}, new int[] {1}, 16.0D, 0, false, 0, false, 0, 
				//<----- Exploding Chicken Syndrome ----->
				false, false, false, false, false, 0, 0, 0, 0, 
				//<----- Mad Chicken Disease ----->
				true, false, true, true, false, 50000, 37500);
		ChickenConfigGenerator.setConfigs(event, lapisConfig, 
				//<----- Spawning ----->
				true, 7, 1, 3, 7, 12, 0.1D, 100.0D, "Blacklist", defaultBlacklist, 
				//<----- Entity Data ----->
				8.0D, 0.25D, 0.3D, 0.7D, true, false, true, true, false, false, 0, false, false, false, 
				0.0D, false, "none", 0, 
				//<----- Taming ----->
				"minecraft:dye", 3, true, 4, 
				//<----- Tempting ----->
				"minecraft:lapis_block", false, 0, 100, 
				//<----- Breeding ----->
				"minecraft:dye", true, 4, 
				//<----- Laying ----->
				"minecraft:dye", true, false, 0, 0, 4, 1, 6000, 3000, "entity.chicken.egg", 
				//<----- Attack Data ----->
				1.0D, false, 0, 0.25D, new String[] {"minecraft:slowness"}, 
				new int[] {200}, new int[] {1}, 16.0D, 0, false, 0, false, 0, 
				//<----- Exploding Chicken Syndrome ----->
				false, false, false, false, false, 0, 0, 0, 0, 
				//<----- Mad Chicken Disease ----->
				true, false, true, true, false, 50000, 37500);
		ChickenConfigGenerator.setConfigs(event, nuuwConfig, 
				//<----- Spawning ----->
				true, 8, 2, 4, 7, 12, 0.1D, 100.0D, "Blacklist", defaultBlacklist, 
				//<----- Entity Data ----->
				5.0D, 0.25D, 0.3D, 0.7D, true, false, true, true, false, false, 0, false, false, false, 
				0.0D, false, "none", 0, 
				//<----- Taming ----->
				"minecraft:diamond", 3, false, 0, 
				//<----- Tempting ----->
				"minecraft:grass", false, 0, 100, 
				//<----- Breeding ----->
				"minecraft:grass", false, 0, 
				//<----- Laying ----->
				"minecraft:dirt", false, false, 0, 0, 0, 1, 6000, 2000, "entity.chicken.egg", 
				//<----- Attack Data ----->
				1.0D, false, 0, 0.25D, new String[] {"minecraft:blindness", "minecraft:slowness"}, 
				new int[] {200, 200}, new int[] {1, 2}, 16.0D, 0, false, 0, false, 0, 
				//<----- Exploding Chicken Syndrome ----->
				false, false, false, false, false, 0, 0, 0, 0, 
				//<----- Mad Chicken Disease ----->
				true, false, true, true, false, 50000, 37500);
		ChickenConfigGenerator.setConfigs(event, quartzConfig, 
				//<----- Spawning ----->
				true, 7, 1, 3, 0, 12, 0.1D, 100.0D, "Whitelist", defaultNetherWhitelist, 
				//<----- Entity Data ----->
				12.0D, 0.25D, 0.3D, 0.7D, true, false, true, true, false, false, 0, true, false, false, 
				0.0D, false, "none", 0, 
				//<----- Taming ----->
				"minecraft:quartz", 3, false, 0, 
				//<----- Tempting ----->
				"minecraft:quartz_block", false, 0, 100, 
				//<----- Breeding ----->
				"minecraft:quartz", false, 0, 
				//<----- Laying ----->
				"minecraft:quartz", false, false, 0, 0, 0, 1, 6000, 3000, "entity.chicken.egg", 
				//<----- Attack Data ----->
				5.0D, false, 0, 0.25D, new String[] {"minecraft:speed", "minecraft:blindness"}, 
				new int[] {200, 200}, new int[] {3, 1}, 16.0D, 0, false, 0, false, 0, 
				//<----- Exploding Chicken Syndrome ----->
				false, false, false, false, false, 0, 0, 0, 0, 
				//<----- Mad Chicken Disease ----->
				true, false, true, true, false, 50000, 37500);
		ChickenConfigGenerator.setConfigs(event, rainbowConfig, 
				//<----- Spawning ----->
				true, 7, 2, 5, 7, 12, 0.1D, 100.0D, "Blacklist", defaultBlacklist, 
				//<----- Entity Data ----->
				10.0D, 0.25D, 0.3D, 0.7D, true, false, true, true, false, false, 0, false, false, false, 
				0.0D, false, "none", 0, 
				//<----- Taming ----->
				"minecraft:dye", 3, false, 0, 
				//<----- Tempting ----->
				"minecraft:wool", false, 0, 100, 
				//<----- Breeding ----->
				"minecraft:dye", false, 0, 
				//<----- Laying ----->
				"minecraft:dye", true, true, 0, 15, 0, 1, 6000, 2000, "entity.chicken.egg", 
				//<----- Attack Data ----->
				4.0D, false, 0, 0.25D, new String[] {"minecraft:nausea", "minecraft:blindness"}, 
				new int[] {200, 200}, new int[] {4, 2}, 16.0D, 0, false, 0, false, 0, 
				//<----- Exploding Chicken Syndrome ----->
				false, false, false, false, false, 0, 0, 0, 0, 
				//<----- Mad Chicken Disease ----->
				true, false, true, true, false, 50000, 37500);
		ChickenConfigGenerator.setConfigs(event, redstoneConfig, 
				//<----- Spawning ----->
				true, 6, 1, 2, 7, 12, 0.1D, 100.0D, "Blacklist", defaultBlacklist, 
				//<----- Entity Data ----->
				4.0D, 0.25D, 0.3D, 0.7D, true, false, true, true, false, false, 0, false, false, false, 
				0.0D, false, "none", 0, 
				//<----- Taming ----->
				"minecraft:redstone", 3, false, 0, 
				//<----- Tempting ----->
				"minecraft:redstone_block", false, 0, 100, 
				//<----- Breeding ----->
				"minecraft:redstone", false, 0, 
				//<----- Laying ----->
				"minecraft:redstone", false, false, 0, 0, 0, 1, 6000, 2000, "entity.chicken.egg", 
				//<----- Attack Data ----->
				5.0D, true, 15, 0.25D, new String[] {"minecraft:speed"}, 
				new int[] {200}, new int[] {10}, 16.0D, 0, false, 0, false, 0, 
				//<----- Exploding Chicken Syndrome ----->
				false, false, false, false, false, 0, 0, 0, 0, 
				//<----- Mad Chicken Disease ----->
				true, false, true, true, false, 50000, 37500);
		ChickenConfigGenerator.setConfigs(event, skeletonConfig, 
				//<----- Spawning ----->
				true, 10, 1, 3, 0, 7, 0.1D, 100.0D, "Blacklist", defaultBlacklist, 
				//<----- Entity Data ----->
				10.0D, 0.25D, 0.3D, 0.7D, true, false, true, true, false, false, 0, false, true, false, 
				0.0D, false, "none", 0, 
				//<----- Taming ----->
				"minecraft:bone", 3, false, 0, 
				//<----- Tempting ----->
				"minecraft:bone_block", false, 0, 100, 
				//<----- Breeding ----->
				"minecraft:bone", false, 0, 
				//<----- Laying ----->
				"minecraft:dye", true, false, 0, 0, 15, 1, 6000, 3500, "entity.chicken.egg", 
				//<----- Attack Data ----->
				0.0D, false, 0, 0.25D, new String[] {"minecraft:slowness"}, 
				new int[] {200}, new int[] {3}, 16.0D, 0, false, 0, true, 60, 
				//<----- Exploding Chicken Syndrome ----->
				false, false, false, false, false, 0, 0, 0, 0, 
				//<----- Mad Chicken Disease ----->
				true, false, true, true, false, 50000, 37500);
		ChickenConfigGenerator.setConfigs(event, snowConfig, 
				//<----- Spawning ----->
				true, 3, 1, 5, 7, 12, 0.1D, 50.0D, "Blacklist", defaultBlacklist, 
				//<----- Entity Data ----->
				8.0D, 0.25D, 0.3D, 0.7D, true, false, true, true, false, false, 0, false, false, false, 
				0.0D, false, "none", 0, 
				//<----- Taming ----->
				"minecraft:snowball", 3, false, 0, 
				//<----- Tempting ----->
				"minecraft:snow_block", false, 0, 100, 
				//<----- Breeding ----->
				"minecraft:snowball", false, 0, 
				//<----- Laying ----->
				"minecraft:snowball", false, false, 0, 0, 0, 1, 6000, 1000, "entity.chicken.egg", 
				//<----- Attack Data ----->
				1.0D, false, 0, 0.25D, new String[] {"minecraft:mining_fatigue"}, 
				new int[] {200}, new int[] {3}, 16.0D, 0, false, 0, false, 0, 
				//<----- Exploding Chicken Syndrome ----->
				false, false, false, false, false, 0, 0, 0, 0, 
				//<----- Mad Chicken Disease ----->
				true, false, true, true, false, 50000, 37500);
		/*CoalChickenConfig.setConfigs(event);
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
		NuuwChickenConfig.setConfigs(event);*/
	}

	/*public static String[] generateBlackLists(String[] allowed, String type) {
		String[] ret = new String[biomeListLength];
		int loop = 0;
		for (Object obj : Biome.REGISTRY.getKeys()) {
			String biome = (String) obj.toString().toLowerCase();
			if ((biome != null) && (!biome.equalsIgnoreCase("mochickens:chicken_forest")) && (!biome.equalsIgnoreCase("mochickens:chicken_plains"))) {
				for (int k = 0; k < allowed.length; k++) {
					if (!allowed[k].toLowerCase().equals(biome)) {
						ret[loop] = biome;
						loop++;
					} else {
						System.out.println("Generating " + type + " list! " + allowed[k] + " compared to " + biome);
					}
				}
			} else {
				System.out.println("[Mo' Chickens] Biome (id " + biome + ") has null name, could not build spawn information.");
			}
		}
		return ret;
	}*/
	
	public static int generateList() {
		int loop = 0;
		for (Object obj : Biome.REGISTRY.getKeys()) {
			String biome = (String) obj.toString().toLowerCase();
			if ((biome != null) && (!biome.equalsIgnoreCase("mochickens:chicken_forest")) && (!biome.equalsIgnoreCase("mochickens:chicken_plains"))) {
					loop++;
			} else {
				MoChickens.logger.error("[Mo' Chickens] Biome (id " + biome + ") has null name, could not build spawn information.");
			}
		}
		return loop;
	}

}
