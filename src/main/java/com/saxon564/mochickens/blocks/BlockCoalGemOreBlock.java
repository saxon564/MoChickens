package com.saxon564.mochickens.blocks;

import java.util.Random;

import com.saxon564.mochickens.MoChickens;
import com.saxon564.mochickens.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class BlockCoalGemOreBlock extends Block {
	
	public BlockCoalGemOreBlock() {
		super(Material.ROCK);
		setCreativeTab(MoChickens.moChickensTab);
        this.setRegistryName(new ResourceLocation(Reference.MOD_ID, "coal_gem_ore"));
		setUnlocalizedName("coal_gem_ore");
		setSoundType(SoundType.STONE);
		setHardness(4.0F);
		setHarvestLevel("pickaxe", 3);
	}

}
