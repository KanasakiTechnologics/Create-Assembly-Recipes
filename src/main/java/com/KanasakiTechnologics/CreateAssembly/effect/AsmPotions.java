package com.KanasakiTechnologics.CreateAssembly.effect;

import com.KanasakiTechnologics.CreateAssembly.CreateAssembly;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class AsmPotions {
    public static DeferredRegister<Potion> POTIONS = DeferredRegister.create(BuiltInRegistries.POTION, CreateAssembly.MOD_ID);

    public static final Holder<Potion> CLOCKING = POTIONS.register("clocking",
            () -> new Potion(new MobEffectInstance(AsmEffect.CLOAKING,15600,2)));

    public static final Holder<Potion> LONG_CLOCKING = POTIONS.register("long_clocking",
            () -> new Potion(new MobEffectInstance(AsmEffect.CLOAKING,21600,3)));

    public static final Holder<Potion> MASTER_CLOCKING = POTIONS.register("master_clocking",
            () -> new Potion(new MobEffectInstance(AsmEffect.CLOAKING,30000,4)));

    public static final Holder<Potion> WITHER_POTION = POTIONS.register("wither_potion",
            () -> new Potion(new MobEffectInstance(MobEffects.WITHER,900,1)));

    public static void register(IEventBus eventBus){
        POTIONS.register(eventBus);
    }
}
