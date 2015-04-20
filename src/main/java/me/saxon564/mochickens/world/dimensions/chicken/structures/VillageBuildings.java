package me.saxon564.mochickens.world.dimensions.chicken.structures;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import cpw.mods.fml.common.eventhandler.Event.Result;
import me.saxon564.mochickens.MoChickens;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.MapGenVillage;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.BiomeEvent;
import static net.minecraftforge.common.ChestGenHooks.*;

public class VillageBuildings
{
    private static final String __OBFID = "CL_00000516";

    public static void registerVillagePieces()
    {
        MapGenStructureIO.registerStructure(VillageBuildings.House1.class, "CViBH");
        MapGenStructureIO.registerStructure(VillageBuildings.Field1.class, "CViDF");
        MapGenStructureIO.registerStructure(VillageBuildings.Field2.class, "CViF");
        MapGenStructureIO.registerStructure(VillageBuildings.Torch.class, "CViL");
        MapGenStructureIO.registerStructure(VillageBuildings.Hall.class, "CViPH");
        MapGenStructureIO.registerStructure(VillageBuildings.House4Garden.class, "CViSH");
        MapGenStructureIO.registerStructure(VillageBuildings.WoodHut.class, "CViSmH");
        MapGenStructureIO.registerStructure(VillageBuildings.Church.class, "CCViST");
        MapGenStructureIO.registerStructure(VillageBuildings.House2.class, "CViS");
        MapGenStructureIO.registerStructure(VillageBuildings.Start.class, "CViStart");
        MapGenStructureIO.registerStructure(VillageBuildings.Path.class, "CViSR");
        MapGenStructureIO.registerStructure(VillageBuildings.House3.class, "CViTRH");
        MapGenStructureIO.registerStructure(VillageBuildings.Well.class, "CViW");
        MapGenStructureIO.func_143031_a(VillageBuildings.House1.class, "CViBH");
        MapGenStructureIO.func_143031_a(VillageBuildings.Field1.class, "CViDF");
        MapGenStructureIO.func_143031_a(VillageBuildings.Field2.class, "CViF");
        MapGenStructureIO.func_143031_a(VillageBuildings.Torch.class, "CViL");
        MapGenStructureIO.func_143031_a(VillageBuildings.Hall.class, "CViPH");
        MapGenStructureIO.func_143031_a(VillageBuildings.House4Garden.class, "CViSH");
        MapGenStructureIO.func_143031_a(VillageBuildings.WoodHut.class, "CViSmH");
        MapGenStructureIO.func_143031_a(VillageBuildings.Church.class, "CCViST");
        MapGenStructureIO.func_143031_a(VillageBuildings.House2.class, "CViS");
        MapGenStructureIO.func_143031_a(VillageBuildings.Start.class, "CViStart");
        MapGenStructureIO.func_143031_a(VillageBuildings.Path.class, "CViSR");
        MapGenStructureIO.func_143031_a(VillageBuildings.House3.class, "CViTRH");
        MapGenStructureIO.func_143031_a(VillageBuildings.Well.class, "CViW");
    }

