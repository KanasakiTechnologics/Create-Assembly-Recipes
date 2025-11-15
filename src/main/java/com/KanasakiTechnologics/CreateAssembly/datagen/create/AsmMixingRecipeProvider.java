package com.KanasakiTechnologics.CreateAssembly.datagen.create;

import com.KanasakiTechnologics.CreateAssembly.CreateAssembly;
import com.KanasakiTechnologics.CreateAssembly.block.AsmBlocks;
import com.KanasakiTechnologics.CreateAssembly.fluid.AsmFluid;
import com.KanasakiTechnologics.CreateAssembly.item.AsmItems;
import com.KanasakiTechnologics.CreateAssembly.util.AsmMods;
import com.KanasakiTechnologics.CreateAssembly.util.AsmTags;
import com.simibubi.create.AllItems;
import com.simibubi.create.api.data.recipe.MixingRecipeGen;
import com.simibubi.create.content.processing.recipe.HeatCondition;
import com.simibubi.create.foundation.data.recipe.CommonMetal;
import com.simibubi.create.foundation.data.recipe.CreateRecipeProvider;
import com.simibubi.create.foundation.data.recipe.Mods;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.NotCondition;
import net.neoforged.neoforge.common.conditions.TagEmptyCondition;
import plus.dragons.createdragonsplus.common.registry.CDPFluids;
import plus.dragons.createenchantmentindustry.common.registry.CEIFluids;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

import static com.simibubi.create.foundation.data.recipe.CommonMetal.*;

