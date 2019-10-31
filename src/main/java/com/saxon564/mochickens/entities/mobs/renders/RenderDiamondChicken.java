package com.saxon564.mochickens.entities.mobs.renders;

import com.saxon564.mochickens.Reference;
import com.saxon564.mochickens.entities.mobs.EntityDiamondChicken;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderDiamondChicken <T extends EntityDiamondChicken, M extends EntityModel<T>> extends  MobRenderer<T, M>
{
    private static final ResourceLocation chickenTextures = new ResourceLocation(Reference.MOD_ID, "textures/mobs/diamondchicken.png");

    public RenderDiamondChicken(EntityRendererManager renderManager, M model, float f1)
    {
        super(renderManager, model, f1);
    }

    public void renderDiamondChicken(T par1EntityDiamondChicken, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRender(par1EntityDiamondChicken, par2, par4, par6, par8, par9);
    }

    protected float getWingRotation(T par1EntityDiamondChicken, float par2)
    {
        float f1 = par1EntityDiamondChicken.field_70888_h + (par1EntityDiamondChicken.field_70886_e - par1EntityDiamondChicken.field_70888_h) * par2;
        float f2 = par1EntityDiamondChicken.field_70884_g + (par1EntityDiamondChicken.destPos - par1EntityDiamondChicken.field_70884_g) * par2;
        return (MathHelper.sin(f1) + 1.0F) * f2;
    }

    /**
     * Defines what float the third param in setRotationAngles of ModelBase is
     */
    protected float handleRotationFloat(T par1EntityLivingBase, float par2)
    {
        return getWingRotation(par1EntityLivingBase, par2);
    }

    public void doRenderLiving(T par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        renderDiamondChicken(par1EntityLiving, par2, par4, par6, par8, par9);
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(T par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        renderDiamondChicken(par1Entity, par2, par4, par6, par8, par9);
    }

    @Override
    protected ResourceLocation getEntityTexture(T entity)
    {
        return chickenTextures;
    }
}
