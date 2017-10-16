package com.saxon564.mochickens.client;

import net.minecraft.client.Minecraft;

import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;

import com.saxon564.mochickens.MoChickens;
import com.saxon564.mochickens.Reference;
import com.saxon564.mochickens.blocks.BlockChickenFireBlock;
import com.saxon564.mochickens.entities.mobs.EntityBeefyChicken;
import com.saxon564.mochickens.entities.mobs.EntityBlazingChicken;
import com.saxon564.mochickens.entities.mobs.EntityClayChicken;
import com.saxon564.mochickens.entities.mobs.EntityCoalChicken;
import com.saxon564.mochickens.entities.mobs.EntityCookieChicken;
import com.saxon564.mochickens.entities.mobs.EntityCreeperChicken;
import com.saxon564.mochickens.entities.mobs.EntityDiamondChicken;
import com.saxon564.mochickens.entities.mobs.EntityEmeraldChicken;
import com.saxon564.mochickens.entities.mobs.EntityEnchantedChicken;
import com.saxon564.mochickens.entities.mobs.EntityEnderChicken;
import com.saxon564.mochickens.entities.mobs.EntityGiantChicken;
import com.saxon564.mochickens.entities.mobs.EntityGlowingChicken;
import com.saxon564.mochickens.entities.mobs.EntityGoldChicken;
import com.saxon564.mochickens.entities.mobs.EntityIronChicken;
import com.saxon564.mochickens.entities.mobs.EntityLapisChicken;
import com.saxon564.mochickens.entities.mobs.EntityMoChicken;
import com.saxon564.mochickens.entities.mobs.EntityNuuwChicken;
import com.saxon564.mochickens.entities.mobs.EntityQuartzChicken;
import com.saxon564.mochickens.entities.mobs.EntityRainbowChicken;
import com.saxon564.mochickens.entities.mobs.EntityRedstoneChicken;
import com.saxon564.mochickens.entities.mobs.EntitySkeletonChicken;
import com.saxon564.mochickens.entities.mobs.EntitySnowChicken;
import com.saxon564.mochickens.entities.mobs.models.ModelBeefyChicken;
import com.saxon564.mochickens.entities.mobs.models.ModelCChicken;
import com.saxon564.mochickens.entities.mobs.models.ModelEnderChicken;
import com.saxon564.mochickens.entities.mobs.models.ModelGiantChicken;
import com.saxon564.mochickens.entities.mobs.models.ModelGoldChicken;
import com.saxon564.mochickens.entities.mobs.models.ModelRedstoneChicken;
import com.saxon564.mochickens.entities.mobs.models.ModelSkeletonChicken;
import com.saxon564.mochickens.entities.mobs.renders.RenderBeefyChicken;
import com.saxon564.mochickens.entities.mobs.renders.RenderBlazingChicken;
import com.saxon564.mochickens.entities.mobs.renders.RenderClayChicken;
import com.saxon564.mochickens.entities.mobs.renders.RenderCoalChicken;
import com.saxon564.mochickens.entities.mobs.renders.RenderCookieChicken;
import com.saxon564.mochickens.entities.mobs.renders.RenderCreeperChicken;
import com.saxon564.mochickens.entities.mobs.renders.RenderDiamondChicken;
import com.saxon564.mochickens.entities.mobs.renders.RenderEmeraldChicken;
import com.saxon564.mochickens.entities.mobs.renders.RenderEnchantedChicken;
import com.saxon564.mochickens.entities.mobs.renders.RenderEnderChicken;
import com.saxon564.mochickens.entities.mobs.renders.RenderGiantChicken;
import com.saxon564.mochickens.entities.mobs.renders.RenderGlowingChicken;
import com.saxon564.mochickens.entities.mobs.renders.RenderGoldChicken;
import com.saxon564.mochickens.entities.mobs.renders.RenderIronChicken;
import com.saxon564.mochickens.entities.mobs.renders.RenderLapisChicken;
import com.saxon564.mochickens.entities.mobs.renders.RenderNuuwChicken;
import com.saxon564.mochickens.entities.mobs.renders.RenderQuartzChicken;
import com.saxon564.mochickens.entities.mobs.renders.RenderRainbowChicken;
import com.saxon564.mochickens.entities.mobs.renders.RenderRedstoneChicken;
import com.saxon564.mochickens.entities.mobs.renders.RenderSkeletonChicken;
import com.saxon564.mochickens.entities.mobs.renders.RenderSnowChicken;
import com.saxon564.mochickens.enums.EnumHandler.*;
import com.saxon564.mochickens.events.FireEventHandlerClient;
import com.saxon564.mochickens.events.FireEventHandlerServer;
import com.saxon564.mochickens.proxies.CommonProxyMoChickens;
import com.saxon564.mochickens.registers.RegisterHelper;

