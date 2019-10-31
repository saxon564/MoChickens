package com.saxon564.mochickens.configs;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.saxon564.mochickens.MoChickens;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;

public class ChickenConfigGenerator extends ForgeConfigSpec.Builder {
	
	private static ConfigComments com = new ConfigComments();

	public static ForgeConfigSpec.Builder CONFIG;

	public BooleanValue IMMUNE_TO_FIRE;
	public BooleanValue HYPOALERGENIC;
	public ConfigValue<Double> WATER_DAMAGE;
	public BooleanValue BURN_IN_SUN;
	public ConfigValue<Integer> SPAWN_PROBIBILITY;
	public ConfigValue<Integer> MINIMUM_SPAWN_GROUP_SIZE;
	public ConfigValue<Integer> MAXIMUM_SPAWN_GROUP_SIZE;
	public ConfigValue<Integer> MINIMUM_SPAWN_LIGHT_LEVEL;
	public ConfigValue<Integer> MAXIMUM_SPAWN_LIGHT_LEVEL;
	public BooleanValue EMITS_PARTICLES;
	public ConfigValue<String> PARTICLE_TYPES;
	public ConfigValue<String> PARTICLE_OCCURANCES;
	public ConfigValue<String> LIVING_SOUND;
	public ConfigValue<String> HURT_SOUND;
	public ConfigValue<String> DEATH_SOUND;
	public ConfigValue<String> STEP_SOUND;
	public ConfigValue<String> BIOME_WHITELIST_OR_BLACKLIST;
	public ConfigValue<String> BIOME_LIST;
	public Map<String, Map<String, Integer>> CUSTOM_BIOMES;
	public ConfigValue<Double> HEALTH;
	public ConfigValue<Double> MOVEMENT_SPEED;
	public BooleanValue CAN_SPAWN;
	public BooleanValue EMITS_LIGHT;
	public ConfigValue<Integer> LIGHT_LEVEL_EMITED;
	public BooleanValue CAN_BE_TAMED;
	public BooleanValue CAN_BE_TEMPTED_WILD;
	public BooleanValue CAN_BE_TEMPTED_TAMED;
	public BooleanValue CAN_LAY_ITEMS_TAMED;
	public BooleanValue CAN_LAY_ITEMS_WILD;
	public BooleanValue UNTAMED_CAN_DESPAWN;
	public BooleanValue TAMED_CAN_DESPAWN;
	public ConfigValue<Float> MINIMUM_SPAWN_TEMP;
	public ConfigValue<Float> MAXIMUM_SPAWN_TEMP;
	public ConfigValue<String> TAMING_ITEMS;
	public ConfigValue<Integer> TAMING_CHANCE;
	public ConfigValue<String> TEMPTING_ITEMS;
	public ConfigValue<Integer> FOLLOWING_DELAY_BETWEEN_ITEM_HOLDINGS;
	public ConfigValue<String> BREEDING_ITEMS;
	public ConfigValue<Integer> VARIABLE_LAYING_TIME;
	public ConfigValue<Integer> MINIMUM_LAYING_TIME;
	public ConfigValue<Integer> NUMBER_OF_ITEMS_TO_LAY;
	public ConfigValue<String> LAYING_ITEMS;
	public ConfigValue<String> LAYING_SOUND;
	public BooleanValue CAN_BREED_TAMED;
	public BooleanValue CAN_BREED_WILD;
	public BooleanValue CAN_TELEPORT;
	public BooleanValue IS_HOSTILE;
	public BooleanValue IS_SILENT;
	public ConfigValue<Float> ATTACK_DAMAGE;
	public ConfigValue<String> ATTACK_EFFECTS;
	public ConfigValue<String> ATTACK_EFFECT_DURATIONS;
	public ConfigValue<String> ATTACK_EFFECT_AMPLIFIERS;
	public BooleanValue SET_TARGET_ON_FIRE;
	public ConfigValue<Integer> DURATION_OF_FIRE_ON_TARGET;
	public ConfigValue<Double> ATTACK_MOVEMENT_SPEED;
	public BooleanValue CAN_SHOOT_ARROWS;
	public ConfigValue<Integer> TIME_BETWEEN_ARROWS;
	public ConfigValue<Double> DISTANCE_TO_TRACK_TARGET;
	public ConfigValue<Integer> EXPLOSION_FUSE_TIME;
	public BooleanValue CAN_EXPLODE;
	public ConfigValue<Integer> EXPLOSION_RADIUS;
	public ConfigValue<Float> HIT_BOX_X_SIZE;
	public ConfigValue<Float> HIT_BOX_Z_SIZE;
	public BooleanValue CAN_GET_EXPLODING_CHICKEN_SYNDROME;
	public BooleanValue ECS_NOTIFY_OWNER_WHEN_INFECTED;
	public BooleanValue ECS_CAN_BE_INFECTED_WHEN_WILD;
	public BooleanValue ECS_CAN_BE_INFECTED_WHEN_TAMED;
	public BooleanValue ECS_CLEAR_INFECTION_UPON_TAMING;
	public ConfigValue<Integer> ECS_BABY_INFECTION_CHANCE;
	public ConfigValue<Integer> ECS_ADULT_INFECTION_CHANCE;
	public BooleanValue ECS_DOES_FALSE_FUSE;
	public ConfigValue<Integer> ECS_FALSE_FUSE_CHANCE;
	public ConfigValue<Integer> ECS_EXPLOSION_CHANCE;
	public BooleanValue CAN_GET_MAD_CHICKEN_DISEASE;
	public BooleanValue MCD_NOTIFY_OWNER_WHEN_INFECTED;
	public BooleanValue MCD_CAN_BE_INFECTED_WHEN_WILD;
	public BooleanValue MCD_CAN_BE_INFECTED_WHEN_TAMED;
	public BooleanValue MCD_CLEAR_INFECTION_UPON_TAMING;
	public ConfigValue<Integer> MCD_BABY_INFECTION_CHANCE;
	public ConfigValue<Integer> MCD_ADULT_INFECTION_CHANCE;
	public BooleanValue CAN_GET_TRICKLE_CHICKEN_DISORDER;
	public BooleanValue TCD_NOTIFY_OWNER_WHEN_INFECTED;
	public BooleanValue TCD_CAN_BE_INFECTED_WHEN_WILD;
	public BooleanValue TCD_CAN_BE_INFECTED_WHEN_TAMED;
	public BooleanValue TCD_CLEAR_INFECTION_UPON_TAMING;
	public ConfigValue<Integer> TCD_BABY_INFECTION_CHANCE;
	public ConfigValue<Integer> TCD_ADULT_INFECTION_CHANCE;
	public ConfigValue<Float> TCD_BASE_SLOWNESS_FACTOR;
	public ConfigValue<Float> TCD_MAXIMUM_SLOWNESS_FACTOR;
	public ConfigValue<Integer> TCD_SLOWNESS_FACTOR_CHANGE_CHANCE;
	public ConfigValue<Float> TCD_SLOWNESS_FACTOR_CHANGE_FACTOR;
	public ConfigValue<Integer> BABY_TO_ADULT_TIME;
	public BooleanValue CHILD_SPAWNS_TAMED;
	public BooleanValue CAN_BE_IGNITED;
	public BooleanValue MOVES_WHEN_PRIMED;
	public ConfigValue<Double> PRIMED_MOVEMENT_SPEED;
	public BooleanValue OWNER_ONLY_BREEDING;
	public BooleanValue OWNER_ONLY_TEMPTING;
	public ConfigValue<Double> TEMPTED_WALKING_SPEED;
	public BooleanValue TEMPT_SCARED_BY_PLAYER;

		
	public ForgeConfigSpec.Builder buildConfig(ForgeConfigSpec.Builder builder,
//			< ----- Spawning ----- >
			boolean canSpawn, int probability, int minGroup, int maxGroup,
			int minLight, int maxLight, double minTempIn, double maxTempIn,
			String blacklistWhitelist, List<String> biomeListIn, Map<String, Map<String, Integer>> customBiomes,
//			< ----- Entity Data ----- >
			double healthIn, double speedIn, double hitX, double hitZ,
			boolean despawnUntamed, boolean despawnTamed, boolean silent,
			boolean teleport, boolean emitLight, int light,
			boolean immuneFire, boolean fireInLight, boolean waterHurt,
			double waterDamaged, boolean emitParticles, List<String> particle,
			List<String> particleOccurance, String livingSound,
			String hurtSound, String deathSound, String stepSound, boolean canBeIgnited, 
//			< ----- Taming ----- >
			boolean canTame, List<String> itemTame, int chance,
//			< ----- Tempting ----- >
			boolean canTemptTamed, boolean canTemptWild, List<String> itemTempt, int delay,
			boolean ownerOnlyTempting, double temptedWalkingSpeed, boolean temptScareByPlayer,
//			< ----- Breeding ----- >
			boolean canBreedTamed, boolean canBreedWild, List<String> itemBreed,  int growTime,
			boolean childSpawnsTamed, boolean ownerOnlyBreeding,
//			< ----- Laying ----- >
			boolean laysItemsTamed, boolean laysItemsWild, List<String> itemLay, int amount, int minLayTime,
			int varLayTime, String laySound,
//			< ----- Attack Data ----- >
			boolean hostile, float damage, boolean createFire, int fireLength,
			double speedAttack, List<String> effects, List<String> effectDurationsIn,
			List<String> effectAmplifiersIn, double attackRange, boolean canExplode,
			int fuse, int explosionRadius, boolean movesWhenPrimed, double primedMovementSpeed,
			boolean canShootArrows, int arrowSpeed,
//			< ----- Exploding Chicken Syndrome ----- >
			boolean explodingSyndrome, boolean eCSNotifyInfectedOwner,
			boolean eCSWhenTamed, boolean eCSWhenWild, boolean eCSClearWhenTamed,
			int eCSChance, int eCSBabyChance, boolean eCSDoesFalseFuse, int eCSFalseFuse,
			int eCSExplode,
//			< ----- Mad Chicken Disease ----- >
			boolean madChicken, boolean mCDNotifyInfectedOwner, boolean mCDWhenTamed,
			boolean mCDWhenWild, boolean mCDClearWhenTamed, int mCDChance,
			int mCDBabyChance,
//			< ----- Trickle Chicken Disorder ----- >
			boolean trickleChicken, boolean tCDNotifyInfectedOwner,  boolean tCDWhenTamed,
			boolean tCDWhenWild, boolean tCDClearWhenTamed,
			int tCDChance, int tCDBabyChance, double tCDBaseFactor, double tCDMaxFactor,
			int tCDAdjustChance, double tCDAdjustFactor) {
		CONFIG = builder;
		
		spawning(canSpawn, probability, minGroup, maxGroup, minLight, maxLight, minTempIn, maxTempIn, 
				blacklistWhitelist, biomeListIn, customBiomes);
		entityData(healthIn, speedIn, hitX, hitZ, despawnUntamed, despawnTamed, silent, 
				teleport, emitLight, light, immuneFire, fireInLight, waterHurt, waterDamaged, 
				emitParticles, particle, particleOccurance, livingSound, hurtSound, deathSound,
				stepSound, canBeIgnited);
		taming(canTame, itemTame, chance);
		tempting(canTemptTamed, canTemptWild, itemTempt, delay, ownerOnlyTempting, temptedWalkingSpeed, temptScareByPlayer);
		breeding(canBreedTamed, canBreedWild, itemBreed, growTime, childSpawnsTamed, ownerOnlyBreeding);
		laying(laysItemsTamed, laysItemsWild, itemLay, amount, minLayTime, varLayTime, laySound);
		attackData(hostile, damage, createFire, fireLength, speedAttack, 
				effects, effectDurationsIn, effectAmplifiersIn, attackRange, canExplode, fuse,
				explosionRadius, movesWhenPrimed, primedMovementSpeed, canShootArrows, arrowSpeed);
		explodingChickenSyndrome(explodingSyndrome, eCSNotifyInfectedOwner, eCSWhenTamed, eCSWhenWild,
				eCSClearWhenTamed, eCSChance, eCSBabyChance, eCSDoesFalseFuse, eCSFalseFuse, eCSExplode);
		madChickenDisease(madChicken, mCDNotifyInfectedOwner, mCDWhenTamed, mCDWhenWild,
				mCDClearWhenTamed, mCDChance, mCDBabyChance); 
		trickleChickenDisorder(trickleChicken, tCDNotifyInfectedOwner, tCDWhenTamed, tCDWhenWild, 
				tCDClearWhenTamed, tCDChance, tCDBabyChance, tCDBaseFactor, tCDMaxFactor,
				tCDAdjustChance, tCDAdjustFactor);
		return CONFIG;
	}

