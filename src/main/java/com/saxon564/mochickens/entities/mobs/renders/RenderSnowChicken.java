package com.saxon564.mochickens.entities.mobs.renders;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.saxon564.mochickens.Reference;
import com.saxon564.mochickens.entities.mobs.EntitySnowChicken;

@SideOnly(Side.CLIENT)
public class RenderSnowChicken extends RenderLiving
{
    private static final ResourceLocation chickenCTextures = new ResourceLocation(Reference.MOD_ID, "textures/mobs/snowchicken.png");

    public RenderSnowChicken(RenderManager renderManager, ModelBase modelBase, float f1)
    {
        super(renderManager, modelBase, f1);
    }

    public void renderSnowChicken(EntitySnowChicken par1EntitySnowChicken, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRender(par1EntitySnowChicken, par2, par4, par6, par8, par9);
    }

    protected float getWingRotation(EntitySnowChicken par1EntitySnowChicken, float par2)
    {
        float f1 = par1EntitySnowChicken.field_70888_h + (par1EntitySnowChicken.field_70886_e - par1EntitySnowChicken.field_70888_h) * par2;
        float f2 = par1EntitySnowChicken.field_70884_g + (par1EntitySnowChicken.destPos - par1EntitySnowChicken.field_70884_g) * par2;
        return (MathHelper.sin(f1) + 1.0F) * f2;
    }

    /**
     * Defines what float the third param in setRotationAngles of ModelBase is
     */
    protected float handleRotationFloat(EntityLivingBase par1EntityLivingBase, float par2)
    {
        return this.getWingRotation((EntitySnowChicken)par1EntityLivingBase, par2);
    }

    public void doRenderLiving(EntityLivingBase par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderSnowChicken((EntitySnowChicken)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderSnowChicken((EntitySnowChicken)par1Entity, par2, par4, par6, par8, par9);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity)
    {
        return this.chickenCTextures;
    }
}
