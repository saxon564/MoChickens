package com.saxon564.mochickens.configs;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.saxon564.mochickens.MoChickens;
import com.saxon564.mochickens.configs.ConfigComments;
import com.saxon564.mochickens.configs.FileManager;

public class ChickenConfigGenerator {

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

	
	public static Configuration setId(FMLPreInitializationEvent event, String fileName, int id) {
		
		path = MoChickens.path + "\\DefaultChickens";
		configFile = new File(path, fileName);
		config = new Configuration(configFile);

		id = config.get("entity data", "ID", id).getInt(id);
		config.save();
		return config;
	}
	
	public static void setConfigs(FMLPostInitializationEvent event, Configuration configIn, boolean canSpawn, 
			int probability, int minGroup, int maxGroup, int minLight, int maxLight, double minTempIn, 
			double maxTempIn, String blacklistWhitelist, String[] biomeListIn, double healthIn, 
			double speedIn, double hitX, double hitZ, boolean despawnUntamed, boolean despawnTamed, 
			boolean hostile, boolean babies, boolean teleport, boolean emitLight, int light, 
			boolean immuneFire, boolean fireInLight, boolean waterHurt, double waterDamaged, 
			boolean emitParticles, String particle, int particleOccurance, String itemTame, int chance, 
			boolean useDataTame, int dataTame, String itemTempt, boolean useDataTempt, int dataTempt, 
			int delay, String itemBreed, boolean useDataBreed, int dataBreed, String itemLay, 
			boolean useDataLay, boolean randomData, int minData, int maxData, int dataLay, int amount, 
			int minLayTime, int varLayTime, String sound, double damage, boolean createFire, 
			int fireLength, double speedAttack, String[] effects, int[] effectDurationsIn, 
			int[] effectAmplifiersIn, double attackRange, int fuse, boolean exploding, int explodingRadius,
			boolean shootArrows, int arrowSpeed, boolean explodingSyndrome, boolean eCSNotifyInfectedOwner,
			boolean eCSWhenTamed, boolean eCSWhenWild, boolean eCSClearWhenTamed, int eCSChance, 
			int eCSBabyChance, int eCSFalseFuse, int eCSExplode, boolean madChicken, 
			boolean mCDNotifyInfectedOwner, boolean mCDWhenTamed, boolean mCDWhenWild, 
			boolean mCDClearWhenTamed, int mCDChance, int mCDBabyChance) {
		config = configIn;
		spawning(canSpawn, probability, minGroup, maxGroup, minLight, maxLight, minTempIn, maxTempIn, 
				blacklistWhitelist, biomeListIn);
		entityData(healthIn, speedIn, hitX, hitZ, despawnUntamed, despawnTamed, hostile, babies, 
				teleport, emitLight, light, immuneFire, fireInLight, waterHurt, waterDamaged, 
				emitParticles, particle, particleOccurance);
		taming(itemTame, chance, useDataTame, dataTame);
		tempting(itemTempt, useDataTempt, dataTempt, delay);
		breeding(itemBreed, useDataBreed, dataBreed);
		laying(itemLay, useDataLay, dataLay, randomData, minData, maxData, amount, 
				minLayTime, varLayTime, sound);
		attackData(damage, createFire, fireLength, speedAttack, 
				effects, effectDurationsIn, effectAmplifiersIn, attackRange, fuse,
				exploding, explodingRadius, shootArrows, arrowSpeed);
		illnesses(explodingSyndrome, eCSNotifyInfectedOwner, eCSWhenTamed, eCSWhenWild, eCSClearWhenTamed, 
				eCSChance, eCSBabyChance, eCSFalseFuse, eCSExplode, madChicken, mCDNotifyInfectedOwner, 
				mCDWhenTamed, mCDWhenWild, mCDClearWhenTamed, mCDChance, mCDBabyChance);
		config.save();
	}
		
	public static void spawning(boolean canSpawn, int probability, int minGroup, int maxGroup, 
			int minLight, int maxLight, double minTempIn, double maxTempIn, 
			String blacklistWhitelist, String[] biomeListIn) { 
		ConfigComments.spawningComments(config);
		spawn = config.get("spawning", "Can Spawn", canSpawn).getBoolean(canSpawn);
		spawnProb = config.get("spawning", "Spawn Probability", probability).getInt(probability);
		minSpawn = config.get("spawning", "Min Spawn Group Size", minGroup).getInt(minGroup);
		maxSpawn = config.get("spawning", "Max Spawn Group Size", maxGroup).getInt(maxGroup);
		minSpawnLight = config.get("spawning", "Min Spawn Light Level", minLight).getInt(minLight);
		maxSpawnLight = config.get("spawning", "Max Spawn Light Level", maxLight).getInt(maxLight);
		maxTemp = config.get("spawning", "Max Spawn Temp", maxTempIn).getDouble(maxTempIn);
		minTemp = config.get("spawning", "Min Spawn Temp", minTempIn).getDouble(minTempIn);
		biomeListType = config.get("spawning", "Biome List Type", blacklistWhitelist).getString();
		biomeList = config.get("spawning", "Biome List", biomeListIn.clone()).getStringList();
	}
		
