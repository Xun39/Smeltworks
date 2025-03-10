package xun.smeltworks.data.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;
import java.util.function.Supplier;

public abstract class SBlockLootProvider extends BlockLootSubProvider {

    protected SBlockLootProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    public void multipleDrops(Supplier<? extends Block> block, Item drop, float minDropAmount, float maxDropAmount) {
        super.add(block.get(), (result) -> createMultipleOreDrops(result, drop, minDropAmount, maxDropAmount));
    }

    public void multipleDrops(Block block, Item drop, float minDropAmount, float maxDropAmount) {
        super.add(block, (result) -> createMultipleOreDrops(result, drop, minDropAmount, maxDropAmount));
    }

    public void dropOtherWithoutSilkTouch(Supplier<? extends Block> block, ItemLike drop) {
        super.add(block.get(), (result) -> createDropOther(result, drop));
    }

    private LootTable.Builder createDropOther(Block block, ItemLike drop) {
        return this.createSilkTouchDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(drop)));
    }

    private LootTable.Builder createMultipleOreDrops(Block block, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(block,
                this.applyExplosionDecay(block, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
    }
}
