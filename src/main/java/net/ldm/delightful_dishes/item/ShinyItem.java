package net.ldm.delightful_dishes.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ShinyItem extends Item {
    public ShinyItem( Settings item$Settings_1) {
        super(item$Settings_1);
    }

    @Override
    public boolean hasGlint( ItemStack stack ) {
        return true;
    }
}
