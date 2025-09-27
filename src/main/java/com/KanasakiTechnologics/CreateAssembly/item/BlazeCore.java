package com.KanasakiTechnologics.CreateAssembly.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

public class BlazeCore extends Item {
    public BlazeCore(Properties properties) {
        super(properties);
    }

    @Override
    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack stack) {
        return new ItemStack((ItemLike) AsmItems.INACTIVE_BLAZE_CORE.get());
    }
}