	public void spawning(boolean canSpawn, int probability, int minGroup, int maxGroup, 
			int minLight, int maxLight, double minTemp, double maxTemp, 
			String blacklistWhitelist, List<String> biomeList, Map<String, Map<String, Integer>> customBiomes) {
		CONFIG.comment(com.SPAWNING_COMMENT).push("Spawning");
		CAN_SPAWN = CONFIG.translation("canSpawn").comment(com.CAN_SPAWN + canSpawn).define("Can_Spawn", canSpawn);
		SPAWN_PROBIBILITY = CONFIG.translation("spawnProbability").comment(com.SPAWNING_PROBABILITY + probability).define("Spawn_Probability", probability);
		MINIMUM_SPAWN_GROUP_SIZE = CONFIG.translation("minSpawnGroupSize").comment(com.MIN_GROUP + minGroup).define("Min_Spawn_Group_Size", minGroup);
		MAXIMUM_SPAWN_GROUP_SIZE = CONFIG.translation("maxSpawnGroupSize").comment(com.MAX_GROUP + maxGroup).define("Max_Spawn_Group_Size",maxGroup);
		MINIMUM_SPAWN_LIGHT_LEVEL = CONFIG.translation("minSpawnLightLevel").comment(com.MIN_LIGHT + minLight).define("Min_Spawn_Light_Level", minLight);
		MAXIMUM_SPAWN_LIGHT_LEVEL = CONFIG.translation("maxSpawnLightLevel").comment(com.MAX_LIGHT + maxLight).define("Max_Spawn_Light_Level", maxLight);
		MINIMUM_SPAWN_TEMP = CONFIG.translation("minSpawnTemp").comment(com.MIN_TEMP + minTemp).define("Min_Spawn_Temp", (float) minTemp);
		MAXIMUM_SPAWN_TEMP = CONFIG.translation("maxSpawnTemp").comment(com.MAX_TEMP + maxTemp).define("Max_Spawn_Temp", (float) maxTemp);
		BIOME_WHITELIST_OR_BLACKLIST = CONFIG.translation("biomeListType").comment(com.BIOME_LIST_TYPE + blacklistWhitelist + "\"").define("Biome_List_Type", blacklistWhitelist);
		BIOME_LIST = CONFIG.translation("biomeList").comment(com.BIOME_LIST + biomeList.toString() + "\"").define("Biome_List", biomeList.toString());
		Set<String> biomes = customBiomes.keySet();
		for (String b:biomes) {
			CONFIG.translation(b + "_spawnProbability").comment(com.SPAWNING_PROBABILITY + customBiomes.get(b).get("probability")).define(b + ".Spawn_Probability", customBiomes.get(b).get("probability"));
			CONFIG.translation(b + "_minSpawnGroupSize").comment(com.MIN_GROUP + customBiomes.get(b).get("max_group")).define(b + ".Min_Spawn_Group_Size", customBiomes.get(b).get("max_group"));
			CONFIG.translation(b + "_maxSpawnGroupSize").comment(com.MAX_GROUP + customBiomes.get(b).get("min_group")).define(b + ".Max_Spawn_Group_Size", customBiomes.get(b).get("min_group"));
		}
		CONFIG.pop();
	}
		
