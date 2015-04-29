package com.saxon564.mochickens.items;

import net.minecraft.item.Item;

import com.saxon564.mochickens.MoChickens;

public class ItemEmeraldStick extends Item
{
    public ItemEmeraldStick()
    {
        super();
        setMaxStackSize(64);
        setCreativeTab(MoChickens.moChickensTab);
        setUnlocalizedName("emerald_stick");
        //setTextureName(MoChickensReference.MODID + ":"
		//		+ getUnlocalizedName().substring(5));
    }
}
