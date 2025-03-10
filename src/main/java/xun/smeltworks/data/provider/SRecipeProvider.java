package xun.smeltworks.data.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import xun.smeltworks.Smeltworks;

import java.util.concurrent.CompletableFuture;

public abstract class SRecipeProvider extends RecipeProvider {

    public SRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    protected void rawOre(ItemLike rawOre, ItemLike smeltOre) {
        smelting(RecipeCategory.MISC, 200, rawOre, smeltOre, 0.7F, 1);
        blasting(RecipeCategory.MISC, 100, rawOre, smeltOre, 0.7F, 1);
    }

    protected SimpleCookingRecipeBuilder smelting(RecipeCategory category, int cookingTime, ItemLike ingredient, ItemLike result, float exp, int count) {
        return SimpleCookingRecipeBuilder.smelting(Ingredient.of(new ItemStack(ingredient, count)), category, result, exp, cookingTime)
                .unlockedBy("has_" + getRegistryName(ingredient), has(ingredient));
    }
    protected SimpleCookingRecipeBuilder blasting(RecipeCategory category, int cookingTime, ItemLike ingredient, ItemLike result, float exp, int count) {
        return SimpleCookingRecipeBuilder.blasting(Ingredient.of(new ItemStack(ingredient, count)), category, result, exp, cookingTime)
                .unlockedBy("has_" + getRegistryName(ingredient), has(ingredient));
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
