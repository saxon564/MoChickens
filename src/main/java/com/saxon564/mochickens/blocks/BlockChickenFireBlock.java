package com.saxon564.mochickens.blocks;

import java.util.Map;
import java.util.Random;

import com.google.common.collect.Maps;
import com.saxon564.mochickens.MoChickens;
import com.saxon564.mochickens.configs.DimensionConfigs;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFire;
import net.minecraft.block.BlockTNT;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BlockChickenFireBlock extends BlockFire {
	
	public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 15);
    public static final PropertyBool FLIP = PropertyBool.create("flip");
    public static final PropertyBool ALT = PropertyBool.create("alt");
    public static final PropertyBool NORTH = PropertyBool.create("north");
    public static final PropertyBool EAST = PropertyBool.create("east");
    public static final PropertyBool SOUTH = PropertyBool.create("south");
    public static final PropertyBool WEST = PropertyBool.create("west");
    public static final PropertyInteger UPPER = PropertyInteger.create("upper", 0, 2);

	boolean portal = false;
	
	public BlockChickenFireBlock() {
		super();
		setUnlocalizedName("chicken_fire");
		setDefaultState(this.blockState.getBaseState().withProperty(AGE, Integer.valueOf(0)).withProperty(FLIP, Boolean.valueOf(false)).withProperty(ALT, Boolean.valueOf(false)).withProperty(NORTH, Boolean.valueOf(false)).withProperty(EAST, Boolean.valueOf(false)).withProperty(SOUTH, Boolean.valueOf(false)).withProperty(WEST, Boolean.valueOf(false)).withProperty(UPPER, Integer.valueOf(0)));
	}
	
	public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
	
		if (!(world.provider.getDimensionId() == 0 || world.provider.getDimensionId() == DimensionConfigs.chickenDimId) || world.getBlockState(pos).getBlock() != MoChickens.blockFeatherBlock) {
			if (!world.doesBlockHaveSolidTopSurface(world, pos.down()) && !this.canNeighborCatchFire(world, pos)) {
				world.setBlockToAir(pos);
			} else {
				world.scheduleUpdate(pos, this, this.tickRate(world) + world.rand.nextInt(10));
				((BlockFeatherPortal)MoChickens.blockFeatherPortal).func_176548_d(world, pos);
			}
			
		}
	}
	
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (worldIn.getGameRules().getGameRuleBooleanValue("doFireTick"))
        {
            if (!this.canPlaceBlockAt(worldIn, pos))
            {
                worldIn.setBlockToAir(pos);
            }

            Block block = worldIn.getBlockState(pos.down()).getBlock();
            boolean flag = block.isFireSource(worldIn, pos.down(), EnumFacing.UP);

            if (!flag && worldIn.isRaining() && this.canDie(worldIn, pos))
            {
                worldIn.setBlockToAir(pos);
            }
            else
            {
                int i = ((Integer)state.getValue(AGE)).intValue();

                if (i < 15)
                {
                    state = state.withProperty(AGE, Integer.valueOf(i + rand.nextInt(3) / 2));
                    worldIn.setBlockState(pos, state, 4);
                }

                worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn) + rand.nextInt(10));

                if (!flag)
                {
                    if (!this.canNeighborCatchFire(worldIn, pos))
                    {
                        if (!World.doesBlockHaveSolidTopSurface(worldIn, pos.down()) || i > 3)
                        {
                            worldIn.setBlockToAir(pos);
                        }

                        return;
                    }

                    if (!this.canCatchFire(worldIn, pos.down(), EnumFacing.UP) && i == 15 && rand.nextInt(4) == 0)
                    {
                        worldIn.setBlockToAir(pos);
                        return;
                    }
                }

                boolean flag1 = worldIn.isBlockinHighHumidity(pos);
                byte b0 = 0;

                if (flag1)
                {
                    b0 = -50;
                }

                this.tryCatchFire(worldIn, pos.east(), 300 + b0, rand, i, EnumFacing.WEST);
                this.tryCatchFire(worldIn, pos.west(), 300 + b0, rand, i, EnumFacing.EAST);
                this.tryCatchFire(worldIn, pos.down(), 250 + b0, rand, i, EnumFacing.UP);
                this.tryCatchFire(worldIn, pos.up(), 250 + b0, rand, i, EnumFacing.DOWN);
                this.tryCatchFire(worldIn, pos.north(), 300 + b0, rand, i, EnumFacing.SOUTH);
                this.tryCatchFire(worldIn, pos.south(), 300 + b0, rand, i, EnumFacing.NORTH);

                for (int j = -1; j <= 1; ++j)
                {
                    for (int k = -1; k <= 1; ++k)
                    {
                        for (int l = -1; l <= 4; ++l)
                        {
                            if (j != 0 || l != 0 || k != 0)
                            {
                                int i1 = 100;

                                if (l > 1)
                                {
                                    i1 += (l - 1) * 100;
                                }

                                BlockPos blockpos1 = pos.add(j, l, k);
                                int j1 = this.getNeighborEncouragement(worldIn, blockpos1);

                                if (j1 > 0)
                                {
                                    int k1 = (j1 + 40 + worldIn.getDifficulty().getDifficultyId() * 7) / (i + 30);

                                    if (flag1)
                                    {
                                        k1 /= 2;
                                    }

                                    if (k1 > 0 && rand.nextInt(i1) <= k1 && (!worldIn.isRaining() || !this.canDie(worldIn, blockpos1)))
                                    {
                                        int l1 = i + rand.nextInt(5) / 4;

                                        if (l1 > 15)
                                        {
                                            l1 = 15;
                                        }

                                        worldIn.setBlockState(blockpos1, state.withProperty(AGE, Integer.valueOf(l1)), 3);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
	
	public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(AGE, Integer.valueOf(meta));
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state)
    {
        return ((Integer)state.getValue(AGE)).intValue();
    }
	
	private void tryCatchFire(World worldIn, BlockPos pos, int chance, Random random, int age, EnumFacing face)
    {
        int k = worldIn.getBlockState(pos).getBlock().getFlammability(worldIn, pos, face);

        if (random.nextInt(chance) < k)
        {
            IBlockState iblockstate = worldIn.getBlockState(pos);

            if (random.nextInt(age + 10) < 5 && !worldIn.canLightningStrike(pos))
            {
                int l = age + random.nextInt(5) / 4;

                if (l > 15)
                {
                    l = 15;
                }

                worldIn.setBlockState(pos, this.getDefaultState().withProperty(AGE, Integer.valueOf(l)), 3);
            }
            else
            {
                worldIn.setBlockToAir(pos);
            }

            if (iblockstate.getBlock() == Blocks.tnt)
            {
                Blocks.tnt.onBlockDestroyedByPlayer(worldIn, pos, iblockstate.withProperty(BlockTNT.EXPLODE, Boolean.valueOf(true)));
            }
        }
    }
	
	private boolean canNeighborCatchFire(World worldIn, BlockPos pos)
    {
        EnumFacing[] aenumfacing = EnumFacing.values();
        int i = aenumfacing.length;

        for (int j = 0; j < i; ++j)
        {
            EnumFacing enumfacing = aenumfacing[j];

            if (this.canCatchFire(worldIn, pos.offset(enumfacing), enumfacing.getOpposite()))
            {
                return true;
            }
        }

        return false;
    }
	
	private int getNeighborEncouragement(World worldIn, BlockPos pos)
    {
        if (!worldIn.isAirBlock(pos))
        {
            return 0;
        }
        else
        {
            int i = 0;
            EnumFacing[] aenumfacing = EnumFacing.values();
            int j = aenumfacing.length;

            for (int k = 0; k < j; ++k)
            {
                EnumFacing enumfacing = aenumfacing[k];
                i = Math.max(worldIn.getBlockState(pos.offset(enumfacing)).getBlock().getFlammability(worldIn, pos.offset(enumfacing), enumfacing.getOpposite()), i);
            }

            return i;
        }
    }
}
