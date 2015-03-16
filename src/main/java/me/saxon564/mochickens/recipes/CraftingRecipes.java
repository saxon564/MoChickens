package me.saxon564.mochickens.recipes;

import me.saxon564.mochickens.MoChickens;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;

public class CraftingRecipes
{
    public static void CraftingRecipieManager()
    {
        //sticks
        GameRegistry.addRecipe(new ItemStack(MoChickens.coalStick, 2), new Object[] { "W", "W", 'W', Item.itemRegistry.getObject("coal")});
        GameRegistry.addRecipe(new ItemStack(MoChickens.ironStick, 2), new Object[] { "W", "W", 'W', Item.itemRegistry.getObject("iron_ingot")});
        GameRegistry.addRecipe(new ItemStack(MoChickens.goldStick, 2), new Object[] { "W", "W", 'W', Item.itemRegistry.getObject("gold_ingot")});
        GameRegistry.addRecipe(new ItemStack(MoChickens.lapisStick, 2), new Object[] { "W", "W", 'W', new ItemStack((Item) Item.itemRegistry.getObject("dye"), 1, 4)});
        GameRegistry.addRecipe(new ItemStack(MoChickens.redstoneStick, 2), new Object[] { "W", "W", 'W', Item.itemRegistry.getObject("redstone")});
        GameRegistry.addRecipe(new ItemStack(MoChickens.diamondStick, 2), new Object[] { "W", "W", 'W', Item.itemRegistry.getObject("diamond")});
        GameRegistry.addRecipe(new ItemStack(MoChickens.emeraldStick, 2), new Object[] { "W", "W", 'W', Item.itemRegistry.getObject("emerald")});
        GameRegistry.addRecipe(new ItemStack(MoChickens.quartzStick, 2), new Object[] { "W", "W", 'W', Item.itemRegistry.getObject("quartz")});
        GameRegistry.addRecipe(new ItemStack(MoChickens.blockFeatherBlock, 2), new Object[] { "WWW", "WWW", "WWW", 'W', Item.itemRegistry.getObject("feather")});
        
        discs();
    }
    
