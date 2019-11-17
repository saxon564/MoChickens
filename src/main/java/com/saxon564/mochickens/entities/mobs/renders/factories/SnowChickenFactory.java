package com.saxon564.mochickens.entities.mobs.renders.factories;

import com.saxon564.mochickens.entities.mobs.EntitySnowChicken;
import com.saxon564.mochickens.entities.mobs.renders.RenderSnowChicken;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.loading.FMLEnvironment;

public class SnowChickenFactory implements IRenderFactory<EntitySnowChicken> {
    public static final SnowChickenFactory INSTANCE = new SnowChickenFactory();

    @Override
    public EntityRenderer<? super EntitySnowChicken> createRenderFor(EntityRendererManager manager) {
        if (FMLEnvironment.dist.isDedicatedServer())
            throw new IllegalStateException("Only run this on client!");

        return new RenderSnowChicken(manager);
    }
}