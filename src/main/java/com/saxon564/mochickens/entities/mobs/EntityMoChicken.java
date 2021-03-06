package com.saxon564.mochickens.entities.mobs;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.UUID;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundList;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentThorns;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIAttackRangedBow;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIFleeSun;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIRestrictSun;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.init.Biomes;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.management.PreYggdrasilConverter;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;

import com.saxon564.mochickens.MoChickens;
import com.saxon564.mochickens.Reference;
import com.saxon564.mochickens.entities.mobs.ai.ChickAIAttackRangedBow;
import com.saxon564.mochickens.entities.mobs.ai.ChickAISwell;
import com.saxon564.mochickens.entities.mobs.ai.ChickAITempt;
import com.saxon564.mochickens.entities.mobs.ai.ChickAITemptDye;

public class EntityMoChicken extends EntityTameable implements IRangedAttackMob {
	private static final UUID attackingSpeedBoostModifierUUID = UUID
			.fromString("020E0DFB-87AE-4653-9556-831010E291A0");
	private static AttributeModifier attackingSpeedBoostModifier;
	
	private final Minecraft mc = Minecraft.getMinecraft();

	private Entity entityToAttack;
	private Entity lastEntityToAttack;
	private boolean isAggressive;
	private int teleportDelay;
	private static final DataParameter<Integer> STATE = EntityDataManager.<Integer>createKey(EntityMoChicken.class, DataSerializers.VARINT);
	private static final DataParameter<Boolean> SCREAMING = EntityDataManager.<Boolean>createKey(EntityMoChicken.class, DataSerializers.BOOLEAN);
	public static final DataParameter<Boolean> EXPLODINGCHICKENSYNDROME = EntityDataManager.<Boolean>createKey(EntityMoChicken.class, DataSerializers.BOOLEAN);
	public static final DataParameter<Boolean> MADCHICKENDISEASE = EntityDataManager.<Boolean>createKey(EntityMoChicken.class, DataSerializers.BOOLEAN);
	public static final DataParameter<String> OWNER = EntityDataManager.<String>createKey(EntityMoChicken.class, DataSerializers.STRING);
	

	public float field_70886_e = 0.0F;
	public float destPos = 0.0F;
	public float field_70884_g;
	public float field_70888_h;
	public float field_70889_i = 1.0F;
	private EnumDifficulty checked = this.world.getDifficulty();
	private boolean despawn;
	private int ran;
	private Class chicken;
	
	/**********************************/
	/*********config variables*********/
	/**********************************/
	protected Configuration config;
	
	// Attack Data
	protected String[] effectIDs;
	protected int[] effectAmplifiers;
	protected int[] effectDurations;
	protected int arrowShootSpeed;
	protected double attackDamage;
	protected double attackSpeed;
	protected double attackTrackingRange;
	protected boolean canBlowUp;
	protected boolean canShootArrows;
	protected int explosionRadius;
	protected int fireDuration;
	protected int fuseTime;
	protected boolean setTargetOnFire;
	
	// Breeding
	protected Item breedingItem;
	protected int breedingItemData;
	protected boolean breedingItemUsesData;
	
	// Entity Data
	protected boolean allowBreeding;
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
	protected boolean hostile;
	protected int id;
	protected boolean immuneToFire;
	protected int lightLevelEmited;
	protected EnumParticleTypes particleType;
	protected int particlesPerTick;
	protected double walkSpeed;
	
	// Laying
	protected Item layingItem;
	protected int layingItemAmount;
	protected int layingItemData;
	protected int layingItemMaxData;
	protected int layingItemMinData;
	protected boolean layingItemUsesData;
	protected boolean layingItemUsesRandomData;
	protected SoundEvent layingSound;
	protected int minItemLayTime;
	protected int variableItemLayTime;
	
	// Spawning
	protected String biomeListType;
	protected String[] biomeList;
	protected boolean canSpawn;
	protected int maxSpawnGroupSize;
	protected double maxSpawnTemp;
	protected int minSpawnGroupSize;
	protected double minSpawnTemp;
	protected int spawnProbability;
	protected static int minSpawnLightLevel;
	protected static int maxSpawnLightLevel;
	
	// Taming
	protected int tamingChance;
	protected Item tamingItem;
	protected int tamingItemData;
	protected boolean tamingItemUsesData;
	
	// Tempting
	protected int delayFollowingBetweenItemHoldings;
	protected Item temptingItem;
	protected int temptingItemData;
	protected boolean temptingItemUsesData;
	
	//~~~~~~~~~~~~~~~~~Infections~~~~~~~~~~~~~~~~~\\
	// Exploding Chicken Syndrome
	protected boolean explodingChickenSyndrome;
	public boolean explodingByECS;
	protected boolean eCSNotifyOwnerWhenInfected;
	protected boolean eCSInfectedWhenWild;
	protected boolean eCSInfectedWhenTamed;
	protected boolean eCSClearInfectionWhenTamed;
	protected int eCSBabyInfectionChance;
	protected int eCSInfectionChance;
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
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\
	
	

	private int lastActiveTime;
	private int timeSinceIgnited;

	/** The time until the next egg is spawned. */
	public int timeUntilNextEgg;

	private ChickAIAttackRangedBow aiArrowAttack;

