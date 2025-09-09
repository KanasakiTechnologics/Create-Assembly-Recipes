package com.KanasakiTechnologics.CreateAssembly.datagen;

import com.KanasakiTechnologics.CreateAssembly.block.AsmBlocks;
import com.KanasakiTechnologics.CreateAssembly.block.LightBlocks;
import com.KanasakiTechnologics.CreateAssembly.item.AsmItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

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

        dropSelf(AsmBlocks.SILVER_BLOCK.get());
        dropSelf(AsmBlocks.RAW_SILVER_BLOCK.get());
        dropSelf(AsmBlocks.TIN_BLOCK.get());
        dropSelf(AsmBlocks.RAW_TIN_BLOCK.get());

        add(AsmBlocks.TIN_ORE.get(),block -> createOreDrop(AsmBlocks.TIN_ORE.get(), AsmItems.RAW_TIN.get()));
        add(AsmBlocks.DEEPSLATE_TIN_ORE.get(),block -> createOreDrop(AsmBlocks.DEEPSLATE_TIN_ORE.get(), AsmItems.RAW_TIN.get()));
        add(AsmBlocks.SILVER_ORE.get(),block -> createOreDrop(AsmBlocks.SILVER_ORE.get(), AsmItems.RAW_SILVER.get()));
        add(AsmBlocks.DEEPSLATE_SILVER_ORE.get(),block -> createOreDrop(AsmBlocks.DEEPSLATE_SILVER_ORE.get(), AsmItems.RAW_SILVER.get()));
        add(AsmBlocks.ENDER_ORE.get(),block -> createMultipleOreDrops(AsmBlocks.ENDER_ORE.get(), AsmItems.ENDER_PEARL_FRAGMENT.get(), 2, 5));
        add(AsmBlocks.SULFUR_ORE.get(),block -> createMultipleOreDrops(AsmBlocks.SULFUR_ORE.get(), AsmItems.SULFUR_CHUNK.get(), 1, 4));
    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return Stream.concat(
                LightBlocks.BLOCKS.getEntries().stream().map(entry -> entry.get()), // LightBlocks
                AsmBlocks.BLOCKS.getEntries().stream().map(entry -> entry.get())    // AsmBlocks
        )::iterator;
    }

}
