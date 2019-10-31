package com.saxon564.mochickens.entities.mobs.models;

import org.lwjgl.opengl.GL11;

import com.saxon564.mochickens.entities.mobs.EntityMoChicken;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelGoldChicken<T extends EntityMoChicken> extends EntityModel<T>
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
  
  public void render(T entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
      super.render(entity, f, f1, f2, f3, f4, f5);

      if (isChild)
      {
    	  setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    	  float f6 = 2.0F;
          GL11.glPushMatrix();
          GL11.glTranslatef(0.0F, 5.0F * f5, 3.0F * f5);
          head.render(f5);
          bill.render(f5);
          chin.render(f5);
          //Head_Spike_1.render(f5);
          Head_Spike_2.render(f5);
          //Head_Spike_3.render(f5);
          GL11.glPopMatrix();
          GL11.glPushMatrix();
          GL11.glScalef(1.0F / f6, 1.0F / f6, 1.0F / f6);
          GL11.glTranslatef(0.0F, 24.0F * f5, 0.0F);
          body.render(f5);
          rleg.render(f5);
          lleg.render(f5);
          rwing.render(f5);
          lwing.render(f5);
          Back_Plate.render(f5);
          GL11.glPopMatrix();
      }
      else
      {
          setRotationAngles(f, f1, f2, f3, f4, f5, entity);
          body.render(f5);
          lwing.render(f5);
          rwing.render(f5);
          head.render(f5);
          bill.render(f5);
          chin.render(f5);
          rleg.render(f5);
          lleg.render(f5);
          Back_Plate.render(f5);
          //Head_Spike_1.render(f5);
          Head_Spike_2.render(f5);
          //Head_Spike_3.render(f5);
      }
  }

  private void setRotation(RendererModel model, float x, float y, float z)
  {
      model.rotateAngleX = x;
      model.rotateAngleY = y;
      model.rotateAngleZ = z;
  }

  public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity)
  {
      head.rotateAngleX = par5 / (180F / (float)Math.PI);
      head.rotateAngleY = par4 / (180F / (float)Math.PI);
      bill.rotateAngleX = head.rotateAngleX;
      bill.rotateAngleY = head.rotateAngleY;
      chin.rotateAngleX = head.rotateAngleX;
      chin.rotateAngleY = head.rotateAngleY;
      rleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
      lleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
      rwing.rotateAngleZ = -par3;
      lwing.rotateAngleZ = par3;
      //Head_Spike_1.rotateAngleX = head.rotateAngleX;
      //Head_Spike_1.rotateAngleY = head.rotateAngleY;
      Head_Spike_2.rotateAngleX = head.rotateAngleX;
      Head_Spike_2.rotateAngleY = head.rotateAngleY;
      //Head_Spike_3.rotateAngleX = head.rotateAngleX;
      //Head_Spike_3.rotateAngleY = head.rotateAngleY;
  }

}
