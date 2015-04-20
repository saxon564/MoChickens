package me.saxon564.mochickens.blocks;

import java.util.Random;

import me.saxon564.mochickens.MoChickens;
import me.saxon564.mochickens.MoChickensReference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class BlockCoalGemOreBlock extends Block {
	
	public BlockCoalGemOreBlock() {
		
		super(Material.rock);
		//setCreativeTab(MoChickens.moChickensTab);
		setBlockName("coal_gem_ore");
		setBlockTextureName(MoChickensReference.MODID + ":" + getUnlocalizedName().substring(5));
		this.setStepSound(soundTypeStone);
		this.setHardness(4.0F);
		this.setHarvestLevel("pickaxe", 3);
	}

}
