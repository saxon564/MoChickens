package com.saxon564.mochickens.registers;

import com.saxon564.mochickens.MoChickens;
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

import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.registry.EntityRegistry;

public class RegisterChickens {

	@Instance("mochickens")
    public static MoChickens instance;
	
	public static void entityRegisters()
    {
        EntityRegistry.registerModEntity(EntityCoalChicken.class, "CoalChicken", CoalChickenConfig.id, instance, 40, 3, true);
        EntityRegistry.registerModEntity(EntityIronChicken.class, "IronChicken", IronChickenConfig.id, instance, 40, 3, true);
        EntityRegistry.registerModEntity(EntityGoldChicken.class, "GoldChicken", GoldChickenConfig.id, instance, 40, 3, true);
        EntityRegistry.registerModEntity(EntityLapisChicken.class, "LapisChicken", LapisChickenConfig.id, instance, 40, 3, true);
        EntityRegistry.registerModEntity(EntityRedstoneChicken.class, "RedstoneChicken", RedstoneChickenConfig.id, instance, 40, 3, true);
        EntityRegistry.registerModEntity(EntityDiamondChicken.class, "DiamondChicken", DiamondChickenConfig.id, instance, 40, 3, true);
        EntityRegistry.registerModEntity(EntityEmeraldChicken.class, "EmeraldChicken", EmeraldChickenConfig.id, instance, 40, 3, true);
        EntityRegistry.registerModEntity(EntityGiantChicken.class, "GiantChicken", GiantChickenConfig.id, instance, 40, 3, true);
        EntityRegistry.registerModEntity(EntityQuartzChicken.class, "QuartzChicken", QuartzChickenConfig.id, instance, 40, 3, true);
        EntityRegistry.registerModEntity(EntityCookieChicken.class, "CookieChicken", CookieChickenConfig.id, instance, 40, 3, true);
        EntityRegistry.registerModEntity(EntitySnowChicken.class, "SnowChicken", SnowChickenConfig.id, instance, 40, 3, true);
        EntityRegistry.registerModEntity(EntityClayChicken.class, "ClayChicken", ClayChickenConfig.id, instance, 40, 3, true);
        EntityRegistry.registerModEntity(EntityRainbowChicken.class, "RainbowChicken", RainbowChickenConfig.id, instance, 40, 3, true);
        EntityRegistry.registerModEntity(EntitySkeletonChicken.class, "SkeletonChicken", SkeletonChickenConfig.id, instance, 40, 3, true);
        EntityRegistry.registerModEntity(EntityEnderChicken.class, "EnderChicken", EnderChickenConfig.id, instance, 40, 3, true);
        EntityRegistry.registerModEntity(EntityCreeperChicken.class, "CreeperChicken", CreeperChickenConfig.id, instance, 40, 3, true);
        EntityRegistry.registerModEntity(EntityBeefyChicken.class, "BeefyChicken", BeefyChickenConfig.id, instance, 40, 3, true);
        EntityRegistry.registerModEntity(EntityGlowingChicken.class, "GlowingChicken", GlowingChickenConfig.id, instance, 40, 3, true);
        EntityRegistry.registerModEntity(EntityBlazingChicken.class, "BlazingChicken", BlazingChickenConfig.id, instance, 40, 3, true);
        EntityRegistry.registerModEntity(EntityEnchantedChicken.class, "EnchantedChicken", EnchantedChickenConfig.id, instance, 40, 3, true);
        EntityRegistry.registerModEntity(EntityNuuwChicken.class, "NuuwChicken", NuuwChickenConfig.id, instance, 40, 3, true);
    }
	
}
