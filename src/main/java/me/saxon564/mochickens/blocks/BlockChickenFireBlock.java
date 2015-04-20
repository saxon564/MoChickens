package me.saxon564.mochickens.blocks;

import static net.minecraftforge.common.util.ForgeDirection.DOWN;
import static net.minecraftforge.common.util.ForgeDirection.EAST;
import static net.minecraftforge.common.util.ForgeDirection.NORTH;
import static net.minecraftforge.common.util.ForgeDirection.SOUTH;
import static net.minecraftforge.common.util.ForgeDirection.UP;
import static net.minecraftforge.common.util.ForgeDirection.WEST;

import org.apache.logging.log4j.LogManager;

import me.saxon564.mochickens.MoChickens;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFire;
import net.minecraft.block.material.Material;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;

public class BlockChickenFireBlock extends BlockFire {

	boolean portal = false;
	
	public BlockChickenFireBlock() {
		super();
	}
	
	/*public void onBlockAdded(World world, int x, int y, int z) {
	
		if (!(world.provider.dimensionId == 0 || world.provider.dimensionId == MoChickens.chickenDimensionId) || world.getBlock(x, y, z) != MoChickens.blockFeatherBlock) {
			if (!world.doesBlockHaveSolidTopSurface(world, x, y - 1, z) && !this.canNeighborBurn(world, x, y, z)) {
				world.setBlockToAir(x, y, z);
			} else {
				world.scheduleBlockUpdate(x, y, z, this, this.tickRate(world) + world.rand.nextInt(10));
				((BlockFeatherPortal)MoChickens.blockFeatherPortal).tryToCreatePortal(world, x, y, z);
			}
			
		}
	}*/
	
	private boolean canNeighborBurn(World world, int x, int y, int z)
    {
        return this.canCatchFire(world, x + 1, y, z, WEST ) ||
               this.canCatchFire(world, x - 1, y, z, EAST ) ||
               this.canCatchFire(world, x, y - 1, z, UP   ) ||
               this.canCatchFire(world, x, y + 1, z, DOWN ) ||
               this.canCatchFire(world, x, y, z - 1, SOUTH) ||
               this.canCatchFire(world, x, y, z + 1, NORTH);
    }

}
