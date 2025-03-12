package xun.smeltworks.data.generator;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import xun.smeltworks.data.provider.SRecipeProvider;
import xun.smeltworks.registry.SBlocks;
import xun.smeltworks.registry.SItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class SRecipes extends SRecipeProvider {

    public SRecipes(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        List<ItemLike> TITANIUM_SMELTABLES = List.of(SItems.RAW_TITANIUM, SBlocks.TITANIUM_ORE, SBlocks.DEEPSLATE_TITANIUM_ORE);
        ores(recipeOutput, TITANIUM_SMELTABLES, SItems.TITANIUM_INGOT, "titanium");

        threeByThreeConvertible(recipeOutput, SItems.RAW_TITANIUM, SBlocks.RAW_TITANIUM_BLOCK, RecipeCategory.MISC, RecipeCategory.BUILDING_BLOCKS);
        threeByThreeConvertible(recipeOutput, SItems.TITANIUM_INGOT, SBlocks.TITANIUM_BLOCK, RecipeCategory.MISC, RecipeCategory.BUILDING_BLOCKS);

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
        threeByThreeConvertible(recipeOutput, SItems.FERROTIDE_INGOT, SBlocks.FERROTIDE_BLOCK, RecipeCategory.MISC, RecipeCategory.BUILDING_BLOCKS);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SItems.FERROTIDE_UPGRADE_SMITHING_TEMPLATE, 2)
                .pattern("#T#")
                .pattern("#C#")
                .pattern("###")
                .define('#', Items.DIAMOND)
                .define('C', Blocks.COBBLESTONE)
                .define('T', SItems.FERROTIDE_UPGRADE_SMITHING_TEMPLATE)
                .unlockedBy(getHasName(SItems.FERROTIDE_UPGRADE_SMITHING_TEMPLATE), has(SItems.FERROTIDE_UPGRADE_SMITHING_TEMPLATE))
                .save(recipeOutput);

        // Ferrotide upgrades
        smithingUpgrade(recipeOutput, Items.DIAMOND_SWORD, SItems.FERROTIDE_UPGRADE_SMITHING_TEMPLATE.get(), SItems.FERROTIDE_INGOT.get(),
                SItems.FERROTIDE_SWORD.get(), RecipeCategory.COMBAT);
        smithingUpgrade(recipeOutput, Items.DIAMOND_PICKAXE, SItems.FERROTIDE_UPGRADE_SMITHING_TEMPLATE.get(), SItems.FERROTIDE_INGOT.get(),
                SItems.FERROTIDE_PICKAXE.get(), RecipeCategory.TOOLS);
        smithingUpgrade(recipeOutput, Items.DIAMOND_AXE, SItems.FERROTIDE_UPGRADE_SMITHING_TEMPLATE.get(), SItems.FERROTIDE_INGOT.get(),
                SItems.FERROTIDE_AXE.get(), RecipeCategory.TOOLS);
        smithingUpgrade(recipeOutput, Items.DIAMOND_HOE, SItems.FERROTIDE_UPGRADE_SMITHING_TEMPLATE.get(), SItems.FERROTIDE_INGOT.get(),
                SItems.FERROTIDE_HOE.get(), RecipeCategory.TOOLS);
        smithingUpgrade(recipeOutput, Items.DIAMOND_SHOVEL, SItems.FERROTIDE_UPGRADE_SMITHING_TEMPLATE.get(), SItems.FERROTIDE_INGOT.get(),
                SItems.FERROTIDE_SHOVEL.get(), RecipeCategory.TOOLS);

        smithingUpgrade(recipeOutput, Items.DIAMOND_HELMET, SItems.FERROTIDE_UPGRADE_SMITHING_TEMPLATE.get(), SItems.FERROTIDE_INGOT.get(),
                SItems.FERROTIDE_HELMET.get(), RecipeCategory.COMBAT);
        smithingUpgrade(recipeOutput, Items.DIAMOND_CHESTPLATE, SItems.FERROTIDE_UPGRADE_SMITHING_TEMPLATE.get(), SItems.FERROTIDE_INGOT.get(),
                SItems.FERROTIDE_CHESTPLATE.get(), RecipeCategory.COMBAT);
        smithingUpgrade(recipeOutput, Items.DIAMOND_LEGGINGS, SItems.FERROTIDE_UPGRADE_SMITHING_TEMPLATE.get(), SItems.FERROTIDE_INGOT.get(),
                SItems.FERROTIDE_LEGGINGS.get(), RecipeCategory.COMBAT);
        smithingUpgrade(recipeOutput, Items.DIAMOND_BOOTS, SItems.FERROTIDE_UPGRADE_SMITHING_TEMPLATE.get(), SItems.FERROTIDE_INGOT.get(),
                SItems.FERROTIDE_BOOTS.get(), RecipeCategory.COMBAT);
    }
}