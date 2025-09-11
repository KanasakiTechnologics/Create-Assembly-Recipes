package com.KanasakiTechnologics.CreateAssembly.datagen;

import com.KanasakiTechnologics.CreateAssembly.block.AsmBlocks;
import com.KanasakiTechnologics.CreateAssembly.block.LightBlocks;
import com.KanasakiTechnologics.CreateAssembly.item.AsmItems;
import com.KanasakiTechnologics.CreateAssembly.util.AsmTags;
import com.simibubi.create.AllItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;


import java.util.List;
import java.util.concurrent.CompletableFuture;

import static com.KanasakiTechnologics.CreateAssembly.CreateAssembly.MOD_ID;

public class AsmVanillaRecipesProvider extends RecipeProvider implements IConditionBuilder {
    List<ItemLike> TIN_SMELTABLES = List.of(AsmItems.RAW_TIN, AsmBlocks.TIN_ORE,AsmBlocks.DEEPSLATE_TIN_ORE);
    List<ItemLike> SILVER_SMELTABLES = List.of(AsmItems.RAW_SILVER, AsmBlocks.SILVER_ORE,AsmBlocks.DEEPSLATE_SILVER_ORE);

    public AsmVanillaRecipesProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.CHEST,4)
                .pattern("LLL")
                .pattern("L L")
                .pattern("LLL")
                .define('L', ItemTags.LOGS)
                .unlockedBy("has_logs",has(ItemTags.LOGS)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,Items.STRING,2)
                .requires(Ingredient.of(ItemTags.LEAVES),3)
                .unlockedBy("has_leaves",has(ItemTags.LEAVES))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, AsmBlocks.RAW_SILVER_BLOCK)
                .requires(Ingredient.of(AsmItems.RAW_SILVER),9)
                .unlockedBy("has_silver",has(AsmItems.RAW_SILVER))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,AsmItems.RAW_SILVER,9)
                .requires(AsmBlocks.RAW_SILVER_BLOCK)
                .unlockedBy("has_silver",has(AsmBlocks.RAW_SILVER_BLOCK))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, AsmBlocks.SILVER_BLOCK)
                .requires(Ingredient.of(AsmItems.SILVER_INGOT),9)
                .unlockedBy("has_silver",has(AsmItems.SILVER_INGOT))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,AsmItems.SILVER_INGOT,9)
                .requires(AsmBlocks.SILVER_BLOCK)
                .unlockedBy("has_silver",has(AsmBlocks.SILVER_BLOCK))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, AsmItems.SILVER_INGOT)
                .requires(Ingredient.of(AsmItems.SILVER_NUGGET),9)
                .unlockedBy("has_silver",has(AsmItems.SILVER_NUGGET))
                .save(recipeOutput,"createassembly:silver_ingot_from_nugget");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,AsmItems.SILVER_NUGGET,9)
                .requires(AsmItems.SILVER_INGOT)
                .unlockedBy("has_silver",has(AsmItems.SILVER_INGOT))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, AsmBlocks.RAW_TIN_BLOCK)
                .requires(Ingredient.of(AsmItems.RAW_TIN),9)
                .unlockedBy("has_tin",has(AsmItems.RAW_TIN))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,AsmItems.RAW_TIN,9)
                .requires(AsmBlocks.RAW_TIN_BLOCK)
                .unlockedBy("has_tin",has(AsmBlocks.RAW_TIN_BLOCK))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, AsmBlocks.TIN_BLOCK)
                .requires(Ingredient.of(AsmItems.TIN_INGOT),9)
                .unlockedBy("has_tin",has(AsmItems.TIN_INGOT))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,AsmItems.TIN_INGOT,9)
                .requires(AsmBlocks.TIN_BLOCK)
                .unlockedBy("has_tin",has(AsmBlocks.TIN_BLOCK))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, AsmItems.TIN_INGOT)
                .requires(Ingredient.of(AsmItems.TIN_NUGGET),9)
                .unlockedBy("has_tin",has(AsmItems.TIN_NUGGET))
                .save(recipeOutput,"createassembly:tin_ingot_from_nugget");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,AsmItems.TIN_NUGGET,9)
                .requires(AsmItems.TIN_INGOT)
                .unlockedBy("has_tin",has(AsmItems.TIN_INGOT))
                .save(recipeOutput);

        oreSmelting(recipeOutput,TIN_SMELTABLES,RecipeCategory.MISC,AsmItems.TIN_INGOT.get(),0.25f,200,"tin");
        oreSmelting(recipeOutput,SILVER_SMELTABLES,RecipeCategory.MISC,AsmItems.SILVER_INGOT.get(),0.25f,200,"silver");
        oreBlasting(recipeOutput,TIN_SMELTABLES,RecipeCategory.MISC,AsmItems.TIN_INGOT.get(),0.50f,100,"tin");
        oreBlasting(recipeOutput,SILVER_SMELTABLES,RecipeCategory.MISC,AsmItems.SILVER_INGOT.get(),0.50f,100,"silver");

        oreRecycling(recipeOutput, AsmTags.commonItemTag("plates/tin"),RecipeCategory.MISC,AsmItems.TIN_INGOT.get(),0.50f,100,"tin");
        oreRecycling(recipeOutput, AsmTags.commonItemTag("plates/brass"),RecipeCategory.MISC,AllItems.BRASS_INGOT.get(),0.50f,100,"brass");
        oreRecycling(recipeOutput, AsmTags.commonItemTag("plates/zinc"),RecipeCategory.MISC,AllItems.ZINC_INGOT.get(),0.50f,100,"zinc");
        oreRecycling(recipeOutput, AsmTags.commonItemTag("plates/lapis"),RecipeCategory.MISC,AsmItems.LAPIS_ALLOY.get(),0.50f,100,"lapis");
        oreRecycling(recipeOutput, AsmTags.commonItemTag("plates/copper"),RecipeCategory.MISC,Items.COPPER_INGOT,0.50f,100,"copper");
        oreRecycling(recipeOutput, AsmTags.commonItemTag("plates/iron"),RecipeCategory.MISC,Items.COPPER_INGOT,0.50f,100,"iron");
        oreRecycling(recipeOutput, ItemTags.LEAVES,RecipeCategory.MISC,AsmItems.SAP.get(),0.25f,100,"sap_leaves");
        oreRecycling(recipeOutput, ItemTags.SAPLINGS,RecipeCategory.MISC,AsmItems.SAP.get(),0.25f,100,"sap_saplings");

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.NETHERRACK),RecipeCategory.MISC,AsmItems.NETHERRACK_SHARD,2).unlockedBy("has_netherrack",has(Blocks.NETHERRACK)).save(recipeOutput);

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

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreRecycling(RecipeOutput recipeOutput, TagKey<Item> inputTag, RecipeCategory category, ItemLike result, float experience, int cookingTime, String group) {
        SimpleCookingRecipeBuilder.generic(Ingredient.of(inputTag),category, result, experience, cookingTime, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new).group(group).unlockedBy("has_" + group, has(inputTag)).save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MOD_ID, getItemName(result) + "_from_blasting_" + group));
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
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, folder + "/" + key.getPath());
    }
}
