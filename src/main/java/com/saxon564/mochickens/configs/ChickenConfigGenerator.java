package com.saxon564.mochickens.configs;

import java.io.File;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.electronwill.nightconfig.core.CommentedConfig;
import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.saxon564.mochickens.MoChickens;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.Builder;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;

public class ChickenConfigGenerator extends ForgeConfigSpec.Builder {
	
	private static ConfigComments com = new ConfigComments();

	public static ForgeConfigSpec.Builder CONFIG;
	protected static CommentedFileConfig CONFIG_DATA;
	
	protected static Path TOML_PATH;

	public Boolean DEFAULT_CAN_SPAWN = true;
	public int DEFAULT_SPAWN_PROBIBILITY = 5;
	public int DEFAULT_MINIMUM_SPAWN_GROUP_SIZE = 1;
	public int DEFAULT_MAXIMUM_SPAWN_GROUP_SIZE = 2;
	public int DEFAULT_MINIMUM_SPAWN_LIGHT_LEVEL = 7;
	public int DEFAULT_MAXIMUM_SPAWN_LIGHT_LEVEL = 16;
	public Float DEFAULT_MINIMUM_SPAWN_TEMP = 0.0F;
	public Float DEFAULT_MAXIMUM_SPAWN_TEMP = 0.0F;
	public String DEFAULT_BIOME_WHITELIST_OR_BLACKLIST = "blacklist";
	public List<String> DEFAULT_BIOME_LIST = Arrays.asList("minecraft:ocean","minecraft:deep_ocean","minecraft:frozen_ocean","minecraft:deep_frozen_ocean","minecraft:cold_ocean","minecraft:deep_cold_ocean","minecraft:lukewarm_ocean","minecraft:deep_lukewarm_ocean","minecraft:warm_ocean","minecraft:deep_warm_ocean","minecraft:nether","minecraft:the_end","minecraft:small_end_islands","minecraft:end_midlands","minecraft:end_highlands","minecraft:end_barrens","minecraft:river","minecraft:frozen_river","minecraft:the_void");
	public Map<String, Map<String, Integer>> DEFAULT_CUSTOM_BIOMES = ConfigHandler.buildMaps(Arrays.asList(""), Arrays.asList(""), Arrays.asList(""), Arrays.asList(""));
	public Double DEFAULT_HEALTH = 20.0D;
	public Double DEFAULT_MOVEMENT_SPEED = 0.25D;
	public Float DEFAULT_HIT_BOX_X_SIZE = 0.25F;
	public Float DEFAULT_HIT_BOX_Z_SIZE = 1.1F;
	public Boolean DEFAULT_UNTAMED_CAN_DESPAWN = true;
	public Boolean DEFAULT_TAMED_CAN_DESPAWN = false;
	public Boolean DEFAULT_IS_SILENT = false;
	public Boolean DEFAULT_IS_ENCHANTED = false;
	public Boolean DEFAULT_CAN_TELEPORT = false;
	public Boolean DEFAULT_EMITS_LIGHT = false;
	public int DEFAULT_LIGHT_LEVEL_EMITED = 0;
	public Boolean DEFAULT_IMMUNE_TO_FIRE = false;
	public Boolean DEFAULT_BURN_IN_SUN = false;
	public Boolean DEFAULT_HYPOALERGENIC = false;
	public Double DEFAULT_WATER_DAMAGE = 0.0D;
	public Boolean DEFAULT_EMITS_PARTICLES = false;
	public List<String> DEFAULT_PARTICLE_TYPES = Arrays.asList("");
	public List<String> DEFAULT_PARTICLE_OCCURANCES = Arrays.asList("");
	public List<String> DEFAULT_PARTICLE_ARGUMENTS = Arrays.asList("");
	public String DEFAULT_LIVING_SOUND = "minecraft:entity.chicken.ambient";
	public String DEFAULT_HURT_SOUND = "minecraft:entity.chicken.hurt";
	public String DEFAULT_DEATH_SOUND = "minecraft:entity.chicken.death";
	public String DEFAULT_STEP_SOUND = "minecraft:entity.chicken.step";
	public Boolean DEFAULT_CAN_BE_IGNITED = false;
	public Boolean DEFAULT_CAN_BE_TAMED = true;
	public List<String> DEFAULT_TAMING_ITEMS = Arrays.asList("minecraft:diamond");
	public int DEFAULT_TAMING_CHANCE = 20;
	public Boolean DEFAULT_CAN_BE_TEMPTED_TAMED = true;
	public Boolean DEFAULT_CAN_BE_TEMPTED_WILD = false;
	public List<String> DEFAULT_TEMPTING_ITEMS = Arrays.asList("minecraft:diamond_block");
	public int DEFAULT_FOLLOWING_DELAY_BETWEEN_ITEM_HOLDINGS = 500;
	public Boolean DEFAULT_OWNER_ONLY_TEMPTING = true;
	public Double DEFAULT_TEMPTED_WALKING_SPEED = 1.0;
	public Boolean DEFAULT_TEMPT_SCARED_BY_PLAYER = false;
	public Boolean DEFAULT_CAN_BREED_TAMED = true;
	public Boolean DEFAULT_CAN_BREED_WILD = false;
	public List<String> DEFAULT_BREEDING_ITEMS = Arrays.asList("minecraft:diamond");
	public int DEFAULT_BABY_TO_ADULT_TIME = 12000;
	public Boolean DEFAULT_CHILD_SPAWNS_TAMED = true;
	public Boolean DEFAULT_OWNER_ONLY_BREEDING = false;
	public Boolean DEFAULT_CAN_LAY_ITEMS_TAMED = true;
	public Boolean DEFAULT_CAN_LAY_ITEMS_WILD = false;
	public List<String> DEFAULT_LAYING_ITEMS = Arrays.asList("minecraft:diamond");
	public int DEFAULT_NUMBER_OF_ITEMS_TO_LAY = 1;
	public int DEFAULT_MINIMUM_LAYING_TIME = 5000;
	public int DEFAULT_VARIABLE_LAYING_TIME = 15000;
	public String DEFAULT_LAYING_SOUND = "mochickens:laydiamond";
	public Boolean DEFAULT_IS_HOSTILE = true;
	public Float DEFAULT_ATTACK_DAMAGE = 5.0F;
	public Boolean DEFAULT_SET_TARGET_ON_FIRE = false;
	public int DEFAULT_DURATION_OF_FIRE_ON_TARGET = 0;
	public Double DEFAULT_ATTACK_MOVEMENT_SPEED = 1.0;
	public List<String> DEFAULT_ATTACK_EFFECTS = Arrays.asList("minecraft:blindness","minecraft:slowness");
	public List<String> DEFAULT_ATTACK_EFFECT_DURATIONS = Arrays.asList("10","20");
	public List<String> DEFAULT_ATTACK_EFFECT_AMPLIFIERS = Arrays.asList("1","5");
	public Double DEFAULT_DISTANCE_TO_TRACK_TARGET = 16.0D;
	public Boolean DEFAULT_CAN_EXPLODE = false;
	public int DEFAULT_EXPLOSION_FUSE_TIME = 0;
	public int DEFAULT_EXPLOSION_RADIUS = 0;
	public Boolean DEFAULT_MOVES_WHEN_PRIMED = false;
	public Double DEFAULT_PRIMED_MOVEMENT_SPEED = 0.0D;
	public Boolean DEFAULT_CAN_SHOOT_ARROWS = false;
	public int DEFAULT_TIME_BETWEEN_ARROWS = 0;
	public Boolean DEFAULT_CAN_GET_EXPLODING_CHICKEN_SYNDROME = false;
	public Boolean DEFAULT_ECS_NOTIFY_OWNER_WHEN_INFECTED = false;
	public Boolean DEFAULT_ECS_CAN_BE_INFECTED_WHEN_TAMED = false;
	public Boolean DEFAULT_ECS_CAN_BE_INFECTED_WHEN_WILD = false;
	public Boolean DEFAULT_ECS_CLEAR_INFECTION_UPON_TAMING = false;
	public int DEFAULT_ECS_ADULT_INFECTION_CHANCE = 0;
	public int DEFAULT_ECS_BABY_INFECTION_CHANCE = 0;
	public Boolean DEFAULT_ECS_DOES_FALSE_FUSE = false;
	public int DEFAULT_ECS_FALSE_FUSE_CHANCE = 0;
	public int DEFAULT_ECS_EXPLOSION_CHANCE = 0;
	public Boolean DEFAULT_CAN_GET_MAD_CHICKEN_DISEASE = true;
	public Boolean DEFAULT_MCD_NOTIFY_OWNER_WHEN_INFECTED = false;
	public Boolean DEFAULT_MCD_CAN_BE_INFECTED_WHEN_TAMED = true;
	public Boolean DEFAULT_MCD_CAN_BE_INFECTED_WHEN_WILD = true;
	public Boolean DEFAULT_MCD_CLEAR_INFECTION_UPON_TAMING = false;
	public int DEFAULT_MCD_ADULT_INFECTION_CHANCE = 1000000;
	public int DEFAULT_MCD_BABY_INFECTION_CHANCE = 100000;
	public Boolean DEFAULT_CAN_GET_TRICKLE_CHICKEN_DISORDER = true;
	public Boolean DEFAULT_TCD_NOTIFY_OWNER_WHEN_INFECTED = false;
	public Boolean DEFAULT_TCD_CAN_BE_INFECTED_WHEN_TAMED = true;
	public Boolean DEFAULT_TCD_CAN_BE_INFECTED_WHEN_WILD = true;
	public Boolean DEFAULT_TCD_CLEAR_INFECTION_UPON_TAMING = false;
	public int DEFAULT_TCD_ADULT_INFECTION_CHANCE = 1000000;
	public int DEFAULT_TCD_BABY_INFECTION_CHANCE = 100000;
	public Float DEFAULT_TCD_BASE_SLOWNESS_FACTOR = 0.0F;
	public Float DEFAULT_TCD_MAXIMUM_SLOWNESS_FACTOR = 1.0F;
	public int DEFAULT_TCD_SLOWNESS_FACTOR_CHANGE_CHANCE = 100000;
	public Float DEFAULT_TCD_SLOWNESS_FACTOR_CHANGE_FACTOR = 0.1F;
	public Boolean DEFAULT_USE_CHICKEN_FEET = true;
	public Boolean DEFAULT_USE_CHIN = true;
	public Boolean DEFAULT_USE_CREEPER_FEET = false;
	public Boolean DEFAULT_USE_RIGHT_HORN = false;
	public Boolean DEFAULT_USE_CENTER_HORN = false;
	public Boolean DEFAULT_USE_LEFT_HORN = false;
	public Boolean DEFAULT_USE_FACE_PLATE = false;
	public Boolean DEFAULT_USE_BACK_PLATE = false;
	public Boolean DEFAULT_USE_MANE = false;
	public ConfigValue<Boolean> IMMUNE_TO_FIRE;
	public ConfigValue<Boolean> HYPOALERGENIC;
	public ConfigValue<Double> WATER_DAMAGE;
	public ConfigValue<Boolean> BURN_IN_SUN;
	public ConfigValue<Integer> SPAWN_PROBIBILITY;
	public ConfigValue<Integer> MINIMUM_SPAWN_GROUP_SIZE;
	public ConfigValue<Integer> MAXIMUM_SPAWN_GROUP_SIZE;
	public ConfigValue<Integer> MINIMUM_SPAWN_LIGHT_LEVEL;
	public ConfigValue<Integer> MAXIMUM_SPAWN_LIGHT_LEVEL;
	public ConfigValue<Boolean> EMITS_PARTICLES;
	public ConfigValue<String> PARTICLE_TYPES;
	public ConfigValue<String> PARTICLE_OCCURANCES;
	public ConfigValue<String> PARTICLE_ARGUMENTS;
	public ConfigValue<String> LIVING_SOUND;
	public ConfigValue<String> HURT_SOUND;
	public ConfigValue<String> DEATH_SOUND;
	public ConfigValue<String> STEP_SOUND;
	public ConfigValue<String> BIOME_WHITELIST_OR_BLACKLIST;
	public ConfigValue<String> BIOME_LIST;
	public Map<String, Map<String, Integer>> CUSTOM_BIOMES;
	public ConfigValue<Double> HEALTH;
	public ConfigValue<Double> MOVEMENT_SPEED;
	public ConfigValue<Boolean> CAN_SPAWN;
	public ConfigValue<Boolean> EMITS_LIGHT;
	public ConfigValue<Integer> LIGHT_LEVEL_EMITED;
	public ConfigValue<Boolean> CAN_BE_TAMED;
	public ConfigValue<Boolean> CAN_BE_TEMPTED_WILD;
	public ConfigValue<Boolean> CAN_BE_TEMPTED_TAMED;
	public ConfigValue<Boolean> CAN_LAY_ITEMS_TAMED;
	public ConfigValue<Boolean> CAN_LAY_ITEMS_WILD;
	public ConfigValue<Boolean> UNTAMED_CAN_DESPAWN;
	public ConfigValue<Boolean> TAMED_CAN_DESPAWN;
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
	public ConfigValue<Boolean> CAN_BREED_TAMED;
	public ConfigValue<Boolean> CAN_BREED_WILD;
	public ConfigValue<Boolean> CAN_TELEPORT;
	public ConfigValue<Boolean> IS_HOSTILE;
	public ConfigValue<Boolean> IS_SILENT;
	public ConfigValue<Boolean> IS_ENCHANTED;
	public ConfigValue<Float> ATTACK_DAMAGE;
	public ConfigValue<String> ATTACK_EFFECTS;
	public ConfigValue<String> ATTACK_EFFECT_DURATIONS;
	public ConfigValue<String> ATTACK_EFFECT_AMPLIFIERS;
	public ConfigValue<Boolean> SET_TARGET_ON_FIRE;
	public ConfigValue<Integer> DURATION_OF_FIRE_ON_TARGET;
	public ConfigValue<Double> ATTACK_MOVEMENT_SPEED;
	public ConfigValue<Boolean> CAN_SHOOT_ARROWS;
	public ConfigValue<Integer> TIME_BETWEEN_ARROWS;
	public ConfigValue<Double> DISTANCE_TO_TRACK_TARGET;
	public ConfigValue<Integer> EXPLOSION_FUSE_TIME;
	public ConfigValue<Boolean> CAN_EXPLODE;
	public ConfigValue<Integer> EXPLOSION_RADIUS;
	public ConfigValue<Float> HIT_BOX_X_SIZE;
	public ConfigValue<Float> HIT_BOX_Z_SIZE;
	public ConfigValue<Boolean> CAN_GET_EXPLODING_CHICKEN_SYNDROME;
	public ConfigValue<Boolean> ECS_NOTIFY_OWNER_WHEN_INFECTED;
	public ConfigValue<Boolean> ECS_CAN_BE_INFECTED_WHEN_WILD;
	public ConfigValue<Boolean> ECS_CAN_BE_INFECTED_WHEN_TAMED;
	public ConfigValue<Boolean> ECS_CLEAR_INFECTION_UPON_TAMING;
	public ConfigValue<Integer> ECS_BABY_INFECTION_CHANCE;
	public ConfigValue<Integer> ECS_ADULT_INFECTION_CHANCE;
	public ConfigValue<Boolean> ECS_DOES_FALSE_FUSE;
	public ConfigValue<Integer> ECS_FALSE_FUSE_CHANCE;
	public ConfigValue<Integer> ECS_EXPLOSION_CHANCE;
	public ConfigValue<Boolean> CAN_GET_MAD_CHICKEN_DISEASE;
	public ConfigValue<Boolean> MCD_NOTIFY_OWNER_WHEN_INFECTED;
	public ConfigValue<Boolean> MCD_CAN_BE_INFECTED_WHEN_WILD;
	public ConfigValue<Boolean> MCD_CAN_BE_INFECTED_WHEN_TAMED;
	public ConfigValue<Boolean> MCD_CLEAR_INFECTION_UPON_TAMING;
	public ConfigValue<Integer> MCD_BABY_INFECTION_CHANCE;
	public ConfigValue<Integer> MCD_ADULT_INFECTION_CHANCE;
	public ConfigValue<Boolean> CAN_GET_TRICKLE_CHICKEN_DISORDER;
	public ConfigValue<Boolean> TCD_NOTIFY_OWNER_WHEN_INFECTED;
	public ConfigValue<Boolean> TCD_CAN_BE_INFECTED_WHEN_WILD;
	public ConfigValue<Boolean> TCD_CAN_BE_INFECTED_WHEN_TAMED;
	public ConfigValue<Boolean> TCD_CLEAR_INFECTION_UPON_TAMING;
	public ConfigValue<Integer> TCD_BABY_INFECTION_CHANCE;
	public ConfigValue<Integer> TCD_ADULT_INFECTION_CHANCE;
	public ConfigValue<Float> TCD_BASE_SLOWNESS_FACTOR;
	public ConfigValue<Float> TCD_MAXIMUM_SLOWNESS_FACTOR;
	public ConfigValue<Integer> TCD_SLOWNESS_FACTOR_CHANGE_CHANCE;
	public ConfigValue<Float> TCD_SLOWNESS_FACTOR_CHANGE_FACTOR;
	public ConfigValue<Integer> BABY_TO_ADULT_TIME;
	public ConfigValue<Boolean> CHILD_SPAWNS_TAMED;
	public ConfigValue<Boolean> CAN_BE_IGNITED;
	public ConfigValue<Boolean> MOVES_WHEN_PRIMED;
	public ConfigValue<Double> PRIMED_MOVEMENT_SPEED;
	public ConfigValue<Boolean> OWNER_ONLY_BREEDING;
	public ConfigValue<Boolean> OWNER_ONLY_TEMPTING;
	public ConfigValue<Double> TEMPTED_WALKING_SPEED;
	public ConfigValue<Boolean> TEMPT_SCARED_BY_PLAYER;
	public ConfigValue<Boolean> USE_CHICKEN_FEET;
	public ConfigValue<Boolean> USE_CHIN;
	public ConfigValue<Boolean> USE_CREEPER_FEET;
	public ConfigValue<Boolean> USE_RIGHT_HORN;
	public ConfigValue<Boolean> USE_CENTER_HORN;
	public ConfigValue<Boolean> USE_LEFT_HORN;
	public ConfigValue<Boolean> USE_FACE_PLATE;
	public ConfigValue<Boolean> USE_BACK_PLATE;
	public ConfigValue<Boolean> USE_MANE;

		
	public Builder buildConfig(ForgeConfigSpec.Builder builder, String name, File dir, String toml, ChickenConfigGenerator defaults) {
		if (ConfigHandler.DEBUG.get()) MoChickens.CHICKEN_LOGGER.debug("Generating Configs for " + name);
		CONFIG = builder;
		CONFIG_DATA = CommentedFileConfig.builder(dir.toPath().resolve(toml)).sync().autosave().preserveInsertionOrder().build();
		
		spawning(defaults);
		entityData(defaults);
		taming(defaults);
		tempting(defaults);
		breeding(defaults);
		laying(defaults);
		attackData(defaults);
		modelOptions(defaults);
		explodingChickenSyndrome(defaults);
		madChickenDisease(defaults); 
		trickleChickenDisorder(defaults);
		return CONFIG;
	}

