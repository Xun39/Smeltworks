package xun.smeltworks.data.provider;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredItem;
import xun.smeltworks.Smeltworks;

public abstract class SItemModelProvider extends ItemModelProvider {

    public SItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Smeltworks.MOD_ID, existingFileHelper);
    }

    protected void handheldItem(DeferredItem<?> item) {
        withExistingParent(getItemRegistryName(item),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                Smeltworks.modLoc("item/" + getItemRegistryName(item)));
    }

    protected static String getItemRegistryName(DeferredItem<?> deferredItem) {
        return deferredItem.getId().getPath();
    }
}
