package com.saxon564.mochickens.world.dimensions.chicken.generators;

import java.util.Random;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockFlower.EnumFlowerType;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenBigMushroom;
import net.minecraft.world.gen.feature.WorldGenBush;
import net.minecraft.world.gen.feature.WorldGenCactus;
import net.minecraft.world.gen.feature.WorldGenClay;
import net.minecraft.world.gen.feature.WorldGenDeadBush;
import net.minecraft.world.gen.feature.WorldGenFlowers;
import net.minecraft.world.gen.feature.WorldGenLiquids;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenPumpkin;
import net.minecraft.world.gen.feature.WorldGenReed;
import net.minecraft.world.gen.feature.WorldGenSand;
import net.minecraft.world.gen.feature.WorldGenWaterlily;
import net.minecraft.world.gen.feature.WorldGenerator;

import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.*;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.*;
import net.minecraftforge.common.*;
import net.minecraftforge.event.terraingen.*;

public class ChickenBiomeDecorator
{
    /** The world the BiomeDecorator is currently decorating */
    public World currentWorld;
    /** The Biome Decorator's random number generator. */
    public Random randomGenerator;
    /** The X-coordinate of the chunk currently being decorated */
    public BlockPos pos;
    /** The clay generator. */
    public WorldGenerator clayGen = new WorldGenClay(4);
    /** The sand generator. */
    public WorldGenerator sandGen;
    /** The gravel generator. */
    public WorldGenerator gravelAsSandGen;
    /** The dirt generator. */
    public WorldGenerator dirtGen;
    public WorldGenerator gravelGen;
    public WorldGenerator coalGen;
    public WorldGenerator ironGen;
    /** Field that holds gold WorldGenMinable */
    public WorldGenerator goldGen;
    /** Field that holds redstone WorldGenMinable */
    public WorldGenerator redstoneGen;
    /** Field that holds diamond WorldGenMinable */
    public WorldGenerator diamondGen;
    /** Field that holds Lapis WorldGenMinable */
    public WorldGenerator lapisGen;
    public WorldGenFlowers yellowFlowerGen;
    /** Field that holds mushroomBrown WorldGenFlowers */
    public WorldGenerator mushroomBrownGen;
    /** Field that holds mushroomRed WorldGenFlowers */
    public WorldGenerator mushroomRedGen;
    /** Field that holds big mushroom generator */
    public WorldGenerator bigMushroomGen;
    /** Field that holds WorldGenReed */
    public WorldGenerator reedGen;
    /** Field that holds WorldGenCactus */
    public WorldGenerator cactusGen;
    /** The water lily generation! */
    public WorldGenerator waterlilyGen;
    /** Amount of waterlilys per chunk. */
    public int waterlilyPerChunk;
    /**
     * The number of trees to attempt to generate per chunk. Up to 10 in forests, none in deserts.
     */
    public int treesPerChunk;
    /**
     * The number of yellow flower patches to generate per chunk. The game generates much less than this number, since
     * it attempts to generate them at a random altitude.
     */
    public int flowersPerChunk;
    /** The amount of tall grass to generate per chunk. */
    public int grassPerChunk;
    /**
     * The number of dead bushes to generate per chunk. Used in deserts and swamps.
     */
    public int deadBushPerChunk;
    /**
     * The number of extra mushroom patches per chunk. It generates 1/4 this number in brown mushroom patches, and 1/8
     * this number in red mushroom patches. These mushrooms go beyond the default base number of mushrooms.
     */
    public int mushroomsPerChunk;
    /**
     * The number of reeds to generate per chunk. Reeds won't generate if the randomly selected placement is unsuitable.
     */
    public int reedsPerChunk;
    /**
     * The number of cactus plants to generate per chunk. Cacti only work on sand.
     */
    public int cactiPerChunk;
    /**
     * The number of sand patches to generate per chunk. Sand patches only generate when part of it is underwater.
     */
    public int sandPerChunk;
    /**
     * The number of sand patches to generate per chunk. Sand patches only generate when part of it is underwater. There
     * appear to be two separate fields for this.
     */
    public int sandPerChunk2;
    /**
     * The number of clay patches to generate per chunk. Only generates when part of it is underwater.
     */
    public int clayPerChunk;
    /** Amount of big mushrooms per chunk */
    public int bigMushroomsPerChunk;
    /** True if decorator should generate surface lava & water */
    public boolean generateLakes;