    public static List getStructureVillageWeightedPieceList(Random p_75084_0_, int p_75084_1_)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new VillageBuildings.PieceWeight(VillageBuildings.House4Garden.class, 4, MathHelper.getRandomIntegerInRange(p_75084_0_, 2 + p_75084_1_, 4 + p_75084_1_ * 2)));
        arraylist.add(new VillageBuildings.PieceWeight(VillageBuildings.Church.class, 20, MathHelper.getRandomIntegerInRange(p_75084_0_, 0 + p_75084_1_, 1 + p_75084_1_)));
        arraylist.add(new VillageBuildings.PieceWeight(VillageBuildings.House1.class, 20, MathHelper.getRandomIntegerInRange(p_75084_0_, 0 + p_75084_1_, 2 + p_75084_1_)));
        arraylist.add(new VillageBuildings.PieceWeight(VillageBuildings.WoodHut.class, 3, MathHelper.getRandomIntegerInRange(p_75084_0_, 2 + p_75084_1_, 5 + p_75084_1_ * 3)));
        arraylist.add(new VillageBuildings.PieceWeight(VillageBuildings.Hall.class, 15, MathHelper.getRandomIntegerInRange(p_75084_0_, 0 + p_75084_1_, 2 + p_75084_1_)));
        arraylist.add(new VillageBuildings.PieceWeight(VillageBuildings.Field1.class, 3, MathHelper.getRandomIntegerInRange(p_75084_0_, 1 + p_75084_1_, 4 + p_75084_1_)));
        arraylist.add(new VillageBuildings.PieceWeight(VillageBuildings.Field2.class, 3, MathHelper.getRandomIntegerInRange(p_75084_0_, 2 + p_75084_1_, 4 + p_75084_1_ * 2)));
        arraylist.add(new VillageBuildings.PieceWeight(VillageBuildings.House2.class, 15, MathHelper.getRandomIntegerInRange(p_75084_0_, 0, 1 + p_75084_1_)));
        arraylist.add(new VillageBuildings.PieceWeight(VillageBuildings.House3.class, 8, MathHelper.getRandomIntegerInRange(p_75084_0_, 0 + p_75084_1_, 3 + p_75084_1_ * 2)));
        VillagerRegistry.addExtraVillageComponents(arraylist, p_75084_0_, p_75084_1_);

        Iterator iterator = arraylist.iterator();

        while (iterator.hasNext())
        {
            if (((VillageBuildings.PieceWeight)iterator.next()).villagePiecesLimit == 0)
            {
                iterator.remove();
            }
        }

        return arraylist;
    }

    private static int func_75079_a(List p_75079_0_)
    {
        boolean flag = false;
        int i = 0;
        VillageBuildings.PieceWeight pieceweight;

        for (Iterator iterator = p_75079_0_.iterator(); iterator.hasNext(); i += pieceweight.villagePieceWeight)
        {
            pieceweight = (VillageBuildings.PieceWeight)iterator.next();

            if (pieceweight.villagePiecesLimit > 0 && pieceweight.villagePiecesSpawned < pieceweight.villagePiecesLimit)
            {
                flag = true;
            }
        }

        return flag ? i : -1;
    }

    private static VillageBuildings.Village func_75083_a(VillageBuildings.Start p_75083_0_, VillageBuildings.PieceWeight p_75083_1_, List p_75083_2_, Random p_75083_3_, int p_75083_4_, int p_75083_5_, int p_75083_6_, int p_75083_7_, int p_75083_8_)
    {
        Class oclass = p_75083_1_.villagePieceClass;
        Object object = null;

        if (oclass == VillageBuildings.House4Garden.class)
        {
            object = VillageBuildings.House4Garden.func_74912_a(p_75083_0_, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
        }
        else if (oclass == VillageBuildings.Church.class)
        {
            object = VillageBuildings.Church.func_74919_a(p_75083_0_, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
        }
        else if (oclass == VillageBuildings.House1.class)
        {
            object = VillageBuildings.House1.func_74898_a(p_75083_0_, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
        }
        else if (oclass == VillageBuildings.WoodHut.class)
        {
            object = VillageBuildings.WoodHut.func_74908_a(p_75083_0_, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
        }
        else if (oclass == VillageBuildings.Hall.class)
        {
            object = VillageBuildings.Hall.func_74906_a(p_75083_0_, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
        }
        else if (oclass == VillageBuildings.Field1.class)
        {
            object = VillageBuildings.Field1.func_74900_a(p_75083_0_, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
        }
        else if (oclass == VillageBuildings.Field2.class)
        {
            object = VillageBuildings.Field2.func_74902_a(p_75083_0_, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
        }
        else if (oclass == VillageBuildings.House2.class)
        {
            object = VillageBuildings.House2.func_74915_a(p_75083_0_, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
        }
        else if (oclass == VillageBuildings.House3.class)
        {
            object = VillageBuildings.House3.func_74921_a(p_75083_0_, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
        }
        else
        {
            object = VillagerRegistry.getVillageComponent(p_75083_1_, p_75083_0_ , p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
        }

        return (VillageBuildings.Village)object;
    }

    /**
     * attempts to find a next Village Component to be spawned
     */
    private static VillageBuildings.Village getNextVillageComponent(VillageBuildings.Start p_75081_0_, List p_75081_1_, Random p_75081_2_, int p_75081_3_, int p_75081_4_, int p_75081_5_, int p_75081_6_, int p_75081_7_)
    {
        int j1 = func_75079_a(p_75081_0_.structureVillageWeightedPieceList);

        if (j1 <= 0)
        {
            return null;
        }
        else
        {
            int k1 = 0;

            while (k1 < 5)
            {
                ++k1;
                int l1 = p_75081_2_.nextInt(j1);
                Iterator iterator = p_75081_0_.structureVillageWeightedPieceList.iterator();

                while (iterator.hasNext())
                {
                    VillageBuildings.PieceWeight pieceweight = (VillageBuildings.PieceWeight)iterator.next();
                    l1 -= pieceweight.villagePieceWeight;

                    if (l1 < 0)
                    {
                        if (!pieceweight.canSpawnMoreVillagePiecesOfType(p_75081_7_) || pieceweight == p_75081_0_.structVillagePieceWeight && p_75081_0_.structureVillageWeightedPieceList.size() > 1)
                        {
                            break;
                        }

                        VillageBuildings.Village village = func_75083_a(p_75081_0_, pieceweight, p_75081_1_, p_75081_2_, p_75081_3_, p_75081_4_, p_75081_5_, p_75081_6_, p_75081_7_);

                        if (village != null)
                        {
                            ++pieceweight.villagePiecesSpawned;
                            p_75081_0_.structVillagePieceWeight = pieceweight;

                            if (!pieceweight.canSpawnMoreVillagePieces())
                            {
                                p_75081_0_.structureVillageWeightedPieceList.remove(pieceweight);
                            }

                            return village;
                        }
                    }
                }
            }

            StructureBoundingBox structureboundingbox = VillageBuildings.Torch.func_74904_a(p_75081_0_, p_75081_1_, p_75081_2_, p_75081_3_, p_75081_4_, p_75081_5_, p_75081_6_);

            if (structureboundingbox != null)
            {
                return new VillageBuildings.Torch(p_75081_0_, p_75081_7_, p_75081_2_, structureboundingbox, p_75081_6_);
            }
            else
            {
                return null;
            }
        }
    }

    /**
     * attempts to find a next Structure Component to be spawned, private Village function
     */
    private static StructureComponent getNextVillageStructureComponent(VillageBuildings.Start p_75077_0_, List p_75077_1_, Random p_75077_2_, int p_75077_3_, int p_75077_4_, int p_75077_5_, int p_75077_6_, int p_75077_7_)
    {
        if (p_75077_7_ > 50)
        {
            return null;
        }
        else if (Math.abs(p_75077_3_ - p_75077_0_.getBoundingBox().minX) <= 112 && Math.abs(p_75077_5_ - p_75077_0_.getBoundingBox().minZ) <= 112)
        {
            VillageBuildings.Village village = getNextVillageComponent(p_75077_0_, p_75077_1_, p_75077_2_, p_75077_3_, p_75077_4_, p_75077_5_, p_75077_6_, p_75077_7_ + 1);

            if (village != null)
            {
                int j1 = (village.getBoundingBox().minX + village.getBoundingBox().maxX) / 2;
                int k1 = (village.getBoundingBox().minZ + village.getBoundingBox().maxZ) / 2;
                int l1 = village.getBoundingBox().maxX - village.getBoundingBox().minX;
                int i2 = village.getBoundingBox().maxZ - village.getBoundingBox().minZ;
                int j2 = l1 > i2 ? l1 : i2;

                if (p_75077_0_.getWorldChunkManager().areBiomesViable(j1, k1, j2 / 2 + 4, MapGenVillage.villageSpawnBiomes))
                {
                    p_75077_1_.add(village);
                    p_75077_0_.field_74932_i.add(village);
                    return village;
                }
            }

            return null;
        }
        else
        {
            return null;
        }
    }

    private static StructureComponent getNextComponentVillagePath(VillageBuildings.Start p_75080_0_, List p_75080_1_, Random p_75080_2_, int p_75080_3_, int p_75080_4_, int p_75080_5_, int p_75080_6_, int p_75080_7_)
    {
        if (p_75080_7_ > 3 + p_75080_0_.terrainType)
        {
            return null;
        }
        else if (Math.abs(p_75080_3_ - p_75080_0_.getBoundingBox().minX) <= 112 && Math.abs(p_75080_5_ - p_75080_0_.getBoundingBox().minZ) <= 112)
        {
            StructureBoundingBox structureboundingbox = VillageBuildings.Path.func_74933_a(p_75080_0_, p_75080_1_, p_75080_2_, p_75080_3_, p_75080_4_, p_75080_5_, p_75080_6_);

            if (structureboundingbox != null && structureboundingbox.minY > 10)
            {
                VillageBuildings.Path path = new VillageBuildings.Path(p_75080_0_, p_75080_7_, p_75080_2_, structureboundingbox, p_75080_6_);
                int j1 = (path.getBoundingBox().minX + path.getBoundingBox().maxX) / 2;
                int k1 = (path.getBoundingBox().minZ + path.getBoundingBox().maxZ) / 2;
                int l1 = path.getBoundingBox().maxX - path.getBoundingBox().minX;
                int i2 = path.getBoundingBox().maxZ - path.getBoundingBox().minZ;
                int j2 = l1 > i2 ? l1 : i2;

                if (p_75080_0_.getWorldChunkManager().areBiomesViable(j1, k1, j2 / 2 + 4, MapGenVillage.villageSpawnBiomes))
                {
                    p_75080_1_.add(path);
                    p_75080_0_.field_74930_j.add(path);
                    return path;
                }
            }

            return null;
        }
        else
        {
            return null;
        }
    }

    public static class Church extends VillageBuildings.Village
        {
            private static final String __OBFID = "CL_00000525";

            public Church() {}

            public Church(VillageBuildings.Start p_i2102_1_, int p_i2102_2_, Random p_i2102_3_, StructureBoundingBox p_i2102_4_, int p_i2102_5_)
            {
                super(p_i2102_1_, p_i2102_2_);
                this.coordBaseMode = p_i2102_5_;
                this.boundingBox = p_i2102_4_;
            }

            public static VillageBuildings.Church func_74919_a(VillageBuildings.Start p_74919_0_, List p_74919_1_, Random p_74919_2_, int p_74919_3_, int p_74919_4_, int p_74919_5_, int p_74919_6_, int p_74919_7_)
            {
                StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_74919_3_, p_74919_4_, p_74919_5_, 0, 0, 0, 5, 12, 9, p_74919_6_);
                return canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(p_74919_1_, structureboundingbox) == null ? new VillageBuildings.Church(p_74919_0_, p_74919_7_, p_74919_2_, structureboundingbox, p_74919_6_) : null;
            }

            /**
             * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
             * Mineshafts at the end, it adds Fences...
             */
            public boolean addComponentParts(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
            {
                if (this.field_143015_k < 0)
                {
                    this.field_143015_k = this.getAverageGroundLevel(p_74875_1_, p_74875_3_);

                    if (this.field_143015_k < 0)
                    {
                        return true;
                    }

                    this.boundingBox.offset(0, this.field_143015_k - this.boundingBox.maxY + 12 - 1, 0);
                }

                this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 1, 1, 3, 3, 7, Blocks.air, Blocks.air, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 5, 1, 3, 9, 3, Blocks.air, Blocks.air, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 0, 0, 3, 0, 8, Blocks.cobblestone, Blocks.cobblestone, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 1, 0, 3, 10, 0, Blocks.cobblestone, Blocks.cobblestone, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 1, 1, 0, 10, 3, Blocks.cobblestone, Blocks.cobblestone, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 4, 1, 1, 4, 10, 3, Blocks.cobblestone, Blocks.cobblestone, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 0, 4, 0, 4, 7, Blocks.cobblestone, Blocks.cobblestone, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 4, 0, 4, 4, 4, 7, Blocks.cobblestone, Blocks.cobblestone, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 1, 8, 3, 4, 8, Blocks.cobblestone, Blocks.cobblestone, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 5, 4, 3, 10, 4, Blocks.cobblestone, Blocks.cobblestone, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 5, 5, 3, 5, 7, Blocks.cobblestone, Blocks.cobblestone, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 9, 0, 4, 9, 4, Blocks.cobblestone, Blocks.cobblestone, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 4, 0, 4, 4, 4, Blocks.cobblestone, Blocks.cobblestone, false);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.cobblestone, 0, 0, 11, 2, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.cobblestone, 0, 4, 11, 2, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.cobblestone, 0, 2, 11, 0, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.cobblestone, 0, 2, 11, 4, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.cobblestone, 0, 1, 1, 6, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.cobblestone, 0, 1, 1, 7, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.cobblestone, 0, 2, 1, 7, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.cobblestone, 0, 3, 1, 6, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.cobblestone, 0, 3, 1, 7, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stone_stairs, this.getMetadataWithOffset(Blocks.stone_stairs, 3), 1, 1, 5, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stone_stairs, this.getMetadataWithOffset(Blocks.stone_stairs, 3), 2, 1, 6, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stone_stairs, this.getMetadataWithOffset(Blocks.stone_stairs, 3), 3, 1, 5, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stone_stairs, this.getMetadataWithOffset(Blocks.stone_stairs, 1), 1, 2, 7, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stone_stairs, this.getMetadataWithOffset(Blocks.stone_stairs, 0), 3, 2, 7, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 0, 2, 2, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 0, 3, 2, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 4, 2, 2, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 4, 3, 2, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 0, 6, 2, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 0, 7, 2, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 4, 6, 2, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 4, 7, 2, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 2, 6, 0, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 2, 7, 0, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 2, 6, 4, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 2, 7, 4, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 0, 3, 6, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 4, 3, 6, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 2, 3, 8, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.torch, 0, 2, 4, 7, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.torch, 0, 1, 4, 6, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.torch, 0, 3, 4, 6, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.torch, 0, 2, 4, 5, p_74875_3_);
                int i = this.getMetadataWithOffset(Blocks.ladder, 4);
                int j;

                for (j = 1; j <= 9; ++j)
                {
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.ladder, i, 3, j, 3, p_74875_3_);
                }

                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.air, 0, 2, 1, 0, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.air, 0, 2, 2, 0, p_74875_3_);
                this.placeDoorAtCurrentPosition(p_74875_1_, p_74875_3_, p_74875_2_, 2, 1, 0, this.getMetadataWithOffset(Blocks.wooden_door, 1));

                if (this.getBlockAtCurrentPosition(p_74875_1_, 2, 0, -1, p_74875_3_).getMaterial() == Material.air && this.getBlockAtCurrentPosition(p_74875_1_, 2, -1, -1, p_74875_3_).getMaterial() != Material.air)
                {
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stone_stairs, this.getMetadataWithOffset(Blocks.stone_stairs, 3), 2, 0, -1, p_74875_3_);
                }

                for (j = 0; j < 9; ++j)
                {
                    for (int k = 0; k < 5; ++k)
                    {
                        this.clearCurrentPositionBlocksUpwards(p_74875_1_, k, 12, j, p_74875_3_);
                        this.func_151554_b(p_74875_1_, Blocks.cobblestone, 0, k, -1, j, p_74875_3_);
                    }
                }

                this.spawnVillagers(p_74875_1_, p_74875_3_, 2, 1, 2, 1);
                return true;
            }

            /**
             * Returns the villager type to spawn in this component, based on the number of villagers already spawned.
             */
            protected int getVillagerType(int p_74888_1_)
            {
                return 2;
            }
        }

    public static class Field1 extends VillageBuildings.Village
        {
            /** First crop type for this field. */
            private Block cropTypeA;
            /** Second crop type for this field. */
            private Block cropTypeB;
            /** Third crop type for this field. */
            private Block cropTypeC;
            /** Fourth crop type for this field. */
            private Block cropTypeD;
            private static final String __OBFID = "CL_00000518";

            public Field1() {}

            public Field1(VillageBuildings.Start p_i2095_1_, int p_i2095_2_, Random p_i2095_3_, StructureBoundingBox p_i2095_4_, int p_i2095_5_)
            {
                super(p_i2095_1_, p_i2095_2_);
                this.coordBaseMode = p_i2095_5_;
                this.boundingBox = p_i2095_4_;
                this.cropTypeA = this.func_151559_a(p_i2095_3_);
                this.cropTypeB = this.func_151559_a(p_i2095_3_);
                this.cropTypeC = this.func_151559_a(p_i2095_3_);
                this.cropTypeD = this.func_151559_a(p_i2095_3_);
            }

            protected void func_143012_a(NBTTagCompound p_143012_1_)
            {
                super.func_143012_a(p_143012_1_);
                p_143012_1_.setInteger("CA", Block.blockRegistry.getIDForObject(this.cropTypeA));
                p_143012_1_.setInteger("CB", Block.blockRegistry.getIDForObject(this.cropTypeB));
                p_143012_1_.setInteger("CC", Block.blockRegistry.getIDForObject(this.cropTypeC));
                p_143012_1_.setInteger("CD", Block.blockRegistry.getIDForObject(this.cropTypeD));
            }

            protected void func_143011_b(NBTTagCompound p_143011_1_)
            {
                super.func_143011_b(p_143011_1_);
                this.cropTypeA = Block.getBlockById(p_143011_1_.getInteger("CA"));
                this.cropTypeB = Block.getBlockById(p_143011_1_.getInteger("CB"));
                this.cropTypeC = Block.getBlockById(p_143011_1_.getInteger("CC"));
                this.cropTypeD = Block.getBlockById(p_143011_1_.getInteger("CD"));
            }

            private Block func_151559_a(Random p_151559_1_)
            {
                switch (p_151559_1_.nextInt(5))
                {
                    case 0:
                        return Blocks.carrots;
                    case 1:
                        return Blocks.potatoes;
                    default:
                        return Blocks.wheat;
                }
            }

            public static VillageBuildings.Field1 func_74900_a(VillageBuildings.Start p_74900_0_, List p_74900_1_, Random p_74900_2_, int p_74900_3_, int p_74900_4_, int p_74900_5_, int p_74900_6_, int p_74900_7_)
            {
                StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_74900_3_, p_74900_4_, p_74900_5_, 0, 0, 0, 13, 4, 9, p_74900_6_);
                return canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(p_74900_1_, structureboundingbox) == null ? new VillageBuildings.Field1(p_74900_0_, p_74900_7_, p_74900_2_, structureboundingbox, p_74900_6_) : null;
            }

            /**
             * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
             * Mineshafts at the end, it adds Fences...
             */
            public boolean addComponentParts(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
            {
                if (this.field_143015_k < 0)
                {
                    this.field_143015_k = this.getAverageGroundLevel(p_74875_1_, p_74875_3_);

                    if (this.field_143015_k < 0)
                    {
                        return true;
                    }

                    this.boundingBox.offset(0, this.field_143015_k - this.boundingBox.maxY + 4 - 1, 0);
                }

                this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 1, 0, 12, 4, 8, Blocks.air, Blocks.air, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 0, 1, 2, 0, 7, Blocks.farmland, Blocks.farmland, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 4, 0, 1, 5, 0, 7, Blocks.farmland, Blocks.farmland, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 7, 0, 1, 8, 0, 7, Blocks.farmland, Blocks.farmland, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 10, 0, 1, 11, 0, 7, Blocks.farmland, Blocks.farmland, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 0, 0, 0, 0, 8, Blocks.log, Blocks.log, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 6, 0, 0, 6, 0, 8, Blocks.log, Blocks.log, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 12, 0, 0, 12, 0, 8, Blocks.log, Blocks.log, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 0, 0, 11, 0, 0, Blocks.log, Blocks.log, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 0, 8, 11, 0, 8, Blocks.log, Blocks.log, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 3, 0, 1, 3, 0, 7, Blocks.water, Blocks.water, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 9, 0, 1, 9, 0, 7, Blocks.water, Blocks.water, false);
                int i;

                for (i = 1; i <= 7; ++i)
                {
                    this.placeBlockAtCurrentPosition(p_74875_1_, this.cropTypeA, MathHelper.getRandomIntegerInRange(p_74875_2_, 2, 7), 1, 1, i, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, this.cropTypeA, MathHelper.getRandomIntegerInRange(p_74875_2_, 2, 7), 2, 1, i, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, this.cropTypeB, MathHelper.getRandomIntegerInRange(p_74875_2_, 2, 7), 4, 1, i, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, this.cropTypeB, MathHelper.getRandomIntegerInRange(p_74875_2_, 2, 7), 5, 1, i, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, this.cropTypeC, MathHelper.getRandomIntegerInRange(p_74875_2_, 2, 7), 7, 1, i, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, this.cropTypeC, MathHelper.getRandomIntegerInRange(p_74875_2_, 2, 7), 8, 1, i, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, this.cropTypeD, MathHelper.getRandomIntegerInRange(p_74875_2_, 2, 7), 10, 1, i, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, this.cropTypeD, MathHelper.getRandomIntegerInRange(p_74875_2_, 2, 7), 11, 1, i, p_74875_3_);
                }

                for (i = 0; i < 9; ++i)
                {
                    for (int j = 0; j < 13; ++j)
                    {
                        this.clearCurrentPositionBlocksUpwards(p_74875_1_, j, 4, i, p_74875_3_);
                        this.func_151554_b(p_74875_1_, Blocks.dirt, 0, j, -1, i, p_74875_3_);
                    }
                }

                return true;
            }
        }

    public static class Field2 extends VillageBuildings.Village
        {
            /** First crop type for this field. */
            private Block cropTypeA;
            /** Second crop type for this field. */
            private Block cropTypeB;
            private static final String __OBFID = "CL_00000519";

            public Field2() {}

            public Field2(VillageBuildings.Start p_i2096_1_, int p_i2096_2_, Random p_i2096_3_, StructureBoundingBox p_i2096_4_, int p_i2096_5_)
            {
                super(p_i2096_1_, p_i2096_2_);
                this.coordBaseMode = p_i2096_5_;
                this.boundingBox = p_i2096_4_;
                this.cropTypeA = this.func_151560_a(p_i2096_3_);
                this.cropTypeB = this.func_151560_a(p_i2096_3_);
            }

            protected void func_143012_a(NBTTagCompound p_143012_1_)
            {
                super.func_143012_a(p_143012_1_);
                p_143012_1_.setInteger("CA", Block.blockRegistry.getIDForObject(this.cropTypeA));
                p_143012_1_.setInteger("CB", Block.blockRegistry.getIDForObject(this.cropTypeB));
            }

            protected void func_143011_b(NBTTagCompound p_143011_1_)
            {
                super.func_143011_b(p_143011_1_);
                this.cropTypeA = Block.getBlockById(p_143011_1_.getInteger("CA"));
                this.cropTypeB = Block.getBlockById(p_143011_1_.getInteger("CB"));
            }

            private Block func_151560_a(Random p_151560_1_)
            {
                switch (p_151560_1_.nextInt(5))
                {
                    case 0:
                        return Blocks.carrots;
                    case 1:
                        return Blocks.potatoes;
                    default:
                        return Blocks.wheat;
                }
            }

            public static VillageBuildings.Field2 func_74902_a(VillageBuildings.Start p_74902_0_, List p_74902_1_, Random p_74902_2_, int p_74902_3_, int p_74902_4_, int p_74902_5_, int p_74902_6_, int p_74902_7_)
            {
                StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_74902_3_, p_74902_4_, p_74902_5_, 0, 0, 0, 7, 4, 9, p_74902_6_);
                return canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(p_74902_1_, structureboundingbox) == null ? new VillageBuildings.Field2(p_74902_0_, p_74902_7_, p_74902_2_, structureboundingbox, p_74902_6_) : null;
            }

            /**
             * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
             * Mineshafts at the end, it adds Fences...
             */
            public boolean addComponentParts(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
            {
                if (this.field_143015_k < 0)
                {
                    this.field_143015_k = this.getAverageGroundLevel(p_74875_1_, p_74875_3_);

                    if (this.field_143015_k < 0)
                    {
                        return true;
                    }

                    this.boundingBox.offset(0, this.field_143015_k - this.boundingBox.maxY + 4 - 1, 0);
                }

                this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 1, 0, 6, 4, 8, Blocks.air, Blocks.air, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 0, 1, 2, 0, 7, Blocks.farmland, Blocks.farmland, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 4, 0, 1, 5, 0, 7, Blocks.farmland, Blocks.farmland, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 0, 0, 0, 0, 8, Blocks.log, Blocks.log, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 6, 0, 0, 6, 0, 8, Blocks.log, Blocks.log, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 0, 0, 5, 0, 0, Blocks.log, Blocks.log, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 0, 8, 5, 0, 8, Blocks.log, Blocks.log, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 3, 0, 1, 3, 0, 7, Blocks.water, Blocks.water, false);
                int i;

                for (i = 1; i <= 7; ++i)
                {
                    this.placeBlockAtCurrentPosition(p_74875_1_, this.cropTypeA, MathHelper.getRandomIntegerInRange(p_74875_2_, 2, 7), 1, 1, i, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, this.cropTypeA, MathHelper.getRandomIntegerInRange(p_74875_2_, 2, 7), 2, 1, i, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, this.cropTypeB, MathHelper.getRandomIntegerInRange(p_74875_2_, 2, 7), 4, 1, i, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, this.cropTypeB, MathHelper.getRandomIntegerInRange(p_74875_2_, 2, 7), 5, 1, i, p_74875_3_);
                }

                for (i = 0; i < 9; ++i)
                {
                    for (int j = 0; j < 7; ++j)
                    {
                        this.clearCurrentPositionBlocksUpwards(p_74875_1_, j, 4, i, p_74875_3_);
                        this.func_151554_b(p_74875_1_, Blocks.dirt, 0, j, -1, i, p_74875_3_);
                    }
                }

                return true;
            }
        }

    public static class Hall extends VillageBuildings.Village
        {
            private static final String __OBFID = "CL_00000522";

            public Hall() {}

            public Hall(VillageBuildings.Start p_i2099_1_, int p_i2099_2_, Random p_i2099_3_, StructureBoundingBox p_i2099_4_, int p_i2099_5_)
            {
                super(p_i2099_1_, p_i2099_2_);
                this.coordBaseMode = p_i2099_5_;
                this.boundingBox = p_i2099_4_;
            }

            public static VillageBuildings.Hall func_74906_a(VillageBuildings.Start p_74906_0_, List p_74906_1_, Random p_74906_2_, int p_74906_3_, int p_74906_4_, int p_74906_5_, int p_74906_6_, int p_74906_7_)
            {
                StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_74906_3_, p_74906_4_, p_74906_5_, 0, 0, 0, 9, 7, 11, p_74906_6_);
                return canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(p_74906_1_, structureboundingbox) == null ? new VillageBuildings.Hall(p_74906_0_, p_74906_7_, p_74906_2_, structureboundingbox, p_74906_6_) : null;
            }

            /**
             * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
             * Mineshafts at the end, it adds Fences...
             */
            public boolean addComponentParts(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
            {
                if (this.field_143015_k < 0)
                {
                    this.field_143015_k = this.getAverageGroundLevel(p_74875_1_, p_74875_3_);

                    if (this.field_143015_k < 0)
                    {
                        return true;
                    }

                    this.boundingBox.offset(0, this.field_143015_k - this.boundingBox.maxY + 7 - 1, 0);
                }

                this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 1, 1, 7, 4, 4, Blocks.air, Blocks.air, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 2, 1, 6, 8, 4, 10, Blocks.air, Blocks.air, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 2, 0, 6, 8, 0, 10, Blocks.dirt, Blocks.dirt, false);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.cobblestone, 0, 6, 0, 6, p_74875_3_);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 2, 1, 6, 2, 1, 10, Blocks.fence, Blocks.fence, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 8, 1, 6, 8, 1, 10, Blocks.fence, Blocks.fence, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 3, 1, 10, 7, 1, 10, Blocks.fence, Blocks.fence, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 0, 1, 7, 0, 4, Blocks.planks, Blocks.planks, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 0, 0, 0, 3, 5, Blocks.cobblestone, Blocks.cobblestone, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 8, 0, 0, 8, 3, 5, Blocks.cobblestone, Blocks.cobblestone, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 0, 0, 7, 1, 0, Blocks.cobblestone, Blocks.cobblestone, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 0, 5, 7, 1, 5, Blocks.cobblestone, Blocks.cobblestone, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 2, 0, 7, 3, 0, Blocks.planks, Blocks.planks, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 2, 5, 7, 3, 5, Blocks.planks, Blocks.planks, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 4, 1, 8, 4, 1, Blocks.planks, Blocks.planks, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 4, 4, 8, 4, 4, Blocks.planks, Blocks.planks, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 5, 2, 8, 5, 3, Blocks.planks, Blocks.planks, false);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.planks, 0, 0, 4, 2, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.planks, 0, 0, 4, 3, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.planks, 0, 8, 4, 2, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.planks, 0, 8, 4, 3, p_74875_3_);
                int i = this.getMetadataWithOffset(Blocks.oak_stairs, 3);
                int j = this.getMetadataWithOffset(Blocks.oak_stairs, 2);
                int k;
                int l;

                for (k = -1; k <= 2; ++k)
                {
                    for (l = 0; l <= 8; ++l)
                    {
                        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.oak_stairs, i, l, 4 + k, k, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.oak_stairs, j, l, 4 + k, 5 - k, p_74875_3_);
                    }
                }

                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.log, 0, 0, 2, 1, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.log, 0, 0, 2, 4, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.log, 0, 8, 2, 1, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.log, 0, 8, 2, 4, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 0, 2, 2, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 0, 2, 3, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 8, 2, 2, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 8, 2, 3, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 2, 2, 5, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 3, 2, 5, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 5, 2, 0, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 6, 2, 5, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.fence, 0, 2, 1, 3, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.wooden_pressure_plate, 0, 2, 2, 3, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.planks, 0, 1, 1, 4, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.oak_stairs, this.getMetadataWithOffset(Blocks.oak_stairs, 3), 2, 1, 4, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.oak_stairs, this.getMetadataWithOffset(Blocks.oak_stairs, 1), 1, 1, 3, p_74875_3_);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 5, 0, 1, 7, 0, 3, Blocks.double_stone_slab, Blocks.double_stone_slab, false);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.double_stone_slab, 0, 6, 1, 1, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.double_stone_slab, 0, 6, 1, 2, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.air, 0, 2, 1, 0, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.air, 0, 2, 2, 0, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.torch, 0, 2, 3, 1, p_74875_3_);
                this.placeDoorAtCurrentPosition(p_74875_1_, p_74875_3_, p_74875_2_, 2, 1, 0, this.getMetadataWithOffset(Blocks.wooden_door, 1));

                if (this.getBlockAtCurrentPosition(p_74875_1_, 2, 0, -1, p_74875_3_).getMaterial() == Material.air && this.getBlockAtCurrentPosition(p_74875_1_, 2, -1, -1, p_74875_3_).getMaterial() != Material.air)
                {
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stone_stairs, this.getMetadataWithOffset(Blocks.stone_stairs, 3), 2, 0, -1, p_74875_3_);
                }

                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.air, 0, 6, 1, 5, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.air, 0, 6, 2, 5, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.torch, 0, 6, 3, 4, p_74875_3_);
                this.placeDoorAtCurrentPosition(p_74875_1_, p_74875_3_, p_74875_2_, 6, 1, 5, this.getMetadataWithOffset(Blocks.wooden_door, 1));

                for (k = 0; k < 5; ++k)
                {
                    for (l = 0; l < 9; ++l)
                    {
                        this.clearCurrentPositionBlocksUpwards(p_74875_1_, l, 7, k, p_74875_3_);
                        this.func_151554_b(p_74875_1_, Blocks.cobblestone, 0, l, -1, k, p_74875_3_);
                    }
                }

                this.spawnVillagers(p_74875_1_, p_74875_3_, 4, 1, 2, 2);
                return true;
            }

            /**
             * Returns the villager type to spawn in this component, based on the number of villagers already spawned.
             */
            protected int getVillagerType(int p_74888_1_)
            {
                return p_74888_1_ == 0 ? 4 : 0;
            }
        }

    public static class House1 extends VillageBuildings.Village
        {
            private static final String __OBFID = "CL_00000517";

            public House1() {}

            public House1(VillageBuildings.Start p_i2094_1_, int p_i2094_2_, Random p_i2094_3_, StructureBoundingBox p_i2094_4_, int p_i2094_5_)
            {
                super(p_i2094_1_, p_i2094_2_);
                this.coordBaseMode = p_i2094_5_;
                this.boundingBox = p_i2094_4_;
            }

            public static VillageBuildings.House1 func_74898_a(VillageBuildings.Start p_74898_0_, List p_74898_1_, Random p_74898_2_, int p_74898_3_, int p_74898_4_, int p_74898_5_, int p_74898_6_, int p_74898_7_)
            {
                StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_74898_3_, p_74898_4_, p_74898_5_, 0, 0, 0, 9, 9, 6, p_74898_6_);
                return canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(p_74898_1_, structureboundingbox) == null ? new VillageBuildings.House1(p_74898_0_, p_74898_7_, p_74898_2_, structureboundingbox, p_74898_6_) : null;
            }

            /**
             * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
             * Mineshafts at the end, it adds Fences...
             */
            public boolean addComponentParts(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
            {
                if (this.field_143015_k < 0)
                {
                    this.field_143015_k = this.getAverageGroundLevel(p_74875_1_, p_74875_3_);

                    if (this.field_143015_k < 0)
                    {
                        return true;
                    }

                    this.boundingBox.offset(0, this.field_143015_k - this.boundingBox.maxY + 9 - 1, 0);
                }

                this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 1, 1, 7, 5, 4, Blocks.air, Blocks.air, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 0, 0, 8, 0, 5, Blocks.cobblestone, Blocks.cobblestone, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 5, 0, 8, 5, 5, Blocks.cobblestone, Blocks.cobblestone, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 6, 1, 8, 6, 4, Blocks.cobblestone, Blocks.cobblestone, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 7, 2, 8, 7, 3, Blocks.cobblestone, Blocks.cobblestone, false);
                int i = this.getMetadataWithOffset(Blocks.oak_stairs, 3);
                int j = this.getMetadataWithOffset(Blocks.oak_stairs, 2);
                int k;
                int l;

                for (k = -1; k <= 2; ++k)
                {
                    for (l = 0; l <= 8; ++l)
                    {
                        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.oak_stairs, i, l, 6 + k, k, p_74875_3_);
                        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.oak_stairs, j, l, 6 + k, 5 - k, p_74875_3_);
                    }
                }

                this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 1, 0, 0, 1, 5, Blocks.cobblestone, Blocks.cobblestone, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 1, 5, 8, 1, 5, Blocks.cobblestone, Blocks.cobblestone, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 8, 1, 0, 8, 1, 4, Blocks.cobblestone, Blocks.cobblestone, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 2, 1, 0, 7, 1, 0, Blocks.cobblestone, Blocks.cobblestone, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 2, 0, 0, 4, 0, Blocks.cobblestone, Blocks.cobblestone, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 2, 5, 0, 4, 5, Blocks.cobblestone, Blocks.cobblestone, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 8, 2, 5, 8, 4, 5, Blocks.cobblestone, Blocks.cobblestone, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 8, 2, 0, 8, 4, 0, Blocks.cobblestone, Blocks.cobblestone, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 2, 1, 0, 4, 4, Blocks.planks, Blocks.planks, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 2, 5, 7, 4, 5, Blocks.planks, Blocks.planks, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 8, 2, 1, 8, 4, 4, Blocks.planks, Blocks.planks, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 2, 0, 7, 4, 0, Blocks.planks, Blocks.planks, false);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 4, 2, 0, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 5, 2, 0, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 6, 2, 0, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 4, 3, 0, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 5, 3, 0, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 6, 3, 0, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 0, 2, 2, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 0, 2, 3, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 0, 3, 2, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 0, 3, 3, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 8, 2, 2, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 8, 2, 3, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 8, 3, 2, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 8, 3, 3, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 2, 2, 5, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 3, 2, 5, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 5, 2, 5, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 6, 2, 5, p_74875_3_);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 4, 1, 7, 4, 1, Blocks.planks, Blocks.planks, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 4, 4, 7, 4, 4, Blocks.planks, Blocks.planks, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 3, 4, 7, 3, 4, Blocks.bookshelf, Blocks.bookshelf, false);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.planks, 0, 7, 1, 4, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.oak_stairs, this.getMetadataWithOffset(Blocks.oak_stairs, 0), 7, 1, 3, p_74875_3_);
                k = this.getMetadataWithOffset(Blocks.oak_stairs, 3);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.oak_stairs, k, 6, 1, 4, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.oak_stairs, k, 5, 1, 4, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.oak_stairs, k, 4, 1, 4, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.oak_stairs, k, 3, 1, 4, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.fence, 0, 6, 1, 3, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.wooden_pressure_plate, 0, 6, 2, 3, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.fence, 0, 4, 1, 3, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.wooden_pressure_plate, 0, 4, 2, 3, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.crafting_table, 0, 7, 1, 1, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.air, 0, 1, 1, 0, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.air, 0, 1, 2, 0, p_74875_3_);
                this.placeDoorAtCurrentPosition(p_74875_1_, p_74875_3_, p_74875_2_, 1, 1, 0, this.getMetadataWithOffset(Blocks.wooden_door, 1));

                if (this.getBlockAtCurrentPosition(p_74875_1_, 1, 0, -1, p_74875_3_).getMaterial() == Material.air && this.getBlockAtCurrentPosition(p_74875_1_, 1, -1, -1, p_74875_3_).getMaterial() != Material.air)
                {
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stone_stairs, this.getMetadataWithOffset(Blocks.stone_stairs, 3), 1, 0, -1, p_74875_3_);
                }

                for (l = 0; l < 6; ++l)
                {
                    for (int i1 = 0; i1 < 9; ++i1)
                    {
                        this.clearCurrentPositionBlocksUpwards(p_74875_1_, i1, 9, l, p_74875_3_);
                        this.func_151554_b(p_74875_1_, Blocks.cobblestone, 0, i1, -1, l, p_74875_3_);
                    }
                }

                this.spawnVillagers(p_74875_1_, p_74875_3_, 2, 1, 2, 1);
                return true;
            }

            /**
             * Returns the villager type to spawn in this component, based on the number of villagers already spawned.
             */
            protected int getVillagerType(int p_74888_1_)
            {
                return 1;
            }
        }

    public static class House2 extends VillageBuildings.Village
        {
            /** List of items that Village's Blacksmith chest can contain. */
            public static final WeightedRandomChestContent[] villageBlacksmithChestContents = new WeightedRandomChestContent[] {new WeightedRandomChestContent(Items.diamond, 0, 1, 3, 3), new WeightedRandomChestContent(Items.iron_ingot, 0, 1, 5, 10), new WeightedRandomChestContent(Items.gold_ingot, 0, 1, 3, 5), new WeightedRandomChestContent(Items.bread, 0, 1, 3, 15), new WeightedRandomChestContent(Items.apple, 0, 1, 3, 15), new WeightedRandomChestContent(Items.iron_pickaxe, 0, 1, 1, 5), new WeightedRandomChestContent(Items.iron_sword, 0, 1, 1, 5), new WeightedRandomChestContent(Items.iron_chestplate, 0, 1, 1, 5), new WeightedRandomChestContent(Items.iron_helmet, 0, 1, 1, 5), new WeightedRandomChestContent(Items.iron_leggings, 0, 1, 1, 5), new WeightedRandomChestContent(Items.iron_boots, 0, 1, 1, 5), new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.obsidian), 0, 3, 7, 5), new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.sapling), 0, 3, 7, 5), new WeightedRandomChestContent(Items.saddle, 0, 1, 1, 3), new WeightedRandomChestContent(Items.iron_horse_armor, 0, 1, 1, 1), new WeightedRandomChestContent(Items.golden_horse_armor, 0, 1, 1, 1), new WeightedRandomChestContent(Items.diamond_horse_armor, 0, 1, 1, 1)};
            private boolean hasMadeChest;
            private static final String __OBFID = "CL_00000526";

            public House2() {}

            public House2(VillageBuildings.Start p_i2103_1_, int p_i2103_2_, Random p_i2103_3_, StructureBoundingBox p_i2103_4_, int p_i2103_5_)
            {
                super(p_i2103_1_, p_i2103_2_);
                this.coordBaseMode = p_i2103_5_;
                this.boundingBox = p_i2103_4_;
            }

            public static VillageBuildings.House2 func_74915_a(VillageBuildings.Start p_74915_0_, List p_74915_1_, Random p_74915_2_, int p_74915_3_, int p_74915_4_, int p_74915_5_, int p_74915_6_, int p_74915_7_)
            {
                StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_74915_3_, p_74915_4_, p_74915_5_, 0, 0, 0, 10, 6, 7, p_74915_6_);
                return canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(p_74915_1_, structureboundingbox) == null ? new VillageBuildings.House2(p_74915_0_, p_74915_7_, p_74915_2_, structureboundingbox, p_74915_6_) : null;
            }

            protected void func_143012_a(NBTTagCompound p_143012_1_)
            {
                super.func_143012_a(p_143012_1_);
                p_143012_1_.setBoolean("Chest", this.hasMadeChest);
            }

            protected void func_143011_b(NBTTagCompound p_143011_1_)
            {
                super.func_143011_b(p_143011_1_);
                this.hasMadeChest = p_143011_1_.getBoolean("Chest");
            }

            /**
             * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
             * Mineshafts at the end, it adds Fences...
             */
            public boolean addComponentParts(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
            {
                if (this.field_143015_k < 0)
                {
                    this.field_143015_k = this.getAverageGroundLevel(p_74875_1_, p_74875_3_);

                    if (this.field_143015_k < 0)
                    {
                        return true;
                    }

                    this.boundingBox.offset(0, this.field_143015_k - this.boundingBox.maxY + 6 - 1, 0);
                }

                this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 1, 0, 9, 4, 6, Blocks.air, Blocks.air, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 0, 0, 9, 0, 6, Blocks.cobblestone, Blocks.cobblestone, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 4, 0, 9, 4, 6, Blocks.cobblestone, Blocks.cobblestone, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 5, 0, 9, 5, 6, Blocks.stone_slab, Blocks.stone_slab, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 5, 1, 8, 5, 5, Blocks.air, Blocks.air, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 1, 0, 2, 3, 0, Blocks.planks, Blocks.planks, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 1, 0, 0, 4, 0, Blocks.log, Blocks.log, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 3, 1, 0, 3, 4, 0, Blocks.log, Blocks.log, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 1, 6, 0, 4, 6, Blocks.log, Blocks.log, false);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.planks, 0, 3, 3, 1, p_74875_3_);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 3, 1, 2, 3, 3, 2, Blocks.planks, Blocks.planks, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 4, 1, 3, 5, 3, 3, Blocks.planks, Blocks.planks, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 1, 1, 0, 3, 5, Blocks.planks, Blocks.planks, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 1, 6, 5, 3, 6, Blocks.planks, Blocks.planks, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 5, 1, 0, 5, 3, 0, Blocks.fence, Blocks.fence, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 9, 1, 0, 9, 3, 0, Blocks.fence, Blocks.fence, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 6, 1, 4, 9, 4, 6, Blocks.cobblestone, Blocks.cobblestone, false);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.flowing_lava, 0, 7, 1, 5, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.flowing_lava, 0, 8, 1, 5, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.iron_bars, 0, 9, 2, 5, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.iron_bars, 0, 9, 2, 4, p_74875_3_);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 7, 2, 4, 8, 2, 5, Blocks.air, Blocks.air, false);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.cobblestone, 0, 6, 1, 3, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.furnace, 0, 6, 2, 3, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.furnace, 0, 6, 3, 3, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.double_stone_slab, 0, 8, 1, 1, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 0, 2, 2, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 0, 2, 4, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 2, 2, 6, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 4, 2, 6, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.fence, 0, 2, 1, 4, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.wooden_pressure_plate, 0, 2, 2, 4, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.planks, 0, 1, 1, 5, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.oak_stairs, this.getMetadataWithOffset(Blocks.oak_stairs, 3), 2, 1, 5, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.oak_stairs, this.getMetadataWithOffset(Blocks.oak_stairs, 1), 1, 1, 4, p_74875_3_);
                int i;
                int j;

                if (!this.hasMadeChest)
                {
                    i = this.getYWithOffset(1);
                    j = this.getXWithOffset(5, 5);
                    int k = this.getZWithOffset(5, 5);

                    if (p_74875_3_.isVecInside(j, i, k))
                    {
                        this.hasMadeChest = true;
                        this.generateStructureChestContents(p_74875_1_, p_74875_3_, p_74875_2_, 5, 1, 5, ChestGenHooks.getItems(VILLAGE_BLACKSMITH, p_74875_2_), ChestGenHooks.getCount(VILLAGE_BLACKSMITH, p_74875_2_));
                    }
                }

                for (i = 6; i <= 8; ++i)
                {
                    if (this.getBlockAtCurrentPosition(p_74875_1_, i, 0, -1, p_74875_3_).getMaterial() == Material.air && this.getBlockAtCurrentPosition(p_74875_1_, i, -1, -1, p_74875_3_).getMaterial() != Material.air)
                    {
                        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stone_stairs, this.getMetadataWithOffset(Blocks.stone_stairs, 3), i, 0, -1, p_74875_3_);
                    }
                }

                for (i = 0; i < 7; ++i)
                {
                    for (j = 0; j < 10; ++j)
                    {
                        this.clearCurrentPositionBlocksUpwards(p_74875_1_, j, 6, i, p_74875_3_);
                        this.func_151554_b(p_74875_1_, Blocks.cobblestone, 0, j, -1, i, p_74875_3_);
                    }
                }

                this.spawnVillagers(p_74875_1_, p_74875_3_, 7, 1, 1, 1);
                return true;
            }

            /**
             * Returns the villager type to spawn in this component, based on the number of villagers already spawned.
             */
            protected int getVillagerType(int p_74888_1_)
            {
                return 3;
            }
        }

    public static class House3 extends VillageBuildings.Village
        {
            private static final String __OBFID = "CL_00000530";

            public House3() {}

            public House3(VillageBuildings.Start p_i2106_1_, int p_i2106_2_, Random p_i2106_3_, StructureBoundingBox p_i2106_4_, int p_i2106_5_)
            {
                super(p_i2106_1_, p_i2106_2_);
                this.coordBaseMode = p_i2106_5_;
                this.boundingBox = p_i2106_4_;
            }

            public static VillageBuildings.House3 func_74921_a(VillageBuildings.Start p_74921_0_, List p_74921_1_, Random p_74921_2_, int p_74921_3_, int p_74921_4_, int p_74921_5_, int p_74921_6_, int p_74921_7_)
            {
                StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_74921_3_, p_74921_4_, p_74921_5_, 0, 0, 0, 9, 7, 12, p_74921_6_);
                return canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(p_74921_1_, structureboundingbox) == null ? new VillageBuildings.House3(p_74921_0_, p_74921_7_, p_74921_2_, structureboundingbox, p_74921_6_) : null;
            }

            /**
             * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
             * Mineshafts at the end, it adds Fences...
             */
            public boolean addComponentParts(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
            {
                if (this.field_143015_k < 0)
                {
                    this.field_143015_k = this.getAverageGroundLevel(p_74875_1_, p_74875_3_);

                    if (this.field_143015_k < 0)
                    {
                        return true;
                    }

                    this.boundingBox.offset(0, this.field_143015_k - this.boundingBox.maxY + 7 - 1, 0);
                }

                this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 1, 1, 7, 4, 4, Blocks.air, Blocks.air, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 2, 1, 6, 8, 4, 10, Blocks.air, Blocks.air, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 2, 0, 5, 8, 0, 10, Blocks.planks, Blocks.planks, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 0, 1, 7, 0, 4, Blocks.planks, Blocks.planks, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 0, 0, 0, 3, 5, Blocks.cobblestone, Blocks.cobblestone, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 8, 0, 0, 8, 3, 10, Blocks.cobblestone, Blocks.cobblestone, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 0, 0, 7, 2, 0, Blocks.cobblestone, Blocks.cobblestone, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 0, 5, 2, 1, 5, Blocks.cobblestone, Blocks.cobblestone, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 2, 0, 6, 2, 3, 10, Blocks.cobblestone, Blocks.cobblestone, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 3, 0, 10, 7, 3, 10, Blocks.cobblestone, Blocks.cobblestone, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 2, 0, 7, 3, 0, Blocks.planks, Blocks.planks, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 2, 5, 2, 3, 5, Blocks.planks, Blocks.planks, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 4, 1, 8, 4, 1, Blocks.planks, Blocks.planks, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 4, 4, 3, 4, 4, Blocks.planks, Blocks.planks, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 5, 2, 8, 5, 3, Blocks.planks, Blocks.planks, false);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.planks, 0, 0, 4, 2, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.planks, 0, 0, 4, 3, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.planks, 0, 8, 4, 2, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.planks, 0, 8, 4, 3, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.planks, 0, 8, 4, 4, p_74875_3_);
                int i = this.getMetadataWithOffset(Blocks.oak_stairs, 3);
                int j = this.getMetadataWithOffset(Blocks.oak_stairs, 2);
                int k;
                int l;

                for (k = -1; k <= 2; ++k)
                {
                    for (l = 0; l <= 8; ++l)
                    {
                        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.oak_stairs, i, l, 4 + k, k, p_74875_3_);

                        if ((k > -1 || l <= 1) && (k > 0 || l <= 3) && (k > 1 || l <= 4 || l >= 6))
                        {
                            this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.oak_stairs, j, l, 4 + k, 5 - k, p_74875_3_);
                        }
                    }
                }

                this.fillWithBlocks(p_74875_1_, p_74875_3_, 3, 4, 5, 3, 4, 10, Blocks.planks, Blocks.planks, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 7, 4, 2, 7, 4, 10, Blocks.planks, Blocks.planks, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 4, 5, 4, 4, 5, 10, Blocks.planks, Blocks.planks, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 6, 5, 4, 6, 5, 10, Blocks.planks, Blocks.planks, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 5, 6, 3, 5, 6, 10, Blocks.planks, Blocks.planks, false);
                k = this.getMetadataWithOffset(Blocks.oak_stairs, 0);
                int i1;

                for (l = 4; l >= 1; --l)
                {
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.planks, 0, l, 2 + l, 7 - l, p_74875_3_);

                    for (i1 = 8 - l; i1 <= 10; ++i1)
                    {
                        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.oak_stairs, k, l, 2 + l, i1, p_74875_3_);
                    }
                }

                l = this.getMetadataWithOffset(Blocks.oak_stairs, 1);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.planks, 0, 6, 6, 3, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.planks, 0, 7, 5, 4, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.oak_stairs, l, 6, 6, 4, p_74875_3_);
                int j1;

                for (i1 = 6; i1 <= 8; ++i1)
                {
                    for (j1 = 5; j1 <= 10; ++j1)
                    {
                        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.oak_stairs, l, i1, 12 - i1, j1, p_74875_3_);
                    }
                }

                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.log, 0, 0, 2, 1, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.log, 0, 0, 2, 4, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 0, 2, 2, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 0, 2, 3, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.log, 0, 4, 2, 0, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 5, 2, 0, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.log, 0, 6, 2, 0, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.log, 0, 8, 2, 1, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 8, 2, 2, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 8, 2, 3, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.log, 0, 8, 2, 4, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.planks, 0, 8, 2, 5, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.log, 0, 8, 2, 6, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 8, 2, 7, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 8, 2, 8, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.log, 0, 8, 2, 9, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.log, 0, 2, 2, 6, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 2, 2, 7, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 2, 2, 8, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.log, 0, 2, 2, 9, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.log, 0, 4, 4, 10, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 5, 4, 10, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.log, 0, 6, 4, 10, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.planks, 0, 5, 5, 10, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.air, 0, 2, 1, 0, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.air, 0, 2, 2, 0, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.torch, 0, 2, 3, 1, p_74875_3_);
                this.placeDoorAtCurrentPosition(p_74875_1_, p_74875_3_, p_74875_2_, 2, 1, 0, this.getMetadataWithOffset(Blocks.wooden_door, 1));
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 0, -1, 3, 2, -1, Blocks.air, Blocks.air, false);

                if (this.getBlockAtCurrentPosition(p_74875_1_, 2, 0, -1, p_74875_3_).getMaterial() == Material.air && this.getBlockAtCurrentPosition(p_74875_1_, 2, -1, -1, p_74875_3_).getMaterial() != Material.air)
                {
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stone_stairs, this.getMetadataWithOffset(Blocks.stone_stairs, 3), 2, 0, -1, p_74875_3_);
                }

                for (i1 = 0; i1 < 5; ++i1)
                {
                    for (j1 = 0; j1 < 9; ++j1)
                    {
                        this.clearCurrentPositionBlocksUpwards(p_74875_1_, j1, 7, i1, p_74875_3_);
                        this.func_151554_b(p_74875_1_, Blocks.cobblestone, 0, j1, -1, i1, p_74875_3_);
                    }
                }

                for (i1 = 5; i1 < 11; ++i1)
                {
                    for (j1 = 2; j1 < 9; ++j1)
                    {
                        this.clearCurrentPositionBlocksUpwards(p_74875_1_, j1, 7, i1, p_74875_3_);
                        this.func_151554_b(p_74875_1_, Blocks.cobblestone, 0, j1, -1, i1, p_74875_3_);
                    }
                }

                this.spawnVillagers(p_74875_1_, p_74875_3_, 4, 1, 2, 2);
                return true;
            }
        }

    public static class House4Garden extends VillageBuildings.Village
        {
            private boolean isRoofAccessible;
            private static final String __OBFID = "CL_00000523";

            public House4Garden() {}

            public House4Garden(VillageBuildings.Start p_i2100_1_, int p_i2100_2_, Random p_i2100_3_, StructureBoundingBox p_i2100_4_, int p_i2100_5_)
            {
                super(p_i2100_1_, p_i2100_2_);
                this.coordBaseMode = p_i2100_5_;
                this.boundingBox = p_i2100_4_;
                this.isRoofAccessible = p_i2100_3_.nextBoolean();
            }

            protected void func_143012_a(NBTTagCompound p_143012_1_)
            {
                super.func_143012_a(p_143012_1_);
                p_143012_1_.setBoolean("Terrace", this.isRoofAccessible);
            }

            protected void func_143011_b(NBTTagCompound p_143011_1_)
            {
                super.func_143011_b(p_143011_1_);
                this.isRoofAccessible = p_143011_1_.getBoolean("Terrace");
            }

            public static VillageBuildings.House4Garden func_74912_a(VillageBuildings.Start p_74912_0_, List p_74912_1_, Random p_74912_2_, int p_74912_3_, int p_74912_4_, int p_74912_5_, int p_74912_6_, int p_74912_7_)
            {
                StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_74912_3_, p_74912_4_, p_74912_5_, 0, 0, 0, 5, 6, 5, p_74912_6_);
                return StructureComponent.findIntersecting(p_74912_1_, structureboundingbox) != null ? null : new VillageBuildings.House4Garden(p_74912_0_, p_74912_7_, p_74912_2_, structureboundingbox, p_74912_6_);
            }

            /**
             * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
             * Mineshafts at the end, it adds Fences...
             */
            public boolean addComponentParts(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
            {
                if (this.field_143015_k < 0)
                {
                    this.field_143015_k = this.getAverageGroundLevel(p_74875_1_, p_74875_3_);

                    if (this.field_143015_k < 0)
                    {
                        return true;
                    }

                    this.boundingBox.offset(0, this.field_143015_k - this.boundingBox.maxY + 6 - 1, 0);
                }

                this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 0, 0, 4, 0, 4, Blocks.cobblestone, Blocks.cobblestone, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 4, 0, 4, 4, 4, Blocks.log, Blocks.log, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 4, 1, 3, 4, 3, Blocks.planks, Blocks.planks, false);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.cobblestone, 0, 0, 1, 0, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.cobblestone, 0, 0, 2, 0, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.cobblestone, 0, 0, 3, 0, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.cobblestone, 0, 4, 1, 0, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.cobblestone, 0, 4, 2, 0, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.cobblestone, 0, 4, 3, 0, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.cobblestone, 0, 0, 1, 4, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.cobblestone, 0, 0, 2, 4, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.cobblestone, 0, 0, 3, 4, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.cobblestone, 0, 4, 1, 4, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.cobblestone, 0, 4, 2, 4, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.cobblestone, 0, 4, 3, 4, p_74875_3_);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 1, 1, 0, 3, 3, Blocks.planks, Blocks.planks, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 4, 1, 1, 4, 3, 3, Blocks.planks, Blocks.planks, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 1, 4, 3, 3, 4, Blocks.planks, Blocks.planks, false);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 0, 2, 2, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 2, 2, 4, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 4, 2, 2, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.planks, 0, 1, 1, 0, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.planks, 0, 1, 2, 0, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.planks, 0, 1, 3, 0, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.planks, 0, 2, 3, 0, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.planks, 0, 3, 3, 0, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.planks, 0, 3, 2, 0, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.planks, 0, 3, 1, 0, p_74875_3_);

                if (this.getBlockAtCurrentPosition(p_74875_1_, 2, 0, -1, p_74875_3_).getMaterial() == Material.air && this.getBlockAtCurrentPosition(p_74875_1_, 2, -1, -1, p_74875_3_).getMaterial() != Material.air)
                {
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stone_stairs, this.getMetadataWithOffset(Blocks.stone_stairs, 3), 2, 0, -1, p_74875_3_);
                }

                this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 1, 1, 3, 3, 3, Blocks.air, Blocks.air, false);

                if (this.isRoofAccessible)
                {
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.fence, 0, 0, 5, 0, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.fence, 0, 1, 5, 0, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.fence, 0, 2, 5, 0, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.fence, 0, 3, 5, 0, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.fence, 0, 4, 5, 0, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.fence, 0, 0, 5, 4, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.fence, 0, 1, 5, 4, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.fence, 0, 2, 5, 4, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.fence, 0, 3, 5, 4, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.fence, 0, 4, 5, 4, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.fence, 0, 4, 5, 1, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.fence, 0, 4, 5, 2, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.fence, 0, 4, 5, 3, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.fence, 0, 0, 5, 1, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.fence, 0, 0, 5, 2, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.fence, 0, 0, 5, 3, p_74875_3_);
                }

                int i;

                if (this.isRoofAccessible)
                {
                    i = this.getMetadataWithOffset(Blocks.ladder, 3);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.ladder, i, 3, 1, 3, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.ladder, i, 3, 2, 3, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.ladder, i, 3, 3, 3, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.ladder, i, 3, 4, 3, p_74875_3_);
                }

                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.torch, 0, 2, 3, 1, p_74875_3_);

                for (i = 0; i < 5; ++i)
                {
                    for (int j = 0; j < 5; ++j)
                    {
                        this.clearCurrentPositionBlocksUpwards(p_74875_1_, j, 6, i, p_74875_3_);
                        this.func_151554_b(p_74875_1_, Blocks.cobblestone, 0, j, -1, i, p_74875_3_);
                    }
                }

                this.spawnVillagers(p_74875_1_, p_74875_3_, 1, 1, 2, 1);
                return true;
            }
        }

    public static class Path extends VillageBuildings.Road
        {
            private int averageGroundLevel;
            private static final String __OBFID = "CL_00000528";

            public Path() {}

            public Path(VillageBuildings.Start p_i2105_1_, int p_i2105_2_, Random p_i2105_3_, StructureBoundingBox p_i2105_4_, int p_i2105_5_)
            {
                super(p_i2105_1_, p_i2105_2_);
                this.coordBaseMode = p_i2105_5_;
                this.boundingBox = p_i2105_4_;
                this.averageGroundLevel = Math.max(p_i2105_4_.getXSize(), p_i2105_4_.getZSize());
            }

            protected void func_143012_a(NBTTagCompound p_143012_1_)
            {
                super.func_143012_a(p_143012_1_);
                p_143012_1_.setInteger("Length", this.averageGroundLevel);
            }

            protected void func_143011_b(NBTTagCompound p_143011_1_)
            {
                super.func_143011_b(p_143011_1_);
                this.averageGroundLevel = p_143011_1_.getInteger("Length");
            }

            /**
             * Initiates construction of the Structure Component picked, at the current Location of StructGen
             */
            public void buildComponent(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
            {
                boolean flag = false;
                int i;
                StructureComponent structurecomponent1;

                for (i = p_74861_3_.nextInt(5); i < this.averageGroundLevel - 8; i += 2 + p_74861_3_.nextInt(5))
                {
                    structurecomponent1 = this.getNextComponentNN((VillageBuildings.Start)p_74861_1_, p_74861_2_, p_74861_3_, 0, i);

                    if (structurecomponent1 != null)
                    {
                        i += Math.max(structurecomponent1.getBoundingBox().getXSize(), structurecomponent1.getBoundingBox().getZSize());
                        flag = true;
                    }
                }

                for (i = p_74861_3_.nextInt(5); i < this.averageGroundLevel - 8; i += 2 + p_74861_3_.nextInt(5))
                {
                    structurecomponent1 = this.getNextComponentPP((VillageBuildings.Start)p_74861_1_, p_74861_2_, p_74861_3_, 0, i);

                    if (structurecomponent1 != null)
                    {
                        i += Math.max(structurecomponent1.getBoundingBox().getXSize(), structurecomponent1.getBoundingBox().getZSize());
                        flag = true;
                    }
                }

                if (flag && p_74861_3_.nextInt(3) > 0)
                {
                    switch (this.coordBaseMode)
                    {
                        case 0:
                            VillageBuildings.getNextComponentVillagePath((VillageBuildings.Start)p_74861_1_, p_74861_2_, p_74861_3_, this.boundingBox.minX - 1, this.boundingBox.minY, this.boundingBox.maxZ - 2, 1, this.getComponentType());
                            break;
                        case 1:
                            VillageBuildings.getNextComponentVillagePath((VillageBuildings.Start)p_74861_1_, p_74861_2_, p_74861_3_, this.boundingBox.minX, this.boundingBox.minY, this.boundingBox.minZ - 1, 2, this.getComponentType());
                            break;
                        case 2:
                            VillageBuildings.getNextComponentVillagePath((VillageBuildings.Start)p_74861_1_, p_74861_2_, p_74861_3_, this.boundingBox.minX - 1, this.boundingBox.minY, this.boundingBox.minZ, 1, this.getComponentType());
                            break;
                        case 3:
                            VillageBuildings.getNextComponentVillagePath((VillageBuildings.Start)p_74861_1_, p_74861_2_, p_74861_3_, this.boundingBox.maxX - 2, this.boundingBox.minY, this.boundingBox.minZ - 1, 2, this.getComponentType());
                    }
                }

                if (flag && p_74861_3_.nextInt(3) > 0)
                {
                    switch (this.coordBaseMode)
                    {
                        case 0:
                            VillageBuildings.getNextComponentVillagePath((VillageBuildings.Start)p_74861_1_, p_74861_2_, p_74861_3_, this.boundingBox.maxX + 1, this.boundingBox.minY, this.boundingBox.maxZ - 2, 3, this.getComponentType());
                            break;
                        case 1:
                            VillageBuildings.getNextComponentVillagePath((VillageBuildings.Start)p_74861_1_, p_74861_2_, p_74861_3_, this.boundingBox.minX, this.boundingBox.minY, this.boundingBox.maxZ + 1, 0, this.getComponentType());
                            break;
                        case 2:
                            VillageBuildings.getNextComponentVillagePath((VillageBuildings.Start)p_74861_1_, p_74861_2_, p_74861_3_, this.boundingBox.maxX + 1, this.boundingBox.minY, this.boundingBox.minZ, 3, this.getComponentType());
                            break;
                        case 3:
                            VillageBuildings.getNextComponentVillagePath((VillageBuildings.Start)p_74861_1_, p_74861_2_, p_74861_3_, this.boundingBox.maxX - 2, this.boundingBox.minY, this.boundingBox.maxZ + 1, 0, this.getComponentType());
                    }
                }
            }

            public static StructureBoundingBox func_74933_a(VillageBuildings.Start p_74933_0_, List p_74933_1_, Random p_74933_2_, int p_74933_3_, int p_74933_4_, int p_74933_5_, int p_74933_6_)
            {
                for (int i1 = 7 * MathHelper.getRandomIntegerInRange(p_74933_2_, 3, 5); i1 >= 7; i1 -= 7)
                {
                    StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_74933_3_, p_74933_4_, p_74933_5_, 0, 0, 0, 3, 3, i1, p_74933_6_);

                    if (StructureComponent.findIntersecting(p_74933_1_, structureboundingbox) == null)
                    {
                        return structureboundingbox;
                    }
                }

                return null;
            }

            /**
             * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
             * Mineshafts at the end, it adds Fences...
             */
            public boolean addComponentParts(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
            {
                Block block = this.func_151558_b(Blocks.gravel, 0);

                for (int i = this.boundingBox.minX; i <= this.boundingBox.maxX; ++i)
                {
                    for (int j = this.boundingBox.minZ; j <= this.boundingBox.maxZ; ++j)
                    {
                        if (p_74875_3_.isVecInside(i, 64, j))
                        {
                            int k = p_74875_1_.getTopSolidOrLiquidBlock(i, j) - 1;
                            p_74875_1_.setBlock(i, k, j, block, 0, 2);
                        }
                    }
                }

                return true;
            }
        }

    public static class PieceWeight
        {
            /** The Class object for the represantation of this village piece. */
            public Class villagePieceClass;
            public final int villagePieceWeight;
            public int villagePiecesSpawned;
            public int villagePiecesLimit;
            private static final String __OBFID = "CL_00000521";

            public PieceWeight(Class p_i2098_1_, int p_i2098_2_, int p_i2098_3_)
            {
                this.villagePieceClass = p_i2098_1_;
                this.villagePieceWeight = p_i2098_2_;
                this.villagePiecesLimit = p_i2098_3_;
            }

            public boolean canSpawnMoreVillagePiecesOfType(int p_75085_1_)
            {
                return this.villagePiecesLimit == 0 || this.villagePiecesSpawned < this.villagePiecesLimit;
            }

            public boolean canSpawnMoreVillagePieces()
            {
                return this.villagePiecesLimit == 0 || this.villagePiecesSpawned < this.villagePiecesLimit;
            }
        }

    public abstract static class Road extends VillageBuildings.Village
        {
            private static final String __OBFID = "CL_00000532";

            public Road() {}

            protected Road(VillageBuildings.Start p_i2108_1_, int p_i2108_2_)
            {
                super(p_i2108_1_, p_i2108_2_);
            }
        }

    public static class Start extends VillageBuildings.Well
        {
            public WorldChunkManager worldChunkMngr;
            /** Boolean that determines if the village is in a desert or not. */
            public boolean inDesert;
            /** World terrain type, 0 for normal, 1 for flap map */
            public int terrainType;
            public VillageBuildings.PieceWeight structVillagePieceWeight;
            /**
             * Contains List of all spawnable Structure Piece Weights. If no more Pieces of a type can be spawned, they
             * are removed from this list
             */
            public List structureVillageWeightedPieceList;
            public List field_74932_i = new ArrayList();
            public List field_74930_j = new ArrayList();
            private static final String __OBFID = "CL_00000527";
            public BiomeGenBase biome;

            public Start() {}

            public Start(WorldChunkManager p_i2104_1_, int p_i2104_2_, Random p_i2104_3_, int p_i2104_4_, int p_i2104_5_, List p_i2104_6_, int p_i2104_7_)
            {
                super((VillageBuildings.Start)null, 0, p_i2104_3_, p_i2104_4_, p_i2104_5_);
                this.worldChunkMngr = p_i2104_1_;
                this.structureVillageWeightedPieceList = p_i2104_6_;
                this.terrainType = p_i2104_7_;
                BiomeGenBase biomegenbase = p_i2104_1_.getBiomeGenAt(p_i2104_4_, p_i2104_5_);
                this.inDesert = biomegenbase == BiomeGenBase.desert || biomegenbase == BiomeGenBase.desertHills;
                this.biome = biomegenbase;
            }

            public WorldChunkManager getWorldChunkManager()
            {
                return this.worldChunkMngr;
            }
        }

    public static class Torch extends VillageBuildings.Village
        {
            private static final String __OBFID = "CL_00000520";

            public Torch() {}

            public Torch(VillageBuildings.Start p_i2097_1_, int p_i2097_2_, Random p_i2097_3_, StructureBoundingBox p_i2097_4_, int p_i2097_5_)
            {
                super(p_i2097_1_, p_i2097_2_);
                this.coordBaseMode = p_i2097_5_;
                this.boundingBox = p_i2097_4_;
            }

            public static StructureBoundingBox func_74904_a(VillageBuildings.Start p_74904_0_, List p_74904_1_, Random p_74904_2_, int p_74904_3_, int p_74904_4_, int p_74904_5_, int p_74904_6_)
            {
                StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_74904_3_, p_74904_4_, p_74904_5_, 0, 0, 0, 3, 4, 2, p_74904_6_);
                return StructureComponent.findIntersecting(p_74904_1_, structureboundingbox) != null ? null : structureboundingbox;
            }

            /**
             * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
             * Mineshafts at the end, it adds Fences...
             */
            public boolean addComponentParts(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
            {
                if (this.field_143015_k < 0)
                {
                    this.field_143015_k = this.getAverageGroundLevel(p_74875_1_, p_74875_3_);

                    if (this.field_143015_k < 0)
                    {
                        return true;
                    }

                    this.boundingBox.offset(0, this.field_143015_k - this.boundingBox.maxY + 4 - 1, 0);
                }

                this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 0, 0, 2, 3, 1, Blocks.air, Blocks.air, false);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.fence, 0, 1, 0, 0, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.fence, 0, 1, 1, 0, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.fence, 0, 1, 2, 0, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.wool, 15, 1, 3, 0, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.torch, 0, 0, 3, 0, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.torch, 0, 1, 3, 1, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.torch, 0, 2, 3, 0, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.torch, 0, 1, 3, -1, p_74875_3_);
                return true;
            }
        }

    public abstract static class Village extends StructureComponent
        {
            protected int field_143015_k = -1;
            /** The number of villagers that have been spawned in this component. */
            private int villagersSpawned;
            private boolean field_143014_b;
            private static final String __OBFID = "CL_00000531";
            private VillageBuildings.Start startPiece;

            public Village() {}

            protected Village(VillageBuildings.Start p_i2107_1_, int p_i2107_2_)
            {
                super(p_i2107_2_);

                if (p_i2107_1_ != null)
                {
                    this.field_143014_b = p_i2107_1_.inDesert;
                    startPiece = p_i2107_1_;
                }
            }

            protected void func_143012_a(NBTTagCompound p_143012_1_)
            {
                p_143012_1_.setInteger("HPos", this.field_143015_k);
                p_143012_1_.setInteger("VCount", this.villagersSpawned);
                p_143012_1_.setBoolean("Desert", this.field_143014_b);
            }

            protected void func_143011_b(NBTTagCompound p_143011_1_)
            {
                this.field_143015_k = p_143011_1_.getInteger("HPos");
                this.villagersSpawned = p_143011_1_.getInteger("VCount");
                this.field_143014_b = p_143011_1_.getBoolean("Desert");
            }

            /**
             * Gets the next village component, with the bounding box shifted -1 in the X and Z direction.
             */
            protected StructureComponent getNextComponentNN(VillageBuildings.Start p_74891_1_, List p_74891_2_, Random p_74891_3_, int p_74891_4_, int p_74891_5_)
            {
                switch (this.coordBaseMode)
                {
                    case 0:
                        return VillageBuildings.getNextVillageStructureComponent(p_74891_1_, p_74891_2_, p_74891_3_, this.boundingBox.minX - 1, this.boundingBox.minY + p_74891_4_, this.boundingBox.minZ + p_74891_5_, 1, this.getComponentType());
                    case 1:
                        return VillageBuildings.getNextVillageStructureComponent(p_74891_1_, p_74891_2_, p_74891_3_, this.boundingBox.minX + p_74891_5_, this.boundingBox.minY + p_74891_4_, this.boundingBox.minZ - 1, 2, this.getComponentType());
                    case 2:
                        return VillageBuildings.getNextVillageStructureComponent(p_74891_1_, p_74891_2_, p_74891_3_, this.boundingBox.minX - 1, this.boundingBox.minY + p_74891_4_, this.boundingBox.minZ + p_74891_5_, 1, this.getComponentType());
                    case 3:
                        return VillageBuildings.getNextVillageStructureComponent(p_74891_1_, p_74891_2_, p_74891_3_, this.boundingBox.minX + p_74891_5_, this.boundingBox.minY + p_74891_4_, this.boundingBox.minZ - 1, 2, this.getComponentType());
                    default:
                        return null;
                }
            }

            /**
             * Gets the next village component, with the bounding box shifted +1 in the X and Z direction.
             */
            protected StructureComponent getNextComponentPP(VillageBuildings.Start p_74894_1_, List p_74894_2_, Random p_74894_3_, int p_74894_4_, int p_74894_5_)
            {
                switch (this.coordBaseMode)
                {
                    case 0:
                        return VillageBuildings.getNextVillageStructureComponent(p_74894_1_, p_74894_2_, p_74894_3_, this.boundingBox.maxX + 1, this.boundingBox.minY + p_74894_4_, this.boundingBox.minZ + p_74894_5_, 3, this.getComponentType());
                    case 1:
                        return VillageBuildings.getNextVillageStructureComponent(p_74894_1_, p_74894_2_, p_74894_3_, this.boundingBox.minX + p_74894_5_, this.boundingBox.minY + p_74894_4_, this.boundingBox.maxZ + 1, 0, this.getComponentType());
                    case 2:
                        return VillageBuildings.getNextVillageStructureComponent(p_74894_1_, p_74894_2_, p_74894_3_, this.boundingBox.maxX + 1, this.boundingBox.minY + p_74894_4_, this.boundingBox.minZ + p_74894_5_, 3, this.getComponentType());
                    case 3:
                        return VillageBuildings.getNextVillageStructureComponent(p_74894_1_, p_74894_2_, p_74894_3_, this.boundingBox.minX + p_74894_5_, this.boundingBox.minY + p_74894_4_, this.boundingBox.maxZ + 1, 0, this.getComponentType());
                    default:
                        return null;
                }
            }

            /**
             * Discover the y coordinate that will serve as the ground level of the supplied BoundingBox. (A median of
             * all the levels in the BB's horizontal rectangle).
             */
            protected int getAverageGroundLevel(World p_74889_1_, StructureBoundingBox p_74889_2_)
            {
                int i = 0;
                int j = 0;

                for (int k = this.boundingBox.minZ; k <= this.boundingBox.maxZ; ++k)
                {
                    for (int l = this.boundingBox.minX; l <= this.boundingBox.maxX; ++l)
                    {
                        if (p_74889_2_.isVecInside(l, 64, k))
                        {
                            i += Math.max(p_74889_1_.getTopSolidOrLiquidBlock(l, k), p_74889_1_.provider.getAverageGroundLevel());
                            ++j;
                        }
                    }
                }

                if (j == 0)
                {
                    return -1;
                }
                else
                {
                    return i / j;
                }
            }

            protected static boolean canVillageGoDeeper(StructureBoundingBox p_74895_0_)
            {
                return p_74895_0_ != null && p_74895_0_.minY > 10;
            }

            /**
             * Spawns a number of villagers in this component. Parameters: world, component bounding box, x offset, y
             * offset, z offset, number of villagers
             */
            protected void spawnVillagers(World p_74893_1_, StructureBoundingBox p_74893_2_, int p_74893_3_, int p_74893_4_, int p_74893_5_, int p_74893_6_)
            {
                if (this.villagersSpawned < p_74893_6_)
                {
                    for (int i1 = this.villagersSpawned; i1 < p_74893_6_; ++i1)
                    {
                        int j1 = this.getXWithOffset(p_74893_3_ + i1, p_74893_5_);
                        int k1 = this.getYWithOffset(p_74893_4_);
                        int l1 = this.getZWithOffset(p_74893_3_ + i1, p_74893_5_);

                        if (!p_74893_2_.isVecInside(j1, k1, l1))
                        {
                            break;
                        }

                        ++this.villagersSpawned;
                        EntityVillager entityvillager = new EntityVillager(p_74893_1_, this.getVillagerType(i1));
                        entityvillager.setLocationAndAngles((double)j1 + 0.5D, (double)k1, (double)l1 + 0.5D, 0.0F, 0.0F);
                        p_74893_1_.spawnEntityInWorld(entityvillager);
                    }
                }
            }

            /**
             * Returns the villager type to spawn in this component, based on the number of villagers already spawned.
             */
            protected int getVillagerType(int p_74888_1_)
            {
                return 0;
            }

            protected Block func_151558_b(Block p_151558_1_, int p_151558_2_)
            {
                BiomeEvent.GetVillageBlockID event = new BiomeEvent.GetVillageBlockID(startPiece == null ? null : startPiece.biome, p_151558_1_, p_151558_2_);
                MinecraftForge.TERRAIN_GEN_BUS.post(event);
                if (event.getResult() == Result.DENY) return event.replacement;
                if (this.field_143014_b)
                {
                    if (p_151558_1_ == Blocks.log || p_151558_1_ == Blocks.log2)
                    {
                        return Blocks.sandstone;
                    }

                    if (p_151558_1_ == Blocks.cobblestone)
                    {
                        return Blocks.sandstone;
                    }

                    if (p_151558_1_ == Blocks.planks)
                    {
                        return Blocks.sandstone;
                    }

                    if (p_151558_1_ == Blocks.oak_stairs)
                    {
                        return Blocks.sandstone_stairs;
                    }

                    if (p_151558_1_ == Blocks.stone_stairs)
                    {
                        return Blocks.sandstone_stairs;
                    }

                    if (p_151558_1_ == Blocks.gravel)
                    {
                        return Blocks.sandstone;
                    }
                }

                return p_151558_1_;
            }

            protected int func_151557_c(Block p_151557_1_, int p_151557_2_)
            {
                BiomeEvent.GetVillageBlockMeta event = new BiomeEvent.GetVillageBlockMeta(startPiece == null ? null : startPiece.biome, p_151557_1_, p_151557_2_);
                MinecraftForge.TERRAIN_GEN_BUS.post(event);
                if (event.getResult() == Result.DENY) return event.replacement;
                if (this.field_143014_b)
                {
                    if (p_151557_1_ == Blocks.log || p_151557_1_ == Blocks.log2)
                    {
                        return 0;
                    }

                    if (p_151557_1_ == Blocks.cobblestone)
                    {
                        return 0;
                    }

                    if (p_151557_1_ == Blocks.planks)
                    {
                        return 2;
                    }
                }

                return p_151557_2_;
            }

            /**
             * current Position depends on currently set Coordinates mode, is computed here
             */
            protected void placeBlockAtCurrentPosition(World p_151550_1_, Block p_151550_2_, int p_151550_3_, int p_151550_4_, int p_151550_5_, int p_151550_6_, StructureBoundingBox p_151550_7_)
            {
                Block block1 = this.func_151558_b(p_151550_2_, p_151550_3_);
                int i1 = this.func_151557_c(p_151550_2_, p_151550_3_);
                super.placeBlockAtCurrentPosition(p_151550_1_, block1, i1, p_151550_4_, p_151550_5_, p_151550_6_, p_151550_7_);
            }

            /**
             * arguments: (World worldObj, StructureBoundingBox structBB, int minX, int minY, int minZ, int maxX, int
             * maxY, int maxZ, int placeBlock, int replaceBlock, boolean alwaysreplace)
             */
            protected void fillWithBlocks(World p_151549_1_, StructureBoundingBox p_151549_2_, int p_151549_3_, int p_151549_4_, int p_151549_5_, int p_151549_6_, int p_151549_7_, int p_151549_8_, Block p_151549_9_, Block p_151549_10_, boolean p_151549_11_)
            {
                Block block2 = this.func_151558_b(p_151549_9_, 0);
                int k1 = this.func_151557_c(p_151549_9_, 0);
                Block block3 = this.func_151558_b(p_151549_10_, 0);
                int l1 = this.func_151557_c(p_151549_10_, 0);
                super.fillWithMetadataBlocks(p_151549_1_, p_151549_2_, p_151549_3_, p_151549_4_, p_151549_5_, p_151549_6_, p_151549_7_, p_151549_8_, block2, k1, block3, l1, p_151549_11_);
            }

            protected void func_151554_b(World p_151554_1_, Block p_151554_2_, int p_151554_3_, int p_151554_4_, int p_151554_5_, int p_151554_6_, StructureBoundingBox p_151554_7_)
            {
                Block block1 = this.func_151558_b(p_151554_2_, p_151554_3_);
                int i1 = this.func_151557_c(p_151554_2_, p_151554_3_);
                super.func_151554_b(p_151554_1_, block1, i1, p_151554_4_, p_151554_5_, p_151554_6_, p_151554_7_);
            }
        }

    public static class Well extends VillageBuildings.Village
        {
            private static final String __OBFID = "CL_00000533";

            public Well() {}

            public Well(VillageBuildings.Start p_i2109_1_, int p_i2109_2_, Random p_i2109_3_, int p_i2109_4_, int p_i2109_5_)
            {
                super(p_i2109_1_, p_i2109_2_);
                this.coordBaseMode = p_i2109_3_.nextInt(4);

                switch (this.coordBaseMode)
                {
                    case 0:
                    case 2:
                        this.boundingBox = new StructureBoundingBox(p_i2109_4_, 64, p_i2109_5_, p_i2109_4_ + 6 - 1, 78, p_i2109_5_ + 6 - 1);
                        break;
                    default:
                        this.boundingBox = new StructureBoundingBox(p_i2109_4_, 64, p_i2109_5_, p_i2109_4_ + 6 - 1, 78, p_i2109_5_ + 6 - 1);
                }
            }

            /**
             * Initiates construction of the Structure Component picked, at the current Location of StructGen
             */
            public void buildComponent(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
            {
                VillageBuildings.getNextComponentVillagePath((VillageBuildings.Start)p_74861_1_, p_74861_2_, p_74861_3_, this.boundingBox.minX - 1, this.boundingBox.maxY - 4, this.boundingBox.minZ + 1, 1, this.getComponentType());
                VillageBuildings.getNextComponentVillagePath((VillageBuildings.Start)p_74861_1_, p_74861_2_, p_74861_3_, this.boundingBox.maxX + 1, this.boundingBox.maxY - 4, this.boundingBox.minZ + 1, 3, this.getComponentType());
                VillageBuildings.getNextComponentVillagePath((VillageBuildings.Start)p_74861_1_, p_74861_2_, p_74861_3_, this.boundingBox.minX + 1, this.boundingBox.maxY - 4, this.boundingBox.minZ - 1, 2, this.getComponentType());
                VillageBuildings.getNextComponentVillagePath((VillageBuildings.Start)p_74861_1_, p_74861_2_, p_74861_3_, this.boundingBox.minX + 1, this.boundingBox.maxY - 4, this.boundingBox.maxZ + 1, 0, this.getComponentType());
            }
            
            public void setBlock(World world, int x, int y, int z, Block block, int metadata)
        	{
        		Block b1 = world.getBlock(x, y, z);

        		if(b1.isAir(world, x, y, z) || b1.isLeaves(world, x, y, z))
        		{
        			world.setBlock(x, y, z, block, metadata, 2);
        		}
        	}

            /**
             * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
             * Mineshafts at the end, it adds Fences...
             */
            public boolean addComponentParts(World world, Random p_74875_2_, StructureBoundingBox p_74875_3_)
            {
                if (this.field_143015_k < 0)
                {
                    this.field_143015_k = this.getAverageGroundLevel(world, p_74875_3_);

                    if (this.field_143015_k < 0)
                    {
                        return true;
                    }

                    this.boundingBox.offset(0, this.field_143015_k - this.boundingBox.maxY + 3, 0);
                }
                

                this.setBlock(world, this.boundingBox.minX + 0, this.boundingBox.minY + 0, this.boundingBox.minZ + 12, Blocks.dirt, 1);
        		this.setBlock(world, this.boundingBox.minX + 0, this.boundingBox.minY + 1, this.boundingBox.minZ + 12, Blocks.dirt, 1);
        		this.setBlock(world, this.boundingBox.minX + 0, this.boundingBox.minY + 2, this.boundingBox.minZ + 12, Blocks.dirt, 1);
        		this.setBlock(world, this.boundingBox.minX + 0, this.boundingBox.minY + 3, this.boundingBox.minZ + 12, Blocks.dirt, 1);
        		this.setBlock(world, this.boundingBox.minX + 0, this.boundingBox.minY + 4, this.boundingBox.minZ + 12, Blocks.dirt, 0);
        		this.setBlock(world, this.boundingBox.minX + 0, this.boundingBox.minY + 5, this.boundingBox.minZ + 12, Blocks.dirt, 0);
        		this.setBlock(world, this.boundingBox.minX + 0, this.boundingBox.minY + 6, this.boundingBox.minZ + 12, Blocks.dirt, 0);
        		this.setBlock(world, this.boundingBox.minX + 0, this.boundingBox.minY + 7, this.boundingBox.minZ + 1, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 0, this.boundingBox.minY + 7, this.boundingBox.minZ + 2, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 0, this.boundingBox.minY + 7, this.boundingBox.minZ + 3, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 0, this.boundingBox.minY + 7, this.boundingBox.minZ + 4, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 0, this.boundingBox.minY + 7, this.boundingBox.minZ + 5, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 0, this.boundingBox.minY + 7, this.boundingBox.minZ + 6, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 0, this.boundingBox.minY + 7, this.boundingBox.minZ + 12, Blocks.grass, 0);
        		this.setBlock(world, this.boundingBox.minX + 0, this.boundingBox.minY + 8, this.boundingBox.minZ + 1, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 0, this.boundingBox.minY + 8, this.boundingBox.minZ + 2, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 0, this.boundingBox.minY + 8, this.boundingBox.minZ + 3, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 0, this.boundingBox.minY + 8, this.boundingBox.minZ + 4, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 0, this.boundingBox.minY + 8, this.boundingBox.minZ + 5, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 0, this.boundingBox.minY + 8, this.boundingBox.minZ + 6, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 0, this.boundingBox.minY + 9, this.boundingBox.minZ + 1, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 0, this.boundingBox.minY + 9, this.boundingBox.minZ + 2, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 0, this.boundingBox.minY + 9, this.boundingBox.minZ + 3, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 0, this.boundingBox.minY + 9, this.boundingBox.minZ + 4, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 0, this.boundingBox.minY + 9, this.boundingBox.minZ + 5, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 0, this.boundingBox.minY + 9, this.boundingBox.minZ + 6, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 0, this.boundingBox.minY + 10, this.boundingBox.minZ + 1, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 0, this.boundingBox.minY + 10, this.boundingBox.minZ + 2, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 0, this.boundingBox.minY + 10, this.boundingBox.minZ + 3, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 0, this.boundingBox.minY + 10, this.boundingBox.minZ + 4, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 0, this.boundingBox.minY + 10, this.boundingBox.minZ + 5, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 0, this.boundingBox.minY + 10, this.boundingBox.minZ + 6, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 1, this.boundingBox.minY + 0, this.boundingBox.minZ + 3, Blocks.air, 4);
        		this.setBlock(world, this.boundingBox.minX + 1, this.boundingBox.minY + 0, this.boundingBox.minZ + 4, Blocks.air, 4);
        		this.setBlock(world, this.boundingBox.minX + 1, this.boundingBox.minY + 0, this.boundingBox.minZ + 12, Blocks.dirt, 1);
        		this.setBlock(world, this.boundingBox.minX + 1, this.boundingBox.minY + 1, this.boundingBox.minZ + 12, Blocks.dirt, 1);
        		this.setBlock(world, this.boundingBox.minX + 1, this.boundingBox.minY + 2, this.boundingBox.minZ + 12, Blocks.dirt, 1);
        		this.setBlock(world, this.boundingBox.minX + 1, this.boundingBox.minY + 3, this.boundingBox.minZ + 12, Blocks.dirt, 1);
        		this.setBlock(world, this.boundingBox.minX + 1, this.boundingBox.minY + 4, this.boundingBox.minZ + 12, Blocks.dirt, 0);
        		this.setBlock(world, this.boundingBox.minX + 1, this.boundingBox.minY + 5, this.boundingBox.minZ + 0, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 1, this.boundingBox.minY + 5, this.boundingBox.minZ + 1, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 1, this.boundingBox.minY + 5, this.boundingBox.minZ + 2, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 1, this.boundingBox.minY + 5, this.boundingBox.minZ + 3, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 1, this.boundingBox.minY + 5, this.boundingBox.minZ + 4, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 1, this.boundingBox.minY + 5, this.boundingBox.minZ + 5, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 1, this.boundingBox.minY + 5, this.boundingBox.minZ + 6, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 1, this.boundingBox.minY + 5, this.boundingBox.minZ + 7, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 1, this.boundingBox.minY + 5, this.boundingBox.minZ + 12, Blocks.dirt, 0);
        		this.setBlock(world, this.boundingBox.minX + 1, this.boundingBox.minY + 6, this.boundingBox.minZ + 0, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 1, this.boundingBox.minY + 6, this.boundingBox.minZ + 1, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 1, this.boundingBox.minY + 6, this.boundingBox.minZ + 2, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 1, this.boundingBox.minY + 6, this.boundingBox.minZ + 3, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 1, this.boundingBox.minY + 6, this.boundingBox.minZ + 4, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 1, this.boundingBox.minY + 6, this.boundingBox.minZ + 5, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 1, this.boundingBox.minY + 6, this.boundingBox.minZ + 6, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 1, this.boundingBox.minY + 6, this.boundingBox.minZ + 7, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 1, this.boundingBox.minY + 6, this.boundingBox.minZ + 12, Blocks.dirt, 0);
        		this.setBlock(world, this.boundingBox.minX + 1, this.boundingBox.minY + 7, this.boundingBox.minZ + 0, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 1, this.boundingBox.minY + 7, this.boundingBox.minZ + 1, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 1, this.boundingBox.minY + 7, this.boundingBox.minZ + 2, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 1, this.boundingBox.minY + 7, this.boundingBox.minZ + 3, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 1, this.boundingBox.minY + 7, this.boundingBox.minZ + 4, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 1, this.boundingBox.minY + 7, this.boundingBox.minZ + 5, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 1, this.boundingBox.minY + 7, this.boundingBox.minZ + 6, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 1, this.boundingBox.minY + 7, this.boundingBox.minZ + 7, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 1, this.boundingBox.minY + 7, this.boundingBox.minZ + 12, Blocks.dirt, 0);
        		this.setBlock(world, this.boundingBox.minX + 1, this.boundingBox.minY + 8, this.boundingBox.minZ + 0, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 1, this.boundingBox.minY + 8, this.boundingBox.minZ + 1, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 1, this.boundingBox.minY + 8, this.boundingBox.minZ + 2, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 1, this.boundingBox.minY + 8, this.boundingBox.minZ + 3, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 1, this.boundingBox.minY + 8, this.boundingBox.minZ + 4, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 1, this.boundingBox.minY + 8, this.boundingBox.minZ + 5, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 1, this.boundingBox.minY + 8, this.boundingBox.minZ + 6, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 1, this.boundingBox.minY + 8, this.boundingBox.minZ + 7, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 1, this.boundingBox.minY + 8, this.boundingBox.minZ + 12, Blocks.grass, 0);
        		this.setBlock(world, this.boundingBox.minX + 1, this.boundingBox.minY + 9, this.boundingBox.minZ + 0, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 1, this.boundingBox.minY + 9, this.boundingBox.minZ + 1, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 1, this.boundingBox.minY + 9, this.boundingBox.minZ + 2, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 1, this.boundingBox.minY + 9, this.boundingBox.minZ + 3, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 1, this.boundingBox.minY + 9, this.boundingBox.minZ + 4, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 1, this.boundingBox.minY + 9, this.boundingBox.minZ + 5, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 1, this.boundingBox.minY + 9, this.boundingBox.minZ + 6, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 1, this.boundingBox.minY + 9, this.boundingBox.minZ + 7, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 1, this.boundingBox.minY + 10, this.boundingBox.minZ + 0, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 1, this.boundingBox.minY + 10, this.boundingBox.minZ + 1, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 1, this.boundingBox.minY + 10, this.boundingBox.minZ + 2, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 1, this.boundingBox.minY + 10, this.boundingBox.minZ + 3, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 1, this.boundingBox.minY + 10, this.boundingBox.minZ + 4, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 1, this.boundingBox.minY + 10, this.boundingBox.minZ + 5, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 1, this.boundingBox.minY + 10, this.boundingBox.minZ + 6, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 1, this.boundingBox.minY + 10, this.boundingBox.minZ + 7, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 0, this.boundingBox.minZ + 3, Blocks.air, 4);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 0, this.boundingBox.minZ + 4, Blocks.air, 4);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 0, this.boundingBox.minZ + 5, Blocks.air, 4);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 0, this.boundingBox.minZ + 12, Blocks.dirt, 1);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 1, this.boundingBox.minZ + 3, Blocks.air, 4);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 1, this.boundingBox.minZ + 12, Blocks.dirt, 1);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 2, this.boundingBox.minZ + 3, Blocks.air, 4);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 2, this.boundingBox.minZ + 12, Blocks.dirt, 1);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 3, this.boundingBox.minZ + 3, Blocks.air, 4);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 3, this.boundingBox.minZ + 12, Blocks.dirt, 1);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 4, this.boundingBox.minZ + 3, Blocks.air, 4);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 4, this.boundingBox.minZ + 12, Blocks.dirt, 0);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 5, this.boundingBox.minZ + 0, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 5, this.boundingBox.minZ + 1, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 5, this.boundingBox.minZ + 2, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 5, this.boundingBox.minZ + 3, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 5, this.boundingBox.minZ + 4, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 5, this.boundingBox.minZ + 5, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 5, this.boundingBox.minZ + 6, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 5, this.boundingBox.minZ + 7, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 5, this.boundingBox.minZ + 12, Blocks.dirt, 0);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 6, this.boundingBox.minZ + 0, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 6, this.boundingBox.minZ + 7, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 6, this.boundingBox.minZ + 12, Blocks.dirt, 0);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 7, this.boundingBox.minZ + 0, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 7, this.boundingBox.minZ + 7, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 7, this.boundingBox.minZ + 12, Blocks.dirt, 0);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 8, this.boundingBox.minZ + 0, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 8, this.boundingBox.minZ + 7, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 8, this.boundingBox.minZ + 12, Blocks.dirt, 0);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 9, this.boundingBox.minZ + 0, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 9, this.boundingBox.minZ + 7, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 9, this.boundingBox.minZ + 8, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 9, this.boundingBox.minZ + 9, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 9, this.boundingBox.minZ + 12, Blocks.grass, 0);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 10, this.boundingBox.minZ + 0, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 10, this.boundingBox.minZ + 1, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 10, this.boundingBox.minZ + 2, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 10, this.boundingBox.minZ + 3, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 10, this.boundingBox.minZ + 4, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 10, this.boundingBox.minZ + 5, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 10, this.boundingBox.minZ + 6, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 10, this.boundingBox.minZ + 7, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 10, this.boundingBox.minZ + 8, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 10, this.boundingBox.minZ + 9, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 11, this.boundingBox.minZ + 7, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 11, this.boundingBox.minZ + 8, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 11, this.boundingBox.minZ + 9, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 11, this.boundingBox.minZ + 10, Blocks.air, 4);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 11, this.boundingBox.minZ + 11, Blocks.air, 4);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 12, this.boundingBox.minZ + 7, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 12, this.boundingBox.minZ + 8, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 12, this.boundingBox.minZ + 9, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 12, this.boundingBox.minZ + 10, Blocks.wool, 4);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 12, this.boundingBox.minZ + 11, Blocks.wool, 4);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 13, this.boundingBox.minZ + 7, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 13, this.boundingBox.minZ + 8, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 13, this.boundingBox.minZ + 9, Blocks.wool, 15);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 14, this.boundingBox.minZ + 7, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 14, this.boundingBox.minZ + 8, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 14, this.boundingBox.minZ + 9, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 0, this.boundingBox.minZ + 3, Blocks.air, 4);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 0, this.boundingBox.minZ + 4, Blocks.air, 4);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 0, this.boundingBox.minZ + 12, Blocks.dirt, 1);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 1, this.boundingBox.minZ + 12, Blocks.dirt, 1);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 2, this.boundingBox.minZ + 12, Blocks.dirt, 1);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 3, this.boundingBox.minZ + 12, Blocks.dirt, 1);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 4, this.boundingBox.minZ + 12, Blocks.dirt, 0);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 5, this.boundingBox.minZ + 0, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 5, this.boundingBox.minZ + 1, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 5, this.boundingBox.minZ + 2, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 5, this.boundingBox.minZ + 3, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 5, this.boundingBox.minZ + 4, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 5, this.boundingBox.minZ + 5, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 5, this.boundingBox.minZ + 6, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 5, this.boundingBox.minZ + 7, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 5, this.boundingBox.minZ + 12, Blocks.dirt, 0);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 6, this.boundingBox.minZ + 0, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 6, this.boundingBox.minZ + 3, MoChickens.blockFeatherBlock, 0);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 6, this.boundingBox.minZ + 4, MoChickens.blockFeatherBlock, 0);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 6, this.boundingBox.minZ + 7, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 6, this.boundingBox.minZ + 12, Blocks.dirt, 0);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 7, this.boundingBox.minZ + 0, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 7, this.boundingBox.minZ + 7, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 7, this.boundingBox.minZ + 12, Blocks.dirt, 0);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 8, this.boundingBox.minZ + 0, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 8, this.boundingBox.minZ + 7, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 8, this.boundingBox.minZ + 12, Blocks.dirt, 0);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 9, this.boundingBox.minZ + 0, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 9, this.boundingBox.minZ + 7, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 9, this.boundingBox.minZ + 8, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 9, this.boundingBox.minZ + 9, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 9, this.boundingBox.minZ + 10, Blocks.air, 14);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 9, this.boundingBox.minZ + 12, Blocks.dirt, 0);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 10, this.boundingBox.minZ + 0, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 10, this.boundingBox.minZ + 1, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 10, this.boundingBox.minZ + 2, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 10, this.boundingBox.minZ + 3, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 10, this.boundingBox.minZ + 4, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 10, this.boundingBox.minZ + 5, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 10, this.boundingBox.minZ + 6, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 10, this.boundingBox.minZ + 7, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 10, this.boundingBox.minZ + 8, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 10, this.boundingBox.minZ + 9, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 10, this.boundingBox.minZ + 10, Blocks.air, 14);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 10, this.boundingBox.minZ + 12, Blocks.grass, 0);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 11, this.boundingBox.minZ + 7, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 11, this.boundingBox.minZ + 8, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 11, this.boundingBox.minZ + 9, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 11, this.boundingBox.minZ + 10, Blocks.air, 4);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 11, this.boundingBox.minZ + 11, Blocks.air, 4);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 12, this.boundingBox.minZ + 7, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 12, this.boundingBox.minZ + 8, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 12, this.boundingBox.minZ + 9, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 12, this.boundingBox.minZ + 10, Blocks.wool, 4);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 12, this.boundingBox.minZ + 11, Blocks.wool, 4);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 13, this.boundingBox.minZ + 7, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 13, this.boundingBox.minZ + 8, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 13, this.boundingBox.minZ + 9, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 14, this.boundingBox.minZ + 7, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 14, this.boundingBox.minZ + 8, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 14, this.boundingBox.minZ + 9, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 0, this.boundingBox.minZ + 3, Blocks.air, 4);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 0, this.boundingBox.minZ + 4, Blocks.air, 4);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 0, this.boundingBox.minZ + 12, Blocks.dirt, 1);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 1, this.boundingBox.minZ + 12, Blocks.dirt, 1);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 2, this.boundingBox.minZ + 12, Blocks.dirt, 1);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 3, this.boundingBox.minZ + 12, Blocks.dirt, 1);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 4, this.boundingBox.minZ + 12, Blocks.dirt, 0);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 5, this.boundingBox.minZ + 0, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 5, this.boundingBox.minZ + 1, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 5, this.boundingBox.minZ + 2, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 5, this.boundingBox.minZ + 3, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 5, this.boundingBox.minZ + 4, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 5, this.boundingBox.minZ + 5, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 5, this.boundingBox.minZ + 6, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 5, this.boundingBox.minZ + 7, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 5, this.boundingBox.minZ + 12, Blocks.dirt, 0);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 6, this.boundingBox.minZ + 0, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 6, this.boundingBox.minZ + 3, MoChickens.blockFeatherBlock, 0);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 6, this.boundingBox.minZ + 4, MoChickens.blockFeatherBlock, 0);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 6, this.boundingBox.minZ + 7, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 6, this.boundingBox.minZ + 12, Blocks.dirt, 0);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 7, this.boundingBox.minZ + 0, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 7, this.boundingBox.minZ + 7, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 7, this.boundingBox.minZ + 12, Blocks.dirt, 0);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 8, this.boundingBox.minZ + 0, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 8, this.boundingBox.minZ + 7, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 8, this.boundingBox.minZ + 12, Blocks.dirt, 0);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 9, this.boundingBox.minZ + 0, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 9, this.boundingBox.minZ + 7, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 9, this.boundingBox.minZ + 8, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 9, this.boundingBox.minZ + 9, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 9, this.boundingBox.minZ + 10, Blocks.air, 14);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 9, this.boundingBox.minZ + 12, Blocks.grass, 0);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 10, this.boundingBox.minZ + 0, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 10, this.boundingBox.minZ + 1, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 10, this.boundingBox.minZ + 2, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 10, this.boundingBox.minZ + 3, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 10, this.boundingBox.minZ + 4, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 10, this.boundingBox.minZ + 5, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 10, this.boundingBox.minZ + 6, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 10, this.boundingBox.minZ + 7, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 10, this.boundingBox.minZ + 8, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 10, this.boundingBox.minZ + 9, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 10, this.boundingBox.minZ + 10, Blocks.air, 14);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 11, this.boundingBox.minZ + 7, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 11, this.boundingBox.minZ + 8, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 11, this.boundingBox.minZ + 9, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 11, this.boundingBox.minZ + 10, Blocks.air, 4);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 11, this.boundingBox.minZ + 11, Blocks.air, 4);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 12, this.boundingBox.minZ + 7, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 12, this.boundingBox.minZ + 8, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 12, this.boundingBox.minZ + 9, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 12, this.boundingBox.minZ + 10, Blocks.wool, 4);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 12, this.boundingBox.minZ + 11, Blocks.wool, 4);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 13, this.boundingBox.minZ + 7, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 13, this.boundingBox.minZ + 8, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 13, this.boundingBox.minZ + 9, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 14, this.boundingBox.minZ + 7, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 14, this.boundingBox.minZ + 8, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 14, this.boundingBox.minZ + 9, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 0, this.boundingBox.minZ + 3, Blocks.air, 4);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 0, this.boundingBox.minZ + 4, Blocks.air, 4);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 0, this.boundingBox.minZ + 5, Blocks.air, 4);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 0, this.boundingBox.minZ + 12, Blocks.dirt, 1);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 1, this.boundingBox.minZ + 3, Blocks.air, 4);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 1, this.boundingBox.minZ + 12, Blocks.dirt, 1);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 2, this.boundingBox.minZ + 3, Blocks.air, 4);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 2, this.boundingBox.minZ + 12, Blocks.dirt, 1);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 3, this.boundingBox.minZ + 3, Blocks.air, 4);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 3, this.boundingBox.minZ + 12, Blocks.dirt, 1);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 4, this.boundingBox.minZ + 3, Blocks.air, 4);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 4, this.boundingBox.minZ + 12, Blocks.dirt, 0);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 5, this.boundingBox.minZ + 0, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 5, this.boundingBox.minZ + 1, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 5, this.boundingBox.minZ + 2, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 5, this.boundingBox.minZ + 3, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 5, this.boundingBox.minZ + 4, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 5, this.boundingBox.minZ + 5, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 5, this.boundingBox.minZ + 6, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 5, this.boundingBox.minZ + 7, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 5, this.boundingBox.minZ + 12, Blocks.dirt, 0);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 6, this.boundingBox.minZ + 0, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 6, this.boundingBox.minZ + 7, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 6, this.boundingBox.minZ + 12, Blocks.dirt, 0);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 7, this.boundingBox.minZ + 0, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 7, this.boundingBox.minZ + 7, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 7, this.boundingBox.minZ + 12, Blocks.dirt, 0);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 8, this.boundingBox.minZ + 0, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 8, this.boundingBox.minZ + 7, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 8, this.boundingBox.minZ + 12, Blocks.grass, 0);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 9, this.boundingBox.minZ + 0, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 9, this.boundingBox.minZ + 7, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 9, this.boundingBox.minZ + 8, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 9, this.boundingBox.minZ + 9, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 10, this.boundingBox.minZ + 0, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 10, this.boundingBox.minZ + 1, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 10, this.boundingBox.minZ + 2, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 10, this.boundingBox.minZ + 3, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 10, this.boundingBox.minZ + 4, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 10, this.boundingBox.minZ + 5, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 10, this.boundingBox.minZ + 6, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 10, this.boundingBox.minZ + 7, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 10, this.boundingBox.minZ + 8, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 10, this.boundingBox.minZ + 9, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 11, this.boundingBox.minZ + 7, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 11, this.boundingBox.minZ + 8, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 11, this.boundingBox.minZ + 9, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 11, this.boundingBox.minZ + 10, Blocks.air, 4);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 11, this.boundingBox.minZ + 11, Blocks.air, 4);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 12, this.boundingBox.minZ + 7, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 12, this.boundingBox.minZ + 8, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 12, this.boundingBox.minZ + 9, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 12, this.boundingBox.minZ + 10, Blocks.wool, 4);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 12, this.boundingBox.minZ + 11, Blocks.wool, 4);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 13, this.boundingBox.minZ + 7, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 13, this.boundingBox.minZ + 8, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 13, this.boundingBox.minZ + 9, Blocks.wool, 15);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 14, this.boundingBox.minZ + 7, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 14, this.boundingBox.minZ + 8, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 14, this.boundingBox.minZ + 9, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 6, this.boundingBox.minY + 0, this.boundingBox.minZ + 3, Blocks.air, 4);
        		this.setBlock(world, this.boundingBox.minX + 6, this.boundingBox.minY + 0, this.boundingBox.minZ + 4, Blocks.air, 4);
        		this.setBlock(world, this.boundingBox.minX + 6, this.boundingBox.minY + 0, this.boundingBox.minZ + 12, Blocks.dirt, 1);
        		this.setBlock(world, this.boundingBox.minX + 6, this.boundingBox.minY + 1, this.boundingBox.minZ + 12, Blocks.dirt, 1);
        		this.setBlock(world, this.boundingBox.minX + 6, this.boundingBox.minY + 2, this.boundingBox.minZ + 12, Blocks.dirt, 1);
        		this.setBlock(world, this.boundingBox.minX + 6, this.boundingBox.minY + 3, this.boundingBox.minZ + 12, Blocks.dirt, 1);
        		this.setBlock(world, this.boundingBox.minX + 6, this.boundingBox.minY + 4, this.boundingBox.minZ + 12, Blocks.dirt, 0);
        		this.setBlock(world, this.boundingBox.minX + 6, this.boundingBox.minY + 5, this.boundingBox.minZ + 0, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 6, this.boundingBox.minY + 5, this.boundingBox.minZ + 1, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 6, this.boundingBox.minY + 5, this.boundingBox.minZ + 2, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 6, this.boundingBox.minY + 5, this.boundingBox.minZ + 3, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 6, this.boundingBox.minY + 5, this.boundingBox.minZ + 4, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 6, this.boundingBox.minY + 5, this.boundingBox.minZ + 5, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 6, this.boundingBox.minY + 5, this.boundingBox.minZ + 6, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 6, this.boundingBox.minY + 5, this.boundingBox.minZ + 7, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 6, this.boundingBox.minY + 5, this.boundingBox.minZ + 12, Blocks.dirt, 0);
        		this.setBlock(world, this.boundingBox.minX + 6, this.boundingBox.minY + 6, this.boundingBox.minZ + 0, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 6, this.boundingBox.minY + 6, this.boundingBox.minZ + 1, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 6, this.boundingBox.minY + 6, this.boundingBox.minZ + 2, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 6, this.boundingBox.minY + 6, this.boundingBox.minZ + 3, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 6, this.boundingBox.minY + 6, this.boundingBox.minZ + 4, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 6, this.boundingBox.minY + 6, this.boundingBox.minZ + 5, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 6, this.boundingBox.minY + 6, this.boundingBox.minZ + 6, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 6, this.boundingBox.minY + 6, this.boundingBox.minZ + 7, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 6, this.boundingBox.minY + 6, this.boundingBox.minZ + 12, Blocks.dirt, 0);
        		this.setBlock(world, this.boundingBox.minX + 6, this.boundingBox.minY + 7, this.boundingBox.minZ + 0, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 6, this.boundingBox.minY + 7, this.boundingBox.minZ + 1, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 6, this.boundingBox.minY + 7, this.boundingBox.minZ + 2, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 6, this.boundingBox.minY + 7, this.boundingBox.minZ + 3, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 6, this.boundingBox.minY + 7, this.boundingBox.minZ + 4, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 6, this.boundingBox.minY + 7, this.boundingBox.minZ + 5, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 6, this.boundingBox.minY + 7, this.boundingBox.minZ + 6, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 6, this.boundingBox.minY + 7, this.boundingBox.minZ + 7, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 6, this.boundingBox.minY + 7, this.boundingBox.minZ + 12, Blocks.grass, 0);
        		this.setBlock(world, this.boundingBox.minX + 6, this.boundingBox.minY + 8, this.boundingBox.minZ + 0, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 6, this.boundingBox.minY + 8, this.boundingBox.minZ + 1, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 6, this.boundingBox.minY + 8, this.boundingBox.minZ + 2, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 6, this.boundingBox.minY + 8, this.boundingBox.minZ + 3, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 6, this.boundingBox.minY + 8, this.boundingBox.minZ + 4, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 6, this.boundingBox.minY + 8, this.boundingBox.minZ + 5, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 6, this.boundingBox.minY + 8, this.boundingBox.minZ + 6, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 6, this.boundingBox.minY + 8, this.boundingBox.minZ + 7, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 6, this.boundingBox.minY + 9, this.boundingBox.minZ + 0, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 6, this.boundingBox.minY + 9, this.boundingBox.minZ + 1, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 6, this.boundingBox.minY + 9, this.boundingBox.minZ + 2, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 6, this.boundingBox.minY + 9, this.boundingBox.minZ + 3, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 6, this.boundingBox.minY + 9, this.boundingBox.minZ + 4, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 6, this.boundingBox.minY + 9, this.boundingBox.minZ + 5, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 6, this.boundingBox.minY + 9, this.boundingBox.minZ + 6, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 6, this.boundingBox.minY + 9, this.boundingBox.minZ + 7, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 6, this.boundingBox.minY + 10, this.boundingBox.minZ + 0, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 6, this.boundingBox.minY + 10, this.boundingBox.minZ + 1, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 6, this.boundingBox.minY + 10, this.boundingBox.minZ + 2, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 6, this.boundingBox.minY + 10, this.boundingBox.minZ + 3, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 6, this.boundingBox.minY + 10, this.boundingBox.minZ + 4, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 6, this.boundingBox.minY + 10, this.boundingBox.minZ + 5, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 6, this.boundingBox.minY + 10, this.boundingBox.minZ + 6, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 6, this.boundingBox.minY + 10, this.boundingBox.minZ + 7, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 7, this.boundingBox.minY + 7, this.boundingBox.minZ + 1, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 7, this.boundingBox.minY + 7, this.boundingBox.minZ + 2, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 7, this.boundingBox.minY + 7, this.boundingBox.minZ + 3, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 7, this.boundingBox.minY + 7, this.boundingBox.minZ + 4, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 7, this.boundingBox.minY + 7, this.boundingBox.minZ + 5, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 7, this.boundingBox.minY + 7, this.boundingBox.minZ + 6, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 7, this.boundingBox.minY + 8, this.boundingBox.minZ + 1, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 7, this.boundingBox.minY + 8, this.boundingBox.minZ + 2, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 7, this.boundingBox.minY + 8, this.boundingBox.minZ + 3, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 7, this.boundingBox.minY + 8, this.boundingBox.minZ + 4, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 7, this.boundingBox.minY + 8, this.boundingBox.minZ + 5, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 7, this.boundingBox.minY + 8, this.boundingBox.minZ + 6, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 7, this.boundingBox.minY + 9, this.boundingBox.minZ + 1, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 7, this.boundingBox.minY + 9, this.boundingBox.minZ + 2, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 7, this.boundingBox.minY + 9, this.boundingBox.minZ + 3, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 7, this.boundingBox.minY + 9, this.boundingBox.minZ + 4, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 7, this.boundingBox.minY + 9, this.boundingBox.minZ + 5, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 7, this.boundingBox.minY + 9, this.boundingBox.minZ + 6, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 7, this.boundingBox.minY + 10, this.boundingBox.minZ + 1, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 7, this.boundingBox.minY + 10, this.boundingBox.minZ + 2, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 7, this.boundingBox.minY + 10, this.boundingBox.minZ + 3, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 7, this.boundingBox.minY + 10, this.boundingBox.minZ + 4, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 7, this.boundingBox.minY + 10, this.boundingBox.minZ + 5, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 7, this.boundingBox.minY + 10, this.boundingBox.minZ + 6, Blocks.snow, 0);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 7, this.boundingBox.minZ + 1, Blocks.lava, 0);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 7, this.boundingBox.minZ + 2, Blocks.lava, 0);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 7, this.boundingBox.minZ + 3, Blocks.lava, 0);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 7, this.boundingBox.minZ + 4, Blocks.lava, 0);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 7, this.boundingBox.minZ + 5, Blocks.lava, 0);
        		this.setBlock(world, this.boundingBox.minX + 2, this.boundingBox.minY + 7, this.boundingBox.minZ + 6, Blocks.lava, 0);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 7, this.boundingBox.minZ + 1, Blocks.lava, 0);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 7, this.boundingBox.minZ + 2, Blocks.lava, 0);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 7, this.boundingBox.minZ + 3, Blocks.lava, 0);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 7, this.boundingBox.minZ + 4, Blocks.lava, 0);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 7, this.boundingBox.minZ + 5, Blocks.lava, 0);
        		this.setBlock(world, this.boundingBox.minX + 3, this.boundingBox.minY + 7, this.boundingBox.minZ + 6, Blocks.lava, 0);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 7, this.boundingBox.minZ + 1, Blocks.lava, 0);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 7, this.boundingBox.minZ + 2, Blocks.lava, 0);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 7, this.boundingBox.minZ + 3, Blocks.lava, 0);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 7, this.boundingBox.minZ + 4, Blocks.lava, 0);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 7, this.boundingBox.minZ + 5, Blocks.lava, 0);
        		this.setBlock(world, this.boundingBox.minX + 4, this.boundingBox.minY + 7, this.boundingBox.minZ + 6, Blocks.lava, 0);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 7, this.boundingBox.minZ + 1, Blocks.lava, 0);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 7, this.boundingBox.minZ + 2, Blocks.lava, 0);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 7, this.boundingBox.minZ + 3, Blocks.lava, 0);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 7, this.boundingBox.minZ + 4, Blocks.lava, 0);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 7, this.boundingBox.minZ + 5, Blocks.lava, 0);
        		this.setBlock(world, this.boundingBox.minX + 5, this.boundingBox.minY + 7, this.boundingBox.minZ + 6, Blocks.lava, 0);

                for (int i = 0; i <= 5; ++i)
                {
                    for (int j = 0; j <= 5; ++j)
                    {
                        if (j == 0 || j == 5 || i == 0 || i == 5)
                        {
                            this.placeBlockAtCurrentPosition(world, Blocks.gravel, 0, j, 11, i, p_74875_3_);
                            this.clearCurrentPositionBlocksUpwards(world, j, 12, i, p_74875_3_);
                        }
                    }
                }

                return true;
            }
        }

    public static class WoodHut extends VillageBuildings.Village
        {
            private boolean isTallHouse;
            private int tablePosition;
            private static final String __OBFID = "CL_00000524";

            public WoodHut() {}

            public WoodHut(VillageBuildings.Start p_i2101_1_, int p_i2101_2_, Random p_i2101_3_, StructureBoundingBox p_i2101_4_, int p_i2101_5_)
            {
                super(p_i2101_1_, p_i2101_2_);
                this.coordBaseMode = p_i2101_5_;
                this.boundingBox = p_i2101_4_;
                this.isTallHouse = p_i2101_3_.nextBoolean();
                this.tablePosition = p_i2101_3_.nextInt(3);
            }

            protected void func_143012_a(NBTTagCompound p_143012_1_)
            {
                super.func_143012_a(p_143012_1_);
                p_143012_1_.setInteger("T", this.tablePosition);
                p_143012_1_.setBoolean("C", this.isTallHouse);
            }

            protected void func_143011_b(NBTTagCompound p_143011_1_)
            {
                super.func_143011_b(p_143011_1_);
                this.tablePosition = p_143011_1_.getInteger("T");
                this.isTallHouse = p_143011_1_.getBoolean("C");
            }

            public static VillageBuildings.WoodHut func_74908_a(VillageBuildings.Start p_74908_0_, List p_74908_1_, Random p_74908_2_, int p_74908_3_, int p_74908_4_, int p_74908_5_, int p_74908_6_, int p_74908_7_)
            {
                StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_74908_3_, p_74908_4_, p_74908_5_, 0, 0, 0, 4, 6, 5, p_74908_6_);
                return canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(p_74908_1_, structureboundingbox) == null ? new VillageBuildings.WoodHut(p_74908_0_, p_74908_7_, p_74908_2_, structureboundingbox, p_74908_6_) : null;
            }

            /**
             * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
             * Mineshafts at the end, it adds Fences...
             */
            public boolean addComponentParts(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
            {
                if (this.field_143015_k < 0)
                {
                    this.field_143015_k = this.getAverageGroundLevel(p_74875_1_, p_74875_3_);

                    if (this.field_143015_k < 0)
                    {
                        return true;
                    }

                    this.boundingBox.offset(0, this.field_143015_k - this.boundingBox.maxY + 6 - 1, 0);
                }

                this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 1, 1, 3, 5, 4, Blocks.air, Blocks.air, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 0, 0, 3, 0, 4, Blocks.cobblestone, Blocks.cobblestone, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 0, 1, 2, 0, 3, Blocks.dirt, Blocks.dirt, false);

                if (this.isTallHouse)
                {
                    this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 4, 1, 2, 4, 3, Blocks.log, Blocks.log, false);
                }
                else
                {
                    this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 5, 1, 2, 5, 3, Blocks.log, Blocks.log, false);
                }

                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.log, 0, 1, 4, 0, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.log, 0, 2, 4, 0, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.log, 0, 1, 4, 4, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.log, 0, 2, 4, 4, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.log, 0, 0, 4, 1, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.log, 0, 0, 4, 2, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.log, 0, 0, 4, 3, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.log, 0, 3, 4, 1, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.log, 0, 3, 4, 2, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.log, 0, 3, 4, 3, p_74875_3_);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 1, 0, 0, 3, 0, Blocks.log, Blocks.log, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 3, 1, 0, 3, 3, 0, Blocks.log, Blocks.log, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 1, 4, 0, 3, 4, Blocks.log, Blocks.log, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 3, 1, 4, 3, 3, 4, Blocks.log, Blocks.log, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 1, 1, 0, 3, 3, Blocks.planks, Blocks.planks, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 3, 1, 1, 3, 3, 3, Blocks.planks, Blocks.planks, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 1, 0, 2, 3, 0, Blocks.planks, Blocks.planks, false);
                this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 1, 4, 2, 3, 4, Blocks.planks, Blocks.planks, false);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 0, 2, 2, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 3, 2, 2, p_74875_3_);

                if (this.tablePosition > 0)
                {
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.fence, 0, this.tablePosition, 1, 3, p_74875_3_);
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.wooden_pressure_plate, 0, this.tablePosition, 2, 3, p_74875_3_);
                }

                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.air, 0, 1, 1, 0, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.air, 0, 1, 2, 0, p_74875_3_);
                this.placeDoorAtCurrentPosition(p_74875_1_, p_74875_3_, p_74875_2_, 1, 1, 0, this.getMetadataWithOffset(Blocks.wooden_door, 1));

                if (this.getBlockAtCurrentPosition(p_74875_1_, 1, 0, -1, p_74875_3_).getMaterial() == Material.air && this.getBlockAtCurrentPosition(p_74875_1_, 1, -1, -1, p_74875_3_).getMaterial() != Material.air)
                {
                    this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stone_stairs, this.getMetadataWithOffset(Blocks.stone_stairs, 3), 1, 0, -1, p_74875_3_);
                }

                for (int i = 0; i < 5; ++i)
                {
                    for (int j = 0; j < 4; ++j)
                    {
                        this.clearCurrentPositionBlocksUpwards(p_74875_1_, j, 6, i, p_74875_3_);
                        this.func_151554_b(p_74875_1_, Blocks.cobblestone, 0, j, -1, i, p_74875_3_);
                    }
                }

                this.spawnVillagers(p_74875_1_, p_74875_3_, 1, 1, 2, 1);
                return true;
            }
        }
}