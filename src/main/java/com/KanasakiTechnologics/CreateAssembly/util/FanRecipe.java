package com.KanasakiTechnologics.CreateAssembly.util;

import com.KanasakiTechnologics.CreateAssembly.content.recipes.AsmRecipeTypes;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeParams;
import com.simibubi.create.content.processing.recipe.StandardProcessingRecipe;
import com.simibubi.create.foundation.recipe.IRecipeTypeInfo;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;
import plus.dragons.createdragonsplus.common.kinetics.fan.ending.EndingRecipe;

public class FanRecipe extends StandardProcessingRecipe<SingleRecipeInput> {
    public FanRecipe(AsmRecipeTypes recipeTypes, ProcessingRecipeParams params) {
        super(recipeTypes, params);
    }

    @Override
    protected int getMaxInputCount() {
        return 1;
    }

    @Override
    protected int getMaxOutputCount() {
        return 12;
    }

    @Override
    public boolean matches(SingleRecipeInput input, Level level) {
        return getIngredients().getFirst().test(input.item());
    }

    public static StandardProcessingRecipe.Builder<EndingRecipe> builder(ResourceLocation id) {
        return new StandardProcessingRecipe.Builder<>(EndingRecipe::new, id);
    }

}
