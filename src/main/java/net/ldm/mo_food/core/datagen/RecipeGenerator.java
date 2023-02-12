package net.ldm.mo_food.core.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.ldm.mo_food.core.init.MoFoodTags;
import net.minecraft.data.server.recipe.CookingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.book.RecipeCategory;

import java.util.function.Consumer;

import static net.ldm.mo_food.core.init.MoFood.*;
import static net.minecraft.recipe.book.RecipeCategory.COMBAT;
import static net.minecraft.recipe.book.RecipeCategory.FOOD;

public class RecipeGenerator extends FabricRecipeProvider {
    public RecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        // Crafting
        // Food & Drinks
        offerShapelessRecipe(exporter, RAW_CHICKEN_NUGGETS, Items.CHICKEN, null, 4);
        offerSurroundRecipe(exporter, ENCHANTED_MUFFIN, FOOD, GOLDEN_MUFFIN, Items.GOLD_INGOT);
        offerKnifeSlicingRecipe(exporter, GARLIC_BREADSTICKS, 4, FOOD, GARLIC_BREAD_SLICE);
        offerSurroundRecipe(exporter, GOLDEN_MUFFIN, FOOD, MUFFIN, Items.GOLD_NUGGET);
        offerSingleOutputShapelessRecipe(exporter, LEMON, LEMON_JUICE, null);
        offerMultipleShapelessRecipe(exporter, RAW_BEEF_PATTY, 1, FOOD, Items.BEEF, GROUND_SALT);
        offerKnifeSlicingRecipe(exporter, BREADSTICKS, 4, FOOD, TOAST);
        offerMultipleShapelessRecipe(exporter, FRENCH_FRIES, 1, FOOD, OLIVE_OIL, Items.BAKED_POTATO, GROUND_SALT, Items.PAPER);
        offerMultipleShapelessRecipe(exporter, RAW_GARLIC_BREAD, 1, FOOD, GROUND_SALT, Items.BREAD, GARLIC);
        offerMultipleShapelessRecipe(exporter, OLIVE_OIL, 3, FOOD, new ItemWithSize(OLIVES, 4), Items.WATER_BUCKET);
        offerMultipleShapelessRecipe(exporter, PEPPERONI, 1, FOOD, Items.PORKCHOP, GROUND_SALT);
        offerCompactingRecipe(exporter, FOOD, PIZZA_DOUGH, FLOUR);
        offerMultipleShapelessRecipe(exporter, RAW_PEPPERONI_PIZZA, 1, FOOD, RAW_CHEESE_PIZZA, new ItemWithSize(PEPPERONI, 4));
        offerMultipleShapelessRecipe(exporter, SALTY_POTATO, 1, FOOD, Items.BAKED_POTATO, GROUND_SALT);
        offerMultipleShapelessRecipe(exporter, SUPER_SALTY_POTATO, 1, FOOD, Items.BAKED_POTATO, GROUND_SALT_BLOCK);
        offerKnifeSlicingRecipe(exporter, GARLIC_BREAD_SLICE, 3, FOOD, BAKED_GARLIC_BREAD);
        offerKnifeSlicingRecipe(exporter, TOAST, 3, FOOD, Items.BREAD);

        // Ingredients
        offerSingleOutputShapelessRecipe(exporter, FLOUR, Items.WHEAT, null);
        offerShapelessRecipe(exporter, GROUND_SALT, GROUND_SALT_BLOCK, null, 9);
        offerCompactingRecipe(exporter, RecipeCategory.MISC, GROUND_SALT_BLOCK, GROUND_SALT);

        // Weapons
        offerKnifeRecipe(exporter, IRON_KNIFE, Items.IRON_INGOT);
        offerKnifeRecipe(exporter, GOLDEN_KNIFE, Items.GOLD_INGOT);
        offerKnifeRecipe(exporter, DIAMOND_KNIFE, Items.DIAMOND);
        offerNetheriteUpgradeRecipe(exporter, DIAMOND_KNIFE, COMBAT, NETHERITE_KNIFE);

