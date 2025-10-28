package com.KanasakiTechnologics.CreateAssembly.block;

import com.KanasakiTechnologics.CreateAssembly.util.AsmTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class ReinforcedGlassBlock extends Block {

    public ReinforcedGlassBlock() {
        super(BlockBehaviour.Properties.of()
                .strength(50.0f, 1200.0f)
                .noOcclusion() // allows transparency like tinted glass
                .isRedstoneConductor((s, g, p) -> false)
                .sound(SoundType.GLASS)
                .requiresCorrectToolForDrops());
    }

    @Override
    public float getExplosionResistance(BlockState state, BlockGetter level, BlockPos pos, Explosion explosion) {
        if (state.is(AsmTags.BlockTags.WITHER_IMMUNE.tag)) {
            return 3600000.0F; // effectively indestructible
        }
        return super.getExplosionResistance(state, level, pos, explosion);
    }

    @Override
    public boolean canEntityDestroy(BlockState state, BlockGetter level, BlockPos pos, net.minecraft.world.entity.Entity entity) {
        if (entity instanceof WitherBoss && state.is(AsmTags.BlockTags.WITHER_IMMUNE.tag)) {
            return false;
        }
        return super.canEntityDestroy(state, level, pos, entity);
    }


    public boolean canDropFromExplosion(BlockState state, BlockGetter level, BlockPos pos, net.minecraft.world.level.Explosion explosion) {
        if (state.is(AsmTags.BlockTags.WITHER_IMMUNE.tag)
                || state.is(AsmTags.BlockTags.EXPLOSION_IMMUNE.tag)) {
            return false;
        }
        return super.canDropFromExplosion(state, level, pos, explosion);
    }


    @Override
    public int getLightBlock(@NotNull BlockState state, @NotNull BlockGetter world, @NotNull BlockPos pos) {
        return world.getMaxLightLevel();
    }
}
