package me.saxon564.mochickens.registers;

import net.minecraft.item.Item;
import me.saxon564.mochickens.MoChickens;
import me.saxon564.mochickens.MoChickensReference;
import me.saxon564.mochickens.items.ItemCoalStick;
import me.saxon564.mochickens.items.ItemDiamondStick;
import me.saxon564.mochickens.items.ItemEmeraldStick;
import me.saxon564.mochickens.items.ItemGoldStick;
import me.saxon564.mochickens.items.ItemInnerTamingDisc;
import me.saxon564.mochickens.items.ItemIronStick;
import me.saxon564.mochickens.items.ItemLapisStick;
import me.saxon564.mochickens.items.ItemLighter;
import me.saxon564.mochickens.items.ItemQuartzStick;
import me.saxon564.mochickens.items.ItemRandomEgg;
import me.saxon564.mochickens.items.ItemRedstoneStick;
import me.saxon564.mochickens.items.ItemTamingDisc;

public class RegisterItems {

	// Add Items
    public static void itemRegisters() {
    	MoChickens.tamingDisc = new ItemTamingDisc();
    	MoChickens.innerTamingDisc = new ItemInnerTamingDisc();
    	MoChickens.coalStick = new ItemCoalStick();
    	MoChickens.ironStick = new ItemIronStick();
        MoChickens.goldStick = new ItemGoldStick();
        MoChickens.redstoneStick = new ItemRedstoneStick();
        MoChickens.lapisStick = new ItemLapisStick();
        MoChickens.diamondStick = new ItemDiamondStick();
        MoChickens.emeraldStick = new ItemEmeraldStick();
        MoChickens.quartzStick = new ItemQuartzStick();
        MoChickens.randomEgg = new ItemRandomEgg();
        //MoChickens.itemLighter = new ItemLighter();
        
        RegisterHelper.registerItem(MoChickens.tamingDisc);
        RegisterHelper.registerItem(MoChickens.innerTamingDisc);
        RegisterHelper.registerItem(MoChickens.coalStick);
        RegisterHelper.registerItem(MoChickens.ironStick);
        RegisterHelper.registerItem(MoChickens.goldStick);
        RegisterHelper.registerItem(MoChickens.redstoneStick);
        RegisterHelper.registerItem(MoChickens.lapisStick);
        RegisterHelper.registerItem(MoChickens.diamondStick);
        RegisterHelper.registerItem(MoChickens.emeraldStick);
        RegisterHelper.registerItem(MoChickens.quartzStick);
        RegisterHelper.registerItem(MoChickens.randomEgg);
        //RegisterHelper.registerItem(MoChickens.itemLighter);
        
    }
	
}
