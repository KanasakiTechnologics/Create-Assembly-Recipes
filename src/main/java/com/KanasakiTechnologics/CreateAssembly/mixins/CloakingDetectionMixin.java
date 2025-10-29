package com.KanasakiTechnologics.CreateAssembly.mixins;

import com.KanasakiTechnologics.CreateAssembly.effect.AsmEffect;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Stops mobs from detecting cloaked entities.
 */
@Mixin(TargetingConditions.class)
public class CloakingDetectionMixin {

    @Inject(method = "test", at = @At("HEAD"), cancellable = true)
    private void preventDetection(LivingEntity attacker, LivingEntity target, CallbackInfoReturnable<Boolean> cir) {
        if (target.hasEffect(AsmEffect.CLOAKING)) {
            cir.setReturnValue(false); // Pretend target is invisible to AI
        }
    }
}
