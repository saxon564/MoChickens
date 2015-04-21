package me.saxon564.mochickens.entities.mobs;

import me.saxon564.mochickens.configs.chickens.EnderChickenConfig;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;

public class EntityEnderChicken extends EntityMoChicken {

	public EntityEnderChicken(World par1World) {
		super(par1World);
	}

	/*protected void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(18, new Byte((byte) 0));
	}*/

	public void applyEntityAttributes() {
		super.applyEntityAttributes(EnderChickenConfig.config, this.getClass());
	}
    
    protected boolean isValidLightLevel()
    {
        int i = MathHelper.floor_double(this.posX);
        int j = MathHelper.floor_double(this.boundingBox.minY);
        int k = MathHelper.floor_double(this.posZ);

        if (this.worldObj.getSavedLightValue(EnumSkyBlock.Sky, i, j, k) > this.rand
                .nextInt(32))
        {
            return false;
        }
        else
        {
            int l = this.worldObj.getBlockLightValue(i, j, k);

            if (this.worldObj.isThundering())
            {
                int i1 = this.worldObj.skylightSubtracted;
                this.worldObj.skylightSubtracted = 10;
                l = this.worldObj.getBlockLightValue(i, j, k);
                this.worldObj.skylightSubtracted = i1;
            }

            return l <= 7;
        }
    }

    @Override
    public boolean getCanSpawnHere()
    {
    		//System.out.println("Chicken: Ender X:" + this.posX + " Y:" + this.posY + " Z:" + this.posZ);
        	return this.worldObj.difficultySetting.toString() != "PEACEFUL" && this.isValidLightLevel();
    }

	/**
	 * Returns the sound this mob makes while it's alive.
	 */
	protected String getLivingSound() {
		return "mob.chicken.say";
	}

	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	protected String getHurtSound() {
		return "mob.chicken.hurt";
	}

	/**
	 * Returns the sound this mob makes on death.
	 */
	protected String getDeathSound() {
		return "mob.chicken.hurt";
	}

	/**
	 * Plays step sound at given x, y, z for the entity
	 */
	protected void playStepSound(int par1, int par2, int par3, int par4) {
		this.playSound("mob.chicken.step", 0.15F, 1.0F);
	}
}
