package com.saxon564.mochickens.entities.mobs.models;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelSkeletonChicken<T extends Entity> extends EntityModel<T>
{
    //fields
    RendererModel rleg;
    RendererModel lleg;
    RendererModel body;
    RendererModel head;
    RendererModel rwing;
    RendererModel lwing;
    RendererModel bill;
    RendererModel chin;

    public ModelSkeletonChicken()
    {
        textureWidth = 64;
        textureHeight = 32;
        rleg = new RendererModel(this, 34, 0);
        rleg.addBox(0F, 0F, -2F, 3, 5, 3);
        rleg.setRotationPoint(0F, 19F, 1F);
        rleg.setTextureSize(64, 32);
        rleg.mirror = true;
        setRotation(rleg, 0F, 0F, 0F);
        lleg = new RendererModel(this, 34, 0);
        lleg.addBox(-3F, 0F, -2F, 3, 5, 3);
        lleg.setRotationPoint(0F, 19F, 1F);
        lleg.setTextureSize(64, 32);
        lleg.mirror = true;
        setRotation(lleg, 0F, 0F, 0F);
        body = new RendererModel(this, 0, 10);
        body.addBox(-3F, -6F, -5F, 6, 6, 8);
        body.setRotationPoint(0F, 19F, 1F);
        body.setTextureSize(64, 32);
        body.mirror = true;
        setRotation(body, 0F, 0F, 0F);
        head = new RendererModel(this, 0, 0);
        head.addBox(-2F, -6F, -2F, 4, 6, 3);
        head.setRotationPoint(0F, 16F, -4F);
        head.setTextureSize(64, 32);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        rwing = new RendererModel(this, 29, 9);
        rwing.addBox(0F, 0F, -3F, 1, 4, 6);
        rwing.setRotationPoint(3F, 13F, 0F);
        rwing.setTextureSize(64, 32);
        rwing.mirror = true;
        setRotation(rwing, 0F, 0F, 0F);
        lwing = new RendererModel(this, 29, 20);
        lwing.addBox(-1F, 0F, -3F, 1, 4, 6);
        lwing.setRotationPoint(-3F, 13F, 0F);
        lwing.setTextureSize(64, 32);
        lwing.mirror = true;
        setRotation(lwing, 0F, 0F, 0F);
        bill = new RendererModel(this, 14, 0);
        bill.addBox(-2F, -4F, -4F, 4, 2, 2);
        bill.setRotationPoint(0F, 16F, -4F);
        bill.setTextureSize(64, 32);
        bill.mirror = true;
        setRotation(bill, 0F, 0F, 0F);
        chin = new RendererModel(this, 14, 4);
        chin.addBox(-1F, -2F, -3F, 2, 2, 2);
        chin.setRotationPoint(0F, 16F, -4F);
        chin.setTextureSize(64, 32);
        chin.mirror = true;
        setRotation(chin, 0F, 0F, 0F);
    }

    public void render(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
        super.render(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);

        if (isChild)
        {
        	setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entity);
            float f6 = 2.0F;
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0F, 5.0F * scale, 2.0F * scale);
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
            setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entity);
            rleg.render(scale);
            lleg.render(scale);
            body.render(scale);
            head.render(scale);
            rwing.render(scale);
            lwing.render(scale);
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
        lwing.rotateAngleZ = ageInTicks;
        rwing.rotateAngleZ = -ageInTicks;
    }
}
