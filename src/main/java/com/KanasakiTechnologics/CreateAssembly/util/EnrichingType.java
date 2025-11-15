package com.KanasakiTechnologics.CreateAssembly.util;

import com.KanasakiTechnologics.CreateAssembly.content.recipes.AsmRecipeTypes;
import com.simibubi.create.content.kinetics.fan.processing.FanProcessingType;
import com.simibubi.create.foundation.recipe.RecipeApplier;
import net.createmod.catnip.theme.Color;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class EnrichingType implements FanProcessingType {
    @Override
    public boolean isValidAt(Level level, BlockPos pos) {
        var fluidState = level.getFluidState(pos);
        if (AsmTags.FluidTags.FAN_PROCESSING_CATALYSTS_ENRICHING.is(fluidState))
            return true;
        var blockState = level.getBlockState(pos);
        if (AsmTags.BlockTags.FAN_PROCESSING_CATALYSTS_ENRICHING.is(blockState))
            return true;
        return false;
    }

    @Override
    public int getPriority() {
        return 1000;
    }

    @Override
    public boolean canProcess(ItemStack stack, Level level) {
        return AsmRecipeTypes.ENRICHING.find(new SingleRecipeInput(stack), level).isPresent();
    }


    @Override
    @Nullable
    public List<ItemStack> process(ItemStack stack, Level level) {
        return AsmRecipeTypes.ENRICHING.find(new SingleRecipeInput(stack), level)
                .map(RecipeHolder::value)
                .map(r -> RecipeApplier.applyRecipeOn(level, stack, r, true))
                .orElse(null);
    }

    @Override
    public void spawnProcessingParticles(Level level, Vec3 pos) {
        if (level.random.nextInt(6) != 0) return;

        var color = new Color(0xFFFFF6).asVectorF();
        level.addParticle(new DustParticleOptions(color, 1),
                pos.x + (level.random.nextFloat() - .5f) * .5f,
                pos.y + .5f,
                pos.z + (level.random.nextFloat() - .5f) * .5f,
                0, 1 / 8f, 0);

        level.addParticle(ParticleTypes.GLOW,
                pos.x + (level.random.nextFloat() - .5f) * .5f,
                pos.y + .5f,
                pos.z + (level.random.nextFloat() - .5f) * .5f,
                0, 1 / 16f, 0);
    }

    @Override
    public void morphAirFlow(AirFlowParticleAccess particleAccess, RandomSource random) {
        particleAccess.setColor(Color.mixColors(0xFFFFF6, 0xEDF5D9, random.nextFloat()));
        particleAccess.setAlpha(1f);
        if (random.nextFloat() < 1 / 128f)
            particleAccess.spawnExtraParticle(ParticleTypes.GLOW, .125f);
        if (random.nextFloat() < 1 / 64f)
            particleAccess.spawnExtraParticle(ParticleTypes.GLOW, .125f);
    }

    @Override
    public void affectEntity(Entity entity, Level level) {
        if (!(entity instanceof LivingEntity livingEntity)) return;
        if (level.isClientSide) return;

        livingEntity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 60, 0, true, true));
        level.playSound(null, livingEntity.blockPosition(), SoundEvents.AMETHYST_CLUSTER_BREAK, SoundSource.PLAYERS, 0.6F,1.4F + (level.random.nextFloat() - level.random.nextFloat()) * 0.2F);
    }

}
