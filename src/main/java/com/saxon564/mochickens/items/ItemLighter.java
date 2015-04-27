package com.saxon564.mochickens.items;

import com.saxon564.mochickens.MoChickens;
import com.saxon564.mochickens.MoChickensReference;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class ItemLighter extends Item {
	
	public ItemLighter()
    {
        super();
        setCreativeTab(MoChickens.moChickensTab);
        setUnlocalizedName("lighter");
        //setTextureName(MoChickensReference.MODID + ":"
		//		+ getUnlocalizedName().substring(5));
        this.maxStackSize = 1;
        this.setMaxDamage(56);
    }
	
	public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        pos = pos.offset(side);

        if (!playerIn.canPlayerEdit(pos, side, stack))
        {
            return false;
        }
        else
        {
            if (worldIn.isAirBlock(pos))
            {
                worldIn.playSoundEffect((double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, "fire.ignite", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
                worldIn.setBlockState(pos, MoChickens.blockChickenFire.getDefaultState());
            }

            stack.damageItem(1, playerIn);
            return true;
        }
    }
	
}
