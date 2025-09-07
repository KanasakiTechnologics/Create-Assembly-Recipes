package com.KanasakiTechnologics.CreateAssembly.block;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.fluids.FluidType;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class GlowInkFluidType extends FluidType{

    private final ResourceLocation still = ResourceLocation.fromNamespaceAndPath("createassembly","block/glow_ink_still");
    private final ResourceLocation flowing = ResourceLocation.fromNamespaceAndPath("createassembly","block/glow_ink_flow");
    public GlowInkFluidType(Properties properties) {
        super(properties);
    }
    @Override
    public void initializeClient(@NotNull Consumer<IClientFluidTypeExtensions> consumer) {
        consumer.accept(new IClientFluidTypeExtensions() {
            @Override
            public ResourceLocation getStillTexture() {
                return still;
            }

            @Override
            public ResourceLocation getFlowingTexture() {
                return flowing;
            }
        });
    }
}
