package com.saxon564.mochickens.events;

import com.saxon564.mochickens.Reference;
import com.saxon564.mochickens.registers.collections.MoChickensEntities.*;

import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SpawnEvents {

	@SubscribeEvent
	public static void registerSpawnPlacements(SpawnPlacementRegisterEvent e) {
		
	}
}
