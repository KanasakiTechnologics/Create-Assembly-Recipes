package com.KanasakiTechnologics.CreateAssembly.datagen.create;

import com.KanasakiTechnologics.CreateAssembly.CreateAssembly;
import com.KanasakiTechnologics.CreateAssembly.item.AsmItems;
import com.KanasakiTechnologics.CreateAssembly.util.AsmTags;
import com.simibubi.create.api.data.recipe.PolishingRecipeGen;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.Tags;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings("unused")
public final class AsmPolishingRecipeProvider extends PolishingRecipeGen {
    public AsmPolishingRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CreateAssembly.MOD_ID);

    }
    GeneratedRecipe COAL_ROD = create("coal_rod",b ->b.require(Ingredient.of(ItemTags.COALS)).output(AsmItems.COAL_ROD.get()));
}
