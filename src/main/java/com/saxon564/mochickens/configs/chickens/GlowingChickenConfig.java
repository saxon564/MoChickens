package com.saxon564.mochickens.configs.chickens;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.saxon564.mochickens.MoChickens;
import com.saxon564.mochickens.configs.ConfigComments;
import com.saxon564.mochickens.configs.FileManager;

public class GlowingChickenConfig {

	public static Configuration config;
	private static File configFile;
	public static String path;

	public static boolean immuneToFire;
	public static boolean waterDamage;
	public static double damageByWater;
	public static boolean burnsInLight;
	public static int id;
	public static int spawnProb;
	public static int minSpawn;
	public static int maxSpawn;
	public static int minSpawnLight;
	public static int maxSpawnLight;
	public static boolean emitsParticles;
	public static String particleType;
	public static String biomeListType;
	public static String[] biomeList;
	public static double health;
	public static double speed;
	public static boolean spawn;
	public static boolean emitsLight;
	public static int lightLevel;
	public static boolean untamedDespawn;
	public static boolean tamedDespawn;
	public static double minTemp;
	public static double maxTemp;
	public static String tameItemType;
	public static int tameItemData;
	public static boolean tameItemUsesData;
	public static String tameItem;
	public static int tameChance;
	public static String temptItemType;
	public static int temptItemData;
	public static boolean temptItemUsesData;
	public static String temptItem;
	public static String breedItemType;
	public static int breedItemData;
	public static boolean breedItemUsesData;
	public static String breedItem;
	public static int varItemLayTime;
	public static int minItemLayTime;
	public static String layItemType;
	public static int layAmount;
	public static int layItemData;
	public static boolean layItemUsesData;
	public static String layItem;
	public static String laySound;
	public static int followDelay;
	public static boolean allowBabies;
	public static boolean canTeleport;
	public static boolean isHostile;
	public static float attackDamage;
	public static String[] effectIds = {"minecraft:night_vision", "minecraft:jump_boost"};
	public static int[] effectDurations = {500, 400};
	public static int[] effectAmplifiers = {2, 5};
	public static Property savedEffectIds;
	public static Property savedEffectDurations;
	public static Property savedEffectAmplifiers;
	public static boolean setFire;
	public static int fireTimer;
	public static double attackSpeed;
	public static boolean shootsArrows;
	public static int shootSpeed;
	public static double trackingRange;
	public static int fuseTime;
	public static boolean canExplode;
	public static int explosionRadius;
	public static double sizeX;
	public static double sizeZ;
	public static int particleFrequency;
	public static boolean layItemDataRandom;
	public static int layItemMinData;
	public static int layItemMaxData;
	public static boolean layModded;
	public static boolean breedModded;
	public static boolean tameModded;
	public static boolean temptModded;
	public static boolean explodingChickenSyndrome;
	public static boolean eCSNotifyOwnerWhenInfected;
	public static boolean eCSInfectedWhenWild;
	public static boolean eCSInfectedWhenTamed;
	public static boolean eCSClearInfectionWhenTamed;
	public static int eCSBabyInfectionChance;
	public static int eCSInfectionChance;
	public static int eCSFalseFuseChance;
	public static int eCSExplosionChance;
	public static boolean madChickenDisease;
	public static boolean mCDNotifyOwnerWhenInfected;
	public static boolean mCDInfectedWhenWild;
	public static boolean mCDInfectedWhenTamed;
	public static boolean mCDClearInfectionWhenTamed;
	public static int mCDBabyInfectionChance;
	public static int mCDInfectionChance;

	public static void setConfigs(FMLPostInitializationEvent event) {
		spawning();
		entityData();
		taming();
		tempting();
		breeding();
		laying();
		attackData();
		illnesses();
		config.save();
	}
	
	public static void setId(FMLPreInitializationEvent event) {
		
		path = MoChickens.path + "\\DefaultChickens";
		configFile = new File(path, "GlowingChicken.cfg");
		config = new Configuration(configFile);

		id = config.get("entity data", "ID", 517).getInt(517);
		config.save();
	}
		
