package net.ldm.delightful_dishes.core.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.ldm.delightful_dishes.core.LDMUtils;
import net.minecraft.item.ItemConvertible;

import static net.ldm.delightful_dishes.core.init.DelightfulDishes.*;

public class LangGenerator extends FabricLanguageProvider {
    protected LangGenerator( FabricDataOutput dataOutput ) {
        super(dataOutput, "en_us");
    }

    @Override
    public void generateTranslations( TranslationBuilder builder ) {
        builder.add(GROUND_SALT_BLOCK, "Block of Ground Salt");

        for (ItemConvertible entry: LANG_DATAGEN) {
            String[] words = LDMUtils.getItemID(entry).split("_");

            StringBuilder convertedString = new StringBuilder();
            for (String word : words) {
                String firstLetter = word.substring(0, 1);
                String remainingLetters = word.substring(1);
                convertedString.append(firstLetter.toUpperCase()).append(remainingLetters).append(" ");
            }

            builder.add(entry.asItem(), convertedString.toString().trim());
        }
    }
}
