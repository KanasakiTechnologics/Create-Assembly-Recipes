package com.KanasakiTechnologics.CreateAssembly.datagen.create;

import com.KanasakiTechnologics.CreateAssembly.CreateAssembly;
import com.KanasakiTechnologics.CreateAssembly.fluid.AsmFluid;
import com.simibubi.create.AllItems;
import com.simibubi.create.api.data.recipe.EmptyingRecipeGen;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings("unused")
public final class AsmEmptyingRecipeProvider extends EmptyingRecipeGen {
    public AsmEmptyingRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CreateAssembly.MOD_ID);
    }

    GeneratedRecipe CHROMATIC_RADIANCE = create("chromatic_radiance",b -> b .require(AllItems.REFINED_RADIANCE)
            .output(AsmFluid.REFINED_RADIANCE.get(),100)
            .output(AllItems.CHROMATIC_COMPOUND));

    GeneratedRecipe CHROMATIC_SHADOW = create("chromatic_shadow",b -> b .require(AllItems.SHADOW_STEEL)
            .output(AsmFluid.SHADOW_STEEL.get(),100)
            .output(AllItems.CHROMATIC_COMPOUND));
}
