package me.saxon564.mochickens.entities.mobs;

import me.saxon564.mochickens.configs.chickens.SkeletonChickenConfig;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
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
        int i = MathHelper.floor_double(this.posX);
        int j = MathHelper.floor_double(this.getBoundingBox().minY);
        int k = MathHelper.floor_double(this.posZ);

        if (this.worldObj.getLightFor(EnumSkyBlock.SKY, new BlockPos(i, j, k)) > this.rand
                .nextInt(32))
        {
            return false;
        }
        else
        {
            float l = this.worldObj.getLightBrightness(new BlockPos(i, j, k));

            if (this.worldObj.isThundering())
            {
                int i1 = this.worldObj.getSkylightSubtracted();
                this.worldObj.setSkylightSubtracted(10);
                l = this.worldObj.getLight(new BlockPos(i, j, k));
                this.worldObj.setSkylightSubtracted(i1);
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
    	return this.worldObj.getDifficulty().toString() != "PEACEFUL" && this.isValidLightLevel();
    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return "mob.skeleton.say";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.skeleton.hurt";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.skeleton.death";
    }

    /**
     * Plays step sound at given x, y, z for the entity
     */
    protected void playStepSound(int par1, int par2, int par3, int par4)
    {
        this.playSound("mob.skeleton.step", 0.15F, 1.0F);
    }
}
