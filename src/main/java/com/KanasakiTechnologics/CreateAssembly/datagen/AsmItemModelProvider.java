package com.KanasakiTechnologics.CreateAssembly.datagen;

import com.KanasakiTechnologics.CreateAssembly.CreateAssembly;
import com.KanasakiTechnologics.CreateAssembly.item.AsmItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

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

    }
}
