package com.saxon564.mochickens.registers;

import com.saxon564.mochickens.MoChickens;
import com.saxon564.mochickens.Reference;
import com.saxon564.mochickens.blocks.BlockChickenFireBlock;
import com.saxon564.mochickens.blocks.BlockFeatherBlock;

//import me.saxon564.mochickens.blocks.BlockChickenFireBlock;
//import me.saxon564.mochickens.blocks.BlockCoalGemOreBlock;
//import me.saxon564.mochickens.blocks.BlockFeatherPortal;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class RegisterBlocks {
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(
			//MoChickens.feather_portal = new BlockFeatherPortal();
			MoChickens.FEATHER_BLOCK = new BlockFeatherBlock(Block.Properties.create(Material.WOOL).hardnessAndResistance(0.8F).sound(SoundType.CLOTH)).setRegistryName(Reference.MOD_ID, "feather_block"),
			MoChickens.COAL_FEATHER_BLOCK = new BlockFeatherBlock(Block.Properties.create(Material.WOOL).hardnessAndResistance(0.8F).sound(SoundType.CLOTH)).setRegistryName(Reference.MOD_ID, "coal_feather_block"),
			MoChickens.IRON_FEATHER_BLOCK = new BlockFeatherBlock(Block.Properties.create(Material.WOOL).hardnessAndResistance(0.8F).sound(SoundType.CLOTH)).setRegistryName(Reference.MOD_ID, "iron_feather_block"),
			MoChickens.GOLD_FEATHER_BLOCK = new BlockFeatherBlock(Block.Properties.create(Material.WOOL).hardnessAndResistance(0.8F).sound(SoundType.CLOTH)).setRegistryName(Reference.MOD_ID, "gold_feather_block"),
			MoChickens.LAPIS_FEATHER_BLOCK = new BlockFeatherBlock(Block.Properties.create(Material.WOOL).hardnessAndResistance(0.8F).sound(SoundType.CLOTH)).setRegistryName(Reference.MOD_ID, "lapis_feather_block"),
			MoChickens.REDSTONE_FEATHER_BLOCK = new BlockFeatherBlock(Block.Properties.create(Material.WOOL).hardnessAndResistance(0.8F).sound(SoundType.CLOTH)).setRegistryName(Reference.MOD_ID, "redstone_feather_block"),
			MoChickens.DIAMOND_FEATHER_BLOCK = new BlockFeatherBlock(Block.Properties.create(Material.WOOL).hardnessAndResistance(0.8F).sound(SoundType.CLOTH)).setRegistryName(Reference.MOD_ID, "diamond_feather_block"),
			MoChickens.EMERALD_FEATHER_BLOCK = new BlockFeatherBlock(Block.Properties.create(Material.WOOL).hardnessAndResistance(0.8F).sound(SoundType.CLOTH)).setRegistryName(Reference.MOD_ID, "emerald_feather_block"),
			MoChickens.QUARTZ_FEATHER_BLOCK = new BlockFeatherBlock(Block.Properties.create(Material.WOOL).hardnessAndResistance(0.8F).sound(SoundType.CLOTH)).setRegistryName(Reference.MOD_ID, "quartz_feather_block")
			//MoChickens.blockEnchantedFeatherBlock = new BlockEnchantedFeatherBlock();
			//MoChickens.blockMasterFeatherBlock = new BlockMasterFeatherBlock();
			//MoChickens.coal_gem_ore = new BlockCoalGemOreBlock();
//			MoChickens.CHICKEN_FIRE = new BlockChickenFireBlock(Block.Properties.create(Material.FIRE).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0.0F).lightValue(15).noDrops()).setRegistryName(Reference.MOD_ID, "chicken_fire")
		);
		
		//RegisterHelper.registerBlock(event, MoChickens.feather_portal);
		//RegisterHelper.registerBlock(event, MoChickens.FEATHER_BLOCK);
	    //RegisterHelper.registerBlock(MoChickens.coalStick);
	    //RegisterHelper.registerBlock(MoChickens.ironStick);
	    //RegisterHelper.registerBlock(MoChickens.goldStick);
	    //RegisterHelper.registerBlock(MoChickens.redstoneStick);
	    //RegisterHelper.registerBlock(MoChickens.lapisStick);
	    //RegisterHelper.registerBlock(MoChickens.diamondStick);
	    //RegisterHelper.registerBlock(MoChickens.emeraldStick);
	    //RegisterHelper.registerBlock(MoChickens.quartzStick);
	    //RegisterHelper.registerBlock(MoChickens.randomEgg);
	    //RegisterHelper.registerBlock(event, MoChickens.coal_gem_ore);
	    //RegisterHelper.registerBlock(event, MoChickens.CHICKEN_FIRE);
		//MoChickens.proxy.modelExceptions();
	}
	
}
