package com.saxon564.mochickens.entities.mobs.renders.factories;

import com.saxon564.mochickens.entities.mobs.EntityDiamondChicken;
import com.saxon564.mochickens.entities.mobs.renders.RenderDiamondChicken;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.loading.FMLEnvironment;

public class DiamondChickenFactory implements IRenderFactory<EntityDiamondChicken> {
    public static final DiamondChickenFactory INSTANCE = new DiamondChickenFactory();

    @Override
    public EntityRenderer<? super EntityDiamondChicken> createRenderFor(EntityRendererManager manager) {
        if (FMLEnvironment.dist.isDedicatedServer())
            throw new IllegalStateException("Only run this on client!");

        return new RenderDiamondChicken(manager);
    }
}