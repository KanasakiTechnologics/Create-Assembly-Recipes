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
import net.minecraft.tags.ItemTags;
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
        lightBlock(recipeOutput, LightBlocks.WHITE_LIGHT_BLOCK.get());
        lightBlock(recipeOutput, LightBlocks.LIGHT_GRAY_LIGHT_BLOCK.get());
        lightBlock(recipeOutput, LightBlocks.GRAY_LIGHT_BLOCK.get());
        lightBlock(recipeOutput, LightBlocks.BLACK_LIGHT_BLOCK.get());
        lightBlock(recipeOutput, LightBlocks.BROWN_LIGHT_BLOCK.get());
        lightBlock(recipeOutput, LightBlocks.RED_LIGHT_BLOCK.get());
        lightBlock(recipeOutput, LightBlocks.ORANGE_LIGHT_BLOCK.get());
        lightBlock(recipeOutput, LightBlocks.YELLOW_LIGHT_BLOCK.get());
        lightBlock(recipeOutput, LightBlocks.LIME_LIGHT_BLOCK.get());
        lightBlock(recipeOutput, LightBlocks.GREEN_LIGHT_BLOCK.get());
        lightBlock(recipeOutput, LightBlocks.CYAN_LIGHT_BLOCK.get());
        lightBlock(recipeOutput, LightBlocks.LIGHT_BLUE_LIGHT_BLOCK.get());
        lightBlock(recipeOutput, LightBlocks.BLUE_LIGHT_BLOCK.get());
        lightBlock(recipeOutput, LightBlocks.PURPLE_LIGHT_BLOCK.get());
        lightBlock(recipeOutput, LightBlocks.MAGENTA_LIGHT_BLOCK.get());
        lightBlock(recipeOutput, LightBlocks.PINK_LIGHT_BLOCK.get());

        lightGlass(recipeOutput, LightBlocks.WHITE_GLASS_LIGHT_BLOCK.get());
        lightGlass(recipeOutput, LightBlocks.LIGHT_GRAY_GLASS_LIGHT_BLOCK.get());
        lightGlass(recipeOutput, LightBlocks.GRAY_GLASS_LIGHT_BLOCK.get());
        lightGlass(recipeOutput, LightBlocks.BLACK_GLASS_LIGHT_BLOCK.get());
        lightGlass(recipeOutput, LightBlocks.BROWN_GLASS_LIGHT_BLOCK.get());
        lightGlass(recipeOutput, LightBlocks.RED_GLASS_LIGHT_BLOCK.get());
        lightGlass(recipeOutput, LightBlocks.ORANGE_GLASS_LIGHT_BLOCK.get());
        lightGlass(recipeOutput, LightBlocks.YELLOW_GLASS_LIGHT_BLOCK.get());
        lightGlass(recipeOutput, LightBlocks.LIME_GLASS_LIGHT_BLOCK.get());
        lightGlass(recipeOutput, LightBlocks.GREEN_GLASS_LIGHT_BLOCK.get());
        lightGlass(recipeOutput, LightBlocks.CYAN_GLASS_LIGHT_BLOCK.get());
        lightGlass(recipeOutput, LightBlocks.LIGHT_BLUE_GLASS_LIGHT_BLOCK.get());
        lightGlass(recipeOutput, LightBlocks.BLUE_GLASS_LIGHT_BLOCK.get());
        lightGlass(recipeOutput, LightBlocks.PURPLE_GLASS_LIGHT_BLOCK.get());
        lightGlass(recipeOutput, LightBlocks.MAGENTA_GLASS_LIGHT_BLOCK.get());
        lightGlass(recipeOutput, LightBlocks.PINK_GLASS_LIGHT_BLOCK.get());
    }

    private static void lightBlock(RecipeOutput out, Block result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result)
                .define('G', Items.GLOW_INK_SAC)
                .define('C', ItemTags.create(ResourceLocation.withDefaultNamespace("concrete"))) // Accepts any concrete
                .pattern(" G ")
                .pattern("GCG")
                .pattern(" G ")
                .unlockedBy("has_glow_ink", has(Items.GLOW_INK_SAC))
                .save(out, id("light_block", result));
    }

    private static void lightGlass(RecipeOutput out, Block result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result)
                .define('G', Items.GLOW_INK_SAC)
                .define('X', ItemTags.create(ResourceLocation.withDefaultNamespace("glass_blocks"))) // Accepts any glass
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
