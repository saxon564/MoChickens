package com.saxon564.mochickens.configs.txts;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

import com.saxon564.mochickens.MoChickens;
import com.saxon564.mochickens.configs.ConfigHandler;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.storage.ServerLevelData;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemFile {
	
	public static void generateTxtFiles(Level level) {
		
		if (ConfigHandler.ITEMS.get()) {
			generateString("Items.txt", ForgeRegistries.ITEMS.getKeys());
		}
		
		if (ConfigHandler.BLOCKS.get()) {
			generateString("Blocks.txt", ForgeRegistries.BLOCKS.getKeys());
		}

		if (ConfigHandler.BIOMES.get()) {
			generateString("Biomes.txt", level.registryAccess().registryOrThrow(Registries.BIOME).keySet());
			MoChickens.CHICKEN_LOGGER.debug("BIOMES: " + level.registryAccess().registryOrThrow(Registries.BIOME).keySet());
		}

		if (ConfigHandler.SOUNDS.get()) {
			generateString("Sounds.txt", ForgeRegistries.SOUND_EVENTS.getKeys());
		}

		if (ConfigHandler.PARTICLES.get()) {
			generateString("Particles.txt", ForgeRegistries.PARTICLE_TYPES.getKeys());
		}

		if (ConfigHandler.EFFECTS.get()) {
			generateString("Effects.txt", ForgeRegistries.POTIONS.getKeys());
		}
		
	}
	
	public static void generateString(String fileName, Set<ResourceLocation> set) {
		try {

			File textFiles = new File(ConfigHandler.MOCHICKENS_CONFIG_DIRECTORY, "ReferenceIds");
			
			if (!textFiles.exists()) {
				textFiles.mkdir();
			}
			File file = new File(textFiles, fileName);
			ArrayList<String> list = new ArrayList<String>();

			for (Object obj : set) {
				list.add((String) obj.toString());
			}

			Collections.sort(list);
			if (file.exists()) {
				file.delete();
			}
			file.createNewFile();

			PrintWriter out = new PrintWriter(new FileWriter(file));

			for (String s : list) {
				out.println(s);
			}

			out.close();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

}
