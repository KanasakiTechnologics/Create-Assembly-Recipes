package com.KanasakiTechnologics.CreateAssembly.compat.jei;

import com.KanasakiTechnologics.CreateAssembly.CreateAssembly;
import com.KanasakiTechnologics.CreateAssembly.compat.jei.category.GlowingCategory;
import com.KanasakiTechnologics.CreateAssembly.content.recipes.AsmRecipeTypes;
import com.KanasakiTechnologics.CreateAssembly.content.recipes.GlowingRecipe;
import com.KanasakiTechnologics.CreateAssembly.item.AsmItems;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.simibubi.create.Create;
import com.simibubi.create.compat.jei.category.CreateRecipeCategory;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.runtime.IJeiRuntime;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeInput;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static mezz.jei.api.recipe.RecipeType.createRecipeHolderType;

@JeiPlugin
@SuppressWarnings("unused")
@ParametersAreNonnullByDefault
public class AsmJEI implements IModPlugin {
    public static final ResourceLocation ID = CreateAssembly.loc("jei_plugin");
    private final List<CreateRecipeCategory<?>> allCategories = new ArrayList<>();
    public static IJeiRuntime runtime;

    private void loadCategories(){
        allCategories.clear();

        CreateRecipeCategory<?> glowing = builder(GlowingRecipe.class)
                .addTypedRecipes(AsmRecipeTypes.GLOWING)
                .catalystStack(getFan("fan_glowing","Fan behind Glow Ink"))
                .doubleItemIcon(AllItems.PROPELLER.get(), AsmItems.GLOW_INK_BUCKET)
                .emptyBackground(178, 72)
                .build("fan_glowing", GlowingCategory::new);
    }


    public static Supplier<ItemStack> getFan(String name, String fullName) {
        var stack = AllBlocks.ENCASED_FAN.asStack();
        stack.set(DataComponents.CUSTOM_NAME, Component.translatableWithFallback(CreateAssembly.MOD_ID + ".recipe." + name + ".fan", fullName).withStyle(style -> style.withItalic(false)));
        return () -> stack;
    }

    private <T extends Recipe<? extends RecipeInput>> CategoryBuilder<T> builder(Class<T> recipeClass) {
        return new CategoryBuilder<>(recipeClass);
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        loadCategories();
        registration.addRecipeCategories(allCategories.toArray(IRecipeCategory[]::new));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        allCategories.forEach(c -> c.registerRecipes(registration));
    }


    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return ID;
    }

    private class CategoryBuilder<T extends Recipe<?>> extends CreateRecipeCategory.Builder<T> {
        public CategoryBuilder(Class<? extends T> recipeClass) {
            super(recipeClass);
        }

        @Override
        public @NotNull CreateRecipeCategory<T> build(ResourceLocation id, CreateRecipeCategory.Factory<T> factory) {
            CreateRecipeCategory<T> category = super.build(id, factory);
            allCategories.add(category);
            return category;
        }
    }

    @Override
    public void onRuntimeAvailable(IJeiRuntime runtime) {
        AsmJEI.runtime = runtime;
    }
}
