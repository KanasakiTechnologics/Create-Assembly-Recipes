package com.KanasakiTechnologics.CreateAssembly.util;

import com.KanasakiTechnologics.CreateAssembly.CreateAssembly;
import net.createmod.catnip.lang.Lang;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;

import static com.KanasakiTechnologics.CreateAssembly.CreateAssembly.MOD_ID;

@SuppressWarnings("unused")
public class AsmTags {

    public static <T> TagKey<T> optionalTag(Registry<T> registry, ResourceLocation id) {
        return TagKey.create(registry.key(), id);
    }

    public static <T> TagKey<T> commonTag(Registry<T> registry, String path) {
        return optionalTag(registry, ResourceLocation.fromNamespaceAndPath("c", path));
    }

    public static<T>TagKey<T> minecraftTag(Registry<T> registry, String path){
        return optionalTag(registry, ResourceLocation.fromNamespaceAndPath("minecraft", path));
    }

    public static <T> TagKey<T> modTag(Registry<T> registry, String path) {
        return optionalTag(registry, ResourceLocation.fromNamespaceAndPath(MOD_ID, path));
    }

    public static TagKey<Block> commonBlockTag(String path) {return commonTag(BuiltInRegistries.BLOCK, path);}
    public static TagKey<Item> commonItemTag(String path) {return commonTag(BuiltInRegistries.ITEM, path);}
    public static TagKey<Item> minecraftItemTag(String path) {return minecraftTag(BuiltInRegistries.ITEM, path);}
    public static TagKey<Fluid> commonFluidTag(String path) {return commonTag(BuiltInRegistries.FLUID, path);}
    public static TagKey<Block> modBlockTag(String path) {return modTag(BuiltInRegistries.BLOCK, path);}
    public static TagKey<Item> modItemTag(String path) {return modTag(BuiltInRegistries.ITEM, path);}
    public static TagKey<Fluid> modFluidTag(String path) {return modTag(BuiltInRegistries.FLUID, path);}

    public enum NameSpace {
        MOD(MOD_ID, false, true),
        COMMON("c"),
        CREATE("create"),
        NEOFORGE("neoforge");

        public final String id;
        public final boolean optionalDefault;
        public final boolean alwaysDatagenDefault;

        NameSpace(String id) {
            this(id, true, false);
        }

        NameSpace(String id, boolean optionalDefault, boolean alwaysDatagenDefault) {
            this.id = id;
            this.optionalDefault = optionalDefault;
            this.alwaysDatagenDefault = alwaysDatagenDefault;
        }
    }

    public enum BlockTags {
        CREATE_WRENCH_PICKUP(NameSpace.CREATE, "wrench_pickup"),
        TIN_ORES(NameSpace.COMMON,"ores/tin"),
        SILVER_ORES(NameSpace.COMMON,"ores/silver"),
        NEEDS_NETHERITE_TOOL(NameSpace.NEOFORGE, "needs_netherite_tool"),
        COLORED_GLASS(NameSpace.MOD,"colored_glass"),
        COLOURED_CONCRETE(NameSpace.MOD,"colored_concrete"),
        ORES(NameSpace.COMMON,"ores"),
        LIFE_CORALS(NameSpace.MOD,"life_corals"),
        PRISMARINE_BUILDING_BLOCK(NameSpace.MOD,"prismarine_building_block"),
        RAW_TIN(NameSpace.COMMON,"storage_blocks/raw_tin"),
        TIN(NameSpace.COMMON,"storage_blocks/tin"),
        RAW_SILVER(NameSpace.COMMON,"storage_blocks/raw_silver"),
        SILVER(NameSpace.COMMON,"storage_blocks/silver"),
        FAN_PROCESSING_CATALYSTS_GLOWING(NameSpace.MOD, "fan_processing_catalysts/glowing");


        public final TagKey<Block> tag;
        public final boolean alwaysDatagen;

        BlockTags() { this(NameSpace.MOD); }
        BlockTags(NameSpace namespace) { this(namespace, namespace.optionalDefault, namespace.alwaysDatagenDefault); }
        BlockTags(NameSpace namespace, String path) { this(namespace, path, namespace.optionalDefault, namespace.alwaysDatagenDefault); }
        BlockTags(NameSpace namespace, boolean optional, boolean alwaysDatagen) { this(namespace, null, optional, alwaysDatagen); }
        BlockTags(NameSpace namespace, String path, boolean optional, boolean alwaysDatagen) {
            ResourceLocation id = ResourceLocation.fromNamespaceAndPath(namespace.id, path == null ? name().toLowerCase() : path);
            if (optional) tag = AsmTags.optionalTag(BuiltInRegistries.BLOCK, id);
            else tag = net.minecraft.tags.BlockTags.create(id);
            this.alwaysDatagen = alwaysDatagen;
        }
        @SuppressWarnings("deprecation")
        public boolean is(Block block) { return block.builtInRegistryHolder().is(tag); }
        public boolean is(ItemStack stack) { return stack != null && stack.getItem() instanceof BlockItem blockItem && is(blockItem.getBlock()); }
        public boolean is(ItemLike item) { return item instanceof BlockItem blockItem && is(blockItem.getBlock()); }
        public boolean is(BlockState state) {return state.is(tag);}
        public boolean is(TagKey<Block> tag) {return tag==this.tag;}

