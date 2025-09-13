package com.KanasakiTechnologics.CreateAssembly.block;

import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public class FakeBedrock extends Block {
    public FakeBedrock() {
        super(Properties.of().strength(150.0f,3600000.0f).sound(SoundType.STONE).mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).pushReaction(PushReaction.BLOCK).isValidSpawn((state, level, pos, value) -> false).requiresCorrectToolForDrops());
    }

    @Override
    public MutableComponent getName() {
        return Blocks.BEDROCK.getName();
    }
}
