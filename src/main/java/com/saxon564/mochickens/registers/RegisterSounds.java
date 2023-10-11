package com.saxon564.mochickens.registers;

//import com.saxon564.mochickens.MoChickens;
import com.saxon564.mochickens.Reference;
import com.saxon564.mochickens.registers.collections.MoChickensSounds;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RegisterSounds {
	
	public static DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Reference.MOD_ID);
	
	public static void registerSounds() {
			MoChickensSounds.DEEP_CLUCK = register("deepcluck");
			MoChickensSounds.GIANT_HURT = register("gianthurt");
			MoChickensSounds.DIAMOND_LAY = register("laydiamond");
	}
	
	public static RegistryObject<SoundEvent> register(String name){
		ResourceLocation location = new ResourceLocation(Reference.MOD_ID, name);
		return SOUNDS.register(name, () -> SoundEvent.createFixedRangeEvent(location, 16.0F));
	}
}
