package xun.smeltworks;

import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ItemLike;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import xun.smeltworks.registry.SBlocks;
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
        }
    }

    private static void insertAfter(BuildCreativeModeTabContentsEvent event, ItemLike existingEntry, ItemLike newEntry) {
        event.insertAfter(new ItemStack(existingEntry), new ItemStack(newEntry), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
