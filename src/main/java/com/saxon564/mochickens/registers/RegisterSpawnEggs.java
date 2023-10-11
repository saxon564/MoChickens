package com.saxon564.mochickens.registers;

import com.saxon564.mochickens.Reference;
import com.saxon564.mochickens.entities.mobs.DiamondChicken;
import com.saxon564.mochickens.registers.collections.MoChickensEntities;
import com.saxon564.mochickens.registers.collections.MoChickensItems;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RegisterSpawnEggs {

	public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Reference.MOD_ID);

	public static void registerSpawnEggs() {
		MoChickensItems.DIAMOND_CHICKEN_SPAWN_EGG = registerEgg("diamond_chicken_spawn_egg", 0xa8e2e2, 0x000000,
				MoChickensEntities.DIAMOND_CHICKEN);
	}

	private static RegistryObject<ForgeSpawnEggItem> registerEgg(String type, int bgColor, int spotColor,
			RegistryObject<EntityType<DiamondChicken>> chicken) {
		return ITEMS.register(type, () -> getEgg(chicken, bgColor, spotColor));
	}

	private static ForgeSpawnEggItem getEgg(RegistryObject<EntityType<DiamondChicken>> chicken, int bgColor, int spotColor) {
		return new ForgeSpawnEggItem(() -> chicken.get(), bgColor, spotColor, new Item.Properties());
	}
}
