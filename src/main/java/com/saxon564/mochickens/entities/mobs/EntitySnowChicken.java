package com.saxon564.mochickens.entities.mobs;

import com.saxon564.mochickens.configs.FileManager;

import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntitySnowChicken extends EntityMoChicken
{

    public EntitySnowChicken(World par1World)
    {
        super(par1World);
    }

    public void applyEntityAttributes()
    {
        super.applyEntityAttributes(FileManager.snowConfig, this.getClass());
    }
    
    public boolean getCanSpawnHere()
    {
    	BlockPos pos = this.getPosition();
    	//int light = this.world.getLight(pos);
        //return this.world.getBlockState(pos.down()) == Blocks.GRASS && light >= this.minSpawnLightLevel && light <= this.maxSpawnLightLevel && super.getCanSpawnHere();
        return this.world.getBlockState(pos.down()) == Blocks.GRASS && super.getCanSpawnHere();
    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected SoundEvent getLivingSound()
    {
        return SoundEvents.ENTITY_CHICKEN_AMBIENT;
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected SoundEvent getHurtSound()
    {
        return SoundEvents.ENTITY_CHICKEN_HURT;
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected SoundEvent getDeathSound()
    {
        return SoundEvents.ENTITY_CHICKEN_DEATH;
    }

    /**
     * Plays step sound at given x, y, z for the entity
     */
    protected void playStepSound(int par1, int par2, int par3, int par4)
    {
        this.playSound(SoundEvents.ENTITY_CHICKEN_STEP, 0.15F, 1.0F);
    }
}
