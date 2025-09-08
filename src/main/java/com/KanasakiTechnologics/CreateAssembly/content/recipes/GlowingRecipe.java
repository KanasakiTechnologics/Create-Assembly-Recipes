package com.KanasakiTechnologics.CreateAssembly.content.recipes;

import com.KanasakiTechnologics.CreateAssembly.util.FanRecipe;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeParams;
import com.KanasakiTechnologics.CreateAssembly.content.recipes.AsmRecipeTypes;

public class GlowingRecipe extends FanRecipe {
    public GlowingRecipe(ProcessingRecipeParams params) {
        super(AsmRecipeTypes.GLOWING, params);
    }

}