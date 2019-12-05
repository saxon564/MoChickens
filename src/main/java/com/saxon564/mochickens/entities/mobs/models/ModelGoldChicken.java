package com.saxon564.mochickens.entities.mobs.models;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelGoldChicken<T extends Entity> extends EntityModel<T>
{
  //fields
    RendererModel rleg;
    RendererModel lleg;
    RendererModel body;
    RendererModel rwing;
    RendererModel head;
    RendererModel lwing;
    RendererModel bill;
    RendererModel chin;
    RendererModel Back_Plate;
    RendererModel Head_Spike_1;
    RendererModel Head_Spike_2;
    RendererModel Head_Spike_3;
  
  public ModelGoldChicken()
  {
    textureWidth = 64;
    textureHeight = 32;
    
    rleg = new RendererModel(this, 34, 0);
    rleg.addBox(0F, 0F, -5F, 3, 5, 3);
    rleg.setRotationPoint(0F, 19F, 1F);
    rleg.setTextureSize(64, 32);
    rleg.mirror = true;
    setRotation(rleg, 0F, 0F, 0F);
    lleg = new RendererModel(this, 34, 0);
    lleg.addBox(-3F, 0F, -5F, 3, 5, 3);
    lleg.setRotationPoint(0F, 19F, 1F);
    lleg.setTextureSize(64, 32);
    lleg.mirror = true;
    setRotation(lleg, 0F, 0F, 0F);
    body = new RendererModel(this, 0, 10);
    body.addBox(-3F, -6F, -8F, 6, 6, 8);
    body.setRotationPoint(0F, 19F, 1F);
    body.setTextureSize(64, 32);
    body.mirror = true;
    setRotation(body, 0F, 0F, 0F);
    rwing = new RendererModel(this, 29, 9);
    rwing.addBox(0F, 0F, -6F, 1, 4, 6);
    rwing.setRotationPoint(3F, 13F, 0F);
    rwing.setTextureSize(64, 32);
    rwing.mirror = true;
    setRotation(rwing, 0F, 0F, 0F);
    head = new RendererModel(this, 0, 0);
    head.addBox(-2F, -6F, -5F, 4, 6, 3);
    head.setRotationPoint(0F, 16F, -4F);
    head.setTextureSize(64, 32);
    head.mirror = true;
    setRotation(head, 0F, 0F, 0F);
    lwing = new RendererModel(this, 29, 20);
    lwing.addBox(-1F, 0F, -6F, 1, 4, 6);
    lwing.setRotationPoint(-3F, 13F, 0F);
    lwing.setTextureSize(64, 32);
    lwing.mirror = true;
    setRotation(lwing, 0F, 0F, 0F);
    bill = new RendererModel(this, 14, 0);
    bill.addBox(-2F, -4F, -7F, 4, 2, 2);
    bill.setRotationPoint(0F, 16F, -4F);
    bill.setTextureSize(64, 32);
    bill.mirror = true;
    setRotation(bill, 0F, 0F, 0F);
    chin = new RendererModel(this, 14, 4);
    chin.addBox(-1F, -2F, -6F, 2, 2, 2);
    chin.setRotationPoint(0F, 16F, -4F);
    chin.setTextureSize(64, 32);
    chin.mirror = true;
    setRotation(chin, 0F, 0F, 0F);
    Back_Plate = new RendererModel(this, 0, 25);
    Back_Plate.addBox(-2F, 0F, -6F, 4, 1, 5);
    Back_Plate.setRotationPoint(0F, 12F, 0F);
    Back_Plate.setTextureSize(64, 32);
    Back_Plate.mirror = true;
    setRotation(Back_Plate, 0F, 0F, 0F);
    Head_Spike_1 = new RendererModel(this, 27, 0);
    Head_Spike_1.addBox(-1F, -7F, -3.5F, 1, 2, 2);
    Head_Spike_1.setRotationPoint(0F, 16F, -4F);
    Head_Spike_1.setTextureSize(64, 32);
    Head_Spike_1.mirror = true;
    setRotation(Head_Spike_1, 0F, 0F, 0.5F);
    Head_Spike_2 = new RendererModel(this, 27, 0);
    Head_Spike_2.addBox(-0.5F, -7F, -3F, 1, 2, 2);
    Head_Spike_2.setRotationPoint(0F, 16F, -4F);
    Head_Spike_2.setTextureSize(64, 32);
    Head_Spike_2.mirror = true;
    setRotation(Head_Spike_2, 0F, 0F, 0F);
    Head_Spike_3 = new RendererModel(this, 27, 0);
    Head_Spike_3.addBox(0F, -7F, -3F, 1, 2, 2);
    Head_Spike_3.setRotationPoint(0F, 16F, -4F);
    Head_Spike_3.setTextureSize(64, 32);
    Head_Spike_3.mirror = true;
    setRotation(Head_Spike_3, 0F, 0F, -0.5F);
  }
  
  public void render(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
  {
      super.render(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);

      if (isChild)
      {
    	  setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entity);
    	  float f6 = 2.0F;
          GL11.glPushMatrix();
          GL11.glTranslatef(0.0F, 5.0F * scale, 3.0F * scale);
          head.render(scale);
          bill.render(scale);
          chin.render(scale);
          //Head_Spike_1.render(scale);
          Head_Spike_2.render(scale);
          //Head_Spike_3.render(scale);
          GL11.glPopMatrix();
          GL11.glPushMatrix();
          GL11.glScalef(1.0F / f6, 1.0F / f6, 1.0F / f6);
          GL11.glTranslatef(0.0F, 24.0F * scale, 0.0F);
          body.render(scale);
          rleg.render(scale);
          lleg.render(scale);
          rwing.render(scale);
          lwing.render(scale);
          Back_Plate.render(scale);
          GL11.glPopMatrix();
      }
      else
      {
          setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entity);
          body.render(scale);
          lwing.render(scale);
          rwing.render(scale);
          head.render(scale);
          bill.render(scale);
          chin.render(scale);
          rleg.render(scale);
          lleg.render(scale);
          Back_Plate.render(scale);
          //Head_Spike_1.render(scale);
          Head_Spike_2.render(scale);
          //Head_Spike_3.render(scale);
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
      rwing.rotateAngleZ = -ageInTicks;
      lwing.rotateAngleZ = ageInTicks;
      //Head_Spike_1.rotateAngleX = head.rotateAngleX;
      //Head_Spike_1.rotateAngleY = head.rotateAngleY;
      Head_Spike_2.rotateAngleX = head.rotateAngleX;
      Head_Spike_2.rotateAngleY = head.rotateAngleY;
      //Head_Spike_3.rotateAngleX = head.rotateAngleX;
      //Head_Spike_3.rotateAngleY = head.rotateAngleY;
  }

}
