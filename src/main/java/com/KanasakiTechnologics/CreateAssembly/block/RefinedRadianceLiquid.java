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

public class RefinedRadianceLiquid extends LiquidBlock {
    public RefinedRadianceLiquid() {
        super((FlowingFluid) AsmFluid.REFINED_RADIANCE.get(), Properties.of().mapColor(MapColor.WATER).lightLevel(p ->15).noCollission().strength(100.00f).noLootTable().replaceable());
    }

    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        super.entityInside(state, level, pos, entity);

        if (entity instanceof LivingEntity living) {
            if (!level.isClientSide()) {
                living.addEffect(new MobEffectInstance(MobEffects.GLOWING, 60, 0, false, true));
            }
        }
    }
}
