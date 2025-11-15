package com.KanasakiTechnologics.CreateAssembly.fluid;

import net.neoforged.neoforge.fluids.BaseFlowingFluid;

public abstract class MoltenRedstoneFluid {
    public static class Source extends BaseFlowingFluid.Source {
        public Source(Properties props) {
            super(props);
        }
    }

    public static class Flowing extends BaseFlowingFluid.Flowing {
        public Flowing(Properties props) {
            super(props);
        }
    }
}
