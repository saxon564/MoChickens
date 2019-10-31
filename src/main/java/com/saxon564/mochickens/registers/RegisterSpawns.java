package com.saxon564.mochickens.registers;

import com.saxon564.mochickens.MoChickens;
import com.saxon564.mochickens.configs.ChickenConfigGenerator;
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
import com.saxon564.mochickens.configs.chickens.RedstoneChickenConfig;
import com.saxon564.mochickens.configs.chickens.SkeletonChickenConfig;
import com.saxon564.mochickens.configs.chickens.SnowChickenConfig;
import com.saxon564.mochickens.entities.mobs.EntityBeefyChicken;
import com.saxon564.mochickens.entities.mobs.EntityBlazingChicken;
import com.saxon564.mochickens.entities.mobs.EntityClayChicken;
import com.saxon564.mochickens.entities.mobs.EntityCoalChicken;
import com.saxon564.mochickens.entities.mobs.EntityCookieChicken;
import com.saxon564.mochickens.entities.mobs.EntityCreeperChicken;
import com.saxon564.mochickens.entities.mobs.EntityDiamondChicken;
import com.saxon564.mochickens.entities.mobs.EntityEmeraldChicken;
import com.saxon564.mochickens.entities.mobs.EntityEnchantedChicken;
import com.saxon564.mochickens.entities.mobs.EntityEnderChicken;
import com.saxon564.mochickens.entities.mobs.EntityGiantChicken;
import com.saxon564.mochickens.entities.mobs.EntityGlowingChicken;
import com.saxon564.mochickens.entities.mobs.EntityGoldChicken;
import com.saxon564.mochickens.entities.mobs.EntityIronChicken;
import com.saxon564.mochickens.entities.mobs.EntityLapisChicken;
import com.saxon564.mochickens.entities.mobs.EntityNuuwChicken;
import com.saxon564.mochickens.entities.mobs.EntityQuartzChicken;
import com.saxon564.mochickens.entities.mobs.EntityRainbowChicken;
import com.saxon564.mochickens.entities.mobs.EntityRedstoneChicken;
import com.saxon564.mochickens.entities.mobs.EntitySkeletonChicken;
import com.saxon564.mochickens.entities.mobs.EntitySnowChicken;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.registries.ForgeRegistries;

public class RegisterSpawns {
	public static int ran;

	// Add Spawns
	public static void entitySpawns() {
		generateSpawning(EntityDiamondChicken.class, EntityClassification.MONSTER, DiamondChickenConfig.class);
		generateSpawning(EntityCoalChicken.class, EntityClassification.MONSTER, CoalChickenConfig.class);
		generateSpawning(EntityIronChicken.class, EntityClassification.MONSTER, IronChickenConfig.class);
		generateSpawning(EntityGoldChicken.class, EntityClassification.MONSTER, GoldChickenConfig.class);
		generateSpawning(EntityLapisChicken.class, EntityClassification.MONSTER, LapisChickenConfig.class);
		generateSpawning(EntityRedstoneChicken.class, EntityClassification.MONSTER, RedstoneChickenConfig.class);
		generateSpawning(EntityEmeraldChicken.class, EntityClassification.MONSTER, EmeraldChickenConfig.class);
		generateSpawning(EntityGiantChicken.class, EntityClassification.MONSTER, GiantChickenConfig.class);
		generateSpawning(EntityQuartzChicken.class, EntityClassification.MONSTER, QuartzChickenConfig.class);
		generateSpawning(EntityCookieChicken.class, EntityClassification.MONSTER, CookieChickenConfig.class);
		generateSpawning(EntitySnowChicken.class, EntityClassification.MONSTER, SnowChickenConfig.class);
		generateSpawning(EntityClayChicken.class, EntityClassification.MONSTER, ClayChickenConfig.class);
		generateSpawning(EntityRainbowChicken.class, EntityClassification.MONSTER, RedstoneChickenConfig.class);
		generateSpawning(EntitySkeletonChicken.class, EntityClassification.MONSTER, SkeletonChickenConfig.class);
		generateSpawning(EntityEnderChicken.class, EntityClassification.MONSTER, EnderChickenConfig.class);
		generateSpawning(EntityCreeperChicken.class, EntityClassification.MONSTER, CreeperChickenConfig.class);
		generateSpawning(EntityBeefyChicken.class, EntityClassification.MONSTER, BeefyChickenConfig.class);
		generateSpawning(EntityGlowingChicken.class, EntityClassification.MONSTER, GlowingChickenConfig.class);
		generateSpawning(EntityBlazingChicken.class, EntityClassification.MONSTER, BlazingChickenConfig.class);
		generateSpawning(EntityEnchantedChicken.class, EntityClassification.MONSTER, EnchantedChickenConfig.class);
		generateSpawning(EntityNuuwChicken.class, EntityClassification.MONSTER, NuuwChickenConfig.class);
	}

