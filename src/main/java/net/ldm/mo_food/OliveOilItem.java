package net.ldm.mo_food;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.UseAction;

public class OliveOilItem extends Item {
    public OliveOilItem(Item.Settings settings) {
        super(settings);
    }
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }
}
