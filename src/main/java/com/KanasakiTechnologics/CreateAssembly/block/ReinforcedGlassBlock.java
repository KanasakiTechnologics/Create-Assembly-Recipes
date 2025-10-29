package com.KanasakiTechnologics.CreateAssembly.block;

import com.KanasakiTechnologics.CreateAssembly.util.AsmTags;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.projectile.WitherSkull;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.TransparentBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import org.jetbrains.annotations.NotNull;

public class ReinforcedGlassBlock extends TransparentBlock {

    public final ResourceLocation texture;
    public final boolean connected;

    public ReinforcedGlassBlock(ResourceLocation identifier, String texture, boolean connected) {
        super(Properties.of()
                .strength(50.0f, 3600000.0f) // insane blast resistance
                .sound(SoundType.GLASS)
                .mapColor(MapColor.COLOR_BLACK)
                .instrument(NoteBlockInstrument.HAT)
                .noOcclusion()
                .isValidSpawn((a, b, c, d) -> false)
                .isRedstoneConductor((a, b, c) -> false)
                .isSuffocating((a, b, c) -> false)
                .isViewBlocking((a, b, c) -> false)
                .requiresCorrectToolForDrops());
        this.texture = ResourceLocation.fromNamespaceAndPath("createassembly", texture);
        this.connected = connected;
    }

    @Override
    public float getExplosionResistance(BlockState state, BlockGetter level, BlockPos pos, Explosion explosion) {
        return 3600000.0F; // virtually unbreakable
    }

    @Override
    public boolean canEntityDestroy(BlockState state, BlockGetter level, BlockPos pos, Entity entity) {
        if (entity instanceof WitherBoss || entity instanceof WitherSkull) {
            return false; // immune to Wither attacks and skulls
        }
        return super.canEntityDestroy(state, level, pos, entity);
    }

    @Override
    public boolean canDropFromExplosion(BlockState state, BlockGetter level, BlockPos pos, Explosion explosion) {
        return false; // never drops from explosions
    }

    @Override
    public int getLightBlock(@NotNull BlockState state, @NotNull BlockGetter world, @NotNull BlockPos pos) {
        return world.getMaxLightLevel(); // fully blocks light (tinted behavior)
    }

    @Override
    public float getDestroyProgress(BlockState state, Player player, BlockGetter level, BlockPos pos) {
        // Makes survival breaking effectively impossible (except creative)
        return player.isCreative() ? super.getDestroyProgress(state, player, level, pos) : 0.0F;
    }
}
