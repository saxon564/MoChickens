package com.saxon564.mochickens.registers;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.Biome;
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
		int[] blacklist = config.getCategory("spawning").get("Blacklist Spawn Biomes").getIntList();
		for (int i = 0; i < Biome.REGISTRY.hashCode(); i++) {
			allowed = true;
			Biome biome = Biome.getBiome(i);
			if ((biome != null)
					&& (!biome.getBiomeName().toLowerCase().equalsIgnoreCase(
							"chicken forest"))
					&& (!biome.getBiomeName().toLowerCase().equalsIgnoreCase(
							"chicken plains")))
				if (biome.getBiomeName() == null) {
					System.out
							.println("[Mo' Chickens] Biome (id "
									+ i
									+ ") has null name, could not build spawn information.");
				} else {
					String name = biome.getBiomeName().toLowerCase();
					float E = biome.getTemperature();
					float F = biome.getRainfall();
					int I = biome.theBiomeDecorator.flowersPerChunk;
					int J = biome.theBiomeDecorator.grassPerChunk;
					int K = biome.theBiomeDecorator.treesPerChunk;
					int C = biome.theBiomeDecorator.clayPerChunk;
					if ((GeneralConfig.debug) && (ran != 1)) {
						System.out.println("Name:" + name + " id: " + i);
					}
					if (!config.getCategory("" + biome.getIdForBiome(biome)).isEmpty()) {
						EntityRegistry.addSpawn(entity, config.getCategory("" + biome.getIdForBiome(biome)).get("Spawn Probability").getInt(), config.getCategory("" + biome.getIdForBiome(biome)).get("Min Spawn Group Size").getInt(), config.getCategory("" + biome.getIdForBiome(biome)).get("Max Spawn Group Size").getInt(), type, Biome.getBiome(i));
						//System.out.println("SPECIAL SPAWNS " + entity.getName() + " in " + BiomeGenBase.getBiome(i) + " ID:" + BiomeGenBase.getBiome(i).biomeID);
						//System.out.println("SPECIAL SPAWNING INFO:  entity:" + entity + "     BiomeId:" + biome.biomeID + "     probability:" + config.getCategory("" + biome.biomeID).get("Spawn Probability").getInt() + "      MaxGroup:" + config.getCategory("" + biome.biomeID).get("Max Spawn Group Size").getInt() + "     MinGroup:" + config.getCategory("" + biome.biomeID).get("Min Spawn Group Size").getInt());
					} else if ((E <= (float)config.getCategory("spawning").get("Max Spawn Temp").getDouble()) && (E >= (float)config.getCategory("spawning").get("Min Spawn Temp").getDouble())) {
						for (int k = 0; k < blacklist.length; k++) {
							if ( blacklist[k] == Biome.getBiome(i).getIdForBiome(biome)) {
								//System.out.println("BLACKLISTED BIOME " + BiomeGenBase.getBiome(i).biomeID);
								allowed = false;
								break;
							}
						}
						if ( allowed == true ) {
							EntityRegistry.addSpawn(entity, config.getCategory("spawning").get("Spawn Probability").getInt(), config.getCategory("spawning").get("Min Spawn Group Size").getInt(), config.getCategory("spawning").get("Max Spawn Group Size").getInt(), type, Biome.getBiome(i));
							//System.out.println("SPAWNS " + entity.getName() + " in " + BiomeGenBase.getBiome(i) + " ID:" + BiomeGenBase.getBiome(i).biomeID);
							//System.out.println("SPAWNING INFO:  entity:" + entity.getName() + "     BiomeId:" + biome.biomeID + "     probability:" + config.getCategory("spawning").get("Spawn Probability").getInt() + "      MaxGroup:" + config.getCategory("spawning").get("Max Spawn Group Size").getInt() + "     MinGroup:" + config.getCategory("spawning").get("Min Spawn Group Size").getInt());
						}
					}
				}
		}
		ran = 1;
	}
}
