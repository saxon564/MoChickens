package com.saxon564.mochickens.entities.mobs.renders.factories;

import com.saxon564.mochickens.entities.mobs.EntityCreeperChicken;
import com.saxon564.mochickens.entities.mobs.renders.RenderCreeperChicken;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.loading.FMLEnvironment;

public class CreeperChickenFactory implements IRenderFactory<EntityCreeperChicken> {
    public static final CreeperChickenFactory INSTANCE = new CreeperChickenFactory();

    @Override
    public EntityRenderer<? super EntityCreeperChicken> createRenderFor(EntityRendererManager manager) {
        if (FMLEnvironment.dist.isDedicatedServer())
            throw new IllegalStateException("Only run this on client!");

        return new RenderCreeperChicken(manager);
    }
}