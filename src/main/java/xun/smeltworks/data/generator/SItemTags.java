package xun.smeltworks.data.generator;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import xun.smeltworks.Smeltworks;
import xun.smeltworks.registry.SItems;

import java.util.concurrent.CompletableFuture;

public class SItemTags extends ItemTagsProvider {

    public SItemTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, Smeltworks.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        tag(Tags.Items.RAW_MATERIALS).add(
                SItems.RAW_TITANIUM.get()
        );

        tag(Tags.Items.INGOTS).add(
                SItems.TITANIUM_INGOT.get(),
                SItems.FERROTIDE_INGOT.get()
        );

        tag(ItemTags.TRIM_TEMPLATES).add(SItems.FERROTIDE_UPGRADE_SMITHING_TEMPLATE.get());

        tag(ItemTags.SWORDS).add(SItems.FERROTIDE_SWORD.get());
        tag(ItemTags.PICKAXES).add(SItems.FERROTIDE_PICKAXE.get());
        tag(ItemTags.AXES).add(SItems.FERROTIDE_AXE.get());
        tag(ItemTags.HOES).add(SItems.FERROTIDE_HOE.get());
        tag(ItemTags.SHOVELS).add(SItems.FERROTIDE_SHOVEL.get());

        tag(ItemTags.HEAD_ARMOR).add(SItems.FERROTIDE_HELMET.get());
        tag(ItemTags.CHEST_ARMOR).add(SItems.FERROTIDE_CHESTPLATE.get());
        tag(ItemTags.LEG_ARMOR).add(SItems.FERROTIDE_LEGGINGS.get());
        tag(ItemTags.FOOT_ARMOR).add(SItems.FERROTIDE_BOOTS.get());
    }
}
