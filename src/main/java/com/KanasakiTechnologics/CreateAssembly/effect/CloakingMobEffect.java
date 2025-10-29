package com.KanasakiTechnologics.CreateAssembly.effect;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class CloakingMobEffect extends MobEffect {

    public CloakingMobEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier) {
        if (entity.level().isClientSide()) return true;

        // Apply invisibility while active
        entity.setInvisible(true);

        // Make mobs forget this entity
        if (entity instanceof Player player && player.level() instanceof ServerLevel level) {
            AABB area = player.getBoundingBox().inflate(20.0D);
            List<Monster> monsters = level.getEntitiesOfClass(Monster.class, area);
            for (Monster mob : monsters) {
                if (mob.getTarget() == player) mob.setTarget(null);
                Brain<?> brain = mob.getBrain();
                brain.eraseMemory(MemoryModuleType.ATTACK_TARGET);
                brain.eraseMemory(MemoryModuleType.NEAREST_VISIBLE_PLAYER);
            }
        }

        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        // Reapply logic every 10 ticks
        return duration % 10 == 0;
    }

    @Override
    public MobEffect addAttributeModifier(Holder<Attribute> attribute, ResourceLocation id, double amount, AttributeModifier.Operation operation) {
        return super.addAttributeModifier(attribute, id, amount, operation);
    }

    @Override
    public void removeAttributeModifiers(AttributeMap attributeMap) {
        super.removeAttributeModifiers(attributeMap);
    }

    public static void tickEnd(LivingEntity entity) {
        // Called externally (e.g. in a common tick event)
        if (!entity.hasEffect(AsmEffect.CLOAKING)) {
            entity.setInvisible(false);
        }
    }
}
