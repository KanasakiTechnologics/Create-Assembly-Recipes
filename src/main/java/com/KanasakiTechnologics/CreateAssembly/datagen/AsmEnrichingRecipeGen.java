package com.KanasakiTechnologics.CreateAssembly.datagen;

import com.KanasakiTechnologics.CreateAssembly.content.recipes.AsmRecipeTypes;
import com.KanasakiTechnologics.CreateAssembly.content.recipes.EnrichingRecipe;
import com.simibubi.create.api.data.recipe.DatagenMod;
import com.simibubi.create.foundation.recipe.IRecipeTypeInfo;
import net.createmod.catnip.registry.RegisteredObjectsHelper;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class AsmEnrichingRecipeGen extends AsmFanProcessingRecipeGen<EnrichingRecipe> {
    public AsmEnrichingRecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, String namespace) {
        super(output, registries, namespace);
    }

    public GeneratedRecipe convert(ItemLike input, ItemLike result) {
        return convert(() -> Ingredient.of(input), () -> result);
    }

    public GeneratedRecipe convert(Supplier<Ingredient> input, Supplier<ItemLike> result) {
        return create(asResource(RegisteredObjectsHelper.getKeyOrThrow(result.get().asItem()).getPath()),
                p -> p.withItemIngredients(input.get()).output(result.get()));
    }

    protected GeneratedRecipe moddedConversion(DatagenMod mod, String input, String output) {
        return create("compat/" + mod.getId() + "/" + output, p -> p.require(mod, input)
                .output(mod, output)
                .whenModLoaded(mod.getId()));
    }


    @Override
    protected AsmRecipeTypes getRecipeType() {
        return AsmRecipeTypes.ENRICHING;
    }
}
