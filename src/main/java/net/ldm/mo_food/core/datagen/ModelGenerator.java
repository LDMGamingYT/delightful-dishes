package net.ldm.mo_food.core.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.Item;

import static net.ldm.mo_food.core.init.MoFood.*;

public class ModelGenerator extends FabricModelProvider {
    public ModelGenerator( FabricDataOutput output ) {
        super(output);
    }

    @Override
    public void generateBlockStateModels( BlockStateModelGenerator generator ) {
        generator.registerSimpleCubeAll(GROUND_SALT_BLOCK);
        // TODO: 2023-08-19 Crop block models
        /*generator.registerCrop(LETTUCE_CROP, BasicCrops.Lettuce.AGE, 0, 1, 2, 3);
        generator.registerCrop(GARLIC_CROP, BasicCrops.Garlic.AGE, 0, 1, 2, 3);
        generator.registerCrop(SWEET_POTATOES, BasicCrops.SweetPotatoes.AGE, 0, 1, 2, 3);
        generator.registerCrop(TOMATO_BUSH, TomatoesCrop.AGE);*/
    }

    @Override
    public void generateItemModels( ItemModelGenerator generator ) {
        generator.register(STONE_KNIFE, Models.GENERATED);
        generator.register(IRON_KNIFE, Models.GENERATED);
        generator.register(GOLDEN_KNIFE, Models.GENERATED);
        generator.register(DIAMOND_KNIFE, Models.GENERATED);
        generator.register(NETHERITE_KNIFE, Models.GENERATED);

        for (Item item: ITEM_MODEL_DATAGEN) {
            generator.register(item, Models.GENERATED);
        }
    }
}
