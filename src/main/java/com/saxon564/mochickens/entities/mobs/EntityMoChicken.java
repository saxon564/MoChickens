package com.saxon564.mochickens.entities.mobs;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.saxon564.mochickens.MoChickens;
import com.saxon564.mochickens.configs.ChickenConfigGenerator;
import com.saxon564.mochickens.configs.ConfigHandler;
import com.saxon564.mochickens.entities.mobs.ai.ChickAIAttackRangedBow;
import com.saxon564.mochickens.entities.mobs.ai.ChickAISwell;
import com.saxon564.mochickens.entities.mobs.ai.ChickAITempt;
import com.saxon564.mochickens.entities.mobs.ai.ChickNearestAttackableTarget;
import com.saxon564.mochickens.misc.ObjectTranslators;

import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.FleeSunGoal;
import net.minecraft.entity.ai.goal.FollowParentGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.RestrictSunGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleType;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.server.management.PreYggdrasilConverter;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.SectionPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Difficulty;
import net.minecraft.world.Explosion;
import net.minecraft.world.GameRules;
import net.minecraft.world.IWorld;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.NibbleArray;

public class EntityMoChicken extends TameableEntity implements IRangedAttackMob {
	private static final UUID attackingSpeedBoostModifierUUID = UUID
			.fromString("020E0DFB-87AE-4653-9556-831010E291A0");
	private static AttributeModifier attackingSpeedBoostModifier;
	
	private final Minecraft mc = Minecraft.getInstance();

	private Entity entityToAttack;
	private Entity lastEntityToAttack;
	private boolean isAggressive;
	private int teleportDelay;
	private static final DataParameter<Integer> STATE = EntityDataManager.<Integer>createKey(EntityMoChicken.class, DataSerializers.VARINT);
	private static final DataParameter<Boolean> SCREAMING = EntityDataManager.<Boolean>createKey(EntityMoChicken.class, DataSerializers.BOOLEAN);
	public static final DataParameter<Boolean> EXPLODINGCHICKENSYNDROME = EntityDataManager.<Boolean>createKey(EntityMoChicken.class, DataSerializers.BOOLEAN);
	public static final DataParameter<Boolean> MADCHICKENDISEASE = EntityDataManager.<Boolean>createKey(EntityMoChicken.class, DataSerializers.BOOLEAN);
	public static final DataParameter<Boolean> TRICKLECHICKENDISORDER = EntityDataManager.<Boolean>createKey(EntityMoChicken.class, DataSerializers.BOOLEAN);
	public static final DataParameter<Float> TRICKLEFACTOR = EntityDataManager.<Float>createKey(EntityMoChicken.class, DataSerializers.FLOAT);
	public static final DataParameter<String> OWNER = EntityDataManager.<String>createKey(EntityMoChicken.class, DataSerializers.STRING);
	
	public float field_70886_e = 0.0F;
	public float destPos = 0.0F;
	public float field_70884_g;
	public float field_70888_h;
	public float field_70889_i = 1.0F;
	private Difficulty checked = world.getDifficulty();
	private boolean despawn;
	private int ran;
	private EntityType<?> chicken;
	public boolean explodingByECS;
	
	/**********************************/
	/*********config variables*********/
	/**********************************/
	protected ChickenConfigGenerator config;
	
	// Attack Data
	protected boolean hostile;
	protected Effect[] effectIDs;
	protected int[] effectAmplifiers;
	protected int[] effectDurations;
	protected int arrowShootSpeed;
	protected double attackDamage;
	protected double attackSpeed;
	protected double attackTrackingRange;
	protected boolean canBlowUp;
	protected boolean canShootArrows;
	protected int explosionRadius;
	protected boolean movesWhenPrimed;
	protected double primedMovementSpeed;
	protected int fireDuration;
	protected int fuseTime;
	protected boolean setTargetOnFire;
	
	// Breeding
	protected boolean allowBreedingTamed;
	protected boolean allowBreedingWild;
	protected Item[] breedingItem;
	protected int growTime;
	protected Boolean childSpawnsTamed;
	protected Boolean ownerOnlyBreeding;
	
	// Entity Data
	protected boolean allowTeleporting;
	protected boolean burnsInSun;
	protected double damageFromWater;
	protected boolean despawnTamed;
	protected boolean despawnUntamed;
	protected boolean emitsLight;
	protected boolean emitsParticles;
	protected boolean getsHurtByWater;
	protected double health;
	protected double hitBoxSizeX;
	protected double hitBoxSizeZ;
	protected boolean immuneToFire;
	protected int lightLevelEmited;
	protected ParticleType<?>[] particleType;
	protected int[] particlesPerTick;
	protected String[] particleData;
	protected double walkSpeed;
	protected SoundEvent livingSound;
	protected SoundEvent hurtSound;
	protected SoundEvent deathSound;
	protected SoundEvent stepSound;
	protected Boolean canBeIgnited;
	
	// Laying
	protected boolean laysItemsTamed;
	protected boolean laysItemsWild;
	protected Item[] layingItem;
	protected int layingItemAmount;
	protected SoundEvent layingSound;
	protected int minItemLayTime;
	protected int variableItemLayTime;
	
	// Spawning
	protected boolean canSpawn;
	protected String biomeListType;
	protected Biome[] biomeList;
	protected int maxSpawnGroupSize;
	protected double maxSpawnTemp;
	protected int minSpawnGroupSize;
	protected double minSpawnTemp;
	protected int spawnProbability;
	protected int minSpawnLightLevel;
	protected int maxSpawnLightLevel;
	
	// Taming
	protected boolean canTame;
	protected int tamingChance;
	protected Item[] tamingItem;
	
	// Tempting
	protected boolean canTemptTamed;
	protected boolean canTemptWild;
	protected int delayFollowingBetweenItemHoldings;
	protected Item[] temptingItem;
	protected boolean ownerOnlyTempting;
	protected boolean temptScareByPlayer;
	protected double temptWalkingSpeed;
	
	//~~~~~~~~~~~~~~~~~Infections~~~~~~~~~~~~~~~~~\\
	// Exploding Chicken Syndrome
	protected boolean explodingChickenSyndrome;
	protected boolean eCSNotifyOwnerWhenInfected;
	protected boolean eCSInfectedWhenWild;
	protected boolean eCSInfectedWhenTamed;
	protected boolean eCSClearInfectionWhenTamed;
	protected int eCSBabyInfectionChance;
	protected int eCSInfectionChance;
	protected Boolean eCSDoesFalseFuse;
	protected int eCSFalseFuseChance;
	protected int eCSExplosionChance;
	
	//Mad Chicken Disease
	protected boolean madChickenDisease;
	protected boolean mCDNotifyOwnerWhenInfected;
	protected boolean mCDInfectedWhenWild;
	protected boolean mCDInfectedWhenTamed;
	protected boolean mCDClearInfectionWhenTamed;
	protected int mCDBabyInfectionChance;
	protected int mCDInfectionChance;
	
