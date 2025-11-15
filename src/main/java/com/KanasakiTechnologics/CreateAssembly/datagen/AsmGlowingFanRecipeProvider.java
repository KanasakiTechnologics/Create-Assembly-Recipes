package com.KanasakiTechnologics.CreateAssembly.datagen;

import com.KanasakiTechnologics.CreateAssembly.CreateAssembly;
import com.KanasakiTechnologics.CreateAssembly.block.LightBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

import static com.KanasakiTechnologics.CreateAssembly.CreateAssembly.MOD_ID;

@SuppressWarnings("unused")
public class AsmGlowingFanRecipeProvider extends AsmGlowingRecipeGen {

    GeneratedRecipe WHITE_LIGHT_BLOCK = convert(Items.WHITE_CONCRETE, LightBlocks.WHITE_LIGHT_BLOCK);
    GeneratedRecipe LIGHT_GRAY_LIGHT_BLOCK = convert(Items.LIGHT_GRAY_CONCRETE, LightBlocks.LIGHT_GRAY_LIGHT_BLOCK);
    GeneratedRecipe GRAY_LIGHT_BLOCK = convert(Items.GRAY_CONCRETE, LightBlocks.GRAY_LIGHT_BLOCK);
    GeneratedRecipe BLACK_LIGHT_BLOCK = convert(Items.BLACK_CONCRETE, LightBlocks.BLACK_LIGHT_BLOCK);
    GeneratedRecipe BROWN_LIGHT_BLOCK = convert(Items.BROWN_CONCRETE, LightBlocks.BROWN_LIGHT_BLOCK);
    GeneratedRecipe RED_LIGHT_BLOCK = convert(Items.RED_CONCRETE, LightBlocks.RED_LIGHT_BLOCK);
    GeneratedRecipe ORANGE_LIGHT_BLOCK = convert(Items.ORANGE_CONCRETE, LightBlocks.ORANGE_LIGHT_BLOCK);
    GeneratedRecipe YELLOW_LIGHT_BLOCK = convert(Items.YELLOW_CONCRETE, LightBlocks.YELLOW_LIGHT_BLOCK);
    GeneratedRecipe LIME_LIGHT_BLOCK = convert(Items.LIME_CONCRETE, LightBlocks.LIME_LIGHT_BLOCK);
    GeneratedRecipe GREEN_LIGHT_BLOCK = convert(Items.GREEN_CONCRETE, LightBlocks.GREEN_LIGHT_BLOCK);
    GeneratedRecipe CYAN_LIGHT_BLOCK = convert(Items.CYAN_CONCRETE, LightBlocks.CYAN_LIGHT_BLOCK);
    GeneratedRecipe LIGHT_BLUE_LIGHT_BLOCK = convert(Items.LIGHT_BLUE_CONCRETE, LightBlocks.LIGHT_BLUE_LIGHT_BLOCK);
    GeneratedRecipe BLUE_LIGHT_BLOCK = convert(Items.BLUE_CONCRETE, LightBlocks.BLUE_LIGHT_BLOCK);
    GeneratedRecipe PURPLE_LIGHT_BLOCK = convert(Items.PURPLE_CONCRETE, LightBlocks.PURPLE_LIGHT_BLOCK);
    GeneratedRecipe MAGENTA_LIGHT_BLOCK = convert(Items.MAGENTA_CONCRETE, LightBlocks.MAGENTA_LIGHT_BLOCK);
    GeneratedRecipe PINK_LIGHT_BLOCK = convert(Items.PINK_CONCRETE, LightBlocks.PINK_LIGHT_BLOCK);

    GeneratedRecipe WHITE_GLASS_LIGHT_BLOCK = convert(Items.WHITE_STAINED_GLASS, LightBlocks.WHITE_GLASS_LIGHT_BLOCK);
    GeneratedRecipe LIGHT_GRAY_GLASS_LIGHT_BLOCK = convert(Items.LIGHT_GRAY_STAINED_GLASS, LightBlocks.LIGHT_GRAY_GLASS_LIGHT_BLOCK);
    GeneratedRecipe GRAY_GLASS_LIGHT_BLOCK = convert(Items.GRAY_STAINED_GLASS, LightBlocks.GRAY_GLASS_LIGHT_BLOCK);
    GeneratedRecipe BLACK_GLASS_LIGHT_BLOCK = convert(Items.BLACK_STAINED_GLASS, LightBlocks.BLACK_GLASS_LIGHT_BLOCK);
    GeneratedRecipe BROWN_GLASS_LIGHT_BLOCK = convert(Items.BROWN_STAINED_GLASS, LightBlocks.BROWN_GLASS_LIGHT_BLOCK);
    GeneratedRecipe RED_GLASS_LIGHT_BLOCK = convert(Items.RED_STAINED_GLASS, LightBlocks.RED_GLASS_LIGHT_BLOCK);
    GeneratedRecipe ORANGE_GLASS_LIGHT_BLOCK = convert(Items.ORANGE_STAINED_GLASS, LightBlocks.ORANGE_GLASS_LIGHT_BLOCK);
    GeneratedRecipe YELLOW_GLASS_LIGHT_BLOCK = convert(Items.YELLOW_STAINED_GLASS, LightBlocks.YELLOW_GLASS_LIGHT_BLOCK);
    GeneratedRecipe LIME_GLASS_LIGHT_BLOCK = convert(Items.LIME_STAINED_GLASS, LightBlocks.LIME_GLASS_LIGHT_BLOCK);
    GeneratedRecipe GREEN_GLASS_LIGHT_BLOCK = convert(Items.GREEN_STAINED_GLASS, LightBlocks.GREEN_GLASS_LIGHT_BLOCK);
    GeneratedRecipe CYAN_GLASS_LIGHT_BLOCK = convert(Items.CYAN_STAINED_GLASS, LightBlocks.CYAN_GLASS_LIGHT_BLOCK);
    GeneratedRecipe LIGHT_BLUE_GLASS_LIGHT_BLOCK = convert(Items.LIGHT_BLUE_STAINED_GLASS, LightBlocks.LIGHT_BLUE_GLASS_LIGHT_BLOCK);
    GeneratedRecipe BLUE_GLASS_LIGHT_BLOCK = convert(Items.BLUE_STAINED_GLASS, LightBlocks.BLUE_GLASS_LIGHT_BLOCK);
    GeneratedRecipe PURPLE_GLASS_LIGHT_BLOCK = convert(Items.PURPLE_STAINED_GLASS, LightBlocks.PURPLE_GLASS_LIGHT_BLOCK);
    GeneratedRecipe MAGENTA_GLASS_LIGHT_BLOCK = convert(Items.MAGENTA_STAINED_GLASS, LightBlocks.MAGENTA_GLASS_LIGHT_BLOCK);
    GeneratedRecipe PINK_GLASS_LIGHT_BLOCK = convert(Items.PINK_STAINED_GLASS, LightBlocks.PINK_GLASS_LIGHT_BLOCK);

    public AsmGlowingFanRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CreateAssembly.MOD_ID);
    }
}
