package net.ldm.delightful_dishes.core.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.ldm.delightful_dishes.core.init.DelightfulDishes;

public class LootTableGenerator {
    public static class Blocks extends FabricBlockLootTableProvider {
        public Blocks(FabricDataOutput output) {
            super(output);
        }

        @Override
        public void generate() {
            addDrop(DelightfulDishes.GROUND_SALT_BLOCK, drops(DelightfulDishes.GROUND_SALT_BLOCK_ITEM));
            addDrop(DelightfulDishes.SIFTER, drops(DelightfulDishes.SIFTER_BLOCK_ITEM));
        }
    }
}
