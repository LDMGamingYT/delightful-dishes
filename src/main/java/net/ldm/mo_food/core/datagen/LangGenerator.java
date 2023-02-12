package net.ldm.mo_food.core.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

import static net.ldm.mo_food.core.init.MoFood.*;

public class LangGenerator extends FabricLanguageProvider {
    protected LangGenerator( FabricDataOutput dataOutput ) {
        super(dataOutput, "en_us");
    }

    @Override
    public void generateTranslations( TranslationBuilder builder ) {
        // Blocks
        builder.add(CHEESE_PIZZA, "Cheese Pizza");
        builder.add(GARLIC_CROP, "Garlic");
        builder.add(LETTUCE_CROP, "Lettuce");
        builder.add(PANCAKES, "Pancakes");
        builder.add(PEPPERONI_PIZZA, "Pepperoni Pizza");
        builder.add(GROUND_SALT_BLOCK, "Block of Ground Salt");
        builder.add(SIFTER, "Sifter");
        builder.add(SWEET_POTATOES, "Sweet Potatoes");
        builder.add(TOMATOES, "Tomatoes");

        // Food & Ingredients
        builder.add(RAW_BACON, "Raw Bacon");
        builder.add(BAKED_GARLIC_BREAD, "Baked Garlic Bread");
        builder.add(BAKED_SWEET_POTATO, "Baked Sweet Potato");
        builder.add(BANANA, "Banana");
        builder.add(MINCED_BEEF, "Raw Beef Patty");
        builder.add(BREADSTICKS, "Breadsticks");
        builder.add(BUTTER, "Butter");
        builder.add(RAW_CALAMARI, "Raw Calamari");
        builder.add(RAW_CAT_STEAK, "Raw Cat Steak");
        builder.add(COOKED_BACON, "Cooked Bacon");
        builder.add(BEEF_PATTY, "Cooked Beef Patty");
        builder.add(COOKED_CALAMARI, "Cooked Calamari");
        builder.add(COOKED_CAT_STEAK, "Cooked Cat Steak");
        builder.add(COOKED_CHICKEN_NUGGETS, "Cooked Chicken Nuggets");
        builder.add(COOKED_HORSE_MEAT, "Cooked Horse Meat");
        builder.add(COOKED_WOLF_MEAT, "Cooked Wolf Meat");
        builder.add(DETOXIFIED_FLESH, "Detoxified Flesh");
        builder.add(ENCHANTED_MUFFIN, "Enchanted Golden Muffin");
        builder.add(FLOUR, "Flour");
        builder.add(FRENCH_FRIES, "French Fries");
        builder.add(RAW_GARLIC_BREAD, "Raw Garlic Bread");
        builder.add(GARLIC_BREAD_SLICE, "Slice of Garlic Bread");
        builder.add(GARLIC_BREADSTICKS, "Garlic Breadsticks");
        builder.add(GOLDEN_MUFFIN, "Golden Muffin");
        builder.add(RAW_HORSE_MEAT, "Raw Horse Meat");
        builder.add(LEMON, "Lemon");
        builder.add(LEMON_JUICE, "Lemon Juice");
        builder.add(CURDLED_MILK_BOTTLE, "Curdled Milk Bottle");
        builder.add(MUFFIN, "Muffin");
        builder.add(OLIVE_OIL, "Olive Oil");
        builder.add(OLIVES, "Olives");
        builder.add(PEPPERONI, "Pepperoni");
        builder.add(PIZZA_BREAD, "Pizza Bread");
        builder.add(PIZZA_DOUGH, "Pizza Dough");
        builder.add(RAW_CHEESE_PIZZA, "Raw Cheese Pizza");
        builder.add(RAW_PEPPERONI_PIZZA, "Raw Pepperoni Pizza");
        builder.add(GROUND_SALT, "Ground Salt");
        builder.add(SALTY_POTATO, "Salty Potato");
        builder.add(SUPER_SALTY_POTATO, "Super Salty Potato");
        builder.add(TOAST, "Toast");
        builder.add(RAW_WOLF_MEAT, "Raw Wolf Meat");
        builder.add(OMELET, "Omelet");
        builder.add(RAW_CHICKEN_NUGGETS, "Raw Chicken Nuggets");
        builder.add(CHEESE, "Cheese");

        // Tools, Weapons & Armor
        builder.add(STONE_KNIFE, "Stone Knife");
        builder.add(IRON_KNIFE, "Iron Knife");
        builder.add(GOLDEN_KNIFE, "Golden Knife");
        builder.add(DIAMOND_KNIFE, "Diamond Knife");
        builder.add(NETHERITE_KNIFE, "Netherite Knife");
    }
}
