package net.ldm.morefood;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class EnchantedMuffinFood extends Item {
    public EnchantedMuffinFood( Settings item$Settings_1) {
        super(item$Settings_1);
    }

    @Override
    public boolean hasGlint( ItemStack stack ) {
        return true;
    }
}
