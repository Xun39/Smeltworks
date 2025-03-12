package xun.smeltworks.data.generator;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;
import xun.smeltworks.Smeltworks;
import xun.smeltworks.registry.SItems;
import xun.smeltworks.world.modifier.loot.AddItemModifier;

import java.util.concurrent.CompletableFuture;

public class SGlobalLootModifiers extends GlobalLootModifierProvider {

    public SGlobalLootModifiers(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, Smeltworks.MOD_ID);
    }

    @Override
    protected void start() {

        this.add("ferrotide_upgrade_smithing_template_in_mineshaft",
                new AddItemModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/abandoned_mineshaft")).build(),
                        LootItemRandomChanceCondition.randomChance(0.5F).build()
                }, SItems.FERROTIDE_UPGRADE_SMITHING_TEMPLATE.get())
        );

        this.add("ferrotide_upgrade_smithing_template_in_stronghold",
                new AddItemModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/stronghold_crossing")).build(),
                        LootItemRandomChanceCondition.randomChance(0.8F).build()
                }, SItems.FERROTIDE_UPGRADE_SMITHING_TEMPLATE.get())
        );
    }
}
