package xun.smeltworks.world.feature;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import xun.smeltworks.Smeltworks;
import xun.smeltworks.world.ModOrePlacement;

import java.util.List;

public class SPlacedFeatures {

    public static final ResourceKey<PlacedFeature> TITANIUM_ORE_PLACED_KEY = registerKey("ore_titanium");
    public static final ResourceKey<PlacedFeature> UPPER_TITANIUM_ORE_PLACED_KEY = registerKey("ore_titanium_upper");
    public static final ResourceKey<PlacedFeature> LARGE_TITANIUM_ORE_PLACED_KEY = registerKey("ore_titanium_large");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, TITANIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(SConfiguredFeatures.SMALL_TITANIUM_ORE_KEY),
                ModOrePlacement.oreCountPlacement(6,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(24)))
        );
        register(context, LARGE_TITANIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(SConfiguredFeatures.LARGE_TITANIUM_ORE_KEY),
                ModOrePlacement.oreCountPlacement(4,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(16)))
        );
        register(context, UPPER_TITANIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(SConfiguredFeatures.UPPER_TITANIUM_ORE_KEY),
                ModOrePlacement.oreCountPlacement(96,
                        HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-12), VerticalAnchor.absolute(384)))
        );
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, Smeltworks.modLoc(name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