    public ChickenBiomeDecorator()
    {
        this.sandGen = new WorldGenSand(Blocks.SAND, 7);
        this.gravelAsSandGen = new WorldGenSand(Blocks.GRAVEL, 6);
        this.dirtGen = new WorldGenMinable(Blocks.DIRT.getDefaultState(), 32);
        this.gravelGen = new WorldGenMinable(Blocks.GRAVEL.getDefaultState(), 32);
        this.coalGen = new WorldGenMinable(Blocks.COAL_ORE.getDefaultState(), 16);
        this.ironGen = new WorldGenMinable(Blocks.IRON_ORE.getDefaultState(), 8);
        this.goldGen = new WorldGenMinable(Blocks.GOLD_ORE.getDefaultState(), 8);
        this.redstoneGen = new WorldGenMinable(Blocks.REDSTONE_ORE.getDefaultState(), 7);
        this.diamondGen = new WorldGenMinable(Blocks.DIAMOND_ORE.getDefaultState(), 7);
        this.lapisGen = new WorldGenMinable(Blocks.LAPIS_ORE.getDefaultState(), 6);
        this.yellowFlowerGen = new WorldGenFlowers(Blocks.YELLOW_FLOWER, EnumFlowerType.DANDELION);
        this.mushroomBrownGen = new WorldGenBush(Blocks.BROWN_MUSHROOM);
        this.mushroomRedGen = new WorldGenBush(Blocks.RED_MUSHROOM);
        this.bigMushroomGen = new WorldGenBigMushroom();
        this.reedGen = new WorldGenReed();
        this.cactusGen = new WorldGenCactus();
        this.waterlilyGen = new WorldGenWaterlily();
        this.flowersPerChunk = 2;
        this.grassPerChunk = 1;
        this.sandPerChunk = 1;
        this.sandPerChunk2 = 3;
        this.clayPerChunk = 1;
        this.generateLakes = true;
    }

    public void decorateChunk(World p_150512_1_, Random p_150512_2_, Biome p_150512_3_, BlockPos pos)
    {
        if (this.currentWorld != null)
        {
            throw new RuntimeException("Already decorating!!");
        }
        else
        {
            this.currentWorld = p_150512_1_;
            this.randomGenerator = p_150512_2_;
            this.pos = pos;
            this.genDecorations(p_150512_3_, pos);
            this.currentWorld = null;
            this.randomGenerator = null;
        }
    }

    protected void genDecorations(Biome p_150513_1_, BlockPos pos)
    {
        MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Pre(currentWorld, randomGenerator, pos));
        this.generateOres();
        int i;
        int tx;
        int ty;
        int tz;
        BlockPos tb;

        boolean doGen = TerrainGen.decorate(currentWorld, randomGenerator, pos, SAND);
        for (i = 0; doGen && i < this.sandPerChunk2; ++i)
        {
            tx = pos.getX() + this.randomGenerator.nextInt(16) + 8;
            tz = pos.getZ() + this.randomGenerator.nextInt(16) + 8;
            ty = this.currentWorld.getTopSolidOrLiquidBlock(pos).getY();
            tb = new BlockPos(tx, ty, tz);
            this.sandGen.generate(this.currentWorld, this.randomGenerator, tb);
        }

        doGen = TerrainGen.decorate(currentWorld, randomGenerator, pos, CLAY);
        for (i = 0; doGen && i < this.clayPerChunk; ++i)
        {
            tx = pos.getX() + this.randomGenerator.nextInt(16) + 8;
            tz = pos.getZ() + this.randomGenerator.nextInt(16) + 8;
            ty = this.currentWorld.getTopSolidOrLiquidBlock(pos).getY();
            tb = new BlockPos(tx, ty, tz);
            this.clayGen.generate(this.currentWorld, this.randomGenerator, tb);
        }

        doGen = TerrainGen.decorate(currentWorld, randomGenerator, pos, SAND_PASS2);
        for (i = 0; doGen && i < this.sandPerChunk; ++i)
        {
            tx = pos.getX() + this.randomGenerator.nextInt(16) + 8;
            tz = pos.getZ() + this.randomGenerator.nextInt(16) + 8;
            ty = this.currentWorld.getTopSolidOrLiquidBlock(pos).getY();
            tb = new BlockPos(tx, ty, tz);
            this.gravelAsSandGen.generate(this.currentWorld, this.randomGenerator, tb);
        }