	//Trickle Chicken Disorder
	protected boolean trickleChickenDisorder;
	protected boolean tCDNotifyOwnerWhenInfected;
	protected boolean tCDInfectedWhenWild;
	protected boolean tCDInfectedWhenTamed;
	protected boolean tCDClearInfectionWhenTamed;
	protected int tCDBabyInfectionChance;
	protected int tCDInfectionChance;
	protected float tCDBaseSlownessFactor;
	protected float tCDMaxSlownessFactor;
	protected int tCDAdjustmentChance;
	protected float tCDAdjustmentFactor;
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\
	
	

	private int lastActiveTime;
	private int timeSinceIgnited;

	/** The time until the next egg is spawned. */
	public int timeUntilNextEgg;

	private ChickAIAttackRangedBow aiArrowAttack;
	private ChickAISwell aiSwell;

	public EntityMoChicken(EntityType<? extends EntityMoChicken> type, World par1World) {
		super(type, par1World);
		attackingSpeedBoostModifier = (new AttributeModifier(
				attackingSpeedBoostModifierUUID, "attackingSpeedBoostModifier",
				attackSpeed, AttributeModifier.Operation.ADDITION)).setSaved(false);
		
	}
	
	@Override
	protected void registerGoals() {
		MoChickens.CHICKEN_LOGGER.debug("Setting Goals");
		if (burnsInSun) {
			goalSelector.addGoal(2, new RestrictSunGoal(this));
			goalSelector.addGoal(3, new FleeSunGoal(this, 1.0D));
		}
		goalSelector.addGoal(1, new SwimGoal(this));
		goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
		if (canBlowUp) {
			aiSwell = new ChickAISwell(this, movesWhenPrimed, primedMovementSpeed);
		}
		goalSelector.addGoal(4, new FollowParentGoal(this, 1.1D));
		goalSelector.addGoal(5, new RandomWalkingGoal(this, 1.0D));
		goalSelector.addGoal(6, new LookAtGoal(this,
				PlayerEntity.class, 6.0F));
		goalSelector.addGoal(7, new LookRandomlyGoal(this));
		if (canShootArrows) {
			aiArrowAttack = new ChickAIAttackRangedBow(this, 1.0D, arrowShootSpeed, 15.0F);
		}
		setTamed(false);
	}

	@Override
	protected void registerData() {
		super.registerData();
		dataManager.register(STATE, Integer.valueOf(-1));
		dataManager.register(SCREAMING, false);
		dataManager.register(OWNER, "");
		dataManager.register(EXPLODINGCHICKENSYNDROME, false);
		dataManager.register(MADCHICKENDISEASE, false);
		dataManager.register(TRICKLECHICKENDISORDER, false);
		dataManager.register(TRICKLEFACTOR, 0.0F);
	}

	public void registerAttributes(ChickenConfigGenerator c, EntityType<?> cl) {
		super.registerAttributes();
		setupConfigVariables(c, cl);
		getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(health);
		getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(walkSpeed);
	}

	@Override
	public final void readAdditional(CompoundNBT compound) {
	super.readAdditional(compound);
	String s;
	
		if (compound.contains("OwnerUUID", 8)) {
			s = compound.getString("OwnerUUID");
			MoChickens.CHICKEN_LOGGER.debug("Reading Owner Contains 8! " + s.toString());
		} else {
			String s1 = compound.getString("Owner");
			s = PreYggdrasilConverter.convertMobOwnerIfNeeded(getServer(), s1);
			MoChickens.CHICKEN_LOGGER.debug("Reading Owner: " + s);
		}
		
		if (compound.contains("ExplodingChickenSyndrome")) {
			setExplodingChickenSyndrome(compound.getBoolean("ExplodingChickenSyndrome"));
		}
		
		if (compound.contains("MadChickenDisease")) {
			setMadChickenDisease(compound.getBoolean("MadChickenDisease"));
		}
		
		if (compound.contains("TrickleChickenDisorder")) {
			setTrickleChickenDisorder(compound.getBoolean("TrickleChickenDisorder"));
		}
		
		if (compound.contains("TrickleFactor")) {
			setTrickleFactor(compound.getFloat("TrickleFactor"));
		}
		
		if (!s.isEmpty()) {
			if (!s.equals("00000000-0000-0000-0000-000000000000")) {
				MoChickens.CHICKEN_LOGGER.debug("Setting Owner! " + s);
				setOwnerId(UUID.fromString(s));
				MoChickens.CHICKEN_LOGGER.debug("Owner After set: " + getOwnerId().toString());
				setTamed(true);
			} else {
				MoChickens.CHICKEN_LOGGER.debug("Forget The Owner! " + s);
				setTamed(false);
			}
		}
	}
	
	@Override
	public void writeAdditional(CompoundNBT compound)
    {
        super.writeAdditional(compound);

        if (getOwnerId() == null)
        {
        	MoChickens.CHICKEN_LOGGER.debug("Writing Owner Null");
            compound.putString("OwnerUUID", "");
        } else {
        	MoChickens.CHICKEN_LOGGER.debug("Writing Owner: " + getOwnerId().toString());
            compound.putString("OwnerUUID", getOwnerId().toString());
        }
        if (getExplodingChickenSyndrome()) {
        	compound.putBoolean("ExplodingChickenSyndrome", true);
        } else {
        	compound.putBoolean("ExplodingChickenSyndrome", false);
        }
        
        if (getMadChickenDisease()) {
        	compound.putBoolean("MadChickenDisease", true);
        } else {
        	compound.putBoolean("MadChickenDisease", false);
        }
        
        if (getTrickleChickenDisorder()) {
        	compound.putBoolean("TrickleChickenDisorder", true);
        } else {
        	compound.putBoolean("TrickleChickenDisorder", false);
        }
        
        if (getTrickleFactor() != 0.0F) {
        	compound.putFloat("TrickleChickenDisorder", getTrickleFactor());
        } else {
        	compound.putFloat("TrickleChickenDisorder", 0.0F);
        }
    }

	@Override
	public boolean canDespawn(double distanceToClosestPlayer) {
		if (ran == 0) {
			ran = 1;
		}
		return despawn;
	}
	
	@Override
	protected SoundEvent getAmbientSound() {
        return livingSound;
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
	@Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return hurtSound;
    }

    /**
     * Returns the sound this mob makes on death.
     */
	@Override
    protected SoundEvent getDeathSound() {
        return deathSound;
    }

