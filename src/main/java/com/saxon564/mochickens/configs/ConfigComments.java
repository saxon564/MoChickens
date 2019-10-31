package com.saxon564.mochickens.configs;

public class ConfigComments {

	/************* Spawning Comments *************/
	protected final String SPAWNING_COMMENT = "Custom configs for each biome can be created using:\n"
				+ "[Spawning.minecraft_hell] \n"
				+ "		Spawn_Probability = number\n"
				+ "		Min_Spawn_Group_Size = number\n"
				+ "		Min_Spawn_Group Size = number\n"
				+ "If a biome has custom spawn settings,\n"
				+ "it overrides the blacklist/whitelist for that biome\n"
				+ "This does not override the 'Can_Spawn' option\n"
				+ "If 'Can_Spawn' is false then the chicken will not spawn period until set to true";
	protected final String CAN_SPAWN = "Can chicken spawn at all\n"
				+ "Default: ";
	protected final String SPAWNING_PROBABILITY = "How many chances the chicken has of spawning in the total spawning pool of all mobs\n"
				+ "Default: ";
	protected final String MIN_GROUP = "Miniumum number of chickens to spawn\n"
				+ "Default: ";
	protected final String MAX_GROUP = "Maximum number of chickens to spawn\n"
				+ "Default: ";
	protected final String MIN_LIGHT = "Minimum light level for chicken to spawn (0-16)\n"
				+ "Default: ";
	protected final String MAX_LIGHT = "Maximum light level for chicken to spawn (0-16)\n"
				+ "Default: ";
	protected final String MIN_TEMP = "Minimum biome temp for chicken to spawn (0.0-1.0)\n"
				+ "Default: ";
	protected final String MAX_TEMP = "Maximum biome temp for chicken to spawn (0.0-1.0)\n"
				+ "Default: ";
	protected final String BIOME_LIST_TYPE = "Can either be \"Whitelist\" or \"Blacklist\"\n"
				+ "Biomes that are blacklisted will cause the Chicken not to spawn in that biome\n"
				+ "Likewise, biomes on the whitelist will be the only biomes the Chicken spawns in\n"
				+ "Default: \"";
	protected final String BIOME_LIST = "The Biome List requires Biomes IDs.\n"
				+ "To get the Biome IDs either enable \"Biome List\" option in the \"MoChickens\" config file,\n"
				+ "or visit the Minecraft wikia at http://minecraft.gamepedia.com/Data_Values#Biome_IDs\n"
				+ "Default: \"";

	/************* Entity Data Comments *************/
	protected final String HEALTH = "How much health the chicken has (1.0 = half a heart)\n"
				+ "Default: ";
	protected final String SPEED = "How many blocks per tick the chicken walks (1.0 = 1 Block)\n"
				+ "Default: ";
	protected final String X_HIT_BOX = "Horizontal size of chickens hit box (Should never need to change this)\n"
				+ "Default: ";
	protected final String Z_HIT_BOX = "Vertical size of chickens hit box (Should never need to change this)\n"
				+ "Default: ";
	protected final String DESPAWN_UNTAMED = "Chicken can despawn when it is still wild\n"
				+ "Default: ";
	protected final String DESPAWN_TAMED = "Chicken can despawn when it is tamed\n"
				+ "Default: ";
	protected final String SILENT = "Chicken is silent and will not make any sounds\n"
				+ "This includes clucking, sounds when items are layed, fuse sound if exploding, ect...\n"
				+ "Default: ";
	protected final String TELEPORT = "Chicken is able to teleport like an Enderman\n"
				+ "Default: ";
	protected final String EMIT_LIGHT = "Chicken emits light\n"
				+ "Default: ";
	protected final String LIGHT_LEVEL = "Level of light chicken emits (0-16)\n"
				+ "Default: ";
	protected final String FIRE_IMMUNE = "Chicken immune to fire damage and lava\n"
				+ "Default: ";
	protected final String SUN_BURN = "Chicken catches fire in sunlight, similar to Skeletons\n"
				+ "Default: ";
	protected final String HYPOALERGENIC = "Chicken gets hurt when in water\n"
				+ "Default: ";
	protected final String WATER_DAMAGE = "Damage done to chicken when hypoalergenic and in water\n"
				+ "Default: ";
	protected final String EMITS_PARTICLES = "Chicken emits particles\n"
				+ "Default: ";
	protected final String PARTICLES = "Particles chicken will emit\n"
				+ "Default: \"";
	protected final String PARTICLE_OCCURANCES = "How many particles show per tick\n"
				+ "Default: \"";
	protected final String LIVING_SOUND = "Sound chicken makes when alive\n"
				+ "Default: \"";
	protected final String HURT_SOUND = "Sound chicken makes when it takes damage\n"
				+ "Default: \"";
	protected final String DEATH_SOUND = "Sound chicken makes when it dies\n"
				+ "Default: \"";
	protected final String STEP_SOUND = "Sound chicken makes when walking around\n"
				+ "Default: \"";
	protected final String IGNITEABLE = "Chicken can get ignited by flint and steel like Creepers\n"
			+ "Default: ";

