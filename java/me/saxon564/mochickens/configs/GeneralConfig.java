package me.saxon564.mochickens.configs;

import java.io.File;

import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

import net.minecraftforge.common.config.Configuration;
import me.saxon564.mochickens.MoChickens;

public class GeneralConfig {
	
	public static boolean debug;
	public static boolean itemFile;
	public static Configuration generalConfig;
	private static File generalConfigFile;
	
	public static void setConfigs(FMLPostInitializationEvent event) {

		generalConfigFile = new File(MoChickens.path, "MoChickens.cfg");
		generalConfig = new Configuration(generalConfigFile);
		
		generalConfig.setCategoryComment("debug", "Caution: Turning this true will cause console spam, and lag the game." + generalConfig.NEW_LINE + "Should be true if blacklisting spawn biomes for chickens");
		debug = generalConfig.get("debug", "Debug Mode", false).getBoolean(false);
		
		generalConfig.setCategoryComment("item file", "Should a file be crated with a list of all the items in the game?" + generalConfig.NEW_LINE + "NOTE: This does NOT factor in data values. e.g. you will not see bonemeal or lapis lazuli on this list, but you will see \"minecraft:dye\" as they are dyes.");
		itemFile = generalConfig.get("item file", "Generate Item List", false).getBoolean(false);
		
		generalConfig.save();
		
	}

}
