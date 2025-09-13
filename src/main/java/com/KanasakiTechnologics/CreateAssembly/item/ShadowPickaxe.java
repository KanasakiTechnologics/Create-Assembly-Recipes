package com.KanasakiTechnologics.CreateAssembly.item;

import com.KanasakiTechnologics.CreateAssembly.block.AsmBlocks;
import com.KanasakiTechnologics.CreateAssembly.util.AsmTags;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

public class ShadowPickaxe extends PickaxeItem {
    public ShadowPickaxe() {
        super(AsmTags.SHADOW_TIER, new Properties().stacksTo(1).durability(2500));
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();

        if (level.isClientSide) return InteractionResult.SUCCESS;

        // Check if the clicked block is vanilla bedrock
        if (level.getBlockState(pos).is(Blocks.BEDROCK)) {
            // Replace with custom bedrock
            level.setBlock(pos, AsmBlocks.BEDROCK.get().defaultBlockState(), 3);

            // Play sound effect
            level.playSound(null, pos, SoundEvents.STONE_BREAK, SoundSource.BLOCKS, 1.0f, 1.0f);

            // Damage the tool and notify client
            ItemStack stack = context.getItemInHand();
            stack.hurtAndBreak(1, context.getPlayer(), EquipmentSlot.MAINHAND);

            return InteractionResult.CONSUME;
        }

        return super.useOn(context);
    }
}
