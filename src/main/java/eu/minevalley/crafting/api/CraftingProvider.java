package eu.minevalley.crafting.api;

import eu.minevalley.crafting.api.ingredient.RecipeIngredient;
import eu.minevalley.crafting.api.recipe.CustomShapedRecipe;
import eu.minevalley.crafting.api.recipe.CustomShapelessRecipe;
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