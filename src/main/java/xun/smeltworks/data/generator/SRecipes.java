package xun.smeltworks.data.generator;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;
import xun.smeltworks.data.provider.SRecipeProvider;
import xun.smeltworks.registry.SBlocks;
import xun.smeltworks.registry.SItems;

import java.util.concurrent.CompletableFuture;

public class SRecipes extends SRecipeProvider {

    public SRecipes(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        rawOre(SItems.RAW_TITANIUM, SItems.TITANIUM_INGOT);
        rawOre(SBlocks.TITANIUM_ORE, SItems.TITANIUM_INGOT);
        rawOre(SBlocks.DEEPSLATE_TITANIUM_ORE, SItems.TITANIUM_INGOT);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, SItems.FERROTIDE_INGOT)
                .requires(Items.IRON_INGOT, 4)
                .requires(SItems.TITANIUM_INGOT, 4)
                .unlockedBy(getHasName(SItems.TITANIUM_INGOT), has(SItems.TITANIUM_INGOT))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, SItems.FERROTIDE_PLATE, 2)
                .requires(Items.IRON_INGOT, 2)
                .requires(SItems.TITANIUM_INGOT, 2)
                .unlockedBy(getHasName(SItems.TITANIUM_INGOT), has(SItems.TITANIUM_INGOT))
                .save(recipeOutput);
        twoByTwoConvertible(recipeOutput, SItems.FERROTIDE_PLATE, SItems.FERROTIDE_INGOT, RecipeCategory.MISC, RecipeCategory.MISC);

        smithingUpgrade(recipeOutput, Items.DIAMOND_SWORD, SItems.FERROTIDE_UPGRADE_SMITHING_TEMPLATE.get(), SItems.FERROTIDE_INGOT.get(),
                SItems.FERROTIDE_SWORD.get(), RecipeCategory.COMBAT);
    }
}