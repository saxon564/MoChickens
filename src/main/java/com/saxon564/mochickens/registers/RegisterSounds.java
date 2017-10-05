package com.saxon564.mochickens.registers;

import com.saxon564.mochickens.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public class RegisterSounds {
	private static int size = 0;
	
	public static SoundEvent DEEP_CLUCK;
	public static SoundEvent GIANT_HURT;
	public static SoundEvent DIAMOND_LAY;
	
	public static void init(){
		size = SoundEvent.REGISTRY.getKeys().size();
		
		DEEP_CLUCK = register("sounds.deepCluck");
		GIANT_HURT = register("sounds.giantHurt");
		DIAMOND_LAY = register("sounds.layDiamond");
	}
	
	public static SoundEvent register(String name){
		ResourceLocation location = new ResourceLocation(Reference.MOD_ID, name);
		SoundEvent e = new SoundEvent(location);
		
		SoundEvent.REGISTRY.register(size, location, e);
		size++;
		return e;
	}
}
