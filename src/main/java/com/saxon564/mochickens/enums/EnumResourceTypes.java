package com.saxon564.mochickens.enums;

import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IStringSerializable;

public enum EnumResourceTypes implements IStringSerializable {
	
	COAL(0, "coal"),
	IRON(1, "iron"),
	GOLD(2, "gold"),
	REDSTONE(3, "redstone"),
	LAPIS(4, "lapis"),
	DIAMOND(5, "diamond"),
	EMERALD(6, "emerald"),
	QUARTZ(7, "quartz");
	
	public int getMetadata() {
		return this.meta;
	}
	
	public static EnumResourceTypes byMetadata(int meta) {
		if (meta < 0 || meta >= META_LOOKUP.length) {
			meta = 0;
		}
		return META_LOOKUP[meta];
	}
	
	public String getName() {
		return this.name;
	}
	
	private final int meta;
	private final String name;
	private static final EnumResourceTypes[] META_LOOKUP = new EnumResourceTypes[values().length];
	
	private EnumResourceTypes(int i_meta, String i_name) {
		this.meta = i_meta;
		this.name = i_name;
	}
	
	static {
		for (EnumResourceTypes value : values()) {
			META_LOOKUP[value.getMetadata()] = value;
		}
	}
	
}