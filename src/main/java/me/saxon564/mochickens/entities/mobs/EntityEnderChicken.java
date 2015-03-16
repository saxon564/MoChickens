package me.saxon564.mochickens.entities.mobs;

import java.util.UUID;
import java.util.logging.Logger;

import me.saxon564.mochickens.MoChickens;
import me.saxon564.mochickens.configs.chickens.EnderChickenConfig;
import me.saxon564.mochickens.entities.mobs.ai.ChickAITempt;
import net.minecraft.block.Block;
import net.minecraft.block.BlockColored;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentThorns;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIPanic;
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
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;

public class EntityEnderChicken extends EntityMoChicken {
	/*private static final UUID attackingSpeedBoostModifierUUID = UUID
			.fromString("020E0DFB-87AE-4653-9556-831010E291A0");
	private static final AttributeModifier attackingSpeedBoostModifier = (new AttributeModifier(
			attackingSpeedBoostModifierUUID, "Attacking speed boost",
			1.2599999809265137D, 0)).setSaved(false);

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
	private int ran;*/

	/** The time until the next egg is spawned. */
	//public int timeUntilNextEgg;

	public EntityEnderChicken(World par1World) {
		super(par1World);
		/*this.setSize(0.3F, 0.7F);
		float f = 0.25F;
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
		this.tasks.addTask(4, new EntityAIFollowParent(this, 1.1D));
		this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(6, new EntityAIWatchClosest(this,
				EntityPlayer.class, 6.0F));
		this.tasks.addTask(7, new EntityAILookIdle(this));
		this.timeUntilNextEgg = -1;
		this.setTamed(false);*/
	}

