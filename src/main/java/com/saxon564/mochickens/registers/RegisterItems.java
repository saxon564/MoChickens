package com.saxon564.mochickens.registers;

import com.saxon564.mochickens.MoChickens;
import com.saxon564.mochickens.enums.EnumHandler.EnumBlockTypes;
import com.saxon564.mochickens.enums.EnumHandler.EnumResourceTypes;
import com.saxon564.mochickens.items.ItemChickenFeather;
import com.saxon564.mochickens.items.ItemDiscStick;
import com.saxon564.mochickens.items.ItemFeatherBlock;
import com.saxon564.mochickens.items.ItemInnerTamingDisc;
import com.saxon564.mochickens.items.ItemLighter;
import com.saxon564.mochickens.items.ItemRandomEgg;
import com.saxon564.mochickens.items.ItemTamingDisc;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityMinecart.Type;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class RegisterItems {

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
    	

    	MoChickens.disc_stick = new ItemDiscStick();
    	MoChickens.chicken_feather = new ItemChickenFeather();
    	MoChickens.taming_disc = new ItemTamingDisc();
    	MoChickens.inner_taming_disc = new ItemInnerTamingDisc();
        MoChickens.random_egg = new ItemRandomEgg();
        MoChickens.chicken_steel = new ItemLighter();
        MoChickens.item_feather_block = new ItemFeatherBlock(MoChickens.feather_block);
    	
    	RegisterHelper.registerItem(event, MoChickens.item_feather_block);
		RegisterHelper.registerItem(event, MoChickens.disc_stick);
    	RegisterHelper.registerItem(event, MoChickens.chicken_feather);
        RegisterHelper.registerItem(event, MoChickens.taming_disc);
        RegisterHelper.registerItem(event, MoChickens.inner_taming_disc);
        RegisterHelper.registerItem(event, MoChickens.random_egg);
        RegisterHelper.registerItem(event, MoChickens.chicken_steel);
        
    }
	
}
