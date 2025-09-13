package com.KanasakiTechnologics.CreateAssembly;

import net.neoforged.neoforge.common.ModConfigSpec;

public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();


    public static final ModConfigSpec.BooleanValue HARVEST_ONLY_BEDROCK = BUILDER
            .comment("If true, the Bedrock Breaker will only harvest Bedrock. If false, it can harvest any block.")
            .define("harvest_only_bedrock", false);


    public static final ModConfigSpec SPEC = BUILDER.build();
}
