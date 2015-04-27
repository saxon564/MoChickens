package com.saxon564.mochickens.items;

import com.saxon564.mochickens.MoChickens;
import com.saxon564.mochickens.MoChickensReference;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

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
