package com.saxon564.mochickens.entities.mobs;

import com.saxon564.mochickens.configs.chickens.ClayChickenConfig;

import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;

public class EntityClayChicken extends EntityMoChicken
{

    public EntityClayChicken(World par1World)
    {
        super(par1World);
    }

    public void applyEntityAttributes()
    {
        super.applyEntityAttributes(ClayChickenConfig.config, this.getClass());
    }
    
    public boolean getCanSpawnHere()
    {
        int i = MathHelper.floor(this.posX);
        int j = MathHelper.floor(this.getEntityBoundingBox().minY);
        int k = MathHelper.floor(this.posZ);
        return this.world.getBlockState(new BlockPos(i, j - 1, k)).getBlock() == Blocks.GRASS && this.world.getLight(new BlockPos(i, j, k)) > 8 && super.getCanSpawnHere();
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
