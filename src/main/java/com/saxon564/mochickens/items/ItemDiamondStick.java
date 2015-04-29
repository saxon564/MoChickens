package com.saxon564.mochickens.items;

import net.minecraft.item.Item;

import com.saxon564.mochickens.MoChickens;

public class ItemDiamondStick extends Item
{
    public ItemDiamondStick()
    {
        super();
        setMaxStackSize(64);
        setCreativeTab(MoChickens.moChickensTab);
        setUnlocalizedName("diamond_stick");
        //setTextureName(MoChickensReference.MODID + ":"
		//		+ getUnlocalizedName().substring(5));
    }
}
