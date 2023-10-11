package com.saxon564.mochickens.entities.mobs.renders;

import com.saxon564.mochickens.Reference;
import com.saxon564.mochickens.configs.ConfigHandler;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class RenderDiamondChicken extends RenderMoChicken {

	public RenderDiamondChicken(EntityRendererProvider.Context renderManager) {
		super(renderManager, ConfigHandler.DIAMOND_CHICKEN_CONFIG);
		TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/mobs/diamondchicken.png");
	}
}
