package com.saxon564.mochickens.entities.mobs;

import com.saxon564.mochickens.configs.chickens.SkeletonChickenConfig;

import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;

public class EntitySkeletonChicken extends EntityMoChicken
{

    public EntitySkeletonChicken(World par1World)
    {
        super(par1World);
    }

    public void applyEntityAttributes()
    {
        super.applyEntityAttributes(SkeletonChickenConfig.config, this.getClass());
    }

    /**
     * Checks to make sure the light is not too bright where the mob is spawning
     */
    /*protected boolean isValidLightLevel()
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
    }*/

    /**
     * Checks if the entity's current position is a valid location to spawn this
     * entity.
     */
    public boolean getCanSpawnHere()
    {
    	//System.out.println("Chicken: Skeleton X:" + this.posX + " Y:" + this.posY + " Z:" + this.posZ);
		//System.out.println("Skeleton Chicken " + (this.world.getDifficulty().toString() != "PEACEFUL" && this.isValidLightLevel()));
    	BlockPos pos = this.getPosition();
    	//int light = this.world.getLight(pos);
    	//return this.world.getDifficulty().toString() != "PEACEFUL" && light >= this.minSpawnLightLevel && light <= this.maxSpawnLightLevel;
    	return this.world.getDifficulty().toString() != "PEACEFUL" && super.getCanSpawnHere();
    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected SoundEvent getLivingSound()
    {
        return SoundEvents.ENTITY_SKELETON_AMBIENT;
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected SoundEvent getHurtSound()
    {
        return SoundEvents.ENTITY_SKELETON_HURT;
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected SoundEvent getDeathSound()
    {
        return SoundEvents.ENTITY_SKELETON_DEATH;
    }

    /**
     * Plays step sound at given x, y, z for the entity
     */
    protected void playStepSound(int par1, int par2, int par3, int par4)
    {
        this.playSound(SoundEvents.ENTITY_SKELETON_STEP, 0.15F, 1.0F);
    }
}
