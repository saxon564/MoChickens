package com.saxon564.mochickens.configs;

public class ConfigComments {

	/************* Spawning Comments *************/
	protected final String SPAWNING_COMMENT = "Custom configs for each biome can be created using:\n"
				+ "[Spawning.Biomes] \n"
				+ "		[Spawning.Biomes.minecraft_hell] \n"
				+ "				Spawn_Probability = number\n"
				+ "				Min_Spawn_Group_Size = number\n"
				+ "				Min_Spawn_Group Size = number\n"
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
	protected final String HEALTH = "How much health the chicken has (1.0 = 0.5 Hearts)\n"
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
	protected final String PARTICLE_ARGUMENTS = "Values required for certain particles to show\n"
			+ "Do NOT use the following particles unless you know how the arguments work:\n"
			+ "minecraft:ambient_entity_effect\n"
			+ "minecraft:block\n"
			+ "minecraft:dust\n"
			+ "minecraft:entity_effect\n"
			+ "minecraft:item\n"
			+ "minecraft:note_emitter\n"
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
	protected final String TAMABLE = "Can chicken be tamed\n"
				+ "Default: ";
	protected final String TAMING_ITEMS = "Items used to tame the chicken\n"
				+ "Taming Item MUST be all lowercase\n"
				+ "Taming Item must be one of the items in the \"Items.txt\" list\n"
				+ "Default: \"";
	protected final String TAMING_CHANCE = "Taming Chance is a 1 in \"number\" chance of being tamed\n"
				+ "Default: ";

	/************* Tempting Comments *************/
	protected final String TEMPTABLE_WILD = "Can chicken be tempted when wild\n"
				+ "Default: ";
	protected final String TEMPTABLE_TAMED = "Can chicken be tempted when tamed\n"
				+ "Default: ";
	protected final String TEMPTING_ITEMS = "Items used to tempt the chicken\n"
				+ "Tempting Item MUST be all lowercase\n"
				+ "Tempting Item must be one of the items in the \"Items.txt\" list\n"
				+ "Default: \"";
	protected final String TEMPTING_COOLDOWN = "Time in ticks the chicken ignores tempting item\n"
				+ "when item gets put away\n"
				+ "Default: ";
	protected final String OWNER_TEMPTING = "Can chicken only be tempted by its owner\n"
				+ "Default: ";
	protected final String TEMPTING_SPEED = "Speed factor of walking speed the chicken moves when tempted\n"
				+ "1.0 = normal speed\n"
				+ "0.0-0.99 = slower\n"
				+ "1.01 and up = faster\n"
				+ "Default: ";
	protected final String TEMPTING_SCARE = "Chicken can be scared away from being tempted\n"
				+ "Default: ";
	
	/************* Breeding Comments *************/
	protected final String BREEDING_WILD = "Can chicken be bred when wild\n"
				+ "Default: ";
	protected final String BREEDING_TAMED = "Can chicken be bred when tamed\n"
				+ "Default: ";
	protected final String BREEDING_ITEMS = "Items used to breed the chicken\n"
				+ "Breeding Item MUST be all lowercase\n"
				+ "Breeding Item must be one of the items in the \"Items.txt\" list\n"
				+ "Default: \"";
	protected final String BREEDING_GROW_TIME = "Time in ticks for the baby chicken\n"
				+ "to grow into an adult\n"
				+ "Default: ";
	protected final String CHILD_TAMED_BREEDING = "Chicken is tamed when spawned by breeding\n"
				+ "Default: ";
	protected final String OWNER_BREEDING = "Can chicken only be bred by its owner\n"
				+ "Default: ";
	
	/************* Laying Comments *************/
	protected final String LAYING_WILD = "Can chicken lay items when wild\n"
				+ "Default: ";
	protected final String LAYING_TAMED = "Can chicken lay items when tamed\n"
				+ "Default: ";
	protected final String LAYING_ITEMS = "Items for the chicken to lay\n"
				+ "Laying Item MUST be all lowercase\n"
				+ "Laying Item must be one of the items in the \"Items.txt\" list\n"
				+ "Default: \"";
	protected final String LAYING_NUMBER = "How many of any item may be layed\n"
				+ "Default: ";
	protected final String LAYING_MIN_TIME = "Minimum time in seconds between each\n"
				+ "time the chicken lays an item\n"
				+ "Default: ";
	protected final String LAYING_VAR_TIME = "Time in second for the lay time to vary"
				+ "e.g. \"Min Lay Time\" is 6000 with a \"Variable Lay Time\" of 2500\n"
				+ "will cause the lay time to be anywhere between 6000 and 8500 seconds\n"
				+ "Default: ";
	protected final String LAYING_SOUND = "Sound chicken makes when chicken lays items\n"
				+ "Default: \"";
	
