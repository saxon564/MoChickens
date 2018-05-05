package com.saxon564.mochickens.registers;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import com.saxon564.mochickens.MoChickens;
import com.saxon564.mochickens.Reference;
import com.saxon564.mochickens.configs.FileManager;
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
        registerEntities(new ResourceLocation(Reference.MOD_ID, "CoalChicken"), EntityCoalChicken.class, "CoalChicken", FileManager.coalConfig, 0x2e2e2e, 0x000000);
        registerEntities(new ResourceLocation(Reference.MOD_ID, "IronChicken"),EntityIronChicken.class, "IronChicken", FileManager.ironConfig, 0xd7d0b2, 0x000000);
        registerEntities(new ResourceLocation(Reference.MOD_ID, "GoldChicken"),EntityGoldChicken.class, "GoldChicken", FileManager.goldConfig, 0xccda2b, 0x000000);
        registerEntities(new ResourceLocation(Reference.MOD_ID, "LapisChicken"),EntityLapisChicken.class, "LapisChicken", FileManager.lapisConfig, 0x4b4bcc, 0x000000);
        registerEntities(new ResourceLocation(Reference.MOD_ID, "RedstoneChicken"),EntityRedstoneChicken.class, "RedstoneChicken", FileManager.redstoneConfig, 0xff6464, 0x000000);
        registerEntities(new ResourceLocation(Reference.MOD_ID, "DiamondChicken"),EntityDiamondChicken.class, "DiamondChicken", FileManager.diamondConfig, 0xa8e2e2, 0x000000);
        registerEntities(new ResourceLocation(Reference.MOD_ID, "EmeraldChicken"),EntityEmeraldChicken.class, "EmeraldChicken", FileManager.emeraldConfig, 0x06cc01, 0x000000);
        registerEntities(new ResourceLocation(Reference.MOD_ID, "GiantChicken"),EntityGiantChicken.class, "GiantChicken", FileManager.giantConfig, 0xe2e2e2, 0x000000);
        registerEntities(new ResourceLocation(Reference.MOD_ID, "QuartzChicken"),EntityQuartzChicken.class, "QuartzChicken", FileManager.quartzConfig, 0x4a0000, 0xdbccbf);
        registerEntities(new ResourceLocation(Reference.MOD_ID, "CookieChicken"),EntityCookieChicken.class, "CookieChicken", FileManager.cookieConfig, 0xe79042, 0x000000);
        registerEntities(new ResourceLocation(Reference.MOD_ID, "SnowChicken"),EntitySnowChicken.class, "SnowChicken", FileManager.snowConfig, 0xFFFFFF, 0x000000);
        registerEntities(new ResourceLocation(Reference.MOD_ID, "ClayChicken"),EntityClayChicken.class, "ClayChicken", FileManager.clayConfig, 0x878787, 0x000000);
        registerEntities(new ResourceLocation(Reference.MOD_ID, "RainbowChicken"),EntityRainbowChicken.class, "RainbowChicken", FileManager.rainbowConfig, 0xff8020, 0x00ffff);
        registerEntities(new ResourceLocation(Reference.MOD_ID, "SkeletonChicken"),EntitySkeletonChicken.class, "SkeletonChicken", FileManager.skeletonConfig, 0xc6c3b6, 0x000000);
        registerEntities(new ResourceLocation(Reference.MOD_ID, "EnderChicken"),EntityEnderChicken.class, "EnderChicken", FileManager.enderConfig, 0x000000, 0x797979);
        registerEntities(new ResourceLocation(Reference.MOD_ID, "CreeperChicken"),EntityCreeperChicken.class, "CreeperChicken", FileManager.creeperConfig, 0x85d576, 0x000000);
        registerEntities(new ResourceLocation(Reference.MOD_ID, "BeefyChicken"),EntityBeefyChicken.class, "BeefyChicken", FileManager.beefyConfig, 0x42361e, 0xd2cfbd);
        registerEntities(new ResourceLocation(Reference.MOD_ID, "GlowingChicken"),EntityGlowingChicken.class, "GlowingChicken", FileManager.glowingConfig, 0xf1d808, 0xfffe31);
        registerEntities(new ResourceLocation(Reference.MOD_ID, "BlazingChicken"),EntityBlazingChicken.class, "BlazingChicken", FileManager.blazingConfig, 0xffcb00, 0x953300);
        registerEntities(new ResourceLocation(Reference.MOD_ID, "EnchantedChicken"),EntityEnchantedChicken.class, "EnchantedChicken", FileManager.enchantedConfig, 0xceff1e, 0x50ff18);
        registerEntities(new ResourceLocation(Reference.MOD_ID, "NuuwChicken"),EntityNuuwChicken.class, "NuuwChicken", FileManager.nuuwConfig, 0xbae8e8, 0xb9855c);
    }
	
	private static void registerEntities(ResourceLocation resourceLocation, Class classIn, String name, Configuration config, int color1, int color2) {
		EntityRegistry.registerModEntity(resourceLocation, classIn, name, config.getCategory("entity data").get("ID").getInt(), instance, 40, 3, true, color1, color2);
	}
	
}
