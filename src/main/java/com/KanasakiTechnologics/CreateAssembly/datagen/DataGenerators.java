package com.KanasakiTechnologics.CreateAssembly.datagen;

import com.KanasakiTechnologics.CreateAssembly.CreateAssembly;
import com.KanasakiTechnologics.CreateAssembly.datagen.create.AsmAdditionRollingRecipeProvider;
import com.KanasakiTechnologics.CreateAssembly.datagen.create.AsmCrushingRecipeProvider;
import com.KanasakiTechnologics.CreateAssembly.datagen.create.AsmPolishingRecipeProvider;
import com.KanasakiTechnologics.CreateAssembly.datagen.create.AsmPressingRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;


@EventBusSubscriber(modid = CreateAssembly.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();


        generator.addProvider(event.includeClient(), new AsmItemModelProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new AsmBlockStateProvider(packOutput, existingFileHelper));


        BlockTagsProvider blockTagsProvider = new AsmBlockTagProvider(packOutput, lookupProvider, existingFileHelper);
        generator.addProvider(event.includeServer(), blockTagsProvider);


        generator.addProvider(event.includeServer(), new AsmFluidTagProvider(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new AsmDatapackProvider(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), new AsmVanillaRecipesProvider(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), new AsmGlowingFanRecipeProvider(packOutput,lookupProvider));
        generator.addProvider(event.includeServer(), new AsmPressingRecipeProvider(packOutput,lookupProvider));
        generator.addProvider(event.includeServer(), new AsmPolishingRecipeProvider(packOutput,lookupProvider));
        generator.addProvider(event.includeServer(), new AsmCrushingRecipeProvider(packOutput,lookupProvider));
        generator.addProvider(event.includeServer(), new AsmAdditionRollingRecipeProvider(packOutput,lookupProvider));

        generator.addProvider(event.includeServer(), new AsmItemTagProvider(packOutput, lookupProvider, blockTagsProvider.contentsGetter(), existingFileHelper));
        generator.addProvider(event.includeServer(), new LootTableProvider(packOutput, Collections.emptySet(), List.of(new LootTableProvider.SubProviderEntry(AsmLootTableProvider::new, LootContextParamSets.BLOCK)), lookupProvider));
    }
}
