package com.KanasakiTechnologics.CreateAssembly.datagen.create;

import com.KanasakiTechnologics.CreateAssembly.CreateAssembly;
import com.KanasakiTechnologics.CreateAssembly.item.AsmItems;
import com.simibubi.create.api.data.recipe.PressingRecipeGen;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings("unused")
public final class AsmPressingRecipeProvider extends PressingRecipeGen {
    public AsmPressingRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CreateAssembly.MOD_ID);
    }

    GeneratedRecipe LAPIS_SHEET = create(() -> AsmItems.LAPIS_ALLOY,b->b.output(AsmItems.LAPIS_SHEET));
    GeneratedRecipe TIN_SHEET = create(() -> AsmItems.TIN_SHEET,b->b.output(AsmItems.TIN_SHEET));
    GeneratedRecipe CREATIVE_ALLOY = create(() -> AsmItems.CREATIVE_ALLOY,b->b.output(AsmItems.CREATIVE_SHEET));

}
