package com.saxon564.mochickens.entities.mobs;

import com.saxon564.mochickens.configs.ConfigHandler;
import com.saxon564.mochickens.configs.chickens.DiamondChickenConfig;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.BlockPathTypes;

public class DiamondChicken extends MoChicken implements RangedAttackMob {
	private static DiamondChickenConfig configs = ConfigHandler.DIAMOND_CHICKEN_CONFIG;

	public DiamondChicken(EntityType<? extends DiamondChicken> chicken, Level world) {
		super(chicken, world, configs);
		this.setPathfindingMalus(BlockPathTypes.WATER, 0.0F);
	}

	public static AttributeSupplier.Builder createAttributes() {
		return createAttributes(ConfigHandler.DIAMOND_CHICKEN_CONFIG.HEALTH.get(), ConfigHandler.DIAMOND_CHICKEN_CONFIG.MOVEMENT_SPEED.get());
	}
}