	public void entityData(double health, double speed, double hitX, double hitZ, 
			boolean despawnUntamed, boolean despawnTamed, boolean silent, 
			boolean teleport, boolean emitLight, int light, boolean immuneFire, boolean fireInLight, 
			boolean waterHurt, double waterDamaged, boolean emitParticles, List<String> particle, 
			List<String> particleOccurance, String livingSound, String hurtSound, String deathSound,
			String stepSound, boolean canBeIgnited)	{
		CONFIG.push("Entity_Data");
		HEALTH = CONFIG.translation("health").comment(com.HEALTH + health).define("Health", health);
		MOVEMENT_SPEED = CONFIG.translation("walkSpeed").comment(com.SPEED + speed).define("Walk_Speed", speed);
		HIT_BOX_X_SIZE = CONFIG.translation("hitBoxSizeX").comment(com.X_HIT_BOX + hitX).define("Hit_Box_Size_X", (float) hitX);
		HIT_BOX_Z_SIZE = CONFIG.translation("hitBoxSizeZ").comment(com.Z_HIT_BOX + hitZ).define("Hit_Box_Size_Z", (float)  hitZ);
		UNTAMED_CAN_DESPAWN = CONFIG.translation("despawnUntamed").comment(com.DESPAWN_UNTAMED + despawnUntamed).define("Despawn_Untamed", despawnUntamed);
		TAMED_CAN_DESPAWN = CONFIG.translation("despawnTamed").comment(com.DESPAWN_TAMED + despawnTamed).define("Despawn_Tamed", despawnTamed);
		IS_SILENT = CONFIG.translation("silent").comment(com.SILENT + silent).define("Silent", silent);
		CAN_TELEPORT = CONFIG.translation("allowTeleporting").comment(com.TELEPORT + teleport).define("Allow_Teleporting", teleport);
		EMITS_LIGHT = CONFIG.translation("emitsLight").comment(com.EMIT_LIGHT + emitLight).define("Emits_Light", emitLight);
		LIGHT_LEVEL_EMITED = CONFIG.translation("lightLevelEmited").comment(com.LIGHT_LEVEL + light).define("Light_Level_Emited", light);
		IMMUNE_TO_FIRE = CONFIG.translation("immuneToFire").comment(com.FIRE_IMMUNE + immuneFire).define("Immune_To_Fire", immuneFire);
		BURN_IN_SUN = CONFIG.translation("burnsInSun").comment(com.SUN_BURN + fireInLight).define("Burns_in_Sun", fireInLight);
		HYPOALERGENIC = CONFIG.translation("hurtByWater").comment(com.HYPOALERGENIC + waterHurt).define("Hypoalergenic", waterHurt);
		WATER_DAMAGE = CONFIG.translation("damageFromWater").comment(com.WATER_DAMAGE + waterDamaged).define("Damage_From_Water", waterDamaged);
		EMITS_PARTICLES = CONFIG.translation("emitsParticles").comment(com.EMITS_PARTICLES + emitParticles).define("Emits_Particles", emitParticles);
		PARTICLE_TYPES = CONFIG.translation("particleType").comment(com.PARTICLES + particle.toString() + "\"").define("Particle_Types", particle.toString());
		PARTICLE_OCCURANCES = CONFIG.translation("particlesPerTick").comment(com.PARTICLE_OCCURANCES + particleOccurance.toString() + "\"").define("Particles_Per_Tick", particleOccurance.toString());
		LIVING_SOUND = CONFIG.translation("livingSound").comment(com.LIVING_SOUND + livingSound + "\"").define("Living_Sound", livingSound);
		HURT_SOUND = CONFIG.translation("hurtSound").comment(com.HURT_SOUND + hurtSound + "\"").define("Hurt_Sound", hurtSound);
		DEATH_SOUND = CONFIG.translation("deathSound").comment(com.DEATH_SOUND + deathSound + "\"").define("Death_Sound", deathSound);
		STEP_SOUND = CONFIG.translation("stepSound").comment(com.STEP_SOUND + stepSound + "\"").define("Step_Sound", stepSound);
		CAN_BE_IGNITED = CONFIG.translation("canBeIgnited").comment(com.IGNITEABLE + canBeIgnited).define("Ignite_With_Flint_And_Steel", canBeIgnited);
		CONFIG.pop();
	}
		
