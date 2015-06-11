package com.saxon564.mochickens.proxies;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;

import com.saxon564.mochickens.events.FireEventHandlerServer;


public class CommonProxyMoChickens
{
    public void registerRenders()
    {
    }

    public void registerSounds()
    {
    }
    
    public void modelExceptions()
    {
    }
    
    public void eventHandlers() {
    	MinecraftForge.EVENT_BUS.register(new FireEventHandlerServer());
		FMLCommonHandler.instance().bus().register(new FireEventHandlerServer());
    }
    
    public void addVariants() 
    {
    }
}
