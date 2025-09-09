package com.KanasakiTechnologics.CreateAssembly.datagen;

import com.KanasakiTechnologics.CreateAssembly.CreateAssembly;
import com.KanasakiTechnologics.CreateAssembly.block.AsmBlocks;
import com.KanasakiTechnologics.CreateAssembly.item.AsmItems;
import com.KanasakiTechnologics.CreateAssembly.util.AsmTags;
import com.simibubi.create.AllItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import java.util.concurrent.CompletableFuture;

public class AsmItemTagProvider extends ItemTagsProvider {


    public AsmItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags,@Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, CreateAssembly.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(AsmTags.ItemTags.COMPLEX_MECHANISM.tag)
                .add(AsmItems.ABSTRUSE_MECHANISM.get())
                .add(AsmItems.CALCULATION_MECHANISM.get())
                .add(AsmItems.INFERNAL_MECHANISM.get())
                .add(AsmItems.INTEGRATED_CIRCUIT.get())
                .add(AsmItems.INTEGRATED_MECHANISM.get())
                .add(AsmItems.KINETIC_MECHANISM.get())
                .add(AllItems.PRECISION_MECHANISM.get())
                .add(AsmItems.SEALED_MECHANISM.get());

        tag(Tags.Items.ORES)
                .add(AsmBlocks.SILVER_ORE.asItem())
                .add(AsmBlocks.TIN_ORE.asItem())
                .add(AsmBlocks.DEEPSLATE_TIN_ORE.asItem())
                .add(AsmBlocks.DEEPSLATE_SILVER_ORE.asItem());

        tag(Tags.Items.INGOTS)
                .add(AsmItems.SILVER_INGOT.get())
                .add(AsmItems.TIN_INGOT.get());
        tag(AsmTags.ItemTags.SILVER_INGOT.tag)
                .add(AsmItems.SILVER_INGOT.get());
        tag(AsmTags.ItemTags.TIN_INGOT.tag)
                .add(AsmItems.TIN_INGOT.get());

        tag(Tags.Items.NUGGETS)
                .add(AsmItems.SILVER_NUGGET.get())
                .add(AsmItems.TIN_NUGGET.get());
        tag(AsmTags.ItemTags.SILVER_NUGGET.tag)
                .add(AsmItems.SILVER_NUGGET.get());
        tag(AsmTags.ItemTags.TIN_NUGGET.tag)
                .add(AsmItems.TIN_NUGGET.get());

        tag(Tags.Items.ORES_IN_GROUND_DEEPSLATE)
                .add(AsmBlocks.DEEPSLATE_SILVER_ORE.asItem())
                .add(AsmBlocks.DEEPSLATE_TIN_ORE.asItem());

        tag(Tags.Items.ORES_IN_GROUND_STONE)
                .add(AsmBlocks.SILVER_ORE.asItem())
                .add(AsmBlocks.TIN_ORE.asItem());

        tag(Tags.Items.RAW_MATERIALS)
                .add(AsmItems.RAW_SILVER.get())
                .add(AsmItems.RAW_TIN.get());
        tag(AsmTags.ItemTags.RAW_TIN2.tag)
                .add(AsmItems.RAW_TIN.get());
        tag(AsmTags.ItemTags.RAW_SILVER2.tag)
                .add(AsmItems.RAW_SILVER.get());

        tag(Tags.Items.STORAGE_BLOCKS)
                .add(AsmBlocks.RAW_SILVER_BLOCK.asItem())
                .add(AsmBlocks.RAW_TIN_BLOCK.asItem())
                .add(AsmBlocks.SILVER_BLOCK.asItem())
                .add(AsmBlocks.TIN_BLOCK.asItem());

        tag(AsmTags.ItemTags.RAW_SILVER.tag)
                .add(AsmBlocks.RAW_SILVER_BLOCK.asItem());
        tag(AsmTags.ItemTags.RAW_TIN.tag)
                .add(AsmBlocks.RAW_TIN_BLOCK.asItem());
        tag(AsmTags.ItemTags.SILVER.tag)
                .add(AsmBlocks.SILVER_BLOCK.asItem());
        tag(AsmTags.ItemTags.TIN.tag)
                .add(AsmBlocks.TIN_BLOCK.asItem());

        tag(AsmTags.ItemTags.TIN_PLATES.tag)
                        .add(AsmItems.TIN_SHEET.get());
        tag(AsmTags.ItemTags.LAPIS_PLATES.tag)
                        .add(AsmItems.LAPIS_SHEET.get());
        tag(AsmTags.ItemTags.PLATES.tag)
                .add(AsmItems.TIN_SHEET.get())
                .add(AsmItems.LAPIS_SHEET.get());

        tag(AsmTags.ItemTags.ENDERIUM_ALLOY.tag)
                .add(AsmItems.ENDERIUM_ROD.get());
        tag(AsmTags.ItemTags.All_METAL.tag)
                .add(AsmItems.ENDERIUM_ROD.get());
        tag(AsmTags.ItemTags.RODS.tag)
                .add(AsmItems.ENDERIUM_ROD.get());

        tag(AsmTags.ItemTags.LIFE_CORALS.tag)
                .add(Blocks.BRAIN_CORAL_BLOCK.asItem())
                .add(Blocks.BUBBLE_CORAL_BLOCK.asItem())
                .add(Blocks.FIRE_CORAL_BLOCK.asItem())
                .add(Blocks.TUBE_CORAL_BLOCK.asItem())
                .add(Blocks.HORN_CORAL_BLOCK.asItem());

        tag(AsmTags.ItemTags.PRISMARINE_BUILDING_BLOCK.tag)
                .add(Blocks.PRISMARINE.asItem())
                .add(Blocks.PRISMARINE_SLAB.asItem())
                .add(Blocks.PRISMARINE_BRICKS.asItem())
                .add(Blocks.PRISMARINE_STAIRS.asItem())
                .add(Blocks.PRISMARINE_BRICK_STAIRS.asItem())
                .add(Blocks.PRISMARINE_BRICK_SLAB.asItem())
                .add(Blocks.DARK_PRISMARINE.asItem())
                .add(Blocks.DARK_PRISMARINE_SLAB.asItem())
                .add(Blocks.DARK_PRISMARINE_STAIRS.asItem());

        tag(AsmTags.ItemTags.ENDER_POWDER.tag)
                .add(AsmItems.ENDER_PEARL_FRAGMENT.get())
                .addOptional(ResourceLocation.fromNamespaceAndPath("enderio", "powdered_ender_pearl"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("ae2", "ender_dust"));

    }
}
