package com.saxon564.mochickens.entities.mobs.renders.factories;

import com.saxon564.mochickens.entities.mobs.EntityBlazingChicken;
import com.saxon564.mochickens.entities.mobs.renders.RenderBlazingChicken;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.loading.FMLEnvironment;

public class BlazingChickenFactory implements IRenderFactory<EntityBlazingChicken> {
    public static final BlazingChickenFactory INSTANCE = new BlazingChickenFactory();

    @Override
    public EntityRenderer<? super EntityBlazingChicken> createRenderFor(EntityRendererManager manager) {
        if (FMLEnvironment.dist.isDedicatedServer())
            throw new IllegalStateException("Only run this on client!");

        return new RenderBlazingChicken(manager);
    }
}