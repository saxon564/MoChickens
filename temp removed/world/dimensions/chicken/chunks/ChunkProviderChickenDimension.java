package com.saxon564.mochickens.world.dimensions.chicken.chunks;

import static net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.CAVE;
import static net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.MINESHAFT;
import static net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.RAVINE;
import static net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.SCATTERED_FEATURE;
import static net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.VILLAGE;
import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.ANIMALS;
import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.DUNGEON;
import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.LAKE;
import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.LAVA;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.WorldEntitySpawner;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.MapGenCaves;
import net.minecraft.world.gen.MapGenRavine;
import net.minecraft.world.gen.NoiseGenerator;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.world.gen.structure.MapGenMineshaft;
import net.minecraft.world.gen.structure.MapGenScatteredFeature;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.ChunkGeneratorEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import net.minecraftforge.fml.common.eventhandler.Event.Result;

import com.saxon564.mochickens.MoChickens;
import com.saxon564.mochickens.world.dimensions.chicken.generators.GenDungeons;
import com.saxon564.mochickens.world.dimensions.chicken.structures.MapGenChickenVillage;

public class ChunkProviderChickenDimension implements IChunkProvider, IChunkGenerator
{
    /** RNG. */
    private Random rand;
    private NoiseGeneratorOctaves noiseGen1;
    private NoiseGeneratorOctaves noiseGen2;
    private NoiseGeneratorOctaves noiseGen3;
    private NoiseGeneratorPerlin noiseGen4;
    /** A NoiseGeneratorOctaves used in generating terrain */
    public NoiseGeneratorOctaves noiseGen5;
    /** A NoiseGeneratorOctaves used in generating terrain */
    public NoiseGeneratorOctaves noiseGen6;
    public NoiseGeneratorOctaves mobSpawnerNoise;
    /** Reference to the World object. */
    private World worldObj;
    /** are map structures going to be generated (e.g. strongholds) */
    private final boolean mapFeaturesEnabled;
    private WorldType worldType;
    private final double[] noiseArray;
    private final float[] parabolicField;
    private double[] stoneNoise = new double[256];
    private MapGenBase caveGenerator = new MapGenCaves();
    /** Holds Stronghold Generator */
    //private MapGenStronghold strongholdGenerator = new MapGenStronghold();
    /** Holds Village Generator */
    private MapGenChickenVillage villageGenerator = new MapGenChickenVillage();
    /** Holds Mineshaft Generator */
    private MapGenMineshaft mineshaftGenerator = new MapGenMineshaft();
    private MapGenScatteredFeature scatteredFeatureGenerator = new MapGenScatteredFeature();
    /** Holds ravine generator */
    private MapGenBase ravineGenerator = new MapGenRavine();
    /** The biomes that are used to generate the chunk */
    private Biome[] biomesForGeneration;
    double[] noise1;
    double[] noise2;
    double[] noise3;
    double[] noise4;
    int[][] field = new int[32][32];

    {
        caveGenerator = TerrainGen.getModdedMapGen(caveGenerator, CAVE);
        //strongholdGenerator = (MapGenStronghold) TerrainGen.getModdedMapGen(strongholdGenerator, STRONGHOLD);
        villageGenerator = (MapGenChickenVillage) TerrainGen.getModdedMapGen(villageGenerator, VILLAGE);
        mineshaftGenerator = (MapGenMineshaft) TerrainGen.getModdedMapGen(mineshaftGenerator, MINESHAFT);
        scatteredFeatureGenerator = (MapGenScatteredFeature) TerrainGen.getModdedMapGen(scatteredFeatureGenerator, SCATTERED_FEATURE);
        ravineGenerator = TerrainGen.getModdedMapGen(ravineGenerator, RAVINE);
    }

