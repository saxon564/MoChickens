package com.saxon564.mochickens.entities.mobs.models;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.saxon564.mochickens.Reference;

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

public class MoChickenModelOld<T extends Entity> extends AgeableListModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation(Reference.MOD_ID, "mochickenmodel"), "main");
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart leftHorn;
	private final ModelPart rightHorn;
	private final ModelPart leftWing;
	private final ModelPart chin;
	private final ModelPart beak;
	private final ModelPart rightWing;
	private final ModelPart leftLeg;
	private final ModelPart rightLeg;

	public MoChickenModelOld(ModelPart root) {
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.leftHorn = root.getChild("leftHorn");
		this.rightHorn = root.getChild("rightHorn");
		this.leftWing = root.getChild("leftWing");
		this.chin = root.getChild("chin");
		this.beak = root.getChild("beak");
		this.rightWing = root.getChild("rightWing");
		this.leftLeg = root.getChild("leftLeg");
		this.rightLeg = root.getChild("rightLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		
		partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(25, 11).addBox(-2.0F, -3.0F, -3.0F,
				4.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 13.0F, -2.0F));
		partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -11.0F, -3.0F,
				6.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
		partdefinition.addOrReplaceChild("leftHorn", CubeListBuilder.create().texOffs(4, 0).addBox(-2.0F, -4.0F, -1.0F,
				1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 13.0F, -2.0F));
		partdefinition.addOrReplaceChild("rightHorn", CubeListBuilder.create().texOffs(0, 0).addBox(1.0F, -4.0F, -1.0F,
				1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 13.0F, -2.0F));
		partdefinition.addOrReplaceChild("leftWing", CubeListBuilder.create().texOffs(0, 14).addBox(-1.0F, 0.0F, -3.0F,
				1.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 13.0F, 2.0F));
		partdefinition.addOrReplaceChild("chin", CubeListBuilder.create().texOffs(0, 17).addBox(-1.0F, 1.0F, -4.0F,
				2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 13.0F, -2.0F));
		partdefinition.addOrReplaceChild("beak", CubeListBuilder.create().texOffs(20, 0).addBox(-2.0F, -1.0F, -5.0F,
				4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 13.0F, -2.0F));
		partdefinition.addOrReplaceChild("rightWing", CubeListBuilder.create().texOffs(14, 14).addBox(0.0F, 0.0F, -3.0F,
				1.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 13.0F, 2.0F));
		partdefinition.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(0, 24).addBox(0.0F, 0.0F, -1.0F,
				3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 19.0F, 1.0F));
		partdefinition.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(0, 24).addBox(-3.0F, 0.0F, -1.0F,
				3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 19.0F, 1.0F));
		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.head.xRot = headPitch * ((float) Math.PI / 180F);
		this.head.yRot = netHeadYaw * ((float) Math.PI / 180F);
		this.beak.xRot = this.head.xRot;
		this.beak.yRot = this.head.yRot;
		this.leftHorn.xRot = this.head.xRot;
		this.leftHorn.yRot = this.head.yRot;
		this.rightHorn.xRot = this.head.xRot;
		this.rightHorn.yRot = this.head.yRot;
		this.chin.xRot = this.head.xRot;
		this.chin.yRot = this.head.yRot;
		this.rightLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leftLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.rightWing.zRot = -ageInTicks;
		this.leftWing.zRot = ageInTicks;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftHorn.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightHorn.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftWing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		chin.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		beak.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightWing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	protected Iterable<ModelPart> headParts() {
		return ImmutableList.of(this.head, this.beak, this.chin, this.leftHorn, this.rightHorn);
	}

	@Override
	protected Iterable<ModelPart> bodyParts() {
		return ImmutableList.of(this.body, this.leftLeg, this.rightLeg, this.rightWing, this.rightWing);
	}
}