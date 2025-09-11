package com.KanasakiTechnologics.CreateAssembly.datagen.create;

import com.KanasakiTechnologics.CreateAssembly.CreateAssembly;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.simibubi.create.api.data.recipe.ItemApplicationRecipeGen;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings("unused")
public final class AsmItemApplicationRecipeProvider extends ItemApplicationRecipeGen {
    public AsmItemApplicationRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CreateAssembly.MOD_ID);
    }

    GeneratedRecipe SHADOW_STEEL_CASING = create("shadow_casing",b -> b.require(Blocks.OBSIDIAN).require(AllItems.SHADOW_STEEL).output(AllBlocks.SHADOW_STEEL_CASING));
    GeneratedRecipe REFINED_RADIANCE_CASING = create("radiance_casing",b -> b.require(Blocks.OBSIDIAN).require(AllItems.REFINED_RADIANCE).output(AllBlocks.REFINED_RADIANCE_CASING));
    GeneratedRecipe ITEM_VAULT = create("item_vault",b -> b.require(Blocks.CHEST).require(AllItems.IRON_SHEET).output(AllBlocks.ITEM_VAULT));
    GeneratedRecipe FLUID_TANK = create("fluid_tank",b -> b.require(Blocks.CHEST).require(AllItems.COPPER_SHEET).output(AllBlocks.FLUID_TANK));
}
