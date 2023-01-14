package disabled_classes;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.Identifier;

public class CooktopRecipe extends AbstractCookingRecipe {
    public CooktopRecipe( Identifier id, String group, Ingredient input, ItemStack output, float experience, int cookTime) {
        super(MoreFood.COOKTOP_RECIPE, id, group, input, output, experience, cookTime);
    }

    public ItemStack getRecipeKindIcon() {
        return new ItemStack(MoreFood.COOKTOP_BLOCK);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        //The Serializer will be created later
        return MoreFood.COOKTOP_RECIPE_SERIALIZER;
    }
}
