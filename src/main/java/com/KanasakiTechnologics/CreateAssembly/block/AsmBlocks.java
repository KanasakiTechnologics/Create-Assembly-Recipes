package com.KanasakiTechnologics.CreateAssembly.block;

import com.KanasakiTechnologics.CreateAssembly.CreateAssembly;
import com.KanasakiTechnologics.CreateAssembly.fluid.AsmFluid;
import com.hlysine.create_connected.CCBlocks;
import com.hlysine.create_connected.CreateConnected;
import com.hlysine.create_connected.compat.Mods;
import com.hlysine.create_connected.config.FeatureToggle;
import com.hlysine.create_connected.content.WrenchableBlock;
import com.simibubi.create.AllTags;
import com.simibubi.create.foundation.data.AssetLookup;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ColorRGBA;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;
import java.util.function.Supplier;

import static com.KanasakiTechnologics.CreateAssembly.item.AsmItems.ITEMS;
import static com.simibubi.create.foundation.data.ModelGen.customItemModel;
import static com.simibubi.create.foundation.data.TagGen.pickaxeOnly;

public class AsmBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(CreateAssembly.MOD_ID);

    public static final DeferredBlock<Block> COMPRESSED_SAND = registerBlock("compressed_sand",
            () -> new ColoredFallingBlock(new ColorRGBA(14406560),BlockBehaviour.Properties.of().mapColor(MapColor.SAND).instrument(NoteBlockInstrument.SNARE).strength(1.0f).sound(SoundType.SAND)));
    public static final DeferredBlock<Block> COMPRESSED_RED_SAND = registerBlock("compressed_red_sand",
            () -> new ColoredFallingBlock(new ColorRGBA(11098145),BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.SNARE).strength(1.0f).sound(SoundType.SAND)));
    public static final DeferredBlock<Block> COMPRESSED_GRAVEL = registerBlock("compressed_gravel",
            () -> new ColoredFallingBlock(new ColorRGBA(-8356741),BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.SNARE).strength(1.0f).sound(SoundType.SAND)));
    public static final DeferredBlock<Block> COMPRESSED_SOUL_SAND = registerBlock("compressed_soul_sand",
            () -> new SoulSandBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.COW_BELL).speedFactor(0.8F).strength(1.0f).sound(SoundType.SOUL_SAND)));
    public static final DeferredBlock<Block> COMPRESSED_COBBLESTONE = registerBlock("compressed_cobblestone",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final DeferredBlock<Block> COMPRESSED_COBBLED_DEEPSLATE = registerBlock("compressed_cobbled_deepslate",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DEEPSLATE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.DEEPSLATE)));

    //public static final DeferredBlock<Block> ENDER_ORE = registerBlock("ender_ore",
    //        () -> new Block(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> SULFUR_ORE = registerBlock("sulfur_ore",
            () -> new Block(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<FakeBedrock> BEDROCK = BLOCKS.register("bedrock", FakeBedrock::new);
    public static final DeferredItem<BlockItem> BEDROCK_ITEM = ITEMS.register("bedrock", () -> new BlockItem(BEDROCK.get(), new Item.Properties()));

    public static final DeferredBlock<Block> TIN_BLOCK = registerBlock("tin_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.COPPER)));
    public static final DeferredBlock<Block> RAW_TIN_BLOCK = registerBlock("raw_tin_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.COPPER)));
    public static final DeferredBlock<Block> TIN_ORE = registerBlock("tin_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 4),BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> DEEPSLATE_TIN_ORE = registerBlock("deepslate_tin_ore",
            () -> new DropExperienceBlock(UniformInt.of(3, 6),BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));
    public static final Supplier<ItemLike> TIN_ORE_ITEM = () -> AsmBlocks.TIN_ORE.get().asItem();
    public static final Supplier<ItemLike> DEEPSLATE_TIN_ORE_ITEM = () -> AsmBlocks.DEEPSLATE_TIN_ORE.get().asItem();


    public static final DeferredBlock<Block> SILVER_BLOCK = registerBlock("silver_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.COPPER)));
    public static final DeferredBlock<Block> RAW_SILVER_BLOCK = registerBlock("raw_silver_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.COPPER)));
    public static final DeferredBlock<Block> SILVER_ORE = registerBlock("silver_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 4), BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> DEEPSLATE_SILVER_ORE = registerBlock("deepslate_silver_ore",
            () -> new DropExperienceBlock(UniformInt.of(3, 6), BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));
    public static final Supplier<ItemLike> SILVER_ORE_ITEM = () -> AsmBlocks.SILVER_ORE.get().asItem();
    public static final Supplier<ItemLike> DEEPSLATE_SILVER_ORE_ITEM = () -> AsmBlocks.DEEPSLATE_SILVER_ORE.get().asItem();

    public static final DeferredBlock<LiquidBlock> GLOW_INK = registerBlock("glow_ink",GlowInkBlock::new);
    public static final DeferredBlock<LiquidBlock> SULFURIC_ACID = registerBlock("sulfuric_acid",SulfuricAcidBlock::new);
    public static final DeferredBlock<LiquidBlock> SOUL_LAVA = registerBlock("soul_lava", SoulLavaBlock::new);
    public static final DeferredBlock<LiquidBlock> SAP = registerBlock("sap", SapBlock::new);
    public static final DeferredBlock<LiquidBlock> REFINED_RADIANCE = registerBlock("refined_radiance", RefinedRadianceLiquid::new);
    public static final DeferredBlock<LiquidBlock> SHADOW_STEEL = registerBlock("shadow_steel", ShadowSteelLiquid::new);
    public static final DeferredHolder<Block, LiquidBlock> MOLTEN_REDSTONE = BLOCKS.register("molten_redstone",
           () -> new MoltenLiquid((FlowingFluid) AsmFluid.MOLTEN_REDSTONE.get()));

    public static final DeferredBlock<Block> HOT_COAL = registerBlock("hot_coal_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> COMPRESSED_COAL = registerBlock("compressed_coal_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> FUSED_COMPRESSED_COAL = registerBlock("fused_compressed_coal_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> HOT_COMPRESSED_COAL = registerBlock("hot_compressed_coal_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> STAR_BLOCK = registerBlock("starblock",
            () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));
    public static final DeferredBlock<ReinforcedGlassBlock> REINFORCED_GLASS = registerBlock("reinforced_glass",
            () -> new ReinforcedGlassBlock(ResourceLocation.fromNamespaceAndPath("createassembly", "reinforced_glass"), "block/reinforced_glass", true){
                @Override
                public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    if(Screen.hasShiftDown()) {
                        tooltipComponents.add(Component.translatable("tooltip.createassembly.reinforced.shift_down"));
                    } else {
                        tooltipComponents.add(Component.translatable("tooltip.createassembly.reinforced"));
                    }
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });


    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block){
        ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }


    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
