package com.KanasakiTechnologics.CreateAssembly;

import com.KanasakiTechnologics.CreateAssembly.block.AsmBlocks;
import com.KanasakiTechnologics.CreateAssembly.block.AsmFluidType;
import com.KanasakiTechnologics.CreateAssembly.block.LightBlocks;
import com.KanasakiTechnologics.CreateAssembly.block.AsmFluid;
import com.KanasakiTechnologics.CreateAssembly.item.AsmItems;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
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
        AsmFluidType.register(modEventBus);
        AsmFluid.register(modEventBus);
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

        if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(AsmBlocks.TIN_ORE);
            event.accept(AsmBlocks.SILVER_ORE);
            event.accept(AsmBlocks.RAW_TIN_BLOCK);
            event.accept(AsmBlocks.RAW_SILVER_BLOCK);
            event.accept(AsmBlocks.DEEPSLATE_TIN_ORE);
            event.accept(AsmBlocks.DEEPSLATE_SILVER_ORE);
            event.accept(AsmBlocks.ENDER_ORE);
        }

        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(AsmBlocks.TIN_BLOCK);
            event.accept(AsmBlocks.SILVER_BLOCK);
        }

        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(AsmItems.SILVER_INGOT);
            event.accept(AsmItems.TIN_INGOT);
            event.accept(AsmItems.RAW_TIN);
            event.accept(AsmItems.TIN_NUGGET);
            event.accept(AsmItems.RAW_SILVER);
            event.accept(AsmItems.SILVER_NUGGET);
            event.accept(AsmItems.ENDER_PEARL_FRAGMENT);
            event.accept(AsmItems.NETHER_STAR_SHARD);
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
            event.enqueueWork(() -> {
                // Glass Light Blocks
                ItemBlockRenderTypes.setRenderLayer(LightBlocks.WHITE_GLASS_LIGHT_BLOCK.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(LightBlocks.LIGHT_GRAY_GLASS_LIGHT_BLOCK.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(LightBlocks.GRAY_GLASS_LIGHT_BLOCK.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(LightBlocks.BLACK_GLASS_LIGHT_BLOCK.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(LightBlocks.BROWN_GLASS_LIGHT_BLOCK.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(LightBlocks.RED_GLASS_LIGHT_BLOCK.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(LightBlocks.ORANGE_GLASS_LIGHT_BLOCK.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(LightBlocks.YELLOW_GLASS_LIGHT_BLOCK.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(LightBlocks.LIME_GLASS_LIGHT_BLOCK.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(LightBlocks.GREEN_GLASS_LIGHT_BLOCK.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(LightBlocks.CYAN_GLASS_LIGHT_BLOCK.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(LightBlocks.LIGHT_BLUE_GLASS_LIGHT_BLOCK.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(LightBlocks.BLUE_GLASS_LIGHT_BLOCK.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(LightBlocks.PURPLE_GLASS_LIGHT_BLOCK.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(LightBlocks.MAGENTA_GLASS_LIGHT_BLOCK.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(LightBlocks.PINK_GLASS_LIGHT_BLOCK.get(), RenderType.translucent());
            });

        }
    }
}
