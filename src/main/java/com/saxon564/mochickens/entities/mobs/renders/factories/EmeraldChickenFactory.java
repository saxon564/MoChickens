package com.saxon564.mochickens.entities.mobs.renders.factories;

import com.saxon564.mochickens.entities.mobs.EntityEmeraldChicken;
import com.saxon564.mochickens.entities.mobs.renders.RenderEmeraldChicken;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.loading.FMLEnvironment;

public class EmeraldChickenFactory implements IRenderFactory<EntityEmeraldChicken> {
    public static final EmeraldChickenFactory INSTANCE = new EmeraldChickenFactory();

    @Override
    public EntityRenderer<? super EntityEmeraldChicken> createRenderFor(EntityRendererManager manager) {
        if (FMLEnvironment.dist.isDedicatedServer())
            throw new IllegalStateException("Only run this on client!");

        return new RenderEmeraldChicken(manager);
    }
}