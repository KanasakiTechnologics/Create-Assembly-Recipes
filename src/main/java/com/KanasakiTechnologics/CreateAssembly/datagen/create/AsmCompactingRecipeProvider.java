package com.KanasakiTechnologics.CreateAssembly.datagen.create;

import com.KanasakiTechnologics.CreateAssembly.CreateAssembly;
import com.KanasakiTechnologics.CreateAssembly.block.AsmBlocks;
import com.KanasakiTechnologics.CreateAssembly.fluid.AsmFluid;
import com.KanasakiTechnologics.CreateAssembly.item.AsmItems;
import com.KanasakiTechnologics.CreateAssembly.util.AsmMods;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.simibubi.create.api.data.recipe.CompactingRecipeGen;
import com.simibubi.create.content.decoration.palettes.AllPaletteBlocks;
import com.simibubi.create.content.decoration.palettes.AllPaletteStoneTypes;
import com.simibubi.create.content.processing.recipe.HeatCondition;
import com.simibubi.create.foundation.data.recipe.Mods;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluids;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings("unused")
public final class AsmCompactingRecipeProvider extends CompactingRecipeGen {
    public AsmCompactingRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CreateAssembly.MOD_ID);
    }

    GeneratedRecipe COAL = create("coal_from_charcoal",b -> b.require(Items.CHARCOAL).require(Items.CHARCOAL).require(Items.CHARCOAL).require(Items.CHARCOAL).output(Items.COAL));
    GeneratedRecipe BROWN_MUSHROOM_BLOCK = create("compact_brown_mushroom",b -> b.require(Items.BROWN_MUSHROOM).require(Items.BROWN_MUSHROOM).require(Items.BROWN_MUSHROOM).require(Items.BROWN_MUSHROOM).output(Items.BROWN_MUSHROOM_BLOCK));
    GeneratedRecipe RED_MUSHROOM_BLOCK = create("compact_red_mushroom",b -> b.require(Items.RED_MUSHROOM).require(Items.RED_MUSHROOM).require(Items.RED_MUSHROOM).require(Items.RED_MUSHROOM).output(Items.RED_MUSHROOM_BLOCK));
    GeneratedRecipe COMPRESSED_BLOCK = create("compressed_coal",b -> b.require(AsmBlocks.HOT_COAL).require(AsmBlocks.HOT_COAL).require(AsmBlocks.HOT_COAL).require(AsmBlocks.HOT_COAL).output(AsmBlocks.COMPRESSED_COAL));
    GeneratedRecipe LEATHER = create("leather_from_flesh",b -> b.requiresHeat(HeatCondition.HEATED).require(Items.ROTTEN_FLESH).require(Items.ROTTEN_FLESH).require(Items.ROTTEN_FLESH).require(Items.ROTTEN_FLESH).output(Items.LEATHER));
    GeneratedRecipe SULFUR = create("sulfur",b -> b.require(AsmItems.SULFUR_CHUNK).require(AsmItems.SULFUR_CHUNK).require(AsmItems.SULFUR_CHUNK).require(AsmItems.SULFUR_CHUNK).output(AsmItems.SULFUR));
    GeneratedRecipe CRIMSITE = create("crimsite",b -> b.require(Items.GRAVEL).require(Items.GRAVEL).require(Items.GRAVEL).require(Items.IRON_NUGGET).require(Items.IRON_NUGGET).require(Items.IRON_NUGGET).require(Items.IRON_NUGGET).require(Fluids.LAVA,250).output(AllPaletteStoneTypes.CRIMSITE.getBaseBlock().get()));
    GeneratedRecipe VERIDIUM = create("veridium",b -> b.require(Items.GRAVEL).require(Items.GRAVEL).require(Items.GRAVEL).require(AllItems.COPPER_NUGGET).require(AllItems.COPPER_NUGGET).require(AllItems.COPPER_NUGGET).require(AllItems.COPPER_NUGGET).require(Fluids.LAVA,250).output(AllPaletteStoneTypes.VERIDIUM.getBaseBlock().get()));
    GeneratedRecipe OCHRUM  = create("ochrum",b -> b.require(Items.GRAVEL).require(Items.GRAVEL).require(Items.GRAVEL).require(Items.GOLD_NUGGET).require(Items.GOLD_NUGGET).require(Items.GOLD_NUGGET).require(Items.GOLD_NUGGET).require(Fluids.LAVA,250).output(AllPaletteStoneTypes.OCHRUM.getBaseBlock().get()));
    GeneratedRecipe ASURINE  = create("asurine",b -> b.require(Items.GRAVEL).require(Items.GRAVEL).require(Items.GRAVEL).require(AllItems.ZINC_NUGGET).require(AllItems.ZINC_NUGGET).require(AllItems.ZINC_NUGGET).require(AllItems.ZINC_NUGGET).require(Fluids.LAVA,250).output(AllPaletteStoneTypes.ASURINE.getBaseBlock().get()));
    GeneratedRecipe SLIME  = create("slime",b -> b.require(AsmFluid.SAP.get(),125).output(Items.SLIME_BALL,3));
    GeneratedRecipe RAW_RUBBER  = create("raw_rubber",b -> b.require(AsmFluid.SAP.get(),250).output(AsmItems.RAW_RUBBER));
    GeneratedRecipe COAL_BLOCK  = create("coal_block",b -> b.require(BuiltInRegistries.ITEM.get(Mods.MEK.asResource("block_charcoal"))).require(BuiltInRegistries.ITEM.get(Mods.MEK.asResource("block_charcoal"))).require(BuiltInRegistries.ITEM.get(Mods.MEK.asResource("block_charcoal"))).require(BuiltInRegistries.ITEM.get(Mods.MEK.asResource("block_charcoal"))).output(Blocks.COAL_BLOCK).whenModLoaded(Mods.MEK.getId()));
    GeneratedRecipe SAND = create("sand", b -> b.require(Blocks.SAND).require(Blocks.SAND).require(Blocks.SAND).require(Blocks.SAND).require(Blocks.SAND).require(Blocks.SAND).require(Blocks.SAND).require(Blocks.SAND).require(Blocks.SAND).output(AsmBlocks.COMPRESSED_SAND));
    GeneratedRecipe SOUL_SAND = create("soul_sand", b -> b.require(Blocks.SOUL_SAND).require(Blocks.SOUL_SAND).require(Blocks.SOUL_SAND).require(Blocks.SOUL_SAND).require(Blocks.SOUL_SAND).require(Blocks.SOUL_SAND).require(Blocks.SOUL_SAND).require(Blocks.SOUL_SAND).require(Blocks.SOUL_SAND).output(AsmBlocks.COMPRESSED_SOUL_SAND));
    GeneratedRecipe RED_SAND = create("red_sand", b -> b.require(Blocks.RED_SAND).require(Blocks.RED_SAND).require(Blocks.RED_SAND).require(Blocks.RED_SAND).require(Blocks.RED_SAND).require(Blocks.RED_SAND).require(Blocks.RED_SAND).require(Blocks.RED_SAND).require(Blocks.RED_SAND).output(AsmBlocks.COMPRESSED_RED_SAND));
    GeneratedRecipe COBBLESTONE = create("cobblestone", b -> b.require(Blocks.COBBLESTONE).require(Blocks.COBBLESTONE).require(Blocks.COBBLESTONE).require(Blocks.COBBLESTONE).require(Blocks.COBBLESTONE).require(Blocks.COBBLESTONE).require(Blocks.COBBLESTONE).require(Blocks.COBBLESTONE).require(Blocks.COBBLESTONE).output(AsmBlocks.COMPRESSED_COBBLESTONE));
    GeneratedRecipe COBBLED_DEEPSLATE = create("cobbled_deepslate", b -> b.require(Blocks.COBBLED_DEEPSLATE).require(Blocks.COBBLED_DEEPSLATE).require(Blocks.COBBLED_DEEPSLATE).require(Blocks.COBBLED_DEEPSLATE).require(Blocks.COBBLED_DEEPSLATE).require(Blocks.COBBLED_DEEPSLATE).require(Blocks.COBBLED_DEEPSLATE).require(Blocks.COBBLED_DEEPSLATE).require(Blocks.COBBLED_DEEPSLATE).output(AsmBlocks.COMPRESSED_COBBLED_DEEPSLATE));
}
