package com.KanasakiTechnologics.CreateAssembly.datagen;

import com.KanasakiTechnologics.CreateAssembly.block.AsmBlocks;
import com.KanasakiTechnologics.CreateAssembly.block.LightBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.Set;
import java.util.stream.Stream;

public class AsmLootTableProvider extends BlockLootSubProvider {
    protected AsmLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(LightBlocks.WHITE_LIGHT_BLOCK.get());
        dropSelf(LightBlocks.LIGHT_GRAY_LIGHT_BLOCK.get());
        dropSelf(LightBlocks.GRAY_LIGHT_BLOCK.get());
        dropSelf(LightBlocks.BLACK_LIGHT_BLOCK.get());
        dropSelf(LightBlocks.BROWN_LIGHT_BLOCK.get());
        dropSelf(LightBlocks.RED_LIGHT_BLOCK.get());
        dropSelf(LightBlocks.ORANGE_LIGHT_BLOCK.get());
        dropSelf(LightBlocks.YELLOW_LIGHT_BLOCK.get());
        dropSelf(LightBlocks.LIME_LIGHT_BLOCK.get());
        dropSelf(LightBlocks.GREEN_LIGHT_BLOCK.get());
        dropSelf(LightBlocks.CYAN_LIGHT_BLOCK.get());
        dropSelf(LightBlocks.LIGHT_BLUE_LIGHT_BLOCK.get());
        dropSelf(LightBlocks.BLUE_LIGHT_BLOCK.get());
        dropSelf(LightBlocks.PURPLE_LIGHT_BLOCK.get());
        dropSelf(LightBlocks.MAGENTA_LIGHT_BLOCK.get());
        dropSelf(LightBlocks.PINK_LIGHT_BLOCK.get());

        dropSelf(LightBlocks.WHITE_GLASS_LIGHT_BLOCK.get());
        dropSelf(LightBlocks.LIGHT_GRAY_GLASS_LIGHT_BLOCK.get());
        dropSelf(LightBlocks.GRAY_GLASS_LIGHT_BLOCK.get());
        dropSelf(LightBlocks.BLACK_GLASS_LIGHT_BLOCK.get());
        dropSelf(LightBlocks.BROWN_GLASS_LIGHT_BLOCK.get());
        dropSelf(LightBlocks.RED_GLASS_LIGHT_BLOCK.get());
        dropSelf(LightBlocks.ORANGE_GLASS_LIGHT_BLOCK.get());
        dropSelf(LightBlocks.YELLOW_GLASS_LIGHT_BLOCK.get());
        dropSelf(LightBlocks.LIME_GLASS_LIGHT_BLOCK.get());
        dropSelf(LightBlocks.GREEN_GLASS_LIGHT_BLOCK.get());
        dropSelf(LightBlocks.CYAN_GLASS_LIGHT_BLOCK.get());
        dropSelf(LightBlocks.LIGHT_BLUE_GLASS_LIGHT_BLOCK.get());
        dropSelf(LightBlocks.BLUE_GLASS_LIGHT_BLOCK.get());
        dropSelf(LightBlocks.PURPLE_GLASS_LIGHT_BLOCK.get());
        dropSelf(LightBlocks.MAGENTA_GLASS_LIGHT_BLOCK.get());
        dropSelf(LightBlocks.PINK_GLASS_LIGHT_BLOCK.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return Stream.concat(
                LightBlocks.BLOCKS.getEntries().stream().map(entry -> entry.get()), // LightBlocks
                AsmBlocks.BLOCKS.getEntries().stream().map(entry -> entry.get())    // AsmBlocks
        )::iterator;
    }

}
