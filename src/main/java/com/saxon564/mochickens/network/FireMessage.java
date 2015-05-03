package com.saxon564.mochickens.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class FireMessage implements IMessage {
    
    private String text;
    private String player;
    private int face;

    public FireMessage() { }

    public FireMessage(EntityPlayer playerIn, EnumFacing faceIn) {
        player = playerIn.toString();
        face = faceIn.getIndex();
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        player = ByteBufUtils.readUTF8String(buf);
        face = ByteBufUtils.readVarInt(buf, 5);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeUTF8String(buf, player);
        ByteBufUtils.writeVarInt(buf, face, 5);
    }

    public static class Handler implements IMessageHandler<FireMessage, IMessage> {
        
        @Override
        public IMessage onMessage(FireMessage message, MessageContext ctx) {
            System.out.println(String.format("Received %s from %s", message.text, ctx.getServerHandler().playerEntity.getDisplayName()));
            return null;
        }
    }
}