        int j = this.treesPerChunk;

        if (this.randomGenerator.nextInt(5) == 0)
        {
            ++j;
        }

        doGen = TerrainGen.decorate(currentWorld, randomGenerator, pos, TREE);
        for (i = 0; doGen && i < j; ++i)
        {
            tx = pos.getX() + this.randomGenerator.nextInt(16) + 8;
            tz = pos.getZ() + this.randomGenerator.nextInt(16) + 8;
            ty = this.currentWorld.getTopSolidOrLiquidBlock(pos).getY();
            tb = new BlockPos(tx, ty, tz);
            WorldGenAbstractTree worldgenabstracttree = p_150513_1_.genBigTreeChance(this.randomGenerator);

            if (worldgenabstracttree.generate(this.currentWorld, this.randomGenerator, tb))
            {
                worldgenabstracttree.generateSaplings(this.currentWorld, this.randomGenerator, tb);
            }
        }

        doGen = TerrainGen.decorate(currentWorld, randomGenerator, pos, BIG_SHROOM);
        for (i = 0; doGen && i < this.bigMushroomsPerChunk; ++i)
        {
            tx = pos.getX() + this.randomGenerator.nextInt(16) + 8;
            tz = pos.getZ() + this.randomGenerator.nextInt(16) + 8;
            ty = this.currentWorld.getTopSolidOrLiquidBlock(pos).getY();
            tb = new BlockPos(tx, ty, tz);
            this.bigMushroomGen.generate(this.currentWorld, this.randomGenerator, tb);
        }

        doGen = TerrainGen.decorate(currentWorld, randomGenerator, pos, FLOWERS);
        for (i = 0; doGen && i < this.flowersPerChunk; ++i)
        {
            tx = pos.getX() + this.randomGenerator.nextInt(16) + 8;
            tz = pos.getZ() + this.randomGenerator.nextInt(16) + 8;
            ty = nextInt(this.currentWorld.getTopSolidOrLiquidBlock(pos).getY() + 32);
            tb = new BlockPos(tx, ty, tz);
            EnumFlowerType ft = p_150513_1_.pickRandomFlower(this.randomGenerator, tb);
            BlockFlower blockflower = ft.getBlockType().getBlock();

            if (blockflower.getMaterial(blockflower.getDefaultState()) != Material.AIR)
            {
                this.yellowFlowerGen.setGeneratedBlock(blockflower, ft);
                this.yellowFlowerGen.generate(this.currentWorld, this.randomGenerator, tb);
            }
        }

        doGen = TerrainGen.decorate(currentWorld, randomGenerator, pos, GRASS);
        for (i = 0; doGen && i < this.grassPerChunk; ++i)
        {
            tx = pos.getX() + this.randomGenerator.nextInt(16) + 8;
            tz = pos.getZ() + this.randomGenerator.nextInt(16) + 8;
            ty = nextInt(this.currentWorld.getTopSolidOrLiquidBlock(pos).getY() * 2);
            tb = new BlockPos(tx, ty, tz);
            WorldGenerator worldgenerator = p_150513_1_.getRandomWorldGenForGrass(this.randomGenerator);
            worldgenerator.generate(this.currentWorld, this.randomGenerator, tb);
        }

        doGen = TerrainGen.decorate(currentWorld, randomGenerator, pos, DEAD_BUSH);
        for (i = 0; doGen && i < this.deadBushPerChunk; ++i)
        {
            tx = pos.getX() + this.randomGenerator.nextInt(16) + 8;
            tz = pos.getZ() + this.randomGenerator.nextInt(16) + 8;
            ty = nextInt(this.currentWorld.getTopSolidOrLiquidBlock(pos).getY() * 2);
            tb = new BlockPos(tx, ty, tz);
            (new WorldGenDeadBush()).generate(this.currentWorld, this.randomGenerator, tb);
        }

        doGen = TerrainGen.decorate(currentWorld, randomGenerator, pos, LILYPAD);
        for (i = 0; doGen && i < this.waterlilyPerChunk; ++i)
        {
            tx = pos.getX() + this.randomGenerator.nextInt(16) + 8;
            tz = pos.getZ() + this.randomGenerator.nextInt(16) + 8;
            ty = nextInt(this.currentWorld.getTopSolidOrLiquidBlock(pos).getY() * 2);
            tb = new BlockPos(tx, ty, tz);

            this.waterlilyGen.generate(this.currentWorld, this.randomGenerator, tb);
        }

