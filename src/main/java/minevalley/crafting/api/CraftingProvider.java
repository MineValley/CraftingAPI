package minevalley.crafting.api;

import minevalley.crafting.api.ingredient.RecipeIngredient;
import minevalley.crafting.api.recipe.CustomShapedRecipe;
import minevalley.crafting.api.recipe.CustomShapelessRecipe;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

public interface CraftingProvider {

    @Nonnull
    CustomShapedRecipe createCustomShapedRecipe(@Nonnull ItemStack result, @Nonnull String[] shape,
                                                long craftingDurationMs) throws IllegalArgumentException;

    @Nonnull
    CustomShapelessRecipe createCustomShapelessRecipe(@Nonnull ItemStack result, long craftingDurationMs,
                                                      @Nonnull RecipeIngredient ingredient,
                                                      @Nonnull RecipeIngredient[] ingredients)
            throws IllegalArgumentException;
}