package net.ldm.mo_food.init;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

import static net.ldm.mo_food.init.MoFood.*;

public class ClientInit implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        /*BlockRenderLayerMap.INSTANCE.putBlock(SWEET_POTATOES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TOMATOES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(LETTUCE_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(GARLIC_CROP, RenderLayer.getCutout());*/
        //ScreenRegistry.register(MoFood.COOKTOP_SCREEN_HANDLER, CooktopScreen::new);
    }
}
