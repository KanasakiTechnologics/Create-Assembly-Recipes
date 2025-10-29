package com.KanasakiTechnologics.CreateAssembly.mixins;

import com.KanasakiTechnologics.CreateAssembly.effect.AsmEffect;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Prevents cloaked players from making step sounds while under the Cloaking effect.
 * This affects only sound playback, not motion or block interaction.
 */
@Mixin(Player.class)
public class CloakingFootstepMixin {

    @Inject(
            method = "playStepSound(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;)V",
            at = @At("HEAD"),
            cancellable = true
    )
    private void silenceSteps(BlockPos pos, BlockState blockState, CallbackInfo ci) {
        Player self = (Player) (Object) this;
        if (self.hasEffect(AsmEffect.CLOAKING)) {
            ci.cancel();
        }
    }
}
