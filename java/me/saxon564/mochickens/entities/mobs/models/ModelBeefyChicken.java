package me.saxon564.mochickens.entities.mobs.models;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelBeefyChicken extends ModelBase
{
  //fields
    ModelRenderer Head;
    ModelRenderer Body;
    ModelRenderer Left_Horn;
    ModelRenderer Right_Horn;
    ModelRenderer Bill;
    ModelRenderer Chin;
    ModelRenderer Left_Foot;
    ModelRenderer Right_Foot;
    ModelRenderer Left_Wing;
    ModelRenderer Right_Wing;
  
  public ModelBeefyChicken()
  {
    textureWidth = 64;
    textureHeight = 32;
    
    Head = new ModelRenderer(this, 0, 0);
    Head.addBox(-2F, -6F, -4F, 4, 6, 4);
    Head.setRotationPoint(0F, 17F, -1F);
    Head.setTextureSize(64, 32);
    Head.mirror = true;
    setRotation(Head, 0F, 0F, 0F);
    Body = new ModelRenderer(this, 25, 0);
    Body.addBox(-3F, -3F, 0F, 6, 6, 8);
    Body.setRotationPoint(0F, 17F, -2F);
    Body.setTextureSize(64, 32);
    Body.mirror = true;
    setRotation(Body, 0F, 0F, 0F);
    Left_Horn = new ModelRenderer(this, 17, 0);
    Left_Horn.addBox(2F, -7F, -1F, 1, 2, 1);
    Left_Horn.setRotationPoint(0F, 17F, -1F);
    Left_Horn.setTextureSize(64, 32);
    Left_Horn.mirror = true;
    setRotation(Left_Horn, 0F, 0F, 0F);
    Right_Horn = new ModelRenderer(this, 17, 0);
    Right_Horn.addBox(-3F, -9F, -1F, 1, 2, 1);
    Right_Horn.setRotationPoint(0F, 19F, -1F);
    Right_Horn.setTextureSize(64, 32);
    Right_Horn.mirror = true;
    setRotation(Right_Horn, 0F, 0F, 0F);
    Bill = new ModelRenderer(this, 27, 16);
    Bill.addBox(-2F, -4F, -6F, 4, 2, 2);
    Bill.setRotationPoint(0F, 17F, -1F);
    Bill.setTextureSize(64, 32);
    Bill.mirror = true;
    setRotation(Bill, 0F, 0F, 0F);
    Chin = new ModelRenderer(this, 17, 4);
    Chin.addBox(-1F, -2F, -5F, 2, 2, 1);
    Chin.setRotationPoint(0F, 17F, -1F);
    Chin.setTextureSize(64, 32);
    Chin.mirror = true;
    setRotation(Chin, 0F, 0F, 0F);
    Left_Foot = new ModelRenderer(this, 0, 25);
    Left_Foot.addBox(-1F, 0F, -1F, 2, 4, 2);
    Left_Foot.setRotationPoint(2F, 20F, 3F);
    Left_Foot.setTextureSize(64, 32);
    Left_Foot.mirror = true;
    setRotation(Left_Foot, 0F, 0F, 0F);
    Right_Foot = new ModelRenderer(this, 0, 25);
    Right_Foot.addBox(-1F, 0F, -1F, 2, 4, 2);
    Right_Foot.setRotationPoint(-2F, 20F, 3F);
    Right_Foot.setTextureSize(64, 32);
    Right_Foot.mirror = true;
    setRotation(Right_Foot, 0F, 0F, 0F);
    Left_Wing = new ModelRenderer(this, 13, 14);
    Left_Wing.addBox(0F, -1F, -1F, 1, 4, 5);
    Left_Wing.setRotationPoint(3F, 15F, 0F);
    Left_Wing.setTextureSize(64, 32);
    Left_Wing.mirror = true;
    setRotation(Left_Wing, 0F, 0F, 0F);
    Right_Wing = new ModelRenderer(this, 0, 14);
    Right_Wing.addBox(-1F, -1F, -1F, 1, 4, 5);
    Right_Wing.setRotationPoint(-3F, 15F, 0F);
    Right_Wing.setTextureSize(64, 32);
    Right_Wing.mirror = true;
    setRotation(Right_Wing, 0F, 0F, 0F);
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
        this.Left_Horn.render(f5);
        this.Right_Horn.render(f5);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glScalef(1.0F / f6, 1.0F / f6, 1.0F / f6);
        GL11.glTranslatef(0.0F, 24.0F * f5, 0.0F);
        this.Body.render(f5);
        this.Right_Foot.render(f5);
        this.Left_Foot.render(f5);
        this.Right_Wing.render(f5);
        this.Left_Wing.render(f5);
        GL11.glPopMatrix();
    }
    else
    {
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Head.render(f5);
    Body.render(f5);
    Left_Horn.render(f5);
    Right_Horn.render(f5);
    Bill.render(f5);
    Chin.render(f5);
    Left_Foot.render(f5);
    Right_Foot.render(f5);
    Left_Wing.render(f5);
    Right_Wing.render(f5);
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
      this.Left_Horn.rotateAngleX = this.Head.rotateAngleX;
      this.Left_Horn.rotateAngleY = this.Head.rotateAngleY;
      this.Right_Horn.rotateAngleX = this.Head.rotateAngleX;
      this.Right_Horn.rotateAngleY = this.Head.rotateAngleY;
      this.Right_Foot.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
      this.Left_Foot.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
      this.Right_Wing.rotateAngleZ = par3;
      this.Left_Wing.rotateAngleZ = -par3;
  }

}