        // Smelting, etc.
        offerCooking(exporter, RAW_BACON, COOKED_BACON);
        offerCooking(exporter, RAW_BEEF_PATTY, COOKED_BEEF_PATTY);
        offerCooking(exporter, RAW_CALAMARI, COOKED_CALAMARI);
        offerCooking(exporter, RAW_CAT_STEAK, COOKED_CAT_STEAK);
        offerCooking(exporter, Items.MILK_BUCKET, CHEESE);
        offerCooking(exporter, CURDLED_MILK_BOTTLE, BUTTER);
        offerCooking(exporter, RAW_CHEESE_PIZZA, CHEESE_PIZZA);
        offerCooking(exporter, RAW_PEPPERONI_PIZZA, PEPPERONI_PIZZA);
        offerCooking(exporter, RAW_CHICKEN_NUGGETS, COOKED_CHICKEN_NUGGETS);
        offerCooking(exporter, Items.ROTTEN_FLESH, DETOXIFIED_FLESH, false, false, true, false);
        offerCooking(exporter, RAW_GARLIC_BREAD, BAKED_GARLIC_BREAD);
        offerCooking(exporter, RAW_HORSE_MEAT, COOKED_HORSE_MEAT);
        offerCooking(exporter, Items.EGG, OMELET);
        offerCooking(exporter, PIZZA_DOUGH, PIZZA_BREAD);
        offerCooking(exporter, SWEET_POTATO, BAKED_SWEET_POTATO);
        offerCooking(exporter, RAW_WOLF_MEAT, COOKED_WOLF_MEAT);
    }

    public static void offerKnifeRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        ShapedRecipeJsonBuilder.create(COMBAT, output).input('#', input).input('/', Items.STICK).pattern("#").pattern("/").group("knife").criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
    }

    public static void offerSurroundRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, RecipeCategory recipeCategory, ItemConvertible itemToSurround, ItemConvertible surroundWith) {
        ShapedRecipeJsonBuilder.create(recipeCategory, output).input('#', surroundWith).input('@', itemToSurround).pattern("###").pattern("#@#").pattern("###").criterion(hasItem(itemToSurround), conditionsFromItem(itemToSurround)).offerTo(exporter);
    }

    public static void offerKnifeSlicingRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, int count, RecipeCategory recipeCategory, ItemConvertible input) {
        ShapelessRecipeJsonBuilder.create(recipeCategory, output, count).input(input).input(MoFoodTags.KNIVES).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
    }

    public static void offerMultipleShapelessRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, int count, RecipeCategory recipeCategory, ItemConvertible... inputs) {
        ShapelessRecipeJsonBuilder builder = ShapelessRecipeJsonBuilder.create(recipeCategory, output, count);
        for (ItemConvertible input: inputs) {
            if (input.getClass() == ItemWithSize.class) builder.input(((ItemWithSize) input).item, ((ItemWithSize) input).count)
                    .criterion(hasItem(((ItemWithSize) input).item), conditionsFromItem(((ItemWithSize) input).item));
            else builder.input(input).criterion(hasItem(input), conditionsFromItem(input));
        }
        builder.offerTo(exporter);
    }

    public static void offerCooking(Consumer<RecipeJsonProvider> exporter, ItemConvertible input, ItemConvertible output, boolean smelt, boolean smoke, boolean campfireCook, boolean blast) {
        if (smelt) CookingRecipeJsonBuilder.create(Ingredient.ofItems(input), FOOD, output, 0.35f, 200, RecipeSerializer.SMELTING)
                .group(getItemPath(output)).criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter, getItemPath(output) + "_smelting");
        if (blast) CookingRecipeJsonBuilder.create(Ingredient.ofItems(input), FOOD, output, 0.35f, 100, RecipeSerializer.BLASTING)
                .group(getItemPath(output)).criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter, getItemPath(output) + "_blasting");
        if (smoke) CookingRecipeJsonBuilder.create(Ingredient.ofItems(input), FOOD, output, 0.35f, 100, RecipeSerializer.SMOKING)
                .group(getItemPath(output)).criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter, getItemPath(output) + "_smoking");
        if (campfireCook) CookingRecipeJsonBuilder.create(Ingredient.ofItems(input), FOOD, output, 0.35f, 600, RecipeSerializer.CAMPFIRE_COOKING)
                .group(getItemPath(output)).criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter, getItemPath(output) + "_campfire_cooking");
    }

    public static void offerCooking(Consumer<RecipeJsonProvider> exporter, ItemConvertible input, ItemConvertible output) {
        offerCooking(exporter, input, output, true, true, true, false);
    }

    private record ItemWithSize(ItemConvertible item, int count) implements ItemConvertible {
        @Override
        public Item asItem() {
            return item.asItem();
        }
    }
}
