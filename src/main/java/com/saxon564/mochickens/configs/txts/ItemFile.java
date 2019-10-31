package com.saxon564.mochickens.configs.txts;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

import com.saxon564.mochickens.configs.ConfigHandler;

public class ItemFile {
	
	public static void generateTxtFiles() {
		
		if (ConfigHandler.ITEMS.get()) {
			generateString("Items.txt", ForgeRegistries.ITEMS.getKeys());
		}

		if (ConfigHandler.BIOMES.get()) {
			generateString("Biomes.txt", ForgeRegistries.BIOMES.getKeys());
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
			File file = new File(ConfigHandler.MOCHICKENS_CONFIG_DIRECTORY, fileName);
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
