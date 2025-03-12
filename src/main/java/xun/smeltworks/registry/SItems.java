package xun.smeltworks.registry;

import net.minecraft.world.item.*;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import xun.smeltworks.Smeltworks;
import xun.smeltworks.content.item.FerrotideUpgradeSmithingTemplateItem;
import xun.smeltworks.content.item.ModTiers;

import java.util.List;

public class SItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Smeltworks.MOD_ID);

    public static final DeferredItem<Item> RAW_TITANIUM = ITEMS.register("raw_titanium", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> TITANIUM_INGOT = ITEMS.register("titanium_ingot", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> FERROTIDE_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("ferrotide_upgrade_smithing_template",
            FerrotideUpgradeSmithingTemplateItem::createFerrotideUpgradeTemplate);

    public static final DeferredItem<Item> FERROTIDE_INGOT = ITEMS.register("ferrotide_ingot", () -> new Item(new Item.Properties().fireResistant()));
    public static final DeferredItem<Item> FERROTIDE_PLATE = ITEMS.register("ferrotide_plate", () -> new Item(new Item.Properties().fireResistant()));

    // Tools
    public static final DeferredItem<SwordItem> FERROTIDE_SWORD = ITEMS.register("ferrotide_sword",
            () -> new SwordItem(ModTiers.FERROTIDE,
                    new Item.Properties().attributes(SwordItem.createAttributes(ModTiers.FERROTIDE, 3, -2.2F)).fireResistant())
    );
    public static final DeferredItem<PickaxeItem> FERROTIDE_PICKAXE = ITEMS.register("ferrotide_pickaxe",
            () -> new PickaxeItem(ModTiers.FERROTIDE,
                    new Item.Properties().attributes(PickaxeItem.createAttributes(ModTiers.FERROTIDE, 1.0F, -2.8F)).fireResistant())
    );
    public static final DeferredItem<AxeItem> FERROTIDE_AXE = ITEMS.register("ferrotide_axe",
            () -> new AxeItem(ModTiers.FERROTIDE,
                    new Item.Properties().attributes(AxeItem.createAttributes(ModTiers.FERROTIDE, 5.0F, -2.9F)).fireResistant())
    );
    public static final DeferredItem<HoeItem> FERROTIDE_HOE = ITEMS.register("ferrotide_hoe",
            () -> new HoeItem(ModTiers.FERROTIDE,
                    new Item.Properties().attributes(HoeItem.createAttributes(ModTiers.FERROTIDE, -3.5F, 1.0F)).fireResistant())
    );
    public static final DeferredItem<ShovelItem> FERROTIDE_SHOVEL = ITEMS.register("ferrotide_shovel",
            () -> new ShovelItem(ModTiers.FERROTIDE,
                    new Item.Properties().attributes(ShovelItem.createAttributes(ModTiers.FERROTIDE, 1.5F, -3.0F)).fireResistant())
    );

    // Armors
    public static final DeferredItem<ArmorItem> FERROTIDE_HELMET = ITEMS.register("ferrotide_helmet",
            () -> new ArmorItem(SArmorMaterials.FERROTIDE, ArmorItem.Type.HELMET,
                    new Item.Properties().fireResistant().durability(ArmorItem.Type.HELMET.getDurability(40)))
    );
    public static final DeferredItem<ArmorItem> FERROTIDE_CHESTPLATE = ITEMS.register("ferrotide_chestplate",
            () -> new ArmorItem(SArmorMaterials.FERROTIDE, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().fireResistant().durability(ArmorItem.Type.CHESTPLATE.getDurability(40)))
    );
    public static final DeferredItem<ArmorItem> FERROTIDE_LEGGINGS = ITEMS.register("ferrotide_leggings",
            () -> new ArmorItem(SArmorMaterials.FERROTIDE, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().fireResistant().durability(ArmorItem.Type.LEGGINGS.getDurability(40)))
    );
    public static final DeferredItem<ArmorItem> FERROTIDE_BOOTS = ITEMS.register("ferrotide_boots",
            () -> new ArmorItem(SArmorMaterials.FERROTIDE, ArmorItem.Type.BOOTS,
                    new Item.Properties().fireResistant().durability(ArmorItem.Type.BOOTS.getDurability(40)))
    );
}