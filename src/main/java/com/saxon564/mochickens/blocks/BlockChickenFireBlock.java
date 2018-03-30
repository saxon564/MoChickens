package com.saxon564.mochickens.blocks;

import java.util.Map;
import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.collect.Maps;
import com.saxon564.mochickens.MoChickens;
import com.saxon564.mochickens.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFire;
import net.minecraft.block.BlockTNT;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockChickenFireBlock extends Block {
	
	public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 15);
    public static final PropertyBool NORTH = PropertyBool.create("north");
    public static final PropertyBool EAST = PropertyBool.create("east");
    public static final PropertyBool SOUTH = PropertyBool.create("south");
    public static final PropertyBool WEST = PropertyBool.create("west");
    public static final PropertyBool UPPER = PropertyBool.create("upper");
    private final Map encouragements = Maps.newIdentityHashMap();
    private final Map flammabilities = Maps.newIdentityHashMap();

	boolean portal = false;
	
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {

        if (!worldIn.getBlockState(pos.down()).isOpaqueCube() && !((BlockChickenFireBlock) MoChickens.chicken_fire).canCatchFire(worldIn, pos.down(), EnumFacing.UP))
        {
        	return state.withProperty(NORTH, this.canCatchFire(worldIn, pos.north(), EnumFacing.SOUTH))
                    .withProperty(EAST,  this.canCatchFire(worldIn, pos.east(), EnumFacing.WEST))
                    .withProperty(SOUTH, this.canCatchFire(worldIn, pos.south(), EnumFacing.NORTH))
                    .withProperty(WEST,  this.canCatchFire(worldIn, pos.west(), EnumFacing.EAST))
                    .withProperty(UPPER, this.canCatchFire(worldIn, pos.up(), EnumFacing.DOWN));
        }
        else
        {
            return this.getDefaultState();
        }
    }
	
	public BlockChickenFireBlock() {
		super(Material.FIRE);
        this.setRegistryName(new ResourceLocation(Reference.MOD_ID, "chicken_fire"));
		setUnlocalizedName("chicken_fire");
		setDefaultState(this.blockState.getBaseState().withProperty(AGE, Integer.valueOf(0)).withProperty(NORTH, Boolean.valueOf(false)).withProperty(EAST, Boolean.valueOf(false)).withProperty(SOUTH, Boolean.valueOf(false)).withProperty(WEST, Boolean.valueOf(false)).withProperty(UPPER, false));
		setTickRandomly(true);
		setLightLevel(0.8F);
	}
	
	public static void init()
    {
        ((BlockChickenFireBlock) MoChickens.chicken_fire).setFireInfo(Blocks.PLANKS, 5, 20);
        ((BlockChickenFireBlock) MoChickens.chicken_fire).setFireInfo(Blocks.DOUBLE_WOODEN_SLAB, 5, 20);
        ((BlockChickenFireBlock) MoChickens.chicken_fire).setFireInfo(Blocks.WOODEN_SLAB, 5, 20);
        ((BlockChickenFireBlock) MoChickens.chicken_fire).setFireInfo(Blocks.OAK_FENCE_GATE, 5, 20);
        ((BlockChickenFireBlock) MoChickens.chicken_fire).setFireInfo(Blocks.SPRUCE_FENCE_GATE, 5, 20);
        ((BlockChickenFireBlock) MoChickens.chicken_fire).setFireInfo(Blocks.BIRCH_FENCE_GATE, 5, 20);
        ((BlockChickenFireBlock) MoChickens.chicken_fire).setFireInfo(Blocks.JUNGLE_FENCE_GATE, 5, 20);
        ((BlockChickenFireBlock) MoChickens.chicken_fire).setFireInfo(Blocks.DARK_OAK_FENCE_GATE, 5, 20);
        ((BlockChickenFireBlock) MoChickens.chicken_fire).setFireInfo(Blocks.ACACIA_FENCE_GATE, 5, 20);
        ((BlockChickenFireBlock) MoChickens.chicken_fire).setFireInfo(Blocks.OAK_FENCE, 5, 20);
        ((BlockChickenFireBlock) MoChickens.chicken_fire).setFireInfo(Blocks.SPRUCE_FENCE, 5, 20);
        ((BlockChickenFireBlock) MoChickens.chicken_fire).setFireInfo(Blocks.BIRCH_FENCE, 5, 20);
        ((BlockChickenFireBlock) MoChickens.chicken_fire).setFireInfo(Blocks.JUNGLE_FENCE, 5, 20);
        ((BlockChickenFireBlock) MoChickens.chicken_fire).setFireInfo(Blocks.DARK_OAK_FENCE, 5, 20);
        ((BlockChickenFireBlock) MoChickens.chicken_fire).setFireInfo(Blocks.ACACIA_FENCE, 5, 20);
        ((BlockChickenFireBlock) MoChickens.chicken_fire).setFireInfo(Blocks.OAK_STAIRS, 5, 20);
        ((BlockChickenFireBlock) MoChickens.chicken_fire).setFireInfo(Blocks.BIRCH_STAIRS, 5, 20);
        ((BlockChickenFireBlock) MoChickens.chicken_fire).setFireInfo(Blocks.SPRUCE_STAIRS, 5, 20);
        ((BlockChickenFireBlock) MoChickens.chicken_fire).setFireInfo(Blocks.JUNGLE_STAIRS, 5, 20);
        ((BlockChickenFireBlock) MoChickens.chicken_fire).setFireInfo(Blocks.LOG, 5, 5);
        ((BlockChickenFireBlock) MoChickens.chicken_fire).setFireInfo(Blocks.LOG2, 5, 5);
        ((BlockChickenFireBlock) MoChickens.chicken_fire).setFireInfo(Blocks.LEAVES, 30, 60);
        ((BlockChickenFireBlock) MoChickens.chicken_fire).setFireInfo(Blocks.LEAVES2, 30, 60);
        ((BlockChickenFireBlock) MoChickens.chicken_fire).setFireInfo(Blocks.BOOKSHELF, 30, 20);
        ((BlockChickenFireBlock) MoChickens.chicken_fire).setFireInfo(Blocks.TNT, 15, 100);
        ((BlockChickenFireBlock) MoChickens.chicken_fire).setFireInfo(Blocks.TALLGRASS, 60, 100);
        ((BlockChickenFireBlock) MoChickens.chicken_fire).setFireInfo(Blocks.DOUBLE_PLANT, 60, 100);
        ((BlockChickenFireBlock) MoChickens.chicken_fire).setFireInfo(Blocks.YELLOW_FLOWER, 60, 100);
        ((BlockChickenFireBlock) MoChickens.chicken_fire).setFireInfo(Blocks.RED_FLOWER, 60, 100);
        ((BlockChickenFireBlock) MoChickens.chicken_fire).setFireInfo(Blocks.DEADBUSH, 60, 100);
        ((BlockChickenFireBlock) MoChickens.chicken_fire).setFireInfo(Blocks.WOOL, 30, 60);
        ((BlockChickenFireBlock) MoChickens.chicken_fire).setFireInfo(Blocks.VINE, 15, 100);
        ((BlockChickenFireBlock) MoChickens.chicken_fire).setFireInfo(Blocks.COAL_BLOCK, 5, 5);
        ((BlockChickenFireBlock) MoChickens.chicken_fire).setFireInfo(Blocks.HAY_BLOCK, 60, 20);
        ((BlockChickenFireBlock) MoChickens.chicken_fire).setFireInfo(Blocks.CARPET, 60, 20);
    }
	
	public void setFireInfo(Block blockIn, int encouragement, int flammability)
    {
        if (blockIn == Blocks.AIR) throw new IllegalArgumentException("Tried to set air on fire... This is bad.");
        this.encouragements.put(blockIn, Integer.valueOf(encouragement));
        this.flammabilities.put(blockIn, Integer.valueOf(flammability));
    }
	
	@Nullable
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        return NULL_AABB;
    }

	public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random random)
    {
        return 0;
    }

    /**
     * How many world ticks before ticking
     */
    public int tickRate(World worldIn)
    {
        return 30;
    }
    
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (worldIn.getGameRules().getBoolean("doFireTick"))
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
                        if (!worldIn.getBlockState(pos.down()).isOpaqueCube() || i > 3)
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

    protected boolean canDie(World worldIn, BlockPos pos)
    {
        return worldIn.isRainingAt(pos) || worldIn.isRainingAt(pos.west()) || worldIn.isRainingAt(pos.east()) || worldIn.isRainingAt(pos.north()) || worldIn.isRainingAt(pos.south());
    }

    public boolean requiresUpdates()
    {
        return false;
    }
	
    private void tryCatchFire(World worldIn, BlockPos pos, int chance, Random random, int age, EnumFacing face)
    {
        int i = worldIn.getBlockState(pos).getBlock().getFlammability(worldIn, pos, face);

        if (random.nextInt(chance) < i)
        {
            IBlockState iblockstate = worldIn.getBlockState(pos);

            if (random.nextInt(age + 10) < 5 && !worldIn.isRainingAt(pos))
            {
                int j = age + random.nextInt(5) / 4;

                if (j > 15)
                {
                    j = 15;
                }

                worldIn.setBlockState(pos, this.getDefaultState().withProperty(AGE, Integer.valueOf(j)), 3);
            }
            else
            {
                worldIn.setBlockToAir(pos);
            }

            if (iblockstate.getBlock() == Blocks.TNT)
            {
                Blocks.TNT.onBlockDestroyedByPlayer(worldIn, pos, iblockstate.withProperty(BlockTNT.EXPLODE, Boolean.valueOf(true)));
            }
        }
    }
	
    private boolean canNeighborCatchFire(World worldIn, BlockPos pos)
    {
        for (EnumFacing enumfacing : EnumFacing.values())
        {
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

            for (EnumFacing enumfacing : EnumFacing.values())
            {
                i = Math.max(worldIn.getBlockState(pos.offset(enumfacing)).getBlock().getFireSpreadSpeed(worldIn, pos.offset(enumfacing), enumfacing.getOpposite()), i);
            }

            return i;
        }
    }
	
	public boolean isCollidable()
    {
        return false;
    }

    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        return worldIn.getBlockState(pos.down()).isOpaqueCube() || this.canNeighborCatchFire(worldIn, pos);
    }

    /**
     * Called when a neighboring block changes.
     */
    public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
    {
        if (!worldIn.getBlockState(pos.down()).isOpaqueCube() && !this.canNeighborCatchFire(worldIn, pos))
        {
            worldIn.setBlockToAir(pos);
        }
    }
    
	public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
	
		/*if (!(world.provider.getDimensionId() == 0 || world.provider.getDimensionId() == DimensionConfigs.chickenDimId) || world.getBlockState(pos).getBlock() != MoChickens.feather_block) {
			if (!world.doesBlockHaveSolidTopSurface(world, pos.down()) && !this.canNeighborCatchFire(world, pos)) {
				world.setBlockToAir(pos);
			} else {
				world.scheduleUpdate(pos, this, this.tickRate(world) + world.rand.nextInt(10));
				((BlockFeatherPortal)MoChickens.feather_portal).func_176548_d(world, pos);
			}
			
		}*/
	}
	
	@SideOnly(Side.CLIENT)
    public void randomDisplayTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (rand.nextInt(24) == 0)
        {
            worldIn.playSound((double)((float)pos.getX() + 0.5F), (double)((float)pos.getY() + 0.5F), (double)((float)pos.getZ() + 0.5F), SoundEvents.BLOCK_FIRE_AMBIENT, SoundCategory.BLOCKS, 1.0F + rand.nextFloat(), rand.nextFloat() * 0.7F + 0.3F, false);
        }

        int i;
        double d0;
        double d1;
        double d2;

        if (!worldIn.getBlockState(pos.down()).isSideSolid(worldIn, pos.down(), EnumFacing.UP) && !((BlockChickenFireBlock) MoChickens.chicken_fire).canCatchFire(worldIn, pos.down(), EnumFacing.UP))
        {
            if (((BlockChickenFireBlock) MoChickens.chicken_fire).canCatchFire(worldIn, pos.west(), EnumFacing.EAST))
            {
                for (i = 0; i < 2; ++i)
                {
                    d0 = (double)pos.getX() + rand.nextDouble() * 0.10000000149011612D;
                    d1 = (double)pos.getY() + rand.nextDouble();
                    d2 = (double)pos.getZ() + rand.nextDouble();
                    worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, d0, d1, d2, 0.0D, 0.0D, 0.0D, new int[0]);
                }
            }

            if (((BlockChickenFireBlock) MoChickens.chicken_fire).canCatchFire(worldIn, pos.east(), EnumFacing.WEST))
            {
                for (i = 0; i < 2; ++i)
                {
                    d0 = (double)(pos.getX() + 1) - rand.nextDouble() * 0.10000000149011612D;
                    d1 = (double)pos.getY() + rand.nextDouble();
                    d2 = (double)pos.getZ() + rand.nextDouble();
                    worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, d0, d1, d2, 0.0D, 0.0D, 0.0D, new int[0]);
                }
            }

            if (((BlockChickenFireBlock) MoChickens.chicken_fire).canCatchFire(worldIn, pos.north(), EnumFacing.SOUTH))
            {
                for (i = 0; i < 2; ++i)
                {
                    d0 = (double)pos.getX() + rand.nextDouble();
                    d1 = (double)pos.getY() + rand.nextDouble();
                    d2 = (double)pos.getZ() + rand.nextDouble() * 0.10000000149011612D;
                    worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, d0, d1, d2, 0.0D, 0.0D, 0.0D, new int[0]);
                }
            }

            if (((BlockChickenFireBlock) MoChickens.chicken_fire).canCatchFire(worldIn, pos.south(), EnumFacing.NORTH))
            {
                for (i = 0; i < 2; ++i)
                {
                    d0 = (double)pos.getX() + rand.nextDouble();
                    d1 = (double)pos.getY() + rand.nextDouble();
                    d2 = (double)(pos.getZ() + 1) - rand.nextDouble() * 0.10000000149011612D;
                    worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, d0, d1, d2, 0.0D, 0.0D, 0.0D, new int[0]);
                }
            }

            if (((BlockChickenFireBlock) MoChickens.chicken_fire).canCatchFire(worldIn, pos.up(), EnumFacing.DOWN))
            {
                for (i = 0; i < 2; ++i)
                {
                    d0 = (double)pos.getX() + rand.nextDouble();
                    d1 = (double)(pos.getY() + 1) - rand.nextDouble() * 0.10000000149011612D;
                    d2 = (double)pos.getZ() + rand.nextDouble();
                    worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, d0, d1, d2, 0.0D, 0.0D, 0.0D, new int[0]);
                }
            }
        }
        else
        {
            for (i = 0; i < 3; ++i)
            {
                d0 = (double)pos.getX() + rand.nextDouble();
                d1 = (double)pos.getY() + rand.nextDouble() * 0.5D + 0.5D;
                d2 = (double)pos.getZ() + rand.nextDouble();
                worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, d0, d1, d2, 0.0D, 0.0D, 0.0D, new int[0]);
            }
        }
    }

    /**
     * Get the MapColor for this Block and the given BlockState
     */
    public MapColor getMapColor(IBlockState state)
    {
        return MapColor.TNT;
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
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

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {AGE, NORTH, EAST, SOUTH, WEST, UPPER});
    }

    public boolean canCatchFire(IBlockAccess world, BlockPos pos, EnumFacing face)
    {
        return world.getBlockState(pos).getBlock().isFlammable(world, pos, face);
    }
}
