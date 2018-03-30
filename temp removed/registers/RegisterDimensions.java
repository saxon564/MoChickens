package com.saxon564.mochickens.registers;

import com.saxon564.mochickens.MoChickens;
import com.saxon564.mochickens.configs.DimensionConfigs;
import com.saxon564.mochickens.world.dimensions.chicken.WorldProviderChickenDimension;

public class RegisterDimensions {
	
	public static void dimensionRegisters() {
		RegisterHelper.registerDimension(DimensionConfigs.chickenDimId, WorldProviderChickenDimension.class, false);
	}
	
}
