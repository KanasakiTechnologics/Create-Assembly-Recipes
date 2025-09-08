package com.KanasakiTechnologics.CreateAssembly.datagen;

import com.simibubi.create.api.data.recipe.StandardProcessingRecipeGen;
import com.simibubi.create.content.processing.recipe.StandardProcessingRecipe;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.createmod.catnip.registry.RegisteredObjectsHelper;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public abstract class AsmFanProcessingRecipeGen<R extends StandardProcessingRecipe<?>> extends StandardProcessingRecipeGen<R> {


    public GeneratedRecipe convert(ItemEntry<Item> input, ItemEntry<Item> result) {
        return convert(() -> Ingredient.of(input), result::get, 1);
    }

    public GeneratedRecipe convert(ItemLike input, ItemLike result) {
        return convert(() -> Ingredient.of(input), () -> result, 1);
    }

    public GeneratedRecipe convert(ItemLike input, ItemLike result, int amount) {
        return convert(() -> Ingredient.of(input), () -> result, amount);
    }

    public GeneratedRecipe convert(Supplier<Ingredient> input, Supplier<ItemLike> result, int amount) {
        return create(asResource(getPath(result) + "_from_" + getPath(() -> input.get().getItems()[0].getItem())),
                p -> p.withItemIngredients(input.get())
                        .output(result.get(), amount));
    }


    public static String getPath(Supplier<ItemLike> item) {
        return RegisteredObjectsHelper.getKeyOrThrow(item.get().asItem()).getPath();
    }


    public AsmFanProcessingRecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, String namespace) {
        super(output, registries, namespace);
    }
}