	public void taming(boolean canTame, List<String> itemTame, int chance) {
		CONFIG.push("Taming");
		CAN_BE_TAMED = CONFIG.translation("canTame").comment(com.TAMABLE + canTame).define("Can_Be_Tamed", canTame);
		TAMING_ITEMS = CONFIG.translation("tamingItems").comment(com.TAMING_ITEMS + itemTame.toString() + "\"").define("Taming_Items", itemTame.toString());
		TAMING_CHANCE = CONFIG.translation("tamingChance").comment(com.TAMING_CHANCE + chance).define("Taming_Chance", chance);
		CONFIG.pop();
	}
		
	public void tempting(boolean canTemptTamed, boolean canTemptWild, List<String> itemTempt, int delay, boolean ownerOnlyTempting,
			double temptedWalkingSpeed, boolean temptScareByPlayer) {
		CONFIG.comment(com.TEMPTING_COMMENT).push("Tempting");
		CAN_BE_TEMPTED_TAMED = CONFIG.translation("canTemptTamed").define("Can_Be_Tempted_When_Tamed", canTemptTamed);
		CAN_BE_TEMPTED_WILD = CONFIG.translation("canTemptWild").define("Can_Be_Tempted_When_Wild", canTemptWild);
		TAMING_ITEMS = CONFIG.translation("temptingItems").define("Tempting_Items", itemTempt.toString());
		FOLLOWING_DELAY_BETWEEN_ITEM_HOLDINGS = CONFIG.translation("temptingDelay").define("Delay_Following_Between_Item_Holdings", delay);
		OWNER_ONLY_TEMPTING = CONFIG.translation("ownerOnlyTempting").define("Only_Owner_Can_Tempt", ownerOnlyTempting);
		TEMPTED_WALKING_SPEED = CONFIG.translation("temptedWalkingSpeed").define("Walking_Speed_When_Tempted", temptedWalkingSpeed);
		TEMPT_SCARED_BY_PLAYER = CONFIG.translation("temptScaredByPlayer").define("Can_Be_Scared_By_Player_While_Tempting", temptScareByPlayer);
		CONFIG.pop();
	}
		
