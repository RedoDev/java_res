package com.gildedrose;

import java.util.List;

class GildedRose {
    private List<Item> items;

    public final String AGED_BRIE = "Aged Brie";
    public final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    public final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public final String CONJURED = "Conjured Mana Cake";
    public final int MAX_QUALITY = 50;

    public GildedRose(List<Item> items) {
        this.items = items;
    }

    public void updateQuality() {
        this.items.forEach(item-> {
            if (item.name.equals(AGED_BRIE)){
                this.handleAgedBrie(item);
            } else if (item.name.equals(BACKSTAGE)){
                this.handleBackStage(item);
            } else if (item.name.equals(CONJURED)){
                this.handleConjured(item);
            } else if (!item.name.equals(SULFURAS)){
                this.handleItem(item);
            }
        });
    }


    /**
     * Backstage passes increase in quality as the sellIn value decreases.
     * @param item
     */
    private void handleAgedBrie(Item item) {
        if (item.quality < MAX_QUALITY) {
            item.quality++;
        }

        item.sellIn--;
        if (item.sellIn < 0 && item.quality < MAX_QUALITY) {
            item.quality++;
        }
    }

    /**
     * Backstage passes increase in quality as the sellIn value decreases.
     * Quality increases by 2 when there are less than 11 days, and by 3 when there are less than 6 days.
     * However, quality drops to 0 after the concert.
     * @param item
     */
    private void handleBackStage(Item item) {
        if (item.quality < MAX_QUALITY) {
            item.quality++;
            if (item.sellIn < 11 && item.quality < MAX_QUALITY) {
               item.quality++;
            }

            if (item.sellIn < 6 && item.quality < MAX_QUALITY) {
                item.quality++;
            }
        }

        item.sellIn--;
        if (item.sellIn < 0) {
            item.quality = 0;
        }

    }

    /**
     * quality degrade twice as regular items when sellIn decrease.
     * @param item
     */
    private void handleConjured(Item item) {
        if (item.quality > 0) {
            item.quality = Math.max(item.quality - 2, 0);
        }

        item.sellIn--;
        if (item.sellIn < 0) {
            item.quality =  Math.max(item.quality - 2, 0);
        }
    }

    /**
     * reduce quality when sellIn decrease
     * @param item
     */
    private void handleItem(Item item) {
        item.quality = Math.max(item.quality - 1, 0);
        item.sellIn--;
        if (item.sellIn < 0) {
            item.quality = Math.max(item.quality - 1, 0);
        }

    }
}
