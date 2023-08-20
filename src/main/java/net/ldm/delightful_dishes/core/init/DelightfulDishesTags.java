package net.ldm.delightful_dishes.core.init;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class DelightfulDishesTags {
    public static final TagKey<Item> KNIVES = TagKey.of(RegistryKeys.ITEM, new Identifier(DelightfulDishes.MOD_ID, "knives"));
}
