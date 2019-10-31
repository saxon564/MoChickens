package com.saxon564.mochickens.registers;

import com.saxon564.mochickens.MoChickens;
import com.saxon564.mochickens.Reference;
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

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

//@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class RegisterChickens {
	
	@SubscribeEvent
	public static void entityRegisters(final RegistryEvent.Register<EntityType<?>> event)
    {
		event.getRegistry().registerAll(
			MoChickens.BEEFY_CHICKEN = createEntities(EntityBeefyChicken::new, EntityClassification.MONSTER, "BeefyChicken", BeefyChickenConfig.class),
			MoChickens.BLAZING_CHICKEN = createEntities(EntityBlazingChicken::new, EntityClassification.MONSTER, "BlazingChicken", BlazingChickenConfig.class),
			MoChickens.CLAY_CHICKEN = createEntities(EntityClayChicken::new, EntityClassification.MONSTER, "ClayChicken", ClayChickenConfig.class),
			MoChickens.COAL_CHICKEN = createEntities(EntityCoalChicken::new, EntityClassification.MONSTER, "CoalChicken", CoalChickenConfig.class),
			MoChickens.COOKIE_CHICKEN = createEntities(EntityCookieChicken::new, EntityClassification.MONSTER, "CookieChicken", CookieChickenConfig.class),
			MoChickens.CREEPER_CHICKEN = createEntities(EntityCreeperChicken::new, EntityClassification.MONSTER, "CreeperChicken", CreeperChickenConfig.class),
			MoChickens.DIAMOND_CHICKEN = createEntities(EntityDiamondChicken::new, EntityClassification.MONSTER, "DiamondChicken", DiamondChickenConfig.class),
			MoChickens.EMERALD_CHICKEN = createEntities(EntityEmeraldChicken::new, EntityClassification.MONSTER, "EmeraldChicken", EmeraldChickenConfig.class),
			MoChickens.ENCHANTED_CHICKEN = createEntities(EntityEnchantedChicken::new, EntityClassification.MONSTER, "EnchantedChicken", EnchantedChickenConfig.class),
			MoChickens.ENDER_CHICKEN = createEntities(EntityEnderChicken::new, EntityClassification.MONSTER, "EnderChicken", EnderChickenConfig.class),
			MoChickens.GIANT_CHICKEN = createEntities(EntityGiantChicken::new, EntityClassification.MONSTER, "GiantChicken", GiantChickenConfig.class),
			MoChickens.GLOWING_CHICKEN = createEntities(EntityGlowingChicken::new, EntityClassification.MONSTER, "GlowingChicken", GlowingChickenConfig.class),
			MoChickens.GOLD_CHICKEN = createEntities(EntityGoldChicken::new, EntityClassification.MONSTER, "GoldChicken",GoldChickenConfig.class),
			MoChickens.IRON_CHICKEN = createEntities(EntityIronChicken::new, EntityClassification.MONSTER, "IronChicken",IronChickenConfig.class),
			MoChickens.LAPIS_CHICKEN = createEntities(EntityLapisChicken::new, EntityClassification.MONSTER, "LapisChicken", LapisChickenConfig.class),
			MoChickens.NUUW_CHICKEN = createEntities(EntityNuuwChicken::new, EntityClassification.MONSTER, "NuuwChicken", NuuwChickenConfig.class),
			MoChickens.QUARTZ_CHICKEN = createEntities(EntityQuartzChicken::new, EntityClassification.MONSTER, "QuartzChicken", QuartzChickenConfig.class),
			MoChickens.RAINBOW_CHICKEN = createEntities(EntityRainbowChicken::new, EntityClassification.MONSTER, "RainbowChicken", RainbowChickenConfig.class),
			MoChickens.REDSTONE_CHICKEN = createEntities(EntityRedstoneChicken::new, EntityClassification.MONSTER, "RedstoneChicken", RedstoneChickenConfig.class),
			MoChickens.SKELETON_CHICKEN = createEntities(EntitySkeletonChicken::new, EntityClassification.MONSTER, "SkeletonChicken", SkeletonChickenConfig.class),
			MoChickens.SNOW_CHICKEN = createEntities(EntitySnowChicken::new, EntityClassification.MONSTER, "SnowChicken", SnowChickenConfig.class)
		);
    }
	
	private static <T extends Entity> EntityType<T> createEntities(EntityType.IFactory<T> entity, EntityClassification classification, String name, Class<?> c) {
		ChickenConfigGenerator config = null;
		EntityType<T> entityType = null;
		float x;
		float z;
		try {
			config = (ChickenConfigGenerator) c.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		if (config != null) {
			x = config.HIT_BOX_X_SIZE.get();
			z = config.HIT_BOX_Z_SIZE.get();
		} else {
			x = 0.3F;
			z = 0.7F;
		}
		if (config.IMMUNE_TO_FIRE.get()) {
			entityType = EntityType.Builder.create(entity, classification).size(x, z).immuneToFire().build(Reference.MOD_ID + name);
		} else {
			entityType = EntityType.Builder.create(entity, classification).size(x, z).build(Reference.MOD_ID + name);
		}
		entityType.setRegistryName(new ResourceLocation(Reference.MOD_ID + name));
		return entityType;
	}
	
}
