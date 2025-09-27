package com.KanasakiTechnologics.CreateAssembly.block;

import com.KanasakiTechnologics.CreateAssembly.CreateAssembly;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static com.KanasakiTechnologics.CreateAssembly.item.AsmItems.ITEMS;

public class AsmBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(CreateAssembly.MOD_ID);

    public static final DeferredBlock<Block> ENDER_ORE = registerBlock("ender_ore",
            () -> new Block(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
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


    public static final DeferredBlock<Block> HOT_COAL = registerBlock("hot_coal_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> COMPRESSED_COAL = registerBlock("compressed_coal_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> FUSED_COMPRESSED_COAL = registerBlock("fused_compressed_coal_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> HOT_COMPRESSED_COAL = registerBlock("hot_compressed_coal_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

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
