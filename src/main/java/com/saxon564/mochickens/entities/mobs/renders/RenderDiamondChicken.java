package com.saxon564.mochickens.entities.mobs.renders;

import com.saxon564.mochickens.Reference;
import com.saxon564.mochickens.entities.mobs.EntityDiamondChicken;
import com.saxon564.mochickens.entities.mobs.models.ModelRedstoneChicken;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderDiamondChicken extends MobRenderer<EntityDiamondChicken, ModelRedstoneChicken<EntityDiamondChicken>>
{
    private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/mobs/diamondchicken.png");

    public RenderDiamondChicken(EntityRendererManager renderManager)
    {
        super(renderManager, new ModelRedstoneChicken<>(), 0.3F);
    }

    @Override
    protected float handleRotationFloat(EntityDiamondChicken entity, float par2)
    {
        float f1 = entity.field_70888_h + (entity.field_70886_e - entity.field_70888_h) * par2;
        float f2 = entity.field_70884_g + (entity.destPos - entity.field_70884_g) * par2;
        return (MathHelper.sin(f1) + 1.0F) * f2;
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityDiamondChicken entity)
    {
        return TEXTURE;
    }
}
