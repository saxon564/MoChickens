package com.saxon564.mochickens.entities.mobs.renders.factories;

import com.saxon564.mochickens.entities.mobs.EntityEnchantedChicken;
import com.saxon564.mochickens.entities.mobs.renders.RenderEnchantedChicken;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.loading.FMLEnvironment;

public class EnchantedChickenFactory implements IRenderFactory<EntityEnchantedChicken> {
    public static final EnchantedChickenFactory INSTANCE = new EnchantedChickenFactory();

    @Override
    public EntityRenderer<? super EntityEnchantedChicken> createRenderFor(EntityRendererManager manager) {
        if (FMLEnvironment.dist.isDedicatedServer())
            throw new IllegalStateException("Only run this on client!");

        return new RenderEnchantedChicken(manager);
    }
}