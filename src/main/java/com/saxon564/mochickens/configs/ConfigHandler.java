package com.saxon564.mochickens.configs;

import java.io.File;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.ParsingMode;
import com.electronwill.nightconfig.core.io.WritingMode;
import com.saxon564.mochickens.configs.chickens.BeefyChickenConfig;
import com.saxon564.mochickens.configs.chickens.CoalChickenConfig;
import com.saxon564.mochickens.configs.chickens.CookieChickenConfig;
import com.saxon564.mochickens.configs.chickens.DiamondChickenConfig;
import com.saxon564.mochickens.configs.chickens.EmeraldChickenConfig;
import com.saxon564.mochickens.configs.chickens.EnderChickenConfig;
import com.saxon564.mochickens.configs.chickens.GoldChickenConfig;
import com.saxon564.mochickens.configs.chickens.IronChickenConfig;
import com.saxon564.mochickens.configs.chickens.LapisChickenConfig;
import com.saxon564.mochickens.configs.chickens.RedstoneChickenConfig;
import com.saxon564.mochickens.configs.chickens.SkeletonChickenConfig;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod.EventBusSubscriber
public class ConfigHandler {
	
	public static String PATH;
	
	public static File MOCHICKENS_CONFIG_DIRECTORY;
	public static File MOCHICKENS_CHICKEN_CONFIG_DIRECTORY;

	public static BooleanValue DEBUG;
	public static BooleanValue ITEMS;
	public static BooleanValue BIOMES;
	public static BooleanValue SOUNDS;
	public static BooleanValue PARTICLES;
	public static BooleanValue EFFECTS;

	private static final ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
	private static final ForgeConfigSpec.Builder BEEFY_CHICKEN_BUILDER = new ForgeConfigSpec.Builder();
	private static final ForgeConfigSpec.Builder BLAZING_CHICKEN_BUILDER = new ForgeConfigSpec.Builder();
	private static final ForgeConfigSpec.Builder CLAY_CHICKEN_BUILDER = new ForgeConfigSpec.Builder();
	private static final ForgeConfigSpec.Builder COAL_CHICKEN_BUILDER = new ForgeConfigSpec.Builder();
	private static final ForgeConfigSpec.Builder COOKIE_CHICKEN_BUILDER = new ForgeConfigSpec.Builder();
	private static final ForgeConfigSpec.Builder CREEPER_CHICKEN_BUILDER = new ForgeConfigSpec.Builder();
	private static final ForgeConfigSpec.Builder DIAMOND_CHICKEN_BUILDER = new ForgeConfigSpec.Builder();
	private static final ForgeConfigSpec.Builder EMERALD_CHICKEN_BUILDER = new ForgeConfigSpec.Builder();
	private static final ForgeConfigSpec.Builder ENCHANTED_CHICKEN_BUILDER = new ForgeConfigSpec.Builder();
	private static final ForgeConfigSpec.Builder ENDER_CHICKEN_BUILDER = new ForgeConfigSpec.Builder();
	private static final ForgeConfigSpec.Builder GIANT_CHICKEN_BUILDER = new ForgeConfigSpec.Builder();
	private static final ForgeConfigSpec.Builder GLOWING_CHICKEN_BUILDER = new ForgeConfigSpec.Builder();
	private static final ForgeConfigSpec.Builder GOLD_CHICKEN_BUILDER = new ForgeConfigSpec.Builder();
	private static final ForgeConfigSpec.Builder IRON_CHICKEN_BUILDER = new ForgeConfigSpec.Builder();
	private static final ForgeConfigSpec.Builder LAPIS_CHICKEN_BUILDER = new ForgeConfigSpec.Builder();
	private static final ForgeConfigSpec.Builder NUUW_CHICKEN_BUILDER = new ForgeConfigSpec.Builder();
	private static final ForgeConfigSpec.Builder QUARTZ_CHICKEN_BUILDER = new ForgeConfigSpec.Builder();
	private static final ForgeConfigSpec.Builder RAINBOW_CHICKEN_BUILDER = new ForgeConfigSpec.Builder();
	private static final ForgeConfigSpec.Builder REDSTONE_CHICKEN_BUILDER = new ForgeConfigSpec.Builder();
	private static final ForgeConfigSpec.Builder SKELETON_CHICKEN_BUILDER = new ForgeConfigSpec.Builder();
	private static final ForgeConfigSpec.Builder SNOW_CHICKEN_BUILDER = new ForgeConfigSpec.Builder();

