package minevalley.crafting.api.recipe;

import minevalley.crafting.api.ingredient.RecipeIngredient;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public interface CustomShapedRecipe extends CustomRecipe {

    /**
     * Maps a symbol in the recipe shape to a crafting ingredient.
     *
     * @param symbol     the symbol to map
     * @param ingredient the crafting ingredient to map to the symbol
     * @return this
     * @throws IllegalArgumentException if the symbol is already mapped or if the ingredient is null
     */
    CustomShapedRecipe mapIngredient(char symbol, @Nonnull RecipeIngredient ingredient) throws IllegalArgumentException;

    /**
     * Gets the ingredients arranged in the shape of the recipe.
     *
     * @return the ingredients in the recipe shape
     */
    @Nonnull
    @Contract(pure = true)
    RecipeIngredient[][] getShape();
}