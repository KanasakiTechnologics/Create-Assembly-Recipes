package com.KanasakiTechnologics.CreateAssembly.compat.jei.category;

import com.KanasakiTechnologics.CreateAssembly.content.recipes.EnrichingRecipe;
import com.KanasakiTechnologics.CreateAssembly.fluid.AsmFluid;
import com.simibubi.create.compat.jei.category.ProcessingViaFanCategory;
import com.simibubi.create.compat.jei.category.animations.AnimatedKinetics;
import com.simibubi.create.foundation.gui.AllGuiTextures;
import net.createmod.catnip.gui.element.GuiGameElement;
import net.minecraft.client.gui.GuiGraphics;


public class EnrichingCategory extends ProcessingViaFanCategory.MultiOutput<EnrichingRecipe> {
    public EnrichingCategory(Info<EnrichingRecipe> info) {
        super(info);
    }
    @Override
    protected AllGuiTextures getBlockShadow() {
        return AllGuiTextures.JEI_LIGHT;
    }

    @Override
    protected void renderAttachedBlock(GuiGraphics graphics) {
        GuiGameElement.of(AsmFluid.REFINED_RADIANCE.get())
                .scale(SCALE)
                .atLocal(0,0,2)
                .lighting(AnimatedKinetics.DEFAULT_LIGHTING)
                .render(graphics);

    }
}
