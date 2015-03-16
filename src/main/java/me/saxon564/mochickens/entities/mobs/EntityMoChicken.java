package me.saxon564.mochickens.entities.mobs;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.UUID;
import java.util.logging.Logger;

import cpw.mods.fml.common.registry.GameData;

import me.saxon564.mochickens.MoChickens;
import me.saxon564.mochickens.configs.chickens.*;
import me.saxon564.mochickens.entities.mobs.ai.*;
import net.minecraft.block.Block;
import net.minecraft.block.BlockColored;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentThorns;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIFleeSun;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAIRestrictSun;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.PreYggdrasilConverter;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;

public class EntityMoChicken extends EntityTameable implements IRangedAttackMob {
	private static final UUID attackingSpeedBoostModifierUUID = UUID
			.fromString("020E0DFB-87AE-4653-9556-831010E291A0");
	private static AttributeModifier attackingSpeedBoostModifier;

	private int stareTimer;
	private Entity lastEntityToAttack;
	private boolean isAggressive;
	private int teleportDelay;

	public boolean field_70885_d = false;
	public float field_70886_e = 0.0F;
	public float destPos = 0.0F;
	public float field_70884_g;
	public float field_70888_h;
	public float field_70889_i = 1.0F;
	private EnumDifficulty checked = this.worldObj.difficultySetting;
	private boolean despawn;
	private int ran;
	private Configuration config;
	private double health;
	private Class chicken;

	private int lastActiveTime;
	private int timeSinceIgnited;

	/** The time until the next egg is spawned. */
	public int timeUntilNextEgg;

	private EntityAIArrowAttack aiArrowAttack;

	public EntityMoChicken(World par1World) {
		super(par1World);
		float x = (float) config.getCategory("entity data")
				.get("Hit Box Size X").getDouble();
		float z = (float) config.getCategory("entity data")
				.get("Hit Box Size Z").getDouble();
		this.setSize(x, z);
		float f = 0.25F;
		attackingSpeedBoostModifier = (new AttributeModifier(
				attackingSpeedBoostModifierUUID, "attackingSpeedBoostModifier",
				config.getCategory("attack data").get("Attack Speed")
						.getDouble(), 0)).setSaved(false);
		if (config.getCategory("entity data").get("Burns in Sun").getBoolean()) {
			this.tasks.addTask(2, new EntityAIRestrictSun(this));
			this.tasks.addTask(3, new EntityAIFleeSun(this, 1.0D));
		}
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
		if (config.getCategory("attack data").get("Can Blow Up").getBoolean()) {
			this.tasks.addTask(2, new ChickAISwell(this));
		}
		this.isImmuneToFire = config.getCategory("entity data")
				.get("Immune To Fire").getBoolean();
		this.tasks.addTask(4, new EntityAIFollowParent(this, 1.1D));
		this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(6, new EntityAIWatchClosest(this,
				EntityPlayer.class, 6.0F));
		this.tasks.addTask(7, new EntityAILookIdle(this));
		this.timeUntilNextEgg = -1;
		if (config.getCategory("attack data").get("Can Shoot Arrows")
				.getBoolean()) {
			aiArrowAttack = new EntityAIArrowAttack(this, 1.0D, 20, config
					.getCategory("attack data").get("Arrow Shoot Speed")
					.getInt(), 15.0F);
		}
		this.setTamed(false);
	}

	/**
	 * Returns true if the newer Entity AI code should be run
	 */
	public boolean isAIEnabled() {
		return true;
	}

	public void applyEntityAttributes(Configuration c, Class cl) {
		super.applyEntityAttributes();
		addVars(c, cl);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(
						config.getCategory("entity data").get("Health").getDouble());
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(
						config.getCategory("entity data").get("Walk Speed").getDouble());
	}

	public void addVars(Configuration c, Class cl) {
		config = c;
		chicken = cl;
	}

	@Override
	public final void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readEntityFromNBT(par1NBTTagCompound);
		String s = "";