    public ChunkProviderChickenDimension(World world, long seed, boolean features)
    {
        this.worldObj = world;
        this.mapFeaturesEnabled = features;
        this.worldType = world.getWorldInfo().getTerrainType();
        this.rand = new Random(seed);
        this.noiseGen1 = new NoiseGeneratorOctaves(this.rand, 16);
        this.noiseGen2 = new NoiseGeneratorOctaves(this.rand, 16);
        this.noiseGen3 = new NoiseGeneratorOctaves(this.rand, 8);
        this.noiseGen4 = new NoiseGeneratorPerlin(this.rand, 4);
        this.noiseGen5 = new NoiseGeneratorOctaves(this.rand, 10);
        this.noiseGen6 = new NoiseGeneratorOctaves(this.rand, 16);
        this.mobSpawnerNoise = new NoiseGeneratorOctaves(this.rand, 8);
        this.noiseArray = new double[825];
        this.parabolicField = new float[25];

        for (int j = -2; j <= 2; ++j)
        {
            for (int k = -2; k <= 2; ++k)
            {
                float f = 10.0F / MathHelper.sqrt((float)(j * j + k * k) + 0.2F);
                this.parabolicField[j + 2 + (k + 2) * 5] = f;
            }
        }

        net.minecraftforge.event.terraingen.InitNoiseGensEvent.ContextOverworld noiseGens = new net.minecraftforge.event.terraingen.InitNoiseGensEvent.ContextOverworld(noiseGen1, noiseGen2, noiseGen3, noiseGen4, noiseGen5, noiseGen6, mobSpawnerNoise);
        noiseGens = TerrainGen.getModdedNoiseGenerators(world, this.rand, noiseGens);
        this.noiseGen1 = noiseGens.getLPerlin1();
        this.noiseGen2 = noiseGens.getLPerlin2();
        this.noiseGen3 = noiseGens.getPerlin();
        this.noiseGen4 = noiseGens.getHeight();
        this.noiseGen5 = noiseGens.getScale();
        this.noiseGen6 = noiseGens.getDepth();
        this.mobSpawnerNoise = noiseGens.getForest();
    }

    public void setBlocksInChunk(int chunkX, int chunkZ, ChunkPrimer p_180518_3_)
    {
        byte b0 = 63;
        this.biomesForGeneration = this.worldObj.getBiomeProvider().getBiomesForGeneration(this.biomesForGeneration, chunkX * 4 - 2, chunkZ * 4 - 2, 10, 10);
        this.initalizeNoiseField(chunkX * 4, 0, chunkZ * 4);

        for (int k = 0; k < 4; ++k)
        {
            int l = k * 5;
            int i1 = (k + 1) * 5;

            for (int j1 = 0; j1 < 4; ++j1)
            {
                int k1 = (l + j1) * 33;
                int l1 = (l + j1 + 1) * 33;
                int i2 = (i1 + j1) * 33;
                int j2 = (i1 + j1 + 1) * 33;

                for (int k2 = 0; k2 < 32; ++k2)
                {
                    double d0 = 0.125D;
                    double d1 = this.noiseArray[k1 + k2];
                    double d2 = this.noiseArray[l1 + k2];
                    double d3 = this.noiseArray[i2 + k2];
                    double d4 = this.noiseArray[j2 + k2];
                    double d5 = (this.noiseArray[k1 + k2 + 1] - d1) * d0;
                    double d6 = (this.noiseArray[l1 + k2 + 1] - d2) * d0;
                    double d7 = (this.noiseArray[i2 + k2 + 1] - d3) * d0;
                    double d8 = (this.noiseArray[j2 + k2 + 1] - d4) * d0;

                    for (int l2 = 0; l2 < 8; ++l2)
                    {
                        double d9 = 0.25D;
                        double d10 = d1;
                        double d11 = d2;
                        double d12 = (d3 - d1) * d9;
                        double d13 = (d4 - d2) * d9;

                        for (int i3 = 0; i3 < 4; ++i3)
                        {
                            double d14 = 0.25D;
                            double d16 = (d11 - d10) * d14;
                            double d15 = d10 - d16;

                            for (int j3 = 0; j3 < 4; ++j3)
                            {
                                if ((d15 += d16) > 0.0D)
                                {
                                    p_180518_3_.setBlockState(k * 4 + i3, k2 * 8 + l2, j1 * 4 + j3, Blocks.STONE.getDefaultState());
                                }
                                else if (k2 * 8 + l2 < b0)
                                {
                                    p_180518_3_.setBlockState(k * 4 + i3, k2 * 8 + l2, j1 * 4 + j3, Blocks.WATER.getDefaultState());
                                }
                            }

                            d10 += d12;
                            d11 += d13;
                        }

                        d1 += d5;
                        d2 += d6;
                        d3 += d7;
                        d4 += d8;
                    }
                }
            }
        }
    }

