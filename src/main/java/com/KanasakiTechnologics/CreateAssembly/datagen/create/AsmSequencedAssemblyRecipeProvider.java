package com.KanasakiTechnologics.CreateAssembly.datagen.create;

import com.KanasakiTechnologics.CreateAssembly.CreateAssembly;
import com.KanasakiTechnologics.CreateAssembly.block.AsmBlocks;
import com.KanasakiTechnologics.CreateAssembly.item.AsmItems;
import com.simibubi.create.AllItems;
import com.simibubi.create.api.data.recipe.SequencedAssemblyRecipeGen;
import com.simibubi.create.content.fluids.transfer.FillingRecipe;
import com.simibubi.create.content.kinetics.deployer.DeployerApplicationRecipe;
import com.simibubi.create.content.kinetics.press.PressingRecipe;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;
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
}
