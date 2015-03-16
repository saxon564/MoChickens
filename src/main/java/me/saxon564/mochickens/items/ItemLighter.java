package me.saxon564.mochickens.items;

import me.saxon564.mochickens.MoChickens;
import me.saxon564.mochickens.MoChickensReference;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemLighter extends Item {
	
	public ItemLighter()
    {
        super();
        setMaxStackSize(64);
        setCreativeTab(MoChickens.moChickensTab);
        setUnlocalizedName("lighter");
        setTextureName(MoChickensReference.MODID + ":"
				+ getUnlocalizedName().substring(5));
        this.maxStackSize = 1;
        this.setMaxDamage(56);
    }
	
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float par8, float par9, float par10) {
		if (side == 0) {
			y--;
		}
		
		if (side == 1) {
			y++;
		}
		
		if (side == 2) {
			z--;
		}
		
		if (side == 3) {
			z++;
		}
		
		if (side == 4) {
			x--;
		}
		
		if (side == 5) {
			x++;
		}
		
		if (!player.canPlayerEdit(x, y, z, side, itemStack)) {
			return false;
		} else {
			if (world.isAirBlock(x, y, z)) {
				world.playSound((double) x + 0.5D, (double) y + 0.5D, (double) z + 0.5D, "fire.ignite", 1F, itemRand.nextFloat() * 0.4F + 0.8F, true);
				world.setBlock(x, y, z, MoChickens.blockChickenFire);
				
			}
			itemStack.damageItem(1, player);
		}
		
		return false;
	}

    @Override
    public void registerIcons(IIconRegister iconRegister)
    {
        itemIcon = iconRegister.registerIcon("mochickens:lighter");
    }
	
}
