package com.saxon564.mochickens.entities.mobs.ai;

import com.saxon564.mochickens.entities.mobs.EntityCreeperChicken;
import com.saxon564.mochickens.entities.mobs.EntityMoChicken;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.monster.EntityCreeper;

public class ChickAISwell extends EntityAIBase
{
    /** The creeper that is swelling. */
    EntityMoChicken swellingChicken;

    /**
     * The creeper's attack target. This is used for the changing of the creeper's state.
     */
    EntityLivingBase chickenAttackTarget;

    public ChickAISwell(EntityMoChicken par1EntityChicken)
    {
        this.swellingChicken = par1EntityChicken;
        this.setMutexBits(1);
    }

	/**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        EntityLivingBase entitylivingbase = this.swellingChicken.getAttackTarget();
        return this.swellingChicken.getChickenState() > 0 || entitylivingbase != null && this.swellingChicken.getDistanceSq(entitylivingbase) < 9.0D;
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        this.swellingChicken.getNavigator().clearPath();
        this.chickenAttackTarget = this.swellingChicken.getAttackTarget();
    }

    /**
     * Resets the task
     */
    public void resetTask()
    {
        this.chickenAttackTarget = null;
    }

    /**
     * Updates the task
     */
    public void updateTask()
    {
        if (this.chickenAttackTarget == null)
        {
            this.swellingChicken.setChickenState(-1);
        }
        else if (this.swellingChicken.getDistanceSq(this.chickenAttackTarget) > 49.0D)
        {
            this.swellingChicken.setChickenState(-1);
        }
        else if (!this.swellingChicken.getEntitySenses().canSee(this.chickenAttackTarget))
        {
            this.swellingChicken.setChickenState(-1);
        }
        else
        {
            this.swellingChicken.setChickenState(1);
        }
    }
}
