package net.ldm.mo_food.core;

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
}
