package com.saxon564.mochickens.configs;

import org.jetbrains.annotations.Nullable;

import com.saxon564.mochickens.MoChickens;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.registries.ForgeRegistries;

public class ObjectTranslators {
	public static double getDouble(String string) {
	      double doub = 0;
    	  if ((!string.equals("")) && (!string.equals(null))) {
    		  if (ConfigHandler.DEBUG.get()) MoChickens.CHICKEN_LOGGER.debug("Double: '" + string + "'");
    		  doub = Double.parseDouble(string);
    	  }
		return doub;
	}
	
	public static int[] getIntArray(String[] stringArray) {
		int size = stringArray.length;
	      int [] intArray = new int [size];
	      for(int i=0; i<size; i++) {
	    	  if ((!stringArray[i].equals("")) && (!stringArray[i].equals(null))) {
	    		  String resource = stringArray[i].replace("[", "");
	    		  resource = resource.replace("]", "");
	    		  resource = resource.replace(" ", "");
	    		  if (ConfigHandler.DEBUG.get()) MoChickens.CHICKEN_LOGGER.debug("Integer: '" + resource + "'");
	    		  if ((!resource.equals("")) && (!resource.equals(null))) {
	    			  intArray[i] = Integer.parseInt(resource);
	    		  }
	    	  }
	      }
		return intArray;
	}
	
	public static Item[] getItemArray(String[] stringArray) {
		int size = stringArray.length;
	      Item [] itemArray = new Item [size];
	      for(int i=0; i<size; i++) {
	    	  if ((!stringArray[i].equals("")) && (!stringArray[i].equals(null))) {
	    		  String resource = stringArray[i].replace("[", "");
	    		  resource = resource.replace("]", "");
	    		  resource = resource.replace(" ", "");
	    		  if (ConfigHandler.DEBUG.get()) MoChickens.CHICKEN_LOGGER.debug("Item: '" + resource + "'");
	    		  if ((!resource.equals("")) && (!resource.equals(null))) {
		    		  itemArray[i] = ForgeRegistries.ITEMS.getValue(new net.minecraft.resources.ResourceLocation(resource));
	    		  }
	    	  }
	      }
		return itemArray;
	}
	
	public static ParticleType<? extends ParticleOptions>[] getParticleArray(String[] stringArray) {
		int size = stringArray.length;
		ParticleType<? extends ParticleOptions>[] particleArray = new ParticleType<?>[size];
	      for(int i=0; i<size; i++) {
	    	  if ((!stringArray[i].equals("")) && (!stringArray[i].equals(null))) {
	    		  String resource = stringArray[i].replace("[", "");
	    		  resource = resource.replace("]", "");
	    		  resource = resource.replace(" ", "");
	    		  if (ConfigHandler.DEBUG.get()) MoChickens.CHICKEN_LOGGER.debug("Particle: '" + resource + "'");
	    		  if ((!resource.equals("")) && (!resource.equals(null))) {
		    		  particleArray[i] = ForgeRegistries.PARTICLE_TYPES.getValue(new net.minecraft.resources.ResourceLocation(resource));
	    		  }
	    	  }
	      }
		return particleArray;
	}
	
	public static Biome[] getBiomeArray(String[] stringArray) {
		int size = stringArray.length;
		Biome[] biomeArray = new Biome[size];
	      for(int i=0; i<size; i++) {
	    	  if ((!stringArray[i].equals("")) && (!stringArray[i].equals(null))) {
	    		  String resource = stringArray[i].replace("[", "");
	    		  resource = resource.replace("]", "");
	    		  resource = resource.replace(" ", "");
	    		  if (ConfigHandler.DEBUG.get()) MoChickens.CHICKEN_LOGGER.debug("Biome: '" + resource + "'");
	    		  if ((!resource.equals("")) && (!resource.equals(null))) {
		    		  biomeArray[i] = ForgeRegistries.BIOMES.getValue(new net.minecraft.resources.ResourceLocation(resource));
	    		  }
	    	  }
	      }
		return biomeArray;
	}
	
	public static Potion[] getEffectsArray(String[] stringArray) {
		int size = stringArray.length;
		Potion[] effectArray = new Potion[size];
	      for(int i=0; i<size; i++) {
	    	  if ((!stringArray[i].equals("")) && (!stringArray[i].equals(null))) {
	    		  String resource = stringArray[i].replace("[", "");
	    		  resource = resource.replace("]", "");
	    		  resource = resource.replace(" ", "");
	    		  if (ConfigHandler.DEBUG.get()) MoChickens.CHICKEN_LOGGER.debug("Effect: '" + resource + "'");
	    		  if ((!resource.equals("")) && (!resource.equals(null))) {
		    		  effectArray[i] = ForgeRegistries.POTIONS.getValue(new net.minecraft.resources.ResourceLocation(resource));
	    		  }
	    	  }
	      }
		return effectArray;
	}
	
	public static net.minecraft.sounds.@Nullable SoundEvent getSound(String string) {
		net.minecraft.sounds.@Nullable SoundEvent sound = ForgeRegistries.SOUND_EVENTS.getValue(new net.minecraft.resources.ResourceLocation(string));
		return sound;
	}
}
