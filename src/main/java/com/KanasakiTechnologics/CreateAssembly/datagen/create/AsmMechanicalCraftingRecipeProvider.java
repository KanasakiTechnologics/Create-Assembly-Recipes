package com.KanasakiTechnologics.CreateAssembly.datagen.create;

import com.KanasakiTechnologics.CreateAssembly.CreateAssembly;
import com.KanasakiTechnologics.CreateAssembly.item.AsmItems;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.simibubi.create.api.data.recipe.MechanicalCraftingRecipeGen;
import com.simibubi.create.foundation.data.recipe.CreateRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings("unused")
public final class AsmMechanicalCraftingRecipeProvider extends MechanicalCraftingRecipeGen {
    public AsmMechanicalCraftingRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CreateAssembly.MOD_ID);
    }
    GeneratedRecipe INACTIVE_BLAZE_CORE = create(AsmItems.INACTIVE_BLAZE_CORE::get).returns(1)
            .recipe(b -> b
                    .key('B',Ingredient.of(Items.BLAZE_ROD))
                    .key('C',Ingredient.of(AsmItems.ALCHEMIST_DUST))
                    .key('S',Ingredient.of(AllItems.STURDY_SHEET))
                    .key('T',Ingredient.of(Blocks.TINTED_GLASS))
                    .patternLine(" S ")
                    .patternLine("SBS")
                    .patternLine("TCT")
                    .patternLine("SBS")
                    .patternLine(" S "));
}
