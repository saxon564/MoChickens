package com.saxon564.mochickens.entities.mobs.renders.factories;

import com.saxon564.mochickens.entities.mobs.EntityRedstoneChicken;
import com.saxon564.mochickens.entities.mobs.renders.RenderRedstoneChicken;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.loading.FMLEnvironment;

public class RedstoneChickenFactory implements IRenderFactory<EntityRedstoneChicken> {
    public static final RedstoneChickenFactory INSTANCE = new RedstoneChickenFactory();

    @Override
    public EntityRenderer<? super EntityRedstoneChicken> createRenderFor(EntityRendererManager manager) {
        if (FMLEnvironment.dist.isDedicatedServer())
            throw new IllegalStateException("Only run this on client!");

        return new RenderRedstoneChicken(manager);
    }
}