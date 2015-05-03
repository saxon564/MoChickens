package com.saxon564.mochickens.events;

import com.saxon564.mochickens.MoChickens;
import com.saxon564.mochickens.network.FireMessage;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class PlayerEventHandler {

	@SubscribeEvent
	public void onMouseEvent(MouseEvent event) {
		int button = event.button;
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		World world = Minecraft.getMinecraft().theWorld;
		
		BlockPos pos = Minecraft.getMinecraft().objectMouseOver.getBlockPos();
		EnumFacing face = Minecraft.getMinecraft().objectMouseOver.sideHit;
		
		if (button == 0) {
			if (world.getBlockState(pos).getBlock()!= null) {
				this.extinguishFire(player, pos, face, world, event);
			}
		}
	}
	
	@SubscribeEvent
	public void onPlayerMovement(PlayerTickEvent event) {
		EntityPlayer player = event.player;
		BlockPos pos = player.getPosition();
		World world = player.worldObj;
		Block block = world.getBlockState(pos).getBlock();
		if (((block == MoChickens.blockChickenFire) || (world.getBlockState(pos.up()).getBlock() == MoChickens.blockChickenFire)) && (!player.capabilities.isCreativeMode)) {
			player.setFire(8);
		}
	}
	
	private void extinguishFire(EntityPlayer player, BlockPos pos, EnumFacing face, World world, MouseEvent event) {
		 pos = pos.offset(face);

	        if (world.getBlockState(pos).getBlock() == MoChickens.blockChickenFire)
	        {
	        	world.playSoundEffect(player.posX, player.posY, player.posZ, "random.fizz", 1.0F, 1.0F);
	        	world.setBlockToAir(pos);
	        	MoChickens.network.sendToServer(new FireMessage(player, face));
	        	event.setCanceled(true);
	        }
		
	}
}
