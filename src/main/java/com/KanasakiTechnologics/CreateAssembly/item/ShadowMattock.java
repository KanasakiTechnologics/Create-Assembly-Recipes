package com.KanasakiTechnologics.CreateAssembly.item;

import com.KanasakiTechnologics.CreateAssembly.util.AsmTags;
import net.minecraft.Util;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LevelEvent;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ShadowMattock extends DiggerItem {

    private static final Set<ItemAbility> SHADOW_MATTOCK_ACTIONS = Util.make(new HashSet<>(), actions -> {
        actions.addAll(ItemAbilities.DEFAULT_AXE_ACTIONS);
        actions.addAll(ItemAbilities.DEFAULT_SHOVEL_ACTIONS);
        actions.addAll(ItemAbilities.DEFAULT_HOE_ACTIONS);
    });

    public ShadowMattock(Tier tier, Item.Properties properties) {
        super(tier, AsmTags.BlockTags.MINEABLE_WITH_SHADOW_MATTOCK.tag,
                properties.durability(tier.getUses()).attributes(createAttributes(tier, 15.0F, -3.0F)));
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ItemAbility action) {
        return SHADOW_MATTOCK_ACTIONS.contains(action);
    }

    @NotNull
    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Player player = context.getPlayer();
        BlockState blockState = level.getBlockState(pos);
        ItemStack stack = context.getItemInHand();

        // If player is sneaking, till like a hoe
        if (player != null && player.isShiftKeyDown()) {
            return tillSoil(level, pos, player, blockState, stack, context);
        }

        BlockState resultToSet = useAsAxe(blockState, context);

        if (resultToSet == null) {
            if (context.getClickedFace() == Direction.DOWN) {
                return InteractionResult.PASS;
            }

            BlockState flattenResult = blockState.getToolModifiedState(context, ItemAbilities.SHOVEL_FLATTEN, false);
            if (flattenResult != null && level.isEmptyBlock(pos.above())) {
                level.playSound(player, pos, SoundEvents.SHOVEL_FLATTEN, SoundSource.BLOCKS, 1.0F, 1.0F);
                resultToSet = flattenResult;
            } else {
                BlockState douseResult = blockState.getToolModifiedState(context, ItemAbilities.SHOVEL_DOUSE, false);
                if (douseResult != null && !level.isClientSide) {
                    level.levelEvent(null, LevelEvent.SOUND_EXTINGUISH_FIRE, pos, 0);
                    resultToSet = douseResult;
                }
            }

            if (resultToSet == null) {
                return InteractionResult.PASS;
            }
        }

        if (!level.isClientSide) {
            if (player instanceof ServerPlayer serverPlayer) {
                CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger(serverPlayer, pos, stack);
            }
            level.setBlock(pos, resultToSet, Block.UPDATE_ALL_IMMEDIATE);
            level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, resultToSet));
            if (player != null) {
                stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(context.getHand()));
            }
        }

        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    @NotNull
    private InteractionResult tillSoil(Level level, BlockPos pos, Player player, BlockState state, ItemStack stack, UseOnContext context) {
        if (!level.isClientSide && context.getClickedFace() != Direction.DOWN && level.isEmptyBlock(pos.above())) {
            if (state.is(Blocks.DIRT) || state.is(Blocks.GRASS_BLOCK) || state.is(Blocks.DIRT_PATH)) {
                level.setBlock(pos, Blocks.FARMLAND.defaultBlockState(), Block.UPDATE_ALL_IMMEDIATE);
                level.playSound(null, pos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(context.getHand()));
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.PASS;
    }

    @Nullable
    private BlockState useAsAxe(BlockState state, UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Player player = context.getPlayer();

        BlockState stripped = state.getToolModifiedState(context, ItemAbilities.AXE_STRIP, false);
        if (stripped != null) {
            level.playSound(player, pos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);
            return stripped;
        }

        BlockState scraped = state.getToolModifiedState(context, ItemAbilities.AXE_SCRAPE, false);
        if (scraped != null) {
            level.playSound(player, pos, SoundEvents.AXE_SCRAPE, SoundSource.BLOCKS, 1.0F, 1.0F);
            level.levelEvent(player, LevelEvent.PARTICLES_SCRAPE, pos, 0);
            return scraped;
        }

        BlockState waxed = state.getToolModifiedState(context, ItemAbilities.AXE_WAX_OFF, false);
        if (waxed != null) {
            level.playSound(player, pos, SoundEvents.AXE_WAX_OFF, SoundSource.BLOCKS, 1.0F, 1.0F);
            level.levelEvent(player, LevelEvent.PARTICLES_WAX_OFF, pos, 0);
            return waxed;
        }

        return null;
    }

    @Override
    public int getEnchantmentValue() {
        return 20;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @NotNull Item.TooltipContext context,
                                @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
        super.appendHoverText(stack, context, tooltip, flag);
        tooltip.add(Component.literal("A versatile tool that works as an Axe, Shovel, and Hoe."));
        tooltip.add(Component.literal("§7Shift + Right Click: Till soil like a hoe."));
    }
}
