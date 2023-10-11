package com.saxon564.mochickens.entities.mobs.renders;

import com.saxon564.mochickens.configs.ChickenConfigGenerator;
import com.saxon564.mochickens.entities.mobs.MoChicken;
import com.saxon564.mochickens.entities.mobs.models.MoChickenModel;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class RenderMoChicken extends MobRenderer<MoChicken, MoChickenModel<MoChicken>> {
	protected static ResourceLocation TEXTURE = null;

	public RenderMoChicken(EntityRendererProvider.Context renderManager, ChickenConfigGenerator config) {
		super(renderManager, new MoChickenModel<>(renderManager.bakeLayer(MoChickenModel.LAYER_LOCATION), config), 0.3F);
		this.addLayer(new ChickenEnchantmentLayer(this, renderManager.getModelSet(), config));
	}

	@Override
	protected float getBob(MoChicken chicken, float p_114001_) {
		float f = Mth.lerp(p_114001_, chicken.oFlap, chicken.flap);
		float f1 = Mth.lerp(p_114001_, chicken.oFlapSpeed, chicken.flapSpeed);
		return (Mth.sin(f) + 1.0F) * f1;
	}

	@Override
	public ResourceLocation getTextureLocation(MoChicken entity) {
		return TEXTURE;
	}
}