	public static ForgeConfigSpec MOCHICKENS_GENERAL_CONFIG;
	public static ForgeConfigSpec BEEFY_CHICKEN_CONFIG;
	public static ForgeConfigSpec BLAZING_CHICKEN_CONFIG;
	public static ForgeConfigSpec CLAY_CHICKEN_CONFIG;
	public static ForgeConfigSpec COAL_CHICKEN_CONFIG;
	public static ForgeConfigSpec COOKIE_CHICKEN_CONFIG;
	public static ForgeConfigSpec CREEPER_CHICKEN_CONFIG;
	public static ForgeConfigSpec DIAMOND_CHICKEN_CONFIG;
	public static ForgeConfigSpec EMERALD_CHICKEN_CONFIG;
	public static ForgeConfigSpec ENCHANTED_CHICKEN_CONFIG;
	public static ForgeConfigSpec ENDER_CHICKEN_CONFIG;
	public static ForgeConfigSpec GIANT_CHICKEN_CONFIG;
	public static ForgeConfigSpec GLOWING_CHICKEN_CONFIG;
	public static ForgeConfigSpec GOLD_CHICKEN_CONFIG;
	public static ForgeConfigSpec IRON_CHICKEN_CONFIG;
	public static ForgeConfigSpec LAPIS_CHICKEN_CONFIG;
	public static ForgeConfigSpec NUUW_CHICKEN_CONFIG;
	public static ForgeConfigSpec QUARTZ_CHICKEN_CONFIG;
	public static ForgeConfigSpec RAINBOW_CHICKEN_CONFIG;
	public static ForgeConfigSpec REDSTONE_CHICKEN_CONFIG;
	public static ForgeConfigSpec SKELETON_CHICKEN_CONFIG;
	public static ForgeConfigSpec SNOW_CHICKEN_CONFIG;
	
