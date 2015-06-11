package com.saxon564.mochickens.entities.mobs;

import com.saxon564.mochickens.MoChickens;
import com.saxon564.mochickens.configs.chickens.IronChickenConfig;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityIronChicken extends EntityMoChicken
{

    public EntityIronChicken(World par1World)
    {
        super(par1World);
    }

    public void applyEntityAttributes()
    {
        super.applyEntityAttributes(IronChickenConfig.config, this.getClass());
    }
    
    public boolean getCanSpawnHere()
    {
        int i = MathHelper.floor_double(this.posX);
        int j = MathHelper.floor_double(this.getEntityBoundingBox().minY);
        int k = MathHelper.floor_double(this.posZ);
        return this.worldObj.getBlockState(new BlockPos(i, j - 1, k)).getBlock() == Blocks.grass && this.worldObj.getLight(new BlockPos(i, j, k)) > 8 && super.getCanSpawnHere();
    }
    
    protected Item getDropItemId() {
		return new ItemStack(MoChickens.chicken_feather, 1, 1).getItem();
	}

	/**
	 * Drop 0-2 items of this living's type. @param par1 - Whether this entity
	 * has recently been hit by a player. @param par2 - Level of Looting used to
	 * kill this mob.
	 */
	protected void dropFewItems(boolean par1, int par2) {
		int j = this.rand.nextInt(3) + this.rand.nextInt(1 + par2);

		if (j >= 3) {
			this.entityDropItem(new ItemStack(MoChickens.chicken_feather, 1, 1), 1);
		}

		if (this.isBurning()) {
			this.dropItem((Item) Item.itemRegistry.getObject("cooked_chicken"),
					1);
		} else {
			this.dropItem((Item) Item.itemRegistry.getObject("chicken"), 1);
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
