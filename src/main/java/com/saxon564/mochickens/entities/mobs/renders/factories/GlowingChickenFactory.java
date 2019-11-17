package com.saxon564.mochickens.entities.mobs.renders.factories;

import com.saxon564.mochickens.entities.mobs.EntityGlowingChicken;
import com.saxon564.mochickens.entities.mobs.renders.RenderGlowingChicken;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.loading.FMLEnvironment;

public class GlowingChickenFactory implements IRenderFactory<EntityGlowingChicken> {
    public static final GlowingChickenFactory INSTANCE = new GlowingChickenFactory();

    @Override
    public EntityRenderer<? super EntityGlowingChicken> createRenderFor(EntityRendererManager manager) {
        if (FMLEnvironment.dist.isDedicatedServer())
            throw new IllegalStateException("Only run this on client!");

        return new RenderGlowingChicken(manager);
    }
}