	/************* Attack Data Comments *************/
	protected final String HOSTILE = "Chicken is hostile toward players\n"
				+ "Default: ";
	protected final String ATTACK_DAMAGE = "How much damage chicken down in physical damage (1.0 = 0.5 Hearts)\n"
				+ "Deafult: ";
	protected final String ATTACK_TARGET_FIRE = "Chicken set target player on fire\n"
				+ "Default: ";
	protected final String ATTACK_FIRE_TIME = "How long the target is set on fire\n"
				+ "Default: ";
	protected final String ATTACK_SPEED = "Factor of walking speed the chicken moves when it is attacking\n"
				+ "1.0 = normal speed\n"
				+ "0.0-0.99 = slower\n"
				+ "1.01 and up = faster\n"
				+ "Default: ";
	protected final String ATTACK_EFFECTS = "Effects chicken give target when it hurts target\n"
				+ "Default: \"";
	protected final String ATTACK_EFFECT_DURATIONS = "Time in seconds the effects last\n"
				+ "Default: \"";
	protected final String ATTACK_EFFECT_AMPLIFIERS = "Level of effects\n"
				+ "Default: \"";
	protected final String ATTACK_DISTANCE = "Distance in blocks the chicken can find a target (1.0 = 1 Block)\n"
				+ "Default: ";
	protected final String ATTACK_EXPLODING = "Will chicken explode when close to target\n"
				+ "Default: ";
	protected final String ATTACK_EXPLODING_FUSE = "How long does it take for chicken to explode\n"
				+ "Default: ";
	protected final String ATTACK_EXPLODING_RADIUS = "How large of a radius is the explosion in blocks (1.0 = 1 Block)\n"
				+ "Default: ";
	protected final String ATTACK_PRIMED_MOVEMENT = "Chicken can still move when exploding\n"
				+ "Default: ";
	protected final String ATTACK_PRIMED_SPEED = "Factor of walking speed the chicken moves when exploding\n"
				+ "1.0 = normal speed\n"
				+ "0.0-0.99 = slower\n"
				+ "1.01 and up = faster\n"
				+ "Default: ";
	protected final String ATTACK_ARROWS = "Attacks by shooting arrows\n"
				+ "Default: ";
	protected final String ATTACK_ARROWS_RATE = "How many ticks between each arrow fired\n"
				+ "Default: ";
	
	/************* ECS Comments *************/
	protected final String ECS = "Can chicken catch \"Exploding Chicken Syndrome\"\n"
				+ "Default: ";
	protected final String ECS_NOTIFY = "Notify chicken owner when chicken becomes infected with \"Exploding Chicken Syndrome\"\n"
				+ "Default: ";
	protected final String ECS_TAMED = "Can chicken get \"Exploding Chicken Syndrome\" while it is tamed\n"
				+ "Default: ";
	protected final String ECS_WILD = "Can chicken get \"Exploding Chicken Syndrome\" while it is wild\n"
				+ "Default: ";
	protected final String ECS_CLEAR = "Cure chicken of \"Exploding Chicken Syndrome\" when it is tamed\n"
				+ "Default: ";
	protected final String ECS_BABY = "Chance the chicken will get \"Exploding Chicken Syndrome\" when a baby\n"
				+ "(1 in */tick)\n"
				+ "Default: ";
	protected final String ECS_ADULT = "Chance the chicken will get \"Exploding Chicken Syndrome\" when an adult\n"
				+ "(1 in */tick)\n"
				+ "Default: ";
	protected final String ECS_FUSE = "Chicken can make fuse sound and not explode when infected with \"Exploding Chicken Syndrome\"\n"
				+ "Default: ";
	protected final String ECS_FUSE_CHANCE = "Chance of a chicken with \"Exploding Chicken Syndrome\" will make fuse sound and not explode\n"
				+ "(1 in */tick)\n"
				+ "Default: ";
	protected final String ECS_EXPLODE = "Chance of the chicken blowing up from \"Exploding Chicken Syndrome\""
				+ "(1 in */tick)\n"
				+ "Default: ";
	
