package com.saxon564.mochickens.world.dimensions.chicken;

import com.saxon564.mochickens.MoChickens;
import com.saxon564.mochickens.configs.DimensionConfigs;
import com.saxon564.mochickens.world.dimensions.chicken.chunks.ChunkProviderChickenDimension;
import com.saxon564.mochickens.world.dimensions.chicken.chunks.WorldChunkManagerChicken;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderChickenDimension extends WorldProvider {

	public void registerWorldChunkManager() {
		WorldType terrainType = worldObj.getWorldInfo().getTerrainType();
		this.worldChunkMgr = new WorldChunkManagerChicken(worldObj.getSeed(), terrainType, worldObj.getWorldInfo().getGeneratorOptions());
		this.dimensionId = DimensionConfigs.chickenDimId;
	}
	
	public IChunkProvider createChunkGenerator() {
		return new ChunkProviderChickenDimension(this.worldObj, this.worldObj.getSeed(), true);
	}
	
	@Override
	public boolean canRespawnHere() {
		return false;
	}
	
	@Override
	public String getDimensionName() {
		return "Chicken Dimension";
	}
	
	@Override
	public int getRespawnDimension(EntityPlayerMP player)
	{
		return 0;
	}

	@Override
	public String getInternalNameSuffix() {
		return null;
	}

}
