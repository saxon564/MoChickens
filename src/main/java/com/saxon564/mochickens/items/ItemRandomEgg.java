package com.saxon564.mochickens.items;

import com.saxon564.mochickens.MoChickens;
import com.saxon564.mochickens.entities.mobs.EntityMoChicken;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.tileentity.MobSpawnerTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.spawner.AbstractSpawner;

public class ItemRandomEgg extends Item {
	
	
	public ItemRandomEgg(Item.Properties builder) {
		super(builder);
	}

	public ActionResultType onItemUse(ItemUseContext context) {
		World world = context.getWorld();
		PlayerEntity player = context.getPlayer();
		BlockPos pos = context.getPos();
		Direction facing = context.getFace();
		ItemStack itemstack = player.getHeldItem(context.getHand());
		
		if (world.isRemote)
        {
            return ActionResultType.SUCCESS;
        }
        else if (!player.canPlayerEdit(pos.offset(facing), facing, itemstack))
        {
            return ActionResultType.FAIL;
        }
        else
        {
            BlockState iblockstate = world.getBlockState(pos);
			final int random = randomInt(0, MoChickens.eggNum);
			EntityType<?> type = MoChickens.egg[random];
            
            if (iblockstate.getBlock() == Blocks.SPAWNER)
            {
                TileEntity tileentity = world.getTileEntity(pos);

                if (tileentity instanceof MobSpawnerTileEntity)
                {
                    AbstractSpawner mobspawnerbaselogic = ((MobSpawnerTileEntity)tileentity).getSpawnerBaseLogic();
                    mobspawnerbaselogic.setEntityType(type);
                    tileentity.markDirty();
                    world.notifyNeighbors(pos, tileentity.getBlockState().getBlock());

                    if (!player.isCreative())
                    {
                    	itemstack.setCount(itemstack.getCount() - 1);
                    }

                    return ActionResultType.SUCCESS;
                }
            }
            
			pos = pos.offset(facing);
			double d0 = 0.0D;

            if (facing == Direction.UP && iblockstate.getBlock() instanceof FenceBlock)
            {
                d0 = 0.5D;
            }

			if (!player.isCreative()) {
				itemstack.setCount(itemstack.getCount() - 1);
			}

			if (MoChickens.egg[random] != null) {
				Class<?> configs = MoChickens.configs[random];
				try {
					LivingEntity newEntity = (LivingEntity) type.create(world);
					if (type.toString().equalsIgnoreCase("class net.minecraft.entity.passive.EntityBat")) {
						// prevent tying to age bat
					} else {
						((EntityMoChicken) newEntity).setupConfigVariables(configs, type);
					   ((AgeableEntity) newEntity).setGrowingAge(-24000);
					}
					newEntity.setLocationAndAngles((double)pos.getX() + 0.5D, (double)pos.getY() + d0, (double)pos.getZ() + 0.5D, MathHelper.wrapDegrees(world.rand.nextFloat() * 360.0F), 0.0F);
					// newEntity.setTamed(true);
					world.addEntity(newEntity);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				}
			}
		}

		return ActionResultType.FAIL;
	}
	
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn)
    {
		System.out.println("Right Clicked!");
        ItemStack itemstack = playerIn.getHeldItem(handIn);

        if (worldIn.isRemote)
        {
			System.out.println("Remote!");
            return new ActionResult<ItemStack>(ActionResultType.PASS, itemstack);
        }
        else
        {
            RayTraceResult raytraceresult = ItemRandomEgg.rayTrace(worldIn, playerIn, RayTraceContext.FluidMode.ANY);

            if (raytraceresult != null && raytraceresult.getType() == RayTraceResult.Type.BLOCK)
            {
				System.out.println("It's a Block!");
				Vec3d vec = raytraceresult.getHitVec();
                BlockPos blockpos = new BlockPos(vec.x, vec.y, vec.z);

                if (!(worldIn.getBlockState(blockpos).getBlock() instanceof FlowingFluidBlock))
                {
					System.out.println("It Isn't a Liquid!");
                	double d0 = 0.0D;

        			if (!playerIn.isCreative()) {
    					System.out.println("Not in Creative!");
        				itemstack.setCount(itemstack.getCount() - 1);
        			}

        			final int random = randomInt(0, MoChickens.eggNum);
        			EntityType<?> type = MoChickens.egg[random];
        			if (type != null) {
        				Class<?> configs = MoChickens.configs[random];
        				try {
        					LivingEntity newEntity = (LivingEntity) type.create(worldIn);
        					if (type.toString().equalsIgnoreCase("class net.minecraft.entity.passive.EntityBat")) {
        						// prevent tying to age bat
        					} else {
        						((EntityMoChicken) newEntity).setupConfigVariables(configs, type);
        					   ((AgeableEntity) newEntity).setGrowingAge(-24000);
        					   //((EntityMoChicken) newEntity).setTamed(true);
        					}
        					newEntity.setLocationAndAngles((double)blockpos.getX() + 0.5D, (double)blockpos.up().getY() + d0, (double)blockpos.getZ() + 0.5D, MathHelper.wrapDegrees(worldIn.rand.nextFloat() * 360.0F), 0.0F);
        					worldIn.addEntity(newEntity);
        				} catch (IllegalArgumentException e) {
        					e.printStackTrace();
        				} catch (SecurityException e) {
        					e.printStackTrace();
        				}
        			}
        			return new ActionResult<ItemStack>(ActionResultType.PASS, itemstack);
                }
                else
                {
					System.out.println("Skipped Spawn Process!");
                    return new ActionResult<ItemStack>(ActionResultType.FAIL, itemstack);
                }
            }
            else
            {
                return new ActionResult<ItemStack>(ActionResultType.PASS, itemstack);
            }
        }
    }

	public static int randomInt(int low, int high) {
		int result = (int) (Math.random() * (high - low + 1)) + low;
		return result;
	}
}