	private void spawning(ChickenConfigGenerator defaults) {
		CONFIG.comment(com.SPAWNING_COMMENT).push("Spawning");
		CAN_SPAWN = CONFIG.translation("canSpawn").comment(com.CAN_SPAWN + defaults.DEFAULT_CAN_SPAWN).define("Can_Spawn\n", defaults.DEFAULT_CAN_SPAWN);
		SPAWN_PROBIBILITY = CONFIG.translation("spawnProbability").comment(com.SPAWNING_PROBABILITY + defaults.DEFAULT_SPAWN_PROBIBILITY).define("Spawn_Probability", defaults.DEFAULT_SPAWN_PROBIBILITY);
		MINIMUM_SPAWN_GROUP_SIZE = CONFIG.translation("minSpawnGroupSize").comment(com.MIN_GROUP + defaults.DEFAULT_MINIMUM_SPAWN_GROUP_SIZE).define("Min_Spawn_Group_Size", defaults.DEFAULT_MINIMUM_SPAWN_GROUP_SIZE);
		MAXIMUM_SPAWN_GROUP_SIZE = CONFIG.translation("maxSpawnGroupSize").comment(com.MAX_GROUP + defaults.DEFAULT_MAXIMUM_SPAWN_GROUP_SIZE).define("Max_Spawn_Group_Size", defaults.DEFAULT_MAXIMUM_SPAWN_GROUP_SIZE);
		MINIMUM_SPAWN_LIGHT_LEVEL = CONFIG.translation("minSpawnLightLevel").comment(com.MIN_LIGHT + defaults.DEFAULT_MINIMUM_SPAWN_LIGHT_LEVEL).define("Min_Spawn_Light_Level", defaults.DEFAULT_MINIMUM_SPAWN_LIGHT_LEVEL);
		MAXIMUM_SPAWN_LIGHT_LEVEL = CONFIG.translation("maxSpawnLightLevel").comment(com.MAX_LIGHT + defaults.DEFAULT_MAXIMUM_SPAWN_LIGHT_LEVEL).define("Max_Spawn_Light_Level", defaults.DEFAULT_MAXIMUM_SPAWN_LIGHT_LEVEL);
		MINIMUM_SPAWN_TEMP = CONFIG.translation("minSpawnTemp").comment(com.MIN_TEMP + defaults.DEFAULT_MINIMUM_SPAWN_TEMP).define("Min_Spawn_Temp", (float) defaults.DEFAULT_MINIMUM_SPAWN_TEMP);
		MAXIMUM_SPAWN_TEMP = CONFIG.translation("maxSpawnTemp").comment(com.MAX_TEMP + defaults.DEFAULT_MAXIMUM_SPAWN_TEMP).define("Max_Spawn_Temp", (float) defaults.DEFAULT_MAXIMUM_SPAWN_TEMP);
		BIOME_WHITELIST_OR_BLACKLIST = CONFIG.translation("biomeListType").comment(com.BIOME_LIST_TYPE + defaults.DEFAULT_BIOME_WHITELIST_OR_BLACKLIST + "\"").define("Biome_List_Type", defaults.DEFAULT_BIOME_WHITELIST_OR_BLACKLIST);
		BIOME_LIST = CONFIG.translation("biomeList").comment(com.BIOME_LIST + defaults.DEFAULT_BIOME_LIST.toString() + "\"").define("Biome_List", defaults.DEFAULT_BIOME_LIST.toString());

		CUSTOM_BIOMES = defaults.DEFAULT_CUSTOM_BIOMES;
		Set<String> biomes = defaults.DEFAULT_CUSTOM_BIOMES.keySet();
		for (String b:biomes) {
			if (b != "") {
				CONFIG.translation(b + "_spawnProbability").comment(com.SPAWNING_PROBABILITY + defaults.DEFAULT_CUSTOM_BIOMES.get(b).get("probability")).define("Biomes." + b + ".Spawn_Probability", defaults.DEFAULT_CUSTOM_BIOMES.get(b).get("probability"));
				CONFIG.translation(b + "_minSpawnGroupSize").comment(com.MIN_GROUP + defaults.DEFAULT_CUSTOM_BIOMES.get(b).get("min_group")).define("Biomes." + b + ".Min_Spawn_Group_Size", defaults.DEFAULT_CUSTOM_BIOMES.get(b).get("min_group"));
				CONFIG.translation(b + "_maxSpawnGroupSize").comment(com.MAX_GROUP + defaults.DEFAULT_CUSTOM_BIOMES.get(b).get("max_group")).define("Biomes." + b + ".Max_Spawn_Group_Size", defaults.DEFAULT_CUSTOM_BIOMES.get(b).get("max_group"));
			}
		}
		readConfig();

		if (ConfigHandler.DEBUG.get()) MoChickens.CHICKEN_LOGGER.error("Internal Stored Biome Values: " + CUSTOM_BIOMES.toString());
		
		CONFIG.pop();
	}
		
