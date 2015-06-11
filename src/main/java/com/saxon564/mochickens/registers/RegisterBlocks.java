package com.saxon564.mochickens.registers;

import com.saxon564.mochickens.MoChickens;
import com.saxon564.mochickens.blocks.BlockChickenFireBlock;
import com.saxon564.mochickens.blocks.BlockCoalGemOreBlock;
import com.saxon564.mochickens.blocks.BlockFeatherBlock;
import com.saxon564.mochickens.blocks.BlockFeatherPortal;
//import me.saxon564.mochickens.blocks.BlockChickenFireBlock;
//import me.saxon564.mochickens.blocks.BlockCoalGemOreBlock;
//import me.saxon564.mochickens.blocks.BlockFeatherPortal;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class RegisterBlocks {
	
	public static void blockRegisters() {
	MoChickens.feather_portal = new BlockFeatherPortal();
	MoChickens.feather_block = new BlockFeatherBlock();
	//MoChickens.blockRedstoneFeatherBlock = new BlockRedstoneFeatherBlock();
	//MoChickens.blockCoalFeatherBlock = new BlockCoalFeatherBlock();
	//MoChickens.blockIronFeatherBlock = new BlockIronFeatherBlock();
	//MoChickens.blockGoldFeatherBlock = new BlockGoldFeatherBlock();
	//MoChickens.blockLapisFeatherBlock = new BlockLapisFeatherBlock();
	//MoChickens.blockDiamondFeatherBlock = new BlockDiamondFeatherBlock();
	//MoChickens.blockEmeraldFeatherBlock = new BlockEmeraldFeatherBlock();
	//MoChickens.blockQuartzFeatherBlock = new BlockQuartzFeatherBlock();
	//MoChickens.blockEnchantedFeatherBlock = new BlockEnchantedFeatherBlock();
	//MoChickens.blockMasterFeatherBlock = new BlockMasterFeatherBlock();
	MoChickens.coal_gem_ore = new BlockCoalGemOreBlock();
	MoChickens.chicken_fire = new BlockChickenFireBlock();
	
	RegisterHelper.registerBlock(MoChickens.feather_portal);
    RegisterHelper.registerBlock(MoChickens.feather_block);
    //RegisterHelper.registerBlock(MoChickens.coalStick);
    //RegisterHelper.registerBlock(MoChickens.ironStick);
    //RegisterHelper.registerBlock(MoChickens.goldStick);
    //RegisterHelper.registerBlock(MoChickens.redstoneStick);
    //RegisterHelper.registerBlock(MoChickens.lapisStick);
    //RegisterHelper.registerBlock(MoChickens.diamondStick);
    //RegisterHelper.registerBlock(MoChickens.emeraldStick);
    //RegisterHelper.registerBlock(MoChickens.quartzStick);
    //RegisterHelper.registerBlock(MoChickens.randomEgg);
    RegisterHelper.registerBlock(MoChickens.coal_gem_ore);
    RegisterHelper.registerBlock(MoChickens.chicken_fire);
	}
	
}