		if (par1NBTTagCompound.hasKey("OwnerUUID", 8)) {
			s = par1NBTTagCompound.getString("OwnerUUID");
		} else {
			String s1 = par1NBTTagCompound.getString("Owner");
			s = PreYggdrasilConverter.func_152719_a(s1);
		}

		if (s.length() > 0) {
			this.setTamed(true);
			this.func_152115_b(s);
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
	public void setTamed(boolean par1) {
		byte b0 = this.dataWatcher.getWatchableObjectByte(16);

		if (par1) {
			this.dataWatcher.updateObject(16, Byte.valueOf((byte) (b0 | 4)));
			this.worldObj.setEntityState(this, (byte) 7);
			this.tasks.removeTask(new EntityAIAttackOnCollide(this,
					EntityPlayer.class, 1.0D, false));
			if (config.getCategory("attack data").get("Can Shoot Arrows")
					.getBoolean()) {
				this.tasks.removeTask(this.aiArrowAttack);
			}
			this.targetTasks.taskEntries.clear();
			if (config.getCategory("tempting").get("Tempting Item Uses Data")
					.getBoolean()) {
				this.tasks.addTask(
						3,
						new ChickAITemptDye(this, 1.0D, new ItemStack(
								(Item) GameData.getItemRegistry().getObject(
										config.getCategory("tempting")
												.get("Tempting Item")
												.getString()), 1, config
										.getCategory("tempting")
										.get("Tempting Item Data").getInt())
								.getDisplayName().toLowerCase(), false, config
								.getCategory("tempting")
								.get("Delay Following Between Item Holdings")
								.getInt()));
			} else {
				this.tasks.addTask(
						3,
						new ChickAITempt(this, 1.0D, (Item) GameData
								.getItemRegistry().getObject(
										config.getCategory("tempting")
												.get("Tempting Item")
												.getString()), false, config
								.getCategory("tempting")
								.get("Delay Following Between Item Holdings")
								.getInt()));

			}
			despawn = config.getCategory("entity data").get("Despawn Tamed")
					.getBoolean();
			ran = 0;
			this.canDespawn();
			this.timeUntilNextEgg = this.rand.nextInt(config
					.getCategory("laying").get("Variable Item Lay Time")
					.getInt())
					+ config.getCategory("laying").get("Min Item Lay Time")
							.getInt();
		} else if (config.getCategory("entity data").get("Hostile")
				.getBoolean()) {
			if (config.getCategory("attack data").get("Can Shoot Arrows")
					.getBoolean()) {
				this.tasks.addTask(4, this.aiArrowAttack);
			} else {
				this.tasks.addTask(2, new EntityAIAttackOnCollide(this,
						EntityPlayer.class, 1.0D, false));
			}
			this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(
					this, EntityPlayer.class, 0, true));
			this.dataWatcher.updateObject(16, Byte.valueOf((byte) (b0 & -5)));
			despawn = config.getCategory("entity data").get("Despawn Untamed")
					.getBoolean();
			ran = 0;
			this.canDespawn();
		} else {
			despawn = config.getCategory("entity data").get("Despawn Untamed")
					.getBoolean();
			ran = 0;
			this.canDespawn();
		}

		if (this.worldObj.difficultySetting.toString().equalsIgnoreCase(
				"peaceful")) {
			this.difficultyChange();
		}
	}
	
	/**
     * Checks to make sure the light is not too bright where the mob is spawning
     */
    protected boolean isValidLightLevel()
    {
        int i = MathHelper.floor_double(this.posX);
        int j = MathHelper.floor_double(this.boundingBox.minY);
        int k = MathHelper.floor_double(this.posZ);

        if (this.worldObj.getSavedLightValue(EnumSkyBlock.Sky, i, j, k) > this.rand
                .nextInt(32))
        {
            return false;
        }
        else
        {
            int l = this.worldObj.getBlockLightValue(i, j, k);

            if (this.worldObj.isThundering())
            {
                int i1 = this.worldObj.skylightSubtracted;
                this.worldObj.skylightSubtracted = 10;
                l = this.worldObj.getBlockLightValue(i, j, k);
                this.worldObj.skylightSubtracted = i1;
            }

            return l <= this.rand.nextInt(8);
        }
    }
	
