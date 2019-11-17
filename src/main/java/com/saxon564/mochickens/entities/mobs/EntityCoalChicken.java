package com.saxon564.mochickens.entities.mobs;

import com.saxon564.mochickens.MoChickens;
import com.saxon564.mochickens.configs.ConfigHandler;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class EntityCoalChicken extends EntityMoChicken {

	public EntityCoalChicken(EntityType<? extends EntityCoalChicken> type, World par1World) {
		super(type, par1World);
	}

	public void registerAttributes() {
		super.registerAttributes(ConfigHandler.COAL_CHICKEN_CONFIG, getType());
	}
    
    public boolean canSpawn(IWorld worldIn, SpawnReason reason)
    {
        BlockPos pos = getPosition();
        return world.getBlockState(pos.down()).getBlock() == Blocks.GRASS && super.canSpawn(worldIn, reason);
    }

	/**
	 * Drop 0-2 items of this living's type. @param par1 - Whether this entity
	 * has recently been hit by a player. @param par2 - Level of Looting used to
	 * kill this mob.
	 */
    protected void dropFewItems(boolean par1, int par2) {
		int j = rand.nextInt(3) + rand.nextInt(1 + par2);

		if (j >= 3) {
			entityDropItem(new ItemStack(MoChickens.COAL_CHICKEN_FEATHER, 1), 1);
		}

		if (isBurning()) {
			entityDropItem(Items.COOKED_CHICKEN, 1);
		} else {
			entityDropItem(Items.CHICKEN, 1);
		}
	}
}
