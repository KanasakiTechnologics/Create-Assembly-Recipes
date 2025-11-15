package com.KanasakiTechnologics.CreateAssembly.content.recipes;

import com.KanasakiTechnologics.CreateAssembly.CreateAssembly;
import com.mojang.serialization.Codec;
import com.simibubi.create.content.processing.recipe.StandardProcessingRecipe;
import com.simibubi.create.foundation.recipe.IRecipeTypeInfo;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.function.Supplier;

@SuppressWarnings("unused")
public enum AsmRecipeTypes implements IRecipeTypeInfo, StringRepresentable {
    GLOWING(GlowingRecipe::new),
    ENRICHING(EnrichingRecipe::new);

    public final ResourceLocation id;
    public final Supplier<RecipeSerializer<?>> serializerSupplier;
    private final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<?>> serializerObject;
    @Nullable
    private final DeferredHolder<RecipeType<?>, RecipeType<?>> typeObject;
    private final Supplier<RecipeType<?>> type;

    public static final Codec<AsmRecipeTypes> CODEC = StringRepresentable.fromEnum(AsmRecipeTypes::values);

    AsmRecipeTypes(StandardProcessingRecipe.Factory<?> factory) {
        var name = idName(name());
        id = CreateAssembly.loc(name);
        serializerSupplier = () -> new StandardProcessingRecipe.Serializer<>(factory);
        serializerObject = Registers.SERIALIZER_REGISTER.register(name, serializerSupplier);
        typeObject = Registers.TYPE_REGISTER.register(name, () -> RecipeType.simple(id));
        type = typeObject;
    }

    public static void register(IEventBus modEventBus) {
        Registers.SERIALIZER_REGISTER.register(modEventBus);
        Registers.TYPE_REGISTER.register(modEventBus);
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends RecipeSerializer<?>> T getSerializer() {
        return (T) serializerObject.get();
    }

    @SuppressWarnings("unchecked")
    @Override
    public <I extends RecipeInput, R extends Recipe<I>> RecipeType<R> getType() {
        return (RecipeType<R>) type.get();
    }

    public <I extends RecipeInput, R extends Recipe<I>> Optional<RecipeHolder<R>> find(I input, Level level) {
        return level.getRecipeManager().getRecipeFor(getType(), input, level);
    }

    @Override
    public @NotNull String getSerializedName() {
        return id.toString();
    }

    private static String idName(String raw) {
        return raw.toLowerCase();
    }

    private static class Registers {
        private static final DeferredRegister<RecipeSerializer<?>> SERIALIZER_REGISTER =
                DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, CreateAssembly.MOD_ID);
        private static final DeferredRegister<RecipeType<?>> TYPE_REGISTER =
                DeferredRegister.create(Registries.RECIPE_TYPE, CreateAssembly.MOD_ID);
    }
}
