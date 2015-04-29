package com.saxon564.mochickens.items;

import net.minecraft.item.Item;

import com.saxon564.mochickens.MoChickens;

public class ItemInnerTamingDisc extends Item
{
    public ItemInnerTamingDisc()
    {
        super();
        setMaxStackSize(16);
        setCreativeTab(MoChickens.moChickensTab);
        setUnlocalizedName("inner_taming_disc");
        //setTextureName(MoChickensReference.MODID + ":"
		//		+ getUnlocalizedName().substring(5));
    }
}
