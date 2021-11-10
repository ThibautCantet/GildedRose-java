package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void sulfuras_selling_and_quality_never_decrease() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 10, 12) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(10, app.items[0].sellIn);
        assertEquals(12, app.items[0].quality);
    }

    @Test
    void bries_sellin_decrease_and_quality_increase() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 12) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(9, app.items[0].sellIn);
        assertEquals(13, app.items[0].quality);
    }

    @Test
    void bries_sellin_decrease_and_quality_increase_when_selling_less_than_0() {
        Item[] items = new Item[] { new Item("Aged Brie", -10, 12) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(-11, app.items[0].sellIn);
        assertEquals(14, app.items[0].quality);
    }

    @Test
    void backstage_sellin_decrease_and_quality_increase_by_2_when_selling_less_than_10() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 12) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(4, app.items[0].sellIn);
        assertEquals(15, app.items[0].quality);
    }

    @Test
    void backstage_sellin_decrease_and_quality_increase_by_1_when_selling_more_than_10() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 12) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(9, app.items[0].sellIn);
        assertEquals(14, app.items[0].quality);
    }

    @Test
    void backstage_sellin_decrease_and_quality_increase_by_1_when_selling_equals_0() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 12) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void quality_has_50_as_maximum() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 4, 50) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(3, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void quality_has_0_has_minimum() {
        Item[] items = new Item[] { new Item("generic", 15, 0) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(14, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void generic_item_sellin_decrease_and_quality_decrease_when_sellin_less_than_0() {
        Item[] items = new Item[] { new Item("generic", -1, 1) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(-2, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void generic_item_sellin_decrease_and_quality_decrease_when_sellin_more_than_0() {
        Item[] items = new Item[] { new Item("generic", 15, 2) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(14, app.items[0].sellIn);
        assertEquals(1, app.items[0].quality);
    }

    @Test
    void generic_item_sellin_decrease_and_quality_decrease_by_2_when_sellin_less_than_0() {
        Item[] items = new Item[] { new Item("generic", -5, 8) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(-6, app.items[0].sellIn);
        assertEquals(6, app.items[0].quality);
    }
}
