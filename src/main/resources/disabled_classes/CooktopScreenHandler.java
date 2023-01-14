package disabled_classes;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.screen.AbstractFurnaceScreenHandler;
import net.minecraft.screen.PropertyDelegate;

public class CooktopScreenHandler extends AbstractFurnaceScreenHandler {
    public CooktopScreenHandler(int i, PlayerInventory playerInventory) {
        super(MoreFood.COOKTOP_SCREEN_HANDLER, MoreFood.COOKTOP_RECIPE, RecipeBookCategory.FURNACE, i, playerInventory);
    }

    public CooktopScreenHandler(int i, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate propertyDelegate) {
        super(MoreFood.COOKTOP_SCREEN_HANDLER, MoreFood.COOKTOP_RECIPE, RecipeBookCategory.FURNACE, i, playerInventory, inventory, propertyDelegate);
    }
}
