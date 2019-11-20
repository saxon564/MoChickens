package com.saxon564.mochickens.entities.mobs.ai;

import java.util.EnumSet;
import java.util.Set;
import java.util.UUID;

import com.google.common.collect.Sets;
import com.saxon564.mochickens.MoChickens;
import com.saxon564.mochickens.entities.mobs.EntityMoChicken;

import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathNavigator;

public class ChickAITempt extends Goal
{
    /** The entity using this AI that is tempted by the player. */
    private final EntityMoChicken temptedEntity;
    private final double speed;
    /** X position of player tempting this mob */
    private double targetX;
    /** Y position of player tempting this mob */
    private double targetY;
    /** Z position of player tempting this mob */
    private double targetZ;
    /** Tempting player's pitch */
    private double pitch;
    /** Tempting player's yaw */
    private double yaw;
    /** The player that is tempting the entity that is using this AI. */
    private PlayerEntity temptingPlayer;
    /**
     * A counter that is decremented each time the shouldExecute method is called. The shouldExecute method will always
     * return false if delayTemptCounter is greater than 0.
     */
    private int delayTemptCounter;
    /** True if this EntityAITempt task is running */
    private boolean isRunning;
    private final Set<Item> temptItem;
    /** Whether the entity using this AI will be scared by the tempter's sudden movement. */
    private final boolean scaredByPlayerMovement;

    private final boolean onlyOwner;
    private final UUID entityOwnerId;
    
    private final boolean wild;
    private final boolean tamed;

    public ChickAITempt(EntityMoChicken temptedEntityIn, double speedIn, Item[] temptItemIn, boolean scaredByPlayerMovementIn, boolean ownerOnly, UUID targetUUID, boolean temptedWild, boolean temptedTamed)
    {
        this(temptedEntityIn, speedIn, scaredByPlayerMovementIn, Sets.newHashSet(temptItemIn), ownerOnly, targetUUID, temptedWild, temptedTamed);
    }

    public ChickAITempt(EntityMoChicken temptedEntityIn, double speedIn, boolean scaredByPlayerMovementIn, Set<Item> temptItemIn, boolean ownerOnly, UUID targetUUID, boolean temptedWild, boolean temptedTamed)
    {
    	wild = temptedWild;
    	tamed = temptedTamed;
        temptedEntity = temptedEntityIn;
        speed = speedIn;
        temptItem = temptItemIn;
        onlyOwner = ownerOnly;
        entityOwnerId = targetUUID;
        scaredByPlayerMovement = scaredByPlayerMovementIn;
        setMutexFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));

        if (!(temptedEntityIn.getNavigator() instanceof PathNavigator))
        {
            throw new IllegalArgumentException("Unsupported mob type for TemptGoal");
        }
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
    	if ((wild) || (tamed && temptedEntity.isTamed())) {
	        if (delayTemptCounter > 0)
	        {
	            --delayTemptCounter;
	            return false;
	        }
	        else
	        {
	            temptingPlayer = temptedEntity.world.getClosestPlayer(temptedEntity, 10.0D);
	            if (temptingPlayer != null) {
	            	
		            if (!onlyOwner || temptingPlayer.getUniqueID().toString().equals(entityOwnerId.toString())) {
		            	return temptingPlayer == null ? false : isTempting(temptingPlayer.getHeldItemMainhand()) || isTempting(temptingPlayer.getHeldItemOffhand());
		            } else {
		            	return false;
		            }
	            } else {
	            	return false;
	            }
	        }
    	} else {
    		return false;
    	}
    }

    protected boolean isTempting(ItemStack stack)
    {
        return temptItem.contains(stack.getItem());
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean shouldContinueExecuting()
    {
        if (scaredByPlayerMovement)
        {
            if (temptedEntity.getDistanceSq(temptingPlayer) < 36.0D)
            {
                if (temptingPlayer.getDistanceSq(targetX, targetY, targetZ) > 0.010000000000000002D)
                {
                    return false;
                }

                if (Math.abs((double)temptingPlayer.rotationPitch - pitch) > 5.0D || Math.abs((double)temptingPlayer.rotationYaw - yaw) > 5.0D)
                {
                    return false;
                }
            }
            else
            {
                targetX = temptingPlayer.posX;
                targetY = temptingPlayer.posY;
                targetZ = temptingPlayer.posZ;
            }

            pitch = (double)temptingPlayer.rotationPitch;
            yaw = (double)temptingPlayer.rotationYaw;
        }

        return shouldExecute();
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        targetX = temptingPlayer.posX;
        targetY = temptingPlayer.posY;
        targetZ = temptingPlayer.posZ;
        isRunning = true;
    }

    /**
     * Resets the task
     */
    public void resetTask()
    {
        temptingPlayer = null;
        temptedEntity.getNavigator().clearPath();
        delayTemptCounter = 100;
        isRunning = false;
    }

    /**
     * Updates the task
     */
    public void updateTask()
    {
        temptedEntity.getLookController().setLookPositionWithEntity(temptingPlayer, (float)(temptedEntity.getHorizontalFaceSpeed() + 20), (float)temptedEntity.getVerticalFaceSpeed());

        if (temptedEntity.getDistanceSq(temptingPlayer) < 6.25D)
        {
            temptedEntity.getNavigator().clearPath();
        }
        else
        {
            temptedEntity.getNavigator().tryMoveToEntityLiving(temptingPlayer, speed);
        }
    }

    /**
     * @see #isRunning
     */
    public boolean isRunning()
    {
        return isRunning;
    }
}