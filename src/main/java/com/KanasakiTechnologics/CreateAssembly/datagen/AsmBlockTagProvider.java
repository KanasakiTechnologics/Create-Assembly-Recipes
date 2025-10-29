package com.KanasakiTechnologics.CreateAssembly.datagen;


import com.KanasakiTechnologics.CreateAssembly.CreateAssembly;
import com.KanasakiTechnologics.CreateAssembly.block.AsmBlocks;
import com.KanasakiTechnologics.CreateAssembly.block.LightBlocks;
import com.KanasakiTechnologics.CreateAssembly.util.AsmTags;
import com.simibubi.create.AllBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class AsmBlockTagProvider extends BlockTagsProvider {


    public AsmBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, CreateAssembly.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(AsmBlocks.COMPRESSED_GRAVEL.get())
                .add(AsmBlocks.COMPRESSED_SAND.get())
                .add(AsmBlocks.COMPRESSED_RED_SAND.get())
                .add(AsmBlocks.COMPRESSED_SOUL_SAND.get());

        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(Blocks.BEDROCK)
                .add(AsmBlocks.STAR_BLOCK.get())
                .add(AsmBlocks.BEDROCK.get())
                .add(AsmBlocks.REINFORCED_GLASS.get())
                .add(LightBlocks.BLACK_GLASS_LIGHT_BLOCK.get())
                .add(LightBlocks.BLUE_GLASS_LIGHT_BLOCK.get())
                .add(LightBlocks.BROWN_GLASS_LIGHT_BLOCK.get())
                .add(LightBlocks.CYAN_GLASS_LIGHT_BLOCK.get())
                .add(LightBlocks.GRAY_GLASS_LIGHT_BLOCK.get())
                .add(LightBlocks.GREEN_GLASS_LIGHT_BLOCK.get())
                .add(LightBlocks.LIGHT_BLUE_GLASS_LIGHT_BLOCK.get())
                .add(LightBlocks.LIGHT_GRAY_GLASS_LIGHT_BLOCK.get())
                .add(LightBlocks.LIME_GLASS_LIGHT_BLOCK.get())
                .add(LightBlocks.MAGENTA_GLASS_LIGHT_BLOCK.get())
                .add(LightBlocks.ORANGE_GLASS_LIGHT_BLOCK.get())
                .add(LightBlocks.PINK_GLASS_LIGHT_BLOCK.get())
                .add(LightBlocks.PURPLE_GLASS_LIGHT_BLOCK.get())
                .add(LightBlocks.RED_GLASS_LIGHT_BLOCK.get())
                .add(LightBlocks.WHITE_GLASS_LIGHT_BLOCK.get())
                .add(LightBlocks.YELLOW_GLASS_LIGHT_BLOCK.get())

                .add(LightBlocks.BLACK_LIGHT_BLOCK.get())
                .add(LightBlocks.BLUE_LIGHT_BLOCK.get())
                .add(LightBlocks.BROWN_LIGHT_BLOCK.get())
                .add(LightBlocks.CYAN_LIGHT_BLOCK.get())
                .add(LightBlocks.GRAY_LIGHT_BLOCK.get())
                .add(LightBlocks.GREEN_LIGHT_BLOCK.get())
                .add(LightBlocks.LIGHT_BLUE_LIGHT_BLOCK.get())
                .add(LightBlocks.LIGHT_GRAY_LIGHT_BLOCK.get())
                .add(LightBlocks.LIME_LIGHT_BLOCK.get())
                .add(LightBlocks.MAGENTA_LIGHT_BLOCK.get())
                .add(LightBlocks.ORANGE_LIGHT_BLOCK.get())
                .add(LightBlocks.PINK_LIGHT_BLOCK.get())
                .add(LightBlocks.PURPLE_LIGHT_BLOCK.get())
                .add(LightBlocks.RED_LIGHT_BLOCK.get())
                .add(LightBlocks.WHITE_LIGHT_BLOCK.get())
                .add(LightBlocks.YELLOW_LIGHT_BLOCK.get())

                .add(AsmBlocks.ENDER_ORE.get())
                .add(AsmBlocks.SULFUR_ORE.get())
                .add(AsmBlocks.TIN_BLOCK.get())
                .add(AsmBlocks.TIN_ORE.get())
                .add(AsmBlocks.RAW_TIN_BLOCK.get())
                .add(AsmBlocks.SILVER_BLOCK.get())
                .add(AsmBlocks.SILVER_ORE.get())
                .add(AsmBlocks.RAW_SILVER_BLOCK.get())
                .add(AsmBlocks.DEEPSLATE_TIN_ORE.get())
                .add(AsmBlocks.DEEPSLATE_SILVER_ORE.get())
                .add(AsmBlocks.HOT_COAL.get())
                .add(AsmBlocks.COMPRESSED_COAL.get())
                .add(AsmBlocks.FUSED_COMPRESSED_COAL.get())
                .add(AsmBlocks.COMPRESSED_COBBLESTONE.get())
                .add(AsmBlocks.COMPRESSED_COBBLED_DEEPSLATE.get())
                .add(AsmBlocks.HOT_COMPRESSED_COAL.get());

        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(AsmBlocks.SULFUR_ORE.get())
                .add(AsmBlocks.HOT_COAL.get())
                .add(AsmBlocks.COMPRESSED_COAL.get())
                .add(AsmBlocks.FUSED_COMPRESSED_COAL.get())
                .add(AsmBlocks.HOT_COMPRESSED_COAL.get())
                .add(AsmBlocks.REINFORCED_GLASS.get())
                .add(LightBlocks.BLACK_GLASS_LIGHT_BLOCK.get())
                .add(LightBlocks.BLUE_GLASS_LIGHT_BLOCK.get())
                .add(LightBlocks.BROWN_GLASS_LIGHT_BLOCK.get())
                .add(LightBlocks.CYAN_GLASS_LIGHT_BLOCK.get())
                .add(LightBlocks.GRAY_GLASS_LIGHT_BLOCK.get())
                .add(LightBlocks.GREEN_GLASS_LIGHT_BLOCK.get())
                .add(LightBlocks.LIGHT_BLUE_GLASS_LIGHT_BLOCK.get())
                .add(LightBlocks.LIGHT_GRAY_GLASS_LIGHT_BLOCK.get())
                .add(LightBlocks.LIME_GLASS_LIGHT_BLOCK.get())
                .add(LightBlocks.MAGENTA_GLASS_LIGHT_BLOCK.get())
                .add(LightBlocks.ORANGE_GLASS_LIGHT_BLOCK.get())
                .add(LightBlocks.PINK_GLASS_LIGHT_BLOCK.get())
                .add(LightBlocks.PURPLE_GLASS_LIGHT_BLOCK.get())
                .add(LightBlocks.RED_GLASS_LIGHT_BLOCK.get())
                .add(LightBlocks.WHITE_GLASS_LIGHT_BLOCK.get())
                .add(LightBlocks.YELLOW_GLASS_LIGHT_BLOCK.get())

                .add(LightBlocks.BLACK_LIGHT_BLOCK.get())
                .add(LightBlocks.BLUE_LIGHT_BLOCK.get())
                .add(LightBlocks.BROWN_LIGHT_BLOCK.get())
                .add(LightBlocks.CYAN_LIGHT_BLOCK.get())
                .add(LightBlocks.GRAY_LIGHT_BLOCK.get())
                .add(LightBlocks.GREEN_LIGHT_BLOCK.get())
                .add(LightBlocks.LIGHT_BLUE_LIGHT_BLOCK.get())
                .add(LightBlocks.LIGHT_GRAY_LIGHT_BLOCK.get())
                .add(LightBlocks.LIME_LIGHT_BLOCK.get())
                .add(LightBlocks.MAGENTA_LIGHT_BLOCK.get())
                .add(LightBlocks.ORANGE_LIGHT_BLOCK.get())
                .add(LightBlocks.PINK_LIGHT_BLOCK.get())
                .add(LightBlocks.PURPLE_LIGHT_BLOCK.get())
                .add(LightBlocks.RED_LIGHT_BLOCK.get())
                .add(LightBlocks.WHITE_LIGHT_BLOCK.get())
                .add(LightBlocks.YELLOW_LIGHT_BLOCK.get());

        tag(AsmTags.BlockTags.COLORED_GLASS.tag)
                .add(Blocks.WHITE_STAINED_GLASS)
                .add(Blocks.ORANGE_STAINED_GLASS)
                .add(Blocks.MAGENTA_STAINED_GLASS)
                .add(Blocks.LIGHT_BLUE_STAINED_GLASS)
                .add(Blocks.YELLOW_STAINED_GLASS)
                .add(Blocks.LIME_STAINED_GLASS)
                .add(Blocks.PINK_STAINED_GLASS)
                .add(Blocks.GRAY_STAINED_GLASS)
                .add(Blocks.LIGHT_GRAY_STAINED_GLASS)
                .add(Blocks.CYAN_STAINED_GLASS)
                .add(Blocks.PURPLE_STAINED_GLASS)
                .add(Blocks.BLUE_STAINED_GLASS)
                .add(Blocks.BROWN_STAINED_GLASS)
                .add(Blocks.GREEN_STAINED_GLASS)
                .add(Blocks.RED_STAINED_GLASS)
                .add(Blocks.BLACK_STAINED_GLASS);

        tag(AsmTags.BlockTags.COLOURED_CONCRETE.tag)
                .add(Blocks.WHITE_CONCRETE)
                .add(Blocks.ORANGE_CONCRETE)
                .add(Blocks.MAGENTA_CONCRETE)
                .add(Blocks.LIGHT_BLUE_CONCRETE)
                .add(Blocks.YELLOW_CONCRETE)
                .add(Blocks.LIME_CONCRETE)
                .add(Blocks.PINK_CONCRETE)
                .add(Blocks.GRAY_CONCRETE)
                .add(Blocks.LIGHT_GRAY_CONCRETE)
                .add(Blocks.CYAN_CONCRETE)
                .add(Blocks.PURPLE_CONCRETE)
                .add(Blocks.BLUE_CONCRETE)
                .add(Blocks.BROWN_CONCRETE)
                .add(Blocks.GREEN_CONCRETE)
                .add(Blocks.RED_CONCRETE)
                .add(Blocks.BLACK_CONCRETE);

        tag(AsmTags.BlockTags.CREATE_WRENCH_PICKUP.tag)
                .add(LightBlocks.BLACK_GLASS_LIGHT_BLOCK.get())
                .add(LightBlocks.BLUE_GLASS_LIGHT_BLOCK.get())
                .add(LightBlocks.BROWN_GLASS_LIGHT_BLOCK.get())
                .add(LightBlocks.CYAN_GLASS_LIGHT_BLOCK.get())
                .add(LightBlocks.GRAY_GLASS_LIGHT_BLOCK.get())
                .add(LightBlocks.GREEN_GLASS_LIGHT_BLOCK.get())
                .add(LightBlocks.LIGHT_BLUE_GLASS_LIGHT_BLOCK.get())
                .add(LightBlocks.LIGHT_GRAY_GLASS_LIGHT_BLOCK.get())
                .add(LightBlocks.LIME_GLASS_LIGHT_BLOCK.get())
                .add(LightBlocks.MAGENTA_GLASS_LIGHT_BLOCK.get())
                .add(LightBlocks.ORANGE_GLASS_LIGHT_BLOCK.get())
                .add(LightBlocks.PINK_GLASS_LIGHT_BLOCK.get())
                .add(LightBlocks.PURPLE_GLASS_LIGHT_BLOCK.get())
                .add(LightBlocks.RED_GLASS_LIGHT_BLOCK.get())
                .add(LightBlocks.WHITE_GLASS_LIGHT_BLOCK.get())
                .add(LightBlocks.YELLOW_GLASS_LIGHT_BLOCK.get())

                .add(AsmBlocks.REINFORCED_GLASS.get())

                .add(LightBlocks.BLACK_LIGHT_BLOCK.get())
                .add(LightBlocks.BLUE_LIGHT_BLOCK.get())
                .add(LightBlocks.BROWN_LIGHT_BLOCK.get())
                .add(LightBlocks.CYAN_LIGHT_BLOCK.get())
                .add(LightBlocks.GRAY_LIGHT_BLOCK.get())
                .add(LightBlocks.GREEN_LIGHT_BLOCK.get())
                .add(LightBlocks.LIGHT_BLUE_LIGHT_BLOCK.get())
                .add(LightBlocks.LIGHT_GRAY_LIGHT_BLOCK.get())
                .add(LightBlocks.LIME_LIGHT_BLOCK.get())
                .add(LightBlocks.MAGENTA_LIGHT_BLOCK.get())
                .add(LightBlocks.ORANGE_LIGHT_BLOCK.get())
                .add(LightBlocks.PINK_LIGHT_BLOCK.get())
                .add(LightBlocks.PURPLE_LIGHT_BLOCK.get())
                .add(LightBlocks.RED_LIGHT_BLOCK.get())
                .add(LightBlocks.WHITE_LIGHT_BLOCK.get())
                .add(LightBlocks.YELLOW_LIGHT_BLOCK.get());

        tag(BlockTags.BEACON_BASE_BLOCKS)
                .add(AsmBlocks.STAR_BLOCK.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(AsmBlocks.ENDER_ORE.get())
                .add(AsmBlocks.TIN_BLOCK.get())
                .add(AsmBlocks.TIN_ORE.get())
                .add(AsmBlocks.RAW_TIN_BLOCK.get())
                .add(AsmBlocks.SILVER_BLOCK.get())
                .add(AsmBlocks.SILVER_ORE.get())
                .add(AsmBlocks.RAW_SILVER_BLOCK.get())
                .add(AsmBlocks.DEEPSLATE_TIN_ORE.get())
                .add(AsmBlocks.DEEPSLATE_SILVER_ORE.get());

        tag(AsmTags.BlockTags.SILVER_ORES.tag)
                .add(AsmBlocks.SILVER_ORE.get())
                .add(AsmBlocks.DEEPSLATE_SILVER_ORE.get());

        tag(AsmTags.BlockTags.TIN_ORES.tag)
                .add(AsmBlocks.TIN_ORE.get())
                .add(AsmBlocks.DEEPSLATE_TIN_ORE.get());

        tag(AsmTags.BlockTags.NETHER_SOUL.tag)
                .add(Blocks.SOUL_SAND)
                .add(Blocks.SOUL_SOIL);

        tag(Tags.Blocks.ORES_IN_GROUND_DEEPSLATE)
                .add(AsmBlocks.DEEPSLATE_SILVER_ORE.get())
                .add(AsmBlocks.DEEPSLATE_TIN_ORE.get());

        tag(Tags.Blocks.ORES_IN_GROUND_STONE)
                .add(AsmBlocks.SILVER_ORE.get())
                .add(AsmBlocks.TIN_ORE.get());

        tag(AsmTags.BlockTags.WITHER_IMMUNE.tag)
                .add(AsmBlocks.REINFORCED_GLASS.get())
                .add(AllBlocks.SHADOW_STEEL_CASING.get());

        tag(AsmTags.BlockTags.EXPLOSION_IMMUNE.tag)
                .add(AsmBlocks.REINFORCED_GLASS.get())
                .add(AllBlocks.SHADOW_STEEL_CASING.get());

        tag(Tags.Blocks.STORAGE_BLOCKS)
                .add(AsmBlocks.RAW_SILVER_BLOCK.get())
                .add(AsmBlocks.RAW_TIN_BLOCK.get())
                .add(AsmBlocks.SILVER_BLOCK.get())
                .add(AsmBlocks.TIN_BLOCK.get())
                .add(AsmBlocks.COMPRESSED_GRAVEL.get())
                .add(AsmBlocks.COMPRESSED_SAND.get())
                .add(AsmBlocks.COMPRESSED_RED_SAND.get())
                .add(AsmBlocks.COMPRESSED_COBBLESTONE.get())
                .add(AsmBlocks.COMPRESSED_COBBLED_DEEPSLATE.get())
                .add(AsmBlocks.COMPRESSED_SOUL_SAND.get())
                .add(AsmBlocks.STAR_BLOCK.get());

        tag(AsmTags.BlockTags.RAW_SILVER.tag)
                .add(AsmBlocks.RAW_SILVER_BLOCK.get());
        tag(AsmTags.BlockTags.RAW_TIN.tag)
                .add(AsmBlocks.RAW_TIN_BLOCK.get());
        tag(AsmTags.BlockTags.SILVER.tag)
                .add(AsmBlocks.SILVER_BLOCK.get());
        tag(AsmTags.BlockTags.TIN.tag)
                .add(AsmBlocks.TIN_BLOCK.get());

        tag(AsmTags.BlockTags.SAND.tag)
                .add(AsmBlocks.COMPRESSED_SAND.get());
        tag(AsmTags.BlockTags.RED_SAND.tag)
                .add(AsmBlocks.COMPRESSED_RED_SAND.get());
        tag(AsmTags.BlockTags.SOUL_SAND.tag)
                .add(AsmBlocks.COMPRESSED_SOUL_SAND.get());
        tag(AsmTags.BlockTags.GRAVEL.tag)
                .add(AsmBlocks.COMPRESSED_GRAVEL.get());
        tag(AsmTags.BlockTags.COBBLESTONE.tag)
                .add(AsmBlocks.COMPRESSED_COBBLESTONE.get());
        tag(AsmTags.BlockTags.COBBLED_DEEPSLATE.tag)
                .add(AsmBlocks.COMPRESSED_COBBLED_DEEPSLATE.get());
        tag(AsmTags.BlockTags.NETHER_STAR.tag)
                .add(AsmBlocks.STAR_BLOCK.get());

        tag(AsmTags.BlockTags.COMPRESSED_SAND.tag)
                .add(AsmBlocks.COMPRESSED_SAND.get())
                .add(AsmBlocks.COMPRESSED_RED_SAND.get());

        tag(AsmTags.BlockTags.COMPRESSED_COBBLESTONE.tag)
                .add(AsmBlocks.COMPRESSED_COBBLESTONE.get())
                .add(AsmBlocks.COMPRESSED_COBBLED_DEEPSLATE.get());

        tag(AsmTags.BlockTags.PRISMARINE_BUILDING_BLOCK.tag)
                .add(Blocks.PRISMARINE)
                .add(Blocks.PRISMARINE_SLAB)
                .add(Blocks.PRISMARINE_BRICKS)
                .add(Blocks.PRISMARINE_STAIRS)
                .add(Blocks.PRISMARINE_BRICK_STAIRS)
                .add(Blocks.PRISMARINE_BRICK_SLAB)
                .add(Blocks.DARK_PRISMARINE)
                .add(Blocks.DARK_PRISMARINE_SLAB)
                .add(Blocks.DARK_PRISMARINE_STAIRS);


        tag(AsmTags.BlockTags.LIFE_CORALS.tag)
                .add(Blocks.BRAIN_CORAL_BLOCK)
                .add(Blocks.BUBBLE_CORAL_BLOCK)
                .add(Blocks.FIRE_CORAL_BLOCK)
                .add(Blocks.TUBE_CORAL_BLOCK)
                .add(Blocks.HORN_CORAL_BLOCK);

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(Blocks.BEDROCK)
                .add(AsmBlocks.STAR_BLOCK.get())
                .add(AsmBlocks.BEDROCK.get());

        tag(AsmTags.BlockTags.NEEDS_SHADOW_TOOL.tag)
                .add(Blocks.BEDROCK)
                .add(AsmBlocks.BEDROCK.get())
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);

        tag(AsmTags.BlockTags.INCORRECT_FOR_SHADOW_TOOL.tag)
                .addTag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
                .remove(AsmTags.BlockTags.NEEDS_SHADOW_TOOL.tag);

        tag(AsmTags.BlockTags.MINEABLE_WITH_SHADOW_MATTOCK.tag)
                .addTag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.MINEABLE_WITH_HOE)
                .addTag(BlockTags.MINEABLE_WITH_SHOVEL);


    }


}
