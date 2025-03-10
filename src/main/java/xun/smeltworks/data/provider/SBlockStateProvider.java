package xun.smeltworks.data.provider;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import xun.smeltworks.Smeltworks;

public abstract class SBlockStateProvider extends BlockStateProvider {

    public SBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Smeltworks.MOD_ID, exFileHelper);
    }

    protected void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}
