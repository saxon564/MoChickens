package com.saxon564.mochickens.configs.biomes;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.saxon564.mochickens.MoChickens;

public class ChickenPlainsConfig {

	public static Configuration config;
	private static File configFile;
	public static int id;
	
	public static void setId(FMLPreInitializationEvent event) {
		configFile = new File(MoChickens.path, "ChickenPlains.cfg");
		config = new Configuration(configFile);

		id = config.get("Biome Data", "ID", 50).getInt(50);
		config.save();
		
	}
	
}
