package com.KanasakiTechnologics.CreateAssembly.worldgen;

import com.KanasakiTechnologics.CreateAssembly.CreateAssembly;
import com.KanasakiTechnologics.CreateAssembly.block.AsmBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class AsmConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_SILVER_ORE_KEY = registerKey("silver_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_TIN_ORE_KEY = registerKey("tin_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_ENDER_ORE_KEY = registerKey("ender_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_BEDROCK_KEY = registerKey("bedrock");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_BEDROCK_KEY = registerKey("nether_bedrock");


    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {

        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest bedrockReplaceable = new BlockMatchTest(Blocks.BEDROCK);

        List<OreConfiguration.TargetBlockState> overworldSilverOres = List.of(
                OreConfiguration.target(stoneReplaceables, AsmBlocks.SILVER_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, AsmBlocks.DEEPSLATE_SILVER_ORE.get().defaultBlockState()));

        register(context, OVERWORLD_SILVER_ORE_KEY, Feature.ORE, new OreConfiguration(overworldSilverOres, 9));


        List<OreConfiguration.TargetBlockState>overworldTinOres = List.of(
                OreConfiguration.target(stoneReplaceables, AsmBlocks.TIN_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, AsmBlocks.DEEPSLATE_TIN_ORE.get().defaultBlockState()));

        register(context, OVERWORLD_TIN_ORE_KEY, Feature.ORE, new OreConfiguration(overworldTinOres, 9));
        register(context, OVERWORLD_ENDER_ORE_KEY, Feature.ORE, new OreConfiguration(stoneReplaceables, AsmBlocks.ENDER_ORE.get().defaultBlockState(), 9));

        register(context, OVERWORLD_BEDROCK_KEY, Feature.ORE, new OreConfiguration(bedrockReplaceable, AsmBlocks.BEDROCK.get().defaultBlockState(), 20));
        register(context, NETHER_BEDROCK_KEY, Feature.ORE, new OreConfiguration(bedrockReplaceable, AsmBlocks.BEDROCK.get().defaultBlockState(), 20));

    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(CreateAssembly.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
