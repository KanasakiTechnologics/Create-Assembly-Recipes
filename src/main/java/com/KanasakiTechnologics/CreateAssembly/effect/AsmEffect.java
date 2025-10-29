package com.KanasakiTechnologics.CreateAssembly.effect;

import com.KanasakiTechnologics.CreateAssembly.CreateAssembly;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class AsmEffect {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, CreateAssembly.MOD_ID);

    public static final DeferredHolder<MobEffect, MobEffect> CLOAKING =
            MOB_EFFECTS.register("cloaking",
                    () -> new CloakingMobEffect(MobEffectCategory.BENEFICIAL, 0x7089A3));

    public static void register(IEventBus bus) {
        MOB_EFFECTS.register(bus);
    }
}
