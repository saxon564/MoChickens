package com.saxon564.mochickens.world.dimensions.chicken.biomes;

import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.FLOWERS;
import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS;
import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.TREE;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.COAL;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.IRON;

import java.util.Random;

import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockFlower.EnumFlowerType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenClay;
import net.minecraft.world.gen.feature.WorldGenFlowers;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenSand;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.TerrainGen;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.saxon564.mochickens.MoChickens;
import com.saxon564.mochickens.entities.mobs.EntityBeefyChicken;
import com.saxon564.mochickens.entities.mobs.EntityCoalChicken;
import com.saxon564.mochickens.entities.mobs.EntityNuuwChicken;
import com.saxon564.mochickens.world.dimensions.chicken.generators.ChickenBiomeDecorator;

public class BiomeGenChickenPlains extends Biome {
	
	private WorldGenerator theWorldGenerator;
	public ChickenBiomeDecorator theBiomeDecorator;
	public int chunk_X;
	public int chunk_Z;
	public Random RNG;
	public World currentWorld;
	public WorldGenerator coalGen;
    public WorldGenerator ironGen;
    public WorldGenerator coalGemGen;
    public WorldGenFlowers yellowFlowerGen;
    public WorldGenerator clayGen = new WorldGenClay(4);
    public WorldGenerator gravelGen;
    
    public int treesPerChunk;
    public int flowersPerChunk;
    public int clayPerChunk;
    public int gravelPerChunk;
    public int grassPerChunk;
	
	public BiomeGenChickenPlains(BiomeProperties id) {
		super(id);
		id.setBaseBiome("Chicken Plains");
		id.setRainDisabled();
		id.setBaseHeight(0F);
		id.setHeightVariation(0F);
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityChicken.class, 30, 4, 10));
		this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityCoalChicken.class, 7, 4, 5));
		this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityBeefyChicken.class, 10, 4, 4));
		this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityNuuwChicken.class, 5, 1, 3));
		this.coalGen = new WorldGenMinable(Blocks.COAL_ORE.getDefaultState(), 16);
        this.ironGen = new WorldGenMinable(Blocks.IRON_ORE.getDefaultState(), 8);
        this.coalGemGen = new WorldGenMinable(MoChickens.coal_gem_ore.getDefaultState(), 5);
        this.gravelGen = new WorldGenSand(Blocks.GRAVEL, 6);
        this.yellowFlowerGen = new WorldGenFlowers(Blocks.YELLOW_FLOWER, EnumFlowerType.DANDELION);
        
        this.flowersPerChunk = 10;
        this.gravelPerChunk = 50;
        this.clayPerChunk = 5;
        this.grassPerChunk = 5;
        this.treesPerChunk = 0;
	}
	
	public void decorate(World world, Random rand, BlockPos pos)
    {
		this.currentWorld = world;
		this.RNG = rand;
		if (TerrainGen.generateOre(currentWorld, RNG, coalGen, pos, COAL))
			this.genStandardOre1(20, this.coalGen, 0, 128, pos.getX()/16, pos.getZ()/16);
	    if (TerrainGen.generateOre(currentWorld, RNG, ironGen, pos, IRON))
	        this.genStandardOre1(20, this.ironGen, 0, 64, pos.getX()/16, pos.getZ()/16);
	    this.genStandardOre1(20, this.coalGemGen, 0, 40, pos.getX()/16, pos.getZ()/16);
	    
	    /*TREE GENERATOR*/
	    int i = this.treesPerChunk;

        if (this.RNG.nextInt(10) == 0)
        {
            ++i;
        }

        int tx;
        int tz;
        int ty;
        BlockPos tb;
        boolean doGen = TerrainGen.decorate(currentWorld, RNG, pos, TREE);
        for (int j = 0; doGen && j < i; ++j)
        {
            tx = pos.getX() + this.RNG.nextInt(16) + 8;
            tz = pos.getZ() + this.RNG.nextInt(16) + 8;
            ty = this.currentWorld.getTopSolidOrLiquidBlock(new BlockPos(tx, pos.getY(), tz)).getY();
            tb = new BlockPos(tx, ty, tz);
            WorldGenAbstractTree worldgenabstracttree = this.genBigTreeChance(this.RNG);

            if (worldgenabstracttree.generate(this.currentWorld, this.RNG, tb))
            {
                worldgenabstracttree.generateSaplings(this.currentWorld, this.RNG, tb);
            }
        }
        
        doGen = TerrainGen.decorate(currentWorld, RNG, pos, FLOWERS);
        for (int j = 0; doGen && j < this.flowersPerChunk; ++j)
        {
            tx = pos.getX() + this.RNG.nextInt(16) + 8;
            tz = pos.getZ() + this.RNG.nextInt(16) + 8;
            ty = nextInt(this.currentWorld.getTopSolidOrLiquidBlock(new BlockPos(tx, pos.getY(), tz)).getY() + 32);
            tb = new BlockPos(tx, ty, tz);
            EnumFlowerType ft = this.pickRandomFlower(this.RNG, tb);
            BlockFlower blockflower = ft.getBlockType().getBlock();

            if (blockflower.getMaterial(blockflower.getDefaultState()) != Material.AIR)
            {
            	this.yellowFlowerGen.setGeneratedBlock(blockflower, ft);
                this.yellowFlowerGen.generate(this.currentWorld, this.RNG, tb);
            }
        }
        
        doGen = TerrainGen.decorate(currentWorld, RNG, pos, GRASS);
        for (int j = 0; doGen && j < this.grassPerChunk; ++j)
        {
            tx = pos.getX() + this.RNG.nextInt(16) + 8;
            tz = pos.getZ() + this.RNG.nextInt(16) + 8;
            ty = nextInt(this.currentWorld.getTopSolidOrLiquidBlock(new BlockPos(tx, pos.getY(), tz)).getY() * 2);
            tb = new BlockPos(tx, ty, tz);
            WorldGenerator worldgenerator = this.getRandomWorldGenForGrass(this.RNG);
            worldgenerator.generate(this.currentWorld, this.RNG, tb);
        }
    }
	
	private int nextInt(int i) {
        if (i <= 1)
            return 0;
        return this.RNG.nextInt(i);
	}
	
	protected void genStandardOre1(int p_76795_1_, WorldGenerator p_76795_2_, int p_76795_3_, int p_76795_4_, int chunkX, int chunkZ)
    {
        for (int l = 0; l < p_76795_1_; ++l)
        {
            int i1 = chunkX + this.RNG.nextInt(16);
            int j1 = this.RNG.nextInt(p_76795_4_ - p_76795_3_) + p_76795_3_;
            int k1 = chunk_Z + this.RNG.nextInt(16);
            p_76795_2_.generate(this.currentWorld, this.RNG, new BlockPos(i1, j1, k1));
        }
    }
	
	@SideOnly(Side.CLIENT)
    public int getModdedBiomeGrassColor(int original)
    {
        return 0x75f467;
    }

}
