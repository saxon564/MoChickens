package com.saxon564.mochickens.entities.mobs;

import com.saxon564.mochickens.configs.ConfigHandler;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class EntityCreeperChicken extends EntityMoChicken
{

    public EntityCreeperChicken(EntityType<? extends EntityCreeperChicken> type, World par1World)
    {
        super(type, par1World);
    }

    public void registerAttributes()
    {
        super.registerAttributes(ConfigHandler.CREEPER_CHICKEN_CONFIG, getType());
    }

    @Override
    public boolean canSpawn(IWorld worldIn, SpawnReason reason)
    {
    		return !world.getDifficulty().toString().equalsIgnoreCase("PEACEFUL") && super.canSpawn(worldIn, reason);
    }
}
