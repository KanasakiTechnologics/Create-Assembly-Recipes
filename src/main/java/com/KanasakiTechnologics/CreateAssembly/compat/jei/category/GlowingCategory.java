package com.KanasakiTechnologics.CreateAssembly.compat.jei.category;

import com.KanasakiTechnologics.CreateAssembly.content.recipes.GlowingRecipe;
import com.KanasakiTechnologics.CreateAssembly.fluid.AsmFluid;
import com.KanasakiTechnologics.CreateAssembly.item.AsmItems;
import com.simibubi.create.compat.jei.category.ProcessingViaFanCategory;
import com.simibubi.create.compat.jei.category.animations.AnimatedKinetics;
import com.simibubi.create.foundation.gui.AllGuiTextures;
import net.createmod.catnip.gui.element.GuiGameElement;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.level.material.Fluid;
import org.jetbrains.annotations.NotNull;


public class GlowingCategory extends ProcessingViaFanCategory.MultiOutput<GlowingRecipe> {
    public GlowingCategory(Info<GlowingRecipe> info) {
        super(info);
    }
    @Override
    protected AllGuiTextures getBlockShadow() {
        return AllGuiTextures.JEI_LIGHT;
    }

    @Override
    protected void renderAttachedBlock(GuiGraphics graphics) {
        GuiGameElement.of(AsmFluid.GLOW_INK.get())
                .scale(SCALE)
                .atLocal(0,0,2)
                .lighting(AnimatedKinetics.DEFAULT_LIGHTING)
                .render(graphics);

    }
}
