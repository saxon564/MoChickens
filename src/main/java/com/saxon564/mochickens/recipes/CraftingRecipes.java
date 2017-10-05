package com.saxon564.mochickens.recipes;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.saxon564.mochickens.MoChickens;

public class CraftingRecipes
{
    public static void CraftingRecipieManager()
    {
        //sticks
        GameRegistry.addRecipe(new ItemStack(MoChickens.disc_stick, 2, 0), new Object[] { "W", "W", 'W', Items.COAL});
        GameRegistry.addRecipe(new ItemStack(MoChickens.disc_stick, 2, 1), new Object[] { "W", "W", 'W', Items.IRON_INGOT});
        GameRegistry.addRecipe(new ItemStack(MoChickens.disc_stick, 2, 2), new Object[] { "W", "W", 'W', Items.GOLD_INGOT});
        GameRegistry.addRecipe(new ItemStack(MoChickens.disc_stick, 2, 4), new Object[] { "W", "W", 'W', new ItemStack((Item) Items.DYE, 1, 4)});
        GameRegistry.addRecipe(new ItemStack(MoChickens.disc_stick, 2, 3), new Object[] { "W", "W", 'W', Items.REDSTONE});
        GameRegistry.addRecipe(new ItemStack(MoChickens.disc_stick, 2, 5), new Object[] { "W", "W", 'W', Items.DIAMOND});
        GameRegistry.addRecipe(new ItemStack(MoChickens.disc_stick, 2, 6), new Object[] { "W", "W", 'W', Items.EMERALD});
        GameRegistry.addRecipe(new ItemStack(MoChickens.disc_stick, 2, 7), new Object[] { "W", "W", 'W', Items.QUARTZ});
        
        // Feather Blocks
        GameRegistry.addRecipe(new ItemStack(MoChickens.feather_block, 2, 0), new Object[] { "WWW", "WWW", "WWW", 'W', Items.FEATHER});
        GameRegistry.addRecipe(new ItemStack(MoChickens.feather_block, 2, 1), new Object[] { "WWW", "WWW", "WWW", 'W', new ItemStack(MoChickens.chicken_feather, 2, 0)});
        GameRegistry.addRecipe(new ItemStack(MoChickens.feather_block, 2, 2), new Object[] { "WWW", "WWW", "WWW", 'W', new ItemStack(MoChickens.chicken_feather, 2, 1)});
        GameRegistry.addRecipe(new ItemStack(MoChickens.feather_block, 2, 3), new Object[] { "WWW", "WWW", "WWW", 'W', new ItemStack(MoChickens.chicken_feather, 2, 2)});
        GameRegistry.addRecipe(new ItemStack(MoChickens.feather_block, 2, 4), new Object[] { "WWW", "WWW", "WWW", 'W', new ItemStack(MoChickens.chicken_feather, 2, 3)});
        GameRegistry.addRecipe(new ItemStack(MoChickens.feather_block, 2, 5), new Object[] { "WWW", "WWW", "WWW", 'W', new ItemStack(MoChickens.chicken_feather, 2, 4)});
        GameRegistry.addRecipe(new ItemStack(MoChickens.feather_block, 2, 6), new Object[] { "WWW", "WWW", "WWW", 'W', new ItemStack(MoChickens.chicken_feather, 2, 5)});
        GameRegistry.addRecipe(new ItemStack(MoChickens.feather_block, 2, 7), new Object[] { "WWW", "WWW", "WWW", 'W', new ItemStack(MoChickens.chicken_feather, 2, 6)});
        GameRegistry.addRecipe(new ItemStack(MoChickens.feather_block, 2, 8), new Object[] { "WWW", "WWW", "WWW", 'W', new ItemStack(MoChickens.chicken_feather, 2, 7)});
        
        // Small Items
        GameRegistry.addRecipe(new ItemStack(MoChickens.chicken_steel), new Object[] { "I ", " C", 'I', Items.IRON_INGOT, 'C', Items.COOKED_CHICKEN});
        
        discs();
    }
    
