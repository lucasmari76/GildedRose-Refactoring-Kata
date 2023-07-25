package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        for (Item item : items) {
            if (item instanceof DegradingItem) {
                ((DegradingItem) item).updateSellIn();
                ((DegradingItem) item).updateQuality();
            } else if (item instanceof AgedBrie) {
                ((AgedBrie) item).updateSellIn();
                ((AgedBrie) item).updateQuality();
            } else if (item instanceof Sulfuras) {
                ((Sulfuras) item).updateSellIn();
                ((Sulfuras) item).updateQuality();
            } else if (item instanceof BackstagePasses) {
                ((BackstagePasses) item).updateSellIn();
                ((BackstagePasses) item).updateQuality();
            } else if (item instanceof Conjured) { //New item type
                ((Conjured) item).updateSellIn();
                ((Conjured) item).updateQuality();
            }
        }
    }
}
