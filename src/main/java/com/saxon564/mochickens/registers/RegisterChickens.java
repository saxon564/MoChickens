package com.saxon564.mochickens.registers;

import com.saxon564.mochickens.MoChickens;
import com.saxon564.mochickens.Reference;
import com.saxon564.mochickens.configs.ChickenConfigGenerator;
import com.saxon564.mochickens.configs.ConfigHandler;
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
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class RegisterChickens {
	
	
	public static void createChickens()
    {
		MoChickens.BEEFY_CHICKEN = createEntities(EntityBeefyChicken::new, EntityClassification.MONSTER, "beefy_chicken", ConfigHandler.BEEFY_CHICKEN_CONFIG);
		MoChickens.BLAZING_CHICKEN = createEntities(EntityBlazingChicken::new, EntityClassification.MONSTER, "blazing_chicken", ConfigHandler.BLAZING_CHICKEN_CONFIG);
		MoChickens.CLAY_CHICKEN = createEntities(EntityClayChicken::new, EntityClassification.MONSTER, "clay_chicken", ConfigHandler.CLAY_CHICKEN_CONFIG);
		MoChickens.COAL_CHICKEN = createEntities(EntityCoalChicken::new, EntityClassification.MONSTER, "coal_chicken", ConfigHandler.COAL_CHICKEN_CONFIG);
		MoChickens.COOKIE_CHICKEN = createEntities(EntityCookieChicken::new, EntityClassification.MONSTER, "cookie_chicken", ConfigHandler.COOKIE_CHICKEN_CONFIG);
		MoChickens.CREEPER_CHICKEN = createEntities(EntityCreeperChicken::new, EntityClassification.MONSTER, "creeper_chicken", ConfigHandler.CREEPER_CHICKEN_CONFIG);
		MoChickens.DIAMOND_CHICKEN = createEntities(EntityDiamondChicken::new, EntityClassification.MONSTER, "diamond_chicken", ConfigHandler.DIAMOND_CHICKEN_CONFIG);
		MoChickens.EMERALD_CHICKEN = createEntities(EntityEmeraldChicken::new, EntityClassification.MONSTER, "emerald_chicken", ConfigHandler.EMERALD_CHICKEN_CONFIG);
		MoChickens.ENCHANTED_CHICKEN = createEntities(EntityEnchantedChicken::new, EntityClassification.MONSTER, "enchanted_chicken", ConfigHandler.ENCHANTED_CHICKEN_CONFIG);
		MoChickens.ENDER_CHICKEN = createEntities(EntityEnderChicken::new, EntityClassification.MONSTER, "ender_chicken", ConfigHandler.ENDER_CHICKEN_CONFIG);
		MoChickens.GIANT_CHICKEN = createEntities(EntityGiantChicken::new, EntityClassification.MONSTER, "giant_chicken", ConfigHandler.GIANT_CHICKEN_CONFIG);
		MoChickens.GLOWING_CHICKEN = createEntities(EntityGlowingChicken::new, EntityClassification.MONSTER, "glowing_chicken", ConfigHandler.GLOWING_CHICKEN_CONFIG);
		MoChickens.GOLD_CHICKEN = createEntities(EntityGoldChicken::new, EntityClassification.MONSTER, "gold_chicken", ConfigHandler.GOLD_CHICKEN_CONFIG);
		MoChickens.IRON_CHICKEN = createEntities(EntityIronChicken::new, EntityClassification.MONSTER, "iron_chicken", ConfigHandler.IRON_CHICKEN_CONFIG);
		MoChickens.LAPIS_CHICKEN = createEntities(EntityLapisChicken::new, EntityClassification.MONSTER, "lapis_chicken", ConfigHandler.LAPIS_CHICKEN_CONFIG);
		MoChickens.NUUW_CHICKEN = createEntities(EntityNuuwChicken::new, EntityClassification.MONSTER, "nuuw_chicken", ConfigHandler.NUUW_CHICKEN_CONFIG);
		MoChickens.QUARTZ_CHICKEN = createEntities(EntityQuartzChicken::new, EntityClassification.MONSTER, "quartz_chicken", ConfigHandler.QUARTZ_CHICKEN_CONFIG);
		MoChickens.RAINBOW_CHICKEN = createEntities(EntityRainbowChicken::new, EntityClassification.MONSTER, "rainbow_chicken", ConfigHandler.RAINBOW_CHICKEN_CONFIG);
		MoChickens.REDSTONE_CHICKEN = createEntities(EntityRedstoneChicken::new, EntityClassification.MONSTER, "redstone_chicken", ConfigHandler.REDSTONE_CHICKEN_CONFIG);
		MoChickens.SKELETON_CHICKEN = createEntities(EntitySkeletonChicken::new, EntityClassification.MONSTER, "skeleton_chicken", ConfigHandler.SKELETON_CHICKEN_CONFIG);
		MoChickens.SNOW_CHICKEN = createEntities(EntitySnowChicken::new, EntityClassification.MONSTER, "snow_chicken", ConfigHandler.SNOW_CHICKEN_CONFIG);
    }
	
	@SubscribeEvent
	public static void entityRegisters(final RegistryEvent.Register<EntityType<?>> event)
    {
		event.getRegistry().registerAll(
			MoChickens.BEEFY_CHICKEN,
			MoChickens.BLAZING_CHICKEN,
			MoChickens.CLAY_CHICKEN,
			MoChickens.COAL_CHICKEN,
			MoChickens.COOKIE_CHICKEN,
			MoChickens.CREEPER_CHICKEN,
			MoChickens.DIAMOND_CHICKEN,
			MoChickens.EMERALD_CHICKEN,
			MoChickens.ENCHANTED_CHICKEN,
			MoChickens.ENDER_CHICKEN,
			MoChickens.GIANT_CHICKEN,
			MoChickens.GLOWING_CHICKEN,
			MoChickens.GOLD_CHICKEN,
			MoChickens.IRON_CHICKEN,
			MoChickens.LAPIS_CHICKEN,
			MoChickens.NUUW_CHICKEN,
			MoChickens.QUARTZ_CHICKEN,
			MoChickens.RAINBOW_CHICKEN,
			MoChickens.REDSTONE_CHICKEN,
			MoChickens.SKELETON_CHICKEN,
			MoChickens.SNOW_CHICKEN
		);
    }
	
	private static <T extends Entity> EntityType<T> createEntities(EntityType.IFactory<T> entity, EntityClassification classification, String name, ChickenConfigGenerator config) {
		EntityType<T> entityType = null;
		float x;
		float z;
		
		if (config != null) {
			x = config.HIT_BOX_X_SIZE.get();
			z = config.HIT_BOX_Z_SIZE.get();
		} else {
			x = 0.3F;
			z = 0.7F;
		}
		if (config.IMMUNE_TO_FIRE.get()) {
			entityType = EntityType.Builder.create(entity, classification).size(x, z).immuneToFire().build(name);
		} else {
			entityType = EntityType.Builder.create(entity, classification).size(x, z).build(name);
		}
		entityType.setRegistryName(new ResourceLocation(Reference.MOD_ID, name));
		return entityType;
	}
	
}