	public void breeding(boolean canBreedTamed, boolean canBreedWild, List<String> itemBreed, int growTime,
			boolean childSpawnsTamed, boolean ownerOnlyBreeding) {	
		CONFIG.comment(com.BREEDING_COMMENT).push("Breeding");
		CAN_BREED_TAMED = CONFIG.translation("allowBreedingTamed").define("Allow_Breeding_When_Tamed", canBreedTamed);
		CAN_BREED_WILD = CONFIG.translation("allowBreedingWild").define("Allow_Breeding_When_Tamed", canBreedWild);
		BREEDING_ITEMS = CONFIG.translation("breedingItems").define("Breeding_Items", itemBreed.toString());
		BABY_TO_ADULT_TIME = CONFIG.translation("growTime").define("Growing_Time", growTime);
		CHILD_SPAWNS_TAMED = CONFIG.translation("childSpawnsTamed").define("Child_Spawns_Tamed", childSpawnsTamed);
		OWNER_ONLY_BREEDING = CONFIG.translation("ownerOnlyBreeding").define("Only_Owner_Can_Breed", ownerOnlyBreeding);
		CONFIG.pop();
	}
		
	public void laying(boolean laysItemsTamed, boolean laysItemsWild, List<String> itemLay, int amount, int minLayTime, int varLayTime, String sound) {
		CONFIG.comment(com.LAYING_COMMENT).push("Laying");
		CAN_LAY_ITEMS_TAMED = CONFIG.translation("laysItemsTamed").define("Can_Lay_Items_When_Tamed", laysItemsTamed);
		CAN_LAY_ITEMS_WILD = CONFIG.translation("laysItemsWild").define("Can_Lay_Items_When_Wild", laysItemsWild);
		LAYING_ITEMS = CONFIG.translation("layingItems").define("Laying_Items", itemLay.toString());
		NUMBER_OF_ITEMS_TO_LAY = CONFIG.translation("layingAmounts").define("Laying_Item_Amounts", amount);
		MINIMUM_LAYING_TIME = CONFIG.translation("minLayTime").define("Min_Item_Lay_Time", minLayTime);
		VARIABLE_LAYING_TIME = CONFIG.translation("varLayTime").define("Variable_Item_Lay_Time", varLayTime);
		LAYING_SOUND = CONFIG.translation("layingSounds").define("Laying_Sounds", sound.toString());
		CONFIG.pop();
	}
	
