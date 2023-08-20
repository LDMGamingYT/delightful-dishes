package net.ldm.mo_food.block.crop;

import net.ldm.mo_food.core.init.MoFood;

public class BasicCrops {
    public static class Garlic extends BasicCrop {
        public Garlic(Settings settings ) {
            super(settings, MoFood.GARLIC);
        }
    }

    public static class Lettuce extends BasicCrop {
        public Lettuce(Settings settings ) {
            super(settings, MoFood.LETTUCE);
        }
    }

    public static class SweetPotatoes extends BasicCrop {

        public SweetPotatoes(Settings settings ) {
            super(settings, MoFood.SWEET_POTATO);
        }
    }
}
