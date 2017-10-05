package com.saxon564.mochickens.entities.mobs.ai;

import com.saxon564.mochickens.entities.mobs.EntityMoChicken;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathNavigateGround;

public class ChickAITempt extends EntityAIBase
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
    private Item breedingFood;
    private String breedingFood2;

    /**
     * Whether the entity using this AI will be scared by the tempter's sudden
     * movement.
     */
    private boolean scaredByPlayerMovement;
    private boolean field_75286_m;

    public ChickAITempt(EntityCreature par1EntityCreature, double par2,
                        Item object, boolean par5, int delay)
    {
        this.setTemptedEntity(par1EntityCreature);
        this.field_75282_b = par2;
        this.setBreedingFood(object);
        this.configedDelay = delay;
        this.scaredByPlayerMovement = par5;
        this.setMutexBits(3);
    }

    public void ChickAITempt2(EntityCreature par1EntityCreature, double par2,
                              String par4, boolean par5, int delay)
    {
        this.setTemptedEntity(par1EntityCreature);
        this.field_75282_b = par2;
        this.setBreedingFood2(par4);
        this.configedDelay = delay;
        this.scaredByPlayerMovement = par5;
        this.setMutexBits(3);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        String owner = this.getTemptedEntity().getDataManager().get(EntityMoChicken.OWNER);

        if (this.getDelayTemptCounter() > 0)
        {
            this.setDelayTemptCounter(this.getDelayTemptCounter() - 1);
            return false;
        }
        else
        {
            this.setTemptingPlayer(this.getTemptedEntity().world
                                   .getClosestPlayerToEntity(this.getTemptedEntity(), 10.0D));

            if (this.getTemptingPlayer() == null)
            {
                return false;
            }
            else if (!this.getTemptingPlayer().getUniqueID().toString().equals(owner))
            {
                return false;
            }
            else
            {
                ItemStack itemstack = this.getTemptingPlayer().getHeldItemMainhand();
                return itemstack == null ? false : itemstack.getItem() == this.breedingFood;
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
        return breedingFood.toString();
    }

    public String getBreedingFood2()
    {
        return breedingFood2;
    }

    public void setBreedingFood(Item object)
    {
        this.breedingFood = object;
    }

    public void setBreedingFood2(String par4)
    {
        this.breedingFood2 = par4;
    }
}
