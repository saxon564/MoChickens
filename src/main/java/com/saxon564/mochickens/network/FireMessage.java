package com.saxon564.mochickens.network;

import java.util.function.Supplier;

//import javax.xml.ws.handler.MessageContext;

//import net.minecraft.block.BlockState;
//import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.Direction;
//import net.minecraft.util.SoundCategory;
//import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
//import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkEvent;

public class FireMessage {
    
    //private String text;
    private static String player;
    private static int face;
    private static int x;
    private static int y;
    private static int z;

    public FireMessage(PlayerEntity playerIn, Direction face2, BlockPos posIn) {
        player = playerIn.getName().toString();
        face = face2.getIndex();
        x = posIn.getX();
        y = posIn.getY();
        z = posIn.getZ();
    }

    public static void decode(PacketBuffer buf) {
        player = buf.readString();
        face = buf.readVarInt();
        x = buf.readVarInt();
        y = buf.readVarInt();
        z = buf.readVarInt();
    }

    public void encode(FireMessage msg, PacketBuffer buf) {
        buf.writeString(player);
        buf.writeVarInt(face);
        buf.writeVarInt(x);
        buf.writeVarInt(y);
        buf.writeVarInt(z);
    }
    

	public static void handle(FireMessage msg, Supplier<NetworkEvent.Context> context) {
		
	}

//    public static class Handler implements IMessageHandler<FireMessage, IMessage> {
//        
//        @Override
//        public IMessage onMessage(FireMessage message, MessageContext ctx) {
//            //System.out.println(String.format("Received %s from %s", message.face, ctx.getServerHandler().playerEntity.getDisplayName()));
//            Direction face2 = Direction.byIndex(message.face);
//            PlayerEntity player = message.player;
//            World world = player.world;
//    		BlockPos pos = new BlockPos(message.x, message.y, message.z);
//    		
//    		world.playSound(player, player.posX, player.posY, player.posZ, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.HOSTILE, 1.0F, 1.0F);
//        	world.setBlockState(pos, new BlockState(Blocks.AIR, null));
//            return null;
//        }
//    }
}
