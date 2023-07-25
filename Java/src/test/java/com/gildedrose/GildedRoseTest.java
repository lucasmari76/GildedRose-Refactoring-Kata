package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new DegradingItem("fixme", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("fixme", app.items[0].name);
    }

    @Test
    void agedBrieTest() {
        Item[] items = new Item[] {
            new AgedBrie("Aged Brie 0", 0, 0),
            new AgedBrie("Aged Brie 1", 1, 1),
            new AgedBrie("Aged Brie 2", 2, 2),
            new AgedBrie("Aged Brie 3", -1, 2),
            new AgedBrie("Aged Brie 4", 10, 50),
            new AgedBrie("Aged Brie 5", 10, 51),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie 0", app.items[0].name);

        assertEquals(-1, app.items[0].sellIn);
        assertEquals(2, app.items[0].quality);

        assertEquals(0, app.items[1].sellIn);
        assertEquals(2, app.items[1].quality);

        assertEquals(1, app.items[2].sellIn);
        assertEquals(3, app.items[2].quality);

        assertEquals(-2, app.items[3].sellIn);
        assertEquals(4, app.items[3].quality);

        assertEquals(9, app.items[4].sellIn);
        assertEquals(50, app.items[4].quality);

        assertEquals(9, app.items[5].sellIn);
        assertEquals(50, app.items[5].quality);
    }


    @Test
    void backstagePassesTest() {
        Item[] items = new Item[] {
            new BackstagePasses("BackStage Passes 0", 10, 0),
            new BackstagePasses("BackStage Passes 1", 5, 1),
            new BackstagePasses("BackStage Passes 2", -1, 2),
            new BackstagePasses("BackStage Passes 3", 15, 5),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("BackStage Passes 0", app.items[0].name);

        assertEquals(9, app.items[0].sellIn);
        assertEquals(2, app.items[0].quality);

        assertEquals(4, app.items[1].sellIn);
        assertEquals(4, app.items[1].quality);

        assertEquals(-2, app.items[2].sellIn);
        assertEquals(0, app.items[2].quality);

        assertEquals(14, app.items[3].sellIn);
        assertEquals(6, app.items[3].quality);

    }


    @Test
    void sulfurasTest() {
        Item[] items = new Item[] {
            new Sulfuras("Sulfuras 0", 0, 0),
            new Sulfuras("Sulfuras 1", 10, 0),
            new Sulfuras("Sulfuras 2", -1, -2),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Sulfuras 0", app.items[0].name);

        assertEquals(0, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);

        assertEquals(10, app.items[1].sellIn);
        assertEquals(80, app.items[1].quality);

        assertEquals(-1, app.items[2].sellIn);
        assertEquals(80, app.items[2].quality);

    }

    @Test
    void degradingItemTest() {
        Item[] items = new Item[] {
            new DegradingItem("Degrading Item 0", 0, 5),
            new DegradingItem("Degrading Item 1", 1, 5),
            new DegradingItem("Degrading Item 2", -1, 5),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Degrading Item 0", app.items[0].name);

        assertEquals(-1, app.items[0].sellIn);
        assertEquals(3, app.items[0].quality);

        assertEquals(0, app.items[1].sellIn);
        assertEquals(4, app.items[1].quality);

        assertEquals(-2, app.items[2].sellIn);
        assertEquals(3, app.items[2].quality);
    }

    @Test
    void conjuredItemTest() {
        Item[] items = new Item[] {
            new Conjured("Conjured Item 0", 0, 5),
            new Conjured("Conjured Item 1", 1, 15),
            new Conjured("Conjured Item 2", -1, 50),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Conjured Item 0", app.items[0].name);

        assertEquals(-1, app.items[0].sellIn);
        assertEquals(3, app.items[0].quality);

        assertEquals(0, app.items[1].sellIn);
        assertEquals(13, app.items[1].quality);

        assertEquals(-2, app.items[2].sellIn);
        assertEquals(48, app.items[2].quality);
    }

}
