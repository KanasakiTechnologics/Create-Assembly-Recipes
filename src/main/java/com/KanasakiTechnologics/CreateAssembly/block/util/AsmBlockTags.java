package com.KanasakiTechnologics.CreateAssembly.block.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class AsmBlockTags {
    public static final TagKey<Block> CREATE_WRENCH_PICKUP = TagKey.create(
            Registries.BLOCK,
            ResourceLocation.fromNamespaceAndPath("create", "wrench_pickup")
    );

    public static final TagKey<Block> NEEDS_NETHERITE_TOOL = TagKey.create(
            Registries.BLOCK,
            ResourceLocation.fromNamespaceAndPath("neoforge", "needs_netherite_tool")
    );
}
