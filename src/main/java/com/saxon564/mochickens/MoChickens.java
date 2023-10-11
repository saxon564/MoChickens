package com.saxon564.mochickens;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.saxon564.mochickens.configs.ConfigHandler;
import com.saxon564.mochickens.entities.mobs.DiamondChicken;
import com.saxon564.mochickens.registers.RegisterChickens;
import com.saxon564.mochickens.registers.RegisterCreativeItems;
import com.saxon564.mochickens.registers.RegisterSounds;
import com.saxon564.mochickens.registers.RegisterSpawnEggs;
import com.saxon564.mochickens.registers.collections.MoChickensEntities;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Reference.MOD_ID)
public class MoChickens {

	public static MoChickens instance;
	public static Logger CHICKEN_LOGGER = LogManager.getLogger("Mo' Chickens");
	public static final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
	public static boolean DEBUG;

	public MoChickens() {
		ConfigHandler.loadConfig();
		
		MinecraftForge.EVENT_BUS.register(this);
		RegisterChickens.ENTITY_TYPE.register(bus);
		RegisterChickens.registerEntities();
		RegisterSpawnEggs.ITEMS.register(bus);
		RegisterSpawnEggs.registerSpawnEggs();
		RegisterSounds.SOUNDS.register(bus);
		RegisterSounds.registerSounds();
		bus.addListener(this::addCreative);
		bus.addListener(this::entityAttributCreation);	
		bus.addListener(this::commonSetup);	

	}

	public void commonSetup(final FMLCommonSetupEvent event) {	
		
	}

	public void interModSetup(final InterModEnqueueEvent event) {

	}

	public void interModProcess(final InterModProcessEvent event) {

	}

	private void addCreative(BuildCreativeModeTabContentsEvent event) {
		RegisterCreativeItems.addCreative(event);
	}
	

	public void entityAttributCreation(EntityAttributeCreationEvent event) {
		event.put(MoChickensEntities.DIAMOND_CHICKEN.get(), DiamondChicken.createAttributes().build());
	}
}
