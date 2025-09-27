package com.KanasakiTechnologics.CreateAssembly.datagen.create;

import com.KanasakiTechnologics.CreateAssembly.CreateAssembly;
import com.KanasakiTechnologics.CreateAssembly.fluid.AsmFluid;
import com.KanasakiTechnologics.CreateAssembly.util.AsmTags;
import com.mrh0.createaddition.datagen.RecipeGen.LiquidBurningRecipeGen;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.foundation.data.recipe.CreateRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings("unused")
public class AsmFuelBurningRecipeProvider extends LiquidBurningRecipeGen {
    public AsmFuelBurningRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CreateAssembly.MOD_ID);
    }

    GeneratedRecipe SOUL_FUEL = create("lava", (b) -> b.fluid(AsmTags.FluidTags.SOUL_LAVA.tag).burnTime(2400).superheated());

}
