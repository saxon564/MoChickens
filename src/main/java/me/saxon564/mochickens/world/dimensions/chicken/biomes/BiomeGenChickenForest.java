package me.saxon564.mochickens.world.dimensions.chicken.biomes;

import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.FLOWERS;
import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS;
import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.TREE;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.*;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.saxon564.mochickens.MoChickens;
import me.saxon564.mochickens.entities.mobs.EntityBeefyChicken;
import me.saxon564.mochickens.entities.mobs.EntityCoalChicken;
import me.saxon564.mochickens.entities.mobs.EntityNuuwChicken;
import me.saxon564.mochickens.world.dimensions.chicken.generators.ChickenBiomeDecorator;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.material.Material;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenClay;
import net.minecraft.world.gen.feature.WorldGenFlowers;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenSand;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.TerrainGen;

public class BiomeGenChickenForest extends BiomeGenBase {
	
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
	
	protected static final BiomeGenBase.Height biomeChicken = new BiomeGenBase.Height(0.3F, 0.3F);

	public BiomeGenChickenForest(int id) {
		super(id);
		setBiomeName("Chicken Forest");
		setDisableRain();
		setHeight(biomeChicken);
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityChicken.class, 30, 4, 10));
		this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityCoalChicken.class, 7, 4, 5));
		this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityBeefyChicken.class, 10, 4, 4));
		this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityNuuwChicken.class, 5, 1, 3));
		this.coalGen = new WorldGenMinable(Blocks.coal_ore, 16);
        this.ironGen = new WorldGenMinable(Blocks.iron_ore, 8);
        this.coalGemGen = new WorldGenMinable(MoChickens.blockCoalGemOreBlock, 5);
        this.gravelGen = new WorldGenSand(Blocks.gravel, 6);
        this.yellowFlowerGen = new WorldGenFlowers(Blocks.yellow_flower);
        
        this.flowersPerChunk = 10;
        this.treesPerChunk = 5;
        this.gravelPerChunk = 50;
        this.clayPerChunk = 5;
        this.grassPerChunk = 5;
	}
	
	public void decorate(World world, Random rand, int chunkX, int chunkZ)
    {
		this.chunk_X = chunkX;
		this.chunk_Z = chunkZ;
		this.currentWorld = world;
		this.RNG = rand;
		if (TerrainGen.generateOre(currentWorld, RNG, coalGen, chunk_X, chunk_Z, COAL))
			this.genStandardOre1(20, this.coalGen, 0, 128, chunkX, chunkZ);
	    if (TerrainGen.generateOre(currentWorld, RNG, ironGen, chunk_X, chunk_Z, IRON))
	        this.genStandardOre1(20, this.ironGen, 0, 64, chunkX, chunkZ);
	    this.genStandardOre1(20, this.coalGemGen, 0, 40, chunkX, chunkZ);
	    
	    /*TREE GENERATOR*/
	    int i = this.treesPerChunk;

        if (this.RNG.nextInt(10) == 0)
        {
            ++i;
        }

        int l;
        int i1;

        boolean doGen = TerrainGen.decorate(currentWorld, RNG, chunk_X, chunk_Z, TREE);
        for (int j = 0; doGen && j < i; ++j)
        {
            int k = this.chunk_X + this.RNG.nextInt(16) + 8;
            l = this.chunk_Z + this.RNG.nextInt(16) + 8;
            i1 = this.currentWorld.getHeightValue(k, l);
            WorldGenAbstractTree worldgenabstracttree = this.func_150567_a(this.RNG);
            worldgenabstracttree.setScale(1.0D, 1.0D, 1.0D);

            if (worldgenabstracttree.generate(this.currentWorld, this.RNG, k, i1, l))
            {
                worldgenabstracttree.func_150524_b(this.currentWorld, this.RNG, k, i1, l);
            }
        }
        
        doGen = TerrainGen.decorate(currentWorld, RNG, chunk_X, chunk_Z, FLOWERS);
        for (int j = 0; doGen && j < this.flowersPerChunk; ++j)
        {
            int k = this.chunk_X + this.RNG.nextInt(16) + 8;
            l = this.chunk_Z + this.RNG.nextInt(16) + 8;
            i1 = nextInt(this.currentWorld.getHeightValue(k, l) + 32);
            String s = this.func_150572_a(this.RNG, k, i1, l);
            BlockFlower blockflower = BlockFlower.func_149857_e(s);

            if (blockflower.getMaterial() != Material.air)
            {
                this.yellowFlowerGen.func_150550_a(blockflower, BlockFlower.func_149856_f(s));
                this.yellowFlowerGen.generate(this.currentWorld, this.RNG, k, i1, l);
            }
        }
        
        doGen = TerrainGen.decorate(currentWorld, RNG, chunk_X, chunk_Z, GRASS);
        for (int j = 0; doGen && j < this.grassPerChunk; ++j)
        {
            int k = this.chunk_X + this.RNG.nextInt(16) + 8;
            l = this.chunk_Z + this.RNG.nextInt(16) + 8;
            i1 = nextInt(this.currentWorld.getHeightValue(k, l) * 2);
            WorldGenerator worldgenerator = this.getRandomWorldGenForGrass(this.RNG);
            worldgenerator.generate(this.currentWorld, this.RNG, k, i1, l);
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
            p_76795_2_.generate(this.currentWorld, this.RNG, i1, j1, k1);
        }
    }
	
	@SideOnly(Side.CLIENT)
    public int getModdedBiomeGrassColor(int original)
    {
        return 0x75f467;
    }

}
