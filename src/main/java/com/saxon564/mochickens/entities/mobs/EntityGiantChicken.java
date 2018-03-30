package com.saxon564.mochickens.entities.mobs;

import com.saxon564.mochickens.MoChickens;
import com.saxon564.mochickens.Reference;
import com.saxon564.mochickens.configs.chickens.GiantChickenConfig;

import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityGiantChicken extends EntityMoChicken
{

    public EntityGiantChicken(World par1World)
    {
        super(par1World);
    }

    public void applyEntityAttributes()
    {
        super.applyEntityAttributes(GiantChickenConfig.config, this.getClass());
    }
    
    public boolean getCanSpawnHere()
    {
        BlockPos pos = this.getPosition();
       //return this.world.getBlockState(pos.down()).getBlock() == Blocks.GRASS && this.world.getLight(pos) > 8 && super.getCanSpawnHere();
        return this.world.getBlockState(pos.down()).getBlock() == Blocks.GRASS && super.getCanSpawnHere();
    }

    /**
     * Returns the sound this mob makes while it's alive.
     * @return
     */
    @Override
	public void playLivingSound()
    {
    	this.playSound(MoChickens.DEEP_CLUCK, 1.0f, 1.0f);
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    @Override
    protected void playHurtSound(DamageSource source)
    {
    	this.playSound(MoChickens.GIANT_HURT, 1.0f, 1.0f);
    	super.playHurtSound(source);
    }

    /**
     * Returns the sound this mob makes on death.
     */
    @Override
    protected SoundEvent getDeathSound()
    {
    	this.playSound(MoChickens.GIANT_HURT, 1.0f, 1.0f);
    	return MoChickens.GIANT_HURT;
    }

    /**
     * Plays step sound at given x, y, z for the entity
     */
    protected void playStepSound(int par1, int par2, int par3, int par4)
    {
        this.playSound(SoundEvents.ENTITY_CHICKEN_STEP, 0.15F, 1.0F);
    }
}
