package com.KanasakiTechnologics.CreateAssembly.datagen.create;

import com.KanasakiTechnologics.CreateAssembly.CreateAssembly;
import com.KanasakiTechnologics.CreateAssembly.block.AsmBlocks;
import com.KanasakiTechnologics.CreateAssembly.item.AsmItems;
import com.KanasakiTechnologics.CreateAssembly.util.AsmTags;
import com.simibubi.create.AllItems;
import com.simibubi.create.api.data.recipe.CrushingRecipeGen;
import com.simibubi.create.content.decoration.palettes.AllPaletteStoneTypes;
import com.simibubi.create.content.kinetics.crusher.CrushingRecipe;
import com.simibubi.create.content.processing.recipe.StandardProcessingRecipe;
import com.simibubi.create.foundation.data.recipe.Mods;
import net.createmod.catnip.lang.Lang;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import static com.simibubi.create.foundation.data.recipe.CommonMetal.SILVER;
import static com.simibubi.create.foundation.data.recipe.CommonMetal.TIN;

@SuppressWarnings("unused")
public final class AsmCrushingRecipeProvider extends CrushingRecipeGen {
    public AsmCrushingRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CreateAssembly.MOD_ID);
    }

    GeneratedRecipe SCORIA = ensMineralRecycling(AllPaletteStoneTypes.SCORIA,b -> b.duration(200).output(.15f,Items.BLAZE_POWDER,2).output(.25f, AsmItems.SULFUR_CHUNK,3));
    GeneratedRecipe CRYING_OBSIDIAN = create(() -> Blocks.CRYING_OBSIDIAN, b -> b.duration(200).output(AllItems.POWDERED_OBSIDIAN).output(.50f,AllItems.POWDERED_OBSIDIAN).output(.25f, Items.AMETHYST_SHARD));
    GeneratedRecipe COMPRESSED_SAND = create(() -> AsmBlocks.COMPRESSED_GRAVEL, b -> b.duration(200).output(AsmBlocks.COMPRESSED_SAND).output(.30f,Items.FLINT,3).output(.45f, Items.CLAY_BALL,4));
    GeneratedRecipe COMPRESSED_GRAVEL = create("compressed_cobblestone", b -> b.require(Ingredient.of(AsmTags.ItemTags.COMPRESSED_COBBLE.tag)).duration(200).output(AsmBlocks.COMPRESSED_GRAVEL));
    GeneratedRecipe LIFE_CORAL = create("life_coral", b -> b.require(Ingredient.of(AsmTags.ItemTags.LIFE_CORALS.tag)).duration(200).output(.25f,Items.NAUTILUS_SHELL));

    GeneratedRecipe TIN_ORE = stoneOre(AsmBlocks.TIN_ORE_ITEM, AllItems.CRUSHED_TIN::get, 1.75f, 250);
    GeneratedRecipe SILVER_ORE = stoneOre(AsmBlocks.SILVER_ORE_ITEM, AllItems.CRUSHED_SILVER::get, 1.75f, 250);
    GeneratedRecipe DEEP_TIN_ORE = deepslateOre(AsmBlocks.DEEPSLATE_TIN_ORE_ITEM, AllItems.CRUSHED_TIN::get, 2.25f, 350);
    GeneratedRecipe DEEP_SILVER_ORE = deepslateOre(AsmBlocks.DEEPSLATE_SILVER_ORE_ITEM, AllItems.CRUSHED_SILVER::get, 2.25f, 350);
    GeneratedRecipe MODDED_TIN_ORE = moddedOre(TIN, AllItems.CRUSHED_TIN::get);
    GeneratedRecipe MODDED_SILVER_ORE = moddedOre(SILVER, AllItems.CRUSHED_SILVER::get);
    GeneratedRecipe RAW_TIN = moddedRawOre(TIN, AllItems.CRUSHED_TIN::get);
    GeneratedRecipe RAW_SILVER = moddedRawOre(SILVER, AllItems.CRUSHED_SILVER::get);
    GeneratedRecipe RAW_TIN_BLOCK = moddedRawOreBlock(TIN, AllItems.CRUSHED_TIN::get);
    GeneratedRecipe RAW_SILVER_BLOCK = moddedRawOreBlock(SILVER, AllItems.CRUSHED_SILVER::get);
    GeneratedRecipe ENDER_FRAGMENT = create(() -> Items.ECHO_SHARD,b -> b.duration(150).output(AsmItems.ENDER_PEARL_FRAGMENT,3).output(0.50f,AsmItems.ENDER_PEARL_FRAGMENT).output(0.75f,AllItems.EXP_NUGGET.get()));



    GeneratedRecipe ensMineralRecycling(AllPaletteStoneTypes type, UnaryOperator<StandardProcessingRecipe.Builder<CrushingRecipe>> transform) {
        create(Lang.asId(type.name()) + "_recycling", b -> transform.apply(b.require(type.materialTag)));
        return create(type.getBaseBlock()::get, b -> transform.apply(b.whenModMissing(Mods.ENS.getId())));
    }
    protected GeneratedRecipe stoneOre(Supplier<ItemLike> ore, Supplier<ItemLike> raw, float expectedAmount,
                                       int duration) {
        return ore(Blocks.COBBLESTONE, ore, raw, expectedAmount, duration);
    }

    protected GeneratedRecipe deepslateOre(Supplier<ItemLike> ore, Supplier<ItemLike> raw, float expectedAmount,
                                           int duration) {
        return ore(Blocks.COBBLED_DEEPSLATE, ore, raw, expectedAmount, duration);
    }


}
