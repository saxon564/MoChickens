package me.saxon564.mochickens.items;

import me.saxon564.mochickens.MoChickens;
import me.saxon564.mochickens.MoChickensReference;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemIronStick extends Item
{
    public ItemIronStick()
    {
        super();
        setMaxStackSize(64);
        setCreativeTab(MoChickens.moChickensTab);
        setUnlocalizedName("iron_stick");
        setTextureName(MoChickensReference.MODID + ":"
				+ getUnlocalizedName().substring(5));
    }
}