	/************* MCD Comments *************/
	protected final String MCD = "Can chicken catch \"Mad Chicken Disease\"\n"
				+ "Default: ";
	protected final String MCD_NOTIFY = "Notify chicken owner when chicken becomes infected with \"Mad Chicken Disease\"\n"
				+ "Default: ";
	protected final String MCD_TAMED = "Can chicken get \"Mad Chicken Disease\" while it is tamed\n"
				+ "Default: ";
	protected final String MCD_WILD = "Can chicken get \"Mad Chicken Disease\" while it is wild\n"
				+ "Default: ";
	protected final String MCD_CLEAR = "Cure chicken of \"Mad Chicken Disease\" when it is tamed\n"
				+ "Default: ";
	protected final String MCD_BABY = "Chance the chicken will get \"Mad Chicken Disease\" when a baby\n"
				+ "(1 in */tick)\n"
				+ "Default: ";
	protected final String MCD_ADULT = "Chance the chicken will get \"Mad Chicken Disease\" when an adult\n"
				+ "(1 in */tick)\n"
				+ "Default: ";
	
	/************* TCD Comments *************/
	protected final String TCD = "Can chicken catch \"Trickle Chicken Disorder\"\n"
				+ "Default: ";
	protected final String TCD_NOTIFY = "Notify chicken owner when chicken becomes infected with \"Trickle Chicken Disorder\"\n"
				+ "Default: ";
	protected final String TCD_TAMED = "Can chicken get \"Trickle Chicken Disorder\" while it is tamed\n"
				+ "Default: ";
	protected final String TCD_WILD = "Can chicken get \"Trickle Chicken Disorder\" while it is wild\n"
				+ "Default: ";
	protected final String TCD_CLEAR = "Cure chicken of \"Trickle Chicken Disorder\" when it is tamed\n"
				+ "Default: ";
	protected final String TCD_BABY = "Chance the chicken will get \"Trickle Chicken Disorder\" when a baby\n"
				+ "(1 in */tick)\n"
				+ "Default: ";
	protected final String TCD_ADULT = "Chance the chicken will get \"Trickle Chicken Disorder\" when an adult\n"
				+ "(1 in */tick)\n"
				+ "Default: ";
	protected final String TCD_BASE = "Base factor in which chicken laying will be affected\n"
				+ "Default: ";
	protected final String TCD_FINAL = "Final factor in which chicken laying will be affected\n"
				+ "Default: ";
	protected final String TCD_ADJUST_CHANCE = "Chance the trickle factor will be adjusted closer to the final factor.\n"
				+ "(1 in */tick)\n"
				+ "Default: ";
	protected final String TCD_ADJUST = "How much the trickle factor will adjust to the final factor\n"
				+ "Default: ";
	
	/************* Model Options Comments *************/
	
	protected final String USE_CHICKEN_FEET = "The chicken model uses the usual 2 feet for the chicken\n"
			+ "Default: ";
	protected final String USE_CREEPER_FEET = "The chicken model use 4 feet similar to the feet on a creeper\n"
			+ "Default: ";
	protected final String USE_FACE_PLATE = "The chicken model uses a plate on the face between the eyes\n"
			+ "Default: ";
	protected final String USE_CHIN = "The chicken model uses a gizzard under the beak\n"
			+ "Deafult: ";
	protected final String USE_BACK_PLATE = "The chicken model uses a plate on the chickens back\n"
			+ "Default: ";
	protected final String USE_LEFT_HORN = "The chicken model uses a horn on the left top of the head\n"
			+ "Default: ";
	protected final String USE_CENTER_HORN = "The chicken model uses a horn on the center top of the head\n"
			+ "Default: ";
	protected final String USE_RIGHT_HORN = "The chicken model uses a horn on the right top of the head\n"
			+ "Default: ";
	protected final String USE_MANE = "The chicken model uses a mane around the back of the head\n"
			+ "Default: ";
	protected final String ENCHANTED = "Chicken has enchantment glint\n"
			+ "Default: ";

}
