package com.saxon564.mochickens.items;

import java.util.List;

import com.saxon564.mochickens.Reference;
import com.saxon564.mochickens.enums.EnumHandler.*;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
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
    	int metadata = stack.getMetadata();
    	int typeBits = metadata;
    	
    	EnumBlockTypes type = EnumBlockTypes.byID(typeBits);
    	return super.getUnlocalizedName(stack) + "." + type.getName();
	}
	
	@SideOnly(Side.CLIENT)
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		for (EnumBlockTypes types : EnumBlockTypes.values()) {
    		
			if (this.isInCreativeTab(tab)) {
	    		int typeBits = types.getID();
	    		int metadata = typeBits;
	    		ItemStack subItemStack = new ItemStack(this, 1, metadata);
	    		items.add(subItemStack);
    		}
    		
    	}
	}

}
