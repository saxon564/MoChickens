package com.saxon564.mochickens;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.MapGenVillage;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.saxon564.mochickens.configs.FileManager;
import com.saxon564.mochickens.configs.GeneralConfig;
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
import com.saxon564.mochickens.events.PlayerEventHandler;
import com.saxon564.mochickens.proxies.CommonProxyMoChickens;
import com.saxon564.mochickens.recipes.CraftingRecipes;
import com.saxon564.mochickens.registers.RegisterBiomes;
import com.saxon564.mochickens.registers.RegisterBlocks;
import com.saxon564.mochickens.registers.RegisterChickens;
import com.saxon564.mochickens.registers.RegisterDimensions;
import com.saxon564.mochickens.registers.RegisterEggs;
import com.saxon564.mochickens.registers.RegisterItems;
import com.saxon564.mochickens.registers.RegisterOreDict;
import com.saxon564.mochickens.registers.RegisterSpawns;
import com.saxon564.mochickens.world.dimensions.chicken.structures.MapGenChickenVillage;


@Mod(modid = MoChickensReference.MODID, name = MoChickensReference.MODNAME, version = MoChickensReference.VERSION)
public class MoChickens {
	@SidedProxy(clientSide = "com.saxon564.mochickens.client.ClientProxyMoChickens", serverSide = "com.saxon564.mochickens.proxies.CommonProxyMoChickens")
	public static CommonProxyMoChickens proxy;

	@Instance("mochickens")
	public static MoChickens instance;
	
	public static Class[] egg = new Class[500];
	public static int eggNum = 0;
	public static Configuration[] configs = new Configuration[500];
	public static Logger logger;
	
	// Initialize Items
	public static Item tamingDisc;
	public static Item innerTamingDisc;
	public static Item coalStick;
	public static Item ironStick;
	public static Item goldStick;
	public static Item redstoneStick;
	public static Item lapisStick;
	public static Item diamondStick;
	public static Item emeraldStick;
	public static Item quartzStick;
	public static Item randomEgg;
	public static Item itemRedstoneFeather;
	public static Item itemCoalFeather;
	public static Item itemIronFeather;
	public static Item itemGoldFeather;
	public static Item itemLapisFeather;
	public static Item itemDiamondFeather;
	public static Item itemEmeraldFeather;
	public static Item itemQuartzFeather;
	public static Item itemEnchantedFeather;
	public static Item chickenSteel;
	
	// Initialize Blocks
	public static Block blockFeatherPortal;
	public static Block blockFeatherBlock;
	public static Block blockRedstoneFeatherBlock;
	public static Block blockCoalFeatherBlock;
	public static Block blockIronFeatherBlock;
	public static Block blockGoldFeatherBlock;
	public static Block blockLapisFeatherBlock;
	public static Block blockDiamondFeatherBlock;
	public static Block blockEmeraldFeatherBlock;
	public static Block blockQuartzFeatherBlock;
	public static Block blockEnchantedFeatherBlock;
	public static Block blockMasterFeatherBlock;
	public static Block blockCoalGemOreBlock;
	public static Block blockChickenFire;
	
	public static String path;
	
	//Dimensions
	//public static int chickenDimensionId;
	
	//Biomes
	public static BiomeGenBase biomeChickenForest;
	public static BiomeGenBase biomeChickenPlains;
	//public static int biomeChickenForestId;
	//public static int biomeChickenPlainsId;

	public static int startEntityId = 300;
	
	public static CreativeTabs moChickensTab = new CreativeTabs("MoChickens") {
		public Item getTabIconItem() {
			return Items.egg;
		}
	};

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
		path = event.getModConfigurationDirectory().toString() + "\\MoChickens";
		logger = LogManager.getLogger("Mo' Chickens");
		 
		FileManager.PreInit(event);

