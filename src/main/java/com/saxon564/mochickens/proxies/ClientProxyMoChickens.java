package com.saxon564.mochickens.proxies;

//import com.saxon564.mochickens.MoChickens;
import com.saxon564.mochickens.Reference;
//import com.saxon564.mochickens.blocks.BlockChickenFireBlock;
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
import com.saxon564.mochickens.entities.mobs.EntityNuuwChicken;
import com.saxon564.mochickens.entities.mobs.EntityQuartzChicken;
import com.saxon564.mochickens.entities.mobs.EntityRainbowChicken;
import com.saxon564.mochickens.entities.mobs.EntityRedstoneChicken;
import com.saxon564.mochickens.entities.mobs.EntitySkeletonChicken;
import com.saxon564.mochickens.entities.mobs.EntitySnowChicken;
import com.saxon564.mochickens.entities.mobs.renders.factories.BeefyChickenFactory;
import com.saxon564.mochickens.entities.mobs.renders.factories.BlazingChickenFactory;
import com.saxon564.mochickens.entities.mobs.renders.factories.ClayChickenFactory;
import com.saxon564.mochickens.entities.mobs.renders.factories.CoalChickenFactory;
import com.saxon564.mochickens.entities.mobs.renders.factories.CookieChickenFactory;
import com.saxon564.mochickens.entities.mobs.renders.factories.CreeperChickenFactory;
import com.saxon564.mochickens.entities.mobs.renders.factories.DiamondChickenFactory;
import com.saxon564.mochickens.entities.mobs.renders.factories.EmeraldChickenFactory;
import com.saxon564.mochickens.entities.mobs.renders.factories.EnchantedChickenFactory;
import com.saxon564.mochickens.entities.mobs.renders.factories.EnderChickenFactory;
import com.saxon564.mochickens.entities.mobs.renders.factories.GiantChickenFactory;
import com.saxon564.mochickens.entities.mobs.renders.factories.GlowingChickenFactory;
import com.saxon564.mochickens.entities.mobs.renders.factories.GoldChickenFactory;
import com.saxon564.mochickens.entities.mobs.renders.factories.IronChickenFactory;
import com.saxon564.mochickens.entities.mobs.renders.factories.LapisChickenFactory;
import com.saxon564.mochickens.entities.mobs.renders.factories.NuuwChickenFactory;
import com.saxon564.mochickens.entities.mobs.renders.factories.QuartzChickenFactory;
import com.saxon564.mochickens.entities.mobs.renders.factories.RainbowChickenFactory;
import com.saxon564.mochickens.entities.mobs.renders.factories.RedstoneChickenFactory;
import com.saxon564.mochickens.entities.mobs.renders.factories.SkeletonChickenFactory;
import com.saxon564.mochickens.entities.mobs.renders.factories.SnowChickenFactory;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = Reference.MOD_ID)
public class ClientProxyMoChickens extends CommonProxyMoChickens
{
	
    public void registerRenders()
    {
    	chickens();
    }
    
    public void modelExceptions() {
//    	System.out.println(MoChickens.CHICKEN_FIRE.getRegistryName());
//    	ModelLoader.setCustomStateMapper(MoChickens.CHICKEN_FIRE, (new StateMap.Builder()).ignore(BlockChickenFireBlock.AGE).build());
    }
    