	/************* Taming Comments *************/
	protected final String TAMABLE = "Chicken can get ignited by flint and steel like Creepers\n"
				+ "Default: ";
	protected final String TAMING_ITEMS = "Items used to taming chicken\n"
				+ "Taming Item MUST be all lowercase\n"
				+"Taming Item must be one of the items in the \"Items.txt\" list\n"
				+ "Default: \"";
	protected final String TAMING_CHANCE = "Taming Chance is a 1 in \"number\" chance of being tamed\n"
				+ "Default: ";

	/************* Tempting Comments *************/
	protected final String TEMPTING_COMMENT = "Tempting\n"
				+"Tempting Item MUST be all lowercase\n"
				+"Tempting Item must be one of the items in the \"Items.txt\" list\n"
				+"Delay Following Between Item Holdings must be in seconds";
	
	/************* Breeding Comments *************/
	protected final String BREEDING_COMMENT = "Breeding\n"
				+"Breeding Item MUST be all lowercase\n"
				+"Breeding Item must be one of the items in the \"Items.txt\" list";
	
	/************* Laying Comments *************/
	protected final String LAYING_COMMENT = "Laying\n"
				+"Laying Item MUST be all lowercase\n"
				+"Laying Item must be one of the items in the \"Items.txt\" list\n"
				+"\"Variable Lay Time\" causes the lay time to vary in seconds by that amount\n"
				+"e.g. \"Min Lay Time\" is 6000 with a \"Variable Lay Time\" of 2500\n"
				+"will cause the lay time to be anywhere between 6000 and 8500 seconds";
	
	/************* Attack Data Comments *************/
	protected final String ATTACK_DATA_COMMENT = "Attack Data\n"
				+"Attack damage is based on each half heart, so 1 attack damage equals 0.5 hearts.\n"
				+"Effect Ids, durations, and amplifiers must all have the same number of variables to work.\n"
				+"Effect duration MUST be seconds times 20.\n"
				+"Amplifier is the level of the effect.\n"
				+"The other of the numbers do matter, for example to have speed 3 for 20 seconds\n"
				+"and Strength 2 for 5 seconds each of them MUST be laid out as so.\n\n"
				+"\"attack data\" {\n"
				+"    I:\"Effect Amplifiers\" <\n"
				+"        3\n"
				+"        2\n"
				+"    >\n"
				+"    I:\"Effect Durations\" <\n"
				+"       400\n"
				+"      100\n"
				+"    >\n"
				+"   I:\"Effect IDs\" <\n"
				+"        1\n"
				+"        5\n"
				+"   >\n"
				+"}\n\n"
				+"So the numbers 1, 400, and 3 are in the same spot, id 1 is speed, 400 is 20 seconds at level 3.\n"
				+"Same goes with the second one. Strength is id 5, duration is 100 (5 seconds) and level is 2\n"
				+"Fire Duration is set in seconds, so if you put in 20, it will be 20 seconds.\n"
				+"Arrow Shoot Speed is in ticks (20 ticks = 1 second)\n"
				+"ATTACK SPEED CURRENTLY IS NOT WORKING! I AM WORKING ON GETTING THIS FIXED.";
	
