package com.saxon564.mochickens.entities.mobs.renders.factories;

import com.saxon564.mochickens.entities.mobs.EntitySkeletonChicken;
import com.saxon564.mochickens.entities.mobs.renders.RenderSkeletonChicken;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.loading.FMLEnvironment;

public class SkeletonChickenFactory implements IRenderFactory<EntitySkeletonChicken> {
    public static final SkeletonChickenFactory INSTANCE = new SkeletonChickenFactory();

    @Override
    public EntityRenderer<? super EntitySkeletonChicken> createRenderFor(EntityRendererManager manager) {
        if (FMLEnvironment.dist.isDedicatedServer())
            throw new IllegalStateException("Only run this on client!");

        return new RenderSkeletonChicken(manager);
    }
}