	public static void entityData(double healthIn, double speedIn, double hitX, double hitZ, 
			boolean despawnUntamed, boolean despawnTamed, boolean hostile, boolean babies, 
			boolean teleport, boolean emitLight, int light, boolean immuneFire, boolean fireInLight, 
			boolean waterHurt, double waterDamaged, boolean emitParticles, String particle, 
			int particleOccurance)	{
		ConfigComments.entityDataComments(config);
		health = config.get("entity data", "Health", healthIn).getDouble(healthIn);
		speed = config.get("entity data", "Walk Speed", speedIn).getDouble(speedIn);
		sizeX = config.get("entity data", "Hit Box Size X", hitX).getDouble(hitX);
		sizeZ = config.get("entity data", "Hit Box Size Z", hitZ).getDouble(hitZ);
		untamedDespawn = config.get("entity data", "Despawn Untamed", despawnUntamed).getBoolean(despawnUntamed);
		tamedDespawn = config.get("entity data", "Despawn Tamed", despawnTamed).getBoolean(despawnTamed);
		isHostile = config.get("entity data", "Hostile", hostile).getBoolean(hostile);
		allowBabies = config.get("entity data", "Allow Breeding", babies).getBoolean(babies);
		canTeleport = config.get("entity data", "Allow Teleporting", teleport).getBoolean(teleport);
		emitsLight = config.get("entity data", "Emits Light", emitLight).getBoolean(emitLight);
		lightLevel = config.get("entity data", "Light Level Emited", light).getInt(light);
		immuneToFire = config.get("entity data", "Immune To Fire", immuneFire).getBoolean(immuneFire);
		burnsInLight = config.get("entity data", "Burns in Sun", fireInLight).getBoolean(fireInLight);
		waterDamage = config.get("entity data", "Gets Hurt by Water", waterHurt).getBoolean(waterHurt);
		damageByWater = config.get("entity data", "Damage From Water", waterDamaged).getDouble(waterDamaged);
		emitsParticles = config.get("entity data", "Emits Particles", emitParticles).getBoolean(emitParticles);
		particleType = config.get("entity data", "Particle Type", particle).getString();
		particleFrequency = config.get("entity data", "Particles Per Tick", particleOccurance).getInt(particleOccurance);
	}
		
	public static void taming(String itemTame, int chance, boolean useDataTame, int dataTame) {
		ConfigComments.tamingComments(config);
		tameItem = config.get("taming", "Taming Item", itemTame).getString();
		tameChance = config.get("taming", "Taming Chance", chance).getInt(chance);
		tameItemUsesData = config.get("taming", "Taming Item Uses Data", useDataTame).getBoolean(useDataTame);
		tameItemData = config.get("taming", "Taming Item Data", dataTame).getInt(dataTame);
	}
		
	public static void tempting(String itemTempt, boolean useDataTempt, int dataTempt, int delay) {
		ConfigComments.temptingComments(config);
		temptItem = config.get("tempting", "Tempting Item", itemTempt).getString();
		temptItemUsesData = config.get("tempting", "Tempting Item Uses Data", useDataTempt).getBoolean(useDataTempt);
		temptItemData = config.get("tempting", "Tempting Item Data", dataTempt).getInt(dataTempt);
		followDelay = config.get("tempting", "Delay Following Between Item Holdings", delay).getInt(delay);
	}
		
	public static void breeding(String itemBreed, boolean useDataBreed, int dataBreed) {	
		ConfigComments.breedingComments(config);
		breedItem = config.get("breeding", "Breeding Item", itemBreed).getString();
		breedItemUsesData = config.get("breeding", "Breeding Item Uses Data", useDataBreed).getBoolean(useDataBreed);
		breedItemData = config.get("breeding", "Breeding Item Data", dataBreed).getInt(dataBreed);
	}
		
	public static void laying(String itemLay, boolean useDataLay, int dataLay, boolean randomData, 
			int minData, int maxData, int amount, int minLayTime, int varLayTime, String sound) {
		ConfigComments.layingComments(config);
		layItem = config.get("laying", "Laying Item", itemLay).getString();
		layItemUsesData = config.get("laying", "Laying Item Uses Data", useDataLay).getBoolean(useDataLay);
		layItemDataRandom = config.get("laying", "Laying Item Uses Random Data", randomData).getBoolean(randomData);
		layItemMinData = config.get("laying", "Laying Item Min Data", minData).getInt(minData);
		layItemMaxData = config.get("laying", "Laying Item Max Data", maxData).getInt(maxData);
		layItemData = config.get("laying", "Laying Item Data", dataLay).getInt(dataLay);
		layAmount = config.get("laying", "Laying Item Amount", amount).getInt(amount);
		minItemLayTime = config.get("laying", "Min Item Lay Time", minLayTime).getInt(minLayTime);
		varItemLayTime = config.get("laying", "Variable Item Lay Time", varLayTime).getInt(varLayTime);
		laySound = config.get("laying", "Laying Sound", sound).getString();
	}
	
