package minevalley.crafting.api.recipe;

import minevalley.core.api.users.OnlineUser;
import minevalley.crafting.api.ingredient.RecipeIngredient;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import java.util.function.Predicate;

@SuppressWarnings("unused")
public interface CustomRecipe {

    /**
     * Gets the result item stack of this custom recipe.
     *
     * @return the result item stack
     */
    @Nonnull
    @Contract(pure = true)
    ItemStack getResult();

    /**
     * Gets the crafting duration in milliseconds for this custom recipe.
     *
     * @return the crafting duration in milliseconds
     */
    @Contract(pure = true)
    long getCraftingDurationMs();

    /**
     * Sets a requirement that must be fulfilled by the user trying to craft this recipe.
     *
     * @param requirement the requirement predicate
     * @return this
     * @throws IllegalArgumentException if the requirement is null
     */
    CustomRecipe require(@Nonnull Predicate<OnlineUser> requirement) throws IllegalArgumentException;

    /**
     * Removes all requirements for crafting this recipe.
     * @return this
     */
    default CustomRecipe removeRequirements() {
        return require(user -> true);
    }

    /**
     * Registers the custom shape recipe so it becomes available in the crafting system.
     *
     * @throws IllegalStateException if the recipe, or another with the same ingredients is already registered
     */
    void register() throws IllegalStateException;

    /**
     * Unregisters the custom shape recipe so it is no longer available in the crafting system.
     */
    void unregister();
}
