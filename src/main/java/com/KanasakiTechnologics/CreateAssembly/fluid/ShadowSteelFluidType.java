package com.KanasakiTechnologics.CreateAssembly.fluid;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.common.SoundActions;
import net.neoforged.neoforge.fluids.FluidType;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class ShadowSteelFluidType extends FluidType {

    private static final ResourceLocation STILL = ResourceLocation.fromNamespaceAndPath("createassembly", "block/shadow_steel_still");
    private static final ResourceLocation FLOWING = ResourceLocation.fromNamespaceAndPath("createassembly", "block/shadow_steel_flow");

    public ShadowSteelFluidType(FluidType.Properties properties) {
        super(properties
                .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
                .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)
        );
    }

    @Override
    public void initializeClient(@NotNull Consumer<IClientFluidTypeExtensions> consumer) {
        consumer.accept(new IClientFluidTypeExtensions() {
            @Override
            public ResourceLocation getStillTexture() {
                return STILL;
            }

            @Override
            public ResourceLocation getFlowingTexture() {
                return FLOWING;
            }
        });
    }
}
