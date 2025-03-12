package xun.smeltworks.data.generator;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import xun.smeltworks.Smeltworks;
import xun.smeltworks.world.feature.SConfiguredFeatures;
import xun.smeltworks.world.feature.SPlacedFeatures;
import xun.smeltworks.world.modifier.SBiomeModifiers;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class SDatapackEntries extends DatapackBuiltinEntriesProvider {

    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, SConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, SPlacedFeatures::bootstrap)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, SBiomeModifiers::bootstrap);

    public SDatapackEntries(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(Smeltworks.MOD_ID));
    }
}
