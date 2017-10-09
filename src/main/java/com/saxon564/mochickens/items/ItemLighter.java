package com.saxon564.mochickens.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
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
	
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        pos = pos.offset(facing);
        ItemStack itemstack = player.getHeldItem(hand);

        if (!player.canPlayerEdit(pos, facing, itemstack))
        {
            return EnumActionResult.FAIL;
        }
        else
        {
            if (worldIn.isAirBlock(pos))
            {
                worldIn.playSound(player, pos, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
                worldIn.setBlockState(pos, MoChickens.chicken_fire.getDefaultState(), 11);
            }

            itemstack.damageItem(1, player);
            return EnumActionResult.SUCCESS;
        }
    }
}