	private void entityData(ChickenConfigGenerator defaults)	{
		CONFIG.push("Entity_Data");
		HEALTH = CONFIG.translation("health").comment(com.HEALTH + defaults.DEFAULT_HEALTH).define("Health", defaults.DEFAULT_HEALTH);
		MOVEMENT_SPEED = CONFIG.translation("walkSpeed").comment(com.SPEED + defaults.DEFAULT_MOVEMENT_SPEED).define("Walk_Speed", defaults.DEFAULT_MOVEMENT_SPEED);
		HIT_BOX_X_SIZE = CONFIG.translation("hitBoxSizeX").comment(com.X_HIT_BOX + defaults.DEFAULT_HIT_BOX_X_SIZE).define("Hit_Box_Size_X", (float) defaults.DEFAULT_HIT_BOX_X_SIZE);
		HIT_BOX_Z_SIZE = CONFIG.translation("hitBoxSizeZ").comment(com.Z_HIT_BOX + defaults.DEFAULT_HIT_BOX_Z_SIZE).define("Hit_Box_Size_Z", (float)  defaults.DEFAULT_HIT_BOX_Z_SIZE);
		UNTAMED_CAN_DESPAWN = CONFIG.translation("despawnUntamed").comment(com.DESPAWN_UNTAMED + defaults.DEFAULT_UNTAMED_CAN_DESPAWN).define("Despawn_Untamed", defaults.DEFAULT_UNTAMED_CAN_DESPAWN);
		TAMED_CAN_DESPAWN = CONFIG.translation("despawnTamed").comment(com.DESPAWN_TAMED + defaults.DEFAULT_TAMED_CAN_DESPAWN).define("Despawn_Tamed", defaults.DEFAULT_TAMED_CAN_DESPAWN);
		IS_SILENT = CONFIG.translation("silent").comment(com.SILENT + defaults.DEFAULT_IS_SILENT).define("Silent", defaults.DEFAULT_IS_SILENT);
		CAN_TELEPORT = CONFIG.translation("allowTeleporting").comment(com.TELEPORT + defaults.DEFAULT_CAN_TELEPORT).define("Allow_Teleporting", defaults.DEFAULT_CAN_TELEPORT);
		EMITS_LIGHT = CONFIG.translation("emitsLight").comment(com.EMIT_LIGHT + defaults.DEFAULT_EMITS_LIGHT).define("Emits_Light", defaults.DEFAULT_EMITS_LIGHT);
		LIGHT_LEVEL_EMITED = CONFIG.translation("lightLevelEmited").comment(com.LIGHT_LEVEL + defaults.DEFAULT_LIGHT_LEVEL_EMITED).define("Light_Level_Emited", defaults.DEFAULT_LIGHT_LEVEL_EMITED);
		IMMUNE_TO_FIRE = CONFIG.translation("immuneToFire").comment(com.FIRE_IMMUNE + defaults.DEFAULT_IMMUNE_TO_FIRE).define("Immune_To_Fire", defaults.DEFAULT_IMMUNE_TO_FIRE);
		BURN_IN_SUN = CONFIG.translation("burnsInSun").comment(com.SUN_BURN + defaults.DEFAULT_BURN_IN_SUN).define("Burns_in_Sun", defaults.DEFAULT_BURN_IN_SUN);
		HYPOALERGENIC = CONFIG.translation("hurtByWater").comment(com.HYPOALERGENIC + defaults.DEFAULT_HYPOALERGENIC).define("Hypoalergenic", defaults.DEFAULT_HYPOALERGENIC);
		WATER_DAMAGE = CONFIG.translation("damageFromWater").comment(com.WATER_DAMAGE + defaults.DEFAULT_WATER_DAMAGE).define("Damage_From_Water", defaults.DEFAULT_WATER_DAMAGE);
		EMITS_PARTICLES = CONFIG.translation("emitsParticles").comment(com.EMITS_PARTICLES + defaults.DEFAULT_EMITS_PARTICLES).define("Emits_Particles", defaults.DEFAULT_EMITS_PARTICLES);
		PARTICLE_TYPES = CONFIG.translation("particleType").comment(com.PARTICLES + defaults.DEFAULT_PARTICLE_TYPES.toString() + "\"").define("Particle_Types", defaults.DEFAULT_PARTICLE_TYPES.toString());
		PARTICLE_OCCURANCES = CONFIG.translation("particlesPerTick").comment(com.PARTICLE_OCCURANCES + defaults.DEFAULT_PARTICLE_OCCURANCES.toString() + "\"").define("Particles_Per_Tick", defaults.DEFAULT_PARTICLE_OCCURANCES.toString());
		PARTICLE_ARGUMENTS = CONFIG.translation("particlearguments").comment(com.PARTICLE_ARGUMENTS + defaults.DEFAULT_PARTICLE_ARGUMENTS.toString() + "\"").define("Particles_Arguments", defaults.DEFAULT_PARTICLE_ARGUMENTS.toString());
		LIVING_SOUND = CONFIG.translation("livingSound").comment(com.LIVING_SOUND + defaults.DEFAULT_LIVING_SOUND + "\"").define("Living_Sound", defaults.DEFAULT_LIVING_SOUND);
		HURT_SOUND = CONFIG.translation("hurtSound").comment(com.HURT_SOUND + defaults.DEFAULT_HURT_SOUND + "\"").define("Hurt_Sound", defaults.DEFAULT_HURT_SOUND);
		DEATH_SOUND = CONFIG.translation("deathSound").comment(com.DEATH_SOUND + defaults.DEFAULT_DEATH_SOUND + "\"").define("Death_Sound", defaults.DEFAULT_DEATH_SOUND);
		STEP_SOUND = CONFIG.translation("stepSound").comment(com.STEP_SOUND + defaults.DEFAULT_STEP_SOUND + "\"").define("Step_Sound", defaults.DEFAULT_STEP_SOUND);
		CAN_BE_IGNITED = CONFIG.translation("canBeIgnited").comment(com.IGNITEABLE + defaults.DEFAULT_CAN_BE_IGNITED).define("Ignite_With_Flint_And_Steel", defaults.DEFAULT_CAN_BE_IGNITED);
		CONFIG.pop();
	}
		
