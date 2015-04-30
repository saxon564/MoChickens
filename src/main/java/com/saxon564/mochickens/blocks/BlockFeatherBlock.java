package com.saxon564.mochickens.blocks;

import com.saxon564.mochickens.MoChickens;
import com.saxon564.mochickens.MoChickensReference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockFeatherBlock extends Block {
	
	public BlockFeatherBlock() {
		
		super(Material.cloth);
		setCreativeTab(MoChickens.moChickensTab);
		setUnlocalizedName("feather_block");
		setStepSound(soundTypeCloth);
	}

}
