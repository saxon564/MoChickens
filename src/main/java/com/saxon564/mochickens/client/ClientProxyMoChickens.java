package com.saxon564.mochickens.client;

import com.saxon564.mochickens.entities.mobs.EntityBeefyChicken;
import com.saxon564.mochickens.entities.mobs.EntityBlazingChicken;
import com.saxon564.mochickens.entities.mobs.EntityClayChicken;
import com.saxon564.mochickens.entities.mobs.EntityCoalChicken;
import com.saxon564.mochickens.entities.mobs.EntityCookieChicken;
import com.saxon564.mochickens.entities.mobs.EntityCreeperChicken;
import com.saxon564.mochickens.entities.mobs.EntityDiamondChicken;
import com.saxon564.mochickens.entities.mobs.EntityEmeraldChicken;
import com.saxon564.mochickens.entities.mobs.EntityEnchantedChicken;
import com.saxon564.mochickens.entities.mobs.EntityEnderChicken;
import com.saxon564.mochickens.entities.mobs.EntityGiantChicken;
import com.saxon564.mochickens.entities.mobs.EntityGlowingChicken;
import com.saxon564.mochickens.entities.mobs.EntityGoldChicken;
import com.saxon564.mochickens.entities.mobs.EntityIronChicken;
import com.saxon564.mochickens.entities.mobs.EntityLapisChicken;
import com.saxon564.mochickens.entities.mobs.EntityNuuwChicken;
import com.saxon564.mochickens.entities.mobs.EntityQuartzChicken;
import com.saxon564.mochickens.entities.mobs.EntityRainbowChicken;
import com.saxon564.mochickens.entities.mobs.EntityRedstoneChicken;
import com.saxon564.mochickens.entities.mobs.EntitySkeletonChicken;
import com.saxon564.mochickens.entities.mobs.EntitySnowChicken;
import com.saxon564.mochickens.entities.mobs.models.ModelBeefyChicken;
import com.saxon564.mochickens.entities.mobs.models.ModelCChicken;
import com.saxon564.mochickens.entities.mobs.models.ModelEnderChicken;
import com.saxon564.mochickens.entities.mobs.models.ModelGiantChicken;
import com.saxon564.mochickens.entities.mobs.models.ModelGoldChicken;
import com.saxon564.mochickens.entities.mobs.models.ModelRedstoneChicken;
import com.saxon564.mochickens.entities.mobs.models.ModelSkeletonChicken;
import com.saxon564.mochickens.entities.mobs.renders.RenderBeefyChicken;
import com.saxon564.mochickens.entities.mobs.renders.RenderBlazingChicken;
import com.saxon564.mochickens.entities.mobs.renders.RenderClayChicken;
import com.saxon564.mochickens.entities.mobs.renders.RenderCoalChicken;
import com.saxon564.mochickens.entities.mobs.renders.RenderCookieChicken;
import com.saxon564.mochickens.entities.mobs.renders.RenderCreeperChicken;
import com.saxon564.mochickens.entities.mobs.renders.RenderDiamondChicken;
import com.saxon564.mochickens.entities.mobs.renders.RenderEmeraldChicken;
import com.saxon564.mochickens.entities.mobs.renders.RenderEnchantedChicken;
import com.saxon564.mochickens.entities.mobs.renders.RenderEnderChicken;
import com.saxon564.mochickens.entities.mobs.renders.RenderGiantChicken;
import com.saxon564.mochickens.entities.mobs.renders.RenderGlowingChicken;
import com.saxon564.mochickens.entities.mobs.renders.RenderGoldChicken;
import com.saxon564.mochickens.entities.mobs.renders.RenderIronChicken;
import com.saxon564.mochickens.entities.mobs.renders.RenderLapisChicken;
import com.saxon564.mochickens.entities.mobs.renders.RenderNuuwChicken;
import com.saxon564.mochickens.entities.mobs.renders.RenderQuartzChicken;
import com.saxon564.mochickens.entities.mobs.renders.RenderRainbowChicken;
import com.saxon564.mochickens.entities.mobs.renders.RenderRedstoneChicken;
import com.saxon564.mochickens.entities.mobs.renders.RenderSkeletonChicken;
import com.saxon564.mochickens.entities.mobs.renders.RenderSnowChicken;
import com.saxon564.mochickens.proxies.CommonProxyMoChickens;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.network.IGuiHandler;

public class ClientProxyMoChickens extends CommonProxyMoChickens
{
    public void registerRenders()
    {
    	RenderManager manager = Minecraft.getMinecraft().getRenderManager();
        RenderingRegistry.registerEntityRenderingHandler(EntityDiamondChicken.class, new RenderDiamondChicken(manager, new ModelEnderChicken(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(EntityCoalChicken.class, new RenderCoalChicken(manager, new ModelCChicken(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(EntityIronChicken.class, new RenderIronChicken(manager, new ModelCChicken(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(EntityGoldChicken.class, new RenderGoldChicken(manager, new ModelGoldChicken(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(EntityLapisChicken.class, new RenderLapisChicken(manager, new ModelGoldChicken(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(EntityRedstoneChicken.class, new RenderRedstoneChicken(manager, new ModelRedstoneChicken(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(EntityEmeraldChicken.class, new RenderEmeraldChicken(manager, new ModelCChicken(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(EntityGiantChicken.class, new RenderGiantChicken(manager, new ModelGiantChicken(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(EntityQuartzChicken.class, new RenderQuartzChicken(manager, new ModelCChicken(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(EntitySkeletonChicken.class, new RenderSkeletonChicken(manager, new ModelSkeletonChicken(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(EntityEnderChicken.class, new RenderEnderChicken(manager, new ModelEnderChicken(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(EntityCreeperChicken.class, new RenderCreeperChicken(manager, new ModelCChicken(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(EntityCookieChicken.class, new RenderCookieChicken(manager, new ModelCChicken(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(EntitySnowChicken.class, new RenderSnowChicken(manager, new ModelCChicken(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(EntityClayChicken.class, new RenderClayChicken(manager, new ModelCChicken(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(EntityRainbowChicken.class, new RenderRainbowChicken(manager, new ModelCChicken(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(EntityBeefyChicken.class, new RenderBeefyChicken(manager, new ModelBeefyChicken(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(EntityGlowingChicken.class, new RenderGlowingChicken(manager, new ModelEnderChicken(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(EntityBlazingChicken.class, new RenderBlazingChicken(manager, new ModelEnderChicken(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(EntityEnchantedChicken.class, new RenderEnchantedChicken(manager, new ModelEnderChicken(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(EntityNuuwChicken.class, new RenderNuuwChicken(manager, new ModelEnderChicken(), 0.3F));
    }
}
