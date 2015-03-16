package me.saxon564.mochickens.entities.mobs.models;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelCChicken extends ModelBase
{
    //fields
    ModelRenderer Body;
    ModelRenderer LeftWing;
    ModelRenderer rightWing;
    ModelRenderer Head;
    ModelRenderer Bill;
    ModelRenderer Chin;
    ModelRenderer rightLeg;
    ModelRenderer leftLeg;

    public ModelCChicken()
    {
        textureWidth = 64;
        textureHeight = 32;
        Body = new ModelRenderer(this, 0, 9);
        Body.addBox(0F, 0F, 0F, 6, 6, 8);
        Body.setRotationPoint(-3F, 12F, -5F);
        Body.setTextureSize(64, 32);
        Body.mirror = true;
        setRotation(Body, 0F, 0F, 0F);
        LeftWing = new ModelRenderer(this, 24, 13);
        LeftWing.addBox(1F, 0F, -3F, 1, 4, 6);
        LeftWing.setRotationPoint(2F, 12F, -1F);
        LeftWing.setTextureSize(64, 32);
        LeftWing.mirror = true;
        setRotation(LeftWing, 0F, 0F, 0F);
        rightWing = new ModelRenderer(this, 24, 13);
        rightWing.addBox(-1F, 0F, -3F, 1, 4, 6);
        rightWing.setRotationPoint(-3F, 12F, -1F);
        rightWing.setTextureSize(64, 32);
        rightWing.mirror = true;
        setRotation(rightWing, 0F, 0F, 0F);
        Head = new ModelRenderer(this, 0, 0);
        Head.addBox(-2F, -4F, -3F, 4, 6, 3);
        Head.setRotationPoint(0F, 12F, -4F);
        Head.setTextureSize(64, 32);
        Head.mirror = true;
        setRotation(Head, 0F, 0F, 0F);
        Bill = new ModelRenderer(this, 14, 0);
        Bill.addBox(-2F, -2F, -5F, 4, 2, 2);
        Bill.setRotationPoint(0F, 12F, -4F);
        Bill.setTextureSize(64, 32);
        Bill.mirror = true;
        setRotation(Bill, 0F, 0F, 0F);
        Chin = new ModelRenderer(this, 14, 5);
        Chin.addBox(-1F, 0F, -4F, 2, 2, 1);
        Chin.setRotationPoint(0F, 12F, -4F);
        Chin.setTextureSize(64, 32);
        Chin.mirror = true;
        setRotation(Chin, 0F, 0F, 0F);
        rightLeg = new ModelRenderer(this, 26, 0);
        rightLeg.addBox(0F, 0F, -3F, 3, 5, 3);
        rightLeg.setRotationPoint(-3F, 18F, 0F);
        rightLeg.setTextureSize(64, 32);
        rightLeg.mirror = true;
        setRotation(rightLeg, 0F, 0F, 0F);
        leftLeg = new ModelRenderer(this, 26, 0);
        leftLeg.addBox(0F, 0F, -3F, 3, 5, 3);
        leftLeg.setRotationPoint(0F, 18F, 0F);
        leftLeg.setTextureSize(64, 32);
        leftLeg.mirror = true;
        setRotation(leftLeg, 0F, 0F, 0F);
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
            this.Head.render(f5);
            this.Bill.render(f5);
            this.Chin.render(f5);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glScalef(1.0F / f6, 1.0F / f6, 1.0F / f6);
            GL11.glTranslatef(0.0F, 24.0F * f5, 0.0F);
            this.Body.render(f5);
            this.rightLeg.render(f5);
            this.leftLeg.render(f5);
            this.rightWing.render(f5);
            this.LeftWing.render(f5);
            GL11.glPopMatrix();
        }
        else
        {
            setRotationAngles(f, f1, f2, f3, f4, f5, entity);
            Body.render(f5);
            LeftWing.render(f5);
            rightWing.render(f5);
            Head.render(f5);
            Bill.render(f5);
            Chin.render(f5);
            rightLeg.render(f5);
            leftLeg.render(f5);
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
        this.Head.rotateAngleX = par5 / (180F / (float)Math.PI);
        this.Head.rotateAngleY = par4 / (180F / (float)Math.PI);
        this.Bill.rotateAngleX = this.Head.rotateAngleX;
        this.Bill.rotateAngleY = this.Head.rotateAngleY;
        this.Chin.rotateAngleX = this.Head.rotateAngleX;
        this.Chin.rotateAngleY = this.Head.rotateAngleY;
        this.rightLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
        this.leftLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
        this.rightWing.rotateAngleZ = par3;
        this.LeftWing.rotateAngleZ = -par3;
    }
}