package net.ldm.mo_food.core.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class DataGen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator( FabricDataGenerator fabricDataGenerator ) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(LangGenerator::new);
        pack.addProvider(ModelGenerator::new);
        pack.addProvider(RecipeGenerator::new);
        pack.addProvider(LootTableGenerator.Blocks::new);
    }

    /*
     * Completed data-gen:
     * Lang (auto)
     * Item models
     * Block models
     * Recipes
     * Block loot tables (not crops)
     *
     * TODO:
     *  Crop block models and loot tables
     *
     */
}