    public void eventHandlers() {
    	//MinecraftForge.EVENT_BUS.register(new FireEventHandlerClient());
    }
    
//    @SubscribeEvent
//	public static void items(ModelRegistryEvent event) {
//		for (EnumResourceTypes types : EnumResourceTypes.values()) {
//			String itemModelName = types.getName();
//			int metadata = types.getID();
//			
//			RegisterHelper.registerItemRenders(MoChickens.DISC_STICK, metadata, itemModelName + "_stick");
//			RegisterHelper.registerItemRenders(MoChickens.CHICKEN_FEATHER, metadata, itemModelName + "_feather");
//		}
//		
//		for (EnumBlockTypes types : EnumBlockTypes.values()) {
//			String itemModelName = types.getName();
//			int metadata = types.getID();
//			
//			RegisterHelper.registerItemRenders(Item.getItemFromBlock(MoChickens.FEATHER_BLOCK), metadata, itemModelName + "_feather_block");
//		}
//		
//		//Items
//		RegisterHelper.registerItemRenders(MoChickens.INNER_TAMING_DISC, 0, "inner_taming_disc");
//		RegisterHelper.registerItemRenders(MoChickens.TAMING_DISC, 0, "taming_disc");
//		RegisterHelper.registerItemRenders(MoChickens.RANDOM_EGG, 0, "random_egg");
//		RegisterHelper.registerItemRenders(MoChickens.CHICKEN_STEEL, 0, "chicken_steel");
//		
//		//Blocks
//		//RegisterHelper.registerItemRenders(Item.getItemFromBlock(MoChickens.coal_gem_ore), 0, "coal_gem_ore");
//		
//	}

	private void chickens() {
		RenderingRegistry.registerEntityRenderingHandler(EntityDiamondChicken.class, DiamondChickenFactory.INSTANCE);
        RenderingRegistry.registerEntityRenderingHandler(EntityCoalChicken.class, CoalChickenFactory.INSTANCE);
        RenderingRegistry.registerEntityRenderingHandler(EntityIronChicken.class, IronChickenFactory.INSTANCE);
        RenderingRegistry.registerEntityRenderingHandler(EntityGoldChicken.class, GoldChickenFactory.INSTANCE);
        RenderingRegistry.registerEntityRenderingHandler(EntityLapisChicken.class, LapisChickenFactory.INSTANCE);
        RenderingRegistry.registerEntityRenderingHandler(EntityRedstoneChicken.class, RedstoneChickenFactory.INSTANCE);
        RenderingRegistry.registerEntityRenderingHandler(EntityEmeraldChicken.class, EmeraldChickenFactory.INSTANCE);
        RenderingRegistry.registerEntityRenderingHandler(EntityGiantChicken.class, GiantChickenFactory.INSTANCE);
        RenderingRegistry.registerEntityRenderingHandler(EntityQuartzChicken.class, QuartzChickenFactory.INSTANCE);
        RenderingRegistry.registerEntityRenderingHandler(EntitySkeletonChicken.class, SkeletonChickenFactory.INSTANCE);
        RenderingRegistry.registerEntityRenderingHandler(EntityEnderChicken.class, EnderChickenFactory.INSTANCE);
        RenderingRegistry.registerEntityRenderingHandler(EntityCreeperChicken.class, CreeperChickenFactory.INSTANCE);
        RenderingRegistry.registerEntityRenderingHandler(EntityCookieChicken.class, CookieChickenFactory.INSTANCE);
        RenderingRegistry.registerEntityRenderingHandler(EntitySnowChicken.class, SnowChickenFactory.INSTANCE);
        RenderingRegistry.registerEntityRenderingHandler(EntityClayChicken.class, ClayChickenFactory.INSTANCE);
        RenderingRegistry.registerEntityRenderingHandler(EntityRainbowChicken.class, RainbowChickenFactory.INSTANCE);
        RenderingRegistry.registerEntityRenderingHandler(EntityBeefyChicken.class, BeefyChickenFactory.INSTANCE);
        RenderingRegistry.registerEntityRenderingHandler(EntityGlowingChicken.class, GlowingChickenFactory.INSTANCE);
        RenderingRegistry.registerEntityRenderingHandler(EntityBlazingChicken.class, BlazingChickenFactory.INSTANCE);
        RenderingRegistry.registerEntityRenderingHandler(EntityEnchantedChicken.class, EnchantedChickenFactory.INSTANCE);
        RenderingRegistry.registerEntityRenderingHandler(EntityNuuwChicken.class, NuuwChickenFactory.INSTANCE);
	}
}
