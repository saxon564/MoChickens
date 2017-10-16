package com.saxon564.mochickens.registers;

import com.saxon564.mochickens.MoChickens;
import com.saxon564.mochickens.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public class RegisterSounds {
	private static int size = 0;
	
	public static void init(){
		size = SoundEvent.REGISTRY.getKeys().size();
		
		MoChickens.DEEP_CLUCK = register("deepCluck");
		MoChickens.GIANT_HURT = register("giantHurt");
		MoChickens.DIAMOND_LAY = register("layDiamond");
	}
	
	public static SoundEvent register(String name){
		ResourceLocation location = new ResourceLocation(Reference.MOD_ID, name);
		SoundEvent e = new SoundEvent(location);
		
		SoundEvent.REGISTRY.register(size, location, e);
		size++;
		return e;
	}
}
