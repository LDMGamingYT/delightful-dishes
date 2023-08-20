package net.ldm.delightful_dishes.block.crop;

import net.ldm.delightful_dishes.core.init.DelightfulDishes;

public class BasicCrops {
    public static class Garlic extends BasicCrop {
        public Garlic(Settings settings ) {
            super(settings, DelightfulDishes.GARLIC);
        }
    }

    public static class Lettuce extends BasicCrop {
        public Lettuce(Settings settings ) {
            super(settings, DelightfulDishes.LETTUCE);
        }
    }

    public static class SweetPotatoes extends BasicCrop {

        public SweetPotatoes(Settings settings ) {
            super(settings, DelightfulDishes.SWEET_POTATO);
        }
    }
}
