package com.KanasakiTechnologics.CreateAssembly.mixins;

import com.KanasakiTechnologics.CreateAssembly.item.AsmItems;
import com.simibubi.create.content.processing.burner.BlazeBurnerBlockEntity;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlazeBurnerBlockEntity.class)
public class BlazeBurnerBlockEntityMixin {

    @Inject(method = "tryUpdateFuel", at = @At("TAIL"))
    private void adjustBurnTime(ItemStack itemStack, boolean forceOverflow, boolean simulate, CallbackInfoReturnable<Boolean> cir) {
        BlazeBurnerBlockEntity self = (BlazeBurnerBlockEntity) (Object) this;
        BlazeBurnerAccessor accessor = (BlazeBurnerAccessor) self;

        // If Create didn't accept the fuel, stop here
        if (!cir.getReturnValue()) return;

        if (itemStack.is(AsmItems.SUPERHEATED_BLAZE_CORE.get())) {
            if (!simulate) {
                accessor.setActiveFuel(BlazeBurnerBlockEntity.FuelType.SPECIAL);
                accessor.setRemainingBurnTime(6000); // 5 min = 5 * 60 * 20
                self.updateBlockState();
            }
        }

        // --- Blaze Core: SPECIAL for 32 minutes ---
        if (itemStack.is(AsmItems.BLAZE_CORE.get())) {
            if (!simulate) {
                accessor.setActiveFuel(BlazeBurnerBlockEntity.FuelType.NORMAL);
                accessor.setRemainingBurnTime(38400); // 32 min = 32 * 60 * 20
                self.updateBlockState();
            }
        }
    }
}