	private void taming(ChickenConfigGenerator defaults) {
		CONFIG.push("Taming");
		CAN_BE_TAMED = CONFIG.translation("canTame").comment(com.TAMABLE + defaults.DEFAULT_CAN_BE_TAMED).define("Can_Be_Tamed", defaults.DEFAULT_CAN_BE_TAMED);
		TAMING_ITEMS = CONFIG.translation("tamingItems").comment(com.TAMING_ITEMS + defaults.DEFAULT_TAMING_ITEMS.toString() + "\"").define("Taming_Items", defaults.DEFAULT_TAMING_ITEMS.toString());
		TAMING_CHANCE = CONFIG.translation("tamingChance").comment(com.TAMING_CHANCE + defaults.DEFAULT_TAMING_CHANCE).define("Taming_Chance", defaults.DEFAULT_TAMING_CHANCE);
		CONFIG.pop();
	}
		
	private void tempting(ChickenConfigGenerator defaults) {
		CONFIG.push("Tempting");
		CAN_BE_TEMPTED_TAMED = CONFIG.translation("canTemptTamed").comment(com.TEMPTABLE_TAMED + defaults.DEFAULT_CAN_BE_TEMPTED_TAMED).define("Can_Be_Tempted_When_Tamed", defaults.DEFAULT_CAN_BE_TEMPTED_TAMED);
		CAN_BE_TEMPTED_WILD = CONFIG.translation("canTemptWild").comment(com.TEMPTABLE_WILD + defaults.DEFAULT_CAN_BE_TEMPTED_WILD).define("Can_Be_Tempted_When_Wild", defaults.DEFAULT_CAN_BE_TEMPTED_WILD);
		TEMPTING_ITEMS = CONFIG.translation("temptingItems").comment(com.TEMPTING_ITEMS + defaults.DEFAULT_TEMPTING_ITEMS + "\"").define("Tempting_Items", defaults.DEFAULT_TEMPTING_ITEMS.toString());
		FOLLOWING_DELAY_BETWEEN_ITEM_HOLDINGS = CONFIG.translation("temptingDelay").comment(com.TEMPTING_COOLDOWN + defaults.DEFAULT_FOLLOWING_DELAY_BETWEEN_ITEM_HOLDINGS).define("Delay_Following_Between_Item_Holdings", defaults.DEFAULT_FOLLOWING_DELAY_BETWEEN_ITEM_HOLDINGS);
		OWNER_ONLY_TEMPTING = CONFIG.translation("ownerOnlyTempting").comment(com.OWNER_TEMPTING + defaults.DEFAULT_OWNER_ONLY_TEMPTING).define("Only_Owner_Can_Tempt", defaults.DEFAULT_OWNER_ONLY_TEMPTING);
		TEMPTED_WALKING_SPEED = CONFIG.translation("temptedWalkingSpeed").comment(com.TEMPTING_SPEED + defaults.DEFAULT_TEMPTED_WALKING_SPEED).define("Walking_Speed_When_Tempted", defaults.DEFAULT_TEMPTED_WALKING_SPEED);
		TEMPT_SCARED_BY_PLAYER = CONFIG.translation("temptScaredByPlayer").comment(com.TEMPTING_SCARE + defaults.DEFAULT_TEMPT_SCARED_BY_PLAYER).define("Can_Be_Scared_By_Player_While_Tempting", defaults.DEFAULT_TEMPT_SCARED_BY_PLAYER);
		CONFIG.pop();
	}
		
