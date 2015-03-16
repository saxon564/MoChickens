package me.saxon564.mochickens.configs.txts;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

import me.saxon564.mochickens.MoChickens;
import net.minecraft.client.Minecraft;
import net.minecraft.server.MinecraftServer;

import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.registry.GameData;

public class ItemFile {

	private static File file;

	public static void generate(FMLPostInitializationEvent event) {
		file = new File(MoChickens.path, "Items.txt");

		try {

			ArrayList<String> itemList = new ArrayList();

			for (Object obj : GameData.getItemRegistry().getKeys()) {
				itemList.add((String) obj);
			}

			Collections.sort(itemList);
			if (file.exists()) {
				file.delete();
			}
			file.createNewFile();

			PrintWriter out = new PrintWriter(new FileWriter(file));

			for (String s : itemList) {
				out.println(s);
			}
			
			out.close();
		} catch (Exception exception) {
			exception.printStackTrace();
		}

	}

}
