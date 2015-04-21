package me.saxon564.mochickens;

import me.saxon564.mochickens.compatability.AdvancedGenetics;
import me.saxon564.mochickens.compatability.Thaumcraft;
import me.saxon564.mochickens.configs.FileManager;
import me.saxon564.mochickens.configs.GeneralConfig;
import me.saxon564.mochickens.configs.chickens.BeefyChickenConfig;
import me.saxon564.mochickens.configs.chickens.BlazingChickenConfig;
import me.saxon564.mochickens.configs.chickens.ClayChickenConfig;
import me.saxon564.mochickens.configs.chickens.CoalChickenConfig;
import me.saxon564.mochickens.configs.chickens.CookieChickenConfig;
import me.saxon564.mochickens.configs.chickens.CreeperChickenConfig;
import me.saxon564.mochickens.configs.chickens.DiamondChickenConfig;
import me.saxon564.mochickens.configs.chickens.EmeraldChickenConfig;
import me.saxon564.mochickens.configs.chickens.EnchantedChickenConfig;
import me.saxon564.mochickens.configs.chickens.EnderChickenConfig;
import me.saxon564.mochickens.configs.chickens.GiantChickenConfig;
import me.saxon564.mochickens.configs.chickens.GlowingChickenConfig;
import me.saxon564.mochickens.configs.chickens.GoldChickenConfig;
import me.saxon564.mochickens.configs.chickens.IronChickenConfig;
import me.saxon564.mochickens.configs.chickens.LapisChickenConfig;
import me.saxon564.mochickens.configs.chickens.NuuwChickenConfig;
import me.saxon564.mochickens.configs.chickens.QuartzChickenConfig;
import me.saxon564.mochickens.configs.chickens.RainbowChickenConfig;
import me.saxon564.mochickens.configs.chickens.RedstoneChickenConfig;
import me.saxon564.mochickens.configs.chickens.SkeletonChickenConfig;
import me.saxon564.mochickens.configs.chickens.SnowChickenConfig;
import me.saxon564.mochickens.configs.txts.ItemFile;
import me.saxon564.mochickens.entities.mobs.EntityBeefyChicken;
import me.saxon564.mochickens.entities.mobs.EntityBlazingChicken;
import me.saxon564.mochickens.entities.mobs.EntityClayChicken;
import me.saxon564.mochickens.entities.mobs.EntityCoalChicken;
import me.saxon564.mochickens.entities.mobs.EntityCookieChicken;
import me.saxon564.mochickens.entities.mobs.EntityCreeperChicken;
import me.saxon564.mochickens.entities.mobs.EntityDiamondChicken;
import me.saxon564.mochickens.entities.mobs.EntityEmeraldChicken;
import me.saxon564.mochickens.entities.mobs.EntityEnchantedChicken;
import me.saxon564.mochickens.entities.mobs.EntityEnderChicken;
import me.saxon564.mochickens.entities.mobs.EntityGiantChicken;
import me.saxon564.mochickens.entities.mobs.EntityGlowingChicken;
import me.saxon564.mochickens.entities.mobs.EntityGoldChicken;
import me.saxon564.mochickens.entities.mobs.EntityIronChicken;
import me.saxon564.mochickens.entities.mobs.EntityLapisChicken;
import me.saxon564.mochickens.entities.mobs.EntityNuuwChicken;
import me.saxon564.mochickens.entities.mobs.EntityQuartzChicken;
import me.saxon564.mochickens.entities.mobs.EntityRainbowChicken;
import me.saxon564.mochickens.entities.mobs.EntityRedstoneChicken;
import me.saxon564.mochickens.entities.mobs.EntitySkeletonChicken;
import me.saxon564.mochickens.entities.mobs.EntitySnowChicken;
import me.saxon564.mochickens.proxies.CommonProxyMoChickens;
import me.saxon564.mochickens.recipes.CraftingRecipes;
import me.saxon564.mochickens.registers.RegisterBlocks;
import me.saxon564.mochickens.registers.RegisterChickens;
import me.saxon564.mochickens.registers.RegisterEggs;
import me.saxon564.mochickens.registers.RegisterItems;
import me.saxon564.mochickens.registers.RegisterOreDict;
import me.saxon564.mochickens.registers.RegisterSpawns;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Optional;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
//import me.saxon564.mochickens.registers.RegisterBiomes;
//import me.saxon564.mochickens.registers.RegisterDimensions;


@Mod(modid = MoChickensReference.MODID, name = MoChickensReference.MODNAME, version = MoChickensReference.VERSION)
public class MoChickens {
	@SidedProxy(clientSide = "me.saxon564.mochickens.client.ClientProxyMoChickens", serverSide = "me.saxon564.mochickens.proxies.CommonProxyMoChickens")
	public static CommonProxyMoChickens proxy;

	@Instance("mochickens")
	public static MoChickens instance;
	
	public static Class[] egg = new Class[500];
	public static int eggNum = 0;
	public static Configuration[] configs = new Configuration[500];
	
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
	public static Item itemLighter;
	
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
	//public static BiomeGenBase biomeChickenForest;
	//public static BiomeGenBase biomeChickenPlains;
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
		
		FileManager.PreInit(event);

		RegisterItems.itemRegisters();
		RegisterBlocks.blockRegisters();
		RegisterChickens.entityRegisters();
		RegisterEggs.EggRegisters();
		//RegisterDimensions.dimensionRegisters();
		//RegisterBiomes.biomeRegisters();
		
		if (Loader.isModLoaded(Thaumcraft.id)) {
			loadThaumcraft();
		}
		
		if (Loader.isModLoaded(AdvancedGenetics.id)) {
			loadAG();
		}
	}
	
	@Optional.Method(modid = Thaumcraft.id)
	private void loadThaumcraft() {
		Thaumcraft.addAspects();
	}
	
	@Optional.Method(modid = AdvancedGenetics.id)
	private void loadAG() {
		AdvancedGenetics.addAbilities();
	}

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
