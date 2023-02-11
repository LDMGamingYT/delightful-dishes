package net.ldm.mo_food.core;

import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

public class LDMUtils {
    public static String getItemID(@NotNull ItemConvertible item) {
        return Registries.ITEM.getId(item.asItem()).getPath();
    }

    public static String getItemID(@NotNull ItemStack stack) {
        return getItemID(stack.getItem());
    }

    public static @NotNull ItemConvertible getItemFromID(Identifier id) {
        return Registries.ITEM.get(id);
    }

    public static @NotNull ItemConvertible getItemFromID(String id) {
        return getItemFromID(new Identifier(id));
    }
}
