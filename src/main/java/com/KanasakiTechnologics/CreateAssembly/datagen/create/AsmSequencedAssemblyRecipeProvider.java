package com.KanasakiTechnologics.CreateAssembly.datagen.create;

import com.KanasakiTechnologics.CreateAssembly.CreateAssembly;
import com.KanasakiTechnologics.CreateAssembly.block.AsmBlocks;
import com.KanasakiTechnologics.CreateAssembly.item.AsmItems;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.simibubi.create.AllTags;
import com.simibubi.create.api.data.recipe.SequencedAssemblyRecipeGen;
import com.simibubi.create.content.fluids.transfer.FillingRecipe;
import com.simibubi.create.content.kinetics.deployer.DeployerApplicationRecipe;
import com.simibubi.create.content.kinetics.press.PressingRecipe;
import com.simibubi.create.content.kinetics.saw.CuttingRecipe;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluids;
import plus.dragons.createenchantmentindustry.common.registry.CEIFluids;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings("unused")
public final class AsmSequencedAssemblyRecipeProvider extends SequencedAssemblyRecipeGen {
    public AsmSequencedAssemblyRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CreateAssembly.MOD_ID);
    }

    GeneratedRecipe NETHERIRE_UPGRADE_SMITHING_TEMPLATE = create("netherite_upgrade_smithing_template",b ->b.require(AsmItems.NETHERRACK_SHARD)
            .transitionTo(AsmItems.UNCOMPLETED_NETHERITE_TEMPLATE)
            .addOutput(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE,1)
            .loops(1)
            .addStep(FillingRecipe::new,rb ->rb.require(Fluids.LAVA,250))
            .addStep(DeployerApplicationRecipe::new,rb -> rb.require(AsmItems.POLISHED_DIAMOND))
            .addStep(FillingRecipe::new,rb -> rb.require(CEIFluids.EXPERIENCE.get(),250))
            .addStep(PressingRecipe::new,rb -> rb)
    );

    GeneratedRecipe EASY_DIAMOND = create("easy_diamond",b -> b.require(AsmBlocks.FUSED_COMPRESSED_COAL)
            .transitionTo(AsmBlocks.HOT_COMPRESSED_COAL)
            .addOutput(AsmItems.ROUGH_DIAMOND,75)
            .addOutput(Items.COAL,25)
            .loops(3)
            .addStep(FillingRecipe::new,rb ->rb.require(Fluids.LAVA,750))
            .addStep(DeployerApplicationRecipe::new,rb ->rb.require(AllItems.EXP_NUGGET))
            .addStep(PressingRecipe::new,rb -> rb)
            .addStep(PressingRecipe::new,rb -> rb)
    );

    GeneratedRecipe DIAMOND = create("diamond",b -> b.require(AsmBlocks.COMPRESSED_COAL)
            .transitionTo(AsmBlocks.HOT_COMPRESSED_COAL)
            .addOutput(AsmItems.ROUGH_DIAMOND,50)
            .addOutput(Items.COAL,50)
            .loops(4)
            .addStep(FillingRecipe::new,rb ->rb.require(Fluids.LAVA,500))
            .addStep(PressingRecipe::new,rb -> rb)
            .addStep(PressingRecipe::new,rb -> rb)
    );

    GeneratedRecipe EASY_NETHERITE_SCRAP = create("easy_netherite_scrap",b-> b.require(AsmItems.NETHERITE_DUST)
            .transitionTo(AsmItems.UNPROCESSED_NETHERITE_DUST)
            .addOutput(Items.NETHERITE_SCRAP,100)
            .addOutput(AllItems.POWDERED_OBSIDIAN,2)
            .addOutput(AllItems.CINDER_FLOUR,2)
            .loops(3)
            .addStep(FillingRecipe::new,rb -> rb.require(CEIFluids.EXPERIENCE.get(),250))
            .addStep(DeployerApplicationRecipe::new,rb -> rb.require(AsmItems.FUSED_BLEND))
            .addStep(FillingRecipe::new,rb ->rb.require(Fluids.LAVA,500))
            .addStep(PressingRecipe::new,rb -> rb)
    );

    GeneratedRecipe NETHERITE_SCRAP = create("netherite_scrap",b -> b.require(AsmItems.NETHERITE_DUST)
            .transitionTo(AsmItems.UNPROCESSED_NETHERITE_DUST)
            .addOutput(Items.NETHERITE_SCRAP,79)
            .addOutput(AllItems.POWDERED_OBSIDIAN,13)
            .addOutput(AllItems.CINDER_FLOUR,13)
            .loops(5)
            .addStep(FillingRecipe::new,rb -> rb.require(CEIFluids.EXPERIENCE.get(),250))
            .addStep(FillingRecipe::new,rb ->rb.require(Fluids.LAVA,250))
            .addStep(PressingRecipe::new,rb -> rb)
    );

    GeneratedRecipe TOTEM_OF_UNDYING = create("totem_of_undying",b -> b.require(AsmItems.ELECTRUM_JEWEL)
            .transitionTo(AsmItems.UNCOMPLETED_TOTEM_OF_UNDYING)
            .addOutput(Items.TOTEM_OF_UNDYING,1)
            .loops(1)
            .addStep(CuttingRecipe::new,rb ->rb)
            .addStep(DeployerApplicationRecipe::new,rb -> rb.require(Items.END_CRYSTAL))
            .addStep(FillingRecipe::new,rb ->rb.require(Fluids.LAVA,1000))
            .addStep(DeployerApplicationRecipe::new,rb ->rb.require(Items.EMERALD))
            .addStep(PressingRecipe::new,rb -> rb)
            .addStep(FillingRecipe::new,rb -> rb.require(CEIFluids.EXPERIENCE.get(),500))

    );

    GeneratedRecipe BLAZE_ROD = create("blaze_rod",b -> b.require(AsmItems.COAL_ROD)
            .transitionTo(AsmItems.INCOMPLETE_BLAZE_ROD)
            .addOutput(Items.BLAZE_ROD,1)
            .loops(3)
            .addStep(FillingRecipe::new,rb ->rb.require(Fluids.LAVA,500))
            .addStep(PressingRecipe::new,rb -> rb)
            .addStep(PressingRecipe::new,rb -> rb)
    );

    GeneratedRecipe INTEGRATED_CIRCUIT = create("integrated_circuit", b-> b.require(AsmItems.LAPIS_SHEET)
            .transitionTo(AsmItems.INCOMPLETE_INTEGRATED_CIRCUIT)
            .addOutput(AsmItems.INTEGRATED_CIRCUIT,135)
            .addOutput(Items.REDSTONE,5)
            .addOutput(AsmItems.LAPIS_SHEET,5)
            .addOutput(Items.QUARTZ,3)
            .addOutput(AllItems.BRASS_NUGGET,2)
            .loops(4)
            .addStep(DeployerApplicationRecipe::new,rb -> rb.require(Items.REDSTONE))
            .addStep(DeployerApplicationRecipe::new,rb -> rb.require(Items.QUARTZ))
            .addStep(DeployerApplicationRecipe::new,rb -> rb.require(AllItems.BRASS_NUGGET))
    );

    GeneratedRecipe INTEGRATED_MECHANISM = create("integrated_mechanism", b-> b.require(AllItems.BRASS_SHEET)
            .transitionTo(AsmItems.INCOMPLETE_INTEGRATED_MECHANISM)
            .addOutput(AsmItems.INTEGRATED_MECHANISM,128)
            .addOutput(AllItems.ELECTRON_TUBE,7)
            .addOutput(AsmItems.INTEGRATED_CIRCUIT,5)
            .addOutput(AllItems.BRASS_SHEET,5)
            .addOutput(AllBlocks.COGWHEEL,5)
            .loops(4)
            .addStep(DeployerApplicationRecipe::new,rb -> rb.require(AsmItems.INTEGRATED_CIRCUIT))
            .addStep(DeployerApplicationRecipe::new,rb -> rb.require(AllBlocks.COGWHEEL))
            .addStep(DeployerApplicationRecipe::new,rb -> rb.require(AllItems.ELECTRON_TUBE))
    );

    GeneratedRecipe LOGISTIC_MECHANISM = create("logistic_mechanism", b-> b.require(AllItems.IRON_SHEET)
            .transitionTo(AsmItems.INCOMPLETE_KINETIC_MECHANISM)
            .addOutput(AsmItems.KINETIC_MECHANISM,128)
            .addOutput(AllItems.ZINC_NUGGET,7)
            .addOutput(AllItems.ANDESITE_ALLOY,5)
            .addOutput(Items.SLIME_BALL,5)
            .addOutput(AllBlocks.COGWHEEL,5)
            .loops(4)
            .addStep(DeployerApplicationRecipe::new,rb -> rb.require(AllItems.ANDESITE_ALLOY))
            .addStep(DeployerApplicationRecipe::new,rb -> rb.require(AllItems.ZINC_NUGGET))
            .addStep(DeployerApplicationRecipe::new,rb -> rb.require(AllBlocks.COGWHEEL))
            .addStep(DeployerApplicationRecipe::new,rb -> rb.require(Items.SLIME_BALL))
    );

    GeneratedRecipe CALCULATION_MECHANISM = create("calculation_mechanism", b-> b.require(AsmItems.TIN_SHEET)
            .transitionTo(AsmItems.INCOMPLETE_CALCULATION_MECHANISM)
            .addOutput(AsmItems.CALCULATION_MECHANISM,120)
            .addOutput(AsmItems.INTEGRATED_CIRCUIT,5)
            .addOutput(AllBlocks.COGWHEEL,5)
            .addOutput(Items.IRON_NUGGET,10)
            .addOutput(AllItems.COPPER_NUGGET,10)
            .loops(4)
            .addStep(DeployerApplicationRecipe::new,rb -> rb.require(AsmItems.INTEGRATED_CIRCUIT))
            .addStep(DeployerApplicationRecipe::new,rb -> rb.require(AllBlocks.COGWHEEL))
            .addStep(DeployerApplicationRecipe::new,rb -> rb.require(AllItems.COPPER_NUGGET))
            .addStep(DeployerApplicationRecipe::new,rb -> rb.require(Items.IRON_NUGGET))
    );

    GeneratedRecipe SEALED_MECHANISM = create("sealed_mechanism", b-> b.require(AsmItems.RUBBER)
            .transitionTo(AsmItems.INCOMPLETE_SEALED_MECHANISM)
            .addOutput(AsmItems.SEALED_MECHANISM,120)
            .addOutput(AllItems.COPPER_SHEET,5)
            .addOutput(Items.DRIED_KELP,5)
            .addOutput(Blocks.GLASS,10)
            .addOutput(AsmItems.RUBBER,10)
            .loops(4)
            .addStep(DeployerApplicationRecipe::new,rb -> rb.require(AllBlocks.COGWHEEL))
            .addStep(DeployerApplicationRecipe::new,rb -> rb.require(Items.DRIED_KELP))
            .addStep(DeployerApplicationRecipe::new,rb -> rb.require(AllItems.COPPER_SHEET))
            .addStep(DeployerApplicationRecipe::new, rb -> rb.require(Ingredient.of(AllTags.commonItemTag("glass_blocks/colorless"))))

    );

    GeneratedRecipe ABSTRUCE_MECHANISM = create("abstruce_mechanism",b -> b.require(AllItems.STURDY_SHEET)
            .transitionTo(AsmItems.INCOMPLETE_ABSTRUSE_MECHANISM)
            .addOutput(AsmItems.ABSTRUSE_MECHANISM,120)
            .addOutput(AsmItems.INTEGRATED_CIRCUIT,5)
            .addOutput(Items.REDSTONE,5)
            .addOutput(Items.AMETHYST_SHARD,10)
            .addOutput(AllItems.STURDY_SHEET,10)
            .loops(4)
            .addStep(DeployerApplicationRecipe::new,rb -> rb.require(AsmItems.INTEGRATED_CIRCUIT))
            .addStep(DeployerApplicationRecipe::new,rb -> rb.require(Items.AMETHYST_SHARD))
            .addStep(DeployerApplicationRecipe::new,rb -> rb.require(Items.REDSTONE))
            .addStep(DeployerApplicationRecipe::new, rb -> rb.require(AllBlocks.COGWHEEL))
    );
}
