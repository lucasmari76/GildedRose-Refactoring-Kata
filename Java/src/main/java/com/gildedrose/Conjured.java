package com.gildedrose;

public class Conjured extends Item implements UpdatedItem{

    public Conjured(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }


    @Override
    public void updateSellIn() {
        sellIn -= 1;
    }

    @Override
    public void updateQuality() {
        quality -= 2;

        //The Quality of an item is never negative or more than 50
        if(quality < 0) quality = 0;
        if(quality > 50) quality = 50;
    }
}
