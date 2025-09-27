package com.KanasakiTechnologics.CreateAssembly.block;

import com.KanasakiTechnologics.CreateAssembly.fluid.AsmFluid;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.MapColor;

public class SoulLavaBlock extends LiquidBlock {
    public SoulLavaBlock() {
        super((FlowingFluid) AsmFluid.SOUL_LAVA.get(), BlockBehaviour.Properties.of().mapColor(MapColor.FIRE).lightLevel(p ->15).noCollission().strength(100.00f).noLootTable().replaceable());
    }

    @Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        super.entityInside(state, level, pos, entity);

        if (!entity.fireImmune()) {
            entity.igniteForSeconds(10);
        }

        if (entity instanceof LivingEntity livingEntity) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 30, 0, false, false));
            livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 1, false, false));
        }
    }

}
