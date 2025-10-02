package com.KanasakiTechnologics.CreateAssembly.datagen.create;

import com.KanasakiTechnologics.CreateAssembly.CreateAssembly;
import com.KanasakiTechnologics.CreateAssembly.item.AsmItems;
import com.mrh0.createaddition.datagen.RecipeGen.RollingRecipeGen;
import com.simibubi.create.AllTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings("unused")
public final class AsmAdditionRollingRecipeProvider extends RollingRecipeGen {
    public AsmAdditionRollingRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CreateAssembly.MOD_ID);
    }

    private GeneratedRecipe rodRolling(Item rod, String metal) {
        return create(metal + "_ingot", b -> b
                .require(AllTags.commonItemTag("ingots/" + metal))
                .output(rod, 2));
    }

    GeneratedRecipe RADIANT_ROD = rodRolling(AsmItems.RADIANT_HANDLE.get(), "radiant");

}
