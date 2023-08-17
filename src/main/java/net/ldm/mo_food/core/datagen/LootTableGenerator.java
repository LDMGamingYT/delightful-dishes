package net.ldm.mo_food.core.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.ldm.mo_food.core.init.MoFood;

public class LootTableGenerator {
    public static class Blocks extends FabricBlockLootTableProvider {
        public Blocks(FabricDataOutput output) {
            super(output);
        }

        @Override
        public void generate() {
            addDrop(MoFood.GROUND_SALT_BLOCK, drops(MoFood.GROUND_SALT_BLOCK_ITEM));
            addDrop(MoFood.SIFTER, drops(MoFood.SIFTER_BLOCK_ITEM));
        }
    }
}
