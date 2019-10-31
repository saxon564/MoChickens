package com.saxon564.mochickens.registers;

import com.saxon564.mochickens.MoChickens;
import com.saxon564.mochickens.Reference;
import com.saxon564.mochickens.items.ItemChickenFeather;
import com.saxon564.mochickens.items.ItemDiscStick;
import com.saxon564.mochickens.items.ItemFeatherBlock;
import com.saxon564.mochickens.items.ItemInnerTamingDisc;
//import com.saxon564.mochickens.items.ItemLighter;
import com.saxon564.mochickens.items.ItemRandomEgg;
import com.saxon564.mochickens.items.ItemTamingDisc;

import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class RegisterItems {

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
    	
		event.getRegistry().registerAll(
	    	MoChickens.COAL_DISC_STICK = new ItemDiscStick(new Item.Properties().group(MoChickens.CHICKENS_TAB)).setRegistryName(Reference.MOD_ID, "coal_stick"),
	    	MoChickens.IRON_DISC_STICK = new ItemDiscStick(new Item.Properties().group(MoChickens.CHICKENS_TAB)).setRegistryName(Reference.MOD_ID, "iron_stick"),
	    	MoChickens.GOLD_DISC_STICK = new ItemDiscStick(new Item.Properties().group(MoChickens.CHICKENS_TAB)).setRegistryName(Reference.MOD_ID, "gold_stick"),
	    	MoChickens.LAPIS_DISC_STICK = new ItemDiscStick(new Item.Properties().group(MoChickens.CHICKENS_TAB)).setRegistryName(Reference.MOD_ID, "lapis_stick"),
	    	MoChickens.REDSTONE_DISC_STICK = new ItemDiscStick(new Item.Properties().group(MoChickens.CHICKENS_TAB)).setRegistryName(Reference.MOD_ID, "redstone_stick"),
	    	MoChickens.DIAMOND_DISC_STICK = new ItemDiscStick(new Item.Properties().group(MoChickens.CHICKENS_TAB)).setRegistryName(Reference.MOD_ID, "diamond_stick"),
	    	MoChickens.EMERALD_DISC_STICK = new ItemDiscStick(new Item.Properties().group(MoChickens.CHICKENS_TAB)).setRegistryName(Reference.MOD_ID, "emerald_stick"),
	    	MoChickens.QUARTZ_DISC_STICK = new ItemDiscStick(new Item.Properties().group(MoChickens.CHICKENS_TAB)).setRegistryName(Reference.MOD_ID, "quartz_stick"),
	    	MoChickens.COAL_CHICKEN_FEATHER = new ItemChickenFeather(new Item.Properties().group(MoChickens.CHICKENS_TAB)).setRegistryName(Reference.MOD_ID, "coal_feather"),
	    	MoChickens.IRON_CHICKEN_FEATHER = new ItemChickenFeather(new Item.Properties().group(MoChickens.CHICKENS_TAB)).setRegistryName(Reference.MOD_ID, "iron_feather"),
	    	MoChickens.GOLD_CHICKEN_FEATHER = new ItemChickenFeather(new Item.Properties().group(MoChickens.CHICKENS_TAB)).setRegistryName(Reference.MOD_ID, "gold_feather"),
	    	MoChickens.LAPIS_CHICKEN_FEATHER = new ItemChickenFeather(new Item.Properties().group(MoChickens.CHICKENS_TAB)).setRegistryName(Reference.MOD_ID, "lapis_feather"),
	    	MoChickens.REDSTONE_CHICKEN_FEATHER = new ItemChickenFeather(new Item.Properties().group(MoChickens.CHICKENS_TAB)).setRegistryName(Reference.MOD_ID, "redstone_feather"),
	    	MoChickens.DIAMOND_CHICKEN_FEATHER = new ItemChickenFeather(new Item.Properties().group(MoChickens.CHICKENS_TAB)).setRegistryName(Reference.MOD_ID, "diamond_feather"),
	    	MoChickens.EMERALD_CHICKEN_FEATHER = new ItemChickenFeather(new Item.Properties().group(MoChickens.CHICKENS_TAB)).setRegistryName(Reference.MOD_ID, "emerald_feather"),
	    	MoChickens.QUARTZ_CHICKEN_FEATHER = new ItemChickenFeather(new Item.Properties().group(MoChickens.CHICKENS_TAB)).setRegistryName(Reference.MOD_ID, "quartz_feather"),
	    	MoChickens.TAMING_DISC = new ItemTamingDisc(new Item.Properties().group(MoChickens.CHICKENS_TAB).maxStackSize(16)).setRegistryName(Reference.MOD_ID, "taming_disc"),
	    	MoChickens.INNER_TAMING_DISC = new ItemInnerTamingDisc(new Item.Properties().group(MoChickens.CHICKENS_TAB).maxStackSize(16)).setRegistryName(Reference.MOD_ID, "inner_taming_disc"),
	        MoChickens.RANDOM_EGG = new ItemRandomEgg(new Item.Properties().group(MoChickens.CHICKENS_TAB).maxStackSize(16)).setRegistryName(Reference.MOD_ID, "random_egg"),
//	        MoChickens.CHICKEN_STEEL = new ItemChickenSteel(new Item.Properties().group(MoChickens.CHICKENS_TAB).maxStackSize(1)).setRegistryName(Reference.MOD_ID, "chicken_steel"),
	    	MoChickens.BEEFY_CHICKEN_EGG = generateSpawnEgg(MoChickens.BEEFY_CHICKEN, 0x42361e, 0xd2cfbd, "beefy_chicken").setRegistryName(Reference.MOD_ID, "beefy_chicken_spawn_egg"),
	    	MoChickens.BLAZING_CHICKEN_EGG = generateSpawnEgg(MoChickens.BLAZING_CHICKEN, 0xffcb00, 0x953300, "blazing_chicken").setRegistryName(Reference.MOD_ID, "blazing_chicken_spawn_egg"),
	    	MoChickens.CLAY_CHICKEN_EGG = generateSpawnEgg(MoChickens.CLAY_CHICKEN, 0x878787, 0x000000, "clay_chicken").setRegistryName(Reference.MOD_ID, "clay_chicken_spawn_egg"),
	    	MoChickens.COAL_CHICKEN_EGG = generateSpawnEgg(MoChickens.COAL_CHICKEN, 0x2e2e2e, 0x000000, "coal_chicken").setRegistryName(Reference.MOD_ID, "coal_chicken_spawn_egg"),
	    	MoChickens.COOKIE_CHICKEN_EGG = generateSpawnEgg(MoChickens.COOKIE_CHICKEN, 0xe79042, 0x000000, "cookie_chicken").setRegistryName(Reference.MOD_ID, "cookie_chicken_spawn_egg"),
	    	MoChickens.CREEPER_CHICKEN_EGG = generateSpawnEgg(MoChickens.CREEPER_CHICKEN, 0x85d576, 0x000000, "creeper_chicken").setRegistryName(Reference.MOD_ID, "creeper_chicken_spawn_egg"),
	    	MoChickens.DIAMOND_CHICKEN_EGG = generateSpawnEgg(MoChickens.DIAMOND_CHICKEN, 0xa8e2e2, 0x000000, "diamond_chicken").setRegistryName(Reference.MOD_ID, "diamond_chicken_spawn_egg"),
	    	MoChickens.EMERALD_CHICKEN_EGG = generateSpawnEgg(MoChickens.EMERALD_CHICKEN, 0x06cc01, 0x000000, "emerald_chicken").setRegistryName(Reference.MOD_ID, "emerald_chicken_spawn_egg"),
	    	MoChickens.ENCHANTED_CHICKEN_EGG = generateSpawnEgg(MoChickens.ENCHANTED_CHICKEN, 0xceff1e, 0x50ff18, "enchanted_chicken").setRegistryName(Reference.MOD_ID, "enchanted_chicken_spawn_egg"),
	    	MoChickens.ENDER_CHICKEN_EGG = generateSpawnEgg(MoChickens.ENDER_CHICKEN, 0x000000, 0x797979, "ender_chicken").setRegistryName(Reference.MOD_ID, "ender_chicken_spawn_egg"),
	    	MoChickens.GIANT_CHICKEN_EGG = generateSpawnEgg(MoChickens.GIANT_CHICKEN, 0xe2e2e2, 0x000000, "giant_chicken").setRegistryName(Reference.MOD_ID, "giant_chicken_spawn_egg"),
	    	MoChickens.GLOWING_CHICKEN_EGG = generateSpawnEgg(MoChickens.GLOWING_CHICKEN, 0xf1d808, 0xfffe31, "glowing_chicken").setRegistryName(Reference.MOD_ID, "glowing_chicken_spawn_egg"),
	    	MoChickens.GOLD_CHICKEN_EGG = generateSpawnEgg(MoChickens.GOLD_CHICKEN, 0xccda2b, 0x000000, "gold_chicken").setRegistryName(Reference.MOD_ID, "gold_chicken_spawn_egg"),
	    	MoChickens.IRON_CHICKEN_EGG = generateSpawnEgg(MoChickens.IRON_CHICKEN, 0xd7d0b2, 0x000000, "iron_chicken").setRegistryName(Reference.MOD_ID, "iron_chicken_spawn_egg"),
	    	MoChickens.LAPIS_CHICKEN_EGG = generateSpawnEgg(MoChickens.LAPIS_CHICKEN, 0x4b4bcc, 0x000000, "lapis_chicken").setRegistryName(Reference.MOD_ID, "lapis_chicken_spawn_egg"),
	    	MoChickens.NUUW_CHICKEN_EGG = generateSpawnEgg(MoChickens.NUUW_CHICKEN, 0xbae8e8, 0xb9855c, "nuuw_chicken").setRegistryName(Reference.MOD_ID, "nuuw_chicken_spawn_egg"),
	    	MoChickens.QUARTZ_CHICKEN_EGG = generateSpawnEgg(MoChickens.QUARTZ_CHICKEN, 0x4a0000, 0xdbccbf, "quartz_chicken").setRegistryName(Reference.MOD_ID, "quartz_chicken_spawn_egg"),
	    	MoChickens.RAINBOW_CHICKEN_EGG = generateSpawnEgg(MoChickens.RAINBOW_CHICKEN, 0xff8020, 0x00ffff, "rainbow_chicken").setRegistryName(Reference.MOD_ID, "rainbow_chicken_spawn_egg"),
	    	MoChickens.REDSTONE_CHICKEN_EGG = generateSpawnEgg(MoChickens.REDSTONE_CHICKEN, 0xff6464, 0x000000, "redstone_chicken").setRegistryName(Reference.MOD_ID, "redstone_chicken_spawn_egg"),
	    	MoChickens.SKELETON_CHICKEN_EGG = generateSpawnEgg(MoChickens.SKELETON_CHICKEN, 0xc6c3b6, 0x000000, "skeleton_chicken").setRegistryName(Reference.MOD_ID, "skeleton_chicken_spawn_egg"),
	    	MoChickens.SNOW_CHICKEN_EGG = generateSpawnEgg(MoChickens.SNOW_CHICKEN, 0xFFFFFF, 0x000000, "snow_chicken").setRegistryName(Reference.MOD_ID, "snow_chicken_spawn_egg"),
			MoChickens.FEATHER_BLOCK_ITEM = (ItemFeatherBlock) new ItemFeatherBlock(MoChickens.FEATHER_BLOCK, new Item.Properties().group(MoChickens.CHICKENS_TAB)).setRegistryName(Reference.MOD_ID, "feather_block"),
			MoChickens.REDSTONE_FEATHER_BLOCK_ITEM = (ItemFeatherBlock) new ItemFeatherBlock(MoChickens.REDSTONE_FEATHER_BLOCK, new Item.Properties().group(MoChickens.CHICKENS_TAB)).setRegistryName(Reference.MOD_ID, "redstone_feather_block"),
			MoChickens.COAL_FEATHER_BLOCK_ITEM = (ItemFeatherBlock) new ItemFeatherBlock(MoChickens.COAL_FEATHER_BLOCK, new Item.Properties().group(MoChickens.CHICKENS_TAB)).setRegistryName(Reference.MOD_ID, "coal_feather_block"),
			MoChickens.IRON_FEATHER_BLOCK_ITEM = (ItemFeatherBlock) new ItemFeatherBlock(MoChickens.IRON_FEATHER_BLOCK, new Item.Properties().group(MoChickens.CHICKENS_TAB)).setRegistryName(Reference.MOD_ID, "iron_feather_block"),
			MoChickens.GOLD_FEATHER_BLOCK_ITEM = (ItemFeatherBlock) new ItemFeatherBlock(MoChickens.GOLD_FEATHER_BLOCK, new Item.Properties().group(MoChickens.CHICKENS_TAB)).setRegistryName(Reference.MOD_ID, "gold_feather_block"),
			MoChickens.LAPIS_FEATHER_BLOCK_ITEM = (ItemFeatherBlock) new ItemFeatherBlock(MoChickens.LAPIS_FEATHER_BLOCK, new Item.Properties().group(MoChickens.CHICKENS_TAB)).setRegistryName(Reference.MOD_ID, "lapis_feather_block"),
			MoChickens.DIAMOND_FEATHER_BLOCK_ITEM = (ItemFeatherBlock) new ItemFeatherBlock(MoChickens.DIAMOND_FEATHER_BLOCK, new Item.Properties().group(MoChickens.CHICKENS_TAB)).setRegistryName(Reference.MOD_ID, "diamond_feather_block"),
			MoChickens.EMERALD_FEATHER_BLOCK_ITEM = (ItemFeatherBlock) new ItemFeatherBlock(MoChickens.EMERALD_FEATHER_BLOCK, new Item.Properties().group(MoChickens.CHICKENS_TAB)).setRegistryName(Reference.MOD_ID, "emerald_feather_block"),
			MoChickens.QUARTZ_FEATHER_BLOCK_ITEM = (ItemFeatherBlock) new ItemFeatherBlock(MoChickens.QUARTZ_FEATHER_BLOCK, new Item.Properties().group(MoChickens.CHICKENS_TAB)).setRegistryName(Reference.MOD_ID, "quartz_feather_block")
        );
        
    }
	
	public static Item generateSpawnEgg(EntityType<?> e, int col1, int col2, String name){
        SpawnEggItem egg = new SpawnEggItem(e, col1, col2, new Item.Properties().group(MoChickens.CHICKENS_TAB));
        return egg;
    }
	
}
