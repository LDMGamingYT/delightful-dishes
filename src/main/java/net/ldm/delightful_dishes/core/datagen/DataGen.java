package net.ldm.delightful_dishes.core.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.LoggerContext;

public class DataGen implements DataGeneratorEntrypoint {
    private static final Logger LOG = LoggerContext.getContext().getLogger("Delightful Dishes Data Generation");

    @Override
    public void onInitializeDataGenerator( FabricDataGenerator fabricDataGenerator ) {
        LOG.info("Preparing data generator packs...");
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
