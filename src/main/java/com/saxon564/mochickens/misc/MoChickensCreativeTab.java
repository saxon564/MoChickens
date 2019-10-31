package com.saxon564.mochickens.misc;

import com.saxon564.mochickens.MoChickens;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class MoChickensCreativeTab extends ItemGroup {

	public MoChickensCreativeTab() {
		super("mo_chickens");
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(MoChickens.TAMING_DISC);
	}

}
