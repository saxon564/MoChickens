package me.saxon564.mochickens.entities.mobs;

import me.saxon564.mochickens.configs.chickens.BlazingChickenConfig;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityBlazingChicken extends EntityMoChicken
{

    public EntityBlazingChicken(World par1World)
    {
        super(par1World);
    }

    public void applyEntityAttributes()
    {
        super.applyEntityAttributes(BlazingChickenConfig.config, this.getClass());
    }

    public boolean getCanSpawnHere()
    {
    	int i = MathHelper.floor_double(this.posX);
        int j = MathHelper.floor_double(this.boundingBox.minY);
        int k = MathHelper.floor_double(this.posZ);

        if ((this.worldObj.getBlock(i, j - 1, k) != Blocks.lava) && (this.worldObj.getBlock(i, j - 1, k) != Blocks.flowing_lava))
        {
        	//System.out.println("Chicken: Blazing X:" + this.posX + " Y:" + this.posY + " Z:" + this.posZ);
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return "mob.chicken.say";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.chicken.hurt";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.chicken.hurt";
    }

    /**
     * Plays step sound at given x, y, z for the entity
     */
    protected void playStepSound(int par1, int par2, int par3, int par4)
    {
        this.playSound("mob.chicken.step", 0.15F, 1.0F);
    }
}
