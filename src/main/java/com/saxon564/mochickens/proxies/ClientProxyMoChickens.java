package com.saxon564.mochickens.proxies;

//import com.saxon564.mochickens.MoChickens;
import com.saxon564.mochickens.Reference;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = Reference.MOD_ID)
public class ClientProxyMoChickens extends CommonProxyMoChickens
{
    
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
}
