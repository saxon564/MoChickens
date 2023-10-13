// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class GiantChickenModel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "giantchickenmodel"), "main");
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart rightHorn;
	private final ModelPart leftHorn;
	private final ModelPart rightWing;
	private final ModelPart chin;
	private final ModelPart beak;
	private final ModelPart leftWing;
	private final ModelPart leftLeg;
	private final ModelPart rightLeg;
	private final ModelPart facePlate;
	private final ModelPart centerHorn;
	private final ModelPart mane;
	private final ModelPart backPlate;
	private final ModelPart backLeftLeg;
	private final ModelPart backRightLeg;
	private final ModelPart frontLeftLeg;
	private final ModelPart frontRightLeg;

	public GiantChickenModel(ModelPart root) {
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.rightHorn = root.getChild("rightHorn");
		this.leftHorn = root.getChild("leftHorn");
		this.rightWing = root.getChild("rightWing");
		this.chin = root.getChild("chin");
		this.beak = root.getChild("beak");
		this.leftWing = root.getChild("leftWing");
		this.leftLeg = root.getChild("leftLeg");
		this.rightLeg = root.getChild("rightLeg");
		this.facePlate = root.getChild("facePlate");
		this.centerHorn = root.getChild("centerHorn");
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

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(75, 33).addBox(-6.0F, -9.0F, -9.0F, 12.0F, 18.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.0F, -6.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-9.0F, -33.0F, -9.0F, 18.0F, 18.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition rightHorn = partdefinition.addOrReplaceChild("rightHorn", CubeListBuilder.create().texOffs(12, 0).addBox(-6.0F, -12.0F, -3.0F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.0F, -6.0F));

		PartDefinition leftHorn = partdefinition.addOrReplaceChild("leftHorn", CubeListBuilder.create().texOffs(0, 0).addBox(3.0F, -12.0F, -3.0F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.0F, -6.0F));

		PartDefinition rightWing = partdefinition.addOrReplaceChild("rightWing", CubeListBuilder.create().texOffs(0, 42).addBox(-3.0F, 0.0F, -9.0F, 3.0F, 12.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(-9.0F, -9.0F, 6.0F));

		PartDefinition chin = partdefinition.addOrReplaceChild("chin", CubeListBuilder.create().texOffs(0, 51).addBox(-3.0F, 3.0F, -12.0F, 6.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.0F, -6.0F));

		PartDefinition beak = partdefinition.addOrReplaceChild("beak", CubeListBuilder.create().texOffs(60, 0).addBox(-6.0F, -3.0F, -15.0F, 12.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.0F, -6.0F));

		PartDefinition leftWing = partdefinition.addOrReplaceChild("leftWing", CubeListBuilder.create().texOffs(42, 42).addBox(0.0F, 0.0F, -9.0F, 3.0F, 12.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(9.0F, -9.0F, 6.0F));

		PartDefinition leftLeg = partdefinition.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(0, 72).addBox(0.0F, 0.0F, -6.0F, 9.0F, 15.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 9.0F, 9.0F));

		PartDefinition rightLeg = partdefinition.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(36, 72).addBox(-9.0F, 0.0F, 0.0F, 9.0F, 15.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 9.0F, 3.0F));

		PartDefinition facePlate = partdefinition.addOrReplaceChild("facePlate", CubeListBuilder.create().texOffs(0, 42).addBox(-3.0F, -9.0F, -12.0F, 6.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.0F, -6.0F));

		PartDefinition centerHorn = partdefinition.addOrReplaceChild("centerHorn", CubeListBuilder.create().texOffs(96, 78).addBox(-1.5F, -13.5F, -6.0F, 3.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.0F, -6.0F));

		PartDefinition mane = partdefinition.addOrReplaceChild("mane", CubeListBuilder.create().texOffs(24, 42).addBox(-7.5F, -10.5F, -1.5F, 15.0F, 15.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.0F, -6.0F));

		PartDefinition backPlate = partdefinition.addOrReplaceChild("backPlate", CubeListBuilder.create().texOffs(69, 60).addBox(-6.0F, -36.0F, -6.0F, 12.0F, 3.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition backLeftLeg = partdefinition.addOrReplaceChild("backLeftLeg", CubeListBuilder.create().texOffs(141, 33).addBox(0.0F, 0.0F, -6.0F, 9.0F, 15.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 9.0F, 12.0F));

		PartDefinition backRightLeg = partdefinition.addOrReplaceChild("backRightLeg", CubeListBuilder.create().texOffs(141, 3).addBox(-3.0F, 0.0F, -6.0F, 9.0F, 15.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(-9.0F, 9.0F, 12.0F));

		PartDefinition frontLeftLeg = partdefinition.addOrReplaceChild("frontLeftLeg", CubeListBuilder.create().texOffs(114, 18).addBox(0.0F, 0.0F, -3.0F, 9.0F, 15.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 9.0F, -6.0F));

		PartDefinition frontRightLeg = partdefinition.addOrReplaceChild("frontRightLeg", CubeListBuilder.create().texOffs(87, 3).addBox(-3.0F, 0.0F, -3.0F, 9.0F, 15.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(-9.0F, 9.0F, -6.0F));

		return LayerDefinition.create(meshdefinition, 192, 96);
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
		rightWing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		chin.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		beak.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftWing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		facePlate.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		centerHorn.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		mane.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		backPlate.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		backLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		backRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		frontLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		frontRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}