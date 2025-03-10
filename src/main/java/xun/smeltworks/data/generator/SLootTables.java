package xun.smeltworks.data.generator;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import xun.smeltworks.data.provider.SBlockLootProvider;
import xun.smeltworks.registry.SBlocks;
import xun.smeltworks.registry.SItems;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class SLootTables extends LootTableProvider {

    public SLootTables(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, Collections.emptySet(),
                List.of(new SubProviderEntry(BlockLootTables::new, LootContextParamSets.BLOCK)
                ), registries);
    }

    public static class BlockLootTables extends SBlockLootProvider {

        protected BlockLootTables(HolderLookup.Provider registries) {
            super(registries);
        }

        @Override
        protected void generate() {

            dropOtherWithoutSilkTouch(SBlocks.TITANIUM_ORE, SItems.RAW_TITANIUM);
            dropOtherWithoutSilkTouch(SBlocks.DEEPSLATE_TITANIUM_ORE, SItems.RAW_TITANIUM);
        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
            return SBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
        }
    }
}
