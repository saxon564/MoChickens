package com.saxon564.mochickens.items;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.saxon564.mochickens.MoChickens;
import com.saxon564.mochickens.enums.EnumResourceTypes;

public class ItemDiscStick extends Item
{
    public ItemDiscStick()
    {
        super();
        setMaxStackSize(64);
        setCreativeTab(MoChickens.moChickensTab);
        setUnlocalizedName("disc_stick");
        setHasSubtypes(true);
    }
    
    @Override
    public int getMetadata(int damage) {
    	return damage;
    }
    
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs tab, List subItems) {
    	
    	for (EnumResourceTypes types : EnumResourceTypes.values()) {
    		
    		int typeBits = types.getMetadata();
    		int metadata = typeBits;
    		ItemStack subItemStack = new ItemStack(item, 1, metadata);
    		subItems.add(subItemStack);
    		
    	}
    	
    }
    
    @Override
    public String getUnlocalizedName(ItemStack stack) {
    	int metadata = stack.getMetadata();
    	int typeBits = metadata;
    	
    	EnumResourceTypes type = EnumResourceTypes.byMetadata(typeBits);
    	return super.getUnlocalizedName() + "." + type.getName();
    }
    
    @Override
    public String getItemStackDisplayName(ItemStack stack) {
    	
    	String s = ("" + StatCollector.translateToLocal(this.getUnlocalizedName(stack) + ".name")).trim();
    	
    	return s;
    }
}