	public void attackData(boolean hostile, float damage, boolean createFire, int fireLength,
			double speedAttack, List<String> effects, List<String> effectDurationsIn,
			List<String> effectAmplifiersIn, double attackRange, boolean exploding, int fuse,
			int explodingRadius, boolean chickenMovesPrimed, double primedMovementSpeed,
			boolean shootArrows, int arrowSpeed) {
		CONFIG.comment(com.ATTACK_DATA_COMMENT).push("Attack_Data");
		IS_HOSTILE = CONFIG.translation("hostile").define("Hostile", hostile);
		ATTACK_DAMAGE = CONFIG.translation("attackDamage").define("Attack_Damage", damage);
		SET_TARGET_ON_FIRE = CONFIG.translation("targetOnFire").define("Set_Target_On_Fire", createFire);
		DURATION_OF_FIRE_ON_TARGET = CONFIG.translation("fireLength").define("Fire_Duration", fireLength);
		ATTACK_MOVEMENT_SPEED = CONFIG.translation("attackSpeed").define("Attack_Speed", speedAttack);
		ATTACK_EFFECTS = CONFIG.translation("effects").define("Effects", effects.toString());
		ATTACK_EFFECT_DURATIONS = CONFIG.translation("effectDurations").define("Effect_Durations", effectDurationsIn.toString());
		ATTACK_EFFECT_AMPLIFIERS = CONFIG.translation("effectAmplifiers").define("Effect_Amplifiers", effectAmplifiersIn.toString());
		DISTANCE_TO_TRACK_TARGET = CONFIG.translation("attackTrackingRange").define("Attack_Tracking_Range", attackRange);
		CAN_EXPLODE = CONFIG.translation("canBlowUp").define("Can_Blow_Up", exploding);
		EXPLOSION_FUSE_TIME = CONFIG.translation("fuseTime").define("Fuse_Time", fuse);
		EXPLOSION_RADIUS = CONFIG.translation("explosionRadius").define("Explosion_Radius", explodingRadius);
		MOVES_WHEN_PRIMED = CONFIG.translation("chickenMovesWhenPrimed").define("Chicken_Moved_When_Primed", chickenMovesPrimed);
		PRIMED_MOVEMENT_SPEED = CONFIG.translation("primedChickenMovementSpeed").define("Movement_Speed_When_Primed", primedMovementSpeed);
		CAN_SHOOT_ARROWS = CONFIG.translation("shootsArrows").define("Can_Shoot_Arrows", shootArrows);
		TIME_BETWEEN_ARROWS = CONFIG.translation("arrowRate").define("Arrow_Shoot_Speed", arrowSpeed);
		CONFIG.pop();
	}
	
