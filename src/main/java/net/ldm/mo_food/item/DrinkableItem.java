package net.ldm.mo_food.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.UseAction;

public class DrinkableItem extends Item {
    public DrinkableItem( Item.Settings settings) {
        super(settings);
    }
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }
}
