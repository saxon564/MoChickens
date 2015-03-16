package me.saxon564.mochickens.client;

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
import me.saxon564.mochickens.entities.mobs.models.ModelBeefyChicken;
import me.saxon564.mochickens.entities.mobs.models.ModelCChicken;
import me.saxon564.mochickens.entities.mobs.models.ModelEnderChicken;
import me.saxon564.mochickens.entities.mobs.models.ModelGiantChicken;
import me.saxon564.mochickens.entities.mobs.models.ModelGoldChicken;
import me.saxon564.mochickens.entities.mobs.models.ModelRedstoneChicken;
import me.saxon564.mochickens.entities.mobs.models.ModelSkeletonChicken;
import me.saxon564.mochickens.entities.mobs.renders.RenderBeefyChicken;
import me.saxon564.mochickens.entities.mobs.renders.RenderBlazingChicken;
import me.saxon564.mochickens.entities.mobs.renders.RenderClayChicken;
import me.saxon564.mochickens.entities.mobs.renders.RenderCoalChicken;
import me.saxon564.mochickens.entities.mobs.renders.RenderCookieChicken;
import me.saxon564.mochickens.entities.mobs.renders.RenderCreeperChicken;
import me.saxon564.mochickens.entities.mobs.renders.RenderDiamondChicken;
import me.saxon564.mochickens.entities.mobs.renders.RenderEmeraldChicken;
import me.saxon564.mochickens.entities.mobs.renders.RenderEnchantedChicken;
import me.saxon564.mochickens.entities.mobs.renders.RenderEnderChicken;
import me.saxon564.mochickens.entities.mobs.renders.RenderGiantChicken;
import me.saxon564.mochickens.entities.mobs.renders.RenderGlowingChicken;
import me.saxon564.mochickens.entities.mobs.renders.RenderGoldChicken;
import me.saxon564.mochickens.entities.mobs.renders.RenderIronChicken;
import me.saxon564.mochickens.entities.mobs.renders.RenderLapisChicken;
import me.saxon564.mochickens.entities.mobs.renders.RenderNuuwChicken;
import me.saxon564.mochickens.entities.mobs.renders.RenderQuartzChicken;
import me.saxon564.mochickens.entities.mobs.renders.RenderRainbowChicken;
import me.saxon564.mochickens.entities.mobs.renders.RenderRedstoneChicken;
import me.saxon564.mochickens.entities.mobs.renders.RenderSkeletonChicken;
import me.saxon564.mochickens.entities.mobs.renders.RenderSnowChicken;
import me.saxon564.mochickens.proxies.CommonProxyMoChickens;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
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
        RenderingRegistry.registerEntityRenderingHandler(EntityDiamondChicken.class, new RenderDiamondChicken(new ModelEnderChicken(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(EntityCoalChicken.class, new RenderCoalChicken(new ModelCChicken(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(EntityIronChicken.class, new RenderIronChicken(new ModelCChicken(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(EntityGoldChicken.class, new RenderGoldChicken(new ModelGoldChicken(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(EntityLapisChicken.class, new RenderLapisChicken(new ModelGoldChicken(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(EntityRedstoneChicken.class, new RenderRedstoneChicken(new ModelRedstoneChicken(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(EntityEmeraldChicken.class, new RenderEmeraldChicken(new ModelCChicken(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(EntityGiantChicken.class, new RenderGiantChicken(new ModelGiantChicken(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(EntityQuartzChicken.class, new RenderQuartzChicken(new ModelCChicken(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(EntitySkeletonChicken.class, new RenderSkeletonChicken(new ModelSkeletonChicken(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(EntityEnderChicken.class, new RenderEnderChicken(new ModelEnderChicken(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(EntityCreeperChicken.class, new RenderCreeperChicken(new ModelCChicken(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(EntityCookieChicken.class, new RenderCookieChicken(new ModelCChicken(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(EntitySnowChicken.class, new RenderSnowChicken(new ModelCChicken(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(EntityClayChicken.class, new RenderClayChicken(new ModelCChicken(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(EntityRainbowChicken.class, new RenderRainbowChicken(new ModelCChicken(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(EntityBeefyChicken.class, new RenderBeefyChicken(new ModelBeefyChicken(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(EntityGlowingChicken.class, new RenderGlowingChicken(new ModelEnderChicken(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(EntityBlazingChicken.class, new RenderBlazingChicken(new ModelEnderChicken(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(EntityEnchantedChicken.class, new RenderEnchantedChicken(new ModelEnderChicken(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(EntityNuuwChicken.class, new RenderNuuwChicken(new ModelEnderChicken(), 0.3F));
    }
}
