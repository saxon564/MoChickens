package me.saxon564.mochickens.registers;

import me.saxon564.mochickens.MoChickens;
import me.saxon564.mochickens.configs.GeneralConfig;
import me.saxon564.mochickens.configs.chickens.*;
import me.saxon564.mochickens.entities.mobs.*;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import cpw.mods.fml.common.registry.EntityRegistry;

public class RegisterSpawns {
	public static int ran;

	// Add Spawns
	public static void entitySpawns() {
		if (DiamondChickenConfig.spawn == true) {
			generateSpawning(EntityDiamondChicken.class,
					EnumCreatureType.monster, DiamondChickenConfig.config);
		}

		if (CoalChickenConfig.spawn == true) {
			generateSpawning(EntityCoalChicken.class,
					EnumCreatureType.monster, CoalChickenConfig.config);
		}

		if (IronChickenConfig.spawn == true) {
			generateSpawning(EntityIronChicken.class,
					EnumCreatureType.monster, IronChickenConfig.config);
		}

		if (GoldChickenConfig.spawn == true) {
			generateSpawning(EntityGoldChicken.class,
					EnumCreatureType.monster, GoldChickenConfig.config);
		}

		if (LapisChickenConfig.spawn == true) {
			generateSpawning(EntityLapisChicken.class,
					EnumCreatureType.monster, LapisChickenConfig.config);
		}

		if (RedstoneChickenConfig.spawn == true) {
			generateSpawning(EntityRedstoneChicken.class,
					EnumCreatureType.monster, RedstoneChickenConfig.config);
		}

		if (EmeraldChickenConfig.spawn == true) {
			generateSpawning(EntityEmeraldChicken.class,
					EnumCreatureType.monster, EmeraldChickenConfig.config);
		}

		if (GiantChickenConfig.spawn == true) {
			generateSpawning(EntityGiantChicken.class,
					EnumCreatureType.monster, GiantChickenConfig.config);
		}

		if (QuartzChickenConfig.spawn == true) {
			generateSpawning(EntityQuartzChicken.class,
					EnumCreatureType.monster, QuartzChickenConfig.config);
		}

		if (CookieChickenConfig.spawn == true) {
			generateSpawning(EntityCookieChicken.class,
					EnumCreatureType.monster, CookieChickenConfig.config);
		}

		if (SnowChickenConfig.spawn == true) {
			generateSpawning(EntitySnowChicken.class,
					EnumCreatureType.monster, SnowChickenConfig.config);
		}

		if (ClayChickenConfig.spawn == true) {
			generateSpawning(EntityClayChicken.class,
					EnumCreatureType.monster, ClayChickenConfig.config);
		}

		if (RainbowChickenConfig.spawn == true) {
			generateSpawning(EntityRainbowChicken.class,
					EnumCreatureType.monster, RainbowChickenConfig.config);
		}

		if (SkeletonChickenConfig.spawn == true) {
			generateSpawning(EntitySkeletonChicken.class,
					EnumCreatureType.monster, SkeletonChickenConfig.config);
		}

		if (EnderChickenConfig.spawn == true) {
			generateSpawning(EntityEnderChicken.class,
					EnumCreatureType.monster, EnderChickenConfig.config);
		}

		if (CreeperChickenConfig.spawn == true) {
			generateSpawning(EntityCreeperChicken.class,
					EnumCreatureType.monster, CreeperChickenConfig.config);
		}

		if (BeefyChickenConfig.spawn == true) {
			generateSpawning(EntityBeefyChicken.class,
					EnumCreatureType.monster, BeefyChickenConfig.config);
		}

		if (GlowingChickenConfig.spawn == true) {
			generateSpawning(EntityGlowingChicken.class,
					EnumCreatureType.monster, GlowingChickenConfig.config);
		}

		if (BlazingChickenConfig.spawn == true) {
			generateSpawning(EntityBlazingChicken.class,
					EnumCreatureType.monster, BlazingChickenConfig.config);
		}

		if (EnchantedChickenConfig.spawn == true) {
			generateSpawning(EntityEnchantedChicken.class,
					EnumCreatureType.monster, EnchantedChickenConfig.config);
		}

		if (NuuwChickenConfig.spawn == true) {
			generateSpawning(EntityNuuwChicken.class,
					EnumCreatureType.monster, NuuwChickenConfig.config);
		}
	}

