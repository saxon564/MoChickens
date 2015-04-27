package com.saxon564.mochickens.items;

import java.lang.reflect.InvocationTargetException;

import com.saxon564.mochickens.MoChickens;
import com.saxon564.mochickens.MoChickensReference;
import com.saxon564.mochickens.entities.mobs.EntityMoChicken;

import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Facing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.config.Configuration;

public class ItemRandomEgg extends Item {
	
	
	public ItemRandomEgg() {
		super();
		setMaxStackSize(64);
		setCreativeTab(MoChickens.moChickensTab);
		setUnlocalizedName("random_egg");
		//setTextureName(MoChickensReference.MODID + ":"
		//		+ getUnlocalizedName().substring(5));
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
            
            if (iblockstate.getBlock() == Blocks.mob_spawner)
            {
                TileEntity tileentity = worldIn.getTileEntity(pos);

                if (tileentity instanceof TileEntityMobSpawner)
                {
                    MobSpawnerBaseLogic mobspawnerbaselogic = ((TileEntityMobSpawner)tileentity).getSpawnerBaseLogic();
                    mobspawnerbaselogic.setEntityName(type.getName());
                    tileentity.markDirty();
                    worldIn.markBlockForUpdate(pos);

                    if (!playerIn.capabilities.isCreativeMode)
                    {
                        --stack.stackSize;
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
				--stack.stackSize;
			}

			float look = -playerIn.rotationYaw;

			if (MoChickens.egg[random] != null) {
				Configuration configs = MoChickens.configs[random];
				try {
					EntityLiving newEntity = (EntityLiving) type
							.getDeclaredConstructor(World.class).newInstance(
									playerIn.worldObj);
					//System.out.println(newEntity.toString());
					if (type.toString().equalsIgnoreCase("class net.minecraft.entity.passive.EntityBat")) {
						// prevent tying to age bat
					} else {
						((EntityMoChicken) newEntity).addVars(configs, type);
					   ((EntityAgeable) newEntity).setGrowingAge(-24000);
					}
					newEntity.setLocationAndAngles((double)pos.getX() + 0.5D, (double)pos.getX() + d0, (double)pos.getZ() + 0.5D, MathHelper.wrapAngleTo180_float(worldIn.rand.nextFloat() * 360.0F), 0.0F);
					// newEntity.setTamed(true);
					playerIn.worldObj.spawnEntityInWorld(newEntity);
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

	public static int randomInt(int low, int high) {
		int result = (int) (Math.random() * (high - low + 1)) + low;
		return result;
	}
}
