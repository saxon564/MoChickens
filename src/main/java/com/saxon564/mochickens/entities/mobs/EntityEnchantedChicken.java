package com.saxon564.mochickens.entities.mobs;

import com.saxon564.mochickens.configs.chickens.EnchantedChickenConfig;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class EntityEnchantedChicken extends EntityMoChicken
{

    public EntityEnchantedChicken(EntityType<? extends EntityEnchantedChicken> type, World par1World)
    {
        super(type, par1World);
    }

    public void registerAttributes()
    {
        super.registerAttributes(EnchantedChickenConfig.class, getType());
    }
    
    public boolean canSpawn(IWorld worldIn, SpawnReason reason)
    {
        BlockPos pos = getPosition();
        return world.getBlockState(pos.down()).getBlock() == Blocks.GRASS && super.canSpawn(worldIn, reason);
    }
}
