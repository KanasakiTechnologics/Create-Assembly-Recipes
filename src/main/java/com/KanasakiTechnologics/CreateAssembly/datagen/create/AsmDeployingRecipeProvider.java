package com.KanasakiTechnologics.CreateAssembly.datagen.create;

import com.KanasakiTechnologics.CreateAssembly.CreateAssembly;
import com.KanasakiTechnologics.CreateAssembly.item.AsmItems;
import com.simibubi.create.api.data.recipe.DeployingRecipeGen;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings("unused")
public final class AsmDeployingRecipeProvider extends DeployingRecipeGen {
    public AsmDeployingRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CreateAssembly.MOD_ID);
    }

    GeneratedRecipe SHADOW_CATALYST = create("shadow_catalyst",b -> b.require(AsmItems.BLANK_CATALYST).require(AsmItems.SHADOW_CATALYST).output(AsmItems.SHADOW_CATALYST));
    GeneratedRecipe RADIANT_CATALYST = create("radiant_catalyst",b -> b.require(AsmItems.BLANK_CATALYST).require(AsmItems.RADIANT_CATALYST).output(AsmItems.RADIANT_CATALYST));
}
