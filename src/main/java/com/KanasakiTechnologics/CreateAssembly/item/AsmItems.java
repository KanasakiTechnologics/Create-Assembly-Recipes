package com.KanasakiTechnologics.CreateAssembly.item;

import com.KanasakiTechnologics.CreateAssembly.CreateAssembly;
import com.KanasakiTechnologics.CreateAssembly.fluid.AsmFluid;
import com.KanasakiTechnologics.CreateAssembly.util.AsmTags;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class AsmItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CreateAssembly.MOD_ID);

    public static final DeferredItem<PickaxeItem> SHADOW_PICKAXE = ITEMS.register("shadow_steel_pickaxe",ShadowPickaxe::new);
    public static final DeferredItem<PickaxeItem> SHADOW_SWORD = ITEMS.register("shadow_steel_sword",
            () -> new PickaxeItem(AsmTags.SHADOW_TIER,new Item.Properties().attributes(PickaxeItem.createAttributes(AsmTags.SHADOW_TIER,10, 3.0f))));
    public static final DeferredItem<ShadowMattock> SHADOW_MATTOCK = ITEMS.register("shadow_steel_mattock",
            () -> new ShadowMattock(AsmTags.SHADOW_TIER, new Item.Properties().attributes(ShadowMattock.createAttributes(AsmTags.SHADOW_TIER, 15.0F, -3.0F))));


    public static final DeferredItem<Item> TIN_INGOT = ITEMS.register("tin_ingot",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RAW_TIN = ITEMS.register("raw_tin",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> TIN_NUGGET = ITEMS.register("tin_nugget",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> TIN_SHEET = ITEMS.register("tin_sheet",
            () -> new Item(new Item.Properties()));


    public static final DeferredItem<Item> SILVER_INGOT = ITEMS.register("silver_ingot",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RAW_SILVER = ITEMS.register("raw_silver",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SILVER_NUGGET = ITEMS.register("silver_nugget",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> NETHER_STAR_SHARD = ITEMS.register("nether_star_shard",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));

    public static final DeferredItem<Item> BLANK_CATALYST = ITEMS.register("blank_catalyst",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE)));
    public static final DeferredItem<Item> SHADOW_CATALYST = ITEMS.register("shadow_catalyst",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(1).durability(100)));
    public static final DeferredItem<Item> RADIANT_CATALYST = ITEMS.register("radiant_catalyst",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(1).durability(100)));

    public static final DeferredItem<Item> ENDER_PEARL_FRAGMENT = ITEMS.register("ender_pearl_fragment",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RADIANT_HANDLE = ITEMS.register("radiant_handle",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> GLOW_INK_BUCKET = ITEMS.register("glow_ink_bucket",
            ()-> new BucketItem(AsmFluid.GLOW_INK.get(),new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).durability(0)));
    public static final DeferredItem<Item> SOUL_LAVA_BUCKET = ITEMS.register("soul_lava_bucket",
            ()-> new BucketItem(AsmFluid.SOUL_LAVA.get(),new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).durability(0)));
    public static final DeferredItem<Item> SULFURIC_ACID_BUCKET = ITEMS.register("sulfuric_acid_bucket",
            ()-> new BucketItem(AsmFluid.SULFURIC_ACID.get(),new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).durability(0)));

    public static final DeferredItem<Item> ABSTRUSE_MECHANISM = ITEMS.register("abstruse_mechanism",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> CALCULATION_MECHANISM = ITEMS.register("calculation_mechanism",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> INFERNAL_MECHANISM = ITEMS.register("infernal_mechanism",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> INTEGRATED_CIRCUIT = ITEMS.register("integrated_circuit",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> INTEGRATED_MECHANISM = ITEMS.register("integrated_mechanism",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> KINETIC_MECHANISM = ITEMS.register("kinetic_mechanism",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SEALED_MECHANISM = ITEMS.register("sealed_mechanism",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> INCOMPLETE_ABSTRUSE_MECHANISM = ITEMS.register("incomplete_abstruse_mechanism",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> INCOMPLETE_CALCULATION_MECHANISM = ITEMS.register("incomplete_calculation_mechanism",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> INCOMPLETE_INFERNAL_MECHANISM = ITEMS.register("incomplete_infernal_mechanism",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> INCOMPLETE_INTEGRATED_CIRCUIT = ITEMS.register("incomplete_integrated_circuit",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> INCOMPLETE_INTEGRATED_MECHANISM = ITEMS.register("incomplete_integrated_mechanism",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> INCOMPLETE_KINETIC_MECHANISM = ITEMS.register("incomplete_kinetic_mechanism",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> INCOMPLETE_SEALED_MECHANISM = ITEMS.register("incomplete_sealed_mechanism",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> INCOMPLETE_ELYTRA = ITEMS.register("incomplete_elytra",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SULFUR = ITEMS.register("sulfur",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SULFUR_CHUNK = ITEMS.register("sulfur_chunk",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> CLONING_TEMPLATE = ITEMS.register("cloning_template",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> LAPIS_ALLOY = ITEMS.register("lapis_alloy",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> LAPIS_SHEET = ITEMS.register("lapis_sheet",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> COAL_ROD = ITEMS.register("coal_rod",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> INCOMPLETE_BLAZE_ROD = ITEMS.register("incomplete_blaze_rod",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SAP_DROP = ITEMS.register("sap_drop",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SAP_BUCKET = ITEMS.register("sap_bucket",
            ()-> new BucketItem(AsmFluid.SAP.get(),new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).durability(0)));

    public static final DeferredItem<Item> ROUGH_DIAMOND = ITEMS.register("rough_diamond",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> POLISHED_DIAMOND = ITEMS.register("polished_diamond",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SILVER_JEWEL = ITEMS.register("silver_jewel",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> ELECTRUM_JEWEL = ITEMS.register("electrum_jewel",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> UNCOMPLETED_TOTEM_OF_UNDYING = ITEMS.register("uncompleted_totem_of_undying",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> ALCHEMIST_DUST = ITEMS.register("alchemist_dust",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> FUSED_BLEND = ITEMS.register("fused_blend",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> NETHERITE_DUST = ITEMS.register("netherite_dust",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> UNPROCESSED_NETHERITE_DUST = ITEMS.register("unprocessed_netherite_dust",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> NETHERRACK_SHARD = ITEMS.register("netherrack_shard",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> UNCOMPLETED_NETHERITE_TEMPLATE = ITEMS.register("uncompleted_template",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RAW_RUBBER = ITEMS.register("raw_rubber",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RUBBER = ITEMS.register("rubber",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> INACTIVE_BLAZE_CORE = ITEMS.register("inactive_blaze_core",
            () -> new Item(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON)));

    public static final DeferredItem<Item> BLAZE_CORE = ITEMS.register("blaze_core",
            () -> new BlazeCore(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON)));

    public static final DeferredItem<Item> SUPERHEATED_BLAZE_CORE = ITEMS.register("superheated_blaze_core",
            () -> new BlazeCore(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON)));


    public static void register(IEventBus eventBus){ITEMS.register(eventBus);}
}
