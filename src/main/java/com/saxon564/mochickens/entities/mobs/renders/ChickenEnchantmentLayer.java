package com.saxon564.mochickens.entities.mobs.renders;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.saxon564.mochickens.Reference;
import com.saxon564.mochickens.configs.ChickenConfigGenerator;
import com.saxon564.mochickens.entities.mobs.MoChicken;
import com.saxon564.mochickens.entities.mobs.models.MoChickenModel;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class ChickenEnchantmentLayer extends RenderLayer<MoChicken, MoChickenModel<MoChicken>> {
	private static final ResourceLocation GLINT_LOCATION = new ResourceLocation(
			"textures/misc/enchanted_glint_item.png");
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation(Reference.MOD_ID, "mochickenmodel"), "glint");
	public final MoChickenModel<MoChicken> model;

	public ChickenEnchantmentLayer(RenderLayerParent<MoChicken, MoChickenModel<MoChicken>> p_174471_,
			EntityModelSet p_174472_, ChickenConfigGenerator config) {
		super(p_174471_);
		this.model = new MoChickenModel<>(p_174472_.bakeLayer(LAYER_LOCATION), config);
	}

	protected float xOffset(float p_116683_) {
		return p_116683_ * 0.01F;
	}

	protected ResourceLocation getTextureLocation() {
		return GLINT_LOCATION;
	}

	public EntityModel<MoChicken> model() {
		return this.model;
	}

	@Override
	public void render(PoseStack p_116970_, MultiBufferSource p_116971_, int p_116972_, MoChicken p_116973_, float p_116974_, float p_116975_, float p_116976_, float p_116977_, float p_116978_, float p_116979_) {
		if (p_116973_.getConfig().IS_ENCHANTED.get()) {
	         float f = (float)p_116973_.tickCount + p_116976_;
	         EntityModel<MoChicken> entitymodel = this.model();
	         entitymodel.prepareMobModel(p_116973_, p_116974_, p_116975_, p_116976_);
	         this.getParentModel().copyPropertiesTo(entitymodel);
	         VertexConsumer vertexconsumer = p_116971_.getBuffer(RenderType.energySwirl(this.getTextureLocation(), this.xOffset(f) % 1.0F, f * 0.01F % 1.0F));
	         entitymodel.setupAnim(p_116973_, p_116974_, p_116975_, p_116977_, p_116978_, p_116979_);
	         entitymodel.renderToBuffer(p_116970_, vertexconsumer, p_116972_, OverlayTexture.NO_OVERLAY, 0.5F, 0.5F, 0.5F, 1.0F);
	      }

	}
}