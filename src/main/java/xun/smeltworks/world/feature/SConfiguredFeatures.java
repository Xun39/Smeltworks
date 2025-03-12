package xun.smeltworks.world.feature;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import xun.smeltworks.Smeltworks;
import xun.smeltworks.registry.SBlocks;

import java.util.List;

public class SConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> SMALL_TITANIUM_ORE_KEY = registerKey("ore_titanium_small");
    public static final ResourceKey<ConfiguredFeature<? ,?>> UPPER_TITANIUM_ORE_KEY = registerKey("ore_titanium_upper");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_TITANIUM_ORE_KEY = registerKey("ore_titanium_large");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {

        RuleTest stoneReplaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceable = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> overworldTitaniumOres = List.of(
                OreConfiguration.target(stoneReplaceable, SBlocks.TITANIUM_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceable, SBlocks.DEEPSLATE_TITANIUM_ORE.get().defaultBlockState())
        );

        register(context, UPPER_TITANIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldTitaniumOres, 3,0.0F));
        register(context, SMALL_TITANIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldTitaniumOres, 3,0.3F));
        register(context, LARGE_TITANIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldTitaniumOres, 6,0.7F));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, Smeltworks.modLoc(name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
