package net.ldm.mo_food.core.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.ldm.mo_food.core.init.MoFood;

import static net.ldm.mo_food.core.init.MoFood.*;

public class LangDataProvider extends FabricLanguageProvider {
    protected LangDataProvider( FabricDataOutput dataOutput ) {
        super(dataOutput, "en_us");
    }

    @Override
    public void generateTranslations( TranslationBuilder builder ) {
        builder.add(OMELET, "Omelet");
    }
}
