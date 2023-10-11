package com.saxon564.mochickens.entities.mobs.models;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.saxon564.mochickens.Reference;
import com.saxon564.mochickens.configs.ChickenConfigGenerator;

import net.minecraft.client.model.AgeableListModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class MoChickenModel<T extends Entity> extends AgeableListModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation(Reference.MOD_ID, "mochickenmodel"), "main");
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart leftWing;
	private final ModelPart rightWing;
	private final ModelPart beak;
	private final ModelPart chin;
	private final ModelPart leftHorn;
	private final ModelPart centerHorn;
	private final ModelPart rightHorn;
	private final ModelPart leftLeg;
	private final ModelPart rightLeg;
	private final ModelPart facePlate;
	private final ModelPart mane;
	private final ModelPart backPlate;
	private final ModelPart backLeftLeg;
	private final ModelPart backRightLeg;
	private final ModelPart frontLeftLeg;
	private final ModelPart frontRightLeg;
	private static ChickenConfigGenerator config;

	public MoChickenModel(ModelPart root, ChickenConfigGenerator configs) {
		config = configs;
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.leftWing = root.getChild("leftWing");
		this.rightWing = root.getChild("rightWing");
		this.beak = root.getChild("beak");
		
		if (config.USE_CHIN.get()) {
			this.chin = root.getChild("chin");
		} else {
			this.chin = null;
		}
		
		if (config.USE_CHICKEN_FEET.get()) {
			this.leftLeg = root.getChild("leftLeg");
			this.rightLeg = root.getChild("rightLeg");
		} else {
			this.leftLeg = null;
			this.rightLeg = null;
		}
		
		if (config.USE_FACE_PLATE.get()) {
			this.facePlate = root.getChild("facePlate");
		} else {
			this.facePlate = null;
		}
		
		if (config.USE_MANE.get()) {
			this.mane = root.getChild("mane");
		} else {
			this.mane = null;
		}
		
		if (config.USE_BACK_PLATE.get()) {
			this.backPlate = root.getChild("backPlate");
		} else {
			this.backPlate = null;
		}
		
		if (config.USE_CREEPER_FEET.get()) {
			this.backLeftLeg = root.getChild("backLeftLeg");
			this.backRightLeg = root.getChild("backRightLeg");
			this.frontLeftLeg = root.getChild("frontLeftLeg");
			this.frontRightLeg = root.getChild("frontRightLeg");
		} else {
			this.backLeftLeg = null;
			this.backRightLeg = null;
			this.frontLeftLeg = null;
			this.frontRightLeg = null;
		}
		
		if (config.USE_LEFT_HORN.get()) {
			this.leftHorn = root.getChild("leftHorn");
		} else {
			this.leftHorn = null;
		}
		
		if (config.USE_CENTER_HORN.get()) {
			this.centerHorn = root.getChild("centerHorn");
		} else {
			this.centerHorn = null;
		}
		
		if (config.USE_RIGHT_HORN.get()) {
			this.rightHorn = root.getChild("rightHorn");
		} else {
			this.rightHorn = null;
		}
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(25, 11).addBox(-2.0F, -3.0F, -3.0F,
				4.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 13.0F, -2.0F));
		partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -11.0F, -3.0F,
				6.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
		partdefinition.addOrReplaceChild("rightHorn", CubeListBuilder.create().texOffs(4, 0).addBox(-2.0F, -4.0F, -1.0F,
				1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 13.0F, -2.0F));
		partdefinition.addOrReplaceChild("centerHorn", CubeListBuilder.create().texOffs(32, 26).addBox(-0.5F, -15.5F,
				-4.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 13.0F, -2.0F));
		partdefinition.addOrReplaceChild("leftHorn", CubeListBuilder.create().texOffs(0, 0).addBox(1.0F, -4.0F, -1.0F,
				1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 13.0F, -2.0F));
		partdefinition.addOrReplaceChild("leftWing", CubeListBuilder.create().texOffs(0, 14).addBox(-1.0F, 0.0F, -3.0F,
				1.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 13.0F, 2.0F));
		partdefinition.addOrReplaceChild("chin", CubeListBuilder.create().texOffs(0, 17).addBox(-1.0F, 1.0F, -4.0F,
				2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 13.0F, -2.0F));
		partdefinition.addOrReplaceChild("beak", CubeListBuilder.create().texOffs(20, 0).addBox(-2.0F, -1.0F, -5.0F,
				4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 13.0F, -2.0F));
		partdefinition.addOrReplaceChild("rightWing", CubeListBuilder.create().texOffs(14, 14).addBox(0.0F, 0.0F, -3.0F,
				1.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 13.0F, 2.0F));
		partdefinition.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(12, 24).addBox(0.0F, 0.0F, -1.0F,
				3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 19.0F, 1.0F));
		partdefinition.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(0, 24).addBox(-3.0F, 0.0F, -1.0F,
				3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 19.0F, 1.0F));
		partdefinition.addOrReplaceChild("facePlate", CubeListBuilder.create().texOffs(0, 14).addBox(-1.0F, -14.0F,
				-6.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
		partdefinition.addOrReplaceChild("mane", CubeListBuilder.create().texOffs(8, 14).addBox(-2.5F, -14.5F, -2.5F,
				5.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
		partdefinition.addOrReplaceChild("backPlate", CubeListBuilder.create().texOffs(23, 20).addBox(-2.0F, -12.0F,
				-2.0F, 4.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
		partdefinition.addOrReplaceChild("backLeftLeg", CubeListBuilder.create().texOffs(47, 11).addBox(0.0F, 0.0F,
				-2.0F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 19.0F, 4.0F));
		partdefinition.addOrReplaceChild("backRightLeg", CubeListBuilder.create().texOffs(47, 1).addBox(-3.0F, 0.0F,
				-2.0F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 19.0F, 4.0F));
		partdefinition.addOrReplaceChild("frontLeftLeg", CubeListBuilder.create().texOffs(38, 6).addBox(0.0F, 0.0F,
				-1.0F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 19.0F, -2.0F));
		partdefinition.addOrReplaceChild("frontRightLeg", CubeListBuilder.create().texOffs(29, 1).addBox(-3.0F, 0.0F,
				-1.0F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 19.0F, -2.0F));
		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.head.xRot = headPitch * ((float) Math.PI / 180F);
		this.head.yRot = netHeadYaw * ((float) Math.PI / 180F);
		this.beak.xRot = this.head.xRot;
		this.beak.yRot = this.head.yRot;
		if (config.USE_LEFT_HORN.get()) {
			this.leftHorn.xRot = this.head.xRot;
			this.leftHorn.yRot = this.head.yRot;
		}
		if (config.USE_CENTER_HORN.get()) {
			this.centerHorn.xRot = this.head.xRot;
			this.centerHorn.yRot = this.head.yRot;
		}
		if (config.USE_RIGHT_HORN.get()) {
			this.rightHorn.xRot = this.head.xRot;
			this.rightHorn.yRot = this.head.yRot;
		}
		if (config.USE_FACE_PLATE.get()) {
			this.facePlate.xRot = this.head.xRot;
			this.facePlate.yRot = this.head.yRot;
		}
		if (config.USE_MANE.get()) {
			this.mane.xRot = this.head.xRot;
			this.mane.yRot = this.head.yRot;
		}
		if (config.USE_CHIN.get()) {
			this.chin.xRot = this.head.xRot;
			this.chin.yRot = this.head.yRot;
		}
		if (config.USE_CHICKEN_FEET.get()) {
			this.rightLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.leftLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		}
		if (config.USE_CREEPER_FEET.get()) {
			this.backRightLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.backLeftLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
			this.frontRightLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.frontLeftLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		}
		this.rightWing.zRot = -ageInTicks;
		this.leftWing.zRot = ageInTicks;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		if (config.USE_LEFT_HORN.get()) leftHorn.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		if (config.USE_CENTER_HORN.get()) centerHorn.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		if (config.USE_RIGHT_HORN.get()) rightHorn.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftWing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		if (config.USE_CHIN.get()) chin.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		beak.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightWing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		if (config.USE_CHICKEN_FEET.get()) {
			leftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
			rightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		}
		if (config.USE_CREEPER_FEET.get()) {
			frontLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
			frontRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
			backLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
			backRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		}
		if (config.USE_FACE_PLATE.get()) facePlate.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		if (config.USE_MANE.get()) mane.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		if (config.USE_BACK_PLATE.get()) backPlate.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	protected Iterable<ModelPart> headParts() {
		return ImmutableList.of(this.head, this.beak, this.chin, this.leftHorn, this.centerHorn, this.rightHorn,
				this.facePlate, this.mane);
	}

	@Override
	protected Iterable<ModelPart> bodyParts() {
		return ImmutableList.of(this.body, this.leftLeg, this.rightLeg, this.rightWing, this.rightWing, this.backPlate,
				this.frontLeftLeg, this.frontRightLeg, this.backLeftLeg, this.backRightLeg);
	}
}