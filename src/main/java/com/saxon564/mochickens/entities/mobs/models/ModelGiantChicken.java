package com.saxon564.mochickens.entities.mobs.models;

import org.lwjgl.opengl.GL11;


import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelGiantChicken<T extends Entity> extends EntityModel<T>
{
    //fields
    RendererModel lleg;
    RendererModel rleg;
    RendererModel body;
    RendererModel lwing;
    RendererModel rwing;
    RendererModel head;
    RendererModel bill;
    RendererModel chin;

    public ModelGiantChicken()
    {
        textureWidth = 256;
        textureHeight = 128;
        lleg = new RendererModel(this, 85, 0);
        lleg.addBox(0F, 0F, -5F, 9, 15, 9);
        lleg.setRotationPoint(0F, 9F, 3F);
        lleg.setTextureSize(256, 128);
        lleg.mirror = true;
        setRotation(lleg, 0F, 0F, 0F);
        rleg = new RendererModel(this, 85, 0);
        rleg.addBox(-9F, 0F, -5F, 9, 15, 9);
        rleg.setRotationPoint(0F, 9F, 3F);
        rleg.setTextureSize(256, 128);
        rleg.mirror = true;
        setRotation(rleg, 0F, 0F, 0F);
        body = new RendererModel(this, 0, 30);
        body.addBox(-9F, -9F, -11F, 18, 18, 24);
        body.setRotationPoint(0F, 0F, 0F);
        body.setTextureSize(256, 128);
        body.mirror = true;
        setRotation(body, 0F, 0F, 0F);
        lwing = new RendererModel(this, 88, 30);
        lwing.addBox(0F, 0F, -9F, 4, 12, 18);
        lwing.setRotationPoint(9F, -9F, 1F);
        lwing.setTextureSize(256, 128);
        lwing.mirror = true;
        setRotation(lwing, 0F, 0F, 0F);
        rwing = new RendererModel(this, 88, 30);
        rwing.addBox(-4F, 0F, -9F, 4, 12, 18);
        rwing.setRotationPoint(-9F, -9F, 1F);
        rwing.setTextureSize(256, 128);
        rwing.mirror = true;
        setRotation(rwing, 0F, 0F, 0F);
        head = new RendererModel(this, 0, 0);
        head.addBox(-6F, -12F, -6F, 12, 18, 9);
        head.setRotationPoint(0F, -9F, -11F);
        head.setTextureSize(256, 128);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        bill = new RendererModel(this, 44, 14);
        bill.addBox(-6F, -6F, -12F, 12, 6, 6);
        bill.setRotationPoint(0F, -9F, -11F);
        bill.setTextureSize(256, 128);
        bill.mirror = true;
        setRotation(bill, 0F, 0F, 0F);
        chin = new RendererModel(this, 47, 0);
        chin.addBox(-3F, 0F, -10F, 6, 6, 6);
        chin.setRotationPoint(0F, -9F, -10F);
        chin.setTextureSize(256, 128);
        chin.mirror = true;
        setRotation(chin, 0F, 0F, 0F);
    }

    public void render(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {

    	setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entity);
        if (isChild)
        {
        	setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entity);
            float f6 = 2.0F;
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0F, 14.0F * scale, 4.0F * scale);
            head.render(scale);
            bill.render(scale);
            chin.render(scale);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glScalef(1.0F / f6, 1.0F / f6, 1.0F / f6);
            GL11.glTranslatef(0.0F, 24.0F * scale, 0.0F);
            body.render(scale);
            rleg.render(scale);
            lleg.render(scale);
            rwing.render(scale);
            lwing.render(scale);
            GL11.glPopMatrix();
        }
        else
        {
            lleg.render(scale);
            rleg.render(scale);
            body.render(scale);
            lwing.render(scale);
            rwing.render(scale);
            head.render(scale);
            bill.render(scale);
            chin.render(scale);
        }
    }

    private void setRotation(RendererModel model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale, Entity entity)
    {
        head.rotateAngleX = headPitch / (180F / (float)Math.PI);
        head.rotateAngleY = netHeadYaw / (180F / (float)Math.PI);
        bill.rotateAngleX = head.rotateAngleX;
        bill.rotateAngleY = head.rotateAngleY;
        chin.rotateAngleX = head.rotateAngleX;
        chin.rotateAngleY = head.rotateAngleY;
        rleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        lleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        rwing.rotateAngleZ = ageInTicks;
        lwing.rotateAngleZ = -ageInTicks;
    }
}
