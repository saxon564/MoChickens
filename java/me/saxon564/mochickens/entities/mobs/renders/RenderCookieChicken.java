package me.saxon564.mochickens.entities.mobs.renders;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.saxon564.mochickens.entities.mobs.EntityCookieChicken;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderCookieChicken extends RenderLiving
{
    private static final ResourceLocation chickenCTextures = new ResourceLocation("mochickens:textures/mobs/cookieChicken.png");

    public RenderCookieChicken(ModelBase par1ModelBase, float par2)
    {
        super(par1ModelBase, par2);
    }

    public void renderCookieChicken(EntityCookieChicken par1EntityCookieChicken, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRender(par1EntityCookieChicken, par2, par4, par6, par8, par9);
    }

    protected float getWingRotation(EntityCookieChicken par1EntityCookieChicken, float par2)
    {
        float f1 = par1EntityCookieChicken.field_70888_h + (par1EntityCookieChicken.field_70886_e - par1EntityCookieChicken.field_70888_h) * par2;
        float f2 = par1EntityCookieChicken.field_70884_g + (par1EntityCookieChicken.destPos - par1EntityCookieChicken.field_70884_g) * par2;
        return (MathHelper.sin(f1) + 1.0F) * f2;
    }

    /**
     * Defines what float the third param in setRotationAngles of ModelBase is
     */
    protected float handleRotationFloat(EntityLivingBase par1EntityLivingBase, float par2)
    {
        return this.getWingRotation((EntityCookieChicken)par1EntityLivingBase, par2);
    }

    public void doRenderLiving(EntityLivingBase par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderCookieChicken((EntityCookieChicken)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderCookieChicken((EntityCookieChicken)par1Entity, par2, par4, par6, par8, par9);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity)
    {
        return this.chickenCTextures;
    }
}
