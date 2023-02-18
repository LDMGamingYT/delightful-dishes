package net.ldm.mo_food.core.init;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.ldm.mo_food.block.CheesePizza;
import net.ldm.mo_food.block.PancakesBlock;
import net.ldm.mo_food.block.PepperoniPizza;
import net.ldm.mo_food.block.SifterBlock;
import net.ldm.mo_food.block.crop.*;
import net.ldm.mo_food.block.entity.SifterBlockEntity;
import net.ldm.mo_food.core.LDMUtils;
import net.ldm.mo_food.item.CornItem;
import net.ldm.mo_food.item.DrinkableItem;
import net.ldm.mo_food.item.ShinyItem;
import net.ldm.mo_food.recipe.SiftingRecipe;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.ArrayList;

import static net.ldm.mo_food.core.LDMUtils.foodItem;
import static net.ldm.mo_food.core.LDMUtils.foodItemSettings;

public class MoFood implements ModInitializer {
    public static final ArrayList<Item> ITEM_MODEL_DATAGEN = new ArrayList<>();
    public static final ArrayList<ItemConvertible> LANG_DATAGEN = new ArrayList<>();
    public static final String MOD_ID = "mo_food";

    public static final Block CORN_CROP = register(Registries.BLOCK, "corn", new CornCrop(FabricBlockSettings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP)), true);
    public static final Block CHEESE_PIZZA = register(Registries.BLOCK, "cheese_pizza", new CheesePizza(FabricBlockSettings.of(Material.CAKE).strength(0.5F).noCollision().sounds(BlockSoundGroup.WOOL)), true);
    public static final Block GARLIC_CROP = register(Registries.BLOCK, "garlic", new BasicCrops.Garlic(FabricBlockSettings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP)), true);
    public static final Block GROUND_SALT_BLOCK = register(Registries.BLOCK, "ground_salt_block", new Block(FabricBlockSettings.of(Material.AGGREGATE).strength(0.5f).sounds(BlockSoundGroup.SAND)));
    public static final Block LETTUCE_CROP = register(Registries.BLOCK, "lettuce", new BasicCrops.Lettuce(FabricBlockSettings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP)), true);
    public static final Block PANCAKES = register(Registries.BLOCK, "pancakes", new PancakesBlock(FabricBlockSettings.of(Material.CAKE).strength(0.5F).sounds(BlockSoundGroup.WOOL)), true);
    public static final Block PEPPERONI_PIZZA = register(Registries.BLOCK, "pepperoni_pizza", new PepperoniPizza(FabricBlockSettings.of(Material.CAKE).strength(0.5F).noCollision().sounds(BlockSoundGroup.WOOL)), true);
    public static final Block SWEET_POTATOES = register(Registries.BLOCK, "sweet_potatoes", new BasicCrops.SweetPotatoes(FabricBlockSettings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP)), true);
    public static final Block TOMATO_BUSH = register(Registries.BLOCK, "tomato_bush", new TomatoesCrop(FabricBlockSettings.of(Material.PLANT).ticksRandomly().noCollision().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));
    public static final BlockItem GROUND_SALT_BLOCK_ITEM = register(Registries.ITEM, "ground_salt_block", new BlockItem(GROUND_SALT_BLOCK, new FabricItemSettings()));
    public static final BlockItem PANCAKES_BLOCK_ITEM = register(Registries.ITEM, "pancakes", new BlockItem(PANCAKES, new FabricItemSettings()));
    public static final Item BACON = registerWithDatagen("bacon", foodItem(1, 0.2f,
            new StatusEffectInstance(StatusEffects.POISON, 1200, 3),
            new StatusEffectInstance(StatusEffects.HUNGER, 300, 2),
            new StatusEffectInstance(StatusEffects.NAUSEA, 300, 1)), true);
    public static final Item BAKED_GARLIC_BREAD = registerWithDatagen("baked_garlic_bread", foodItem(8, 9.6f), true);
    public static final Item BAKED_SWEET_POTATO = registerWithDatagen("baked_sweet_potato", foodItem(5, 6.0f), true);
    public static final Item BANANA = registerWithDatagen("banana", foodItem(4, 2.8f), true);
    public static final Item BEEF_PATTY = registerWithDatagen("beef_patty", foodItem(7, 11.4f), true);
    public static final Item BREADSTICKS = registerWithDatagen("breadsticks", foodItem(1, 0.5f), true);
    public static final Item BUTTER = registerWithDatagen("butter", foodItem(4, 1.2f), true);
    public static final Item CHEESE = registerWithDatagen("cheese", foodItem(5, 6.2f), true);
    public static final Item CHEESE_PIZZA_ITEM = registerWithDatagen("cheese_pizza", new BlockItem(CHEESE_PIZZA, new FabricItemSettings()));
    public static final Item COOKED_BACON = registerWithDatagen("cooked_bacon", foodItem(2, 1.5f, false, true), true);
    public static final Item COOKED_CALAMARI = registerWithDatagen("cooked_calamari", LDMUtils.foodItem(5, 6.0f, true), true);
    public static final Item COOKED_CAT_STEAK = registerWithDatagen("cooked_cat_steak", LDMUtils.foodItem(6, 9.6f, true), true);
    public static final Item COOKED_CHICKEN_NUGGETS = registerWithDatagen("cooked_chicken_nuggets", foodItem(2, 0.3f, false, true), true);
    public static final Item COOKED_HORSE_MEAT = registerWithDatagen("cooked_horse_meat", LDMUtils.foodItem(8, 12.8f, true), true);
    public static final Item COOKED_WOLF_MEAT = registerWithDatagen("cooked_wolf_meat", foodItem(6, 9.6f, true), true);
    public static final Item CORN = register(Registries.ITEM, "corn", new CornItem(foodItemSettings(4, 2.4f).maxCount(1)));
    public static final Item CURDLED_MILK_BOTTLE = registerWithDatagen("curdled_milk_bottle", new DrinkableItem(new FabricItemSettings()), true);
    public static final Item DETOXIFIED_FLESH = registerWithDatagen("detoxified_flesh", foodItem(1, 0.25f), true);
    public static final Item ENCHANTED_MUFFIN = registerWithDatagen("enchanted_golden_muffin", new ShinyItem(new FabricItemSettings().rarity(Rarity.RARE)
            .food(new FoodComponent.Builder().hunger(6).alwaysEdible().saturationModifier(9.6f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200, 1), 1.0f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 0), 1.0f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 300, 1), 1.0f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 300, 1), 1.0f).build())), true);
    public static final Item FLOUR = registerWithDatagen("flour", new Item(new FabricItemSettings()), true);
    public static final Item FRENCH_FRIES = registerWithDatagen("french_fries", foodItem(6, 7.2f), true);
    public static final Item GARLIC = registerWithDatagen("garlic", new BlockItem(GARLIC_CROP, new FabricItemSettings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.7f).snack().build())));
    public static final Item GARLIC_BREADSTICKS = registerWithDatagen("garlic_breadsticks", foodItem(1, 0.8f), true);
    public static final Item GARLIC_BREAD_SLICE = registerWithDatagen("garlic_bread_slice", foodItem(3, 3.2f), true);
    public static final Item GOLDEN_MUFFIN = registerWithDatagen("golden_muffin", new Item(new FabricItemSettings().rarity(Rarity.UNCOMMON).food(new FoodComponent.Builder().hunger(6).saturationModifier(14.4f).build())), true);
    public static final Item GROUND_SALT = registerWithDatagen("ground_salt", new Item(new FabricItemSettings()), true);
    public static final Item LEMON = registerWithDatagen("lemon", foodItem(1, 1.2f), true);
    public static final Item LEMON_JUICE = registerWithDatagen("lemon_juice", new DrinkableItem(new FabricItemSettings()), true);
    public static final Item LETTUCE = registerWithDatagen("lettuce", new BlockItem(LETTUCE_CROP, new FabricItemSettings().food(new FoodComponent.Builder().hunger(1).saturationModifier(1.2f).snack().build())));
    public static final Item MINCED_BEEF = registerWithDatagen("minced_beef", foodItem(3, 1.8f), true);
    public static final Item MUFFIN = registerWithDatagen("muffin", foodItem(6, 1.2f), true);
    public static final Item OLIVES = registerWithDatagen("olives", foodItem(1, 1.2f, false, true), true);
    public static final Item OLIVE_OIL = registerWithDatagen("olive_oil", new DrinkableItem(new FabricItemSettings()), true);
    public static final Item OMELET = registerWithDatagen("omelet", foodItem(5, 3.2f), true);
    public static final Item PEPPERONI = registerWithDatagen("pepperoni", foodItem(1, 1.0f, true, true), true);
    public static final Item PEPPERONI_PIZZA_ITEM = registerWithDatagen("pepperoni_pizza", new BlockItem(PEPPERONI_PIZZA, new FabricItemSettings()));
    public static final Item PIZZA_BREAD = registerWithDatagen("pizza_bread", foodItem(8, 8.0f), true);
    public static final Item PIZZA_DOUGH = registerWithDatagen("pizza_dough", new Item(new FabricItemSettings()), true);
    public static final Item CALAMARI = registerWithDatagen("calamari", LDMUtils.foodItem(2, 0.4f, true), true);
    public static final Item CAT_STEAK = registerWithDatagen("cat_steak", LDMUtils.foodItem(2, 1.2f, true), true);
    public static final Item RAW_CHEESE_PIZZA = registerWithDatagen("raw_cheese_pizza", new Item(new FabricItemSettings()), true);
    public static final Item CHICKEN_NUGGETS = registerWithDatagen("chicken_nuggets", foodItem(1, 0.8f, new LDMUtils.FoodEffect(new StatusEffectInstance(StatusEffects.HUNGER, 600, 0), 0.3f)), true);
    public static final Item GARLIC_BREAD = registerWithDatagen("garlic_bread", foodItem(3, 4.6f), true);
    public static final Item HORSE_MEAT = registerWithDatagen("horse_meat", LDMUtils.foodItem(3, 1.8f, true), true);
    public static final Item RAW_PEPPERONI_PIZZA = registerWithDatagen("raw_pepperoni_pizza", new Item(new FabricItemSettings()), true);
    public static final Item WOLF_MEAT = registerWithDatagen("wolf_meat", foodItem(2, 1.2f, true), true);
    public static final Item SALTY_POTATO = registerWithDatagen("salty_potato", foodItem(7, 5.8f), true);
    public static final Item SUPER_SALTY_POTATO = registerWithDatagen("super_salty_potato", foodItem(10, 0.6f), true);
    public static final Item SWEET_POTATO = registerWithDatagen("sweet_potato", new BlockItem(SWEET_POTATOES, foodItemSettings(1, 0.8f)));
    public static final Item TOAST = registerWithDatagen("toast", foodItem(2, 2.0f), true);
    public static final Item TOMATO = registerWithDatagen("tomato", new BlockItem(TOMATO_BUSH, foodItemSettings(1, 1.2f)), true);
    // TODO: 2023-02-15 Add bell peppers
    // NOTE: 2023-02-15 Textures already exist

    public static final SwordItem STONE_KNIFE = register(Registries.ITEM, "stone_knife", new SwordItem(ToolMaterials.STONE, 1, -2.0f, new FabricItemSettings().recipeRemainder(MoFood.STONE_KNIFE)), true);
    public static final SwordItem IRON_KNIFE = register(Registries.ITEM, "iron_knife", new SwordItem(ToolMaterials.IRON, 1, -2.0f, new FabricItemSettings().recipeRemainder(MoFood.IRON_KNIFE)), true);
    public static final SwordItem GOLDEN_KNIFE = register(Registries.ITEM, "golden_knife", new SwordItem(ToolMaterials.GOLD, 1, -2.0f, new FabricItemSettings().recipeRemainder(MoFood.GOLDEN_KNIFE)), true);
    public static final SwordItem DIAMOND_KNIFE = register(Registries.ITEM, "diamond_knife", new SwordItem(ToolMaterials.DIAMOND, 1, -2.0f, new FabricItemSettings().recipeRemainder(MoFood.DIAMOND_KNIFE)), true);
    public static final SwordItem NETHERITE_KNIFE = register(Registries.ITEM, "netherite_knife", new SwordItem(ToolMaterials.NETHERITE, 1, -2.0f, new FabricItemSettings().recipeRemainder(MoFood.NETHERITE_KNIFE)), true);

    public static final Block SIFTER = register(Registries.BLOCK, "sifter", new SifterBlock(FabricBlockSettings.of(Material.WOOD).strength(2f).sounds(BlockSoundGroup.WOOL)), true);
    public static final Item SIFTER_BLOCK_ITEM = register(Registries.ITEM, "sifter", new BlockItem(SIFTER, new FabricItemSettings()));
    public static final BlockEntityType<SifterBlockEntity> SIFTER_BLOCK_ENTITY = register(Registries.BLOCK_ENTITY_TYPE, "sifter_block_entity", FabricBlockEntityTypeBuilder.create(SifterBlockEntity::new, SIFTER).build());

    private static Item registerWithDatagen(String id, Item entry, boolean genLang) {
        Item registryInstance = register(Registries.ITEM, id, entry, genLang);
        ITEM_MODEL_DATAGEN.add(registryInstance);
        return registryInstance;
    }

    private static Item registerWithDatagen(String id, Item entry) {
        return registerWithDatagen(id, entry, false);
    }

    private static <V, T extends V> T register(Registry<V> registry, String id, T entry, boolean genLang) {
        T registryInstance = Registry.register(registry, new Identifier(MOD_ID, id), entry);
        if (genLang) LANG_DATAGEN.add((ItemConvertible) registryInstance);
        return registryInstance;
    }

    private static <V, T extends V> T register(Registry<V> registry, String id, T entry) {
        return register(registry, id, entry, false);
    }

    @Override
    public void onInitialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(OMELET);
            entries.add(BACON);
            entries.add(COOKED_BACON);
            entries.add(MUFFIN);
            entries.add(GOLDEN_MUFFIN);
            entries.add(ENCHANTED_MUFFIN);
            entries.add(SWEET_POTATO);
            entries.add(BAKED_SWEET_POTATO);
            entries.add(SALTY_POTATO);
            entries.add(SUPER_SALTY_POTATO);
            entries.add(CHICKEN_NUGGETS);
            entries.add(COOKED_CHICKEN_NUGGETS);
            entries.add(LETTUCE);
            entries.add(PIZZA_DOUGH);
            entries.add(CHEESE);
            entries.add(PIZZA_BREAD);
            entries.add(RAW_CHEESE_PIZZA);
            entries.add(RAW_PEPPERONI_PIZZA);
            entries.add(PEPPERONI);
            entries.add(WOLF_MEAT);
            entries.add(COOKED_WOLF_MEAT);
            entries.add(HORSE_MEAT);
            entries.add(COOKED_HORSE_MEAT);
            entries.add(CAT_STEAK);
            entries.add(COOKED_CAT_STEAK);
            entries.add(CALAMARI);
            entries.add(COOKED_CALAMARI);
            entries.add(OLIVES);
            entries.add(LEMON);
            entries.add(FRENCH_FRIES);
            entries.add(BUTTER);
            entries.add(MINCED_BEEF);
            entries.add(BEEF_PATTY);
            entries.add(DETOXIFIED_FLESH);
            entries.add(GARLIC_BREAD);
            entries.add(BAKED_GARLIC_BREAD);
            entries.add(TOAST);
            entries.add(GARLIC_BREAD_SLICE);
            entries.add(BREADSTICKS);
            entries.add(GARLIC_BREADSTICKS);
            entries.add(BANANA);
            entries.add(CURDLED_MILK_BOTTLE);
            entries.add(OLIVE_OIL);
            entries.add(LEMON_JUICE);
            entries.add(PANCAKES_BLOCK_ITEM);
            entries.add(SWEET_POTATO);
            entries.add(LETTUCE);
            entries.add(TOMATO);
            entries.add(CHEESE_PIZZA_ITEM);
            entries.add(PEPPERONI_PIZZA_ITEM);
            entries.add(GARLIC);
            entries.add(CORN);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(FLOUR);
            entries.add(GROUND_SALT);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(STONE_KNIFE);
            entries.add(IRON_KNIFE);
            entries.add(GOLDEN_KNIFE);
            entries.add(DIAMOND_KNIFE);
            entries.add(NETHERITE_KNIFE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> entries.add(GROUND_SALT_BLOCK_ITEM));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> entries.add(SIFTER_BLOCK_ITEM));

        Registry.register(Registries.RECIPE_SERIALIZER, SiftingRecipe.Serializer.ID, SiftingRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(MOD_ID, SiftingRecipe.Type.ID), SiftingRecipe.Type.INSTANCE);
    }
}