package minevalley.crafting.api.recipe;

import minevalley.crafting.api.ingredient.RecipeIngredient;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public interface CustomShapelessRecipe extends CustomRecipe {

    /**
     * Adds an ingredient to the recipe.
     *
     * @param ingredient the ingredient to add
     * @return this
     * @throws IllegalArgumentException if the ingredient is null
     */
    CustomShapelessRecipe addIngredient(@Nonnull RecipeIngredient ingredient) throws IllegalArgumentException;
}