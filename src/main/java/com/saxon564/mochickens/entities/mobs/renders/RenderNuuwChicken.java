package com.saxon564.mochickens.entities.mobs.renders;

import com.saxon564.mochickens.Reference;
import com.saxon564.mochickens.entities.mobs.EntityNuuwChicken;
import com.saxon564.mochickens.entities.mobs.models.ModelEnderChicken;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderNuuwChicken extends MobRenderer<EntityNuuwChicken, ModelEnderChicken<EntityNuuwChicken>>
{
    private static final ResourceLocation WILD_TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/mobs/diamondchicken.png");
    private static final ResourceLocation TAMED_TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/mobs/dirtchicken.png");
    public boolean tamed = false;

    public RenderNuuwChicken(EntityRendererManager renderManager)
    {
        super(renderManager, new ModelEnderChicken<>(), 0.3F);
    }

    @Override
    protected float handleRotationFloat(EntityNuuwChicken entity, float par2)
    {
        float f1 = entity.field_70888_h + (entity.field_70886_e - entity.field_70888_h) * par2;
        float f2 = entity.field_70884_g + (entity.destPos - entity.field_70884_g) * par2;
        return (MathHelper.sin(f1) + 1.0F) * f2;
    }

	@Override
	protected ResourceLocation getEntityTexture(EntityNuuwChicken entity) {
		if (entity.isTamed()) {
	        	return TAMED_TEXTURE;
	    	} else {
	    		return WILD_TEXTURE;	
	    	}
	}
    
}
