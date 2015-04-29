package com.saxon564.mochickens.items;

import net.minecraft.item.Item;

import com.saxon564.mochickens.MoChickens;

public class ItemGoldStick extends Item
{
    public ItemGoldStick()
    {
        super();
        setMaxStackSize(64);
        setCreativeTab(MoChickens.moChickensTab);
        setUnlocalizedName("gold_stick");
        //setTextureName(MoChickensReference.MODID + ":"
		//		+ getUnlocalizedName().substring(5));
    }
}
