package net.ldm.mo_food.core.init;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class MoFoodTags {
    public static final TagKey<Item> KNIVES = TagKey.of(RegistryKeys.ITEM, new Identifier(MoFood.MOD_ID, "knives"));
}
