package com.saxon564.mochickens.entities.mobs;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

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
import net.minecraft.particles.BasicParticleType;
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
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Difficulty;
import net.minecraft.world.Explosion.Mode;
import net.minecraft.world.GameRules;
import net.minecraft.world.IWorld;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

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
	protected static boolean hostile;
	protected static Effect[] effectIDs;
	protected static int[] effectAmplifiers;
	protected static int[] effectDurations;
	protected static int arrowShootSpeed;
	protected static double attackDamage;
	protected static double attackSpeed;
	protected static double attackTrackingRange;
	protected static boolean canBlowUp;
	protected static boolean canShootArrows;
	protected static int explosionRadius;
	protected static boolean movesWhenPrimed;
	protected static double primedMovementSpeed;
	protected static int fireDuration;
	protected static int fuseTime;
	protected static boolean setTargetOnFire;
	
	// Breeding
	protected static boolean allowBreedingTamed;
	protected static boolean allowBreedingWild;
	protected static Item[] breedingItem;
	protected static int growTime;
	protected static Boolean childSpawnsTamed;
	protected static Boolean ownerOnlyBreeding;
	
	// Entity Data
	protected static boolean allowTeleporting;
	protected static boolean burnsInSun;
	protected static double damageFromWater;
	protected static boolean despawnTamed;
	protected static boolean despawnUntamed;
	protected static boolean emitsLight;
	protected static boolean emitsParticles;
	protected static boolean getsHurtByWater;
	protected static double health;
	protected static double hitBoxSizeX;
	protected static double hitBoxSizeZ;
	protected static boolean immuneToFire;
	protected static int lightLevelEmited;
	protected static ParticleType<?>[] particleType;
	protected static int[] particlesPerTick;
	protected static double walkSpeed;
	protected static SoundEvent livingSound;
	protected static SoundEvent hurtSound;
	protected static SoundEvent deathSound;
	protected static SoundEvent stepSound;
	protected static Boolean canBeIgnited;
	
	// Laying
	protected static boolean laysItemsTamed;
	protected static boolean laysItemsWild;
	protected static Item[] layingItem;
	protected static int layingItemAmount;
	protected static SoundEvent layingSound;
	protected static int minItemLayTime;
	protected static int variableItemLayTime;
	
	// Spawning
	protected static boolean canSpawn;
	protected static String biomeListType;
	protected static Biome[] biomeList;
	protected static int maxSpawnGroupSize;
	protected static double maxSpawnTemp;
	protected static int minSpawnGroupSize;
	protected static double minSpawnTemp;
	protected static int spawnProbability;
	protected static int minSpawnLightLevel;
	protected static int maxSpawnLightLevel;
	
	// Taming
	protected static boolean canTame;
	protected static int tamingChance;
	protected static Item[] tamingItem;
	
	// Tempting
	protected static boolean canTemptTamed;
	protected static boolean canTemptWild;
	protected static int delayFollowingBetweenItemHoldings;
	protected static Item[] temptingItem;
	protected static boolean ownerOnlyTempting;
	protected static boolean temptScareByPlayer;
	protected static double temptWalkingSpeed;
	
	//~~~~~~~~~~~~~~~~~Infections~~~~~~~~~~~~~~~~~\\
	// Exploding Chicken Syndrome
	protected static boolean explodingChickenSyndrome;
	protected static boolean eCSNotifyOwnerWhenInfected;
	protected static boolean eCSInfectedWhenWild;
	protected static boolean eCSInfectedWhenTamed;
	protected static boolean eCSClearInfectionWhenTamed;
	protected static int eCSBabyInfectionChance;
	protected static int eCSInfectionChance;
	protected static Boolean eCSDoesFalseFuse;
	protected static int eCSFalseFuseChance;
	protected static int eCSExplosionChance;
	
	//Mad Chicken Disease
	protected static boolean madChickenDisease;
	protected static boolean mCDNotifyOwnerWhenInfected;
	protected static boolean mCDInfectedWhenWild;
	protected static boolean mCDInfectedWhenTamed;
	protected static boolean mCDClearInfectionWhenTamed;
	protected static int mCDBabyInfectionChance;
	protected static int mCDInfectionChance;
	
	//Trickle Chicken Disorder
	protected static boolean trickleChickenDisorder;
	protected static boolean tCDNotifyOwnerWhenInfected;
	protected static boolean tCDInfectedWhenWild;
	protected static boolean tCDInfectedWhenTamed;
	protected static boolean tCDClearInfectionWhenTamed;
	protected static int tCDBabyInfectionChance;
	protected static int tCDInfectionChance;
	protected static float tCDBaseSlownessFactor;
	protected static float tCDMaxSlownessFactor;
	protected static int tCDAdjustmentChance;
	protected static float tCDAdjustmentFactor;
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\
	
	

	private int lastActiveTime;
	private int timeSinceIgnited;

	/** The time until the next egg is spawned. */
	public int timeUntilNextEgg;

	private ChickAIAttackRangedBow aiArrowAttack;

	public EntityMoChicken(EntityType<? extends EntityMoChicken> type, World par1World) {
		super(type, par1World);
		attackingSpeedBoostModifier = (new AttributeModifier(
				attackingSpeedBoostModifierUUID, "attackingSpeedBoostModifier",
				attackSpeed, AttributeModifier.Operation.ADDITION)).setSaved(false);
		if (burnsInSun) {
			goalSelector.addGoal(2, new RestrictSunGoal(this));
			goalSelector.addGoal(3, new FleeSunGoal(this, 1.0D));
		}
		goalSelector.addGoal(1, new SwimGoal(this));
		goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
		if (canBlowUp) {
			goalSelector.addGoal(2, new ChickAISwell(this, movesWhenPrimed, primedMovementSpeed));
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

	/**
	 * Returns true if the newer Entity AI code should be run
	 */
	public boolean isAIEnabled() {
		return true;
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
		UUID s = null;

		if (compound.contains("OwnerUUID", 8)) {
			s = compound.getUniqueId("OwnerUUID");
		} else {
			String s1 = compound.getString("Owner");
			if (s1 != null && s1 != "") {
				s = UUID.fromString(PreYggdrasilConverter.convertMobOwnerIfNeeded(getServer(), s1));
			}
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
		
		if (s != null && s.toString().length() > 0 && !s.toString().equals("00000000-0000-0000-0000-000000000000")) {
			setTamed(true);
			setOwnerId(s);
		}
	}
	
	@Override
	public void writeAdditional(CompoundNBT compound)
    {
        super.writeAdditional(compound);

        if (getOwnerId() == null)
        {
            compound.putString("OwnerUUID", "");
        } else {
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

	protected boolean canDespawn() {
		if (ran == 0) {
			ran = 1;
		}
		return despawn;
	}
	
	protected SoundEvent getLivingSound() {
        return livingSound;
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected SoundEvent getHurtSound() {
        return hurtSound;
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected SoundEvent getDeathSound() {
        return deathSound;
    }

    /**
     * Plays step sound at given x, y, z for the entity
     */
    protected void playStepSound(int par1, int par2, int par3, int par4) {
        playSound(stepSound, 0.15F, 1.0F);
    }
	
	@Override
	public boolean isTamed()
    {
		int tamedInt = (((Byte)dataManager.get(TAMED)).byteValue() & 4);
		boolean tamed = tamedInt != 0;
		
        return tamed;
    }

	@Override
	public void setTamed(boolean tamed)
    {
        byte b0 = ((Byte)dataManager.get(TAMED)).byteValue();

        if (tamed)
        {
            dataManager.set(TAMED, Byte.valueOf((byte)(b0 | 4)));
        	dataManager.set(TAMED, Byte.valueOf((byte)(b0 & -5)));
        }
        else
        {
            dataManager.set(TAMED, Byte.valueOf((byte)(b0 & -5)));
        }

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
			if ((canTemptWild) || (canTemptTamed && isTamed())) {
				goalSelector.addGoal(3, new ChickAITempt(this, 1.0D, temptingItem, false, ownerOnlyTempting, getOwner().getUniqueID(), canTemptWild, canTemptTamed));
			}
			despawn = despawnTamed;
			ran = 0;
			canDespawn();
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
			targetSelector.addGoal(1, new ChickNearestAttackableTarget<>(
					this, PlayerEntity.class, true, attackTrackingRange));
			setChickenState(-1);
			despawn = despawnUntamed;
			ran = 0;
			canDespawn();
		} else {
			despawn = despawnUntamed;
			ran = 0;
			if (laysItemsWild) {
				timeUntilNextEgg = rand.nextInt(variableItemLayTime) + minItemLayTime;
			} else {
				timeUntilNextEgg = -1;
			}
			canDespawn();
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
					setMotion(this.getMotion().mul(0.6D, 1.0D, 0.6D));
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
		BlockPos pos = new BlockPos((int) posX, (int) posY, (int) posZ);
		if (world.getLight(pos) < lightLevelEmited) {
			//System.out.println("Light Set");
			world.getChunkProvider().getLightManager().func_215573_a(pos, config.LIGHT_LEVEL_EMITED.get());
			world.notifyNeighbors(pos, world.getBlockState(pos).getBlock());
			world.getChunkProvider().getLightManager().getLightEngine(LightType.BLOCK).func_215567_a(pos, false);
			world.getLightFor(LightType.BLOCK, pos.up());
			world.getLightFor(LightType.BLOCK, pos.down());
			world.getLightFor(LightType.BLOCK, pos.north());
			world.getLightFor(LightType.BLOCK, pos.south());
			world.getLightFor(LightType.BLOCK, pos.east());
			world.getLightFor(LightType.BLOCK, pos.west());
		}
	}
	
	@Override
	public void onDeath(DamageSource cause)
    {
        if (!world.isRemote && world.getGameRules().getBoolean(GameRules.SHOW_DEATH_MESSAGES) && getOwner() instanceof ServerPlayerEntity)
        {
        	getOwner().sendMessage(getDisplayName().appendText(" at " + dateFormat() + " by " + cause.getImmediateSource().getName()));

        }

        super.onDeath(cause);
    }

	/**
	 * Called frequently so the entity can update its state every tick as
	 * required. For example, zombies and skeletons use this to react to
	 * sunlight and start to burn.
	 */
	private int loc = 0;
	public void livingTick() {
		super.livingTick();
		if (loc == 0) {
			if (ConfigHandler.DEBUG.get()) MoChickens.CHICKEN_LOGGER.debug(chicken + " X:" + posX + " Y:" + posY + " Z:" + posZ);
			loc ++;
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
					world.addParticle(particleType[p],
							posX + (rand.nextDouble() - 0.5D)
							* (double) getWidth(),
							posY + rand.nextDouble()
							* (double) getHeight(),
							posZ + (rand.nextDouble() - 0.5D)
							* (double) getWidth(), 0.0D, 0.0D, 0.0D);
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
				entityDropItem(layingItem[randomInt(0, layingItem.length)], layingItemAmount);
				timeUntilNextEgg = rand.nextInt(variableItemLayTime) + minItemLayTime;
			}
		} else {
			entityDropItem(Items.EGG, layingItemAmount);
			timeUntilNextEgg = rand.nextInt(variableItemLayTime) + minItemLayTime;
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
					Mode flag = (world.getGameRules().get(GameRules.MOB_GRIEFING).get()) ? Mode.BREAK : Mode.NONE;
					world.createExplosion(
							this, posX, posY, posZ,
							(float) explosionRadius, flag);
					if (dataManager.get(EXPLODINGCHICKENSYNDROME)) {
						mc.ingameGUI.getChatGUI().printChatMessage(getDisplayName().appendText(" has blown up from Exploding Chicken Syndrome!"));
						mc.ingameGUI.getChatGUI().printChatMessage(getDisplayName().appendText(" at " + dateFormat()));
					}
					if (target != null) {
						applyEffects(target);
					}
					dead = true;
				}
			}
		}
	}
	
	public String dateFormat() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	public void fall(float distance, float damageMultiplier) {}

	public static int randomInt(int low, int high) {
		int result = (int) (Math.random() * (high - low + 1)) + low;
		return result;
	}

	public float getChickenFlashIntensity(float par1) {
		return ((float) lastActiveTime + (float) (timeSinceIgnited - lastActiveTime)
				* par1) / (float) (fuseTime - 2);
	}

	public int getChickenState()
    {
        return ((Integer)dataManager.get(STATE)).intValue();
    }

    /**
     * Sets the state of creeper, -1 to idle and 1 to be 'in fuse'
     */
    public void setChickenState(int state)
    {
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
	 */
	protected void dropFewItems(boolean par1, int par2) {
		int j = rand.nextInt(3) + rand.nextInt(1 + par2);

		for (int k = 0; k < j; ++k) {
			entityDropItem((Item) Items.FEATHER, 1);
		}

		if (isBurning()) {
			entityDropItem((Item) Items.COOKED_CHICKEN, 1);
		} else {
			entityDropItem((Item) Items.CHICKEN, 1);
		}
	}

	/**
	 * Called when a player interacts with a mob. e.g. gets milk from a cow,
	 * gets into the saddle on a pig.
	 */
	public boolean processInteract(PlayerEntity player, Hand hand) {
		
		ItemStack itemstack = player.getHeldItem(hand);
		
		if (isBreedingItem(itemstack, player)) {
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
				
				if (!itemstack.isEmpty() && tamingItem.toString().contains((itemstack.getItem().getRegistryName().toString()))) {
					if (!player.isCreative()) {
						itemstack.setCount(itemstack.getCount() - 1);
					}
	
					if (itemstack.getCount() <= 0) {
						player.inventory.setInventorySlotContents(
								player.inventory.currentItem,
								(ItemStack) null);
					}
	
					if (!world.isRemote) {
						if (rand.nextInt(tamingChance) == 0) {
							setTamed(true);
							navigator.clearPath();
							setAttackTarget((LivingEntity) null);
							setAttackTarget(null);
							setOwnerId(player.getUniqueID());
							playTameEffect(true);
						} else {
							playTameEffect(false);
							world.setEntityState(this, (byte) 6);
						}
					}
	
				}
			}
		}

		if ((itemstack.getItem() == Items.FLINT_AND_STEEL) && canBeIgnited) {
			this.world.playSound(player, this.posX, this.posY, this.posZ, SoundEvents.ITEM_FLINTANDSTEEL_USE, this.getSoundCategory(), 1.0F, this.rand.nextFloat() * 0.4F + 0.8F);
			player.swingArm(hand);
			if (!this.world.isRemote) {
				this.blowUp();
				itemstack.damageItem(1, player, (p_213625_1_) -> {
					p_213625_1_.sendBreakAnimation(hand);
				});
				return true;
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
	public boolean isBreedingItem(ItemStack par1ItemStack, PlayerEntity player) {
		if ((allowBreedingWild && !isTamed()) || (allowBreedingTamed && isTamed())) {
			if (!ownerOnlyBreeding || getOwner().getUniqueID() == player.getUniqueID()) {
				return !par1ItemStack.isEmpty() && breedingItem.toString()
						.contains(par1ItemStack.getItem().getRegistryName().toString());
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
		if (ConfigHandler.DEBUG.get()) MoChickens.CHICKEN_LOGGER.debug(this.getDisplayName().toString() + " " + config.TEMPTING_ITEMS.get() + "");
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
