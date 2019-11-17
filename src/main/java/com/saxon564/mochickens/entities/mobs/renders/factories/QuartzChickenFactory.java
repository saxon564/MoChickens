package com.saxon564.mochickens.entities.mobs.renders.factories;

import com.saxon564.mochickens.entities.mobs.EntityQuartzChicken;
import com.saxon564.mochickens.entities.mobs.renders.RenderQuartzChicken;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.loading.FMLEnvironment;

public class QuartzChickenFactory implements IRenderFactory<EntityQuartzChicken> {
    public static final QuartzChickenFactory INSTANCE = new QuartzChickenFactory();

    @Override
    public EntityRenderer<? super EntityQuartzChicken> createRenderFor(EntityRendererManager manager) {
        if (FMLEnvironment.dist.isDedicatedServer())
            throw new IllegalStateException("Only run this on client!");

        return new RenderQuartzChicken(manager);
    }
}