	private void breeding(ChickenConfigGenerator defaults) {	
		CONFIG.push("Breeding");
		CAN_BREED_TAMED = CONFIG.translation("allowBreedingTamed").comment(com.BREEDING_TAMED + defaults.DEFAULT_CAN_BREED_TAMED).define("Allow_Breeding_When_Tamed", defaults.DEFAULT_CAN_BREED_TAMED);
		CAN_BREED_WILD = CONFIG.translation("allowBreedingWild").comment(com.BREEDING_WILD + defaults.DEFAULT_CAN_BREED_WILD).define("Allow_Breeding_When_Wild", defaults.DEFAULT_CAN_BREED_WILD);
		BREEDING_ITEMS = CONFIG.translation("breedingItems").comment(com.BREEDING_ITEMS + defaults.DEFAULT_BREEDING_ITEMS + "\"").define("Breeding_Items", defaults.DEFAULT_BREEDING_ITEMS.toString());
		BABY_TO_ADULT_TIME = CONFIG.translation("growTime").comment(com.BREEDING_GROW_TIME + defaults.DEFAULT_BABY_TO_ADULT_TIME).define("Growing_Time", defaults.DEFAULT_BABY_TO_ADULT_TIME);
		CHILD_SPAWNS_TAMED = CONFIG.translation("childSpawnsTamed").comment(com.CHILD_TAMED_BREEDING + defaults.DEFAULT_CHILD_SPAWNS_TAMED).define("Child_Spawns_Tamed", defaults.DEFAULT_CHILD_SPAWNS_TAMED);
		OWNER_ONLY_BREEDING = CONFIG.translation("ownerOnlyBreeding").comment(com.OWNER_BREEDING + defaults.DEFAULT_OWNER_ONLY_BREEDING).define("Only_Owner_Can_Breed", defaults.DEFAULT_OWNER_ONLY_BREEDING);
		CONFIG.pop();
	}
		
	private void laying(ChickenConfigGenerator defaults) {
		CONFIG.push("Laying");
		CAN_LAY_ITEMS_TAMED = CONFIG.translation("laysItemsTamed").comment(com.LAYING_TAMED + defaults.DEFAULT_CAN_LAY_ITEMS_TAMED).define("Can_Lay_Items_When_Tamed", defaults.DEFAULT_CAN_LAY_ITEMS_TAMED);
		CAN_LAY_ITEMS_WILD = CONFIG.translation("laysItemsWild").comment(com.LAYING_WILD + defaults.DEFAULT_CAN_LAY_ITEMS_WILD).define("Can_Lay_Items_When_Wild", defaults.DEFAULT_CAN_LAY_ITEMS_WILD);
		LAYING_ITEMS = CONFIG.translation("layingItems").comment(com.LAYING_ITEMS + defaults.DEFAULT_LAYING_ITEMS + "\"").define("Laying_Items", defaults.DEFAULT_LAYING_ITEMS.toString());
		NUMBER_OF_ITEMS_TO_LAY = CONFIG.translation("layingAmounts").comment(com.LAYING_NUMBER + defaults.DEFAULT_NUMBER_OF_ITEMS_TO_LAY).define("Laying_Item_Amounts", defaults.DEFAULT_NUMBER_OF_ITEMS_TO_LAY);
		MINIMUM_LAYING_TIME = CONFIG.translation("minLayTime").comment(com.LAYING_MIN_TIME + defaults.DEFAULT_MINIMUM_LAYING_TIME).define("Min_Item_Lay_Time", defaults.DEFAULT_MINIMUM_LAYING_TIME);
		VARIABLE_LAYING_TIME = CONFIG.translation("varLayTime").comment(com.LAYING_VAR_TIME + defaults.DEFAULT_VARIABLE_LAYING_TIME).define("Variable_Item_Lay_Time", defaults.DEFAULT_VARIABLE_LAYING_TIME);
		LAYING_SOUND = CONFIG.translation("layingSounds").comment(com.LAYING_SOUND + defaults.DEFAULT_LAYING_SOUND).define("Laying_Sounds", defaults.DEFAULT_LAYING_SOUND.toString());
		CONFIG.pop();
	}
	