	public static void attackData(double damage, boolean createFire, int fireLength, double speedAttack, 
			String[] effects, int[] effectDurationsIn, int[] effectAmplifiersIn, double attackRange, int fuse,
			boolean exploding, int explodingRadius, boolean shootArrows, int arrowSpeed) {
		ConfigComments.attackDataComments(config);
		attackDamage = (float) config.get("attack data", "Attack Damage", damage).getDouble(damage);
		setFire = config.get("attack data", "Set Target On Fire", createFire).getBoolean(createFire);
		fireTimer = config.get("attack data", "Fire Duration", fireLength).getInt(fireLength);
		attackSpeed = config.get("attack data", "Attack Speed", speedAttack).getDouble(speedAttack);
		savedEffectIds = config.get("attack data", "Effect IDs", effects.clone());
		savedEffectDurations = config.get("attack data", "Effect Durations", effectDurationsIn.clone());
		savedEffectAmplifiers = config.get("attack data", "Effect Amplifiers", effectAmplifiersIn.clone());
		trackingRange= config.get("attack data", "Attack Tracking Range", attackRange).getDouble(attackRange);
		fuseTime = config.get("attack data", "Fuse Time", fuse).getInt(fuse);
		canExplode = config.get("attack data", "Can Blow Up", exploding).getBoolean(exploding);
		explosionRadius = config.get("attack data", "Explosion Radius", explodingRadius).getInt(explodingRadius);
		shootsArrows = config.get("attack data", "Can Shoot Arrows", shootArrows).getBoolean(shootArrows);
		shootSpeed = config.get("attack data", "Arrow Shoot Speed", arrowSpeed).getInt(arrowSpeed);
	}
	
	public static void illnesses(boolean explodingSyndrome, boolean eCSNotifyInfectedOwner, 
			boolean eCSWhenTamed, boolean eCSWhenWild, boolean eCSClearWhenTamed, int eCSChance,
			int eCSBabyChance, int eCSFalseFuse, int eCSExplode, boolean madChicken, 
			boolean mCDNotifyInfectedOwner, boolean mCDWhenTamed, boolean mCDWhenWild, 
			boolean mCDClearWhenTamed, int mCDChance, int mCDBabyChance) {
		ConfigComments.illnessesComments(config);
		
		// Exploding Chicken Syndrome
		explodingChickenSyndrome = config.get("exploding chicken syndrome", "Exploding Chicken Syndrome", explodingSyndrome).getBoolean(explodingSyndrome);
		eCSNotifyOwnerWhenInfected = config.get("exploding chicken syndrome", "Notify Owner When Infected", eCSNotifyInfectedOwner).getBoolean(eCSNotifyInfectedOwner);
		eCSInfectedWhenTamed = config.get("exploding chicken syndrome", "Can Be Infected While Tamed", eCSWhenTamed).getBoolean(eCSWhenTamed);
		eCSInfectedWhenWild = config.get("exploding chicken syndrome", "Can Be Infected While Wild", eCSWhenWild).getBoolean(eCSWhenWild);
		eCSClearInfectionWhenTamed = config.get("exploding chicken syndrome", "Clear Infection When Tamed", eCSClearWhenTamed).getBoolean(eCSClearWhenTamed);
		eCSInfectionChance = config.get("exploding chicken syndrome", "Infection Chance", eCSChance).getInt(eCSChance);
		eCSBabyInfectionChance = config.get("exploding chicken syndrome", "Infection Chance When Baby", eCSBabyChance).getInt(eCSBabyChance);
		eCSFalseFuseChance = config.get("exploding chicken syndrome", "False Fuse Chance", eCSFalseFuse).getInt(eCSFalseFuse);
		eCSExplosionChance = config.get("exploding chicken syndrome", "Explosion Chance", eCSExplode).getInt(eCSExplode);
		
		// Mad Chicken Disease
		madChickenDisease = config.get("mad chicken disease", "Mad Chicken Disease", madChicken).getBoolean(madChicken);
		mCDNotifyOwnerWhenInfected = config.get("mad chicken disease", "Notify Owner When Infected", mCDNotifyInfectedOwner).getBoolean(mCDNotifyInfectedOwner);
		mCDInfectedWhenTamed = config.get("mad chicken disease", "Can Be Infected While Tamed", mCDWhenTamed).getBoolean(mCDWhenTamed);
		mCDInfectedWhenWild = config.get("mad chicken disease", "Can Be Infected While Wild", mCDWhenWild).getBoolean(mCDWhenWild);
		mCDClearInfectionWhenTamed = config.get("mad chicken disease", "Clear Infection When Tamed", mCDClearWhenTamed).getBoolean(mCDClearWhenTamed);
		mCDInfectionChance = config.get("mad chicken disease", "Infection Chance", mCDChance).getInt(mCDChance);
		mCDBabyInfectionChance = config.get("mad chicken disease", "Infection Chance When Baby", mCDBabyChance).getInt(mCDBabyChance);
	}
}
