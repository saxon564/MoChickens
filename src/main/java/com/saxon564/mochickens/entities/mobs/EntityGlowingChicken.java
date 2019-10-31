package com.saxon564.mochickens.entities.mobs;

import com.saxon564.mochickens.configs.chickens.GlowingChickenConfig;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class EntityGlowingChicken extends EntityMoChicken
{

    public EntityGlowingChicken(EntityType<? extends EntityGlowingChicken> type, World par1World)
    {
        super(type, par1World);
    }

    public void registerAttributes()
    {
        super.registerAttributes(GlowingChickenConfig.class, getType());
    }
    
    @Override
    public boolean canSpawn(IWorld worldIn, SpawnReason reason)
    {
    	BlockPos pos = getPosition();
    	Block block = world.getBlockState(pos.down()).getBlock();

        return !block.equals(Blocks.LAVA) && super.canSpawn(worldIn, reason);
    }
}
