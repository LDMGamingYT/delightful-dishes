package net.ldm.morefood;

import net.minecraft.block.PotatoesBlock;
import net.minecraft.item.ItemConvertible;

public class LettuceBlock extends PotatoesBlock {

    public LettuceBlock( Settings settings ) {
        super(settings);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return MoreFood.LETTUCE;
    }
}