	private void attackData(ChickenConfigGenerator defaults) {
		CONFIG.push("Attack_Data");
		IS_HOSTILE = CONFIG.translation("hostile").comment(com.HOSTILE + defaults.DEFAULT_IS_HOSTILE).define("Hostile", defaults.DEFAULT_IS_HOSTILE);
		ATTACK_DAMAGE = CONFIG.translation("attackDamage").comment(com.ATTACK_DAMAGE + defaults.DEFAULT_ATTACK_DAMAGE).define("Attack_Damage", defaults.DEFAULT_ATTACK_DAMAGE);
		SET_TARGET_ON_FIRE = CONFIG.translation("targetOnFire").comment(com.ATTACK_TARGET_FIRE + defaults.DEFAULT_SET_TARGET_ON_FIRE).define("Set_Target_On_Fire", defaults.DEFAULT_SET_TARGET_ON_FIRE);
		DURATION_OF_FIRE_ON_TARGET = CONFIG.translation("fireLength").comment(com.ATTACK_FIRE_TIME + defaults.DEFAULT_DURATION_OF_FIRE_ON_TARGET).define("Fire_Duration", defaults.DEFAULT_DURATION_OF_FIRE_ON_TARGET);
		ATTACK_MOVEMENT_SPEED = CONFIG.translation("attackSpeed").comment(com.ATTACK_SPEED + defaults.DEFAULT_ATTACK_MOVEMENT_SPEED).define("Attack_Speed", defaults.DEFAULT_ATTACK_MOVEMENT_SPEED);
		ATTACK_EFFECTS = CONFIG.translation("effects").comment(com.ATTACK_EFFECTS + defaults.DEFAULT_ATTACK_EFFECTS.toString() + "\"").define("Effects", defaults.DEFAULT_ATTACK_EFFECTS.toString());
		ATTACK_EFFECT_DURATIONS = CONFIG.translation("effectDurations").comment(com.ATTACK_EFFECT_DURATIONS + defaults.DEFAULT_ATTACK_EFFECT_DURATIONS.toString() + "\"").define("Effect_Durations", defaults.DEFAULT_ATTACK_EFFECT_DURATIONS.toString());
		ATTACK_EFFECT_AMPLIFIERS = CONFIG.translation("effectAmplifiers").comment(com.ATTACK_EFFECT_AMPLIFIERS + defaults.DEFAULT_ATTACK_EFFECT_AMPLIFIERS.toString() + "\"").define("Effect_Amplifiers", defaults.DEFAULT_ATTACK_EFFECT_AMPLIFIERS.toString());
		DISTANCE_TO_TRACK_TARGET = CONFIG.translation("attackTrackingRange").comment(com.ATTACK_DISTANCE + defaults.DEFAULT_DISTANCE_TO_TRACK_TARGET).define("Attack_Tracking_Range", defaults.DEFAULT_DISTANCE_TO_TRACK_TARGET);
		CAN_EXPLODE = CONFIG.translation("canBlowUp").comment(com.ATTACK_EXPLODING + defaults.DEFAULT_CAN_EXPLODE).define("Can_Blow_Up", defaults.DEFAULT_CAN_EXPLODE);
		EXPLOSION_FUSE_TIME = CONFIG.translation("fuseTime").comment(com.ATTACK_EXPLODING_FUSE + defaults.DEFAULT_EXPLOSION_FUSE_TIME).define("Fuse_Time", defaults.DEFAULT_EXPLOSION_FUSE_TIME);
		EXPLOSION_RADIUS = CONFIG.translation("explosionRadius").comment(com.ATTACK_EXPLODING_RADIUS + defaults.DEFAULT_EXPLOSION_RADIUS).define("Explosion_Radius", defaults.DEFAULT_EXPLOSION_RADIUS);
		MOVES_WHEN_PRIMED = CONFIG.translation("chickenMovesWhenPrimed").comment(com.ATTACK_PRIMED_MOVEMENT + defaults.DEFAULT_MOVES_WHEN_PRIMED).define("Chicken_Moved_When_Primed", defaults.DEFAULT_MOVES_WHEN_PRIMED);
		PRIMED_MOVEMENT_SPEED = CONFIG.translation("primedChickenMovementSpeed").comment(com.ATTACK_PRIMED_SPEED + defaults.DEFAULT_PRIMED_MOVEMENT_SPEED).define("Movement_Speed_When_Primed", defaults.DEFAULT_PRIMED_MOVEMENT_SPEED);
		CAN_SHOOT_ARROWS = CONFIG.translation("shootsArrows").comment(com.ATTACK_ARROWS + defaults.DEFAULT_CAN_SHOOT_ARROWS).define("Can_Shoot_Arrows", defaults.DEFAULT_CAN_SHOOT_ARROWS);
		TIME_BETWEEN_ARROWS = CONFIG.translation("arrowRate").comment(com.ATTACK_ARROWS_RATE + defaults.DEFAULT_TIME_BETWEEN_ARROWS).define("Arrow_Shoot_Speed", defaults.DEFAULT_TIME_BETWEEN_ARROWS);
		CONFIG.pop();
	}
	
	private void modelOptions(ChickenConfigGenerator defaults) {
		CONFIG.push("Model_Options");
		USE_CHIN = CONFIG.translation("useChin").comment(com.USE_CHIN + defaults.DEFAULT_USE_CHIN).define("Use Chin", defaults.DEFAULT_USE_CHIN);
		USE_CHICKEN_FEET = CONFIG.translation("useChickenFeet").comment(com.USE_CHICKEN_FEET + defaults.DEFAULT_USE_CHICKEN_FEET).define("Use_Chicken_Feet", defaults.DEFAULT_USE_CHICKEN_FEET);
		USE_CREEPER_FEET = CONFIG.translation("useCreeperFeet").comment(com.USE_CREEPER_FEET + defaults.DEFAULT_USE_CREEPER_FEET).define("Use_Creeper_Feet", defaults.DEFAULT_USE_CREEPER_FEET);
		USE_BACK_PLATE = CONFIG.translation("useBackPlate").comment(com.USE_BACK_PLATE + defaults.DEFAULT_USE_BACK_PLATE).define("Use_Back_Plate", defaults.DEFAULT_USE_BACK_PLATE);
		USE_FACE_PLATE = CONFIG.translation("useFacePlate").comment(com.USE_FACE_PLATE + defaults.DEFAULT_USE_FACE_PLATE).define("Use_Face_Plate", defaults.DEFAULT_USE_FACE_PLATE);
		USE_RIGHT_HORN = CONFIG.translation("useRightHorn").comment(com.USE_RIGHT_HORN + defaults.DEFAULT_USE_RIGHT_HORN).define("Use_Right_Horn", defaults.DEFAULT_USE_RIGHT_HORN);
		USE_CENTER_HORN = CONFIG.translation("useCenterHorn").comment(com.USE_CENTER_HORN + defaults.DEFAULT_USE_CENTER_HORN).define("Use_Center_Horn", defaults.DEFAULT_USE_CENTER_HORN);
		USE_LEFT_HORN = CONFIG.translation("useLeftHorn").comment(com.USE_LEFT_HORN + defaults.DEFAULT_USE_LEFT_HORN).define("Use_Left_Horn", defaults.DEFAULT_USE_LEFT_HORN);
		USE_MANE = CONFIG.translation("useMane").comment(com.USE_MANE + defaults.DEFAULT_USE_MANE).define("Use_Mane", defaults.DEFAULT_USE_MANE);
		IS_ENCHANTED = CONFIG.translation("enchanted").comment(com.ENCHANTED + defaults.DEFAULT_IS_ENCHANTED).define("Enchanted", defaults.DEFAULT_IS_ENCHANTED);
	}
	
