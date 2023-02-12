package net.ldm.mo_food.core.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

import static net.ldm.mo_food.core.init.MoFood.*;

public class ModelGenerator extends FabricModelProvider {
    public ModelGenerator( FabricDataOutput output ) {
        super(output);
    }

    @Override
    public void generateBlockStateModels( BlockStateModelGenerator generator ) {
        generator.registerSimpleCubeAll(GROUND_SALT_BLOCK);
        /*generator.registerCrop(LETTUCE_CROP, IntProperty.of("age", 0, 7), 0, 1, 2, 3);
        generator.registerCrop(GARLIC_CROP, IntProperty.of("age", 0, 7), 0, 1, 2, 3);
        generator.registerCrop(SWEET_POTATOES, IntProperty.of("age", 0, 7), 0, 1, 2, 3);
        generator.registerCrop(TOMATOES, IntProperty.of("age", 0, 3));*/
    }

    @Override
    public void generateItemModels( ItemModelGenerator generator ) {
        generator.register(GARLIC, Models.GENERATED);
        generator.register(LETTUCE, Models.GENERATED);
        generator.register(SWEET_POTATO, Models.GENERATED);
        generator.register(TOMATO, Models.GENERATED);
        generator.register(CHEESE_PIZZA_ITEM, Models.GENERATED);
        generator.register(PEPPERONI_PIZZA_ITEM, Models.GENERATED);

        generator.register(RAW_BACON, Models.GENERATED);
        generator.register(BAKED_GARLIC_BREAD, Models.GENERATED);
        generator.register(BAKED_SWEET_POTATO, Models.GENERATED);
        generator.register(BANANA, Models.GENERATED);
        generator.register(MINCED_BEEF, Models.GENERATED);
        generator.register(BREADSTICKS, Models.GENERATED);
        generator.register(BUTTER, Models.GENERATED);
        generator.register(RAW_CALAMARI, Models.GENERATED);
        generator.register(RAW_CAT_STEAK, Models.GENERATED);
        generator.register(COOKED_BACON, Models.GENERATED);
        generator.register(BEEF_PATTY, Models.GENERATED);
        generator.register(COOKED_CALAMARI, Models.GENERATED);
        generator.register(COOKED_CAT_STEAK, Models.GENERATED);
        generator.register(COOKED_CHICKEN_NUGGETS, Models.GENERATED);
        generator.register(COOKED_HORSE_MEAT, Models.GENERATED);
        generator.register(COOKED_WOLF_MEAT, Models.GENERATED);
        generator.register(DETOXIFIED_FLESH, Models.GENERATED);
        generator.register(ENCHANTED_MUFFIN, Models.GENERATED);
        generator.register(FLOUR, Models.GENERATED);
        generator.register(FRENCH_FRIES, Models.GENERATED);
        generator.register(RAW_GARLIC_BREAD, Models.GENERATED);
        generator.register(GARLIC_BREAD_SLICE, Models.GENERATED);
        generator.register(GARLIC_BREADSTICKS, Models.GENERATED);
        generator.register(GOLDEN_MUFFIN, Models.GENERATED);
        generator.register(RAW_HORSE_MEAT, Models.GENERATED);
        generator.register(LEMON, Models.GENERATED);
        generator.register(LEMON_JUICE, Models.GENERATED);
        generator.register(CURDLED_MILK_BOTTLE, Models.GENERATED);
        generator.register(MUFFIN, Models.GENERATED);
        generator.register(OLIVE_OIL, Models.GENERATED);
        generator.register(OLIVES, Models.GENERATED);
        generator.register(PEPPERONI, Models.GENERATED);
        generator.register(PIZZA_BREAD, Models.GENERATED);
        generator.register(PIZZA_DOUGH, Models.GENERATED);
        generator.register(RAW_CHEESE_PIZZA, Models.GENERATED);
        generator.register(RAW_PEPPERONI_PIZZA, Models.GENERATED);
        generator.register(GROUND_SALT, Models.GENERATED);
        generator.register(SALTY_POTATO, Models.GENERATED);
        generator.register(SUPER_SALTY_POTATO, Models.GENERATED);
        generator.register(TOAST, Models.GENERATED);
        generator.register(RAW_WOLF_MEAT, Models.GENERATED);
        generator.register(OMELET, Models.GENERATED);
        generator.register(RAW_CHICKEN_NUGGETS, Models.GENERATED);
        generator.register(CHEESE, Models.GENERATED);

        generator.register(STONE_KNIFE, Models.GENERATED);
        generator.register(IRON_KNIFE, Models.GENERATED);
        generator.register(GOLDEN_KNIFE, Models.GENERATED);
        generator.register(DIAMOND_KNIFE, Models.GENERATED);
        generator.register(NETHERITE_KNIFE, Models.GENERATED);
    }
}
