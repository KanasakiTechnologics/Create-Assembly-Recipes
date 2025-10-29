package com.KanasakiTechnologics.CreateAssembly.util;

import com.KanasakiTechnologics.CreateAssembly.CreateAssembly;
import com.KanasakiTechnologics.CreateAssembly.effect.AsmPotions;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;

@EventBusSubscriber(modid = CreateAssembly.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class AsmModEvents {
    @SubscribeEvent
    public static void onBrewingRecipeRegister(RegisterBrewingRecipesEvent event) {
        PotionBrewing.Builder builder = event.getBuilder();

        builder.addMix(Potions.MUNDANE, Items.WITHER_ROSE, AsmPotions.WITHER_POTION);
        builder.addMix(Potions.LONG_INVISIBILITY, Items.PHANTOM_MEMBRANE, AsmPotions.CLOCKING);
        builder.addMix(AsmPotions.CLOCKING, Items.REDSTONE, AsmPotions.LONG_CLOCKING);
        builder.addMix(AsmPotions.LONG_CLOCKING, Items.REDSTONE, AsmPotions.MASTER_CLOCKING);
    }
}
