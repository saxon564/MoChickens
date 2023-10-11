package com.saxon564.mochickens.registers;

import com.saxon564.mochickens.Reference;
import com.saxon564.mochickens.entities.mobs.models.MoChickenModel;
import com.saxon564.mochickens.entities.mobs.renders.ChickenEnchantmentLayer;
import com.saxon564.mochickens.entities.mobs.renders.RenderDiamondChicken;
import com.saxon564.mochickens.registers.collections.MoChickensEntities;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RegisterRenders {
	
	@SubscribeEvent
	public static void renderRegistry(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(MoChickensEntities.DIAMOND_CHICKEN.get(), RenderDiamondChicken::new);
	}
	
	@SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(MoChickenModel.LAYER_LOCATION, MoChickenModel::createBodyLayer);
        event.registerLayerDefinition(ChickenEnchantmentLayer.LAYER_LOCATION, MoChickenModel::createBodyLayer);
    }
	    
}
