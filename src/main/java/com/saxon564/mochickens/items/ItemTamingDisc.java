package com.saxon564.mochickens.items;

import net.minecraft.item.Item;

import com.saxon564.mochickens.MoChickens;

public class ItemTamingDisc extends Item
{
    public ItemTamingDisc()
    {
        super();
        setMaxStackSize(16);
        setCreativeTab(MoChickens.moChickensTab);
        setUnlocalizedName("taming_disc");
        //setTextureName(MoChickensReference.MODID + ":"
		//		+ getUnlocalizedName().substring(5));
    }
}