	@Override
    public boolean getCanSpawnHere()
    {
		super.getCanSpawnHere();
		if (!this.worldObj.getBlock((int) this.posX, (int) this.posY, (int) this.posZ).isOpaqueCube() && (this.worldObj.getLightBrightness((int) this.posX, (int) this.posY, (int) this.posZ) >= 7)) {
			//System.out.println("Chicken:" + this.chicken.toString() + " X:" + this.posX + " Y:" + this.posY + " Z:" + this.posZ);
			return true;
		} else {
			return false;
		}
    }

	public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
		if (this.isEntityInvulnerable()) {
			return false;
		} else if (config.getCategory("entity data").get("Allow Teleporting")
				.getBoolean()) {
			this.setScreaming(true);

			if (par1DamageSource instanceof EntityDamageSource
					&& par1DamageSource.getEntity() instanceof EntityPlayer) {
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
				&& (config.getCategory("entity data").get("Hostile")
						.getBoolean())
				&& (!config.getCategory("attack data").get("Can Blow Up")
						.getBoolean())) {
			EntityPlayer entityplayer = this.worldObj
					.getClosestVulnerablePlayerToEntity(
							this,
							config.getCategory("attack data")
									.get("Attack Tracking Range").getDouble());
			float f = (float) config.getCategory("attack data")
					.get("Attack Damage").getDouble();
			int i = 0;

			if (entityplayer instanceof EntityLivingBase) {
				f += EnchantmentHelper.getEnchantmentModifierLiving(this,
						(EntityLivingBase) entityplayer);
				i += EnchantmentHelper.getKnockbackModifier(this,
						(EntityLivingBase) entityplayer);
				addEffects(entityplayer);
				if (config.getCategory("attack data").get("Set Target On Fire")
						.getBoolean()) {
					entityplayer.setFire(config.getCategory("attack data")
							.get("Fire Duration").getInt());
				}
			}

			boolean flag = par1Entity.attackEntityFrom(
					DamageSource.causeMobDamage(this), f);

			if (flag) {
				if (i > 0) {
					entityplayer.addVelocity(
							(double) (-MathHelper.sin(this.rotationYaw
									* (float) Math.PI / 180.0F)
									* (float) i * 0.5F),
							0.1D,
							(double) (MathHelper.cos(this.rotationYaw
									* (float) Math.PI / 180.0F)
									* (float) i * 0.5F));
					this.motionX *= 0.6D;
					this.motionZ *= 0.6D;
				}

				int j = EnchantmentHelper.getFireAspectModifier(this);

				if (j > 0) {
					entityplayer.setFire(j * 4);
				}

				if (entityplayer instanceof EntityLivingBase) {
					EnchantmentThorns.func_92094_a(i, this.rand);
				}
			}

			return flag;
		} else {
			return false;
		}
	}

	private void addEffects(EntityPlayer entityplayer) {
		int[] pots = new int[50];
		pots = config.getCategory("attack data").get("Effect IDs").getIntList();
		int[] amps = new int[50];
		amps = config.getCategory("attack data").get("Effect Amplifiers")
				.getIntList();
		int[] durs = new int[50];
		durs = config.getCategory("attack data").get("Effect Durations")
				.getIntList();

		for (int p = 0; p < pots.length; p++) {
			int k = pots[p];
			int j = amps[p];
			int h = durs[p];
			if (checkpot(k, j, h) != null) {
				entityplayer.addPotionEffect(new PotionEffect(k, h, j));
			}
		}
	}

	private String checkpot(int k, int j, int h) {
		String test = new PotionEffect(k, h, j).getEffectName();
		int test2 = new PotionEffect(k, h, j).getDuration();
		int test3 = new PotionEffect(k, h, j).getAmplifier();
		return test;
	}

