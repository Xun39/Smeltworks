package xun.smeltworks.data.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import xun.smeltworks.Smeltworks;
import xun.smeltworks.util.TextUtils;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public abstract class SRecipeProvider extends RecipeProvider {

    public SRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    protected void ores(RecipeOutput recipeOutput, List<ItemLike> smeltableOres, ItemLike result, String group) {
        smelting(recipeOutput, RecipeCategory.MISC, 200, smeltableOres, result, 0.7F, group);
        blasting(recipeOutput, RecipeCategory.MISC, 100, smeltableOres, result, 0.7F, group);
    }

    protected static void smelting(RecipeOutput recipeOutput, RecipeCategory category, int cookingTime, List<ItemLike> ingredients, ItemLike result, float exp, String group) {
        cooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, ingredients, category, result, exp, cookingTime, group, "_from_smelting");
    }

    protected static void blasting(RecipeOutput recipeOutput, RecipeCategory category, int cookingTime, List<ItemLike> ingredients, ItemLike result, float exp, String group) {
        cooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, ingredients, category, result, exp, cookingTime, group, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void cooking(RecipeOutput recipeOutput, RecipeSerializer<T> cookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                    List<ItemLike> ingredients, RecipeCategory category, ItemLike result, float experience, int cookingTime, String group, String recipeName) {
        for(ItemLike itemlike : ingredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), category, result, experience, cookingTime, cookingSerializer, factory).group(group).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, TextUtils.getId(getItemName(result) + recipeName, getItemName(itemlike)));
        }
    }

    protected static void twoByTwo(RecipeOutput output, ItemLike ingredient, ItemLike result, int count, RecipeCategory recipeCategory) {
        ShapedRecipeBuilder.shaped(recipeCategory, result, count).define('#', ingredient)
                .pattern("##")
                .pattern("##")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(output, Smeltworks.modLoc(getRegistryName(result) + "_from_" + getRegistryName(ingredient)));
    }

    protected static void twoByTwoConvertible(RecipeOutput output, ItemLike unpacked, ItemLike packed, RecipeCategory unpackedCategory, RecipeCategory packedCategory) {
        ShapelessRecipeBuilder.shapeless(unpackedCategory, unpacked, 4).requires(packed)
                .unlockedBy(getHasName(packed), has(packed))
                .save(output, Smeltworks.modLoc(getRegistryName(unpacked) + "_from_" + getRegistryName(packed)));
        twoByTwo(output, unpacked, packed, 1, packedCategory);
    }

    protected static void threeByThreeConvertible(RecipeOutput output, ItemLike unpacked, ItemLike packed, RecipeCategory unpackedCategory, RecipeCategory packedCategory) {
        ShapelessRecipeBuilder.shapeless(unpackedCategory, unpacked, 9).requires(packed)
                .unlockedBy(getHasName(packed), has(packed))
                .save(output, Smeltworks.modLoc(getRegistryName(unpacked) + "_from_" + getRegistryName(packed)));
        ShapedRecipeBuilder.shaped(packedCategory, packed).define('#', unpacked).pattern("###").pattern("###").pattern("###")
                .unlockedBy(getHasName(unpacked), has(unpacked))
                .save(output, Smeltworks.modLoc(getRegistryName(packed) + "_from_" + getRegistryName(unpacked)));
    }

    protected static void smithingUpgrade(RecipeOutput recipeOutput, Item ingredientItem, Item smithingTemplateItem, Item materialItem, Item resultItem, RecipeCategory category) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(smithingTemplateItem), Ingredient.of(ingredientItem), Ingredient.of(materialItem), category, resultItem)
                .unlocks(getHasName(materialItem), has(materialItem))
                .save(recipeOutput, Smeltworks.modLoc(getRegistryName(resultItem) + "_from_" + "smithing"));
    }

    private static String getRegistryName(ItemLike itemLike) {
        return getItemName(itemLike);
    }
}