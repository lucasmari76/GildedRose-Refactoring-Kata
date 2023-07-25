package com.gildedrose;

public class DegradingItem extends Item implements UpdatedItem{

    private int increaseFactor = 1;

    public DegradingItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }


    @Override
    public void updateSellIn() {

        sellIn -= 1;
        //Once the sell by date has passed, Quality degrades twice as fast
        if(sellIn < 0){
            increaseFactor = 2;
        }
    }

    @Override
    public void updateQuality() {
        quality -= increaseFactor;

        //The Quality of an item is never negative or more than 50
        if(quality < 0) quality = 0;
        if(quality > 50) quality = 50;
    }
}