    public static void discs() {
        //inner disk iron top
        GameRegistry.addRecipe(new ItemStack(MoChickens.innerTamingDisc), new Object[] { " T ", "L R", " B ", 'T', MoChickens.ironStick, 'L', MoChickens.redstoneStick, 'R', MoChickens.diamondStick, 'B', MoChickens.emeraldStick});
        GameRegistry.addRecipe(new ItemStack(MoChickens.innerTamingDisc), new Object[] { " T ", "L R", " B ", 'T', MoChickens.ironStick, 'L', MoChickens.diamondStick, 'R', MoChickens.redstoneStick, 'B', MoChickens.emeraldStick});
        GameRegistry.addRecipe(new ItemStack(MoChickens.innerTamingDisc), new Object[] { " T ", "L R", " B ", 'T', MoChickens.ironStick, 'L', MoChickens.emeraldStick, 'R', MoChickens.redstoneStick, 'B', MoChickens.diamondStick});
        GameRegistry.addRecipe(new ItemStack(MoChickens.innerTamingDisc), new Object[] { " T ", "L R", " B ", 'T', MoChickens.ironStick, 'L', MoChickens.redstoneStick, 'R', MoChickens.emeraldStick, 'B', MoChickens.diamondStick});
        GameRegistry.addRecipe(new ItemStack(MoChickens.innerTamingDisc), new Object[] { " T ", "L R", " B ", 'T', MoChickens.ironStick, 'L', MoChickens.emeraldStick, 'R', MoChickens.diamondStick, 'B', MoChickens.redstoneStick});
        GameRegistry.addRecipe(new ItemStack(MoChickens.innerTamingDisc), new Object[] { " T ", "L R", " B ", 'T', MoChickens.ironStick, 'L', MoChickens.diamondStick, 'R', MoChickens.emeraldStick, 'B', MoChickens.redstoneStick});
        //inner disk redstone top
        GameRegistry.addRecipe(new ItemStack(MoChickens.innerTamingDisc), new Object[] { " T ", "L R", " B ", 'T', MoChickens.redstoneStick, 'L', MoChickens.ironStick, 'R', MoChickens.diamondStick, 'B', MoChickens.emeraldStick});
        GameRegistry.addRecipe(new ItemStack(MoChickens.innerTamingDisc), new Object[] { " T ", "L R", " B ", 'T', MoChickens.redstoneStick, 'L', MoChickens.diamondStick, 'R', MoChickens.ironStick, 'B', MoChickens.emeraldStick});
        GameRegistry.addRecipe(new ItemStack(MoChickens.innerTamingDisc), new Object[] { " T ", "L R", " B ", 'T', MoChickens.redstoneStick, 'L', MoChickens.emeraldStick, 'R', MoChickens.ironStick, 'B', MoChickens.diamondStick});
        GameRegistry.addRecipe(new ItemStack(MoChickens.innerTamingDisc), new Object[] { " T ", "L R", " B ", 'T', MoChickens.redstoneStick, 'L', MoChickens.ironStick, 'R', MoChickens.emeraldStick, 'B', MoChickens.diamondStick});
        GameRegistry.addRecipe(new ItemStack(MoChickens.innerTamingDisc), new Object[] { " T ", "L R", " B ", 'T', MoChickens.redstoneStick, 'L', MoChickens.emeraldStick, 'R', MoChickens.diamondStick, 'B', MoChickens.ironStick});
        GameRegistry.addRecipe(new ItemStack(MoChickens.innerTamingDisc), new Object[] { " T ", "L R", " B ", 'T', MoChickens.redstoneStick, 'L', MoChickens.diamondStick, 'R', MoChickens.emeraldStick, 'B', MoChickens.ironStick});
        //inner disk diamond top
        GameRegistry.addRecipe(new ItemStack(MoChickens.innerTamingDisc), new Object[] { " T ", "L R", " B ", 'T', MoChickens.diamondStick, 'L', MoChickens.ironStick, 'R', MoChickens.redstoneStick, 'B', MoChickens.emeraldStick});
        GameRegistry.addRecipe(new ItemStack(MoChickens.innerTamingDisc), new Object[] { " T ", "L R", " B ", 'T', MoChickens.diamondStick, 'L', MoChickens.redstoneStick, 'R', MoChickens.ironStick, 'B', MoChickens.emeraldStick});
        GameRegistry.addRecipe(new ItemStack(MoChickens.innerTamingDisc), new Object[] { " T ", "L R", " B ", 'T', MoChickens.diamondStick, 'L', MoChickens.emeraldStick, 'R', MoChickens.ironStick, 'B', MoChickens.redstoneStick});
        GameRegistry.addRecipe(new ItemStack(MoChickens.innerTamingDisc), new Object[] { " T ", "L R", " B ", 'T', MoChickens.diamondStick, 'L', MoChickens.ironStick, 'R', MoChickens.emeraldStick, 'B', MoChickens.redstoneStick});
        GameRegistry.addRecipe(new ItemStack(MoChickens.innerTamingDisc), new Object[] { " T ", "L R", " B ", 'T', MoChickens.diamondStick, 'L', MoChickens.emeraldStick, 'R', MoChickens.redstoneStick, 'B', MoChickens.ironStick});
        GameRegistry.addRecipe(new ItemStack(MoChickens.innerTamingDisc), new Object[] { " T ", "L R", " B ", 'T', MoChickens.diamondStick, 'L', MoChickens.redstoneStick, 'R', MoChickens.emeraldStick, 'B', MoChickens.ironStick});
        //inner disk emerald top
        GameRegistry.addRecipe(new ItemStack(MoChickens.innerTamingDisc), new Object[] { " T ", "L R", " B ", 'T', MoChickens.emeraldStick, 'L', MoChickens.ironStick, 'R', MoChickens.redstoneStick, 'B', MoChickens.diamondStick});
        GameRegistry.addRecipe(new ItemStack(MoChickens.innerTamingDisc), new Object[] { " T ", "L R", " B ", 'T', MoChickens.emeraldStick, 'L', MoChickens.redstoneStick, 'R', MoChickens.ironStick, 'B', MoChickens.diamondStick});
        GameRegistry.addRecipe(new ItemStack(MoChickens.innerTamingDisc), new Object[] { " T ", "L R", " B ", 'T', MoChickens.emeraldStick, 'L', MoChickens.diamondStick, 'R', MoChickens.ironStick, 'B', MoChickens.redstoneStick});
        GameRegistry.addRecipe(new ItemStack(MoChickens.innerTamingDisc), new Object[] { " T ", "L R", " B ", 'T', MoChickens.emeraldStick, 'L', MoChickens.ironStick, 'R', MoChickens.diamondStick, 'B', MoChickens.redstoneStick});
        GameRegistry.addRecipe(new ItemStack(MoChickens.innerTamingDisc), new Object[] { " T ", "L R", " B ", 'T', MoChickens.emeraldStick, 'L', MoChickens.diamondStick, 'R', MoChickens.redstoneStick, 'B', MoChickens.ironStick});
        GameRegistry.addRecipe(new ItemStack(MoChickens.innerTamingDisc), new Object[] { " T ", "L R", " B ", 'T', MoChickens.emeraldStick, 'L', MoChickens.redstoneStick, 'R', MoChickens.diamondStick, 'B', MoChickens.ironStick});
        //disk gold top
        GameRegistry.addRecipe(new ItemStack(MoChickens.tamingDisc), new Object[] { " T ", "LCR", " B ", 'T', MoChickens.goldStick, 'L', MoChickens.coalStick, 'R', MoChickens.lapisStick, 'B', MoChickens.quartzStick, 'C', MoChickens.innerTamingDisc});
        GameRegistry.addRecipe(new ItemStack(MoChickens.tamingDisc), new Object[] { " T ", "LCR", " B ", 'T', MoChickens.goldStick, 'L', MoChickens.lapisStick, 'R', MoChickens.coalStick, 'B', MoChickens.quartzStick, 'C', MoChickens.innerTamingDisc});
        GameRegistry.addRecipe(new ItemStack(MoChickens.tamingDisc), new Object[] { " T ", "LCR", " B ", 'T', MoChickens.goldStick, 'L', MoChickens.quartzStick, 'R', MoChickens.coalStick, 'B', MoChickens.lapisStick, 'C', MoChickens.innerTamingDisc});
        GameRegistry.addRecipe(new ItemStack(MoChickens.tamingDisc), new Object[] { " T ", "LCR", " B ", 'T', MoChickens.goldStick, 'L', MoChickens.coalStick, 'R', MoChickens.quartzStick, 'B', MoChickens.lapisStick, 'C', MoChickens.innerTamingDisc});
        GameRegistry.addRecipe(new ItemStack(MoChickens.tamingDisc), new Object[] { " T ", "LCR", " B ", 'T', MoChickens.goldStick, 'L', MoChickens.quartzStick, 'R', MoChickens.lapisStick, 'B', MoChickens.coalStick, 'C', MoChickens.innerTamingDisc});
        GameRegistry.addRecipe(new ItemStack(MoChickens.tamingDisc), new Object[] { " T ", "LCR", " B ", 'T', MoChickens.goldStick, 'L', MoChickens.lapisStick, 'R', MoChickens.quartzStick, 'B', MoChickens.coalStick, 'C', MoChickens.innerTamingDisc});
        //disk coal top
        GameRegistry.addRecipe(new ItemStack(MoChickens.tamingDisc), new Object[] { " T ", "LCR", " B ", 'T', MoChickens.coalStick, 'L', MoChickens.goldStick, 'R', MoChickens.lapisStick, 'B', MoChickens.quartzStick, 'C', MoChickens.innerTamingDisc});
        GameRegistry.addRecipe(new ItemStack(MoChickens.tamingDisc), new Object[] { " T ", "LCR", " B ", 'T', MoChickens.coalStick, 'L', MoChickens.lapisStick, 'R', MoChickens.goldStick, 'B', MoChickens.quartzStick, 'C', MoChickens.innerTamingDisc});
        GameRegistry.addRecipe(new ItemStack(MoChickens.tamingDisc), new Object[] { " T ", "LCR", " B ", 'T', MoChickens.coalStick, 'L', MoChickens.quartzStick, 'R', MoChickens.goldStick, 'B', MoChickens.lapisStick, 'C', MoChickens.innerTamingDisc});
        GameRegistry.addRecipe(new ItemStack(MoChickens.tamingDisc), new Object[] { " T ", "LCR", " B ", 'T', MoChickens.coalStick, 'L', MoChickens.goldStick, 'R', MoChickens.quartzStick, 'B', MoChickens.lapisStick, 'C', MoChickens.innerTamingDisc});
        GameRegistry.addRecipe(new ItemStack(MoChickens.tamingDisc), new Object[] { " T ", "LCR", " B ", 'T', MoChickens.coalStick, 'L', MoChickens.quartzStick, 'R', MoChickens.lapisStick, 'B', MoChickens.goldStick, 'C', MoChickens.innerTamingDisc});
        GameRegistry.addRecipe(new ItemStack(MoChickens.tamingDisc), new Object[] { " T ", "LCR", " B ", 'T', MoChickens.coalStick, 'L', MoChickens.lapisStick, 'R', MoChickens.quartzStick, 'B', MoChickens.goldStick, 'C', MoChickens.innerTamingDisc});
        //disk lapis top
        GameRegistry.addRecipe(new ItemStack(MoChickens.tamingDisc), new Object[] { " T ", "LCR", " B ", 'T', MoChickens.lapisStick, 'L', MoChickens.goldStick, 'R', MoChickens.coalStick, 'B', MoChickens.quartzStick, 'C', MoChickens.innerTamingDisc});
        GameRegistry.addRecipe(new ItemStack(MoChickens.tamingDisc), new Object[] { " T ", "LCR", " B ", 'T', MoChickens.lapisStick, 'L', MoChickens.coalStick, 'R', MoChickens.goldStick, 'B', MoChickens.quartzStick, 'C', MoChickens.innerTamingDisc});
        GameRegistry.addRecipe(new ItemStack(MoChickens.tamingDisc), new Object[] { " T ", "LCR", " B ", 'T', MoChickens.lapisStick, 'L', MoChickens.quartzStick, 'R', MoChickens.goldStick, 'B', MoChickens.coalStick, 'C', MoChickens.innerTamingDisc});
        GameRegistry.addRecipe(new ItemStack(MoChickens.tamingDisc), new Object[] { " T ", "LCR", " B ", 'T', MoChickens.lapisStick, 'L', MoChickens.goldStick, 'R', MoChickens.quartzStick, 'B', MoChickens.coalStick, 'C', MoChickens.innerTamingDisc});
        GameRegistry.addRecipe(new ItemStack(MoChickens.tamingDisc), new Object[] { " T ", "LCR", " B ", 'T', MoChickens.lapisStick, 'L', MoChickens.quartzStick, 'R', MoChickens.coalStick, 'B', MoChickens.goldStick, 'C', MoChickens.innerTamingDisc});
        GameRegistry.addRecipe(new ItemStack(MoChickens.tamingDisc), new Object[] { " T ", "LCR", " B ", 'T', MoChickens.lapisStick, 'L', MoChickens.coalStick, 'R', MoChickens.quartzStick, 'B', MoChickens.goldStick, 'C', MoChickens.innerTamingDisc});
        //disk quartz top
        GameRegistry.addRecipe(new ItemStack(MoChickens.tamingDisc), new Object[] { " T ", "LCR", " B ", 'T', MoChickens.quartzStick, 'L', MoChickens.goldStick, 'R', MoChickens.coalStick, 'B', MoChickens.lapisStick, 'C', MoChickens.innerTamingDisc});
        GameRegistry.addRecipe(new ItemStack(MoChickens.tamingDisc), new Object[] { " T ", "LCR", " B ", 'T', MoChickens.quartzStick, 'L', MoChickens.coalStick, 'R', MoChickens.goldStick, 'B', MoChickens.lapisStick, 'C', MoChickens.innerTamingDisc});
        GameRegistry.addRecipe(new ItemStack(MoChickens.tamingDisc), new Object[] { " T ", "LCR", " B ", 'T', MoChickens.quartzStick, 'L', MoChickens.lapisStick, 'R', MoChickens.goldStick, 'B', MoChickens.coalStick, 'C', MoChickens.innerTamingDisc});
        GameRegistry.addRecipe(new ItemStack(MoChickens.tamingDisc), new Object[] { " T ", "LCR", " B ", 'T', MoChickens.quartzStick, 'L', MoChickens.goldStick, 'R', MoChickens.lapisStick, 'B', MoChickens.coalStick, 'C', MoChickens.innerTamingDisc});
        GameRegistry.addRecipe(new ItemStack(MoChickens.tamingDisc), new Object[] { " T ", "LCR", " B ", 'T', MoChickens.quartzStick, 'L', MoChickens.lapisStick, 'R', MoChickens.coalStick, 'B', MoChickens.goldStick, 'C', MoChickens.innerTamingDisc});
        GameRegistry.addRecipe(new ItemStack(MoChickens.tamingDisc), new Object[] { " T ", "LCR", " B ", 'T', MoChickens.quartzStick, 'L', MoChickens.coalStick, 'R', MoChickens.lapisStick, 'B', MoChickens.goldStick, 'C', MoChickens.innerTamingDisc});
    }
}
