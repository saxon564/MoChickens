package com.saxon564.mochickens.configs.txts;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

import com.saxon564.mochickens.MoChickens;

public class ItemFile {
	
	public static void generateResourceLocation(String fileName, Set<ResourceLocation> set) {
		try {
			File file = new File(MoChickens.path, fileName);
			ArrayList<String> list = new ArrayList();

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
	
	public static void generateString(String fileName, Set<String> set) {
		try {
			File file = new File(MoChickens.path, fileName);
			ArrayList<String> list = new ArrayList();

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
