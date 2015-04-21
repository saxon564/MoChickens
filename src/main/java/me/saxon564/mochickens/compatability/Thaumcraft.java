package me.saxon564.mochickens.compatability;

import me.saxon564.mochickens.MoChickens;
import net.minecraft.item.ItemStack;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

public class Thaumcraft {
	public static final String id = "Thaumcraft";
	
	public static void addAspects() {
		//Chickens
		ThaumcraftApi.registerEntityTag("mochickens.CoalChicken", (new AspectList()).add(Aspect.AIR, 1).add(Aspect.BEAST, 2).add(Aspect.FLIGHT, 2).add(Aspect.FIRE, 2).add(Aspect.ENERGY, 2));
		ThaumcraftApi.registerEntityTag("mochickens.IronChicken", (new AspectList()).add(Aspect.AIR, 1).add(Aspect.BEAST, 2).add(Aspect.FLIGHT, 2).add(Aspect.METAL, 6));
		ThaumcraftApi.registerEntityTag("mochickens.GoldChicken", (new AspectList()).add(Aspect.AIR, 1).add(Aspect.BEAST, 2).add(Aspect.FLIGHT, 2).add(Aspect.GREED, 2).add(Aspect.METAL, 3));
		ThaumcraftApi.registerEntityTag("mochickens.LapisChicken", (new AspectList()).add(Aspect.AIR, 1).add(Aspect.BEAST, 2).add(Aspect.FLIGHT, 2).add(Aspect.SENSES, 1));
		ThaumcraftApi.registerEntityTag("mochickens.RedstoneChicken", (new AspectList()).add(Aspect.AIR, 1).add(Aspect.BEAST, 2).add(Aspect.FLIGHT, 2).add(Aspect.MECHANISM, 1).add(Aspect.ENERGY, 2));
		ThaumcraftApi.registerEntityTag("mochickens.DiamondChicken", (new AspectList()).add(Aspect.AIR, 1).add(Aspect.BEAST, 2).add(Aspect.FLIGHT, 2).add(Aspect.GREED, 4).add(Aspect.CRYSTAL, 4));
		ThaumcraftApi.registerEntityTag("mochickens.EmeraldChicken", (new AspectList()).add(Aspect.AIR, 1).add(Aspect.BEAST, 2).add(Aspect.FLIGHT, 2).add(Aspect.GREED, 5).add(Aspect.CRYSTAL, 4));
		ThaumcraftApi.registerEntityTag("mochickens.GiantChicken", (new AspectList()).add(Aspect.AIR, 3).add(Aspect.BEAST, 6).add(Aspect.FLIGHT, 6).add(Aspect.MAGIC, 2).add(Aspect.LIFE, 1).add(Aspect.ELDRITCH, 2));
		ThaumcraftApi.registerEntityTag("mochickens.SkeletonChicken", (new AspectList()).add(Aspect.AIR, 1).add(Aspect.BEAST, 2).add(Aspect.FLIGHT, 2).add(Aspect.SENSES, 1));
		ThaumcraftApi.registerEntityTag("mochickens.CreeperChicken", (new AspectList()).add(Aspect.AIR, 1).add(Aspect.BEAST, 2).add(Aspect.FLIGHT, 2).add(Aspect.FIRE, 4).add(Aspect.ENTROPY, 4));
		ThaumcraftApi.registerEntityTag("mochickens.EnderChicken", (new AspectList()).add(Aspect.AIR, 1).add(Aspect.BEAST, 2).add(Aspect.FLIGHT, 2).add(Aspect.ELDRITCH, 4).add(Aspect.TRAVEL, 4).add(Aspect.MAGIC, 2));
		ThaumcraftApi.registerEntityTag("mochickens.BlazingChicken", (new AspectList()).add(Aspect.AIR, 1).add(Aspect.BEAST, 2).add(Aspect.FLIGHT, 2).add(Aspect.FIRE, 2).add(Aspect.MAGIC, 1));
		ThaumcraftApi.registerEntityTag("mochickens.QuartzChicken", (new AspectList()).add(Aspect.AIR, 1).add(Aspect.BEAST, 2).add(Aspect.FLIGHT, 2).add(Aspect.CRYSTAL, 1).add(Aspect.ENERGY, 1));
		ThaumcraftApi.registerEntityTag("mochickens.GlowingChicken", (new AspectList()).add(Aspect.AIR, 1).add(Aspect.BEAST, 2).add(Aspect.FLIGHT, 2).add(Aspect.SENSES, 1).add(Aspect.LIGHT, 2));
		ThaumcraftApi.registerEntityTag("mochickens.SnowChicken", (new AspectList()).add(Aspect.AIR, 1).add(Aspect.BEAST, 2).add(Aspect.FLIGHT, 2).add(Aspect.COLD, 1));
		ThaumcraftApi.registerEntityTag("mochickens.ClayChicken", (new AspectList()).add(Aspect.AIR, 1).add(Aspect.BEAST, 2).add(Aspect.FLIGHT, 2).add(Aspect.WATER, 1).add(Aspect.EARTH, 1));
		ThaumcraftApi.registerEntityTag("mochickens.BeefyChicken", (new AspectList()).add(Aspect.AIR, 1).add(Aspect.BEAST, 2).add(Aspect.FLIGHT, 2).add(Aspect.FLESH, 4).add(Aspect.HUNGER, 4).add(Aspect.CRAFT, 1));
		ThaumcraftApi.registerEntityTag("mochickens.RainbowChicken", (new AspectList()).add(Aspect.AIR, 1).add(Aspect.BEAST, 2).add(Aspect.FLIGHT, 2).add(Aspect.SENSES, 1));
		ThaumcraftApi.registerEntityTag("mochickens.CookieChicken", (new AspectList()).add(Aspect.AIR, 1).add(Aspect.BEAST, 2).add(Aspect.FLIGHT, 2).add(Aspect.HUNGER, 1));
		ThaumcraftApi.registerEntityTag("mochickens.EnchantedChicken", (new AspectList()).add(Aspect.AIR, 1).add(Aspect.BEAST, 2).add(Aspect.FLIGHT, 2).add(Aspect.MIND, 5));
		ThaumcraftApi.registerEntityTag("mochickens.NuuwChicken", (new AspectList()).add(Aspect.AIR, 1).add(Aspect.BEAST, 2).add(Aspect.FLIGHT, 2).add(Aspect.EARTH, 2));
		
		//Blocks
		ThaumcraftApi.registerObjectTag(new ItemStack(MoChickens.blockFeatherBlock), (new AspectList()).add(Aspect.FLIGHT, 9));
		
		//Items
		ThaumcraftApi.registerObjectTag(new ItemStack(MoChickens.ironStick), (new AspectList()).add(Aspect.METAL, 8));
		ThaumcraftApi.registerObjectTag(new ItemStack(MoChickens.coalStick), (new AspectList()).add(Aspect.FIRE, 2).add(Aspect.ENERGY, 2));
		ThaumcraftApi.registerObjectTag(new ItemStack(MoChickens.goldStick), (new AspectList()).add(Aspect.GREED, 4).add(Aspect.METAL, 6));
		ThaumcraftApi.registerObjectTag(new ItemStack(MoChickens.diamondStick), (new AspectList()).add(Aspect.GREED, 8).add(Aspect.CRYSTAL, 8));
		ThaumcraftApi.registerObjectTag(new ItemStack(MoChickens.lapisStick), (new AspectList()).add(Aspect.SENSES, 2));
		ThaumcraftApi.registerObjectTag(new ItemStack(MoChickens.redstoneStick), (new AspectList()).add(Aspect.MECHANISM, 2).add(Aspect.ENERGY, 4));
		ThaumcraftApi.registerObjectTag(new ItemStack(MoChickens.emeraldStick), (new AspectList()).add(Aspect.GREED, 10).add(Aspect.CRYSTAL, 8));
		ThaumcraftApi.registerObjectTag(new ItemStack(MoChickens.quartzStick), (new AspectList()).add(Aspect.ENERGY, 2).add(Aspect.CRYSTAL, 2));
		ThaumcraftApi.registerObjectTag(new ItemStack(MoChickens.innerTamingDisc), (new AspectList()).add(Aspect.MECHANISM, 2).add(Aspect.ENERGY, 4).add(Aspect.METAL, 8).add(Aspect.GREED, 10).add(Aspect.CRYSTAL, 10));
		ThaumcraftApi.registerObjectTag(new ItemStack(MoChickens.innerTamingDisc), (new AspectList()).add(Aspect.MECHANISM, 2).add(Aspect.ENERGY, 10).add(Aspect.METAL, 14).add(Aspect.GREED, 10).add(Aspect.CRYSTAL, 10).add(Aspect.FIRE, 2).add(Aspect.SENSES, 2));
		ThaumcraftApi.registerObjectTag(new ItemStack(MoChickens.randomEgg), (new AspectList()).add(Aspect.MAGIC, 2).add(Aspect.LIFE, 1).add(Aspect.ELDRITCH, 2));
	}
}
