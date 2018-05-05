package com.saxon564.mochickens.registers;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import com.saxon564.mochickens.MoChickens;
import com.saxon564.mochickens.configs.FileManager;
import com.saxon564.mochickens.configs.GeneralConfig;
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

public class RegisterSpawns {
	public static int ran;

	// Add Spawns
	public static void entitySpawns() {
		if (FileManager.diamondConfig.getCategory("spawning").get("Can Spawn").getBoolean() == true) {
			generateSpawning(EntityDiamondChicken.class,
					EnumCreatureType.MONSTER, FileManager.diamondConfig);
		}

		if (FileManager.coalConfig.getCategory("spawning").get("Can Spawn").getBoolean() == true) {
			generateSpawning(EntityCoalChicken.class,
					EnumCreatureType.MONSTER, FileManager.coalConfig);
		}

		if (FileManager.ironConfig.getCategory("spawning").get("Can Spawn").getBoolean() == true) {
			generateSpawning(EntityIronChicken.class,
					EnumCreatureType.MONSTER, FileManager.ironConfig);
		}

		if (FileManager.goldConfig.getCategory("spawning").get("Can Spawn").getBoolean() == true) {
			generateSpawning(EntityGoldChicken.class,
					EnumCreatureType.MONSTER, FileManager.goldConfig);
		}

		if (FileManager.lapisConfig.getCategory("spawning").get("Can Spawn").getBoolean() == true) {
			generateSpawning(EntityLapisChicken.class,
					EnumCreatureType.MONSTER, FileManager.lapisConfig);
		}

		if (FileManager.redstoneConfig.getCategory("spawning").get("Can Spawn").getBoolean() == true) {
			generateSpawning(EntityRedstoneChicken.class,
					EnumCreatureType.MONSTER, FileManager.redstoneConfig);
		}

		if (FileManager.emeraldConfig.getCategory("spawning").get("Can Spawn").getBoolean() == true) {
			generateSpawning(EntityEmeraldChicken.class,
					EnumCreatureType.MONSTER, FileManager.emeraldConfig);
		}

		if (FileManager.giantConfig.getCategory("spawning").get("Can Spawn").getBoolean() == true) {
			generateSpawning(EntityGiantChicken.class,
					EnumCreatureType.MONSTER, FileManager.giantConfig);
		}

		if (FileManager.quartzConfig.getCategory("spawning").get("Can Spawn").getBoolean() == true) {
			generateSpawning(EntityQuartzChicken.class,
					EnumCreatureType.MONSTER, FileManager.quartzConfig);
		}

		if (FileManager.cookieConfig.getCategory("spawning").get("Can Spawn").getBoolean() == true) {
			generateSpawning(EntityCookieChicken.class,
					EnumCreatureType.MONSTER, FileManager.cookieConfig);
		}

		if (FileManager.snowConfig.getCategory("spawning").get("Can Spawn").getBoolean() == true) {
			generateSpawning(EntitySnowChicken.class,
					EnumCreatureType.MONSTER, FileManager.snowConfig);
		}

		if (FileManager.clayConfig.getCategory("spawning").get("Can Spawn").getBoolean() == true) {
			generateSpawning(EntityClayChicken.class,
					EnumCreatureType.MONSTER, FileManager.clayConfig);
		}

		if (FileManager.rainbowConfig.getCategory("spawning").get("Can Spawn").getBoolean() == true) {
			generateSpawning(EntityRainbowChicken.class,
					EnumCreatureType.MONSTER, FileManager.redstoneConfig);
		}

		if (FileManager.skeletonConfig.getCategory("spawning").get("Can Spawn").getBoolean() == true) {
			generateSpawning(EntitySkeletonChicken.class,
					EnumCreatureType.MONSTER, FileManager.skeletonConfig);
		}

		if (FileManager.enderConfig.getCategory("spawning").get("Can Spawn").getBoolean() == true) {
			generateSpawning(EntityEnderChicken.class,
					EnumCreatureType.MONSTER, FileManager.enderConfig);
		}

		if (FileManager.creeperConfig.getCategory("spawning").get("Can Spawn").getBoolean() == true) {
			generateSpawning(EntityCreeperChicken.class,
					EnumCreatureType.MONSTER, FileManager.creeperConfig);
		}

		if (FileManager.beefyConfig.getCategory("spawning").get("Can Spawn").getBoolean() == true) {
			generateSpawning(EntityBeefyChicken.class,
					EnumCreatureType.MONSTER, FileManager.beefyConfig);
		}

		if (FileManager.glowingConfig.getCategory("spawning").get("Can Spawn").getBoolean() == true) {
			generateSpawning(EntityGlowingChicken.class,
					EnumCreatureType.MONSTER, FileManager.glowingConfig);
		}

		if (FileManager.blazingConfig.getCategory("spawning").get("Can Spawn").getBoolean() == true) {
			generateSpawning(EntityBlazingChicken.class,
					EnumCreatureType.MONSTER, FileManager.blazingConfig);
		}

		if (FileManager.enchantedConfig.getCategory("spawning").get("Can Spawn").getBoolean() == true) {
			generateSpawning(EntityEnchantedChicken.class,
					EnumCreatureType.MONSTER, FileManager.enchantedConfig);
		}

		if (FileManager.nuuwConfig.getCategory("spawning").get("Can Spawn").getBoolean() == true) {
			generateSpawning(EntityNuuwChicken.class,
					EnumCreatureType.MONSTER, FileManager.nuuwConfig);
		}
	}

	public static void generateSpawning(Class entity, EnumCreatureType type,
			Configuration config) {
		
		Boolean allowed;
		String listType = config.getCategory("spawning").get("Biome List Type").getString();
		String[] biomeList = config.getCategory("spawning").get("Biome List").getStringList();
		for (Object obj : Biome.REGISTRY.getKeys()) {
			
			allowed = true;
			String biomeResource = (String) obj.toString().toLowerCase();
			ConfigCategory customCategory = config.getCategory(biomeResource);
			ConfigCategory category = config.getCategory("spawning");
			
			if (biomeResource != null) {
				Biome biome = Biome.REGISTRY.getObject(new ResourceLocation(biomeResource));
				float temp = biome.getDefaultTemperature();
				if (!customCategory.isEmpty()) {
					EntityRegistry.addSpawn(entity, customCategory.get("Spawn Probability").getInt(), customCategory.get("Min Spawn Group Size").getInt(), customCategory.get("Max Spawn Group Size").getInt(), type, Biome.REGISTRY.getObject(new ResourceLocation(biomeResource)));
				} else if ((temp <= (float)category.get("Max Spawn Temp").getDouble()) && (temp >= (float)category.get("Min Spawn Temp").getDouble())) {
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
						EntityRegistry.addSpawn(entity, category.get("Spawn Probability").getInt(), category.get("Min Spawn Group Size").getInt(), category.get("Max Spawn Group Size").getInt(), type, Biome.REGISTRY.getObject(new ResourceLocation(biomeResource)));
					}
				}
			} else {
				MoChickens.logger.error("[Mo' Chickens] Biome (id "
								+ biomeResource
								+ ") has null name, could not build spawn information.");
			}
		}
		ran = 1;
	}
}
