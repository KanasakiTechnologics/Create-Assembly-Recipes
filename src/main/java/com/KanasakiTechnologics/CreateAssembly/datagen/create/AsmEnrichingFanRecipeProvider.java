package com.KanasakiTechnologics.CreateAssembly.datagen.create;

import com.KanasakiTechnologics.CreateAssembly.CreateAssembly;
import com.KanasakiTechnologics.CreateAssembly.datagen.AsmEnrichingRecipeGen;
import com.KanasakiTechnologics.CreateAssembly.item.AsmItems;
import com.KanasakiTechnologics.CreateAssembly.util.AsmTags;
import com.simibubi.create.foundation.data.recipe.Mods;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.Tags;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings("unused")
public class AsmEnrichingFanRecipeProvider extends AsmEnrichingRecipeGen {

    //Overworld Spawn Egg
    GeneratedRecipe OVERWORLD_ENRICHING_1 = create("overworld_enrinching_1", b -> b.require(AsmItems.OVERWORLD_EGG_SPAWN)
                    .output(.10f, Items.ALLAY_SPAWN_EGG)
                    .output(.10f, Items.ARMADILLO_SPAWN_EGG)
                    .output(.10f, Items.AXOLOTL_SPAWN_EGG)
                    .output(.10f, Items.BAT_SPAWN_EGG)
                    .output(.10f, Items.CAMEL_SPAWN_EGG)
                    .output(.10f, Items.CAT_SPAWN_EGG)
                    .output(.10f, Items.CHICKEN_SPAWN_EGG)
                    .output(.10f, Items.COW_SPAWN_EGG)
                    .output(.10f, Items.DONKEY_SPAWN_EGG)
                    .output(.10f, Items.FOX_SPAWN_EGG)
                    .output(.10f, Items.FROG_SPAWN_EGG)
                    .output(.10f, Items.GOAT_SPAWN_EGG)

    );

    GeneratedRecipe OVERWORLD_ENRICHING_2 = create("overworld_enrinching_2", b -> b.require(AsmItems.OVERWORLD_EGG_SPAWN)
            .output(.10f, Items.HORSE_SPAWN_EGG)
            .output(.10f, Items.MOOSHROOM_SPAWN_EGG)
            .output(.10f, Items.MULE_SPAWN_EGG)
            .output(.10f, Items.OCELOT_SPAWN_EGG)
            .output(.10f, Items.PANDA_SPAWN_EGG)
            .output(.10f, Items.PARROT_SPAWN_EGG)
            .output(.10f, Items.PIG_SPAWN_EGG)
            .output(.10f, Items.RABBIT_SPAWN_EGG)
            .output(.10f, Items.SHEEP_SPAWN_EGG)
            .output(.10f, Items.SNIFFER_SPAWN_EGG)
            .output(.10f, Items.TURTLE_SPAWN_EGG)
            .output(.10f, Items.VILLAGER_SPAWN_EGG)
    );

    GeneratedRecipe OVERWORLD_ENRICHING_3 = create("overworld_enrinching_3", b -> b.require(AsmItems.OVERWORLD_EGG_SPAWN)
            .output(.10f, Items.WANDERING_TRADER_SPAWN_EGG)
            .output(.10f, Items.TRADER_LLAMA_SPAWN_EGG)
            .output(.10f, Items.BEE_SPAWN_EGG)
            .output(.10f, Items.DOLPHIN_SPAWN_EGG)
            .output(.10f, Items.ENDERMAN_SPAWN_EGG)
            .output(.10f, Items.LLAMA_SPAWN_EGG)
            .output(.10f, Items.WOLF_SPAWN_EGG)
            .output(.10f, Items.POLAR_BEAR_SPAWN_EGG)
    );

    //Nether Spawn Egg
    GeneratedRecipe NETHER_ENRICHING = create("nether_enriching", b -> b.require(AsmItems.NETHER_EGG_SPAWN)
            .output(.10f, Items.STRIDER_SPAWN_EGG)
            .output(.10f, Items.PIGLIN_SPAWN_EGG)
            .output(.10f, Items.ZOMBIFIED_PIGLIN_SPAWN_EGG)
    );

    //End Spawn Egg
    GeneratedRecipe END_ENRICHING = create("end_enriching", b -> b.require(AsmItems.END_EGG_SPAWN)
            .output(.10f, Items.ENDERMAN_SPAWN_EGG)
    );

    //Mekanism Enrichment
    GeneratedRecipe
        CARBON = create(Mods.MEK.recipeId("enriched_carbon"), b -> b.require(Ingredient.of(ItemTags.COALS)).output(Mods.MEK, "enriched_carbon").whenModLoaded(Mods.MEK.getId())),
        DIAMOND = create(Mods.MEK.recipeId("enriched_diamond"), b -> b.require(Items.DIAMOND).output(Mods.MEK, "enriched_diamond").whenModLoaded(Mods.MEK.getId())),
        REFINED_OBSIDIAN = moddedConversion(Mods.MEK,"dust_refined_obsidian","enriched_refined_obsidian"),
        REDSTONE = create(Mods.MEK.recipeId("enriched_redstone"), b -> b.require(Items.REDSTONE).output(Mods.MEK, "enriched_carbon").whenModLoaded(Mods.MEK.getId())),
        GOLD = create(Mods.MEK.recipeId("enriched_gold"), b -> b.require(Ingredient.of(AsmTags.ItemTags.GOLDS.tag)).output(Mods.MEK, "enriched_gold").whenModLoaded(Mods.MEK.getId())),
        TIN = create(Mods.MEK.recipeId("enriched_tin"), b -> b.require(Ingredient.of(AsmTags.ItemTags.TIN3.tag)).output(Mods.MEK, "enriched_tin").whenModLoaded(Mods.MEK.getId())),
        IRON = create(Mods.MEK.recipeId("enriched_iron"), b -> b.require(Ingredient.of(AsmTags.ItemTags.IRON.tag)).output(Mods.MEK, "enriched_iron").whenModLoaded(Mods.MEK.getId()));

    public AsmEnrichingFanRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CreateAssembly.MOD_ID);
    }
}
