package com.saxon564.mochickens.events;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class PlayerDamageHandler {
	
	@SubscribeEvent
	public void onEvent(LivingHurtEvent event)
	{
		Entity entitysource = event.getSource().getTrueSource();
		if (entitysource instanceof LivingEntity)
		{
			if (event.getSource().isProjectile())
			{
				System.out.println(event.getSource().getImmediateSource().toString());
			}
		}
	}
}
