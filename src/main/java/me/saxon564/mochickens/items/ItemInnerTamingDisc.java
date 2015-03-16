package me.saxon564.mochickens.items;

import me.saxon564.mochickens.MoChickens;
import me.saxon564.mochickens.MoChickensReference;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemInnerTamingDisc extends Item
{
    public ItemInnerTamingDisc()
    {
        super();
        setMaxStackSize(16);
        setCreativeTab(MoChickens.moChickensTab);
        setUnlocalizedName("inner_taming_disc");
        setTextureName(MoChickensReference.MODID + ":"
				+ getUnlocalizedName().substring(5));
    }
}
