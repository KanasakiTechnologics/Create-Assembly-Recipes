package com.KanasakiTechnologics.CreateAssembly.datagen.create;

import com.KanasakiTechnologics.CreateAssembly.CreateAssembly;
import com.simibubi.create.api.data.recipe.HauntingRecipeGen;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.Tags;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings("unused")
public final class AsmHauntingRecipeProvider extends HauntingRecipeGen {
    public AsmHauntingRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CreateAssembly.MOD_ID);
    }

    GeneratedRecipe ROTTEN_FLESH = convert(() -> Ingredient.of(Tags.Items.FOODS_RAW_MEAT),() -> Items.ROTTEN_FLESH);
    GeneratedRecipe PHANTOM_MEMBRANE = convert(() -> Ingredient.of(Items.FEATHER),() -> Items.PHANTOM_MEMBRANE);
    GeneratedRecipe WITHER_ROSE = convert(() -> Ingredient.of(ItemTags.SMALL_FLOWERS),() -> Items.WITHER_ROSE);

}
