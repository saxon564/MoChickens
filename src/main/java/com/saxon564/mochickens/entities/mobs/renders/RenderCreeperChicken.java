package com.saxon564.mochickens.entities.mobs.renders;

import com.saxon564.mochickens.Reference;
import com.saxon564.mochickens.entities.mobs.EntityCreeperChicken;
import com.saxon564.mochickens.entities.mobs.models.ModelCChicken;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderCreeperChicken extends MobRenderer<EntityCreeperChicken, ModelCChicken<EntityCreeperChicken>>
{
    private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/mobs/creeperchicken.png");

    public RenderCreeperChicken(EntityRendererManager renderManager)
    {
        super(renderManager, new ModelCChicken<>(), 0.3f);
    }

    @Override
    protected float handleRotationFloat(EntityCreeperChicken entity, float par2)
    {
        float f1 = entity.field_70888_h + (entity.field_70886_e - entity.field_70888_h) * par2;
        float f2 = entity.field_70884_g + (entity.destPos - entity.field_70884_g) * par2;
        return (MathHelper.sin(f1) + 1.0F) * f2;
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityCreeperChicken entity)
    {
        return TEXTURE;
    }
}
