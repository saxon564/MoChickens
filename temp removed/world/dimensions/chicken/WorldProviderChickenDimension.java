package com.saxon564.mochickens.world.dimensions.chicken;

import com.saxon564.mochickens.MoChickens;
import com.saxon564.mochickens.configs.DimensionConfigs;
import com.saxon564.mochickens.world.dimensions.chicken.chunks.ChunkProviderChickenDimension;
import com.saxon564.mochickens.world.dimensions.chicken.chunks.WorldChunkManagerChicken;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldType;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderChickenDimension extends WorldProvider {

	public void registerWorldChunkManager() {
		WorldType terrainType = world.getWorldInfo().getTerrainType();
		this.biomeProvider = new WorldChunkManagerChicken(world.getSeed(), terrainType, world.getWorldInfo().getGeneratorOptions());
	}
	
	public IChunkGenerator createChunkGenerator() {
		return new ChunkProviderChickenDimension(this.world, this.world.getSeed(), true);
	}
	
	@Override
	public boolean canRespawnHere() {
		return false;
	}
	
	@Override
	public int getRespawnDimension(EntityPlayerMP player)
	{
		return 0;
	}

	@Override
	public DimensionType getDimensionType() {
		return null;
	}

}
