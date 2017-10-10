package com.saxon564.mochickens.items;

import java.lang.reflect.InvocationTargetException;

import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.common.config.Configuration;

import com.saxon564.mochickens.MoChickens;
import com.saxon564.mochickens.Reference;
import com.saxon564.mochickens.entities.mobs.EntityMoChicken;

public class ItemRandomEgg extends Item {
	
	
	public ItemRandomEgg() {
		super();
		setMaxStackSize(64);
		setCreativeTab(MoChickens.moChickensTab);
        this.setRegistryName(new ResourceLocation(Reference.MOD_ID, "random_egg"));
		setUnlocalizedName("random_egg");
	}

	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
		if (worldIn.isRemote)
        {
            return EnumActionResult.SUCCESS;
        }
        else if (!playerIn.canPlayerEdit(pos.offset(side), side, stack))
        {
            return EnumActionResult.FAIL;
        }
        else
        {
            IBlockState iblockstate = worldIn.getBlockState(pos);
			final int random = randomInt(0, MoChickens.eggNum);
			Class type = MoChickens.egg[random];
            
            if (iblockstate.getBlock() == Blocks.MOB_SPAWNER)
            {
                TileEntity tileentity = worldIn.getTileEntity(pos);

                if (tileentity instanceof TileEntityMobSpawner)
                {
                    MobSpawnerBaseLogic mobspawnerbaselogic = ((TileEntityMobSpawner)tileentity).getSpawnerBaseLogic();
                    mobspawnerbaselogic.setEntityId(new ResourceLocation(type.getName()));
                    tileentity.markDirty();
                    worldIn.markBlockRangeForRenderUpdate(pos, pos);;

                    if (!playerIn.capabilities.isCreativeMode)
                    {
                        stack.setCount(stack.getCount() - 1);
                    }

                    return EnumActionResult.SUCCESS;
                }
            }
            
			pos = pos.offset(side);
			double d0 = 0.0D;

            if (side == EnumFacing.UP && iblockstate instanceof BlockFence)
            {
                d0 = 0.5D;
            }

			if (!playerIn.capabilities.isCreativeMode) {
				stack.setCount(stack.getCount() - 1);
			}

			float look = -playerIn.rotationYaw;
			if (MoChickens.egg[random] != null) {
				Configuration configs = MoChickens.configs[random];
				try {
					EntityLiving newEntity = (EntityLiving) type
							.getDeclaredConstructor(World.class).newInstance(
									worldIn);
					if (type.toString().equalsIgnoreCase("class net.minecraft.entity.passive.EntityBat")) {
						// prevent tying to age bat
					} else {
						((EntityMoChicken) newEntity).setupConfigVariables(configs, type);
					   ((EntityAgeable) newEntity).setGrowingAge(-24000);
					}
					newEntity.setLocationAndAngles((double)pos.getX() + 0.5D, (double)pos.getY() + d0, (double)pos.getZ() + 0.5D, MathHelper.wrapDegrees(worldIn.rand.nextFloat() * 360.0F), 0.0F);
					// newEntity.setTamed(true);
					worldIn.spawnEntity(newEntity);
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				}
			}
		}

