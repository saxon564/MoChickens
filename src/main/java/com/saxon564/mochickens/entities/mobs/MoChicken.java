package com.saxon564.mochickens.entities.mobs;

import javax.annotation.Nullable;

import com.saxon564.mochickens.MoChickens;
import com.saxon564.mochickens.configs.ChickenConfigGenerator;
import com.saxon564.mochickens.entities.mobs.ai.ChickAIAttackRangedBow;
import com.saxon564.mochickens.entities.mobs.ai.ChickAISwell;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;
import net.minecraftforge.registries.ForgeRegistries;

public class MoChicken extends TamableAnimal implements RangedAttackMob {
	public float flap;
	public float flapSpeed;
	public float oFlapSpeed;
	public float oFlap;
	public float flapping = 1.0F;
	private float nextFlap = 1.0F;
	public int eggTime;
	public boolean isChickenJockey;

	// private EntityType<?> chicken;
	protected ChickenConfigGenerator config;
	
	private ChickAIAttackRangedBow aiArrowAttack;
	private ChickAISwell aiSwell;

	public MoChicken(EntityType<? extends MoChicken> entityType, Level world, ChickenConfigGenerator configs) {
		super(entityType, world);
		// chicken = entityType;
		config = configs;
		this.eggTime = this.random.nextInt(config.VARIABLE_LAYING_TIME.get()) + config.MINIMUM_LAYING_TIME.get();
		this.setPathfindingMalus(BlockPathTypes.WATER, 0.0F);
		String items = config.TEMPTING_ITEMS.get();
		String[] temptingItems = items.split(",");
		for (String listItem : temptingItems) {
			listItem = stripArrayCharacters(listItem);
			Item ingredient = ForgeRegistries.ITEMS.getValue(new ResourceLocation(listItem));
			this.goalSelector.addGoal(3, new TemptGoal(this, 1.0D, Ingredient.of(ingredient), false));
		}
	}
	
	public ChickenConfigGenerator getConfig() {
		return config;
	}

