package me.saxon564.mochickens.registers;

import me.saxon564.mochickens.MoChickens;
import cpw.mods.fml.common.registry.GameRegistry;

public class RegisterGameInfo {

	public static void GameRegisters()
    {
        GameRegistry.registerItem(MoChickens.tamingDisc, "tamingDisc");
        GameRegistry.registerItem(MoChickens.innerTamingDisc, "innerTamingDisc");
        GameRegistry.registerItem(MoChickens.coalStick, "coalStick");
        GameRegistry.registerItem(MoChickens.ironStick, "ironStick");
        GameRegistry.registerItem(MoChickens.goldStick, "goldStick");
        GameRegistry.registerItem(MoChickens.redstoneStick, "redstoneStick");
        GameRegistry.registerItem(MoChickens.lapisStick, "lapisStick");
        GameRegistry.registerItem(MoChickens.diamondStick, "diamondStick");
        GameRegistry.registerItem(MoChickens.emeraldStick, "emeraldStick");
        GameRegistry.registerItem(MoChickens.quartzStick, "quartzStick");
        GameRegistry.registerItem(MoChickens.randomEgg, "randomEgg");
    }
	
}
