package com.saxon564.mochickens.entities.mobs.renders.factories;

import com.saxon564.mochickens.entities.mobs.EntityBeefyChicken;
import com.saxon564.mochickens.entities.mobs.renders.RenderBeefyChicken;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.loading.FMLEnvironment;

public class BeefyChickenFactory implements IRenderFactory<EntityBeefyChicken> {
    public static final BeefyChickenFactory INSTANCE = new BeefyChickenFactory();

    @Override
    public EntityRenderer<? super EntityBeefyChicken> createRenderFor(EntityRendererManager manager) {
        if (FMLEnvironment.dist.isDedicatedServer())
            throw new IllegalStateException("Only run this on client!");

        return new RenderBeefyChicken(manager);
    }
}