	public static void spawning() { 
		ConfigComments.spawningComments(config);
		spawn = config.get("spawning", "Can Spawn", true).getBoolean(true);
		spawnProb = config.get("spawning", "Spawn Probability", 8).getInt(8);
		minSpawn = config.get("spawning", "Min Spawn Group Size", 2).getInt(2);
		maxSpawn = config.get("spawning", "Max Spawn Group Size", 4).getInt(4);
		minSpawnLight = config.get("spawning", "Min Spawn Light Level", 0).getInt(0);
		maxSpawnLight = config.get("spawning", "Max Spawn Light Level", 12).getInt(12);
		maxTemp = config.get("spawning", "Max Spawn Temp", 100.0D).getDouble(100.0D);
		minTemp = config.get("spawning", "Min Spawn Temp", 0.1D).getDouble(0.1D);
		biomeListType = config.get("spawning", "Biome List Type", "Whitelist").getString();
		biomeList = config.get("spawning", "Biome List", FileManager.defaultNetherWhitelist.clone()).getStringList();
		config.get("8", "Spawn Probability", 8).getInt(8);
		config.get("8", "Min Spawn Group Size", 2).getInt(2);
		config.get("8", "Max Spawn Group Size", 4).getInt(4);
	}
		
	public static void entityData()	{
		ConfigComments.entityDataComments(config);
		health = config.get("entity data", "Health", 6.0D).getDouble(6.0D);
		speed = config.get("entity data", "Walk Speed", 0.25D).getDouble(0.25D);
		sizeX = config.get("entity data", "Hit Box Size X", 0.3D).getDouble(0.3D);
		sizeZ = config.get("entity data", "Hit Box Size Z", 0.7D).getDouble(0.7D);
		untamedDespawn = config.get("entity data", "Despawn Untamed", true).getBoolean(true);
		tamedDespawn = config.get("entity data", "Despawn Tamed", false).getBoolean(false);
		isHostile = config.get("entity data", "Hostile", true).getBoolean(true);
		allowBabies = config.get("entity data", "Allow Breeding", true).getBoolean(true);
		canTeleport = config.get("entity data", "Allow Teleporting", false).getBoolean(false);
		emitsLight = config.get("entity data", "Emits Light", true).getBoolean(true);
		lightLevel = config.get("entity data", "Light Level Emited", 15).getInt(15);
		immuneToFire = config.get("entity data", "Immune To Fire", true).getBoolean(true);
		burnsInLight = config.get("entity data", "Burns in Sun", false).getBoolean(false);
		waterDamage = config.get("entity data", "Gets Hurt by Water", false).getBoolean(false);
		damageByWater = config.get("entity data", "Damage From Water", 0.0D).getDouble(0.0F);
		emitsParticles = config.get("entity data", "Emits Particles", false).getBoolean(false);
		particleType = config.get("entity data", "Particle Type", "none").getString();
		particleFrequency = config.get("entity data", "Particles Per Tick", 0).getInt(0);
	}
		
	public static void taming() {
		ConfigComments.tamingComments(config);
		tameItem = config.get("taming", "Taming Item", "minecraft:glowstone_dust").getString();
		tameChance = config.get("taming", "Taming Chance", 3).getInt(3);
		tameItemUsesData = config.get("taming", "Taming Item Uses Data", false).getBoolean(false);
		tameItemData = config.get("taming", "Taming Item Data", 0).getInt(0);
	}
		
	public static void tempting() {
		ConfigComments.temptingComments(config);
		temptItem = config.get("tempting", "Tempting Item", "minecraft:glowstone").getString();
		temptItemUsesData = config.get("tempting", "Tempting Item Uses Data", false).getBoolean(false);
		temptItemData = config.get("tempting", "Tempting Item Data", 0).getInt(0);
		followDelay = config.get("tempting", "Delay Following Between Item Holdings", 100).getInt(100);
	}
		
	public static void breeding() {	
		ConfigComments.breedingComments(config);
		breedItem = config.get("breeding", "Breeding Item", "minecraft:glowstone_dust").getString();
		breedItemUsesData = config.get("breeding", "Breeding Item Uses Data", false).getBoolean(false);
		breedItemData = config.get("breeding", "Breeding Item Data", 0).getInt(0);
	}
		
