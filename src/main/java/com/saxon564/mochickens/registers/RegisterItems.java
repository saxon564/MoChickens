package com.saxon564.mochickens.registers;

import com.saxon564.mochickens.MoChickens;
import com.saxon564.mochickens.items.ItemChickenFeather;
import com.saxon564.mochickens.items.ItemDiscStick;
import com.saxon564.mochickens.items.ItemInnerTamingDisc;
import com.saxon564.mochickens.items.ItemLighter;
import com.saxon564.mochickens.items.ItemRandomEgg;
import com.saxon564.mochickens.items.ItemTamingDisc;

public class RegisterItems {

	// Add Items
    public static void itemRegisters() {
    	MoChickens.disc_stick = new ItemDiscStick();
    	MoChickens.chicken_feather = new ItemChickenFeather();
    	MoChickens.taming_disc = new ItemTamingDisc();
    	MoChickens.inner_taming_disc = new ItemInnerTamingDisc();
        MoChickens.random_egg = new ItemRandomEgg();
        MoChickens.chicken_steel = new ItemLighter();

        RegisterHelper.registerItem(MoChickens.disc_stick);
        RegisterHelper.registerItem(MoChickens.chicken_feather);
        RegisterHelper.registerItem(MoChickens.taming_disc);
        RegisterHelper.registerItem(MoChickens.inner_taming_disc);
        RegisterHelper.registerItem(MoChickens.random_egg);
        RegisterHelper.registerItem(MoChickens.chicken_steel);
        
    }
	
}
