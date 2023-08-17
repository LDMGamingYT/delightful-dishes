package net.ldm.mo_food.core.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.util.Identifier;

import java.util.function.BiConsumer;

public class LootTableGenerator {
    public static class Blocks extends SimpleFabricLootTableProvider {

        public Blocks(FabricDataOutput output) {
            super(output, LootContextTypes.BLOCK);
        }

        @Override
        public void accept(BiConsumer<Identifier, LootTable.Builder> consumer) {
            //consumer.accept(LDMUtils.newId("garlic"), .drops(MoFood.GARLIC));
        }
    }
}
