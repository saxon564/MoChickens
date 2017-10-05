package com.saxon564.mochickens.items;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import com.saxon564.mochickens.MoChickens;
import com.saxon564.mochickens.Reference;

public class ItemTamingDisc extends Item
{
    public ItemTamingDisc()
    {
        super();
        setMaxStackSize(16);
        setCreativeTab(MoChickens.moChickensTab);
        setRegistryName(new ResourceLocation(Reference.MOD_ID, "taming_disc"));
        setUnlocalizedName("taming_disc");
    }
}
