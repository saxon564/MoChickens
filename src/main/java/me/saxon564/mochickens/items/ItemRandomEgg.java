package me.saxon564.mochickens.items;

import java.lang.reflect.InvocationTargetException;

import cpw.mods.fml.common.registry.EntityRegistry;
import me.saxon564.mochickens.MoChickens;
import me.saxon564.mochickens.MoChickensReference;
import me.saxon564.mochickens.entities.mobs.EntityMoChicken;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Facing;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.config.Configuration;

public class ItemRandomEgg extends Item {
	
	
	public ItemRandomEgg() {
		super();
		setMaxStackSize(64);
		setCreativeTab(MoChickens.moChickensTab);
		setUnlocalizedName("random_egg");
		setTextureName(MoChickensReference.MODID + ":"
				+ getUnlocalizedName().substring(5));
	}

	public boolean onItemUse(ItemStack par1ItemStack,
			EntityPlayer par2EntityPlayer, World par3World, int par4, int par5,
			int par6, int par7, float par8, float par9, float par10) {
		double d0 = 0.0D;

		if (par3World.isRemote) {
			return true;
		} else {
			Block i1 = par3World.getBlock(par4, par5, par6);
			par4 += Facing.offsetsXForSide[par7];
			par5 += Facing.offsetsYForSide[par7];
			par6 += Facing.offsetsZForSide[par7];

			if (par7 == 1 && i1 != null
					&& i1.getRenderType() == 11) {
				d0 = 0.5D;
			}

			if (!par2EntityPlayer.capabilities.isCreativeMode) {
				--par1ItemStack.stackSize;
			}

			float look = -par2EntityPlayer.rotationYaw;
			final int random = randomInt(0, MoChickens.eggNum);

			if (MoChickens.egg[random] != null) {
				Class type = MoChickens.egg[random];
				Configuration configs = MoChickens.configs[random];
				try {
					EntityLiving newEntity = (EntityLiving) type
							.getDeclaredConstructor(World.class).newInstance(
									par2EntityPlayer.worldObj);
					System.out.println(newEntity.toString());
					if (type.toString().equalsIgnoreCase("class net.minecraft.entity.passive.EntityBat")) {
						// prevent tying to age bat
					} else {
						((EntityMoChicken) newEntity).addVars(configs, type);
					   ((EntityAgeable) newEntity).setGrowingAge(-24000);
					}
					newEntity.setLocationAndAngles((double) par4 + 0.5D,
							(double) par5 + d0, (double) par6 + 0.5D,
							look, 0.0F);
					// newEntity.setTamed(true);
					par2EntityPlayer.worldObj.spawnEntityInWorld(newEntity);
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
