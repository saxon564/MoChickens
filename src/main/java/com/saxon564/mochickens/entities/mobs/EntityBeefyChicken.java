package com.saxon564.mochickens.entities.mobs;

import com.saxon564.mochickens.configs.ConfigHandler;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class EntityBeefyChicken extends EntityMoChicken
{

    public EntityBeefyChicken(EntityType<? extends EntityBeefyChicken> type, World par1World)
    {
        super(type, par1World);
    }

    public void registerAttributes()
    {
        super.registerAttributes(ConfigHandler.BEEFY_CHICKEN_CONFIG, this.getType());
    }
    
    public boolean canSpawn(IWorld worldIn, SpawnReason reason)
    {
    	BlockPos pos = this.getPosition();
    	return this.world.getBlockState(pos.down()).getBlock() == Blocks.GRASS && super.canSpawn(worldIn, reason);
    }
}
