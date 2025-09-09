package com.KanasakiTechnologics.CreateAssembly.fluid;

import com.KanasakiTechnologics.CreateAssembly.CreateAssembly;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class AsmFluidType {
    public static final DeferredRegister<FluidType> FLUID_TYPE = DeferredRegister.create(NeoForgeRegistries.Keys.FLUID_TYPES, CreateAssembly.MOD_ID);;
    public static final DeferredHolder<FluidType, FluidType> GLOW_INK_TYPE = FLUID_TYPE.register("glow_ink_type",
            ()-> new GlowInkFluidType(FluidType.Properties.create().lightLevel(10).viscosity(1000).density(1000).canDrown(false).supportsBoating(true)));
    public static final DeferredHolder<FluidType,FluidType>SULFURIC_ACID_TYPE = FLUID_TYPE.register("sulfuric_acid_type",
            ()-> new SulfuricAcidFluidType(FluidType.Properties.create().density(1000).viscosity(1000).canDrown(false)));

    public static void register(IEventBus eventBus)
    {
        FLUID_TYPE.register(eventBus);
    }

}