		RegisterItems.itemRegisters();
		RegisterBlocks.blockRegisters();
		RegisterChickens.entityRegisters();
		RegisterEggs.EggRegisters();
		RegisterDimensions.dimensionRegisters();
		RegisterBiomes.biomeRegisters();
		proxy.modelExceptions();
		
		//Events
		MinecraftForge.EVENT_BUS.register(new PlayerEventHandler());
		FMLCommonHandler.instance().bus().register(new PlayerEventHandler());
		
		//Structures
		MapGenStructureIO.registerStructure(MapGenChickenVillage.Start.class, "Chicken_Village");
		
		/*if (Loader.isModLoaded(Thaumcraft.id)) {
			loadThaumcraft();
		}
		
		if (Loader.isModLoaded(AdvancedGenetics.id)) {
			loadAG();
		}*/
	}
	
	/*@Optional.Method(modid = Thaumcraft.id)
	private void loadThaumcraft() {
		Thaumcraft.addAspects();
	}
	
	@Optional.Method(modid = AdvancedGenetics.id)
	private void loadAG() {
		AdvancedGenetics.addAbilities();
	}*/

	@EventHandler
	public void load(FMLInitializationEvent event) { 
		CraftingRecipes.CraftingRecipieManager();
		RegisterOreDict.AddOres();
		proxy.registerSounds();
		proxy.registerRenders();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		FileManager.PostInit(event);
		
		//RegisterSpawns.generateBiomeData();
		RegisterSpawns.entitySpawns();
		
		if (GeneralConfig.itemFile) {
		ItemFile.generate(event);
		}
		
		// Register Random Spawn Egg Entries
		randomSpawnEgg(EntityCoalChicken.class, CoalChickenConfig.config);
		randomSpawnEgg(EntityIronChicken.class, IronChickenConfig.config);
		randomSpawnEgg(EntityGoldChicken.class, GoldChickenConfig.config);
		randomSpawnEgg(EntityLapisChicken.class, LapisChickenConfig.config);
		randomSpawnEgg(EntityRedstoneChicken.class, RedstoneChickenConfig.config);
		randomSpawnEgg(EntityDiamondChicken.class, DiamondChickenConfig.config);
		randomSpawnEgg(EntityEmeraldChicken.class, EmeraldChickenConfig.config);
		randomSpawnEgg(EntityQuartzChicken.class, QuartzChickenConfig.config);
		randomSpawnEgg(EntityGiantChicken.class, GiantChickenConfig.config);
		randomSpawnEgg(EntityClayChicken.class, ClayChickenConfig.config);
		randomSpawnEgg(EntityRainbowChicken.class, RainbowChickenConfig.config);
		randomSpawnEgg(EntitySnowChicken.class, SnowChickenConfig.config);
		randomSpawnEgg(EntityCookieChicken.class, CookieChickenConfig.config);
		randomSpawnEgg(EntitySkeletonChicken.class, SkeletonChickenConfig.config);
		randomSpawnEgg(EntityCreeperChicken.class, CreeperChickenConfig.config);
		randomSpawnEgg(EntityEnderChicken.class, EnderChickenConfig.config);
		randomSpawnEgg(EntityBeefyChicken.class, BeefyChickenConfig.config);
		randomSpawnEgg(EntityGlowingChicken.class, GlowingChickenConfig.config);
		randomSpawnEgg(EntityBlazingChicken.class, BlazingChickenConfig.config);
		randomSpawnEgg(EntityEnchantedChicken.class, EnchantedChickenConfig.config);
		randomSpawnEgg(EntityNuuwChicken.class, NuuwChickenConfig.config);
		randomSpawnEgg(EntityBat.class, null);
		randomSpawnEgg(EntityBat.class, null);
		randomSpawnEgg(EntityBat.class, null);
		randomSpawnEgg(EntityBat.class, null);
		randomSpawnEgg(EntityBat.class, null);
	}

	public static void randomSpawnEgg(Class c, Configuration config) {
		egg[eggNum] = c;
		configs[eggNum] = config;
		eggNum++;
	}
}
