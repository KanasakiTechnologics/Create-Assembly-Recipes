package com.KanasakiTechnologics.CreateAssembly.util;

import com.KanasakiTechnologics.CreateAssembly.CreateAssembly;
import com.simibubi.create.AllItems; // <-- Import Create's AllItems
import net.createmod.catnip.lang.Lang;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.neoforged.neoforge.common.SimpleTier;

import static com.KanasakiTechnologics.CreateAssembly.CreateAssembly.MOD_ID;

@SuppressWarnings("unused")
public class AsmTags {

    public static <T> TagKey<T> optionalTag(Registry<T> registry, ResourceLocation id) {
        return TagKey.create(registry.key(), id);
    }

    public static <T> TagKey<T> commonTag(Registry<T> registry, String path) {
        return optionalTag(registry, ResourceLocation.fromNamespaceAndPath("c", path));
    }

    public static <T> TagKey<T> minecraftTag(Registry<T> registry, String path) {
        return optionalTag(registry, ResourceLocation.fromNamespaceAndPath("minecraft", path));
    }

    public static <T> TagKey<T> modTag(Registry<T> registry, String path) {
        return optionalTag(registry, ResourceLocation.fromNamespaceAndPath(MOD_ID, path));
    }

    public static TagKey<Block> commonBlockTag(String path) {
        return commonTag(BuiltInRegistries.BLOCK, path);
    }

    public static TagKey<Item> commonItemTag(String path) {
        return commonTag(BuiltInRegistries.ITEM, path);
    }

    public static TagKey<Item> minecraftItemTag(String path) {
        return minecraftTag(BuiltInRegistries.ITEM, path);
    }

    public static TagKey<Fluid> commonFluidTag(String path) {
        return commonTag(BuiltInRegistries.FLUID, path);
    }

    public static TagKey<Block> modBlockTag(String path) {
        return modTag(BuiltInRegistries.BLOCK, path);
    }

    public static TagKey<Item> modItemTag(String path) {
        return modTag(BuiltInRegistries.ITEM, path);
    }

    public static TagKey<Fluid> modFluidTag(String path) {
        return modTag(BuiltInRegistries.FLUID, path);
    }

    public static final Tier SHADOW_TIER = new SimpleTier(
            AsmTags.BlockTags.INCORRECT_FOR_SHADOW_TOOL.tag,
            2500,
            6.0f,
            3.5f,
            4,
            () -> Ingredient.of(AllItems.SHADOW_STEEL.get())
    );

    public enum NameSpace {
        MOD(MOD_ID, false, true),
        COMMON("c"),
        CREATE("create"),
        MINECRAFT("minecraft"),
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
        TIN_ORES(NameSpace.COMMON, "ores/tin"),
        SILVER_ORES(NameSpace.COMMON, "ores/silver"),
        NEEDS_NETHERITE_TOOL(NameSpace.NEOFORGE, "needs_netherite_tool"),
        COLORED_GLASS(NameSpace.MOD, "colored_glass"),
        COLOURED_CONCRETE(NameSpace.MOD, "colored_concrete"),
        ORES(NameSpace.COMMON, "ores"),
        LIFE_CORALS(NameSpace.MOD, "life_corals"),
        PRISMARINE_BUILDING_BLOCK(NameSpace.MOD, "prismarine_building_block"),
        RAW_TIN(NameSpace.COMMON, "storage_blocks/raw_tin"),
        TIN(NameSpace.COMMON, "storage_blocks/tin"),
        RAW_SILVER(NameSpace.COMMON, "storage_blocks/raw_silver"),
        SILVER(NameSpace.COMMON, "storage_blocks/silver"),
        COBBLESTONE(NameSpace.COMMON, "storage_blocks/cobblestone"),
        COBBLED_DEEPSLATE(NameSpace.COMMON, "storage_blocks/cobbled_deepslate"),
        SAND(NameSpace.COMMON, "storage_blocks/sand"),
        RED_SAND(NameSpace.COMMON, "storage_blocks/red_sand"),
        SOUL_SAND(NameSpace.COMMON, "storage_blocks/soul_sand"),
        COMPRESSED_SAND(NameSpace.MOD, "compressed_sand"),
        COMPRESSED_COBBLESTONE(NameSpace.MOD, "compressed_cobblestone"),
        GRAVEL(NameSpace.COMMON, "storage_blocks/gravel"),
        SANDS(NameSpace.COMMON,"sands"),
        SAND2(NameSpace.COMMON, "sands/sand"),
        RED_SAND2(NameSpace.COMMON, "sands/red_sand"),
        SOUL_SAND2(NameSpace.COMMON, "sands/soul_sand"),
        NETHER_STAR(NameSpace.COMMON, "storage_blocks/nether_star"),
        NEEDS_SHADOW_TOOL(NameSpace.COMMON, "needs_shadow_tool"),
        INCORRECT_FOR_SHADOW_TOOL(NameSpace.COMMON, "incorrect_for_shadow_tool"),
        MINEABLE_WITH_SHADOW_MATTOCK(NameSpace.MOD,"mineable_with_shadow_mattock"),
        NETHER_SOUL(NameSpace.MINECRAFT,"nether_soul"),
        FAN_PROCESSING_CATALYSTS_GLOWING(NameSpace.MOD, "fan_processing_catalysts/glowing");

