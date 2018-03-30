package com.saxon564.mochickens.configs;

import java.io.File;

import com.saxon564.mochickens.MoChickens;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class DimensionConfigs {

	public static Configuration config;
	private static File configFile;
	public static int chickenDimId;
	
	public static void setId(FMLPreInitializationEvent event) {
		configFile = new File(MoChickens.path, "Dimensions.cfg");
		config = new Configuration(configFile);

		chickenDimId = config.get("chicken dimension", "ID", 20).getInt(20);
		config.save();
		
	}

}
