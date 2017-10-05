package com.saxon564.mochickens.blocks;

import java.util.List;

import com.saxon564.mochickens.MoChickens;
import com.saxon564.mochickens.Reference;
import com.saxon564.mochickens.enums.EnumHandler.*;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockFeatherBlock extends Block {
	
	public static final PropertyEnum VARIANT = PropertyEnum.create("variant", EnumBlockTypes.class);
	
	public BlockFeatherBlock() {
		
		super(Material.ROCK);
		setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, EnumBlockTypes.CHICKEN));
		setCreativeTab(MoChickens.moChickensTab);
        this.setRegistryName(new ResourceLocation(Reference.MOD_ID, "feather_block"));
		setUnlocalizedName("feather_block");
		setSoundType(SoundType.CLOTH);
	}
	
	public int damageDropped(IBlockState state)
    {
        return ((EnumBlockTypes)state.getValue(VARIANT)).getID();
    }
	
	@SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List list)
    {
		EnumBlockTypes[] aenumtype = EnumBlockTypes.values();
        int i = aenumtype.length;

        for (int j = 0; j < i; ++j)
        {
        	EnumBlockTypes enumtype = aenumtype[j];
            list.add(new ItemStack(itemIn, 1, enumtype.getID()));
        }
    }
	
	public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(VARIANT, EnumBlockTypes.byID(meta));
    }
    public int getMetaFromState(IBlockState state)
    {
        return ((EnumBlockTypes)state.getValue(VARIANT)).getID();
    }
	
	protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {VARIANT});
    }

}
