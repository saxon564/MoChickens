package com.saxon564.mochickens.registers;

import com.saxon564.mochickens.MoChickens;
import com.saxon564.mochickens.MoChickensReference;
import com.saxon564.mochickens.items.ItemCoalStick;
import com.saxon564.mochickens.items.ItemDiamondStick;
import com.saxon564.mochickens.items.ItemEmeraldStick;
import com.saxon564.mochickens.items.ItemGoldStick;
import com.saxon564.mochickens.items.ItemInnerTamingDisc;
import com.saxon564.mochickens.items.ItemIronStick;
import com.saxon564.mochickens.items.ItemLapisStick;
import com.saxon564.mochickens.items.ItemLighter;
import com.saxon564.mochickens.items.ItemQuartzStick;
import com.saxon564.mochickens.items.ItemRandomEgg;
import com.saxon564.mochickens.items.ItemRedstoneStick;
import com.saxon564.mochickens.items.ItemTamingDisc;

import net.minecraft.item.Item;

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
        MoChickens.chicken_steel = new ItemLighter();
        
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
        RegisterHelper.registerItem(MoChickens.chicken_steel);
        
    }
	
}