	protected void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(18, new Byte((byte) 0));
	}

	/**
	 * Returns true if the newer Entity AI code should be run
	 */
	/*public boolean isAIEnabled() {
		return true;
	}*/

	public void applyEntityAttributes() {
		super.applyEntityAttributes(EnderChickenConfig.config, this.getClass());
		/*this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
				.setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
				.setBaseValue(0.25D);*/
	}

	/*@Override
	public final void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readEntityFromNBT(par1NBTTagCompound);
		String s = "";

        if (par1NBTTagCompound.hasKey("OwnerUUID", 8))
        {
            s = par1NBTTagCompound.getString("OwnerUUID");
        }
        else
        {
            String s1 = par1NBTTagCompound.getString("Owner");
            s = PreYggdrasilConverter.func_152719_a(s1);
        }
        
        if (s.length() > 0)
        {
            this.setTamed(true);
            this.func_152115_b(s);
        }
	}*/

	@Override
	public boolean getCanSpawnHere() {
		if (!this.worldObj.getBiomeGenForCoords((int) this.posX, (int) this.posZ).biomeName.equalsIgnoreCase("chicken plains") && !this.worldObj.getBiomeGenForCoords((int) this.posX, (int) this.posZ).biomeName.equalsIgnoreCase("chicken forest") && !this.worldObj.getBiomeGenForCoords((int) this.posX, (int) this.posZ).biomeName.equalsIgnoreCase("hell") && (this.worldObj.getLightBrightness((int)this.posX, (int)this.posY, (int)this.posZ) <= 7)) {
	    	return true;
	    	} else {
	    		return false;
	    	}
	}

	/*protected boolean canDespawn() {
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
			this.targetTasks.taskEntries.clear();
			this.tasks.addTask(3, new ChickAITempt(this, 1.0D,
					(Item) Item.itemRegistry.getObject("ender_eye"), false));
			if (MoChickens.enderTamedDespawn == false) {
				despawn = false;
				ran = 0;
				this.canDespawn();
			} else {
				despawn = true;
				ran = 0;
				this.canDespawn();
			}
			this.timeUntilNextEgg = this.rand.nextInt(2000) + 6000;
		} else {
			this.tasks.addTask(2, new EntityAIAttackOnCollide(this,
					EntityPlayer.class, 1.0D, false));
			this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(
					this, EntityPlayer.class, 0, true));
			this.dataWatcher.updateObject(16, Byte.valueOf((byte) (b0 & -5)));
			if (MoChickens.enderUntamedDespawn == false) {
				despawn = false;
				ran = 0;
				this.canDespawn();
			} else {
				despawn = true;
				ran = 0;
				this.canDespawn();
			}

		}

		if (this.worldObj.difficultySetting.toString() == "PEACEFUL") {
			this.difficultyChange();
		}
	}

	public boolean attackEntityAsMob(Entity par1Entity) {
		if (!this.isTamed()) {
			EntityPlayer entityplayer = this.worldObj
					.getClosestVulnerablePlayerToEntity(this, 16.0D);
			// f = damage delt 2.0D = 1 heart
			float f = (float) 6.0D;
			int i = 0;

			if (entityplayer instanceof EntityLivingBase) {
				f += EnchantmentHelper.getEnchantmentModifierLiving(this,
						(EntityLivingBase) entityplayer);
				i += EnchantmentHelper.getKnockbackModifier(this,
						(EntityLivingBase) entityplayer);
				entityplayer.addPotionEffect(new PotionEffect(
						Potion.weakness.id, 200, 3));
				entityplayer.addPotionEffect(new PotionEffect(
						Potion.blindness.id, 200, 5));
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

	public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
		if (this.isEntityInvulnerable()) {
			return false;
		} else {
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
		}
	}*/

	/**
	 * Called frequently so the entity can update its state every tick as
	 * required. For example, zombies and skeletons use this to react to
	 * sunlight and start to burn.
	 */
	// private int loc = 0;
	/*public void onLivingUpdate() {
		super.onLivingUpdate();
		// if (loc == 0) {
		// MinecraftServer.getServer().getLogAgent().logInfo("Ender X:" +
		// this.posX + " Y:" + this.posY + " Z:" + this.posZ);
		// loc ++;
		// }
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

		this.field_70889_i = (float) ((double) this.field_70889_i * 0.9D);

		if (!this.onGround && this.motionY < 0.0D) {
			this.motionY *= 0.6D;
		}

		this.field_70886_e += this.field_70889_i * 2.0F;

		if (this.worldObj.difficultySetting != checked) {
			this.difficultyChange();
			checked = this.worldObj.difficultySetting;
		}

		if (this.isWet()) {
			this.attackEntityFrom(DamageSource.drown, 1.0F);
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
		int i;

		if (!this.worldObj.isRemote
				&& this.worldObj.getGameRules().getGameRuleBooleanValue(
						"mobGriefing")) {
			int j;
			int k;
			Block l;

			if (this.rand.nextInt(2000) == 0) {
				i = MathHelper.floor_double(this.posX - 1.0D
						+ this.rand.nextDouble() * 2.0D);
				j = MathHelper.floor_double(this.posY + this.rand.nextDouble()
						* 2.0D);
				k = MathHelper.floor_double(this.posZ - 1.0D
						+ this.rand.nextDouble() * 2.0D);
				l = this.worldObj.getBlock(i, j, k);
				Block i1 = this.worldObj.getBlock(i, j - 1, k);
			}
		}

		for (i = 0; i < 2; ++i) {
			this.worldObj.spawnParticle("portal",
					this.posX + (this.rand.nextDouble() - 0.5D)
							* (double) this.width,
					this.posY + this.rand.nextDouble() * (double) this.height
							- 0.25D, this.posZ
							+ (this.rand.nextDouble() - 0.5D)
							* (double) this.width,
					(this.rand.nextDouble() - 0.5D) * 2.0D,
					-this.rand.nextDouble(),
					(this.rand.nextDouble() - 0.5D) * 2.0D);
		}

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

		super.onLivingUpdate();

		if (!this.isChild() && !this.worldObj.isRemote
				&& --this.timeUntilNextEgg == 0) {
			this.playSound(
					"mob.chicken.plop",
					1.0F,
					(this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
			this.dropItem((Item) Item.itemRegistry.getObject("ender_pearl"), 1);
			this.timeUntilNextEgg = this.rand.nextInt(6000) + 6000;
		}
	}

	private void difficultyChange() {
		if (this.worldObj.difficultySetting.toString() == "PEACEFUL") {
			this.setPathToEntity((PathEntity) null);
			this.setAttackTarget((EntityLivingBase) null);
			this.setTarget(null);
			this.tasks.removeTask(new EntityAIAttackOnCollide(this,
					EntityPlayer.class, 1.0D, false));
			this.targetTasks.taskEntries.clear();
		}
		else
		{
        	if (this.getOwner() != null) {
            EntityLivingBase s = this.getOwner();
            
            if (s.getUniqueID().toString().length() > 0)
            {
                this.setTamed(true);
                this.func_152115_b(s.toString());
            }
        	}
            else
            {
                this.setTamed(false);
            }
        }
	}*/

	/**
	 * Called when the mob is falling. Calculates and applies fall damage.
	 */
	protected void fall(float par1) {
	}

	/**
	 * Returns the sound this mob makes while it's alive.
	 */
	protected String getLivingSound() {
		return "mob.chicken.say";
	}

	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	protected String getHurtSound() {
		return "mob.chicken.hurt";
	}

	/**
	 * Returns the sound this mob makes on death.
	 */
	protected String getDeathSound() {
		return "mob.chicken.hurt";
	}

	/**
	 * Plays step sound at given x, y, z for the entity
	 */
	protected void playStepSound(int par1, int par2, int par3, int par4) {
		this.playSound("mob.chicken.step", 0.15F, 1.0F);
	}

	/**
	 * Returns the item the mob drops on death.
	 */
	/*protected Item getDropItemId() {
		return (Item) Item.itemRegistry.getObject("feather");
	}*/

	/**
	 * Drop 0-2 items of this living's type. @param par1 - Whether this entity
	 * has recently been hit by a player. @param par2 - Level of Looting used to
	 * kill this mob.
	 */
	/*protected void dropFewItems(boolean par1, int par2) {
		int j = this.rand.nextInt(3) + this.rand.nextInt(1 + par2);

		for (int k = 0; k < j; ++k) {
			if (this.isTamed()) {
				this.dropItem((Item) Item.itemRegistry.getObject("ender_pearl"), 1);
			} else {
				this.dropItem((Item) Item.itemRegistry.getObject("egg"), 1);
			}
		}

		if (this.isBurning()) {
			this.dropItem((Item) Item.itemRegistry.getObject("cooked_chicken"), 1);
		} else {
			this.dropItem((Item) Item.itemRegistry.getObject("chicken"), 1);
		}
	}*/

	/**
	 * Called when a player interacts with a mob. e.g. gets milk from a cow,
	 * gets into the saddle on a pig.
	 */
	/*public boolean interact(EntityPlayer par1EntityPlayer) {
		ItemStack itemstack = par1EntityPlayer.inventory.getCurrentItem();

		if (!this.isTamed()) {
			if (itemstack != null && itemstack.getItem() == (Item) Item.itemRegistry.getObject("ender_eye")) {
				if (!par1EntityPlayer.capabilities.isCreativeMode) {
					--itemstack.stackSize;
				}

				if (itemstack.stackSize <= 0) {
					par1EntityPlayer.inventory.setInventorySlotContents(
							par1EntityPlayer.inventory.currentItem,
							(ItemStack) null);
				}

				if (!this.worldObj.isRemote) {
					if (this.rand.nextInt(3) == 0) {
						this.setTamed(true);
						this.setPathToEntity((PathEntity) null);
						this.setAttackTarget((EntityLivingBase) null);
						this.setTarget(null);
						this.func_152115_b(par1EntityPlayer.getUniqueID().toString());
						this.playTameEffect(true);
					} else {
						this.playTameEffect(false);
						this.worldObj.setEntityState(this, (byte) 6);
					}
				}

				return true;
			}
		}

		return super.interact(par1EntityPlayer);
	}*/

	/**
	 * This function is used when two same-species animals in 'love mode' breed
	 * to generate the new baby animal.
	 */
	/*public EntityEnderChicken spawnBabyAnimal(EntityAgeable par1EntityAgeable) {
		EntityEnderChicken entitybluechicken = new EntityEnderChicken(
				this.worldObj);
		EntityLivingBase s = this.getOwner();

		if (s != null && s.getUniqueID().toString().length() > 0)
        {
            entitybluechicken.func_152115_b(s.getUniqueID().toString());
            entitybluechicken.setTamed(true);
        }

		return entitybluechicken;
	}*/

	/**
	 * Checks if the parameter is an item which this animal can be fed to breed
	 * it (wheat, carrots or seeds depending on the animal type)
	 */
	/*public boolean isBreedingItem(ItemStack par1ItemStack) {
		if (this.isTamed()) {
			return par1ItemStack != null
					&& par1ItemStack.getItem() == (Item) Item.itemRegistry.getObject("ender_eye");
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
		Vec3 vec3 = Vec3.createVectorHelper(this.posX - par1Entity.posX, this.boundingBox.minY + (double)(this.height / 1.5F) - par1Entity.posY + (double)par1Entity.getEyeHeight(), this.posZ - par1Entity.posZ);
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

	protected boolean teleportTo(double par1, double par3, double par5)
    {
        EnderTeleportEvent event = new EnderTeleportEvent(this, par1, par3, par5, 0);
        if (MinecraftForge.EVENT_BUS.post(event)){
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

        if (this.worldObj.blockExists(i, j, k))
        {
            boolean flag1 = false;

            while (!flag1 && j > 0)
            {
                Block block = this.worldObj.getBlock(i, j - 1, k);

                if (block.getMaterial().blocksMovement())
                {
                    flag1 = true;
                }
                else
                {
                    --this.posY;
                    --j;
                }
            }

            if (flag1)
            {
                this.setPosition(this.posX, this.posY, this.posZ);

                if (this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox))
                {
                    flag = true;
                }
            }
        }

        if (!flag)
        {
            this.setPosition(d3, d4, d5);
            return false;
        }
        else
        {
            short short1 = 128;

            for (int l = 0; l < short1; ++l)
            {
                double d6 = (double)l / ((double)short1 - 1.0D);
                float f = (this.rand.nextFloat() - 0.5F) * 0.2F;
                float f1 = (this.rand.nextFloat() - 0.5F) * 0.2F;
                float f2 = (this.rand.nextFloat() - 0.5F) * 0.2F;
                double d7 = d3 + (this.posX - d3) * d6 + (this.rand.nextDouble() - 0.5D) * (double)this.width * 2.0D;
                double d8 = d4 + (this.posY - d4) * d6 + this.rand.nextDouble() * (double)this.height;
                double d9 = d5 + (this.posZ - d5) * d6 + (this.rand.nextDouble() - 0.5D) * (double)this.width * 2.0D;
                this.worldObj.spawnParticle("portal", d7, d8, d9, (double)f, (double)f1, (double)f2);
            }

            this.worldObj.playSoundEffect(d3, d4, d5, "mob.endermen.portal", 1.0F, 1.0F);
            this.playSound("mob.endermen.portal", 1.0F, 1.0F);
            return true;
        }
    }*/
}
