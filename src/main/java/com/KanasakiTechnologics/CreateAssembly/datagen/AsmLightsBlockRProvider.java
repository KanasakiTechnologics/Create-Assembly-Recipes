package com.KanasakiTechnologics.CreateAssembly.datagen;

import com.KanasakiTechnologics.CreateAssembly.CreateAssembly;
import com.KanasakiTechnologics.CreateAssembly.block.LightBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class AsmLightsBlockRProvider extends RecipeProvider implements IConditionBuilder {

    public AsmLightsBlockRProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        // Concrete → Light blocks
        concreteLight(recipeOutput, Items.WHITE_CONCRETE, LightBlocks.WHITE_LIGHT_BLOCK.get());
        concreteLight(recipeOutput, Items.LIGHT_GRAY_CONCRETE, LightBlocks.LIGHT_GRAY_LIGHT_BLOCK.get());
        concreteLight(recipeOutput, Items.GRAY_CONCRETE, LightBlocks.GRAY_LIGHT_BLOCK.get());
        concreteLight(recipeOutput, Items.BLACK_CONCRETE, LightBlocks.BLACK_LIGHT_BLOCK.get());
        concreteLight(recipeOutput, Items.BROWN_CONCRETE, LightBlocks.BROWN_LIGHT_BLOCK.get());
        concreteLight(recipeOutput, Items.RED_CONCRETE, LightBlocks.RED_LIGHT_BLOCK.get());
        concreteLight(recipeOutput, Items.ORANGE_CONCRETE, LightBlocks.ORANGE_LIGHT_BLOCK.get());
        concreteLight(recipeOutput, Items.YELLOW_CONCRETE, LightBlocks.YELLOW_LIGHT_BLOCK.get());
        concreteLight(recipeOutput, Items.LIME_CONCRETE, LightBlocks.LIME_LIGHT_BLOCK.get());
        concreteLight(recipeOutput, Items.GREEN_CONCRETE, LightBlocks.GREEN_LIGHT_BLOCK.get());
        concreteLight(recipeOutput, Items.CYAN_CONCRETE, LightBlocks.CYAN_LIGHT_BLOCK.get());
        concreteLight(recipeOutput, Items.LIGHT_BLUE_CONCRETE, LightBlocks.LIGHT_BLUE_LIGHT_BLOCK.get());
        concreteLight(recipeOutput, Items.BLUE_CONCRETE, LightBlocks.BLUE_LIGHT_BLOCK.get());
        concreteLight(recipeOutput, Items.PURPLE_CONCRETE, LightBlocks.PURPLE_LIGHT_BLOCK.get());
        concreteLight(recipeOutput, Items.MAGENTA_CONCRETE, LightBlocks.MAGENTA_LIGHT_BLOCK.get());
        concreteLight(recipeOutput, Items.PINK_CONCRETE, LightBlocks.PINK_LIGHT_BLOCK.get());

        // Stained glass → Light glass blocks
        glassLight(recipeOutput, Items.WHITE_STAINED_GLASS, LightBlocks.WHITE_GLASS_LIGHT_BLOCK.get());
        glassLight(recipeOutput, Items.LIGHT_GRAY_STAINED_GLASS, LightBlocks.LIGHT_GRAY_GLASS_LIGHT_BLOCK.get());
        glassLight(recipeOutput, Items.GRAY_STAINED_GLASS, LightBlocks.GRAY_GLASS_LIGHT_BLOCK.get());
        glassLight(recipeOutput, Items.BLACK_STAINED_GLASS, LightBlocks.BLACK_GLASS_LIGHT_BLOCK.get());
        glassLight(recipeOutput, Items.BROWN_STAINED_GLASS, LightBlocks.BROWN_GLASS_LIGHT_BLOCK.get());
        glassLight(recipeOutput, Items.RED_STAINED_GLASS, LightBlocks.RED_GLASS_LIGHT_BLOCK.get());
        glassLight(recipeOutput, Items.ORANGE_STAINED_GLASS, LightBlocks.ORANGE_GLASS_LIGHT_BLOCK.get());
        glassLight(recipeOutput, Items.YELLOW_STAINED_GLASS, LightBlocks.YELLOW_GLASS_LIGHT_BLOCK.get());
        glassLight(recipeOutput, Items.LIME_STAINED_GLASS, LightBlocks.LIME_GLASS_LIGHT_BLOCK.get());
        glassLight(recipeOutput, Items.GREEN_STAINED_GLASS, LightBlocks.GREEN_GLASS_LIGHT_BLOCK.get());
        glassLight(recipeOutput, Items.CYAN_STAINED_GLASS, LightBlocks.CYAN_GLASS_LIGHT_BLOCK.get());
        glassLight(recipeOutput, Items.LIGHT_BLUE_STAINED_GLASS, LightBlocks.LIGHT_BLUE_GLASS_LIGHT_BLOCK.get());
        glassLight(recipeOutput, Items.BLUE_STAINED_GLASS, LightBlocks.BLUE_GLASS_LIGHT_BLOCK.get());
        glassLight(recipeOutput, Items.PURPLE_STAINED_GLASS, LightBlocks.PURPLE_GLASS_LIGHT_BLOCK.get());
        glassLight(recipeOutput, Items.MAGENTA_STAINED_GLASS, LightBlocks.MAGENTA_GLASS_LIGHT_BLOCK.get());
        glassLight(recipeOutput, Items.PINK_STAINED_GLASS, LightBlocks.PINK_GLASS_LIGHT_BLOCK.get());
    }

    private static void concreteLight(RecipeOutput out, Item concrete, Block result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result)
                .define('G', Items.GLOW_INK_SAC)
                .define('C', concrete)
                .pattern(" G ")
                .pattern("GCG")
                .pattern(" G ")
                .unlockedBy("has_glow_ink", has(Items.GLOW_INK_SAC))
                .save(out, id("light_block", result));
    }

    private static void glassLight(RecipeOutput out, Item glass, Block result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result)
                .define('G', Items.GLOW_INK_SAC)
                .define('X', glass)
                .pattern(" G ")
                .pattern("GXG")
                .pattern(" G ")
                .unlockedBy("has_glow_ink", has(Items.GLOW_INK_SAC))
                .save(out, id("light_glass_block", result));
    }

    private static ResourceLocation id(String folder, Block result) {
        ResourceLocation key = BuiltInRegistries.BLOCK.getKey(result);
        if (key == null) {
            throw new IllegalStateException("Unregistered block: " + result);
        }
        return ResourceLocation.fromNamespaceAndPath(CreateAssembly.MOD_ID, folder + "/" + key.getPath());
    }
}