	private void addLight() {
		this.worldObj.setLightValue(EnumSkyBlock.Block, (int) this.posX,
				(int) this.posY, (int) this.posZ,
				config.getCategory("entity data").get("Light Level Emited")
						.getInt());
		this.worldObj.markBlockRangeForRenderUpdate((int) this.posX,
				(int) this.posY, (int) this.posX, 12, 12, 12);
		this.worldObj.markBlockForUpdate((int) this.posX, (int) this.posY,
				(int) this.posZ);
		this.worldObj.updateLightByType(EnumSkyBlock.Block, (int) this.posX,
				(int) this.posY + 1, (int) this.posZ);
		this.worldObj.updateLightByType(EnumSkyBlock.Block, (int) this.posX,
				(int) this.posY - 1, (int) this.posZ);
		this.worldObj.updateLightByType(EnumSkyBlock.Block,
				(int) this.posX + 1, (int) this.posY, (int) this.posZ);
		this.worldObj.updateLightByType(EnumSkyBlock.Block,
				(int) this.posX - 1, (int) this.posY, (int) this.posZ);
		this.worldObj.updateLightByType(EnumSkyBlock.Block, (int) this.posX,
				(int) this.posY, (int) this.posZ + 1);
		this.worldObj.updateLightByType(EnumSkyBlock.Block, (int) this.posX,
				(int) this.posY, (int) this.posZ - 1);
	}

