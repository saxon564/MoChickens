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
import net.minecraft.util.EnumFacing;
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

	public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
		if (worldIn.isRemote)
        {
            return true;
        }
        else if (!playerIn.canPlayerEdit(pos.offset(side), side, stack))
        {
            return false;
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

                    return true;
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
						((EntityMoChicken) newEntity).addVars(configs, type);
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

		return false;
	}
	
	public ItemStack onItemRightClick(ItemStack stack, World worldIn, EntityPlayer player)
    {
        if (worldIn.isRemote)
        {
            return stack;
        }
        else
        {
            RayTraceResult movingobjectposition = this.rayTrace(worldIn, player, true);

            if (movingobjectposition == null)
            {
                return stack;
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
    }

	public static int randomInt(int low, int high) {
		int result = (int) (Math.random() * (high - low + 1)) + low;
		return result;
	}
}
