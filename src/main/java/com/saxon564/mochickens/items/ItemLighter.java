package com.saxon564.mochickens.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

import com.saxon564.mochickens.MoChickens;
import com.saxon564.mochickens.Reference;

public class ItemLighter extends Item {
	
	public ItemLighter()
    {
        super();
        setCreativeTab(MoChickens.moChickensTab);
        this.setRegistryName(new ResourceLocation(Reference.MOD_ID, "chicken_steel"));
        setUnlocalizedName("chicken_steel");
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
                worldIn.playSound(playerIn, (double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.MASTER, 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
                worldIn.setBlockState(pos, MoChickens.chicken_fire.getDefaultState());
            }

            stack.damageItem(1, playerIn);
            return true;
        }
    }
}