	public static void generateSpawning(Class<?> entity, EntityClassification type,
			Class<?> c) {
		
		ChickenConfigGenerator config = null;
		EntityType<?> eType = null;
		
		try {
			config = (ChickenConfigGenerator) c.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		try {
			eType = (EntityType<?>) entity.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		
		if (config.CAN_SPAWN.get()) {
			Boolean allowed;
			String listType = config.BIOME_WHITELIST_OR_BLACKLIST.get();
			String[] biomeList = config.BIOME_LIST.get().split(",");
			for (Biome biomes : ForgeRegistries.BIOMES) {
				
				allowed = true;
				String biomeResource = (String) biomes.toString().toLowerCase();
	//			ConfigCategory customCategory = config.getCategory(biomeResource);
				
				if (biomeResource != null) {
					Biome biome = ForgeRegistries.BIOMES.getValue(new ResourceLocation(biomeResource));
					float temp = biome.getDefaultTemperature();
	//				if (!customCategory.isEmpty()) {
	//					EntitySpawnPlacementRegistry.addSpawn(entity, customCategory.get("Spawn Probability").getInt(), customCategory.get("Min Spawn Group Size").getInt(), customCategory.get("Max Spawn Group Size").getInt(), type, ForgeRegistries.BIOMES.getValue(new ResourceLocation(biomeResource)));
	//				} else 
					if ((temp <= config.MAXIMUM_SPAWN_TEMP.get()) && (temp >= config.MINIMUM_SPAWN_TEMP.get())) {
						for (int k = 0; k < biomeList.length; k++) {
							if (listType.equalsIgnoreCase("whitelist")) {
								if (!biomeList[k].equals(biomeResource)) {
									//if (entity.getName().equals("com.saxon564.mochickens.entities.mobs.EntityEnderChicken") || entity.getName().equals("com.saxon564.mochickens.entities.mobs.EntitySkeletonChicken") || entity.getName().equals("com.saxon564.mochickens.entities.mobs.EntityCreeperChicken")) {
										//System.out.println(entity.getName() + " whitelist biome " + biomeList[k] + " compared to " + biomeResource);
									//}
									allowed = false;
									break;
								}
							} else {
								if (biomeList[k].equals(biomeResource)) {
									//if (entity.getName().equals("com.saxon564.mochickens.entities.mobs.EntityEnderChicken") || entity.getName().equals("com.saxon564.mochickens.entities.mobs.EntitySkeletonChicken") || entity.getName().equals("com.saxon564.mochickens.entities.mobs.EntityCreeperChicken")) {
										//System.out.println(entity.getName() + " blacklist biome " + biomeList[k] + " compared to " + biomeResource);
									//}
									allowed = false;
									break;
								}
							}
						}
						if ( allowed == true ) {
							biome.getSpawns(type).add(new Biome.SpawnListEntry(eType, config.SPAWN_PROBIBILITY.get(), config.MINIMUM_SPAWN_GROUP_SIZE.get(), config.MAXIMUM_SPAWN_GROUP_SIZE.get()));
						}
					}
				} else {
					MoChickens.CHICKEN_LOGGER.error("[Mo' Chickens] Biome (id "
									+ biomeResource
									+ ") has null name, could not build spawn information.");
				}
			}
		}
		ran = 1;
	}
}
