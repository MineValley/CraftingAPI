package minevalley.crafting.api;

import minevalley.crafting.api.ingredient.RecipeIngredient;
import minevalley.crafting.api.recipe.CustomShapedRecipe;
import minevalley.crafting.api.recipe.CustomShapelessRecipe;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

@SuppressWarnings({"unused", "UnusedReturnValue"})
public class Crafting {

    private static CraftingProvider provider;

    /**
     * Creates a custom shaped crafting recipe.
     *
     * @param result             the resulting item stack
     * @param shape              the shape of the recipe
     * @param craftingDurationMs the crafting duration in milliseconds
     * @return the created custom shaped recipe
     * @throws IllegalArgumentException if the result or the shape is null, if the shape is invalid or the crafting duration is negative
     */
    @Nonnull
    public static CustomShapedRecipe createCustomRecipe(@Nonnull ItemStack result, @Nonnull String[] shape,
                                                        long craftingDurationMs) throws IllegalArgumentException {
        return provider.createCustomShapedRecipe(result, shape, craftingDurationMs);
    }

    /**
     * Creates a custom shapeless crafting recipe.
     *
     * @param result             the resulting item stack
     * @param craftingDurationMs the crafting duration in milliseconds
     * @param ingredient         the first ingredient
     * @param ingredients        the other ingredients
     * @return the created custom shapeless recipe
     * @throws IllegalArgumentException if the result is null, if no ingredients are provided or the crafting duration is negative
     */
    @Nonnull
    public static CustomShapelessRecipe createCustomRecipe(@Nonnull ItemStack result, long craftingDurationMs,
                                                           @Nonnull RecipeIngredient ingredient,
                                                           @Nonnull RecipeIngredient... ingredients)
            throws IllegalArgumentException {
        return provider.createCustomShapelessRecipe(result, craftingDurationMs, ingredient, ingredients);
    }
}