	public EntityMoChicken(World par1World) {
		super(par1World);
		float x = (float) hitBoxSizeX;
		float z = (float) hitBoxSizeZ;
		this.setSize(x, z);
		float f = 0.25F;
		this.attackingSpeedBoostModifier = (new AttributeModifier(
				attackingSpeedBoostModifierUUID, "attackingSpeedBoostModifier",
				attackSpeed, 0)).setSaved(false);
		if (burnsInSun) {
			this.tasks.addTask(2, new EntityAIRestrictSun(this));
			this.tasks.addTask(3, new EntityAIFleeSun(this, 1.0D));
		}
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
		if (canBlowUp) {
			this.tasks.addTask(2, new ChickAISwell(this));
		}
		this.isImmuneToFire = immuneToFire;
		this.tasks.addTask(4, new EntityAIFollowParent(this, 1.1D));
		this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(6, new EntityAIWatchClosest(this,
				EntityPlayer.class, 6.0F));
		this.tasks.addTask(7, new EntityAILookIdle(this));
		this.timeUntilNextEgg = -1;
		if (canShootArrows) {
			aiArrowAttack = new ChickAIAttackRangedBow(this, 1.0D, arrowShootSpeed, 15.0F);
		}
		this.setTamed(false);
	}

	protected void entityInit() {
		super.entityInit();
		this.dataManager.register(STATE, Integer.valueOf(-1));
		this.dataManager.register(SCREAMING, false);
		this.dataManager.register(OWNER, "");
		this.dataManager.register(EXPLODINGCHICKENSYNDROME, false);
		this.dataManager.register(MADCHICKENDISEASE, false);
	}

	/**
	 * Returns true if the newer Entity AI code should be run
	 */
	public boolean isAIEnabled() {
		return true;
	}

	public void applyEntityAttributes(Configuration c, Class cl) {
		super.applyEntityAttributes();
		setupConfigVariables(c, cl);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(health);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(walkSpeed);
	}

	@Override
	public final void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		UUID s = null;

		if (compound.hasKey("OwnerUUID", 8)) {
			s = compound.getUniqueId("OwnerUUID");
		} else {
			String s1 = compound.getString("Owner");
			if (s1 != null && s1 != "") {
				s = UUID.fromString(PreYggdrasilConverter.convertMobOwnerIfNeeded(getServer(), s1));
			}
		}
		
		if (compound.hasKey("ExplodingChickenSyndrome")) {
			setExplodingChickenSyndrome(compound.getBoolean("ExplodingChickenSyndrome"));
		}
		
		if (compound.hasKey("MadChickenDisease")) {
			setMadChickenDisease(compound.getBoolean("MadChickenDisease"));
		}
		
