package me.saxon564.mochickens.compatability;

import me.saxon564.mochickens.entities.mobs.EntityBeefyChicken;
import me.saxon564.mochickens.entities.mobs.EntityBlazingChicken;
import me.saxon564.mochickens.entities.mobs.EntityClayChicken;
import me.saxon564.mochickens.entities.mobs.EntityCoalChicken;
import me.saxon564.mochickens.entities.mobs.EntityCookieChicken;
import me.saxon564.mochickens.entities.mobs.EntityCreeperChicken;
import me.saxon564.mochickens.entities.mobs.EntityDiamondChicken;
import me.saxon564.mochickens.entities.mobs.EntityEmeraldChicken;
import me.saxon564.mochickens.entities.mobs.EntityEnchantedChicken;
import me.saxon564.mochickens.entities.mobs.EntityEnderChicken;
import me.saxon564.mochickens.entities.mobs.EntityGiantChicken;
import me.saxon564.mochickens.entities.mobs.EntityGlowingChicken;
import me.saxon564.mochickens.entities.mobs.EntityGoldChicken;
import me.saxon564.mochickens.entities.mobs.EntityIronChicken;
import me.saxon564.mochickens.entities.mobs.EntityLapisChicken;
import me.saxon564.mochickens.entities.mobs.EntityNuuwChicken;
import me.saxon564.mochickens.entities.mobs.EntityQuartzChicken;
import me.saxon564.mochickens.entities.mobs.EntityRainbowChicken;
import me.saxon564.mochickens.entities.mobs.EntityRedstoneChicken;
import me.saxon564.mochickens.entities.mobs.EntitySkeletonChicken;
import me.saxon564.mochickens.entities.mobs.EntitySnowChicken;

import com.advGenetics.API.RegistrationHelper;

public class AdvancedGenetics {
	
	public static final String id = "advancedgenetics";

	public static void addAbilities() {
		RegistrationHelper.addEntityToAbility("nofall", EntityCoalChicken.class);
		RegistrationHelper.addEntityToAbility("nofall", EntityIronChicken.class);
		RegistrationHelper.addEntityToAbility("nofall", EntityGoldChicken.class);
		RegistrationHelper.addEntityToAbility("nofall", EntityRedstoneChicken.class);
		RegistrationHelper.addEntityToAbility("nofall", EntityLapisChicken.class);
		RegistrationHelper.addEntityToAbility("nofall", EntityDiamondChicken.class);
		RegistrationHelper.addEntityToAbility("nofall", EntityEmeraldChicken.class);
		RegistrationHelper.addEntityToAbility("nofall", EntityQuartzChicken.class);
		RegistrationHelper.addEntityToAbility("nofall", EntityGiantChicken.class);
		RegistrationHelper.addEntityToAbility("nofall", EntityClayChicken.class);
		RegistrationHelper.addEntityToAbility("nofall", EntityRainbowChicken.class);
		RegistrationHelper.addEntityToAbility("nofall", EntityCookieChicken.class);
		RegistrationHelper.addEntityToAbility("nofall", EntitySnowChicken.class);
		RegistrationHelper.addEntityToAbility("nofall", EntityEnchantedChicken.class);
		RegistrationHelper.addEntityToAbility("nofall", EntityNuuwChicken.class);
		RegistrationHelper.addEntityToAbility("nofall", EntityBeefyChicken.class);
		RegistrationHelper.addEntityToAbility("nofall", EntitySkeletonChicken.class);
		RegistrationHelper.addEntityToAbility("nofall", EntityCreeperChicken.class);
		RegistrationHelper.addEntityToAbility("nofall", EntityEnderChicken.class);
		RegistrationHelper.addEntityToAbility("nofall", EntityGlowingChicken.class);
		RegistrationHelper.addEntityToAbility("nofall", EntityBlazingChicken.class);
	}
}
