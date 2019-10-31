package com.saxon564.mochickens.registers;

import com.saxon564.mochickens.MoChickens;
import com.saxon564.mochickens.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class RegisterSounds {
	//public static int size = 0;
	
	@SubscribeEvent
	public static void registerSounds(RegistryEvent.Register<SoundEvent> event) {
		
		/*event.getRegistry().registerAll(
			MoChickens.DEEP_CLUCK = register("deepCluck"),
			MoChickens.GIANT_HURT = register("giantHurt"),
			MoChickens.DIAMOND_LAY = register("layDiamond")
		);*/
		//size = ForgeRegistries.SOUND_EVENTS.getKeys().size();
	}
	
	public static SoundEvent register(String name){
		ResourceLocation location = new ResourceLocation(Reference.MOD_ID, name);
		SoundEvent e = new SoundEvent(location).setRegistryName(Reference.MOD_ID, name);
		
		//SoundEvent.REGISTRY.register(size, location, e);
		//size++;
		return e;
	}
}