@Mod.EventBusSubscriber
public class ClientProxyMoChickens extends CommonProxyMoChickens
{
	private RenderManager manager;
	
    public void registerRenders()
    {
    	chickens();
    }
    
    public void modelExceptions() {
    	ModelLoader.setCustomStateMapper(MoChickens.chicken_fire, (new StateMap.Builder()).ignore(BlockChickenFireBlock.AGE).build());
    }
    
    public void eventHandlers() {
    	//MinecraftForge.EVENT_BUS.register(new FireEventHandlerClient());
    }
    
    @SubscribeEvent
	public static void items(ModelRegistryEvent event) {
		for (EnumResourceTypes types : EnumResourceTypes.values()) {
			String itemModelName = types.getName();
			int metadata = types.getID();
			
			RegisterHelper.registerItemRenders(MoChickens.disc_stick, metadata, itemModelName + "_stick");
			RegisterHelper.registerItemRenders(MoChickens.chicken_feather, metadata, itemModelName + "_feather");
		}
		
		for (EnumBlockTypes types : EnumBlockTypes.values()) {
			String itemModelName = types.getName();
			int metadata = types.getID();
			
			RegisterHelper.registerItemRenders(Item.getItemFromBlock(MoChickens.feather_block), metadata, itemModelName + "_feather_block");
		}
		
		//Items
		RegisterHelper.registerItemRenders(MoChickens.inner_taming_disc, 0, "inner_taming_disc");
		RegisterHelper.registerItemRenders(MoChickens.taming_disc, 0, "taming_disc");
		RegisterHelper.registerItemRenders(MoChickens.random_egg, 0, "random_egg");
		RegisterHelper.registerItemRenders(MoChickens.chicken_steel, 0, "chicken_steel");
		
		//Blocks
		RegisterHelper.registerItemRenders(Item.getItemFromBlock(MoChickens.coal_gem_ore), 0, "coal_gem_ore");
		
	}