	public static void laying() {
		ConfigComments.layingComments(config);
		layItem = config.get("laying", "Laying Item", "minecraft:glowstone_dust").getString();
		layItemUsesData = config.get("laying", "Laying Item Uses Data", false).getBoolean(false);
		layItemDataRandom = config.get("laying", "Laying Item Uses Random Data", false).getBoolean(false);
		layItemMinData = config.get("laying", "Laying Item Min Data", 0).getInt(0);
		layItemMaxData = config.get("laying", "Laying Item Max Data", 0).getInt(0);
		layItemData = config.get("laying", "Laying Item Data", 0).getInt(0);
		layAmount = config.get("laying", "Laying Item Amount", 1).getInt(1);
		minItemLayTime = config.get("laying", "Min Item Lay Time", 6000).getInt(6000);
		varItemLayTime = config.get("laying", "Variable Item Lay Time", 3000).getInt(3000);
		layItem = config.get("laying", "Laying Sound", "entity.chicken.egg").getString();
	}
	
	public static void attackData() {
		ConfigComments.attackDataComments(config);
		attackDamage = (float) config.get("attack data", "Attack Damage", 3.0D).getDouble(3.0D);
		setFire = config.get("attack data", "Set Target On Fire", false).getBoolean(false);
		fireTimer = config.get("attack data", "Fire Duration", 0).getInt(0);
		attackSpeed = config.get("attack data", "Attack Speed", 0.25D).getDouble(0.25D);
		savedEffectIds = config.get("attack data", "Effect IDs", effectIds);
		savedEffectDurations = config.get("attack data", "Effect Durations", effectDurations);
		savedEffectAmplifiers = config.get("attack data", "Effect Amplifiers", effectAmplifiers);
		trackingRange= config.get("attack data", "Attack Tracking Range", 16.0D).getDouble(16.0D);
		fuseTime = config.get("attack data", "Fuse Time", 0).getInt(0);
		canExplode = config.get("attack data", "Can Blow Up", false).getBoolean(false);
		explosionRadius = config.get("attack data", "Explosion Radius", 0).getInt(0);
		shootsArrows = config.get("attack data", "Can Shoot Arrows", false).getBoolean(false);
		shootSpeed = config.get("attack data", "Arrow Shoot Speed", 0).getInt(0);
	}
	
	public static void illnesses() {
		ConfigComments.illnessesComments(config);
		
		// Exploding Chicken Syndrome
		explodingChickenSyndrome = config.get("exploding chicken syndrome", "Exploding Chicken Syndrome", false).getBoolean(false);
		eCSNotifyOwnerWhenInfected = config.get("exploding chicken syndrome", "Notify Owner When Infected", false).getBoolean(false);
		eCSInfectedWhenTamed = config.get("exploding chicken syndrome", "Can Be Infected While Tamed", false).getBoolean(false);
		eCSInfectedWhenWild = config.get("exploding chicken syndrome", "Can Be Infected While Wild", false).getBoolean(false);
		eCSClearInfectionWhenTamed = config.get("exploding chicken syndrome", "Clear Infection When Tamed", false).getBoolean(false);
		eCSInfectionChance = config.get("exploding chicken syndrome", "Infection Chance", 0).getInt(0);
		eCSBabyInfectionChance = config.get("exploding chicken syndrome", "Infection Chance When Baby", 0).getInt(0);
		eCSFalseFuseChance = config.get("exploding chicken syndrome", "False Fuse Chance", 0).getInt(0);
		eCSExplosionChance = config.get("exploding chicken syndrome", "Explosion Chance", 0).getInt(0);
		
		// Mad Chicken Disease
		madChickenDisease = config.get("mad chicken disease", "Mad Chicken Disease", true).getBoolean(true);
		mCDNotifyOwnerWhenInfected = config.get("mad chicken disease", "Notify Owner When Infected", false).getBoolean(false);
		mCDInfectedWhenTamed = config.get("mad chicken disease", "Can Be Infected While Tamed", true).getBoolean(true);
		mCDInfectedWhenWild = config.get("mad chicken disease", "Can Be Infected While Wild", true).getBoolean(true);
		mCDClearInfectionWhenTamed = config.get("mad chicken disease", "Clear Infection When Tamed", false).getBoolean(false);
		mCDInfectionChance = config.get("mad chicken disease", "Infection Chance", 50000).getInt(50000);
		mCDBabyInfectionChance = config.get("mad chicken disease", "Infection Chance When Baby", 37500).getInt(37500);
	}
}