	/************* ECS Comments *************/
	protected final String EXPLODING_CHICKEN_COMMENT = "Exploding Chicken Syndrome\n"
				+"Exploding Chicken Syndrome: The chicken can catch \"Exploding Chicken Syndrome\".\n"
				+"Notify Owner When Infected: Notifies the owner of a tamed chicken when their chicken is infected with \"Exploding Chicken Syndrome\".\n"
				+"Can Be Infected While Tamed: If chicken can get \"Exploding Chicken Syndrome\" while it is tamed.\n"
				+"Can Be Infected While Wild: If chicken can get \"Exploding Chicken Syndrome\" while it is wild.\n"
				+"Clear Infection When Tamed: Cures chicken of \"Exploding Chicken Syndrome\" when it is tamed.\n"
				+"Infection Chance When Baby: 1 in */minute chance the chicken will become infected with \"Exploding Chicken Syndrome\" when a baby.\n"
				+"Infection Chance: 1 in */minute chance the chicken will become infected with \"Exploding Chicken Syndrome\".\n"
				+"False Fuse Chance: 1 in */minute chance of a chicken infected with \"Exploding Chicken Syndrome\" will falsely prime itself to explode.\n"
				+"Explosion Chance: 1 in */minute chance of the chicken blowing up from \"Exploding Chicken Syndrome\".";
	
	/************* MCD Comments *************/
	protected final String MAD_CHICKEN_COMMENT = "Mad Chicken Disease\n"
				+"Mad Chicken Disease: The chicken can catch \"Mad Chicken Disease\".\n"
				+"Notify Owner When Infected: Notifies the owner of a tamed chicken when their chicken is infected with \"Mad Chicken Disease\".\n"
				+"Can Be Infected While Tamed: If chicken can get \"Mad Chicken Disease\" while it is tamed.\n"
				+"Can Be Infected While Wild: If chicken can get \"Mad Chicken Disease\" while it is wild.\n"
				+"Clear Infection When Tamed: Cures chicken of \"Mad Chicken Disease\" when it is tamed.\n"
				+"Infection Chance When Baby: 1 in */minute chance the chicken will become infected with \"Mad Chicken Disease\" when a baby.\n"
				+"Infection Chance: 1 in */minute chance the chicken will become infected with \"Mad Chicken Disease\".";
	
	/************* TCD Comments *************/
	protected final String TRICKLE_CHICKEN_COMMENT = "Trickle Chicken Disorder\n"
				+"Trickle Chicken Disorder: The chicken can catch \"Trickle Chicken Disorder\".\n"
				+"Notify Owner When Infected: Notifies the owner of a tamed chicken when their chicken is infected with \"Trickle Chicken Disorder\".\n"
				+"Can Be Infected While Tamed: If chicken can get \"Trickle Chicken Disorder\" while it is tamed.\n"
				+"Can Be Infected While Wild: If chicken can get \"Trickle Chicken Disorder\" while it is wild.\n"
				+"Clear Infection When Tamed: Cures chicken of \"Trickle Chicken Disorder\" when it is tamed.\n"
				+"Infection Chance When Baby: 1 in */minute chance the chicken will become infected with \"Trickle Chicken Disorder\" when a baby.\n"
				+"Infection Chance: 1 in */minute chance the chicken will become infected with \"Trickle Chicken Disorder\".\n"
				+"Base Trickle Factor: The base factor in which chicken laying will be affected.\n"
				+"Final Trickle Factor: Final factor in which chicken laying will be affected.\n"
				+"Trickle Adjustment Chance: 1 in * chance the trickle factor will be adjusted closer to the final factor.\n"
				+"Trickle Adjustment Factor: How much the trickle factor will be adjusted toward the final factor";

}
