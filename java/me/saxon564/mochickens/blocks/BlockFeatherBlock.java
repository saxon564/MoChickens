package me.saxon564.mochickens.blocks;

import me.saxon564.mochickens.MoChickens;
import me.saxon564.mochickens.MoChickensReference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockFeatherBlock extends Block {
	
	public BlockFeatherBlock() {
		
		super(Material.cloth);
		setCreativeTab(MoChickens.moChickensTab);
		setBlockName("feather_block");
		setBlockTextureName(MoChickensReference.MODID + ":" + getUnlocalizedName().substring(5));
		this.setStepSound(soundTypeCloth);
	}

}
