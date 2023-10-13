package com.saxon564.mochickens.registers;

import com.saxon564.mochickens.Reference;
import com.saxon564.mochickens.configs.ConfigHandler;
import com.saxon564.mochickens.entities.mobs.DiamondChicken;
import com.saxon564.mochickens.entities.mobs.MoChicken;
import com.saxon564.mochickens.registers.collections.MoChickensEntities;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityType.EntityFactory;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegisterChickens {

	public static final DeferredRegister<EntityType<?>> ENTITY_TYPE = DeferredRegister
			.create(ForgeRegistries.ENTITY_TYPES, Reference.MOD_ID);

	@SuppressWarnings("unchecked")
	public static void registerEntities() {
		MoChickensEntities.DIAMOND_CHICKEN = (RegistryObject<EntityType<DiamondChicken>>) registerChicken(
				DiamondChicken::new, "diamond_chicken", ConfigHandler.DIAMOND_CHICKEN_CONFIG.HIT_BOX_X_SIZE.get(), ConfigHandler.DIAMOND_CHICKEN_CONFIG.HIT_BOX_Z_SIZE.get());
	}

	private static <T extends MoChicken> RegistryObject<?> registerChicken(EntityFactory<T> chicken, String type,
			float sizeX, float sizeZ) {
		return ENTITY_TYPE.register(type, () -> getEntity(chicken, sizeX, sizeZ, type));
	}

	private static <T extends MoChicken> EntityType<? extends MoChicken> getEntity(EntityFactory<T> chicken,
			float sizeX, float sizeZ, String type) {
		return (EntityType<? extends MoChicken>) EntityType.Builder.<T>of(chicken, MobCategory.MISC).sized(sizeX, sizeZ)
				.clientTrackingRange(4).updateInterval(1)
				.build(new ResourceLocation(Reference.MOD_ID, type).toString());
	}

	/*
	 * public static void createChickens() { MoChickens.BEEFY_CHICKEN =
	 * createEntities(EntityBeefyChicken::new, EntityType.MONSTER, "beefy_chicken",
	 * ConfigHandler.BEEFY_CHICKEN_CONFIG);
	 * 
	 * }
	 * 
	 * @SubscribeEvent public static void entityRegisters(final
	 * RegistryEvent.Register<EntityType<?>> event) {
	 * event.getRegistry().registerAll( MoChickens.BEEFY_CHICKEN ); }
	 * 
	 * private static <T extends Entity> EntityType<T>
	 * createEntities(EntityType.IFactory<T> entity, EntityClassification
	 * classification, String name, ChickenConfigGenerator config) { EntityType<T>
	 * entityType = null; float x; float z;
	 * 
	 * if (config != null) { x = config.HIT_BOX_X_SIZE.get(); z =
	 * config.HIT_BOX_Z_SIZE.get(); } else { x = 0.3F; z = 0.7F; } if
	 * (config.IMMUNE_TO_FIRE.get()) { entityType =
	 * EntityType.Builder.create(entity, classification).size(x,
	 * z).immuneToFire().build(name); } else { entityType =
	 * EntityType.Builder.create(entity, classification).size(x, z).build(name); }
	 * entityType.setRegistryName(new ResourceLocation(Reference.MOD_ID, name));
	 * return entityType; }
	 */

}
