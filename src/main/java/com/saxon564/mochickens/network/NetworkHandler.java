package com.saxon564.mochickens.network;

import com.saxon564.mochickens.MoChickens;
import com.saxon564.mochickens.Reference;
import com.saxon564.mochickens.network.FireMessage;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class NetworkHandler {
	private static final String PROTICOL_VERSION = "1";
    
//    public static void register() {
//    	MoChickens.network = NetworkRegistry.newSimpleChannel(
//        		new ResourceLocation(Reference.MOD_ID, "network")
//        		,() -> PROTICOL_VERSION
//        		, PROTICOL_VERSION::equals
//        		, PROTICOL_VERSION::equals);
//    	int id = 0;
//    	
//    	MoChickens.network.registerMessage(id++, FireMessage.class, FireMessage::encode, FireMessage::decode, FireMessage::handle);
//    }
}
