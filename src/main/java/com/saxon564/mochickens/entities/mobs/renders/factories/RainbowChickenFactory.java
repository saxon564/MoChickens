package com.saxon564.mochickens.entities.mobs.renders.factories;

import com.saxon564.mochickens.entities.mobs.EntityRainbowChicken;
import com.saxon564.mochickens.entities.mobs.renders.RenderRainbowChicken;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.loading.FMLEnvironment;

public class RainbowChickenFactory implements IRenderFactory<EntityRainbowChicken> {
    public static final RainbowChickenFactory INSTANCE = new RainbowChickenFactory();

    @Override
    public EntityRenderer<? super EntityRainbowChicken> createRenderFor(EntityRendererManager manager) {
        if (FMLEnvironment.dist.isDedicatedServer())
            throw new IllegalStateException("Only run this on client!");

        return new RenderRainbowChicken(manager);
    }
}