package com.KanasakiTechnologics.CreateAssembly.datagen;

import com.KanasakiTechnologics.CreateAssembly.CreateAssembly;
import com.KanasakiTechnologics.CreateAssembly.block.AsmBlocks;
import com.KanasakiTechnologics.CreateAssembly.item.AsmItems;
import com.KanasakiTechnologics.CreateAssembly.util.AsmTags;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.simibubi.create.AllTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.minecraft.resources.ResourceLocation;
import org.checkerframework.checker.units.qual.A;
import org.jetbrains.annotations.Nullable;
import java.util.concurrent.CompletableFuture;

public class AsmItemTagProvider extends ItemTagsProvider {


    public AsmItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags,@Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, CreateAssembly.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ItemTags.PICKAXES)
                .add(AsmItems.SHADOW_PICKAXE.get());

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

        tag(AsmTags.ItemTags.GEARBOXES.tag)
                .add(AllItems.VERTICAL_GEARBOX.get())
                .add(AllBlocks.GEARBOX.asItem());

        tag(AsmTags.ItemTags.RADIANCE_CATALYST_REQUIRED.tag)
                .add(AllItems.REFINED_RADIANCE.get());
        tag(AsmTags.ItemTags.SHADOW_CATALYST_REQUIRED.tag)
                .add(AllItems.SHADOW_STEEL.get());

        tag(Tags.Items.INGOTS)
                .add(AsmItems.SILVER_INGOT.get())
                .add(AsmItems.TIN_INGOT.get())
                .add(AllItems.REFINED_RADIANCE.get());
        tag(AsmTags.ItemTags.SILVER_INGOT.tag)
                .add(AsmItems.SILVER_INGOT.get());
        tag(AsmTags.ItemTags.REFINED_RADIANCE2.tag)
                .add(AllItems.REFINED_RADIANCE.get());
        tag(AsmTags.ItemTags.TIN_INGOT.tag)
                .add(AsmItems.TIN_INGOT.get());

        tag(Tags.Items.NUGGETS)
                .add(AsmItems.SILVER_NUGGET.get())
                .add(AsmItems.TIN_NUGGET.get());
        tag(AsmTags.ItemTags.SILVER_NUGGET.tag)
                .add(AsmItems.SILVER_NUGGET.get());
        tag(AsmTags.ItemTags.TIN_NUGGET.tag)
                .add(AsmItems.TIN_NUGGET.get());

        tag(AsmTags.ItemTags.UPRIGHT_ON_BELT.tag)
                .add(AsmItems.INACTIVE_BLAZE_CORE.get())
                .add(AsmItems.BLAZE_CORE.get())
                .add(AsmItems.SUPERHEATED_BLAZE_CORE.get());

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
                .add(AsmBlocks.TIN_BLOCK.asItem())
                .add(AsmBlocks.COMPRESSED_GRAVEL.asItem())
                .add(AsmBlocks.COMPRESSED_SAND.asItem())
                .add(AsmBlocks.COMPRESSED_RED_SAND.asItem())
                .add(AsmBlocks.COMPRESSED_COBBLESTONE.asItem())
                .add(AsmBlocks.COMPRESSED_COBBLED_DEEPSLATE.asItem())
                .add(AsmBlocks.COMPRESSED_SOUL_SAND.asItem())
                .add(AsmBlocks.STAR_BLOCK.asItem());

        tag(AllTags.AllItemTags.BLAZE_BURNER_FUEL_SPECIAL.tag)
                .add(AsmItems.SUPERHEATED_BLAZE_CORE.get());

        tag(AllTags.AllItemTags.BLAZE_BURNER_FUEL_REGULAR.tag)
                .add(AsmItems.BLAZE_CORE.get());

        tag(AsmTags.ItemTags.RAW_SILVER.tag)
                .add(AsmBlocks.RAW_SILVER_BLOCK.asItem());
        tag(AsmTags.ItemTags.RAW_TIN.tag)
                .add(AsmBlocks.RAW_TIN_BLOCK.asItem());
        tag(AsmTags.ItemTags.SILVER.tag)
                .add(AsmBlocks.SILVER_BLOCK.asItem());
        tag(AsmTags.ItemTags.TIN.tag)
                .add(AsmBlocks.TIN_BLOCK.asItem());

        tag(AsmTags.ItemTags.SAND.tag)
                .add(AsmBlocks.COMPRESSED_SAND.asItem());
        tag(AsmTags.ItemTags.RED_SAND.tag)
                .add(AsmBlocks.COMPRESSED_RED_SAND.asItem());
        tag(AsmTags.ItemTags.SOUL_SAND.tag)
                .add(AsmBlocks.COMPRESSED_SOUL_SAND.asItem());
        tag(AsmTags.ItemTags.GRAVEL.tag)
                .add(AsmBlocks.COMPRESSED_GRAVEL.asItem());
        tag(AsmTags.ItemTags.COBBLESTONE.tag)
                .add(AsmBlocks.COMPRESSED_COBBLESTONE.asItem());
        tag(AsmTags.ItemTags.COBBLED_DEEPSLATE.tag)
                .add(AsmBlocks.COMPRESSED_COBBLED_DEEPSLATE.asItem());
        tag(AsmTags.ItemTags.NETHER_STAR.tag)
                .add(AsmBlocks.STAR_BLOCK.asItem());

        tag(AsmTags.ItemTags.COMPRESSED_SAND.tag)
                .add(AsmBlocks.COMPRESSED_SAND.asItem())
                .add(AsmBlocks.COMPRESSED_RED_SAND.asItem());

        tag(AsmTags.ItemTags.COMPRESSED_COBBLESTONE.tag)
                .add(AsmBlocks.COMPRESSED_COBBLESTONE.asItem())
                .add(AsmBlocks.COMPRESSED_COBBLED_DEEPSLATE.asItem());

        tag(AsmTags.ItemTags.TIN_PLATES.tag)
                        .add(AsmItems.TIN_SHEET.get());
        tag(AsmTags.ItemTags.LAPIS_PLATES.tag)
                        .add(AsmItems.LAPIS_SHEET.get());
        tag(AsmTags.ItemTags.PLATES.tag)
                .add(AsmItems.TIN_SHEET.get())
                .add(AsmItems.LAPIS_SHEET.get());

        tag(AsmTags.ItemTags.NETHER_SOUL.tag)
                .add(Blocks.SOUL_SAND.asItem())
                .add(Blocks.SOUL_SOIL.asItem());

        tag(AsmTags.ItemTags.CHROMATIC_REWARDS.tag)
                .add(AllItems.SHADOW_STEEL.get())
                .add(AllItems.REFINED_RADIANCE.get());

        tag(AsmTags.ItemTags.REFINED_RADIANCE.tag)
                .add(AsmItems.RADIANT_HANDLE.get());
        tag(AsmTags.ItemTags.All_METAL.tag)
                .add(AsmItems.RADIANT_HANDLE.get());
        tag(AsmTags.ItemTags.RODS.tag)
                .add(AsmItems.RADIANT_HANDLE.get());

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
