package com.saxon564.mochickens.entities.mobs;

import com.saxon564.mochickens.Reference;
import com.saxon564.mochickens.configs.chickens.GiantChickenConfig;

import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.ResourceLocation;
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
        int i = MathHelper.floor(this.posX);
        int j = MathHelper.floor(this.getEntityBoundingBox().minY);
        int k = MathHelper.floor(this.posZ);
        return this.world.getBlockState(new BlockPos(i, j - 1, k)).getBlock() == Blocks.GRASS && this.world.getLight(new BlockPos(i, j, k)) > 8 && super.getCanSpawnHere();
    }

    /**
     * Returns the sound this mob makes while it's alive.
     * @return
     */
    protected SoundEvent getLivingSound()
    {
    	return SoundEvent.REGISTRY.getObject(new ResourceLocation(Reference.MOD_ID, "sounds.deepCluck"));
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected SoundEvent getHurtSound()
    {
        return SoundEvent.REGISTRY.getObject(new ResourceLocation(Reference.MOD_ID, "sounds.giantHurt"));
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected SoundEvent getDeathSound()
    {
    	return SoundEvent.REGISTRY.getObject(new ResourceLocation(Reference.MOD_ID, "sounds.giantHurt"));
    }

    /**
     * Plays step sound at given x, y, z for the entity
     */
    protected void playStepSound(int par1, int par2, int par3, int par4)
    {
        this.playSound(SoundEvents.ENTITY_CHICKEN_STEP, 0.15F, 1.0F);
    }
}
