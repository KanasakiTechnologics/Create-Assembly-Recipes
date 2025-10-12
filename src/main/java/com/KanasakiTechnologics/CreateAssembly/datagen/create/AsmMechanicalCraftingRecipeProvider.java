package com.KanasakiTechnologics.CreateAssembly.datagen.create;

import com.KanasakiTechnologics.CreateAssembly.CreateAssembly;
import com.KanasakiTechnologics.CreateAssembly.item.AsmItems;
import com.mrh0.createaddition.index.CABlocks;
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

    GeneratedRecipe CREATIVE_MOTOR = create(AllBlocks.CREATIVE_MOTOR::get).returns(1)
            .recipe(b -> b
                    .key('S',Ingredient.of(AsmItems.CREATIVE_SHEET))
                    .key('M',Ingredient.of(AsmItems.CREATIVE_MECHANISM))
                    .key('N',Ingredient.of(CABlocks.ELECTRIC_MOTOR))
                    .key('P',Ingredient.of(AllBlocks.ROTATION_SPEED_CONTROLLER))
                    .key('C',Ingredient.of(AsmItems.CREATIVE_ALLOY))
                    .patternLine("SCCCS")
                    .patternLine("SPCPS")
                    .patternLine("SPCPS")
                    .patternLine("SNMNS")
                    .patternLine("SNSNS")
            );
    GeneratedRecipe CREATIVE_CRATE = create(AllBlocks.CREATIVE_CRATE::get).returns(1)
            .recipe(b -> b
                    .key('S',Ingredient.of(AsmItems.CREATIVE_SHEET))
                    .key('C',Ingredient.of(AsmItems.CREATIVE_ALLOY))
                    .key('I',Ingredient.of(AllBlocks.ITEM_VAULT))
                    .key('M',Ingredient.of(AsmItems.CREATIVE_MECHANISM))
                    .patternLine("SCCCS")
                    .patternLine("SIIIS")
                    .patternLine("SIMIS")
                    .patternLine("SIIIS")
                    .patternLine("SCCCS")
            );
    GeneratedRecipe CREATIVE_FLUID_TANK = create(AllBlocks.CREATIVE_FLUID_TANK::get).returns(1)
            .recipe(b -> b
                    .key('S',Ingredient.of(AsmItems.CREATIVE_SHEET))
                    .key('C',Ingredient.of(AsmItems.CREATIVE_ALLOY))
                    .key('F',Ingredient.of(AllBlocks.FLUID_TANK))
                    .key('M',Ingredient.of(AsmItems.CREATIVE_MECHANISM))
                    .patternLine("SCCCS")
                    .patternLine("SFFFS")
                    .patternLine("SFMFS")
                    .patternLine("SFFFS")
                    .patternLine("SCCCS")
            );
    GeneratedRecipe CREATIVE_BLAZE_CAKE = create(AllItems.CREATIVE_BLAZE_CAKE::get).returns(1)
            .recipe(b -> b
                    .key('S',Ingredient.of(AsmItems.CREATIVE_SHEET))
                    .key('C',Ingredient.of(AsmItems.CREATIVE_ALLOY))
                    .key('B',Ingredient.of(AllItems.BLAZE_CAKE))
                    .key('H',Ingredient.of(AsmItems.SUPERHEATED_BLAZE_CORE))
                    .key('M',Ingredient.of(AsmItems.CREATIVE_MECHANISM))
                    .patternLine("SCCCS")
                    .patternLine("SBHBS")
                    .patternLine("SBMBS")
                    .patternLine("SBHBS")
                    .patternLine("SCCCS")
            );
    GeneratedRecipe WORLDSHAPER = create(AllItems.WORLDSHAPER::get).returns(1)
            .recipe(b -> b
                    .key('S',Ingredient.of(AsmItems.CREATIVE_SHEET))
                    .key('C',Ingredient.of(AsmItems.CREATIVE_ALLOY))
                    .key('D',Ingredient.of(AllBlocks.DEPLOYER))
                    .key('M',Ingredient.of(AsmItems.CREATIVE_MECHANISM))
                    .key('L',Ingredient.of(AllBlocks.MECHANICAL_DRILL))
                    .key('O',Ingredient.of(Blocks.OBSIDIAN))
                    .patternLine("SLDLS")
                    .patternLine("  O  ")
                    .patternLine("  M  ")
                    .patternLine("  O  ")
                    .patternLine("  CC ")
            );
    GeneratedRecipe CREATIVE_ENERGY = create(CABlocks.CREATIVE_ENERGY::get).returns(1)
            .recipe(b -> b
                    .key('S',Ingredient.of(AsmItems.CREATIVE_SHEET))
                    .key('C',Ingredient.of(AsmItems.CREATIVE_ALLOY))
                    .key('A',Ingredient.of(CABlocks.ALTERNATOR))
                    .key('M',Ingredient.of(AsmItems.CREATIVE_MECHANISM))
                    .key('B',Ingredient.of(CABlocks.MODULAR_ACCUMULATOR))
                    .patternLine("SCCCS")
                    .patternLine("SAAAS")
                    .patternLine("SAMAS")
                    .patternLine("SABAS")
                    .patternLine("SCCCS")
            );
}
