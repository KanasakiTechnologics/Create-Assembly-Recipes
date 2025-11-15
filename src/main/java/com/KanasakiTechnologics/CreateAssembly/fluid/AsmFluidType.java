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
    public static final DeferredHolder<FluidType,FluidType>SAP_TYPE = FLUID_TYPE.register("sap_type",
            ()-> new SapFluidType(FluidType.Properties.create().density(3000).viscosity(4000).canDrown(false)));
    public static final DeferredHolder<FluidType, FluidType> SOUL_LAVA_TYPE = FLUID_TYPE.register("soul_lava_type",
            ()-> new SoulLavaFluidType(FluidType.Properties.create().lightLevel(10).temperature(1300).viscosity(4000).density(3000).canDrown(true).supportsBoating(false)));
    public static final DeferredHolder<FluidType, FluidType> MOLTEN_REDSTONE_TYPE = FLUID_TYPE.register("molten_redstone_type",
            ()-> new MoltenRedstoneFluidType(FluidType.Properties.create().lightLevel(10).temperature(1300).viscosity(4000).density(3000).canDrown(true).supportsBoating(false)));
    public static final DeferredHolder<FluidType,FluidType>SHADOW_STEEL_TYPE = FLUID_TYPE.register("shadow_steel_type",
            ()-> new ShadowSteelFluidType(FluidType.Properties.create().lightLevel(10).density(1000).viscosity(1000).canDrown(false).supportsBoating(true)));
    public static final DeferredHolder<FluidType,FluidType>REFINED_RADIANCE_TYPE = FLUID_TYPE.register("refined_radiance_type",
            ()-> new RefinedRadianceFluidType(FluidType.Properties.create().lightLevel(10).density(1000).viscosity(1000).canDrown(false).supportsBoating(true)));

    public static void register(IEventBus eventBus)
    {
        FLUID_TYPE.register(eventBus);
    }

}

