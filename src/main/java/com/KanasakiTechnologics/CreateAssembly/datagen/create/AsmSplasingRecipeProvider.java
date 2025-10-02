package com.KanasakiTechnologics.CreateAssembly.datagen.create;

import com.KanasakiTechnologics.CreateAssembly.CreateAssembly;
import com.KanasakiTechnologics.CreateAssembly.block.AsmBlocks;
import com.KanasakiTechnologics.CreateAssembly.util.AsmTags;
import com.simibubi.create.api.data.recipe.WashingRecipeGen;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings("unused")
public final class AsmSplasingRecipeProvider extends WashingRecipeGen {
    public AsmSplasingRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CreateAssembly.MOD_ID);
    }

    GeneratedRecipe INK_SAC = create(("ink_sac_from_coal"),b -> b.require(ItemTags.COALS).output(Items.INK_SAC));
    GeneratedRecipe COMPRESSED_GRAVEL = create(() -> AsmBlocks.COMPRESSED_GRAVEL,b -> b.output(.25f, Items.FLINT,3).output(.35f, Items.IRON_NUGGET,9));
    GeneratedRecipe COMPRESSED_SAND = create(() -> AsmBlocks.COMPRESSED_SAND,b -> b.output(.40f, Items.CLAY_BALL, 6));
    GeneratedRecipe COMPRESSED_RED_SAND = create(() -> AsmBlocks.COMPRESSED_RED_SAND,b -> b.output(.35f, Items.GOLD_NUGGET, 9).output(.20f, Items.DEAD_BUSH, 3));
    GeneratedRecipe COMPRESSED_SOUL_SAND = create(() -> AsmBlocks.COMPRESSED_SOUL_SAND,b -> b.output(.35f, Items.QUARTZ, 12).output(.10f, Items.GOLD_NUGGET,3));
}
