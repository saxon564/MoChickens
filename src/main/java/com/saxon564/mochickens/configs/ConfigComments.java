package com.saxon564.mochickens.configs;

import net.minecraftforge.common.config.Configuration;

public class ConfigComments {

	public static void spawningComments(Configuration config) {
		config.addCustomCategoryComment(
				"spawning",
				"Custom configs for each biome can be created using:"
						+ config.NEW_LINE
						+ "\"biomeid\" {"
						+ config.NEW_LINE
						+ "    I:\"Max Spawn Group Size\"=number"
						+ config.NEW_LINE
						+ "    I:\"Min Spawn Group Size\"=number"
						+ config.NEW_LINE
						+ "    I:\"Spawn Probability\"=number"
						+ config.NEW_LINE
						+ "}"
						+ config.NEW_LINE
						+ "If a biome has custom spawn settings,"
						+ config.NEW_LINE
						+ "it overrides the blacklist for that biome"
						+ config.NEW_LINE
						+ "The Blacklist Spawn Biomes list requires Biomes IDs."
						+ config.NEW_LINE
						+ "Biomes that are blacklisted will cause the Chicken not to spawn in that biome"
						+ config.NEW_LINE
						+ "To get the Biome IDs either enable \"Debug\" mode in the \"MoChickens\" config file,"
						+ config.NEW_LINE
						+ "or visit the Minecraft wikia at http://minecraft.gamepedia.com/Data_Values#Biome_IDs");
	}

	public static void entityDataComments(Configuration config) {
		config.addCustomCategoryComment("entity data", "");
	}

	public static void tamingComments(Configuration config) {
		config.addCustomCategoryComment(
				"taming",
				"Taming Item MUST be all lowercase"
						+ config.NEW_LINE
						+ "Taming Item must be one of the items in the \"Items.txt\" list"
						+ config.NEW_LINE
						+ "Taming Chance is a 1 in \"number\" chance of being tamed");
	}

	public static void temptingComments(Configuration config) {
		config.addCustomCategoryComment("tempting",
				"Tempting Item MUST be all lowercase"
				+ config.NEW_LINE
				+ "Tempting Item must be one of the items in the \"Items.txt\" list"
				+ config.NEW_LINE
				+ "Delay Following Between Item Holdings must be in seconds");
	}
	
	public static void breedingComments(Configuration config) {
		config.addCustomCategoryComment("breeding",
				"Breeding Item MUST be all lowercase"
						+ config.NEW_LINE
						+ "Breeding Item must be one of the items in the \"Items.txt\" list");
	}
	
	public static void layingComments(Configuration config) {
		config.addCustomCategoryComment("laying",
				"Laying Item MUST be all lowercase"
						+ config.NEW_LINE
						+ "Laying Item must be one of the items in the \"Items.txt\" list"
						+ config.NEW_LINE
						+ "\"Variable Lay Time\" causes the lay time to vary in seconds by that amount"
						+ config.NEW_LINE
						+ "e.g. \"Min Lay Time\" is 6000 with a \"Variable Lay Time\" of 2500"
						+ config.NEW_LINE
						+ "will cause the lay time to be anywhere between 6000 and 8500 seconds");
	}
	
	public static void attackDataComments(Configuration config) {
		config.addCustomCategoryComment("attack data",
				"Attack damage is based on each half heart, so 1 attack damage equals 0.5 hearts."
				+ config.NEW_LINE
				+ "Effect Ids, durations, and amplifiers must all have the same number of variables to work."
				+ config.NEW_LINE
				+ "Effect duration MUST be seconds times 20."
				+ config.NEW_LINE
				+ "Amplifier is the level of the effect."
				+ config.NEW_LINE
				+ "The other of the numbers do matter, for example to have speed 3 for 20 seconds"
				+ config.NEW_LINE
				+ "and Strength 2 for 5 seconds each of them MUST be laid out as so."
				+ config.NEW_LINE
				+ config.NEW_LINE 
				+ "\"attack data\" {"
				+ config.NEW_LINE
				+ "    I:\"Effect Amplifiers\" <"
				+ config.NEW_LINE
				+ "        3"
				+ config.NEW_LINE
				+ "        2"
				+ config.NEW_LINE
				+ "    >"
				+ config.NEW_LINE
				+ "    I:\"Effect Durations\" <"
				+ config.NEW_LINE
				+ "        400"
				+ config.NEW_LINE
				+ "        100"
				+ config.NEW_LINE
				+ "    >"
				+ config.NEW_LINE
				+ "    I:\"Effect IDs\" <"
				+ config.NEW_LINE
				+ "        1"
				+ config.NEW_LINE
				+ "        5"
				+ config.NEW_LINE
				+ "    >"
				+ config.NEW_LINE
				+ "}"
				+ config.NEW_LINE
				+ config.NEW_LINE
				+ "So the numbers 1, 400, and 3 are in the same spot, id 1 is speed, 400 is 20 seconds at level 3."
				+ config.NEW_LINE
				+ "Same goes with the second one. Strength is id 5, duration is 100 (5 seconds) and level is 2"
				+ config.NEW_LINE
				+ "Fire Duration is set in seconds, so if you put in 20, it will be 20 seconds."
				+ config.NEW_LINE
				+ "Arrow Shoot Speed is in ticks (20 ticks = 1 second)"
				+ config.NEW_LINE
				+ "ATTACK SPEED CURRENTLY IS NOT WORKING! I AM WORKING ON GETTING THIS FIXED."
				);
	}

}
