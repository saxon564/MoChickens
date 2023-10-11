package com.saxon564.mochickens.registers;

import com.saxon564.mochickens.registers.collections.MoChickensItems;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

public class RegisterCreativeItems {

	public static void addCreative(BuildCreativeModeTabContentsEvent event) {
		if (event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			event.accept(MoChickensItems.DIAMOND_CHICKEN_SPAWN_EGG);
		}
	}

}
