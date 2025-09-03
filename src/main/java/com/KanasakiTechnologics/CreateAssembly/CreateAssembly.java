package com.KanasakiTechnologics.CreateAssembly;

import com.KanasakiTechnologics.CreateAssembly.block.AsmBlocks;
import com.KanasakiTechnologics.CreateAssembly.block.LightBlocks;
import com.KanasakiTechnologics.CreateAssembly.item.AsmItems;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllCreativeModeTabs;
import com.simibubi.create.AllItems;
import com.simibubi.create.foundation.data.CreateRegistrate;

@Mod(CreateAssembly.MOD_ID)
public class CreateAssembly {
    public static final String MOD_ID = "createassembly";
    public static final Logger LOGGER = LogUtils.getLogger();


    public CreateAssembly(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);



        NeoForge.EVENT_BUS.register(this);
        REGISTRATE.registerEventListeners(modEventBus);
        AsmItems.register(modEventBus);
        AsmBlocks.register(modEventBus);
        LightBlocks.register(modEventBus);
        modEventBus.addListener(this::addCreative);
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {}
    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(MOD_ID)
            .defaultCreativeTab((ResourceKey<CreativeModeTab>) null);


    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == AllCreativeModeTabs.BASE_CREATIVE_TAB.getKey()){
            event.insertAfter(AllItems.BRASS_INGOT.asStack(),AllItems.CHROMATIC_COMPOUND.asStack(),CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AllItems.CHROMATIC_COMPOUND.asStack(),AllItems.SHADOW_STEEL.asStack(),CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AllItems.SHADOW_STEEL.asStack(),AllItems.REFINED_RADIANCE.asStack(),CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AllBlocks.RAILWAY_CASING.asStack(), AllBlocks.REFINED_RADIANCE_CASING.asStack(),CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AllBlocks.REFINED_RADIANCE_CASING.asStack(),AllBlocks.SHADOW_STEEL_CASING.asStack(),CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }

        if (event.getTabKey() == CreativeModeTabs.COLORED_BLOCKS){
            event.accept(LightBlocks.WHITE_LIGHT_BLOCK);
            event.accept(LightBlocks.LIGHT_GRAY_LIGHT_BLOCK);
            event.accept(LightBlocks.GRAY_LIGHT_BLOCK);
            event.accept(LightBlocks.BLACK_LIGHT_BLOCK);
            event.accept(LightBlocks.BROWN_LIGHT_BLOCK);
            event.accept(LightBlocks.RED_LIGHT_BLOCK);
            event.accept(LightBlocks.ORANGE_LIGHT_BLOCK);
            event.accept(LightBlocks.YELLOW_LIGHT_BLOCK);
            event.accept(LightBlocks.LIME_LIGHT_BLOCK);
            event.accept(LightBlocks.GREEN_LIGHT_BLOCK);
            event.accept(LightBlocks.CYAN_LIGHT_BLOCK);
            event.accept(LightBlocks.LIGHT_BLUE_LIGHT_BLOCK);
            event.accept(LightBlocks.BLUE_LIGHT_BLOCK);
            event.accept(LightBlocks.PURPLE_LIGHT_BLOCK);
            event.accept(LightBlocks.MAGENTA_LIGHT_BLOCK);
            event.accept(LightBlocks.PINK_LIGHT_BLOCK);

            event.accept(LightBlocks.WHITE_GLASS_LIGHT_BLOCK);
            event.accept(LightBlocks.LIGHT_GRAY_GLASS_LIGHT_BLOCK);
            event.accept(LightBlocks.GRAY_GLASS_LIGHT_BLOCK);
            event.accept(LightBlocks.BLACK_GLASS_LIGHT_BLOCK);
            event.accept(LightBlocks.BROWN_GLASS_LIGHT_BLOCK);
            event.accept(LightBlocks.RED_GLASS_LIGHT_BLOCK);
            event.accept(LightBlocks.ORANGE_GLASS_LIGHT_BLOCK);
            event.accept(LightBlocks.YELLOW_GLASS_LIGHT_BLOCK);
            event.accept(LightBlocks.LIME_GLASS_LIGHT_BLOCK);
            event.accept(LightBlocks.GREEN_GLASS_LIGHT_BLOCK);
            event.accept(LightBlocks.CYAN_GLASS_LIGHT_BLOCK);
            event.accept(LightBlocks.LIGHT_BLUE_GLASS_LIGHT_BLOCK);
            event.accept(LightBlocks.BLUE_GLASS_LIGHT_BLOCK);
            event.accept(LightBlocks.PURPLE_GLASS_LIGHT_BLOCK);
            event.accept(LightBlocks.MAGENTA_GLASS_LIGHT_BLOCK);
            event.accept(LightBlocks.PINK_GLASS_LIGHT_BLOCK);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    
    @EventBusSubscriber(modid = CreateAssembly.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    static class ClientModEvents {
        @SubscribeEvent
        static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
