package com.KanasakiTechnologics.CreateAssembly.datagen;

import com.KanasakiTechnologics.CreateAssembly.CreateAssembly;
import com.KanasakiTechnologics.CreateAssembly.item.AsmItems;
import com.KanasakiTechnologics.CreateAssembly.loot.AddItemModifier;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;

import java.util.concurrent.CompletableFuture;

public class AsmGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public AsmGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CreateAssembly.MOD_ID);
    }

    @Override
    protected void start() {
        this.add("blank_catalyst_from_bastion",
                new AddItemModifier(new LootItemCondition[]{
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/bastion_treasure")).build(),
                        LootItemRandomChanceCondition.randomChance(0.35f).build()
                }, AsmItems.BLANK_CATALYST.get()));

        this.add("shadow_catalyst_from_ancient",
                new AddItemModifier(new LootItemCondition[]{
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/ancient_city")).build(),
                        LootItemRandomChanceCondition.randomChance(0.35f).build()
                },AsmItems.SHADOW_CATALYST.get()));

        this.add("radiant_catalyst_from_fortress",
                new AddItemModifier(new LootItemCondition[]{
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/nether_bridge")).build(),
                        LootItemRandomChanceCondition.randomChance(0.35f).build()
                },AsmItems.RADIANT_CATALYST.get()));

        this.add("blank_catalyst_from_ominous_common",
                new AddItemModifier(new LootItemCondition[]{
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/trial_chambers/reward_ominous_common")).build(),
                }, AsmItems.BLANK_CATALYST.get()));

        this.add("shadow_catalyst_from_ominous_common",
                new AddItemModifier(new LootItemCondition[]{
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/trial_chambers/reward_ominous_common")).build(),
                },AsmItems.SHADOW_CATALYST.get()));

        this.add("radiant_catalyst_from_ominous_common",
                new AddItemModifier(new LootItemCondition[]{
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/trial_chambers/reward_ominous_common")).build(),
                },AsmItems.RADIANT_CATALYST.get()));

        this.add("cloning_template_from_reward_common",
                new AddItemModifier(new LootItemCondition[]{
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/trial_chambers/reward_common")).build(),
                },AsmItems.CLONING_TEMPLATE.get()));

        this.add("shadow_catalyst_from_warden",
                new AddItemModifier(new LootItemCondition[]{
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("entities/warden")).build()
                },AsmItems.SHADOW_CATALYST.get()));

        this.add("cloning_template_from_wither_skeleton",
                new AddItemModifier(new LootItemCondition[]{
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("entities/wither_skeleton")).build(),
                        LootItemRandomChanceCondition.randomChance(0.50f).build()
                },AsmItems.CLONING_TEMPLATE.get()));

        this.add("end_city_spawn_egg",
                new AddItemModifier(new LootItemCondition[]{
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/end_city_treasure")).build(),
                        LootItemRandomChanceCondition.randomChance(0.45f).build()
                },AsmItems.END_EGG_SPAWN.get()));

        this.add("bartering_spawn_egg",
                new AddItemModifier(new LootItemCondition[]{
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("gameplay/piglin_bartering")).build(),
                        LootItemRandomChanceCondition.randomChance(0.45f).build()
                },AsmItems.NETHER_EGG_SPAWN.get()));

    }
}
