package com.saxon564.mochickens.configs;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

import com.saxon564.mochickens.MoChickens;

public class GeneralConfig {
	
	public static boolean debug;
	public static boolean itemFile;
	public static boolean biomeFile;
	public static boolean soundFile;
	public static boolean particleFile;
	public static Configuration generalConfig;
	private static File generalConfigFile;
	
	public static void setConfigs(FMLPostInitializationEvent event) {

		generalConfigFile = new File(MoChickens.path, "MoChickens.cfg");
		generalConfig = new Configuration(generalConfigFile);
		
		generalConfig.setCategoryComment("debug", "Caution: Turning this true will cause console spam, and lag the game.");
		debug = generalConfig.get("debug", "Debug Mode", false).getBoolean(false);
		
		generalConfig.setCategoryComment("list files", "Should a file be created with a list of all the items/biomes/sounds/particles in the game?" + generalConfig.NEW_LINE + "NOTE: This does NOT factor in data values. e.g. you will not see bonemeal or lapis lazuli on this list, but you will see \"minecraft:dye\" as they are dyes.");
		itemFile = generalConfig.get("list files", "Generate Item List", false).getBoolean(false);
		biomeFile = generalConfig.get("list files", "Generate Biome List", false).getBoolean(false);
		soundFile = generalConfig.get("list files", "Generate Sound List", false).getBoolean(false);
		particleFile = generalConfig.get("list files", "Generate Particle List", false).getBoolean(false);
		
		generalConfig.save();
		
	}

}