        public final TagKey<Block> tag;
        public final boolean alwaysDatagen;

        BlockTags() {
            this(NameSpace.MOD);
        }

        BlockTags(NameSpace namespace) {
            this(namespace, namespace.optionalDefault, namespace.alwaysDatagenDefault);
        }

        BlockTags(NameSpace namespace, String path) {
            this(namespace, path, namespace.optionalDefault, namespace.alwaysDatagenDefault);
        }

        BlockTags(NameSpace namespace, boolean optional, boolean alwaysDatagen) {
            this(namespace, null, optional, alwaysDatagen);
        }

        BlockTags(NameSpace namespace, String path, boolean optional, boolean alwaysDatagen) {
            ResourceLocation id = ResourceLocation.fromNamespaceAndPath(namespace.id, path == null ? name().toLowerCase() : path);
            if (optional)
                tag = AsmTags.optionalTag(BuiltInRegistries.BLOCK, id);
            else
                tag = net.minecraft.tags.BlockTags.create(id);
            this.alwaysDatagen = alwaysDatagen;
        }

        @SuppressWarnings("deprecation")
        public boolean is(Block block) {
            return block.builtInRegistryHolder().is(tag);
        }

        public boolean is(ItemStack stack) {
            return stack != null && stack.getItem() instanceof BlockItem blockItem && is(blockItem.getBlock());
        }

        public boolean is(ItemLike item) {
            return item instanceof BlockItem blockItem && is(blockItem.getBlock());
        }

        public boolean is(BlockState state) {
            return state.is(tag);
        }

        public boolean is(TagKey<Block> tag) {
            return tag == this.tag;
        }

        private static void init() {}
    }

    public enum ItemTags {
        COMPLEX_MECHANISM(NameSpace.MOD, "complex_mechanism"),
        UPRIGHT_ON_BELT(NameSpace.CREATE,"upright_on_belt"),
        TIN_PLATES(NameSpace.COMMON, "plates/tin"),
        LIFE_CORALS(NameSpace.MOD, "life_corals"),
        LAPIS_PLATES(NameSpace.COMMON, "plates/lapis"),
        GRAVEL(NameSpace.COMMON, "storage_blocks/gravel"),
        NETHER_STAR(NameSpace.COMMON, "storage_blocks/nether_star"),
        PRISMARINE_BUILDING_BLOCK(NameSpace.MOD, "prismarine_building_block"),
        PLATES(NameSpace.COMMON, "plates"),
        All_METAL(NameSpace.COMMON, "rods/all_metal"),
        REFINED_RADIANCE(NameSpace.COMMON, "rods/radiant"),
        COMPRESSED_COBBLESTONE(NameSpace.MOD, "compressed_cobblestone"),
        RODS(NameSpace.COMMON, "rods"),
        ORES(NameSpace.COMMON, "ores"),
        SHADOW_CATALYST_REQUIRED(NameSpace.COMMON, "shadow_catalyst_required"),
        RADIANCE_CATALYST_REQUIRED(NameSpace.COMMON, "radiance_catalyst_required"),
        RAW_TIN(NameSpace.COMMON, "storage_blocks/raw_tin"),
        NETHER_SOUL(NameSpace.MINECRAFT,"nether_soul"),
        RAW_TIN2(NameSpace.COMMON, "raw_materials/tin"),
        TIN(NameSpace.COMMON, "storage_blocks/tin"),
        COBBLESTONE(NameSpace.COMMON, "storage_blocks/cobblestone"),
        COBBLED_DEEPSLATE(NameSpace.COMMON, "storage_blocks/cobbled_deepslate"),
        SAND(NameSpace.COMMON, "storage_blocks/sand"),
        RED_SAND(NameSpace.COMMON, "storage_blocks/red_sand"),
        SOUL_SAND(NameSpace.COMMON, "storage_blocks/soul_sand"),
        SANDS(NameSpace.COMMON,"sands"),
        SAND2(NameSpace.COMMON, "sands/sand"),
        RED_SAND2(NameSpace.COMMON, "sands/red_sand"),
        SOUL_SAND2(NameSpace.COMMON, "sands/soul_sand"),
        RAW_SILVER(NameSpace.COMMON, "storage_blocks/raw_silver"),
        RAW_SILVER2(NameSpace.COMMON, "raw_materials/silver"),
        SILVER(NameSpace.COMMON, "storage_blocks/silver"),
        TIN_INGOT(NameSpace.COMMON, "ingots/tin"),
        REFINED_RADIANCE2(NameSpace.COMMON, "ingots/radiant"),
        TIN_NUGGET(NameSpace.COMMON, "nuggets/tin"),
        SILVER_INGOT(NameSpace.COMMON, "ingots/silver"),
        SILVER_NUGGET(NameSpace.COMMON, "nuggets/silver"),
        ENDER_POWDER(NameSpace.MOD, "ender_powder"),
        CHROMATIC_REWARDS(NameSpace.CREATE,"chromoatic_rewards"),
        GEARBOXES(NameSpace.CREATE, "gearboxes"),
        COMPRESSED_SAND(NameSpace.MOD, "compressed_sand");

