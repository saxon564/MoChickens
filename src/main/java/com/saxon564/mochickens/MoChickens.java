package com.saxon564.mochickens;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.saxon564.mochickens.configs.ConfigHandler;
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
import com.saxon564.mochickens.configs.txts.ItemFile;
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
import com.saxon564.mochickens.items.ItemFeatherBlock;
import com.saxon564.mochickens.misc.MoChickensCreativeTab;
import com.saxon564.mochickens.proxies.ClientProxyMoChickens;
import com.saxon564.mochickens.proxies.CommonProxyMoChickens;
import com.saxon564.mochickens.proxies.IProxy;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.network.simple.SimpleChannel;


@Mod(Reference.MOD_ID)
public class MoChickens {

	public static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxyMoChickens(), () -> () -> new CommonProxyMoChickens());
	
	public static CommonProxyMoChickens myProxy;

	public static MoChickens instance;
	
	public static EntityType<?>[] egg = new EntityType<?>[500];
	public static Class<?>[] configs = new Class<?>[500];
	public static int eggNum = 0;
	public static Logger CHICKEN_LOGGER = LogManager.getLogger("Mo' Chickens");
	public static SimpleChannel network;
	
	// Initialize Items
	public static Item TAMING_DISC;
	public static Item INNER_TAMING_DISC;
	public static Item RANDOM_EGG;
	public static Item COAL_CHICKEN_FEATHER;
	public static Item IRON_CHICKEN_FEATHER;
	public static Item GOLD_CHICKEN_FEATHER;
	public static Item LAPIS_CHICKEN_FEATHER;
	public static Item REDSTONE_CHICKEN_FEATHER;
	public static Item DIAMOND_CHICKEN_FEATHER;
	public static Item EMERALD_CHICKEN_FEATHER;
	public static Item QUARTZ_CHICKEN_FEATHER;
	
//	public static Item CHICKEN_STEEL;
	public static Item COAL_DISC_STICK;
	public static Item IRON_DISC_STICK;
	public static Item GOLD_DISC_STICK;
	public static Item LAPIS_DISC_STICK;
	public static Item REDSTONE_DISC_STICK;
	public static Item DIAMOND_DISC_STICK;
	public static Item EMERALD_DISC_STICK;
	public static Item QUARTZ_DISC_STICK;
	public static ItemFeatherBlock FEATHER_BLOCK_ITEM;
	public static ItemFeatherBlock COAL_FEATHER_BLOCK_ITEM;
	public static ItemFeatherBlock IRON_FEATHER_BLOCK_ITEM;
	public static ItemFeatherBlock GOLD_FEATHER_BLOCK_ITEM;
	public static ItemFeatherBlock LAPIS_FEATHER_BLOCK_ITEM;
	public static ItemFeatherBlock REDSTONE_FEATHER_BLOCK_ITEM;
	public static ItemFeatherBlock DIAMOND_FEATHER_BLOCK_ITEM;
	public static ItemFeatherBlock EMERALD_FEATHER_BLOCK_ITEM;
	public static ItemFeatherBlock QUARTZ_FEATHER_BLOCK_ITEM;
	public static Item BEEFY_CHICKEN_EGG;
	public static Item BLAZING_CHICKEN_EGG;
	public static Item CLAY_CHICKEN_EGG;
	public static Item COAL_CHICKEN_EGG;
	public static Item COOKIE_CHICKEN_EGG;
	public static Item CREEPER_CHICKEN_EGG;
	public static Item DIAMOND_CHICKEN_EGG;
	public static Item EMERALD_CHICKEN_EGG;
	public static Item ENCHANTED_CHICKEN_EGG;
	public static Item ENDER_CHICKEN_EGG;
	public static Item GIANT_CHICKEN_EGG;
	public static Item GLOWING_CHICKEN_EGG;
	public static Item GOLD_CHICKEN_EGG;
	public static Item IRON_CHICKEN_EGG;
	public static Item LAPIS_CHICKEN_EGG;
	public static Item NUUW_CHICKEN_EGG;
	public static Item QUARTZ_CHICKEN_EGG;
	public static Item RAINBOW_CHICKEN_EGG;
	public static Item REDSTONE_CHICKEN_EGG;
	public static Item SKELETON_CHICKEN_EGG;
	public static Item SNOW_CHICKEN_EGG;
	
	// Initialize Blocks
	//public static Block FETHER_PORTAL;
	public static Block FEATHER_BLOCK;
	public static Block COAL_FEATHER_BLOCK;
	public static Block IRON_FEATHER_BLOCK;
	public static Block GOLD_FEATHER_BLOCK;
	public static Block LAPIS_FEATHER_BLOCK;
	public static Block REDSTONE_FEATHER_BLOCK;
	public static Block DIAMOND_FEATHER_BLOCK;
	public static Block EMERALD_FEATHER_BLOCK;
	public static Block QUARTZ_FEATHER_BLOCK;
	//public static Block COAL_GEM_ORE;
