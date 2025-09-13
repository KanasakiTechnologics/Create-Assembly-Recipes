package com.KanasakiTechnologics.CreateAssembly.util;

import com.KanasakiTechnologics.CreateAssembly.CreateAssembly;
import com.KanasakiTechnologics.CreateAssembly.block.AsmBlocks;
import com.KanasakiTechnologics.CreateAssembly.item.AsmItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class AsmCreativeModTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateAssembly.MOD_ID);

    public static final Supplier<CreativeModeTab> DNDESIRES_MECHANISMS = CREATIVE_MODE_TAB.register("dndesires_mechanism",
            ()->CreativeModeTab.builder().icon(()->new ItemStack(AsmItems.INTEGRATED_CIRCUIT.get()))
                    .title(Component.translatable("creativetab.createassembly.dndesires_mechanisms"))
                    .displayItems((itemDisplayParameters, output) ->{
                        output.accept(AsmItems.ABSTRUSE_MECHANISM);
                        output.accept(AsmItems.CALCULATION_MECHANISM);
                        output.accept(AsmItems.INFERNAL_MECHANISM);
                        output.accept(AsmItems.INTEGRATED_CIRCUIT);
                        output.accept(AsmItems.INTEGRATED_MECHANISM);
                        output.accept(AsmItems.KINETIC_MECHANISM);
                        output.accept(AsmItems.SEALED_MECHANISM);
                    }).build());

    public static final Supplier<CreativeModeTab> CREATE_ASSEMBLY = CREATIVE_MODE_TAB.register("create_assembly",
            ()->CreativeModeTab.builder().icon(()->new ItemStack(AsmItems.GLOW_INK_BUCKET.get()))
                    .title(Component.translatable("creativetab.createassembly.create_assembly"))
                    .displayItems((itemDisplayParameters, output) ->{
                        output.accept(AsmItems.SHADOW_PICKAXE);
                        output.accept(AsmItems.SHADOW_MATTOCK);
                        output.accept(AsmItems.SHADOW_SWORD);
                        output.accept(AsmItems.RADIANT_HANDLE);
                        output.accept(AsmItems.LAPIS_ALLOY);
                        output.accept(AsmItems.LAPIS_SHEET);
                        output.accept(AsmItems.COAL_ROD);
                        output.accept(AsmItems.BLANK_CATALYST);
                        output.accept(AsmItems.SHADOW_CATALYST);
                        output.accept(AsmItems.RADIANT_CATALYST);
                        output.accept(AsmItems.ROUGH_DIAMOND);
                        output.accept(AsmItems.ELECTRUM_JEWEL);
                        output.accept(AsmItems.SILVER_JEWEL);
                        output.accept(AsmItems.POLISHED_DIAMOND);
                        output.accept(AsmItems.ALCHEMIST_DUST);
                        output.accept(AsmItems.FUSED_BLEND);
                        output.accept(AsmItems.NETHERITE_DUST);
                        output.accept(AsmItems.NETHERRACK_SHARD);
                        output.accept(AsmItems.RAW_RUBBER);
                        output.accept(AsmItems.RUBBER);
                        output.accept(AsmItems.SULFUR);
                        output.accept(AsmBlocks.HOT_COAL);
                        output.accept(AsmBlocks.COMPRESSED_COAL);
                        output.accept(AsmBlocks.FUSED_COMPRESSED_COAL);
                        output.accept(AsmItems.GLOW_INK_BUCKET);
                        output.accept(AsmItems.SULFURIC_ACID_BUCKET);
                    }).build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
