package xun.smeltworks;

import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ItemLike;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import xun.smeltworks.registry.SArmorMaterials;
import xun.smeltworks.registry.SBlocks;
import xun.smeltworks.registry.SGlobalLootModifierSerializers;
import xun.smeltworks.registry.SItems;

@Mod(Smeltworks.MOD_ID)
public class Smeltworks {

    public static final String MOD_ID = "smeltworks";
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final ResourceLocation modLoc(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }

    public Smeltworks(IEventBus modEventBus, ModContainer modContainer) {

        IEventBus neoForgeEventBus = NeoForge.EVENT_BUS;

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addCreative);

        SItems.ITEMS.register(modEventBus);
        SBlocks.BLOCKS.register(modEventBus);

        SArmorMaterials.ARMOR_MATERIALS.register(modEventBus);
        SGlobalLootModifierSerializers.GLOBAL_LOOT_MODIFIER_SERIALIZERS.register(modEventBus);

        neoForgeEventBus.register(this);
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        ResourceKey<CreativeModeTab> tab = event.getTabKey();

        if (tab == CreativeModeTabs.INGREDIENTS) {
            insertAfter(event, Items.RAW_GOLD, SItems.RAW_TITANIUM);
            insertAfter(event, Items.GOLD_INGOT, SItems.TITANIUM_INGOT);
            insertAfter(event, Items.NETHERITE_INGOT, SItems.FERROTIDE_PLATE);
            insertAfter(event, SItems.FERROTIDE_PLATE, SItems.FERROTIDE_INGOT);
            insertAfter(event, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, SItems.FERROTIDE_UPGRADE_SMITHING_TEMPLATE);
        }

        if (tab == CreativeModeTabs.NATURAL_BLOCKS) {
            insertAfter(event, Blocks.DEEPSLATE_GOLD_ORE, SBlocks.TITANIUM_ORE);
            insertAfter(event, SBlocks.TITANIUM_ORE, SBlocks.DEEPSLATE_TITANIUM_ORE);
            insertAfter(event, Blocks.RAW_GOLD_BLOCK, SBlocks.RAW_TITANIUM_BLOCK);
        }

        if (tab == CreativeModeTabs.BUILDING_BLOCKS) {
            insertAfter(event, Blocks.DIAMOND_BLOCK, SBlocks.TITANIUM_BLOCK);
            insertAfter(event, Blocks.NETHERITE_BLOCK, SBlocks.FERROTIDE_BLOCK);
        }

        if (tab == CreativeModeTabs.COMBAT) {
            insertAfter(event, Items.NETHERITE_SWORD, SItems.FERROTIDE_SWORD);
            insertAfter(event, Items.NETHERITE_AXE, SItems.FERROTIDE_AXE);
            insertAfter(event, Items.NETHERITE_BOOTS, SItems.FERROTIDE_HELMET);
            insertAfter(event, SItems.FERROTIDE_HELMET, SItems.FERROTIDE_CHESTPLATE);
            insertAfter(event, SItems.FERROTIDE_CHESTPLATE, SItems.FERROTIDE_LEGGINGS);
            insertAfter(event, SItems.FERROTIDE_LEGGINGS, SItems.FERROTIDE_BOOTS);
        }

        if (tab == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            insertAfter(event, Items.NETHERITE_HOE, SItems.FERROTIDE_SHOVEL);
            insertAfter(event, SItems.FERROTIDE_SHOVEL, SItems.FERROTIDE_PICKAXE);
            insertAfter(event, SItems.FERROTIDE_PICKAXE, SItems.FERROTIDE_AXE);
            insertAfter(event, SItems.FERROTIDE_AXE, SItems.FERROTIDE_HOE);
        }
    }

    private static void insertAfter(BuildCreativeModeTabContentsEvent event, ItemLike existingEntry, ItemLike newEntry) {
        event.insertAfter(new ItemStack(existingEntry), new ItemStack(newEntry), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
    }

    @SubscribeEvent
    private void onSeverStarting(ServerStartingEvent event) {

    }
}