        public final TagKey<Item> tag;
        public final boolean alwaysDatagen;

        ItemTags() {
            this(NameSpace.MOD);
        }

        ItemTags(NameSpace namespace) {
            this(namespace, namespace.optionalDefault, namespace.alwaysDatagenDefault);
        }

        ItemTags(NameSpace namespace, String path) {
            this(namespace, path, namespace.optionalDefault, namespace.alwaysDatagenDefault);
        }

        ItemTags(NameSpace namespace, boolean optional, boolean alwaysDatagen) {
            this(namespace, null, optional, alwaysDatagen);
        }

        ItemTags(NameSpace namespace, String path, boolean optional, boolean alwaysDatagen) {
            ResourceLocation id = ResourceLocation.fromNamespaceAndPath(namespace.id, path == null ? Lang.asId(name()) : path);
            if (optional)
                tag = optionalTag(BuiltInRegistries.ITEM, id);
            else
                tag = net.minecraft.tags.ItemTags.create(id);
            this.alwaysDatagen = alwaysDatagen;
        }

        @SuppressWarnings("deprecation")
        public boolean matches(Item item) {
            return item.builtInRegistryHolder().is(tag);
        }

        public boolean matches(ItemStack stack) {
            return stack.is(tag);
        }

        private static void init() {}
    }

    public enum FluidTags {
        FAN_PROCESSING_CATALYSTS_GLOWING(NameSpace.MOD, "fan_processing_catalysts/glowing"),
        SOUL_LAVA(NameSpace.COMMON,"soul_lava");

        public final TagKey<Fluid> tag;
        public final boolean alwaysDatagen;

        FluidTags() {
            this(NameSpace.MOD);
        }

        FluidTags(NameSpace namespace) {
            this(namespace, namespace.optionalDefault, namespace.alwaysDatagenDefault);
        }

        FluidTags(NameSpace namespace, String path) {
            this(namespace, path, namespace.optionalDefault, namespace.alwaysDatagenDefault);
        }

        FluidTags(NameSpace namespace, boolean optional, boolean alwaysDatagen) {
            this(namespace, null, optional, alwaysDatagen);
        }

        FluidTags(NameSpace namespace, String path, boolean optional, boolean alwaysDatagen) {
            ResourceLocation id = ResourceLocation.fromNamespaceAndPath(namespace.id, path == null ? Lang.asId(name()) : path);
            if (optional)
                tag = optionalTag(BuiltInRegistries.FLUID, id);
            else
                tag = net.minecraft.tags.FluidTags.create(id);
            this.alwaysDatagen = alwaysDatagen;
        }

        @SuppressWarnings("deprecation")
        public boolean is(Fluid fluid) {
            return fluid.builtInRegistryHolder().is(tag);
        }

        public boolean is(ItemStack stack) {
            return stack != null && stack.getItem() instanceof BucketItem bucket && is(bucket.content);
        }

        public boolean is(ItemLike item) {
            return item instanceof BucketItem bucket && is(bucket.content);
        }

        public boolean is(FluidState state) {
            return state.is(tag);
        }

        public boolean is(TagKey<Fluid> tag) {
            return tag == this.tag;
        }

        private static void init() {}
    }

    public static void init() {
        BlockTags.init();
        ItemTags.init();
        FluidTags.init();
    }
}
