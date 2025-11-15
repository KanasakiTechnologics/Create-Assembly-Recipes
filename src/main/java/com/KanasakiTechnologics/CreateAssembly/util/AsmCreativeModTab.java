package com.KanasakiTechnologics.CreateAssembly.util;

import com.KanasakiTechnologics.CreateAssembly.CreateAssembly;
import com.KanasakiTechnologics.CreateAssembly.block.AsmBlocks;
import com.KanasakiTechnologics.CreateAssembly.item.AsmItems;
import com.simibubi.create.AllItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class AsmCreativeModTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateAssembly.MOD_ID);

    public static final Supplier<CreativeModeTab> CREATE_SHADOW_STEEL_TOOL= CREATIVE_MODE_TAB.register("create_shadow_steel_tool",
            ()->CreativeModeTab.builder().icon(()->new ItemStack(AllItems.SHADOW_STEEL.get()))
                    .title(Component.translatable("creativetab.createassembly.create_shadow_steel_tool"))
                    .displayItems((itemDisplayParameters, output) ->{
                        output.accept(AsmItems.SHADOW_PICKAXE);
                        output.accept(AsmItems.SHADOW_MATTOCK);
                        output.accept(AsmItems.SHADOW_SWORD);
                        output.accept(AsmItems.RADIANT_HANDLE);
                    }).build());

    public static final Supplier<CreativeModeTab> COMPRESSED_CREATE_BASIC_MATERIAL= CREATIVE_MODE_TAB.register("compressed_create_basic_material",
            ()->CreativeModeTab.builder().icon(()->new ItemStack(AsmBlocks.COMPRESSED_COBBLESTONE.get()))
                    .title(Component.translatable("creativetab.createassembly.compressed_create_basic_material"))
                    .displayItems((itemDisplayParameters, output) ->{
                        output.accept(AsmBlocks.COMPRESSED_COBBLESTONE);
                        output.accept(AsmBlocks.COMPRESSED_COBBLED_DEEPSLATE);
                        output.accept(AsmBlocks.COMPRESSED_GRAVEL);
                        output.accept(AsmBlocks.COMPRESSED_SAND);
                        output.accept(AsmBlocks.COMPRESSED_RED_SAND);
                        output.accept(AsmBlocks.COMPRESSED_SOUL_SAND);
                    }).build());

    public static final Supplier<CreativeModeTab> DNDESIRES_MECHANISMS = CREATIVE_MODE_TAB.register("dndesires_mechanism",
            ()->CreativeModeTab.builder().icon(()->new ItemStack(AsmItems.INTEGRATED_CIRCUIT.get()))
                    .title(Component.translatable("creativetab.createassembly.dndesires_mechanisms"))
                    .displayItems((itemDisplayParameters, output) ->{
                        output.accept(AsmItems.ANDESITE_MECHANISM);
                        output.accept(AsmItems.ABSTRUSE_MECHANISM);
                        output.accept(AsmItems.CALCULATION_MECHANISM);
                        output.accept(AsmItems.INFERNAL_MECHANISM);
                        output.accept(AsmItems.INTEGRATED_CIRCUIT);
                        output.accept(AsmItems.INTEGRATED_MECHANISM);
                        output.accept(AsmItems.KINETIC_MECHANISM);
                        output.accept(AsmItems.SEALED_MECHANISM);
                        output.accept(AsmItems.CREATIVE_MECHANISM);
                    }).build());

    public static final Supplier<CreativeModeTab> BLAZE_BURNER_FUEL= CREATIVE_MODE_TAB.register("blaze_burner_fuel",
            ()->CreativeModeTab.builder().icon(()->new ItemStack(AsmItems.BLAZE_CORE.get()))
                    .title(Component.translatable("creativetab.createassembly.blaze_burner_fuel"))
                    .displayItems((itemDisplayParameters, output) ->{
                        output.accept(AsmItems.INACTIVE_BLAZE_CORE);
                        output.accept(AsmItems.BLAZE_CORE);
                        output.accept(AsmItems.SUPERHEATED_BLAZE_CORE);
                    }).build());

    public static final Supplier<CreativeModeTab> CREATE_ASSEMBLY = CREATIVE_MODE_TAB.register("create_assembly",
            ()->CreativeModeTab.builder().icon(()->new ItemStack(AsmItems.GLOW_INK_BUCKET.get()))
                    .title(Component.translatable("creativetab.createassembly.create_assembly"))
                    .displayItems((itemDisplayParameters, output) ->{
                        output.accept(AsmItems.IRON_HAMMER);
                        output.accept(AsmItems.NETHER_STAR_SHARD);
                        output.accept(AsmBlocks.STAR_BLOCK);
                        output.accept(AsmItems.CLONING_TEMPLATE);
                        //output.accept(AsmItems.COPPER_BACKPACK_SMITHING_TEMPLATE);
                        output.accept(AsmItems.CREATIVE_ALLOY);
                        output.accept(AsmItems.CREATIVE_SHEET);
                        output.accept(AsmItems.PROCESSING_CREATIVE);
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
                        output.accept(AsmItems.SAP_DROP);
                        output.accept(AsmItems.RAW_RUBBER);
                        output.accept(AsmItems.RUBBER);
                        output.accept(AsmItems.SULFUR);
                        output.accept(AsmBlocks.HOT_COAL);
                        output.accept(AsmBlocks.COMPRESSED_COAL);
                        output.accept(AsmBlocks.FUSED_COMPRESSED_COAL);
                        output.accept(AsmItems.GLOW_INK_BUCKET);
                        output.accept(AsmItems.SOUL_LAVA_BUCKET);
                        output.accept(AsmItems.MOLTEN_REDSTONE_BUCKET);
                        output.accept(AsmItems.SULFURIC_ACID_BUCKET);
                        output.accept(AsmItems.SAP_BUCKET);
                        output.accept(AsmItems.REFINED_RADIANCE_BUCKET);
                        output.accept(AsmItems.SHADOW_STEEL_BUCKET);
                        output.accept(AsmItems.SAW_BLADE);
                        output.accept(AsmItems.DRILL_HEAD);
                        output.accept(AsmItems.PRESS_HEAD);
                        output.accept(AsmBlocks.REINFORCED_GLASS);
                    }).build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