        private static void init() {}
    }

    public enum ItemTags {
        COMPLEX_MECHANISM(NameSpace.MOD,"complex_mechanism"),
        TIN_PLATES(NameSpace.COMMON,"plates/tin"),
        LIFE_CORALS(NameSpace.MOD,"life_corals"),
        LAPIS_PLATES(NameSpace.COMMON,"plates/lapis"),
        PRISMARINE_BUILDING_BLOCK(NameSpace.MOD,"prismarine_building_block"),
        PLATES(NameSpace.COMMON,"plates"),
        All_METAL(NameSpace.COMMON,"rods/all_metal"),
        ENDERIUM_ALLOY(NameSpace.COMMON,"rods/enderium"),
        RODS(NameSpace.COMMON,"rods"),
        ORES(NameSpace.COMMON,"ores"),
        RAW_TIN(NameSpace.COMMON,"storage_blocks/raw_tin"),
        RAW_TIN2(NameSpace.COMMON,"raw_materials/tin"),
        TIN(NameSpace.COMMON,"storage_blocks/tin"),
        RAW_SILVER(NameSpace.COMMON,"storage_blocks/raw_silver"),
        RAW_SILVER2(NameSpace.COMMON,"raw_materials/silver"),
        SILVER(NameSpace.COMMON,"storage_blocks/silver"),
        TIN_INGOT(NameSpace.COMMON,"ingots/tin"),
        TIN_NUGGET(NameSpace.COMMON,"nuggets/tin"),
        SILVER_INGOT(NameSpace.COMMON,"ingots/silver"),
        SILVER_NUGGET(NameSpace.COMMON,"nuggets/silver"),
        ENDER_POWDER(NameSpace.MOD,"ender_powder"),
        ENDERIUM_ALLOY2(NameSpace.COMMON,"ingots/enderium");


        public final TagKey<Item> tag;
        public final boolean alwaysDatagen;

        ItemTags() { this(NameSpace.MOD); }
        ItemTags(NameSpace namespace) { this(namespace, namespace.optionalDefault, namespace.alwaysDatagenDefault); }
        ItemTags(NameSpace namespace, String path) { this(namespace, path, namespace.optionalDefault, namespace.alwaysDatagenDefault); }
        ItemTags(NameSpace namespace, boolean optional, boolean alwaysDatagen) { this(namespace, null, optional, alwaysDatagen); }
        ItemTags(NameSpace namespace, String path, boolean optional, boolean alwaysDatagen) {
            ResourceLocation id = ResourceLocation.fromNamespaceAndPath(namespace.id, path == null ? Lang.asId(name()) : path);
            if (optional) tag = optionalTag(BuiltInRegistries.ITEM, id);
            else tag = net.minecraft.tags.ItemTags.create(id);
            this.alwaysDatagen = alwaysDatagen;
        }
        @SuppressWarnings("deprecation")
        public boolean matches(Item item) { return item.builtInRegistryHolder().is(tag); }
        public boolean matches(ItemStack stack) { return stack.is(tag); }
        private static void init() {}
    }

    public enum FluidTags {
        FAN_PROCESSING_CATALYSTS_GLOWING(NameSpace.MOD, "fan_processing_catalysts/glowing");

        public final TagKey<Fluid> tag;
        public final boolean alwaysDatagen;

        FluidTags() { this(NameSpace.MOD); }
        FluidTags(NameSpace namespace) { this(namespace, namespace.optionalDefault, namespace.alwaysDatagenDefault); }
        FluidTags(NameSpace namespace, String path) { this(namespace, path, namespace.optionalDefault, namespace.alwaysDatagenDefault); }
        FluidTags(NameSpace namespace, boolean optional, boolean alwaysDatagen) { this(namespace, null, optional, alwaysDatagen); }
        FluidTags(NameSpace namespace, String path, boolean optional, boolean alwaysDatagen) {
            ResourceLocation id = ResourceLocation.fromNamespaceAndPath(namespace.id, path == null ? Lang.asId(name()) : path);
            if (optional) tag = optionalTag(BuiltInRegistries.FLUID, id);
            else tag = net.minecraft.tags.FluidTags.create(id);
            this.alwaysDatagen = alwaysDatagen;
        }
        @SuppressWarnings("deprecation")
        public boolean is(Fluid fluid) { return fluid.builtInRegistryHolder().is(tag); }
        public boolean is(ItemStack stack) { return stack != null && stack.getItem() instanceof BucketItem bucket && is(bucket.content); }
        public boolean is(ItemLike item) { return item instanceof BucketItem bucket && is(bucket.content); }
        public boolean is(FluidState state) {return state.is(tag);}
        public boolean is(TagKey<Fluid> tag) {return tag==this.tag;}

        private static void init() {}
    }

    public static void init() {
        BlockTags.init();
        ItemTags.init();
        FluidTags.init();
    }
}

