package net.ldm.mo_food.block.crop;

import net.ldm.mo_food.core.init.MoFood;
import net.minecraft.block.PotatoesBlock;
import net.minecraft.item.ItemConvertible;

public class LettuceCrop extends PotatoesBlock {

    public LettuceCrop( Settings settings ) {
        super(settings);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return MoFood.LETTUCE;
    }
}
