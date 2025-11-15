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

    public static final DeferredHolder<Fluid,Fluid> SULFURIC_ACID = FLUIDS.register("sulfuric_acid",
            ()-> new SulfuricAcidFluid.Source(getSulfuricAcidProperties()));
    public static final DeferredHolder<Fluid,Fluid> FLOWING_SULFURIC_ACID = FLUIDS.register("flowing_sulfuric_acid",
            ()-> new SulfuricAcidFluid.Flowing(getSulfuricAcidProperties()));

    private static BaseFlowingFluid.Properties getSulfuricAcidProperties() {
        return new BaseFlowingFluid.Properties(
                () -> AsmFluidType.SULFURIC_ACID_TYPE.get(),
                () -> SULFURIC_ACID.get(),
                () -> FLOWING_SULFURIC_ACID.get()
        )
                .bucket(() -> AsmItems.SULFURIC_ACID_BUCKET.get())
                .block(() -> AsmBlocks.SULFURIC_ACID.get())
                .tickRate(10)
                .levelDecreasePerBlock(2)
                .slopeFindDistance(2)
                .explosionResistance(0f);
    }

    public static final DeferredHolder<Fluid,Fluid> SOUL_LAVA = FLUIDS.register("soul_lava",
            ()-> new SulfuricAcidFluid.Source(getSoulLavaProperties()));
    public static final DeferredHolder<Fluid,Fluid> FLOWING_SOUL_LAVA = FLUIDS.register("flowing_soul_lava",
            ()-> new SulfuricAcidFluid.Flowing(getSoulLavaProperties()));

    private static BaseFlowingFluid.Properties getSoulLavaProperties() {
        return new BaseFlowingFluid.Properties(
                () -> AsmFluidType.SOUL_LAVA_TYPE.get(),
                () -> SOUL_LAVA.get(),
                () -> FLOWING_SOUL_LAVA.get()
        )
                .bucket(() -> AsmItems.SOUL_LAVA_BUCKET.get())
                .block(() -> AsmBlocks.SOUL_LAVA.get())
                .tickRate(10)
                .levelDecreasePerBlock(2)
                .slopeFindDistance(2)
                .explosionResistance(0f);
    }

    public static final DeferredHolder<Fluid,Fluid> SAP = FLUIDS.register("sap",
            ()-> new SapFluid.Source(getSapProperties()));
    public static final DeferredHolder<Fluid,Fluid> FLOWING_SAP = FLUIDS.register("flowing_sap",
            ()-> new SapFluid.Flowing(getSapProperties()));

    private static BaseFlowingFluid.Properties getSapProperties() {
        return new BaseFlowingFluid.Properties(
                () -> AsmFluidType.SAP_TYPE.get(),
                () -> SAP.get(),
                () -> FLOWING_SAP.get()
        )
                .bucket(() -> AsmItems.SAP_BUCKET.get())
                .block(() -> AsmBlocks.SAP.get())
                .tickRate(10)
                .levelDecreasePerBlock(2)
                .slopeFindDistance(2)
                .explosionResistance(0f);
    }

    public static final DeferredHolder<Fluid,Fluid> MOLTEN_GOLD = FLUIDS.register("molten_gold",
            ()-> new MoltenGold.Source(getMoltenGoldProperties()));
    public static final DeferredHolder<Fluid,Fluid> FLOWING_MOLTEN_GOLD = FLUIDS.register("flowing_molten_gold",
            ()-> new MoltenGold.Flowing(getMoltenGoldProperties()));

    private static BaseFlowingFluid.Properties getMoltenGoldProperties() {
        return new BaseFlowingFluid.Properties(
                () -> AsmFluidType.MOLTEN_GOLD_TYPE.get(),
                () -> MOLTEN_GOLD.get(),
                () -> FLOWING_MOLTEN_GOLD.get()
        )
                .bucket(() -> AsmItems.MOLTEN_GOLD_BUCKET.get())
                .block(() -> AsmBlocks.MOLTEN_GOLD.get())
                .tickRate(10)
                .levelDecreasePerBlock(2)
                .slopeFindDistance(2)
                .explosionResistance(0f);
    }

    public static final DeferredHolder<Fluid,Fluid> REFINED_RADIANCE = FLUIDS.register("refined_radiance",
            ()-> new RefinedRadianceFluid.Source(getRefinedRadianceProperties()));
    public static final DeferredHolder<Fluid,Fluid> FLOWING_REFINED_RADIANCE = FLUIDS.register("flowing_refined_radiance",
            ()-> new RefinedRadianceFluid.Flowing(getRefinedRadianceProperties()));

    private static BaseFlowingFluid.Properties getRefinedRadianceProperties() {
        return new BaseFlowingFluid.Properties(
                () -> AsmFluidType.REFINED_RADIANCE_TYPE.get(),
                () -> REFINED_RADIANCE.get(),
                () -> FLOWING_REFINED_RADIANCE.get()
        )
                .bucket(() -> AsmItems.REFINED_RADIANCE_BUCKET.get())
                .block(() -> AsmBlocks.REFINED_RADIANCE.get())
                .tickRate(10)
                .levelDecreasePerBlock(2)
                .slopeFindDistance(2)
                .explosionResistance(0f);
    }

    public static final DeferredHolder<Fluid,Fluid> SHADOW_STEEL = FLUIDS.register("shadow_steel",
            ()-> new ShadowSteelFluid.Source(getShadowSteelProperties()));
    public static final DeferredHolder<Fluid,Fluid> FLOWING_SHADOW_STEEL = FLUIDS.register("flowing_shadow_steel",
            ()-> new ShadowSteelFluid.Flowing(getShadowSteelProperties()));

    private static BaseFlowingFluid.Properties getShadowSteelProperties() {
        return new BaseFlowingFluid.Properties(
                () -> AsmFluidType.SHADOW_STEEL_TYPE.get(),
                () -> SHADOW_STEEL.get(),
                () -> FLOWING_SHADOW_STEEL.get()
        )
                .bucket(() -> AsmItems.SHADOW_STEEL_BUCKET.get())
                .block(() -> AsmBlocks.SHADOW_STEEL.get())
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
