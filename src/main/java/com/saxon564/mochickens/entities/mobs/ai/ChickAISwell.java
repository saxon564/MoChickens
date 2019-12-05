package com.saxon564.mochickens.entities.mobs.ai;

import java.util.EnumSet;

import com.saxon564.mochickens.entities.mobs.EntityMoChicken;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.pathfinding.Path;

public class ChickAISwell extends Goal {
    /** The creeper that is swelling. */
    EntityMoChicken swellingChicken;
    boolean moves;
    double speed;
    Path path;

    /**
     * The creeper's attack target. This is used for the changing of the creeper's state.
     */
    LivingEntity chickenAttackTarget;

    public ChickAISwell(EntityMoChicken par1EntityChicken, boolean movingExplosion, double moveSpeed) {
        swellingChicken = par1EntityChicken;
        moves = movingExplosion;
        speed = moveSpeed;
        setMutexFlags(EnumSet.of(Goal.Flag.MOVE));
    }

	/**
     * Returns whether the EntityAIBase should begin execution.
     */
    @Override
    public boolean shouldExecute() {
        LivingEntity entitylivingbase = swellingChicken.getAttackTarget();
        return swellingChicken.getChickenState() > 0 || entitylivingbase != null && swellingChicken.getDistanceSq(entitylivingbase) < 9.0D;
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    @Override
    public void startExecuting() {
        chickenAttackTarget = swellingChicken.getAttackTarget();
        this.path = this.swellingChicken.getNavigator().getPathToEntityLiving(chickenAttackTarget, 0);
    	if (!moves) {
    		swellingChicken.getNavigator().clearPath();
    	} else {
    		swellingChicken.getNavigator().setPath(path, speed);
    	}
    }

    /**
     * Resets the task
     */
    @Override
    public void resetTask() {
        this.chickenAttackTarget = null;
    }

    /**
     * Updates the task
     */
    @Override
    public void tick() {
    	if (!swellingChicken.explodingByECS) {
	        if (this.chickenAttackTarget == null) {
	            this.swellingChicken.setChickenState(-1);
	        } else if (this.swellingChicken.getDistanceSq(this.chickenAttackTarget) > 49.0D) {
	            this.swellingChicken.setChickenState(-1);
	        } else if (!this.swellingChicken.getEntitySenses().canSee(this.chickenAttackTarget)) {
	            this.swellingChicken.setChickenState(-1);
	        } else {
	            this.swellingChicken.setChickenState(1);
	        }
    	}
    }
}
