package net.ldm.mo_food.recipe;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import net.ldm.mo_food.core.init.MoFood;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.random.Random;

public class SiftingRecipeSerializer implements RecipeSerializer<SiftingRecipe> {
    private SiftingRecipeSerializer(){}
    public static final SiftingRecipeSerializer INSTANCE = new SiftingRecipeSerializer();
    public static final Identifier ID = new Identifier(MoFood.MOD_ID, "sifting");

    @Override
    public SiftingRecipe read(Identifier id, JsonObject json) {
        SiftingRecipe.JsonFormat recipeJson = new Gson().fromJson(json, SiftingRecipe.JsonFormat.class);

        if (recipeJson.ingredient == null || recipeJson.result == null)
            throw new JsonSyntaxException("A required attribute is missing or null!");

        if (recipeJson.min == 0) recipeJson.min = 1;
        if (recipeJson.max == 0) recipeJson.max = recipeJson.min;

        Ingredient input = Ingredient.fromJson(recipeJson.ingredient);
        Item output = Registries.ITEM.getOrEmpty(new Identifier(recipeJson.result)).orElseThrow(() ->
                new JsonSyntaxException(String.format("Item '%s' does not exist", recipeJson.result)));
        ItemStack outputStack = new ItemStack(output, Random.create().nextBetween(recipeJson.min, recipeJson.max));

        return new SiftingRecipe(input, outputStack, id);
    }

    @Override
    public SiftingRecipe read(Identifier id, PacketByteBuf buf) {
        Ingredient input = Ingredient.fromPacket(buf);
        ItemStack output = buf.readItemStack();
        return new SiftingRecipe(input, output, id);
    }

    @Override
    public void write(PacketByteBuf buf, SiftingRecipe recipe) {
        recipe.ingredient().write(buf);
        buf.writeItemStack(recipe.getOutput());
    }
}