	private void explodingChickenSyndrome(ChickenConfigGenerator defaults) {
		CONFIG.push("Exploding_Chicken_Syndrome");
		CAN_GET_EXPLODING_CHICKEN_SYNDROME = CONFIG.translation("eCS").comment(com.ECS + defaults.DEFAULT_CAN_GET_EXPLODING_CHICKEN_SYNDROME).define("Exploding_Chicken_Syndrome", defaults.DEFAULT_CAN_GET_EXPLODING_CHICKEN_SYNDROME);
		ECS_NOTIFY_OWNER_WHEN_INFECTED = CONFIG.translation("eCSNotifyOwner").comment(com.ECS_NOTIFY + defaults.DEFAULT_ECS_NOTIFY_OWNER_WHEN_INFECTED).define("Notify_Owner_When_Infected", defaults.DEFAULT_ECS_NOTIFY_OWNER_WHEN_INFECTED);
		ECS_CAN_BE_INFECTED_WHEN_TAMED = CONFIG.translation("eCSWhenTamed").comment(com.ECS_TAMED + defaults.DEFAULT_ECS_CAN_BE_INFECTED_WHEN_TAMED).define("Can_Be_Infected_While_Tamed", defaults.DEFAULT_ECS_CAN_BE_INFECTED_WHEN_TAMED);
		ECS_CAN_BE_INFECTED_WHEN_WILD = CONFIG.translation("eCSWhenWild").comment(com.ECS_WILD + defaults.DEFAULT_ECS_CAN_BE_INFECTED_WHEN_WILD).define("Can_Be_Infected_While_Wild", defaults.DEFAULT_ECS_CAN_BE_INFECTED_WHEN_WILD);
		ECS_CLEAR_INFECTION_UPON_TAMING = CONFIG.translation("eCSClearWhenTamed").comment(com.ECS_CLEAR + defaults.DEFAULT_ECS_CLEAR_INFECTION_UPON_TAMING).define("Clear_Infection_When_Tamed", defaults.DEFAULT_ECS_CLEAR_INFECTION_UPON_TAMING);
		ECS_ADULT_INFECTION_CHANCE = CONFIG.translation("eCSChance").comment(com.ECS_ADULT + defaults.DEFAULT_ECS_ADULT_INFECTION_CHANCE).define("Infection_Chance", defaults.DEFAULT_ECS_ADULT_INFECTION_CHANCE);
		ECS_BABY_INFECTION_CHANCE = CONFIG.translation("eCSBabyChance").comment(com.ECS_BABY + defaults.DEFAULT_ECS_BABY_INFECTION_CHANCE).define("Infection_Chance_When_Baby", defaults.DEFAULT_ECS_BABY_INFECTION_CHANCE);
		ECS_DOES_FALSE_FUSE = CONFIG.translation("eCSDoesFalseFuse").comment(com.ECS_FUSE + defaults.DEFAULT_ECS_DOES_FALSE_FUSE).define("Does_False_Fuse", defaults.DEFAULT_ECS_DOES_FALSE_FUSE);
		ECS_FALSE_FUSE_CHANCE = CONFIG.translation("eCSFalseFuse").comment(com.ECS_FUSE_CHANCE + defaults.DEFAULT_ECS_FALSE_FUSE_CHANCE).define("False_Fuse_Chance", defaults.DEFAULT_ECS_FALSE_FUSE_CHANCE);
		ECS_EXPLOSION_CHANCE = CONFIG.translation("eCSExplodeChance").comment(com.ECS_EXPLODE + defaults.DEFAULT_ECS_EXPLOSION_CHANCE).define("Explosion_Chance", defaults.DEFAULT_ECS_EXPLOSION_CHANCE);
		CONFIG.pop();
	}
	
	private void madChickenDisease(ChickenConfigGenerator defaults) {
		CONFIG.push("Mad_Chicken_Disease");
		CAN_GET_MAD_CHICKEN_DISEASE = CONFIG.translation("mCD").comment(com.MCD + defaults.DEFAULT_CAN_GET_MAD_CHICKEN_DISEASE).define("Mad_Chicken_Disease", defaults.DEFAULT_CAN_GET_MAD_CHICKEN_DISEASE);
		MCD_NOTIFY_OWNER_WHEN_INFECTED = CONFIG.translation("mCDNotifyOwner").comment(com.MCD_NOTIFY + defaults.DEFAULT_MCD_NOTIFY_OWNER_WHEN_INFECTED).define("Notify_Owner_When_Infected", defaults.DEFAULT_MCD_NOTIFY_OWNER_WHEN_INFECTED);
		MCD_CAN_BE_INFECTED_WHEN_TAMED = CONFIG.translation("mCDWhenTamed").comment(com.MCD_TAMED + defaults.DEFAULT_MCD_CAN_BE_INFECTED_WHEN_TAMED).define("Can_Be_Infected_While_Tamed", defaults.DEFAULT_MCD_CAN_BE_INFECTED_WHEN_TAMED);
		MCD_CAN_BE_INFECTED_WHEN_WILD = CONFIG.translation("mCDWhenWild").comment(com.MCD_WILD + defaults.DEFAULT_MCD_CAN_BE_INFECTED_WHEN_WILD).define("Can_Be_Infected_While_Wild", defaults.DEFAULT_MCD_CAN_BE_INFECTED_WHEN_WILD);
		MCD_CLEAR_INFECTION_UPON_TAMING = CONFIG.translation("mCDClearWhenTamed").comment(com.MCD_CLEAR + defaults.DEFAULT_MCD_CLEAR_INFECTION_UPON_TAMING).define("Clear_Infection_When_Tamed", defaults.DEFAULT_MCD_CLEAR_INFECTION_UPON_TAMING);
		MCD_ADULT_INFECTION_CHANCE = CONFIG.translation("mCDChance").comment(com.MCD_ADULT + defaults.DEFAULT_MCD_ADULT_INFECTION_CHANCE).define("Infection_Chance", defaults.DEFAULT_MCD_ADULT_INFECTION_CHANCE);
		MCD_BABY_INFECTION_CHANCE = CONFIG.translation("mCDBabyChance").comment(com.MCD_BABY + defaults.DEFAULT_MCD_BABY_INFECTION_CHANCE).define("Infection_Chance_When_Baby", defaults.DEFAULT_MCD_BABY_INFECTION_CHANCE);
		CONFIG.pop();
	}
		
