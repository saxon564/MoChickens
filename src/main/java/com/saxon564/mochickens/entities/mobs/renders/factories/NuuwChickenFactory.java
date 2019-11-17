package com.saxon564.mochickens.entities.mobs.renders.factories;

import com.saxon564.mochickens.entities.mobs.EntityNuuwChicken;
import com.saxon564.mochickens.entities.mobs.renders.RenderNuuwChicken;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.loading.FMLEnvironment;

public class NuuwChickenFactory implements IRenderFactory<EntityNuuwChicken> {
    public static final NuuwChickenFactory INSTANCE = new NuuwChickenFactory();

    @Override
    public EntityRenderer<? super EntityNuuwChicken> createRenderFor(EntityRendererManager manager) {
        if (FMLEnvironment.dist.isDedicatedServer())
            throw new IllegalStateException("Only run this on client!");

        return new RenderNuuwChicken(manager);
    }
}