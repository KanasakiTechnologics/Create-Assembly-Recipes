package com.KanasakiTechnologics.CreateAssembly;

import com.KanasakiTechnologics.CreateAssembly.block.AsmBlocks;
import com.KanasakiTechnologics.CreateAssembly.block.LightBlocks;
import com.KanasakiTechnologics.CreateAssembly.block.entity.AsmBlockEntities;
import com.KanasakiTechnologics.CreateAssembly.content.recipes.AsmRecipeTypes;
import com.KanasakiTechnologics.CreateAssembly.effect.AsmEffect;
import com.KanasakiTechnologics.CreateAssembly.effect.AsmPotions;
import com.KanasakiTechnologics.CreateAssembly.fluid.AsmFluid;
import com.KanasakiTechnologics.CreateAssembly.fluid.AsmFluidType;
import com.KanasakiTechnologics.CreateAssembly.item.AsmItems;
import com.KanasakiTechnologics.CreateAssembly.loot.AsmLootModifiers;
import com.KanasakiTechnologics.CreateAssembly.screen.AsmMenuTypes;
import com.KanasakiTechnologics.CreateAssembly.util.*;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllCreativeModeTabs;
import com.simibubi.create.AllItems;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.RegisterEvent;
import org.slf4j.Logger;

@SuppressWarnings("removal")
@Mod(CreateAssembly.MOD_ID)
public class CreateAssembly {

    public static final String MOD_ID = "createassembly";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(MOD_ID)
            .defaultCreativeTab((ResourceKey<CreativeModeTab>) null);


    public CreateAssembly(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        //./gradlew build --warning-mode=all
        // Register events and game objects
        NeoForge.EVENT_BUS.register(this);
        REGISTRATE.registerEventListeners(modEventBus);

        AsmTags.init();
        AsmFluidType.register(modEventBus);
        AsmFluid.register(modEventBus);
        AsmItems.register(modEventBus);
        AsmBlocks.register(modEventBus);
        LightBlocks.register(modEventBus);
        AsmRecipeTypes.register(modEventBus);
        AsmCreativeModTab.register(modEventBus);
        AsmMenuTypes.register(modEventBus);
        AsmBlockEntities.register(modEventBus);
        AsmLootModifiers.register(modEventBus);
        AsmEffect.register(modEventBus);
        AsmPotions.register(modEventBus);

        // Register creative tab handler
        modEventBus.addListener(this::addCreative);

        // Registry initialization
        modEventBus.addListener(CreateAssembly::onRegister);

        // Register server config (includes HARVEST_ONLY_BEDROCK)
        modContainer.registerConfig(ModConfig.Type.SERVER, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() ->{

        });
    }

    public static void onRegister(final RegisterEvent event) {
        AsmFanProcessingTypes.init();
        AsmAttributeTypes.init();
    }

    public static ResourceLocation loc(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == AllCreativeModeTabs.BASE_CREATIVE_TAB.getKey()){
            event.insertAfter(AllItems.BRASS_INGOT.asStack(),AllItems.CHROMATIC_COMPOUND.asStack(),CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AllItems.CHROMATIC_COMPOUND.asStack(),AllItems.SHADOW_STEEL.asStack(),CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AllItems.SHADOW_STEEL.asStack(),AllItems.REFINED_RADIANCE.asStack(),CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AllBlocks.RAILWAY_CASING.asStack(), AllBlocks.REFINED_RADIANCE_CASING.asStack(),CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(AllBlocks.REFINED_RADIANCE_CASING.asStack(),AllBlocks.SHADOW_STEEL_CASING.asStack(),CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }


        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS){
            event.accept(AsmItems.RAW_TIN);
            event.accept(AsmItems.RAW_SILVER);
        }

        if (event.getTabKey() == CreativeModeTabs.SPAWN_EGGS){
            event.accept(AsmItems.OVERWORLD_EGG_SPAWN);
            event.accept(AsmItems.NETHER_EGG_SPAWN);
            event.accept(AsmItems.END_EGG_SPAWN);
        }

        if (event.getTabKey() == CreativeModeTabs.COLORED_BLOCKS) {
            // Register all light blocks
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

            // Register all glass light blocks
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
    public void onServerStarting(ServerStartingEvent event) {}

    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        static void onClientSetup(FMLClientSetupEvent event) {
            event.enqueueWork(() -> {
                // Set translucent render layer for glass light blocks one by one
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
                Minecraft.getInstance().getBlockColors().register(
                        (state, world, pos, tintIndex) -> 0x55000000, // ARGB = semi-transparent black overlay
                        AsmBlocks.REINFORCED_GLASS.get()
                );

            });
        }

        @SubscribeEvent
        public static void registerScreens(RegisterMenuScreensEvent event) {

        }
    }
}
