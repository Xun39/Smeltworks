package xun.smeltworks.data.generator;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import xun.smeltworks.data.provider.SItemModelProvider;
import xun.smeltworks.registry.SItems;

public class SItemModels extends SItemModelProvider {

    public SItemModels(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        basicItem(SItems.RAW_TITANIUM.get());
        basicItem(SItems.TITANIUM_INGOT.get());

        basicItem(SItems.FERROTIDE_PLATE.get());
        basicItem(SItems.FERROTIDE_INGOT.get());
        basicItem(SItems.FERROTIDE_UPGRADE_SMITHING_TEMPLATE.get());

        handheldItem(SItems.FERROTIDE_SWORD);
    }
}