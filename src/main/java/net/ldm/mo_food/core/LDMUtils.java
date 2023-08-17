package net.ldm.mo_food.core;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class LDMUtils {
    public static String getItemID(ItemConvertible item) {
        if (item == null) return "";
        return Registries.ITEM.getId(item.asItem()).getPath();
    }

    public static String getItemID(ItemStack stack) {
        if (stack == null) return "";
        return getItemID(stack.getItem());
    }

    public static ItemConvertible getItemFromID(Identifier id) {
        if (id == null) return null;
        return Registries.ITEM.get(id);
    }

    public static ItemConvertible getItemFromID(String id) {
        if (id == null || id.isEmpty()) return null;
        return getItemFromID(new Identifier(id));
    }

    public static ItemStack getItemOrNull(ItemConvertible item) {
        if (item == null) return null;
        else return item.asItem().getDefaultStack();
    }

    public static Item foodItem(int hunger, float saturation, boolean isMeat, boolean isSnack, FoodEffect... effects) {
        FoodComponent.Builder builder = new FoodComponent.Builder().hunger(hunger).saturationModifier(saturation);
        if (isSnack) builder.snack();
        if (isMeat) builder.meat();

        for (FoodEffect effect: effects) {
            builder.statusEffect(effect.instance, effect.chance);
        }

        return new Item(new FabricItemSettings().food(builder.build()));
    }

    public static Item foodItem(int hunger, float saturation, FoodEffect... effects) {
        return foodItem(hunger, saturation, false, false, effects);
    }

    public static Item foodItem(int hunger, float saturation, boolean isMeat, boolean isSnack, StatusEffectInstance... effects) {
        FoodComponent.Builder builder = new FoodComponent.Builder().hunger(hunger).saturationModifier(saturation);
        if (isSnack) builder.snack();
        if (isMeat) builder.meat();

        for (StatusEffectInstance instance: effects) {
            builder.statusEffect(instance, 1.0f);
        }

        return new Item(new FabricItemSettings().food(builder.build()));
    }

    public static Item foodItem(int hunger, float saturation, StatusEffectInstance... effects) {
        return foodItem(hunger, saturation, false, false, effects);
    }

    public static Item foodItem(int hunger, float saturation, boolean isMeat, boolean isSnack) {
        FoodComponent.Builder builder = new FoodComponent.Builder().hunger(hunger).saturationModifier(saturation);
        if (isSnack) builder.snack();
        if (isMeat) builder.meat();
        return new Item(new FabricItemSettings().food(builder.build()));
    }

    public static Item foodItem(int hunger, float saturation, boolean isMeat) {
        return foodItem(hunger, saturation, isMeat, false);
    }

    public static Item foodItem(int hunger, float saturation) {
        return foodItem(hunger, saturation, false, false);
    }

    public static FabricItemSettings foodItemSettings(int hunger, float saturation) {
        return new FabricItemSettings().food(new FoodComponent.Builder().hunger(hunger).saturationModifier(saturation).build());
    }

    public record FoodEffect(StatusEffectInstance instance, float chance) {
    }
}
