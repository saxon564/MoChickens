package com.saxon564.mochickens.registers;

import com.saxon564.mochickens.MoChickens;
import com.saxon564.mochickens.configs.ChickenConfigGenerator;
import com.saxon564.mochickens.configs.ConfigHandler;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.registries.ForgeRegistries;

public class RegisterSpawns {
	public static int ran;

	// Add Spawns
	public static void entitySpawns() {
		generateSpawning(MoChickens.DIAMOND_CHICKEN, EntityClassification.MONSTER, ConfigHandler.DIAMOND_CHICKEN_CONFIG);
		generateSpawning(MoChickens.COAL_CHICKEN, EntityClassification.MONSTER, ConfigHandler.COAL_CHICKEN_CONFIG);
		generateSpawning(MoChickens.IRON_CHICKEN, EntityClassification.MONSTER, ConfigHandler.IRON_CHICKEN_CONFIG);
		generateSpawning(MoChickens.GOLD_CHICKEN, EntityClassification.MONSTER, ConfigHandler.GOLD_CHICKEN_CONFIG);
		generateSpawning(MoChickens.LAPIS_CHICKEN, EntityClassification.MONSTER, ConfigHandler.LAPIS_CHICKEN_CONFIG);
		generateSpawning(MoChickens.REDSTONE_CHICKEN, EntityClassification.MONSTER, ConfigHandler.REDSTONE_CHICKEN_CONFIG);
		generateSpawning(MoChickens.EMERALD_CHICKEN, EntityClassification.MONSTER, ConfigHandler.EMERALD_CHICKEN_CONFIG);
		generateSpawning(MoChickens.GIANT_CHICKEN, EntityClassification.MONSTER, ConfigHandler.GIANT_CHICKEN_CONFIG);
		generateSpawning(MoChickens.QUARTZ_CHICKEN, EntityClassification.MONSTER, ConfigHandler.QUARTZ_CHICKEN_CONFIG);
		generateSpawning(MoChickens.COOKIE_CHICKEN, EntityClassification.MONSTER, ConfigHandler.COOKIE_CHICKEN_CONFIG);
		generateSpawning(MoChickens.SNOW_CHICKEN, EntityClassification.MONSTER, ConfigHandler.SNOW_CHICKEN_CONFIG);
		generateSpawning(MoChickens.CLAY_CHICKEN, EntityClassification.MONSTER, ConfigHandler.CLAY_CHICKEN_CONFIG);
		generateSpawning(MoChickens.REDSTONE_CHICKEN, EntityClassification.MONSTER, ConfigHandler.REDSTONE_CHICKEN_CONFIG);
		generateSpawning(MoChickens.SKELETON_CHICKEN, EntityClassification.MONSTER, ConfigHandler.SKELETON_CHICKEN_CONFIG);
		generateSpawning(MoChickens.ENDER_CHICKEN, EntityClassification.MONSTER, ConfigHandler.ENDER_CHICKEN_CONFIG);
		generateSpawning(MoChickens.CREEPER_CHICKEN, EntityClassification.MONSTER, ConfigHandler.CREEPER_CHICKEN_CONFIG);
		generateSpawning(MoChickens.BEEFY_CHICKEN, EntityClassification.MONSTER, ConfigHandler.BEEFY_CHICKEN_CONFIG);
		generateSpawning(MoChickens.GLOWING_CHICKEN, EntityClassification.MONSTER, ConfigHandler.GLOWING_CHICKEN_CONFIG);
		generateSpawning(MoChickens.BLAZING_CHICKEN, EntityClassification.MONSTER, ConfigHandler.BLAZING_CHICKEN_CONFIG);
		generateSpawning(MoChickens.ENCHANTED_CHICKEN, EntityClassification.MONSTER, ConfigHandler.ENCHANTED_CHICKEN_CONFIG);
		generateSpawning(MoChickens.NUUW_CHICKEN, EntityClassification.MONSTER, ConfigHandler.NUUW_CHICKEN_CONFIG);
	}

	public static void generateSpawning(EntityType<?> entity, EntityClassification type,
			ChickenConfigGenerator config) {
		
		if (config.CAN_SPAWN.get()) {
			Boolean allowed;
			String listType = config.BIOME_WHITELIST_OR_BLACKLIST.get();
			String[] biomeList = config.BIOME_LIST.get().split(",");
			for (Biome biome : ForgeRegistries.BIOMES) {
				
				allowed = true;
				String biomeResource = (String) biome.toString().toLowerCase();
				
				if (biomeResource != null) {
					if (config.CUSTOM_BIOMES.containsKey(biome.getRegistryName().toString())) {
						biome.getSpawns(type).add(new Biome.SpawnListEntry(entity, config.CUSTOM_BIOMES.get(biome.getRegistryName().toString()).get("probability"), config.CUSTOM_BIOMES.get(biome.getRegistryName().toString()).get("min_group"), config.CUSTOM_BIOMES.get(biome.getRegistryName().toString()).get("max_group")));
					}
					float temp = biome.getDefaultTemperature();
					if ((temp <= config.MAXIMUM_SPAWN_TEMP.get()) && (temp >= config.MINIMUM_SPAWN_TEMP.get())) {
						for (int k = 0; k < biomeList.length; k++) {
							if (listType.equalsIgnoreCase("whitelist")) {
								if (!biomeList[k].equals(biomeResource)) {
									if (ConfigHandler.DEBUG.get()) MoChickens.CHICKEN_LOGGER.debug(entity.getName() + " whitelist biome " + biomeList[k] + " compared to " + biomeResource);
									allowed = false;
									break;
								}
							} else {
								if (biomeList[k].equals(biomeResource)) {
									if (ConfigHandler.DEBUG.get()) MoChickens.CHICKEN_LOGGER.debug(entity.getName() + " blacklist biome " + biomeList[k] + " compared to " + biomeResource);
									allowed = false;
									break;
								}
							}
						}
						if ( allowed == true ) {
							biome.getSpawns(type).add(new Biome.SpawnListEntry(entity, config.SPAWN_PROBIBILITY.get(), config.MINIMUM_SPAWN_GROUP_SIZE.get(), config.MAXIMUM_SPAWN_GROUP_SIZE.get()));
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
