package com.KanasakiTechnologics.CreateAssembly.block;

import com.KanasakiTechnologics.CreateAssembly.fluid.AsmFluid;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.MapColor;

public class SulfuricAcidBlock extends LiquidBlock {
    public SulfuricAcidBlock() {
        super((FlowingFluid) AsmFluid.SULFURIC_ACID.get(),BlockBehaviour.Properties.of().mapColor(MapColor.WATER).noCollission().strength(100f).noLootTable().replaceable());
    }

}
