package net.ldm.mo_food.core.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

import static net.ldm.mo_food.core.init.MoFood.*;

public class ModelGenerator extends FabricModelProvider {
    public ModelGenerator( FabricDataOutput output ) {
        super(output);
    }

    @Override
    public void generateBlockStateModels( BlockStateModelGenerator generator ) {
        generator.registerSimpleCubeAll(SALT_BLOCK);
    }

    @Override
    public void generateItemModels( ItemModelGenerator generator ) {
        generator.register(OMELET, Models.GENERATED);
    }
}
