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
        handheldItem(SItems.FERROTIDE_PICKAXE);
        handheldItem(SItems.FERROTIDE_AXE);
        handheldItem(SItems.FERROTIDE_HOE);
        handheldItem(SItems.FERROTIDE_SHOVEL);

        trimmedArmorItem(SItems.FERROTIDE_HELMET);
        trimmedArmorItem(SItems.FERROTIDE_CHESTPLATE);
        trimmedArmorItem(SItems.FERROTIDE_LEGGINGS);
        trimmedArmorItem(SItems.FERROTIDE_BOOTS);
    }
}