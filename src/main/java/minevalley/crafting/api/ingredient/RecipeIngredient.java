package minevalley.crafting.api.ingredient;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Represents an ingredient used in crafting recipes.
 */
@SuppressWarnings("unused")
public class RecipeIngredient {

    /**
     * Predicate to validate if an ItemStack matches this ingredient.
     */
    private final Predicate<ItemStack> validator;

    /**
     * Function to transform an ItemStack when used in crafting.
     */
    private final Function<ItemStack, ItemStack> transformer;

    /**
     * Constructs a RecipeIngredient with the specified validator and transformer.
     *
     * @param validator   predicate that defines, whether an ItemStack matches this ingredient
     * @param transformer function that transforms the ItemStack when used in crafting
     */
    public RecipeIngredient(@Nonnull Predicate<ItemStack> validator, @Nonnull Function<ItemStack, ItemStack> transformer) {
        this.validator = validator;
        this.transformer = transformer;
    }

    /**
     * Constructs a RecipeIngredient with the specified ItemStack and transformer.
     *
     * @param itemStack   the ItemStack to match
     * @param transformer function that transforms the ItemStack when used in crafting
     */
    public RecipeIngredient(@Nonnull ItemStack itemStack, @Nonnull Function<ItemStack, ItemStack> transformer) {
        this(stack -> stack.isSimilar(itemStack), transformer);
    }

    /**
     * Constructs a RecipeIngredient with the specified Material and transformer.
     *
     * @param material    the Material to match
     * @param transformer function that transforms the ItemStack when used in crafting
     */
    public RecipeIngredient(@Nonnull Material material, @Nonnull Function<ItemStack, ItemStack> transformer) {
        this(stack -> stack.getType() == material, transformer);
    }

    /**
     * Constructs a RecipeIngredient with the specified validator.
     *
     * @param validator predicate that defines, whether an ItemStack matches this ingredient
     */
    public RecipeIngredient(@Nonnull Predicate<ItemStack> validator) {
        this(validator, ItemStack::subtract);
    }

    /**
     * Constructs a RecipeIngredient with the specified ItemStack.
     *
     * @param itemStack the ItemStack to match
     */
    public RecipeIngredient(@Nonnull ItemStack itemStack) {
        this(stack -> stack.isSimilar(itemStack));
    }

    /**
     * Constructs a RecipeIngredient with the specified Material.
     *
     * @param material the Material to match
     */
    public RecipeIngredient(@Nonnull Material material) {
        this(stack -> stack.getType() == material);
    }

    /**
     * Checks if the given ItemStack is valid for this ingredient.
     *
     * @param itemStack the ItemStack to validate
     * @return true if the ItemStack matches this ingredient, false otherwise
     */
    @Contract(value = "null -> false", pure = true)
    public boolean isValid(@Nullable ItemStack itemStack) {
        return itemStack != null && validator.test(itemStack);
    }

    /**
     * Transforms the given ItemStack according to this ingredient's transformer.
     *
     * @param itemStack the ItemStack to transform
     * @return the transformed ItemStack, or null if the transformation results in no item
     * @throws IllegalArgumentException if the provided ItemStack is null
     */
    @Nullable
    @Contract(pure = true)
    public ItemStack transform(@Nonnull ItemStack itemStack) throws IllegalArgumentException {
        if (itemStack == null) {
            throw new IllegalArgumentException("ItemStack cannot be null");
        }
        return transformer.apply(itemStack);
    }
}