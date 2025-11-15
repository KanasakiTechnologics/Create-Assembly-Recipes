package com.KanasakiTechnologics.CreateAssembly.datagen.create;

import com.KanasakiTechnologics.CreateAssembly.CreateAssembly;
import com.KanasakiTechnologics.CreateAssembly.fluid.AsmFluid;
import com.KanasakiTechnologics.CreateAssembly.item.AsmItems;
import com.KanasakiTechnologics.CreateAssembly.util.AsmMods;
import com.KanasakiTechnologics.CreateAssembly.util.AsmTags;
import com.simibubi.create.AllItems;
import com.simibubi.create.api.data.recipe.FillingRecipeGen;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.content.fluids.potion.PotionFluidHandler;
import com.simibubi.create.foundation.block.CopperBlockSet;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.WeatheringCopper.WeatherState;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.common.Tags;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings("unused")
public final class AsmFillingRecipeProvider extends FillingRecipeGen {

    public AsmFillingRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CreateAssembly.MOD_ID);

        // --- Vanilla copper ---
        copperOxidation("chiseled_copper", Blocks.CHISELED_COPPER, Blocks.EXPOSED_CHISELED_COPPER, Blocks.WEATHERED_CHISELED_COPPER, Blocks.OXIDIZED_CHISELED_COPPER);
        copperOxidation("copper_block", Blocks.COPPER_BLOCK, Blocks.EXPOSED_COPPER, Blocks.WEATHERED_COPPER, Blocks.OXIDIZED_COPPER);
        copperOxidation("copper_bulb", Blocks.COPPER_BULB, Blocks.EXPOSED_COPPER_BULB, Blocks.WEATHERED_COPPER_BULB, Blocks.OXIDIZED_COPPER_BULB);
        copperOxidation("copper_door", Blocks.COPPER_DOOR, Blocks.EXPOSED_COPPER_DOOR, Blocks.WEATHERED_COPPER_DOOR, Blocks.OXIDIZED_COPPER_DOOR);
        copperOxidation("copper_grate", Blocks.COPPER_GRATE, Blocks.EXPOSED_COPPER_GRATE, Blocks.WEATHERED_COPPER_GRATE, Blocks.OXIDIZED_COPPER_GRATE);
        copperOxidation("copper_trapdoor", Blocks.COPPER_TRAPDOOR, Blocks.EXPOSED_COPPER_TRAPDOOR, Blocks.WEATHERED_COPPER_TRAPDOOR, Blocks.OXIDIZED_COPPER_TRAPDOOR);
        copperOxidation("cut_copper", Blocks.CUT_COPPER, Blocks.EXPOSED_CUT_COPPER, Blocks.WEATHERED_CUT_COPPER, Blocks.OXIDIZED_CUT_COPPER);
        copperOxidation("cut_copper_slab", Blocks.CUT_COPPER_SLAB, Blocks.EXPOSED_CUT_COPPER_SLAB, Blocks.WEATHERED_CUT_COPPER_SLAB, Blocks.OXIDIZED_CUT_COPPER_SLAB);
        copperOxidation("cut_copper_stairs", Blocks.CUT_COPPER_STAIRS, Blocks.EXPOSED_CUT_COPPER_STAIRS, Blocks.WEATHERED_CUT_COPPER_STAIRS, Blocks.OXIDIZED_CUT_COPPER_STAIRS);

        // --- Create copper sets ---
        registerCopperSet(AllBlocks.COPPER_SHINGLES);
        registerCopperSet(AllBlocks.COPPER_TILES);
    }

    FlowingFluid soulLavaFluid = (FlowingFluid) AsmFluid.SOUL_LAVA.get();

    GeneratedRecipe SUPERHEATED_BLAZE_CORE = create("superheated_blaze_core", b -> b.require(soulLavaFluid, 1000)
            .require(AsmItems.INACTIVE_BLAZE_CORE)
            .output(AsmItems.SUPERHEATED_BLAZE_CORE));
    GeneratedRecipe BLAZE_CORE = create("blaze_core", b -> b.require(Fluids.LAVA, 1000)
            .require(AsmItems.INACTIVE_BLAZE_CORE)
            .output(AsmItems.BLAZE_CORE));
    GeneratedRecipe GUNPOWDER = create("gunpowder",b -> b.require(PotionFluidHandler.potionIngredient(Potions.HARMING,750))
            .require(AsmItems.ALCHEMIST_DUST)
            .output(Items.GUNPOWDER,3)
            .whenModLoaded(AsmMods.ENDERIO.getId())
    );
    GeneratedRecipe GLOWSTONE = create("glowstone",b -> b.require(PotionFluidHandler.potionIngredient(Potions.NIGHT_VISION,750))
            .require(AsmItems.ALCHEMIST_DUST)
            .output(Items.GLOWSTONE_DUST,3)
            .whenModLoaded(AsmMods.ENDERIO.getId())
    );
    GeneratedRecipe REDSTONE = create("redstone",b -> b.require(PotionFluidHandler.potionIngredient(Potions.STRENGTH,750))
            .require(AsmItems.ALCHEMIST_DUST)
            .output(Items.REDSTONE,3)
            .whenModLoaded(AsmMods.ENDERIO.getId())
    );

    GeneratedRecipe ROSE_QUARTZ = create("rose_quartz", b -> b.require((FlowingFluid) AsmFluid.MOLTEN_REDSTONE.get(),500)
            .require(Items.QUARTZ)
            .output(AllItems.ROSE_QUARTZ)
    );

    // For vanilla
    private void copperOxidation(String baseName, Block normal, Block exposed, Block weathered, Block oxidized) {
        create(baseName + "_to_exposed", b -> b.require(normal).require(Fluids.WATER, 250).output(exposed));
        create("exposed_" + baseName + "_to_weathered", b -> b.require(exposed).require(Fluids.WATER, 250).output(weathered));
        create("weathered_" + baseName + "_to_oxidized", b -> b.require(weathered).require(Fluids.WATER, 250).output(oxidized));
    }

    // For Create copper sets
    private void registerCopperSet(CopperBlockSet set) {
        for (CopperBlockSet.Variant<?> variant : set.getVariants()) {
            for (int i = 0; i < WeatherState.values().length - 1; i++) {
                WeatherState current = WeatherState.values()[i];
                WeatherState next = WeatherState.values()[i + 1];

                Block currentBlock = set.get(variant, current, false).get();
                Block nextBlock = set.get(variant, next, false).get();

                String recipeName = set.getName() + variant.getSuffix() + "_" + current.name().toLowerCase() + "_to_" + next.name().toLowerCase();

                create(recipeName, b -> b
                        .require(currentBlock)
                        .require(Fluids.WATER, 250)
                        .output(nextBlock));
            }
        }
    }
}