	public void explodingChickenSyndrome(boolean explodingSyndrome, boolean eCSNotifyInfectedOwner, 
			boolean eCSWhenTamed, boolean eCSWhenWild, boolean eCSClearWhenTamed, int eCSChance,
			int eCSBabyChance, boolean eCSDoesFalseFuse, int eCSFalseFuse, int eCSExplode ) {
		CONFIG.comment(com.EXPLODING_CHICKEN_COMMENT).push("Exploding_Chicken_Syndrome");
		CAN_GET_EXPLODING_CHICKEN_SYNDROME = CONFIG.translation("eCS").define("Exploding_Chicken_Syndrome", explodingSyndrome);
		ECS_NOTIFY_OWNER_WHEN_INFECTED = CONFIG.translation("eCSNotifyOwner").define("Notify_Owner_When_Infected", eCSNotifyInfectedOwner);
		ECS_CAN_BE_INFECTED_WHEN_TAMED = CONFIG.translation("eCSWhenTamed").define("Can_Be_Infected_While_Tamed", eCSWhenTamed);
		ECS_CAN_BE_INFECTED_WHEN_WILD = CONFIG.translation("eCSWhenWild").define("Can_Be_Infected_While_Wild", eCSWhenWild);
		ECS_CLEAR_INFECTION_UPON_TAMING = CONFIG.translation("eCSClearWhenTamed").define("Clear_Infection_When_Tamed", eCSClearWhenTamed);
		ECS_ADULT_INFECTION_CHANCE = CONFIG.translation("eCSChance").define("Infection_Chance", eCSChance);
		ECS_BABY_INFECTION_CHANCE = CONFIG.translation("eCSBabyChance").define("Infection_Chance_When_Baby", eCSBabyChance);
		ECS_DOES_FALSE_FUSE = CONFIG.translation("eCSDoesFalseFuse").define("Does_False_Fuse", eCSDoesFalseFuse);
		ECS_FALSE_FUSE_CHANCE = CONFIG.translation("eCSFalseFuse").define("False_Fuse_Chance", eCSFalseFuse);
		ECS_EXPLOSION_CHANCE = CONFIG.translation("eCSExplodeChance").define("Explosion_Chance", eCSExplode);
		CONFIG.pop();
	}
	
