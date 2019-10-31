package com.saxon564.mochickens.entities.mobs;

import com.saxon564.mochickens.configs.chickens.SkeletonChickenConfig;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class EntitySkeletonChicken extends EntityMoChicken
{

    public EntitySkeletonChicken(EntityType<? extends EntitySkeletonChicken> type, World par1World)
    {
        super(type, par1World);
    }

    public void registerAttributes()
    {
        super.registerAttributes(SkeletonChickenConfig.class, getType());
    }

    public boolean canSpawn(IWorld worldIn, SpawnReason reason)
    {
    	return world.getDifficulty().toString() != "PEACEFUL" && super.canSpawn(worldIn, reason);
    }
}
