package com.KanasakiTechnologics.CreateAssembly.datagen;

import com.KanasakiTechnologics.CreateAssembly.block.AsmBlocks;
import com.KanasakiTechnologics.CreateAssembly.block.LightBlocks;
import com.KanasakiTechnologics.CreateAssembly.item.AsmItems;
import com.KanasakiTechnologics.CreateAssembly.util.AsmTags;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeBuilder;
import com.simibubi.create.content.processing.recipe.StandardProcessingRecipe;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import plus.dragons.createdragonsplus.common.kinetics.fan.ending.EndingRecipe;
import com.tterrag.registrate.providers.RegistrateRecipeProvider;


import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

import static com.KanasakiTechnologics.CreateAssembly.CreateAssembly.MOD_ID;
import static net.minecraft.world.item.Items.*;
import static plus.dragons.createdragonsplus.common.CDPCommon.REGISTRATE;

public class AsmVanillaRecipesProvider extends RecipeProvider implements IConditionBuilder {
    List<ItemLike> TIN_SMELTABLES = List.of(AsmItems.RAW_TIN, AsmBlocks.TIN_ORE,AsmBlocks.DEEPSLATE_TIN_ORE);
    List<ItemLike> SILVER_SMELTABLES = List.of(AsmItems.RAW_SILVER, AsmBlocks.SILVER_ORE,AsmBlocks.DEEPSLATE_SILVER_ORE);
    List<ItemLike> RAW_RUBBER = List.of(AsmItems.RAW_RUBBER);

