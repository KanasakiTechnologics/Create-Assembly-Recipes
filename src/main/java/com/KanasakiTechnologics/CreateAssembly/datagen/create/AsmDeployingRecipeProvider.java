package com.KanasakiTechnologics.CreateAssembly.datagen.create;

import com.KanasakiTechnologics.CreateAssembly.CreateAssembly;
import com.KanasakiTechnologics.CreateAssembly.block.AsmBlocks;
import com.KanasakiTechnologics.CreateAssembly.item.AsmItems;
import com.simibubi.create.api.data.recipe.DeployingRecipeGen;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings("unused")
public final class AsmDeployingRecipeProvider extends DeployingRecipeGen {
    public AsmDeployingRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CreateAssembly.MOD_ID);
    }

    GeneratedRecipe SHADOW_CATALYST = create("shadow_catalyst",b -> b.require(AsmItems.BLANK_CATALYST).require(AsmItems.SHADOW_CATALYST).output(AsmItems.SHADOW_CATALYST));
    GeneratedRecipe RADIANT_CATALYST = create("radiant_catalyst",b -> b.require(AsmItems.BLANK_CATALYST).require(AsmItems.RADIANT_CATALYST).output(AsmItems.RADIANT_CATALYST));
    GeneratedRecipe CREATIVE_ALLOY = create("creative_alloy",b -> b.require(AsmItems.PROCESSING_CREATIVE).require(AsmBlocks.STAR_BLOCK).toolNotConsumed().output(AsmItems.CREATIVE_ALLOY));
    GeneratedRecipe EMERALD = create("emerald",b -> b.require(Items.DIAMOND).require(AsmBlocks.STAR_BLOCK).toolNotConsumed().output(Items.EMERALD));
}