@SuppressWarnings("unused")
public final class AsmMixingRecipeProvider extends MixingRecipeGen {
    public AsmMixingRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CreateAssembly.MOD_ID);
    }

    GeneratedRecipe GLOW_INK_FLUID = create("glow_ink_fluid",b -> b.require(Items.GLOW_INK_SAC).require(Fluids.WATER,250).output(AsmFluid.GLOW_INK.get(), 250));
    GeneratedRecipe GLOW_INK_SAC = create("glow_ink_sac",b -> b.requiresHeat(HeatCondition.HEATED).require((FlowingFluid)AsmFluid.GLOW_INK.get(), 250).output(Items.GLOW_INK_SAC));
    GeneratedRecipe HOT_COAL = create("hot_coal",b -> b.requiresHeat(HeatCondition.SUPERHEATED).require(Blocks.COAL_BLOCK).output(AsmBlocks.HOT_COAL));
    GeneratedRecipe AMETHYST_BLOCK = create("amethyst_block",b -> b.require(Items.AMETHYST_SHARD).require(Items.AMETHYST_SHARD).require(Items.AMETHYST_SHARD).require(Fluids.WATER,150).output(Blocks.AMETHYST_BLOCK));
    GeneratedRecipe CHROMATIC_COMPOUND = create("chromatic_compound",b -> b.require(Items.GLOWSTONE_DUST).require(Items.GLOWSTONE_DUST).require(Items.GLOWSTONE_DUST).require(AllItems.POWDERED_OBSIDIAN).require(AllItems.POWDERED_OBSIDIAN).require(AllItems.POWDERED_OBSIDIAN).require(AllItems.POLISHED_ROSE_QUARTZ).requiresHeat(HeatCondition.SUPERHEATED).output(AllItems.CHROMATIC_COMPOUND));
    GeneratedRecipe DIORITE = create("diorite",b -> b.require(Blocks.COBBLESTONE).require(Items.QUARTZ).output(Blocks.DIORITE));
    GeneratedRecipe ECHO_SHARD = create("echo_shard",b -> b.require(Items.AMETHYST_SHARD).require(Blocks.SCULK_CATALYST).output(Items.ECHO_SHARD).output(Blocks.SCULK_CATALYST));
    GeneratedRecipe LAPIS_LAZULI = create("lapis_lazuli",b -> b.require(Items.QUARTZ).require(Items.BLUE_DYE).requiresHeat(HeatCondition.HEATED).output(Items.LAPIS_LAZULI));
    GeneratedRecipe LAPIS_ALLOY = create("lapis_alloy",b -> b.require(Items.LAPIS_LAZULI).require(Items.LAPIS_LAZULI).require(AsmTags.ItemTags.TIN_NUGGET.tag).require(AsmTags.ItemTags.TIN_NUGGET.tag).output(AsmItems.LAPIS_ALLOY));
    GeneratedRecipe NETHERITE_DUST = create("netherite_dust",b -> b.requiresHeat(HeatCondition.SUPERHEATED).require(AllItems.POWDERED_OBSIDIAN).require(AllItems.CINDER_FLOUR).output(AsmItems.NETHERITE_DUST));
    GeneratedRecipe NETHERACK = create("netherack",b -> b.requiresHeat(HeatCondition.HEATED).require(Tags.Items.STONES).require(Items.NETHER_WART).output(Blocks.NETHERRACK));
    GeneratedRecipe ROOTED_DIRT = create("rooted_dirt",b -> b.require(Blocks.DIRT).require(Items.HANGING_ROOTS).output(Blocks.ROOTED_DIRT));
    GeneratedRecipe TUFF = create("tuff",b -> b.require(Blocks.ANDESITE).require(Blocks.DIORITE).require(Fluids.LAVA,100).output(Blocks.TUFF).output(Blocks.TUFF));
    GeneratedRecipe SOUL_LAVA = create("soul_lava",b -> b.requiresHeat(HeatCondition.SUPERHEATED).require(Fluids.LAVA,1000).require(AsmTags.ItemTags.NETHER_SOUL.tag).require(AsmTags.ItemTags.NETHER_SOUL.tag).require(AsmTags.ItemTags.NETHER_SOUL.tag).require(Items.BLAZE_POWDER).require(Items.BLAZE_POWDER).output(AsmFluid.SOUL_LAVA.get(),500));
    GeneratedRecipe SAP = create("sap",b -> b.requiresHeat(HeatCondition.HEATED).require(AsmItems.SAP_DROP).require(AsmItems.SAP_DROP).require(AsmItems.SAP_DROP).require(AsmItems.SAP_DROP).output(AsmFluid.SAP.get(),100));
    GeneratedRecipe ALCHEMIST_DUST = create("alchemist_dust",b -> b.requiresHeat(HeatCondition.HEATED).require(AllItems.CINDER_FLOUR).require(AllItems.CINDER_FLOUR).require(AllItems.CINDER_FLOUR).require(Items.BLAZE_POWDER).require(Items.BLAZE_POWDER).require(BuiltInRegistries.ITEM.get(AsmMods.ENDERIO.asResource("grains_of_infinity"))).require(BuiltInRegistries.ITEM.get(AsmMods.ENDERIO.asResource("grains_of_infinity"))).require(BuiltInRegistries.ITEM.get(AsmMods.ENDERIO.asResource("grains_of_infinity"))).require(BuiltInRegistries.ITEM.get(AsmMods.ENDERIO.asResource("grains_of_infinity"))).output(AsmItems.ALCHEMIST_DUST,3).whenModLoaded(AsmMods.ENDERIO.getId()));
    GeneratedRecipe FUSED_BLEND = create("fused_blend",b -> b.requiresHeat(HeatCondition.HEATED).require(AllItems.POWDERED_OBSIDIAN).require(AllItems.POWDERED_OBSIDIAN).require(AllItems.CINDER_FLOUR).require(AllItems.CINDER_FLOUR).require(AllItems.CINDER_FLOUR).require(BuiltInRegistries.ITEM.get(AsmMods.ENDERIO.asResource("grains_of_infinity"))).require(BuiltInRegistries.ITEM.get(AsmMods.ENDERIO.asResource("grains_of_infinity"))).require(BuiltInRegistries.ITEM.get(AsmMods.ENDERIO.asResource("grains_of_infinity"))).require(BuiltInRegistries.ITEM.get(AsmMods.ENDERIO.asResource("grains_of_infinity"))).output(AsmItems.FUSED_BLEND,3).whenModLoaded(AsmMods.ENDERIO.getId()));
    GeneratedRecipe PROCESSING_CREATIVE = create("processing_creative",b -> b.requiresHeat(HeatCondition.SUPERHEATED).require(Items.NETHERITE_INGOT).require(Items.CHORUS_FRUIT).require(Items.CHORUS_FRUIT).require(AllItems.REFINED_RADIANCE).require(AllItems.REFINED_RADIANCE).require(AsmItems.FUSED_BLEND).require(AsmItems.FUSED_BLEND).require(CDPFluids.DRAGON_BREATH.get(),500).output(AsmItems.PROCESSING_CREATIVE).whenModLoaded(AsmMods.ENDERIO.getId()));

    GeneratedRecipe IRON_DOUBLE = create("iron_double", b -> b.require((FlowingFluid) AsmFluid.REFINED_RADIANCE.get(),10).require(Items.IRON_INGOT).output(Items.IRON_INGOT,2));
    GeneratedRecipe GOLD_DOUBLE = create("gold_double", b -> b.require((FlowingFluid) AsmFluid.REFINED_RADIANCE.get(),10).require(Items.GOLD_INGOT).output(Items.GOLD_INGOT,2));
    GeneratedRecipe COPPER_DOUBLE = create("copper_double", b -> b.require((FlowingFluid) AsmFluid.REFINED_RADIANCE.get(),10).require(Items.COPPER_INGOT).output(Items.COPPER_INGOT,2));
    GeneratedRecipe ZINC_DOUBLE = create("zinc_double", b -> b.require((FlowingFluid) AsmFluid.REFINED_RADIANCE.get(),10).require(AllItems.ZINC_INGOT).output(AllItems.ZINC_INGOT,2));
    GeneratedRecipe TIN_DOUBLE_ASM = create("tin_double_asm", b -> b.require((FlowingFluid) AsmFluid.REFINED_RADIANCE.get(),10).require(AsmItems.TIN_INGOT).output(AsmItems.TIN_INGOT,2));
    GeneratedRecipe SILVER_DOUBLE = create("silver_double", b -> b.require((FlowingFluid) AsmFluid.REFINED_RADIANCE.get(),10).require(AsmItems.SILVER_INGOT).output(AsmItems.SILVER_INGOT,2));

    GeneratedRecipe WET_SPONGE = create("wet_sponge", b -> b.require(Ingredient.of(ItemTags.WOOL)).require(Blocks.DRIED_KELP_BLOCK).require(Fluids.WATER,500).output(Items.WET_SPONGE,2));
    GeneratedRecipe OBSIDIAN = create("obsidian", b -> b.require(Items.BLUE_ICE).require(Fluids.WATER,500).require(Fluids.LAVA,500).output(Items.OBSIDIAN));

    GeneratedRecipe MOLTEN_DUST_REDSTONE = create("molten_dust", b -> b.requiresHeat(HeatCondition.HEATED).require(Fluids.WATER,50).require(Items.REDSTONE).output(AsmFluid.MOLTEN_REDSTONE.get(),100));
    GeneratedRecipe MOLTEN_BLOCK_REDSTONE = create("molten_block", b -> b.requiresHeat(HeatCondition.HEATED).require(Fluids.WATER,450).require(Items.REDSTONE_BLOCK).output(AsmFluid.MOLTEN_REDSTONE.get(),900));
}