		return EnumActionResult.FAIL;
	}
	
	/*public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World worldIn, EntityPlayer player)
    {
        if (worldIn.isRemote)
        {
            return new ActionResult(EnumActionResult.PASS, stack);
        }
        else
        {
            RayTraceResult movingobjectposition = this.rayTrace(worldIn, player, true);

            if (movingobjectposition == null)
            {
            	return new ActionResult(EnumActionResult.FAIL, stack);
            }
            else
            {
                if (movingobjectposition.typeOfHit == RayTraceResult.Type.BLOCK)
                {
                    BlockPos blockpos = movingobjectposition.getBlockPos();

                    if (!worldIn.isBlockModifiable(player, blockpos))
                    {
                        return stack;
                    }

                    if (!player.canPlayerEdit(blockpos, movingobjectposition.sideHit, stack))
                    {
                        return stack;
                    }

                    if (worldIn.getBlockState(blockpos).getBlock() instanceof BlockLiquid)
                    {
            			double d0 = 0.0D;

            			if (!player.capabilities.isCreativeMode) {
            				stack.setCount(stack.getCount() - 1);
            			}

            			float look = -player.rotationYaw;
            			final int random = randomInt(0, MoChickens.eggNum);
            			Class type = MoChickens.egg[random];
            			if (MoChickens.egg[random] != null) {
            				Configuration configs = MoChickens.configs[random];
            				try {
            					EntityLiving newEntity = (EntityLiving) type
            							.getDeclaredConstructor(World.class).newInstance(
            									worldIn);
            					if (type.toString().equalsIgnoreCase("class net.minecraft.entity.passive.EntityBat")) {
            						// prevent tying to age bat
            					} else {
            						((EntityMoChicken) newEntity).addVars(configs, type);
            					   ((EntityAgeable) newEntity).setGrowingAge(-24000);
            					}
            					newEntity.setLocationAndAngles((double)blockpos.getX() + 0.5D, (double)blockpos.getY() + d0, (double)blockpos.getZ() + 0.5D, MathHelper.wrapDegrees(worldIn.rand.nextFloat() * 360.0F), 0.0F);
            					// newEntity.setTamed(true);
            					worldIn.spawnEntity(newEntity);
            				} catch (InstantiationException e) {
            					e.printStackTrace();
            				} catch (IllegalAccessException e) {
            					e.printStackTrace();
            				} catch (IllegalArgumentException e) {
            					e.printStackTrace();
            				} catch (InvocationTargetException e) {
            					e.printStackTrace();
            				} catch (NoSuchMethodException e) {
            					e.printStackTrace();
            				} catch (SecurityException e) {
            					e.printStackTrace();
            				}
            			}
                    }
                }

                return stack;
            }
        }
    }*/
	
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
		System.out.println("Right Clicked!");
        ItemStack itemstack = playerIn.getHeldItem(handIn);

        if (worldIn.isRemote)
        {
			System.out.println("Remote!");
            return new ActionResult(EnumActionResult.PASS, itemstack);
        }
        else
        {
            RayTraceResult raytraceresult = this.rayTrace(worldIn, playerIn, true);

            if (raytraceresult != null && raytraceresult.typeOfHit == RayTraceResult.Type.BLOCK)
            {
				System.out.println("It's a Block!");
                BlockPos blockpos = raytraceresult.getBlockPos();

                if (!(worldIn.getBlockState(blockpos).getBlock() instanceof BlockLiquid))
                {
					System.out.println("It Isn't a Liquid!");
                	double d0 = 0.0D;

        			if (!playerIn.capabilities.isCreativeMode) {
    					System.out.println("Not in Creative!");
        				itemstack.setCount(itemstack.getCount() - 1);
        			}

        			float look = -playerIn.rotationYaw;
        			final int random = randomInt(0, MoChickens.eggNum);
        			Class type = MoChickens.egg[random];
        			if (type != null) {
        				Configuration configs = MoChickens.configs[random];
    					System.out.println("Before Try!");
        				try {
        					System.out.println("Inside Try!");
        					EntityLiving newEntity = (EntityLiving) type
        							.getDeclaredConstructor(World.class).newInstance(
        									worldIn);
        					if (type.toString().equalsIgnoreCase("class net.minecraft.entity.passive.EntityBat")) {
        						// prevent tying to age bat
        					} else {
        						((EntityMoChicken) newEntity).setupConfigVariables(configs, type);
        					   ((EntityAgeable) newEntity).setGrowingAge(-24000);
        					}
        					newEntity.setLocationAndAngles((double)blockpos.getX() + 0.5D, (double)blockpos.getY() + d0, (double)blockpos.getZ() + 0.5D, MathHelper.wrapDegrees(worldIn.rand.nextFloat() * 360.0F), 0.0F);
        					// newEntity.setTamed(true);
        					worldIn.spawnEntity(newEntity);
        				} catch (InstantiationException e) {
        					e.printStackTrace();
        				} catch (IllegalAccessException e) {
        					e.printStackTrace();
        				} catch (IllegalArgumentException e) {
        					e.printStackTrace();
        				} catch (InvocationTargetException e) {
        					e.printStackTrace();
        				} catch (NoSuchMethodException e) {
        					e.printStackTrace();
        				} catch (SecurityException e) {
        					e.printStackTrace();
        				}
    					System.out.println("After Try!");
        			}
					System.out.println("Failed Spawn Process!");
        			return new ActionResult(EnumActionResult.PASS, itemstack);
                }
                else
                {
					System.out.println("Skipped Spawn Process!");
                    return new ActionResult(EnumActionResult.FAIL, itemstack);
                }
            }
            else
            {
                return new ActionResult(EnumActionResult.PASS, itemstack);
            }
        }
    }

	public static int randomInt(int low, int high) {
		int result = (int) (Math.random() * (high - low + 1)) + low;
		return result;
	}
}
