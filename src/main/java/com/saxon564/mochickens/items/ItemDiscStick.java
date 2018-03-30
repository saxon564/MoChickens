package com.saxon564.mochickens.items;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.saxon564.mochickens.MoChickens;
import com.saxon564.mochickens.Reference;
import com.saxon564.mochickens.enums.EnumHandler.*;

public class ItemDiscStick extends Item
{
    public ItemDiscStick()
    {
        super();
        setMaxStackSize(64);
        setCreativeTab(MoChickens.moChickensTab);
        this.setRegistryName(new ResourceLocation(Reference.MOD_ID, "disc_stick"));
        setUnlocalizedName("disc_stick");
        setHasSubtypes(true);
    }
    
    @Override
    public int getMetadata(int damage) {
    	return damage;
    }
    
    @SideOnly(Side.CLIENT)
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
    	
    	for (EnumResourceTypes types : EnumResourceTypes.values()) {
    		
    		if (this.isInCreativeTab(tab)) {
	    		int typeBits = types.getID();
	    		int metadata = typeBits;
	    		ItemStack subItemStack = new ItemStack(this, 1, metadata);
	    		items.add(subItemStack);
    		}
    		
    	}
    	
    }
    
    @Override
    public String getUnlocalizedName(ItemStack stack) {
    	int metadata = stack.getMetadata();
    	int typeBits = metadata;
    	
    	EnumResourceTypes type = EnumResourceTypes.byID(typeBits);
    	return super.getUnlocalizedName() + "." + type.getName();
    }
    
    @Override
    public String getItemStackDisplayName(ItemStack stack) {
    	
    	String s = ("" + I18n.translateToLocal(this.getUnlocalizedName(stack) + ".name")).trim();
    	
    	return s;
    }
}
