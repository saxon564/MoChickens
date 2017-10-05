package com.saxon564.mochickens.items;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import com.saxon564.mochickens.MoChickens;
import com.saxon564.mochickens.Reference;

public class ItemInnerTamingDisc extends Item
{
    public ItemInnerTamingDisc()
    {
        super();
        setMaxStackSize(16);
        setCreativeTab(MoChickens.moChickensTab);
        this.setRegistryName(new ResourceLocation(Reference.MOD_ID, "inner_taming_disc"));
        setUnlocalizedName("inner_taming_disc");
        //setTextureName(MoChickensReference.MODID + ":"
		//		+ getUnlocalizedName().substring(5));
    }
}
