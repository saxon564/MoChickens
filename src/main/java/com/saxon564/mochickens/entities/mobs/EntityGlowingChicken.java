package com.saxon564.mochickens.entities.mobs;

import com.saxon564.mochickens.configs.FileManager;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityGlowingChicken extends EntityMoChicken
{

    public EntityGlowingChicken(World par1World)
    {
        super(par1World);
    }

    public void applyEntityAttributes()
    {
        super.applyEntityAttributes(FileManager.glowingConfig, this.getClass());
    }
    
    @Override
    public boolean getCanSpawnHere()
    {
    	BlockPos pos = this.getPosition();
    	Block block = this.world.getBlockState(pos.down()).getBlock();

        /*if ((this.world.getBlockState(pos).getBlock() != Blocks.LAVA) && (this.world.getBlockState(new BlockPos(i, j - 1, k)).getBlock() != Blocks.FLOWING_LAVA))
        {
        	//System.out.println("Chicken: Glowing X:" + this.posX + " Y:" + this.posY + " Z:" + this.posZ);
            return true;
        }
        else
        {
            return false;
        }*/
        return !block.equals(Blocks.LAVA) && !block.equals(Blocks.FLOWING_LAVA) && super.getCanSpawnHere();
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
        return SoundEvents.BLOCK_GLASS_BREAK;
    }

    /**
     * Plays step sound at given x, y, z for the entity
     */
    protected void playStepSound(int par1, int par2, int par3, int par4)
    {
        this.playSound(SoundEvents.ENTITY_CHICKEN_STEP, 0.15F, 1.0F);
    }
}