	static {
		setup();
		
		COMMON_BUILDER.comment("Debug Mode\nCaution: Turning this true will cause console spam, and lag the game.").push("Debug Mode");
		DEBUG = COMMON_BUILDER.translation("debugMode").define("Debug Mode", false);
		COMMON_BUILDER.pop();
		
		COMMON_BUILDER.comment("List Files\nShould a file be created with a list of all the items/biomes/sounds/particles in the game?").push("List Files");
		ITEMS = COMMON_BUILDER.define("Item List", false);
		SOUNDS = COMMON_BUILDER.define("Sound List", false);
		BIOMES = COMMON_BUILDER.define("Biome List", false);
		PARTICLES = COMMON_BUILDER.define("Particle List", false);
		EFFECTS = COMMON_BUILDER.define("Effects List", false);
		COMMON_BUILDER.pop();
		
		MOCHICKENS_GENERAL_CONFIG = COMMON_BUILDER.build();
		try {
			DIAMOND_CHICKEN_CONFIG = DiamondChickenConfig.class.newInstance().buildConfig(DIAMOND_CHICKEN_BUILDER, "Diamond Chicken", MOCHICKENS_CHICKEN_CONFIG_DIRECTORY, "DiamondChicken.toml", true, 5, 1, 2, 7, 16, 0.0, 1.0, "Blacklist", Arrays.asList("minecraft:ocean","minecraft:deep_ocean","minecraft:frozen_ocean","minecraft:deep_frozen_ocean","minecraft:cold_ocean","minecraft:deep_cold_ocean","minecraft:lukewarm_ocean","minecraft:deep_lukewarm_ocean","minecraft:warm_ocean","minecraft:deep_warm_ocean","minecraft:nether","minecraft:the_end","minecraft:small_end_islands","minecraft:end_midlands","minecraft:end_highlands","minecraft:end_barrens","minecraft:river","minecraft:frozen_river"), buildMaps(Arrays.asList("minecraft_hell"), Arrays.asList(0), Arrays.asList(0), Arrays.asList(0)), 20.0, 0.25, 0.3, 0.7, true, false, true, false, false, 0, false, false, false, 0.0D, false, Arrays.asList(""), Arrays.asList(""), "minecraft:entity.chicken.ambient", "minecraft:entity.chicken.hurt", "minecraft:entity.chicken.death", "minecraft:entity.chicken.step", false, true, Arrays.asList("minecraft:diamond"), 20, true, false, Arrays.asList("minecraft:diamond_block"), 500, true, 0.25, false, true, false, Arrays.asList("minecraft:diamond"), 12000, true, false, true, false, Arrays.asList("minecraft:diamond"), 1, 5000, 15000, "mochickens:laydiamond", true, 5.0F, false, 0, 0.25, Arrays.asList("minecraft:blindness","minecraft:slowness"), Arrays.asList("10","20"), Arrays.asList("1","5"), 16.0, false, 0, 0, false, 0.0D, false, 0, false, false, false, false, false, 0, 0, false, 0, 0, true, false, false, true, false, 1000000, 100000, true, false, true, true, false, 1000000, 100000, 0.0, 1.0, 100000, 0.1).build();
			COAL_CHICKEN_CONFIG = CoalChickenConfig.class.newInstance().buildConfig(COAL_CHICKEN_BUILDER, "Coal Chicken", MOCHICKENS_CHICKEN_CONFIG_DIRECTORY, "CoalChicken.toml", true, 10, 3, 5, 7, 16, 0.0, 1.0, "Blacklist", Arrays.asList("minecraft:ocean","minecraft:deep_ocean","minecraft:frozen_ocean","minecraft:deep_frozen_ocean","minecraft:cold_ocean","minecraft:deep_cold_ocean","minecraft:lukewarm_ocean","minecraft:deep_lukewarm_ocean","minecraft:warm_ocean","minecraft:deep_warm_ocean","minecraft:river","minecraft:frozen_river","minecraft:nether","minecraft:the_end","minecraft:small_end_islands","minecraft:end_midlands","minecraft:end_highlands","minecraft:end_barrens","minecraft:the_void"), buildMaps(Arrays.asList("minecraft_hell"), Arrays.asList(0), Arrays.asList(0), Arrays.asList(0)), 5.0, 0.25, 0.3, 0.7, true, false, true, false, false, 0, false, false, false, 0.0D, false, Arrays.asList(""), Arrays.asList(""), "minecraft:entity.chicken.ambient", "minecraft:entity.chicken.hurt", "minecraft:entity.chicken.death", "minecraft:entity.chicken.step", false, true, Arrays.asList("minecraft:coal","minecraft:charcoal"), 10, true, false, Arrays.asList("minecraft:coal_block"), 500, true, 0.25, false, true, false, Arrays.asList("minecraft:charcoal","minecraft:coal"), 5000, true, false, true, false, Arrays.asList("minecraft:coal"), 1, 5000, 10000, "minecraft:entity.chicken.egg", true, 1.0F, false, 0, 0.25, Arrays.asList("minecraft:slowness"), Arrays.asList("10"), Arrays.asList("1"), 16.0, false, 0, 0, false, 0.0D, false, 0, false, false, false, false, false, 0, 0, false, 0, 0, true, false, false, true, false, 1000000, 100000, true, false, true, true, false, 1000000, 100000, 0.0, 0.5, 100000, 0.05).build();
			IRON_CHICKEN_CONFIG = IronChickenConfig.class.newInstance().buildConfig(IRON_CHICKEN_BUILDER, "Iron Chicken", MOCHICKENS_CHICKEN_CONFIG_DIRECTORY, "IronChicken.toml", true, 7, 2, 3, 7, 16, 0.0, 1.0, "Blacklist", Arrays.asList("minecraft:ocean","minecraft:deep_ocean","minecraft:frozen_ocean","minecraft:deep_frozen_ocean","minecraft:cold_ocean","minecraft:deep_cold_ocean","minecraft:lukewarm_ocean","minecraft:deep_lukewarm_ocean","minecraft:warm_ocean","minecraft:deep_warm_ocean","minecraft:river","minecraft:frozen_river","minecraft:nether","minecraft:the_end","minecraft:small_end_islands","minecraft:end_midlands","minecraft:end_highlands","minecraft:end_barrens","minecraft:the_void"), buildMaps(Arrays.asList("minecraft_hell"), Arrays.asList(0), Arrays.asList(0), Arrays.asList(0)), 10.0, 0.25, 0.3, 0.7, true, false, true, false, false, 0, false, false, false, 0.0D, false, Arrays.asList(""), Arrays.asList(""), "minecraft:entity.chicken.ambient", "minecraft:entity.chicken.hurt", "minecraft:entity.chicken.death", "minecraft:entity.chicken.step", false, true, Arrays.asList("minecraft:iron_ingot"), 10, true, false, Arrays.asList("minecraft:iron_block"), 500, true, 0.25, false, true, false, Arrays.asList("minecraft:iron_ingot"), 7000, true, false, true, false, Arrays.asList("minecraft:iron_ingot"), 1, 10000, 5000, "minecraft:entity.chicken.egg", true, 2.0F, false, 0, 0.25, Arrays.asList("minecraft:poison","minecraft:hunger"), Arrays.asList("15","5"), Arrays.asList("2","1"), 16.0, false, 0, 0, false, 0.0D, false, 0, false, false, false, false, false, 0, 0, false, 0, 0, true, false, false, true, false, 1000000, 100000, true, false, true, true, false, 1000000, 100000, 0.0, 0.8, 100000, 0.05).build();
			GOLD_CHICKEN_CONFIG = GoldChickenConfig.class.newInstance().buildConfig(GOLD_CHICKEN_BUILDER, "Gold Chicken", MOCHICKENS_CHICKEN_CONFIG_DIRECTORY, "GoldChicken.toml", true, 10, 2, 4, 7, 16, 0.0, 1.0, "Blacklist", Arrays.asList("minecraft:ocean","minecraft:deep_ocean","minecraft:frozen_ocean","minecraft:deep_frozen_ocean","minecraft:cold_ocean","minecraft:deep_cold_ocean","minecraft:lukewarm_ocean","minecraft:deep_lukewarm_ocean","minecraft:warm_ocean","minecraft:deep_warm_ocean","minecraft:river","minecraft:frozen_river","minecraft:nether","minecraft:the_end","minecraft:small_end_islands","minecraft:end_midlands","minecraft:end_highlands","minecraft:end_barrens","minecraft:the_void"), buildMaps(Arrays.asList("minecraft_hell"), Arrays.asList(0), Arrays.asList(0), Arrays.asList(0)), 10.0, 0.25, 0.3, 0.7, true, false, true, false, false, 0, false, false, false, 0.0D, false, Arrays.asList(""), Arrays.asList(""), "minecraft:entity.chicken.ambient", "minecraft:entity.chicken.hurt", "minecraft:entity.chicken.death", "minecraft:entity.chicken.step", false, true, Arrays.asList("minecraft:gold_ingot"), 10, true, false, Arrays.asList("minecraft:gold_block"), 500, true, 0.25, false, true, false, Arrays.asList("minecraft:gold_ingot"), 10000, true, false, true, false, Arrays.asList("minecraft:gold_ingot"), 1, 9000, 4800, "minecraft:entity.chicken.egg", true, 2.0F, false, 0, 0.25, Arrays.asList("minecraft:mining_fatigue","minecraft:nausea"), Arrays.asList("10","15"), Arrays.asList("3","2"), 16.0, false, 0, 0, false, 0.0D, false, 0, false, false, false, false, false, 0, 0, false, 0, 0, true, false, false, true, false, 1000000, 100000, true, false, true, true, false, 100000, 10000, 0.0, 0.5, 10000, 0.05).build();
			REDSTONE_CHICKEN_CONFIG = RedstoneChickenConfig.class.newInstance().buildConfig(REDSTONE_CHICKEN_BUILDER, "Redstone Chicken", MOCHICKENS_CHICKEN_CONFIG_DIRECTORY, "RedstoneChicken.toml", true, 7, 2, 3, 7, 16, 0.0, 1.0, "Blacklist", Arrays.asList("minecraft:ocean","minecraft:deep_ocean","minecraft:frozen_ocean","minecraft:deep_frozen_ocean","minecraft:cold_ocean","minecraft:deep_cold_ocean","minecraft:lukewarm_ocean","minecraft:deep_lukewarm_ocean","minecraft:warm_ocean","minecraft:deep_warm_ocean","minecraft:river","minecraft:frozen_river","minecraft:nether","minecraft:the_end","minecraft:small_end_islands","minecraft:end_midlands","minecraft:end_highlands","minecraft:the_void","minecraft:end_barrens"), buildMaps(Arrays.asList("minecraft_hell"), Arrays.asList(0), Arrays.asList(0), Arrays.asList(0)), 10.0, 0.25, 0.3, 0.7, true, false, true, false, false, 0, false, false, false, 0.0D, true, Arrays.asList("minecraft:dust"), Arrays.asList("3"), "minecraft:entity.chicken.ambient", "minecraft:entity.chicken.hurt", "minecraft:entity.chicken.death", "minecraft:entity.chicken.step", false, true, Arrays.asList("minecraft:redstone"), 10, true, false, Arrays.asList("minecraft:redstone_block"), 500, true, 0.25, false, true, false, Arrays.asList("minecraft:redstone"), 16800, true, false, true, false, Arrays.asList("minecraft:redstone"), 1, 12000, 6000, "minecraft:entity.chicken.ambient", true, 4.0F, true, 10, 0.25, Arrays.asList("minecraft:speed"), Arrays.asList("10"), Arrays.asList("5"), 16.0, false, 0, 0, false, 0.0D, false, 0, false, false, false, false, false, 0, 0, false, 0, 0, true, false, false, true, false, 1000000, 100000, true, false, true, true, false, 100000, 10000, 0.0, 0.8, 10000, 0.04).build();
			LAPIS_CHICKEN_CONFIG = LapisChickenConfig.class.newInstance().buildConfig(LAPIS_CHICKEN_BUILDER, "Lapis Chicken", MOCHICKENS_CHICKEN_CONFIG_DIRECTORY, "LapisChicken.toml", true, 8, 2, 3, 7, 16, 0.0, 1.0, "Blacklist", Arrays.asList("minecraft:ocean","minecraft:frozen_ocean","minecraft:deep_ocean","minecraft:deep_frozen_ocean","minecraft:cold_ocean","minecraft:deep_cold_ocean","minecraft:lukewarm_ocean","minecraft:deep_lukewarm_ocean","minecraft:warm_ocean","minecraft:deep_warm_ocean","minecraft:river","minecraft:frozen_river","minecraft:the_void","minecraft:end_barrens","minecraft:end_highlands","minecraft:end_midlands","minecraft:small_end_islands","minecraft:the_end","minecraft:nether"), buildMaps(Arrays.asList("minecraft_hell"), Arrays.asList(0), Arrays.asList(0), Arrays.asList(0)), 7.0, 0.25, 0.3, 0.7, true, false, true, false, false, 0, false, false, false, 0.0D, false, Arrays.asList(""), Arrays.asList(""), "minecraft:entity.chicken.ambient", "minecraft:entity.chicken.hurt", "minecraft:entity.chicken.death", "minecraft:entity.chicken.step", false, true, Arrays.asList("minecraft:lapis_lazuli"), 10, true, false, Arrays.asList("minecraft:lapis_block"), 500, true, 0.25, false, true, false, Arrays.asList("minecraft:lapis_lazuli"), 9600, true, false, true, false, Arrays.asList("minecraft:lapis_lazuli"), 1, 9600, 4800, "minecraft:entity.chicken.egg", true, 2.0F, false, 0, 0.25, Arrays.asList("minecraft:nausea","minecraft:levitation"), Arrays.asList("5","10"), Arrays.asList("2","1"), 16.0, false, 0, 0, false, 0.0D, false, 0, false, false, false, false, false, 0, 0, false, 0, 0, true, false, false, true, false, 1000000, 100000, true, false, true, true, false, 1000000, 100000, 0.0, 0.5, 100000, 0.02).build();
			EMERALD_CHICKEN_CONFIG = EmeraldChickenConfig.class.newInstance().buildConfig(EMERALD_CHICKEN_BUILDER, "Emerald Chicken", MOCHICKENS_CHICKEN_CONFIG_DIRECTORY, "EmeraldChicken.toml", true, 9, 1, 2, 7, 16, 0.0, 1.0, "Blacklist", Arrays.asList("minecraft:ocean","minecraft:deep_ocean","minecraft:frozen_ocean","minecraft:deep_frozen_ocean","minecraft:cold_ocean","minecraft:deep_cold_ocean","minecraft:lukewarm_ocean","minecraft:deep_lukewarm_ocean","minecraft:warm_ocean","minecraft:deep_warm_ocean","minecraft:river","minecraft:frozen_river","minecraft:the_void","minecraft:end_barrens","minecraft:end_highlands","minecraft:end_midlands","minecraft:small_end_islands","minecraft:the_end","minecraft:nether"), buildMaps(Arrays.asList("minecraft_hell"), Arrays.asList(0), Arrays.asList(0), Arrays.asList(0)), 14.0, 0.25, 0.3, 0.7, true, false, true, false, false, 0, false, false, false, 0.0D, false, Arrays.asList(""), Arrays.asList(""), "minecraft:entity.chicken.ambient", "minecraft:entity.chicken.hurt", "minecraft:entity.chicken.death", "minecraft:entity.chicken.step", false, true, Arrays.asList("minecraft:emerald"), 15, true, false, Arrays.asList("minecraft:emerald_block"), 500, true, 0.25, false, true, false, Arrays.asList("minecraft:emerald"), 18000, true, false, true, false, Arrays.asList("minecraft:emerald"), 1, 18000, 9000, "minecraft:entity.chicken.egg", true, 3.0F, false, 0, 0.25, Arrays.asList("minecraft:nausea","minecraft:blindness"), Arrays.asList("10","10"), Arrays.asList("3","2"), 16.0, false, 0, 0, false, 0.0D, false, 0, false, false, false, false, false, 0, 0, false, 0, 0, true, false, false, true, false, 1000000, 100000, true, false, true, true, false, 100000, 10000, 0.0, 0.7, 10000, 0.05).build();
			ENDER_CHICKEN_CONFIG = EnderChickenConfig.class.newInstance().buildConfig(ENDER_CHICKEN_BUILDER, "Ender Chicken", MOCHICKENS_CHICKEN_CONFIG_DIRECTORY, "EnderChicken.toml", true, 10, 2, 3, 0, 16, 0.0, 1.0, "Blacklist", Arrays.asList("minecraft:ocean","minecraft:deep_ocean","minecraft:frozen_ocean","minecraft:deep_frozen_ocean","minecraft:cold_ocean","minecraft:deep_cold_ocean","minecraft:lukewarm_ocean","minecraft:deep_lukewarm_ocean","minecraft:warm_ocean","minecraft:deep_warm_ocean","minecraft:river","minecraft:frozen_river","minecraft:nether","minecraft:the_void"), buildMaps(Arrays.asList("minecraft_hell"), Arrays.asList(0), Arrays.asList(0), Arrays.asList(0)), 15.0, 0.25, 0.3, 0.7, true, false, true, true, false, 0, false, false, true, 2.0, true, Arrays.asList("minecraft:portal"), Arrays.asList("10"), "minecraft:entity.chicken.ambient", "minecraft:entity.chicken.hurt", "minecraft:entity.chicken.death", "minecraft:entity.chicken.step", false, true, Arrays.asList("minecraft:ender_pearl"), 15, true, false, Arrays.asList("minecraft:ender_eye"), 500, true, 0.25, false, true, false, Arrays.asList("minecraft:ender_pearl"), 15600, true, false, true, false, Arrays.asList("minecraft:ender_pearl"), 1, 15600, 7800, "minecraft:entity.chicken.egg", true, 5.0F, false, 0, 0.4, Arrays.asList("minecraft:weakness","minecraft:blindness"), Arrays.asList("10","10"), Arrays.asList("2","1"), 16.0, false, 0, 0, false, 0.0D, false, 0, false, false, false, false, false, 0, 0, false, 0, 0, true, false, false, true, false, 1000000, 100000, true, false, true, true, false, 100000, 10000, 0.1, 0.8, 10000, 0.05).build();
			COOKIE_CHICKEN_CONFIG = CookieChickenConfig.class.newInstance().buildConfig(COOKIE_CHICKEN_BUILDER, "Cookie Chicken", MOCHICKENS_CHICKEN_CONFIG_DIRECTORY, "CookieChicken.toml", true, 15, 3, 5, 7, 16, 0.0, 1.0, "Blacklist", Arrays.asList("minecraft:ocean","minecraft:deep_ocean","minecraft:frozen_ocean","minecraft:deep_frozen_ocean","minecraft:cold_ocean","minecraft:deep_cold_ocean","minecraft:lukewarm_ocean","minecraft:warm_ocean","minecraft:deep_lukewarm_ocean","minecraft:deep_warm_ocean","minecraft:river","minecraft:frozen_river","minecraft:nether","minecraft:the_end","minecraft:small_end_islands","minecraft:end_midlands","minecraft:end_highlands","minecraft:end_barrens","minecraft:the_void"), buildMaps(Arrays.asList("minecraft_hell"), Arrays.asList(0), Arrays.asList(0), Arrays.asList(0)), 5.0, 0.25, 0.3, 0.7, true, false, true, false, false, 0, false, false, false, 0.0D, false, Arrays.asList(""), Arrays.asList(""), "minecraft:entity.chicken.ambient", "minecraft:entity.chicken.hurt", "minecraft:entity.chicken.death", "minecraft:entity.chicken.step", false, true, Arrays.asList("minecraft:cookie"), 5, true, false, Arrays.asList("minecraft:cocoa_beans"), 500, true, 0.25, false, true, false, Arrays.asList("minecraft:cookie"), 9600, true, false, true, false, Arrays.asList("minecraft:cookie"), 1, 12000, 6000, "minecraft:entity.chicken.egg", true, 2.0F, false, 0, 0.25, Arrays.asList("minecraft:haste","minecraft:nausea","minecraft:speed"), Arrays.asList("15","10","15"), Arrays.asList("3","5","3"), 16.0, false, 0, 0, false, 0.0D, false, 0, false, false, false, false, false, 0, 0, false, 0, 0, true, false, false, true, false, 1000000, 100000, true, false, true, true, false, 100000, 10000, 0.0, 0.5, 100000, 0.02).build();
			SKELETON_CHICKEN_CONFIG = SkeletonChickenConfig.class.newInstance().buildConfig(SKELETON_CHICKEN_BUILDER, "Skeleton Chicken", MOCHICKENS_CHICKEN_CONFIG_DIRECTORY, "SkeletonChicken.toml", true, 10, 2, 3, 0, 7, 0.0, 1.0, "Blacklist", Arrays.asList("minecraft:nether","minecraft:the_end","minecraft:small_end_islands","minecraft:end_midlands","minecraft:end_highlands","minecraft:end_barrens","minecraft:the_void","minecraft:ocean","minecraft:deep_ocean","minecraft:frozen_ocean","minecraft:deep_frozen_ocean","minecraft:cold_ocean","minecraft:deep_cold_ocean","minecraft:lukewarm_ocean","minecraft:deep_lukewarm_ocean","minecraft:warm_ocean","minecraft:deep_warm_ocean","minecraft:river","minecraft:frozen_river"), buildMaps(Arrays.asList("minecraft_hell"), Arrays.asList(0), Arrays.asList(0), Arrays.asList(0)), 10.0, 0.25, 0.3, 0.7, true, false, true, false, false, 0, false, true, false, 0.0D, false, Arrays.asList(""), Arrays.asList(""), "minecraft:entity.chicken.ambient", "minecraft:entity.chicken.hurt", "minecraft:entity.chicken.death", "minecraft:entity.chicken.step", false, true, Arrays.asList("minecraft:bone"), 15, true, false, Arrays.asList("minecraft:bone_block"), 500, true, 0.25, false, true, false, Arrays.asList("minecraft:bone"), 14400, true, false, true, false, Arrays.asList("minecraft:bone"), 1, 12000, 6000, "minecraft:entity.chicken.egg", true, 0.0F, false, 0, 0.25, Arrays.asList("minecraft:hunger","minecraft:slowness"), Arrays.asList("10","10"), Arrays.asList("2","2"), 16.0, false, 0, 0, false, 0.0D, true, 10, false, false, false, false, false, 0, 0, false, 0, 0, true, false, false, true, false, 1000000, 100000, true, false, true, true, false, 100000, 10000, 0.0, 0.8, 100000, 0.05).build();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	public static void setup() {
		PATH = FMLPaths.CONFIGDIR.get().toString();
		
		MOCHICKENS_CONFIG_DIRECTORY = new File(PATH, "MoChickens");
		MOCHICKENS_CHICKEN_CONFIG_DIRECTORY = new File(MOCHICKENS_CONFIG_DIRECTORY.toString(), "DefaultChickens");
		
		if (!MOCHICKENS_CONFIG_DIRECTORY.exists()) {
			MOCHICKENS_CONFIG_DIRECTORY.mkdir();
		}
		
		if (!MOCHICKENS_CHICKEN_CONFIG_DIRECTORY.exists()) {
			MOCHICKENS_CHICKEN_CONFIG_DIRECTORY.mkdir();
		}
	}
	
	public static void loadConfig() {
		loadConfig(MOCHICKENS_GENERAL_CONFIG, MOCHICKENS_CONFIG_DIRECTORY, "MoChickens.toml");
        loadConfig(DIAMOND_CHICKEN_CONFIG, MOCHICKENS_CHICKEN_CONFIG_DIRECTORY, "DiamondChicken.toml");
        loadConfig(COAL_CHICKEN_CONFIG, MOCHICKENS_CHICKEN_CONFIG_DIRECTORY, "CoalChicken.toml");
        loadConfig(IRON_CHICKEN_CONFIG, MOCHICKENS_CHICKEN_CONFIG_DIRECTORY, "IronChicken.toml");
        loadConfig(GOLD_CHICKEN_CONFIG, MOCHICKENS_CHICKEN_CONFIG_DIRECTORY, "GoldChicken.toml");
        loadConfig(REDSTONE_CHICKEN_CONFIG, MOCHICKENS_CHICKEN_CONFIG_DIRECTORY, "RedstoneChicken.toml");
        loadConfig(LAPIS_CHICKEN_CONFIG, MOCHICKENS_CHICKEN_CONFIG_DIRECTORY, "LapisChicken.toml");
        loadConfig(EMERALD_CHICKEN_CONFIG, MOCHICKENS_CHICKEN_CONFIG_DIRECTORY, "EmeraldChicken.toml");
        loadConfig(ENDER_CHICKEN_CONFIG, MOCHICKENS_CHICKEN_CONFIG_DIRECTORY, "EnderChicken.toml");
        loadConfig(COOKIE_CHICKEN_CONFIG, MOCHICKENS_CHICKEN_CONFIG_DIRECTORY, "CookieChicken.toml");
        loadConfig(SKELETON_CHICKEN_CONFIG, MOCHICKENS_CHICKEN_CONFIG_DIRECTORY, "SkeletonChicken.toml");
	}
	public static void loadConfig(ForgeConfigSpec spec, File dir, String toml) {
		Path path = dir.toPath().resolve(toml);
		CommentedFileConfig configData = CommentedFileConfig.builder(path)
				.sync().autosave().preserveInsertionOrder().build();
		loadConfig(spec, configData);
	}
	
	public static void loadConfig(ForgeConfigSpec spec, CommentedFileConfig configData) {
		configData.load();
		spec.setConfig(configData);
	}
	
	private static Map<String, Map<String, Integer>> buildMaps(List<String> biomes, List<Integer> prob, List<Integer> minGroup, List<Integer> maxGroup) {
		Map<String, Map<String, Integer>> full = new HashMap<String, Map<String, Integer>>();
		
		if (biomes != null) {
			for (int i = 0; i < biomes.size(); i++) {
				Map<String, Integer> vars = new HashMap<String, Integer>();
				vars.put("probability", prob.get(i));
				vars.put("min_group", minGroup.get(i));
				vars.put("max_group", maxGroup.get(i));
				full.put(biomes.get(i), vars);
			}
		}
		
		return full;
	}
}
