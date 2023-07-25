package com.gildedrose;

public class BackstagePasses extends Item implements UpdatedItem{

    private int increaseFactor = 1;

    public BackstagePasses(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateSellIn() {
        sellIn -= 1;
        //Quality drops to 0 after the concert
        if(sellIn <= 0){
            increaseFactor = -quality;
        }else if (sellIn <= 5){ //by 3 when there are 5 days or less
            increaseFactor = 3;
        }else if(sellIn <= 10) { //Quality increases by 2 when there are 10 days or less
            increaseFactor = 2;
        }

    }

    @Override
    public void updateQuality() {
        quality += increaseFactor;

        //The Quality of an item is never negative or more than 50
        if(quality < 0) quality = 0;
        if(quality > 50) quality = 50;

    }
}
