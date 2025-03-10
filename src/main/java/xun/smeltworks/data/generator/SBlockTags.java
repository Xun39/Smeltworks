package xun.smeltworks.data.generator;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import xun.smeltworks.Smeltworks;
import xun.smeltworks.registry.SBlocks;

import java.util.concurrent.CompletableFuture;

public class SBlockTags extends BlockTagsProvider {

    public SBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Smeltworks.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                SBlocks.TITANIUM_ORE.get(),
                SBlocks.DEEPSLATE_TITANIUM_ORE.get()
        );

        tag(BlockTags.NEEDS_IRON_TOOL).add(
                SBlocks.TITANIUM_ORE.get(),
                SBlocks.DEEPSLATE_TITANIUM_ORE.get()
        );
    }
}
