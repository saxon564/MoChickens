package me.saxon564.mochickens.registers;

import me.saxon564.mochickens.MoChickens;
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
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;

public class RegisterEggs {

	// Add Spawn Egg
    public static int getUniqueEntityID()
    {
        do
        {
            MoChickens.startEntityId++;
        }
        while (EntityList.getStringFromID(MoChickens.startEntityId) != null);

        return MoChickens.startEntityId;
    }

    public static void registerEntityEgg(Class <? extends Entity > entity,
                                         int primaryColor, int secondaryColor)
    {
        int id = getUniqueEntityID();
        EntityList.IDtoClassMapping.put(id, entity);
        EntityList.entityEggs.put(id, new EntityList.EntityEggInfo(id, primaryColor,
                                  secondaryColor));
    }

    public static void EggRegisters()
    {
        registerEntityEgg(EntityDiamondChicken.class, 0xa8e2e2, 0x000000);
        registerEntityEgg(EntityCoalChicken.class, 0x2e2e2e, 0x000000);
        registerEntityEgg(EntityIronChicken.class, 0xd7d0b2, 0x000000);
        registerEntityEgg(EntityGoldChicken.class, 0xccda2b, 0x000000);
        registerEntityEgg(EntityLapisChicken.class, 0x4b4bcc, 0x000000);
        registerEntityEgg(EntityRedstoneChicken.class, 0xff6464, 0x000000);
        registerEntityEgg(EntityEmeraldChicken.class, 0x06cc01, 0x000000);
        registerEntityEgg(EntityGiantChicken.class, 0xe2e2e2, 0x000000);
        registerEntityEgg(EntityQuartzChicken.class, 0x4a0000, 0xdbccbf);
        registerEntityEgg(EntityCookieChicken.class, 0xe79042, 0x000000);
        registerEntityEgg(EntitySnowChicken.class, 0xFFFFFF, 0x000000);
        registerEntityEgg(EntityClayChicken.class, 0x878787, 0x000000);
        registerEntityEgg(EntityRainbowChicken.class, 0xff8020, 0x00ffff);
        registerEntityEgg(EntitySkeletonChicken.class, 0xc6c3b6, 0x000000);
        registerEntityEgg(EntityEnderChicken.class, 0x000000, 0x797979);
        registerEntityEgg(EntityCreeperChicken.class, 0x85d576, 0x000000);
        registerEntityEgg(EntityBeefyChicken.class, 0x42361e, 0xd2cfbd);
        registerEntityEgg(EntityGlowingChicken.class, 0xf1d808, 0xfffe31);
        registerEntityEgg(EntityBlazingChicken.class, 0xffcb00, 0x953300);
        registerEntityEgg(EntityEnchantedChicken.class, 0xceff1e, 0x50ff18);
        registerEntityEgg(EntityNuuwChicken.class, 0xbae8e8, 0xb9855c);
    }
	
}