//	public static Block CHICKEN_FIRE;
	
	// Initialize Sounds
	public static SoundEvent DEEP_CLUCK;
	public static SoundEvent GIANT_HURT;
	public static SoundEvent DIAMOND_LAY;
	
	// Initilize Entities
	public static EntityType<EntityBeefyChicken> BEEFY_CHICKEN;
	public static EntityType<EntityBlazingChicken> BLAZING_CHICKEN;
	public static EntityType<EntityClayChicken> CLAY_CHICKEN;
	public static EntityType<EntityCoalChicken> COAL_CHICKEN;
	public static EntityType<EntityCookieChicken> COOKIE_CHICKEN;
	public static EntityType<EntityCreeperChicken> CREEPER_CHICKEN;
	public static EntityType<EntityDiamondChicken> DIAMOND_CHICKEN;
	public static EntityType<EntityEmeraldChicken> EMERALD_CHICKEN;
	public static EntityType<EntityEnchantedChicken> ENCHANTED_CHICKEN;
	public static EntityType<EntityEnderChicken> ENDER_CHICKEN;
	public static EntityType<EntityGiantChicken> GIANT_CHICKEN;
	public static EntityType<EntityGlowingChicken> GLOWING_CHICKEN;
	public static EntityType<EntityGoldChicken> GOLD_CHICKEN;
	public static EntityType<EntityIronChicken> IRON_CHICKEN;
	public static EntityType<EntityLapisChicken> LAPIS_CHICKEN;
	public static EntityType<EntityNuuwChicken> NUUW_CHICKEN;
	public static EntityType<EntityQuartzChicken> QUARTZ_CHICKEN;
	public static EntityType<EntityRainbowChicken> RAINBOW_CHICKEN;
	public static EntityType<EntityRedstoneChicken> REDSTONE_CHICKEN;
	public static EntityType<EntitySkeletonChicken> SKELETON_CHICKEN;
	public static EntityType<EntitySnowChicken> SNOW_CHICKEN;
	
	//Biomes
	//public static BiomeGenChickenForest chicken_forest;
	//public static BiomeGenChickenPlains chicken_plains;

	public static int startEntityId = 300;
	
	public static ItemGroup CHICKENS_TAB = new MoChickensCreativeTab();

	public MoChickens() {
		
//		NetworkHandler.register();
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::interModSetup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::interModProcess);
		MinecraftForge.EVENT_BUS.register(this);

		ConfigHandler.loadConfig();
		
		CHICKEN_LOGGER.warn("Skeleton: " + ConfigHandler.SKELETON_CHICKEN_CONFIG.get("Spawning.Biomes.minecraft_nether.Spawn_Probability"));
		
		registerRandomEgg();
		
	}
	
	public void setup(final FMLCommonSetupEvent event) {
		ItemFile.generateTxtFiles();
	}

	public void clientSetup(final FMLClientSetupEvent event) {
		//network.registerMessage(FireMessage.Handler.class, FireMessage.class, 0, Side.SERVER);
		 

		//RegisterDimensions.dimensionRegisters();
		//RegisterBiomes.biomeRegisters();
		
		//Structures
		//MapGenStructureIO.registerStructure(MapGenChickenVillage.ChickenStart.class, "Chicken_Village");
		//VillageBuildings.registerVillagePieces();
		
		/*if (Loader.isModLoaded(Thaumcraft.id)) {
			loadThaumcraft();
		}*/
		//CraftingRecipes.CraftingRecipieManager();
		//RegisterSpawns.generateBiomeData();
		
		
//		//path = event.getModConfigurationDirectory().toString() + "\\MoChickens";
//		network = NetworkRegistry.newSimpleChannel(new ResourceLocation(Reference.MOD_ID), "MoChickens");
//		//FileManager.PreInit(event);
//		myProxy.eventHandlers();
//		myProxy.registerRenders();
//		myProxy.registerRenders();
//		RegisterSpawns.entitySpawns();
//		RegisterOreDict.AddOres();
//		RegisterSounds.init();
	}
	
	private static void registerRandomEgg() {
		// Register Random Spawn Egg Entries
		randomSpawnEgg(COAL_CHICKEN, CoalChickenConfig.class);
		randomSpawnEgg(IRON_CHICKEN, IronChickenConfig.class);
		randomSpawnEgg(GOLD_CHICKEN, GoldChickenConfig.class);
		randomSpawnEgg(LAPIS_CHICKEN, LapisChickenConfig.class);
		randomSpawnEgg(REDSTONE_CHICKEN, RedstoneChickenConfig.class);
		randomSpawnEgg(DIAMOND_CHICKEN, DiamondChickenConfig.class);
		randomSpawnEgg(EMERALD_CHICKEN, EmeraldChickenConfig.class);
		randomSpawnEgg(QUARTZ_CHICKEN, QuartzChickenConfig.class);
		randomSpawnEgg(GIANT_CHICKEN, GiantChickenConfig.class);
		randomSpawnEgg(CLAY_CHICKEN, ClayChickenConfig.class);
		randomSpawnEgg(RAINBOW_CHICKEN, RainbowChickenConfig.class);
		randomSpawnEgg(SNOW_CHICKEN, SnowChickenConfig.class);
		randomSpawnEgg(COOKIE_CHICKEN, CookieChickenConfig.class);
		randomSpawnEgg(SKELETON_CHICKEN, SkeletonChickenConfig.class);
		randomSpawnEgg(CREEPER_CHICKEN, CreeperChickenConfig.class);
		randomSpawnEgg(ENDER_CHICKEN, EnderChickenConfig.class);
		randomSpawnEgg(BEEFY_CHICKEN, BeefyChickenConfig.class);
		randomSpawnEgg(GLOWING_CHICKEN, GlowingChickenConfig.class);
		randomSpawnEgg(BLAZING_CHICKEN, BlazingChickenConfig.class);
		randomSpawnEgg(ENCHANTED_CHICKEN, EnchantedChickenConfig.class);
		randomSpawnEgg(NUUW_CHICKEN, NuuwChickenConfig.class);
		randomSpawnEgg(EntityType.BAT, null);
		randomSpawnEgg(EntityType.BAT, null);
		randomSpawnEgg(EntityType.BAT, null);
		randomSpawnEgg(EntityType.BAT, null);
		randomSpawnEgg(EntityType.BAT, null);
	}

	public void interModSetup(final InterModEnqueueEvent event) {
		
	}

	public void interModProcess(final InterModProcessEvent event) {
		
	}

	@SubscribeEvent
	public void serverStartup(FMLServerStartingEvent event) {
		
	}
	
	/*@Optional.Method(modid = Thaumcraft.id)
	private void loadThaumcraft() {
		Thaumcraft.addAspects();
	}*/

	public static void randomSpawnEgg(EntityType<?> c, Class<?> class1) {
		egg[eggNum] = c;
		configs[eggNum] = class1;
		eggNum++;
	}
}