    public static void discs() {
        //inner disk iron top
        GameRegistry.addRecipe(new ItemStack(MoChickens.inner_taming_disc), new Object[] { " T ", "L R", " B ", 'T', new ItemStack(MoChickens.disc_stick, 2, 1), 'L', new ItemStack(MoChickens.disc_stick, 2, 3), 'R', new ItemStack(MoChickens.disc_stick, 2, 5), 'B', new ItemStack(MoChickens.disc_stick, 2, 6)});
        GameRegistry.addRecipe(new ItemStack(MoChickens.inner_taming_disc), new Object[] { " T ", "L R", " B ", 'T', new ItemStack(MoChickens.disc_stick, 2, 1), 'L', new ItemStack(MoChickens.disc_stick, 2, 5), 'R', new ItemStack(MoChickens.disc_stick, 2, 3), 'B', new ItemStack(MoChickens.disc_stick, 2, 6)});
        GameRegistry.addRecipe(new ItemStack(MoChickens.inner_taming_disc), new Object[] { " T ", "L R", " B ", 'T', new ItemStack(MoChickens.disc_stick, 2, 1), 'L', new ItemStack(MoChickens.disc_stick, 2, 6), 'R', new ItemStack(MoChickens.disc_stick, 2, 3), 'B', new ItemStack(MoChickens.disc_stick, 2, 5)});
        GameRegistry.addRecipe(new ItemStack(MoChickens.inner_taming_disc), new Object[] { " T ", "L R", " B ", 'T', new ItemStack(MoChickens.disc_stick, 2, 1), 'L', new ItemStack(MoChickens.disc_stick, 2, 3), 'R', new ItemStack(MoChickens.disc_stick, 2, 6), 'B', new ItemStack(MoChickens.disc_stick, 2, 5)});
        GameRegistry.addRecipe(new ItemStack(MoChickens.inner_taming_disc), new Object[] { " T ", "L R", " B ", 'T', new ItemStack(MoChickens.disc_stick, 2, 1), 'L', new ItemStack(MoChickens.disc_stick, 2, 6), 'R', new ItemStack(MoChickens.disc_stick, 2, 5), 'B', new ItemStack(MoChickens.disc_stick, 2, 3)});
        GameRegistry.addRecipe(new ItemStack(MoChickens.inner_taming_disc), new Object[] { " T ", "L R", " B ", 'T', new ItemStack(MoChickens.disc_stick, 2, 1), 'L', new ItemStack(MoChickens.disc_stick, 2, 5), 'R', new ItemStack(MoChickens.disc_stick, 2, 6), 'B', new ItemStack(MoChickens.disc_stick, 2, 3)});
        //inner disk redstone top
        GameRegistry.addRecipe(new ItemStack(MoChickens.inner_taming_disc), new Object[] { " T ", "L R", " B ", 'T', new ItemStack(MoChickens.disc_stick, 2, 3), 'L', new ItemStack(MoChickens.disc_stick, 2, 1), 'R', new ItemStack(MoChickens.disc_stick, 2, 5), 'B', new ItemStack(MoChickens.disc_stick, 2, 6)});
        GameRegistry.addRecipe(new ItemStack(MoChickens.inner_taming_disc), new Object[] { " T ", "L R", " B ", 'T', new ItemStack(MoChickens.disc_stick, 2, 3), 'L', new ItemStack(MoChickens.disc_stick, 2, 5), 'R', new ItemStack(MoChickens.disc_stick, 2, 1), 'B', new ItemStack(MoChickens.disc_stick, 2, 6)});
        GameRegistry.addRecipe(new ItemStack(MoChickens.inner_taming_disc), new Object[] { " T ", "L R", " B ", 'T', new ItemStack(MoChickens.disc_stick, 2, 3), 'L', new ItemStack(MoChickens.disc_stick, 2, 6), 'R', new ItemStack(MoChickens.disc_stick, 2, 1), 'B', new ItemStack(MoChickens.disc_stick, 2, 5)});
        GameRegistry.addRecipe(new ItemStack(MoChickens.inner_taming_disc), new Object[] { " T ", "L R", " B ", 'T', new ItemStack(MoChickens.disc_stick, 2, 3), 'L', new ItemStack(MoChickens.disc_stick, 2, 1), 'R', new ItemStack(MoChickens.disc_stick, 2, 6), 'B', new ItemStack(MoChickens.disc_stick, 2, 5)});
        GameRegistry.addRecipe(new ItemStack(MoChickens.inner_taming_disc), new Object[] { " T ", "L R", " B ", 'T', new ItemStack(MoChickens.disc_stick, 2, 3), 'L', new ItemStack(MoChickens.disc_stick, 2, 6), 'R', new ItemStack(MoChickens.disc_stick, 2, 5), 'B', new ItemStack(MoChickens.disc_stick, 2, 1)});
        GameRegistry.addRecipe(new ItemStack(MoChickens.inner_taming_disc), new Object[] { " T ", "L R", " B ", 'T', new ItemStack(MoChickens.disc_stick, 2, 3), 'L', new ItemStack(MoChickens.disc_stick, 2, 5), 'R', new ItemStack(MoChickens.disc_stick, 2, 6), 'B', new ItemStack(MoChickens.disc_stick, 2, 1)});
        //inner disk diamond top
        GameRegistry.addRecipe(new ItemStack(MoChickens.inner_taming_disc), new Object[] { " T ", "L R", " B ", 'T', new ItemStack(MoChickens.disc_stick, 2, 5), 'L', new ItemStack(MoChickens.disc_stick, 2, 1), 'R', new ItemStack(MoChickens.disc_stick, 2, 3), 'B', new ItemStack(MoChickens.disc_stick, 2, 6)});
        GameRegistry.addRecipe(new ItemStack(MoChickens.inner_taming_disc), new Object[] { " T ", "L R", " B ", 'T', new ItemStack(MoChickens.disc_stick, 2, 5), 'L', new ItemStack(MoChickens.disc_stick, 2, 3), 'R', new ItemStack(MoChickens.disc_stick, 2, 1), 'B', new ItemStack(MoChickens.disc_stick, 2, 6)});
        GameRegistry.addRecipe(new ItemStack(MoChickens.inner_taming_disc), new Object[] { " T ", "L R", " B ", 'T', new ItemStack(MoChickens.disc_stick, 2, 5), 'L', new ItemStack(MoChickens.disc_stick, 2, 6), 'R', new ItemStack(MoChickens.disc_stick, 2, 1), 'B', new ItemStack(MoChickens.disc_stick, 2, 3)});
        GameRegistry.addRecipe(new ItemStack(MoChickens.inner_taming_disc), new Object[] { " T ", "L R", " B ", 'T', new ItemStack(MoChickens.disc_stick, 2, 5), 'L', new ItemStack(MoChickens.disc_stick, 2, 1), 'R', new ItemStack(MoChickens.disc_stick, 2, 6), 'B', new ItemStack(MoChickens.disc_stick, 2, 3)});
        GameRegistry.addRecipe(new ItemStack(MoChickens.inner_taming_disc), new Object[] { " T ", "L R", " B ", 'T', new ItemStack(MoChickens.disc_stick, 2, 5), 'L', new ItemStack(MoChickens.disc_stick, 2, 6), 'R', new ItemStack(MoChickens.disc_stick, 2, 3), 'B', new ItemStack(MoChickens.disc_stick, 2, 1)});
        GameRegistry.addRecipe(new ItemStack(MoChickens.inner_taming_disc), new Object[] { " T ", "L R", " B ", 'T', new ItemStack(MoChickens.disc_stick, 2, 5), 'L', new ItemStack(MoChickens.disc_stick, 2, 3), 'R', new ItemStack(MoChickens.disc_stick, 2, 6), 'B', new ItemStack(MoChickens.disc_stick, 2, 1)});
        //inner disk emerald top
        GameRegistry.addRecipe(new ItemStack(MoChickens.inner_taming_disc), new Object[] { " T ", "L R", " B ", 'T', new ItemStack(MoChickens.disc_stick, 2, 6), 'L', new ItemStack(MoChickens.disc_stick, 2, 1), 'R', new ItemStack(MoChickens.disc_stick, 2, 3), 'B', new ItemStack(MoChickens.disc_stick, 2, 5)});
        GameRegistry.addRecipe(new ItemStack(MoChickens.inner_taming_disc), new Object[] { " T ", "L R", " B ", 'T', new ItemStack(MoChickens.disc_stick, 2, 6), 'L', new ItemStack(MoChickens.disc_stick, 2, 3), 'R', new ItemStack(MoChickens.disc_stick, 2, 1), 'B', new ItemStack(MoChickens.disc_stick, 2, 5)});
        GameRegistry.addRecipe(new ItemStack(MoChickens.inner_taming_disc), new Object[] { " T ", "L R", " B ", 'T', new ItemStack(MoChickens.disc_stick, 2, 6), 'L', new ItemStack(MoChickens.disc_stick, 2, 5), 'R', new ItemStack(MoChickens.disc_stick, 2, 1), 'B', new ItemStack(MoChickens.disc_stick, 2, 3)});
        GameRegistry.addRecipe(new ItemStack(MoChickens.inner_taming_disc), new Object[] { " T ", "L R", " B ", 'T', new ItemStack(MoChickens.disc_stick, 2, 6), 'L', new ItemStack(MoChickens.disc_stick, 2, 1), 'R', new ItemStack(MoChickens.disc_stick, 2, 5), 'B', new ItemStack(MoChickens.disc_stick, 2, 3)});
        GameRegistry.addRecipe(new ItemStack(MoChickens.inner_taming_disc), new Object[] { " T ", "L R", " B ", 'T', new ItemStack(MoChickens.disc_stick, 2, 6), 'L', new ItemStack(MoChickens.disc_stick, 2, 5), 'R', new ItemStack(MoChickens.disc_stick, 2, 3), 'B', new ItemStack(MoChickens.disc_stick, 2, 1)});
        GameRegistry.addRecipe(new ItemStack(MoChickens.inner_taming_disc), new Object[] { " T ", "L R", " B ", 'T', new ItemStack(MoChickens.disc_stick, 2, 6), 'L', new ItemStack(MoChickens.disc_stick, 2, 3), 'R', new ItemStack(MoChickens.disc_stick, 2, 5), 'B', new ItemStack(MoChickens.disc_stick, 2, 1)});
        
        
        //disk gold top
        GameRegistry.addRecipe(new ItemStack(MoChickens.taming_disc), new Object[] { " T ", "LCR", " B ", 'T', new ItemStack(MoChickens.disc_stick, 2, 2), 'L', new ItemStack(MoChickens.disc_stick, 2, 0), 'R', new ItemStack(MoChickens.disc_stick, 2, 4), 'B', new ItemStack(MoChickens.disc_stick, 2, 7), 'C', MoChickens.inner_taming_disc});
        GameRegistry.addRecipe(new ItemStack(MoChickens.taming_disc), new Object[] { " T ", "LCR", " B ", 'T', new ItemStack(MoChickens.disc_stick, 2, 2), 'L', new ItemStack(MoChickens.disc_stick, 2, 4), 'R', new ItemStack(MoChickens.disc_stick, 2, 0), 'B', new ItemStack(MoChickens.disc_stick, 2, 7), 'C', MoChickens.inner_taming_disc});
        GameRegistry.addRecipe(new ItemStack(MoChickens.taming_disc), new Object[] { " T ", "LCR", " B ", 'T', new ItemStack(MoChickens.disc_stick, 2, 2), 'L', new ItemStack(MoChickens.disc_stick, 2, 7), 'R', new ItemStack(MoChickens.disc_stick, 2, 0), 'B', new ItemStack(MoChickens.disc_stick, 2, 4), 'C', MoChickens.inner_taming_disc});
        GameRegistry.addRecipe(new ItemStack(MoChickens.taming_disc), new Object[] { " T ", "LCR", " B ", 'T', new ItemStack(MoChickens.disc_stick, 2, 2), 'L', new ItemStack(MoChickens.disc_stick, 2, 0), 'R', new ItemStack(MoChickens.disc_stick, 2, 7), 'B', new ItemStack(MoChickens.disc_stick, 2, 4), 'C', MoChickens.inner_taming_disc});
        GameRegistry.addRecipe(new ItemStack(MoChickens.taming_disc), new Object[] { " T ", "LCR", " B ", 'T', new ItemStack(MoChickens.disc_stick, 2, 2), 'L', new ItemStack(MoChickens.disc_stick, 2, 7), 'R', new ItemStack(MoChickens.disc_stick, 2, 4), 'B', new ItemStack(MoChickens.disc_stick, 2, 0), 'C', MoChickens.inner_taming_disc});
        GameRegistry.addRecipe(new ItemStack(MoChickens.taming_disc), new Object[] { " T ", "LCR", " B ", 'T', new ItemStack(MoChickens.disc_stick, 2, 2), 'L', new ItemStack(MoChickens.disc_stick, 2, 4), 'R', new ItemStack(MoChickens.disc_stick, 2, 7), 'B', new ItemStack(MoChickens.disc_stick, 2, 0), 'C', MoChickens.inner_taming_disc});
        //disk coal top
        GameRegistry.addRecipe(new ItemStack(MoChickens.taming_disc), new Object[] { " T ", "LCR", " B ", 'T', new ItemStack(MoChickens.disc_stick, 2, 0), 'L', new ItemStack(MoChickens.disc_stick, 2, 2), 'R', new ItemStack(MoChickens.disc_stick, 2, 4), 'B', new ItemStack(MoChickens.disc_stick, 2, 7), 'C', MoChickens.inner_taming_disc});
        GameRegistry.addRecipe(new ItemStack(MoChickens.taming_disc), new Object[] { " T ", "LCR", " B ", 'T', new ItemStack(MoChickens.disc_stick, 2, 0), 'L', new ItemStack(MoChickens.disc_stick, 2, 4), 'R', new ItemStack(MoChickens.disc_stick, 2, 2), 'B', new ItemStack(MoChickens.disc_stick, 2, 7), 'C', MoChickens.inner_taming_disc});
        GameRegistry.addRecipe(new ItemStack(MoChickens.taming_disc), new Object[] { " T ", "LCR", " B ", 'T', new ItemStack(MoChickens.disc_stick, 2, 0), 'L', new ItemStack(MoChickens.disc_stick, 2, 7), 'R', new ItemStack(MoChickens.disc_stick, 2, 2), 'B', new ItemStack(MoChickens.disc_stick, 2, 4), 'C', MoChickens.inner_taming_disc});
        GameRegistry.addRecipe(new ItemStack(MoChickens.taming_disc), new Object[] { " T ", "LCR", " B ", 'T', new ItemStack(MoChickens.disc_stick, 2, 0), 'L', new ItemStack(MoChickens.disc_stick, 2, 2), 'R', new ItemStack(MoChickens.disc_stick, 2, 7), 'B', new ItemStack(MoChickens.disc_stick, 2, 4), 'C', MoChickens.inner_taming_disc});
        GameRegistry.addRecipe(new ItemStack(MoChickens.taming_disc), new Object[] { " T ", "LCR", " B ", 'T', new ItemStack(MoChickens.disc_stick, 2, 0), 'L', new ItemStack(MoChickens.disc_stick, 2, 7), 'R', new ItemStack(MoChickens.disc_stick, 2, 4), 'B', new ItemStack(MoChickens.disc_stick, 2, 2), 'C', MoChickens.inner_taming_disc});
        GameRegistry.addRecipe(new ItemStack(MoChickens.taming_disc), new Object[] { " T ", "LCR", " B ", 'T', new ItemStack(MoChickens.disc_stick, 2, 0), 'L', new ItemStack(MoChickens.disc_stick, 2, 4), 'R', new ItemStack(MoChickens.disc_stick, 2, 7), 'B', new ItemStack(MoChickens.disc_stick, 2, 2), 'C', MoChickens.inner_taming_disc});
        //disk lapis top
        GameRegistry.addRecipe(new ItemStack(MoChickens.taming_disc), new Object[] { " T ", "LCR", " B ", 'T', new ItemStack(MoChickens.disc_stick, 2, 4), 'L', new ItemStack(MoChickens.disc_stick, 2, 2), 'R', new ItemStack(MoChickens.disc_stick, 2, 0), 'B', new ItemStack(MoChickens.disc_stick, 2, 7), 'C', MoChickens.inner_taming_disc});
        GameRegistry.addRecipe(new ItemStack(MoChickens.taming_disc), new Object[] { " T ", "LCR", " B ", 'T', new ItemStack(MoChickens.disc_stick, 2, 4), 'L', new ItemStack(MoChickens.disc_stick, 2, 0), 'R', new ItemStack(MoChickens.disc_stick, 2, 2), 'B', new ItemStack(MoChickens.disc_stick, 2, 7), 'C', MoChickens.inner_taming_disc});
        GameRegistry.addRecipe(new ItemStack(MoChickens.taming_disc), new Object[] { " T ", "LCR", " B ", 'T', new ItemStack(MoChickens.disc_stick, 2, 4), 'L', new ItemStack(MoChickens.disc_stick, 2, 7), 'R', new ItemStack(MoChickens.disc_stick, 2, 2), 'B', new ItemStack(MoChickens.disc_stick, 2, 0), 'C', MoChickens.inner_taming_disc});
        GameRegistry.addRecipe(new ItemStack(MoChickens.taming_disc), new Object[] { " T ", "LCR", " B ", 'T', new ItemStack(MoChickens.disc_stick, 2, 4), 'L', new ItemStack(MoChickens.disc_stick, 2, 2), 'R', new ItemStack(MoChickens.disc_stick, 2, 7), 'B', new ItemStack(MoChickens.disc_stick, 2, 0), 'C', MoChickens.inner_taming_disc});
        GameRegistry.addRecipe(new ItemStack(MoChickens.taming_disc), new Object[] { " T ", "LCR", " B ", 'T', new ItemStack(MoChickens.disc_stick, 2, 4), 'L', new ItemStack(MoChickens.disc_stick, 2, 7), 'R', new ItemStack(MoChickens.disc_stick, 2, 0), 'B', new ItemStack(MoChickens.disc_stick, 2, 2), 'C', MoChickens.inner_taming_disc});
        GameRegistry.addRecipe(new ItemStack(MoChickens.taming_disc), new Object[] { " T ", "LCR", " B ", 'T', new ItemStack(MoChickens.disc_stick, 2, 4), 'L', new ItemStack(MoChickens.disc_stick, 2, 0), 'R', new ItemStack(MoChickens.disc_stick, 2, 7), 'B', new ItemStack(MoChickens.disc_stick, 2, 2), 'C', MoChickens.inner_taming_disc});
        //disk quartz top
        GameRegistry.addRecipe(new ItemStack(MoChickens.taming_disc), new Object[] { " T ", "LCR", " B ", 'T', new ItemStack(MoChickens.disc_stick, 2, 7), 'L', new ItemStack(MoChickens.disc_stick, 2, 2), 'R', new ItemStack(MoChickens.disc_stick, 2, 0), 'B', new ItemStack(MoChickens.disc_stick, 2, 4), 'C', MoChickens.inner_taming_disc});
        GameRegistry.addRecipe(new ItemStack(MoChickens.taming_disc), new Object[] { " T ", "LCR", " B ", 'T', new ItemStack(MoChickens.disc_stick, 2, 7), 'L', new ItemStack(MoChickens.disc_stick, 2, 0), 'R', new ItemStack(MoChickens.disc_stick, 2, 2), 'B', new ItemStack(MoChickens.disc_stick, 2, 4), 'C', MoChickens.inner_taming_disc});
        GameRegistry.addRecipe(new ItemStack(MoChickens.taming_disc), new Object[] { " T ", "LCR", " B ", 'T', new ItemStack(MoChickens.disc_stick, 2, 7), 'L', new ItemStack(MoChickens.disc_stick, 2, 4), 'R', new ItemStack(MoChickens.disc_stick, 2, 2), 'B', new ItemStack(MoChickens.disc_stick, 2, 0), 'C', MoChickens.inner_taming_disc});
        GameRegistry.addRecipe(new ItemStack(MoChickens.taming_disc), new Object[] { " T ", "LCR", " B ", 'T', new ItemStack(MoChickens.disc_stick, 2, 7), 'L', new ItemStack(MoChickens.disc_stick, 2, 2), 'R', new ItemStack(MoChickens.disc_stick, 2, 4), 'B', new ItemStack(MoChickens.disc_stick, 2, 0), 'C', MoChickens.inner_taming_disc});
        GameRegistry.addRecipe(new ItemStack(MoChickens.taming_disc), new Object[] { " T ", "LCR", " B ", 'T', new ItemStack(MoChickens.disc_stick, 2, 7), 'L', new ItemStack(MoChickens.disc_stick, 2, 4), 'R', new ItemStack(MoChickens.disc_stick, 2, 0), 'B', new ItemStack(MoChickens.disc_stick, 2, 2), 'C', MoChickens.inner_taming_disc});
        GameRegistry.addRecipe(new ItemStack(MoChickens.taming_disc), new Object[] { " T ", "LCR", " B ", 'T', new ItemStack(MoChickens.disc_stick, 2, 7), 'L', new ItemStack(MoChickens.disc_stick, 2, 0), 'R', new ItemStack(MoChickens.disc_stick, 2, 4), 'B', new ItemStack(MoChickens.disc_stick, 2, 2), 'C', MoChickens.inner_taming_disc});
    }
}