	public static void generateSpawning(Class entity, EnumCreatureType type,
			Configuration config) {
		
		Boolean allowed;
		int[] blacklist = config.getCategory("spawning").get("Blacklist Spawn Biomes").getIntList();
		for (int i = 0; i < BiomeGenBase.getBiomeGenArray().length; i++) {
			allowed = true;
			BiomeGenBase biome = BiomeGenBase.getBiome(i);
			if ((biome != null)
					&& (!biome.biomeName.toLowerCase().equalsIgnoreCase(
							"chicken forest"))
					&& (!biome.biomeName.toLowerCase().equalsIgnoreCase(
							"chicken plains")))
				if (biome.biomeName == null) {
					System.out
							.println("[Mo' Chickens] Biome (id "
									+ i
									+ ") has null name, could not build spawn information.");
				} else {
					String name = biome.biomeName.toLowerCase();
					float E = biome.temperature;
					float F = biome.rainfall;
					float H = biome.rootHeight;
					int I = biome.theBiomeDecorator.flowersPerChunk;
					int J = biome.theBiomeDecorator.grassPerChunk;
					int K = biome.theBiomeDecorator.treesPerChunk;
					int C = biome.theBiomeDecorator.clayPerChunk;
					if ((GeneralConfig.debug) && (ran != 1)) {
						System.out.println("Name:" + name + " id: " + i);
					}
					if (!config.getCategory("" + biome.biomeID).isEmpty()) {
						EntityRegistry.addSpawn(entity, config.getCategory("" + biome.biomeID).get("Spawn Probability").getInt(), config.getCategory("" + biome.biomeID).get("Min Spawn Group Size").getInt(), config.getCategory("" + biome.biomeID).get("Max Spawn Group Size").getInt(), type, BiomeGenBase.getBiome(i));
						//System.out.println("SPECIAL SPAWNS " + entity.getName() + " in " + BiomeGenBase.getBiome(i) + " ID:" + BiomeGenBase.getBiome(i).biomeID);
						//System.out.println("SPECIAL SPAWNING INFO:  entity:" + entity + "     BiomeId:" + biome.biomeID + "     probability:" + config.getCategory("" + biome.biomeID).get("Spawn Probability").getInt() + "      MaxGroup:" + config.getCategory("" + biome.biomeID).get("Max Spawn Group Size").getInt() + "     MinGroup:" + config.getCategory("" + biome.biomeID).get("Min Spawn Group Size").getInt());
					} else if ((E <= (float)config.getCategory("spawning").get("Max Spawn Temp").getDouble()) && (E >= (float)config.getCategory("spawning").get("Min Spawn Temp").getDouble())) {
						for (int k = 0; k < blacklist.length; k++) {
							if ( blacklist[k] == BiomeGenBase.getBiome(i).biomeID) {
								//System.out.println("BLACKLISTED BIOME " + BiomeGenBase.getBiome(i).biomeID);
								allowed = false;
								break;
							}
						}
						if ( allowed == true ) {
							EntityRegistry.addSpawn(entity, config.getCategory("spawning").get("Spawn Probability").getInt(), config.getCategory("spawning").get("Min Spawn Group Size").getInt(), config.getCategory("spawning").get("Max Spawn Group Size").getInt(), type, BiomeGenBase.getBiome(i));
							//System.out.println("SPAWNS " + entity.getName() + " in " + BiomeGenBase.getBiome(i) + " ID:" + BiomeGenBase.getBiome(i).biomeID);
							//System.out.println("SPAWNING INFO:  entity:" + entity.getName() + "     BiomeId:" + biome.biomeID + "     probability:" + config.getCategory("spawning").get("Spawn Probability").getInt() + "      MaxGroup:" + config.getCategory("spawning").get("Max Spawn Group Size").getInt() + "     MinGroup:" + config.getCategory("spawning").get("Min Spawn Group Size").getInt());
						}
					}
				}
		}
		ran = 1;
	}
}
