package com.saxon564.mochickens.registers;

import com.saxon564.mochickens.MoChickensReference;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RegisterHelper {

	public static void registerBlock(Block block) {
		GameRegistry.registerBlock(block, block.getUnlocalizedName().substring(5));
	}
	
	public static void registerItem (Item item) {
		GameRegistry.registerItem(item, item.getUnlocalizedName().substring(5));
	}
	
	public static void registerDimension(int id, Class provider, boolean loaded) {
		DimensionManager.registerProviderType(id, provider, loaded);
		DimensionManager.registerDimension(id, id);
	}
	
	public static void registerBiome(BiomeGenBase biome, boolean canSpawn) {
		BiomeManager.addSpawnBiome(biome);
		registerVillageBiome(biome, canSpawn);
	}
	
	public static void registerVillageBiome(BiomeGenBase biome, boolean canSpawn) {
		BiomeManager.addVillageBiome(biome, canSpawn);
	}
	
	public static void registerItemRenders(Item item, int meta, String name) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, new ModelResourceLocation(MoChickensReference.MODID + ":" + name, "inventory"));	
	}
	
}
