package com.saxon564.mochickens.registers;

import com.saxon564.mochickens.Reference;
import com.saxon564.mochickens.enums.EnumHandler.EnumResourceTypes;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.DimensionType;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RegisterHelper {

	public static void registerBlock(RegistryEvent.Register<Block> event, Block block) {
		event.getRegistry().register(block);
	}
	
	public static void registerItem (RegistryEvent.Register<Item> event, Item item) {
		event.getRegistry().register(item);
	}
	
	public static void registerDimension(int id, Class provider, boolean loaded) {
		DimensionType.register("chicken", "_chicken", id, provider, loaded);
		DimensionManager.registerDimension(id, DimensionType.valueOf("chicken"));
	}
	
	public static void registerBiome(Biome biome, boolean canSpawn) {
		BiomeManager.addSpawnBiome(biome);
		registerVillageBiome(biome, canSpawn);
	}
	
	public static void registerVillageBiome(Biome biome, boolean canSpawn) {
		BiomeManager.addVillageBiome(biome, canSpawn);
	}
	
	public static void registerItemRenders(Item item, int meta, String name) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(Reference.MOD_ID + ":" + name, "inventory"));	
	}
	
}
