package com.KanasakiTechnologics.CreateAssembly.datagen;

import com.KanasakiTechnologics.CreateAssembly.CreateAssembly;
import com.KanasakiTechnologics.CreateAssembly.block.AsmBlocks;
import com.KanasakiTechnologics.CreateAssembly.block.LightBlocks;
import com.KanasakiTechnologics.CreateAssembly.block.ReinforcedGlassBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.Map;

public class AsmBlockStateProvider extends BlockStateProvider {

    public AsmBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, CreateAssembly.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(LightBlocks.WHITE_LIGHT_BLOCK);
        blockWithItem(LightBlocks.LIGHT_GRAY_LIGHT_BLOCK);
        blockWithItem(LightBlocks.GRAY_LIGHT_BLOCK);
        blockWithItem(LightBlocks.BLACK_LIGHT_BLOCK);
        blockWithItem(LightBlocks.BROWN_LIGHT_BLOCK);
        blockWithItem(LightBlocks.RED_LIGHT_BLOCK);
        blockWithItem(LightBlocks.ORANGE_LIGHT_BLOCK);
        blockWithItem(LightBlocks.YELLOW_LIGHT_BLOCK);
        blockWithItem(LightBlocks.LIME_LIGHT_BLOCK);
        blockWithItem(LightBlocks.GREEN_LIGHT_BLOCK);
        blockWithItem(LightBlocks.CYAN_LIGHT_BLOCK);
        blockWithItem(LightBlocks.LIGHT_BLUE_LIGHT_BLOCK);
        blockWithItem(LightBlocks.BLUE_LIGHT_BLOCK);
        blockWithItem(LightBlocks.PURPLE_LIGHT_BLOCK);
        blockWithItem(LightBlocks.MAGENTA_LIGHT_BLOCK);
        blockWithItem(LightBlocks.PINK_LIGHT_BLOCK);

        glassWithItem(LightBlocks.WHITE_GLASS_LIGHT_BLOCK);
        glassWithItem(LightBlocks.LIGHT_GRAY_GLASS_LIGHT_BLOCK);
        glassWithItem(LightBlocks.GRAY_GLASS_LIGHT_BLOCK);
        glassWithItem(LightBlocks.BLACK_GLASS_LIGHT_BLOCK);
        glassWithItem(LightBlocks.BROWN_GLASS_LIGHT_BLOCK);
        glassWithItem(LightBlocks.RED_GLASS_LIGHT_BLOCK);
        glassWithItem(LightBlocks.ORANGE_GLASS_LIGHT_BLOCK);
        glassWithItem(LightBlocks.YELLOW_GLASS_LIGHT_BLOCK);
        glassWithItem(LightBlocks.LIME_GLASS_LIGHT_BLOCK);
        glassWithItem(LightBlocks.GREEN_GLASS_LIGHT_BLOCK);
        glassWithItem(LightBlocks.CYAN_GLASS_LIGHT_BLOCK);
        glassWithItem(LightBlocks.LIGHT_BLUE_GLASS_LIGHT_BLOCK);
        glassWithItem(LightBlocks.BLUE_GLASS_LIGHT_BLOCK);
        glassWithItem(LightBlocks.PURPLE_GLASS_LIGHT_BLOCK);
        glassWithItem(LightBlocks.MAGENTA_GLASS_LIGHT_BLOCK);
        glassWithItem(LightBlocks.PINK_GLASS_LIGHT_BLOCK);

        blockWithItem(AsmBlocks.ENDER_ORE);
        blockWithItem(AsmBlocks.SULFUR_ORE);
        blockWithItem(AsmBlocks.SILVER_BLOCK);
        blockWithItem(AsmBlocks.TIN_BLOCK);
        blockWithItem(AsmBlocks.RAW_SILVER_BLOCK);
        blockWithItem(AsmBlocks.RAW_TIN_BLOCK);
        blockWithItem(AsmBlocks.TIN_ORE);
        blockWithItem(AsmBlocks.DEEPSLATE_TIN_ORE);
        blockWithItem(AsmBlocks.SILVER_ORE);
        blockWithItem(AsmBlocks.DEEPSLATE_SILVER_ORE);
        blockWithItem(AsmBlocks.STAR_BLOCK);

        blockWithItem(AsmBlocks.HOT_COAL);
        blockWithItem(AsmBlocks.COMPRESSED_COAL);
        blockWithItem(AsmBlocks.FUSED_COMPRESSED_COAL);
        blockWithItem(AsmBlocks.HOT_COMPRESSED_COAL);
        blockWithItem(AsmBlocks.COMPRESSED_COBBLESTONE);
        blockWithItem(AsmBlocks.COMPRESSED_COBBLED_DEEPSLATE);
        blockWithItem(AsmBlocks.COMPRESSED_GRAVEL);
        blockWithItem(AsmBlocks.COMPRESSED_SAND);
        blockWithItem(AsmBlocks.COMPRESSED_RED_SAND);
        blockWithItem(AsmBlocks.COMPRESSED_SOUL_SAND);
        blockWithItemVanillaTexture(AsmBlocks.BEDROCK, "minecraft:block/bedrock");
        blockWithItemVanillaTexture(AsmBlocks.REINFORCED_GLASS,"minecraft:block/tinted_glass");


    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void glassWithItem(DeferredBlock<?> deferredBlock) {
        Block block = deferredBlock.get();
        String blockName = block.getDescriptionId().replace("block." + CreateAssembly.MOD_ID + ".", "");

        ModelFile model = models()
                .cubeAll(blockName, modLoc("block/" + blockName))
                .renderType("minecraft:translucent"); // <--- important for glass

        simpleBlock(block, model);
        simpleBlockItem(block, model);
    }

    private void blockWithItemVanillaTexture(DeferredBlock<?> deferredBlock, String vanillaTexturePath) {
        Block block = deferredBlock.get();
        String blockName = block.getDescriptionId().replace("block." + CreateAssembly.MOD_ID + ".", "");

        ModelFile model = models().cubeAll(blockName, mcLoc(vanillaTexturePath));
        simpleBlock(block, model);
        simpleBlockItem(block, model);
    }


    private static String name(Block block) {
        return block.getDescriptionId().replace("block." + CreateAssembly.MOD_ID + ".", "");
    }
}
