package com.gildedrose;

import java.util.Arrays;
import java.util.function.Consumer;

class GildedRose {
    Item[] items;

    private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    private static final String AGED_BRIE = "Aged Brie";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        Arrays.stream(items).forEach(this::updateQualityAndSelling);
    }

    private void updateQualityAndSelling(Item item) {
        switch (item.name) {
            case SULFURAS:
                return;
            case AGED_BRIE:
                increaseQuality(item);
                handlePositiveSellin(item, this::increaseQuality);
                break;
            case BACKSTAGE:
                increaseBackstageQuality(item);
                handlePositiveSellin(item, i -> i.quality = 0);
                break;
            default:
                decreaseQuality(item);
                handlePositiveSellin(item, this::decreaseQuality);
        }
    }

    private void handlePositiveSellin(Item item, Consumer<Item> action) {
        item.sellIn--;
        if (item.sellIn < 0) {
            action.accept(item);
        }
    }

    private void increaseBackstageQuality(Item item) {
        increaseQuality(item);
        if (item.sellIn < 11) {
            increaseQuality(item);
        }
        if (item.sellIn < 6) {
            increaseQuality(item);
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
    }

}