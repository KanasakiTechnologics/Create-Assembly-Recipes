package com.KanasakiTechnologics.CreateAssembly.util;

import com.KanasakiTechnologics.CreateAssembly.CreateAssembly;
import com.simibubi.create.api.registry.CreateBuiltInRegistries;
import com.simibubi.create.content.kinetics.fan.processing.FanProcessingType;
import it.unimi.dsi.fastutil.objects.Object2ReferenceOpenHashMap;
import net.minecraft.core.Registry;
import org.jetbrains.annotations.ApiStatus;
public class AsmFanProcessingTypes {
    public static GlowingType GLOWING_TYPE = register("glowing",new GlowingType());
    public static EnrichingType ENRICHING_TYPE = register("enriching",new EnrichingType());

    static {
        Object2ReferenceOpenHashMap<String,FanProcessingType> map = new Object2ReferenceOpenHashMap<>();
        map.put("GLOWING",GLOWING_TYPE);
        map.put("ENRICHING",ENRICHING_TYPE);
        map.trim();
    }


    private static <T extends FanProcessingType> T register(String name, T type) {
        return Registry.register(CreateBuiltInRegistries.FAN_PROCESSING_TYPE, CreateAssembly.loc(name), type);
    }

    @ApiStatus.Internal
    public static void init() {
    }
}
