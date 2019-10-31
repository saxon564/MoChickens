package com.saxon564.mochickens.events;

import java.awt.Event;
import java.awt.event.MouseEvent;

import com.mojang.realmsclient.gui.ChatFormatting;
import com.saxon564.mochickens.MoChickens;
import com.saxon564.mochickens.network.FireMessage;

import net.java.games.input.Keyboard;
import net.java.games.input.Mouse;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.client.event.InputEvent.KeyInputEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class FireEventHandlerClient {

//	@SubscribeEvent
//	public void onMouseEvent(MouseEvent event) {
//		int button = event.getButton() - 100;
//		Minecraft mc = Minecraft.getInstance();
//		PlayerEntity player = mc.player;
//		World world = mc.world;
//		Vec3d vec = mc.objectMouseOver.getHitVec();
//		int key = mc.gameSettings.keyBindAttack.getKey().getKeyCode();
//		
//		BlockPos pos = new BlockPos(vec.x, vec.y, vec.z);
//		Direction face = mc.objectMouseOver.sideHit;
//		
//		if ((button == key) && (Mouse.isButtonDown(button + 100))) {
//			if (pos != null) {
//			    if (world.getBlockState(pos).getBlock() != null) {
//				    this.extinguishFire(player, pos, face, world, event, button);
//			    }
//			}
//		}
//	}
//	
//	@SubscribeEvent
//	public void onInputEvent(KeyInputEvent event) {
//		int key = Keyboard.getEventKey();
//		Minecraft mc = Minecraft.getInstance();
//		PlayerEntity player = mc.player;
//		World world = mc.world;
//		Vec3d vec = mc.objectMouseOver.getHitVec();
//		int bind = mc.gameSettings.keyBindAttack.getKey().getKeyCode();
//		
//		BlockPos pos = new BlockPos(vec.x, vec.y, vec.z);
//		Direction face = mc.objectMouseOver.sideHit;
//		
//		if ((key == bind) && (Keyboard.isKeyDown(key))) {
//			if (world.getBlockState(pos).getBlock() != null) {
//				this.extinguishFire(player, pos, face, world, event, key);
//			}
//		}
//	}
	
	/*@SubscribeEvent
	public void onPlayerInteract(PlayerInteractEvent event) {
		Action action = event.action;
		Minecraft mc = Minecraft.getMinecraft();
		EntityPlayer player = event.entityPlayer;
		World world = event.world;
		
		BlockPos pos = event.pos;
		EnumFacing face = event.face;
		
		MoChickens.logger.info("Player Interact Event");
		
		if (action == Action.LEFT_CLICK_BLOCK) {
			if (world.getBlockState(pos).getBlock()!= null) {
				this.extinguishFire(player, pos, face, world, event/*, button/);
			}
		}
	}*/
	
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
//	private void extinguishFire(PlayerEntity player, BlockPos posIn, Direction face, World world, Event event, int key) {
//		 BlockPos pos = posIn.offset(face);
//
//	        if (world.getBlockState(pos).getBlock() == MoChickens.CHICKEN_FIRE)
//	        {
//	        	if ((event instanceof MouseEvent) || (event instanceof PlayerInteractEvent)) {
//		        	MoChickens.network.sendToServer(new FireMessage(player, face, pos));
//	        		event.setCanceled(true);
//	        	} else if(event instanceof KeyInputEvent) {
//					//KeyBinding.setKeyBindState(key, false);
//	        		player.sendMessage(new TextComponentString( ChatFormatting.RED + "Please contact saxon564 if you are trying to put out a fire " + ChatFormatting.RED +  "using a key on your keyboard as your attack key."));
//	        	}
//	        }
//		
//	}
}
