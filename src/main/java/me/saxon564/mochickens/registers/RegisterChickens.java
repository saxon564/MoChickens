package me.saxon564.mochickens.registers;

import me.saxon564.mochickens.MoChickens;
import me.saxon564.mochickens.configs.chickens.BeefyChickenConfig;
import me.saxon564.mochickens.configs.chickens.BlazingChickenConfig;
import me.saxon564.mochickens.configs.chickens.ClayChickenConfig;
import me.saxon564.mochickens.configs.chickens.CoalChickenConfig;
import me.saxon564.mochickens.configs.chickens.CookieChickenConfig;
import me.saxon564.mochickens.configs.chickens.CreeperChickenConfig;
import me.saxon564.mochickens.configs.chickens.DiamondChickenConfig;
import me.saxon564.mochickens.configs.chickens.EmeraldChickenConfig;
import me.saxon564.mochickens.configs.chickens.EnchantedChickenConfig;
import me.saxon564.mochickens.configs.chickens.EnderChickenConfig;
import me.saxon564.mochickens.configs.chickens.GiantChickenConfig;
import me.saxon564.mochickens.configs.chickens.GlowingChickenConfig;
import me.saxon564.mochickens.configs.chickens.GoldChickenConfig;
import me.saxon564.mochickens.configs.chickens.IronChickenConfig;
import me.saxon564.mochickens.configs.chickens.LapisChickenConfig;
import me.saxon564.mochickens.configs.chickens.NuuwChickenConfig;
import me.saxon564.mochickens.configs.chickens.QuartzChickenConfig;
import me.saxon564.mochickens.configs.chickens.RainbowChickenConfig;
import me.saxon564.mochickens.configs.chickens.RedstoneChickenConfig;
import me.saxon564.mochickens.configs.chickens.SkeletonChickenConfig;
import me.saxon564.mochickens.configs.chickens.SnowChickenConfig;
import me.saxon564.mochickens.entities.mobs.EntityBeefyChicken;
import me.saxon564.mochickens.entities.mobs.EntityBlazingChicken;
import me.saxon564.mochickens.entities.mobs.EntityClayChicken;
import me.saxon564.mochickens.entities.mobs.EntityCoalChicken;
import me.saxon564.mochickens.entities.mobs.EntityCookieChicken;
import me.saxon564.mochickens.entities.mobs.EntityCreeperChicken;
import me.saxon564.mochickens.entities.mobs.EntityDiamondChicken;
import me.saxon564.mochickens.entities.mobs.EntityEmeraldChicken;
import me.saxon564.mochickens.entities.mobs.EntityEnchantedChicken;
import me.saxon564.mochickens.entities.mobs.EntityEnderChicken;
import me.saxon564.mochickens.entities.mobs.EntityGiantChicken;
import me.saxon564.mochickens.entities.mobs.EntityGlowingChicken;
import me.saxon564.mochickens.entities.mobs.EntityGoldChicken;
import me.saxon564.mochickens.entities.mobs.EntityIronChicken;
import me.saxon564.mochickens.entities.mobs.EntityLapisChicken;
import me.saxon564.mochickens.entities.mobs.EntityNuuwChicken;
import me.saxon564.mochickens.entities.mobs.EntityQuartzChicken;
import me.saxon564.mochickens.entities.mobs.EntityRainbowChicken;
import me.saxon564.mochickens.entities.mobs.EntityRedstoneChicken;
import me.saxon564.mochickens.entities.mobs.EntitySkeletonChicken;
import me.saxon564.mochickens.entities.mobs.EntitySnowChicken;
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
