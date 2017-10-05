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
    protected boolean isValidLightLevel()
    {
        int i = MathHelper.floor(this.posX);
        int j = MathHelper.floor(this.getEntityBoundingBox().minY);
        int k = MathHelper.floor(this.posZ);

        if (this.world.getLightFor(EnumSkyBlock.SKY, new BlockPos(i, j, k)) > this.rand
                .nextInt(32))
        {
            return false;
        }
        else
        {
        	int l = this.world.getLightFromNeighbors(new BlockPos(i, j, k));

            if (this.world.isThundering())
            {
                int i1 = this.world.getSkylightSubtracted();
                this.world.setSkylightSubtracted(10);
                l = this.world.getLight(new BlockPos(i, j, k));
                this.world.setSkylightSubtracted(i1);
            }

            return l <= 7;
        }
    }

    /**
     * Checks if the entity's current position is a valid location to spawn this
     * entity.
     */
    public boolean getCanSpawnHere()
    {
    	//System.out.println("Chicken: Skeleton X:" + this.posX + " Y:" + this.posY + " Z:" + this.posZ);
    	return this.world.getDifficulty().toString() != "PEACEFUL" && this.isValidLightLevel();
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
