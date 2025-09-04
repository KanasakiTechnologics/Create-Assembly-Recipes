package com.KanasakiTechnologics.CreateAssembly.datagen;


import com.KanasakiTechnologics.CreateAssembly.CreateAssembly;
import com.KanasakiTechnologics.CreateAssembly.block.AsmBlocks;
import com.KanasakiTechnologics.CreateAssembly.block.LightBlocks;
import com.KanasakiTechnologics.CreateAssembly.block.util.AsmBlockTags;
import com.simibubi.create.AllTags.AllBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
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
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
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
                .add(AsmBlocks.TIN_BLOCK.get())
                .add(AsmBlocks.TIN_ORE.get())
                .add(AsmBlocks.RAW_TIN_BLOCK.get())
                .add(AsmBlocks.SILVER_BLOCK.get())
                .add(AsmBlocks.SILVER_ORE.get())
                .add(AsmBlocks.RAW_SILVER_BLOCK.get())
                .add(AsmBlocks.DEEPSLATE_TIN_ORE.get())
                .add(AsmBlocks.DEEPSLATE_SILVER_ORE.get());

        tag(BlockTags.NEEDS_STONE_TOOL)
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

        tag(AsmBlockTags.CREATE_WRENCH_PICKUP)
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

    }


}
