package me.saxon564.mochickens.registers;

import me.saxon564.mochickens.MoChickens;
import net.minecraftforge.oredict.OreDictionary;

public class RegisterOreDict {
	
	public static void AddOres() {
		OreDictionary.registerOre("stickCoal", MoChickens.coalStick);
		OreDictionary.registerOre("stickIron", MoChickens.ironStick);
		OreDictionary.registerOre("stickGold", MoChickens.goldStick);
		OreDictionary.registerOre("stickRedstone", MoChickens.redstoneStick);
		OreDictionary.registerOre("stickLapis", MoChickens.lapisStick);
		OreDictionary.registerOre("stickDiamond", MoChickens.diamondStick);
		OreDictionary.registerOre("stickEmerald", MoChickens.emeraldStick);
		OreDictionary.registerOre("stickQuartz", MoChickens.quartzStick);
	}

}
