package com.saxon564.mochickens.items;

import java.util.List;

import com.saxon564.mochickens.Reference;
import com.saxon564.mochickens.enums.EnumHandler.*;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemFeatherBlock extends ItemBlock {

	public ItemFeatherBlock(Block block) {
		super(block);
		this.setRegistryName(new ResourceLocation(Reference.MOD_ID, "feather_block"));
	    this.setMaxDamage(0);
	    this.setHasSubtypes(true);
	}

	@Override
	public int getMetadata(int metadata)
	{
	  return metadata;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
	  EnumBlockTypes color = EnumBlockTypes.byID(stack.getMetadata());
	  return super.getUnlocalizedName() + "." + color.toString();
	}
	
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs tab, List<ItemStack> subItems) {
		for (EnumBlockTypes types : EnumBlockTypes.values()) {
    		
    		int typeBits = types.getID();
    		int metadata = typeBits;
    		ItemStack subItemStack = new ItemStack(item, 1, metadata);
    		subItems.add(subItemStack);
    		
    	}
	}

}
