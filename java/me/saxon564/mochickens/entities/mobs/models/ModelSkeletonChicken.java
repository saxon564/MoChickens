package me.saxon564.mochickens.entities.mobs.models;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelSkeletonChicken extends ModelBase
{
    //fields
    ModelRenderer rleg;
    ModelRenderer lleg;
    ModelRenderer body;
    ModelRenderer head;
    ModelRenderer rwing;
    ModelRenderer lwing;
    ModelRenderer bill;
    ModelRenderer chin;

    public ModelSkeletonChicken()
    {
        textureWidth = 64;
        textureHeight = 32;
        rleg = new ModelRenderer(this, 34, 0);
        rleg.addBox(0F, 0F, -2F, 3, 5, 3);
        rleg.setRotationPoint(0F, 19F, 1F);
        rleg.setTextureSize(64, 32);
        rleg.mirror = true;
        setRotation(rleg, 0F, 0F, 0F);
        lleg = new ModelRenderer(this, 34, 0);
        lleg.addBox(-3F, 0F, -2F, 3, 5, 3);
        lleg.setRotationPoint(0F, 19F, 1F);
        lleg.setTextureSize(64, 32);
        lleg.mirror = true;
        setRotation(lleg, 0F, 0F, 0F);
        body = new ModelRenderer(this, 0, 10);
        body.addBox(-3F, -6F, -5F, 6, 6, 8);
        body.setRotationPoint(0F, 19F, 1F);
        body.setTextureSize(64, 32);
        body.mirror = true;
        setRotation(body, 0F, 0F, 0F);
        head = new ModelRenderer(this, 0, 0);
        head.addBox(-2F, -6F, -2F, 4, 6, 3);
        head.setRotationPoint(0F, 16F, -4F);
        head.setTextureSize(64, 32);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        rwing = new ModelRenderer(this, 29, 9);
        rwing.addBox(0F, 0F, -3F, 1, 4, 6);
        rwing.setRotationPoint(3F, 13F, 0F);
        rwing.setTextureSize(64, 32);
        rwing.mirror = true;
        setRotation(rwing, 0F, 0F, 0F);
        lwing = new ModelRenderer(this, 29, 20);
        lwing.addBox(-1F, 0F, -3F, 1, 4, 6);
        lwing.setRotationPoint(-3F, 13F, 0F);
        lwing.setTextureSize(64, 32);
        lwing.mirror = true;
        setRotation(lwing, 0F, 0F, 0F);
        bill = new ModelRenderer(this, 14, 0);
        bill.addBox(-2F, -4F, -4F, 4, 2, 2);
        bill.setRotationPoint(0F, 16F, -4F);
        bill.setTextureSize(64, 32);
        bill.mirror = true;
        setRotation(bill, 0F, 0F, 0F);
        chin = new ModelRenderer(this, 14, 4);
        chin.addBox(-1F, -2F, -3F, 2, 2, 2);
        chin.setRotationPoint(0F, 16F, -4F);
        chin.setTextureSize(64, 32);
        chin.mirror = true;
        setRotation(chin, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);

        if (this.isChild)
        {
        	setRotationAngles(f, f1, f2, f3, f4, f5, entity);
            float f6 = 2.0F;
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0F, 5.0F * f5, 2.0F * f5);
            this.head.render(f5);
            this.bill.render(f5);
            this.chin.render(f5);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glScalef(1.0F / f6, 1.0F / f6, 1.0F / f6);
            GL11.glTranslatef(0.0F, 24.0F * f5, 0.0F);
            this.body.render(f5);
            this.rleg.render(f5);
            this.lleg.render(f5);
            this.rwing.render(f5);
            this.lwing.render(f5);
            GL11.glPopMatrix();
        }
        else
        {
            setRotationAngles(f, f1, f2, f3, f4, f5, entity);
            rleg.render(f5);
            lleg.render(f5);
            body.render(f5);
            head.render(f5);
            rwing.render(f5);
            lwing.render(f5);
            bill.render(f5);
            chin.render(f5);
        }
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity)
    {
        this.head.rotateAngleX = par5 / (180F / (float)Math.PI);
        this.head.rotateAngleY = par4 / (180F / (float)Math.PI);
        this.bill.rotateAngleX = this.head.rotateAngleX;
        this.bill.rotateAngleY = this.head.rotateAngleY;
        this.chin.rotateAngleX = this.head.rotateAngleX;
        this.chin.rotateAngleY = this.head.rotateAngleY;
        this.rleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
        this.lleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
        this.lwing.rotateAngleZ = par3;
        this.rwing.rotateAngleZ = -par3;
    }
}
