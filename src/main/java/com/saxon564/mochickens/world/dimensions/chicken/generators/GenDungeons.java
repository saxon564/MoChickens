package com.saxon564.mochickens.world.dimensions.chicken.generators;

import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.WeightedRandom;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenDungeons;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.common.DungeonHooks;

public class GenDungeons
{
   
    public boolean generate(World world, Random rand, int z, int y, int j2)
    {
        byte b0 = 3;
        int l = rand.nextInt(2) + 2;
        int i1 = rand.nextInt(2) + 2;
        int j1 = 0;
        int k1;
        int l1;
        int i2;

        for (k1 = z - l - 1; k1 <= z + l + 1; ++k1)
        {
            for (l1 = y - 1; l1 <= y + b0 + 1; ++l1)
            {
                for (i2 = j2 - i1 - 1; i2 <= j2 + i1 + 1; ++i2)
                {
                    Material material = world.getBlockState(new BlockPos(k1, l1, i2)).getMaterial();

                    if (l1 == y - 1 && !material.isSolid())
                    {
                        return false;
                    }

                    if (l1 == y + b0 + 1 && !material.isSolid())
                    {
                        return false;
                    }

                    if ((k1 == z - l - 1 || k1 == z + l + 1 || i2 == j2 - i1 - 1 || i2 == j2 + i1 + 1) && l1 == y && world.isAirBlock(new BlockPos(k1, l1, i2)) && world.isAirBlock(new BlockPos(k1, l1 + 1, i2)))
                    {
                        ++j1;
                    }
                }
            }
        }

        if (j1 >= 1 && j1 <= 5)
        {
            for (k1 = z - l - 1; k1 <= z + l + 1; ++k1)
            {
                for (l1 = y + b0; l1 >= y - 1; --l1)
                {
                    for (i2 = j2 - i1 - 1; i2 <= j2 + i1 + 1; ++i2)
                    {
                        if (k1 != z - l - 1 && l1 != y - 1 && i2 != j2 - i1 - 1 && k1 != z + l + 1 && l1 != y + b0 + 1 && i2 != j2 + i1 + 1)
                        {
                            world.setBlockToAir(new BlockPos(k1, l1, i2));
                        }
                        else if (l1 >= 0 && !world.getBlockState(new BlockPos(k1, l1 - 1, i2)).getMaterial().isSolid())
                        {
                            world.setBlockToAir(new BlockPos(k1, l1, i2));
                        }
                        else if (world.getBlockState(new BlockPos(k1, l1, i2)).getMaterial().isSolid())
                        {
                            if (l1 == y - 1 && rand.nextInt(4) != 0)
                            {
                                world.setBlockState(new BlockPos(k1, l1, i2), Blocks.MOSSY_COBBLESTONE.getDefaultState());
                            }
                            else
                            {
                                world.setBlockState(new BlockPos(k1, l1, i2), Blocks.COBBLESTONE.getDefaultState());
                            }
                        }
                    }
                }
            }

            k1 = 0;

            while (k1 < 2)
            {
                l1 = 0;

                while (true)
                {
                    if (l1 < 3)
                    {
                        label101:
                        {
                            i2 = z + rand.nextInt(l * 2 + 1) - l;
                            int j3 = j2 + rand.nextInt(i1 * 2 + 1) - i1;

                            if (world.isAirBlock(new BlockPos(i2, y, j3)))
                            {
                                int k2 = 0;

                                if (world.getBlockState(new BlockPos(i2 - 1, y, j3)).getMaterial().isSolid())
                                {
                                    ++k2;
                                }

                                if (world.getBlockState(new BlockPos(i2 + 1, y, j3)).getMaterial().isSolid())
                                {
                                    ++k2;
                                }

                                if (world.getBlockState(new BlockPos(i2, y, j3 - 1)).getMaterial().isSolid())
                                {
                                    ++k2;
                                }

                                if (world.getBlockState(new BlockPos(i2, y, j3 + 1)).getMaterial().isSolid())
                                {
                                    ++k2;
                                }

                                if (k2 == 1)
                                {
                                    world.setBlockState(new BlockPos(i2, y, j3), Blocks.CHEST.getDefaultState());
                                    TileEntity tileentitychest = world.getTileEntity(new BlockPos(i2, y, j3));

                                    if (tileentitychest != null)
                                    {
                                    	((TileEntityChest)tileentitychest).setLootTable(LootTableList.CHESTS_SIMPLE_DUNGEON, rand.nextLong());
                                    }
                                    //System.out.println("Dungeon " + i2 + " " + y + " " + j3);
                                    break label101;
                                }
                            }

                            ++l1;
                            continue;
                        }
                    }

                    ++k1;
                    break;
                }
            }

            //world.setBlock(z, y, j2, Blocks.air, 0, 2);
            /*TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)world.getTileEntity(z, y, j2);

            if (tileentitymobspawner != null)
            {
                tileentitymobspawner.func_145881_a().setEntityName(this.pickMobSpawner(rand));
            }
            else
            {
                System.err.println("Failed to fetch mob spawner entity at (" + z + ", " + y + ", " + j2 + ")");
            }*/

            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Randomly decides which spawner to use in a dungeon
     */
    private ResourceLocation pickMobSpawner(Random rand)
    {
        return net.minecraftforge.common.DungeonHooks.getRandomDungeonMob(rand);
    }
}