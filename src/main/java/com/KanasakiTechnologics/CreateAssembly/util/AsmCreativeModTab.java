package com.KanasakiTechnologics.CreateAssembly.util;

import com.KanasakiTechnologics.CreateAssembly.CreateAssembly;
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
                        output.accept(AsmItems.ENDERIUM_ALLOY);
                        output.accept(AsmItems.LAPIS_ALLOY);
                        output.accept(AsmItems.ENDERIUM_ROD);
                        output.accept(AsmItems.COAL_ROD);
                        output.accept(AsmItems.LAPIS_SHEET);
                        output.accept(AsmItems.SULFUR);
                        output.accept(AsmItems.GLOW_INK_BUCKET);
                        output.accept(AsmItems.SULFURIC_ACID_BUCKET);
                    }).build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
