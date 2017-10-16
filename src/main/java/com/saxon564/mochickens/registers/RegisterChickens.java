package com.saxon564.mochickens.registers;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import com.saxon564.mochickens.MoChickens;
import com.saxon564.mochickens.Reference;
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

public class RegisterChickens {

	@Instance("mochickens")
    public static MoChickens instance;
	
	
	public static void entityRegisters()
    {
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, "CoalChicken"), EntityCoalChicken.class, "CoalChicken", CoalChickenConfig.id, instance, 40, 3, true, 0x2e2e2e, 0x000000);
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, "IronChicken"),EntityIronChicken.class, "IronChicken", IronChickenConfig.id, instance, 40, 3, true, 0xd7d0b2, 0x000000);
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, "GoldChicken"),EntityGoldChicken.class, "GoldChicken", GoldChickenConfig.id, instance, 40, 3, true, 0xccda2b, 0x000000);
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, "LapisChicken"),EntityLapisChicken.class, "LapisChicken", LapisChickenConfig.id, instance, 40, 3, true, 0x4b4bcc, 0x000000);
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, "RedstoneChicken"),EntityRedstoneChicken.class, "RedstoneChicken", RedstoneChickenConfig.id, instance, 40, 3, true, 0xff6464, 0x000000);
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, "DiamondChicken"),EntityDiamondChicken.class, "DiamondChicken", DiamondChickenConfig.id, instance, 40, 3, true, 0xa8e2e2, 0x000000);
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, "EmeraldChicken"),EntityEmeraldChicken.class, "EmeraldChicken", EmeraldChickenConfig.id, instance, 40, 3, true, 0x06cc01, 0x000000);
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, "GiantChicken"),EntityGiantChicken.class, "GiantChicken", GiantChickenConfig.id, instance, 40, 3, true, 0xe2e2e2, 0x000000);
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, "QuartzChicken"),EntityQuartzChicken.class, "QuartzChicken", QuartzChickenConfig.id, instance, 40, 3, true, 0x4a0000, 0xdbccbf);
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, "CookieChicken"),EntityCookieChicken.class, "CookieChicken", CookieChickenConfig.id, instance, 40, 3, true, 0xe79042, 0x000000);
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, "SnowChicken"),EntitySnowChicken.class, "SnowChicken", SnowChickenConfig.id, instance, 40, 3, true, 0xFFFFFF, 0x000000);
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, "ClayChicken"),EntityClayChicken.class, "ClayChicken", ClayChickenConfig.id, instance, 40, 3, true, 0x878787, 0x000000);
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, "RainbowChicken"),EntityRainbowChicken.class, "RainbowChicken", RainbowChickenConfig.id, instance, 40, 3, true, 0xff8020, 0x00ffff);
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, "SkeletonChicken"),EntitySkeletonChicken.class, "SkeletonChicken", SkeletonChickenConfig.id, instance, 40, 3, true, 0xc6c3b6, 0x000000);
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, "EnderChicken"),EntityEnderChicken.class, "EnderChicken", EnderChickenConfig.id, instance, 40, 3, true, 0x000000, 0x797979);
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, "CreeperChicken"),EntityCreeperChicken.class, "CreeperChicken", CreeperChickenConfig.id, instance, 40, 3, true, 0x85d576, 0x000000);
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, "BeefyChicken"),EntityBeefyChicken.class, "BeefyChicken", BeefyChickenConfig.id, instance, 40, 3, true, 0x42361e, 0xd2cfbd);
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, "GlowingChicken"),EntityGlowingChicken.class, "GlowingChicken", GlowingChickenConfig.id, instance, 40, 3, true, 0xf1d808, 0xfffe31);
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, "BlazingChicken"),EntityBlazingChicken.class, "BlazingChicken", BlazingChickenConfig.id, instance, 40, 3, true, 0xffcb00, 0x953300);
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, "EnchantedChicken"),EntityEnchantedChicken.class, "EnchantedChicken", EnchantedChickenConfig.id, instance, 40, 3, true, 0xceff1e, 0x50ff18);
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, "NuuwChicken"),EntityNuuwChicken.class, "NuuwChicken", NuuwChickenConfig.id, instance, 40, 3, true, 0xbae8e8, 0xb9855c);
    }
	
}
