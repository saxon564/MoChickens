package com.saxon564.mochickens.entities.mobs;

import com.saxon564.mochickens.configs.chickens.BlazingChickenConfig;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class EntityBlazingChicken extends EntityMoChicken
{

    public EntityBlazingChicken(EntityType<? extends EntityBlazingChicken> type, World par1World)
    {
        super(type, par1World);
    }

    public void registerAttributes()
    {
        super.registerAttributes(BlazingChickenConfig.class, this.getType());
    }

    public boolean canSpawn(IWorld worldIn, SpawnReason reason)
    {
    	BlockPos pos = getPosition();
    	Block block = world.getBlockState(pos.down()).getBlock();
        return !block.equals(Blocks.LAVA) && super.canSpawn(worldIn, reason);
    }
}
