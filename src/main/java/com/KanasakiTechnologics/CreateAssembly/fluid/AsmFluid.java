package com.KanasakiTechnologics.CreateAssembly.fluid;

import com.KanasakiTechnologics.CreateAssembly.CreateAssembly;
import com.KanasakiTechnologics.CreateAssembly.block.AsmBlocks;
import com.KanasakiTechnologics.CreateAssembly.item.AsmItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class AsmFluid {
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(Registries.FLUID, CreateAssembly.MOD_ID);

    public static final DeferredHolder<Fluid,Fluid> GLOW_INK = FLUIDS.register("glow_ink",
            ()-> new GlowInkFluid.Source(getGlowInkProperties()));
    public static final DeferredHolder<Fluid,Fluid> FLOWING_GLOW_INK = FLUIDS.register("flowing_glow_ink",
            ()-> new GlowInkFluid.Flowing(getGlowInkProperties()));

    private static BaseFlowingFluid.Properties getGlowInkProperties() {
        return new BaseFlowingFluid.Properties(
                () -> AsmFluidType.GLOW_INK_TYPE.get(),
                () -> GLOW_INK.get(),
                () -> FLOWING_GLOW_INK.get()
        )
                .bucket(() -> AsmItems.GLOW_INK_BUCKET.get())
                .block(() -> AsmBlocks.GLOW_INK.get())
                .tickRate(10)
                .levelDecreasePerBlock(2)
                .slopeFindDistance(2)
                .explosionResistance(0f);
    }

    public static void register(IEventBus eventBus)
    {
        FLUIDS.register(eventBus);
    }



}