	/**
	 * Called frequently so the entity can update its state every tick as
	 * required. For example, zombies and skeletons use this to react to
	 * sunlight and start to burn.
	 */
	//private int loc = 0;
	public void onLivingUpdate() {
		super.onLivingUpdate();
		//if (loc == 0) {
		//	System.out.println(this.chicken + " X:" + this.posX + " Y:" + this.posY + " Z:" + this.posZ);
		//	loc ++;
		//}
		if (this.worldObj.isDaytime()
				&& !this.worldObj.isRemote
				&& config.getCategory("entity data").get("Burns in Sun")
						.getBoolean()) {
			float f = this.getBrightness(1.0F);

			if (f > 0.5F
					&& this.rand.nextFloat() * 30.0F < (f - 0.4F) * 2.0F
					&& this.worldObj.canBlockSeeTheSky(
							MathHelper.floor_double(this.posX),
							MathHelper.floor_double(this.posY),
							MathHelper.floor_double(this.posZ))) {
				boolean flag = true;

				if (flag) {
					this.setFire(8);
				}
			}
		}

		if (this.lastEntityToAttack != this.entityToAttack) {
			IAttributeInstance attributeinstance = this
					.getEntityAttribute(SharedMonsterAttributes.movementSpeed);
			attributeinstance.removeModifier(attackingSpeedBoostModifier);

			if (this.entityToAttack != null) {
				attributeinstance.applyModifier(attackingSpeedBoostModifier);
			}
		}

		this.lastEntityToAttack = this.entityToAttack;

		if (config.getCategory("entity data").get("Allow Teleporting")
				.getBoolean()) {
			if (this.worldObj.isDaytime() && !this.worldObj.isRemote) {
				float f = this.getBrightness(1.0F);

				if (f > 0.5F
						&& this.worldObj.canBlockSeeTheSky(
								MathHelper.floor_double(this.posX),
								MathHelper.floor_double(this.posY),
								MathHelper.floor_double(this.posZ))
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

			if (!this.worldObj.isRemote && this.isEntityAlive()) {
				if (this.entityToAttack != null) {
					if (this.entityToAttack instanceof EntityPlayer) {
						if (this.entityToAttack.getDistanceSqToEntity(this) < 16.0D) {
							this.teleportRandomly();
						}

						this.teleportDelay = 0;
					} else if (this.entityToAttack.getDistanceSqToEntity(this) > 256.0D
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

		if ((!this.isTamed())
				&& (config.getCategory("attack data").get("Can Blow Up")
						.getBoolean())
				&& (config.getCategory("entity data").get("Hostile")
						.getBoolean())) {
			if (this.isEntityAlive()) {
				this.lastActiveTime = this.timeSinceIgnited;
				int i = this.getCreeperState();

				if (i > 0 && this.timeSinceIgnited == 0) {
					this.playSound("creeper.primed", 1.0F, 0.5F);
				}

				this.timeSinceIgnited += i;

				if (this.timeSinceIgnited < 0) {
					this.timeSinceIgnited = 0;
				}

				if (this.timeSinceIgnited >= config.getCategory("attack data")
						.get("Fuse Time").getInt()) {
					this.timeSinceIgnited = config.getCategory("attack data")
							.get("Fuse Time").getInt();

					if (!this.worldObj.isRemote) {
						EntityPlayer entityplayer = this.worldObj
								.getClosestVulnerablePlayerToEntity(this, 5.0D);
						boolean flag = this.worldObj.getGameRules()
								.getGameRuleBooleanValue("mobGriefing");
						this.worldObj
								.createExplosion(
										this,
										this.posX,
										this.posY,
										this.posZ,
										(float) config
												.getCategory("attack data")
												.get("Explosion Radius")
												.getInt(), flag);
						if (entityplayer != null) {
							addEffects(entityplayer);
						}
						this.setDead();
					}
				}
			}
		}

		this.field_70888_h = this.field_70886_e;
		this.field_70884_g = this.destPos;
		this.destPos = (float) ((double) this.destPos + (double) (this.onGround ? -1
				: 4) * 0.3D);

		if (this.destPos < 0.0F) {
			this.destPos = 0.0F;
		}

		if (this.destPos > 1.0F) {
			this.destPos = 1.0F;
		}

		if (!this.onGround && this.field_70889_i < 1.0F) {
			this.field_70889_i = 1.0F;
		}

		if (config.getCategory("entity data").get("Emits Particles")
				.getBoolean()) {
			for (int i = 0; i < config.getCategory("entity data")
					.get("Particles Per Tick").getInt(); ++i) {
				this.worldObj.spawnParticle(config.getCategory("entity data")
						.get("Particle Type").getString(),
						this.posX + (this.rand.nextDouble() - 0.5D)
								* (double) this.width,
						this.posY + this.rand.nextDouble()
								* (double) this.height,
						this.posZ + (this.rand.nextDouble() - 0.5D)
								* (double) this.width, 0.0D, 0.0D, 0.0D);
			}
		}

		if (config.getCategory("entity data").get("Emits Light").getBoolean()) {
			addLight();
		}

		if ((this.isWet())
				&& (config.getCategory("entity data").get("Gets Hurt by Water")
						.getBoolean())) {
			this.attackEntityFrom(DamageSource.drown, (float) config
					.getCategory("entity data").get("Damage From Water")
					.getDouble());
		}

		this.field_70889_i = (float) ((double) this.field_70889_i * 0.9D);

		if (!this.onGround && this.motionY < 0.0D) {
			this.motionY *= 0.6D;
		}

		this.field_70886_e += this.field_70889_i * 2.0F;

		if (this.worldObj.difficultySetting != checked) {
			this.difficultyChange();
			checked = this.worldObj.difficultySetting;
		}

		if (!this.isChild() && !this.worldObj.isRemote
				&& --this.timeUntilNextEgg == 0) {
			this.playSound(
					config.getCategory("laying").get("Laying Sound")
							.getString().toLowerCase(),
					1.0F,
					(this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
			if (GameData.getItemRegistry()
					.getObject(
							config.getCategory("laying").get("Laying Item")
									.getString()) != null) {
				if (config.getCategory("laying").get("Laying Item Uses Data")
						.getBoolean()) {
					if (config.getCategory("laying")
							.get("Laying Item Uses Random Data").getBoolean()) {
						this.entityDropItem(
								new ItemStack(
										(Item) GameData
												.getItemRegistry()
												.getObject(
														config.getCategory(
																"laying")
																.get("Laying Item")
																.getString()),
										1,
										this.randomInt(
												config.getCategory("laying")
														.get("Laying Item Min Data")
														.getInt(),
												config.getCategory("laying")
														.get("Laying Item Max Data")
														.getInt())),
								config.getCategory("laying")
										.get("Laying Item Amount").getInt());
					} else {
						this.entityDropItem(
								new ItemStack((Item) GameData.getItemRegistry()
										.getObject(
												config.getCategory("laying")
														.get("Laying Item")
														.getString()), 1,
										config.getCategory("laying")
												.get("Laying Item Data")
												.getInt()),
								config.getCategory("laying")
										.get("Laying Item Amount").getInt());
					}
				} else {
					this.dropItem(
							(Item) GameData.getItemRegistry().getObject(
									config.getCategory("laying")
											.get("Laying Item").getString()),
							config.getCategory("laying")
									.get("Laying Item Amount").getInt());
				}
			} else {
				this.dropItem((Item) Item.itemRegistry.getObject("egg"), config
						.getCategory("laying").get("Laying Item Amount")
						.getInt());
			}
			this.timeUntilNextEgg = this.rand.nextInt(config
					.getCategory("laying").get("Variable Item Lay Time")
					.getInt())
					+ config.getCategory("laying").get("Min Item Lay Time")
							.getInt();
		}

		if (this.isDead) {
			this.worldObj.updateLightByType(EnumSkyBlock.Block,
					(int) this.posX, (int) this.posY, (int) this.posZ);
		}
	}

	public static int randomInt(int low, int high) {
		int result = (int) (Math.random() * (high - low + 1)) + low;
		return result;
	}

	public float getCreeperFlashIntensity(float par1) {
		return ((float) this.lastActiveTime + (float) (this.timeSinceIgnited - this.lastActiveTime)
				* par1)
				/ (float) (config.getCategory("attack data").get("Fuse Time")
						.getInt() - 2);
	}

	public int getCreeperState() {
		return this.dataWatcher.getWatchableObjectByte(16);
	}

	public void setCreeperState(int par1) {
		this.dataWatcher.updateObject(16, Byte.valueOf((byte) par1));
	}

	private void difficultyChange() {
		if (this.worldObj.difficultySetting.toString().equalsIgnoreCase(
				"peaceful")) {
			this.setPathToEntity((PathEntity) null);
			this.setAttackTarget((EntityLivingBase) null);
			this.setTarget(null);
			this.tasks.removeTask(new EntityAIAttackOnCollide(this,
					EntityPlayer.class, 1.0D, false));
			this.targetTasks.taskEntries.clear();
		} else {
			if (this.getOwner() != null) {
				EntityLivingBase s = this.getOwner();

				if (s.getUniqueID().toString().length() > 0) {
					this.setTamed(true);
					this.func_152115_b(s.toString());
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
		return (Item) Item.itemRegistry.getObject("feather");
	}

	/**
	 * Drop 0-2 items of this living's type. @param par1 - Whether this entity
	 * has recently been hit by a player. @param par2 - Level of Looting used to
	 * kill this mob.
	 */
	protected void dropFewItems(boolean par1, int par2) {
		int j = this.rand.nextInt(3) + this.rand.nextInt(1 + par2);

		for (int k = 0; k < j; ++k) {
			this.dropItem((Item) Item.itemRegistry.getObject("feather"), 1);
		}

		if (this.isBurning()) {
			this.dropItem((Item) Item.itemRegistry.getObject("cooked_chicken"),
					1);
		} else {
			this.dropItem((Item) Item.itemRegistry.getObject("chicken"), 1);
		}
	}

	/**
	 * Called when a player interacts with a mob. e.g. gets milk from a cow,
	 * gets into the saddle on a pig.
	 */
	public boolean interact(EntityPlayer par1EntityPlayer) {
		ItemStack itemstack = par1EntityPlayer.inventory.getCurrentItem();

		if (!this.isTamed()) {
			if (config.getCategory("taming").get("Taming Item Uses Data").getBoolean()) {
				if (itemstack != null && ((itemstack.getDisplayName().toLowerCase().equalsIgnoreCase(new ItemStack((Item) GameData.getItemRegistry().getObject(config.getCategory("taming").get("Taming Item").getString()), 1, config.getCategory("taming").get("Taming Item Data").getInt()).getDisplayName().toLowerCase())))) {
					if (!par1EntityPlayer.capabilities.isCreativeMode) {
						--itemstack.stackSize;
					}

					if (itemstack.stackSize <= 0) {
						par1EntityPlayer.inventory.setInventorySlotContents(
								par1EntityPlayer.inventory.currentItem,
								(ItemStack) null);
					}

					if (!this.worldObj.isRemote) {
						if (this.rand.nextInt(config.getCategory("taming")
								.get("Taming Chance").getInt()) == 0) {
							this.setTamed(true);
							this.setPathToEntity((PathEntity) null);
							this.setAttackTarget((EntityLivingBase) null);
							this.setTarget(null);
							this.func_152115_b(par1EntityPlayer.getUniqueID()
									.toString());
							this.playTameEffect(true);
						} else {
							this.playTameEffect(false);
							this.worldObj.setEntityState(this, (byte) 6);
						}
					}

					return true;
				}
			} else if (itemstack != null && ((itemstack.getItem().equals((Item) GameData.getItemRegistry().getObject(config.getCategory("taming").get("Taming Item").getString()))))) {
				if (!par1EntityPlayer.capabilities.isCreativeMode) {
					--itemstack.stackSize;
				}

				if (itemstack.stackSize <= 0) {
					par1EntityPlayer.inventory.setInventorySlotContents(
							par1EntityPlayer.inventory.currentItem,
							(ItemStack) null);
				}

				if (!this.worldObj.isRemote) {
					if (this.rand.nextInt(config.getCategory("taming")
							.get("Taming Chance").getInt()) == 0) {
						this.setTamed(true);
						this.setPathToEntity((PathEntity) null);
						this.setAttackTarget((EntityLivingBase) null);
						this.setTarget(null);
						this.func_152115_b(par1EntityPlayer.getUniqueID()
								.toString());
						this.playTameEffect(true);
					} else {
						this.playTameEffect(false);
						this.worldObj.setEntityState(this, (byte) 6);
					}
				}

			}
		}

		return super.interact(par1EntityPlayer);
	}

	/**
	 * This function is used when two same-species animals in 'love mode' breed
	 * to generate the new baby animal.
	 */
	public EntityMoChicken spawnBabyAnimal(EntityAgeable par1EntityAgeable) {
		try {
			EntityMoChicken newEntity = (EntityMoChicken) chicken
					.getDeclaredConstructor(World.class).newInstance(
							par1EntityAgeable.worldObj);

			EntityLivingBase s = this.getOwner();

			if (s != null && s.getUniqueID().toString().length() > 0) {
				((EntityMoChicken) newEntity).func_152115_b(s.getUniqueID()
						.toString());
				((EntityMoChicken) newEntity).addVars(config, chicken);
				((EntityMoChicken) newEntity).setTamed(true);
			}

			return (EntityMoChicken) newEntity;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Checks if the parameter is an item which this animal can be fed to breed
	 * it (wheat, carrots or seeds depending on the animal type)
	 */
	public boolean isBreedingItem(ItemStack par1ItemStack) {
		if (config.getCategory("entity data").get("Allow Breeding").getBoolean()) {
			if (this.isTamed()) {
				if (config.getCategory("breeding").get("Breeding Item Uses Data").getBoolean()) {
					return par1ItemStack != null && par1ItemStack.getDisplayName().toLowerCase().equalsIgnoreCase(new ItemStack((Item) GameData.getItemRegistry().getObject(config.getCategory("breeding").get("Breeding Item").getString()), 1, config.getCategory("breeding").get("Breeding Item Data").getInt()).getDisplayName().toLowerCase());
				} else {
					return par1ItemStack != null && par1ItemStack.getItem().equals((Item) GameData.getItemRegistry().getObject(config.getCategory("breeding").get("Breeding Item").getString()));
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

	public boolean isScreaming() {
		return this.dataWatcher.getWatchableObjectByte(18) > 0;
	}

	public void setScreaming(boolean par1) {
		this.dataWatcher.updateObject(18, Byte.valueOf((byte) (par1 ? 1 : 0)));
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
		Vec3 vec3 = Vec3.createVectorHelper(this.posX - par1Entity.posX,
				this.boundingBox.minY + (double) (this.height / 1.5F)
						- par1Entity.posY + (double) par1Entity.getEyeHeight(),
				this.posZ - par1Entity.posZ);
		vec3 = vec3.normalize();
		double d0 = 16.0D;
		double d1 = this.posX + (this.rand.nextDouble() - 0.5D) * 8.0D
				- vec3.xCoord * d0;
		double d2 = this.posY + (double) (this.rand.nextInt(16) - 8)
				- vec3.yCoord * d0;
		double d3 = this.posZ + (this.rand.nextDouble() - 0.5D) * 8.0D
				- vec3.zCoord * d0;
		return this.teleportTo(d1, d2, d3);
	}

	protected boolean teleportTo(double par1, double par3, double par5) {
		EnderTeleportEvent event = new EnderTeleportEvent(this, par1, par3,
				par5, 0);
		if (MinecraftForge.EVENT_BUS.post(event)) {
			return false;
		}
		double d3 = this.posX;
		double d4 = this.posY;
		double d5 = this.posZ;
		this.posX = event.targetX;
		this.posY = event.targetY;
		this.posZ = event.targetZ;
		boolean flag = false;
		int i = MathHelper.floor_double(this.posX);
		int j = MathHelper.floor_double(this.posY);
		int k = MathHelper.floor_double(this.posZ);

		if (this.worldObj.blockExists(i, j, k)) {
			boolean flag1 = false;

			while (!flag1 && j > 0) {
				Block block = this.worldObj.getBlock(i, j - 1, k);

				if (block.getMaterial().blocksMovement()) {
					flag1 = true;
				} else {
					--this.posY;
					--j;
				}
			}

			if (flag1) {
				this.setPosition(this.posX, this.posY, this.posZ);

				if (this.worldObj.getCollidingBoundingBoxes(this,
						this.boundingBox).isEmpty()
						&& !this.worldObj.isAnyLiquid(this.boundingBox)) {
					flag = true;
				}
			}
		}

		if (!flag) {
			this.setPosition(d3, d4, d5);
			return false;
		} else {
			short short1 = 128;

			for (int l = 0; l < short1; ++l) {
				double d6 = (double) l / ((double) short1 - 1.0D);
				float f = (this.rand.nextFloat() - 0.5F) * 0.2F;
				float f1 = (this.rand.nextFloat() - 0.5F) * 0.2F;
				float f2 = (this.rand.nextFloat() - 0.5F) * 0.2F;
				double d7 = d3 + (this.posX - d3) * d6
						+ (this.rand.nextDouble() - 0.5D) * (double) this.width
						* 2.0D;
				double d8 = d4 + (this.posY - d4) * d6 + this.rand.nextDouble()
						* (double) this.height;
				double d9 = d5 + (this.posZ - d5) * d6
						+ (this.rand.nextDouble() - 0.5D) * (double) this.width
						* 2.0D;
				this.worldObj.spawnParticle("portal", d7, d8, d9, (double) f,
						(double) f1, (double) f2);
			}

			this.worldObj.playSoundEffect(d3, d4, d5, "mob.endermen.portal",
					1.0F, 1.0F);
			this.playSound("mob.endermen.portal", 1.0F, 1.0F);
			return true;
		}
	}

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase entitylivingbase,
			float f) {
		EntityArrow entityarrow = new EntityArrow(
				this.worldObj,
				this,
				entitylivingbase,
				1.6F,
				(float) (14 - this.worldObj.difficultySetting.getDifficultyId() * 4));
		entityarrow.setDamage((double) (f * 2.0F)
				+ this.rand.nextGaussian()
				* 0.25D
				+ (double) ((float) this.worldObj.difficultySetting
						.getDifficultyId() * 0.11F));
		this.playSound("random.bow", 1.0F,
				1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
		this.worldObj.spawnEntityInWorld(entityarrow);
	}
}
