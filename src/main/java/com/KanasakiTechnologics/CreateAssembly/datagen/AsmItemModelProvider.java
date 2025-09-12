package com.KanasakiTechnologics.CreateAssembly.datagen;

import com.KanasakiTechnologics.CreateAssembly.CreateAssembly;
import com.KanasakiTechnologics.CreateAssembly.item.AsmItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.checkerframework.checker.units.qual.A;

public class AsmItemModelProvider extends ItemModelProvider {
    public AsmItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, CreateAssembly.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(AsmItems.SILVER_INGOT.get());
        basicItem(AsmItems.ENDER_PEARL_FRAGMENT.get());
        basicItem(AsmItems.TIN_INGOT.get());
        basicItem(AsmItems.RAW_TIN.get());
        basicItem(AsmItems.TIN_NUGGET.get());
        basicItem(AsmItems.RAW_SILVER.get());
        basicItem(AsmItems.SILVER_NUGGET.get());
        basicItem(AsmItems.NETHER_STAR_SHARD.get());
        basicItem(AsmItems.ABSTRUSE_MECHANISM.get());
        basicItem(AsmItems.CALCULATION_MECHANISM.get());
        basicItem(AsmItems.INFERNAL_MECHANISM.get());
        basicItem(AsmItems.INTEGRATED_CIRCUIT.get());
        basicItem(AsmItems.INTEGRATED_MECHANISM.get());
        basicItem(AsmItems.KINETIC_MECHANISM.get());
        basicItem(AsmItems.SEALED_MECHANISM.get());
        basicItem(AsmItems.INCOMPLETE_ABSTRUSE_MECHANISM.get());
        basicItem(AsmItems.INCOMPLETE_CALCULATION_MECHANISM.get());
        basicItem(AsmItems.INCOMPLETE_INFERNAL_MECHANISM.get());
        basicItem(AsmItems.INCOMPLETE_INTEGRATED_CIRCUIT.get());
        basicItem(AsmItems.INCOMPLETE_INTEGRATED_MECHANISM.get());
        basicItem(AsmItems.INCOMPLETE_KINETIC_MECHANISM.get());
        basicItem(AsmItems.INCOMPLETE_SEALED_MECHANISM.get());
        basicItem(AsmItems.SULFUR_CHUNK.get());
        basicItem(AsmItems.SULFUR.get());
        basicItem(AsmItems.TIN_SHEET.get());
        basicItem(AsmItems.ENDERIUM_ALLOY.get());
        basicItem(AsmItems.ENDERIUM_ROD.get());
        basicItem(AsmItems.LAPIS_ALLOY.get());
        basicItem(AsmItems.LAPIS_SHEET.get());
        basicItem(AsmItems.COAL_ROD.get());
        basicItem(AsmItems.SAP.get());
        basicItem(AsmItems.ROUGH_DIAMOND.get());
        basicItem(AsmItems.POLISHED_DIAMOND.get());
        basicItem(AsmItems.SILVER_JEWEL.get());
        basicItem(AsmItems.ELECTRUM_JEWEL.get());
        basicItem(AsmItems.ALCHEMIST_DUST.get());
        basicItem(AsmItems.FUSED_BLEND.get());
        basicItem(AsmItems.NETHERITE_DUST.get());
        basicItem(AsmItems.NETHERRACK_SHARD.get());
        basicItem(AsmItems.UNCOMPLETED_NETHERITE_TEMPLATE.get());
        basicItem(AsmItems.UNPROCESSED_NETHERITE_DUST.get());
        basicItem(AsmItems.UNCOMPLETED_TOTEM_OF_UNDYING.get());
        basicItem(AsmItems.INCOMPLETE_BLAZE_ROD.get());
        basicItem(AsmItems.BLANK_CATALYST.get());
        basicItem(AsmItems.SHADOW_CATALYST.get());
        basicItem(AsmItems.RADIANT_CATALYST.get());
        basicItem(AsmItems.RAW_RUBBER.get());
        basicItem(AsmItems.RUBBER.get());
    }
}