	protected void registerGoals() {
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.4D));
		this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1D));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
	}

	public static AttributeSupplier.Builder createAttributes(double health, double speed) {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, health).add(Attributes.MOVEMENT_SPEED, speed);
	}

	protected float getStandingEyeHeight(Pose pose, EntityDimensions size) {
		return this.isBaby() ? size.height * 0.85F : size.height * 0.92F;
	}
	
	public void setTame(boolean tamed) {
		byte b0 = this.entityData.get(DATA_FLAGS_ID);
		if (tamed) {
			this.entityData.set(DATA_FLAGS_ID, (byte) (b0 | 4));
		} else {
			this.entityData.set(DATA_FLAGS_ID, (byte) (b0 & -5));
		}

		this.reassessTameGoals();
		
		setupTamedAI();
	}
	
	public void setupTamedAI() {
		if (isTame()) {
			
		} else if (config.IS_HOSTILE.get()){
			if (config.CAN_SHOOT_ARROWS.get()) {
				
			} else {
				
			}
			
			if (config.CAN_EXPLODE.get()) {
				
			}
		}
	}

	/*@SuppressWarnings("resource")
	public void aiStep() {
		super.aiStep();
		this.oFlap = this.flap;
		this.oFlapSpeed = this.flapSpeed;
		this.flapSpeed += (this.onGround() ? -1.0F : 4.0F) * 0.3F;
		this.flapSpeed = Mth.clamp(this.flapSpeed, 0.0F, 1.0F);
		if (!this.onGround() && this.flapping < 1.0F) {
			this.flapping = 1.0F;
		}

		this.flapping *= 0.9F;
		Vec3 vec3 = this.getDeltaMovement();
		if (!this.onGround() && vec3.y < 0.0D) {
			this.setDeltaMovement(vec3.multiply(1.0D, 0.6D, 1.0D));
		}

		this.flap += this.flapping * 2.0F;
		if (!this.level().isClientSide && this.isAlive() && !this.isBaby() && --this.eggTime <= 0) {
			if (isTame()) {
				String itemString = config.LAYING_ITEMS.get();
				String[] items = itemString.split(",");
				if (MoChickens.DEBUG)
					MoChickens.CHICKEN_LOGGER.debug("Laying Items: " + itemString);
				if (MoChickens.DEBUG)
					MoChickens.CHICKEN_LOGGER.debug("Laying Items Count: " + items.length);
				int rand = this.random.nextInt(items.length);
				String item = items[rand];
				item = stripArrayCharacters(item);
				if (!item.equalsIgnoreCase("")) {
					this.playSound(
							ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(config.LAYING_SOUND.get())),
							1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
					if (MoChickens.DEBUG)
						MoChickens.CHICKEN_LOGGER.debug("Tamed Laying Item: " + item);
					this.spawnAtLocation(ForgeRegistries.ITEMS.getValue(new ResourceLocation(item)));
				} else {
					MoChickens.CHICKEN_LOGGER.warn("Laying item returned empty!");
				}
			} else {
				this.playSound(SoundEvents.CHICKEN_EGG, 1.0F,
						(this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
				if (MoChickens.DEBUG)
					MoChickens.CHICKEN_LOGGER.debug("Untamed Laying Item: Egg");
				this.spawnAtLocation(Items.EGG);
			}
			this.gameEvent(GameEvent.ENTITY_PLACE);
			this.eggTime = this.random.nextInt(config.VARIABLE_LAYING_TIME.get()) + config.MINIMUM_LAYING_TIME.get();
		}

	}*/

	protected boolean isFlapping() {
		return this.flyDist > this.nextFlap;
	}

	protected void onFlap() {
		this.nextFlap = this.flyDist + this.flapSpeed / 2.0F;
	}

	protected SoundEvent getAmbientSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(config.LIVING_SOUND.get()));
	}

	protected SoundEvent getHurtSound(DamageSource source) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(config.HURT_SOUND.get()));
	}

	protected SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(config.DEATH_SOUND.get()));
	}

	protected void playStepSound(BlockPos blockPos, BlockState blackState) {
		this.playSound(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(config.STEP_SOUND.get())), 0.15F,
				1.0F);
	}

	@Nullable
	public Chicken getBreedOffspring(ServerLevel world, AgeableMob chicken) {
		return EntityType.CHICKEN.create(world);
	}

	public boolean isFood(ItemStack item, ConfigValue<String> targetItems) {
		boolean match = false;
		String itemString = targetItems.get();
		String[] items = itemString.split(",");
		for (String listItem : items) {
			listItem = stripArrayCharacters(listItem);
			boolean check = item
					.is(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(listItem))).getItemHolder());
			if (check)
				match = true;
		}
		return match;
	}

	public void readAdditionalSaveData(CompoundTag p_28243_) {
		super.readAdditionalSaveData(p_28243_);
		this.isChickenJockey = p_28243_.getBoolean("IsChickenJockey");
		if (p_28243_.contains("EggLayTime")) {
			this.eggTime = p_28243_.getInt("EggLayTime");
		}

	}

	public void addAdditionalSaveData(CompoundTag p_28257_) {
		super.addAdditionalSaveData(p_28257_);
		p_28257_.putBoolean("IsChickenJockey", this.isChickenJockey);
		p_28257_.putInt("EggLayTime", this.eggTime);
	}

	public void performRangedAttack(LivingEntity p_33317_, float p_33318_) {
		// TODO Auto-generated method stub

	}

	public boolean doHurtTarget(Entity target) {
		boolean flag = super.doHurtTarget(target);
		if (flag) {
			String potions = config.ATTACK_EFFECTS.get();
			String potionAmps = config.ATTACK_EFFECT_AMPLIFIERS.get();
			String potionDurations = config.ATTACK_EFFECT_DURATIONS.get();
			String[] potionList = potions.split(",");
			String[] potionAmpList = potionAmps.split(",");
			String[] potionDurationList = potionDurations.split(",");
			
			for (int index = 0; index < potionList.length; index++) {
				String potion = stripArrayCharacters(potionList[index]);
				String potionAmp = stripArrayCharacters(potionAmpList[index]);
				String potionDuration = stripArrayCharacters(potionDurationList[index]);
				((LivingEntity) target).addEffect(new MobEffectInstance(ForgeRegistries.MOB_EFFECTS.getValue(new ResourceLocation(potion)), Integer.getInteger(potionDuration), Integer.getInteger(potionAmp)), this);
			}
			if (config.SET_TARGET_ON_FIRE.get()) {
				target.setSecondsOnFire(config.DURATION_OF_FIRE_ON_TARGET.get());
			}
		}

		return flag;
	}

	public InteractionResult mobInteract(Player p_30412_, InteractionHand p_30413_) {
		ItemStack itemstack = p_30412_.getItemInHand(p_30413_);
		if (!isTame()) {
			if (isFood(itemstack, config.TAMING_ITEMS)) {
				if (!p_30412_.getAbilities().instabuild) {
					itemstack.shrink(1);
				}

				if (this.random.nextInt(config.TAMING_CHANCE.get()) == 0
						&& !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, p_30412_)) {
					this.tame(p_30412_);
					this.navigation.stop();
					this.setTarget((LivingEntity) null);
					this.setOrderedToSit(true);
					this.level().broadcastEntityEvent(this, (byte) 7);
				} else {
					this.level().broadcastEntityEvent(this, (byte) 6);
				}

				return InteractionResult.SUCCESS;
			} else {
				return super.mobInteract(p_30412_, p_30413_);
			}
		} else {
			return null;
		}
	}
	
	public String stripArrayCharacters(String entry) {
		if (MoChickens.DEBUG) MoChickens.CHICKEN_LOGGER.debug("Character Strip Entry: " + entry);
		if (entry.isEmpty() || entry.isBlank()) return "";
		String strippedEntry = entry.replaceAll("\\[", "");
		strippedEntry = strippedEntry.replaceAll("\\]", "");
		strippedEntry = strippedEntry.replaceAll(" ", "");
		return strippedEntry;
	}
}
