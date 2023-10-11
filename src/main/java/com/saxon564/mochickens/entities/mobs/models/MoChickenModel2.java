// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class MoChickenModel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "mochickenmodel"), "main");
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart rightHorn;
	private final ModelPart leftHorn;
	private final ModelPart leftWing;
	private final ModelPart chin;
	private final ModelPart beak;
	private final ModelPart rightWing;
	private final ModelPart leftLeg;
	private final ModelPart rightLeg;
	private final ModelPart facePlate;
	private final ModelPart leftSpike;
	private final ModelPart centerSpike;
	private final ModelPart rightSpike;
	private final ModelPart mane;
	private final ModelPart backPlate;
	private final ModelPart backLeftLeg;
	private final ModelPart backRightLeg;
	private final ModelPart frontLeftLeg;
	private final ModelPart frontRightLeg;

	public MoChickenModel(ModelPart root) {
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.rightHorn = root.getChild("rightHorn");
		this.leftHorn = root.getChild("leftHorn");
		this.leftWing = root.getChild("leftWing");
		this.chin = root.getChild("chin");
		this.beak = root.getChild("beak");
		this.rightWing = root.getChild("rightWing");
		this.leftLeg = root.getChild("leftLeg");
		this.rightLeg = root.getChild("rightLeg");
		this.facePlate = root.getChild("facePlate");
		this.leftSpike = root.getChild("leftSpike");
		this.centerSpike = root.getChild("centerSpike");
		this.rightSpike = root.getChild("rightSpike");
		this.mane = root.getChild("mane");
		this.backPlate = root.getChild("backPlate");
		this.backLeftLeg = root.getChild("backLeftLeg");
		this.backRightLeg = root.getChild("backRightLeg");
		this.frontLeftLeg = root.getChild("frontLeftLeg");
		this.frontRightLeg = root.getChild("frontRightLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(25, 11).addBox(-2.0F, -3.0F, -3.0F, 4.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 13.0F, -2.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -11.0F, -3.0F, 6.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition rightHorn = partdefinition.addOrReplaceChild("rightHorn", CubeListBuilder.create().texOffs(4, 0).addBox(-2.0F, -4.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 13.0F, -2.0F));

		PartDefinition leftHorn = partdefinition.addOrReplaceChild("leftHorn", CubeListBuilder.create().texOffs(0, 0).addBox(1.0F, -4.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 13.0F, -2.0F));

		PartDefinition leftWing = partdefinition.addOrReplaceChild("leftWing", CubeListBuilder.create().texOffs(0, 14).addBox(-1.0F, 0.0F, -3.0F, 1.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 13.0F, 2.0F));

		PartDefinition chin = partdefinition.addOrReplaceChild("chin", CubeListBuilder.create().texOffs(0, 17).addBox(-1.0F, 1.0F, -4.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 13.0F, -2.0F));

		PartDefinition beak = partdefinition.addOrReplaceChild("beak", CubeListBuilder.create().texOffs(20, 0).addBox(-2.0F, -1.0F, -5.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 13.0F, -2.0F));

		PartDefinition rightWing = partdefinition.addOrReplaceChild("rightWing", CubeListBuilder.create().texOffs(14, 14).addBox(0.0F, 0.0F, -3.0F, 1.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 13.0F, 2.0F));

		PartDefinition leftLeg = partdefinition.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(12, 24).addBox(0.0F, 0.0F, -2.0F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 19.0F, 3.0F));

		PartDefinition rightLeg = partdefinition.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(0, 24).addBox(-3.0F, 0.0F, 0.0F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 19.0F, 1.0F));

		PartDefinition facePlate = partdefinition.addOrReplaceChild("facePlate", CubeListBuilder.create().texOffs(0, 14).addBox(-1.0F, -14.0F, -6.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition leftSpike = partdefinition.addOrReplaceChild("leftSpike", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition leftSpike_r1 = leftSpike.addOrReplaceChild("leftSpike_r1", CubeListBuilder.create().texOffs(24, 26).addBox(-1.0F, -4.5F, -2.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0F, -2.0F, 0.0F, 0.0F, 0.6981F));

		PartDefinition centerSpike = partdefinition.addOrReplaceChild("centerSpike", CubeListBuilder.create().texOffs(32, 26).addBox(-0.5F, -15.5F, -4.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition rightSpike = partdefinition.addOrReplaceChild("rightSpike", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition rightSpike_r1 = rightSpike.addOrReplaceChild("rightSpike_r1", CubeListBuilder.create().texOffs(28, 28).addBox(0.0F, -4.5F, -2.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0F, -2.0F, 0.0F, 0.0F, -0.6981F));

		PartDefinition mane = partdefinition.addOrReplaceChild("mane", CubeListBuilder.create().texOffs(8, 14).addBox(-2.5F, -14.5F, -2.5F, 5.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition backPlate = partdefinition.addOrReplaceChild("backPlate", CubeListBuilder.create().texOffs(23, 20).addBox(-2.0F, -12.0F, -2.0F, 4.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition backLeftLeg = partdefinition.addOrReplaceChild("backLeftLeg", CubeListBuilder.create().texOffs(47, 11).addBox(0.0F, 0.0F, -2.0F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 19.0F, 4.0F));

		PartDefinition backRightLeg = partdefinition.addOrReplaceChild("backRightLeg", CubeListBuilder.create().texOffs(47, 1).addBox(-3.0F, 0.0F, -2.0F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 19.0F, 4.0F));

		PartDefinition frontLeftLeg = partdefinition.addOrReplaceChild("frontLeftLeg", CubeListBuilder.create().texOffs(38, 6).addBox(0.0F, 0.0F, -1.0F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 19.0F, -2.0F));

		PartDefinition frontRightLeg = partdefinition.addOrReplaceChild("frontRightLeg", CubeListBuilder.create().texOffs(29, 1).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 19.0F, -2.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightHorn.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftHorn.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftWing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		chin.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		beak.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightWing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		facePlate.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftSpike.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		centerSpike.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightSpike.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		mane.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		backPlate.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		backLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		backRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		frontLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		frontRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}