        doGen = TerrainGen.decorate(currentWorld, randomGenerator, pos, SHROOM);
        for (i = 0; doGen && i < this.mushroomsPerChunk; ++i)
        {
            if (this.randomGenerator.nextInt(4) == 0)
            {
                tx = pos.getX() + this.randomGenerator.nextInt(16) + 8;
                tz = pos.getZ() + this.randomGenerator.nextInt(16) + 8;
                ty = this.currentWorld.getTopSolidOrLiquidBlock(pos).getY();
                tb = new BlockPos(tx, ty, tz);
                this.mushroomBrownGen.generate(this.currentWorld, this.randomGenerator, tb);
            }

            if (this.randomGenerator.nextInt(8) == 0)
            {
                tx = pos.getX() + this.randomGenerator.nextInt(16) + 8;
                tz = pos.getZ() + this.randomGenerator.nextInt(16) + 8;
                ty = nextInt(this.currentWorld.getTopSolidOrLiquidBlock(pos).getY() * 2);
                tb = new BlockPos(tx, ty, tz);
                this.mushroomRedGen.generate(this.currentWorld, this.randomGenerator, tb);
            }
        }

        if (doGen && this.randomGenerator.nextInt(4) == 0)
        {
            tx = pos.getX() + this.randomGenerator.nextInt(16) + 8;
            tz = pos.getZ() + this.randomGenerator.nextInt(16) + 8;
            ty = nextInt(this.currentWorld.getTopSolidOrLiquidBlock(pos).getY() * 2);
            tb = new BlockPos(tx, ty, tz);
            this.mushroomBrownGen.generate(this.currentWorld, this.randomGenerator, tb);
        }

        if (doGen && this.randomGenerator.nextInt(8) == 0)
        {
            tx = pos.getX() + this.randomGenerator.nextInt(16) + 8;
            tz = pos.getZ() + this.randomGenerator.nextInt(16) + 8;
            ty = nextInt(this.currentWorld.getTopSolidOrLiquidBlock(pos).getY() * 2);
            tb = new BlockPos(tx, ty, tz);
            this.mushroomRedGen.generate(this.currentWorld, this.randomGenerator, tb);
        }

        doGen = TerrainGen.decorate(currentWorld, randomGenerator, pos, REED);
        for (i = 0; doGen && i < this.reedsPerChunk; ++i)
        {
            tx = pos.getX() + this.randomGenerator.nextInt(16) + 8;
            tz = pos.getZ() + this.randomGenerator.nextInt(16) + 8;
            ty = nextInt(this.currentWorld.getTopSolidOrLiquidBlock(pos).getY() * 2);
            tb = new BlockPos(tx, ty, tz);
            this.reedGen.generate(this.currentWorld, this.randomGenerator, tb);
        }

        for (j = 0; doGen && j < 10; ++j)
        {
            tx = pos.getX() + this.randomGenerator.nextInt(16) + 8;
            tz = pos.getZ() + this.randomGenerator.nextInt(16) + 8;
            ty = nextInt(this.currentWorld.getTopSolidOrLiquidBlock(pos).getY() * 2);
            tb = new BlockPos(tx, ty,tz);
            this.reedGen.generate(this.currentWorld, this.randomGenerator, tb);
        }

        doGen = TerrainGen.decorate(currentWorld, randomGenerator, pos, PUMPKIN);
        if (doGen && this.randomGenerator.nextInt(32) == 0)
        {
            tx = pos.getX() + this.randomGenerator.nextInt(16) + 8;
            tz = pos.getZ() + this.randomGenerator.nextInt(16) + 8;
            ty = nextInt(this.currentWorld.getTopSolidOrLiquidBlock(pos).getY() * 2);
            tb = new BlockPos(tx, ty, tz);
            (new WorldGenPumpkin()).generate(this.currentWorld, this.randomGenerator, tb);
        }

