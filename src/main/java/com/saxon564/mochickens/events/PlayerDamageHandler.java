package com.saxon564.mochickens.events;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class PlayerDamageHandler {
	
	@SubscribeEvent
	public void onEvent(LivingHurtEvent event)
	{
		Entity entitysource = event.getSource().getSourceOfDamage();
		if (entitysource instanceof EntityLivingBase)
		{
			if (event.getSource().isProjectile())
			{
				System.out.println(event.getSource().getEntity().toString());
			}
		}
	}
}
