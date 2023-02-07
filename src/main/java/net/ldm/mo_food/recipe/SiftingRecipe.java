package net.ldm.mo_food.recipe;

import com.google.gson.JsonObject;
import net.ldm.mo_food.core.BasicInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public record SiftingRecipe(Ingredient ingredient, ItemStack result, Identifier id) implements Recipe<BasicInventory> {

    @Override
    public boolean matches(BasicInventory inventory, World world) {
        return false;
    }

    @Override
    public ItemStack craft(BasicInventory inventory) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean fits(int width, int height) {
        return false;
    }

    @Override
    public ItemStack getOutput() {
        return result;
    }

    @Override
    public Identifier getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return SiftingRecipeSerializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<SiftingRecipe> {
        public Type(){}
        public static final Type INSTANCE = new Type();
        public static final String ID = "sifting";
    }

    static class JsonFormat {
        JsonObject ingredient;
        String result;
        int min;
        int max;
    }
}