    public void func_180517_a(int chunkX, int chunkZ, ChunkPrimer chunkPrimer, Biome[] biomesForGeneration)
    {
    	PopulateChunkEvent.ReplaceBiomeBlocks event = new PopulateChunkEvent.ReplaceBiomeBlocks(this, chunkX, chunkZ, chunkPrimer, this.worldObj);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.getResult() == Result.DENY) return;

        double d0 = 0.03125D;
        this.stoneNoise = this.noiseGen4.getRegion(this.stoneNoise, (double)(chunkX * 16), (double)(chunkZ * 16), 16, 16, d0 * 2.0D, d0 * 2.0D, 1.0D);
        
        for (int k = 0; k < 16; ++k)
        {
            for (int l = 0; l < 16; ++l)
            {
                Biome biomegenbase = biomesForGeneration[l + k * 16];
                biomegenbase.genTerrainBlocks(this.worldObj, this.rand, chunkPrimer, chunkX * 16 + k, chunkZ * 16 + l, this.stoneNoise[l + k * 16]);
            }
        }
    }

    /**
     * loads or generates the chunk at the chunk location specified
     */
    public Chunk loadChunk(int chunkX, int chunkZ)
    {
        return this.provideChunk(chunkX, chunkZ);
    }

    /**
     * Will return back a chunk, if it doesn't exist and its not a MP client it will generates all the blocks for the
     * specified chunk from the map seed and chunk seed
     */
    public Chunk provideChunk(int chunkX, int chunkZ)
    {
        this.rand.setSeed((long)chunkX * 341873128712L + (long)chunkZ * 132897987541L);
        ChunkPrimer chunkprimer = new ChunkPrimer();
        this.setBlocksInChunk(chunkX, chunkZ, chunkprimer);
        this.biomesForGeneration = this.worldObj.getBiomeProvider().getBiomes(this.biomesForGeneration, chunkX * 16, chunkZ * 16, 16, 16);
        this.func_180517_a(chunkX, chunkZ, chunkprimer, this.biomesForGeneration);
        this.caveGenerator.generate(this.worldObj, chunkX, chunkZ, chunkprimer);
        this.ravineGenerator.generate(this.worldObj, chunkX, chunkZ, chunkprimer);

        if (this.mapFeaturesEnabled)
        {
            this.mineshaftGenerator.generate(this.worldObj, chunkX, chunkZ, chunkprimer);
            this.villageGenerator.generate(this.worldObj, chunkX, chunkZ, chunkprimer);
            //this.strongholdGenerator.func_func_175792_a(this, this.worldObj, chunkX, chunkZ, chunkprimer);
            this.scatteredFeatureGenerator.generate(this.worldObj, chunkX, chunkZ, chunkprimer);
        }

        Chunk chunk = new Chunk(this.worldObj, chunkprimer, chunkX, chunkZ);
        byte[] abyte1 = chunk.getBiomeArray();

        for (int k = 0; k < abyte1.length; ++k)
        {
            abyte1[k] = (byte)Biome.getIdForBiome(biomesForGeneration[k]);
        }

        chunk.generateSkylightMap();
        return chunk;
    }

    private void initalizeNoiseField(int posX, int posY, int posZ)
    {
        double d0 = 684.412D;
        double d1 = 684.412D;
        double d2 = 512.0D;
        double d3 = 512.0D;
        this.noise4 = this.noiseGen6.generateNoiseOctaves(this.noise4, posX, posZ, 5, 5, 200.0D, 200.0D, 0.5D);
        this.noise1 = this.noiseGen3.generateNoiseOctaves(this.noise1, posX, posY, posZ, 5, 33, 5, 8.555150000000001D, 4.277575000000001D, 8.555150000000001D);
        this.noise2 = this.noiseGen1.generateNoiseOctaves(this.noise2, posX, posY, posZ, 5, 33, 5, 684.412D, 684.412D, 684.412D);
        this.noise3 = this.noiseGen2.generateNoiseOctaves(this.noise3, posX, posY, posZ, 5, 33, 5, 684.412D, 684.412D, 684.412D);
        boolean flag1 = false;
        boolean flag = false;
        int l = 0;
        int i1 = 0;
        double d4 = 8.5D;

        for (int j1 = 0; j1 < 5; ++j1)
        {
            for (int k1 = 0; k1 < 5; ++k1)
            {
                float f = 0.0F;
                float f1 = 0.0F;
                float f2 = 0.0F;
                byte b0 = 2;
                Biome biomegenbase = this.biomesForGeneration[j1 + 2 + (k1 + 2) * 10];

                for (int l1 = -b0; l1 <= b0; ++l1)
                {
                    for (int i2 = -b0; i2 <= b0; ++i2)
                    {
                        Biome biomegenbase1 = this.biomesForGeneration[j1 + l1 + 2 + (k1 + i2 + 2) * 10];
                        float f3 = (biomegenbase1.getBaseHeight() + biomegenbase1.getHeightVariation())/2;
                        float f4 = biomegenbase1.getHeightVariation() - biomegenbase1.getBaseHeight();

                        if (this.worldType == WorldType.AMPLIFIED && f3 > 0.0F)
                        {
                            f3 = 1.0F + f3 * 2.0F;
                            f4 = 1.0F + f4 * 4.0F;
                        }

                        float f5 = this.parabolicField[l1 + 2 + (i2 + 2) * 5] / (f3 + 2.0F);

                        if ((biomegenbase1.getBaseHeight() + biomegenbase1.getHeightVariation())/2 > (biomegenbase.getBaseHeight() + biomegenbase.getHeightVariation())/2)
                        {
                            f5 /= 2.0F;
                        }

                        f += f4 * f5;
                        f1 += f3 * f5;
                        f2 += f5;
                    }
                }

                f /= f2;
                f1 /= f2;
                f = f * 0.9F + 0.1F;
                f1 = (f1 * 4.0F - 1.0F) / 8.0F;
                double d12 = this.noise4[i1] / 8000.0D;

                if (d12 < 0.0D)
                {
                    d12 = -d12 * 0.3D;
                }

                d12 = d12 * 3.0D - 2.0D;

                if (d12 < 0.0D)
                {
                    d12 /= 2.0D;

                    if (d12 < -1.0D)
                    {
                        d12 = -1.0D;
                    }

                    d12 /= 1.4D;
                    d12 /= 2.0D;
                }
                else
                {
                    if (d12 > 1.0D)
                    {
                        d12 = 1.0D;
                    }

                    d12 /= 8.0D;
                }

                ++i1;
                double d13 = (double)f1;
                double d14 = (double)f;
                d13 += d12 * 0.2D;
                d13 = d13 * 8.5D / 8.0D;
                double d5 = 8.5D + d13 * 4.0D;

                for (int j2 = 0; j2 < 33; ++j2)
                {
                    double d6 = ((double)j2 - d5) * 12.0D * 128.0D / 256.0D / d14;

                    if (d6 < 0.0D)
                    {
                        d6 *= 4.0D;
                    }

                    double d7 = this.noise2[l] / 512.0D;
                    double d8 = this.noise3[l] / 512.0D;
                    double d9 = (this.noise1[l] / 10.0D + 1.0D) / 2.0D;
                    double d10 = MathHelper.clamp(d7, d8, d9) - d6;

                    if (j2 > 29)
                    {
                        double d11 = (double)((float)(j2 - 29) / 3.0F);
                        d10 = d10 * (1.0D - d11) + -10.0D * d11;
                    }

                    this.noiseArray[l] = d10;
                    ++l;
                }
            }
        }
    }

    /**
     * Checks to see if a chunk exists at x, y
     */
    public boolean chunkExists(int chunkX, int chunkZ)
    {
        return true;
    }

    /**
     * Populates chunk with ores etc etc
     */
    public void populate(IChunkGenerator chunkProvider, int chunkX, int chunkZ)
    {
        BlockFalling.fallInstantly = true;
        int k = chunkX * 16;
        int l = chunkZ * 16;
        BlockPos blockpos = new BlockPos(k, 0, l);
        Biome biomegenbase = this.worldObj.getBiome(blockpos.add(16, 0, 16));
        this.rand.setSeed(this.worldObj.getSeed());
        long i1 = this.rand.nextLong() / 2L * 2L + 1L;
        long j1 = this.rand.nextLong() / 2L * 2L + 1L;
        this.rand.setSeed((long)chunkX * i1 + (long)chunkZ * j1 ^ this.worldObj.getSeed());
        boolean flag = false;
        ChunkPos chunkpos = new ChunkPos(chunkX, chunkZ);

        net.minecraftforge.event.ForgeEventFactory.onChunkPopulate(true, chunkProvider, worldObj, rand, chunkX, chunkZ, flag);

        if (this.mapFeaturesEnabled)
        {
            this.mineshaftGenerator.generateStructure(this.worldObj, this.rand, chunkpos);
            flag = this.villageGenerator.generateStructure(this.worldObj, this.rand, chunkpos);
            //this.strongholdGenerator.func_175794_a(this.worldObj, this.rand, chunkpos);
            this.scatteredFeatureGenerator.generateStructure(this.worldObj, this.rand, chunkpos);
        }
        
        if (flag == true) {
        	
        	MoChickens.logger.info("Village " + chunkX*16 + "  " + chunkZ*16);
        	
        }

        int k1;
        int l1;
        int i2;

        if (biomegenbase != Biomes.DESERT && biomegenbase != Biomes.DESERT_HILLS && !flag && this.rand.nextInt(4) == 0
            && TerrainGen.populate(chunkProvider, worldObj, rand, chunkX, chunkZ, flag, LAKE))
        {
            k1 = k + this.rand.nextInt(16) + 8;
            l1 = this.rand.nextInt(256);
            i2 = l + this.rand.nextInt(16) + 8;
            (new WorldGenLakes(Blocks.WATER)).generate(this.worldObj, this.rand, new BlockPos(k1, l1, i2));
        }

        if (TerrainGen.populate(chunkProvider, worldObj, rand, chunkX, chunkZ, flag, LAVA) && !flag && this.rand.nextInt(8) == 0)
        {
            k1 = k + this.rand.nextInt(16) + 8;
            l1 = this.rand.nextInt(this.rand.nextInt(248) + 8);
            i2 = l + this.rand.nextInt(16) + 8;

            if (l1 < 63 || this.rand.nextInt(10) == 0)
            {
                (new WorldGenLakes(Blocks.LAVA)).generate(this.worldObj, this.rand, new BlockPos(k1, l1, i2));
            }
        }

        boolean doGen = TerrainGen.populate(chunkProvider, worldObj, rand, chunkX, chunkZ, flag, DUNGEON);
        for (k1 = 0; doGen && k1 < 8; ++k1)
        {
            l1 = k + this.rand.nextInt(16) + 8;
            i2 = this.rand.nextInt(256);
            int j2 = l + this.rand.nextInt(16) + 8;
            (new GenDungeons()).generate(this.worldObj, this.rand, l1, i2, j2);
        }

        biomegenbase.decorate(this.worldObj, this.rand, new BlockPos(k, this.worldObj.getTopSolidOrLiquidBlock(new BlockPos(k, 0, l)).getY(), l));
        if (TerrainGen.populate(chunkProvider, worldObj, rand, chunkX, chunkZ, flag, ANIMALS))
        {
        WorldEntitySpawner.performWorldGenSpawning(this.worldObj, biomegenbase, k + 8, l + 8, 16, 16, this.rand);
        }
        k += 8;
        l += 8;

        /*doGen = TerrainGen.populate(chunkProvider, worldObj, rand, chunkX, chunkZ, flag, ICE);
        for (k1 = 0; doGen && k1 < 16; ++k1)
        {
            for (l1 = 0; l1 < 16; ++l1)
            {
                i2 = this.worldObj.getPrecipitationHeight(k + k1, l + l1);

                if (this.worldObj.isBlockFreezable(k1 + k, i2 - 1, l1 + l))
                {
                    this.worldObj.setBlock(k1 + k, i2 - 1, l1 + l, Blocks.ice, 0, 2);
                }

                if (this.worldObj.func_147478_e(k1 + k, i2, l1 + l, true))
                {
                    this.worldObj.setBlock(k1 + k, i2, l1 + l, Blocks.snow_layer, 0, 2);
                }
            }
        }*/

        MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Post(chunkProvider, worldObj, rand, chunkX, chunkZ, flag));

        BlockFalling.fallInstantly = false;
    }

    /**
     * Two modes of operation: if passed true, save all Chunks in one go.  If passed false, save up to two chunks.
     * Return true if all chunks have been saved.
     */
    public boolean saveChunks(boolean flag, IProgressUpdate progress)
    {
        return true;
    }

    /**
     * Save extra data not associated with any Chunk.  Not saved during autosave, only during world unload.  Currently
     * unimplemented.
     */
    public void saveExtraData() {}

    /**
     * Unloads chunks that are marked to be unloaded. This is not guaranteed to unload every such chunk.
     */
    public boolean unloadQueuedChunks()
    {
        return false;
    }

    /**
     * Returns if the IChunkProvider supports saving.
     */
    public boolean canSave()
    {
        return true;
    }

    /**
     * Converts the instance data to a readable string.
     */
    public String makeString()
    {
        return "RandomLevelSource";
    }

    /**
     * Returns a list of creatures of the specified type that can spawn at the given location.
     */
    public List getPossibleCreatures(EnumCreatureType enumCreatureType, BlockPos pos)
    {
        Biome biomegenbase = this.worldObj.getBiome(pos);
        return enumCreatureType == EnumCreatureType.MONSTER && this.scatteredFeatureGenerator.isInsideStructure(pos) ? this.scatteredFeatureGenerator.getScatteredFeatureSpawnList() : biomegenbase.getSpawnableList(enumCreatureType);
    }

    public int getLoadedChunkCount()
    {
        return 0;
    }

    public void recreateStructures(Chunk chunk, int chunkX, int chunkZ)
    {
        if (this.mapFeaturesEnabled)
        {
            this.mineshaftGenerator.generate(this.worldObj, chunkX, chunkZ, (ChunkPrimer)null);
            this.villageGenerator.generate(this.worldObj, chunkX, chunkZ, (ChunkPrimer)null);
            //this.strongholdGenerator.generate(this.worldObj, chunkX, chunkZ, (ChunkPrimer)null);
            this.scatteredFeatureGenerator.generate(this.worldObj, chunkX, chunkZ, (ChunkPrimer)null);
        }
    }

    public Chunk provideChunk(BlockPos blockPosIn)
    {
        return this.provideChunk(blockPosIn.getX() >> 4, blockPosIn.getZ() >> 4);
    }

    public boolean func_177460_a(IChunkProvider p_177460_1_, Chunk p_177460_2_, int p_177460_3_, int p_177460_4_)
    {
        boolean flag = false;

        /*if (this.settings.useMonuments && this.mapFeaturesEnabled && p_177460_2_.getInhabitedTime() < 3600L)
        {
            flag |= this.oceanMonumentGenerator.func_175794_a(this.worldObj, this.rand, new ChunkCoordIntPair(p_177460_3_, p_177460_4_));
        }*/

        return flag;
    }

	public List func_177458_a(EnumCreatureType creature, BlockPos pos)
    {
        Biome biomegenbase = this.worldObj.getBiome(pos);

        if (this.mapFeaturesEnabled)
        {
            if (creature == EnumCreatureType.MONSTER && this.scatteredFeatureGenerator.isInsideStructure(pos))
            {
                return this.scatteredFeatureGenerator.getScatteredFeatureSpawnList();
            }

            /*if (p_177458_1_ == EnumCreatureType.MONSTER && this.settings.useMonuments && this.oceanMonumentGenerator.func_175796_a(this.worldObj, p_177458_2_))
            {
                return this.oceanMonumentGenerator.func_175799_b();
            }*/
        }

        return biomegenbase.getSpawnableList(creature);
    }

	public BlockPos getStrongholdGen(World worldIn, String p_180513_2_, BlockPos p_180513_3_)
    {
        return null; //"Stronghold".equals(p_180513_2_) && this.strongholdGenerator != null ? this.strongholdGenerator.getClosestStrongholdPos(worldIn, p_180513_3_) : null;
    }

	@Override
	public Chunk getLoadedChunk(int x, int z) {
		return null;
	}

	@Override
	public void populate(int x, int z) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean generateStructures(Chunk chunkIn, int x, int z) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BlockPos getStrongholdGen(World worldIn, String structureName, BlockPos position, boolean p_180513_4_) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean tick() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isChunkGeneratedAt(int p_191062_1_, int p_191062_2_) {
		// TODO Auto-generated method stub
		return false;
	}

}