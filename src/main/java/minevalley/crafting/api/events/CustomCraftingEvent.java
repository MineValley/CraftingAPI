package minevalley.crafting.api.events;

import lombok.Getter;
import minevalley.crafting.api.recipe.CustomRecipe;
import org.bukkit.block.Block;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.block.BlockEvent;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public class CustomCraftingEvent extends BlockEvent implements Cancellable {

    private final static @Getter(onMethod_ = @Nonnull) HandlerList handlerList = new HandlerList();

    private final @Getter(onMethod_ = @Nonnull) CustomRecipe recipe;
    private boolean cancelled = false;

    public CustomCraftingEvent(@Nonnull Block craftingBlock, @Nonnull CustomRecipe recipe) {
        super(craftingBlock);
        this.recipe = recipe;
    }

    @Override
    public @Nonnull HandlerList getHandlers() {
        return handlerList;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }
}