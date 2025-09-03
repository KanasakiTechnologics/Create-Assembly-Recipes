package com.KanasakiTechnologics.CreateAssembly.datagen;

import com.KanasakiTechnologics.CreateAssembly.CreateAssembly;
import com.KanasakiTechnologics.CreateAssembly.block.LightBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

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
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void glassWithItem(DeferredBlock<?> deferredBlock) {
        Block block = deferredBlock.get();
        ModelFile model = models().cubeAll(name(block), modLoc("block/" + name(block))).renderType("minecraft:translucent");
        simpleBlock(block, model);
        simpleBlockItem(block, model);
    }

    private static String name(Block block) {
        return block.getDescriptionId().replace("block." + CreateAssembly.MOD_ID + ".", "");
    }
}