	private void trickleChickenDisorder(ChickenConfigGenerator defaults) {
		CONFIG.push("Trickle_Chicken_Disorder");
		CAN_GET_TRICKLE_CHICKEN_DISORDER = CONFIG.translation("tCD").comment(com.TCD + defaults.DEFAULT_CAN_GET_TRICKLE_CHICKEN_DISORDER).define("Trickle_Chicken_Disorder", defaults.DEFAULT_CAN_GET_TRICKLE_CHICKEN_DISORDER);
		TCD_NOTIFY_OWNER_WHEN_INFECTED = CONFIG.translation("tCDNotifyOwner").comment(com.TCD_NOTIFY + defaults.DEFAULT_TCD_NOTIFY_OWNER_WHEN_INFECTED).define("Notify_Owner_When_Infected", defaults.DEFAULT_TCD_NOTIFY_OWNER_WHEN_INFECTED);
		TCD_CAN_BE_INFECTED_WHEN_TAMED = CONFIG.translation("tCDWhenTamed").comment(com.TCD_TAMED + defaults.DEFAULT_TCD_CAN_BE_INFECTED_WHEN_TAMED).define("Can_Be_Infected_While_Tamed", defaults.DEFAULT_TCD_CAN_BE_INFECTED_WHEN_TAMED);
		TCD_CAN_BE_INFECTED_WHEN_WILD = CONFIG.translation("tCDWhenWild").comment(com.TCD_WILD + defaults.DEFAULT_TCD_CAN_BE_INFECTED_WHEN_WILD).define("Can_Be_Infected_While_Wild", defaults.DEFAULT_TCD_CAN_BE_INFECTED_WHEN_WILD);
		TCD_CLEAR_INFECTION_UPON_TAMING = CONFIG.translation("tCDClearWhenTamed").comment(com.TCD_CLEAR + defaults.DEFAULT_TCD_CLEAR_INFECTION_UPON_TAMING).define("Clear_Infection_When_Tamed", defaults.DEFAULT_TCD_CLEAR_INFECTION_UPON_TAMING);
		TCD_ADULT_INFECTION_CHANCE = CONFIG.translation("tCDChance").comment(com.TCD_ADULT + defaults.DEFAULT_TCD_ADULT_INFECTION_CHANCE).define("Infection_Chance", defaults.DEFAULT_TCD_ADULT_INFECTION_CHANCE);
		TCD_BABY_INFECTION_CHANCE = CONFIG.translation("tCDBabyChance").comment(com.TCD_BABY + defaults.DEFAULT_TCD_BABY_INFECTION_CHANCE).define("Infection_Chance_When_Baby", defaults.DEFAULT_TCD_BABY_INFECTION_CHANCE);
		TCD_BASE_SLOWNESS_FACTOR = CONFIG.translation("tCDBaseFactor").comment(com.TCD_BASE + defaults.DEFAULT_TCD_BASE_SLOWNESS_FACTOR).define("Base_Trickle_Factor", (float) defaults.DEFAULT_TCD_BASE_SLOWNESS_FACTOR);
		TCD_MAXIMUM_SLOWNESS_FACTOR = CONFIG.translation("tCDMaxFactor").comment(com.TCD_FINAL + defaults.DEFAULT_TCD_MAXIMUM_SLOWNESS_FACTOR).define("Max_Trickle_Factor", (float) defaults.DEFAULT_TCD_MAXIMUM_SLOWNESS_FACTOR);
		TCD_SLOWNESS_FACTOR_CHANGE_CHANCE = CONFIG.translation("tCDAdjustChance").comment(com.TCD_ADJUST_CHANCE + defaults.DEFAULT_TCD_SLOWNESS_FACTOR_CHANGE_CHANCE).define("Trickle_Adjustment_Chance", defaults.DEFAULT_TCD_SLOWNESS_FACTOR_CHANGE_CHANCE);
		TCD_SLOWNESS_FACTOR_CHANGE_FACTOR = CONFIG.translation("tCDAdjustFactor").comment(com.TCD_ADJUST + defaults.DEFAULT_TCD_SLOWNESS_FACTOR_CHANGE_FACTOR).define("Trickle_Adjustment_Factor", (float) defaults.DEFAULT_TCD_SLOWNESS_FACTOR_CHANGE_FACTOR);
		CONFIG.pop();
	}
	
	private void readConfig() {
		CONFIG_DATA.load();
        Map<String, Object> configMap = CONFIG_DATA.valueMap();
        if (ConfigHandler.DEBUG.get()) MoChickens.CHICKEN_LOGGER.error("Checking for user add biome configurations");
        
		for (Iterator<Map.Entry<String, Object>> ittr = configMap.entrySet().iterator(); ittr.hasNext();) {
			// Find Config Sections Here
			Map.Entry<String, Object> entry = ittr.next();
            
            if (entry.getKey().toString().equalsIgnoreCase("spawning")) {
            	
            	CommentedConfig spawningKeys = (CommentedConfig) entry.getValue();
            	Map<String, Object> spawningMap = spawningKeys.valueMap();
            	
            	for (Iterator<Map.Entry<String, Object>> spawning_ittr = spawningMap.entrySet().iterator(); spawning_ittr.hasNext();) {
            		// Find Spawning Keys Here
            		Map.Entry<String, Object> options = spawning_ittr.next();
            		
            		if (options.getKey().toString().equalsIgnoreCase("biomes")) {
            			
                    	CommentedConfig biomes = (CommentedConfig) options.getValue();
                    	Map<String, Object> biomesMap = biomes.valueMap();
                    	
                    	for (Iterator<Map.Entry<String, Object>> biome_ittr = biomesMap.entrySet().iterator(); biome_ittr.hasNext();) {
                    		// Find Biomes Here
                    		Map.Entry<String, Object> biomeKeys = biome_ittr.next();
                        	if (ConfigHandler.DEBUG.get()) MoChickens.CHICKEN_LOGGER.error("Current Working Biome: " + biomeKeys.getKey());
                    		
                    		if (!CUSTOM_BIOMES.containsKey(biomeKeys.getKey())) {
                    			
                    			if (ConfigHandler.DEBUG.get()) MoChickens.CHICKEN_LOGGER.debug("Found user added biome! Biome: " + biomeKeys.getKey());
                    			
                    			CommentedConfig spawnOptions = (CommentedConfig) biomeKeys.getValue();
                            	Map<String, Object> spawnOptionsMap = spawnOptions.valueMap();
                            	
                        		CONFIG.translation(biomeKeys.getKey() + "_spawnProbability").comment(com.SPAWNING_PROBABILITY + "Manually added by user").define("Biomes." + biomeKeys.getKey() + ".Spawn_Probability", spawnOptionsMap.get("Spawn_Probability"));
                    			CONFIG.translation(biomeKeys.getKey() + "_minSpawnGroupSize").comment(com.MIN_GROUP + "Manually added by user").define("Biomes." + biomeKeys.getKey() + ".Min_Spawn_Group_Size", spawnOptionsMap.get("Min_Spawn_Group_Size"));
                    			CONFIG.translation(biomeKeys.getKey() + "_maxSpawnGroupSize").comment(com.MAX_GROUP + "Manually added by user").define("Biomes." + biomeKeys.getKey() + ".Max_Spawn_Group_Size", spawnOptionsMap.get("Max_Spawn_Group_Size"));
                    			Map<String, Integer> vars = new HashMap<String, Integer>();
                				vars.put("probability", (Integer) spawnOptionsMap.get("Spawn_Probability"));
                				vars.put("min_group", (Integer) spawnOptionsMap.get("Min_Spawn_Group_Size"));
                				vars.put("max_group", (Integer) spawnOptionsMap.get("Max_Spawn_Group_Size"));
                				CUSTOM_BIOMES.put(biomeKeys.getKey(), vars);
                            	
                    		}
                    		
                        }
                    	
            		}
            		
                }
            	
            }
            
        }
		
	}
}
