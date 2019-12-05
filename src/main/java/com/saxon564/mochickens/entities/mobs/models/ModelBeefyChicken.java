package com.saxon564.mochickens.entities.mobs.models;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelBeefyChicken<T extends Entity> extends EntityModel<T>
{
  //fields
    RendererModel Head;
    RendererModel Body;
    RendererModel Left_Horn;
    RendererModel Right_Horn;
    RendererModel Bill;
    RendererModel Chin;
    RendererModel Left_Foot;
    RendererModel Right_Foot;
    RendererModel Left_Wing;
    RendererModel Right_Wing;
  
  public ModelBeefyChicken()
  {
    textureWidth = 64;
    textureHeight = 32;
    
    Head = new RendererModel(this, 0, 0);
    Head.addBox(-2F, -6F, -4F, 4, 6, 4);
    Head.setRotationPoint(0F, 17F, -1F);
    Head.setTextureSize(64, 32);
    Head.mirror = true;
    setRotation(Head, 0F, 0F, 0F);
    Body = new RendererModel(this, 25, 0);
    Body.addBox(-3F, -3F, 0F, 6, 6, 8);
    Body.setRotationPoint(0F, 17F, -2F);
    Body.setTextureSize(64, 32);
    Body.mirror = true;
    setRotation(Body, 0F, 0F, 0F);
    Left_Horn = new RendererModel(this, 17, 0);
    Left_Horn.addBox(2F, -7F, -1F, 1, 2, 1);
    Left_Horn.setRotationPoint(0F, 17F, -1F);
    Left_Horn.setTextureSize(64, 32);
    Left_Horn.mirror = true;
    setRotation(Left_Horn, 0F, 0F, 0F);
    Right_Horn = new RendererModel(this, 17, 0);
    Right_Horn.addBox(-3F, -9F, -1F, 1, 2, 1);
    Right_Horn.setRotationPoint(0F, 19F, -1F);
    Right_Horn.setTextureSize(64, 32);
    Right_Horn.mirror = true;
    setRotation(Right_Horn, 0F, 0F, 0F);
    Bill = new RendererModel(this, 27, 16);
    Bill.addBox(-2F, -4F, -6F, 4, 2, 2);
    Bill.setRotationPoint(0F, 17F, -1F);
    Bill.setTextureSize(64, 32);
    Bill.mirror = true;
    setRotation(Bill, 0F, 0F, 0F);
    Chin = new RendererModel(this, 17, 4);
    Chin.addBox(-1F, -2F, -5F, 2, 2, 1);
    Chin.setRotationPoint(0F, 17F, -1F);
    Chin.setTextureSize(64, 32);
    Chin.mirror = true;
    setRotation(Chin, 0F, 0F, 0F);
    Left_Foot = new RendererModel(this, 0, 25);
    Left_Foot.addBox(-1F, 0F, -1F, 2, 4, 2);
    Left_Foot.setRotationPoint(2F, 20F, 3F);
    Left_Foot.setTextureSize(64, 32);
    Left_Foot.mirror = true;
    setRotation(Left_Foot, 0F, 0F, 0F);
    Right_Foot = new RendererModel(this, 0, 25);
    Right_Foot.addBox(-1F, 0F, -1F, 2, 4, 2);
    Right_Foot.setRotationPoint(-2F, 20F, 3F);
    Right_Foot.setTextureSize(64, 32);
    Right_Foot.mirror = true;
    setRotation(Right_Foot, 0F, 0F, 0F);
    Left_Wing = new RendererModel(this, 13, 14);
    Left_Wing.addBox(0F, -1F, -1F, 1, 4, 5);
    Left_Wing.setRotationPoint(3F, 15F, 0F);
    Left_Wing.setTextureSize(64, 32);
    Left_Wing.mirror = true;
    setRotation(Left_Wing, 0F, 0F, 0F);
    Right_Wing = new RendererModel(this, 0, 14);
    Right_Wing.addBox(-1F, -1F, -1F, 1, 4, 5);
    Right_Wing.setRotationPoint(-3F, 15F, 0F);
    Right_Wing.setTextureSize(64, 32);
    Right_Wing.mirror = true;
    setRotation(Right_Wing, 0F, 0F, 0F);
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
        Left_Horn.render(scale);
        Right_Horn.render(scale);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glScalef(1.0F / f6, 1.0F / f6, 1.0F / f6);
        GL11.glTranslatef(0.0F, 24.0F * scale, 0.0F);
        Body.render(scale);
        Right_Foot.render(scale);
        Left_Foot.render(scale);
        Right_Wing.render(scale);
        Left_Wing.render(scale);
        GL11.glPopMatrix();
    }
    else
    {
    setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entity);
    Head.render(scale);
    Body.render(scale);
    Left_Horn.render(scale);
    Right_Horn.render(scale);
    Bill.render(scale);
    Chin.render(scale);
    Left_Foot.render(scale);
    Right_Foot.render(scale);
    Left_Wing.render(scale);
    Right_Wing.render(scale);
    }
  }
  
  private void setRotation(RendererModel model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity)
  {
	  Head.rotateAngleX = headPitch / (180F / (float)Math.PI);
      Head.rotateAngleY = netHeadYaw / (180F / (float)Math.PI);
      Bill.rotateAngleX = Head.rotateAngleX;
      Bill.rotateAngleY = Head.rotateAngleY;
      Chin.rotateAngleX = Head.rotateAngleX;
      Chin.rotateAngleY = Head.rotateAngleY;
      Left_Horn.rotateAngleX = Head.rotateAngleX;
      Left_Horn.rotateAngleY = Head.rotateAngleY;
      Right_Horn.rotateAngleX = Head.rotateAngleX;
      Right_Horn.rotateAngleY = Head.rotateAngleY;
      Right_Foot.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
      Left_Foot.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
      Right_Wing.rotateAngleZ = ageInTicks;
      Left_Wing.rotateAngleZ = -ageInTicks;
  }

}
