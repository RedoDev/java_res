package com.gildedrose;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    public void testRegularItemQualityDecrease() {
        Item item = new Item("Elixir of the Mongoose", 10, 35);
        GildedRose app = new GildedRose(Arrays.asList(item));
        app.updateQuality();
        assertEquals(34, item.quality);
    }

    @Test
    public void testRegularItemSellInDecrease() {
        Item item = new Item("Elixir of the Mongoose", 10, 35);
        GildedRose app = new GildedRose(Arrays.asList(item));
        app.updateQuality();
        assertEquals(9, item.sellIn);
    }

    @Test
    public void testRegularItemQualityDecreaseAfterSellIn() {
        Item item = new Item("Elixir of the Mongoose", 0, 20);
        GildedRose app = new GildedRose(Arrays.asList(item));
        app.updateQuality();
        assertEquals(18, item.quality);
    }

    @Test
    public void testAgedBrieQualityIncrease() {
        Item item = new Item("Aged Brie", 10, 20);
        GildedRose app = new GildedRose(Arrays.asList(item));
        app.updateQuality();
        assertEquals(21, item.quality);
    }

    @Test
    public void testAgedBrieQualityIncreaseAfterSellIn() {
        Item item = new Item("Aged Brie", 0, 20);
        GildedRose app = new GildedRose(Arrays.asList(item));
        app.updateQuality();
        assertEquals(22, item.quality);
    }

    @Test
    public void testBackstageQualityIncrease() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20);
        GildedRose app = new GildedRose(Arrays.asList(item));
        app.updateQuality();
        assertEquals(21, item.quality);
    }

    @Test
    public void testBackstageQualityIncreaseWithSellInLessThanEleven() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20);
        GildedRose app = new GildedRose(Arrays.asList(item));
        app.updateQuality();
        assertEquals(22, item.quality);
    }

    @Test
    public void testBackstageQualityIncreaseWithSellInLessThanSix() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20);
        GildedRose app = new GildedRose(Arrays.asList(item));
        app.updateQuality();
        assertEquals(23, item.quality);
    }

    @Test
    public void testBackstageQualityIncreaseWithSellInEqualsZero() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20);
        GildedRose app = new GildedRose(Arrays.asList(item));
        app.updateQuality();
        assertEquals(0, item.quality);
    }
    @Test
    public void testConjuredItemQualityDecrease() {
        Item item = new Item("Conjured Mana Cake", 10, 20);
        GildedRose app = new GildedRose(Arrays.asList(item));
        app.updateQuality();
        assertEquals(18, item.quality);
    }

    @Test
    public void testSulfurasItemQualityUnchanged() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 10, 80);
        GildedRose app = new GildedRose(Arrays.asList(item));
        app.updateQuality();
        assertEquals(80, item.quality);
    }

    @Test
    public void testSulfurasItemQualityUnchangedWhen() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", -2, 80);
        GildedRose app = new GildedRose(Arrays.asList(item));
        app.updateQuality();
        assertEquals(80, item.quality);
    }
}