	private void chickens() {
		RenderingRegistry.registerEntityRenderingHandler(
				EntityDiamondChicken.class, new IRenderFactory<EntityMoChicken>() {
					@Override
					public Render<? super EntityMoChicken> createRenderFor(RenderManager manager) {
						return new RenderDiamondChicken(manager, new ModelEnderChicken(), 0.3F);
					}
				});
        RenderingRegistry.registerEntityRenderingHandler(
        		EntityCoalChicken.class, new IRenderFactory<EntityMoChicken>() {
					@Override
					public Render<? super EntityMoChicken> createRenderFor(RenderManager manager) {
						return new RenderCoalChicken(manager, new ModelCChicken(), 0.3F);
					}
				});
        RenderingRegistry.registerEntityRenderingHandler(
        		EntityIronChicken.class, new IRenderFactory<EntityMoChicken>() {
					@Override
					public Render<? super EntityMoChicken> createRenderFor(RenderManager manager) {
						return new RenderIronChicken(manager, new ModelCChicken(), 0.3F);
					}
				});
        RenderingRegistry.registerEntityRenderingHandler(
        		EntityGoldChicken.class, new IRenderFactory<EntityMoChicken>() {
					@Override
					public Render<? super EntityMoChicken> createRenderFor(RenderManager manager) {
						return new RenderGoldChicken(manager, new ModelGoldChicken(), 0.3F);
					}
				});
        RenderingRegistry.registerEntityRenderingHandler(
        		EntityLapisChicken.class, new IRenderFactory<EntityMoChicken>() {
					@Override
					public Render<? super EntityMoChicken> createRenderFor(RenderManager manager) {
						return new RenderLapisChicken(manager, new ModelGoldChicken(), 0.3F);
					}
				});
        RenderingRegistry.registerEntityRenderingHandler(
        		EntityRedstoneChicken.class, new IRenderFactory<EntityMoChicken>() {
					@Override
					public Render<? super EntityMoChicken> createRenderFor(RenderManager manager) {
						return new RenderRedstoneChicken(manager, new ModelRedstoneChicken(), 0.3F);
					}
				});
        RenderingRegistry.registerEntityRenderingHandler(
        		EntityEmeraldChicken.class, new IRenderFactory<EntityMoChicken>() {
					@Override
					public Render<? super EntityMoChicken> createRenderFor(RenderManager manager) {
						return new RenderEmeraldChicken(manager, new ModelEnderChicken(), 0.3F);
					}
				});
        RenderingRegistry.registerEntityRenderingHandler(
        		EntityGiantChicken.class, new IRenderFactory<EntityMoChicken>() {
					@Override
					public Render<? super EntityMoChicken> createRenderFor(RenderManager manager) {
						return new RenderGiantChicken(manager, new ModelGiantChicken(), 0.3F);
					}
				});
        RenderingRegistry.registerEntityRenderingHandler(
        		EntityQuartzChicken.class, new IRenderFactory<EntityMoChicken>() {
					@Override
					public Render<? super EntityMoChicken> createRenderFor(RenderManager manager) {
						return new RenderQuartzChicken(manager, new ModelCChicken(), 0.3F);
					}
				});
        RenderingRegistry.registerEntityRenderingHandler(
        		EntitySkeletonChicken.class, new IRenderFactory<EntityMoChicken>() {
					@Override
					public Render<? super EntityMoChicken> createRenderFor(RenderManager manager) {
						return new RenderSkeletonChicken(manager, new ModelSkeletonChicken(), 0.3F);
					}
				});
        RenderingRegistry.registerEntityRenderingHandler(
        		EntityEnderChicken.class, new IRenderFactory<EntityMoChicken>() {
					@Override
					public Render<? super EntityMoChicken> createRenderFor(RenderManager manager) {
						return new RenderEnderChicken(manager, new ModelEnderChicken(), 0.3F);
					}
				});
        RenderingRegistry.registerEntityRenderingHandler(
        		EntityCreeperChicken.class, new IRenderFactory<EntityMoChicken>() {
					@Override
					public Render<? super EntityMoChicken> createRenderFor(RenderManager manager) {
						return new RenderCreeperChicken(manager, new ModelCChicken(), 0.3F);
					}
				});
        RenderingRegistry.registerEntityRenderingHandler(
        		EntityCookieChicken.class, new IRenderFactory<EntityMoChicken>() {
					@Override
					public Render<? super EntityMoChicken> createRenderFor(RenderManager manager) {
						return new RenderCookieChicken(manager, new ModelCChicken(), 0.3F);
					}
				});
        RenderingRegistry.registerEntityRenderingHandler(
        		EntitySnowChicken.class, new IRenderFactory<EntityMoChicken>() {
					@Override
					public Render<? super EntityMoChicken> createRenderFor(RenderManager manager) {
						return new RenderSnowChicken(manager, new ModelCChicken(), 0.3F);
					}
				});
        RenderingRegistry.registerEntityRenderingHandler(
        		EntityClayChicken.class, new IRenderFactory<EntityMoChicken>() {
					@Override
					public Render<? super EntityMoChicken> createRenderFor(RenderManager manager) {
						return new RenderClayChicken(manager, new ModelCChicken(), 0.3F);
					}
				});
        RenderingRegistry.registerEntityRenderingHandler(
        		EntityRainbowChicken.class, new IRenderFactory<EntityMoChicken>() {
					@Override
					public Render<? super EntityMoChicken> createRenderFor(RenderManager manager) {
						return new RenderRainbowChicken(manager, new ModelCChicken(), 0.3F);
					}
				});
        RenderingRegistry.registerEntityRenderingHandler(
        		EntityBeefyChicken.class, new IRenderFactory<EntityMoChicken>() {
					@Override
					public Render<? super EntityMoChicken> createRenderFor(RenderManager manager) {
						return new RenderBeefyChicken(manager, new ModelBeefyChicken(), 0.3F);
					}
        		});
        RenderingRegistry.registerEntityRenderingHandler(
        		EntityGlowingChicken.class, new IRenderFactory<EntityMoChicken>() {
					@Override
					public Render<? super EntityMoChicken> createRenderFor(RenderManager manager) {
						return new RenderGlowingChicken(manager, new ModelEnderChicken(), 0.3F);
					}
				});
        RenderingRegistry.registerEntityRenderingHandler(
        		EntityBlazingChicken.class, new IRenderFactory<EntityMoChicken>() {
					@Override
					public Render<? super EntityMoChicken> createRenderFor(RenderManager manager) {
						return new RenderBlazingChicken(manager, new ModelEnderChicken(), 0.3F);
					}
				});
        RenderingRegistry.registerEntityRenderingHandler(
        		EntityEnchantedChicken.class, new IRenderFactory<EntityMoChicken>() {
					@Override
					public Render<? super EntityMoChicken> createRenderFor(RenderManager manager) {
						return new RenderEnchantedChicken(manager, new ModelEnderChicken(), 0.3F);
					}
				});
        RenderingRegistry.registerEntityRenderingHandler(
        		EntityNuuwChicken.class, new IRenderFactory<EntityMoChicken>() {
					@Override
					public Render<? super EntityMoChicken> createRenderFor(RenderManager manager) {
						return new RenderNuuwChicken(manager, new ModelEnderChicken(), 0.3F);
					}
				});
	}
}
