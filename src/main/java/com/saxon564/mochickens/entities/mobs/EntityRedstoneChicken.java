package com.saxon564.mochickens.entities.mobs;

import com.saxon564.mochickens.MoChickens;
import com.saxon564.mochickens.configs.FileManager;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityRedstoneChicken extends EntityMoChicken
{

    public EntityRedstoneChicken(World par1World)
    {
        super(par1World);
    }

    public void applyEntityAttributes()
    {
        super.applyEntityAttributes(FileManager.redstoneConfig, this.getClass());
    }
    
    public boolean getCanSpawnHere()
    {
    	BlockPos pos = this.getPosition();
    	//return this.world.getBlockState(pos.down()).getBlock() == Blocks.GRASS && this.world.getLight(pos) >= this.minSpawnLightLevel && this.world.getLight(pos) <= this.maxSpawnLightLevel && super.getCanSpawnHere();
    	return this.world.getBlockState(pos.down()).getBlock() == Blocks.GRASS  && super.getCanSpawnHere();
    }
    
    protected Item getDropItemId() {
		return new ItemStack(MoChickens.chicken_feather, 1, 3).getItem();
	}

	/**
	 * Drop 0-2 items of this living's type. @param par1 - Whether this entity
	 * has recently been hit by a player. @param par2 - Level of Looting used to
	 * kill this mob.
	 */
    protected void dropFewItems(boolean par1, int par2) {
		int j = this.rand.nextInt(3) + this.rand.nextInt(1 + par2);

		if (j >= 3) {
			this.entityDropItem(new ItemStack(MoChickens.chicken_feather, 1, 3), 1);
		}

		if (this.isBurning()) {
			this.dropItem(Items.COOKED_CHICKEN, 1);
		} else {
			this.dropItem(Items.CHICKEN, 1);
		}
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
