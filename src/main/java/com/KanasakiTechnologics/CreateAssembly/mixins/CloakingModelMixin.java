package com.KanasakiTechnologics.CreateAssembly.mixins;

import com.KanasakiTechnologics.CreateAssembly.effect.AsmEffect;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Prevents rendering the entity model when the Cloaking effect is active.
 */
@Mixin(LivingEntityRenderer.class)
public abstract class CloakingModelMixin {

    @Inject(
            method = "render(Lnet/minecraft/world/entity/LivingEntity;FFLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;I)V",
            at = @At("HEAD"),
            cancellable = true
    )
    private void hideEntity(LivingEntity entity, float entityYaw, float partialTick,
                            PoseStack poseStack, MultiBufferSource bufferSource, int packedLight,
                            CallbackInfo ci) {
        if (entity.hasEffect(AsmEffect.CLOAKING)) {
            ci.cancel();
        }
    }
}
