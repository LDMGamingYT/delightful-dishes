package net.ldm.mo_food.init;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.ldm.mo_food.block.*;
import net.ldm.mo_food.item.DrinkableItem;
import net.ldm.mo_food.item.ShinyItem;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class MoFood implements ModInitializer {
    public static final String MOD_ID = "mo_food";

    //TODO: Go through every item until I find what is crashing the game.
    public static final Item OMELET = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "omelet"), new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(6).saturationModifier(6f).build())));
    /*public static final Item FLOUR = new Item(new FabricItemSettings());
    public static final Block PANCAKES = new PancakesBlock(FabricBlockSettings.of(Material.CAKE).strength(0.5F).sounds(BlockSoundGroup.WOOL));
    public static final Item RAW_BACON = new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.2f).statusEffect(new StatusEffectInstance(StatusEffects.POISON,60*20,3), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER,15*20, 2), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA,15*20, 1), 1.0f).build()));
    public static final Item COOKED_BACON = new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(1.5f).snack().build()));
    public static final Item MUFFIN = new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(6).saturationModifier(1.2f).build()));
    public static final Item GOLDEN_MUFFIN = new Item(new FabricItemSettings().rarity(Rarity.UNCOMMON).food(new FoodComponent.Builder().hunger(6).saturationModifier(14.4f).build()));
    public static final Item ENCHANTED_MUFFIN = new ShinyItem(new FabricItemSettings().rarity(Rarity.RARE).food(new FoodComponent.Builder().hunger(6).alwaysEdible().saturationModifier(9.6f).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,10*20,1), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION,120*20,0), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.SPEED,15*20,1), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST,15*20,1), 1.0f).build()));
    public static final Item SWEET_POTATO = new Item((new FabricItemSettings()).food(new FoodComponent.Builder().hunger(1).saturationModifier(0.8f).build()));
    public static final Item BAKED_SWEET_POTATO = new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(5).saturationModifier(6.0f).build()));
    public static final Block SWEET_POTATOES = new SweetPotatoesBlock(FabricBlockSettings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP));
    public static final Item SALTY_POTATO = new Item((new FabricItemSettings()).food(new FoodComponent.Builder().hunger(7).saturationModifier(5.8f).build()));
    public static final Block SALT_BLOCK = new Block(AbstractBlock.Settings.of(Material.AGGREGATE).strength(0.5f).sounds(BlockSoundGroup.SAND));
    public static final Item SALT = new Item((new FabricItemSettings()));
    public static final Item SUPER_SALTY_POTATO = new Item((new FabricItemSettings()).food(new FoodComponent.Builder().hunger(10).saturationModifier(0.6f).build()));
    public static final Item RAW_CHICKEN_NUGGET = new Item((new FabricItemSettings()).food(new FoodComponent.Builder().hunger(1).saturationModifier(0.8f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER,30*20,0), 0.3f).build()));
    public static final Item COOKED_CHICKEN_NUGGET = new Item((new FabricItemSettings()).food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3f).snack().build()));
    public static final Block TOMATOES = new TomatoesBlock(FabricBlockSettings.of(Material.PLANT).ticksRandomly().noCollision().sounds(BlockSoundGroup.SWEET_BERRY_BUSH));
    public static final Item LETTUCE = new Item((new FabricItemSettings()).food(new FoodComponent.Builder().hunger(1).saturationModifier(1.2f).build()));
    public static final Block LETTUCE_CROP = new LettuceBlock(FabricBlockSettings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP));
    public static final Item PIZZA_DOUGH = new Item((new FabricItemSettings()));
    public static final Item CHEESE = new Item((new FabricItemSettings()).food(new FoodComponent.Builder().hunger(5).saturationModifier(6.2f).build()));
    public static final Item PIZZA_BREAD = new Item((new FabricItemSettings()).food(new FoodComponent.Builder().hunger(8).saturationModifier(8.0f).build()));
    public static final Block CHEESE_PIZZA = new CheesePizza(FabricBlockSettings.of(Material.CAKE).strength(0.5F).noCollision().sounds(BlockSoundGroup.WOOL));
    public static final Block PEPPERONI_PIZZA = new PepperoniPizza(FabricBlockSettings.of(Material.CAKE).strength(0.5F).noCollision().sounds(BlockSoundGroup.WOOL));
    public static final Item RAW_CHEESE_PIZZA = new Item((new FabricItemSettings()));
    public static final Item RAW_PEPPERONI_PIZZA = new Item((new FabricItemSettings()));
    public static final Item MILK = new Item((new FabricItemSettings()));
    public static final Item PEPPERONI = new Item((new FabricItemSettings()).food(new FoodComponent.Builder().hunger(1).saturationModifier(1.0f).snack().build()));
    public static final Item RAW_WOLF_MEAT = new Item((new FabricItemSettings()).food(new FoodComponent.Builder().meat().hunger(2).saturationModifier(1.2f).build()));
    public static final Item COOKED_WOLF_MEAT = new Item((new FabricItemSettings()).food(new FoodComponent.Builder().meat().hunger(6).saturationModifier(9.6f).build()));
    public static final Item RAW_HORSE_MEAT = new Item((new FabricItemSettings()).food(new FoodComponent.Builder().meat().hunger(3).saturationModifier(1.8f).build()));
    public static final Item COOKED_HORSE_MEAT = new Item((new FabricItemSettings()).food(new FoodComponent.Builder().meat().hunger(8).saturationModifier(12.8f).build()));
    public static final Item RAW_CAT_STEAK = new Item((new FabricItemSettings()).food(new FoodComponent.Builder().meat().hunger(2).saturationModifier(1.2f).build()));
    public static final Item COOKED_CAT_STEAK = new Item((new FabricItemSettings()).food(new FoodComponent.Builder().meat().hunger(6).saturationModifier(9.6f).build()));
    public static final Item RAW_CALAMARI = new Item((new FabricItemSettings()).food(new FoodComponent.Builder().meat().hunger(2).saturationModifier(0.4f).build()));
    public static final Item COOKED_CALAMARI = new Item((new FabricItemSettings()).food(new FoodComponent.Builder().meat().hunger(5).saturationModifier(6f).build()));
    public static final Item OLIVES = new Item((new FabricItemSettings()).food(new FoodComponent.Builder().snack().hunger(1).saturationModifier(1.2f).build()));
    public static final Item LEMON = new Item((new FabricItemSettings()).food(new FoodComponent.Builder().hunger(1).saturationModifier(1.2f).build()));
    public static final Item OLIVE_OIL = new DrinkableItem((new FabricItemSettings()));
    public static final Item FRENCH_FRIES = new Item((new FabricItemSettings()).food(new FoodComponent.Builder().hunger(6).saturationModifier(7.2f).build()));
    public static final Item LEMON_JUICE = new Item((new FabricItemSettings()));
    public static final Item BUTTER = new Item((new FabricItemSettings()).food(new FoodComponent.Builder().hunger(4).saturationModifier(1.2f).build()));
    public static final Item RAW_BEEF_PATTY = new Item((new FabricItemSettings()).food(new FoodComponent.Builder().hunger(3).saturationModifier(1.8f).build()));
    public static final Item COOKED_BEEF_PATTY = new Item((new FabricItemSettings()).food(new FoodComponent.Builder().hunger(7).saturationModifier(11.4f).build()));
    public static final Item DETOXIFIED_FLESH = new Item((new FabricItemSettings()).food(new FoodComponent.Builder().hunger(1).saturationModifier(0.25f).build()));
    public static final Block GARLIC_CROP = new LettuceBlock(FabricBlockSettings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP));
    public static final Item RAW_GARLIC_BREAD = new Item((new FabricItemSettings()).food(new FoodComponent.Builder().hunger(3).saturationModifier(4.6f).build()));
    public static final Item BAKED_GARLIC_BREAD = new Item((new FabricItemSettings()).food(new FoodComponent.Builder().hunger(8).saturationModifier(9.6f).build()));
    public static final Item TOAST = new Item((new FabricItemSettings()).food(new FoodComponent.Builder().hunger(2).saturationModifier(2.0f).build()));
    public static final Item GARLIC_TOAST = new Item((new FabricItemSettings()).food(new FoodComponent.Builder().hunger(3).saturationModifier(3.2f).build()));
    public static final Item BREADSTICKS = new Item((new FabricItemSettings()).food(new FoodComponent.Builder().hunger(1).saturationModifier(0.5f).build()));
    public static final Item GARLIC_BREADSTICKS = new Item((new FabricItemSettings()).food(new FoodComponent.Builder().hunger(1).saturationModifier(0.8f).build()));

    public static final SwordItem STONE_KNIFE = new SwordItem(ToolMaterials.STONE, 1, -2.0f, (new FabricItemSettings()).recipeRemainder(MoFood.STONE_KNIFE));
    public static final SwordItem IRON_KNIFE = new SwordItem(ToolMaterials.IRON, 1, -2.0f, (new FabricItemSettings()).recipeRemainder(MoFood.IRON_KNIFE));
    public static final SwordItem GOLDEN_KNIFE = new SwordItem(ToolMaterials.GOLD, 1, -2.0f, (new FabricItemSettings()).recipeRemainder(MoFood.GOLDEN_KNIFE));
    public static final SwordItem DIAMOND_KNIFE = new SwordItem(ToolMaterials.DIAMOND, 1, -2.0f, (new FabricItemSettings()).recipeRemainder(MoFood.DIAMOND_KNIFE));
    public static final SwordItem NETHERITE_KNIFE = new SwordItem(ToolMaterials.NETHERITE, 1, -2.0f, (new FabricItemSettings()).recipeRemainder(MoFood.NETHERITE_KNIFE));
    public static final Item BANANA = new Item((new FabricItemSettings()).food(new FoodComponent.Builder().hunger(4).saturationModifier(2.8f).build()));*/

    @Override
    public void onInitialize() {
        //TODO: Move all of the register() methods into the lambda method (see above)
        //Registry.register(Registries.ITEM, new Identifier(MOD_ID, "omelet"), OMELET);
        /*Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "pancakes"), PANCAKES);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "pancakes"), new BlockItem(PANCAKES, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "flour"), FLOUR);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "bacon"), RAW_BACON);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "cooked_bacon"), COOKED_BACON);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "muffin"), MUFFIN);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "golden_muffin"), GOLDEN_MUFFIN);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "enchanted_golden_muffin"), ENCHANTED_MUFFIN);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "sweet_potato"), new BlockItem(SWEET_POTATOES, new FabricItemSettings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.8f).build())));
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "baked_sweet_potato"), BAKED_SWEET_POTATO);
        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "sweet_potatoes"), SWEET_POTATOES);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "salty_potato"), SALTY_POTATO);
        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "salt_block"), SALT_BLOCK);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "salt_block"), new BlockItem(SALT_BLOCK, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "salt"), SALT);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "super_salty_potato"), SUPER_SALTY_POTATO);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "chicken_nuggets"), RAW_CHICKEN_NUGGET);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "cooked_chicken_nuggets"), COOKED_CHICKEN_NUGGET);
        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "tomatoes"), TOMATOES);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "tomato"), new BlockItem(TOMATOES, new FabricItemSettings().food(new FoodComponent.Builder().hunger(1).saturationModifier(1.2f).build())));
        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "lettuce"), LETTUCE_CROP);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "lettuce"), new BlockItem(LETTUCE_CROP, new FabricItemSettings().food(new FoodComponent.Builder().hunger(1).saturationModifier(1.2f).snack().build())));
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "pizza_dough"), PIZZA_DOUGH);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "cheese"), CHEESE);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "pizza_bread"), PIZZA_BREAD);
        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "cheese_pizza"), CHEESE_PIZZA);
        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "pepperoni_pizza"), PEPPERONI_PIZZA);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "cheese_pizza"), new BlockItem(CHEESE_PIZZA, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "pepperoni_pizza"), new BlockItem(PEPPERONI_PIZZA, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "raw_cheese_pizza"), RAW_CHEESE_PIZZA);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "raw_pepperoni_pizza"), RAW_PEPPERONI_PIZZA);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "milk"), MILK);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "pepperoni"), PEPPERONI);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "wolf_meat"), RAW_WOLF_MEAT);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "cooked_wolf_meat"), COOKED_WOLF_MEAT);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "cat_steak"), RAW_CAT_STEAK);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "cooked_cat_steak"), COOKED_CAT_STEAK);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "horse_meat"), RAW_HORSE_MEAT);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "cooked_horse_meat"), COOKED_HORSE_MEAT);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "calamari"), RAW_CALAMARI);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "cooked_calamari"), COOKED_CALAMARI);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "olives"), OLIVES);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "olive_oil"), OLIVE_OIL);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "french_fries"), FRENCH_FRIES);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "lemon"), LEMON);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "lemon_juice"), LEMON_JUICE);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "butter"), BUTTER);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "beef_patty"), RAW_BEEF_PATTY);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "cooked_beef_patty"), COOKED_BEEF_PATTY);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "detoxified_flesh"), DETOXIFIED_FLESH);
        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "garlic"), GARLIC_CROP);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "garlic"), new BlockItem(GARLIC_CROP, new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.4f).build())));
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "garlic_bread"), RAW_GARLIC_BREAD);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "baked_garlic_bread"), BAKED_GARLIC_BREAD);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "toast"), TOAST);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "garlic_bread_slice"), GARLIC_TOAST);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "breadsticks"), BREADSTICKS);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "garlic_breadsticks"), GARLIC_BREADSTICKS);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "stone_knife"), STONE_KNIFE);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "iron_knife"), IRON_KNIFE);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "golden_knife"), GOLDEN_KNIFE);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "diamond_knife"), DIAMOND_KNIFE);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "netherite_knife"), NETHERITE_KNIFE);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "banana"), BANANA);*/

        //TODO: Add all items into creative tabs. (ITEMS WILL NOT LOAD WITHOUT THIS)
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> entries.add(OMELET));
    }
}