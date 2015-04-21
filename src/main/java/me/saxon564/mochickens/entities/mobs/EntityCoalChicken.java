package me.saxon564.mochickens.entities.mobs;

import me.saxon564.mochickens.configs.chickens.CoalChickenConfig;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityCoalChicken extends EntityMoChicken {

	public EntityCoalChicken(World par1World) {
		super(par1World);
	}

	/**
	 * Returns true if the newer Entity AI code should be run
	 */
	/*public boolean isAIEnabled() {
		return true;
	}*/

	public void applyEntityAttributes() {
		super.applyEntityAttributes(CoalChickenConfig.config, this.getClass());
	}
    
    public boolean getCanSpawnHere()
    {
        int i = MathHelper.floor_double(this.posX);
        int j = MathHelper.floor_double(this.boundingBox.minY);
        int k = MathHelper.floor_double(this.posZ);
        return this.worldObj.getBlock(i, j - 1, k) == Blocks.grass && this.worldObj.getFullBlockLightValue(i, j, k) > 8 && super.getCanSpawnHere();
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
