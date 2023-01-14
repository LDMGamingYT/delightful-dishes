package net.ldm.morefood;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.PotatoesBlock;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.ItemConvertible;

public class SweetPotatoesBlock extends PotatoesBlock {

    public SweetPotatoesBlock( Settings settings ) {
        super(settings);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return MoreFood.SWEET_POTATO;
    }
}
