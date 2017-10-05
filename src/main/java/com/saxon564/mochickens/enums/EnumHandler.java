package com.saxon564.mochickens.enums;

import net.minecraft.util.IStringSerializable;

public class EnumHandler {
	
	public enum EnumBlockTypes implements IStringSerializable {
		
		CHICKEN(0, "chicken"),
		COAL(1, "coal"),
		IRON(2, "iron"),
		GOLD(3, "gold"),
		REDSTONE(4, "redstone"),
		LAPIS(5, "lapis"),
		DIAMOND(6, "diamond"),
		EMERALD(7, "emerald"),
		QUARTZ(8, "quartz");
		
		private final int ID;
		private final String name;
		private static final EnumBlockTypes[] META_LOOKUP = new EnumBlockTypes[values().length];
		
		private EnumBlockTypes(int id, String name) {
			this.ID = id;
			this.name = name;
		}
		
		@Override
		public String getName() {
			return this.name;
		}
		
		public int getID() {
			return this.ID;
		}
		
		@Override
		public String toString() {
			return getName();
		}
		
		public static EnumBlockTypes byID(int meta) {
			if (meta < 0 || meta >= META_LOOKUP.length) {
				meta = 0;
			}
			return META_LOOKUP[meta];
		}
		
		static {
			for (EnumBlockTypes value : values()) {
				META_LOOKUP[value.getID()] = value;
			}
		}
		
	}
	
	public enum EnumResourceTypes implements IStringSerializable {
		
		COAL(0, "coal"),
		IRON(1, "iron"),
		GOLD(2, "gold"),
		REDSTONE(3, "redstone"),
		LAPIS(4, "lapis"),
		DIAMOND(5, "diamond"),
		EMERALD(6, "emerald"),
		QUARTZ(7, "quartz");
		
		private final int ID;
		private final String name;
		private static final EnumResourceTypes[] META_LOOKUP = new EnumResourceTypes[values().length];
		
		private EnumResourceTypes(int id, String name) {
			this.ID = id;
			this.name = name;
		}
		
		@Override
		public String getName() {
			return this.name;
		}
		
		public int getID() {
			return this.ID;
		}
		
		@Override
		public String toString() {
			return getName();
		}
		
		public static EnumResourceTypes byID(int meta) {
			if (meta < 0 || meta >= META_LOOKUP.length) {
				meta = 0;
			}
			return META_LOOKUP[meta];
		}
		
		static {
			for (EnumResourceTypes value : values()) {
				META_LOOKUP[value.getID()] = value;
			}
		}
		
	}
}
