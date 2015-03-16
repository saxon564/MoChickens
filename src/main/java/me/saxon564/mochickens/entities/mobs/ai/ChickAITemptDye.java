package me.saxon564.mochickens.entities.mobs.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;

public class ChickAITemptDye extends EntityAIBase
{
    /** The entity using this AI that is tempted by the player. */
    private EntityCreature temptedEntity;
    private double field_75282_b;

    /** X position of player tempting this mob */
    private double targetX;

    /** Y position of player tempting this mob */
    private double targetY;

    /** Z position of player tempting this mob */
    private double targetZ;
    private double field_75278_f;
    private double field_75279_g;

    /** The player that is tempting the entity that is using this AI. */
    private EntityPlayer temptingPlayer;

    /**
     * A counter that is decremented each time the shouldExecute method is
     * called. The shouldExecute method will always return false if
     * delayTemptCounter is greater than 0.
     */
    private int delayTemptCounter;
    private int configedDelay;

    /** True if this EntityAITempt task is running */
    private boolean isRunning;

    /**
     * This field saves the ID of the items that can be used to breed entities
     * with this behaviour.
     */
    private String breedingFood;

    /**
     * Whether the entity using this AI will be scared by the tempter's sudden
     * movement.
     */
    private boolean scaredByPlayerMovement;
    private boolean field_75286_m;

    public ChickAITemptDye(EntityCreature par1EntityCreature, double par2,
                           String par4, boolean par5, int delay)
    {
        this.setTemptedEntity(par1EntityCreature);
        this.field_75282_b = par2;
        this.setBreedingFood(par4);
        this.configedDelay = delay;
        this.scaredByPlayerMovement = par5;
        this.setMutexBits(3);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        String owner = this.getTemptedEntity().getDataWatcher()
                       .getWatchableObjectString(17);

        if (this.getDelayTemptCounter() > 0)
        {
            this.setDelayTemptCounter(this.getDelayTemptCounter() - 1);
            return false;
        }
        else
        {
            this.setTemptingPlayer(this.getTemptedEntity().worldObj
                                   .getClosestPlayerToEntity(this.getTemptedEntity(), 10.0D));

            if (this.getTemptingPlayer() == null)
            {
                return false;
            }
            else if (this.getTemptingPlayer().getDisplayName() != owner)
            {
                return false;
            }
            else
            {
                ItemStack itemstack = this.getTemptingPlayer()
                                      .getCurrentEquippedItem();
                return itemstack == null ? false : itemstack.getDisplayName().equalsIgnoreCase(this.getBreedingFood());
            }
        }
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean continueExecuting()
    {
        if (this.scaredByPlayerMovement)
        {
            if (this.getTemptedEntity().getDistanceSqToEntity(
                        this.getTemptingPlayer()) < 36.0D)
            {
                if (this.getTemptingPlayer().getDistanceSq(this.targetX,
                        this.targetY, this.targetZ) > 0.010000000000000002D)
                {
                    return false;
                }

                if (Math.abs((double) this.getTemptingPlayer().rotationPitch
                             - this.field_75278_f) > 5.0D
                        || Math.abs((double) this.getTemptingPlayer().rotationYaw
                                    - this.field_75279_g) > 5.0D)
                {
                    return false;
                }
            }
            else
            {
                this.targetX = this.getTemptingPlayer().posX;
                this.targetY = this.getTemptingPlayer().posY;
                this.targetZ = this.getTemptingPlayer().posZ;
            }

            this.field_75278_f = (double) this.getTemptingPlayer().rotationPitch;
            this.field_75279_g = (double) this.getTemptingPlayer().rotationYaw;
        }

        return this.shouldExecute();
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        this.targetX = this.getTemptingPlayer().posX;
        this.targetY = this.getTemptingPlayer().posY;
        this.targetZ = this.getTemptingPlayer().posZ;
        this.isRunning = true;
        this.field_75286_m = this.getTemptedEntity().getNavigator()
                             .getAvoidsWater();
        this.getTemptedEntity().getNavigator().setAvoidsWater(false);
    }

    /**
     * Resets the task
     */
    public void resetTask()
    {
        this.setTemptingPlayer(null);
        this.getTemptedEntity().getNavigator().clearPathEntity();
        this.setDelayTemptCounter(this.configedDelay);
        this.isRunning = false;
        this.getTemptedEntity().getNavigator()
        .setAvoidsWater(this.field_75286_m);
    }

    /**
     * Updates the task
     */
    public void updateTask()
    {
        this.getTemptedEntity()
        .getLookHelper()
        .setLookPositionWithEntity(this.getTemptingPlayer(), 30.0F,
                                   (float) this.getTemptedEntity().getVerticalFaceSpeed());

        if (this.getTemptedEntity().getDistanceSqToEntity(
                    this.getTemptingPlayer()) < 6.25D)
        {
            this.getTemptedEntity().getNavigator().clearPathEntity();
        }
        else
        {
            this.getTemptedEntity()
            .getNavigator()
            .tryMoveToEntityLiving(this.getTemptingPlayer(),
                                   this.field_75282_b);
        }
    }

    /**
     * @see #isRunning
     */
    public boolean isRunning()
    {
        return this.isRunning;
    }

    public int getDelayTemptCounter()
    {
        return delayTemptCounter;
    }

    public void setDelayTemptCounter(int delayTemptCounter)
    {
        this.delayTemptCounter = delayTemptCounter;
    }

    public EntityPlayer getTemptingPlayer()
    {
        return temptingPlayer;
    }

    public void setTemptingPlayer(EntityPlayer temptingPlayer)
    {
        this.temptingPlayer = temptingPlayer;
    }

    public EntityCreature getTemptedEntity()
    {
        return temptedEntity;
    }

    public void setTemptedEntity(EntityCreature temptedEntity)
    {
        this.temptedEntity = temptedEntity;
    }

    public String getBreedingFood()
    {
        return breedingFood;
    }

    public void setBreedingFood(String par4)
    {
        this.breedingFood = par4;
    }
}
