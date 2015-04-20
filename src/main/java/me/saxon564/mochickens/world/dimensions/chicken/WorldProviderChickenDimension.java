package me.saxon564.mochickens.world.dimensions.chicken;

import me.saxon564.mochickens.MoChickens;
import me.saxon564.mochickens.world.dimensions.chicken.chunks.ChunkProviderChickenDimension;
import me.saxon564.mochickens.world.dimensions.chicken.chunks.WorldChunkManagerChicken;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderChickenDimension extends WorldProvider {

	public void registerWorldChunkManager() {
		this.worldChunkMgr = new WorldChunkManagerChicken(worldObj.getSeed(), terrainType);
		//this.dimensionId = MoChickens.chickenDimensionId;
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

}
