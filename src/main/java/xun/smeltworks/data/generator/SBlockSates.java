package xun.smeltworks.data.generator;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import xun.smeltworks.data.provider.SBlockStateProvider;
import xun.smeltworks.registry.SBlocks;

public class SBlockSates extends SBlockStateProvider {

    public SBlockSates(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        blockWithItem(SBlocks.TITANIUM_ORE);
        blockWithItem(SBlocks.DEEPSLATE_TITANIUM_ORE);
    }
}