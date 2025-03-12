package xun.smeltworks.content.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;
import xun.smeltworks.registry.SItems;

public class ModTiers {

    public static final Tier FERROTIDE = new SimpleTier(BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            2349, 10.0F, 3.5F, 16, () -> Ingredient.of(SItems.FERROTIDE_INGOT));
}
