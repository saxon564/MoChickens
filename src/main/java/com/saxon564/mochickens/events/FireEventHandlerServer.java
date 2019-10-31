//package com.saxon564.mochickens.events;
//
//import net.minecraft.block.Block;
//import net.minecraft.entity.Entity;
//import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.world.World;
//import net.minecraftforge.event.entity.living.LivingEvent;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//
//import com.saxon564.mochickens.MoChickens;
//
//public class FireEventHandlerServer {
//	
//	@SubscribeEvent
//	public void onPlayerMovement(LivingEvent event) {
//		Entity player = event.getEntity();
//		BlockPos pos = player.getPosition();
//		World world = player.world;
//		Block block = world.getBlockState(pos).getBlock();
//		if ((block == MoChickens.CHICKEN_FIRE) || (world.getBlockState(pos.up()).getBlock() == MoChickens.CHICKEN_FIRE)) {
//			if (player.isImmuneToFire()) {
//				
//			} else if ((player instanceof PlayerEntity) && (((PlayerEntity)player).isCreative())) {
//					
//			} else {
//				player.setFire(8);
//			}
//		}
//	}
//
//}