        doGen = TerrainGen.decorate(currentWorld, randomGenerator, pos, CACTUS);
        for (j = 0; doGen && j < this.cactiPerChunk; ++j)
        {
            tx = pos.getX() + this.randomGenerator.nextInt(16) + 8;
            tz = pos.getZ() + this.randomGenerator.nextInt(16) + 8;
            ty = nextInt(this.currentWorld.getTopSolidOrLiquidBlock(pos).getY() * 2);
            tb = new BlockPos(tx, ty, tz);
            this.cactusGen.generate(this.currentWorld, this.randomGenerator, tb);
        }

        doGen = TerrainGen.decorate(currentWorld, randomGenerator, pos, LAKE_WATER);
        if (doGen && this.generateLakes)
        {
            for (j = 0; j < 50; ++j)
            {
                tx = pos.getX() + this.randomGenerator.nextInt(16) + 8;
                ty = this.randomGenerator.nextInt(this.randomGenerator.nextInt(248) + 8);
                tz = this.pos.getZ() + this.randomGenerator.nextInt(16) + 8;
                tb = new BlockPos(tx, ty, tz);
                (new WorldGenLiquids(Blocks.FLOWING_WATER)).generate(this.currentWorld, this.randomGenerator, tb);
            }

            for (j = 0; j < 20; ++j)
            {
                tx = pos.getX() + this.randomGenerator.nextInt(16) + 8;
                ty = this.randomGenerator.nextInt(this.randomGenerator.nextInt(this.randomGenerator.nextInt(240) + 8) + 8);
                tz = pos.getZ() + this.randomGenerator.nextInt(16) + 8;
                tb = new BlockPos(tx, ty, tz);
                (new WorldGenLiquids(Blocks.FLOWING_LAVA)).generate(this.currentWorld, this.randomGenerator, tb);
            }
        }

        MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Post(currentWorld, randomGenerator, pos));
    }

    /**
     * Standard ore generation helper. Generates most ores.
     */
    protected void genStandardOre1(int p_76795_1_, WorldGenerator p_76795_2_, int p_76795_3_, int p_76795_4_)
    {
        for (int l = 0; l < p_76795_1_; ++l)
        {
            int tx = pos.getX() + this.randomGenerator.nextInt(16);
            int ty = this.randomGenerator.nextInt(p_76795_4_ - p_76795_3_) + p_76795_3_;
            int tz = pos.getZ() + this.randomGenerator.nextInt(16);
            BlockPos tb = new BlockPos(tx, ty, tz);
            p_76795_2_.generate(this.currentWorld, this.randomGenerator, tb);
        }
    }

    /**
     * Standard ore generation helper. Generates Lapis Lazuli.
     */
    protected void genStandardOre2(int p_76793_1_, WorldGenerator p_76793_2_, int p_76793_3_, int p_76793_4_)
    {
        for (int l = 0; l < p_76793_1_; ++l)
        {
            int tx = pos.getX() + this.randomGenerator.nextInt(16);
            int ty = this.randomGenerator.nextInt(p_76793_4_) + this.randomGenerator.nextInt(p_76793_4_) + (p_76793_3_ - p_76793_4_);
            int tz = pos.getZ() + this.randomGenerator.nextInt(16);
            BlockPos tb = new BlockPos(tx, ty, tz);
            p_76793_2_.generate(this.currentWorld, this.randomGenerator, tb);
        }
    }

    /**
     * Generates ores in the current chunk
     */
    protected void generateOres()
    {
        MinecraftForge.ORE_GEN_BUS.post(new OreGenEvent.Pre(currentWorld, randomGenerator, pos));
        if (TerrainGen.generateOre(currentWorld, randomGenerator, dirtGen, pos, DIRT))
        this.genStandardOre1(20, this.dirtGen, 0, 256);
        if (TerrainGen.generateOre(currentWorld, randomGenerator, gravelGen, pos, GRAVEL))
        this.genStandardOre1(10, this.gravelGen, 0, 256);
        if (TerrainGen.generateOre(currentWorld, randomGenerator, coalGen, pos, COAL))
        this.genStandardOre1(20, this.coalGen, 0, 128);
        if (TerrainGen.generateOre(currentWorld, randomGenerator, ironGen, pos, IRON))
        this.genStandardOre1(20, this.ironGen, 0, 64);
        MinecraftForge.ORE_GEN_BUS.post(new OreGenEvent.Post(currentWorld, randomGenerator, pos));
    }

    private int nextInt(int i) {
        if (i <= 1)
            return 0;
        return this.randomGenerator.nextInt(i);
	}
}