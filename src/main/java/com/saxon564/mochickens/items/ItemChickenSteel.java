package com.saxon564.mochickens.items;
//package com.saxon564.mochickens.items;
//
//import com.saxon564.mochickens.MoChickens;
//
//import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.item.Item;
//import net.minecraft.item.ItemStack;
//import net.minecraft.item.ItemUseContext;
//import net.minecraft.util.ActionResultType;
//import net.minecraft.util.Direction;
//import net.minecraft.util.SoundCategory;
//import net.minecraft.util.SoundEvents;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.world.World;
//
//public class ItemLighter extends Item {
//	
//	public ItemLighter(Item.Properties builder)
//    {
//        super(builder);
//    }
//	
//	public ActionResultType onItemUse(ItemUseContext context)
//    {
//		World world = context.getWorld();
//	    PlayerEntity player = context.getPlayer();
//	    Direction facing = context.getFace();
//	    BlockPos blockpos = context.getPos();
//	    blockpos = blockpos.offset(facing);
//        ItemStack itemstack = player.getHeldItem(context.getHand());
//
//        if (!player.canPlayerEdit(blockpos, facing, itemstack))
//        {
//            return ActionResultType.FAIL;
//        }
//        else
//        {
//            if (world.isAirBlock(blockpos))
//            {
//            	world.playSound(player, blockpos, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F, random.nextFloat() * 0.4F + 0.8F);
//            	world.setBlockState(blockpos, MoChickens.CHICKEN_FIRE.getDefaultState(), 11);
//            }
//
//            itemstack.damageItem(1, player, (p_220043_1_) -> {
//                p_220043_1_.sendBreakAnimation(context.getHand());
//             });
//            return ActionResultType.SUCCESS;
//        }
//    }
//}