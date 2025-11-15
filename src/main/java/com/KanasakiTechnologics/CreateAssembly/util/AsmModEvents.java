package com.KanasakiTechnologics.CreateAssembly.util;

import com.KanasakiTechnologics.CreateAssembly.CreateAssembly;
import com.KanasakiTechnologics.CreateAssembly.effect.AsmPotions;
import com.KanasakiTechnologics.CreateAssembly.item.AsmItems;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import net.neoforged.neoforge.event.village.WandererTradesEvent;

import java.util.List;

@SuppressWarnings("removal")
@EventBusSubscriber(modid = CreateAssembly.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class AsmModEvents {
    @SubscribeEvent
    public static void onBrewingRecipeRegister(RegisterBrewingRecipesEvent event) {
        PotionBrewing.Builder builder = event.getBuilder();

        builder.addMix(Potions.MUNDANE, Items.WITHER_ROSE, AsmPotions.WITHER_POTION);
        builder.addMix(Potions.LONG_INVISIBILITY, Items.PHANTOM_MEMBRANE, AsmPotions.CLOCKING);
        builder.addMix(AsmPotions.CLOCKING, Items.REDSTONE, AsmPotions.LONG_CLOCKING);
        builder.addMix(AsmPotions.LONG_CLOCKING, Items.REDSTONE, AsmPotions.MASTER_CLOCKING);
    }

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event){
        if(event.getType() == VillagerProfession.CLERIC){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(5).add(((entity, randomSource) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 16),
                new ItemStack(AsmItems.OVERWORLD_EGG_SPAWN.get(),2),6,3,0.05f
            )));
        }
    }

    @SubscribeEvent
    public static void addWanderingTrades(WandererTradesEvent event){
        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();

        rareTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 32),
                new ItemStack(AsmItems.OVERWORLD_EGG_SPAWN.get(),2),1,10,0.2f
        ));

        rareTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 32),
                new ItemStack(AsmItems.NETHER_EGG_SPAWN.get(),2),1,10,0.2f
        ));

        rareTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 32),
                new ItemStack(AsmItems.END_EGG_SPAWN.get(),2),1,10,0.2f
        ));
    }
}