	public void madChickenDisease(boolean madChicken, 
			boolean mCDNotifyInfectedOwner, boolean mCDWhenTamed, boolean mCDWhenWild, 
			boolean mCDClearWhenTamed, int mCDChance, int mCDBabyChance) {
		CONFIG.comment(com.MAD_CHICKEN_COMMENT).push("Mad_Chicken_Disease");
		CAN_GET_MAD_CHICKEN_DISEASE = CONFIG.translation("mCD").define("Mad_Chicken_Disease", madChicken);
		MCD_NOTIFY_OWNER_WHEN_INFECTED = CONFIG.translation("mCDNotifyOwner").define("Notify_Owner_When_Infected", mCDNotifyInfectedOwner);
		MCD_CAN_BE_INFECTED_WHEN_TAMED = CONFIG.translation("mCDWhenTamed").define("Can_Be_Infected_While_Tamed", mCDWhenTamed);
		MCD_CAN_BE_INFECTED_WHEN_WILD = CONFIG.translation("mCDWhenWild").define("Can_Be_Infected_While_Wild", mCDWhenWild);
		MCD_CLEAR_INFECTION_UPON_TAMING = CONFIG.translation("mCDClearWhenTamed").define("Clear_Infection_When_Tamed", mCDClearWhenTamed);
		MCD_ADULT_INFECTION_CHANCE = CONFIG.translation("mCDChance").define("Infection_Chance", mCDChance);
		MCD_BABY_INFECTION_CHANCE = CONFIG.translation("mCDBabyChance").define("Infection_Chance_When_Baby", mCDBabyChance);
		CONFIG.pop();
	}
		
	public void trickleChickenDisorder(boolean trickleChicken, boolean tCDNotifyInfectedOwner,
			boolean tCDWhenTamed, boolean tCDWhenWild, boolean tCDClearWhenTamed, int tCDChance,
			int tCDBabyChance, double tCDBaseFactor, double tCDMaxFactor,int tCDAdjustChance,
			double tCDAdjustFactor) {
		CONFIG.comment(com.TRICKLE_CHICKEN_COMMENT).push("Trickle_Chicken_Disorder");
		CAN_GET_TRICKLE_CHICKEN_DISORDER = CONFIG.translation("tCD").define("Trickle_Chicken_Disorder", trickleChicken);
		TCD_NOTIFY_OWNER_WHEN_INFECTED = CONFIG.translation("tCDNotifyOwner").define("Notify_Owner_When_Infected", tCDNotifyInfectedOwner);
		TCD_CAN_BE_INFECTED_WHEN_TAMED = CONFIG.translation("tCDWhenTamed").define("Can_Be_Infected_While_Tamed", tCDWhenTamed);
		TCD_CAN_BE_INFECTED_WHEN_WILD = CONFIG.translation("tCDWhenWild").define("Can_Be_Infected_While_Wild", tCDWhenWild);
		TCD_CLEAR_INFECTION_UPON_TAMING = CONFIG.translation("tCDClearWhenTamed").define("Clear_Infection_When_Tamed", tCDClearWhenTamed);
		TCD_ADULT_INFECTION_CHANCE = CONFIG.translation("tCDChance").define("Infection_Chance", tCDChance);
		TCD_BABY_INFECTION_CHANCE = CONFIG.translation("tCDBabyChance").define("Infection_Chance_When_Baby", tCDBabyChance);
		TCD_BASE_SLOWNESS_FACTOR = CONFIG.translation("tCDBaseFactor").define("Base_Trickle_Factor", (float) tCDBaseFactor);
		TCD_MAXIMUM_SLOWNESS_FACTOR = CONFIG.translation("tCDMaxFactor").define("Max_Trickle_Factor", (float) tCDMaxFactor);
		TCD_SLOWNESS_FACTOR_CHANGE_CHANCE = CONFIG.translation("tCDAdjustChance").define("Trickle_Adjustment_Chance", tCDAdjustChance);
		TCD_SLOWNESS_FACTOR_CHANGE_FACTOR = CONFIG.translation("tCDAdjustFactor").define("Trickle_Adjustment_Factor", (float) tCDAdjustFactor);
		CONFIG.pop();
	}
}