		if (s != null && s.toString().length() > 0 && !s.toString().equals("00000000-0000-0000-0000-000000000000")) {
			this.setTamed(true);
			this.setOwnerId(s);
		}
	}
	
	@Override
	public void writeEntityToNBT(NBTTagCompound compound)
    {
        super.writeEntityToNBT(compound);

        if (this.getOwnerId() == null)
        {
            compound.setString("OwnerUUID", "");
        } else {
            compound.setString("OwnerUUID", this.getOwnerId().toString());
        }
        if (this.getExplodingChickenSyndrome()) {
        	compound.setBoolean("ExplodingChickenSyndrome", true);
        } else {
        	compound.setBoolean("ExplodingChickenSyndrome", false);
        }
        
        if (this.getMadChickenDisease()) {
        	compound.setBoolean("MadChickenDisease", true);
        } else {
        	compound.setBoolean("MadChickenDisease", false);
        }
    }

	protected boolean canDespawn() {
		if (ran == 0) {
			// System.out.println("Coal Deaspawning is: " + despawn);
			ran = 1;
		}
		return despawn;
	}
	
	@Override
	public boolean isTamed()
    {
		int tamedInt = (((Byte)this.dataManager.get(TAMED)).byteValue() & 4);
		boolean tamed = tamedInt != 0;
		
        return tamed;
    }

	@Override
	public void setTamed(boolean tamed)
    {
        byte b0 = ((Byte)this.dataManager.get(TAMED)).byteValue();

        if (tamed)
        {
            this.dataManager.set(TAMED, Byte.valueOf((byte)(b0 | 4)));
        }
        else
        {
            this.dataManager.set(TAMED, Byte.valueOf((byte)(b0 & -5)));
        }

        this.setupTaimedAI(tamed);
    }
	
	public void setupTaimedAI(boolean tamed) {
		if (tamed) {
			if (getExplodingChickenSyndrome() && eCSClearInfectionWhenTamed) {
				setExplodingChickenSyndrome(false);
			}
			if (getMadChickenDisease() && mCDClearInfectionWhenTamed) {
				setMadChickenDisease(false);
				this.tasks.removeTask(new EntityAIAttackMelee(this, 1.0D, false));
			}
			this.world.setEntityState(this, (byte) 7);
			this.targetTasks.removeTask(new EntityAINearestAttackableTarget(
					this, EntityPlayer.class, true));
			if (canShootArrows) {
				this.tasks.removeTask(this.aiArrowAttack);
			}
			//this.targetTasks.taskEntries.clear();
			if (temptingItemUsesData) {
				this.tasks.addTask(
						3,
						new ChickAITemptDye(this, 1.0D, new ItemStack(
								temptingItem, 1, temptingItemData)
								.getDisplayName().toLowerCase(), false));
			} else {
				this.tasks.addTask(
						3,
						new ChickAITempt(this, 1.0D, temptingItem, false));

			}
			despawn = despawnTamed;
			ran = 0;
			this.canDespawn();
			this.timeUntilNextEgg = this.rand.nextInt(variableItemLayTime)
					+ minItemLayTime;
		} else if (hostile) {
			if (canShootArrows) {
				this.tasks.addTask(4, this.aiArrowAttack);
			} else {
				this.tasks.addTask(2, new EntityAIAttackMelee(this, attackSpeed, false));
			}
			this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(
					this, EntityPlayer.class, true));
			setChickenState(-1);
			despawn = despawnUntamed;
			ran = 0;
			this.canDespawn();
		} else {
			despawn = despawnUntamed;
			ran = 0;
			this.canDespawn();
		}

		if (this.world.getDifficulty().toString().equalsIgnoreCase(
				"peaceful")) {
			this.difficultyChange();
		}
	}
	
	/**
     * Checks to make sure the light is not too bright where the mob is spawning
     */
	protected boolean isValidLightLevel()
    {
        BlockPos blockpos = new BlockPos(this.posX, this.getEntityBoundingBox().minY, this.posZ);

        if (this.world.getLightFor(EnumSkyBlock.SKY, blockpos) > this.rand.nextInt(32))
        {
            return false;
        }
        else
        {
            int i = this.world.getLightFromNeighbors(blockpos);

            if (this.world.isThundering())
            {
                int j = this.world.getSkylightSubtracted();
                this.world.setSkylightSubtracted(10);
                i = this.world.getLightFromNeighbors(blockpos);
                this.world.setSkylightSubtracted(j);
            }

            return i <= this.rand.nextInt(8);
        }
    }
	
	@Override
    public boolean getCanSpawnHere()
    {
		super.getCanSpawnHere();
		BlockPos pos = new BlockPos((int) this.posX, (int) this.posY, (int) this.posZ);
		Block block = this.world.getBlockState(pos).getBlock();
		int light = this.world.getLightFromNeighbors(pos);
		IBlockState iBlockState = this.world.getBlockState((new BlockPos(this)));
		IBlockState iBlockStateDown = this.world.getBlockState((new BlockPos(this)).down());
		/*List<SpawnListEntry> list = this.world.getBiome(pos).getSpawnableList(EnumCreatureType.MONSTER);
		list.forEach((temp) -> {
			System.out.println("Chicken:" + this.chicken.toString().substring(44) + " Could be: " + temp);
		});
		List<SpawnListEntry> list2 = Biomes.HELL.getSpawnableList(EnumCreatureType.MONSTER);
		list2.forEach((temp) -> {
			System.out.println("Chicken:" + this.chicken.toString().substring(44) + " Could be: " + temp);
		});
		List<SpawnListEntry> list3 = Biomes.SKY.getSpawnableList(EnumCreatureType.MONSTER);
		list3.forEach((temp) -> {
			System.out.println("Chicken:" + this.chicken.toString().substring(44) + " Could be: " + temp);
		});*/
		//do {
		//	System.out.println("Chicken:" + this.chicken.toString() + " Could be: " + list.listIterator().next().entityClass.toString() + " with Spawn Probability: " + list.listIterator().next().itemWeight + "and a min/max of" + list.listIterator().next().minGroupCount + "/" + list.listIterator().next().maxGroupCount);
		//} while(list.listIterator().hasNext());
		//System.out.println("Chicken:" + this.chicken.toString() + " Spawn Probability: " + list.get(index).itemWeight);
		if (iBlockStateDown.canEntitySpawn(this)/*!block.isPassable(world, pos.down())*/ && (light >= minSpawnLightLevel) && (light <= maxSpawnLightLevel)) {
			//System.out.println("Chicken:" + this.chicken.toString() + " X:" + this.posX + " Y:" + this.posY + " Z:" + this.posZ);
			//System.out.println("Chicken:" + this.chicken.toString() + " Light data: current: " + light + " min: " + minSpawnLightLevel + " max: " + maxSpawnLightLevel);
			return true;
		} else {
			return false;
		}
    }

	public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
		if (this.isEntityInvulnerable(par1DamageSource)) {
			return false;
		} else if (allowTeleporting) {
			this.setScreaming(true);

			if (par1DamageSource instanceof EntityDamageSource
					&& par1DamageSource.getTrueSource() instanceof EntityPlayer) {
				this.isAggressive = true;
			}

			if (par1DamageSource instanceof EntityDamageSourceIndirect) {
				this.isAggressive = false;

				for (int i = 0; i < 64; ++i) {
					if (this.teleportRandomly()) {
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

	public boolean attackEntityAsMob(Entity par1Entity) {
		if ((!this.isTamed())
				&& (hostile)
				&& (!canBlowUp)) {
			EntityPlayer entityplayer = this.world
					.getClosestPlayerToEntity(this, attackTrackingRange);
			float f = (float) attackDamage;
			int i = 0;

			if (entityplayer instanceof EntityLivingBase) {
				f += EnchantmentHelper.getModifierForCreature(this.getHeldItemMainhand(), ((EntityLivingBase)par1Entity).getCreatureAttribute());
	            i += EnchantmentHelper.getKnockbackModifier(this);
				applyEffects(entityplayer);
				if (setTargetOnFire) {
					entityplayer.setFire(fireDuration);
				}
			}

			boolean flag = par1Entity.attackEntityFrom(
					DamageSource.causeMobDamage(this), f);

			if (flag) {
				if (i > 0) {
					entityplayer.knockBack(this, (float)i * 0.5F, (double)MathHelper.sin(this.rotationYaw * 0.017453292F), (double)(-MathHelper.cos(this.rotationYaw * 0.017453292F)));
					this.motionX *= 0.6D;
					this.motionZ *= 0.6D;
				}

				int j = EnchantmentHelper.getFireAspectModifier(this);

				if (j > 0) {
					entityplayer.setFire(j * 4);
				}

				if (par1Entity instanceof EntityPlayer)
	            {
	                EntityPlayer entityp = (EntityPlayer)par1Entity;
	                ItemStack itemstack1 = entityp.isHandActive() ? entityp.getActiveItemStack() : ItemStack.EMPTY;

	                if (!itemstack1.isEmpty() && itemstack1.getItem() == Items.SHIELD)
	                {
	                    float f1 = 0.25F + (float)EnchantmentHelper.getEfficiencyModifier(this) * 0.05F;

	                    if (this.rand.nextFloat() < f1)
	                    {
	                        entityp.getCooldownTracker().setCooldown(Items.SHIELD, 100);
	                        this.world.setEntityState(entityp, (byte)30);
	                    }
	                }
	            }

	            this.applyEnchantments(this, par1Entity);
			}

			return flag;
		} else {
			return false;
		}
	}

	private void applyEffects(EntityPlayer entityplayer) {

		for (int p = 0; p < effectIDs.length; p++) {
			Potion pot = Potion.getPotionFromResourceLocation(effectIDs[p]);
			int amplifier = effectAmplifiers[p];
			int duration = effectDurations[p];
			if (checkpot(pot, amplifier, duration) != "") {
				entityplayer.addPotionEffect(new PotionEffect(pot, duration, amplifier));
			} else {
				MoChickens.logger.error("Effect " + effectIDs[p] + " was not found!");
			}
		}
	}

	private String checkpot(Potion pot, int amplifier, int duration) {
		String test = "";
		if (pot != null) {
			test = new PotionEffect(pot, amplifier, duration).getEffectName();
			int test2 = new PotionEffect(pot, amplifier, duration).getDuration();
			int test3 = new PotionEffect(pot, amplifier, duration).getAmplifier();
		}
		return test;
	}

	private void addLight() {
		this.world.setLightFor(EnumSkyBlock.BLOCK, new BlockPos((int) this.posX,
				(int) this.posY, (int) this.posZ), lightLevelEmited);
		this.world.markBlockRangeForRenderUpdate((int) this.posX,
				(int) this.posY, (int) this.posX, 12, 12, 12);
		this.world.updateBlockTick(new BlockPos((int) this.posX, (int) this.posY,
				(int) this.posZ), this.world.getBlockState(new BlockPos((int) this.posX, (int) this.posY,
				(int) this.posZ)).getBlock(), 1, 0);
		this.world.checkLightFor(EnumSkyBlock.BLOCK, new BlockPos((int) this.posX,
				(int) this.posY + 1, (int) this.posZ));
		this.world.checkLightFor(EnumSkyBlock.BLOCK, new BlockPos((int) this.posX,
				(int) this.posY - 1, (int) this.posZ));
		this.world.checkLightFor(EnumSkyBlock.BLOCK, new BlockPos(
				(int) this.posX + 1, (int) this.posY, (int) this.posZ));
		this.world.checkLightFor(EnumSkyBlock.BLOCK, new BlockPos(
				(int) this.posX - 1, (int) this.posY, (int) this.posZ));
		this.world.checkLightFor(EnumSkyBlock.BLOCK, new BlockPos(
				(int) this.posX, (int) this.posY, (int) this.posZ + 1));
		this.world.checkLightFor(EnumSkyBlock.BLOCK, new BlockPos(
				(int) this.posX, (int) this.posY, (int) this.posZ - 1));
	}

	/**
	 * Called frequently so the entity can update its state every tick as
	 * required. For example, zombies and skeletons use this to react to
	 * sunlight and start to burn.
	 */
	private int loc = 0;
	public void onLivingUpdate() {
		super.onLivingUpdate();
		if (loc == 0) {
			//System.out.println(this.chicken + " X:" + this.posX + " Y:" + this.posY + " Z:" + this.posZ);
			loc ++;
		}
		if (this.world.isDaytime() && !this.world.isRemote && burnsInSun) {
			float f = this.getBrightness();

			if (f > 0.5F
					&& this.rand.nextFloat() * 30.0F < (f - 0.4F) * 2.0F
					&& this.world.canBlockSeeSky(new BlockPos(
							MathHelper.floor(this.posX),
							MathHelper.floor(this.posY),
							MathHelper.floor(this.posZ)))) {
				boolean flag = true;

				if (flag) {
					this.setFire(8);
				}
			}
		}

		if (this.lastEntityToAttack != this.entityToAttack) {
			IAttributeInstance attributeinstance = this
					.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED);
			attributeinstance.removeModifier(attackingSpeedBoostModifier);

			if (this.entityToAttack != null) {
				attributeinstance.applyModifier(attackingSpeedBoostModifier);
			}
		}

		this.lastEntityToAttack = this.entityToAttack;

		if (allowTeleporting) {
			if (this.world.isDaytime() && !this.world.isRemote) {
				float f = this.getBrightness();

				if (f > 0.5F && this.world.canBlockSeeSky(new BlockPos(
								MathHelper.floor(this.posX),
								MathHelper.floor(this.posY),
								MathHelper.floor(this.posZ)))
						&& this.rand.nextFloat() * 30.0F < (f - 0.4F) * 2.0F) {
					this.entityToAttack = null;
					this.setScreaming(false);
					this.isAggressive = false;
					this.teleportRandomly();
				}
			}

			if (this.isWet() || this.isBurning()) {
				this.entityToAttack = null;
				this.setScreaming(false);
				this.isAggressive = false;
				this.teleportRandomly();
			}

			if (this.isScreaming() && !this.isAggressive
					&& this.rand.nextInt(100) == 0) {
				this.setScreaming(false);
			}

			this.isJumping = false;

			if (this.entityToAttack != null) {
				this.faceEntity(this.entityToAttack, 100.0F, 100.0F);
			}

			if (!this.world.isRemote && this.isEntityAlive()) {
				if (this.entityToAttack != null) {
					if (this.entityToAttack instanceof EntityPlayer) {
						if (this.entityToAttack.getDistanceSq(this) < 16.0D) {
							this.teleportRandomly();
						}

						this.teleportDelay = 0;
					} else if (this.entityToAttack.getDistanceSq(this) > 256.0D
							&& this.teleportDelay++ >= 30
							&& this.teleportToEntity(this.entityToAttack)) {
						this.teleportDelay = 0;
					}
				} else {
					this.setScreaming(false);
					this.teleportDelay = 0;
				}
			}
		}

		if ((!this.isTamed()) && (canBlowUp) && (hostile)) {
			blowUp();
		}

		this.field_70888_h = this.field_70886_e;
		this.field_70884_g = this.destPos;
		this.destPos = (float) ((double) this.destPos + (double)
				(this.onGround ? -1 : 4) * 0.3D);

		if (this.destPos < 0.0F) {
			this.destPos = 0.0F;
		}

		if (this.destPos > 1.0F) {
			this.destPos = 1.0F;
		}

		if (!this.onGround && this.field_70889_i < 1.0F) {
			this.field_70889_i = 1.0F;
		}

		if (emitsParticles) {
			for (int i = 0; i < particlesPerTick; ++i) {
				this.world.spawnParticle(particleType,
						this.posX + (this.rand.nextDouble() - 0.5D)
								* (double) this.width,
						this.posY + this.rand.nextDouble()
								* (double) this.height,
						this.posZ + (this.rand.nextDouble() - 0.5D)
								* (double) this.width, 0.0D, 0.0D, 0.0D);
			}
		}

		if (emitsLight) {
			addLight();
		}

		if ((this.isWet()) && (getsHurtByWater)) {
			this.attackEntityFrom(DamageSource.DROWN, (float) damageFromWater);
		}

		this.field_70889_i = (float) ((double) this.field_70889_i * 0.9D);

		if (!this.onGround && this.motionY < 0.0D) {
			this.motionY *= 0.6D;
		}

		this.field_70886_e += this.field_70889_i * 2.0F;

		if (this.world.getDifficulty() != checked) {
			this.difficultyChange();
			checked = this.world.getDifficulty();
		}

		if (!this.isChild() && !this.world.isRemote
				&& --this.timeUntilNextEgg == 0) {
			this.playSound(
					layingSound, 1.0F,
					(this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
			if (layingItem != null) {
				if (layingItemUsesData) {
					if (layingItemUsesRandomData) {
						this.entityDropItem(
								new ItemStack(layingItem, 1,
										this.randomInt(layingItemMinData, 
												layingItemMaxData)), layingItemAmount);
					} else {
						this.entityDropItem(new ItemStack(layingItem, 
								1, layingItemData), 
								layingItemAmount);
					}
				} else {
					this.dropItem(layingItem, layingItemAmount);
				}
			} else {
				this.dropItem(Items.EGG, layingItemAmount);
			}
			this.timeUntilNextEgg = this.rand.nextInt(variableItemLayTime) 
					+ minItemLayTime;
		}
		
		manageInfections();

		if (this.isDead) {
			this.world.checkLightFor(EnumSkyBlock.BLOCK,
					new BlockPos((int) this.posX, (int) this.posY, (int) this.posZ));
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
							if (world.playerEntities.contains(getOwner())) {
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
					this.playSound(SoundEvents.ENTITY_CREEPER_PRIMED, 1.0F, 0.5F);
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
			System.out.println(this.getName() + " Should by mad!");
			this.tasks.addTask(2, new EntityAIAttackMelee(this, 1.0D, false));
			if (canShootArrows) {
				this.tasks.addTask(4, this.aiArrowAttack);
			}
			this.targetTasks.addTask(0, new EntityAINearestAttackableTarget(
					this, EntityMoChicken.class, true));
		}
		dataManager.set(MADCHICKENDISEASE, bool);
	}
	
	public void blowUp() {
		if (this.isEntityAlive()) {
			this.lastActiveTime = this.timeSinceIgnited;
			int i = this.getChickenState();

			if (i > 0 && this.timeSinceIgnited == 0) {
				this.playSound(SoundEvents.ENTITY_CREEPER_PRIMED, 1.0F, 0.5F);
			}

			this.timeSinceIgnited += i;

			if (this.timeSinceIgnited < 0) {
				this.timeSinceIgnited = 0;
			}

			if (this.timeSinceIgnited >= fuseTime) {
				this.timeSinceIgnited = fuseTime;

				if (!this.world.isRemote) {
					EntityPlayer entityplayer = this.world
							.getClosestPlayerToEntity(this, 5.0D);
					boolean flag = this.world.getGameRules()
							.getBoolean("mobGriefing");
					this.world.createExplosion(
							this, this.posX, this.posY, this.posZ,
							(float) explosionRadius, flag);
					if (dataManager.get(EXPLODINGCHICKENSYNDROME)) {
						mc.ingameGUI.getChatGUI().printChatMessage(getDisplayName().appendText(" has blown up from Exploding Chicken Syndrome!"));
					}
					if (entityplayer != null) {
						applyEffects(entityplayer);
					}
					this.setDead();
				}
			}
		}
	}
	
	public void fall(float distance, float damageMultiplier) {}

	public static int randomInt(int low, int high) {
		int result = (int) (Math.random() * (high - low + 1)) + low;
		return result;
	}

	public float getChickenFlashIntensity(float par1) {
		return ((float) this.lastActiveTime + (float) (this.timeSinceIgnited - this.lastActiveTime)
				* par1) / (float) (fuseTime - 2);
	}

	public int getChickenState()
    {
        return ((Integer)this.dataManager.get(this.STATE)).intValue();
    }

    /**
     * Sets the state of creeper, -1 to idle and 1 to be 'in fuse'
     */
    public void setChickenState(int state)
    {
        this.dataManager.set(this.STATE, Integer.valueOf(state));
    }

	private void difficultyChange() {
		if (this.world.getDifficulty().toString().equalsIgnoreCase(
				"peaceful")) {
			this.navigator.clearPath();
			this.setAttackTarget((EntityLivingBase) null);
			this.setAttackTarget(null);
			this.targetTasks.taskEntries.clear();
		} else {
			if (this.getOwner() != null) {
				EntityLivingBase s = (EntityLivingBase) this.getOwner();
				System.out.println("Difficult Change");
				System.out.println(s.getUniqueID().toString());

				if (s.getUniqueID().toString().length() > 0) {
					this.setTamed(true);
					this.setOwnerId(s.getUniqueID());
				}
			} else {
				this.setTamed(false);
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
		int j = this.rand.nextInt(3) + this.rand.nextInt(1 + par2);

		for (int k = 0; k < j; ++k) {
			this.dropItem((Item) Items.FEATHER, 1);
		}

		if (this.isBurning()) {
			this.dropItem((Item) Items.COOKED_CHICKEN, 1);
		} else {
			this.dropItem((Item) Items.CHICKEN, 1);
		}
	}

	/**
	 * Called when a player interacts with a mob. e.g. gets milk from a cow,
	 * gets into the saddle on a pig.
	 */
	public boolean processInteract(EntityPlayer player, EnumHand hand) {
		
		ItemStack itemstack = player.getHeldItem(hand);
		
		if (!this.isTamed()) {
			
			if (tamingItemUsesData) {
				System.out.print("Item Requires Data");
				if (!itemstack.isEmpty() && ((itemstack.getDisplayName().toLowerCase()
						.equalsIgnoreCase(new ItemStack(tamingItem, 1, 
								tamingItemData)
								.getDisplayName().toLowerCase())))) {
					if (!player.capabilities.isCreativeMode) {
						itemstack.setCount(itemstack.getCount() - 1);;
					}

					if (itemstack.getCount() <= 0) {
						player.inventory.setInventorySlotContents(
								player.inventory.currentItem,
								(ItemStack) null);
					}

					if (!this.world.isRemote) {
						if (this.rand.nextInt(tamingChance) == 0) {
							this.setTamed(true);
							this.navigator.clearPath();
							this.setAttackTarget((EntityLivingBase) null);
							this.setAttackTarget(null);
							this.setOwnerId(player.getUniqueID());
							this.playTameEffect(true);
						} else {
							this.playTameEffect(false);
							this.world.setEntityState(this, (byte) 6);
						}
					}

					return true;
				}
			} else if (!itemstack.isEmpty() && ((itemstack.getItem().equals(tamingItem)))) {
				if (!player.capabilities.isCreativeMode) {
					itemstack.setCount(itemstack.getCount() - 1);
				}

				if (itemstack.getCount() <= 0) {
					player.inventory.setInventorySlotContents(
							player.inventory.currentItem,
							(ItemStack) null);
				}

				if (!this.world.isRemote) {
					if (this.rand.nextInt(tamingChance) == 0) {
						this.setTamed(true);
						this.navigator.clearPath();
						this.setAttackTarget((EntityLivingBase) null);
						this.setAttackTarget(null);
						this.setOwnerId(player.getUniqueID());
						this.playTameEffect(true);
					} else {
						this.playTameEffect(false);
						this.world.setEntityState(this, (byte) 6);
					}
				}

			}
		}

		return super.processInteract(player, hand);
	}

	/**
	 * This function is used when two same-species animals in 'love mode' breed
	 * to generate the new baby animal.
	 */
	public EntityMoChicken spawnBabyAnimal(EntityAgeable par1EntityAgeable) {
		try {
			EntityMoChicken newEntity = (EntityMoChicken) chicken
					.getDeclaredConstructor(World.class).newInstance(
							par1EntityAgeable.world);

			EntityLivingBase s = (EntityLivingBase) this.getOwner();

			if (s != null && s.getUniqueID().toString().length() > 0) {
				((EntityMoChicken) newEntity).setOwnerId(s.getUniqueID());
				((EntityMoChicken) newEntity).setupConfigVariables(config, chicken);
				((EntityMoChicken) newEntity).setTamed(true);
			}

			return (EntityMoChicken) newEntity;
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Checks if the parameter is an item which this animal can be fed to breed
	 * it (wheat, carrots or seeds depending on the animal type)
	 */
	public boolean isBreedingItem(ItemStack par1ItemStack) {
		if (allowBreeding) {
			if (this.isTamed()) {
				if (breedingItemUsesData) {
					return !par1ItemStack.isEmpty() && par1ItemStack.getDisplayName().toLowerCase()
							.equalsIgnoreCase(new ItemStack(breedingItem, 1, breedingItemData)
									.getDisplayName().toLowerCase());
				} else {
					return !par1ItemStack.isEmpty() && par1ItemStack.getItem()
							.equals(breedingItem);
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public EntityAgeable createChild(EntityAgeable par1EntityAgeable) {
		return this.spawnBabyAnimal(par1EntityAgeable);
	}

	public boolean isScreaming()
    {
        return ((Boolean)this.dataManager.get(SCREAMING)).booleanValue();
    }

	public void setScreaming(boolean par1) {
		this.dataManager.set(SCREAMING, par1);;
	}

	protected boolean teleportRandomly() {
		if (!this.isTamed()) {
			double d0 = this.posX + (this.rand.nextDouble() - 0.5D) * 64.0D;
			double d1 = this.posY + (double) (this.rand.nextInt(64) - 32);
			double d2 = this.posZ + (this.rand.nextDouble() - 0.5D) * 64.0D;
			return this.teleportTo(d0, d1, d2);
		} else {
			return false;
		}
	}

	protected boolean teleportToEntity(Entity par1Entity) {
		Vec3d vec3 = new Vec3d(this.posX - par1Entity.posX,
				this.getEntityBoundingBox().minY + (double) (this.height / 1.5F)
						- par1Entity.posY + (double) par1Entity.getEyeHeight(),
				this.posZ - par1Entity.posZ);
		vec3 = vec3.normalize();
		double d0 = 16.0D;
		double d1 = this.posX + (this.rand.nextDouble() - 0.5D) * 8.0D
				- vec3.x * d0;
		double d2 = this.posY + (double) (this.rand.nextInt(16) - 8)
				- vec3.y * d0;
		double d3 = this.posZ + (this.rand.nextDouble() - 0.5D) * 8.0D
				- vec3.z * d0;
		return this.teleportTo(d1, d2, d3);
	}

	private boolean teleportTo(double x, double y, double z)
    {
        net.minecraftforge.event.entity.living.EnderTeleportEvent event = new net.minecraftforge.event.entity.living.EnderTeleportEvent(this, x, y, z, 0);
        if (net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event)) return false;
        boolean flag = this.attemptTeleport(event.getTargetX(), event.getTargetY(), event.getTargetZ());

        if (flag)
        {
            this.world.playSound((EntityPlayer)null, this.prevPosX, this.prevPosY, this.prevPosZ, SoundEvents.ENTITY_ENDERMEN_TELEPORT, this.getSoundCategory(), 1.0F, 1.0F);
            this.playSound(SoundEvents.ENTITY_ENDERMEN_TELEPORT, 1.0F, 1.0F);
        }

        return flag;
    }

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase target, float distanceFactor)
    {
        EntityArrow entityarrow = this.getArrow(distanceFactor);
        double d0 = target.posX - this.posX;
        double d1 = target.getEntityBoundingBox().minY + (double)(target.height / 3.0F) - entityarrow.posY;
        double d2 = target.posZ - this.posZ;
        double d3 = (double)MathHelper.sqrt(d0 * d0 + d2 * d2);
        entityarrow.shoot(d0, d1 + d3 * 0.20000000298023224D, d2, 1.6F, (float)(14 - this.world.getDifficulty().getDifficultyId() * 4));
        this.playSound(SoundEvents.ENTITY_SKELETON_SHOOT, 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
        this.world.spawnEntity(entityarrow);
        
    }
	
	protected EntityArrow getArrow(float power)
    {
        EntityTippedArrow entitytippedarrow = new EntityTippedArrow(this.world, this);
        for (int p = 0; p < effectIDs.length; p++) {
			Potion pot = Potion.getPotionFromResourceLocation(effectIDs[p]);
			int amplifier = effectAmplifiers[p];
			int duration = effectDurations[p];
			if (checkpot(pot, amplifier, duration) != "") {
				entitytippedarrow.addEffect(new PotionEffect(pot, duration, amplifier));
			} else {
				MoChickens.logger.error("Effect " + effectIDs[p] + " was not found for arrow!");
			}
		}
        return entitytippedarrow;
    }

	public void setupConfigVariables(Configuration c, Class cl) {
		
		chicken = cl;
		config = c;
		
		// Attack Data
		effectIDs = config.getCategory("attack data").get("Effect IDs").getStringList();
		effectAmplifiers = config.getCategory("attack data").get("Effect Amplifiers").getIntList();
		effectDurations = config.getCategory("attack data").get("Effect Durations").getIntList();
		arrowShootSpeed = config.getCategory("attack data").get("Arrow Shoot Speed").getInt();
		attackDamage = config.getCategory("attack data").get("Attack Damage").getDouble();
		attackSpeed = config.getCategory("attack data").get("Attack Speed").getDouble();
		attackTrackingRange = config.getCategory("attack data").get("Attack Tracking Range").getDouble();
		canBlowUp = config.getCategory("attack data").get("Can Blow Up").getBoolean();
		canShootArrows = config.getCategory("attack data").get("Can Shoot Arrows").getBoolean();
		explosionRadius = config.getCategory("attack data").get("Explosion Radius").getInt();
		fireDuration = config.getCategory("attack data").get("Fire Duration").getInt();
		fuseTime = config.getCategory("attack data").get("Fuse Time").getInt();
		setTargetOnFire = config.getCategory("attack data").get("Set Target On Fire").getBoolean();
		
		// Breeding
		breedingItem = Item.REGISTRY.getObject(new ResourceLocation(config.getCategory("breeding").get("Breeding Item").getString()));
		breedingItemData = config.getCategory("breeding").get("Breeding Item Data").getInt();
		breedingItemUsesData = config.getCategory("breeding").get("Breeding Item Uses Data").getBoolean();
		
		// Entity Data
		allowBreeding = config.getCategory("entity data").get("Allow Breeding").getBoolean();
		allowTeleporting = config.getCategory("entity data").get("Allow Teleporting").getBoolean();
		burnsInSun = config.getCategory("entity data").get("Burns in Sun").getBoolean();
		damageFromWater = config.getCategory("entity data").get("Damage From Water").getDouble();
		despawnTamed = config.getCategory("entity data").get("Despawn Tamed").getBoolean();
		despawnUntamed = config.getCategory("entity data").get("Despawn Untamed").getBoolean();
		emitsLight = config.getCategory("entity data").get("Emits Light").getBoolean();
		emitsParticles = config.getCategory("entity data").get("Emits Particles").getBoolean();
		getsHurtByWater = config.getCategory("entity data").get("Gets Hurt by Water").getBoolean();
		health = config.getCategory("entity data").get("Health").getDouble();
		hitBoxSizeX = config.getCategory("entity data").get("Hit Box Size X").getDouble();
		hitBoxSizeZ = config.getCategory("entity data").get("Hit Box Size Z").getDouble();
		hostile = config.getCategory("entity data").get("Hostile").getBoolean();
		id = config.getCategory("entity data").get("ID").getInt();
		immuneToFire = config.getCategory("entity data").get("Immune To Fire").getBoolean();
		lightLevelEmited = config.getCategory("entity data").get("Light Level Emited").getInt();
		particleType = EnumParticleTypes.getByName(config.getCategory("entity data").get("Particle Type").getString());
		particlesPerTick = config.getCategory("entity data").get("Particles Per Tick").getInt();
		walkSpeed = config.getCategory("entity data").get("Walk Speed").getDouble();
		
		// Laying
		layingItem = Item.REGISTRY.getObject(new ResourceLocation(config.getCategory("laying").get("Laying Item").getString()));
		layingItemAmount = config.getCategory("laying").get("Laying Item Amount").getInt();
		layingItemData = config.getCategory("laying").get("Laying Item Data").getInt();
		layingItemMaxData = config.getCategory("laying").get("Laying Item Max Data").getInt();
		layingItemMinData = config.getCategory("laying").get("Laying Item Min Data").getInt();
		layingItemUsesData = config.getCategory("laying").get("Laying Item Uses Data").getBoolean();
		layingItemUsesRandomData = config.getCategory("laying").get("Laying Item Uses Random Data").getBoolean();
		layingSound = SoundEvent.REGISTRY.getObject(new ResourceLocation(config.getCategory("laying").get("Laying Sound").getString()));
		minItemLayTime = config.getCategory("laying").get("Min Item Lay Time").getInt();
		variableItemLayTime = config.getCategory("laying").get("Variable Item Lay Time").getInt();
		
		// Spawning
		biomeListType = config.getCategory("spawning").get("Biome List Type").getString();
		biomeList = config.getCategory("spawning").get("Biome List").getStringList();
		canSpawn = config.getCategory("spawning").get("Can Spawn").getBoolean();
		maxSpawnGroupSize = config.getCategory("spawning").get("Max Spawn Group Size").getInt();
		maxSpawnTemp = config.getCategory("spawning").get("Max Spawn Temp").getDouble();
		minSpawnGroupSize = config.getCategory("spawning").get("Min Spawn Group Size").getInt();
		minSpawnTemp = config.getCategory("spawning").get("Min Spawn Temp").getDouble();
		spawnProbability = config.getCategory("spawning").get("Spawn Probability").getInt();
		minSpawnLightLevel = config.getCategory("spawning").get("Min Spawn Light Level").getInt();
		maxSpawnLightLevel = config.getCategory("spawning").get("Max Spawn Light Level").getInt();
		
		// Taming
		tamingChance = config.getCategory("taming").get("Taming Chance").getInt();
		tamingItem = Item.REGISTRY.getObject(new ResourceLocation(config.getCategory("taming").get("Taming Item").getString()));
		tamingItemData = config.getCategory("taming").get("Taming Item Data").getInt();
		tamingItemUsesData = config.getCategory("taming").get("Taming Item Uses Data").getBoolean();
		
		// Tempting
		delayFollowingBetweenItemHoldings = config.getCategory("tempting").get("Delay Following Between Item Holdings").getInt();
		temptingItem = Item.REGISTRY.getObject(new ResourceLocation(config.getCategory("tempting").get("Tempting Item").getString()));
		temptingItemData = config.getCategory("tempting").get("Tempting Item Data").getInt();
		temptingItemUsesData = config.getCategory("tempting").get("Tempting Item Uses Data").getBoolean();
		
		// Exploding Chicken Syndrome
		explodingChickenSyndrome = config.getCategory("exploding chicken syndrome").get("Exploding Chicken Syndrome").getBoolean();
		eCSNotifyOwnerWhenInfected = config.getCategory("exploding chicken syndrome").get("Notify Owner When Infected").getBoolean();
		eCSInfectedWhenTamed = config.getCategory("exploding chicken syndrome").get("Can Be Infected While Tamed").getBoolean();
		eCSInfectedWhenWild = config.getCategory("exploding chicken syndrome").get("Can Be Infected While Wild").getBoolean();
		eCSClearInfectionWhenTamed = config.getCategory("exploding chicken syndrome").get("Clear Infection When Tamed").getBoolean();
		eCSInfectionChance = config.getCategory("exploding chicken syndrome").get("Infection Chance").getInt();
		eCSBabyInfectionChance = config.getCategory("exploding chicken syndrome").get("Infection Chance When Baby").getInt();
		eCSExplosionChance = config.getCategory("exploding chicken syndrome").get("Explosion Chance").getInt();
		eCSFalseFuseChance = config.getCategory("exploding chicken syndrome").get("False Fuse Chance").getInt();
		
		// Mad Chicken Disease
		madChickenDisease = config.getCategory("mad chicken disease").get("Mad Chicken Disease").getBoolean();
		mCDNotifyOwnerWhenInfected = config.getCategory("mad chicken disease").get("Notify Owner When Infected").getBoolean();
		mCDInfectedWhenTamed = config.getCategory("mad chicken disease").get("Can Be Infected While Tamed").getBoolean();
		mCDInfectedWhenWild = config.getCategory("mad chicken disease").get("Can Be Infected While Wild").getBoolean();
		mCDClearInfectionWhenTamed = config.getCategory("mad chicken disease").get("Clear Infection When Tamed").getBoolean();
		mCDInfectionChance = config.getCategory("mad chicken disease").get("Infection Chance").getInt();
		mCDBabyInfectionChance = config.getCategory("mad chicken disease").get("Infection Chance When Baby").getInt();
	}

	@Override
	public void setSwingingArms(boolean swingingArms) {
		
	}
	
	/*@Override
	public void onDeath(DamageSource cause) {
		super.onDeath(cause);
		Entity source = cause.getImmediateSource();
		System.out.println(cause.getImmediateSource());
		if (source.toString().isEmpty()) {
			if (source.isEntityEqual(this)) {
				EntityMoChicken chicken = (EntityMoChicken) source;
				if (chicken.getMadChickenDisease()) {
					mc.ingameGUI.getChatGUI().printChatMessage(getDisplayName().appendText(" was killed by " + source.getDisplayName() + " infected with Mad Chicken Disease."));
				}
			}
		}
	}*/
}
