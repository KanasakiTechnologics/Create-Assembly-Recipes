package com.KanasakiTechnologics.CreateAssembly.mixins;

import com.simibubi.create.content.processing.burner.BlazeBurnerBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(BlazeBurnerBlockEntity.class)
public interface BlazeBurnerAccessor {
    @Accessor("remainingBurnTime")
    void setRemainingBurnTime(int time);

    @Accessor("activeFuel")
    void setActiveFuel(BlazeBurnerBlockEntity.FuelType fuelType);
}