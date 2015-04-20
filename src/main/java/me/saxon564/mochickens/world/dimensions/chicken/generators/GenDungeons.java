package me.saxon564.mochickens.world.dimensions.chicken.generators;

import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenDungeons;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.DungeonHooks;
import static net.minecraftforge.common.ChestGenHooks.DUNGEON_CHEST;;

public class GenDungeons
{
    public static final WeightedRandomChestContent[] field_111189_a = new WeightedRandomChestContent[] {new WeightedRandomChestContent(Items.saddle, 0, 1, 1, 10), new WeightedRandomChestContent(Items.iron_ingot, 0, 1, 4, 10), new WeightedRandomChestContent(Items.bread, 0, 1, 1, 10), new WeightedRandomChestContent(Items.wheat, 0, 1, 4, 10), new WeightedRandomChestContent(Items.gunpowder, 0, 1, 4, 10), new WeightedRandomChestContent(Items.string, 0, 1, 4, 10), new WeightedRandomChestContent(Items.bucket, 0, 1, 1, 10), new WeightedRandomChestContent(Items.golden_apple, 0, 1, 1, 1), new WeightedRandomChestContent(Items.redstone, 0, 1, 4, 10), new WeightedRandomChestContent(Items.record_13, 0, 1, 1, 10), new WeightedRandomChestContent(Items.record_cat, 0, 1, 1, 10), new WeightedRandomChestContent(Items.name_tag, 0, 1, 1, 10), new WeightedRandomChestContent(Items.golden_horse_armor, 0, 1, 1, 2), new WeightedRandomChestContent(Items.iron_horse_armor, 0, 1, 1, 5), new WeightedRandomChestContent(Items.diamond_horse_armor, 0, 1, 1, 1)};
    private static final String __OBFID = "CL_00000425";
   
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
                    Material material = world.getBlock(k1, l1, i2).getMaterial();

                    if (l1 == y - 1 && !material.isSolid())
                    {
                        return false;
                    }

                    if (l1 == y + b0 + 1 && !material.isSolid())
                    {
                        return false;
                    }

                    if ((k1 == z - l - 1 || k1 == z + l + 1 || i2 == j2 - i1 - 1 || i2 == j2 + i1 + 1) && l1 == y && world.isAirBlock(k1, l1, i2) && world.isAirBlock(k1, l1 + 1, i2))
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
                            world.setBlockToAir(k1, l1, i2);
                        }
                        else if (l1 >= 0 && !world.getBlock(k1, l1 - 1, i2).getMaterial().isSolid())
                        {
                            world.setBlockToAir(k1, l1, i2);
                        }
                        else if (world.getBlock(k1, l1, i2).getMaterial().isSolid())
                        {
                            if (l1 == y - 1 && rand.nextInt(4) != 0)
                            {
                                world.setBlock(k1, l1, i2, Blocks.mossy_cobblestone, 0, 2);
                            }
                            else
                            {
                                world.setBlock(k1, l1, i2, Blocks.cobblestone, 0, 2);
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

                            if (world.isAirBlock(i2, y, j3))
                            {
                                int k2 = 0;

                                if (world.getBlock(i2 - 1, y, j3).getMaterial().isSolid())
                                {
                                    ++k2;
                                }

                                if (world.getBlock(i2 + 1, y, j3).getMaterial().isSolid())
                                {
                                    ++k2;
                                }

                                if (world.getBlock(i2, y, j3 - 1).getMaterial().isSolid())
                                {
                                    ++k2;
                                }

                                if (world.getBlock(i2, y, j3 + 1).getMaterial().isSolid())
                                {
                                    ++k2;
                                }

                                if (k2 == 1)
                                {
                                    world.setBlock(i2, y, j3, Blocks.chest, 0, 2);
                                    TileEntityChest tileentitychest = (TileEntityChest)world.getTileEntity(i2, y, j3);

                                    if (tileentitychest != null)
                                    {
                                        WeightedRandomChestContent.generateChestContents(rand, ChestGenHooks.getItems(DUNGEON_CHEST, rand), tileentitychest, ChestGenHooks.getCount(DUNGEON_CHEST, rand));
                                    }

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
    private String pickMobSpawner(Random p_76543_1_)
    {
        return DungeonHooks.getRandomDungeonMob(p_76543_1_);
    }
}