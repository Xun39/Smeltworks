package xun.smeltworks.world.modifier;

import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import xun.smeltworks.Smeltworks;
import xun.smeltworks.world.feature.SPlacedFeatures;

import java.util.List;

public class SBiomeModifiers {

    public static final ResourceKey<BiomeModifier> ADD_ORE_TITANIUM = registerKey("add_ore_titanium");
    public static final ResourceKey<BiomeModifier> ADD_ORE_TITANIUM_UPPER = registerKey("add_ore_titanium_upper");
    public static final ResourceKey<BiomeModifier> ADD_ORE_TITANIUM_LARGE= registerKey("add_ore_titanium_large");

    public static void bootstrap(BootstrapContext<BiomeModifier> context) {

        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_ORE_TITANIUM, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(SPlacedFeatures.TITANIUM_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES)
        );
        context.register(ADD_ORE_TITANIUM_LARGE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(SPlacedFeatures.LARGE_TITANIUM_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES)
        );
        context.register(ADD_ORE_TITANIUM_UPPER, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_MOUNTAIN),
                HolderSet.direct(placedFeatures.getOrThrow(SPlacedFeatures.UPPER_TITANIUM_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES)
        );
    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, Smeltworks.modLoc(name));
    }
}
