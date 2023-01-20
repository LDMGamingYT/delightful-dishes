package net.ldm.mo_food.block;

import net.ldm.mo_food.init.MoFood;
import net.minecraft.block.PotatoesBlock;
import net.minecraft.item.ItemConvertible;

public class GarlicCrop extends PotatoesBlock {

    public GarlicCrop( Settings settings ) {
        super(settings);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return MoFood.GARLIC;
    }
}
