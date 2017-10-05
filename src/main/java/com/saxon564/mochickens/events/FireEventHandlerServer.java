package com.saxon564.mochickens.events;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.saxon564.mochickens.MoChickens;

public class FireEventHandlerServer {
	
	@SubscribeEvent
	public void onPlayerMovement(LivingEvent event) {
		Entity player = event.getEntity();
		BlockPos pos = player.getPosition();
		World world = player.world;
		Block block = world.getBlockState(pos).getBlock();
		if ((block == MoChickens.chicken_fire) || (world.getBlockState(pos.up()).getBlock() == MoChickens.chicken_fire)) {
			if (player.isImmuneToFire()) {
				
			} else if ((player instanceof EntityPlayer) && (((EntityPlayer)player).capabilities.isCreativeMode)) {
					
			} else {
				player.setFire(8);
			}
		}
	}

}
