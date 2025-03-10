package xun.smeltworks.registry;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.TooltipFlag;
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

    public static final DeferredItem<Item> FERROTIDE_INGOT = ITEMS.register("ferrotide_ingot", () -> new Item(new Item.Properties().fireResistant()) {
        @Override
        public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
            super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
            tooltipComponents.add(Component.literal("Ti-50Fe").withStyle(ChatFormatting.DARK_GRAY));
        }
    });
    public static final DeferredItem<Item> FERROTIDE_PLATE = ITEMS.register("ferrotide_plate", () -> new Item(new Item.Properties().fireResistant()));

    public static final DeferredItem<SwordItem> FERROTIDE_SWORD = ITEMS.register("ferrotide_sword",
            () -> new SwordItem(ModTiers.FERROTIDE,
                    new Item.Properties().attributes(SwordItem.createAttributes(ModTiers.FERROTIDE, 3, -2.2F)).fireResistant()));
}