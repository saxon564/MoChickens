package com.saxon564.mochickens.registers;

import com.saxon564.mochickens.MoChickens;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class RegisterOreDict {
	
	public static void AddOres() {
		OreDictionary.registerOre("stickCoal", new ItemStack(MoChickens.disc_stick, 2, 0));
		OreDictionary.registerOre("stickIron", new ItemStack(MoChickens.disc_stick, 2, 1));
		OreDictionary.registerOre("stickGold", new ItemStack(MoChickens.disc_stick, 2, 2));
		OreDictionary.registerOre("stickRedstone", new ItemStack(MoChickens.disc_stick, 2, 3));
		OreDictionary.registerOre("stickLapis", new ItemStack(MoChickens.disc_stick, 2, 4));
		OreDictionary.registerOre("stickDiamond", new ItemStack(MoChickens.disc_stick, 2, 5));
		OreDictionary.registerOre("stickEmerald", new ItemStack(MoChickens.disc_stick, 2, 6));
		OreDictionary.registerOre("stickQuartz", new ItemStack(MoChickens.disc_stick, 2, 7));
	}

}
