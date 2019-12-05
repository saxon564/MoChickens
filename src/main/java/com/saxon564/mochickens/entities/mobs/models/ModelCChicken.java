package com.saxon564.mochickens.entities.mobs.models;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelCChicken<T extends Entity> extends EntityModel<T>
{
    //fields
    RendererModel Body;
    RendererModel LeftWing;
    RendererModel rightWing;
    RendererModel Head;
    RendererModel Bill;
    RendererModel Chin;
    RendererModel rightLeg;
    RendererModel leftLeg;

    public ModelCChicken()
    {
        textureWidth = 64;
        textureHeight = 32;
        Body = new RendererModel(this, 0, 9);
        Body.addBox(0F, 0F, 0F, 6, 6, 8);
        Body.setRotationPoint(-3F, 12F, -5F);
        Body.setTextureSize(64, 32);
        Body.mirror = true;
        setRotation(Body, 0F, 0F, 0F);
        LeftWing = new RendererModel(this, 24, 13);
        LeftWing.addBox(1F, 0F, -3F, 1, 4, 6);
        LeftWing.setRotationPoint(2F, 12F, -1F);
        LeftWing.setTextureSize(64, 32);
        LeftWing.mirror = true;
        setRotation(LeftWing, 0F, 0F, 0F);
        rightWing = new RendererModel(this, 24, 13);
        rightWing.addBox(-1F, 0F, -3F, 1, 4, 6);
        rightWing.setRotationPoint(-3F, 12F, -1F);
        rightWing.setTextureSize(64, 32);
        rightWing.mirror = true;
        setRotation(rightWing, 0F, 0F, 0F);
        Head = new RendererModel(this, 0, 0);
        Head.addBox(-2F, -4F, -3F, 4, 6, 3);
        Head.setRotationPoint(0F, 12F, -4F);
        Head.setTextureSize(64, 32);
        Head.mirror = true;
        setRotation(Head, 0F, 0F, 0F);
        Bill = new RendererModel(this, 14, 0);
        Bill.addBox(-2F, -2F, -5F, 4, 2, 2);
        Bill.setRotationPoint(0F, 12F, -4F);
        Bill.setTextureSize(64, 32);
        Bill.mirror = true;
        setRotation(Bill, 0F, 0F, 0F);
        Chin = new RendererModel(this, 14, 5);
        Chin.addBox(-1F, 0F, -4F, 2, 2, 1);
        Chin.setRotationPoint(0F, 12F, -4F);
        Chin.setTextureSize(64, 32);
        Chin.mirror = true;
        setRotation(Chin, 0F, 0F, 0F);
        rightLeg = new RendererModel(this, 26, 0);
        rightLeg.addBox(0F, 0F, -3F, 3, 5, 3);
        rightLeg.setRotationPoint(-3F, 18F, 0F);
        rightLeg.setTextureSize(64, 32);
        rightLeg.mirror = true;
        setRotation(rightLeg, 0F, 0F, 0F);
        leftLeg = new RendererModel(this, 26, 0);
        leftLeg.addBox(0F, 0F, -3F, 3, 5, 3);
        leftLeg.setRotationPoint(0F, 18F, 0F);
        leftLeg.setTextureSize(64, 32);
        leftLeg.mirror = true;
        setRotation(leftLeg, 0F, 0F, 0F);
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
            Head.render(scale);
            Bill.render(scale);
            Chin.render(scale);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glScalef(1.0F / f6, 1.0F / f6, 1.0F / f6);
            GL11.glTranslatef(0.0F, 24.0F * scale, 0.0F);
            Body.render(scale);
            rightLeg.render(scale);
            leftLeg.render(scale);
            rightWing.render(scale);
            LeftWing.render(scale);
            GL11.glPopMatrix();
        }
        else
        {
            setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entity);
            Body.render(scale);
            LeftWing.render(scale);
            rightWing.render(scale);
            Head.render(scale);
            Bill.render(scale);
            Chin.render(scale);
            rightLeg.render(scale);
            leftLeg.render(scale);
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
        Head.rotateAngleX = headPitch / (180F / (float)Math.PI);
        Head.rotateAngleY = netHeadYaw / (180F / (float)Math.PI);
        Bill.rotateAngleX = Head.rotateAngleX;
        Bill.rotateAngleY = Head.rotateAngleY;
        Chin.rotateAngleX = Head.rotateAngleX;
        Chin.rotateAngleY = Head.rotateAngleY;
        rightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        leftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        rightWing.rotateAngleZ = ageInTicks;
        LeftWing.rotateAngleZ = -ageInTicks;
    }
}