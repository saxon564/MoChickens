package com.saxon564.mochickens.registers;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import com.saxon564.mochickens.configs.GeneralConfig;
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
		if (DiamondChickenConfig.spawn == true) {
			generateSpawning(EntityDiamondChicken.class,
					EnumCreatureType.MONSTER, DiamondChickenConfig.config);
		}

		if (CoalChickenConfig.spawn == true) {
			generateSpawning(EntityCoalChicken.class,
					EnumCreatureType.MONSTER, CoalChickenConfig.config);
		}

		if (IronChickenConfig.spawn == true) {
			generateSpawning(EntityIronChicken.class,
					EnumCreatureType.MONSTER, IronChickenConfig.config);
		}

		if (GoldChickenConfig.spawn == true) {
			generateSpawning(EntityGoldChicken.class,
					EnumCreatureType.MONSTER, GoldChickenConfig.config);
		}

		if (LapisChickenConfig.spawn == true) {
			generateSpawning(EntityLapisChicken.class,
					EnumCreatureType.MONSTER, LapisChickenConfig.config);
		}

		if (RedstoneChickenConfig.spawn == true) {
			generateSpawning(EntityRedstoneChicken.class,
					EnumCreatureType.MONSTER, RedstoneChickenConfig.config);
		}

		if (EmeraldChickenConfig.spawn == true) {
			generateSpawning(EntityEmeraldChicken.class,
					EnumCreatureType.MONSTER, EmeraldChickenConfig.config);
		}

		if (GiantChickenConfig.spawn == true) {
			generateSpawning(EntityGiantChicken.class,
					EnumCreatureType.MONSTER, GiantChickenConfig.config);
		}

		if (QuartzChickenConfig.spawn == true) {
			generateSpawning(EntityQuartzChicken.class,
					EnumCreatureType.MONSTER, QuartzChickenConfig.config);
		}

		if (CookieChickenConfig.spawn == true) {
			generateSpawning(EntityCookieChicken.class,
					EnumCreatureType.MONSTER, CookieChickenConfig.config);
		}

		if (SnowChickenConfig.spawn == true) {
			generateSpawning(EntitySnowChicken.class,
					EnumCreatureType.MONSTER, SnowChickenConfig.config);
		}

		if (ClayChickenConfig.spawn == true) {
			generateSpawning(EntityClayChicken.class,
					EnumCreatureType.MONSTER, ClayChickenConfig.config);
		}

		if (RainbowChickenConfig.spawn == true) {
			generateSpawning(EntityRainbowChicken.class,
					EnumCreatureType.MONSTER, RainbowChickenConfig.config);
		}

		if (SkeletonChickenConfig.spawn == true) {
			generateSpawning(EntitySkeletonChicken.class,
					EnumCreatureType.MONSTER, SkeletonChickenConfig.config);
		}

		if (EnderChickenConfig.spawn == true) {
			generateSpawning(EntityEnderChicken.class,
					EnumCreatureType.MONSTER, EnderChickenConfig.config);
		}

		if (CreeperChickenConfig.spawn == true) {
			generateSpawning(EntityCreeperChicken.class,
					EnumCreatureType.MONSTER, CreeperChickenConfig.config);
		}

		if (BeefyChickenConfig.spawn == true) {
			generateSpawning(EntityBeefyChicken.class,
					EnumCreatureType.MONSTER, BeefyChickenConfig.config);
		}

		if (GlowingChickenConfig.spawn == true) {
			generateSpawning(EntityGlowingChicken.class,
					EnumCreatureType.MONSTER, GlowingChickenConfig.config);
		}

		if (BlazingChickenConfig.spawn == true) {
			generateSpawning(EntityBlazingChicken.class,
					EnumCreatureType.MONSTER, BlazingChickenConfig.config);
		}

		if (EnchantedChickenConfig.spawn == true) {
			generateSpawning(EntityEnchantedChicken.class,
					EnumCreatureType.MONSTER, EnchantedChickenConfig.config);
		}

		if (NuuwChickenConfig.spawn == true) {
			generateSpawning(EntityNuuwChicken.class,
					EnumCreatureType.MONSTER, NuuwChickenConfig.config);
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
			
			if ((biomeResource != null)
					&& (!biomeResource.equalsIgnoreCase(
							"mochickens:chicken_forest"))
					&& (!biomeResource.equalsIgnoreCase(
							"mochcickens:chicken_plains"))) {
				Biome biome = Biome.REGISTRY.getObject(new ResourceLocation(biomeResource));
				float E = biome.getTemperature();
				float F = biome.getRainfall();
				int I = biome.theBiomeDecorator.flowersPerChunk;
				int J = biome.theBiomeDecorator.grassPerChunk;
				int K = biome.theBiomeDecorator.treesPerChunk;
				int C = biome.theBiomeDecorator.clayPerChunk;
				if (!customCategory.isEmpty()) {
					EntityRegistry.addSpawn(entity, customCategory.get("Spawn Probability").getInt(), customCategory.get("Min Spawn Group Size").getInt(), customCategory.get("Max Spawn Group Size").getInt(), type, Biome.REGISTRY.getObject(new ResourceLocation(biomeResource)));
				} else if ((E <= (float)category.get("Max Spawn Temp").getDouble()) && (E >= (float)category.get("Min Spawn Temp").getDouble())) {
					for (int k = 0; k < biomeList.length; k++) {
						if (listType.equalsIgnoreCase("whitelist")) {
							if (!biomeList[k].equals(biomeResource)) {
								//if (entity.getName().equals("com.saxon564.mochickens.entities.mobs.EntityEnderChicken") || entity.getName().equals("com.saxon564.mochickens.entities.mobs.EntitySkeletonChicken") || entity.getName().equals("com.saxon564.mochickens.entities.mobs.EntityCreeperChicken")) {
									System.out.println(entity.getName() + " whitelist biome " + biomeList[k] + " compared to " + biomeResource);
								//}
								allowed = false;
								break;
							}
						} else {
							if (biomeList[k].equals(biomeResource)) {
								//if (entity.getName().equals("com.saxon564.mochickens.entities.mobs.EntityEnderChicken") || entity.getName().equals("com.saxon564.mochickens.entities.mobs.EntitySkeletonChicken") || entity.getName().equals("com.saxon564.mochickens.entities.mobs.EntityCreeperChicken")) {
									System.out.println(entity.getName() + " blacklist biome " + biomeList[k] + " compared to " + biomeResource);
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
				System.out.println("[Mo' Chickens] Biome (id "
								+ biomeResource
								+ ") has null name, could not build spawn information.");
			}
		}
		ran = 1;
	}
}