    public AsmVanillaRecipesProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, AsmBlocks.STAR_BLOCK,1)
                .pattern("NNN")
                .pattern("NNN")
                .pattern("NNN")
                .define('N', Items.NETHER_STAR)
                .unlockedBy("has_nether_star",has(Items.NETHER_STAR)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,Items.NETHER_STAR,9)
                .requires(AsmBlocks.STAR_BLOCK)
                .unlockedBy("has_nether_star",has(Items.NETHER_STAR))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, AllBlocks.PACKAGE_FROGPORT,3)
                .pattern(" S ")
                .pattern(" I ")
                .pattern(" K ")
                .define('I', AllBlocks.ITEM_VAULT)
                .define('S', Items.SLIME_BALL)
                .define('K', AsmItems.KINETIC_MECHANISM)
                .unlockedBy("has_kinetic_mechanism",has(AsmItems.KINETIC_MECHANISM)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, AllBlocks.PACKAGER,4)
                .pattern("IKI")
                .pattern("ICI")
                .pattern("RIR")
                .define('I', Items.IRON_INGOT)
                .define('R', Items.REDSTONE)
                .define('C', AllBlocks.CARDBOARD_BLOCK)
                .define('K', AsmItems.KINETIC_MECHANISM)
                .unlockedBy("has_kinetic_mechanism",has(AsmItems.KINETIC_MECHANISM)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, AllItems.VERTICAL_GEARBOX,6)
                .pattern(" G ")
                .pattern(" K ")
                .pattern("   ")
                .define('G', AsmTags.ItemTags.GEARBOXES.tag)
                .define('K', AsmItems.KINETIC_MECHANISM)
                .unlockedBy("has_kinetic_mechanism",has(AsmItems.KINETIC_MECHANISM)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, AsmItems.COPPER_BACKPACK_SMITHING_TEMPLATE,1)
                .pattern("CIC")
                .pattern("IBI")
                .pattern("CIC")
                .define('C', AllBlocks.COPPER_CASING)
                .define('I', Items.COPPER_INGOT)
                .define('B', AsmItems.NETHERRACK_SHARD)
                .unlockedBy("has_copper_casing",has(AllBlocks.COPPER_CASING)).save(recipeOutput);


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, AllBlocks.GEARBOX,6)
                .pattern("   ")
                .pattern("GK ")
                .pattern("   ")
                .define('G', AsmTags.ItemTags.GEARBOXES.tag)
                .define('K', AsmItems.KINETIC_MECHANISM)
                .unlockedBy("has_kinetic_mechanism",has(AsmItems.KINETIC_MECHANISM)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, AllBlocks.CRUSHING_WHEEL,2)
                .pattern(" K ")
                .pattern(" C ")
                .pattern(" S ")
                .define('C', AllBlocks.CRUSHING_WHEEL)
                .define('K', AsmItems.KINETIC_MECHANISM)
                .define('S', Ingredient.of(AsmTags.commonItemTag("stones")))
                .unlockedBy("has_kinetic_mechanism",has(AsmItems.KINETIC_MECHANISM)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, AllBlocks.DEPLOYER,3)
                .pattern(" K ")
                .pattern(" A ")
                .pattern(" B ")
                .define('A', AllBlocks.ANDESITE_CASING)
                .define('K', AsmItems.KINETIC_MECHANISM)
                .define('B', AllItems.BRASS_HAND)
                .unlockedBy("has_kinetic_mechanism",has(AsmItems.KINETIC_MECHANISM)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, AllBlocks.REDSTONE_CONTACT,4)
                .pattern(" B ")
                .pattern(" A ")
                .pattern(" K ")
                .define('A', AllBlocks.ANDESITE_CASING)
                .define('K', AsmItems.KINETIC_MECHANISM)
                .define('B', ItemTags.BUTTONS)
                .unlockedBy("has_kinetic_mechanism",has(AsmItems.KINETIC_MECHANISM)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, AllBlocks.MECHANICAL_ROLLER,3)
                .pattern(" K ")
                .pattern(" A ")
                .pattern(" C ")
                .define('A', AllBlocks.ANDESITE_CASING)
                .define('K', AsmItems.KINETIC_MECHANISM)
                .define('C', AllBlocks.CRUSHING_WHEEL)
                .unlockedBy("has_kinetic_mechanism",has(AsmItems.KINETIC_MECHANISM)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, AllBlocks.PORTABLE_STORAGE_INTERFACE,4)
                .pattern("   ")
                .pattern("AK ")
                .pattern("   ")
                .define('A', AllBlocks.ANDESITE_CASING)
                .define('K', AsmItems.KINETIC_MECHANISM)
                .unlockedBy("has_kinetic_mechanism",has(AsmItems.KINETIC_MECHANISM)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, AllBlocks.STEAM_ENGINE,6)
                .pattern(" G ")
                .pattern(" S ")
                .pattern(" C ")
                .define('G', AllItems.GOLDEN_SHEET)
                .define('S', AsmItems.SEALED_MECHANISM)
                .define('C', Blocks.COPPER_BLOCK)
                .unlockedBy("has_sealed_mechanism",has(AsmItems.SEALED_MECHANISM)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, AllBlocks.SPOUT,6)
                .pattern("   ")
                .pattern(" C ")
                .pattern(" S ")
                .define('S', AsmItems.SEALED_MECHANISM)
                .define('C', AllBlocks.COPPER_CASING)
                .unlockedBy("has_sealed_mechanism",has(AsmItems.SEALED_MECHANISM)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, AllBlocks.PORTABLE_FLUID_INTERFACE,4)
                .pattern("   ")
                .pattern("CS ")
                .pattern("   ")
                .define('S', AsmItems.SEALED_MECHANISM)
                .define('C', AllBlocks.COPPER_CASING)
                .unlockedBy("has_sealed_mechanism",has(AsmItems.SEALED_MECHANISM)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, AllBlocks.MECHANICAL_CRAFTER,5)
                .pattern(" I ")
                .pattern(" B ")
                .pattern(" C ")
                .define('B', AllBlocks.BRASS_CASING)
                .define('C', Blocks.CRAFTER)
                .define('I', AsmItems.INTEGRATED_MECHANISM)
                .unlockedBy("has_integrated_mechanism",has(AsmItems.INTEGRATED_MECHANISM)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, AllItems.TRANSMITTER,3)
                .pattern(" L ")
                .pattern("CCC")
                .pattern(" I ")
                .define('L', Blocks.LIGHTNING_ROD)
                .define('C', AllItems.COPPER_SHEET)
                .define('I',AsmItems.INTEGRATED_MECHANISM)
                .unlockedBy("has_integrated_mechanism",has(AsmItems.INTEGRATED_MECHANISM)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, AllBlocks.CONTRAPTION_CONTROLS,3)
                .pattern(" L ")
                .pattern(" T ")
                .pattern(" I ")
                .define('L', Items.LEVER)
                .define('T', AllBlocks.RAILWAY_CASING)
                .define('I',AsmItems.INTEGRATED_MECHANISM)
                .unlockedBy("has_integrated_mechanism",has(AsmItems.INTEGRATED_MECHANISM)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, AllBlocks.MECHANICAL_ARM,3)
                .pattern("BBA")
                .pattern("B  ")
                .pattern("IC ")
                .define('B', AllItems.BRASS_SHEET)
                .define('A', AllItems.ANDESITE_ALLOY)
                .define('I',AsmItems.INTEGRATED_MECHANISM)
                .define('C',AllBlocks.BRASS_CASING)
                .unlockedBy("has_integrated_mechanism",has(AsmItems.INTEGRATED_MECHANISM)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, AllBlocks.DISPLAY_BOARD,12)
                .pattern("   ")
                .pattern("LCL")
                .pattern("   ")
                .define('L', AsmItems.LAPIS_ALLOY)
                .define('C', AsmItems.CALCULATION_MECHANISM)
                .unlockedBy("has_calculation_mechanism",has(AsmItems.CALCULATION_MECHANISM)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, AllBlocks.DISPLAY_BOARD,8)
                .pattern("   ")
                .pattern("ACA")
                .pattern("   ")
                .define('A', AllItems.ANDESITE_ALLOY)
                .define('C', AsmItems.CALCULATION_MECHANISM)
                .unlockedBy("has_calculation_mechanism",has(AsmItems.CALCULATION_MECHANISM)).save(recipeOutput,"minecraft:display_board_8");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Blocks.CRAFTER,2)
                .pattern(" D ")
                .pattern(" C ")
                .pattern(" T ")
                .define('D', Blocks.DROPPER)
                .define('T', Blocks.CRAFTING_TABLE)
                .define('C', AsmItems.CALCULATION_MECHANISM)
                .unlockedBy("has_calculation_mechanism",has(AsmItems.CALCULATION_MECHANISM)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, AllBlocks.FACTORY_GAUGE,6)
                .requires(AllItems.TRANSMITTER)
                .requires(AsmItems.CALCULATION_MECHANISM)
                .unlockedBy("has_calculation_mechanism",has(AsmItems.CALCULATION_MECHANISM))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Blocks.ENDER_CHEST,2)
                .pattern("OAO")
                .pattern("OCO")
                .pattern("OOO")
                .define('A', AsmItems.ABSTRUSE_MECHANISM)
                .define('C', Blocks.CHEST)
                .define('O', Blocks.OBSIDIAN)
                .unlockedBy("has_abstruce_mechanism",has(AsmItems.ABSTRUSE_MECHANISM)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, AllBlocks.BLAZE_BURNER)
                .pattern("BBB")
                .pattern("BSB")
                .pattern("BEB")
                .define('B', Items.BLAZE_ROD)
                .define('S', Blocks.SOUL_SAND)
                .define('E',AllItems.EMPTY_BLAZE_BURNER)
                .unlockedBy("has_blaze_rod",has(Items.BLAZE_ROD)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.CHEST,4)
                .pattern("LLL")
                .pattern("L L")
                .pattern("LLL")
                .define('L', ItemTags.LOGS)
                .unlockedBy("has_logs",has(ItemTags.LOGS)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.ENDER_PEARL)
                .pattern("FFF")
                .pattern("F F")
                .pattern("FFF")
                .define('F', AsmItems.ENDER_PEARL_FRAGMENT)
                .unlockedBy("has_ender_pearl_fragment",has(AsmItems.ENDER_PEARL_FRAGMENT)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, AsmItems.SHADOW_PICKAXE)
                .pattern("SSS")
                .pattern(" R ")
                .pattern(" R ")
                .define('S', AllItems.SHADOW_STEEL)
                .define('R', AsmItems.RADIANT_HANDLE)
                .unlockedBy("has_shadow_steel",has(AllItems.SHADOW_STEEL)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, AsmItems.SHADOW_MATTOCK)
                .pattern("SSS")
                .pattern("SR ")
                .pattern(" R ")
                .define('S', AllItems.SHADOW_STEEL)
                .define('R', AsmItems.RADIANT_HANDLE)
                .unlockedBy("has_shadow_steel",has(AllItems.SHADOW_STEEL)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, AsmItems.SHADOW_SWORD)
                .pattern(" S ")
                .pattern(" S ")
                .pattern(" R ")
                .define('S', AllItems.SHADOW_STEEL)
                .define('R', AsmItems.RADIANT_HANDLE)
                .unlockedBy("has_shadow_steel",has(AllItems.SHADOW_STEEL)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.ENDER_EYE)
                .pattern("FFF")
                .pattern("FBF")
                .pattern("FFF")
                .define('F', AsmItems.ENDER_PEARL_FRAGMENT)
                .define('B', Items.BLAZE_POWDER)
                .unlockedBy("has_ender_pearl_fragment",has(AsmItems.ENDER_PEARL_FRAGMENT)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,AsmItems.BLANK_CATALYST,2)
                .pattern("SSS")
                .pattern("SBS")
                .pattern("SSS")
                .define('S', AsmItems.NETHER_STAR_SHARD)
                .define('B', AsmItems.BLANK_CATALYST)
                .unlockedBy("has_catalyst",has(AsmItems.BLANK_CATALYST)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,AsmItems.CLONING_TEMPLATE,2)
                .pattern("CCC")
                .pattern("CBC")
                .pattern("CCC")
                .define('C', AsmTags.ItemTags.CHROMATIC_REWARDS.tag)
                .define('B', AsmItems.CLONING_TEMPLATE)
                .unlockedBy("has_template",has(AsmItems.CLONING_TEMPLATE)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,Items.STRING,2)
                .requires(Ingredient.of(ItemTags.LEAVES),3)
                .unlockedBy("has_leaves",has(ItemTags.LEAVES))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,AsmItems.NETHER_STAR_SHARD,4)
                .requires(Ingredient.of(Items.NETHER_STAR))
                .unlockedBy("has_nether_star",has(Items.NETHER_STAR))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, AsmBlocks.RAW_SILVER_BLOCK)
                .requires(Ingredient.of(AsmItems.RAW_SILVER),9)
                .unlockedBy("has_silver",has(AsmItems.RAW_SILVER))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,AsmItems.RAW_SILVER,9)
                .requires(AsmBlocks.RAW_SILVER_BLOCK)
                .unlockedBy("has_silver",has(AsmBlocks.RAW_SILVER_BLOCK))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, AsmBlocks.SILVER_BLOCK)
                .requires(Ingredient.of(AsmItems.SILVER_INGOT),9)
                .unlockedBy("has_silver",has(AsmItems.SILVER_INGOT))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,AsmItems.SILVER_INGOT,9)
                .requires(AsmBlocks.SILVER_BLOCK)
                .unlockedBy("has_silver",has(AsmBlocks.SILVER_BLOCK))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, AsmItems.SILVER_INGOT)
                .requires(Ingredient.of(AsmItems.SILVER_NUGGET),9)
                .unlockedBy("has_silver",has(AsmItems.SILVER_NUGGET))
                .save(recipeOutput,"createassembly:silver_ingot_from_nugget");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,AsmItems.SILVER_NUGGET,9)
                .requires(AsmItems.SILVER_INGOT)
                .unlockedBy("has_silver",has(AsmItems.SILVER_INGOT))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, AsmBlocks.RAW_TIN_BLOCK)
                .requires(Ingredient.of(AsmItems.RAW_TIN),9)
                .unlockedBy("has_tin",has(AsmItems.RAW_TIN))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,AsmItems.RAW_TIN,9)
                .requires(AsmBlocks.RAW_TIN_BLOCK)
                .unlockedBy("has_tin",has(AsmBlocks.RAW_TIN_BLOCK))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, AsmBlocks.TIN_BLOCK)
                .requires(Ingredient.of(AsmItems.TIN_INGOT),9)
                .unlockedBy("has_tin",has(AsmItems.TIN_INGOT))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,AsmItems.TIN_INGOT,9)
                .requires(AsmBlocks.TIN_BLOCK)
                .unlockedBy("has_tin",has(AsmBlocks.TIN_BLOCK))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, AsmItems.TIN_INGOT)
                .requires(Ingredient.of(AsmItems.TIN_NUGGET),9)
                .unlockedBy("has_tin",has(AsmItems.TIN_NUGGET))
                .save(recipeOutput,"createassembly:tin_ingot_from_nugget");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,AsmItems.TIN_NUGGET,9)
                .requires(AsmItems.TIN_INGOT)
                .unlockedBy("has_tin",has(AsmItems.TIN_INGOT))
                .save(recipeOutput);

        templateduplicate(recipeOutput, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE);
        templateduplicate(recipeOutput, Items.SENTRY_ARMOR_TRIM_SMITHING_TEMPLATE, Items.SENTRY_ARMOR_TRIM_SMITHING_TEMPLATE);
        templateduplicate(recipeOutput, Items.DUNE_ARMOR_TRIM_SMITHING_TEMPLATE, Items.DUNE_ARMOR_TRIM_SMITHING_TEMPLATE);
        templateduplicate(recipeOutput, Items.COAST_ARMOR_TRIM_SMITHING_TEMPLATE, Items.COAST_ARMOR_TRIM_SMITHING_TEMPLATE);
        templateduplicate(recipeOutput, Items.WILD_ARMOR_TRIM_SMITHING_TEMPLATE, Items.WILD_ARMOR_TRIM_SMITHING_TEMPLATE);
        templateduplicate(recipeOutput, Items.WARD_ARMOR_TRIM_SMITHING_TEMPLATE, Items.WARD_ARMOR_TRIM_SMITHING_TEMPLATE);
        templateduplicate(recipeOutput, Items.EYE_ARMOR_TRIM_SMITHING_TEMPLATE, Items.EYE_ARMOR_TRIM_SMITHING_TEMPLATE);
        templateduplicate(recipeOutput, Items.VEX_ARMOR_TRIM_SMITHING_TEMPLATE, Items.VEX_ARMOR_TRIM_SMITHING_TEMPLATE);
        templateduplicate(recipeOutput, Items.TIDE_ARMOR_TRIM_SMITHING_TEMPLATE, Items.TIDE_ARMOR_TRIM_SMITHING_TEMPLATE);
        templateduplicate(recipeOutput, Items.SNOUT_ARMOR_TRIM_SMITHING_TEMPLATE, Items.SNOUT_ARMOR_TRIM_SMITHING_TEMPLATE);
        templateduplicate(recipeOutput, Items.RIB_ARMOR_TRIM_SMITHING_TEMPLATE, Items.RIB_ARMOR_TRIM_SMITHING_TEMPLATE);
        templateduplicate(recipeOutput, Items.SPIRE_ARMOR_TRIM_SMITHING_TEMPLATE, Items.SPIRE_ARMOR_TRIM_SMITHING_TEMPLATE);
        templateduplicate(recipeOutput, Items.WAYFINDER_ARMOR_TRIM_SMITHING_TEMPLATE, Items.WAYFINDER_ARMOR_TRIM_SMITHING_TEMPLATE);
        templateduplicate(recipeOutput, Items.SHAPER_ARMOR_TRIM_SMITHING_TEMPLATE, Items.SHAPER_ARMOR_TRIM_SMITHING_TEMPLATE);
        templateduplicate(recipeOutput, Items.SILENCE_ARMOR_TRIM_SMITHING_TEMPLATE, Items.SILENCE_ARMOR_TRIM_SMITHING_TEMPLATE);
        templateduplicate(recipeOutput, Items.RAISER_ARMOR_TRIM_SMITHING_TEMPLATE, Items.RAISER_ARMOR_TRIM_SMITHING_TEMPLATE);
        templateduplicate(recipeOutput, Items.HOST_ARMOR_TRIM_SMITHING_TEMPLATE, Items.HOST_ARMOR_TRIM_SMITHING_TEMPLATE);
        templateduplicate(recipeOutput, AsmItems.COPPER_BACKPACK_SMITHING_TEMPLATE.get(), AsmItems.COPPER_BACKPACK_SMITHING_TEMPLATE.get());

        recompressed(recipeOutput,AsmBlocks.COMPRESSED_COBBLESTONE.get(),Blocks.COBBLESTONE);
        recompressed(recipeOutput,AsmBlocks.COMPRESSED_SAND.get(),Blocks.SAND);
        recompressed(recipeOutput,AsmBlocks.COMPRESSED_SOUL_SAND.get(),Blocks.SOUL_SAND);
        recompressed(recipeOutput,AsmBlocks.COMPRESSED_RED_SAND.get(),Blocks.RED_SAND);
        recompressed(recipeOutput,AsmBlocks.COMPRESSED_COBBLED_DEEPSLATE.get(),Blocks.COBBLED_DEEPSLATE);
        recompressed(recipeOutput,AsmBlocks.COMPRESSED_GRAVEL.get(),Blocks.GRAVEL);

        oreSmelting(recipeOutput,TIN_SMELTABLES,RecipeCategory.MISC,AsmItems.TIN_INGOT.get(),0.25f,200,"tin");
        oreSmelting(recipeOutput,SILVER_SMELTABLES,RecipeCategory.MISC,AsmItems.SILVER_INGOT.get(),0.25f,200,"silver");
        oreSmelting(recipeOutput,RAW_RUBBER,RecipeCategory.MISC,AsmItems.RUBBER.get(),0.25f,200,"silver");
        oreBlasting(recipeOutput,TIN_SMELTABLES,RecipeCategory.MISC,AsmItems.TIN_INGOT.get(),0.50f,100,"tin");
        oreBlasting(recipeOutput,RAW_RUBBER,RecipeCategory.MISC,AsmItems.RUBBER.get(),0.50f,100,"tin");
        oreBlasting(recipeOutput,SILVER_SMELTABLES,RecipeCategory.MISC,AsmItems.SILVER_INGOT.get(),0.50f,100,"silver");

        oreRecycling(recipeOutput, AsmTags.commonItemTag("plates/tin"),RecipeCategory.MISC,AsmItems.TIN_INGOT.get(),0.50f,100,"tin");
        oreRecycling(recipeOutput, AsmTags.commonItemTag("plates/brass"),RecipeCategory.MISC,AllItems.BRASS_INGOT.get(),0.50f,100,"brass");
        oreRecycling(recipeOutput, AsmTags.commonItemTag("plates/zinc"),RecipeCategory.MISC,AllItems.ZINC_INGOT.get(),0.50f,100,"zinc");
        oreRecycling(recipeOutput, AsmTags.commonItemTag("plates/lapis"),RecipeCategory.MISC,AsmItems.LAPIS_ALLOY.get(),0.50f,100,"lapis");
        oreRecycling(recipeOutput, AsmTags.commonItemTag("plates/copper"),RecipeCategory.MISC,Items.COPPER_INGOT,0.50f,100,"copper");
        oreRecycling(recipeOutput, AsmTags.commonItemTag("plates/iron"),RecipeCategory.MISC,Items.COPPER_INGOT,0.50f,100,"iron");
        oreRecycling(recipeOutput, ItemTags.LEAVES,RecipeCategory.MISC,AsmItems.SAP_DROP.get(),0.25f,100,"sap_leaves");
        oreRecycling(recipeOutput, ItemTags.SAPLINGS,RecipeCategory.MISC,AsmItems.SAP_DROP.get(),0.25f,100,"sap_saplings");

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.NETHERRACK),RecipeCategory.MISC,AsmItems.NETHERRACK_SHARD,2).unlockedBy("has_netherrack",has(Blocks.NETHERRACK)).save(recipeOutput);

        concreteLight(recipeOutput, Items.WHITE_CONCRETE, LightBlocks.WHITE_LIGHT_BLOCK.get());
        concreteLight(recipeOutput, Items.LIGHT_GRAY_CONCRETE, LightBlocks.LIGHT_GRAY_LIGHT_BLOCK.get());
        concreteLight(recipeOutput, Items.GRAY_CONCRETE, LightBlocks.GRAY_LIGHT_BLOCK.get());
        concreteLight(recipeOutput, Items.BLACK_CONCRETE, LightBlocks.BLACK_LIGHT_BLOCK.get());
        concreteLight(recipeOutput, Items.BROWN_CONCRETE, LightBlocks.BROWN_LIGHT_BLOCK.get());
        concreteLight(recipeOutput, Items.RED_CONCRETE, LightBlocks.RED_LIGHT_BLOCK.get());
        concreteLight(recipeOutput, Items.ORANGE_CONCRETE, LightBlocks.ORANGE_LIGHT_BLOCK.get());
        concreteLight(recipeOutput, Items.YELLOW_CONCRETE, LightBlocks.YELLOW_LIGHT_BLOCK.get());
        concreteLight(recipeOutput, Items.LIME_CONCRETE, LightBlocks.LIME_LIGHT_BLOCK.get());
        concreteLight(recipeOutput, Items.GREEN_CONCRETE, LightBlocks.GREEN_LIGHT_BLOCK.get());
        concreteLight(recipeOutput, Items.CYAN_CONCRETE, LightBlocks.CYAN_LIGHT_BLOCK.get());
        concreteLight(recipeOutput, Items.LIGHT_BLUE_CONCRETE, LightBlocks.LIGHT_BLUE_LIGHT_BLOCK.get());
        concreteLight(recipeOutput, Items.BLUE_CONCRETE, LightBlocks.BLUE_LIGHT_BLOCK.get());
        concreteLight(recipeOutput, Items.PURPLE_CONCRETE, LightBlocks.PURPLE_LIGHT_BLOCK.get());
        concreteLight(recipeOutput, Items.MAGENTA_CONCRETE, LightBlocks.MAGENTA_LIGHT_BLOCK.get());
        concreteLight(recipeOutput, Items.PINK_CONCRETE, LightBlocks.PINK_LIGHT_BLOCK.get());
        glassLight(recipeOutput, Items.WHITE_STAINED_GLASS, LightBlocks.WHITE_GLASS_LIGHT_BLOCK.get());
        glassLight(recipeOutput, Items.LIGHT_GRAY_STAINED_GLASS, LightBlocks.LIGHT_GRAY_GLASS_LIGHT_BLOCK.get());
        glassLight(recipeOutput, Items.GRAY_STAINED_GLASS, LightBlocks.GRAY_GLASS_LIGHT_BLOCK.get());
        glassLight(recipeOutput, Items.BLACK_STAINED_GLASS, LightBlocks.BLACK_GLASS_LIGHT_BLOCK.get());
        glassLight(recipeOutput, Items.BROWN_STAINED_GLASS, LightBlocks.BROWN_GLASS_LIGHT_BLOCK.get());
        glassLight(recipeOutput, Items.RED_STAINED_GLASS, LightBlocks.RED_GLASS_LIGHT_BLOCK.get());
        glassLight(recipeOutput, Items.ORANGE_STAINED_GLASS, LightBlocks.ORANGE_GLASS_LIGHT_BLOCK.get());
        glassLight(recipeOutput, Items.YELLOW_STAINED_GLASS, LightBlocks.YELLOW_GLASS_LIGHT_BLOCK.get());
        glassLight(recipeOutput, Items.LIME_STAINED_GLASS, LightBlocks.LIME_GLASS_LIGHT_BLOCK.get());
        glassLight(recipeOutput, Items.GREEN_STAINED_GLASS, LightBlocks.GREEN_GLASS_LIGHT_BLOCK.get());
        glassLight(recipeOutput, Items.CYAN_STAINED_GLASS, LightBlocks.CYAN_GLASS_LIGHT_BLOCK.get());
        glassLight(recipeOutput, Items.LIGHT_BLUE_STAINED_GLASS, LightBlocks.LIGHT_BLUE_GLASS_LIGHT_BLOCK.get());
        glassLight(recipeOutput, Items.BLUE_STAINED_GLASS, LightBlocks.BLUE_GLASS_LIGHT_BLOCK.get());
        glassLight(recipeOutput, Items.PURPLE_STAINED_GLASS, LightBlocks.PURPLE_GLASS_LIGHT_BLOCK.get());
        glassLight(recipeOutput, Items.MAGENTA_STAINED_GLASS, LightBlocks.MAGENTA_GLASS_LIGHT_BLOCK.get());
        glassLight(recipeOutput, Items.PINK_STAINED_GLASS, LightBlocks.PINK_GLASS_LIGHT_BLOCK.get());
    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreRecycling(RecipeOutput recipeOutput, TagKey<Item> inputTag, RecipeCategory category, ItemLike result, float experience, int cookingTime, String group) {
        SimpleCookingRecipeBuilder.generic(Ingredient.of(inputTag),category, result, experience, cookingTime, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new).group(group).unlockedBy("has_" + group, has(inputTag)).save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MOD_ID, getItemName(result) + "_from_blasting_" + group));
    }


    private static void concreteLight(RecipeOutput out, Item concrete, Block result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result)
                .define('G', Items.GLOW_INK_SAC)
                .define('C', concrete)
                .pattern(" G ")
                .pattern("GCG")
                .pattern(" G ")
                .unlockedBy("has_glow_ink", has(Items.GLOW_INK_SAC))
                .save(out, id("light_block", result));
    }

    public static void templateduplicate(RecipeOutput out, Item template, Item result){
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,result,2)
                .requires(Ingredient.of(AsmItems.CLONING_TEMPLATE))
                .requires(Ingredient.of(template))
                .unlockedBy("has_template",has(AsmItems.CLONING_TEMPLATE))
                .save(out, ResourceLocation.fromNamespaceAndPath(MOD_ID, "template_duplication_" + BuiltInRegistries.ITEM.getKey(result).getPath()));
    }

    public static void recompressed(RecipeOutput out, Block compressed, Block result){
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,result,9)
                .requires(Ingredient.of(compressed))
                .unlockedBy("has_cobblestone",has(Blocks.COBBLESTONE))
                .save(out, ResourceLocation.fromNamespaceAndPath(MOD_ID, "recompressed_" + BuiltInRegistries.BLOCK.getKey(result).getPath()));
    }

    private static void glassLight(RecipeOutput out, Item glass, Block result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result)
                .define('G', Items.GLOW_INK_SAC)
                .define('X', glass)
                .pattern(" G ")
                .pattern("GXG")
                .pattern(" G ")
                .unlockedBy("has_glow_ink", has(Items.GLOW_INK_SAC))
                .save(out, id("light_glass_block", result));
    }


    private static ResourceLocation id(String folder, Block result) {
        ResourceLocation key = BuiltInRegistries.BLOCK.getKey(result);
        if (key == null) {
            throw new IllegalStateException("Unregistered block: " + result);
        }
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, folder + "/" + key.getPath());
    }
}
