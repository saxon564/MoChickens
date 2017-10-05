package com.saxon564.mochickens.entities.mobs.models;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelGiantChicken extends ModelBase
{
    //fields
    ModelRenderer lleg;
    ModelRenderer rleg;
    ModelRenderer body;
    ModelRenderer lwing;
    ModelRenderer rwing;
    ModelRenderer head;
    ModelRenderer bill;
    ModelRenderer chin;

    public ModelGiantChicken()
    {
        textureWidth = 256;
        textureHeight = 128;
        lleg = new ModelRenderer(this, 85, 0);
        lleg.addBox(0F, 0F, -5F, 9, 15, 9);
        lleg.setRotationPoint(0F, 9F, 3F);
        lleg.setTextureSize(256, 128);
        lleg.mirror = true;
        setRotation(lleg, 0F, 0F, 0F);
        rleg = new ModelRenderer(this, 85, 0);
        rleg.addBox(-9F, 0F, -5F, 9, 15, 9);
        rleg.setRotationPoint(0F, 9F, 3F);
        rleg.setTextureSize(256, 128);
        rleg.mirror = true;
        setRotation(rleg, 0F, 0F, 0F);
        body = new ModelRenderer(this, 0, 30);
        body.addBox(-9F, -9F, -11F, 18, 18, 24);
        body.setRotationPoint(0F, 0F, 0F);
        body.setTextureSize(256, 128);
        body.mirror = true;
        setRotation(body, 0F, 0F, 0F);
        lwing = new ModelRenderer(this, 88, 30);
        lwing.addBox(0F, 0F, -9F, 4, 12, 18);
        lwing.setRotationPoint(9F, -9F, 1F);
        lwing.setTextureSize(256, 128);
        lwing.mirror = true;
        setRotation(lwing, 0F, 0F, 0F);
        rwing = new ModelRenderer(this, 88, 30);
        rwing.addBox(-4F, 0F, -9F, 4, 12, 18);
        rwing.setRotationPoint(-9F, -9F, 1F);
        rwing.setTextureSize(256, 128);
        rwing.mirror = true;
        setRotation(rwing, 0F, 0F, 0F);
        head = new ModelRenderer(this, 0, 0);
        head.addBox(-6F, -12F, -6F, 12, 18, 9);
        head.setRotationPoint(0F, -9F, -11F);
        head.setTextureSize(256, 128);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        bill = new ModelRenderer(this, 44, 14);
        bill.addBox(-6F, -6F, -12F, 12, 6, 6);
        bill.setRotationPoint(0F, -9F, -11F);
        bill.setTextureSize(256, 128);
        bill.mirror = true;
        setRotation(bill, 0F, 0F, 0F);
        chin = new ModelRenderer(this, 47, 0);
        chin.addBox(-3F, 0F, -10F, 6, 6, 6);
        chin.setRotationPoint(0F, -9F, -10F);
        chin.setTextureSize(256, 128);
        chin.mirror = true;
        setRotation(chin, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {

    	setRotationAngles(f, f1, f2, f3, f4, f5);
        if (this.isChild)
        {
        	setRotationAngles(f, f1, f2, f3, f4, f5, entity);
            float f6 = 2.0F;
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0F, 14.0F * f5, 4.0F * f5);
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
            lleg.render(f5);
            rleg.render(f5);
            body.render(f5);
            lwing.render(f5);
            rwing.render(f5);
            head.render(f5);
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

    public void setRotationAngles(float f1, float f2, float f3, float f4, float f5, float f6)
    {
        this.head.rotateAngleX = f5 / (180F / (float)Math.PI);
        this.head.rotateAngleY = f4 / (180F / (float)Math.PI);
        this.bill.rotateAngleX = this.head.rotateAngleX;
        this.bill.rotateAngleY = this.head.rotateAngleY;
        this.chin.rotateAngleX = this.head.rotateAngleX;
        this.chin.rotateAngleY = this.head.rotateAngleY;
        this.rleg.rotateAngleX = MathHelper.cos(f1 * 0.6662F) * 1.4F * f2;
        this.lleg.rotateAngleX = MathHelper.cos(f1 * 0.6662F + (float)Math.PI) * 1.4F * f2;
        this.rwing.rotateAngleZ = f3;
        this.lwing.rotateAngleZ = -f3;
    }
}
