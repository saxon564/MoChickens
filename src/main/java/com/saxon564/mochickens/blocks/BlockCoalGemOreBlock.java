package com.saxon564.mochickens.blocks;

import java.util.Random;

import com.saxon564.mochickens.MoChickens;
import com.saxon564.mochickens.MoChickensReference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class BlockCoalGemOreBlock extends Block {
	
	public BlockCoalGemOreBlock() {
		super(Material.rock);
		setCreativeTab(MoChickens.moChickensTab);
		setUnlocalizedName("coal_gem_ore");
		setStepSound(soundTypeStone);
		setHardness(4.0F);
		setHarvestLevel("pickaxe", 3);
	}

}
