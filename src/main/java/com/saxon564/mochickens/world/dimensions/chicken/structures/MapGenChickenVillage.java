package com.saxon564.mochickens.world.dimensions.chicken.structures;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;

import com.saxon564.mochickens.MoChickens;

import net.minecraft.init.Biomes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.MapGenVillage;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureStart;
import net.minecraft.world.gen.structure.StructureVillagePieces;

public class MapGenChickenVillage extends MapGenStructure
{
    /** A list of all the biomes villages can spawn in. */
    public static List villageSpawnBiomes = Arrays.asList(new Biome[] {Biomes.PLAINS, Biomes.DESERT, Biomes.SAVANNA, MoChickens.chicken_plains});
    /** World terrain type, 0 for normal, 1 for flat map */
    private int terrainType;
    private int field_82665_g;
    private int field_82666_h;

    public MapGenChickenVillage()
    {
        this.field_82665_g = 32;
        this.field_82666_h = 8;
    }

    public MapGenChickenVillage(Map p_i2093_1_)
    {
        this();
        Iterator iterator = p_i2093_1_.entrySet().iterator();

        while (iterator.hasNext())
        {
            Entry entry = (Entry)iterator.next();

            if (((String)entry.getKey()).equals("size"))
            {
                this.terrainType = MathHelper.getInt((String)entry.getValue(), this.terrainType, 0);
            }
            else if (((String)entry.getKey()).equals("distance"))
            {
                this.field_82665_g = MathHelper.getInt((String)entry.getValue(), this.field_82665_g, this.field_82666_h + 1);
            }
        }
    }

	@Override
	public String getStructureName()
    {
        return "Chicken_Village";
    }

    protected boolean canSpawnStructureAtCoords(int p_75047_1_, int p_75047_2_)
    {
        int k = p_75047_1_;
        int l = p_75047_2_;

        if (p_75047_1_ < 0)
        {
            p_75047_1_ -= this.field_82665_g - 1;
        }

        if (p_75047_2_ < 0)
        {
            p_75047_2_ -= this.field_82665_g - 1;
        }

        int i1 = p_75047_1_ / this.field_82665_g;
        int j1 = p_75047_2_ / this.field_82665_g;
        Random random = this.world.setRandomSeed(i1, j1, 10387312);
        i1 *= this.field_82665_g;
        j1 *= this.field_82665_g;
        i1 += random.nextInt(this.field_82665_g - this.field_82666_h);
        j1 += random.nextInt(this.field_82665_g - this.field_82666_h);

        if (k == i1 && l == j1)
        {
            boolean flag = this.world.getBiomeProvider().areBiomesViable(k * 16 + 8, l * 16 + 8, 0, villageSpawnBiomes);

            if (flag)
            {
                return true;
            }
        }

        return false;
    }

    protected StructureStart getStructureStart(int p_75049_1_, int p_75049_2_)
    {
        return new MapGenChickenVillage.ChickenStart(this.world, this.rand, p_75049_1_, p_75049_2_, this.terrainType);
    }

    public static class ChickenStart extends StructureStart
    {
        /** well ... thats what it does */
        private boolean hasMoreThanTwoComponents;

        public ChickenStart() {}

        public ChickenStart(World worldIn, Random p_i2092_2_, int p_i2092_3_, int p_i2092_4_, int p_i2092_5_)
        {
            super(p_i2092_3_, p_i2092_4_);
            List list = VillageBuildings.getStructureVillageWeightedPieceList(p_i2092_2_, p_i2092_5_);
            VillageBuildings.Start start = new VillageBuildings.Start(worldIn.getBiomeProvider(), 0, p_i2092_2_, (p_i2092_3_ << 4) + 2, (p_i2092_4_ << 4) + 2, list, p_i2092_5_);
            this.components.add(start);
            start.buildComponent(start, this.components, p_i2092_2_);
            List<StructureComponent> list1 = start.pendingRoads;
            List<StructureComponent> list2 = start.pendingHouses;
            int l;

            while (!list1.isEmpty() || !list2.isEmpty())
            {
                StructureComponent structurecomponent;

                if (list1.isEmpty())
                {
                    l = p_i2092_2_.nextInt(list2.size());
                    structurecomponent = (StructureComponent)list2.remove(l);
                    structurecomponent.buildComponent(start, this.components, p_i2092_2_);
                }
                else
                {
                    l = p_i2092_2_.nextInt(list1.size());
                    structurecomponent = (StructureComponent)list1.remove(l);
                    structurecomponent.buildComponent(start, this.components, p_i2092_2_);
                }
            }

            this.updateBoundingBox();
            l = 0;
            Iterator iterator = this.components.iterator();

            while (iterator.hasNext())
            {
                StructureComponent structurecomponent1 = (StructureComponent)iterator.next();

                if (!(structurecomponent1 instanceof StructureVillagePieces.Road))
                {
                    ++l;
                }
            }

            this.hasMoreThanTwoComponents = l > 2;
        }

        /**
         * currently only defined for Villages, returns true if Village has more than 2 non-road components
         */
        public boolean isSizeableStructure()
        {
            return this.hasMoreThanTwoComponents;
        }

        public void writeToNBT(NBTTagCompound tagCompound)
        {
            super.writeToNBT(tagCompound);
            tagCompound.setBoolean("Valid", this.hasMoreThanTwoComponents);
        }

        public void readFromNBT(NBTTagCompound tagCompound)
        {
            super.readFromNBT(tagCompound);
            this.hasMoreThanTwoComponents = tagCompound.getBoolean("Valid");
        }
    }

	@Override
	public BlockPos getClosestStrongholdPos(World worldIn, BlockPos pos, boolean p_180706_3_) {
		// TODO Auto-generated method stub
		return null;
	}
}