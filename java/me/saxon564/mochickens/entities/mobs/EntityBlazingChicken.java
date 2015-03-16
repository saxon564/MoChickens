package me.saxon564.mochickens.entities.mobs;

import java.util.logging.Logger;

import me.saxon564.mochickens.MoChickens;
import me.saxon564.mochickens.configs.chickens.BlazingChickenConfig;
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
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

public class EntityBlazingChicken extends EntityMoChicken
{
    /*public boolean field_70885_d = false;
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

    public EntityBlazingChicken(World par1World)
    {
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
        this.isImmuneToFire = true;
        this.timeUntilNextEgg = -1;
        this.setTamed(false);*/
    }

    /**
     * Returns true if the newer Entity AI code should be run
     */
    /*public boolean isAIEnabled()
    {
        return true;
    }*/

    public void applyEntityAttributes()
    {
        super.applyEntityAttributes(BlazingChickenConfig.config, this.getClass());
        /*this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
        .setBaseValue(15.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
        .setBaseValue(0.25D);*/
    }

    /*@Override
    public final void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
    {
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

    public boolean getCanSpawnHere()
    {
    	int i = MathHelper.floor_double(this.posX);
        int j = MathHelper.floor_double(this.boundingBox.minY);
        int k = MathHelper.floor_double(this.posZ);

        if ((this.worldObj.getBlock(i, j - 1, k) != Block.blockRegistry.getObject("lava")) && (this.worldObj.getBlock(i, j - 1, k) != Block.blockRegistry.getObject("flowing_lava")))
        {
        	//System.out.println("Chicken: Blazing X:" + this.posX + " Y:" + this.posY + " Z:" + this.posZ);
            return true;
        }
        else
        {
            return false;
        }
    }

    /*protected boolean canDespawn() {
		if (ran == 0) {
			//System.out.println("Coal Deaspawning is: " + despawn);
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
					(Item) Item.itemRegistry.getObject("blaze_rod"), false));
			if (MoChickens.blazingTamedDespawn == false) {
				despawn = false;
				ran = 0;
				this.canDespawn();
			} else {
				despawn = true;
				ran = 0;
				this.canDespawn();
			}
			this.timeUntilNextEgg = this.rand.nextInt(3000) + 6000;
		} else {
			this.tasks.addTask(2, new EntityAIAttackOnCollide(this,
					EntityPlayer.class, 1.0D, false));
			this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(
					this, EntityPlayer.class, 0, true));
			this.dataWatcher.updateObject(16, Byte.valueOf((byte) (b0 & -5)));
			if (MoChickens.blazingUntamedDespawn == false) {
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

    public boolean attackEntityAsMob(Entity par1Entity)
    {
        if (!this.isTamed())
        {
            EntityPlayer entityplayer = this.worldObj
                                        .getClosestVulnerablePlayerToEntity(this, 16.0D);
            // f = damage delt 2.0D = 1 heart
            float f = (float) 5.0D;
            int i = 0;

            if (entityplayer instanceof EntityLivingBase)
            {
                f += EnchantmentHelper.getEnchantmentModifierLiving(this,
                        (EntityLivingBase) entityplayer);
                i += EnchantmentHelper.getKnockbackModifier(this,
                        (EntityLivingBase) entityplayer);
                entityplayer.setFire(7);
                entityplayer.addPotionEffect(new PotionEffect(
                                                 Potion.moveSlowdown.id, 200, 3));
            }

            boolean flag = par1Entity.attackEntityFrom(
                               DamageSource.causeMobDamage(this), f);

            if (flag)
            {
                if (i > 0)
                {
                    entityplayer.addVelocity(
                        (double)(-MathHelper.sin(this.rotationYaw
                                                 * (float) Math.PI / 180.0F)
                                 * (float) i * 0.5F),
                        0.1D,
                        (double)(MathHelper.cos(this.rotationYaw
                                                * (float) Math.PI / 180.0F)
                                 * (float) i * 0.5F));
                    this.motionX *= 0.6D;
                    this.motionZ *= 0.6D;
                }

                int j = EnchantmentHelper.getFireAspectModifier(this);

                if (j > 0)
                {
                    entityplayer.setFire(j * 4);
                }

                if (entityplayer instanceof EntityLivingBase)
                {
                    EnchantmentThorns.func_92094_a(i, this.rand);
                }
            }

            return flag;
        }
        else
        {
            return false;
        }
    }*/

    /**
     * Called frequently so the entity can update its state every tick as
     * required. For example, zombies and skeletons use this to react to
     * sunlight and start to burn.
     */
    //private int loc = 0;
    /*public void onLivingUpdate()
    {
        super.onLivingUpdate();
        //if (loc == 0) {
        //	MinecraftServer.getServer().getLogAgent().logInfo("Beefy X:" + this.posX + " Y:" + this.posY + " Z:" + this.posZ);
        //	loc ++;
        //}
        this.field_70888_h = this.field_70886_e;
        this.field_70884_g = this.destPos;
        this.destPos = (float)((double) this.destPos + (double)(this.onGround ? -1
                               : 4) * 0.3D);

        if (this.destPos < 0.0F)
        {
            this.destPos = 0.0F;
        }

        if (this.destPos > 1.0F)
        {
            this.destPos = 1.0F;
        }

        if (!this.onGround && this.field_70889_i < 1.0F)
        {
            this.field_70889_i = 1.0F;
        }

        this.field_70889_i = (float)((double) this.field_70889_i * 0.9D);

        if (!this.onGround && this.motionY < 0.0D)
        {
            this.motionY *= 0.6D;
        }

        this.field_70886_e += this.field_70889_i * 2.0F;

        if (this.worldObj.difficultySetting != checked)
        {
            this.difficultyChange();
            checked = this.worldObj.difficultySetting;
        }
        
        for (int i = 0; i < 2; ++i)
        {
            this.worldObj.spawnParticle("largesmoke", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
        }

        if (!this.isChild() && !this.worldObj.isRemote
                && --this.timeUntilNextEgg == 0)
        {
            this.playSound("mob.chicken.plop", 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
            this.dropItem((Item) Item.itemRegistry.getObject("blaze_powder"), 1);
            this.timeUntilNextEgg = this.rand.nextInt(3000) + 6000;
        }
    }

    private void difficultyChange()
    {
        if (this.worldObj.difficultySetting.toString() == "PEACEFUL")
        {
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
    protected void fall(float par1)
    {
    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return "mob.chicken.say";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.chicken.hurt";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.chicken.hurt";
    }

    /**
     * Plays step sound at given x, y, z for the entity
     */
    protected void playStepSound(int par1, int par2, int par3, int par4)
    {
        this.playSound("mob.chicken.step", 0.15F, 1.0F);
    }

    /**
     * Returns the item the mob drops on death.
     */
    /*protected Item getDropItemId()
    {
        return (Item) Item.itemRegistry.getObject("feather");
    }*/

    /**
     * Drop 0-2 items of this living's type. @param par1 - Whether this entity
     * has recently been hit by a player. @param par2 - Level of Looting used to
     * kill this mob.
     */
    /*protected void dropFewItems(boolean par1, int par2)
    {
        int j = this.rand.nextInt(3) + this.rand.nextInt(1 + par2);

        for (int k = 0; k < j; ++k)
        {
            if (this.isTamed())
            {
                this.dropItem((Item) Item.itemRegistry.getObject("blaze_powder"), 1);
            }
            else
            {
                this.dropItem((Item) Item.itemRegistry.getObject("egg"), 1);
            }
        }

        if (this.isBurning())
        {
            this.dropItem((Item) Item.itemRegistry.getObject("blaze_powder"), 1);
        }
        else
        {
            this.dropItem((Item) Item.itemRegistry.getObject("chicken"), 1);
        }
    }*/

    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow,
     * gets into the saddle on a pig.
     */
    /*public boolean interact(EntityPlayer par1EntityPlayer)
    {
        ItemStack itemstack = par1EntityPlayer.inventory.getCurrentItem();

        if (!this.isTamed())
        {
            if (itemstack != null && itemstack.getItem() == (Item) Item.itemRegistry.getObject("blaze_rod"))
            {
                if (!par1EntityPlayer.capabilities.isCreativeMode)
                {
                    --itemstack.stackSize;
                }

                if (itemstack.stackSize <= 0)
                {
                    par1EntityPlayer.inventory.setInventorySlotContents(
                        par1EntityPlayer.inventory.currentItem,
                        (ItemStack) null);
                }

                if (!this.worldObj.isRemote)
                {
                    if (this.rand.nextInt(3) == 0)
                    {
                        this.setTamed(true);
                        this.setPathToEntity((PathEntity) null);
                        this.setAttackTarget((EntityLivingBase) null);
                        this.setTarget(null);
                        this.func_152115_b(par1EntityPlayer.getUniqueID().toString());
                        this.playTameEffect(true);
                    }
                    else
                    {
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
    /*public EntityBlazingChicken spawnBabyAnimal(EntityAgeable par1EntityAgeable)
    {
        EntityBlazingChicken entitybluechicken = new EntityBlazingChicken(
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
    /*public boolean isBreedingItem(ItemStack par1ItemStack)
    {
        if (this.isTamed())
        {
            return par1ItemStack != null
                   && par1ItemStack.getItem() == (Item) Item.itemRegistry.getObject("blaze_rod");
        }
        else
        {
            return false;
        }
    }

    public EntityAgeable createChild(EntityAgeable par1EntityAgeable)
    {
        return this.spawnBabyAnimal(par1EntityAgeable);
    }*/
}
