package minevalley.crafting.api.recipe;

import minevalley.crafting.api.ingredient.RecipeIngredient;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public interface CustomShapedRecipe extends CustomRecipe {

    /**
     * Gets the ingredients arranged in the shape of the recipe.
     *
     * @return the ingredients in the recipe shape
     */
    @Nonnull
    @Contract(pure = true)
    RecipeIngredient[][] getShape();
}