    /**
     * Plays step sound at given x, y, z for the entity
     */
	@Override
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
		playSound(stepSound, 0.15F, 1.0F);
    }
	
	@Override
	public boolean isTamed()
    {
		return (dataManager.get(TAMED) & 4) != 0;
    }

	@Override
	public void setTamed(boolean tamed)
    {
		byte b0 = dataManager.get(TAMED);
	      if (tamed) {
	         dataManager.set(TAMED, (byte)(b0 | 4));
	      } else {
	         dataManager.set(TAMED, (byte)(b0 & -5));
	      }
	      
		MoChickens.CHICKEN_LOGGER.debug("Setting Tamed AI: " + tamed);
        setupTaimedAI(tamed);
    }
	
	public void setupTaimedAI(boolean tamed) {
		if (tamed) {
			if (getExplodingChickenSyndrome() && eCSClearInfectionWhenTamed) {
				setExplodingChickenSyndrome(false);
			}
			if (getMadChickenDisease() && mCDClearInfectionWhenTamed) {
				System.out.println(getName() + " Infection Cleared!");
				setMadChickenDisease(false);
				goalSelector.removeGoal(new ChickNearestAttackableTarget<>(
						this, EntityMoChicken.class, true, attackTrackingRange));
			}
			world.setEntityState(this, (byte) 7);
			goalSelector.removeGoal(new ChickNearestAttackableTarget<>(
					this, PlayerEntity.class, true, attackTrackingRange));
			if (canShootArrows) {
				goalSelector.removeGoal(aiArrowAttack);
			}
			if (canBlowUp) {
				goalSelector.removeGoal(aiSwell);
			}
			if ((canTemptWild) || (canTemptTamed && isTamed())) {
				MoChickens.CHICKEN_LOGGER.debug(getOwnerId().toString());
				goalSelector.addGoal(3, new ChickAITempt(this, 1.0D, temptingItem, false, ownerOnlyTempting, getOwnerId(), canTemptWild, canTemptTamed));
			}
			despawn = despawnTamed;
			ran = 0;
			canDespawn(0D);
			if (laysItemsTamed) {
				timeUntilNextEgg = rand.nextInt(variableItemLayTime) + minItemLayTime;
			} else {
				timeUntilNextEgg = -1;
			}
		} else if (hostile) {
			if (canShootArrows) {
				goalSelector.addGoal(4, aiArrowAttack);
			} else {
				goalSelector.addGoal(2, new MeleeAttackGoal(this, attackSpeed, false));
			}
			
			if (canBlowUp) {
				MoChickens.CHICKEN_LOGGER.debug("Adding Explosion Goal! " + canBlowUp);
				goalSelector.addGoal(2, aiSwell);
			} else {
				MoChickens.CHICKEN_LOGGER.debug("Not Adding Explosion Goal!" + canBlowUp);
			}
			
			targetSelector.addGoal(1, new ChickNearestAttackableTarget<>(
					this, PlayerEntity.class, true, attackTrackingRange));
			setChickenState(-1);
			despawn = despawnUntamed;
			ran = 0;
			canDespawn(0D);
		} else {
			despawn = despawnUntamed;
			ran = 0;
			if (laysItemsWild) {
				timeUntilNextEgg = rand.nextInt(variableItemLayTime) + minItemLayTime;
			} else {
				timeUntilNextEgg = -1;
			}
			canDespawn(0D);
		}

		if (world.getDifficulty().toString().equalsIgnoreCase(
				"peaceful")) {
			difficultyChange();
		}
	}
	
	@Override
    public boolean canSpawn(IWorld worldIn, SpawnReason reason)
    {
		super.canSpawn(worldIn, reason);
		if (canSpawn) {
			BlockPos pos = new BlockPos((int) posX, (int) posY, (int) posZ);
			int light = world.getNeighborAwareLightSubtracted(pos, 0);
			BlockState iBlockStateDown = world.getBlockState((new BlockPos(this)).down());
			if (iBlockStateDown.canEntitySpawn(worldIn, pos, getType()) && (light >= minSpawnLightLevel) && (light <= maxSpawnLightLevel)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
    }

	@Override
	public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
		if (isInvulnerableTo(par1DamageSource)) {
			return false;
		} else if (allowTeleporting) {
			setScreaming(true);

			if (par1DamageSource instanceof EntityDamageSource
					&& par1DamageSource.getTrueSource() instanceof PlayerEntity) {
				isAggressive = true;
			}

			if (par1DamageSource instanceof EntityDamageSource) {
				isAggressive = false;

				for (int i = 0; i < 64; ++i) {
					if (teleportRandomly()) {
						return true;
					}
				}

				return super.attackEntityFrom(par1DamageSource, par2);
			} else {
				return super.attackEntityFrom(par1DamageSource, par2);
			}
		} else {
			return super.attackEntityFrom(par1DamageSource, par2);
		}

	}

	@Override
	public boolean attackEntityAsMob(Entity par1Entity) {
		if ((!isTamed())
				&& (hostile)
				&& (!canBlowUp)) {
			LivingEntity target = getAttackTarget();
			float f = (float) attackDamage;
			int i = 0;

			if (target instanceof LivingEntity) {
				f += EnchantmentHelper.getModifierForCreature(getHeldItemMainhand(), ((LivingEntity)par1Entity).getCreatureAttribute());
	            i += EnchantmentHelper.getKnockbackModifier(this);
				applyEffects(target);
				if (setTargetOnFire) {
					target.setFire(fireDuration);
				}
			}

			boolean flag = par1Entity.attackEntityFrom(
					DamageSource.causeMobDamage(this), f);

			if (flag) {
				if (i > 0) {
					target.knockBack(this, (float)i * 0.5F, (double)MathHelper.sin(rotationYaw * 0.017453292F), (double)(-MathHelper.cos(rotationYaw * 0.017453292F)));
					setMotion(getMotion().mul(0.6D, 1.0D, 0.6D));
				}

				int j = EnchantmentHelper.getFireAspectModifier(this);

				if (j > 0) {
					target.setFire(j * 4);
				}

				if (par1Entity instanceof PlayerEntity)
	            {
					PlayerEntity entityp = (PlayerEntity)par1Entity;
	                ItemStack itemstack1 = entityp.isHandActive() ? entityp.getActiveItemStack() : ItemStack.EMPTY;

	                if (!itemstack1.isEmpty() && itemstack1.getItem() == Items.SHIELD)
	                {
	                    float f1 = 0.25F + (float)EnchantmentHelper.getEfficiencyModifier(this) * 0.05F;

	                    if (rand.nextFloat() < f1)
	                    {
	                        entityp.getCooldownTracker().setCooldown(Items.SHIELD, 100);
	                        world.setEntityState(entityp, (byte)30);
	                    }
	                }
	            }

	            applyEnchantments(this, par1Entity);
			}

			return flag;
		} else {
			return false;
		}
	}

	private void applyEffects(LivingEntity target) {

		for (int p = 0; p < effectIDs.length; p++) {
			Effect pot = effectIDs[p];
			int amplifier = effectAmplifiers[p];
			int duration = effectDurations[p];
			if (checkpot(pot, amplifier, duration) != "") {
				target.addPotionEffect(new EffectInstance(pot, duration, amplifier));
			} else {
				MoChickens.CHICKEN_LOGGER.error("Effect " + effectIDs[p] + " was not found!");
			}
		}
	}

	private String checkpot(Effect pot, int amplifier, int duration) {
		String test = "";
		if (pot != null) {
			test = new EffectInstance(pot, amplifier, duration).getEffectName();
		}
		return test;
	}

	private void addLight() {
		BlockPos pos = getPosition();
		//MoChickens.CHICKEN_LOGGER.debug("Attempting To Set Light To " + lightLevelEmited);
		if (world.getLight(pos) < lightLevelEmited) {
			//MoChickens.CHICKEN_LOGGER.debug("Light Set");
			//MoChickens.CHICKEN_LOGGER.debug("Current Block Light Before: " + world.getBlockState(pos).getLightValue());
			NibbleArray nibble = world.getChunkProvider().getLightManager().getLightEngine(LightType.BLOCK).getData(SectionPos.from(pos)).copy();
			//MoChickens.CHICKEN_LOGGER.debug(nibble.toString());
			int x = Math.abs(pos.getX() % 16);
			int y = Math.abs(pos.getY() % 16);
			int z = Math.abs(pos.getZ() % 16);
			nibble.set(x, y, z, lightLevelEmited);
			world.getChunkProvider().getLightManager().setData(LightType.BLOCK, SectionPos.from(pos), nibble);
			world.getChunkProvider().getLightManager().getLightEngine(LightType.BLOCK).func_215567_a(pos, false);
			world.notifyNeighbors(pos, world.getBlockState(pos).getBlock());
			//MoChickens.CHICKEN_LOGGER.debug("Current Block Light After: " + world.getBlockState(pos).getLightValue());
			//world.getLightFor(LightType.BLOCK, pos.up());
			//world.getLightFor(LightType.BLOCK, pos.down());
			//world.getLightFor(LightType.BLOCK, pos.north());
			//world.getLightFor(LightType.BLOCK, pos.south());
			//world.getLightFor(LightType.BLOCK, pos.east());
			//world.getLightFor(LightType.BLOCK, pos.west());
		}
	}
	
	@Override
	public void onDeath(DamageSource cause)
    {
        if (!world.isRemote && world.getGameRules().getBoolean(GameRules.SHOW_DEATH_MESSAGES) && getOwner() instanceof ServerPlayerEntity)
        {
        	getOwner().sendMessage(getDisplayName().appendText(" at " + dateFormat() + " by " + cause.getImmediateSource().getName().getFormattedText()));

        }
		//world.getChunkProvider().getLightManager().getLightEngine(LightType.BLOCK).func_215567_a(getPosition(), false);
		world.notifyNeighbors(getPosition(), world.getBlockState(getPosition()).getBlock());
        super.onDeath(cause);
    }

	/**
	 * Called frequently so the entity can update its state every tick as
	 * required. For example, zombies and skeletons use this to react to
	 * sunlight and start to burn.
	 */
	private int loc = 0;
	@Override
	public void livingTick() {
		super.livingTick();
		if (loc == 0) {
			if (ConfigHandler.DEBUG.get()) MoChickens.CHICKEN_LOGGER.debug(chicken + " X:" + posX + " Y:" + posY + " Z:" + posZ);
			loc ++;
		}
		
	Vec3d vec3d = this.getMotion();
	if (!this.onGround && vec3d.y < 0.0D) {
		this.setMotion(vec3d.mul(1.0D, 0.6D, 1.0D));
    }
	      
		if (world.isDaytime() && !world.isRemote && burnsInSun) {
			float f = getBrightness();

			if (f > 0.5F
					&& rand.nextFloat() * 30.0F < (f - 0.4F) * 2.0F
					&& world.canBlockSeeSky(new BlockPos(
							MathHelper.floor(posX),
							MathHelper.floor(posY),
							MathHelper.floor(posZ)))) {
				boolean flag = true;

				if (flag) {
					setFire(8);
				}
			}
		}

		if (lastEntityToAttack != entityToAttack) {
			IAttributeInstance attributeinstance = this
					.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED);
			attributeinstance.removeModifier(attackingSpeedBoostModifier);

			if (entityToAttack != null) {
				attributeinstance.applyModifier(attackingSpeedBoostModifier);
			}
		}

		lastEntityToAttack = entityToAttack;

		if (allowTeleporting) {
			if (world.isDaytime() && !world.isRemote) {
				float f = getBrightness();

				if (f > 0.5F && world.canBlockSeeSky(new BlockPos(
						MathHelper.floor(posX),
						MathHelper.floor(posY),
						MathHelper.floor(posZ)))
						&& rand.nextFloat() * 30.0F < (f - 0.4F) * 2.0F) {
					entityToAttack = null;
					setScreaming(false);
					isAggressive = false;
					teleportRandomly();
				}
			}


			if (isWet() || isBurning()) {
				entityToAttack = null;
				setScreaming(false);
				isAggressive = false;
				teleportRandomly();
			}

			if (isScreaming() && !isAggressive
					&& rand.nextInt(100) == 0) {
				setScreaming(false);
			}

			isJumping = false;

			if (entityToAttack != null) {
				faceEntity(entityToAttack, 100.0F, 100.0F);
			}

			if (!world.isRemote && isAlive()) {
				if (entityToAttack != null) {
					if (entityToAttack instanceof PlayerEntity) {
						if (entityToAttack.getDistanceSq(this) < 16.0D) {
							teleportRandomly();
						}

						teleportDelay = 0;
					} else if (entityToAttack.getDistanceSq(this) > 256.0D
							&& teleportDelay++ >= 30
							&& teleportToEntity(entityToAttack)) {
						teleportDelay = 0;
					}
				} else {
					setScreaming(false);
					teleportDelay = 0;
				}
			}
		}

		if ((!isTamed()) && (canBlowUp) && (hostile)) {
			blowUp();
		}

		field_70888_h = field_70886_e;
		field_70884_g = destPos;
		destPos = (float) ((double) destPos + (double)
				(onGround ? -1 : 4) * 0.3D);

		if (destPos < 0.0F) {
			destPos = 0.0F;
		}

		if (destPos > 1.0F) {
			destPos = 1.0F;
		}

		if (!onGround && field_70889_i < 1.0F) {
			field_70889_i = 1.0F;
		}

		if (emitsParticles) {
			for (int p = 0; p < particleType.length; ++p) {
				for (int i = 0; i < particlesPerTick[p]; ++i) {
					if (particleData[p].contains("[") || particleData[p].contains("]")) {
						particleData[p] = particleData[p].replace("[", "");
						particleData[p] = particleData[p].replace("]", "");
					}
					try {
						if (!particleType[p].getRegistryName().toString().equalsIgnoreCase("minecraft:note")) {
							world.addParticle(deserializeParticle(new StringReader(particleData[p] + " 1.0 0"), particleType[p]),
									posX + (rand.nextDouble() - 0.5D)
									* (double) getWidth(),
									posY + rand.nextDouble()
									* (double) getHeight(),
									posZ + (rand.nextDouble() - 0.5D)
									* (double) getWidth(), 0.0D, 0.0D, 0.0D);
						} else {
							particleData[p] = particleData[p].replace(" ", "");
							world.addParticle(deserializeParticle(new StringReader(""), particleType[p]),
									posX + (rand.nextDouble() - 0.5D)
									* (double) getWidth(),
									posY + rand.nextDouble()
									* (double) getHeight(),
									posZ + (rand.nextDouble() - 0.5D)
									* (double) getWidth(), ObjectTranslators.getDouble(particleData[p]), 0.0D, 0.0D);
						}
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
					}
				}
			}
		}

		if (emitsLight) {
			addLight();
		}

		if ((isWet()) && (getsHurtByWater)) {
			attackEntityFrom(DamageSource.DROWN, (float) damageFromWater);
		}

		field_70889_i = (float) ((double) field_70889_i * 0.9D);

		if (!onGround && moveVertical < 0.0D) {
			moveVertical *= 0.6D;
		}

		field_70886_e += field_70889_i * 2.0F;

		if (world.getDifficulty() != checked) {
			difficultyChange();
			checked = world.getDifficulty();
		}

		if (!isChild() && ((laysItemsWild && !isTamed()) || (laysItemsTamed &&  isTamed())) && !world.isRemote
				&& --timeUntilNextEgg == 0) {

			playSound(layingSound, 1.0F,
					(rand.nextFloat() - rand.nextFloat()) * 0.2F + 1.0F);
			if (layingItem != null) {
				entityDropItem(layingItem[randomInt(0, (layingItem.length - 1))], layingItemAmount);
				timeUntilNextEgg = rand.nextInt(variableItemLayTime) + minItemLayTime;
			} else {
				entityDropItem(Items.EGG, layingItemAmount);
				timeUntilNextEgg = rand.nextInt(variableItemLayTime) + minItemLayTime;
			}
		} 

		if (getTrickleChickenDisorder()) {
			if (getTrickleFactor() != 0.0F) {
				int adjust = (int) (Math.random() * (tCDAdjustmentChance + 1));
				if (tCDAdjustmentFactor < 0) {
					tCDAdjustmentFactor = tCDAdjustmentFactor * -1;
				}
				if (adjust == 0) {
					float newAdjustment = getTrickleFactor();
					if (tCDBaseSlownessFactor > tCDMaxSlownessFactor) {
						newAdjustment = getTrickleFactor() - tCDAdjustmentFactor;
						if (newAdjustment < tCDMaxSlownessFactor) {
							newAdjustment = tCDMaxSlownessFactor;
						}
					} else if (tCDBaseSlownessFactor < tCDMaxSlownessFactor) {
						newAdjustment = getTrickleFactor() + tCDAdjustmentFactor;
						if (newAdjustment > tCDMaxSlownessFactor) {
							newAdjustment = tCDMaxSlownessFactor;
						}
					}
					setTrickleFactor(newAdjustment);
					timeUntilNextEgg = (int) Math.ceil(timeUntilNextEgg / getTrickleFactor());
				}
			} else {
				setTrickleFactor(tCDBaseSlownessFactor);
				timeUntilNextEgg = (int) Math.ceil(timeUntilNextEgg / getTrickleFactor());
			}
		}

		manageInfections();

		if (dead) {
			world.getLightFor(LightType.BLOCK, new BlockPos((int) posX, (int) posY, (int) posZ));
		}
	}
	
	private static <T extends IParticleData> T deserializeParticle(StringReader reader, ParticleType<T> type) throws CommandSyntaxException {
	      return type.getDeserializer().deserialize(type, reader);
	}
	
	public void manageInfections() {
		if (!world.isRemote) {
			if (explodingChickenSyndrome && !getExplodingChickenSyndrome()) {
				int rand;
				if (isChild()) {
					rand = randomInt(1, eCSBabyInfectionChance);
				} else {
					rand = randomInt(1, eCSInfectionChance);
				}
				if (rand == 1) {
					if (isTamed() && eCSInfectedWhenTamed) {
						setExplodingChickenSyndrome(true);
						if (eCSNotifyOwnerWhenInfected) {
							if (world.getPlayers().contains(getOwner())) {
								getOwner().sendMessage(getDisplayName().appendText(" has been infected with Exploding Chicken Syndrome!"));
							}
						}
					}
					if (!isTamed() && eCSInfectedWhenWild) {
						setExplodingChickenSyndrome(true);
					}
				}
			}
			
			if (getExplodingChickenSyndrome()) {
				int rand = randomInt(1, eCSFalseFuseChance);
				int rand2 = randomInt(1, eCSExplosionChance);
				if (rand == 1) {
					playSound(SoundEvents.ENTITY_CREEPER_PRIMED, 1.0F, 0.5F);
				}
				if (rand2 == 1) {
					explodingByECS = true;
					setChickenState(1);
				}
			 	blowUp();
			}
			
			if (madChickenDisease && !getMadChickenDisease()) {
				int rand;
				if (isChild()) {
					rand = randomInt(1, mCDBabyInfectionChance);
				} else {
					rand = randomInt(1, mCDInfectionChance);
				}
				if (rand == 1) {
					if (isTamed() && mCDInfectedWhenTamed) {
						setMadChickenDisease(true);
						if (mCDNotifyOwnerWhenInfected) {
							getOwner().sendMessage(getDisplayName().appendText(" has been infected with Mad Chicken Disease!"));
						}
					}
					if (!isTamed() && mCDInfectedWhenWild) {
						setMadChickenDisease(true);
					}
				}
			}
			
			if (trickleChickenDisorder && !getTrickleChickenDisorder()) {
				int rand;
				if (isChild()) {
					rand = randomInt(1, tCDBabyInfectionChance);
				} else {
					rand = randomInt(1, tCDInfectionChance);
				}
				if (rand == 1) {
					if (isTamed() && tCDInfectedWhenTamed) {
						setTrickleChickenDisorder(true);
						if (tCDNotifyOwnerWhenInfected) {
							getOwner().sendMessage(getDisplayName().appendText(" has been infected with Trickle Chicken Disorder!"));
						}
					}
					if (!isTamed() && tCDInfectedWhenWild) {
						setTrickleChickenDisorder(true);
					}
				}
			}
		}
	}
	
	public boolean getExplodingChickenSyndrome() {
		return dataManager.get(EXPLODINGCHICKENSYNDROME);
	}
	
	public void setExplodingChickenSyndrome(boolean bool) {
		dataManager.set(EXPLODINGCHICKENSYNDROME, bool);
	}
	
	public boolean getMadChickenDisease() {
		return dataManager.get(MADCHICKENDISEASE);
	}
	
	public void setMadChickenDisease(boolean bool) {
		if (bool) {
			System.out.println(getName() + " Should by mad!");
			if (canShootArrows) {
				goalSelector.addGoal(4, aiArrowAttack);
			} else {
				goalSelector.addGoal(2, new MeleeAttackGoal(this, attackSpeed, false));
			}
			targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, EntityMoChicken.class, true));
		}
		dataManager.set(MADCHICKENDISEASE, bool);
	}
	
	public boolean getTrickleChickenDisorder() {
		return dataManager.get(TRICKLECHICKENDISORDER);
	}
	
	public void setTrickleChickenDisorder(boolean bool) {
		dataManager.set(TRICKLECHICKENDISORDER, bool);
	}
	
	public Float getTrickleFactor() {
		return dataManager.get(TRICKLEFACTOR);
	}
	
	public void setTrickleFactor(Float f) {
		if (f < 0) {
			f = f * -1;
		}
		dataManager.set(TRICKLEFACTOR, f);
	}
	
	public void blowUp() {
		if (isAlive()) {
			lastActiveTime = timeSinceIgnited;
			
			int i = getChickenState();

			if (i > 0 && timeSinceIgnited == 0) {
				playSound(SoundEvents.ENTITY_CREEPER_PRIMED, 1.0F, 0.5F);
			}

			timeSinceIgnited += i;

			if (timeSinceIgnited < 0) {
				timeSinceIgnited = 0;
			}

			if (timeSinceIgnited >= fuseTime) {
				timeSinceIgnited = fuseTime;
				if (!world.isRemote) {
					LivingEntity target = getAttackTarget();
					Explosion.Mode explosion$mode = net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.world, this) ? Explosion.Mode.DESTROY : Explosion.Mode.NONE;
			        dead = true;
					world.createExplosion(this, posX, posY, posZ, (float) explosionRadius, explosion$mode);
					if (dataManager.get(EXPLODINGCHICKENSYNDROME)) {
						mc.ingameGUI.getChatGUI().printChatMessage(getDisplayName().appendText(" has blown up from Exploding Chicken Syndrome!"));
						mc.ingameGUI.getChatGUI().printChatMessage(getDisplayName().appendText(" at " + dateFormat()));
					}
					if (target != null) {
						applyEffects(target);
					}
					remove();
				}
			}
		}
	}
	
	public String dateFormat() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}

	public static int randomInt(int low, int high) {
		int result = (int) (Math.random() * (high - low + 1)) + low;
		return result;
	}

	public float getChickenFlashIntensity(float par1) {
		return ((float) lastActiveTime + (float) (timeSinceIgnited - lastActiveTime)
				* par1) / (float) (fuseTime - 2);
	}

	public int getChickenState() {
        return ((Integer)dataManager.get(STATE)).intValue();
    }

    /**
     * Sets the state of creeper, -1 to idle and 1 to be 'in fuse'
     */
    public void setChickenState(int state) {
        dataManager.set(STATE, Integer.valueOf(state));
    }

	private void difficultyChange() {
		if (world.getDifficulty().toString().equalsIgnoreCase(
				"peaceful")) {
			navigator.clearPath();
			setAttackTarget((LivingEntity) null);
			setAttackTarget(null);
			targetSelector.getRunningGoals().close();
		} else {
			if (getOwner() != null) {
				LivingEntity s = (LivingEntity) getOwner();
				System.out.println("Difficult Change");
				System.out.println(s.getUniqueID().toString());

				if (s.getUniqueID().toString().length() > 0) {
					setTamed(true);
					setOwnerId(s.getUniqueID());
				}
			} else {
				setTamed(false);
			}
		}
	}

	/**
	 * Returns the item the mob drops on death.
	 */
	
	protected Item getDropItemId() {
		return Items.FEATHER;
	}

	/**
	 * Drop 0-2 items of this living's type. @param par1 - Whether this entity
	 * has recently been hit by a player. @param par2 - Level of Looting used to
	 * kill this mob.
	 *
	@Override
	protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
		int j = rand.nextInt(3) + rand.nextInt(1 + looting);

		for (int k = 0; k < j; ++k) {
			entityDropItem((Item) Items.FEATHER, 1);
		}

		if (isBurning()) {
			entityDropItem((Item) Items.COOKED_CHICKEN, 1);
		} else {
			entityDropItem((Item) Items.CHICKEN, 1);
		}
	}*/

	/**
	 * Called when a player interacts with a mob. e.g. gets milk from a cow,
	 * gets into the saddle on a pig.
	 */
	@Override
	public boolean processInteract(PlayerEntity player, Hand hand) {
		
		ItemStack itemstack = player.getHeldItem(hand);
		if (!itemstack.isEmpty()) {
			if (isBreedingItem(itemstack.getItem(), player)) {
				if (getGrowingAge() == 0 && canBreed()) {
					consumeItemFromStack(player, itemstack);
					setInLove(player);
					return true;
				}
				
				if (isChild()) {
					consumeItemFromStack(player, itemstack);
					ageUp((int)((float)(-getGrowingAge() / 20) * 0.1F), true);
					return true;
				}
			}
		
			if (canTame) {
				if (!isTamed()) {
					for (Item item : tamingItem) {
						if (item == itemstack.getItem()) {
							consumeItemFromStack(player, itemstack);
							if (!world.isRemote) {
								if (rand.nextInt(tamingChance) == 0) {
									setOwnerId(player.getUniqueID());
									setTamedBy(player);
									navigator.clearPath();
									setAttackTarget((LivingEntity) null);
									setAttackTarget(null);
									playTameEffect(true);
								} else {
									playTameEffect(false);
									world.setEntityState(this, (byte) 6);
								}
							}
					
						}
					}
				
				}
			}

			if ((itemstack.getItem() == Items.FLINT_AND_STEEL) && canBeIgnited) {
				world.playSound(player, posX, posY, posZ, SoundEvents.ITEM_FLINTANDSTEEL_USE, getSoundCategory(), 1.0F, rand.nextFloat() * 0.4F + 0.8F);
				player.swingArm(hand);
				if (!world.isRemote) {
					blowUp();
					itemstack.damageItem(1, player, (p_213625_1_) -> {
						p_213625_1_.sendBreakAnimation(hand);
					});
					return true;
				}
			}
		}
		return super.processInteract(player, hand);
	}

	/**
	 * This function is used when two same-species animals in 'love mode' breed
	 * to generate the new baby animal.
	 */
	public EntityMoChicken spawnBabyAnimal(AgeableEntity par1EntityAgeable) {
		try {
			EntityMoChicken newEntity = (EntityMoChicken) chicken.create(world);

			LivingEntity s = (LivingEntity) getOwner();

			if (s != null && s.getUniqueID().toString().length() > 0) {
				((EntityMoChicken) newEntity).setOwnerId(s.getUniqueID());
				((EntityMoChicken) newEntity).setupConfigVariables(config, chicken);
				((EntityMoChicken) newEntity).setGrowingAge(Math.multiplyExact(growTime, -1));
				((EntityMoChicken) newEntity).setTamed(childSpawnsTamed);
			}

			return (EntityMoChicken) newEntity;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}  catch (SecurityException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Checks if the parameter is an item which this animal can be fed to breed
	 * it (wheat, carrots or seeds depending on the animal type)
	 */
	public boolean isBreedingItem(Item item, PlayerEntity player) {
		if ((allowBreedingWild && !isTamed()) || (allowBreedingTamed && isTamed())) {
			if (!ownerOnlyBreeding || (getOwner().getUniqueID() == player.getUniqueID())) {
				for (Item loopItem : breedingItem) {
					if (loopItem == item) {
						return true;
						
					}
				}
				return false;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public AgeableEntity createChild(AgeableEntity par1EntityAgeable) {
		return spawnBabyAnimal(par1EntityAgeable);
	}

	public boolean isScreaming()
    {
        return ((Boolean)dataManager.get(SCREAMING)).booleanValue();
    }

	public void setScreaming(boolean par1) {
		dataManager.set(SCREAMING, par1);;
	}

	protected boolean teleportRandomly() {
		if (!isTamed()) {
			double d0 = posX + (rand.nextDouble() - 0.5D) * 64.0D;
			double d1 = posY + (double) (rand.nextInt(64) - 32);
			double d2 = posZ + (rand.nextDouble() - 0.5D) * 64.0D;
			return teleportTo(d0, d1, d2);
		} else {
			return false;
		}
	}

	protected boolean teleportToEntity(Entity par1Entity) {
		Vec3d vec3 = new Vec3d(posX - par1Entity.posX,
				getBoundingBox().minY + (double) (getHeight() / 1.5F)
						- par1Entity.posY + (double) par1Entity.getEyeHeight(),
				posZ - par1Entity.posZ);
		vec3 = vec3.normalize();
		double d0 = 16.0D;
		double d1 = posX + (rand.nextDouble() - 0.5D) * 8.0D
				- vec3.x * d0;
		double d2 = posY + (double) (rand.nextInt(16) - 8)
				- vec3.y * d0;
		double d3 = posZ + (rand.nextDouble() - 0.5D) * 8.0D
				- vec3.z * d0;
		return teleportTo(d1, d2, d3);
	}

	private boolean teleportTo(double x, double y, double z)
    {
        net.minecraftforge.event.entity.living.EnderTeleportEvent event = new net.minecraftforge.event.entity.living.EnderTeleportEvent(this, x, y, z, 0);
        if (net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event)) return false;
        boolean flag = attemptTeleport(event.getTargetX(), event.getTargetY(), event.getTargetZ(), true);

        if (flag)
        {
            world.playSound((PlayerEntity)null, prevPosX, prevPosY, prevPosZ, SoundEvents.ENTITY_ENDERMAN_TELEPORT, getSoundCategory(), 1.0F, 1.0F);
            playSound(SoundEvents.ENTITY_ENDERMAN_TELEPORT, 1.0F, 1.0F);
        }

        return flag;
    }

	@Override
	public void attackEntityWithRangedAttack(LivingEntity target, float distanceFactor)
    {
        ArrowEntity entityarrow = getArrow(distanceFactor);
        double d0 = target.posX - posX;
        double d1 = target.getBoundingBox().minY + (double)(target.getHeight() / 3.0F) - entityarrow.posY;
        double d2 = target.posZ - posZ;
        double d3 = (double)MathHelper.sqrt(d0 * d0 + d2 * d2);
        entityarrow.shoot(d0, d1 + d3 * 0.20000000298023224D, d2, 1.6F, (float)(14 - world.getDifficulty().getId() * 4));
        playSound(SoundEvents.ENTITY_SKELETON_SHOOT, 1.0F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
        world.addEntity(entityarrow);
        
    }
	
	protected ArrowEntity getArrow(float power)
    {
        ArrowEntity entitytippedarrow = new ArrowEntity(world, this);
        for (int p = 0; p < effectIDs.length; p++) {
        	Effect pot = effectIDs[p];
			int amplifier = effectAmplifiers[p];
			int duration = effectDurations[p];
			if (checkpot(pot, amplifier, duration) != "") {
				entitytippedarrow.addEffect(new EffectInstance(pot, duration, amplifier));
			} else {
				MoChickens.CHICKEN_LOGGER.error("Effect " + effectIDs[p] + " was not found for arrow!");
			}
		}
        return entitytippedarrow;
    }

	public void setupConfigVariables(ChickenConfigGenerator c, EntityType<?> type) {
		
		chicken = type;
		config = c;
		
		// Attack Data
		hostile = config.IS_HOSTILE.get();
		effectIDs = ObjectTranslators.getEffectsArray(config.ATTACK_EFFECTS.get().split(","));
		effectAmplifiers = ObjectTranslators.getIntArray(config.ATTACK_EFFECT_AMPLIFIERS.get().split(","));
		effectDurations = ObjectTranslators.getIntArray(config.ATTACK_EFFECT_DURATIONS.get().split(","));
		arrowShootSpeed = config.TIME_BETWEEN_ARROWS.get();
		attackDamage = config.ATTACK_DAMAGE.get();
		attackSpeed = config.ATTACK_MOVEMENT_SPEED.get();
		attackTrackingRange = config.DISTANCE_TO_TRACK_TARGET.get();
		canBlowUp = config.CAN_EXPLODE.get();
		canShootArrows = config.CAN_SHOOT_ARROWS.get();
		explosionRadius = config.EXPLOSION_RADIUS.get();
		movesWhenPrimed = config.MOVES_WHEN_PRIMED.get();
		primedMovementSpeed = config.PRIMED_MOVEMENT_SPEED.get();
		fireDuration = config.DURATION_OF_FIRE_ON_TARGET.get();
		fuseTime = config.EXPLOSION_FUSE_TIME.get();
		setTargetOnFire = config.SET_TARGET_ON_FIRE.get();
		
		// Breeding
		allowBreedingTamed = config.CAN_BREED_TAMED.get();
		allowBreedingWild = config.CAN_BREED_WILD.get();
		breedingItem = ObjectTranslators.getItemArray(config.BREEDING_ITEMS.get().split(","));
		childSpawnsTamed = config.CHILD_SPAWNS_TAMED.get();
		growTime = config.BABY_TO_ADULT_TIME.get();
		ownerOnlyBreeding = config.OWNER_ONLY_BREEDING.get();
		
		// Entity Data
		allowTeleporting = config.CAN_TELEPORT.get();
		burnsInSun = config.BURN_IN_SUN.get();
		damageFromWater = config.WATER_DAMAGE.get();
		despawnTamed = config.TAMED_CAN_DESPAWN.get();
		despawnUntamed = config.UNTAMED_CAN_DESPAWN.get();
		emitsLight = config.EMITS_LIGHT.get();
		emitsParticles = config.EMITS_PARTICLES.get();
		getsHurtByWater = config.HYPOALERGENIC.get();
		health = config.HEALTH.get();
		hitBoxSizeX = config.HIT_BOX_X_SIZE.get();
		hitBoxSizeZ = config.HIT_BOX_Z_SIZE.get();
		immuneToFire = config.IMMUNE_TO_FIRE.get();
		lightLevelEmited = config.LIGHT_LEVEL_EMITED.get();
		particleType = ObjectTranslators.getParticleArray(config.PARTICLE_TYPES.get().split(","));
		particlesPerTick = ObjectTranslators.getIntArray(config.PARTICLE_OCCURANCES.get().split(","));
		particleData = config.PARTICLE_ARGUMENTS.get().split(",");
		walkSpeed = config.MOVEMENT_SPEED.get();
		livingSound = ObjectTranslators.getSound(config.LIVING_SOUND.get());
		hurtSound = ObjectTranslators.getSound(config.HURT_SOUND.get());
		deathSound = ObjectTranslators.getSound(config.DEATH_SOUND.get());
		stepSound = ObjectTranslators.getSound(config.STEP_SOUND.get());
		canBeIgnited = config.CAN_BE_IGNITED.get();
		
		// Laying
		laysItemsTamed = config.CAN_LAY_ITEMS_TAMED.get();
		laysItemsWild = config.CAN_LAY_ITEMS_WILD.get();
		layingItem = ObjectTranslators.getItemArray(config.LAYING_ITEMS.get().split(","));
		layingItemAmount = config.NUMBER_OF_ITEMS_TO_LAY.get();
		layingSound = ObjectTranslators.getSound(config.LAYING_SOUND.get());
		minItemLayTime = config.MINIMUM_LAYING_TIME.get();
		variableItemLayTime = config.VARIABLE_LAYING_TIME.get();
		
		// Spawning
		biomeListType = config.BIOME_WHITELIST_OR_BLACKLIST.get();
		biomeList = ObjectTranslators.getBiomeArray(config.BIOME_LIST.get().split(","));
		canSpawn = config.CAN_SPAWN.get();
		maxSpawnGroupSize = config.MAXIMUM_SPAWN_GROUP_SIZE.get();
		maxSpawnTemp = config.MAXIMUM_SPAWN_TEMP.get();
		minSpawnGroupSize = config.MINIMUM_SPAWN_GROUP_SIZE.get();
		minSpawnTemp = config.MINIMUM_SPAWN_TEMP.get();
		spawnProbability = config.SPAWN_PROBIBILITY.get();
		minSpawnLightLevel = config.MINIMUM_SPAWN_LIGHT_LEVEL.get();
		maxSpawnLightLevel = config.MAXIMUM_SPAWN_LIGHT_LEVEL.get();
		
		// Taming
		canTame = config.CAN_BE_TAMED.get();
		tamingChance = config.TAMING_CHANCE.get();
		tamingItem = ObjectTranslators.getItemArray(config.TAMING_ITEMS.get().split(","));
		
		// Tempting
		canTemptTamed = config.CAN_BE_TEMPTED_TAMED.get();
		canTemptWild = config.CAN_BE_TEMPTED_WILD.get();
		delayFollowingBetweenItemHoldings = config.FOLLOWING_DELAY_BETWEEN_ITEM_HOLDINGS.get();
		if (ConfigHandler.DEBUG.get()) MoChickens.CHICKEN_LOGGER.debug(getDisplayName().toString() + " " + config.TEMPTING_ITEMS.get() + "");
		temptingItem = ObjectTranslators.getItemArray(config.TEMPTING_ITEMS.get().split(","));
		ownerOnlyTempting = config.OWNER_ONLY_TEMPTING.get();
		temptWalkingSpeed = config.TEMPTED_WALKING_SPEED.get();
		temptScareByPlayer = config.TEMPT_SCARED_BY_PLAYER.get();
		
		// Exploding Chicken Syndrome
		explodingChickenSyndrome = config.CAN_GET_EXPLODING_CHICKEN_SYNDROME.get();
		eCSNotifyOwnerWhenInfected = config.ECS_NOTIFY_OWNER_WHEN_INFECTED.get();
		eCSInfectedWhenTamed = config.ECS_CAN_BE_INFECTED_WHEN_TAMED.get();
		eCSInfectedWhenWild = config.ECS_CAN_BE_INFECTED_WHEN_WILD.get();
		eCSClearInfectionWhenTamed = config.ECS_CLEAR_INFECTION_UPON_TAMING.get();
		eCSInfectionChance = config.ECS_ADULT_INFECTION_CHANCE.get();
		eCSBabyInfectionChance = config.ECS_BABY_INFECTION_CHANCE.get();
		eCSExplosionChance = config.ECS_EXPLOSION_CHANCE.get();
		eCSDoesFalseFuse = config.ECS_DOES_FALSE_FUSE.get();
		eCSFalseFuseChance = config.ECS_FALSE_FUSE_CHANCE.get();
		
		// Mad Chicken Disease
		madChickenDisease = config.CAN_GET_MAD_CHICKEN_DISEASE.get();
		mCDNotifyOwnerWhenInfected = config.MCD_NOTIFY_OWNER_WHEN_INFECTED.get();
		mCDInfectedWhenTamed = config.MCD_CAN_BE_INFECTED_WHEN_TAMED.get();
		mCDInfectedWhenWild = config.MCD_CAN_BE_INFECTED_WHEN_WILD.get();
		mCDClearInfectionWhenTamed = config.MCD_CLEAR_INFECTION_UPON_TAMING.get();
		mCDInfectionChance = config.MCD_ADULT_INFECTION_CHANCE.get();
		mCDBabyInfectionChance = config.MCD_BABY_INFECTION_CHANCE.get();
		
		// Trickle Chicken Disorder
		trickleChickenDisorder = config.CAN_GET_TRICKLE_CHICKEN_DISORDER.get();
		tCDNotifyOwnerWhenInfected = config.TCD_NOTIFY_OWNER_WHEN_INFECTED.get();
		tCDInfectedWhenTamed = config.TCD_CAN_BE_INFECTED_WHEN_TAMED.get();
		tCDInfectedWhenWild = config.TCD_CAN_BE_INFECTED_WHEN_WILD.get();
		tCDClearInfectionWhenTamed = config.TCD_CLEAR_INFECTION_UPON_TAMING.get();
		tCDInfectionChance = config.TCD_ADULT_INFECTION_CHANCE.get();
		tCDBabyInfectionChance = config.TCD_BABY_INFECTION_CHANCE.get();
		tCDBaseSlownessFactor = (float) config.TCD_BASE_SLOWNESS_FACTOR.get();
		tCDMaxSlownessFactor = (float) config.TCD_MAXIMUM_SLOWNESS_FACTOR.get();
		tCDAdjustmentChance = config.TCD_SLOWNESS_FACTOR_CHANGE_CHANCE.get();
		tCDAdjustmentFactor = (float) config.TCD_SLOWNESS_FACTOR_CHANGE_FACTOR.get();
	}
}
