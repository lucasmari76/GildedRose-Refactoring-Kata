package com.gildedrose;

public class Sulfuras extends Item implements UpdatedItem{

    public Sulfuras(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }


    @Override
    public void updateSellIn() {
    //"Sulfuras", being a legendary item, never has to be sold or decreases in Quality
    }

    @Override
    public void updateQuality() {
        quality = 80;
    }
}
